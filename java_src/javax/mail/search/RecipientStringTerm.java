package javax.mail.search;

import javax.mail.Address;
import javax.mail.Message;
/* loaded from: classes2.dex */
public final class RecipientStringTerm extends AddressStringTerm {
    private static final long serialVersionUID = -8293562089611618849L;
    private Message.RecipientType type;

    public RecipientStringTerm(Message.RecipientType recipientType, String str) {
        super(str);
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

    @Override // javax.mail.search.AddressStringTerm, javax.mail.search.StringTerm
    public boolean equals(Object obj) {
        return (obj instanceof RecipientStringTerm) && ((RecipientStringTerm) obj).type.equals(this.type) && super.equals(obj);
    }

    @Override // javax.mail.search.StringTerm
    public int hashCode() {
        return this.type.hashCode() + super.hashCode();
    }
}
