package javax.mail;

import java.io.Serializable;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Vector;
/* loaded from: classes2.dex */
public class Flags implements Cloneable, Serializable {
    private static final int ANSWERED_BIT = 1;
    private static final int DELETED_BIT = 2;
    private static final int DRAFT_BIT = 4;
    private static final int FLAGGED_BIT = 8;
    private static final int RECENT_BIT = 16;
    private static final int SEEN_BIT = 32;
    private static final int USER_BIT = Integer.MIN_VALUE;
    private static final long serialVersionUID = 6243590407214169028L;
    private int system_flags;
    private Hashtable<String, String> user_flags;

    /* loaded from: classes2.dex */
    public static final class Flag {
        public static final Flag ANSWERED = new Flag(1);
        public static final Flag DELETED = new Flag(2);
        public static final Flag DRAFT = new Flag(4);
        public static final Flag FLAGGED = new Flag(8);
        public static final Flag RECENT = new Flag(16);
        public static final Flag SEEN = new Flag(32);
        public static final Flag USER = new Flag(Integer.MIN_VALUE);
        private int bit;

        private Flag(int i) {
            this.bit = i;
        }
    }

    public Flags() {
        this.system_flags = 0;
        this.user_flags = null;
    }

    public Flags(Flags flags) {
        this.system_flags = 0;
        this.user_flags = null;
        this.system_flags = flags.system_flags;
        Hashtable<String, String> hashtable = flags.user_flags;
        if (hashtable != null) {
            this.user_flags = (Hashtable) hashtable.clone();
        }
    }

    public Flags(Flag flag) {
        this.system_flags = 0;
        this.user_flags = null;
        this.system_flags = flag.bit | 0;
    }

    public Flags(String str) {
        this.system_flags = 0;
        this.user_flags = null;
        Hashtable<String, String> hashtable = new Hashtable<>(1);
        this.user_flags = hashtable;
        hashtable.put(str.toLowerCase(Locale.ENGLISH), str);
    }

    public void add(Flag flag) {
        this.system_flags = flag.bit | this.system_flags;
    }

    public void add(String str) {
        if (this.user_flags == null) {
            this.user_flags = new Hashtable<>(1);
        }
        this.user_flags.put(str.toLowerCase(Locale.ENGLISH), str);
    }

    public void add(Flags flags) {
        this.system_flags |= flags.system_flags;
        if (flags.user_flags != null) {
            if (this.user_flags == null) {
                this.user_flags = new Hashtable<>(1);
            }
            Enumeration<String> keys = flags.user_flags.keys();
            while (keys.hasMoreElements()) {
                String nextElement = keys.nextElement();
                this.user_flags.put(nextElement, flags.user_flags.get(nextElement));
            }
        }
    }

    public void remove(Flag flag) {
        this.system_flags = (~flag.bit) & this.system_flags;
    }

    public void remove(String str) {
        Hashtable<String, String> hashtable = this.user_flags;
        if (hashtable != null) {
            hashtable.remove(str.toLowerCase(Locale.ENGLISH));
        }
    }

    public void remove(Flags flags) {
        this.system_flags &= ~flags.system_flags;
        Hashtable<String, String> hashtable = flags.user_flags;
        if (hashtable == null || this.user_flags == null) {
            return;
        }
        Enumeration<String> keys = hashtable.keys();
        while (keys.hasMoreElements()) {
            this.user_flags.remove(keys.nextElement());
        }
    }

    public boolean retainAll(Flags flags) {
        boolean z;
        int i = this.system_flags;
        int i2 = flags.system_flags & i;
        if (i != i2) {
            this.system_flags = i2;
            z = true;
        } else {
            z = false;
        }
        Hashtable<String, String> hashtable = this.user_flags;
        if (hashtable == null || (flags.system_flags & Integer.MIN_VALUE) != 0) {
            return z;
        }
        if (flags.user_flags != null) {
            Enumeration<String> keys = hashtable.keys();
            while (keys.hasMoreElements()) {
                String nextElement = keys.nextElement();
                if (!flags.user_flags.containsKey(nextElement)) {
                    this.user_flags.remove(nextElement);
                    z = true;
                }
            }
            return z;
        }
        boolean z2 = hashtable.size() > 0;
        this.user_flags = null;
        return z2;
    }

    public boolean contains(Flag flag) {
        return (flag.bit & this.system_flags) != 0;
    }

    public boolean contains(String str) {
        Hashtable<String, String> hashtable = this.user_flags;
        if (hashtable == null) {
            return false;
        }
        return hashtable.containsKey(str.toLowerCase(Locale.ENGLISH));
    }

