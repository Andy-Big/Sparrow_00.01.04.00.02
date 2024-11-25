package com.sun.mail.util;

import java.util.Properties;
import javax.mail.Session;
/* loaded from: classes2.dex */
public class PropUtil {
    private PropUtil() {
    }

    public static int getIntProperty(Properties properties, String str, int i) {
        return getInt(getProp(properties, str), i);
    }

    public static boolean getBooleanProperty(Properties properties, String str, boolean z) {
        return getBoolean(getProp(properties, str), z);
    }

    @Deprecated
    public static int getIntSessionProperty(Session session, String str, int i) {
        return getInt(getProp(session.getProperties(), str), i);
    }

    @Deprecated
    public static boolean getBooleanSessionProperty(Session session, String str, boolean z) {
        return getBoolean(getProp(session.getProperties(), str), z);
    }

    public static boolean getBooleanSystemProperty(String str, boolean z) {
        try {
            try {
                return getBoolean(getProp(System.getProperties(), str), z);
            } catch (SecurityException unused) {
                return z;
            }
        } catch (SecurityException unused2) {
            String property = System.getProperty(str);
            if (property == null) {
                return z;
            }
            if (z) {
                return !property.equalsIgnoreCase("false");
            }
            return property.equalsIgnoreCase("true");
        }
    }

    private static Object getProp(Properties properties, String str) {
        Object obj = properties.get(str);
        return obj != null ? obj : properties.getProperty(str);
    }

    private static int getInt(Object obj, int i) {
        if (obj == null) {
            return i;
        }
        if (obj instanceof String) {
            try {
                String str = (String) obj;
                if (str.startsWith("0x")) {
                    return Integer.parseInt(str.substring(2), 16);
                }
                return Integer.parseInt(str);
            } catch (NumberFormatException unused) {
            }
        }
        return obj instanceof Integer ? ((Integer) obj).intValue() : i;
    }

    private static boolean getBoolean(Object obj, boolean z) {
        if (obj == null) {
            return z;
        }
        if (!(obj instanceof String)) {
            return obj instanceof Boolean ? ((Boolean) obj).booleanValue() : z;
        } else if (z) {
            return !((String) obj).equalsIgnoreCase("false");
        } else {
            return ((String) obj).equalsIgnoreCase("true");
        }
    }
}
