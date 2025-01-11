package javax.mail.internet;

import com.sun.mail.util.PropUtil;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Locale;
import java.util.StringTokenizer;
import javax.mail.Address;
import javax.mail.Session;
import kotlin.jvm.internal.CharCompanionObject;
import kotlin.text.Typography;

/* loaded from: classes2.dex */
public class InternetAddress extends Address implements Cloneable {
    private static final long serialVersionUID = -7507595530758302903L;
    private static final String specialsNoDot = "()<>,;:\\\"[]@";
    private static final String specialsNoDotNoAt = "()<>,;:\\\"[]";
    protected String address;
    protected String encodedPersonal;
    protected String personal;
    private static final boolean ignoreBogusGroupName = PropUtil.getBooleanSystemProperty("mail.mime.address.ignorebogusgroupname", true);
    private static final boolean useCanonicalHostName = PropUtil.getBooleanSystemProperty("mail.mime.address.usecanonicalhostname", true);
    private static final boolean allowUtf8 = PropUtil.getBooleanSystemProperty("mail.mime.allowutf8", false);
    private static final String rfc822phrase = HeaderTokenizer.RFC822.replace(' ', (char) 0).replace('\t', (char) 0);

    @Override // javax.mail.Address
    public String getType() {
        return "rfc822";
    }

    public InternetAddress() {
    }

    public InternetAddress(String str) throws AddressException {
        InternetAddress[] parse = parse(str, true);
        if (parse.length != 1) {
            throw new AddressException("Illegal address", str);
        }
        this.address = parse[0].address;
        this.personal = parse[0].personal;
        this.encodedPersonal = parse[0].encodedPersonal;
    }

    public InternetAddress(String str, boolean z) throws AddressException {
        this(str);
        if (z) {
            if (isGroup()) {
                getGroup(true);
            } else {
                checkAddress(this.address, true, true);
            }
        }
    }

    public InternetAddress(String str, String str2) throws UnsupportedEncodingException {
        this(str, str2, null);
    }

    public InternetAddress(String str, String str2, String str3) throws UnsupportedEncodingException {
        this.address = str;
        setPersonal(str2, str3);
    }

    public Object clone() {
        try {
            return (InternetAddress) super.clone();
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public void setPersonal(String str, String str2) throws UnsupportedEncodingException {
        this.personal = str;
        if (str != null) {
            this.encodedPersonal = MimeUtility.encodeWord(str, str2, null);
        } else {
            this.encodedPersonal = null;
        }
    }

    public void setPersonal(String str) throws UnsupportedEncodingException {
        this.personal = str;
        if (str != null) {
            this.encodedPersonal = MimeUtility.encodeWord(str);
        } else {
            this.encodedPersonal = null;
        }
    }

    public String getAddress() {
        return this.address;
    }

    public String getPersonal() {
        String str = this.personal;
        if (str != null) {
            return str;
        }
        String str2 = this.encodedPersonal;
        if (str2 != null) {
            try {
                String decodeText = MimeUtility.decodeText(str2);
                this.personal = decodeText;
                return decodeText;
            } catch (Exception unused) {
                return this.encodedPersonal;
            }
        }
        return null;
    }

    @Override // javax.mail.Address
    public String toString() {
        String str;
        String str2 = this.address;
        if (str2 == null) {
            str2 = "";
        }
        if (this.encodedPersonal == null && (str = this.personal) != null) {
            try {
                this.encodedPersonal = MimeUtility.encodeWord(str);
            } catch (UnsupportedEncodingException unused) {
            }
        }
        if (this.encodedPersonal != null) {
            return quotePhrase(this.encodedPersonal) + " <" + str2 + ">";
        } else if (isGroup() || isSimple()) {
            return str2;
        } else {
            return "<" + str2 + ">";
        }
    }

    public String toUnicodeString() {
        String personal = getPersonal();
        if (personal != null) {
            return quotePhrase(personal) + " <" + this.address + ">";
        } else if (isGroup() || isSimple()) {
            return this.address;
        } else {
            return "<" + this.address + ">";
        }
    }

    private static String quotePhrase(String str) {
        int length = str.length();
        boolean z = false;
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt == '\"' || charAt == '\\') {
                StringBuilder sb = new StringBuilder(length + 3);
                sb.append(Typography.quote);
                for (int i2 = 0; i2 < length; i2++) {
                    char charAt2 = str.charAt(i2);
                    if (charAt2 == '\"' || charAt2 == '\\') {
                        sb.append('\\');
                    }
                    sb.append(charAt2);
                }
                sb.append(Typography.quote);
                return sb.toString();
            }
            if ((charAt < ' ' && charAt != '\r' && charAt != '\n' && charAt != '\t') || ((charAt >= 127 && !allowUtf8) || rfc822phrase.indexOf(charAt) >= 0)) {
                z = true;
            }
        }
        if (z) {
            StringBuilder sb2 = new StringBuilder(length + 2);
            sb2.append(Typography.quote);
            sb2.append(str);
            sb2.append(Typography.quote);
            return sb2.toString();
        }
        return str;
    }

