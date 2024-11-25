package org.apache.commons.csv;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Serializable;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashSet;
import kotlin.text.Typography;
/* loaded from: classes2.dex */
public final class CSVFormat implements Serializable {
    public static final CSVFormat DEFAULT;
    public static final CSVFormat EXCEL;
    public static final CSVFormat INFORMIX_UNLOAD;
    public static final CSVFormat INFORMIX_UNLOAD_CSV;
    public static final CSVFormat MONGODB_CSV;
    public static final CSVFormat MONGODB_TSV;
    public static final CSVFormat MYSQL;
    public static final CSVFormat ORACLE;
    public static final CSVFormat POSTGRESQL_CSV;
    public static final CSVFormat POSTGRESQL_TEXT;
    public static final CSVFormat RFC4180;
    public static final CSVFormat TDF;
    private static final long serialVersionUID = 1;
    private final boolean allowDuplicateHeaderNames;
    private final boolean allowMissingColumnNames;
    private final boolean autoFlush;
    private final Character commentMarker;
    private final char delimiter;
    private final Character escapeCharacter;
    private final String[] header;
    private final String[] headerComments;
    private final boolean ignoreEmptyLines;
    private final boolean ignoreHeaderCase;
    private final boolean ignoreSurroundingSpaces;
    private final String nullString;
    private final Character quoteCharacter;
    private final QuoteMode quoteMode;
    private final String quotedNullString;
    private final String recordSeparator;
    private final boolean skipHeaderRecord;
    private final boolean trailingDelimiter;
    private final boolean trim;

    private static boolean isLineBreak(char c) {
        return c == '\n' || c == '\r';
    }

    /* loaded from: classes2.dex */
    public enum Predefined {
        Default(CSVFormat.DEFAULT),
        Excel(CSVFormat.EXCEL),
        InformixUnload(CSVFormat.INFORMIX_UNLOAD),
        InformixUnloadCsv(CSVFormat.INFORMIX_UNLOAD_CSV),
        MongoDBCsv(CSVFormat.MONGODB_CSV),
        MongoDBTsv(CSVFormat.MONGODB_TSV),
        MySQL(CSVFormat.MYSQL),
        Oracle(CSVFormat.ORACLE),
        PostgreSQLCsv(CSVFormat.POSTGRESQL_CSV),
        PostgreSQLText(CSVFormat.POSTGRESQL_TEXT),
        RFC4180(CSVFormat.RFC4180),
        TDF(CSVFormat.TDF);
        
        private final CSVFormat format;

        Predefined(CSVFormat cSVFormat) {
            this.format = cSVFormat;
        }

        public CSVFormat getFormat() {
            return this.format;
        }
    }

    static {
        CSVFormat cSVFormat = new CSVFormat(',', Constants.DOUBLE_QUOTE_CHAR, null, null, null, false, true, "\r\n", null, null, null, false, false, false, false, false, false, true);
        DEFAULT = cSVFormat;
        EXCEL = cSVFormat.withIgnoreEmptyLines(false).withAllowMissingColumnNames();
        INFORMIX_UNLOAD = DEFAULT.withDelimiter('|').withEscape('\\').withQuote(Constants.DOUBLE_QUOTE_CHAR).withRecordSeparator('\n');
        INFORMIX_UNLOAD_CSV = DEFAULT.withDelimiter(',').withQuote(Constants.DOUBLE_QUOTE_CHAR).withRecordSeparator('\n');
        MONGODB_CSV = DEFAULT.withDelimiter(',').withEscape(Constants.DOUBLE_QUOTE_CHAR).withQuote(Constants.DOUBLE_QUOTE_CHAR).withQuoteMode(QuoteMode.MINIMAL).withSkipHeaderRecord(false);
        MONGODB_TSV = DEFAULT.withDelimiter('\t').withEscape(Constants.DOUBLE_QUOTE_CHAR).withQuote(Constants.DOUBLE_QUOTE_CHAR).withQuoteMode(QuoteMode.MINIMAL).withSkipHeaderRecord(false);
        MYSQL = DEFAULT.withDelimiter('\t').withEscape('\\').withIgnoreEmptyLines(false).withQuote((Character) null).withRecordSeparator('\n').withNullString("\\N").withQuoteMode(QuoteMode.ALL_NON_NULL);
        ORACLE = DEFAULT.withDelimiter(',').withEscape('\\').withIgnoreEmptyLines(false).withQuote(Constants.DOUBLE_QUOTE_CHAR).withNullString("\\N").withTrim().withSystemRecordSeparator().withQuoteMode(QuoteMode.MINIMAL);
        POSTGRESQL_CSV = DEFAULT.withDelimiter(',').withEscape(Constants.DOUBLE_QUOTE_CHAR).withIgnoreEmptyLines(false).withQuote(Constants.DOUBLE_QUOTE_CHAR).withRecordSeparator('\n').withNullString("").withQuoteMode(QuoteMode.ALL_NON_NULL);
        POSTGRESQL_TEXT = DEFAULT.withDelimiter('\t').withEscape('\\').withIgnoreEmptyLines(false).withQuote(Constants.DOUBLE_QUOTE_CHAR).withRecordSeparator('\n').withNullString("\\N").withQuoteMode(QuoteMode.ALL_NON_NULL);
        RFC4180 = DEFAULT.withIgnoreEmptyLines(false);
        TDF = DEFAULT.withDelimiter('\t').withIgnoreSurroundingSpaces();
    }

