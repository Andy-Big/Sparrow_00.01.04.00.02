package javax.mail.search;

import javax.mail.Address;
import javax.mail.Message;
/* loaded from: classes2.dex */
public final class RecipientTerm extends AddressTerm {
    private static final long serialVersionUID = 6548700653122680468L;
    private Message.RecipientType type;

    public RecipientTerm(Message.RecipientType recipientType, Address address) {
        super(address);
        this.type = recipientType;
    }

    public Message.RecipientType getRecipientType() {
        return this.type;
    }

    @Override // javax.mail.search.SearchTerm
    public boolean match(Message message) {
        Address[] recipients;
        try {
            recipients = message.getRecipients(this.type);
        } catch (Exception unused) {
        }
        if (recipients == null) {
            return false;
        }
        for (Address address : recipients) {
            if (super.match(address)) {
                return true;
            }
        }
        return false;
    }

    @Override // javax.mail.search.AddressTerm
    public boolean equals(Object obj) {
        return (obj instanceof RecipientTerm) && ((RecipientTerm) obj).type.equals(this.type) && super.equals(obj);
    }

    @Override // javax.mail.search.AddressTerm
    public int hashCode() {
        return this.type.hashCode() + super.hashCode();
    }
}
