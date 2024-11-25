package com.blankj.utilcode.util;

import android.app.ActivityManager;
import android.os.Environment;
import java.io.File;
/* loaded from: classes.dex */
public final class CleanUtils {
    private CleanUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static boolean cleanInternalCache() {
        return UtilsBridge.deleteAllInDir(Utils.getApp().getCacheDir());
    }

    public static boolean cleanInternalFiles() {
        return UtilsBridge.deleteAllInDir(Utils.getApp().getFilesDir());
    }

    public static boolean cleanInternalDbs() {
        return UtilsBridge.deleteAllInDir(new File(Utils.getApp().getFilesDir().getParent(), "databases"));
    }

    public static boolean cleanInternalDbByName(String str) {
        return Utils.getApp().deleteDatabase(str);
    }

    public static boolean cleanInternalSp() {
        return UtilsBridge.deleteAllInDir(new File(Utils.getApp().getFilesDir().getParent(), "shared_prefs"));
    }

    public static boolean cleanExternalCache() {
        return "mounted".equals(Environment.getExternalStorageState()) && UtilsBridge.deleteAllInDir(Utils.getApp().getExternalCacheDir());
    }

    public static boolean cleanCustomDir(String str) {
        return UtilsBridge.deleteAllInDir(UtilsBridge.getFileByPath(str));
    }

    public static void cleanAppUserData() {
        ((ActivityManager) Utils.getApp().getSystemService("activity")).clearApplicationUserData();
    }
}
