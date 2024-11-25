package com.sun.mail.imap;

import com.sun.mail.iap.BadCommandException;
import com.sun.mail.iap.CommandFailedException;
import com.sun.mail.iap.ConnectionException;
import com.sun.mail.iap.Protocol;
import com.sun.mail.iap.ProtocolException;
import com.sun.mail.iap.Response;
import com.sun.mail.iap.ResponseHandler;
import com.sun.mail.imap.protocol.IMAPProtocol;
import com.sun.mail.imap.protocol.IMAPReferralException;
import com.sun.mail.imap.protocol.ListInfo;
import com.sun.mail.imap.protocol.Namespaces;
import com.sun.mail.util.MailConnectException;
import com.sun.mail.util.MailLogger;
import com.sun.mail.util.PropUtil;
import com.sun.mail.util.SocketConnectException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.logging.Level;
import javax.mail.AuthenticationFailedException;
import javax.mail.Folder;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Quota;
import javax.mail.QuotaAwareStore;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.StoreClosedException;
import javax.mail.URLName;
import kotlin.jvm.internal.CharCompanionObject;
/* loaded from: classes2.dex */
public class IMAPStore extends Store implements QuotaAwareStore, ResponseHandler {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String ID_ADDRESS = "address";
    public static final String ID_ARGUMENTS = "arguments";
    public static final String ID_COMMAND = "command";
    public static final String ID_DATE = "date";
    public static final String ID_ENVIRONMENT = "environment";
    public static final String ID_NAME = "name";
    public static final String ID_OS = "os";
    public static final String ID_OS_VERSION = "os-version";
    public static final String ID_SUPPORT_URL = "support-url";
    public static final String ID_VENDOR = "vendor";
    public static final String ID_VERSION = "version";
    public static final int RESPONSE = 1000;
    private final int appendBufferSize;
    protected String authorizationID;
    private final int blksize;
    private boolean closeFoldersOnStoreFailure;
    private volatile boolean connectionFailed;
    private final Object connectionFailedLock;
    private boolean debugpassword;
    private boolean debugusername;
    protected final int defaultPort;
    private boolean enableCompress;
    private boolean enableImapEvents;
    private boolean enableResponseEvents;
    private boolean enableSASL;
    private boolean enableStartTLS;
    private boolean finalizeCleanClose;
    private volatile Constructor<?> folderConstructor;
    private volatile Constructor<?> folderConstructorLI;
    private volatile boolean forceClose;
    private boolean forcePasswordRefresh;
    private String guid;
    protected String host;
    private boolean ignoreSize;
    protected final boolean isSSL;
    protected MailLogger logger;
    private boolean messageCacheDebug;
    private final int minIdleTime;
    protected final String name;
    private Namespaces namespaces;
    private ResponseHandler nonStoreResponseHandler;
    protected String password;
    private boolean peek;
    private final ConnectionPool pool;
    private volatile int port;
    protected String proxyAuthUser;
    private boolean requireStartTLS;
    private String[] saslMechanisms;
    protected String saslRealm;
    private final int statusCacheTimeout;
    private boolean throwSearchException;
    protected String user;
    private boolean usingSSL;

