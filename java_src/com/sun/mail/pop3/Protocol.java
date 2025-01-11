package com.sun.mail.pop3;

import com.sun.mail.auth.Ntlm;
import com.sun.mail.util.ASCIIUtility;
import com.sun.mail.util.BASE64DecoderStream;
import com.sun.mail.util.BASE64EncoderStream;
import com.sun.mail.util.LineInputStream;
import com.sun.mail.util.MailLogger;
import com.sun.mail.util.PropUtil;
import com.sun.mail.util.SharedByteArrayOutputStream;
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
import java.io.OutputStream;
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

/* loaded from: classes2.dex */
class Protocol {
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

    /* JADX WARN: Removed duplicated region for block: B:30:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0121 A[LOOP:0: B:32:0x011f->B:33:0x0121, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    Protocol(String str, int i, MailLogger mailLogger, Properties properties, String str2, boolean z) throws IOException {
        boolean z2;
        this.apopChallenge = null;
        this.noauthdebug = true;
        this.host = str;
        this.props = properties;
        this.prefix = str2;
        this.logger = mailLogger;
        this.traceLogger = mailLogger.getSubLogger("protocol", null);
        this.noauthdebug = !PropUtil.getBooleanProperty(properties, "mail.debug.auth", false);
        boolean boolProp = getBoolProp(properties, str2 + ".apop.enable");
        boolean boolProp2 = getBoolProp(properties, str2 + ".disablecapa");
        i = i == -1 ? 110 : i;
        try {
            if (mailLogger.isLoggable(Level.FINE)) {
                mailLogger.fine("connecting to host \"" + str + "\", port " + i + ", isSSL " + z);
            }
            this.socket = SocketFetcher.getSocket(str, i, properties, str2, z);
            initStreams();
            Response simpleCommand = simpleCommand(null);
            if (!simpleCommand.ok) {
                throw cleanupAndThrow(this.socket, new IOException("Connect failed"));
            }
            if (boolProp && simpleCommand.data != null) {
                int indexOf = simpleCommand.data.indexOf(60);
                int indexOf2 = simpleCommand.data.indexOf(62, indexOf);
                if (indexOf != -1 && indexOf2 != -1) {
                    this.apopChallenge = simpleCommand.data.substring(indexOf, indexOf2 + 1);
                }
                mailLogger.log(Level.FINE, "APOP challenge: {0}", this.apopChallenge);
            }
            if (!boolProp2) {
                setCapabilities(capa());
            }
            if (!hasCapability("PIPELINING")) {
                if (!PropUtil.getBooleanProperty(properties, str2 + ".pipelining", false)) {
                    z2 = false;
                    this.pipelining = z2;
                    if (z2) {
                        mailLogger.config("PIPELINING enabled");
                    }
                    Authenticator[] authenticatorArr = {new LoginAuthenticator(), new PlainAuthenticator(), new NtlmAuthenticator(), new OAuth2Authenticator()};
                    StringBuilder sb = new StringBuilder();
                    for (int i2 = 0; i2 < 4; i2++) {
                        this.authenticators.put(authenticatorArr[i2].getMechanism(), authenticatorArr[i2]);
                        sb.append(authenticatorArr[i2].getMechanism());
                        sb.append(' ');
                    }
                    this.defaultAuthenticationMechanisms = sb.toString();
                }
            }
            z2 = true;
            this.pipelining = z2;
            if (z2) {
            }
            Authenticator[] authenticatorArr2 = {new LoginAuthenticator(), new PlainAuthenticator(), new NtlmAuthenticator(), new OAuth2Authenticator()};
            StringBuilder sb2 = new StringBuilder();
            while (i2 < 4) {
            }
            this.defaultAuthenticationMechanisms = sb2.toString();
        } catch (IOException e) {
            throw cleanupAndThrow(this.socket, e);
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 3, expect 1 */
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

