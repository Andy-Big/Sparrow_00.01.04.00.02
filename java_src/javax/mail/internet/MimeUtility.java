package javax.mail.internet;

import com.rigol.scope.utilities.UnitFormat;
import com.sun.mail.util.ASCIIUtility;
import com.sun.mail.util.BASE64DecoderStream;
import com.sun.mail.util.BASE64EncoderStream;
import com.sun.mail.util.BEncoderStream;
import com.sun.mail.util.LineInputStream;
import com.sun.mail.util.PropUtil;
import com.sun.mail.util.QDecoderStream;
import com.sun.mail.util.QEncoderStream;
import com.sun.mail.util.QPDecoderStream;
import com.sun.mail.util.QPEncoderStream;
import com.sun.mail.util.UUDecoderStream;
import com.sun.mail.util.UUEncoderStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.EncodingAware;
import javax.mail.MessagingException;
import kotlin.UByte;
import kotlin.text.Typography;
/* loaded from: classes2.dex */
public class MimeUtility {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int ALL = -1;
    static final int ALL_ASCII = 1;
    static final int MOSTLY_ASCII = 2;
    static final int MOSTLY_NONASCII = 3;
    private static String defaultJavaCharset;
    private static String defaultMIMECharset;
    private static final Map<String, Boolean> nonAsciiCharsetMap = new HashMap();
    private static final boolean decodeStrict = PropUtil.getBooleanSystemProperty("mail.mime.decodetext.strict", true);
    private static final boolean encodeEolStrict = PropUtil.getBooleanSystemProperty("mail.mime.encodeeol.strict", false);
    private static final boolean ignoreUnknownEncoding = PropUtil.getBooleanSystemProperty("mail.mime.ignoreunknownencoding", false);
    private static final boolean allowUtf8 = PropUtil.getBooleanSystemProperty("mail.mime.allowutf8", false);
    private static final boolean foldEncodedWords = PropUtil.getBooleanSystemProperty("mail.mime.foldencodedwords", false);
    private static final boolean foldText = PropUtil.getBooleanSystemProperty("mail.mime.foldtext", true);
    private static Map<String, String> java2mime = new HashMap(40);
    private static Map<String, String> mime2java = new HashMap(14);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean nonascii(int i) {
        return i >= 127 || !(i >= 32 || i == 13 || i == 10 || i == 9);
    }

    private MimeUtility() {
    }

