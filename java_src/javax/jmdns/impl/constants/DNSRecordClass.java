package javax.jmdns.impl.constants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/* loaded from: classes2.dex */
public enum DNSRecordClass {
    CLASS_UNKNOWN("?", 0),
    CLASS_IN("in", 1),
    CLASS_CS("cs", 2),
    CLASS_CH("ch", 3),
    CLASS_HS("hs", 4),
    CLASS_NONE("none", 254),
    CLASS_ANY("any", 255);
    
    public static final int CLASS_MASK = 32767;
    public static final int CLASS_UNIQUE = 32768;
    public static final boolean NOT_UNIQUE = false;
    public static final boolean UNIQUE = true;
    private static Logger logger = LoggerFactory.getLogger(DNSRecordClass.class.getName());
    private final String _externalName;
    private final int _index;

    DNSRecordClass(String str, int i) {
        this._externalName = str;
        this._index = i;
    }

    public String externalName() {
        return this._externalName;
    }

    public int indexValue() {
        return this._index;
    }

    public boolean isUnique(int i) {
        return (this == CLASS_UNKNOWN || (i & 32768) == 0) ? false : true;
    }

    public static DNSRecordClass classForName(String str) {
        DNSRecordClass[] values;
        if (str != null) {
            String lowerCase = str.toLowerCase();
            for (DNSRecordClass dNSRecordClass : values()) {
                if (dNSRecordClass._externalName.equals(lowerCase)) {
                    return dNSRecordClass;
                }
            }
        }
        logger.warn("Could not find record class for name: {}", str);
        return CLASS_UNKNOWN;
    }

    public static DNSRecordClass classForIndex(int i) {
        DNSRecordClass[] values;
        int i2 = i & 32767;
        for (DNSRecordClass dNSRecordClass : values()) {
            if (dNSRecordClass._index == i2) {
                return dNSRecordClass;
            }
        }
        logger.warn("Could not find record class for index: {}", Integer.valueOf(i));
        return CLASS_UNKNOWN;
    }

    @Override // java.lang.Enum
    public String toString() {
        return name() + " index " + indexValue();
    }
}
