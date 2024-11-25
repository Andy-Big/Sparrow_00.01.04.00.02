package javax.mail.internet;

import javax.mail.internet.HeaderTokenizer;
import org.slf4j.Marker;
/* loaded from: classes2.dex */
public class ContentType {
    private ParameterList list;
    private String primaryType;
    private String subType;

    public ContentType() {
    }

    public ContentType(String str, String str2, ParameterList parameterList) {
        this.primaryType = str;
        this.subType = str2;
        this.list = parameterList;
    }

    public ContentType(String str) throws ParseException {
        HeaderTokenizer headerTokenizer = new HeaderTokenizer(str, HeaderTokenizer.MIME);
        HeaderTokenizer.Token next = headerTokenizer.next();
        if (next.getType() != -1) {
            throw new ParseException("In Content-Type string <" + str + ">, expected MIME type, got " + next.getValue());
        }
        this.primaryType = next.getValue();
        HeaderTokenizer.Token next2 = headerTokenizer.next();
        if (((char) next2.getType()) != '/') {
            throw new ParseException("In Content-Type string <" + str + ">, expected '/', got " + next2.getValue());
        }
        HeaderTokenizer.Token next3 = headerTokenizer.next();
        if (next3.getType() != -1) {
            throw new ParseException("In Content-Type string <" + str + ">, expected MIME subtype, got " + next3.getValue());
        }
        this.subType = next3.getValue();
        String remainder = headerTokenizer.getRemainder();
        if (remainder != null) {
            this.list = new ParameterList(remainder);
        }
    }

    public String getPrimaryType() {
        return this.primaryType;
    }

    public String getSubType() {
        return this.subType;
    }

    public String getBaseType() {
        if (this.primaryType == null || this.subType == null) {
            return "";
        }
        return this.primaryType + '/' + this.subType;
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

    public void setPrimaryType(String str) {
        this.primaryType = str;
    }

    public void setSubType(String str) {
        this.subType = str;
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
        if (this.primaryType == null || this.subType == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.primaryType);
        sb.append('/');
        sb.append(this.subType);
        ParameterList parameterList = this.list;
        if (parameterList != null) {
            sb.append(parameterList.toString(sb.length() + 14));
        }
        return sb.toString();
    }

    public boolean match(ContentType contentType) {
        String str;
        String str2;
        if (!(this.primaryType == null && contentType.getPrimaryType() == null) && ((str = this.primaryType) == null || !str.equalsIgnoreCase(contentType.getPrimaryType()))) {
            return false;
        }
        String subType = contentType.getSubType();
        String str3 = this.subType;
        if ((str3 == null || !str3.startsWith(Marker.ANY_MARKER)) && (subType == null || !subType.startsWith(Marker.ANY_MARKER))) {
            return (this.subType == null && subType == null) || ((str2 = this.subType) != null && str2.equalsIgnoreCase(subType));
        }
        return true;
    }

    public boolean match(String str) {
        try {
            return match(new ContentType(str));
        } catch (ParseException unused) {
            return false;
        }
    }
}