    private static boolean isLineBreak(Character ch2) {
        return ch2 != null && isLineBreak(ch2.charValue());
    }

    public static CSVFormat newFormat(char c) {
        return new CSVFormat(c, null, null, null, null, false, false, null, null, null, null, false, false, false, false, false, false, true);
    }

    public static CSVFormat valueOf(String str) {
        return Predefined.valueOf(str).getFormat();
    }

    private CSVFormat(char c, Character ch2, QuoteMode quoteMode, Character ch3, Character ch4, boolean z, boolean z2, String str, String str2, Object[] objArr, String[] strArr, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9) {
        this.delimiter = c;
        this.quoteCharacter = ch2;
        this.quoteMode = quoteMode;
        this.commentMarker = ch3;
        this.escapeCharacter = ch4;
        this.ignoreSurroundingSpaces = z;
        this.allowMissingColumnNames = z4;
        this.ignoreEmptyLines = z2;
        this.recordSeparator = str;
        this.nullString = str2;
        this.headerComments = toStringArray(objArr);
        this.header = strArr == null ? null : (String[]) strArr.clone();
        this.skipHeaderRecord = z3;
        this.ignoreHeaderCase = z5;
        this.trailingDelimiter = z7;
        this.trim = z6;
        this.autoFlush = z8;
        this.quotedNullString = this.quoteCharacter + str2 + this.quoteCharacter;
        this.allowDuplicateHeaderNames = z9;
        validate();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            CSVFormat cSVFormat = (CSVFormat) obj;
            if (this.delimiter == cSVFormat.delimiter && this.trailingDelimiter == cSVFormat.trailingDelimiter && this.autoFlush == cSVFormat.autoFlush && this.trim == cSVFormat.trim && this.allowMissingColumnNames == cSVFormat.allowMissingColumnNames && this.allowDuplicateHeaderNames == cSVFormat.allowDuplicateHeaderNames && this.ignoreHeaderCase == cSVFormat.ignoreHeaderCase && this.quoteMode == cSVFormat.quoteMode) {
                Character ch2 = this.quoteCharacter;
                if (ch2 == null) {
                    if (cSVFormat.quoteCharacter != null) {
                        return false;
                    }
                } else if (!ch2.equals(cSVFormat.quoteCharacter)) {
                    return false;
                }
                Character ch3 = this.commentMarker;
                if (ch3 == null) {
                    if (cSVFormat.commentMarker != null) {
                        return false;
                    }
                } else if (!ch3.equals(cSVFormat.commentMarker)) {
                    return false;
                }
                Character ch4 = this.escapeCharacter;
                if (ch4 == null) {
                    if (cSVFormat.escapeCharacter != null) {
                        return false;
                    }
                } else if (!ch4.equals(cSVFormat.escapeCharacter)) {
                    return false;
                }
                String str = this.nullString;
                if (str == null) {
                    if (cSVFormat.nullString != null) {
                        return false;
                    }
                } else if (!str.equals(cSVFormat.nullString)) {
                    return false;
                }
                if (Arrays.equals(this.header, cSVFormat.header) && this.ignoreSurroundingSpaces == cSVFormat.ignoreSurroundingSpaces && this.ignoreEmptyLines == cSVFormat.ignoreEmptyLines && this.skipHeaderRecord == cSVFormat.skipHeaderRecord) {
                    String str2 = this.recordSeparator;
                    if (str2 == null) {
                        if (cSVFormat.recordSeparator != null) {
                            return false;
                        }
                    } else if (!str2.equals(cSVFormat.recordSeparator)) {
                        return false;
                    }
                    return Arrays.equals(this.headerComments, cSVFormat.headerComments);
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public String format(Object... objArr) {
        StringWriter stringWriter = new StringWriter();
        try {
            CSVPrinter cSVPrinter = new CSVPrinter(stringWriter, this);
            cSVPrinter.printRecord(objArr);
            String trim = stringWriter.toString().trim();
            cSVPrinter.close();
            return trim;
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    public boolean getAllowDuplicateHeaderNames() {
        return this.allowDuplicateHeaderNames;
    }

    public boolean getAllowMissingColumnNames() {
        return this.allowMissingColumnNames;
    }

    public boolean getAutoFlush() {
        return this.autoFlush;
    }

    public Character getCommentMarker() {
        return this.commentMarker;
    }

    public char getDelimiter() {
        return this.delimiter;
    }

    public Character getEscapeCharacter() {
        return this.escapeCharacter;
    }

    public String[] getHeader() {
        String[] strArr = this.header;
        if (strArr != null) {
            return (String[]) strArr.clone();
        }
        return null;
    }

    public String[] getHeaderComments() {
        String[] strArr = this.headerComments;
        if (strArr != null) {
            return (String[]) strArr.clone();
        }
        return null;
    }

    public boolean getIgnoreEmptyLines() {
        return this.ignoreEmptyLines;
    }

    public boolean getIgnoreHeaderCase() {
        return this.ignoreHeaderCase;
    }

    public boolean getIgnoreSurroundingSpaces() {
        return this.ignoreSurroundingSpaces;
    }

    public String getNullString() {
        return this.nullString;
    }

    public Character getQuoteCharacter() {
        return this.quoteCharacter;
    }

    public QuoteMode getQuoteMode() {
        return this.quoteMode;
    }

    public String getRecordSeparator() {
        return this.recordSeparator;
    }

    public boolean getSkipHeaderRecord() {
        return this.skipHeaderRecord;
    }

    public boolean getTrailingDelimiter() {
        return this.trailingDelimiter;
    }

    public boolean getTrim() {
        return this.trim;
    }

    public int hashCode() {
        int i = (this.delimiter + 31) * 31;
        QuoteMode quoteMode = this.quoteMode;
        int hashCode = (i + (quoteMode == null ? 0 : quoteMode.hashCode())) * 31;
        Character ch2 = this.quoteCharacter;
        int hashCode2 = (hashCode + (ch2 == null ? 0 : ch2.hashCode())) * 31;
        Character ch3 = this.commentMarker;
        int hashCode3 = (hashCode2 + (ch3 == null ? 0 : ch3.hashCode())) * 31;
        Character ch4 = this.escapeCharacter;
        int hashCode4 = (hashCode3 + (ch4 == null ? 0 : ch4.hashCode())) * 31;
        String str = this.nullString;
        int hashCode5 = (((((((((((((((((((hashCode4 + (str == null ? 0 : str.hashCode())) * 31) + (this.ignoreSurroundingSpaces ? 1231 : 1237)) * 31) + (this.ignoreHeaderCase ? 1231 : 1237)) * 31) + (this.ignoreEmptyLines ? 1231 : 1237)) * 31) + (this.skipHeaderRecord ? 1231 : 1237)) * 31) + (this.allowDuplicateHeaderNames ? 1231 : 1237)) * 31) + (this.trim ? 1231 : 1237)) * 31) + (this.autoFlush ? 1231 : 1237)) * 31) + (this.trailingDelimiter ? 1231 : 1237)) * 31) + (this.allowMissingColumnNames ? 1231 : 1237)) * 31;
        String str2 = this.recordSeparator;
        return ((((hashCode5 + (str2 != null ? str2.hashCode() : 0)) * 31) + Arrays.hashCode(this.header)) * 31) + Arrays.hashCode(this.headerComments);
    }

    public boolean isCommentMarkerSet() {
        return this.commentMarker != null;
    }

    public boolean isEscapeCharacterSet() {
        return this.escapeCharacter != null;
    }

    public boolean isNullStringSet() {
        return this.nullString != null;
    }

    public boolean isQuoteCharacterSet() {
        return this.quoteCharacter != null;
    }

    public CSVParser parse(Reader reader) throws IOException {
        return new CSVParser(reader, this);
    }

    public CSVPrinter print(Appendable appendable) throws IOException {
        return new CSVPrinter(appendable, this);
    }

    public CSVPrinter print(File file, Charset charset) throws IOException {
        return new CSVPrinter(new OutputStreamWriter(new FileOutputStream(file), charset), this);
    }

    public void print(Object obj, Appendable appendable, boolean z) throws IOException {
        CharSequence obj2;
        if (obj == null) {
            if (this.nullString == null) {
                obj2 = "";
            } else if (QuoteMode.ALL == this.quoteMode) {
                obj2 = this.quotedNullString;
            } else {
                obj2 = this.nullString;
            }
        } else if (obj instanceof CharSequence) {
            obj2 = (CharSequence) obj;
        } else if (obj instanceof Reader) {
            print((Reader) obj, appendable, z);
            return;
        } else {
            obj2 = obj.toString();
        }
        if (getTrim()) {
            obj2 = trim(obj2);
        }
        print(obj, obj2, appendable, z);
    }

    private void print(Object obj, CharSequence charSequence, Appendable appendable, boolean z) throws IOException {
        int length = charSequence.length();
        if (!z) {
            appendable.append(getDelimiter());
        }
        if (obj == null) {
            appendable.append(charSequence);
        } else if (isQuoteCharacterSet()) {
            printWithQuotes(obj, charSequence, appendable, z);
        } else if (isEscapeCharacterSet()) {
            printWithEscapes(charSequence, appendable);
        } else {
            appendable.append(charSequence, 0, length);
        }
    }

    public CSVPrinter print(Path path, Charset charset) throws IOException {
        return print(Files.newBufferedWriter(path, charset, new OpenOption[0]));
    }

    private void print(Reader reader, Appendable appendable, boolean z) throws IOException {
        if (!z) {
            appendable.append(getDelimiter());
        }
        if (isQuoteCharacterSet()) {
            printWithQuotes(reader, appendable);
        } else if (isEscapeCharacterSet()) {
            printWithEscapes(reader, appendable);
        } else if (appendable instanceof Writer) {
            IOUtils.copyLarge(reader, (Writer) appendable);
        } else {
            IOUtils.copy(reader, appendable);
        }
    }

    public CSVPrinter printer() throws IOException {
        return new CSVPrinter(System.out, this);
    }

    public void println(Appendable appendable) throws IOException {
        if (getTrailingDelimiter()) {
            appendable.append(getDelimiter());
        }
        String str = this.recordSeparator;
        if (str != null) {
            appendable.append(str);
        }
    }

    public void printRecord(Appendable appendable, Object... objArr) throws IOException {
        int i = 0;
        while (i < objArr.length) {
            print(objArr[i], appendable, i == 0);
            i++;
        }
        println(appendable);
    }

    private void printWithEscapes(CharSequence charSequence, Appendable appendable) throws IOException {
        int length = charSequence.length();
        char delimiter = getDelimiter();
        char charValue = getEscapeCharacter().charValue();
        int i = 0;
        int i2 = 0;
        while (i < length) {
            char charAt = charSequence.charAt(i);
            if (charAt == '\r' || charAt == '\n' || charAt == delimiter || charAt == charValue) {
                if (i > i2) {
                    appendable.append(charSequence, i2, i);
                }
                if (charAt == '\n') {
                    charAt = 'n';
                } else if (charAt == '\r') {
                    charAt = 'r';
                }
                appendable.append(charValue);
                appendable.append(charAt);
                i2 = i + 1;
            }
            i++;
        }
        if (i > i2) {
            appendable.append(charSequence, i2, i);
        }
    }

    private void printWithEscapes(Reader reader, Appendable appendable) throws IOException {
        char delimiter = getDelimiter();
        char charValue = getEscapeCharacter().charValue();
        StringBuilder sb = new StringBuilder(4096);
        int i = 0;
        int i2 = 0;
        while (true) {
            int read = reader.read();
            if (-1 == read) {
                break;
            }
            sb.append((char) read);
            if (read == 13 || read == 10 || read == delimiter || read == charValue) {
                if (i > i2) {
                    appendable.append(sb.substring(i2, i));
                    sb.setLength(0);
                }
                if (read == 10) {
                    read = 110;
                } else if (read == 13) {
                    read = 114;
                }
                appendable.append(charValue);
                appendable.append((char) read);
                i2 = i + 1;
            }
            i++;
        }
        if (i > i2) {
            appendable.append(sb.substring(i2, i));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0078, code lost:
        if (r11.charAt(r10) <= ' ') goto L20;
     */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00a7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void printWithQuotes(java.lang.Object r10, java.lang.CharSequence r11, java.lang.Appendable r12, boolean r13) throws java.io.IOException {
        /*
            r9 = this;
            int r0 = r11.length()
            char r1 = r9.getDelimiter()
            java.lang.Character r2 = r9.getQuoteCharacter()
            char r2 = r2.charValue()
            boolean r3 = r9.isEscapeCharacterSet()
            if (r3 == 0) goto L1f
            java.lang.Character r3 = r9.getEscapeCharacter()
            char r3 = r3.charValue()
            goto L20
        L1f:
            r3 = r2
        L20:
            org.apache.commons.csv.QuoteMode r4 = r9.getQuoteMode()
            if (r4 != 0) goto L28
            org.apache.commons.csv.QuoteMode r4 = org.apache.commons.csv.QuoteMode.MINIMAL
        L28:
            int[] r5 = org.apache.commons.csv.CSVFormat.AnonymousClass1.$SwitchMap$org$apache$commons$csv$QuoteMode
            int r6 = r4.ordinal()
            r5 = r5[r6]
            r6 = 0
            r7 = 1
            if (r5 == r7) goto La0
            r8 = 2
            if (r5 == r8) goto La0
            r8 = 3
            if (r5 == r8) goto L9d
            r10 = 4
            if (r5 == r10) goto L99
            r10 = 5
            if (r5 != r10) goto L82
            if (r0 > 0) goto L48
            if (r13 == 0) goto L45
            goto L50
        L45:
            r10 = r6
            r7 = r10
            goto L7c
        L48:
            char r10 = r11.charAt(r6)
            r13 = 35
            if (r10 > r13) goto L52
        L50:
            r10 = r6
            goto L7c
        L52:
            r10 = r6
        L53:
            if (r10 >= r0) goto L6d
            char r13 = r11.charAt(r10)
            r4 = 10
            if (r13 == r4) goto L6b
            r4 = 13
            if (r13 == r4) goto L6b
            if (r13 == r2) goto L6b
            if (r13 == r1) goto L6b
            if (r13 != r3) goto L68
            goto L6b
        L68:
            int r10 = r10 + 1
            goto L53
        L6b:
            r13 = r7
            goto L6e
        L6d:
            r13 = r6
        L6e:
            if (r13 != 0) goto L7b
            int r10 = r0 + (-1)
            char r1 = r11.charAt(r10)
            r4 = 32
            if (r1 > r4) goto L7b
            goto L7c
        L7b:
            r7 = r13
        L7c:
            if (r7 != 0) goto La1
            r12.append(r11, r6, r0)
            return
        L82:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "Unexpected Quote value: "
            r11.append(r12)
            r11.append(r4)
            java.lang.String r11 = r11.toString()
            r10.<init>(r11)
            throw r10
        L99:
            r9.printWithEscapes(r11, r12)
            return
        L9d:
            boolean r10 = r10 instanceof java.lang.Number
            r7 = r7 ^ r10
        La0:
            r10 = r6
        La1:
            if (r7 != 0) goto La7
            r12.append(r11, r6, r0)
            return
        La7:
            r12.append(r2)
        Laa:
            if (r10 >= r0) goto Lbe
            char r13 = r11.charAt(r10)
            if (r13 == r2) goto Lb4
            if (r13 != r3) goto Lbb
        Lb4:
            r12.append(r11, r6, r10)
            r12.append(r3)
            r6 = r10
        Lbb:
            int r10 = r10 + 1
            goto Laa
        Lbe:
            r12.append(r11, r6, r10)
            r12.append(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.csv.CSVFormat.printWithQuotes(java.lang.Object, java.lang.CharSequence, java.lang.Appendable, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: org.apache.commons.csv.CSVFormat$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$csv$QuoteMode;

        static {
            int[] iArr = new int[QuoteMode.values().length];
            $SwitchMap$org$apache$commons$csv$QuoteMode = iArr;
            try {
                iArr[QuoteMode.ALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$commons$csv$QuoteMode[QuoteMode.ALL_NON_NULL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$commons$csv$QuoteMode[QuoteMode.NON_NUMERIC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$commons$csv$QuoteMode[QuoteMode.NONE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$apache$commons$csv$QuoteMode[QuoteMode.MINIMAL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    private void printWithQuotes(Reader reader, Appendable appendable) throws IOException {
        if (getQuoteMode() == QuoteMode.NONE) {
            printWithEscapes(reader, appendable);
            return;
        }
        char charValue = getQuoteCharacter().charValue();
        StringBuilder sb = new StringBuilder(4096);
        appendable.append(charValue);
        int i = 0;
        while (true) {
            int read = reader.read();
            if (-1 == read) {
                break;
            }
            char c = (char) read;
            sb.append(c);
            if (read == charValue) {
                if (i > 0) {
                    appendable.append(sb.substring(0, i));
                    sb.setLength(0);
                    i = -1;
                }
                appendable.append(charValue);
                appendable.append(c);
            }
            i++;
        }
        if (i > 0) {
            appendable.append(sb.substring(0, i));
        }
        appendable.append(charValue);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Delimiter=<");
        sb.append(this.delimiter);
        sb.append(Typography.greater);
        if (isEscapeCharacterSet()) {
            sb.append(' ');
            sb.append("Escape=<");
            sb.append(this.escapeCharacter);
            sb.append(Typography.greater);
        }
        if (isQuoteCharacterSet()) {
            sb.append(' ');
            sb.append("QuoteChar=<");
            sb.append(this.quoteCharacter);
            sb.append(Typography.greater);
        }
        if (this.quoteMode != null) {
            sb.append(' ');
            sb.append("QuoteMode=<");
            sb.append(this.quoteMode);
            sb.append(Typography.greater);
        }
        if (isCommentMarkerSet()) {
            sb.append(' ');
            sb.append("CommentStart=<");
            sb.append(this.commentMarker);
            sb.append(Typography.greater);
        }
        if (isNullStringSet()) {
            sb.append(' ');
            sb.append("NullString=<");
            sb.append(this.nullString);
            sb.append(Typography.greater);
        }
        if (this.recordSeparator != null) {
            sb.append(' ');
            sb.append("RecordSeparator=<");
            sb.append(this.recordSeparator);
            sb.append(Typography.greater);
        }
        if (getIgnoreEmptyLines()) {
            sb.append(" EmptyLines:ignored");
        }
        if (getIgnoreSurroundingSpaces()) {
            sb.append(" SurroundingSpaces:ignored");
        }
        if (getIgnoreHeaderCase()) {
            sb.append(" IgnoreHeaderCase:ignored");
        }
        sb.append(" SkipHeaderRecord:");
        sb.append(this.skipHeaderRecord);
        if (this.headerComments != null) {
            sb.append(' ');
            sb.append("HeaderComments:");
            sb.append(Arrays.toString(this.headerComments));
        }
        if (this.header != null) {
            sb.append(' ');
            sb.append("Header:");
            sb.append(Arrays.toString(this.header));
        }
        return sb.toString();
    }

    private String[] toStringArray(Object[] objArr) {
        if (objArr == null) {
            return null;
        }
        String[] strArr = new String[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            Object obj = objArr[i];
            strArr[i] = obj == null ? null : obj.toString();
        }
        return strArr;
    }

    private CharSequence trim(CharSequence charSequence) {
        if (charSequence instanceof String) {
            return ((String) charSequence).trim();
        }
        int length = charSequence.length();
        int i = 0;
        while (i < length && charSequence.charAt(i) <= ' ') {
            i++;
        }
        int i2 = length;
        while (i < i2 && charSequence.charAt(i2 - 1) <= ' ') {
            i2--;
        }
        return (i > 0 || i2 < length) ? charSequence.subSequence(i, i2) : charSequence;
    }

    private void validate() throws IllegalArgumentException {
        String[] strArr;
        if (isLineBreak(this.delimiter)) {
            throw new IllegalArgumentException("The delimiter cannot be a line break");
        }
        Character ch2 = this.quoteCharacter;
        if (ch2 != null && this.delimiter == ch2.charValue()) {
            throw new IllegalArgumentException("The quoteChar character and the delimiter cannot be the same ('" + this.quoteCharacter + "')");
        }
        Character ch3 = this.escapeCharacter;
        if (ch3 != null && this.delimiter == ch3.charValue()) {
            throw new IllegalArgumentException("The escape character and the delimiter cannot be the same ('" + this.escapeCharacter + "')");
        }
        Character ch4 = this.commentMarker;
        if (ch4 != null && this.delimiter == ch4.charValue()) {
            throw new IllegalArgumentException("The comment start character and the delimiter cannot be the same ('" + this.commentMarker + "')");
        }
        Character ch5 = this.quoteCharacter;
        if (ch5 != null && ch5.equals(this.commentMarker)) {
            throw new IllegalArgumentException("The comment start character and the quoteChar cannot be the same ('" + this.commentMarker + "')");
        }
        Character ch6 = this.escapeCharacter;
        if (ch6 != null && ch6.equals(this.commentMarker)) {
            throw new IllegalArgumentException("The comment start and the escape character cannot be the same ('" + this.commentMarker + "')");
        } else if (this.escapeCharacter == null && this.quoteMode == QuoteMode.NONE) {
            throw new IllegalArgumentException("No quotes mode set but no escape character is set");
        } else {
            if (this.header == null || this.allowDuplicateHeaderNames) {
                return;
            }
            HashSet hashSet = new HashSet();
            for (String str : this.header) {
                if (!hashSet.add(str)) {
                    throw new IllegalArgumentException("The header contains a duplicate entry: '" + str + "' in " + Arrays.toString(this.header));
                }
            }
        }
    }

    public CSVFormat withAllowDuplicateHeaderNames() {
        return withAllowDuplicateHeaderNames(true);
    }

    public CSVFormat withAllowDuplicateHeaderNames(boolean z) {
        return new CSVFormat(this.delimiter, this.quoteCharacter, this.quoteMode, this.commentMarker, this.escapeCharacter, this.ignoreSurroundingSpaces, this.ignoreEmptyLines, this.recordSeparator, this.nullString, this.headerComments, this.header, this.skipHeaderRecord, this.allowMissingColumnNames, this.ignoreHeaderCase, this.trim, this.trailingDelimiter, this.autoFlush, z);
    }

    public CSVFormat withAllowMissingColumnNames() {
        return withAllowMissingColumnNames(true);
    }

    public CSVFormat withAllowMissingColumnNames(boolean z) {
        return new CSVFormat(this.delimiter, this.quoteCharacter, this.quoteMode, this.commentMarker, this.escapeCharacter, this.ignoreSurroundingSpaces, this.ignoreEmptyLines, this.recordSeparator, this.nullString, this.headerComments, this.header, this.skipHeaderRecord, z, this.ignoreHeaderCase, this.trim, this.trailingDelimiter, this.autoFlush, this.allowDuplicateHeaderNames);
    }

    public CSVFormat withAutoFlush(boolean z) {
        return new CSVFormat(this.delimiter, this.quoteCharacter, this.quoteMode, this.commentMarker, this.escapeCharacter, this.ignoreSurroundingSpaces, this.ignoreEmptyLines, this.recordSeparator, this.nullString, this.headerComments, this.header, this.skipHeaderRecord, this.allowMissingColumnNames, this.ignoreHeaderCase, this.trim, this.trailingDelimiter, z, this.allowDuplicateHeaderNames);
    }

    public CSVFormat withCommentMarker(char c) {
        return withCommentMarker(Character.valueOf(c));
    }

    public CSVFormat withCommentMarker(Character ch2) {
        if (isLineBreak(ch2)) {
            throw new IllegalArgumentException("The comment start marker character cannot be a line break");
        }
        return new CSVFormat(this.delimiter, this.quoteCharacter, this.quoteMode, ch2, this.escapeCharacter, this.ignoreSurroundingSpaces, this.ignoreEmptyLines, this.recordSeparator, this.nullString, this.headerComments, this.header, this.skipHeaderRecord, this.allowMissingColumnNames, this.ignoreHeaderCase, this.trim, this.trailingDelimiter, this.autoFlush, this.allowDuplicateHeaderNames);
    }

    public CSVFormat withDelimiter(char c) {
        if (isLineBreak(c)) {
            throw new IllegalArgumentException("The delimiter cannot be a line break");
        }
        return new CSVFormat(c, this.quoteCharacter, this.quoteMode, this.commentMarker, this.escapeCharacter, this.ignoreSurroundingSpaces, this.ignoreEmptyLines, this.recordSeparator, this.nullString, this.headerComments, this.header, this.skipHeaderRecord, this.allowMissingColumnNames, this.ignoreHeaderCase, this.trim, this.trailingDelimiter, this.autoFlush, this.allowDuplicateHeaderNames);
    }

    public CSVFormat withEscape(char c) {
        return withEscape(Character.valueOf(c));
    }

    public CSVFormat withEscape(Character ch2) {
        if (isLineBreak(ch2)) {
            throw new IllegalArgumentException("The escape character cannot be a line break");
        }
        return new CSVFormat(this.delimiter, this.quoteCharacter, this.quoteMode, this.commentMarker, ch2, this.ignoreSurroundingSpaces, this.ignoreEmptyLines, this.recordSeparator, this.nullString, this.headerComments, this.header, this.skipHeaderRecord, this.allowMissingColumnNames, this.ignoreHeaderCase, this.trim, this.trailingDelimiter, this.autoFlush, this.allowDuplicateHeaderNames);
    }

    public CSVFormat withFirstRecordAsHeader() {
        return withHeader(new String[0]).withSkipHeaderRecord();
    }

    public CSVFormat withHeader(Class<? extends Enum<?>> cls) {
        String[] strArr;
        if (cls != null) {
            Enum[] enumArr = (Enum[]) cls.getEnumConstants();
            strArr = new String[enumArr.length];
            for (int i = 0; i < enumArr.length; i++) {
                strArr[i] = enumArr[i].name();
            }
        } else {
            strArr = null;
        }
        return withHeader(strArr);
    }

    public CSVFormat withHeader(ResultSet resultSet) throws SQLException {
        return withHeader(resultSet != null ? resultSet.getMetaData() : null);
    }

    public CSVFormat withHeader(ResultSetMetaData resultSetMetaData) throws SQLException {
        String[] strArr;
        if (resultSetMetaData != null) {
            int columnCount = resultSetMetaData.getColumnCount();
            strArr = new String[columnCount];
            int i = 0;
            while (i < columnCount) {
                int i2 = i + 1;
                strArr[i] = resultSetMetaData.getColumnLabel(i2);
                i = i2;
            }
        } else {
            strArr = null;
        }
        return withHeader(strArr);
    }

    public CSVFormat withHeader(String... strArr) {
        return new CSVFormat(this.delimiter, this.quoteCharacter, this.quoteMode, this.commentMarker, this.escapeCharacter, this.ignoreSurroundingSpaces, this.ignoreEmptyLines, this.recordSeparator, this.nullString, this.headerComments, strArr, this.skipHeaderRecord, this.allowMissingColumnNames, this.ignoreHeaderCase, this.trim, this.trailingDelimiter, this.autoFlush, this.allowDuplicateHeaderNames);
    }

    public CSVFormat withHeaderComments(Object... objArr) {
        return new CSVFormat(this.delimiter, this.quoteCharacter, this.quoteMode, this.commentMarker, this.escapeCharacter, this.ignoreSurroundingSpaces, this.ignoreEmptyLines, this.recordSeparator, this.nullString, objArr, this.header, this.skipHeaderRecord, this.allowMissingColumnNames, this.ignoreHeaderCase, this.trim, this.trailingDelimiter, this.autoFlush, this.allowDuplicateHeaderNames);
    }

    public CSVFormat withIgnoreEmptyLines() {
        return withIgnoreEmptyLines(true);
    }

    public CSVFormat withIgnoreEmptyLines(boolean z) {
        return new CSVFormat(this.delimiter, this.quoteCharacter, this.quoteMode, this.commentMarker, this.escapeCharacter, this.ignoreSurroundingSpaces, z, this.recordSeparator, this.nullString, this.headerComments, this.header, this.skipHeaderRecord, this.allowMissingColumnNames, this.ignoreHeaderCase, this.trim, this.trailingDelimiter, this.autoFlush, this.allowDuplicateHeaderNames);
    }

    public CSVFormat withIgnoreHeaderCase() {
        return withIgnoreHeaderCase(true);
    }

    public CSVFormat withIgnoreHeaderCase(boolean z) {
        return new CSVFormat(this.delimiter, this.quoteCharacter, this.quoteMode, this.commentMarker, this.escapeCharacter, this.ignoreSurroundingSpaces, this.ignoreEmptyLines, this.recordSeparator, this.nullString, this.headerComments, this.header, this.skipHeaderRecord, this.allowMissingColumnNames, z, this.trim, this.trailingDelimiter, this.autoFlush, this.allowDuplicateHeaderNames);
    }

    public CSVFormat withIgnoreSurroundingSpaces() {
        return withIgnoreSurroundingSpaces(true);
    }

    public CSVFormat withIgnoreSurroundingSpaces(boolean z) {
        return new CSVFormat(this.delimiter, this.quoteCharacter, this.quoteMode, this.commentMarker, this.escapeCharacter, z, this.ignoreEmptyLines, this.recordSeparator, this.nullString, this.headerComments, this.header, this.skipHeaderRecord, this.allowMissingColumnNames, this.ignoreHeaderCase, this.trim, this.trailingDelimiter, this.autoFlush, this.allowDuplicateHeaderNames);
    }

    public CSVFormat withNullString(String str) {
        return new CSVFormat(this.delimiter, this.quoteCharacter, this.quoteMode, this.commentMarker, this.escapeCharacter, this.ignoreSurroundingSpaces, this.ignoreEmptyLines, this.recordSeparator, str, this.headerComments, this.header, this.skipHeaderRecord, this.allowMissingColumnNames, this.ignoreHeaderCase, this.trim, this.trailingDelimiter, this.autoFlush, this.allowDuplicateHeaderNames);
    }

    public CSVFormat withQuote(char c) {
        return withQuote(Character.valueOf(c));
    }

    public CSVFormat withQuote(Character ch2) {
        if (isLineBreak(ch2)) {
            throw new IllegalArgumentException("The quoteChar cannot be a line break");
        }
        return new CSVFormat(this.delimiter, ch2, this.quoteMode, this.commentMarker, this.escapeCharacter, this.ignoreSurroundingSpaces, this.ignoreEmptyLines, this.recordSeparator, this.nullString, this.headerComments, this.header, this.skipHeaderRecord, this.allowMissingColumnNames, this.ignoreHeaderCase, this.trim, this.trailingDelimiter, this.autoFlush, this.allowDuplicateHeaderNames);
    }

    public CSVFormat withQuoteMode(QuoteMode quoteMode) {
        return new CSVFormat(this.delimiter, this.quoteCharacter, quoteMode, this.commentMarker, this.escapeCharacter, this.ignoreSurroundingSpaces, this.ignoreEmptyLines, this.recordSeparator, this.nullString, this.headerComments, this.header, this.skipHeaderRecord, this.allowMissingColumnNames, this.ignoreHeaderCase, this.trim, this.trailingDelimiter, this.autoFlush, this.allowDuplicateHeaderNames);
    }

    public CSVFormat withRecordSeparator(char c) {
        return withRecordSeparator(String.valueOf(c));
    }

    public CSVFormat withRecordSeparator(String str) {
        return new CSVFormat(this.delimiter, this.quoteCharacter, this.quoteMode, this.commentMarker, this.escapeCharacter, this.ignoreSurroundingSpaces, this.ignoreEmptyLines, str, this.nullString, this.headerComments, this.header, this.skipHeaderRecord, this.allowMissingColumnNames, this.ignoreHeaderCase, this.trim, this.trailingDelimiter, this.autoFlush, this.allowDuplicateHeaderNames);
    }

    public CSVFormat withSkipHeaderRecord() {
        return withSkipHeaderRecord(true);
    }

    public CSVFormat withSkipHeaderRecord(boolean z) {
        return new CSVFormat(this.delimiter, this.quoteCharacter, this.quoteMode, this.commentMarker, this.escapeCharacter, this.ignoreSurroundingSpaces, this.ignoreEmptyLines, this.recordSeparator, this.nullString, this.headerComments, this.header, z, this.allowMissingColumnNames, this.ignoreHeaderCase, this.trim, this.trailingDelimiter, this.autoFlush, this.allowDuplicateHeaderNames);
    }

    public CSVFormat withSystemRecordSeparator() {
        return withRecordSeparator(System.getProperty("line.separator"));
    }

    public CSVFormat withTrailingDelimiter() {
        return withTrailingDelimiter(true);
    }

    public CSVFormat withTrailingDelimiter(boolean z) {
        return new CSVFormat(this.delimiter, this.quoteCharacter, this.quoteMode, this.commentMarker, this.escapeCharacter, this.ignoreSurroundingSpaces, this.ignoreEmptyLines, this.recordSeparator, this.nullString, this.headerComments, this.header, this.skipHeaderRecord, this.allowMissingColumnNames, this.ignoreHeaderCase, this.trim, z, this.autoFlush, this.allowDuplicateHeaderNames);
    }

    public CSVFormat withTrim() {
        return withTrim(true);
    }

    public CSVFormat withTrim(boolean z) {
        return new CSVFormat(this.delimiter, this.quoteCharacter, this.quoteMode, this.commentMarker, this.escapeCharacter, this.ignoreSurroundingSpaces, this.ignoreEmptyLines, this.recordSeparator, this.nullString, this.headerComments, this.header, this.skipHeaderRecord, this.allowMissingColumnNames, this.ignoreHeaderCase, z, this.trailingDelimiter, this.autoFlush, this.allowDuplicateHeaderNames);
    }
}
