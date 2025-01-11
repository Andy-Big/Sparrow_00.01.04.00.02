package javax.mail;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.EventListener;
import java.util.Vector;
import java.util.concurrent.Executor;
import javax.mail.event.ConnectionEvent;
import javax.mail.event.ConnectionListener;
import javax.mail.event.MailEvent;

/* loaded from: classes2.dex */
public abstract class Service implements AutoCloseable {
    private boolean connected = false;
    private final Vector<ConnectionListener> connectionListeners = new Vector<>();
    protected boolean debug;
    private final EventQueue q;
    protected Session session;
    protected volatile URLName url;

    protected boolean protocolConnect(String str, int i, String str2, String str3) throws MessagingException {
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00d5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected Service(Session session, URLName uRLName) {
        String str;
        String str2;
        String str3;
        String str4;
        int i;
        String property;
        String property2;
        String str5 = null;
        this.url = null;
        this.debug = false;
        this.session = session;
        this.debug = session.getDebug();
        this.url = uRLName;
        if (this.url != null) {
            String protocol = this.url.getProtocol();
            String host = this.url.getHost();
            int port = this.url.getPort();
            str = this.url.getUsername();
            i = port;
            str4 = this.url.getPassword();
            str3 = this.url.getFile();
            str2 = protocol;
            str5 = host;
        } else {
            str = null;
            str2 = null;
            str3 = null;
            str4 = null;
            i = -1;
        }
        if (str2 != null) {
            if (str5 == null) {
                str5 = session.getProperty("mail." + str2 + ".host");
            }
            if (str == null) {
                str = session.getProperty("mail." + str2 + ".user");
            }
        }
        String property3 = str5 == null ? session.getProperty("mail.host") : str5;
        str = str == null ? session.getProperty("mail.user") : str;
        if (str == null) {
            try {
                property = System.getProperty("user.name");
            } catch (SecurityException unused) {
            }
            this.url = new URLName(str2, property3, i, str3, property, str4);
            property2 = session.getProperties().getProperty("mail.event.scope", "folder");
            Executor executor = (Executor) session.getProperties().get("mail.event.executor");
            if (!property2.equalsIgnoreCase("application")) {
                this.q = EventQueue.getApplicationEventQueue(executor);
                return;
            } else if (property2.equalsIgnoreCase("session")) {
                this.q = session.getEventQueue();
                return;
            } else {
                this.q = new EventQueue(executor);
                return;
            }
        }
        property = str;
        this.url = new URLName(str2, property3, i, str3, property, str4);
        property2 = session.getProperties().getProperty("mail.event.scope", "folder");
        Executor executor2 = (Executor) session.getProperties().get("mail.event.executor");
        if (!property2.equalsIgnoreCase("application")) {
        }
    }

    public void connect() throws MessagingException {
        connect(null, null, null);
    }

    public void connect(String str, String str2, String str3) throws MessagingException {
        connect(str, -1, str2, str3);
    }

    public void connect(String str, String str2) throws MessagingException {
        connect(null, str, str2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r17v0, resolved type: javax.mail.Service */
    /* JADX WARN: Can't wrap try/catch for region: R(14:6|(5:8|(1:10)(1:86)|11|(1:13)(1:85)|(4:15|(2:17|18)|80|18)(3:(2:84|18)|80|18))(1:87)|(2:(1:21)|(1:23))|(1:25)|(1:27)|(2:76|77)|29|(1:75)(2:33|(1:(1:36)(2:71|(1:73)))(6:74|38|39|40|(5:60|61|62|63|(1:65))|(1:(1:(1:(2:46|47)(2:49|50))(2:51|52))(1:53))(4:54|(1:56)|57|58)))|37|38|39|40|(0)|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0113, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0114, code lost:
        r16 = r0;
        r0 = false;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:65:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0159 A[Catch: all -> 0x0188, TryCatch #3 {, blocks: (B:4:0x0005, B:6:0x000b, B:8:0x000f, B:10:0x0017, B:14:0x0025, B:17:0x002f, B:19:0x0037, B:25:0x0055, B:29:0x006d, B:31:0x008b, B:33:0x00a9, B:35:0x00b3, B:37:0x00bd, B:40:0x00c6, B:42:0x00ca, B:45:0x00ec, B:53:0x010c, B:58:0x0119, B:61:0x0120, B:63:0x012c, B:68:0x0140, B:69:0x0147, B:70:0x0148, B:71:0x014f, B:72:0x0150, B:73:0x0157, B:74:0x0158, B:75:0x0159, B:77:0x016a, B:78:0x0178, B:46:0x00f5, B:48:0x00ff, B:21:0x0040, B:23:0x004c, B:81:0x0180, B:82:0x0187), top: B:93:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0119 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r15v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r15v7 */
    /* JADX WARN: Type inference failed for: r15v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void connect(String str, int i, String str2, String str3) throws MessagingException {
        String str4;
        String str5;
        int i2;
        String str6;
        String str7;
        boolean z;
        ?? r15;
        boolean z2;
        String str8;
        String str9;
        boolean z3;
        InetAddress inetAddress;
        String password;
        String str10 = str2;
        synchronized (this) {
            if (isConnected()) {
                throw new IllegalStateException("already connected");
            }
            if (this.url != null) {
                String protocol = this.url.getProtocol();
                str4 = str == null ? this.url.getHost() : str;
                int port = i == -1 ? this.url.getPort() : i;
                if (str10 == null) {
                    str10 = this.url.getUsername();
                    if (str3 == null) {
                        password = this.url.getPassword();
                        str6 = protocol;
                        i2 = port;
                        str5 = password;
                        str7 = this.url.getFile();
                    }
                    password = str3;
                    str6 = protocol;
                    i2 = port;
                    str5 = password;
                    str7 = this.url.getFile();
                } else {
                    if (str3 == null && str10.equals(this.url.getUsername())) {
                        password = this.url.getPassword();
                        str6 = protocol;
                        i2 = port;
                        str5 = password;
                        str7 = this.url.getFile();
                    }
                    password = str3;
                    str6 = protocol;
                    i2 = port;
                    str5 = password;
                    str7 = this.url.getFile();
                }
            } else {
                str4 = str;
                str5 = str3;
                i2 = i;
                str6 = null;
                str7 = null;
            }
            if (str6 != null) {
                if (str4 == null) {
                    str4 = this.session.getProperty("mail." + str6 + ".host");
                }
                if (str10 == null) {
                    str10 = this.session.getProperty("mail." + str6 + ".user");
                }
            }
            if (str4 == null) {
                str4 = this.session.getProperty("mail.host");
            }
            if (str10 == null) {
                str10 = this.session.getProperty("mail.user");
            }
            if (str10 == null) {
                try {
                    str10 = System.getProperty("user.name");
                } catch (SecurityException unused) {
                }
            }
            if (str5 != null || this.url == null) {
                z = true;
            } else {
                boolean z4 = true;
                setURLName(new URLName(str6, str4, i2, str7, str10, null));
                PasswordAuthentication passwordAuthentication = this.session.getPasswordAuthentication(getURLName());
                if (passwordAuthentication == null) {
                    str9 = str10;
                    str8 = str5;
                    z2 = true;
                    r15 = z4;
                    z3 = protocolConnect(str4, i2, str9, str8);
                    AuthenticationFailedException authenticationFailedException = null;
                    if (!z3) {
                        try {
                            inetAddress = InetAddress.getByName(str4);
                        } catch (UnknownHostException unused2) {
                            inetAddress = null;
                        }
                        PasswordAuthentication requestPasswordAuthentication = this.session.requestPasswordAuthentication(inetAddress, i2, str6, null, str9);
                        if (requestPasswordAuthentication != null) {
                            str9 = requestPasswordAuthentication.getUserName();
                            str8 = requestPasswordAuthentication.getPassword();
                            z3 = protocolConnect(str4, i2, str9, str8);
                        }
                    }
                    if (z3) {
                        if (authenticationFailedException != null) {
                            throw authenticationFailedException;
                        }
                        if (str9 == null) {
                            throw new AuthenticationFailedException("failed to connect, no user name specified?");
                        }
                        if (str8 == null) {
                            throw new AuthenticationFailedException("failed to connect, no password specified?");
                        }
                        throw new AuthenticationFailedException("failed to connect");
                    }
                    String str11 = str8;
                    setURLName(new URLName(str6, str4, i2, str7, str9, str8));
                    if (z2) {
                        this.session.setPasswordAuthentication(getURLName(), new PasswordAuthentication(str9, str11));
                    }
                    setConnected(r15);
                    notifyConnectionListeners(r15);
                } else if (str10 == null) {
                    str10 = passwordAuthentication.getUserName();
                    str5 = passwordAuthentication.getPassword();
                    z = z4;
                } else {
                    z = z4;
                    if (str10.equals(passwordAuthentication.getUserName())) {
                        str5 = passwordAuthentication.getPassword();
                        z = z4;
                    }
                }
            }
            str9 = str10;
            str8 = str5;
            z2 = false;
            r15 = z;
            z3 = protocolConnect(str4, i2, str9, str8);
            AuthenticationFailedException authenticationFailedException2 = null;
            if (!z3) {
            }
            if (z3) {
            }
        }
    }

    public synchronized boolean isConnected() {
        return this.connected;
    }

    protected synchronized void setConnected(boolean z) {
        this.connected = z;
    }

    @Override // java.lang.AutoCloseable
    public synchronized void close() throws MessagingException {
        setConnected(false);
        notifyConnectionListeners(3);
    }

    public URLName getURLName() {
        URLName uRLName = this.url;
        return (uRLName == null || (uRLName.getPassword() == null && uRLName.getFile() == null)) ? uRLName : new URLName(uRLName.getProtocol(), uRLName.getHost(), uRLName.getPort(), null, uRLName.getUsername(), null);
    }

    protected void setURLName(URLName uRLName) {
        this.url = uRLName;
    }

    public void addConnectionListener(ConnectionListener connectionListener) {
        this.connectionListeners.addElement(connectionListener);
    }

    public void removeConnectionListener(ConnectionListener connectionListener) {
        this.connectionListeners.removeElement(connectionListener);
    }

    protected void notifyConnectionListeners(int i) {
        if (this.connectionListeners.size() > 0) {
            queueEvent(new ConnectionEvent(this, i), this.connectionListeners);
        }
        if (i == 3) {
            this.q.terminateQueue();
        }
    }

    public String toString() {
        URLName uRLName = getURLName();
        if (uRLName != null) {
            return uRLName.toString();
        }
        return super.toString();
    }

    protected void queueEvent(MailEvent mailEvent, Vector<? extends EventListener> vector) {
        this.q.enqueue(mailEvent, (Vector) vector.clone());
    }

    protected void finalize() throws Throwable {
        try {
            this.q.terminateQueue();
        } finally {
            super.finalize();
        }
    }

    Session getSession() {
        return this.session;
    }

    EventQueue getEventQueue() {
        return this.q;
    }
}
