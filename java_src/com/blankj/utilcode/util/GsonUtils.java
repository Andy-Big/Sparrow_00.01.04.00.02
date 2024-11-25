package com.blankj.utilcode.util;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public final class GsonUtils {
    private static final Map<String, Gson> GSONS = new ConcurrentHashMap();
    private static final String KEY_DEFAULT = "defaultGson";
    private static final String KEY_DELEGATE = "delegateGson";
    private static final String KEY_LOG_UTILS = "logUtilsGson";

    private GsonUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static void setGsonDelegate(Gson gson) {
        if (gson == null) {
            return;
        }
        GSONS.put(KEY_DELEGATE, gson);
    }

    public static void setGson(String str, Gson gson) {
        if (TextUtils.isEmpty(str) || gson == null) {
            return;
        }
        GSONS.put(str, gson);
    }

    public static Gson getGson(String str) {
        return GSONS.get(str);
    }

    public static Gson getGson() {
        Gson gson = GSONS.get(KEY_DELEGATE);
        if (gson != null) {
            return gson;
        }
        Gson gson2 = GSONS.get(KEY_DEFAULT);
        if (gson2 == null) {
            Gson createGson = createGson();
            GSONS.put(KEY_DEFAULT, createGson);
            return createGson;
        }
        return gson2;
    }

    public static String toJson(Object obj) {
        return toJson(getGson(), obj);
    }

    public static String toJson(Object obj, Type type) {
        if (type == null) {
            throw new NullPointerException("Argument 'typeOfSrc' of type Type (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        return toJson(getGson(), obj, type);
    }

    public static String toJson(Gson gson, Object obj) {
        if (gson == null) {
            throw new NullPointerException("Argument 'gson' of type Gson (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        return gson.toJson(obj);
    }

    public static String toJson(Gson gson, Object obj, Type type) {
        if (gson != null) {
            if (type == null) {
                throw new NullPointerException("Argument 'typeOfSrc' of type Type (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            }
            return gson.toJson(obj, type);
        }
        throw new NullPointerException("Argument 'gson' of type Gson (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    public static <T> T fromJson(String str, Class<T> cls) {
        if (cls == null) {
            throw new NullPointerException("Argument 'type' of type Class<T> (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        return (T) fromJson(getGson(), str, (Class<Object>) cls);
    }

    public static <T> T fromJson(String str, Type type) {
        if (type == null) {
            throw new NullPointerException("Argument 'type' of type Type (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        return (T) fromJson(getGson(), str, type);
    }

    public static <T> T fromJson(Reader reader, Class<T> cls) {
        if (reader != null) {
            if (cls == null) {
                throw new NullPointerException("Argument 'type' of type Class<T> (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            }
            return (T) fromJson(getGson(), reader, (Class<Object>) cls);
        }
        throw new NullPointerException("Argument 'reader' of type Reader (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    public static <T> T fromJson(Reader reader, Type type) {
        if (reader != null) {
            if (type == null) {
                throw new NullPointerException("Argument 'type' of type Type (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            }
            return (T) fromJson(getGson(), reader, type);
        }
        throw new NullPointerException("Argument 'reader' of type Reader (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    public static <T> T fromJson(Gson gson, String str, Class<T> cls) {
        if (gson != null) {
            if (cls == null) {
                throw new NullPointerException("Argument 'type' of type Class<T> (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            }
            return (T) gson.fromJson(str, (Class<Object>) cls);
        }
        throw new NullPointerException("Argument 'gson' of type Gson (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    public static <T> T fromJson(Gson gson, String str, Type type) {
        if (gson != null) {
            if (type == null) {
                throw new NullPointerException("Argument 'type' of type Type (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            }
            return (T) gson.fromJson(str, type);
        }
        throw new NullPointerException("Argument 'gson' of type Gson (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    public static <T> T fromJson(Gson gson, Reader reader, Class<T> cls) {
        if (gson != null) {
            if (cls == null) {
                throw new NullPointerException("Argument 'type' of type Class<T> (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            }
            return (T) gson.fromJson(reader, (Class<Object>) cls);
        }
        throw new NullPointerException("Argument 'gson' of type Gson (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    public static <T> T fromJson(Gson gson, Reader reader, Type type) {
        if (gson != null) {
            if (type == null) {
                throw new NullPointerException("Argument 'type' of type Type (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            }
            return (T) gson.fromJson(reader, type);
        }
        throw new NullPointerException("Argument 'gson' of type Gson (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    public static Type getListType(Type type) {
        if (type == null) {
            throw new NullPointerException("Argument 'type' of type Type (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        return TypeToken.getParameterized(List.class, type).getType();
    }

    public static Type getSetType(Type type) {
        if (type == null) {
            throw new NullPointerException("Argument 'type' of type Type (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        return TypeToken.getParameterized(Set.class, type).getType();
    }

    public static Type getMapType(Type type, Type type2) {
        if (type != null) {
            if (type2 == null) {
                throw new NullPointerException("Argument 'valueType' of type Type (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            }
            return TypeToken.getParameterized(Map.class, type, type2).getType();
        }
        throw new NullPointerException("Argument 'keyType' of type Type (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    public static Type getArrayType(Type type) {
        if (type == null) {
            throw new NullPointerException("Argument 'type' of type Type (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        return TypeToken.getArray(type).getType();
    }

    public static Type getType(Type type, Type... typeArr) {
        if (type != null) {
            if (typeArr == null) {
                throw new NullPointerException("Argument 'typeArguments' of type Type[] (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            }
            return TypeToken.getParameterized(type, typeArr).getType();
        }
        throw new NullPointerException("Argument 'rawType' of type Type (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Gson getGson4LogUtils() {
        Gson gson = GSONS.get(KEY_LOG_UTILS);
        if (gson == null) {
            Gson create = new GsonBuilder().setPrettyPrinting().serializeNulls().create();
            GSONS.put(KEY_LOG_UTILS, create);
            return create;
        }
        return gson;
    }

    private static Gson createGson() {
        return new GsonBuilder().serializeNulls().disableHtmlEscaping().create();
    }
}
