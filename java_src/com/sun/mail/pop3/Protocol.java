package com.sun.mail.pop3;

import com.sun.mail.auth.Ntlm;
import com.sun.mail.util.ASCIIUtility;
import com.sun.mail.util.BASE64DecoderStream;
import com.sun.mail.util.BASE64EncoderStream;
import com.sun.mail.util.LineInputStream;
import com.sun.mail.util.MailLogger;
import com.sun.mail.util.PropUtil;
import com.sun.mail.util.SocketFetcher;
import com.sun.mail.util.TraceInputStream;
import com.sun.mail.util.TraceOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.logging.Level;
import javax.net.ssl.SSLSocket;
import kotlin.UByte;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class Protocol {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String CRLF = "\r\n";
    private static final int POP3_PORT = 110;
    private static final int SLOP = 128;
    private static char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private String apopChallenge;
    private String defaultAuthenticationMechanisms;
    private String host;
    private BufferedReader input;
    private String localHostName;
    private MailLogger logger;
    private boolean noauthdebug;
    private PrintWriter output;
    private boolean pipelining;
    private String prefix;
    private Properties props;
    private Socket socket;
    private TraceInputStream traceInput;
    private MailLogger traceLogger;
    private TraceOutputStream traceOutput;
    private boolean traceSuspended;
    private Map<String, String> capabilities = null;
    private Map<String, Authenticator> authenticators = new HashMap();

    private void batchCommandContinue(String str) {
    }

    private void batchCommandEnd() {
    }

    private void batchCommandStart(String str) {
    }

    private void multilineCommandEnd() {
    }

    private void multilineCommandStart(String str) {
    }

    private void simpleCommandEnd() {
    }

    private void simpleCommandStart(String str) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0121 A[LOOP:0: B:32:0x011f->B:33:0x0121, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public Protocol(java.lang.String r9, int r10, com.sun.mail.util.MailLogger r11, java.util.Properties r12, java.lang.String r13, boolean r14) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 348
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.pop3.Protocol.<init>(java.lang.String, int, com.sun.mail.util.MailLogger, java.util.Properties, java.lang.String, boolean):void");
    }

    private static IOException cleanupAndThrow(Socket socket, IOException iOException) {
        try {
            socket.close();
        } catch (Throwable th) {
            if (isRecoverable(th)) {
                iOException.addSuppressed(th);
            } else {
                th.addSuppressed(iOException);
                if (th instanceof Error) {
                    throw ((Error) th);
                }
                if (th instanceof RuntimeException) {
                    throw th;
                }
                throw new RuntimeException("unexpected exception", th);
            }
        }
        return iOException;
    }

    private static boolean isRecoverable(Throwable th) {
        return (th instanceof Exception) || (th instanceof LinkageError);
    }

    private final synchronized boolean getBoolProp(Properties properties, String str) {
        boolean booleanProperty;
        booleanProperty = PropUtil.getBooleanProperty(properties, str, false);
        if (this.logger.isLoggable(Level.CONFIG)) {
            MailLogger mailLogger = this.logger;
            mailLogger.config(str + ": " + booleanProperty);
        }
        return booleanProperty;
    }

    private void initStreams() throws IOException {
        boolean booleanProperty = PropUtil.getBooleanProperty(this.props, "mail.debug.quote", false);
        TraceInputStream traceInputStream = new TraceInputStream(this.socket.getInputStream(), this.traceLogger);
        this.traceInput = traceInputStream;
        traceInputStream.setQuote(booleanProperty);
        TraceOutputStream traceOutputStream = new TraceOutputStream(this.socket.getOutputStream(), this.traceLogger);
        this.traceOutput = traceOutputStream;
        traceOutputStream.setQuote(booleanProperty);
        this.input = new BufferedReader(new InputStreamReader(this.traceInput, "iso-8859-1"));
        this.output = new PrintWriter(new BufferedWriter(new OutputStreamWriter(this.traceOutput, "iso-8859-1")));
    }

    protected void finalize() throws Throwable {
        try {
            if (this.socket != null) {
                quit();
            }
        } finally {
            super.finalize();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void setCapabilities(InputStream inputStream) {
        BufferedReader bufferedReader = null;
        if (inputStream == null) {
            this.capabilities = null;
        } else {
            this.capabilities = new HashMap(10);
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "us-ascii"));
            } catch (UnsupportedEncodingException unused) {
            }
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        int indexOf = readLine.indexOf(32);
                        this.capabilities.put((indexOf > 0 ? readLine.substring(0, indexOf) : readLine).toUpperCase(Locale.ENGLISH), readLine);
                    }
                } catch (IOException unused2) {
                } catch (Throwable th) {
                    try {
                        inputStream.close();
                    } catch (IOException unused3) {
                    }
                    throw th;
                }
                try {
                    break;
                } catch (IOException unused4) {
                    return;
                }
            }
            inputStream.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean hasCapability(String str) {
        boolean z;
        if (this.capabilities != null) {
            z = this.capabilities.containsKey(str.toUpperCase(Locale.ENGLISH));
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Map<String, String> getCapabilities() {
        return this.capabilities;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean supportsMechanism(String str) {
        return this.authenticators.containsKey(str.toUpperCase(Locale.ENGLISH));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getDefaultMechanisms() {
        return this.defaultAuthenticationMechanisms;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isMechanismEnabled(String str) {
        Authenticator authenticator = this.authenticators.get(str.toUpperCase(Locale.ENGLISH));
        return authenticator != null && authenticator.enabled();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized String authenticate(String str, String str2, String str3, String str4, String str5) {
        Authenticator authenticator = this.authenticators.get(str.toUpperCase(Locale.ENGLISH));
        if (authenticator == null) {
            return "No such authentication mechanism: " + str;
        }
        try {
            if (authenticator.authenticate(str2, str3, str4, str5)) {
                return null;
            }
            return "login failed";
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean supportsAuthentication(String str) {
        if (str.equals("LOGIN")) {
            return true;
        }
        if (this.capabilities == null) {
            return false;
        }
        String str2 = this.capabilities.get("SASL");
        if (str2 == null) {
            return false;
        }
        StringTokenizer stringTokenizer = new StringTokenizer(str2);
        while (stringTokenizer.hasMoreTokens()) {
            if (stringTokenizer.nextToken().equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    synchronized String login(String str, String str2) throws IOException {
        Response simpleCommand;
        boolean z = this.pipelining && (this.socket instanceof SSLSocket);
        if (this.noauthdebug && isTracing()) {
            this.logger.fine("authentication command trace suppressed");
            suspendTracing();
        }
        String digest = this.apopChallenge != null ? getDigest(str2) : null;
        if (this.apopChallenge != null && digest != null) {
            simpleCommand = simpleCommand("APOP " + str + " " + digest);
        } else if (z) {
            String str3 = "USER " + str;
            batchCommandStart(str3);
            issueCommand(str3);
            String str4 = "PASS " + str2;
            batchCommandContinue(str4);
            issueCommand(str4);
            Response readResponse = readResponse();
            if (!readResponse.ok) {
                String str5 = readResponse.data != null ? readResponse.data : "USER command failed";
                readResponse();
                batchCommandEnd();
                resumeTracing();
                return str5;
            }
            simpleCommand = readResponse();
            batchCommandEnd();
        } else {
            Response simpleCommand2 = simpleCommand("USER " + str);
            if (!simpleCommand2.ok) {
                String str6 = simpleCommand2.data != null ? simpleCommand2.data : "USER command failed";
                resumeTracing();
                return str6;
            }
            simpleCommand = simpleCommand("PASS " + str2);
        }
        if (this.noauthdebug && isTracing()) {
            this.logger.log(Level.FINE, "authentication command {0}", simpleCommand.ok ? "succeeded" : "failed");
        }
        if (simpleCommand.ok) {
            resumeTracing();
            return null;
        }
        String str7 = simpleCommand.data != null ? simpleCommand.data : "login failed";
        resumeTracing();
        return str7;
    }

    private String getDigest(String str) {
        try {
            return toHex(MessageDigest.getInstance("MD5").digest((this.apopChallenge + str).getBytes("iso-8859-1")));
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public abstract class Authenticator {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final boolean enabled;
        private final String mech;
        protected Response resp;

        abstract void doAuth(String str, String str2, String str3, String str4) throws IOException;

        String getInitialResponse(String str, String str2, String str3, String str4) throws IOException {
            return null;
        }

        Authenticator(Protocol protocol, String str) {
            this(str, true);
        }

        Authenticator(String str, boolean z) {
            this.mech = str.toUpperCase(Locale.ENGLISH);
            this.enabled = z;
        }

        String getMechanism() {
            return this.mech;
        }

        boolean enabled() {
            return this.enabled;
        }

        boolean authenticate(String str, String str2, String str3, String str4) throws IOException {
            try {
                try {
                    String initialResponse = getInitialResponse(str, str2, str3, str4);
                    if (Protocol.this.noauthdebug && Protocol.this.isTracing()) {
                        MailLogger mailLogger = Protocol.this.logger;
                        mailLogger.fine("AUTH " + this.mech + " command trace suppressed");
                        Protocol.this.suspendTracing();
                    }
                    if (initialResponse != null) {
                        Protocol protocol = Protocol.this;
                        StringBuilder sb = new StringBuilder();
                        sb.append("AUTH ");
                        sb.append(this.mech);
                        sb.append(" ");
                        if (initialResponse.length() == 0) {
                            initialResponse = "=";
                        }
                        sb.append(initialResponse);
                        this.resp = protocol.simpleCommand(sb.toString());
                    } else {
                        Protocol protocol2 = Protocol.this;
                        this.resp = protocol2.simpleCommand("AUTH " + this.mech);
                    }
                    if (this.resp.cont) {
                        doAuth(str, str2, str3, str4);
                    }
                    if (Protocol.this.noauthdebug && Protocol.this.isTracing()) {
                        MailLogger mailLogger2 = Protocol.this.logger;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("AUTH ");
                        sb2.append(this.mech);
                        sb2.append(" ");
                        sb2.append(this.resp.ok ? "succeeded" : "failed");
                        mailLogger2.fine(sb2.toString());
                    }
                    Protocol.this.resumeTracing();
                    if (this.resp.ok) {
                        return true;
                    }
                    Protocol.this.close();
                    throw new EOFException(this.resp.data != null ? this.resp.data : "authentication failed");
                } catch (IOException e) {
                    MailLogger mailLogger3 = Protocol.this.logger;
                    Level level = Level.FINE;
                    mailLogger3.log(level, "AUTH " + this.mech + " failed", (Throwable) e);
                    if (Protocol.this.noauthdebug && Protocol.this.isTracing()) {
                        MailLogger mailLogger4 = Protocol.this.logger;
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("AUTH ");
                        sb3.append(this.mech);
                        sb3.append(" ");
                        sb3.append(this.resp.ok ? "succeeded" : "failed");
                        mailLogger4.fine(sb3.toString());
                    }
                    Protocol.this.resumeTracing();
                    if (this.resp.ok) {
                        return true;
                    }
                    Protocol.this.close();
                    throw new EOFException(this.resp.data != null ? this.resp.data : "authentication failed");
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    private class LoginAuthenticator extends Authenticator {
        LoginAuthenticator() {
            super(Protocol.this, "LOGIN");
        }

        @Override // com.sun.mail.pop3.Protocol.Authenticator
        boolean authenticate(String str, String str2, String str3, String str4) throws IOException {
            String login = Protocol.this.login(str3, str4);
            if (login == null) {
                return true;
            }
            throw new EOFException(login);
        }

        @Override // com.sun.mail.pop3.Protocol.Authenticator
        void doAuth(String str, String str2, String str3, String str4) throws IOException {
            throw new EOFException("LOGIN asked for more");
        }
    }

    /* loaded from: classes2.dex */
    private class PlainAuthenticator extends Authenticator {
        PlainAuthenticator() {
            super(Protocol.this, "PLAIN");
        }

        @Override // com.sun.mail.pop3.Protocol.Authenticator
        String getInitialResponse(String str, String str2, String str3, String str4) throws IOException {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            BASE64EncoderStream bASE64EncoderStream = new BASE64EncoderStream(byteArrayOutputStream, Integer.MAX_VALUE);
            if (str2 != null) {
                bASE64EncoderStream.write(str2.getBytes(StandardCharsets.UTF_8));
            }
            bASE64EncoderStream.write(0);
            bASE64EncoderStream.write(str3.getBytes(StandardCharsets.UTF_8));
            bASE64EncoderStream.write(0);
            bASE64EncoderStream.write(str4.getBytes(StandardCharsets.UTF_8));
            bASE64EncoderStream.flush();
            return ASCIIUtility.toString(byteArrayOutputStream.toByteArray());
        }

        @Override // com.sun.mail.pop3.Protocol.Authenticator
        void doAuth(String str, String str2, String str3, String str4) throws IOException {
            throw new EOFException("PLAIN asked for more");
        }
    }

    /* loaded from: classes2.dex */
    private class NtlmAuthenticator extends Authenticator {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private Ntlm ntlm;

        NtlmAuthenticator() {
            super(Protocol.this, "NTLM");
        }

        @Override // com.sun.mail.pop3.Protocol.Authenticator
        String getInitialResponse(String str, String str2, String str3, String str4) throws IOException {
            Properties properties = Protocol.this.props;
            this.ntlm = new Ntlm(properties.getProperty(Protocol.this.prefix + ".auth.ntlm.domain"), Protocol.this.getLocalHost(), str3, str4, Protocol.this.logger);
            Properties properties2 = Protocol.this.props;
            int intProperty = PropUtil.getIntProperty(properties2, Protocol.this.prefix + ".auth.ntlm.flags", 0);
            Properties properties3 = Protocol.this.props;
            return this.ntlm.generateType1Msg(intProperty, PropUtil.getBooleanProperty(properties3, Protocol.this.prefix + ".auth.ntlm.v2", true));
        }

        @Override // com.sun.mail.pop3.Protocol.Authenticator
        void doAuth(String str, String str2, String str3, String str4) throws IOException {
            this.resp = Protocol.this.simpleCommand(this.ntlm.generateType3Msg(this.resp.data.substring(4).trim()));
        }
    }

    /* loaded from: classes2.dex */
    private class OAuth2Authenticator extends Authenticator {
        OAuth2Authenticator() {
            super("XOAUTH2", false);
        }

        @Override // com.sun.mail.pop3.Protocol.Authenticator
        String getInitialResponse(String str, String str2, String str3, String str4) throws IOException {
            return ASCIIUtility.toString(BASE64EncoderStream.encode(("user=" + str3 + "\u0001auth=Bearer " + str4 + "\u0001\u0001").getBytes(StandardCharsets.UTF_8)));
        }

        @Override // com.sun.mail.pop3.Protocol.Authenticator
        void doAuth(String str, String str2, String str3, String str4) throws IOException {
            String str5 = this.resp.data != null ? new String(BASE64DecoderStream.decode(this.resp.data.getBytes(StandardCharsets.UTF_8)), StandardCharsets.UTF_8) : "";
            throw new EOFException("OAUTH2 authentication failed: " + str5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized String getLocalHost() {
        try {
            if (this.localHostName == null || this.localHostName.length() == 0) {
                InetAddress localHost = InetAddress.getLocalHost();
                String canonicalHostName = localHost.getCanonicalHostName();
                this.localHostName = canonicalHostName;
                if (canonicalHostName == null) {
                    this.localHostName = "[" + localHost.getHostAddress() + "]";
                }
            }
        } catch (UnknownHostException unused) {
        }
        if ((this.localHostName == null || this.localHostName.length() <= 0) && this.socket != null && this.socket.isBound()) {
            InetAddress localAddress = this.socket.getLocalAddress();
            String canonicalHostName2 = localAddress.getCanonicalHostName();
            this.localHostName = canonicalHostName2;
            if (canonicalHostName2 == null) {
                this.localHostName = "[" + localAddress.getHostAddress() + "]";
            }
        }
        return this.localHostName;
    }

    private static String toHex(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        int i = 0;
        for (byte b : bArr) {
            int i2 = b & UByte.MAX_VALUE;
            int i3 = i + 1;
            char[] cArr2 = digits;
            cArr[i] = cArr2[i2 >> 4];
            i = i3 + 1;
            cArr[i3] = cArr2[i2 & 15];
        }
        return new String(cArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean quit() throws IOException {
        boolean z;
        z = simpleCommand("QUIT").ok;
        close();
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void close() {
        try {
            if (this.socket != null) {
                this.socket.close();
            }
        } catch (IOException unused) {
        } catch (Throwable th) {
            this.socket = null;
            this.input = null;
            this.output = null;
            throw th;
        }
        this.socket = null;
        this.input = null;
        this.output = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Status stat() throws IOException {
        Status status;
        Response simpleCommand = simpleCommand("STAT");
        status = new Status();
        if (!simpleCommand.ok) {
            throw new IOException("STAT command failed: " + simpleCommand.data);
        } else if (simpleCommand.data != null) {
            try {
                StringTokenizer stringTokenizer = new StringTokenizer(simpleCommand.data);
                status.total = Integer.parseInt(stringTokenizer.nextToken());
                status.size = Integer.parseInt(stringTokenizer.nextToken());
            } catch (RuntimeException unused) {
            }
        }
        return status;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized int list(int i) throws IOException {
        int i2;
        Response simpleCommand = simpleCommand("LIST " + i);
        i2 = -1;
        if (simpleCommand.ok && simpleCommand.data != null) {
            try {
                StringTokenizer stringTokenizer = new StringTokenizer(simpleCommand.data);
                stringTokenizer.nextToken();
                i2 = Integer.parseInt(stringTokenizer.nextToken());
            } catch (RuntimeException unused) {
            }
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized InputStream list() throws IOException {
        return multilineCommand("LIST", 128).bytes;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0012 A[Catch: all -> 0x000a, TryCatch #2 {all -> 0x000a, blocks: (B:5:0x0004, B:13:0x0012, B:15:0x0048, B:17:0x004c, B:21:0x0063, B:23:0x006d, B:27:0x0088, B:29:0x0090, B:30:0x0098, B:52:0x0115, B:55:0x011b, B:57:0x0125, B:58:0x0141, B:31:0x009d, B:33:0x00bc, B:38:0x00c4, B:40:0x00c8, B:42:0x00df, B:46:0x00e8, B:48:0x00f2, B:51:0x010c), top: B:70:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x009d A[Catch: all -> 0x000a, TryCatch #2 {all -> 0x000a, blocks: (B:5:0x0004, B:13:0x0012, B:15:0x0048, B:17:0x004c, B:21:0x0063, B:23:0x006d, B:27:0x0088, B:29:0x0090, B:30:0x0098, B:52:0x0115, B:55:0x011b, B:57:0x0125, B:58:0x0141, B:31:0x009d, B:33:0x00bc, B:38:0x00c4, B:40:0x00c8, B:42:0x00df, B:46:0x00e8, B:48:0x00f2, B:51:0x010c), top: B:70:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized java.io.InputStream retr(int r6, int r7) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 327
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.pop3.Protocol.retr(int, int):java.io.InputStream");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0042, code lost:
        r2 = r5.input.read();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized boolean retr(int r6, java.io.OutputStream r7) throws java.io.IOException {
        /*
            r5 = this;
            monitor-enter(r5)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L8e
            r0.<init>()     // Catch: java.lang.Throwable -> L8e
            java.lang.String r1 = "RETR "
            r0.append(r1)     // Catch: java.lang.Throwable -> L8e
            r0.append(r6)     // Catch: java.lang.Throwable -> L8e
            java.lang.String r6 = r0.toString()     // Catch: java.lang.Throwable -> L8e
            r5.multilineCommandStart(r6)     // Catch: java.lang.Throwable -> L8e
            r5.issueCommand(r6)     // Catch: java.lang.Throwable -> L8e
            com.sun.mail.pop3.Response r6 = r5.readResponse()     // Catch: java.lang.Throwable -> L8e
            boolean r6 = r6.ok     // Catch: java.lang.Throwable -> L8e
            if (r6 != 0) goto L26
            r5.multilineCommandEnd()     // Catch: java.lang.Throwable -> L8e
            r6 = 0
            monitor-exit(r5)
            return r6
        L26:
            r6 = 0
            r0 = 10
            r1 = r0
        L2a:
            java.io.BufferedReader r2 = r5.input     // Catch: java.io.InterruptedIOException -> L87 java.lang.Throwable -> L8e
            int r2 = r2.read()     // Catch: java.io.InterruptedIOException -> L87 java.lang.Throwable -> L8e
            if (r2 < 0) goto L66
            if (r1 != r0) goto L49
            r1 = 46
            if (r2 != r1) goto L49
            java.io.BufferedReader r1 = r5.input     // Catch: java.io.InterruptedIOException -> L87 java.lang.Throwable -> L8e
            int r1 = r1.read()     // Catch: java.io.InterruptedIOException -> L87 java.lang.Throwable -> L8e
            r2 = 13
            if (r1 != r2) goto L4a
            java.io.BufferedReader r7 = r5.input     // Catch: java.io.InterruptedIOException -> L87 java.lang.Throwable -> L8e
            int r2 = r7.read()     // Catch: java.io.InterruptedIOException -> L87 java.lang.Throwable -> L8e
            goto L66
        L49:
            r1 = r2
        L4a:
            if (r6 != 0) goto L2a
            r7.write(r1)     // Catch: java.lang.RuntimeException -> L50 java.io.IOException -> L5b java.lang.Throwable -> L8e
            goto L2a
        L50:
            r6 = move-exception
            com.sun.mail.util.MailLogger r2 = r5.logger     // Catch: java.io.InterruptedIOException -> L87 java.lang.Throwable -> L8e
            java.util.logging.Level r3 = java.util.logging.Level.FINE     // Catch: java.io.InterruptedIOException -> L87 java.lang.Throwable -> L8e
            java.lang.String r4 = "exception while streaming"
            r2.log(r3, r4, r6)     // Catch: java.io.InterruptedIOException -> L87 java.lang.Throwable -> L8e
            goto L2a
        L5b:
            r6 = move-exception
            com.sun.mail.util.MailLogger r2 = r5.logger     // Catch: java.io.InterruptedIOException -> L87 java.lang.Throwable -> L8e
            java.util.logging.Level r3 = java.util.logging.Level.FINE     // Catch: java.io.InterruptedIOException -> L87 java.lang.Throwable -> L8e
            java.lang.String r4 = "exception while streaming"
            r2.log(r3, r4, r6)     // Catch: java.io.InterruptedIOException -> L87 java.lang.Throwable -> L8e
            goto L2a
        L66:
            if (r2 < 0) goto L7f
            if (r6 == 0) goto L79
            boolean r7 = r6 instanceof java.io.IOException     // Catch: java.lang.Throwable -> L8e
            if (r7 != 0) goto L76
            boolean r7 = r6 instanceof java.lang.RuntimeException     // Catch: java.lang.Throwable -> L8e
            if (r7 != 0) goto L73
            goto L79
        L73:
            java.lang.RuntimeException r6 = (java.lang.RuntimeException) r6     // Catch: java.lang.Throwable -> L8e
            throw r6     // Catch: java.lang.Throwable -> L8e
        L76:
            java.io.IOException r6 = (java.io.IOException) r6     // Catch: java.lang.Throwable -> L8e
            throw r6     // Catch: java.lang.Throwable -> L8e
        L79:
            r5.multilineCommandEnd()     // Catch: java.lang.Throwable -> L8e
            r6 = 1
            monitor-exit(r5)
            return r6
        L7f:
            java.io.EOFException r6 = new java.io.EOFException     // Catch: java.lang.Throwable -> L8e
            java.lang.String r7 = "EOF on socket"
            r6.<init>(r7)     // Catch: java.lang.Throwable -> L8e
            throw r6     // Catch: java.lang.Throwable -> L8e
        L87:
            r6 = move-exception
            java.net.Socket r7 = r5.socket     // Catch: java.io.IOException -> L8d java.lang.Throwable -> L8e
            r7.close()     // Catch: java.io.IOException -> L8d java.lang.Throwable -> L8e
        L8d:
            throw r6     // Catch: java.lang.Throwable -> L8e
        L8e:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.pop3.Protocol.retr(int, java.io.OutputStream):boolean");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized InputStream top(int i, int i2) throws IOException {
        return multilineCommand("TOP " + i + " " + i2, 0).bytes;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean dele(int i) throws IOException {
        return simpleCommand("DELE " + i).ok;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized String uidl(int i) throws IOException {
        Response simpleCommand = simpleCommand("UIDL " + i);
        if (simpleCommand.ok) {
            int indexOf = simpleCommand.data.indexOf(32);
            if (indexOf > 0) {
                return simpleCommand.data.substring(indexOf + 1);
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean uidl(String[] strArr) throws IOException {
        int parseInt;
        Response multilineCommand = multilineCommand("UIDL", strArr.length * 15);
        if (multilineCommand.ok) {
            LineInputStream lineInputStream = new LineInputStream(multilineCommand.bytes);
            while (true) {
                String readLine = lineInputStream.readLine();
                if (readLine != null) {
                    int indexOf = readLine.indexOf(32);
                    if (indexOf >= 1 && indexOf < readLine.length() && (parseInt = Integer.parseInt(readLine.substring(0, indexOf))) > 0 && parseInt <= strArr.length) {
                        strArr[parseInt - 1] = readLine.substring(indexOf + 1);
                    }
                } else {
                    try {
                        break;
                    } catch (IOException unused) {
                    }
                }
            }
            multilineCommand.bytes.close();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean noop() throws IOException {
        return simpleCommand("NOOP").ok;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean rset() throws IOException {
        return simpleCommand("RSET").ok;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean stls() throws IOException {
        if (this.socket instanceof SSLSocket) {
            return true;
        }
        Response simpleCommand = simpleCommand("STLS");
        if (simpleCommand.ok) {
            try {
                this.socket = SocketFetcher.startTLS(this.socket, this.host, this.props, this.prefix);
                initStreams();
            } catch (IOException e) {
                this.socket.close();
                this.socket = null;
                this.input = null;
                this.output = null;
                IOException iOException = new IOException("Could not convert socket to TLS");
                iOException.initCause(e);
                throw iOException;
            }
        }
        return simpleCommand.ok;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean isSSL() {
        return this.socket instanceof SSLSocket;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized InputStream capa() throws IOException {
        Response multilineCommand = multilineCommand("CAPA", 128);
        if (multilineCommand.ok) {
            return multilineCommand.bytes;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Response simpleCommand(String str) throws IOException {
        simpleCommandStart(str);
        issueCommand(str);
        Response readResponse = readResponse();
        simpleCommandEnd();
        return readResponse;
    }

    private void issueCommand(String str) throws IOException {
        if (this.socket == null) {
            throw new IOException("Folder is closed");
        }
        if (str != null) {
            this.output.print(str + CRLF);
            this.output.flush();
        }
    }

    private Response readResponse() throws IOException {
        try {
            String readLine = this.input.readLine();
            if (readLine == null) {
                this.traceLogger.finest("<EOF>");
                throw new EOFException("EOF on socket");
            }
            Response response = new Response();
            if (readLine.startsWith("+OK")) {
                response.ok = true;
            } else if (readLine.startsWith("+ ")) {
                response.ok = true;
                response.cont = true;
            } else if (readLine.startsWith("-ERR")) {
                response.ok = false;
            } else {
                throw new IOException("Unexpected response: " + readLine);
            }
            int indexOf = readLine.indexOf(32);
            if (indexOf >= 0) {
                response.data = readLine.substring(indexOf + 1);
            }
            return response;
        } catch (InterruptedIOException e) {
            try {
                this.socket.close();
            } catch (IOException unused) {
            }
            throw new EOFException(e.getMessage());
        } catch (SocketException e2) {
            try {
                this.socket.close();
            } catch (IOException unused2) {
            }
            throw new EOFException(e2.getMessage());
        }
    }

    private Response multilineCommand(String str, int i) throws IOException {
        multilineCommandStart(str);
        issueCommand(str);
        Response readResponse = readResponse();
        if (!readResponse.ok) {
            multilineCommandEnd();
            return readResponse;
        }
        readResponse.bytes = readMultilineResponse(i);
        multilineCommandEnd();
        return readResponse;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0020, code lost:
        r2 = r3.input.read();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.io.InputStream readMultilineResponse(int r4) throws java.io.IOException {
        /*
            r3 = this;
            com.sun.mail.util.SharedByteArrayOutputStream r0 = new com.sun.mail.util.SharedByteArrayOutputStream
            r0.<init>(r4)
            r4 = 10
            r1 = r4
        L8:
            java.io.BufferedReader r2 = r3.input     // Catch: java.io.InterruptedIOException -> L3b
            int r2 = r2.read()     // Catch: java.io.InterruptedIOException -> L3b
            if (r2 < 0) goto L2c
            if (r1 != r4) goto L27
            r1 = 46
            if (r2 != r1) goto L27
            java.io.BufferedReader r1 = r3.input     // Catch: java.io.InterruptedIOException -> L3b
            int r1 = r1.read()     // Catch: java.io.InterruptedIOException -> L3b
            r2 = 13
            if (r1 != r2) goto L28
            java.io.BufferedReader r4 = r3.input     // Catch: java.io.InterruptedIOException -> L3b
            int r2 = r4.read()     // Catch: java.io.InterruptedIOException -> L3b
            goto L2c
        L27:
            r1 = r2
        L28:
            r0.write(r1)     // Catch: java.io.InterruptedIOException -> L3b
            goto L8
        L2c:
            if (r2 < 0) goto L33
            java.io.InputStream r4 = r0.toStream()
            return r4
        L33:
            java.io.EOFException r4 = new java.io.EOFException
            java.lang.String r0 = "EOF on socket"
            r4.<init>(r0)
            throw r4
        L3b:
            r4 = move-exception
            java.net.Socket r0 = r3.socket     // Catch: java.io.IOException -> L41
            r0.close()     // Catch: java.io.IOException -> L41
        L41:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.pop3.Protocol.readMultilineResponse(int):java.io.InputStream");
    }

    protected boolean isTracing() {
        return this.traceLogger.isLoggable(Level.FINEST);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void suspendTracing() {
        if (this.traceLogger.isLoggable(Level.FINEST)) {
            this.traceInput.setTrace(false);
            this.traceOutput.setTrace(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resumeTracing() {
        if (this.traceLogger.isLoggable(Level.FINEST)) {
            this.traceInput.setTrace(true);
            this.traceOutput.setTrace(true);
        }
    }
}
