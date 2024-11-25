package javax.mail.search;

import javax.mail.Address;
import javax.mail.Message;
/* loaded from: classes2.dex */
public final class FromTerm extends AddressTerm {
    private static final long serialVersionUID = 5214730291502658665L;

    public FromTerm(Address address) {
        super(address);
    }

    @Override // javax.mail.search.SearchTerm
    public boolean match(Message message) {
        Address[] from;
        try {
            from = message.getFrom();
        } catch (Exception unused) {
        }
        if (from == null) {
            return false;
        }
        for (Address address : from) {
            if (super.match(address)) {
                return true;
            }
        }
        return false;
    }

    @Override // javax.mail.search.AddressTerm
    public boolean equals(Object obj) {
        if (obj instanceof FromTerm) {
            return super.equals(obj);
        }
        return false;
    }
}
