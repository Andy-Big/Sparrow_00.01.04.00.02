package javax.mail.search;

import java.util.Locale;
import javax.mail.Message;
/* loaded from: classes2.dex */
public final class HeaderTerm extends StringTerm {
    private static final long serialVersionUID = 8342514650333389122L;
    private String headerName;

    public HeaderTerm(String str, String str2) {
        super(str2);
        this.headerName = str;
    }

    public String getHeaderName() {
        return this.headerName;
    }

    @Override // javax.mail.search.SearchTerm
    public boolean match(Message message) {
        String[] header;
        try {
            header = message.getHeader(this.headerName);
        } catch (Exception unused) {
        }
        if (header == null) {
            return false;
        }
        for (String str : header) {
            if (super.match(str)) {
                return true;
            }
        }
        return false;
    }

    @Override // javax.mail.search.StringTerm
    public boolean equals(Object obj) {
        if (obj instanceof HeaderTerm) {
            HeaderTerm headerTerm = (HeaderTerm) obj;
            return headerTerm.headerName.equalsIgnoreCase(this.headerName) && super.equals(headerTerm);
        }
        return false;
    }

    @Override // javax.mail.search.StringTerm
    public int hashCode() {
        return this.headerName.toLowerCase(Locale.ENGLISH).hashCode() + super.hashCode();
    }
}
