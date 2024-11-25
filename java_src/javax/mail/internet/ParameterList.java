package javax.mail.internet;

import com.sun.mail.util.ASCIIUtility;
import com.sun.mail.util.PropUtil;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.UByte;
import org.slf4j.Marker;
/* loaded from: classes2.dex */
public class ParameterList {
    private String lastName;
    private Map<String, Object> list;
    private Set<String> multisegmentNames;
    private Map<String, Object> slist;
    private static final boolean encodeParameters = PropUtil.getBooleanSystemProperty("mail.mime.encodeparameters", true);
    private static final boolean decodeParameters = PropUtil.getBooleanSystemProperty("mail.mime.decodeparameters", true);
    private static final boolean decodeParametersStrict = PropUtil.getBooleanSystemProperty("mail.mime.decodeparameters.strict", false);
    private static final boolean applehack = PropUtil.getBooleanSystemProperty("mail.mime.applefilenames", false);
    private static final boolean windowshack = PropUtil.getBooleanSystemProperty("mail.mime.windowsfilenames", false);
    private static final boolean parametersStrict = PropUtil.getBooleanSystemProperty("mail.mime.parameters.strict", true);
    private static final boolean splitLongParameters = PropUtil.getBooleanSystemProperty("mail.mime.splitlongparameters", true);
    private static final char[] hex = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class Value {
        String charset;
        String encodedValue;
        String value;

        private Value() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class LiteralValue {
        String value;

        private LiteralValue() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class MultiValue extends ArrayList<Object> {
        private static final long serialVersionUID = 699561094618751023L;
        String value;

        private MultiValue() {
        }
    }

    /* loaded from: classes2.dex */
    private static class ParamEnum implements Enumeration<String> {
        private Iterator<String> it;

        ParamEnum(Iterator<String> it) {
            this.it = it;
        }

        @Override // java.util.Enumeration
        public boolean hasMoreElements() {
            return this.it.hasNext();
        }

        @Override // java.util.Enumeration
        public String nextElement() {
            return this.it.next();
        }
    }

    public ParameterList() {
        this.list = new LinkedHashMap();
        this.lastName = null;
        if (decodeParameters) {
            this.multisegmentNames = new HashSet();
            this.slist = new HashMap();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0030, code lost:
        if (javax.mail.internet.ParameterList.decodeParameters == false) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0032, code lost:
        combineMultisegmentNames(false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0036, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x016d, code lost:
        throw new javax.mail.internet.ParseException("In parameter list <" + r12 + ">, expected ';', got \"" + r1.getValue() + "\"");
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:?, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public ParameterList(java.lang.String r12) throws javax.mail.internet.ParseException {
        /*
            Method dump skipped, instructions count: 366
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.mail.internet.ParameterList.<init>(java.lang.String):void");
    }

    public void combineSegments() {
        if (!decodeParameters || this.multisegmentNames.size() <= 0) {
            return;
        }
        try {
            combineMultisegmentNames(true);
        } catch (ParseException unused) {
        }
    }

    private void putEncodedName(String str, String str2) throws ParseException {
        Value value;
        int indexOf = str.indexOf(42);
        if (indexOf < 0) {
            this.list.put(str, str2);
        } else if (indexOf == str.length() - 1) {
            String substring = str.substring(0, indexOf);
            Value extractCharset = extractCharset(str2);
            try {
                extractCharset.value = decodeBytes(extractCharset.value, extractCharset.charset);
            } catch (UnsupportedEncodingException e) {
                if (decodeParametersStrict) {
                    throw new ParseException(e.toString());
                }
            }
            this.list.put(substring, extractCharset);
        } else {
            String substring2 = str.substring(0, indexOf);
            this.multisegmentNames.add(substring2);
            this.list.put(substring2, "");
            Value value2 = str2;
            if (str.endsWith(Marker.ANY_MARKER)) {
                if (str.endsWith("*0*")) {
                    value = extractCharset(str2);
                } else {
                    Value value3 = new Value();
                    Value value4 = value3;
                    value4.encodedValue = str2;
                    value4.value = str2;
                    value = value3;
                }
                str = str.substring(0, str.length() - 1);
                value2 = value;
            }
            this.slist.put(str, value2);
        }
    }

    private void combineMultisegmentNames(boolean z) throws ParseException {
        try {
            for (String str : this.multisegmentNames) {
                String str2 = null;
                MultiValue multiValue = new MultiValue();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                int i = 0;
                while (true) {
                    String str3 = str + Marker.ANY_MARKER + i;
                    Object obj = this.slist.get(str3);
                    if (obj == null) {
                        break;
                    }
                    multiValue.add(obj);
                    try {
                        if (obj instanceof Value) {
                            Value value = (Value) obj;
                            if (i == 0) {
                                str2 = value.charset;
                            } else if (str2 == null) {
                                this.multisegmentNames.remove(str);
                                break;
                            }
                            decodeBytes(value.value, byteArrayOutputStream);
                        } else {
                            byteArrayOutputStream.write(ASCIIUtility.getBytes((String) obj));
                        }
                    } catch (IOException unused) {
                    }
                    this.slist.remove(str3);
                    i++;
                }
                if (i == 0) {
                    this.list.remove(str);
                } else {
                    if (str2 != null) {
                        try {
                            str2 = MimeUtility.javaCharset(str2);
                        } catch (UnsupportedEncodingException e) {
                            if (decodeParametersStrict) {
                                throw new ParseException(e.toString());
                            }
                            try {
                                multiValue.value = byteArrayOutputStream.toString("iso-8859-1");
                            } catch (UnsupportedEncodingException unused2) {
                            }
                        }
                    }
                    if (str2 == null || str2.length() == 0) {
                        str2 = MimeUtility.getDefaultJavaCharset();
                    }
                    if (str2 != null) {
                        multiValue.value = byteArrayOutputStream.toString(str2);
                    } else {
                        multiValue.value = byteArrayOutputStream.toString();
                    }
                    this.list.put(str, multiValue);
                }
            }
            if (this.slist.size() > 0) {
                for (Object obj2 : this.slist.values()) {
                    if (obj2 instanceof Value) {
                        Value value2 = (Value) obj2;
                        try {
                            value2.value = decodeBytes(value2.value, value2.charset);
                        } catch (UnsupportedEncodingException e2) {
                            if (decodeParametersStrict) {
                                throw new ParseException(e2.toString());
                            }
                        }
                    }
                }
                this.list.putAll(this.slist);
            }
            this.multisegmentNames.clear();
            this.slist.clear();
        } catch (Throwable th) {
            if (z) {
                if (this.slist.size() > 0) {
                    for (Object obj3 : this.slist.values()) {
                        if (obj3 instanceof Value) {
                            Value value3 = (Value) obj3;
                            try {
                                value3.value = decodeBytes(value3.value, value3.charset);
                            } catch (UnsupportedEncodingException e3) {
                                if (decodeParametersStrict) {
                                    throw new ParseException(e3.toString());
                                }
                            }
                        }
                    }
                    this.list.putAll(this.slist);
                }
                this.multisegmentNames.clear();
                this.slist.clear();
            }
            throw th;
        }
    }

    public int size() {
        return this.list.size();
    }

    public String get(String str) {
        Object obj = this.list.get(str.trim().toLowerCase(Locale.ENGLISH));
        if (obj instanceof MultiValue) {
            return ((MultiValue) obj).value;
        }
        if (obj instanceof LiteralValue) {
            return ((LiteralValue) obj).value;
        }
        if (obj instanceof Value) {
            return ((Value) obj).value;
        }
        return (String) obj;
    }

    public void set(String str, String str2) {
        String lowerCase = str.trim().toLowerCase(Locale.ENGLISH);
        if (decodeParameters) {
            try {
                putEncodedName(lowerCase, str2);
                return;
            } catch (ParseException unused) {
                this.list.put(lowerCase, str2);
                return;
            }
        }
        this.list.put(lowerCase, str2);
    }

    public void set(String str, String str2, String str3) {
        if (encodeParameters) {
            Value encodeValue = encodeValue(str2, str3);
            if (encodeValue != null) {
                this.list.put(str.trim().toLowerCase(Locale.ENGLISH), encodeValue);
                return;
            } else {
                set(str, str2);
                return;
            }
        }
        set(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setLiteral(String str, String str2) {
        LiteralValue literalValue = new LiteralValue();
        literalValue.value = str2;
        this.list.put(str, literalValue);
    }

    public void remove(String str) {
        this.list.remove(str.trim().toLowerCase(Locale.ENGLISH));
    }

    public Enumeration<String> getNames() {
        return new ParamEnum(this.list.keySet().iterator());
    }

    public String toString() {
        return toString(0);
    }

    public String toString(int i) {
        String str;
        String str2;
        ToStringBuffer toStringBuffer = new ToStringBuffer(i);
        for (Map.Entry<String, Object> entry : this.list.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof MultiValue) {
                MultiValue multiValue = (MultiValue) value;
                String str3 = key + Marker.ANY_MARKER;
                for (int i2 = 0; i2 < multiValue.size(); i2++) {
                    Object obj = multiValue.get(i2);
                    if (obj instanceof Value) {
                        str = str3 + i2 + Marker.ANY_MARKER;
                        str2 = ((Value) obj).encodedValue;
                    } else {
                        str = str3 + i2;
                        str2 = (String) obj;
                    }
                    toStringBuffer.addNV(str, quote(str2));
                }
            } else if (value instanceof LiteralValue) {
                toStringBuffer.addNV(key, quote(((LiteralValue) value).value));
            } else if (value instanceof Value) {
                toStringBuffer.addNV(key + Marker.ANY_MARKER, quote(((Value) value).encodedValue));
            } else {
                String str4 = (String) value;
                if (str4.length() > 60 && splitLongParameters && encodeParameters) {
                    String str5 = key + Marker.ANY_MARKER;
                    int i3 = 0;
                    while (str4.length() > 60) {
                        toStringBuffer.addNV(str5 + i3, quote(str4.substring(0, 60)));
                        str4 = str4.substring(60);
                        i3++;
                    }
                    if (str4.length() > 0) {
                        toStringBuffer.addNV(str5 + i3, quote(str4));
                    }
                } else {
                    toStringBuffer.addNV(key, quote(str4));
                }
            }
        }
        return toStringBuffer.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class ToStringBuffer {
        private StringBuilder sb = new StringBuilder();
        private int used;

        public ToStringBuffer(int i) {
            this.used = i;
        }

        public void addNV(String str, String str2) {
            int lastIndexOf;
            this.sb.append("; ");
            this.used += 2;
            if (this.used + str.length() + str2.length() + 1 > 76) {
                this.sb.append("\r\n\t");
                this.used = 8;
            }
            StringBuilder sb = this.sb;
            sb.append(str);
            sb.append('=');
            int length = this.used + str.length() + 1;
            this.used = length;
            if (length + str2.length() > 76) {
                String fold = MimeUtility.fold(this.used, str2);
                this.sb.append(fold);
                if (fold.lastIndexOf(10) >= 0) {
                    this.used += (fold.length() - lastIndexOf) - 1;
                    return;
                } else {
                    this.used += fold.length();
                    return;
                }
            }
            this.sb.append(str2);
            this.used += str2.length();
        }

        public String toString() {
            return this.sb.toString();
        }
    }

    private static String quote(String str) {
        return MimeUtility.quote(str, HeaderTokenizer.MIME);
    }

    private static Value encodeValue(String str, String str2) {
        if (MimeUtility.checkAscii(str) == 1) {
            return null;
        }
        try {
            byte[] bytes = str.getBytes(MimeUtility.javaCharset(str2));
            StringBuffer stringBuffer = new StringBuffer(bytes.length + str2.length() + 2);
            stringBuffer.append(str2);
            stringBuffer.append("''");
            for (byte b : bytes) {
                char c = (char) (b & UByte.MAX_VALUE);
                if (c <= ' ' || c >= 127 || c == '*' || c == '\'' || c == '%' || HeaderTokenizer.MIME.indexOf(c) >= 0) {
                    stringBuffer.append('%');
                    stringBuffer.append(hex[c >> 4]);
                    stringBuffer.append(hex[c & 15]);
                } else {
                    stringBuffer.append(c);
                }
            }
            Value value = new Value();
            value.charset = str2;
            value.value = str;
            value.encodedValue = stringBuffer.toString();
            return value;
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }

    private static Value extractCharset(String str) throws ParseException {
        int indexOf;
        Value value = new Value();
        value.encodedValue = str;
        value.value = str;
        try {
            indexOf = str.indexOf(39);
        } catch (NumberFormatException e) {
            if (decodeParametersStrict) {
                throw new ParseException(e.toString());
            }
        } catch (StringIndexOutOfBoundsException e2) {
            if (decodeParametersStrict) {
                throw new ParseException(e2.toString());
            }
        }
        if (indexOf < 0) {
            if (decodeParametersStrict) {
                throw new ParseException("Missing charset in encoded value: " + str);
            }
            return value;
        }
        String substring = str.substring(0, indexOf);
        int indexOf2 = str.indexOf(39, indexOf + 1);
        if (indexOf2 < 0) {
            if (decodeParametersStrict) {
                throw new ParseException("Missing language in encoded value: " + str);
            }
            return value;
        }
        value.value = str.substring(indexOf2 + 1);
        value.charset = substring;
        return value;
    }

    private static String decodeBytes(String str, String str2) throws ParseException, UnsupportedEncodingException {
        byte[] bArr = new byte[str.length()];
        int i = 0;
        int i2 = 0;
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (charAt == '%') {
                try {
                    charAt = (char) Integer.parseInt(str.substring(i + 1, i + 3), 16);
                    i += 2;
                } catch (NumberFormatException e) {
                    if (decodeParametersStrict) {
                        throw new ParseException(e.toString());
                    }
                } catch (StringIndexOutOfBoundsException e2) {
                    if (decodeParametersStrict) {
                        throw new ParseException(e2.toString());
                    }
                }
            }
            bArr[i2] = (byte) charAt;
            i++;
            i2++;
        }
        if (str2 != null) {
            str2 = MimeUtility.javaCharset(str2);
        }
        if (str2 == null || str2.length() == 0) {
            str2 = MimeUtility.getDefaultJavaCharset();
        }
        return new String(bArr, 0, i2, str2);
    }

    private static void decodeBytes(String str, OutputStream outputStream) throws ParseException, IOException {
        int i = 0;
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (charAt == '%') {
                try {
                    charAt = (char) Integer.parseInt(str.substring(i + 1, i + 3), 16);
                    i += 2;
                } catch (NumberFormatException e) {
                    if (decodeParametersStrict) {
                        throw new ParseException(e.toString());
                    }
                } catch (StringIndexOutOfBoundsException e2) {
                    if (decodeParametersStrict) {
                        throw new ParseException(e2.toString());
                    }
                }
            }
            outputStream.write((byte) charAt);
            i++;
        }
    }
}
