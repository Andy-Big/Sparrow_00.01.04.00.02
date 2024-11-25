package com.blankj.utilcode.util;

import android.os.Vibrator;
/* loaded from: classes.dex */
public final class VibrateUtils {
    private static Vibrator vibrator;

    private VibrateUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static void vibrate(long j) {
        Vibrator vibrator2 = getVibrator();
        if (vibrator2 == null) {
            return;
        }
        vibrator2.vibrate(j);
    }

    public static void vibrate(long[] jArr, int i) {
        Vibrator vibrator2 = getVibrator();
        if (vibrator2 == null) {
            return;
        }
        vibrator2.vibrate(jArr, i);
    }

    public static void cancel() {
        Vibrator vibrator2 = getVibrator();
        if (vibrator2 == null) {
            return;
        }
        vibrator2.cancel();
    }

    private static Vibrator getVibrator() {
        if (vibrator == null) {
            vibrator = (Vibrator) Utils.getApp().getSystemService("vibrator");
        }
        return vibrator;
    }
}
