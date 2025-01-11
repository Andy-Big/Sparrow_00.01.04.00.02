package com.bumptech.glide.util;

import android.text.TextUtils;
import java.util.Collection;

/* loaded from: classes.dex */
public final class Preconditions {
    private Preconditions() {
    }

    public static void checkArgument(boolean z, String str) {
        if (!z) {
            throw new IllegalArgumentException(str);
        }
    }

    public static <T> T checkNotNull(T t) {
        return (T) checkNotNull(t, "Argument must not be null");
    }

    public static <T> T checkNotNull(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    public static String checkNotEmpty(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Must not be null or empty");
        }
        return str;
    }

    public static <T extends Collection<Y>, Y> T checkNotEmpty(T t) {
        if (t.isEmpty()) {
            throw new IllegalArgumentException("Must not be empty.");
        }
        return t;
    }
}
