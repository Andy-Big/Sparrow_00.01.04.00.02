package com.blankj.utilcode.util;

/* loaded from: classes.dex */
public final class CacheMemoryStaticUtils {
    private static CacheMemoryUtils sDefaultCacheMemoryUtils;

    public static void setDefaultCacheMemoryUtils(CacheMemoryUtils cacheMemoryUtils) {
        sDefaultCacheMemoryUtils = cacheMemoryUtils;
    }

    public static void put(String str, Object obj) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        put(str, obj, getDefaultCacheMemoryUtils());
    }

    public static void put(String str, Object obj, int i) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        put(str, obj, i, getDefaultCacheMemoryUtils());
    }

    public static <T> T get(String str) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        return (T) get(str, getDefaultCacheMemoryUtils());
    }

    public static <T> T get(String str, T t) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        return (T) get(str, t, getDefaultCacheMemoryUtils());
    }

    public static int getCacheCount() {
        return getCacheCount(getDefaultCacheMemoryUtils());
    }

    public static Object remove(String str) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        return remove(str, getDefaultCacheMemoryUtils());
    }

    public static void clear() {
        clear(getDefaultCacheMemoryUtils());
    }

    public static void put(String str, Object obj, CacheMemoryUtils cacheMemoryUtils) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        if (cacheMemoryUtils == null) {
            throw new NullPointerException("Argument 'cacheMemoryUtils' of type CacheMemoryUtils (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        cacheMemoryUtils.put(str, obj);
    }

    public static void put(String str, Object obj, int i, CacheMemoryUtils cacheMemoryUtils) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        if (cacheMemoryUtils == null) {
            throw new NullPointerException("Argument 'cacheMemoryUtils' of type CacheMemoryUtils (#3 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        cacheMemoryUtils.put(str, obj, i);
    }

    public static <T> T get(String str, CacheMemoryUtils cacheMemoryUtils) {
        if (str != null) {
            if (cacheMemoryUtils == null) {
                throw new NullPointerException("Argument 'cacheMemoryUtils' of type CacheMemoryUtils (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            }
            return (T) cacheMemoryUtils.get(str);
        }
        throw new NullPointerException("Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    public static <T> T get(String str, T t, CacheMemoryUtils cacheMemoryUtils) {
        if (str != null) {
            if (cacheMemoryUtils == null) {
                throw new NullPointerException("Argument 'cacheMemoryUtils' of type CacheMemoryUtils (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            }
            return (T) cacheMemoryUtils.get(str, t);
        }
        throw new NullPointerException("Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    public static int getCacheCount(CacheMemoryUtils cacheMemoryUtils) {
        if (cacheMemoryUtils == null) {
            throw new NullPointerException("Argument 'cacheMemoryUtils' of type CacheMemoryUtils (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        return cacheMemoryUtils.getCacheCount();
    }

    public static Object remove(String str, CacheMemoryUtils cacheMemoryUtils) {
        if (str != null) {
            if (cacheMemoryUtils == null) {
                throw new NullPointerException("Argument 'cacheMemoryUtils' of type CacheMemoryUtils (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            }
            return cacheMemoryUtils.remove(str);
        }
        throw new NullPointerException("Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    public static void clear(CacheMemoryUtils cacheMemoryUtils) {
        if (cacheMemoryUtils == null) {
            throw new NullPointerException("Argument 'cacheMemoryUtils' of type CacheMemoryUtils (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        cacheMemoryUtils.clear();
    }

    private static CacheMemoryUtils getDefaultCacheMemoryUtils() {
        CacheMemoryUtils cacheMemoryUtils = sDefaultCacheMemoryUtils;
        return cacheMemoryUtils != null ? cacheMemoryUtils : CacheMemoryUtils.getInstance();
    }
}
