package com.bumptech.glide.util;

import android.os.Build;
import android.os.SystemClock;
/* loaded from: classes.dex */
public final class LogTime {
    private static final double MILLIS_MULTIPLIER;

    static {
        MILLIS_MULTIPLIER = Build.VERSION.SDK_INT >= 17 ? 1.0d / Math.pow(10.0d, 6.0d) : 1.0d;
    }

    private LogTime() {
    }

    public static long getLogTime() {
        if (Build.VERSION.SDK_INT >= 17) {
            return SystemClock.elapsedRealtimeNanos();
        }
        return SystemClock.uptimeMillis();
    }

    public static double getElapsedMillis(long j) {
        return (getLogTime() - j) * MILLIS_MULTIPLIER;
    }
}
