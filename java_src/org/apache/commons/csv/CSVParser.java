package org.apache.commons.csv;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.TreeMap;
import org.apache.commons.csv.Token;
/* loaded from: classes2.dex */
public final class CSVParser implements Iterable<CSVRecord>, Closeable {
    private final long characterOffset;
    private final CSVRecordIterator csvRecordIterator;
    private final CSVFormat format;
    private final Map<String, Integer> headerMap;
    private final List<String> headerNames;
    private final Lexer lexer;
    private final List<String> recordList;
    private long recordNumber;
    private final Token reusableToken;

    /* loaded from: classes2.dex */
    class CSVRecordIterator implements Iterator<CSVRecord> {
        private CSVRecord current;

        CSVRecordIterator() {
        }

        private CSVRecord getNextRecord() {
            try {
                return CSVParser.this.nextRecord();
            } catch (IOException e) {
                throw new IllegalStateException(e.getClass().getSimpleName() + " reading next record: " + e.toString(), e);
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (CSVParser.this.isClosed()) {
                return false;
            }
            if (this.current == null) {
                this.current = getNextRecord();
            }
            return this.current != null;
        }

        @Override // java.util.Iterator
        public CSVRecord next() {
            if (CSVParser.this.isClosed()) {
                throw new NoSuchElementException("CSVParser has been closed");
            }
            CSVRecord cSVRecord = this.current;
            this.current = null;
            if (cSVRecord == null && (cSVRecord = getNextRecord()) == null) {
                throw new NoSuchElementException("No more CSV records available");
            }
            return cSVRecord;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static CSVParser parse(File file, Charset charset, CSVFormat cSVFormat) throws IOException {
        Assertions.notNull(file, "file");
        Assertions.notNull(cSVFormat, "format");
        return new CSVParser(new InputStreamReader(new FileInputStream(file), charset), cSVFormat);
    }

    public static CSVParser parse(InputStream inputStream, Charset charset, CSVFormat cSVFormat) throws IOException {
        Assertions.notNull(inputStream, "inputStream");
        Assertions.notNull(cSVFormat, "format");
        return parse(new InputStreamReader(inputStream, charset), cSVFormat);
    }

    public static CSVParser parse(Path path, Charset charset, CSVFormat cSVFormat) throws IOException {
        Assertions.notNull(path, "path");
        Assertions.notNull(cSVFormat, "format");
        return parse(Files.newInputStream(path, new OpenOption[0]), charset, cSVFormat);
    }

    public static CSVParser parse(Reader reader, CSVFormat cSVFormat) throws IOException {
        return new CSVParser(reader, cSVFormat);
    }

    public static CSVParser parse(String str, CSVFormat cSVFormat) throws IOException {
        Assertions.notNull(str, "string");
        Assertions.notNull(cSVFormat, "format");
        return new CSVParser(new StringReader(str), cSVFormat);
    }

    public static CSVParser parse(URL url, Charset charset, CSVFormat cSVFormat) throws IOException {
        Assertions.notNull(url, "url");
        Assertions.notNull(charset, "charset");
        Assertions.notNull(cSVFormat, "format");
        return new CSVParser(new InputStreamReader(url.openStream(), charset), cSVFormat);
    }

    public CSVParser(Reader reader, CSVFormat cSVFormat) throws IOException {
        this(reader, cSVFormat, 0L, 1L);
    }

    public CSVParser(Reader reader, CSVFormat cSVFormat, long j, long j2) throws IOException {
        this.recordList = new ArrayList();
        this.reusableToken = new Token();
        Assertions.notNull(reader, "reader");
        Assertions.notNull(cSVFormat, "format");
        this.format = cSVFormat;
        this.lexer = new Lexer(cSVFormat, new ExtendedBufferedReader(reader));
        this.csvRecordIterator = new CSVRecordIterator();
        Headers createHeaders = createHeaders();
        this.headerMap = createHeaders.headerMap;
        this.headerNames = createHeaders.headerNames;
        this.characterOffset = j;
        this.recordNumber = j2 - 1;
    }

    private void addRecordValue(boolean z) {
        String sb = this.reusableToken.content.toString();
        if (this.format.getTrim()) {
            sb = sb.trim();
        }
        if (z && sb.isEmpty() && this.format.getTrailingDelimiter()) {
            return;
        }
        String nullString = this.format.getNullString();
        List<String> list = this.recordList;
        if (sb.equals(nullString)) {
            sb = null;
        }
        list.add(sb);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Lexer lexer = this.lexer;
        if (lexer != null) {
            lexer.close();
        }
    }

    private Map<String, Integer> createEmptyHeaderMap() {
        return this.format.getIgnoreHeaderCase() ? new TreeMap(String.CASE_INSENSITIVE_ORDER) : new LinkedHashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class Headers {
        final Map<String, Integer> headerMap;
        final List<String> headerNames;

        Headers(Map<String, Integer> map, List<String> list) {
            this.headerMap = map;
            this.headerNames = list;
        }
    }

    private Headers createHeaders() throws IOException {
        Map<String, Integer> map;
        List unmodifiableList;
        String[] header = this.format.getHeader();
        ArrayList arrayList = null;
        if (header != null) {
            map = createEmptyHeaderMap();
            if (header.length == 0) {
                CSVRecord nextRecord = nextRecord();
                header = nextRecord != null ? nextRecord.values() : null;
            } else if (this.format.getSkipHeaderRecord()) {
                nextRecord();
            }
            if (header != null) {
                for (int i = 0; i < header.length; i++) {
                    String str = header[i];
                    boolean z = str == null || str.trim().isEmpty();
                    if (z && !this.format.getAllowMissingColumnNames()) {
                        throw new IllegalArgumentException("A header name is missing in " + Arrays.toString(header));
                    }
                    if ((str != null && map.containsKey(str)) && !z && !this.format.getAllowDuplicateHeaderNames()) {
                        throw new IllegalArgumentException(String.format("The header contains a duplicate name: \"%s\" in %s. If this is valid then use CSVFormat.withAllowDuplicateHeaderNames().", str, Arrays.toString(header)));
                    }
                    if (str != null) {
                        map.put(str, Integer.valueOf(i));
                        if (arrayList == null) {
                            arrayList = new ArrayList(header.length);
                        }
                        arrayList.add(str);
                    }
                }
            }
        } else {
            map = null;
        }
        if (arrayList == null) {
            unmodifiableList = Collections.emptyList();
        } else {
            unmodifiableList = Collections.unmodifiableList(arrayList);
        }
        return new Headers(map, unmodifiableList);
    }

    public long getCurrentLineNumber() {
        return this.lexer.getCurrentLineNumber();
    }

    public String getFirstEndOfLine() {
        return this.lexer.getFirstEol();
    }

    public Map<String, Integer> getHeaderMap() {
        if (this.headerMap == null) {
            return null;
        }
        Map<String, Integer> createEmptyHeaderMap = createEmptyHeaderMap();
        createEmptyHeaderMap.putAll(this.headerMap);
        return createEmptyHeaderMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map<String, Integer> getHeaderMapRaw() {
        return this.headerMap;
    }

    public List<String> getHeaderNames() {
        return this.headerNames;
    }

    public long getRecordNumber() {
        return this.recordNumber;
    }

    public List<CSVRecord> getRecords() throws IOException {
        ArrayList arrayList = new ArrayList();
        while (true) {
            CSVRecord nextRecord = nextRecord();
            if (nextRecord == null) {
                return arrayList;
            }
            arrayList.add(nextRecord);
        }
    }

    public boolean isClosed() {
        return this.lexer.isClosed();
    }

    @Override // java.lang.Iterable
    public Iterator<CSVRecord> iterator() {
        return this.csvRecordIterator;
    }

    CSVRecord nextRecord() throws IOException {
        this.recordList.clear();
        long characterPosition = this.lexer.getCharacterPosition() + this.characterOffset;
        StringBuilder sb = null;
        do {
            this.reusableToken.reset();
            this.lexer.nextToken(this.reusableToken);
            int i = AnonymousClass1.$SwitchMap$org$apache$commons$csv$Token$Type[this.reusableToken.type.ordinal()];
            if (i == 1) {
                addRecordValue(false);
            } else if (i == 2) {
                addRecordValue(true);
            } else if (i != 3) {
                if (i == 4) {
                    throw new IOException("(line " + getCurrentLineNumber() + ") invalid parse sequence");
                } else if (i == 5) {
                    if (sb == null) {
                        sb = new StringBuilder();
                    } else {
                        sb.append('\n');
                    }
                    sb.append((CharSequence) this.reusableToken.content);
                    this.reusableToken.type = Token.Type.TOKEN;
                } else {
                    throw new IllegalStateException("Unexpected Token type: " + this.reusableToken.type);
                }
            } else if (this.reusableToken.isReady) {
                addRecordValue(true);
            }
        } while (this.reusableToken.type == Token.Type.TOKEN);
        if (this.recordList.isEmpty()) {
            return null;
        }
        this.recordNumber++;
        String sb2 = sb != null ? sb.toString() : null;
        List<String> list = this.recordList;
        return new CSVRecord(this, (String[]) list.toArray(new String[list.size()]), sb2, this.recordNumber, characterPosition);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: org.apache.commons.csv.CSVParser$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$csv$Token$Type;

        static {
            int[] iArr = new int[Token.Type.values().length];
            $SwitchMap$org$apache$commons$csv$Token$Type = iArr;
            try {
                iArr[Token.Type.TOKEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$commons$csv$Token$Type[Token.Type.EORECORD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$commons$csv$Token$Type[Token.Type.EOF.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$commons$csv$Token$Type[Token.Type.INVALID.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$apache$commons$csv$Token$Type[Token.Type.COMMENT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }
}