    private static String unquote(String str) {
        if (str.startsWith("\"") && str.endsWith("\"") && str.length() > 1) {
            String substring = str.substring(1, str.length() - 1);
            if (substring.indexOf(92) >= 0) {
                StringBuilder sb = new StringBuilder(substring.length());
                int i = 0;
                while (i < substring.length()) {
                    char charAt = substring.charAt(i);
                    if (charAt == '\\' && i < substring.length() - 1) {
                        i++;
                        charAt = substring.charAt(i);
                    }
                    sb.append(charAt);
                    i++;
                }
                return sb.toString();
            }
            return substring;
        }
        return str;
    }

    @Override // javax.mail.Address
    public boolean equals(Object obj) {
        if (obj instanceof InternetAddress) {
            String address = ((InternetAddress) obj).getAddress();
            String str = this.address;
            if (address == str) {
                return true;
            }
            return str != null && str.equalsIgnoreCase(address);
        }
        return false;
    }

    public int hashCode() {
        String str = this.address;
        if (str == null) {
            return 0;
        }
        return str.toLowerCase(Locale.ENGLISH).hashCode();
    }

    public static String toString(Address[] addressArr) {
        return toString(addressArr, 0);
    }

    public static String toUnicodeString(Address[] addressArr) {
        return toUnicodeString(addressArr, 0);
    }

    public static String toString(Address[] addressArr, int i) {
        if (addressArr == null || addressArr.length == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < addressArr.length; i2++) {
            if (i2 != 0) {
                sb.append(", ");
                i += 2;
            }
            String fold = MimeUtility.fold(0, addressArr[i2].toString());
            if (lengthOfFirstSegment(fold) + i > 76) {
                int length = sb.length();
                if (length > 0) {
                    int i3 = length - 1;
                    if (sb.charAt(i3) == ' ') {
                        sb.setLength(i3);
                    }
                }
                sb.append("\r\n\t");
                i = 8;
            }
            sb.append(fold);
            i = lengthOfLastSegment(fold, i);
        }
        return sb.toString();
    }

