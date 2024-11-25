package javax.mail.search;

import javax.mail.Message;
/* loaded from: classes2.dex */
public final class MessageNumberTerm extends IntegerComparisonTerm {
    private static final long serialVersionUID = -5379625829658623812L;

    public MessageNumberTerm(int i) {
        super(3, i);
    }

    @Override // javax.mail.search.SearchTerm
    public boolean match(Message message) {
        try {
            return super.match(message.getMessageNumber());
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // javax.mail.search.IntegerComparisonTerm, javax.mail.search.ComparisonTerm
    public boolean equals(Object obj) {
        if (obj instanceof MessageNumberTerm) {
            return super.equals(obj);
        }
        return false;
    }
}
