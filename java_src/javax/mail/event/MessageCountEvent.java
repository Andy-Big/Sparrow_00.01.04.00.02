package javax.mail.event;

import javax.mail.Folder;
import javax.mail.Message;
/* loaded from: classes2.dex */
public class MessageCountEvent extends MailEvent {
    public static final int ADDED = 1;
    public static final int REMOVED = 2;
    private static final long serialVersionUID = -7447022340837897369L;
    protected transient Message[] msgs;
    protected boolean removed;
    protected int type;

    public MessageCountEvent(Folder folder, int i, boolean z, Message[] messageArr) {
        super(folder);
        this.type = i;
        this.removed = z;
        this.msgs = messageArr;
    }

    public int getType() {
        return this.type;
    }

    public boolean isRemoved() {
        return this.removed;
    }

    public Message[] getMessages() {
        return this.msgs;
    }

    @Override // javax.mail.event.MailEvent
    public void dispatch(Object obj) {
        if (this.type == 1) {
            ((MessageCountListener) obj).messagesAdded(this);
        } else {
            ((MessageCountListener) obj).messagesRemoved(this);
        }
    }
}
