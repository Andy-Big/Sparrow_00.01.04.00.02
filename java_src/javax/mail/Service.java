package javax.mail;

import java.util.EventListener;
import java.util.Vector;
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

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00d5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public Service(javax.mail.Session r10, javax.mail.URLName r11) {
        /*
            Method dump skipped, instructions count: 236
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.mail.Service.<init>(javax.mail.Session, javax.mail.URLName):void");
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
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void connect(java.lang.String r18, int r19, java.lang.String r20, java.lang.String r21) throws javax.mail.MessagingException {
        /*
            Method dump skipped, instructions count: 395
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.mail.Service.connect(java.lang.String, int, java.lang.String, java.lang.String):void");
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

    /* JADX INFO: Access modifiers changed from: protected */
    public void queueEvent(MailEvent mailEvent, Vector<? extends EventListener> vector) {
        this.q.enqueue(mailEvent, (Vector) vector.clone());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void finalize() throws Throwable {
        try {
            this.q.terminateQueue();
        } finally {
            super.finalize();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Session getSession() {
        return this.session;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public EventQueue getEventQueue() {
        return this.q;
    }
}
