package javax.mail.internet;

import com.sun.mail.util.PropUtil;
import javax.mail.internet.HeaderTokenizer;
/* loaded from: classes2.dex */
public class ContentDisposition {
    private static final boolean contentDispositionStrict = PropUtil.getBooleanSystemProperty("mail.mime.contentdisposition.strict", true);
    private String disposition;
    private ParameterList list;

    public ContentDisposition() {
    }

    public ContentDisposition(String str, ParameterList parameterList) {
        this.disposition = str;
        this.list = parameterList;
    }

    public ContentDisposition(String str) throws ParseException {
        HeaderTokenizer headerTokenizer = new HeaderTokenizer(str, HeaderTokenizer.MIME);
        HeaderTokenizer.Token next = headerTokenizer.next();
        if (next.getType() != -1) {
            if (contentDispositionStrict) {
                throw new ParseException("Expected disposition, got " + next.getValue());
            }
        } else {
            this.disposition = next.getValue();
        }
        String remainder = headerTokenizer.getRemainder();
        if (remainder != null) {
            try {
                this.list = new ParameterList(remainder);
            } catch (ParseException e) {
                if (contentDispositionStrict) {
                    throw e;
                }
            }
        }
    }

    public String getDisposition() {
        return this.disposition;
    }

    public String getParameter(String str) {
        ParameterList parameterList = this.list;
        if (parameterList == null) {
            return null;
        }
        return parameterList.get(str);
    }

    public ParameterList getParameterList() {
        return this.list;
    }

    public void setDisposition(String str) {
        this.disposition = str;
    }

    public void setParameter(String str, String str2) {
        if (this.list == null) {
            this.list = new ParameterList();
        }
        this.list.set(str, str2);
    }

    public void setParameterList(ParameterList parameterList) {
        this.list = parameterList;
    }

    public String toString() {
        String str = this.disposition;
        if (str == null) {
            return "";
        }
        if (this.list == null) {
            return str;
        }
        StringBuilder sb = new StringBuilder(this.disposition);
        sb.append(this.list.toString(sb.length() + 21));
        return sb.toString();
    }
}