    public static String toUnicodeString(Address[] addressArr, int i) {
        if (addressArr == null || addressArr.length == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        for (int i2 = 0; i2 < addressArr.length; i2++) {
            if (i2 != 0) {
                sb.append(", ");
                i += 2;
            }
            String unicodeString = ((InternetAddress) addressArr[i2]).toUnicodeString();
            if (MimeUtility.checkAscii(unicodeString) != 1) {
                unicodeString = new String(unicodeString.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1);
                z = true;
            }
            String fold = MimeUtility.fold(0, unicodeString);
            if (lengthOfFirstSegment(fold) + i > 76) {
                int length = sb.length();
                if (length > 0) {
                    int i3 = length - 1;
                    if (sb.charAt(i3) == ' ') {
                        sb.setLength(i3);
                    }
                }
                sb.append("\r\n\t");
                i = 8;
            }
            sb.append(fold);
            i = lengthOfLastSegment(fold, i);
        }
        String sb2 = sb.toString();
        return z ? new String(sb2.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8) : sb2;
    }

    private static int lengthOfFirstSegment(String str) {
        int indexOf = str.indexOf("\r\n");
        return indexOf != -1 ? indexOf : str.length();
    }

    private static int lengthOfLastSegment(String str, int i) {
        int lastIndexOf = str.lastIndexOf("\r\n");
        if (lastIndexOf != -1) {
            return (str.length() - lastIndexOf) - 2;
        }
        return str.length() + i;
    }

    public static InternetAddress getLocalAddress(Session session) {
        try {
            return _getLocalAddress(session);
        } catch (SecurityException | UnknownHostException | AddressException unused) {
            return null;
        }
    }

    static InternetAddress _getLocalAddress(Session session) throws SecurityException, AddressException, UnknownHostException {
        String property;
        String str;
        String str2;
        if (session == null) {
            str = System.getProperty("user.name");
            str2 = getLocalHostName();
            property = null;
        } else {
            property = session.getProperty("mail.from");
            if (property == null) {
                String property2 = session.getProperty("mail.user");
                if (property2 == null || property2.length() == 0) {
                    property2 = session.getProperty("user.name");
                }
                String property3 = (property2 == null || property2.length() == 0) ? System.getProperty("user.name") : property2;
                String property4 = session.getProperty("mail.host");
                if (property4 == null || property4.length() == 0) {
                    property4 = getLocalHostName();
                }
                String str3 = property3;
                str2 = property4;
                str = str3;
            } else {
                str = null;
                str2 = null;
            }
        }
        if (property == null && str != null && str.length() != 0 && str2 != null && str2.length() != 0) {
            property = MimeUtility.quote(str.trim(), "()<>,;:\\\"[]@\t ") + "@" + str2;
        }
        if (property == null) {
            return null;
        }
        return new InternetAddress(property);
    }

    private static String getLocalHostName() throws UnknownHostException {
        InetAddress localHost = InetAddress.getLocalHost();
        if (localHost != null) {
            String canonicalHostName = useCanonicalHostName ? localHost.getCanonicalHostName() : null;
            if (canonicalHostName == null) {
                canonicalHostName = localHost.getHostName();
            }
            if (canonicalHostName == null) {
                canonicalHostName = localHost.getHostAddress();
            }
            if (canonicalHostName == null || canonicalHostName.length() <= 0 || !isInetAddressLiteral(canonicalHostName)) {
                return canonicalHostName;
            }
            return '[' + canonicalHostName + ']';
        }
        return null;
    }

    private static boolean isInetAddressLiteral(String str) {
        boolean z = false;
        boolean z2 = false;
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if ((charAt < '0' || charAt > '9') && charAt != '.') {
                if ((charAt >= 'a' && charAt <= 'z') || (charAt >= 'A' && charAt <= 'Z')) {
                    z = true;
                } else if (charAt != ':') {
                    return false;
                } else {
                    z2 = true;
                }
            }
        }
        return !z || z2;
    }

    public static InternetAddress[] parse(String str) throws AddressException {
        return parse(str, true);
    }

    public static InternetAddress[] parse(String str, boolean z) throws AddressException {
        return parse(str, z, false);
    }