    protected void preLogin(IMAPProtocol iMAPProtocol) throws ProtocolException {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class ConnectionPool {
        private static final int ABORTING = 2;
        private static final int IDLE = 1;
        private static final int RUNNING = 0;
        private final long clientTimeoutInterval;
        private Vector<IMAPFolder> folders;
        private IMAPProtocol idleProtocol;
        private final MailLogger logger;
        private final int poolSize;
        private final long pruningInterval;
        private final boolean separateStoreConnection;
        private final long serverTimeoutInterval;
        private Vector<IMAPProtocol> authenticatedConnections = new Vector<>();
        private boolean storeConnectionInUse = false;
        private int idleState = 0;
        private long lastTimePruned = System.currentTimeMillis();

        ConnectionPool(String str, MailLogger mailLogger, Session session) {
            Properties properties = session.getProperties();
            this.logger = mailLogger.getSubLogger("connectionpool", "DEBUG IMAP CP", PropUtil.getBooleanProperty(properties, "mail." + str + ".connectionpool.debug", false));
            int intProperty = PropUtil.getIntProperty(properties, "mail." + str + ".connectionpoolsize", -1);
            if (intProperty > 0) {
                this.poolSize = intProperty;
                if (this.logger.isLoggable(Level.CONFIG)) {
                    MailLogger mailLogger2 = this.logger;
                    mailLogger2.config("mail.imap.connectionpoolsize: " + this.poolSize);
                }
            } else {
                this.poolSize = 1;
            }
            int intProperty2 = PropUtil.getIntProperty(properties, "mail." + str + ".connectionpooltimeout", -1);
            if (intProperty2 > 0) {
                this.clientTimeoutInterval = intProperty2;
                if (this.logger.isLoggable(Level.CONFIG)) {
                    MailLogger mailLogger3 = this.logger;
                    mailLogger3.config("mail.imap.connectionpooltimeout: " + this.clientTimeoutInterval);
                }
            } else {
                this.clientTimeoutInterval = 45000L;
            }
            int intProperty3 = PropUtil.getIntProperty(properties, "mail." + str + ".servertimeout", -1);
            if (intProperty3 > 0) {
                this.serverTimeoutInterval = intProperty3;
                if (this.logger.isLoggable(Level.CONFIG)) {
                    MailLogger mailLogger4 = this.logger;
                    mailLogger4.config("mail.imap.servertimeout: " + this.serverTimeoutInterval);
                }
            } else {
                this.serverTimeoutInterval = 1800000L;
            }
            int intProperty4 = PropUtil.getIntProperty(properties, "mail." + str + ".pruninginterval", -1);
            if (intProperty4 > 0) {
                this.pruningInterval = intProperty4;
                if (this.logger.isLoggable(Level.CONFIG)) {
                    MailLogger mailLogger5 = this.logger;
                    mailLogger5.config("mail.imap.pruninginterval: " + this.pruningInterval);
                }
            } else {
                this.pruningInterval = 60000L;
            }
            boolean booleanProperty = PropUtil.getBooleanProperty(properties, "mail." + str + ".separatestoreconnection", false);
            this.separateStoreConnection = booleanProperty;
            if (booleanProperty) {
                this.logger.config("dedicate a store connection");
            }
        }
    }

    public IMAPStore(Session session, URLName uRLName) {
        this(session, uRLName, "imap", false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public IMAPStore(Session session, URLName uRLName, String str, boolean z) {
        super(session, uRLName);
        Class<?> cls;
        this.port = -1;
        this.enableStartTLS = false;
        this.requireStartTLS = false;
        this.usingSSL = false;
        this.enableSASL = false;
        this.forcePasswordRefresh = false;
        this.enableResponseEvents = false;
        this.enableImapEvents = false;
        this.throwSearchException = false;
        this.peek = false;
        this.closeFoldersOnStoreFailure = true;
        this.enableCompress = false;
        this.finalizeCleanClose = false;
        this.connectionFailed = false;
        this.forceClose = false;
        this.connectionFailedLock = new Object();
        this.folderConstructor = null;
        this.folderConstructorLI = null;
        this.nonStoreResponseHandler = new ResponseHandler() { // from class: com.sun.mail.imap.IMAPStore.1
            @Override // com.sun.mail.iap.ResponseHandler
            public void handleResponse(Response response) {
                if (response.isOK() || response.isNO() || response.isBAD() || response.isBYE()) {
                    IMAPStore.this.handleResponseCode(response);
                }
                if (response.isBYE()) {
                    IMAPStore.this.logger.fine("IMAPStore non-store connection dead");
                }
            }
        };
        Properties properties = session.getProperties();
        str = uRLName != null ? uRLName.getProtocol() : str;
        this.name = str;
        if (!z) {
            z = PropUtil.getBooleanProperty(properties, "mail." + str + ".ssl.enable", false);
        }
        if (z) {
            this.defaultPort = 993;
        } else {
            this.defaultPort = 143;
        }
        this.isSSL = z;
        this.debug = session.getDebug();
        this.debugusername = PropUtil.getBooleanProperty(properties, "mail.debug.auth.username", true);
        this.debugpassword = PropUtil.getBooleanProperty(properties, "mail.debug.auth.password", false);
        Class<?> cls2 = getClass();
        this.logger = new MailLogger(cls2, "DEBUG " + str.toUpperCase(Locale.ENGLISH), session.getDebug(), session.getDebugOut());
        if (!PropUtil.getBooleanProperty(properties, "mail." + str + ".partialfetch", true)) {
            this.blksize = -1;
            this.logger.config("mail.imap.partialfetch: false");
        } else {
            this.blksize = PropUtil.getIntProperty(properties, "mail." + str + ".fetchsize", 16384);
            if (this.logger.isLoggable(Level.CONFIG)) {
                MailLogger mailLogger = this.logger;
                mailLogger.config("mail.imap.fetchsize: " + this.blksize);
            }
        }
        this.ignoreSize = PropUtil.getBooleanProperty(properties, "mail." + str + ".ignorebodystructuresize", false);
        if (this.logger.isLoggable(Level.CONFIG)) {
            MailLogger mailLogger2 = this.logger;
            mailLogger2.config("mail.imap.ignorebodystructuresize: " + this.ignoreSize);
        }
        this.statusCacheTimeout = PropUtil.getIntProperty(properties, "mail." + str + ".statuscachetimeout", 1000);
        if (this.logger.isLoggable(Level.CONFIG)) {
            MailLogger mailLogger3 = this.logger;
            mailLogger3.config("mail.imap.statuscachetimeout: " + this.statusCacheTimeout);
        }
        this.appendBufferSize = PropUtil.getIntProperty(properties, "mail." + str + ".appendbuffersize", -1);
        if (this.logger.isLoggable(Level.CONFIG)) {
            MailLogger mailLogger4 = this.logger;
            mailLogger4.config("mail.imap.appendbuffersize: " + this.appendBufferSize);
        }
        this.minIdleTime = PropUtil.getIntProperty(properties, "mail." + str + ".minidletime", 10);
        if (this.logger.isLoggable(Level.CONFIG)) {
            MailLogger mailLogger5 = this.logger;
            mailLogger5.config("mail.imap.minidletime: " + this.minIdleTime);
        }
        String property = session.getProperty("mail." + str + ".proxyauth.user");
        if (property != null) {
            this.proxyAuthUser = property;
            if (this.logger.isLoggable(Level.CONFIG)) {
                MailLogger mailLogger6 = this.logger;
                mailLogger6.config("mail.imap.proxyauth.user: " + this.proxyAuthUser);
            }
        }
        boolean booleanProperty = PropUtil.getBooleanProperty(properties, "mail." + str + ".starttls.enable", false);
        this.enableStartTLS = booleanProperty;
        if (booleanProperty) {
            this.logger.config("enable STARTTLS");
        }
        boolean booleanProperty2 = PropUtil.getBooleanProperty(properties, "mail." + str + ".starttls.required", false);
        this.requireStartTLS = booleanProperty2;
        if (booleanProperty2) {
            this.logger.config("require STARTTLS");
        }
        boolean booleanProperty3 = PropUtil.getBooleanProperty(properties, "mail." + str + ".sasl.enable", false);
        this.enableSASL = booleanProperty3;
        if (booleanProperty3) {
            this.logger.config("enable SASL");
        }
        if (this.enableSASL) {
            String property2 = session.getProperty("mail." + str + ".sasl.mechanisms");
            if (property2 != null && property2.length() > 0) {
                if (this.logger.isLoggable(Level.CONFIG)) {
                    MailLogger mailLogger7 = this.logger;
                    mailLogger7.config("SASL mechanisms allowed: " + property2);
                }
                ArrayList arrayList = new ArrayList(5);
                StringTokenizer stringTokenizer = new StringTokenizer(property2, " ,");
                while (stringTokenizer.hasMoreTokens()) {
                    String nextToken = stringTokenizer.nextToken();
                    if (nextToken.length() > 0) {
                        arrayList.add(nextToken);
                    }
                }
                String[] strArr = new String[arrayList.size()];
                this.saslMechanisms = strArr;
                arrayList.toArray(strArr);
            }
        }
        String property3 = session.getProperty("mail." + str + ".sasl.authorizationid");
        if (property3 != null) {
            this.authorizationID = property3;
            this.logger.log(Level.CONFIG, "mail.imap.sasl.authorizationid: {0}", this.authorizationID);
        }
        String property4 = session.getProperty("mail." + str + ".sasl.realm");
        if (property4 != null) {
            this.saslRealm = property4;
            this.logger.log(Level.CONFIG, "mail.imap.sasl.realm: {0}", this.saslRealm);
        }
        boolean booleanProperty4 = PropUtil.getBooleanProperty(properties, "mail." + str + ".forcepasswordrefresh", false);
        this.forcePasswordRefresh = booleanProperty4;
        if (booleanProperty4) {
            this.logger.config("enable forcePasswordRefresh");
        }
        boolean booleanProperty5 = PropUtil.getBooleanProperty(properties, "mail." + str + ".enableresponseevents", false);
        this.enableResponseEvents = booleanProperty5;
        if (booleanProperty5) {
            this.logger.config("enable IMAP response events");
        }
        boolean booleanProperty6 = PropUtil.getBooleanProperty(properties, "mail." + str + ".enableimapevents", false);
        this.enableImapEvents = booleanProperty6;
        if (booleanProperty6) {
            this.logger.config("enable IMAP IDLE events");
        }
        this.messageCacheDebug = PropUtil.getBooleanProperty(properties, "mail." + str + ".messagecache.debug", false);
        String property5 = session.getProperty("mail." + str + ".yahoo.guid");
        this.guid = property5;
        if (property5 != null) {
            this.logger.log(Level.CONFIG, "mail.imap.yahoo.guid: {0}", this.guid);
        }
        boolean booleanProperty7 = PropUtil.getBooleanProperty(properties, "mail." + str + ".throwsearchexception", false);
        this.throwSearchException = booleanProperty7;
        if (booleanProperty7) {
            this.logger.config("throw SearchException");
        }
        boolean booleanProperty8 = PropUtil.getBooleanProperty(properties, "mail." + str + ".peek", false);
        this.peek = booleanProperty8;
        if (booleanProperty8) {
            this.logger.config("peek");
        }
        boolean booleanProperty9 = PropUtil.getBooleanProperty(properties, "mail." + str + ".closefoldersonstorefailure", true);
        this.closeFoldersOnStoreFailure = booleanProperty9;
        if (booleanProperty9) {
            this.logger.config("closeFoldersOnStoreFailure");
        }
        boolean booleanProperty10 = PropUtil.getBooleanProperty(properties, "mail." + str + ".compress.enable", false);
        this.enableCompress = booleanProperty10;
        if (booleanProperty10) {
            this.logger.config("enable COMPRESS");
        }
        boolean booleanProperty11 = PropUtil.getBooleanProperty(properties, "mail." + str + ".finalizecleanclose", false);
        this.finalizeCleanClose = booleanProperty11;
        if (booleanProperty11) {
            this.logger.config("close connection cleanly in finalize");
        }
        String property6 = session.getProperty("mail." + str + ".folder.class");
        if (property6 != null) {
            this.logger.log(Level.CONFIG, "IMAP: folder class: {0}", property6);
            try {
                try {
                    cls = Class.forName(property6, false, getClass().getClassLoader());
                } catch (ClassNotFoundException unused) {
                    cls = Class.forName(property6);
                }
                this.folderConstructor = cls.getConstructor(String.class, Character.TYPE, IMAPStore.class, Boolean.class);
                this.folderConstructorLI = cls.getConstructor(ListInfo.class, IMAPStore.class);
            } catch (Exception e) {
                this.logger.log(Level.CONFIG, "IMAP: failed to load folder class", (Throwable) e);
            }
        }
        this.pool = new ConnectionPool(str, this.logger, session);
    }

    @Override // javax.mail.Service
    protected synchronized boolean protocolConnect(String str, int i, String str2, String str3) throws MessagingException {
        boolean isEmpty;
        Protocol protocol = null;
        if (str == null || str3 == null || str2 == null) {
            if (this.logger.isLoggable(Level.FINE)) {
                MailLogger mailLogger = this.logger;
                mailLogger.fine("protocolConnect returning false, host=" + str + ", user=" + traceUser(str2) + ", password=" + tracePassword(str3));
            }
            return false;
        }
        if (i != -1) {
            this.port = i;
        } else {
            Properties properties = this.session.getProperties();
            this.port = PropUtil.getIntProperty(properties, "mail." + this.name + ".port", this.port);
        }
        if (this.port == -1) {
            this.port = this.defaultPort;
        }
        try {
            try {
                synchronized (this.pool) {
                    isEmpty = this.pool.authenticatedConnections.isEmpty();
                }
                if (isEmpty) {
                    if (this.logger.isLoggable(Level.FINE)) {
                        MailLogger mailLogger2 = this.logger;
                        mailLogger2.fine("trying to connect to host \"" + str + "\", port " + this.port + ", isSSL " + this.isSSL);
                    }
                    IMAPProtocol newIMAPProtocol = newIMAPProtocol(str, this.port);
                    if (this.logger.isLoggable(Level.FINE)) {
                        MailLogger mailLogger3 = this.logger;
                        mailLogger3.fine("protocolConnect login, host=" + str + ", user=" + traceUser(str2) + ", password=" + tracePassword(str3));
                    }
                    newIMAPProtocol.addResponseHandler(this.nonStoreResponseHandler);
                    login(newIMAPProtocol, str2, str3);
                    newIMAPProtocol.removeResponseHandler(this.nonStoreResponseHandler);
                    newIMAPProtocol.addResponseHandler(this);
                    this.usingSSL = newIMAPProtocol.isSSL();
                    this.host = str;
                    this.user = str2;
                    this.password = str3;
                    synchronized (this.pool) {
                        this.pool.authenticatedConnections.addElement(newIMAPProtocol);
                    }
                }
                return true;
            } catch (IMAPReferralException e) {
                if (0 != 0) {
                    protocol.disconnect();
                }
                throw new ReferralException(e.getUrl(), e.getMessage());
            } catch (IOException e2) {
                throw new MessagingException(e2.getMessage(), e2);
            }
        } catch (CommandFailedException e3) {
            if (0 != 0) {
                protocol.disconnect();
            }
            Response response = e3.getResponse();
            throw new AuthenticationFailedException(response != null ? response.getRest() : e3.getMessage());
        } catch (ProtocolException e4) {
            if (0 != 0) {
                protocol.disconnect();
            }
            throw new MessagingException(e4.getMessage(), e4);
        } catch (SocketConnectException e5) {
            throw new MailConnectException(e5);
        }
    }

    protected IMAPProtocol newIMAPProtocol(String str, int i) throws IOException, ProtocolException {
        return new IMAPProtocol(this.name, str, i, this.session.getProperties(), this.isSSL, this.logger);
    }

    private void login(IMAPProtocol iMAPProtocol, String str, String str2) throws ProtocolException {
        if ((this.enableStartTLS || this.requireStartTLS) && !iMAPProtocol.isSSL()) {
            if (iMAPProtocol.hasCapability("STARTTLS")) {
                iMAPProtocol.startTLS();
                iMAPProtocol.capability();
            } else if (this.requireStartTLS) {
                this.logger.fine("STARTTLS required but not supported by server");
                throw new ProtocolException("STARTTLS required but not supported by server");
            }
        }
        if (iMAPProtocol.isAuthenticated()) {
            return;
        }
        preLogin(iMAPProtocol);
        if (this.guid != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("GUID", this.guid);
            iMAPProtocol.id(hashMap);
        }
        iMAPProtocol.getCapabilities().put("__PRELOGIN__", "");
        String str3 = this.authorizationID;
        if (str3 == null && (str3 = this.proxyAuthUser) == null) {
            str3 = null;
        }
        if (this.enableSASL) {
            try {
                iMAPProtocol.sasllogin(this.saslMechanisms, this.saslRealm, str3, str, str2);
                if (!iMAPProtocol.isAuthenticated()) {
                    throw new CommandFailedException("SASL authentication failed");
                }
            } catch (UnsupportedOperationException unused) {
            }
        }
        if (!iMAPProtocol.isAuthenticated()) {
            authenticate(iMAPProtocol, str3, str, str2);
        }
        String str4 = this.proxyAuthUser;
        if (str4 != null) {
            iMAPProtocol.proxyauth(str4);
        }
        if (iMAPProtocol.hasCapability("__PRELOGIN__")) {
            try {
                iMAPProtocol.capability();
            } catch (ConnectionException e) {
                throw e;
            } catch (ProtocolException unused2) {
            }
        }
        if (this.enableCompress && iMAPProtocol.hasCapability("COMPRESS=DEFLATE")) {
            iMAPProtocol.compress();
        }
        if (iMAPProtocol.hasCapability("UTF8=ACCEPT") || iMAPProtocol.hasCapability("UTF8=ONLY")) {
            iMAPProtocol.enable("UTF8=ACCEPT");
        }
    }

    private void authenticate(IMAPProtocol iMAPProtocol, String str, String str2, String str3) throws ProtocolException {
        String property = this.session.getProperty("mail." + this.name + ".auth.mechanisms");
        if (property == null) {
            property = "PLAIN LOGIN NTLM XOAUTH2";
        }
        StringTokenizer stringTokenizer = new StringTokenizer(property);
        while (stringTokenizer.hasMoreTokens()) {
            String upperCase = stringTokenizer.nextToken().toUpperCase(Locale.ENGLISH);
            if (property == "PLAIN LOGIN NTLM XOAUTH2") {
                String str4 = "mail." + this.name + ".auth." + upperCase.toLowerCase(Locale.ENGLISH) + ".disable";
                if (PropUtil.getBooleanProperty(this.session.getProperties(), str4, upperCase.equals("XOAUTH2"))) {
                    if (this.logger.isLoggable(Level.FINE)) {
                        this.logger.fine("mechanism " + upperCase + " disabled by property: " + str4);
                    }
                }
            }
            if (!iMAPProtocol.hasCapability("AUTH=" + upperCase) && (!upperCase.equals("LOGIN") || !iMAPProtocol.hasCapability("AUTH-LOGIN"))) {
                this.logger.log(Level.FINE, "mechanism {0} not supported by server", upperCase);
            } else if (upperCase.equals("PLAIN")) {
                iMAPProtocol.authplain(str, str2, str3);
                return;
            } else if (upperCase.equals("LOGIN")) {
                iMAPProtocol.authlogin(str2, str3);
                return;
            } else if (upperCase.equals("NTLM")) {
                iMAPProtocol.authntlm(str, str2, str3);
                return;
            } else if (upperCase.equals("XOAUTH2")) {
                iMAPProtocol.authoauth2(str2, str3);
                return;
            } else {
                this.logger.log(Level.FINE, "no authenticator for mechanism {0}", upperCase);
            }
        }
        if (!iMAPProtocol.hasCapability("LOGINDISABLED")) {
            iMAPProtocol.login(str2, str3);
            return;
        }
        throw new ProtocolException("No login methods supported!");
    }

    public synchronized boolean isSSL() {
        return this.usingSSL;
    }

    public synchronized void setUsername(String str) {
        this.user = str;
    }

    public synchronized void setPassword(String str) {
        this.password = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't wrap try/catch for region: R(11:6|7|(10:16|(1:18)|19|20|(2:47|48)|22|(2:28|29)|38|39|(3:41|(1:43)|44))|56|57|58|(1:60)|61|(1:63)|39|(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x010d, code lost:
        if (r1 != null) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x010f, code lost:
        r1.disconnect();
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0112, code lost:
        r1 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x013f, code lost:
        throw new javax.mail.MessagingException("connection failure");
     */
    /* JADX WARN: Removed duplicated region for block: B:51:0x011a A[Catch: all -> 0x0140, TryCatch #1 {, blocks: (B:7:0x0007, B:9:0x0013, B:11:0x0020, B:13:0x0028, B:16:0x0032, B:18:0x003c, B:19:0x005c, B:22:0x0084, B:27:0x00a3, B:29:0x00a7, B:31:0x00b3, B:33:0x00bb, B:35:0x00d6, B:36:0x00de, B:38:0x00e1, B:49:0x0115, B:51:0x011a, B:53:0x0122, B:54:0x012c, B:55:0x0135, B:24:0x0098, B:25:0x00a0, B:39:0x00e5, B:40:0x00ec, B:42:0x00f0, B:43:0x00f3, B:57:0x0138, B:58:0x013f, B:46:0x010f), top: B:68:0x0007 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.sun.mail.imap.protocol.IMAPProtocol getProtocol(com.sun.mail.imap.IMAPFolder r8) throws javax.mail.MessagingException {
        /*
            Method dump skipped, instructions count: 324
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.imap.IMAPStore.getProtocol(com.sun.mail.imap.IMAPFolder):com.sun.mail.imap.protocol.IMAPProtocol");
    }

    private IMAPProtocol getStoreProtocol() throws ProtocolException {
        IMAPProtocol iMAPProtocol = null;
        while (iMAPProtocol == null) {
            synchronized (this.pool) {
                waitIfIdle();
                if (this.pool.authenticatedConnections.isEmpty()) {
                    this.pool.logger.fine("getStoreProtocol() - no connections in the pool, creating a new one");
                    try {
                        if (this.forcePasswordRefresh) {
                            refreshPassword();
                        }
                        iMAPProtocol = newIMAPProtocol(this.host, this.port);
                        login(iMAPProtocol, this.user, this.password);
                    } catch (Exception unused) {
                        if (iMAPProtocol != null) {
                            try {
                                iMAPProtocol.logout();
                            } catch (Exception unused2) {
                            }
                        }
                        iMAPProtocol = null;
                    }
                    if (iMAPProtocol == null) {
                        throw new ConnectionException("failed to create new store connection");
                    }
                    iMAPProtocol.addResponseHandler(this);
                    this.pool.authenticatedConnections.addElement(iMAPProtocol);
                } else {
                    if (this.pool.logger.isLoggable(Level.FINE)) {
                        this.pool.logger.fine("getStoreProtocol() - connection available -- size: " + this.pool.authenticatedConnections.size());
                    }
                    iMAPProtocol = (IMAPProtocol) this.pool.authenticatedConnections.firstElement();
                    if (this.proxyAuthUser != null && !this.proxyAuthUser.equals(iMAPProtocol.getProxyAuthUser()) && iMAPProtocol.hasCapability("X-UNAUTHENTICATE")) {
                        iMAPProtocol.unauthenticate();
                        login(iMAPProtocol, this.user, this.password);
                    }
                }
                if (!this.pool.storeConnectionInUse) {
                    this.pool.storeConnectionInUse = true;
                    this.pool.logger.fine("getStoreProtocol() -- storeConnectionInUse");
                } else {
                    try {
                        this.pool.wait();
                        iMAPProtocol = null;
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        throw new ProtocolException("Interrupted getStoreProtocol", e);
                    }
                }
                timeoutConnections();
            }
        }
        return iMAPProtocol;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public IMAPProtocol getFolderStoreProtocol() throws ProtocolException {
        IMAPProtocol storeProtocol = getStoreProtocol();
        storeProtocol.removeResponseHandler(this);
        storeProtocol.addResponseHandler(this.nonStoreResponseHandler);
        return storeProtocol;
    }

    private void refreshPassword() {
        InetAddress inetAddress;
        if (this.logger.isLoggable(Level.FINE)) {
            MailLogger mailLogger = this.logger;
            mailLogger.fine("refresh password, user: " + traceUser(this.user));
        }
        try {
            inetAddress = InetAddress.getByName(this.host);
        } catch (UnknownHostException unused) {
            inetAddress = null;
        }
        PasswordAuthentication requestPasswordAuthentication = this.session.requestPasswordAuthentication(inetAddress, this.port, this.name, null, this.user);
        if (requestPasswordAuthentication != null) {
            this.user = requestPasswordAuthentication.getUserName();
            this.password = requestPasswordAuthentication.getPassword();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean allowReadOnlySelect() {
        Properties properties = this.session.getProperties();
        return PropUtil.getBooleanProperty(properties, "mail." + this.name + ".allowreadonlyselect", false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean hasSeparateStoreConnection() {
        return this.pool.separateStoreConnection;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MailLogger getConnectionPoolLogger() {
        return this.pool.logger;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean getMessageCacheDebug() {
        return this.messageCacheDebug;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isConnectionPoolFull() {
        boolean z;
        synchronized (this.pool) {
            if (this.pool.logger.isLoggable(Level.FINE)) {
                MailLogger mailLogger = this.pool.logger;
                mailLogger.fine("connection pool current size: " + this.pool.authenticatedConnections.size() + "   pool size: " + this.pool.poolSize);
            }
            z = this.pool.authenticatedConnections.size() >= this.pool.poolSize;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void releaseProtocol(IMAPFolder iMAPFolder, IMAPProtocol iMAPProtocol) {
        synchronized (this.pool) {
            if (iMAPProtocol != null) {
                if (!isConnectionPoolFull()) {
                    iMAPProtocol.addResponseHandler(this);
                    this.pool.authenticatedConnections.addElement(iMAPProtocol);
                    if (this.logger.isLoggable(Level.FINE)) {
                        MailLogger mailLogger = this.logger;
                        mailLogger.fine("added an Authenticated connection -- size: " + this.pool.authenticatedConnections.size());
                    }
                } else {
                    this.logger.fine("pool is full, not adding an Authenticated connection");
                    try {
                        iMAPProtocol.logout();
                    } catch (ProtocolException unused) {
                    }
                }
            }
            if (this.pool.folders != null) {
                this.pool.folders.removeElement(iMAPFolder);
            }
            timeoutConnections();
        }
    }

    private void releaseStoreProtocol(IMAPProtocol iMAPProtocol) {
        boolean z;
        if (iMAPProtocol == null) {
            cleanup();
            return;
        }
        synchronized (this.connectionFailedLock) {
            z = this.connectionFailed;
            this.connectionFailed = false;
        }
        synchronized (this.pool) {
            this.pool.storeConnectionInUse = false;
            this.pool.notifyAll();
            this.pool.logger.fine("releaseStoreProtocol()");
            timeoutConnections();
        }
        if (z) {
            cleanup();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void releaseFolderStoreProtocol(IMAPProtocol iMAPProtocol) {
        if (iMAPProtocol == null) {
            return;
        }
        iMAPProtocol.removeResponseHandler(this.nonStoreResponseHandler);
        iMAPProtocol.addResponseHandler(this);
        synchronized (this.pool) {
            this.pool.storeConnectionInUse = false;
            this.pool.notifyAll();
            this.pool.logger.fine("releaseFolderStoreProtocol()");
            timeoutConnections();
        }
    }

    private void emptyConnectionPool(boolean z) {
        synchronized (this.pool) {
            for (int size = this.pool.authenticatedConnections.size() - 1; size >= 0; size--) {
                try {
                    IMAPProtocol iMAPProtocol = (IMAPProtocol) this.pool.authenticatedConnections.elementAt(size);
                    iMAPProtocol.removeResponseHandler(this);
                    if (z) {
                        iMAPProtocol.disconnect();
                    } else {
                        iMAPProtocol.logout();
                    }
                } catch (ProtocolException unused) {
                }
            }
            this.pool.authenticatedConnections.removeAllElements();
        }
        this.pool.logger.fine("removed all authenticated connections from pool");
    }

    private void timeoutConnections() {
        synchronized (this.pool) {
            if (System.currentTimeMillis() - this.pool.lastTimePruned > this.pool.pruningInterval && this.pool.authenticatedConnections.size() > 1) {
                if (this.pool.logger.isLoggable(Level.FINE)) {
                    this.pool.logger.fine("checking for connections to prune: " + (System.currentTimeMillis() - this.pool.lastTimePruned));
                    this.pool.logger.fine("clientTimeoutInterval: " + this.pool.clientTimeoutInterval);
                }
                for (int size = this.pool.authenticatedConnections.size() - 1; size > 0; size--) {
                    IMAPProtocol iMAPProtocol = (IMAPProtocol) this.pool.authenticatedConnections.elementAt(size);
                    if (this.pool.logger.isLoggable(Level.FINE)) {
                        this.pool.logger.fine("protocol last used: " + (System.currentTimeMillis() - iMAPProtocol.getTimestamp()));
                    }
                    if (System.currentTimeMillis() - iMAPProtocol.getTimestamp() > this.pool.clientTimeoutInterval) {
                        this.pool.logger.fine("authenticated connection timed out, logging out the connection");
                        iMAPProtocol.removeResponseHandler(this);
                        this.pool.authenticatedConnections.removeElementAt(size);
                        try {
                            iMAPProtocol.logout();
                        } catch (ProtocolException unused) {
                        }
                    }
                }
                this.pool.lastTimePruned = System.currentTimeMillis();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getFetchBlockSize() {
        return this.blksize;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean ignoreBodyStructureSize() {
        return this.ignoreSize;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Session getSession() {
        return this.session;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getStatusCacheTimeout() {
        return this.statusCacheTimeout;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getAppendBufferSize() {
        return this.appendBufferSize;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getMinIdleTime() {
        return this.minIdleTime;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean throwSearchException() {
        return this.throwSearchException;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean getPeek() {
        return this.peek;
    }

    public synchronized boolean hasCapability(String str) throws MessagingException {
        boolean hasCapability;
        try {
            IMAPProtocol storeProtocol = getStoreProtocol();
            hasCapability = storeProtocol.hasCapability(str);
            releaseStoreProtocol(storeProtocol);
        } catch (ProtocolException e) {
            throw new MessagingException(e.getMessage(), e);
        }
        return hasCapability;
    }

    public void setProxyAuthUser(String str) {
        this.proxyAuthUser = str;
    }

    public String getProxyAuthUser() {
        return this.proxyAuthUser;
    }

    @Override // javax.mail.Service
    public synchronized boolean isConnected() {
        if (super.isConnected()) {
            IMAPProtocol iMAPProtocol = null;
            try {
                iMAPProtocol = getStoreProtocol();
                iMAPProtocol.noop();
            } catch (ProtocolException unused) {
            }
            releaseStoreProtocol(iMAPProtocol);
            return super.isConnected();
        }
        return false;
    }

    @Override // javax.mail.Service, java.lang.AutoCloseable
    public synchronized void close() throws MessagingException {
        cleanup();
        closeAllFolders(true);
        emptyConnectionPool(true);
    }

    @Override // javax.mail.Service
    protected void finalize() throws Throwable {
        if (!this.finalizeCleanClose) {
            synchronized (this.connectionFailedLock) {
                this.connectionFailed = true;
                this.forceClose = true;
            }
            this.closeFoldersOnStoreFailure = true;
        }
        try {
            close();
        } finally {
            super.finalize();
        }
    }

    private synchronized void cleanup() {
        boolean z;
        if (!super.isConnected()) {
            this.logger.fine("IMAPStore cleanup, not connected");
            return;
        }
        synchronized (this.connectionFailedLock) {
            z = this.forceClose;
            this.forceClose = false;
            this.connectionFailed = false;
        }
        if (this.logger.isLoggable(Level.FINE)) {
            MailLogger mailLogger = this.logger;
            mailLogger.fine("IMAPStore cleanup, force " + z);
        }
        if (!z || this.closeFoldersOnStoreFailure) {
            closeAllFolders(z);
        }
        emptyConnectionPool(z);
        try {
            super.close();
        } catch (MessagingException unused) {
        }
        this.logger.fine("IMAPStore cleanup done");
    }

    private void closeAllFolders(boolean z) {
        boolean z2;
        Vector vector = null;
        while (true) {
            synchronized (this.pool) {
                if (this.pool.folders != null) {
                    vector = this.pool.folders;
                    this.pool.folders = null;
                    z2 = false;
                } else {
                    z2 = true;
                }
            }
            if (z2) {
                return;
            }
            int size = vector.size();
            for (int i = 0; i < size; i++) {
                IMAPFolder iMAPFolder = (IMAPFolder) vector.get(i);
                if (z) {
                    try {
                        this.logger.fine("force folder to close");
                        iMAPFolder.forceClose();
                    } catch (IllegalStateException | MessagingException unused) {
                    }
                } else {
                    this.logger.fine("close folder");
                    iMAPFolder.close(false);
                }
            }
        }
    }

    @Override // javax.mail.Store
    public synchronized Folder getDefaultFolder() throws MessagingException {
        checkConnected();
        return new DefaultFolder(this);
    }

    @Override // javax.mail.Store
    public synchronized Folder getFolder(String str) throws MessagingException {
        checkConnected();
        return newIMAPFolder(str, CharCompanionObject.MAX_VALUE);
    }

    @Override // javax.mail.Store
    public synchronized Folder getFolder(URLName uRLName) throws MessagingException {
        checkConnected();
        return newIMAPFolder(uRLName.getFile(), CharCompanionObject.MAX_VALUE);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected com.sun.mail.imap.IMAPFolder newIMAPFolder(java.lang.String r5, char r6, java.lang.Boolean r7) {
        /*
            r4 = this;
            java.lang.reflect.Constructor<?> r0 = r4.folderConstructor
            if (r0 == 0) goto L2a
            r0 = 4
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch: java.lang.Exception -> L20
            r1 = 0
            r0[r1] = r5     // Catch: java.lang.Exception -> L20
            r1 = 1
            java.lang.Character r2 = java.lang.Character.valueOf(r6)     // Catch: java.lang.Exception -> L20
            r0[r1] = r2     // Catch: java.lang.Exception -> L20
            r1 = 2
            r0[r1] = r4     // Catch: java.lang.Exception -> L20
            r1 = 3
            r0[r1] = r7     // Catch: java.lang.Exception -> L20
            java.lang.reflect.Constructor<?> r1 = r4.folderConstructor     // Catch: java.lang.Exception -> L20
            java.lang.Object r0 = r1.newInstance(r0)     // Catch: java.lang.Exception -> L20
            com.sun.mail.imap.IMAPFolder r0 = (com.sun.mail.imap.IMAPFolder) r0     // Catch: java.lang.Exception -> L20
            goto L2b
        L20:
            r0 = move-exception
            com.sun.mail.util.MailLogger r1 = r4.logger
            java.util.logging.Level r2 = java.util.logging.Level.FINE
            java.lang.String r3 = "exception creating IMAPFolder class"
            r1.log(r2, r3, r0)
        L2a:
            r0 = 0
        L2b:
            if (r0 != 0) goto L32
            com.sun.mail.imap.IMAPFolder r0 = new com.sun.mail.imap.IMAPFolder
            r0.<init>(r5, r6, r4, r7)
        L32:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.imap.IMAPStore.newIMAPFolder(java.lang.String, char, java.lang.Boolean):com.sun.mail.imap.IMAPFolder");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public IMAPFolder newIMAPFolder(String str, char c) {
        return newIMAPFolder(str, c, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.sun.mail.imap.IMAPFolder newIMAPFolder(com.sun.mail.imap.protocol.ListInfo r5) {
        /*
            r4 = this;
            java.lang.reflect.Constructor<?> r0 = r4.folderConstructorLI
            if (r0 == 0) goto L20
            r0 = 2
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch: java.lang.Exception -> L16
            r1 = 0
            r0[r1] = r5     // Catch: java.lang.Exception -> L16
            r1 = 1
            r0[r1] = r4     // Catch: java.lang.Exception -> L16
            java.lang.reflect.Constructor<?> r1 = r4.folderConstructorLI     // Catch: java.lang.Exception -> L16
            java.lang.Object r0 = r1.newInstance(r0)     // Catch: java.lang.Exception -> L16
            com.sun.mail.imap.IMAPFolder r0 = (com.sun.mail.imap.IMAPFolder) r0     // Catch: java.lang.Exception -> L16
            goto L21
        L16:
            r0 = move-exception
            com.sun.mail.util.MailLogger r1 = r4.logger
            java.util.logging.Level r2 = java.util.logging.Level.FINE
            java.lang.String r3 = "exception creating IMAPFolder class LI"
            r1.log(r2, r3, r0)
        L20:
            r0 = 0
        L21:
            if (r0 != 0) goto L28
            com.sun.mail.imap.IMAPFolder r0 = new com.sun.mail.imap.IMAPFolder
            r0.<init>(r5, r4)
        L28:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.imap.IMAPStore.newIMAPFolder(com.sun.mail.imap.protocol.ListInfo):com.sun.mail.imap.IMAPFolder");
    }

    @Override // javax.mail.Store
    public Folder[] getPersonalNamespaces() throws MessagingException {
        Namespaces namespaces = getNamespaces();
        if (namespaces == null || namespaces.personal == null) {
            return super.getPersonalNamespaces();
        }
        return namespaceToFolders(namespaces.personal, null);
    }

    @Override // javax.mail.Store
    public Folder[] getUserNamespaces(String str) throws MessagingException {
        Namespaces namespaces = getNamespaces();
        if (namespaces == null || namespaces.otherUsers == null) {
            return super.getUserNamespaces(str);
        }
        return namespaceToFolders(namespaces.otherUsers, str);
    }

    @Override // javax.mail.Store
    public Folder[] getSharedNamespaces() throws MessagingException {
        Namespaces namespaces = getNamespaces();
        if (namespaces == null || namespaces.shared == null) {
            return super.getSharedNamespaces();
        }
        return namespaceToFolders(namespaces.shared, null);
    }

    private synchronized Namespaces getNamespaces() throws MessagingException {
        checkConnected();
        IMAPProtocol iMAPProtocol = null;
        if (this.namespaces == null) {
            try {
                iMAPProtocol = getStoreProtocol();
                this.namespaces = iMAPProtocol.namespace();
            } catch (BadCommandException unused) {
            } catch (ConnectionException e) {
                throw new StoreClosedException(this, e.getMessage());
            } catch (ProtocolException e2) {
                throw new MessagingException(e2.getMessage(), e2);
            }
            releaseStoreProtocol(iMAPProtocol);
        }
        return this.namespaces;
    }

    private Folder[] namespaceToFolders(Namespaces.Namespace[] namespaceArr, String str) {
        int length = namespaceArr.length;
        Folder[] folderArr = new Folder[length];
        for (int i = 0; i < length; i++) {
            String str2 = namespaceArr[i].prefix;
            if (str == null) {
                int length2 = str2.length();
                if (length2 > 0) {
                    int i2 = length2 - 1;
                    if (str2.charAt(i2) == namespaceArr[i].delimiter) {
                        str2 = str2.substring(0, i2);
                    }
                }
            } else {
                str2 = str2 + str;
            }
            folderArr[i] = newIMAPFolder(str2, namespaceArr[i].delimiter, Boolean.valueOf(str == null));
        }
        return folderArr;
    }

    @Override // javax.mail.QuotaAwareStore
    public synchronized Quota[] getQuota(String str) throws MessagingException {
        Quota[] quotaRoot;
        checkConnected();
        try {
            try {
                try {
                    IMAPProtocol storeProtocol = getStoreProtocol();
                    quotaRoot = storeProtocol.getQuotaRoot(str);
                    releaseStoreProtocol(storeProtocol);
                } catch (BadCommandException e) {
                    throw new MessagingException("QUOTA not supported", e);
                }
            } catch (ConnectionException e2) {
                throw new StoreClosedException(this, e2.getMessage());
            }
        } catch (ProtocolException e3) {
            throw new MessagingException(e3.getMessage(), e3);
        }
        return quotaRoot;
    }

    @Override // javax.mail.QuotaAwareStore
    public synchronized void setQuota(Quota quota) throws MessagingException {
        checkConnected();
        try {
            try {
                try {
                    IMAPProtocol storeProtocol = getStoreProtocol();
                    storeProtocol.setQuota(quota);
                    releaseStoreProtocol(storeProtocol);
                } catch (BadCommandException e) {
                    throw new MessagingException("QUOTA not supported", e);
                }
            } catch (ConnectionException e2) {
                throw new StoreClosedException(this, e2.getMessage());
            }
        } catch (ProtocolException e3) {
            throw new MessagingException(e3.getMessage(), e3);
        }
    }

    private void checkConnected() {
        if (!super.isConnected()) {
            throw new IllegalStateException("Not connected");
        }
    }

    @Override // com.sun.mail.iap.ResponseHandler
    public void handleResponse(Response response) {
        if (response.isOK() || response.isNO() || response.isBAD() || response.isBYE()) {
            handleResponseCode(response);
        }
        if (response.isBYE()) {
            this.logger.fine("IMAPStore connection dead");
            synchronized (this.connectionFailedLock) {
                this.connectionFailed = true;
                if (response.isSynthetic()) {
                    this.forceClose = true;
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0052, code lost:
        if (r8.enableImapEvents == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0058, code lost:
        if (r3.isUnTagged() == false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x005a, code lost:
        notifyStoreListeners(1000, r3.toString());
     */
    /* JADX WARN: Removed duplicated region for block: B:102:0x00ed  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:54:0x0097 -> B:55:0x0098). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void idle() throws javax.mail.MessagingException {
        /*
            Method dump skipped, instructions count: 267
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.imap.IMAPStore.idle():void");
    }

    private void waitIfIdle() throws ProtocolException {
        while (this.pool.idleState != 0) {
            if (this.pool.idleState == 1) {
                this.pool.idleProtocol.idleAbort();
                this.pool.idleState = 2;
            }
            try {
                this.pool.wait();
            } catch (InterruptedException e) {
                throw new ProtocolException("Interrupted waitIfIdle", e);
            }
        }
    }

    public synchronized Map<String, String> id(Map<String, String> map) throws MessagingException {
        Map<String, String> id;
        checkConnected();
        try {
            try {
                try {
                    IMAPProtocol storeProtocol = getStoreProtocol();
                    id = storeProtocol.id(map);
                    releaseStoreProtocol(storeProtocol);
                } catch (BadCommandException e) {
                    throw new MessagingException("ID not supported", e);
                }
            } catch (ConnectionException e2) {
                throw new StoreClosedException(this, e2.getMessage());
            }
        } catch (ProtocolException e3) {
            throw new MessagingException(e3.getMessage(), e3);
        }
        return id;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void handleResponseCode(Response response) {
        if (this.enableResponseEvents) {
            notifyStoreListeners(1000, response.toString());
        }
        String rest = response.getRest();
        boolean z = false;
        if (rest.startsWith("[")) {
            int indexOf = rest.indexOf(93);
            if (indexOf > 0 && rest.substring(0, indexOf + 1).equalsIgnoreCase("[ALERT]")) {
                z = true;
            }
            rest = rest.substring(indexOf + 1).trim();
        }
        if (z) {
            notifyStoreListeners(1, rest);
        } else if (!response.isUnTagged() || rest.length() <= 0) {
        } else {
            notifyStoreListeners(2, rest);
        }
    }

    private String traceUser(String str) {
        return this.debugusername ? str : "<user name suppressed>";
    }

    private String tracePassword(String str) {
        return this.debugpassword ? str : str == null ? "<null>" : "<non-null>";
    }
}
