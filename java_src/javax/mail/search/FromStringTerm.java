package javax.mail.search;

import javax.mail.Address;
import javax.mail.Message;
/* loaded from: classes2.dex */
public final class FromStringTerm extends AddressStringTerm {
    private static final long serialVersionUID = 5801127523826772788L;

    public FromStringTerm(String str) {
        super(str);
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

    @Override // javax.mail.search.AddressStringTerm, javax.mail.search.StringTerm
    public boolean equals(Object obj) {
        if (obj instanceof FromStringTerm) {
            return super.equals(obj);
        }
        return false;
    }
}
