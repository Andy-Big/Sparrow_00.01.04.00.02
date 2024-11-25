package com.blankj.utilcode.util;

import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import java.io.File;
/* loaded from: classes.dex */
public final class PathUtils {
    private static final char SEP = File.separatorChar;

    private PathUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static String join(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        if (str == null) {
            str = "";
        }
        int length = str.length();
        String legalSegment = getLegalSegment(str2);
        if (length == 0) {
            return SEP + legalSegment;
        } else if (str.charAt(length - 1) == SEP) {
            return str + legalSegment;
        } else {
            return str + SEP + legalSegment;
        }
    }

    private static String getLegalSegment(String str) {
        char[] charArray = str.toCharArray();
        int i = -1;
        int i2 = -1;
        for (int i3 = 0; i3 < charArray.length; i3++) {
            if (charArray[i3] != SEP) {
                if (i == -1) {
                    i = i3;
                }
                i2 = i3;
            }
        }
        if (i >= 0 && i2 >= i) {
            return str.substring(i, i2 + 1);
        }
        throw new IllegalArgumentException("segment of <" + str + "> is illegal");
    }

    public static String getRootPath() {
        return getAbsolutePath(Environment.getRootDirectory());
    }

    public static String getDataPath() {
        return getAbsolutePath(Environment.getDataDirectory());
    }

    public static String getDownloadCachePath() {
        return getAbsolutePath(Environment.getDownloadCacheDirectory());
    }

    public static String getInternalAppDataPath() {
        if (Build.VERSION.SDK_INT < 24) {
            return Utils.getApp().getApplicationInfo().dataDir;
        }
        return getAbsolutePath(Utils.getApp().getDataDir());
    }

    public static String getInternalAppCodeCacheDir() {
        if (Build.VERSION.SDK_INT < 21) {
            return Utils.getApp().getApplicationInfo().dataDir + "/code_cache";
        }
        return getAbsolutePath(Utils.getApp().getCodeCacheDir());
    }

    public static String getInternalAppCachePath() {
        return getAbsolutePath(Utils.getApp().getCacheDir());
    }

    public static String getInternalAppDbsPath() {
        return Utils.getApp().getApplicationInfo().dataDir + "/databases";
    }

    public static String getInternalAppDbPath(String str) {
        return getAbsolutePath(Utils.getApp().getDatabasePath(str));
    }

    public static String getInternalAppFilesPath() {
        return getAbsolutePath(Utils.getApp().getFilesDir());
    }

    public static String getInternalAppSpPath() {
        return Utils.getApp().getApplicationInfo().dataDir + "/shared_prefs";
    }

    public static String getInternalAppNoBackupFilesPath() {
        if (Build.VERSION.SDK_INT < 21) {
            return Utils.getApp().getApplicationInfo().dataDir + "/no_backup";
        }
        return getAbsolutePath(Utils.getApp().getNoBackupFilesDir());
    }

    public static String getExternalStoragePath() {
        return !UtilsBridge.isSDCardEnableByEnvironment() ? "" : getAbsolutePath(Environment.getExternalStorageDirectory());
    }