    static {
        LineInputStream lineInputStream;
        Throwable th;
        try {
            InputStream resourceAsStream = MimeUtility.class.getResourceAsStream("/META-INF/javamail.charset.map");
            if (resourceAsStream != null) {
                try {
                    lineInputStream = new LineInputStream(resourceAsStream);
                } catch (Throwable th2) {
                    lineInputStream = resourceAsStream;
                    th = th2;
                }
                try {
                    loadMappings(lineInputStream, java2mime);
                    loadMappings(lineInputStream, mime2java);
                    lineInputStream.close();
                } catch (Throwable th3) {
                    th = th3;
                    try {
                        lineInputStream.close();
                    } catch (Exception unused) {
                    }
                    throw th;
                }
            }
        } catch (Exception unused2) {
        }
        if (java2mime.isEmpty()) {
            java2mime.put("8859_1", "ISO-8859-1");
            java2mime.put("iso8859_1", "ISO-8859-1");
            java2mime.put("iso8859-1", "ISO-8859-1");
            java2mime.put("8859_2", "ISO-8859-2");
            java2mime.put("iso8859_2", "ISO-8859-2");
            java2mime.put("iso8859-2", "ISO-8859-2");
            java2mime.put("8859_3", "ISO-8859-3");
            java2mime.put("iso8859_3", "ISO-8859-3");
            java2mime.put("iso8859-3", "ISO-8859-3");
            java2mime.put("8859_4", "ISO-8859-4");
            java2mime.put("iso8859_4", "ISO-8859-4");
            java2mime.put("iso8859-4", "ISO-8859-4");
            java2mime.put("8859_5", "ISO-8859-5");
            java2mime.put("iso8859_5", "ISO-8859-5");
            java2mime.put("iso8859-5", "ISO-8859-5");
            java2mime.put("8859_6", "ISO-8859-6");
            java2mime.put("iso8859_6", "ISO-8859-6");
            java2mime.put("iso8859-6", "ISO-8859-6");
            java2mime.put("8859_7", "ISO-8859-7");
            java2mime.put("iso8859_7", "ISO-8859-7");
            java2mime.put("iso8859-7", "ISO-8859-7");
            java2mime.put("8859_8", "ISO-8859-8");
            java2mime.put("iso8859_8", "ISO-8859-8");
            java2mime.put("iso8859-8", "ISO-8859-8");
            java2mime.put("8859_9", "ISO-8859-9");
            java2mime.put("iso8859_9", "ISO-8859-9");
            java2mime.put("iso8859-9", "ISO-8859-9");
            java2mime.put("sjis", "Shift_JIS");
            java2mime.put("jis", "ISO-2022-JP");
            java2mime.put("iso2022jp", "ISO-2022-JP");
            java2mime.put("euc_jp", "euc-jp");
            java2mime.put("koi8_r", "koi8-r");
            java2mime.put("euc_cn", "euc-cn");
            java2mime.put("euc_tw", "euc-tw");
            java2mime.put("euc_kr", "euc-kr");
        }
        if (mime2java.isEmpty()) {
            mime2java.put("iso-2022-cn", "ISO2022CN");
            mime2java.put("iso-2022-kr", "ISO2022KR");
            mime2java.put("utf-8", "UTF8");
            mime2java.put("utf8", "UTF8");
            mime2java.put("ja_jp.iso2022-7", "ISO2022JP");
            mime2java.put("ja_jp.eucjp", "EUCJIS");
            mime2java.put("euc-kr", "KSC5601");
            mime2java.put("euckr", "KSC5601");
            mime2java.put("us-ascii", "ISO-8859-1");
            mime2java.put("x-us-ascii", "ISO-8859-1");
            mime2java.put("gb2312", "GB18030");
            mime2java.put("cp936", "GB18030");
            mime2java.put("ms936", "GB18030");
            mime2java.put("gbk", "GB18030");
        }
    }

