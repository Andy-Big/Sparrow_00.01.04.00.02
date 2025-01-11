package com.blankj.utilcode.util;

import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class SPStaticUtils {
    private static SPUtils sDefaultSPUtils;

    public static void setDefaultSPUtils(SPUtils sPUtils) {
        sDefaultSPUtils = sPUtils;
    }

    public static void put(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        put(str, str2, getDefaultSPUtils());
    }

    public static void put(String str, String str2, boolean z) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        put(str, str2, z, getDefaultSPUtils());
    }

    public static String getString(String str) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        return getString(str, getDefaultSPUtils());
    }

    public static String getString(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        return getString(str, str2, getDefaultSPUtils());
    }

    public static void put(String str, int i) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        put(str, i, getDefaultSPUtils());
    }

    public static void put(String str, int i, boolean z) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        put(str, i, z, getDefaultSPUtils());
    }

    public static int getInt(String str) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        return getInt(str, getDefaultSPUtils());
    }

    public static int getInt(String str, int i) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        return getInt(str, i, getDefaultSPUtils());
    }

    public static void put(String str, long j) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        put(str, j, getDefaultSPUtils());
    }

    public static void put(String str, long j, boolean z) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        put(str, j, z, getDefaultSPUtils());
    }

    public static long getLong(String str) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        return getLong(str, getDefaultSPUtils());
    }

    public static long getLong(String str, long j) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        return getLong(str, j, getDefaultSPUtils());
    }

    public static void put(String str, float f) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        put(str, f, getDefaultSPUtils());
    }

    public static void put(String str, float f, boolean z) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        put(str, f, z, getDefaultSPUtils());
    }

    public static float getFloat(String str) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        return getFloat(str, getDefaultSPUtils());
    }

    public static float getFloat(String str, float f) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        return getFloat(str, f, getDefaultSPUtils());
    }

    public static void put(String str, boolean z) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        put(str, z, getDefaultSPUtils());
    }

    public static void put(String str, boolean z, boolean z2) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        put(str, z, z2, getDefaultSPUtils());
    }

    public static boolean getBoolean(String str) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        return getBoolean(str, getDefaultSPUtils());
    }

    public static boolean getBoolean(String str, boolean z) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        return getBoolean(str, z, getDefaultSPUtils());
    }

    public static void put(String str, Set<String> set) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        put(str, set, getDefaultSPUtils());
    }

    public static void put(String str, Set<String> set, boolean z) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        put(str, set, z, getDefaultSPUtils());
    }

    public static Set<String> getStringSet(String str) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        return getStringSet(str, getDefaultSPUtils());
    }

    public static Set<String> getStringSet(String str, Set<String> set) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        return getStringSet(str, set, getDefaultSPUtils());
    }

    public static Map<String, ?> getAll() {
        return getAll(getDefaultSPUtils());
    }

    public static boolean contains(String str) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        return contains(str, getDefaultSPUtils());
    }

    public static void remove(String str) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        remove(str, getDefaultSPUtils());
    }

    public static void remove(String str, boolean z) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        remove(str, z, getDefaultSPUtils());
    }

    public static void clear() {
        clear(getDefaultSPUtils());
    }

    public static void clear(boolean z) {
        clear(z, getDefaultSPUtils());
    }

    public static void put(String str, String str2, SPUtils sPUtils) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        if (sPUtils == null) {
            throw new NullPointerException("Argument 'spUtils' of type SPUtils (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        sPUtils.put(str, str2);
    }

    public static void put(String str, String str2, boolean z, SPUtils sPUtils) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        if (sPUtils == null) {
            throw new NullPointerException("Argument 'spUtils' of type SPUtils (#3 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        sPUtils.put(str, str2, z);
    }

    public static String getString(String str, SPUtils sPUtils) {
        if (str != null) {
            if (sPUtils == null) {
                throw new NullPointerException("Argument 'spUtils' of type SPUtils (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            }
            return sPUtils.getString(str);
        }
        throw new NullPointerException("Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    public static String getString(String str, String str2, SPUtils sPUtils) {
        if (str != null) {
            if (sPUtils == null) {
                throw new NullPointerException("Argument 'spUtils' of type SPUtils (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            }
            return sPUtils.getString(str, str2);
        }
        throw new NullPointerException("Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    public static void put(String str, int i, SPUtils sPUtils) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        if (sPUtils == null) {
            throw new NullPointerException("Argument 'spUtils' of type SPUtils (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        sPUtils.put(str, i);
    }

    public static void put(String str, int i, boolean z, SPUtils sPUtils) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        if (sPUtils == null) {
            throw new NullPointerException("Argument 'spUtils' of type SPUtils (#3 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        sPUtils.put(str, i, z);
    }

    public static int getInt(String str, SPUtils sPUtils) {
        if (str != null) {
            if (sPUtils == null) {
                throw new NullPointerException("Argument 'spUtils' of type SPUtils (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            }
            return sPUtils.getInt(str);
        }
        throw new NullPointerException("Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    public static int getInt(String str, int i, SPUtils sPUtils) {
        if (str != null) {
            if (sPUtils == null) {
                throw new NullPointerException("Argument 'spUtils' of type SPUtils (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            }
            return sPUtils.getInt(str, i);
        }
        throw new NullPointerException("Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    public static void put(String str, long j, SPUtils sPUtils) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        if (sPUtils == null) {
            throw new NullPointerException("Argument 'spUtils' of type SPUtils (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        sPUtils.put(str, j);
    }

    public static void put(String str, long j, boolean z, SPUtils sPUtils) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        if (sPUtils == null) {
            throw new NullPointerException("Argument 'spUtils' of type SPUtils (#3 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        sPUtils.put(str, j, z);
    }

    public static long getLong(String str, SPUtils sPUtils) {
        if (str != null) {
            if (sPUtils == null) {
                throw new NullPointerException("Argument 'spUtils' of type SPUtils (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            }
            return sPUtils.getLong(str);
        }
        throw new NullPointerException("Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    public static long getLong(String str, long j, SPUtils sPUtils) {
        if (str != null) {
            if (sPUtils == null) {
                throw new NullPointerException("Argument 'spUtils' of type SPUtils (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            }
            return sPUtils.getLong(str, j);
        }
        throw new NullPointerException("Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    public static void put(String str, float f, SPUtils sPUtils) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        if (sPUtils == null) {
            throw new NullPointerException("Argument 'spUtils' of type SPUtils (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        sPUtils.put(str, f);
    }

    public static void put(String str, float f, boolean z, SPUtils sPUtils) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        if (sPUtils == null) {
            throw new NullPointerException("Argument 'spUtils' of type SPUtils (#3 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        sPUtils.put(str, f, z);
    }

    public static float getFloat(String str, SPUtils sPUtils) {
        if (str != null) {
            if (sPUtils == null) {
                throw new NullPointerException("Argument 'spUtils' of type SPUtils (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            }
            return sPUtils.getFloat(str);
        }
        throw new NullPointerException("Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    public static float getFloat(String str, float f, SPUtils sPUtils) {
        if (str != null) {
            if (sPUtils == null) {
                throw new NullPointerException("Argument 'spUtils' of type SPUtils (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            }
            return sPUtils.getFloat(str, f);
        }
        throw new NullPointerException("Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    public static void put(String str, boolean z, SPUtils sPUtils) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        if (sPUtils == null) {
            throw new NullPointerException("Argument 'spUtils' of type SPUtils (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        sPUtils.put(str, z);
    }

    public static void put(String str, boolean z, boolean z2, SPUtils sPUtils) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        if (sPUtils == null) {
            throw new NullPointerException("Argument 'spUtils' of type SPUtils (#3 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        sPUtils.put(str, z, z2);
    }

    public static boolean getBoolean(String str, SPUtils sPUtils) {
        if (str != null) {
            if (sPUtils == null) {
                throw new NullPointerException("Argument 'spUtils' of type SPUtils (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            }
            return sPUtils.getBoolean(str);
        }
        throw new NullPointerException("Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    public static boolean getBoolean(String str, boolean z, SPUtils sPUtils) {
        if (str != null) {
            if (sPUtils == null) {
                throw new NullPointerException("Argument 'spUtils' of type SPUtils (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            }
            return sPUtils.getBoolean(str, z);
        }
        throw new NullPointerException("Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    public static void put(String str, Set<String> set, SPUtils sPUtils) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        if (sPUtils == null) {
            throw new NullPointerException("Argument 'spUtils' of type SPUtils (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        sPUtils.put(str, set);
    }

    public static void put(String str, Set<String> set, boolean z, SPUtils sPUtils) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        if (sPUtils == null) {
            throw new NullPointerException("Argument 'spUtils' of type SPUtils (#3 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        sPUtils.put(str, set, z);
    }

    public static Set<String> getStringSet(String str, SPUtils sPUtils) {
        if (str != null) {
            if (sPUtils == null) {
                throw new NullPointerException("Argument 'spUtils' of type SPUtils (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            }
            return sPUtils.getStringSet(str);
        }
        throw new NullPointerException("Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    public static Set<String> getStringSet(String str, Set<String> set, SPUtils sPUtils) {
        if (str != null) {
            if (sPUtils == null) {
                throw new NullPointerException("Argument 'spUtils' of type SPUtils (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            }
            return sPUtils.getStringSet(str, set);
        }
        throw new NullPointerException("Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    public static Map<String, ?> getAll(SPUtils sPUtils) {
        if (sPUtils == null) {
            throw new NullPointerException("Argument 'spUtils' of type SPUtils (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        return sPUtils.getAll();
    }

    public static boolean contains(String str, SPUtils sPUtils) {
        if (str != null) {
            if (sPUtils == null) {
                throw new NullPointerException("Argument 'spUtils' of type SPUtils (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            }
            return sPUtils.contains(str);
        }
        throw new NullPointerException("Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    public static void remove(String str, SPUtils sPUtils) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        if (sPUtils == null) {
            throw new NullPointerException("Argument 'spUtils' of type SPUtils (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        sPUtils.remove(str);
    }

    public static void remove(String str, boolean z, SPUtils sPUtils) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        if (sPUtils == null) {
            throw new NullPointerException("Argument 'spUtils' of type SPUtils (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        sPUtils.remove(str, z);
    }

    public static void clear(SPUtils sPUtils) {
        if (sPUtils == null) {
            throw new NullPointerException("Argument 'spUtils' of type SPUtils (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        sPUtils.clear();
    }

    public static void clear(boolean z, SPUtils sPUtils) {
        if (sPUtils == null) {
            throw new NullPointerException("Argument 'spUtils' of type SPUtils (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        sPUtils.clear(z);
    }

    private static SPUtils getDefaultSPUtils() {
        SPUtils sPUtils = sDefaultSPUtils;
        return sPUtils != null ? sPUtils : SPUtils.getInstance();
    }
}
