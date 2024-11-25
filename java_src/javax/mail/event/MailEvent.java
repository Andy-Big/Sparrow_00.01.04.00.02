package javax.mail.event;

import java.util.EventObject;
/* loaded from: classes2.dex */
public abstract class MailEvent extends EventObject {
    private static final long serialVersionUID = 1846275636325456631L;

    public abstract void dispatch(Object obj);

    public MailEvent(Object obj) {
        super(obj);
    }
}