    public static String getExternalMusicPath() {
        return !UtilsBridge.isSDCardEnableByEnvironment() ? "" : getAbsolutePath(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC));
    }

    public static String getExternalPodcastsPath() {
        return !UtilsBridge.isSDCardEnableByEnvironment() ? "" : getAbsolutePath(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PODCASTS));
    }

    public static String getExternalRingtonesPath() {
        return !UtilsBridge.isSDCardEnableByEnvironment() ? "" : getAbsolutePath(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_RINGTONES));
    }

    public static String getExternalAlarmsPath() {
        return !UtilsBridge.isSDCardEnableByEnvironment() ? "" : getAbsolutePath(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_ALARMS));
    }

    public static String getExternalNotificationsPath() {
        return !UtilsBridge.isSDCardEnableByEnvironment() ? "" : getAbsolutePath(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_NOTIFICATIONS));
    }

    public static String getExternalPicturesPath() {
        return !UtilsBridge.isSDCardEnableByEnvironment() ? "" : getAbsolutePath(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES));
    }

    public static String getExternalMoviesPath() {
        return !UtilsBridge.isSDCardEnableByEnvironment() ? "" : getAbsolutePath(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES));
    }

    public static String getExternalDownloadsPath() {
        return !UtilsBridge.isSDCardEnableByEnvironment() ? "" : getAbsolutePath(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS));
    }

    public static String getExternalDcimPath() {
        return !UtilsBridge.isSDCardEnableByEnvironment() ? "" : getAbsolutePath(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM));
    }

    public static String getExternalDocumentsPath() {
        if (UtilsBridge.isSDCardEnableByEnvironment()) {
            if (Build.VERSION.SDK_INT < 19) {
                return getAbsolutePath(Environment.getExternalStorageDirectory()) + "/Documents";
            }
            return getAbsolutePath(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS));
        }
        return "";
    }

    public static String getExternalAppDataPath() {
        File externalCacheDir;
        return (UtilsBridge.isSDCardEnableByEnvironment() && (externalCacheDir = Utils.getApp().getExternalCacheDir()) != null) ? getAbsolutePath(externalCacheDir.getParentFile()) : "";
    }

    public static String getExternalAppCachePath() {
        return !UtilsBridge.isSDCardEnableByEnvironment() ? "" : getAbsolutePath(Utils.getApp().getExternalCacheDir());
    }

    public static String getExternalAppFilesPath() {
        return !UtilsBridge.isSDCardEnableByEnvironment() ? "" : getAbsolutePath(Utils.getApp().getExternalFilesDir(null));
    }

    public static String getExternalAppMusicPath() {
        return !UtilsBridge.isSDCardEnableByEnvironment() ? "" : getAbsolutePath(Utils.getApp().getExternalFilesDir(Environment.DIRECTORY_MUSIC));
    }

    public static String getExternalAppPodcastsPath() {
        return !UtilsBridge.isSDCardEnableByEnvironment() ? "" : getAbsolutePath(Utils.getApp().getExternalFilesDir(Environment.DIRECTORY_PODCASTS));
    }

    public static String getExternalAppRingtonesPath() {
        return !UtilsBridge.isSDCardEnableByEnvironment() ? "" : getAbsolutePath(Utils.getApp().getExternalFilesDir(Environment.DIRECTORY_RINGTONES));
    }

    public static String getExternalAppAlarmsPath() {
        return !UtilsBridge.isSDCardEnableByEnvironment() ? "" : getAbsolutePath(Utils.getApp().getExternalFilesDir(Environment.DIRECTORY_ALARMS));
    }

    public static String getExternalAppNotificationsPath() {
        return !UtilsBridge.isSDCardEnableByEnvironment() ? "" : getAbsolutePath(Utils.getApp().getExternalFilesDir(Environment.DIRECTORY_NOTIFICATIONS));
    }

    public static String getExternalAppPicturesPath() {
        return !UtilsBridge.isSDCardEnableByEnvironment() ? "" : getAbsolutePath(Utils.getApp().getExternalFilesDir(Environment.DIRECTORY_PICTURES));
    }

    public static String getExternalAppMoviesPath() {
        return !UtilsBridge.isSDCardEnableByEnvironment() ? "" : getAbsolutePath(Utils.getApp().getExternalFilesDir(Environment.DIRECTORY_MOVIES));
    }

    public static String getExternalAppDownloadPath() {
        return !UtilsBridge.isSDCardEnableByEnvironment() ? "" : getAbsolutePath(Utils.getApp().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS));
    }

    public static String getExternalAppDcimPath() {
        return !UtilsBridge.isSDCardEnableByEnvironment() ? "" : getAbsolutePath(Utils.getApp().getExternalFilesDir(Environment.DIRECTORY_DCIM));
    }

    public static String getExternalAppDocumentsPath() {
        if (UtilsBridge.isSDCardEnableByEnvironment()) {
            if (Build.VERSION.SDK_INT < 19) {
                return getAbsolutePath(Utils.getApp().getExternalFilesDir(null)) + "/Documents";
            }
            return getAbsolutePath(Utils.getApp().getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS));
        }
        return "";
    }

    public static String getExternalAppObbPath() {
        return !UtilsBridge.isSDCardEnableByEnvironment() ? "" : getAbsolutePath(Utils.getApp().getObbDir());
    }

    public static String getRootPathExternalFirst() {
        String externalStoragePath = getExternalStoragePath();
        return TextUtils.isEmpty(externalStoragePath) ? getRootPath() : externalStoragePath;
    }

    public static String getAppDataPathExternalFirst() {
        String externalAppDataPath = getExternalAppDataPath();
        return TextUtils.isEmpty(externalAppDataPath) ? getInternalAppDataPath() : externalAppDataPath;
    }

    public static String getFilesPathExternalFirst() {
        String externalAppFilesPath = getExternalAppFilesPath();
        return TextUtils.isEmpty(externalAppFilesPath) ? getInternalAppFilesPath() : externalAppFilesPath;
    }

    public static String getCachePathExternalFirst() {
        String externalAppCachePath = getExternalAppCachePath();
        return TextUtils.isEmpty(externalAppCachePath) ? getInternalAppCachePath() : externalAppCachePath;
    }

    private static String getAbsolutePath(File file) {
        return file == null ? "" : file.getAbsolutePath();
    }
}
