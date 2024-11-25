package javax.mail.event;
/* loaded from: classes2.dex */
public class ConnectionEvent extends MailEvent {
    public static final int CLOSED = 3;
    public static final int DISCONNECTED = 2;
    public static final int OPENED = 1;
    private static final long serialVersionUID = -1855480171284792957L;
    protected int type;

    public ConnectionEvent(Object obj, int i) {
        super(obj);
        this.type = i;
    }

    public int getType() {
        return this.type;
    }

    @Override // javax.mail.event.MailEvent
    public void dispatch(Object obj) {
        int i = this.type;
        if (i == 1) {
            ((ConnectionListener) obj).opened(this);
        } else if (i == 2) {
            ((ConnectionListener) obj).disconnected(this);
        } else if (i == 3) {
            ((ConnectionListener) obj).closed(this);
        }
    }
}
