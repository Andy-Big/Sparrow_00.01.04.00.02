package javax.mail.search;

import java.util.Date;
import javax.mail.Message;
/* loaded from: classes2.dex */
public final class ReceivedDateTerm extends DateTerm {
    private static final long serialVersionUID = -2756695246195503170L;

    public ReceivedDateTerm(int i, Date date) {
        super(i, date);
    }

    @Override // javax.mail.search.SearchTerm
    public boolean match(Message message) {
        try {
            Date receivedDate = message.getReceivedDate();
            if (receivedDate == null) {
                return false;
            }
            return super.match(receivedDate);
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // javax.mail.search.DateTerm, javax.mail.search.ComparisonTerm
    public boolean equals(Object obj) {
        if (obj instanceof ReceivedDateTerm) {
            return super.equals(obj);
        }
        return false;
    }
}