    public boolean contains(Flags flags) {
        int i = flags.system_flags;
        if ((this.system_flags & i) != i) {
            return false;
        }
        Hashtable<String, String> hashtable = flags.user_flags;
        if (hashtable != null) {
            if (this.user_flags == null) {
                return false;
            }
            Enumeration<String> keys = hashtable.keys();
            while (keys.hasMoreElements()) {
                if (!this.user_flags.containsKey(keys.nextElement())) {
                    return false;
                }
            }
            return true;
        }
        return true;
    }

    public boolean equals(Object obj) {
        Hashtable<String, String> hashtable;
        if (obj instanceof Flags) {
            Flags flags = (Flags) obj;
            if (flags.system_flags != this.system_flags) {
                return false;
            }
            Hashtable<String, String> hashtable2 = this.user_flags;
            int size = hashtable2 == null ? 0 : hashtable2.size();
            Hashtable<String, String> hashtable3 = flags.user_flags;
            int size2 = hashtable3 == null ? 0 : hashtable3.size();
            if (size == 0 && size2 == 0) {
                return true;
            }
            if (flags.user_flags == null || (hashtable = this.user_flags) == null || size2 != size) {
                return false;
            }
            return hashtable.keySet().equals(flags.user_flags.keySet());
        }
        return false;
    }

    public int hashCode() {
        int i = this.system_flags;
        Hashtable<String, String> hashtable = this.user_flags;
        if (hashtable != null) {
            Enumeration<String> keys = hashtable.keys();
            while (keys.hasMoreElements()) {
                i += keys.nextElement().hashCode();
            }
        }
        return i;
    }

    public Flag[] getSystemFlags() {
        Vector vector = new Vector();
        if ((this.system_flags & 1) != 0) {
            vector.addElement(Flag.ANSWERED);
        }
        if ((this.system_flags & 2) != 0) {
            vector.addElement(Flag.DELETED);
        }
        if ((this.system_flags & 4) != 0) {
            vector.addElement(Flag.DRAFT);
        }
        if ((this.system_flags & 8) != 0) {
            vector.addElement(Flag.FLAGGED);
        }
        if ((this.system_flags & 16) != 0) {
            vector.addElement(Flag.RECENT);
        }
        if ((this.system_flags & 32) != 0) {
            vector.addElement(Flag.SEEN);
        }
        if ((this.system_flags & Integer.MIN_VALUE) != 0) {
            vector.addElement(Flag.USER);
        }
        Flag[] flagArr = new Flag[vector.size()];
        vector.copyInto(flagArr);
        return flagArr;
    }

    public String[] getUserFlags() {
        Vector vector = new Vector();
        Hashtable<String, String> hashtable = this.user_flags;
        if (hashtable != null) {
            Enumeration<String> elements = hashtable.elements();
            while (elements.hasMoreElements()) {
                vector.addElement(elements.nextElement());
            }
        }
        String[] strArr = new String[vector.size()];
        vector.copyInto(strArr);
        return strArr;
    }

    public void clearSystemFlags() {
        this.system_flags = 0;
    }

    public void clearUserFlags() {
        this.user_flags = null;
    }

    public Object clone() {
        Flags flags;
        try {
            flags = (Flags) super.clone();
        } catch (CloneNotSupportedException unused) {
            flags = null;
        }
        Hashtable<String, String> hashtable = this.user_flags;
        if (hashtable != null) {
            flags.user_flags = (Hashtable) hashtable.clone();
        }
        return flags;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder();
        if ((this.system_flags & 1) != 0) {
            sb.append("\\Answered ");
        }
        if ((this.system_flags & 2) != 0) {
            sb.append("\\Deleted ");
        }
        if ((this.system_flags & 4) != 0) {
            sb.append("\\Draft ");
        }
        if ((this.system_flags & 8) != 0) {
            sb.append("\\Flagged ");
        }
        if ((this.system_flags & 16) != 0) {
            sb.append("\\Recent ");
        }
        if ((this.system_flags & 32) != 0) {
            sb.append("\\Seen ");
        }
        if ((this.system_flags & Integer.MIN_VALUE) != 0) {
            sb.append("\\* ");
        }
        Hashtable<String, String> hashtable = this.user_flags;
        if (hashtable != null) {
            Enumeration<String> elements = hashtable.elements();
            z = true;
            while (elements.hasMoreElements()) {
                if (z) {
                    z = false;
                } else {
                    sb.append(' ');
                }
                sb.append(elements.nextElement());
            }
        } else {
            z = true;
        }
        if (z && sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }
}
