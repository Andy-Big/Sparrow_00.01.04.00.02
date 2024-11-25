package javax.jmdns.impl.constants;
/* loaded from: classes2.dex */
public enum DNSLabel {
    Unknown("", 128),
    Standard("standard label", 0),
    Compressed("compressed label", 192),
    Extended("extended label", 64);
    
    static final int LABEL_MASK = 192;
    static final int LABEL_NOT_MASK = 63;
    private final String _externalName;
    private final int _index;

    public static int labelValue(int i) {
        return i & 63;
    }

    DNSLabel(String str, int i) {
        this._externalName = str;
        this._index = i;
    }

    public String externalName() {
        return this._externalName;
    }

    public int indexValue() {
        return this._index;
    }

    public static DNSLabel labelForByte(int i) {
        DNSLabel[] values;
        int i2 = i & 192;
        for (DNSLabel dNSLabel : values()) {
            if (dNSLabel._index == i2) {
                return dNSLabel;
            }
        }
        return Unknown;
    }

    @Override // java.lang.Enum
    public String toString() {
        return name() + " index " + indexValue();
    }
}