    synchronized void setCapabilities(InputStream inputStream) {
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

    synchronized boolean hasCapability(String str) {
        boolean z;
        if (this.capabilities != null) {
            z = this.capabilities.containsKey(str.toUpperCase(Locale.ENGLISH));
        }
        return z;
    }

    synchronized Map<String, String> getCapabilities() {
        return this.capabilities;
    }

    boolean supportsMechanism(String str) {
        return this.authenticators.containsKey(str.toUpperCase(Locale.ENGLISH));
    }

    String getDefaultMechanisms() {
        return this.defaultAuthenticationMechanisms;
    }

    boolean isMechanismEnabled(String str) {
        Authenticator authenticator = this.authenticators.get(str.toUpperCase(Locale.ENGLISH));
        return authenticator != null && authenticator.enabled();
    }

    synchronized String authenticate(String str, String str2, String str3, String str4, String str5) {
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

    synchronized boolean supportsAuthentication(String str) {
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [391=5] */
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

    /* loaded from: classes2.dex */
    private abstract class Authenticator {
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

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [481=4, 482=4, 483=4, 496=4, 478=4, 479=4] */
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
                }
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

    synchronized boolean quit() throws IOException {
        boolean z;
        z = simpleCommand("QUIT").ok;
        close();
        return z;
    }

    void close() {
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

    synchronized Status stat() throws IOException {
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

    synchronized int list(int i) throws IOException {
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

    synchronized InputStream list() throws IOException {
        return multilineCommand("LIST", 128).bytes;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0012 A[Catch: all -> 0x000a, TryCatch #2 {all -> 0x000a, blocks: (B:5:0x0004, B:13:0x0012, B:15:0x0048, B:17:0x004c, B:21:0x0063, B:23:0x006d, B:27:0x0088, B:29:0x0090, B:30:0x0098, B:52:0x0115, B:55:0x011b, B:57:0x0125, B:58:0x0141, B:31:0x009d, B:33:0x00bc, B:38:0x00c4, B:40:0x00c8, B:42:0x00df, B:46:0x00e8, B:48:0x00f2, B:51:0x010c), top: B:70:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x009d A[Catch: all -> 0x000a, TryCatch #2 {all -> 0x000a, blocks: (B:5:0x0004, B:13:0x0012, B:15:0x0048, B:17:0x004c, B:21:0x0063, B:23:0x006d, B:27:0x0088, B:29:0x0090, B:30:0x0098, B:52:0x0115, B:55:0x011b, B:57:0x0125, B:58:0x0141, B:31:0x009d, B:33:0x00bc, B:38:0x00c4, B:40:0x00c8, B:42:0x00df, B:46:0x00e8, B:48:0x00f2, B:51:0x010c), top: B:70:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    synchronized InputStream retr(int i, int i2) throws IOException {
        boolean z;
        Response readResponse;
        if (i2 == 0) {
            try {
                if (this.pipelining) {
                    z = true;
                    if (!z) {
                        String str = "LIST " + i;
                        batchCommandStart(str);
                        issueCommand(str);
                        String str2 = "RETR " + i;
                        batchCommandContinue(str2);
                        issueCommand(str2);
                        Response readResponse2 = readResponse();
                        if (readResponse2.ok && readResponse2.data != null) {
                            try {
                                StringTokenizer stringTokenizer = new StringTokenizer(readResponse2.data);
                                stringTokenizer.nextToken();
                                int parseInt = Integer.parseInt(stringTokenizer.nextToken());
                                if (parseInt > 1073741824 || parseInt < 0) {
                                    i2 = 0;
                                } else {
                                    try {
                                        if (this.logger.isLoggable(Level.FINE)) {
                                            this.logger.fine("pipeline message size " + parseInt);
                                        }
                                        parseInt += 128;
                                    } catch (RuntimeException unused) {
                                    }
                                    i2 = parseInt;
                                }
                            } catch (RuntimeException unused2) {
                            }
                        }
                        readResponse = readResponse();
                        if (readResponse.ok) {
                            readResponse.bytes = readMultilineResponse(i2 + 128);
                        }
                        batchCommandEnd();
                    } else {
                        String str3 = "RETR " + i;
                        multilineCommandStart(str3);
                        issueCommand(str3);
                        readResponse = readResponse();
                        if (!readResponse.ok) {
                            multilineCommandEnd();
                            return null;
                        }
                        if (i2 <= 0 && readResponse.data != null) {
                            try {
                                StringTokenizer stringTokenizer2 = new StringTokenizer(readResponse.data);
                                String nextToken = stringTokenizer2.nextToken();
                                if (stringTokenizer2.nextToken().equals("octets")) {
                                    i2 = Integer.parseInt(nextToken);
                                    if (i2 <= 1073741824 && i2 >= 0) {
                                        if (this.logger.isLoggable(Level.FINE)) {
                                            this.logger.fine("guessing message size: " + i2);
                                        }
                                        i2 += 128;
                                    }
                                    i2 = 0;
                                }
                            } catch (RuntimeException unused3) {
                            }
                        }
                        readResponse.bytes = readMultilineResponse(i2);
                        multilineCommandEnd();
                    }
                    if (readResponse.ok && i2 > 0 && this.logger.isLoggable(Level.FINE)) {
                        this.logger.fine("got message size " + readResponse.bytes.available());
                    }
                    return readResponse.bytes;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        z = false;
        if (!z) {
        }
        if (readResponse.ok) {
            this.logger.fine("got message size " + readResponse.bytes.available());
        }
        return readResponse.bytes;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0042, code lost:
        r2 = r5.input.read();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    synchronized boolean retr(int i, OutputStream outputStream) throws IOException {
        int read;
        String str = "RETR " + i;
        multilineCommandStart(str);
        issueCommand(str);
        if (!readResponse().ok) {
            multilineCommandEnd();
            return false;
        }
        Throwable e = null;
        int i2 = 10;
        while (true) {
            try {
                read = this.input.read();
                if (read < 0) {
                    break;
                }
                if (i2 == 10 && read == 46) {
                    i2 = this.input.read();
                    if (i2 == 13) {
                        break;
                    }
                } else {
                    i2 = read;
                }
                if (e == null) {
                    try {
                        outputStream.write(i2);
                    } catch (IOException e2) {
                        e = e2;
                        this.logger.log(Level.FINE, "exception while streaming", e);
                    } catch (RuntimeException e3) {
                        e = e3;
                        this.logger.log(Level.FINE, "exception while streaming", e);
                    }
                }
            } catch (InterruptedIOException e4) {
                try {
                    this.socket.close();
                } catch (IOException unused) {
                }
                throw e4;
            }
        }
        if (read < 0) {
            throw new EOFException("EOF on socket");
        }
        if (e != null) {
            if (e instanceof IOException) {
                throw ((IOException) e);
            }
            if (e instanceof RuntimeException) {
                throw ((RuntimeException) e);
            }
        }
        multilineCommandEnd();
        return true;
    }

    synchronized InputStream top(int i, int i2) throws IOException {
        return multilineCommand("TOP " + i + " " + i2, 0).bytes;
    }

    synchronized boolean dele(int i) throws IOException {
        return simpleCommand("DELE " + i).ok;
    }

    synchronized String uidl(int i) throws IOException {
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

    synchronized boolean uidl(String[] strArr) throws IOException {
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

    synchronized boolean noop() throws IOException {
        return simpleCommand("NOOP").ok;
    }

    synchronized boolean rset() throws IOException {
        return simpleCommand("RSET").ok;
    }

    synchronized boolean stls() throws IOException {
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

    synchronized boolean isSSL() {
        return this.socket instanceof SSLSocket;
    }

    synchronized InputStream capa() throws IOException {
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
    */
    private InputStream readMultilineResponse(int i) throws IOException {
        int read;
        SharedByteArrayOutputStream sharedByteArrayOutputStream = new SharedByteArrayOutputStream(i);
        int i2 = 10;
        while (true) {
            try {
                read = this.input.read();
                if (read < 0) {
                    break;
                }
                if (i2 == 10 && read == 46) {
                    i2 = this.input.read();
                    if (i2 == 13) {
                        break;
                    }
                } else {
                    i2 = read;
                }
                sharedByteArrayOutputStream.write(i2);
            } catch (InterruptedIOException e) {
                try {
                    this.socket.close();
                } catch (IOException unused) {
                }
                throw e;
            }
        }
        if (read < 0) {
            throw new EOFException("EOF on socket");
        }
        return sharedByteArrayOutputStream.toStream();
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
