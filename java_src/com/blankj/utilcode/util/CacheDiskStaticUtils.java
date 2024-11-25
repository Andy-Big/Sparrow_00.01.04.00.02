package com.blankj.utilcode.util;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import java.io.Serializable;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class CacheDiskStaticUtils {
    private static CacheDiskUtils sDefaultCacheDiskUtils;

    public static void setDefaultCacheDiskUtils(CacheDiskUtils cacheDiskUtils) {
        sDefaultCacheDiskUtils = cacheDiskUtils;
    }

    public static void put(String str, byte[] bArr) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        put(str, bArr, getDefaultCacheDiskUtils());
    }

    public static void put(String str, byte[] bArr, int i) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        put(str, bArr, i, getDefaultCacheDiskUtils());
    }

    public static byte[] getBytes(String str) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        return getBytes(str, getDefaultCacheDiskUtils());
    }

    public static byte[] getBytes(String str, byte[] bArr) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        return getBytes(str, bArr, getDefaultCacheDiskUtils());
    }

    public static void put(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        put(str, str2, getDefaultCacheDiskUtils());
    }

    public static void put(String str, String str2, int i) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        put(str, str2, i, getDefaultCacheDiskUtils());
    }

    public static String getString(String str) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        return getString(str, getDefaultCacheDiskUtils());
    }

    public static String getString(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        return getString(str, str2, getDefaultCacheDiskUtils());
    }

    public static void put(String str, JSONObject jSONObject) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        put(str, jSONObject, getDefaultCacheDiskUtils());
    }

    public static void put(String str, JSONObject jSONObject, int i) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        put(str, jSONObject, i, getDefaultCacheDiskUtils());
    }

    public static JSONObject getJSONObject(String str) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        return getJSONObject(str, getDefaultCacheDiskUtils());
    }

    public static JSONObject getJSONObject(String str, JSONObject jSONObject) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        return getJSONObject(str, jSONObject, getDefaultCacheDiskUtils());
    }

    public static void put(String str, JSONArray jSONArray) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        put(str, jSONArray, getDefaultCacheDiskUtils());
    }

    public static void put(String str, JSONArray jSONArray, int i) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        put(str, jSONArray, i, getDefaultCacheDiskUtils());
    }

    public static JSONArray getJSONArray(String str) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        return getJSONArray(str, getDefaultCacheDiskUtils());
    }

    public static JSONArray getJSONArray(String str, JSONArray jSONArray) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        return getJSONArray(str, jSONArray, getDefaultCacheDiskUtils());
    }

    public static void put(String str, Bitmap bitmap) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        put(str, bitmap, getDefaultCacheDiskUtils());
    }

    public static void put(String str, Bitmap bitmap, int i) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        put(str, bitmap, i, getDefaultCacheDiskUtils());
    }

    public static Bitmap getBitmap(String str) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        return getBitmap(str, getDefaultCacheDiskUtils());
    }

    public static Bitmap getBitmap(String str, Bitmap bitmap) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        return getBitmap(str, bitmap, getDefaultCacheDiskUtils());
    }

    public static void put(String str, Drawable drawable) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        put(str, drawable, getDefaultCacheDiskUtils());
    }

    public static void put(String str, Drawable drawable, int i) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        put(str, drawable, i, getDefaultCacheDiskUtils());
    }

    public static Drawable getDrawable(String str) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        return getDrawable(str, getDefaultCacheDiskUtils());
    }

    public static Drawable getDrawable(String str, Drawable drawable) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        return getDrawable(str, drawable, getDefaultCacheDiskUtils());
    }

    public static void put(String str, Parcelable parcelable) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        put(str, parcelable, getDefaultCacheDiskUtils());
    }

    public static void put(String str, Parcelable parcelable, int i) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        put(str, parcelable, i, getDefaultCacheDiskUtils());
    }

    public static <T> T getParcelable(String str, Parcelable.Creator<T> creator) {
        if (str != null) {
            if (creator == null) {
                throw new NullPointerException("Argument 'creator' of type Parcelable.Creator<T> (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            }
            return (T) getParcelable(str, (Parcelable.Creator<Object>) creator, getDefaultCacheDiskUtils());
        }
        throw new NullPointerException("Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    public static <T> T getParcelable(String str, Parcelable.Creator<T> creator, T t) {
        if (str != null) {
            if (creator == null) {
                throw new NullPointerException("Argument 'creator' of type Parcelable.Creator<T> (#1 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            }
            return (T) getParcelable(str, creator, t, getDefaultCacheDiskUtils());
        }
        throw new NullPointerException("Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    public static void put(String str, Serializable serializable) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        put(str, serializable, getDefaultCacheDiskUtils());
    }

    public static void put(String str, Serializable serializable, int i) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        put(str, serializable, i, getDefaultCacheDiskUtils());
    }

    public static Object getSerializable(String str) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        return getSerializable(str, getDefaultCacheDiskUtils());
    }

    public static Object getSerializable(String str, Object obj) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        return getSerializable(str, obj, getDefaultCacheDiskUtils());
    }

    public static long getCacheSize() {
        return getCacheSize(getDefaultCacheDiskUtils());
    }

    public static int getCacheCount() {
        return getCacheCount(getDefaultCacheDiskUtils());
    }

    public static boolean remove(String str) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        return remove(str, getDefaultCacheDiskUtils());
    }

    public static boolean clear() {
        return clear(getDefaultCacheDiskUtils());
    }

    public static void put(String str, byte[] bArr, CacheDiskUtils cacheDiskUtils) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        if (cacheDiskUtils == null) {
            throw new NullPointerException("Argument 'cacheDiskUtils' of type CacheDiskUtils (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        cacheDiskUtils.put(str, bArr);
    }

    public static void put(String str, byte[] bArr, int i, CacheDiskUtils cacheDiskUtils) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        if (cacheDiskUtils == null) {
            throw new NullPointerException("Argument 'cacheDiskUtils' of type CacheDiskUtils (#3 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        cacheDiskUtils.put(str, bArr, i);
    }

    public static byte[] getBytes(String str, CacheDiskUtils cacheDiskUtils) {
        if (str != null) {
            if (cacheDiskUtils == null) {
                throw new NullPointerException("Argument 'cacheDiskUtils' of type CacheDiskUtils (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            }
            return cacheDiskUtils.getBytes(str);
        }
        throw new NullPointerException("Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    public static byte[] getBytes(String str, byte[] bArr, CacheDiskUtils cacheDiskUtils) {
        if (str != null) {
            if (cacheDiskUtils == null) {
                throw new NullPointerException("Argument 'cacheDiskUtils' of type CacheDiskUtils (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            }
            return cacheDiskUtils.getBytes(str, bArr);
        }
        throw new NullPointerException("Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    public static void put(String str, String str2, CacheDiskUtils cacheDiskUtils) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        if (cacheDiskUtils == null) {
            throw new NullPointerException("Argument 'cacheDiskUtils' of type CacheDiskUtils (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        cacheDiskUtils.put(str, str2);
    }

    public static void put(String str, String str2, int i, CacheDiskUtils cacheDiskUtils) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        if (cacheDiskUtils == null) {
            throw new NullPointerException("Argument 'cacheDiskUtils' of type CacheDiskUtils (#3 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        cacheDiskUtils.put(str, str2, i);
    }

    public static String getString(String str, CacheDiskUtils cacheDiskUtils) {
        if (str != null) {
            if (cacheDiskUtils == null) {
                throw new NullPointerException("Argument 'cacheDiskUtils' of type CacheDiskUtils (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            }
            return cacheDiskUtils.getString(str);
        }
        throw new NullPointerException("Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    public static String getString(String str, String str2, CacheDiskUtils cacheDiskUtils) {
        if (str != null) {
            if (cacheDiskUtils == null) {
                throw new NullPointerException("Argument 'cacheDiskUtils' of type CacheDiskUtils (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            }
            return cacheDiskUtils.getString(str, str2);
        }
        throw new NullPointerException("Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    public static void put(String str, JSONObject jSONObject, CacheDiskUtils cacheDiskUtils) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        if (cacheDiskUtils == null) {
            throw new NullPointerException("Argument 'cacheDiskUtils' of type CacheDiskUtils (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        cacheDiskUtils.put(str, jSONObject);
    }

    public static void put(String str, JSONObject jSONObject, int i, CacheDiskUtils cacheDiskUtils) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        if (cacheDiskUtils == null) {
            throw new NullPointerException("Argument 'cacheDiskUtils' of type CacheDiskUtils (#3 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        cacheDiskUtils.put(str, jSONObject, i);
    }

    public static JSONObject getJSONObject(String str, CacheDiskUtils cacheDiskUtils) {
        if (str != null) {
            if (cacheDiskUtils == null) {
                throw new NullPointerException("Argument 'cacheDiskUtils' of type CacheDiskUtils (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            }
            return cacheDiskUtils.getJSONObject(str);
        }
        throw new NullPointerException("Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    public static JSONObject getJSONObject(String str, JSONObject jSONObject, CacheDiskUtils cacheDiskUtils) {
        if (str != null) {
            if (cacheDiskUtils == null) {
                throw new NullPointerException("Argument 'cacheDiskUtils' of type CacheDiskUtils (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            }
            return cacheDiskUtils.getJSONObject(str, jSONObject);
        }
        throw new NullPointerException("Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    public static void put(String str, JSONArray jSONArray, CacheDiskUtils cacheDiskUtils) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        if (cacheDiskUtils == null) {
            throw new NullPointerException("Argument 'cacheDiskUtils' of type CacheDiskUtils (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        cacheDiskUtils.put(str, jSONArray);
    }

    public static void put(String str, JSONArray jSONArray, int i, CacheDiskUtils cacheDiskUtils) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        if (cacheDiskUtils == null) {
            throw new NullPointerException("Argument 'cacheDiskUtils' of type CacheDiskUtils (#3 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        cacheDiskUtils.put(str, jSONArray, i);
    }

    public static JSONArray getJSONArray(String str, CacheDiskUtils cacheDiskUtils) {
        if (str != null) {
            if (cacheDiskUtils == null) {
                throw new NullPointerException("Argument 'cacheDiskUtils' of type CacheDiskUtils (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            }
            return cacheDiskUtils.getJSONArray(str);
        }
        throw new NullPointerException("Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    public static JSONArray getJSONArray(String str, JSONArray jSONArray, CacheDiskUtils cacheDiskUtils) {
        if (str != null) {
            if (cacheDiskUtils == null) {
                throw new NullPointerException("Argument 'cacheDiskUtils' of type CacheDiskUtils (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            }
            return cacheDiskUtils.getJSONArray(str, jSONArray);
        }
        throw new NullPointerException("Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    public static void put(String str, Bitmap bitmap, CacheDiskUtils cacheDiskUtils) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        if (cacheDiskUtils == null) {
            throw new NullPointerException("Argument 'cacheDiskUtils' of type CacheDiskUtils (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        cacheDiskUtils.put(str, bitmap);
    }

    public static void put(String str, Bitmap bitmap, int i, CacheDiskUtils cacheDiskUtils) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        if (cacheDiskUtils == null) {
            throw new NullPointerException("Argument 'cacheDiskUtils' of type CacheDiskUtils (#3 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        cacheDiskUtils.put(str, bitmap, i);
    }

    public static Bitmap getBitmap(String str, CacheDiskUtils cacheDiskUtils) {
        if (str != null) {
            if (cacheDiskUtils == null) {
                throw new NullPointerException("Argument 'cacheDiskUtils' of type CacheDiskUtils (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            }
            return cacheDiskUtils.getBitmap(str);
        }
        throw new NullPointerException("Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    public static Bitmap getBitmap(String str, Bitmap bitmap, CacheDiskUtils cacheDiskUtils) {
        if (str != null) {
            if (cacheDiskUtils == null) {
                throw new NullPointerException("Argument 'cacheDiskUtils' of type CacheDiskUtils (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            }
            return cacheDiskUtils.getBitmap(str, bitmap);
        }
        throw new NullPointerException("Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    public static void put(String str, Drawable drawable, CacheDiskUtils cacheDiskUtils) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        if (cacheDiskUtils == null) {
            throw new NullPointerException("Argument 'cacheDiskUtils' of type CacheDiskUtils (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        cacheDiskUtils.put(str, drawable);
    }

    public static void put(String str, Drawable drawable, int i, CacheDiskUtils cacheDiskUtils) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        if (cacheDiskUtils == null) {
            throw new NullPointerException("Argument 'cacheDiskUtils' of type CacheDiskUtils (#3 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        cacheDiskUtils.put(str, drawable, i);
    }

    public static Drawable getDrawable(String str, CacheDiskUtils cacheDiskUtils) {
        if (str != null) {
            if (cacheDiskUtils == null) {
                throw new NullPointerException("Argument 'cacheDiskUtils' of type CacheDiskUtils (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            }
            return cacheDiskUtils.getDrawable(str);
        }
        throw new NullPointerException("Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    public static Drawable getDrawable(String str, Drawable drawable, CacheDiskUtils cacheDiskUtils) {
        if (str != null) {
            if (cacheDiskUtils == null) {
                throw new NullPointerException("Argument 'cacheDiskUtils' of type CacheDiskUtils (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            }
            return cacheDiskUtils.getDrawable(str, drawable);
        }
        throw new NullPointerException("Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    public static void put(String str, Parcelable parcelable, CacheDiskUtils cacheDiskUtils) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        if (cacheDiskUtils == null) {
            throw new NullPointerException("Argument 'cacheDiskUtils' of type CacheDiskUtils (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        cacheDiskUtils.put(str, parcelable);
    }

    public static void put(String str, Parcelable parcelable, int i, CacheDiskUtils cacheDiskUtils) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        if (cacheDiskUtils == null) {
            throw new NullPointerException("Argument 'cacheDiskUtils' of type CacheDiskUtils (#3 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        cacheDiskUtils.put(str, parcelable, i);
    }

    public static <T> T getParcelable(String str, Parcelable.Creator<T> creator, CacheDiskUtils cacheDiskUtils) {
        if (str != null) {
            if (creator != null) {
                if (cacheDiskUtils == null) {
                    throw new NullPointerException("Argument 'cacheDiskUtils' of type CacheDiskUtils (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
                }
                return (T) cacheDiskUtils.getParcelable(str, creator);
            }
            throw new NullPointerException("Argument 'creator' of type Parcelable.Creator<T> (#1 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        throw new NullPointerException("Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    public static <T> T getParcelable(String str, Parcelable.Creator<T> creator, T t, CacheDiskUtils cacheDiskUtils) {
        if (str != null) {
            if (creator != null) {
                if (cacheDiskUtils == null) {
                    throw new NullPointerException("Argument 'cacheDiskUtils' of type CacheDiskUtils (#3 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
                }
                return (T) cacheDiskUtils.getParcelable(str, creator, t);
            }
            throw new NullPointerException("Argument 'creator' of type Parcelable.Creator<T> (#1 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        throw new NullPointerException("Argument 'key' of type String (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    public static void put(String str, Serializable serializable, CacheDiskUtils cacheDiskUtils) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        if (cacheDiskUtils == null) {
            throw new NullPointerException("Argument 'cacheDiskUtils' of type CacheDiskUtils (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        cacheDiskUtils.put(str, serializable);
    }

    public static void put(String str, Serializable serializable, int i, CacheDiskUtils cacheDiskUtils) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        if (cacheDiskUtils == null) {
            throw new NullPointerException("Argument 'cacheDiskUtils' of type CacheDiskUtils (#3 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        cacheDiskUtils.put(str, serializable, i);
    }

    public static Object getSerializable(String str, CacheDiskUtils cacheDiskUtils) {
        if (str != null) {
            if (cacheDiskUtils == null) {
                throw new NullPointerException("Argument 'cacheDiskUtils' of type CacheDiskUtils (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            }
            return cacheDiskUtils.getSerializable(str);
        }
        throw new NullPointerException("Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    public static Object getSerializable(String str, Object obj, CacheDiskUtils cacheDiskUtils) {
        if (str != null) {
            if (cacheDiskUtils == null) {
                throw new NullPointerException("Argument 'cacheDiskUtils' of type CacheDiskUtils (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            }
            return cacheDiskUtils.getSerializable(str, obj);
        }
        throw new NullPointerException("Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    public static long getCacheSize(CacheDiskUtils cacheDiskUtils) {
        if (cacheDiskUtils == null) {
            throw new NullPointerException("Argument 'cacheDiskUtils' of type CacheDiskUtils (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        return cacheDiskUtils.getCacheSize();
    }

    public static int getCacheCount(CacheDiskUtils cacheDiskUtils) {
        if (cacheDiskUtils == null) {
            throw new NullPointerException("Argument 'cacheDiskUtils' of type CacheDiskUtils (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        return cacheDiskUtils.getCacheCount();
    }

    public static boolean remove(String str, CacheDiskUtils cacheDiskUtils) {
        if (str != null) {
            if (cacheDiskUtils == null) {
                throw new NullPointerException("Argument 'cacheDiskUtils' of type CacheDiskUtils (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            }
            return cacheDiskUtils.remove(str);
        }
        throw new NullPointerException("Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    public static boolean clear(CacheDiskUtils cacheDiskUtils) {
        if (cacheDiskUtils == null) {
            throw new NullPointerException("Argument 'cacheDiskUtils' of type CacheDiskUtils (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        return cacheDiskUtils.clear();
    }

    private static CacheDiskUtils getDefaultCacheDiskUtils() {
        CacheDiskUtils cacheDiskUtils = sDefaultCacheDiskUtils;
        return cacheDiskUtils != null ? cacheDiskUtils : CacheDiskUtils.getInstance();
    }
}
