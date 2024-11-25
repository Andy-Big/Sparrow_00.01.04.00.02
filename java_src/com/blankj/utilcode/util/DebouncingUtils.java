package com.blankj.utilcode.util;

import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class DebouncingUtils {
    private static final int CACHE_SIZE = 64;
    private static final long DEBOUNCING_DEFAULT_VALUE = 1000;
    private static final Map<String, Long> KEY_MILLIS_MAP = new ConcurrentHashMap(64);

    private DebouncingUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static boolean isValid(View view) {
        if (view == null) {
            throw new NullPointerException("Argument 'view' of type View (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        return isValid(view, 1000L);
    }

    public static boolean isValid(View view, long j) {
        if (view == null) {
            throw new NullPointerException("Argument 'view' of type View (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        return isValid(String.valueOf(view.hashCode()), j);
    }

    public static boolean isValid(String str, long j) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("The key is null.");
        }
        if (j < 0) {
            throw new IllegalArgumentException("The duration is less than 0.");
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        clearIfNecessary(elapsedRealtime);
        Long l = KEY_MILLIS_MAP.get(str);
        if (l == null || elapsedRealtime >= l.longValue()) {
            KEY_MILLIS_MAP.put(str, Long.valueOf(elapsedRealtime + j));
            return true;
        }
        return false;
    }

    private static void clearIfNecessary(long j) {
        if (KEY_MILLIS_MAP.size() < 64) {
            return;
        }
        Iterator<Map.Entry<String, Long>> it = KEY_MILLIS_MAP.entrySet().iterator();
        while (it.hasNext()) {
            if (j >= it.next().getValue().longValue()) {
                it.remove();
            }
        }
    }
}
