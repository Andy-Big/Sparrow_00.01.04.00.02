package com.just.agentweb;

import android.util.Log;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class LogUtils {
    private static final String PREFIX = "agentweb-";

    LogUtils() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isDebug() {
        return AgentWebConfig.DEBUG;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void i(String str, String str2) {
        if (isDebug()) {
            Log.i(PREFIX.concat(str), str2);
        }
    }

    static void v(String str, String str2) {
        if (isDebug()) {
            Log.v(PREFIX.concat(str), str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void safeCheckCrash(String str, String str2, Throwable th) {
        if (isDebug()) {
            throw new RuntimeException(PREFIX.concat(str) + " " + str2, th);
        }
        Log.e(PREFIX.concat(str), str2, th);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void e(String str, String str2, Throwable th) {
        Log.e(str, str2, th);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void e(String str, String str2) {
        if (isDebug()) {
            Log.e(PREFIX.concat(str), str2);
        }
    }
}
