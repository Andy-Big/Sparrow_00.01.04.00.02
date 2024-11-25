package com.blankj.utilcode.util;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import com.blankj.utilcode.constant.CacheConstants;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class CacheDoubleUtils implements CacheConstants {
    private static final Map<String, CacheDoubleUtils> CACHE_MAP = new HashMap();
    private final CacheDiskUtils mCacheDiskUtils;
    private final CacheMemoryUtils mCacheMemoryUtils;

    public static CacheDoubleUtils getInstance() {
        return getInstance(CacheMemoryUtils.getInstance(), CacheDiskUtils.getInstance());
    }

    public static CacheDoubleUtils getInstance(CacheMemoryUtils cacheMemoryUtils, CacheDiskUtils cacheDiskUtils) {
        if (cacheMemoryUtils != null) {
            if (cacheDiskUtils == null) {
                throw new NullPointerException("Argument 'cacheDiskUtils' of type CacheDiskUtils (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            }
            String str = cacheDiskUtils.toString() + "_" + cacheMemoryUtils.toString();
            CacheDoubleUtils cacheDoubleUtils = CACHE_MAP.get(str);
            if (cacheDoubleUtils == null) {
                synchronized (CacheDoubleUtils.class) {
                    cacheDoubleUtils = CACHE_MAP.get(str);
                    if (cacheDoubleUtils == null) {
                        cacheDoubleUtils = new CacheDoubleUtils(cacheMemoryUtils, cacheDiskUtils);
                        CACHE_MAP.put(str, cacheDoubleUtils);
                    }
                }
            }
            return cacheDoubleUtils;
        }
        throw new NullPointerException("Argument 'cacheMemoryUtils' of type CacheMemoryUtils (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    private CacheDoubleUtils(CacheMemoryUtils cacheMemoryUtils, CacheDiskUtils cacheDiskUtils) {
        this.mCacheMemoryUtils = cacheMemoryUtils;
        this.mCacheDiskUtils = cacheDiskUtils;
    }

    public void put(String str, byte[] bArr) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        put(str, bArr, -1);
    }

    public void put(String str, byte[] bArr, int i) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        this.mCacheMemoryUtils.put(str, bArr, i);
        this.mCacheDiskUtils.put(str, bArr, i);
    }

    public byte[] getBytes(String str) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        return getBytes(str, null);
    }

    public byte[] getBytes(String str, byte[] bArr) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        byte[] bArr2 = (byte[]) this.mCacheMemoryUtils.get(str);
        return bArr2 != null ? bArr2 : this.mCacheDiskUtils.getBytes(str, bArr);
    }

    public void put(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        put(str, str2, -1);
    }

    public void put(String str, String str2, int i) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        this.mCacheMemoryUtils.put(str, str2, i);
        this.mCacheDiskUtils.put(str, str2, i);
    }

    public String getString(String str) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        return getString(str, null);
    }

    public String getString(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        String str3 = (String) this.mCacheMemoryUtils.get(str);
        return str3 != null ? str3 : this.mCacheDiskUtils.getString(str, str2);
    }

    public void put(String str, JSONObject jSONObject) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        put(str, jSONObject, -1);
    }

    public void put(String str, JSONObject jSONObject, int i) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        this.mCacheMemoryUtils.put(str, jSONObject, i);
        this.mCacheDiskUtils.put(str, jSONObject, i);
    }

    public JSONObject getJSONObject(String str) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        return getJSONObject(str, null);
    }

    public JSONObject getJSONObject(String str, JSONObject jSONObject) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        JSONObject jSONObject2 = (JSONObject) this.mCacheMemoryUtils.get(str);
        return jSONObject2 != null ? jSONObject2 : this.mCacheDiskUtils.getJSONObject(str, jSONObject);
    }

    public void put(String str, JSONArray jSONArray) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        put(str, jSONArray, -1);
    }

    public void put(String str, JSONArray jSONArray, int i) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        this.mCacheMemoryUtils.put(str, jSONArray, i);
        this.mCacheDiskUtils.put(str, jSONArray, i);
    }

    public JSONArray getJSONArray(String str) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        return getJSONArray(str, null);
    }

    public JSONArray getJSONArray(String str, JSONArray jSONArray) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        JSONArray jSONArray2 = (JSONArray) this.mCacheMemoryUtils.get(str);
        return jSONArray2 != null ? jSONArray2 : this.mCacheDiskUtils.getJSONArray(str, jSONArray);
    }

    public void put(String str, Bitmap bitmap) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        put(str, bitmap, -1);
    }

    public void put(String str, Bitmap bitmap, int i) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        this.mCacheMemoryUtils.put(str, bitmap, i);
        this.mCacheDiskUtils.put(str, bitmap, i);
    }

    public Bitmap getBitmap(String str) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        return getBitmap(str, null);
    }

    public Bitmap getBitmap(String str, Bitmap bitmap) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        Bitmap bitmap2 = (Bitmap) this.mCacheMemoryUtils.get(str);
        return bitmap2 != null ? bitmap2 : this.mCacheDiskUtils.getBitmap(str, bitmap);
    }

    public void put(String str, Drawable drawable) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        put(str, drawable, -1);
    }

    public void put(String str, Drawable drawable, int i) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        this.mCacheMemoryUtils.put(str, drawable, i);
        this.mCacheDiskUtils.put(str, drawable, i);
    }

    public Drawable getDrawable(String str) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        return getDrawable(str, null);
    }

    public Drawable getDrawable(String str, Drawable drawable) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        Drawable drawable2 = (Drawable) this.mCacheMemoryUtils.get(str);
        return drawable2 != null ? drawable2 : this.mCacheDiskUtils.getDrawable(str, drawable);
    }

    public void put(String str, Parcelable parcelable) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        put(str, parcelable, -1);
    }

    public void put(String str, Parcelable parcelable, int i) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        this.mCacheMemoryUtils.put(str, parcelable, i);
        this.mCacheDiskUtils.put(str, parcelable, i);
    }

    public <T> T getParcelable(String str, Parcelable.Creator<T> creator) {
        if (str != null) {
            if (creator == null) {
                throw new NullPointerException("Argument 'creator' of type Parcelable.Creator<T> (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            }
            return (T) getParcelable(str, creator, null);
        }
        throw new NullPointerException("Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    public <T> T getParcelable(String str, Parcelable.Creator<T> creator, T t) {
        if (str != null) {
            if (creator == null) {
                throw new NullPointerException("Argument 'creator' of type Parcelable.Creator<T> (#1 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            }
            T t2 = (T) this.mCacheMemoryUtils.get(str);
            return t2 != null ? t2 : (T) this.mCacheDiskUtils.getParcelable(str, creator, t);
        }
        throw new NullPointerException("Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    public void put(String str, Serializable serializable) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        put(str, serializable, -1);
    }

    public void put(String str, Serializable serializable, int i) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        this.mCacheMemoryUtils.put(str, serializable, i);
        this.mCacheDiskUtils.put(str, serializable, i);
    }

    public Object getSerializable(String str) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        return getSerializable(str, null);
    }

    public Object getSerializable(String str, Object obj) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        Object obj2 = this.mCacheMemoryUtils.get(str);
        return obj2 != null ? obj2 : this.mCacheDiskUtils.getSerializable(str, obj);
    }

    public long getCacheDiskSize() {
        return this.mCacheDiskUtils.getCacheSize();
    }

    public int getCacheDiskCount() {
        return this.mCacheDiskUtils.getCacheCount();
    }

    public int getCacheMemoryCount() {
        return this.mCacheMemoryUtils.getCacheCount();
    }

    public void remove(String str) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        this.mCacheMemoryUtils.remove(str);
        this.mCacheDiskUtils.remove(str);
    }

    public void clear() {
        this.mCacheMemoryUtils.clear();
        this.mCacheDiskUtils.clear();
    }
}
