package com.blankj.utilcode.util;

import java.lang.reflect.Type;

/* loaded from: classes.dex */
public final class CloneUtils {
    private CloneUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static <T> T deepClone(T t, Type type) {
        try {
            return (T) UtilsBridge.fromJson(UtilsBridge.toJson(t), type);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
