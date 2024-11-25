package org.apache.commons.csv;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
/* loaded from: classes2.dex */
public final class CSVRecord implements Serializable, Iterable<String> {
    private static final String[] EMPTY_STRING_ARRAY = new String[0];
    private static final long serialVersionUID = 1;
    private final long characterPosition;
    private final String comment;
    private final transient CSVParser parser;
    private final long recordNumber;
    private final String[] values;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CSVRecord(CSVParser cSVParser, String[] strArr, String str, long j, long j2) {
        this.recordNumber = j;
        this.values = strArr == null ? EMPTY_STRING_ARRAY : strArr;
        this.parser = cSVParser;
        this.comment = str;
        this.characterPosition = j2;
    }

    public String get(Enum<?> r2) {
        return get(Objects.toString(r2, null));
    }

    public String get(int i) {
        return this.values[i];
    }

    public String get(String str) {
        Map<String, Integer> headerMapRaw = getHeaderMapRaw();
        if (headerMapRaw == null) {
            throw new IllegalStateException("No header mapping was specified, the record values can't be accessed by name");
        }
        Integer num = headerMapRaw.get(str);
        if (num == null) {
            throw new IllegalArgumentException(String.format("Mapping for %s not found, expected one of %s", str, headerMapRaw.keySet()));
        }
        try {
            return this.values[num.intValue()];
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new IllegalArgumentException(String.format("Index for header '%s' is %d but CSVRecord only has %d values!", str, num, Integer.valueOf(this.values.length)));
        }
    }

    public long getCharacterPosition() {
        return this.characterPosition;
    }

    public String getComment() {
        return this.comment;
    }

    private Map<String, Integer> getHeaderMapRaw() {
        CSVParser cSVParser = this.parser;
        if (cSVParser == null) {
            return null;
        }
        return cSVParser.getHeaderMapRaw();
    }

    public CSVParser getParser() {
        return this.parser;
    }

    public long getRecordNumber() {
        return this.recordNumber;
    }

    public boolean hasComment() {
        return this.comment != null;
    }

    public boolean isConsistent() {
        Map<String, Integer> headerMapRaw = getHeaderMapRaw();
        return headerMapRaw == null || headerMapRaw.size() == this.values.length;
    }

    public boolean isMapped(String str) {
        Map<String, Integer> headerMapRaw = getHeaderMapRaw();
        return headerMapRaw != null && headerMapRaw.containsKey(str);
    }

    public boolean isSet(String str) {
        return isMapped(str) && getHeaderMapRaw().get(str).intValue() < this.values.length;
    }

    public boolean isSet(int i) {
        return i >= 0 && i < this.values.length;
    }

    @Override // java.lang.Iterable
    public Iterator<String> iterator() {
        return toList().iterator();
    }

    <M extends Map<String, String>> M putIn(M m) {
        if (getHeaderMapRaw() == null) {
            return m;
        }
        for (Map.Entry<String, Integer> entry : getHeaderMapRaw().entrySet()) {
            int intValue = entry.getValue().intValue();
            if (intValue < this.values.length) {
                m.put(entry.getKey(), this.values[intValue]);
            }
        }
        return m;
    }

    public int size() {
        return this.values.length;
    }

    private List<String> toList() {
        return Arrays.asList(this.values);
    }

    public Map<String, String> toMap() {
        return putIn(new LinkedHashMap(this.values.length));
    }

    public String toString() {
        return "CSVRecord [comment='" + this.comment + "', recordNumber=" + this.recordNumber + ", values=" + Arrays.toString(this.values) + "]";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String[] values() {
        return this.values;
    }
}