    public static InternetAddress[] parseHeader(String str, boolean z) throws AddressException {
        return parse(MimeUtility.unfold(str), z, true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:160:0x01e8, code lost:
        if (r8 == (-1)) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:211:0x0267, code lost:
        if (r8 == (-1)) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:228:0x02a7, code lost:
        if (r3.trim().length() == 0) goto L273;
     */
    /* JADX WARN: Code restructure failed: missing block: B:287:0x0362, code lost:
        if (r0.trim().length() == 0) goto L331;
     */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x032a  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x0333  */
    /* JADX WARN: Removed duplicated region for block: B:335:0x00c3 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0102  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static InternetAddress[] parse(String str, boolean z, boolean z2) throws AddressException {
        String str2;
        int i;
        String str3;
        int i2;
        int i3;
        int i4;
        int i5;
        boolean z3;
        int i6;
        int i7;
        int i8;
        int i9;
        int length = str.length();
        boolean z4 = z2 && !z;
        ArrayList arrayList = new ArrayList();
        int i10 = 0;
        int i11 = -1;
        int i12 = -1;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        int i13 = -1;
        int i14 = -1;
        while (i10 < length) {
            char charAt = str.charAt(i10);
            if (charAt != '\t' && charAt != '\n' && charAt != '\r' && charAt != ' ') {
                if (charAt != '\"') {
                    if (charAt != ',') {
                        if (charAt != '>') {
                            if (charAt != '[') {
                                char c = '(';
                                if (charAt == '(') {
                                    if (i11 >= 0 && i12 == -1) {
                                        i12 = i10;
                                    }
                                    i10++;
                                    int i15 = i10;
                                    int i16 = 1;
                                    while (i15 < length && i16 > 0) {
                                        char charAt2 = str.charAt(i15);
                                        if (charAt2 == c) {
                                            i16++;
                                        } else if (charAt2 == ')') {
                                            i16--;
                                        } else if (charAt2 == '\\') {
                                            i15++;
                                        }
                                        i15++;
                                        c = '(';
                                    }
                                    if (i16 <= 0) {
                                        i2 = i15 - 1;
                                        if (i13 == -1) {
                                            i13 = i10;
                                        }
                                        if (i14 == -1) {
                                            i10 = i2;
                                            i14 = i10;
                                        }
                                        i10 = i2;
                                    } else if (!z4) {
                                        throw new AddressException("Missing ')'", str, i15);
                                    }
                                } else if (charAt != ')') {
                                    switch (charAt) {
                                        case ':':
                                            if (!z5 || z4) {
                                                if (i11 == -1) {
                                                    i11 = i10;
                                                }
                                                if (!z2 || z) {
                                                    i = 1;
                                                    z5 = true;
                                                    z7 = true;
                                                    break;
                                                } else {
                                                    int i17 = i10 + 1;
                                                    if (i17 < length) {
                                                        char charAt3 = str.charAt(i17);
                                                        if (")>[]:@\\,.".indexOf(charAt3) >= 0) {
                                                            if (charAt3 == '@') {
                                                                for (int i18 = i10 + 2; i18 < length && (charAt3 = str.charAt(i18)) != ';' && ")>[]:@\\,.".indexOf(charAt3) < 0; i18++) {
                                                                }
                                                            }
                                                        }
                                                    }
                                                    String substring = str.substring(i11, i10);
                                                    if (!ignoreBogusGroupName || (!substring.equalsIgnoreCase("mailto") && !substring.equalsIgnoreCase("From") && !substring.equalsIgnoreCase("To") && !substring.equalsIgnoreCase("Cc") && !substring.equalsIgnoreCase("Subject") && !substring.equalsIgnoreCase("Re"))) {
                                                        z5 = true;
                                                        break;
                                                    } else {
                                                        i11 = -1;
                                                        break;
                                                    }
                                                }
                                            } else {
                                                throw new AddressException("Nested group", str, i10);
                                            }
                                            break;
                                        case ';':
                                            if (i11 == -1) {
                                                i = 1;
                                                i11 = -1;
                                                i12 = -1;
                                                z6 = false;
                                                z7 = false;
                                                break;
                                            } else if (z5) {
                                                if (!z2 || z || (i3 = i10 + 1) >= length || str.charAt(i3) != '@') {
                                                    InternetAddress internetAddress = new InternetAddress();
                                                    internetAddress.setAddress(str.substring(i11, i10 + 1).trim());
                                                    arrayList.add(internetAddress);
                                                    i = 1;
                                                    i11 = -1;
                                                    i12 = -1;
                                                    z5 = false;
                                                    z6 = false;
                                                    z7 = false;
                                                    i13 = -1;
                                                    i14 = -1;
                                                    break;
                                                } else {
                                                    i = 1;
                                                    z5 = false;
                                                    break;
                                                }
                                            } else if (!z4) {
                                                throw new AddressException("Illegal semicolon, not in group", str, i10);
                                            }
                                            break;
                                        case '<':
                                            if (z6) {
                                                if (!z4) {
                                                    throw new AddressException("Extra route-addr", str, i10);
                                                }
                                                if (i11 == -1) {
                                                    i11 = -1;
                                                    i12 = i11;
                                                    i = 1;
                                                    z6 = false;
                                                    z7 = false;
                                                    break;
                                                } else if (!z5) {
                                                    if (i12 == -1) {
                                                        i12 = i10;
                                                    }
                                                    String trim = str.substring(i11, i12).trim();
                                                    InternetAddress internetAddress2 = new InternetAddress();
                                                    internetAddress2.setAddress(trim);
                                                    if (i13 >= 0) {
                                                        internetAddress2.encodedPersonal = unquote(str.substring(i13, i14).trim());
                                                    }
                                                    arrayList.add(internetAddress2);
                                                    i11 = -1;
                                                    i12 = -1;
                                                    z6 = false;
                                                    z7 = false;
                                                    i13 = -1;
                                                    i14 = -1;
                                                    i4 = i10 + 1;
                                                    i5 = i4;
                                                    z3 = false;
                                                    while (true) {
                                                        i6 = i4;
                                                        if (i5 >= length) {
                                                            char charAt4 = str.charAt(i5);
                                                            i7 = i12;
                                                            if (charAt4 == '\"') {
                                                                z3 = !z3;
                                                            } else if (charAt4 != '>') {
                                                                if (charAt4 == '\\') {
                                                                    i5++;
                                                                }
                                                            } else if (!z3) {
                                                            }
                                                            i5++;
                                                            i4 = i6;
                                                            i12 = i7;
                                                        } else {
                                                            i7 = i12;
                                                        }
                                                    }
                                                    if (z3) {
                                                        i12 = i5;
                                                    } else if (!z4) {
                                                        throw new AddressException("Missing '\"'", str, i5);
                                                    } else {
                                                        int i19 = i6;
                                                        while (i19 < length) {
                                                            char charAt5 = str.charAt(i19);
                                                            if (charAt5 == '\\') {
                                                                i19++;
                                                                i9 = 1;
                                                            } else if (charAt5 == '>') {
                                                                i12 = i19;
                                                            } else {
                                                                i9 = 1;
                                                            }
                                                            i19 += i9;
                                                        }
                                                        i12 = i19;
                                                    }
                                                    if (i12 >= length) {
                                                        if (z5) {
                                                            i8 = i11;
                                                        } else {
                                                            if (i11 < 0) {
                                                                i11 = i13;
                                                                i10 = i14;
                                                            }
                                                            i14 = i10;
                                                            i13 = i11;
                                                            i8 = i6;
                                                        }
                                                        i11 = i8;
                                                        i10 = i12;
                                                        i = 1;
                                                        z6 = true;
                                                        break;
                                                    } else if (z4) {
                                                        if (i11 == -1) {
                                                            i11 = i10;
                                                        }
                                                        i10 = i6;
                                                        i12 = i7;
                                                        break;
                                                    } else {
                                                        throw new AddressException("Missing '>'", str, i12);
                                                    }
                                                }
                                            }
                                            z7 = true;
                                            i4 = i10 + 1;
                                            i5 = i4;
                                            z3 = false;
                                            while (true) {
                                                i6 = i4;
                                                if (i5 >= length) {
                                                }
                                                i5++;
                                                i4 = i6;
                                                i12 = i7;
                                            }
                                            if (z3) {
                                            }
                                            if (i12 >= length) {
                                            }
                                        default:
                                            if (i11 == -1) {
                                                i11 = i10;
                                                break;
                                            }
                                            break;
                                    }
                                } else if (!z4) {
                                    throw new AddressException("Missing '('", str, i10);
                                }
                            } else {
                                if (i11 == -1) {
                                    i11 = i10;
                                }
                                i10++;
                                i2 = i10;
                                while (i2 < length) {
                                    char charAt6 = str.charAt(i2);
                                    if (charAt6 == '\\') {
                                        i2++;
                                    } else if (charAt6 == ']') {
                                        if (i2 >= length) {
                                            if (!z4) {
                                                throw new AddressException("Missing ']'", str, i2);
                                            }
                                        }
                                        i10 = i2;
                                    }
                                    i2++;
                                }
                                if (i2 >= length) {
                                }
                                i10 = i2;
                            }
                        } else if (!z4) {
                            throw new AddressException("Missing '<'", str, i10);
                        }
                        i10 += i;
                    }
                    if (i11 == -1) {
                        i11 = -1;
                        i12 = i11;
                        i = 1;
                        z6 = false;
                        z7 = false;
                        i10 += i;
                    } else if (z5) {
                        i = 1;
                        z6 = false;
                        i10 += i;
                    } else {
                        if (i12 == -1) {
                            i12 = i10;
                        }
                        String trim2 = str.substring(i11, i12).trim();
                        if (z7 && i13 >= 0) {
                            str3 = unquote(str.substring(i13, i14).trim());
                        }
                        str3 = null;
                        if (z2 && !z && str3 != null && str3.indexOf(64) >= 0 && trim2.indexOf(64) < 0 && trim2.indexOf(33) < 0) {
                            String str4 = str3;
                            str3 = trim2;
                            trim2 = str4;
                        }
                        if (z7 || z || z2) {
                            if (!z4) {
                                checkAddress(trim2, z6, false);
                            }
                            InternetAddress internetAddress3 = new InternetAddress();
                            internetAddress3.setAddress(trim2);
                            if (str3 != null) {
                                internetAddress3.encodedPersonal = str3;
                            }
                            arrayList.add(internetAddress3);
                        } else {
                            StringTokenizer stringTokenizer = new StringTokenizer(trim2);
                            while (stringTokenizer.hasMoreTokens()) {
                                String nextToken = stringTokenizer.nextToken();
                                checkAddress(nextToken, false, false);
                                InternetAddress internetAddress4 = new InternetAddress();
                                internetAddress4.setAddress(nextToken);
                                arrayList.add(internetAddress4);
                            }
                        }
                        i = 1;
                        i11 = -1;
                        i12 = -1;
                        z6 = false;
                        z7 = false;
                        i13 = -1;
                        i14 = -1;
                        i10 += i;
                    }
                } else {
                    if (i11 == -1) {
                        i11 = i10;
                    }
                    i10++;
                    int i20 = i10;
                    while (i20 < length) {
                        char charAt7 = str.charAt(i20);
                        if (charAt7 != '\"') {
                            if (charAt7 == '\\') {
                                i20++;
                            }
                            i20++;
                        } else if (i20 >= length) {
                            i10 = i20;
                        } else if (!z4) {
                            throw new AddressException("Missing '\"'", str, i20);
                        }
                    }
                    if (i20 >= length) {
                    }
                }
                i = 1;
                z7 = true;
                i10 += i;
            }
            i = 1;
            i10 += i;
        }
        if (i11 >= 0) {
            if (i12 != -1) {
                length = i12;
            }
            String trim3 = str.substring(i11, length).trim();
            if (z7 && i13 >= 0) {
                str2 = unquote(str.substring(i13, i14).trim());
            }
            str2 = null;
            if (z2 && !z && str2 != null && str2.indexOf(64) >= 0 && trim3.indexOf(64) < 0 && trim3.indexOf(33) < 0) {
                trim3 = str2;
                str2 = trim3;
            }
            if (z7 || z || z2) {
                if (!z4) {
                    checkAddress(trim3, z6, false);
                }
                InternetAddress internetAddress5 = new InternetAddress();
                internetAddress5.setAddress(trim3);
                if (str2 != null) {
                    internetAddress5.encodedPersonal = str2;
                }
                arrayList.add(internetAddress5);
            } else {
                StringTokenizer stringTokenizer2 = new StringTokenizer(trim3);
                while (stringTokenizer2.hasMoreTokens()) {
                    String nextToken2 = stringTokenizer2.nextToken();
                    checkAddress(nextToken2, false, false);
                    InternetAddress internetAddress6 = new InternetAddress();
                    internetAddress6.setAddress(nextToken2);
                    arrayList.add(internetAddress6);
                }
            }
        }
        InternetAddress[] internetAddressArr = new InternetAddress[arrayList.size()];
        arrayList.toArray(internetAddressArr);
        return internetAddressArr;
    }

    public void validate() throws AddressException {
        if (isGroup()) {
            getGroup(true);
        } else {
            checkAddress(getAddress(), true, true);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0121, code lost:
        r8 = r8 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x0122, code lost:
        if (r8 >= r1) goto L143;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0128, code lost:
        if (r16.charAt(r8) == '.') goto L141;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x012a, code lost:
        r5 = false;
        r2 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x012c, code lost:
        if (r2 >= r1) goto L136;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x012e, code lost:
        r6 = r16.charAt(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0134, code lost:
        if (r6 != '[') goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0136, code lost:
        if (r2 != r8) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0138, code lost:
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x0141, code lost:
        throw new javax.mail.internet.AddressException("Domain literal not at start of domain", r16);
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x0144, code lost:
        if (r6 != ']') goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x0148, code lost:
        if (r2 != (r1 - 1)) goto L110;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x014a, code lost:
        r5 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x0153, code lost:
        throw new javax.mail.internet.AddressException("Domain literal end not at end of domain", r16);
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x0154, code lost:
        if (r6 <= ' ') goto L135;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x0156, code lost:
        if (r6 == 127) goto L132;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x0158, code lost:
        if (r5 != false) goto L131;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x015e, code lost:
        if (java.lang.Character.isLetterOrDigit(r6) != false) goto L124;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x0162, code lost:
        if (r6 == '-') goto L124;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x0164, code lost:
        if (r6 != '.') goto L121;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x016e, code lost:
        throw new javax.mail.internet.AddressException("Domain contains illegal character", r16);
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x016f, code lost:
        if (r6 != '.') goto L130;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x0171, code lost:
        if (r7 == '.') goto L126;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x017b, code lost:
        throw new javax.mail.internet.AddressException("Domain contains dot-dot", r16);
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x017c, code lost:
        r2 = r2 + 1;
        r7 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x0187, code lost:
        throw new javax.mail.internet.AddressException("Domain contains control or whitespace", r16);
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x0188, code lost:
        if (r7 == '.') goto L139;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x018a, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x0192, code lost:
        throw new javax.mail.internet.AddressException("Domain ends with dot", r16);
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x019a, code lost:
        throw new javax.mail.internet.AddressException("Domain starts with dot", r16);
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x01a2, code lost:
        throw new javax.mail.internet.AddressException("Missing domain", r16);
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x01aa, code lost:
        throw new javax.mail.internet.AddressException("Unterminated quote", r16);
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x010a, code lost:
        throw new javax.mail.internet.AddressException("Local address contains control or whitespace", r16);
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0112, code lost:
        if (r9 != false) goto L145;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0114, code lost:
        if (r6 == '@') goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0116, code lost:
        if (r18 != false) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0118, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0120, code lost:
        throw new javax.mail.internet.AddressException("Missing final '@domain'", r16);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void checkAddress(String str, boolean z, boolean z2) throws AddressException {
        int i;
        int i2;
        int i3;
        if (str == null) {
            throw new AddressException("Address is null");
        }
        int length = str.length();
        if (length == 0) {
            throw new AddressException("Empty address", str);
        }
        if (z && str.charAt(0) == '@') {
            i = 0;
            while (true) {
                int indexOfAny = indexOfAny(str, ",:", i);
                if (indexOfAny < 0) {
                    break;
                } else if (str.charAt(i) != '@') {
                    throw new AddressException("Illegal route-addr", str);
                } else {
                    if (str.charAt(indexOfAny) == ':') {
                        i = indexOfAny + 1;
                        break;
                    }
                    i = indexOfAny + 1;
                }
            }
        } else {
            i = 0;
        }
        char c = CharCompanionObject.MAX_VALUE;
        boolean z3 = false;
        int i4 = i;
        char c2 = 65535;
        while (true) {
            if (i4 >= length) {
                break;
            }
            char charAt = str.charAt(i4);
            if (charAt != '\\' && c != '\\') {
                if (charAt != '\"') {
                    if (charAt == '\r') {
                        int i5 = i4 + 1;
                        if (i5 < length && str.charAt(i5) != '\n') {
                            throw new AddressException("Quoted local address contains CR without LF", str);
                        }
                    } else if (charAt == '\n' && (i2 = i4 + 1) < length && str.charAt(i2) != ' ' && str.charAt(i2) != '\t') {
                        throw new AddressException("Quoted local address contains newline without whitespace", str);
                    }
                    if (z3) {
                        continue;
                    } else {
                        if (charAt == '.') {
                            if (i4 == i) {
                                throw new AddressException("Local address starts with dot", str);
                            }
                            if (c == '.') {
                                throw new AddressException("Local address contains dot-dot", str);
                            }
                        }
                        if (charAt == '@') {
                            if (i4 == 0) {
                                throw new AddressException("Missing local name", str);
                            }
                            if (c == '.') {
                                throw new AddressException("Local address ends with dot", str);
                            }
                            c2 = c;
                            c = charAt;
                        } else if (charAt <= ' ' || charAt == 127) {
                            break;
                        } else if (specialsNoDot.indexOf(charAt) >= 0) {
                            throw new AddressException("Local address contains illegal character", str);
                        }
                    }
                } else if (z3) {
                    if (z2 && (i3 = i4 + 1) < length && str.charAt(i3) != '@') {
                        throw new AddressException("Quote not at end of local address", str);
                    }
                    z3 = false;
                } else if (z2 && i4 != 0) {
                    throw new AddressException("Quote not at start of local address", str);
                } else {
                    z3 = true;
                }
            }
            i4++;
            c2 = c;
            c = charAt;
        }
    }

    private boolean isSimple() {
        String str = this.address;
        return str == null || indexOfAny(str, specialsNoDotNoAt) < 0;
    }

    public boolean isGroup() {
        String str = this.address;
        return str != null && str.endsWith(";") && this.address.indexOf(58) > 0;
    }

    public InternetAddress[] getGroup(boolean z) throws AddressException {
        int indexOf;
        String address = getAddress();
        if (address != null && address.endsWith(";") && (indexOf = address.indexOf(58)) >= 0) {
            return parseHeader(address.substring(indexOf + 1, address.length() - 1), z);
        }
        return null;
    }

    private static int indexOfAny(String str, String str2) {
        return indexOfAny(str, str2, 0);
    }

    private static int indexOfAny(String str, String str2, int i) {
        try {
            int length = str.length();
            while (i < length) {
                if (str2.indexOf(str.charAt(i)) >= 0) {
                    return i;
                }
                i++;
            }
        } catch (StringIndexOutOfBoundsException unused) {
        }
        return -1;
    }
}
