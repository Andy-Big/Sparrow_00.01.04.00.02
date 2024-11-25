package javax.mail.internet;
/* loaded from: classes2.dex */
public class HeaderTokenizer {
    private static final Token EOFToken = new Token(-4, null);
    public static final String MIME = "()<>@,;:\\\"\t []/?=";
    public static final String RFC822 = "()<>@,;:\\\"\t .[]";
    private int currentPos;
    private String delimiters;
    private int maxPos;
    private int nextPos;
    private int peekPos;
    private boolean skipComments;
    private String string;

    /* loaded from: classes2.dex */
    public static class Token {
        public static final int ATOM = -1;
        public static final int COMMENT = -3;
        public static final int EOF = -4;
        public static final int QUOTEDSTRING = -2;
        private int type;
        private String value;

        public Token(int i, String str) {
            this.type = i;
            this.value = str;
        }

        public int getType() {
            return this.type;
        }

        public String getValue() {
            return this.value;
        }
    }

    public HeaderTokenizer(String str, String str2, boolean z) {
        str = str == null ? "" : str;
        this.string = str;
        this.skipComments = z;
        this.delimiters = str2;
        this.peekPos = 0;
        this.nextPos = 0;
        this.currentPos = 0;
        this.maxPos = str.length();
    }

    public HeaderTokenizer(String str, String str2) {
        this(str, str2, true);
    }

    public HeaderTokenizer(String str) {
        this(str, RFC822);
    }

    public Token next() throws ParseException {
        return next((char) 0, false);
    }

    public Token next(char c) throws ParseException {
        return next(c, false);
    }

    public Token next(char c, boolean z) throws ParseException {
        this.currentPos = this.nextPos;
        Token next = getNext(c, z);
        int i = this.currentPos;
        this.peekPos = i;
        this.nextPos = i;
        return next;
    }

    public Token peek() throws ParseException {
        this.currentPos = this.peekPos;
        Token next = getNext((char) 0, false);
        this.peekPos = this.currentPos;
        return next;
    }

    public String getRemainder() {
        if (this.nextPos >= this.string.length()) {
            return null;
        }
        return this.string.substring(this.nextPos);
    }

    /* JADX WARN: Code restructure failed: missing block: B:70:0x00db, code lost:
        if (r2 == r10) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00dd, code lost:
        r9.currentPos = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00e3, code lost:
        return collectString(r10, r11);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private javax.mail.internet.HeaderTokenizer.Token getNext(char r10, boolean r11) throws javax.mail.internet.ParseException {
        /*
            Method dump skipped, instructions count: 272
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.mail.internet.HeaderTokenizer.getNext(char, boolean):javax.mail.internet.HeaderTokenizer$Token");
    }

    private Token collectString(char c, boolean z) throws ParseException {
        String substring;
        String substring2;
        int i = this.currentPos;
        boolean z2 = false;
        while (true) {
            int i2 = this.currentPos;
            if (i2 >= this.maxPos) {
                if (c == '\"') {
                    throw new ParseException("Unbalanced quoted string");
                }
                if (z2) {
                    substring = filterToken(this.string, i, i2, z);
                } else {
                    substring = this.string.substring(i, i2);
                }
                return new Token(-2, trimWhiteSpace(substring));
            }
            char charAt = this.string.charAt(i2);
            if (charAt == '\\') {
                this.currentPos++;
            } else if (charAt != '\r') {
                if (charAt != c) {
                    this.currentPos++;
                } else {
                    int i3 = this.currentPos + 1;
                    this.currentPos = i3;
                    if (z2) {
                        substring2 = filterToken(this.string, i, i3 - 1, z);
                    } else {
                        substring2 = this.string.substring(i, i3 - 1);
                    }
                    if (charAt != '\"') {
                        substring2 = trimWhiteSpace(substring2);
                        this.currentPos--;
                    }
                    return new Token(-2, substring2);
                }
            }
            z2 = true;
            this.currentPos++;
        }
    }

    private int skipWhiteSpace() {
        while (true) {
            int i = this.currentPos;
            if (i >= this.maxPos) {
                return -4;
            }
            char charAt = this.string.charAt(i);
            if (charAt == ' ' || charAt == '\t' || charAt == '\r' || charAt == '\n') {
                this.currentPos++;
            } else {
                return this.currentPos;
            }
        }
    }

    private static String trimWhiteSpace(String str) {
        int length = str.length() - 1;
        while (length >= 0) {
            char charAt = str.charAt(length);
            if (charAt != ' ' && charAt != '\t' && charAt != '\r' && charAt != '\n') {
                break;
            }
            length--;
        }
        return length <= 0 ? "" : str.substring(0, length + 1);
    }

    private static String filterToken(String str, int i, int i2, boolean z) {
        StringBuilder sb = new StringBuilder();
        boolean z2 = false;
        boolean z3 = false;
        while (i < i2) {
            char charAt = str.charAt(i);
            if (charAt != '\n' || !z2) {
                if (z3) {
                    if (z) {
                        sb.append('\\');
                    }
                    sb.append(charAt);
                    z2 = false;
                    z3 = false;
                } else if (charAt == '\\') {
                    z2 = false;
                    z3 = true;
                } else if (charAt == '\r') {
                    z2 = true;
                } else {
                    sb.append(charAt);
                }
                i++;
            }
            z2 = false;
            i++;
        }
        return sb.toString();
    }
}
