package javax.mail.event;

import javax.mail.Message;
/* loaded from: classes2.dex */
public class MessageChangedEvent extends MailEvent {
    public static final int ENVELOPE_CHANGED = 2;
    public static final int FLAGS_CHANGED = 1;
    private static final long serialVersionUID = -4974972972105535108L;
    protected transient Message msg;
    protected int type;

    public MessageChangedEvent(Object obj, int i, Message message) {
        super(obj);
        this.msg = message;
        this.type = i;
    }

    public int getMessageChangeType() {
        return this.type;
    }

    public Message getMessage() {
        return this.msg;
    }

    @Override // javax.mail.event.MailEvent
    public void dispatch(Object obj) {
        ((MessageChangedListener) obj).messageChanged(this);
    }
}