    public static String getEncoding(DataSource dataSource) {
        String encoding;
        String str = "base64";
        if (!(dataSource instanceof EncodingAware) || (encoding = ((EncodingAware) dataSource).getEncoding()) == null) {
            InputStream inputStream = null;
            try {
                ContentType contentType = new ContentType(dataSource.getContentType());
                inputStream = dataSource.getInputStream();
                boolean match = contentType.match("text/*");
                int checkAscii = checkAscii(inputStream, -1, !match);
                if (checkAscii == 1) {
                    str = "7bit";
                } else if (checkAscii == 2) {
                    if (match) {
                        if (nonAsciiCharset(contentType)) {
                        }
                    }
                    str = "quoted-printable";
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused) {
                    }
                }
                return str;
            } catch (Exception unused2) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused3) {
                    }
                }
                return "base64";
            } catch (Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused4) {
                    }
                }
                throw th;
            }
        }
        return encoding;
    }

    private static boolean nonAsciiCharset(ContentType contentType) {
        Boolean bool;
        Boolean bool2;
        String parameter = contentType.getParameter("charset");
        boolean z = false;
        if (parameter == null) {
            return false;
        }
        String lowerCase = parameter.toLowerCase(Locale.ENGLISH);
        synchronized (nonAsciiCharsetMap) {
            bool = nonAsciiCharsetMap.get(lowerCase);
        }
        if (bool == null) {
            try {
                byte[] bytes = "\r\n".getBytes(lowerCase);
                if (bytes.length != 2 || bytes[0] != 13 || bytes[1] != 10) {
                    z = true;
                }
                bool2 = Boolean.valueOf(z);
            } catch (UnsupportedEncodingException unused) {
                bool2 = Boolean.FALSE;
            } catch (RuntimeException unused2) {
                bool2 = Boolean.TRUE;
            }
            bool = bool2;
            synchronized (nonAsciiCharsetMap) {
                nonAsciiCharsetMap.put(lowerCase, bool);
            }
        }
        return bool.booleanValue();
    }

    public static String getEncoding(DataHandler dataHandler) {
        if (dataHandler.getName() != null) {
            return getEncoding(dataHandler.getDataSource());
        }
        try {
            if (new ContentType(dataHandler.getContentType()).match("text/*")) {
                AsciiOutputStream asciiOutputStream = new AsciiOutputStream(false, false);
                try {
                    dataHandler.writeTo(asciiOutputStream);
                } catch (IOException unused) {
                }
                int ascii = asciiOutputStream.getAscii();
                if (ascii != 1) {
                    return ascii != 2 ? "base64" : "quoted-printable";
                }
            } else {
                AsciiOutputStream asciiOutputStream2 = new AsciiOutputStream(true, encodeEolStrict);
                try {
                    dataHandler.writeTo(asciiOutputStream2);
                } catch (IOException unused2) {
                }
                if (asciiOutputStream2.getAscii() != 1) {
                    return "base64";
                }
            }
            return "7bit";
        } catch (Exception unused3) {
            return "base64";
        }
    }

    public static InputStream decode(InputStream inputStream, String str) throws MessagingException {
        if (str.equalsIgnoreCase("base64")) {
            return new BASE64DecoderStream(inputStream);
        }
        if (str.equalsIgnoreCase("quoted-printable")) {
            return new QPDecoderStream(inputStream);
        }
        if (str.equalsIgnoreCase("uuencode") || str.equalsIgnoreCase("x-uuencode") || str.equalsIgnoreCase("x-uue")) {
            return new UUDecoderStream(inputStream);
        }
        if (str.equalsIgnoreCase("binary") || str.equalsIgnoreCase("7bit") || str.equalsIgnoreCase("8bit") || ignoreUnknownEncoding) {
            return inputStream;
        }
        throw new MessagingException("Unknown encoding: " + str);
    }

    public static OutputStream encode(OutputStream outputStream, String str) throws MessagingException {
        if (str == null) {
            return outputStream;
        }
        if (str.equalsIgnoreCase("base64")) {
            return new BASE64EncoderStream(outputStream);
        }
        if (str.equalsIgnoreCase("quoted-printable")) {
            return new QPEncoderStream(outputStream);
        }
        if (str.equalsIgnoreCase("uuencode") || str.equalsIgnoreCase("x-uuencode") || str.equalsIgnoreCase("x-uue")) {
            return new UUEncoderStream(outputStream);
        }
        if (str.equalsIgnoreCase("binary") || str.equalsIgnoreCase("7bit") || str.equalsIgnoreCase("8bit")) {
            return outputStream;
        }
        throw new MessagingException("Unknown encoding: " + str);
    }

    public static OutputStream encode(OutputStream outputStream, String str, String str2) throws MessagingException {
        if (str == null) {
            return outputStream;
        }
        if (str.equalsIgnoreCase("base64")) {
            return new BASE64EncoderStream(outputStream);
        }
        if (str.equalsIgnoreCase("quoted-printable")) {
            return new QPEncoderStream(outputStream);
        }
        if (str.equalsIgnoreCase("uuencode") || str.equalsIgnoreCase("x-uuencode") || str.equalsIgnoreCase("x-uue")) {
            return new UUEncoderStream(outputStream, str2);
        }
        if (str.equalsIgnoreCase("binary") || str.equalsIgnoreCase("7bit") || str.equalsIgnoreCase("8bit")) {
            return outputStream;
        }
        throw new MessagingException("Unknown encoding: " + str);
    }

    public static String encodeText(String str) throws UnsupportedEncodingException {
        return encodeText(str, null, null);
    }

    public static String encodeText(String str, String str2, String str3) throws UnsupportedEncodingException {
        return encodeWord(str, str2, str3, false);
    }

    public static String decodeText(String str) throws UnsupportedEncodingException {
        String decodeInnerWords;
        if (str.indexOf("=?") == -1) {
            return str;
        }
        StringTokenizer stringTokenizer = new StringTokenizer(str, " \t\n\r", true);
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        boolean z = false;
        while (stringTokenizer.hasMoreTokens()) {
            String nextToken = stringTokenizer.nextToken();
            char charAt = nextToken.charAt(0);
            if (charAt == ' ' || charAt == '\t' || charAt == '\r' || charAt == '\n') {
                sb2.append(charAt);
            } else {
                try {
                    decodeInnerWords = decodeWord(nextToken);
                    if (!z && sb2.length() > 0) {
                        sb.append((CharSequence) sb2);
                    }
                    z = true;
                } catch (ParseException unused) {
                    if (!decodeStrict) {
                        decodeInnerWords = decodeInnerWords(nextToken);
                        if (decodeInnerWords != nextToken) {
                            if ((!z || !nextToken.startsWith("=?")) && sb2.length() > 0) {
                                sb.append((CharSequence) sb2);
                            }
                            z = nextToken.endsWith("?=");
                        } else if (sb2.length() > 0) {
                            sb.append((CharSequence) sb2);
                        }
                    } else if (sb2.length() > 0) {
                        sb.append((CharSequence) sb2);
                    }
                    z = false;
                }
                nextToken = decodeInnerWords;
                sb.append(nextToken);
                sb2.setLength(0);
            }
        }
        sb.append((CharSequence) sb2);
        return sb.toString();
    }

    public static String encodeWord(String str) throws UnsupportedEncodingException {
        return encodeWord(str, null, null);
    }

    public static String encodeWord(String str, String str2, String str3) throws UnsupportedEncodingException {
        return encodeWord(str, str2, str3, true);
    }

    private static String encodeWord(String str, String str2, String str3, boolean z) throws UnsupportedEncodingException {
        String javaCharset;
        int checkAscii = checkAscii(str);
        boolean z2 = true;
        if (checkAscii == 1) {
            return str;
        }
        if (str2 == null) {
            javaCharset = getDefaultJavaCharset();
            str2 = getDefaultMIMECharset();
        } else {
            javaCharset = javaCharset(str2);
        }
        if (str3 == null) {
            str3 = checkAscii != 3 ? "Q" : "B";
        }
        if (!str3.equalsIgnoreCase("B")) {
            if (!str3.equalsIgnoreCase("Q")) {
                throw new UnsupportedEncodingException("Unknown transfer encoding: " + str3);
            }
            z2 = false;
        }
        boolean z3 = z2;
        StringBuilder sb = new StringBuilder();
        int length = 68 - str2.length();
        doEncode(str, z3, javaCharset, length, "=?" + str2 + "?" + str3 + "?", true, z, sb);
        return sb.toString();
    }

    private static void doEncode(String str, boolean z, String str2, int i, String str3, boolean z2, boolean z3, StringBuilder sb) throws UnsupportedEncodingException {
        int encodedLength;
        OutputStream qEncoderStream;
        int length;
        byte[] bytes = str.getBytes(str2);
        if (z) {
            encodedLength = BEncoderStream.encodedLength(bytes);
        } else {
            encodedLength = QEncoderStream.encodedLength(bytes, z3);
        }
        if (encodedLength > i && (length = str.length()) > 1) {
            int i2 = length / 2;
            if (Character.isHighSurrogate(str.charAt(i2 - 1))) {
                i2--;
            }
            int i3 = i2;
            if (i3 > 0) {
                doEncode(str.substring(0, i3), z, str2, i, str3, z2, z3, sb);
            }
            doEncode(str.substring(i3, length), z, str2, i, str3, false, z3, sb);
            return;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (z) {
            qEncoderStream = new BEncoderStream(byteArrayOutputStream);
        } else {
            qEncoderStream = new QEncoderStream(byteArrayOutputStream, z3);
        }
        try {
            qEncoderStream.write(bytes);
            qEncoderStream.close();
        } catch (IOException unused) {
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (!z2) {
            if (foldEncodedWords) {
                sb.append("\r\n ");
            } else {
                sb.append(" ");
            }
        }
        sb.append(str3);
        for (byte b : byteArray) {
            sb.append((char) b);
        }
        sb.append("?=");
    }

    public static String decodeWord(String str) throws ParseException, UnsupportedEncodingException {
        InputStream qDecoderStream;
        if (!str.startsWith("=?")) {
            throw new ParseException("encoded word does not start with \"=?\": " + str);
        }
        int indexOf = str.indexOf(63, 2);
        if (indexOf == -1) {
            throw new ParseException("encoded word does not include charset: " + str);
        }
        String substring = str.substring(2, indexOf);
        int indexOf2 = substring.indexOf(42);
        if (indexOf2 >= 0) {
            substring = substring.substring(0, indexOf2);
        }
        String javaCharset = javaCharset(substring);
        int i = indexOf + 1;
        int indexOf3 = str.indexOf(63, i);
        if (indexOf3 == -1) {
            throw new ParseException("encoded word does not include encoding: " + str);
        }
        String substring2 = str.substring(i, indexOf3);
        int i2 = indexOf3 + 1;
        int indexOf4 = str.indexOf("?=", i2);
        if (indexOf4 == -1) {
            throw new ParseException("encoded word does not end with \"?=\": " + str);
        }
        String substring3 = str.substring(i2, indexOf4);
        try {
            String str2 = "";
            if (substring3.length() > 0) {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(ASCIIUtility.getBytes(substring3));
                if (substring2.equalsIgnoreCase("B")) {
                    qDecoderStream = new BASE64DecoderStream(byteArrayInputStream);
                } else if (substring2.equalsIgnoreCase("Q")) {
                    qDecoderStream = new QDecoderStream(byteArrayInputStream);
                } else {
                    throw new UnsupportedEncodingException("unknown encoding: " + substring2);
                }
                int available = byteArrayInputStream.available();
                byte[] bArr = new byte[available];
                int read = qDecoderStream.read(bArr, 0, available);
                if (read > 0) {
                    str2 = new String(bArr, 0, read, javaCharset);
                }
            }
            int i3 = indexOf4 + 2;
            if (i3 < str.length()) {
                String substring4 = str.substring(i3);
                if (!decodeStrict) {
                    substring4 = decodeInnerWords(substring4);
                }
                return str2 + substring4;
            }
            return str2;
        } catch (UnsupportedEncodingException e) {
            throw e;
        } catch (IOException e2) {
            throw new ParseException(e2.toString());
        } catch (IllegalArgumentException unused) {
            throw new UnsupportedEncodingException(javaCharset);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0044, code lost:
        return r5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.String decodeInnerWords(java.lang.String r5) throws java.io.UnsupportedEncodingException {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = 0
        L6:
            java.lang.String r2 = "=?"
            int r2 = r5.indexOf(r2, r1)
            if (r2 < 0) goto L42
            java.lang.String r3 = r5.substring(r1, r2)
            r0.append(r3)
            int r3 = r2 + 2
            r4 = 63
            int r3 = r5.indexOf(r4, r3)
            if (r3 >= 0) goto L20
            goto L42
        L20:
            int r3 = r3 + 1
            int r3 = r5.indexOf(r4, r3)
            if (r3 >= 0) goto L29
            goto L42
        L29:
            int r3 = r3 + 1
            java.lang.String r4 = "?="
            int r3 = r5.indexOf(r4, r3)
            if (r3 >= 0) goto L34
            goto L42
        L34:
            int r1 = r3 + 2
            java.lang.String r2 = r5.substring(r2, r1)
            java.lang.String r2 = decodeWord(r2)     // Catch: javax.mail.internet.ParseException -> L3e
        L3e:
            r0.append(r2)
            goto L6
        L42:
            if (r1 != 0) goto L45
            return r5
        L45:
            int r2 = r5.length()
            if (r1 >= r2) goto L52
            java.lang.String r5 = r5.substring(r1)
            r0.append(r5)
        L52:
            java.lang.String r5 = r0.toString()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.mail.internet.MimeUtility.decodeInnerWords(java.lang.String):java.lang.String");
    }

    public static String quote(String str, String str2) {
        char c = 0;
        int length = str == null ? 0 : str.length();
        if (length == 0) {
            return "\"\"";
        }
        int i = 0;
        boolean z = false;
        while (i < length) {
            char charAt = str.charAt(i);
            if (charAt == '\"' || charAt == '\\' || charAt == '\r' || charAt == '\n') {
                StringBuilder sb = new StringBuilder(length + 3);
                sb.append(Typography.quote);
                sb.append(str.substring(0, i));
                while (i < length) {
                    char charAt2 = str.charAt(i);
                    if ((charAt2 == '\"' || charAt2 == '\\' || charAt2 == '\r' || charAt2 == '\n') && (charAt2 != '\n' || c != '\r')) {
                        sb.append('\\');
                    }
                    sb.append(charAt2);
                    i++;
                    c = charAt2;
                }
                sb.append(Typography.quote);
                return sb.toString();
            }
            if (charAt < ' ' || ((charAt >= 127 && !allowUtf8) || str2.indexOf(charAt) >= 0)) {
                z = true;
            }
            i++;
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

    public static String fold(int i, String str) {
        char charAt;
        if (foldText) {
            int length = str.length() - 1;
            while (length >= 0 && ((charAt = str.charAt(length)) == ' ' || charAt == '\t' || charAt == '\r' || charAt == '\n')) {
                length--;
            }
            if (length != str.length() - 1) {
                str = str.substring(0, length + 1);
            }
            if (str.length() + i <= 76) {
                return makesafe(str);
            }
            StringBuilder sb = new StringBuilder(str.length() + 4);
            char c = 0;
            while (true) {
                if (str.length() + i <= 76) {
                    break;
                }
                int i2 = 0;
                int i3 = -1;
                while (i2 < str.length() && (i3 == -1 || i + i2 <= 76)) {
                    char charAt2 = str.charAt(i2);
                    if ((charAt2 == ' ' || charAt2 == '\t') && c != ' ' && c != '\t') {
                        i3 = i2;
                    }
                    i2++;
                    c = charAt2;
                }
                if (i3 == -1) {
                    sb.append(str);
                    str = "";
                    break;
                }
                sb.append(str.substring(0, i3));
                sb.append("\r\n");
                c = str.charAt(i3);
                sb.append(c);
                str = str.substring(i3 + 1);
                i = 1;
            }
            sb.append(str);
            return makesafe(sb);
        }
        return str;
    }

    private static String makesafe(CharSequence charSequence) {
        char charAt;
        int i = 0;
        while (i < charSequence.length() && (charAt = charSequence.charAt(i)) != '\r' && charAt != '\n') {
            i++;
        }
        if (i == charSequence.length()) {
            return charSequence.toString();
        }
        StringBuilder sb = new StringBuilder(charSequence.length() + 1);
        BufferedReader bufferedReader = new BufferedReader(new StringReader(charSequence.toString()));
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    if (readLine.trim().length() != 0) {
                        if (sb.length() > 0) {
                            sb.append("\r\n");
                            char charAt2 = readLine.charAt(0);
                            if (charAt2 != ' ' && charAt2 != '\t') {
                                sb.append(' ');
                            }
                        }
                        sb.append(readLine);
                    }
                } else {
                    return sb.toString();
                }
            } catch (IOException unused) {
                return charSequence.toString();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x007d, code lost:
        r0 = new java.lang.StringBuilder(r8.length());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String unfold(java.lang.String r8) {
        /*
            boolean r0 = javax.mail.internet.MimeUtility.foldText
            if (r0 != 0) goto L5
            return r8
        L5:
            r0 = 0
        L6:
            java.lang.String r1 = "\r\n"
            int r1 = indexOfAny(r8, r1)
            if (r1 < 0) goto L93
            int r2 = r8.length()
            int r3 = r1 + 1
            if (r3 >= r2) goto L2a
            int r4 = r3 + (-1)
            char r4 = r8.charAt(r4)
            r5 = 13
            if (r4 != r5) goto L2a
            char r4 = r8.charAt(r3)
            r5 = 10
            if (r4 != r5) goto L2a
            int r3 = r3 + 1
        L2a:
            r4 = 0
            if (r1 <= 0) goto L55
            int r5 = r1 + (-1)
            char r6 = r8.charAt(r5)
            r7 = 92
            if (r6 != r7) goto L55
            if (r0 != 0) goto L42
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            int r2 = r8.length()
            r0.<init>(r2)
        L42:
            java.lang.String r2 = r8.substring(r4, r5)
            r0.append(r2)
            java.lang.String r1 = r8.substring(r1, r3)
            r0.append(r1)
            java.lang.String r8 = r8.substring(r3)
            goto L6
        L55:
            if (r3 >= r2) goto L7b
            char r2 = r8.charAt(r3)
            r5 = 32
            if (r2 == r5) goto L7b
            r5 = 9
            if (r2 != r5) goto L64
            goto L7b
        L64:
            if (r0 != 0) goto L6f
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            int r1 = r8.length()
            r0.<init>(r1)
        L6f:
            java.lang.String r1 = r8.substring(r4, r3)
            r0.append(r1)
            java.lang.String r8 = r8.substring(r3)
            goto L6
        L7b:
            if (r0 != 0) goto L86
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            int r2 = r8.length()
            r0.<init>(r2)
        L86:
            java.lang.String r1 = r8.substring(r4, r1)
            r0.append(r1)
            java.lang.String r8 = r8.substring(r3)
            goto L6
        L93:
            if (r0 == 0) goto L9c
            r0.append(r8)
            java.lang.String r8 = r0.toString()
        L9c:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.mail.internet.MimeUtility.unfold(java.lang.String):java.lang.String");
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

    public static String javaCharset(String str) {
        Map<String, String> map = mime2java;
        if (map == null || str == null) {
            return str;
        }
        String str2 = map.get(str.toLowerCase(Locale.ENGLISH));
        if (str2 != null) {
            try {
                Charset.forName(str2);
            } catch (Exception unused) {
                str2 = null;
            }
        }
        return str2 == null ? str : str2;
    }

    public static String mimeCharset(String str) {
        String str2;
        Map<String, String> map = java2mime;
        return (map == null || str == null || (str2 = map.get(str.toLowerCase(Locale.ENGLISH))) == null) ? str : str2;
    }

    public static String getDefaultJavaCharset() {
        if (defaultJavaCharset == null) {
            String str = null;
            try {
                str = System.getProperty("mail.mime.charset");
            } catch (SecurityException unused) {
            }
            if (str != null && str.length() > 0) {
                String javaCharset = javaCharset(str);
                defaultJavaCharset = javaCharset;
                return javaCharset;
            }
            try {
                defaultJavaCharset = System.getProperty("file.encoding", "8859_1");
            } catch (SecurityException unused2) {
                String encoding = new InputStreamReader(new InputStream() { // from class: javax.mail.internet.MimeUtility.1NullInputStream
                    @Override // java.io.InputStream
                    public int read() {
                        return 0;
                    }
                }).getEncoding();
                defaultJavaCharset = encoding;
                if (encoding == null) {
                    defaultJavaCharset = "8859_1";
                }
            }
        }
        return defaultJavaCharset;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getDefaultMIMECharset() {
        if (defaultMIMECharset == null) {
            try {
                defaultMIMECharset = System.getProperty("mail.mime.charset");
            } catch (SecurityException unused) {
            }
        }
        if (defaultMIMECharset == null) {
            defaultMIMECharset = mimeCharset(getDefaultJavaCharset());
        }
        return defaultMIMECharset;
    }

    private static void loadMappings(LineInputStream lineInputStream, Map<String, String> map) {
        while (true) {
            try {
                String readLine = lineInputStream.readLine();
                if (readLine == null) {
                    return;
                }
                if (readLine.startsWith("--") && readLine.endsWith("--")) {
                    return;
                }
                if (readLine.trim().length() != 0 && !readLine.startsWith(UnitFormat.PATTERN_SIGN)) {
                    StringTokenizer stringTokenizer = new StringTokenizer(readLine, " \t");
                    try {
                        String nextToken = stringTokenizer.nextToken();
                        map.put(nextToken.toLowerCase(Locale.ENGLISH), stringTokenizer.nextToken());
                    } catch (NoSuchElementException unused) {
                    }
                }
            } catch (IOException unused2) {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int checkAscii(String str) {
        int length = str.length();
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            if (nonascii(str.charAt(i3))) {
                i++;
            } else {
                i2++;
            }
        }
        if (i == 0) {
            return 1;
        }
        return i2 > i ? 2 : 3;
    }

    static int checkAscii(byte[] bArr) {
        int i = 0;
        int i2 = 0;
        for (byte b : bArr) {
            if (nonascii(b & UByte.MAX_VALUE)) {
                i++;
            } else {
                i2++;
            }
        }
        if (i == 0) {
            return 1;
        }
        return i2 > i ? 2 : 3;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x005d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static int checkAscii(java.io.InputStream r16, int r17, boolean r18) {
        /*
            r0 = r17
            boolean r1 = javax.mail.internet.MimeUtility.encodeEolStrict
            r3 = 0
            if (r1 == 0) goto Lb
            if (r18 == 0) goto Lb
            r1 = 1
            goto Lc
        Lb:
            r1 = r3
        Lc:
            r4 = 0
            r5 = -1
            r6 = 4096(0x1000, float:5.74E-42)
            if (r0 == 0) goto L1c
            if (r0 != r5) goto L15
            goto L1a
        L15:
            int r4 = java.lang.Math.min(r0, r6)
            r6 = r4
        L1a:
            byte[] r4 = new byte[r6]
        L1c:
            r7 = r3
            r8 = r7
            r9 = r8
            r10 = r9
            r11 = r10
        L21:
            if (r0 == 0) goto L6b
            r13 = r16
            int r14 = r13.read(r4, r3, r6)     // Catch: java.io.IOException -> L6b
            if (r14 != r5) goto L2c
            goto L6b
        L2c:
            r15 = r3
        L2d:
            if (r15 >= r14) goto L64
            r2 = r4[r15]     // Catch: java.io.IOException -> L6b
            r2 = r2 & 255(0xff, float:3.57E-43)
            r5 = 10
            r12 = 13
            if (r1 == 0) goto L42
            if (r3 != r12) goto L3d
            if (r2 != r5) goto L41
        L3d:
            if (r3 == r12) goto L42
            if (r2 != r5) goto L42
        L41:
            r9 = 1
        L42:
            if (r2 == r12) goto L4f
            if (r2 != r5) goto L47
            goto L4f
        L47:
            int r11 = r11 + 1
            r3 = 998(0x3e6, float:1.398E-42)
            if (r11 <= r3) goto L50
            r10 = 1
            goto L50
        L4f:
            r11 = 0
        L50:
            boolean r3 = nonascii(r2)     // Catch: java.io.IOException -> L6b
            if (r3 == 0) goto L5d
            if (r18 == 0) goto L5a
            r3 = 3
            return r3
        L5a:
            int r8 = r8 + 1
            goto L5f
        L5d:
            int r7 = r7 + 1
        L5f:
            int r15 = r15 + 1
            r3 = r2
            r5 = -1
            goto L2d
        L64:
            r2 = r5
            if (r0 == r2) goto L68
            int r0 = r0 - r14
        L68:
            r5 = r2
            r3 = 0
            goto L21
        L6b:
            if (r0 != 0) goto L71
            if (r18 == 0) goto L71
            r0 = 3
            return r0
        L71:
            r0 = 3
            r1 = 2
            if (r8 != 0) goto L7d
            if (r9 == 0) goto L78
            return r0
        L78:
            if (r10 == 0) goto L7b
            return r1
        L7b:
            r0 = 1
            return r0
        L7d:
            if (r7 <= r8) goto L80
            return r1
        L80:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.mail.internet.MimeUtility.checkAscii(java.io.InputStream, int, boolean):int");
    }
}
