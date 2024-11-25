package javax.mail.event;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Transport;
/* loaded from: classes2.dex */
public class TransportEvent extends MailEvent {
    public static final int MESSAGE_DELIVERED = 1;
    public static final int MESSAGE_NOT_DELIVERED = 2;
    public static final int MESSAGE_PARTIALLY_DELIVERED = 3;
    private static final long serialVersionUID = -4729852364684273073L;
    protected transient Address[] invalid;
    protected transient Message msg;
    protected int type;
    protected transient Address[] validSent;
    protected transient Address[] validUnsent;

    public TransportEvent(Transport transport, int i, Address[] addressArr, Address[] addressArr2, Address[] addressArr3, Message message) {
        super(transport);
        this.type = i;
        this.validSent = addressArr;
        this.validUnsent = addressArr2;
        this.invalid = addressArr3;
        this.msg = message;
    }

    public int getType() {
        return this.type;
    }

    public Address[] getValidSentAddresses() {
        return this.validSent;
    }

    public Address[] getValidUnsentAddresses() {
        return this.validUnsent;
    }

    public Address[] getInvalidAddresses() {
        return this.invalid;
    }

    public Message getMessage() {
        return this.msg;
    }

    @Override // javax.mail.event.MailEvent
    public void dispatch(Object obj) {
        int i = this.type;
        if (i == 1) {
            ((TransportListener) obj).messageDelivered(this);
        } else if (i == 2) {
            ((TransportListener) obj).messageNotDelivered(this);
        } else {
            ((TransportListener) obj).messagePartiallyDelivered(this);
        }
    }
}
