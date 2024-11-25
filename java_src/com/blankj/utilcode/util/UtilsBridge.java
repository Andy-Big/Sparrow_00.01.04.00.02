package com.blankj.utilcode.util;

import android.app.Activity;
import android.app.Application;
import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import androidx.core.app.NotificationCompat;
import com.blankj.utilcode.util.NotificationUtils;
import com.blankj.utilcode.util.ShellUtils;
import com.blankj.utilcode.util.Utils;
import com.google.gson.Gson;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class UtilsBridge {
    UtilsBridge() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void init(Application application) {
        UtilsActivityLifecycleImpl.INSTANCE.init(application);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void unInit(Application application) {
        UtilsActivityLifecycleImpl.INSTANCE.unInit(application);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void preLoad() {
        preLoad(AdaptScreenUtils.getPreLoadRunnable());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Activity getTopActivity() {
        return UtilsActivityLifecycleImpl.INSTANCE.getTopActivity();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void addOnAppStatusChangedListener(Utils.OnAppStatusChangedListener onAppStatusChangedListener) {
        UtilsActivityLifecycleImpl.INSTANCE.addOnAppStatusChangedListener(onAppStatusChangedListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void removeOnAppStatusChangedListener(Utils.OnAppStatusChangedListener onAppStatusChangedListener) {
        UtilsActivityLifecycleImpl.INSTANCE.removeOnAppStatusChangedListener(onAppStatusChangedListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void addActivityLifecycleCallbacks(Utils.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        UtilsActivityLifecycleImpl.INSTANCE.addActivityLifecycleCallbacks(activityLifecycleCallbacks);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void removeActivityLifecycleCallbacks(Utils.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        UtilsActivityLifecycleImpl.INSTANCE.removeActivityLifecycleCallbacks(activityLifecycleCallbacks);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void addActivityLifecycleCallbacks(Activity activity, Utils.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        UtilsActivityLifecycleImpl.INSTANCE.addActivityLifecycleCallbacks(activity, activityLifecycleCallbacks);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void removeActivityLifecycleCallbacks(Activity activity) {
        UtilsActivityLifecycleImpl.INSTANCE.removeActivityLifecycleCallbacks(activity);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void removeActivityLifecycleCallbacks(Activity activity, Utils.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        UtilsActivityLifecycleImpl.INSTANCE.removeActivityLifecycleCallbacks(activity, activityLifecycleCallbacks);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<Activity> getActivityList() {
        return UtilsActivityLifecycleImpl.INSTANCE.getActivityList();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Application getApplicationByReflect() {
        return UtilsActivityLifecycleImpl.INSTANCE.getApplicationByReflect();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isAppForeground() {
        return UtilsActivityLifecycleImpl.INSTANCE.isAppForeground();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isActivityAlive(Activity activity) {
        return ActivityUtils.isActivityAlive(activity);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getLauncherActivity(String str) {
        return ActivityUtils.getLauncherActivity(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Activity getActivityByContext(Context context) {
        return ActivityUtils.getActivityByContext(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void startHomeActivity() {
        ActivityUtils.startHomeActivity();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void finishAllActivities() {
        ActivityUtils.finishAllActivities();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isAppRunning(String str) {
        if (str == null) {
            throw new NullPointerException("Argument 'pkgName' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        return AppUtils.isAppRunning(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isAppInstalled(String str) {
        return AppUtils.isAppInstalled(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isAppDebug() {
        return AppUtils.isAppDebug();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void relaunchApp() {
        AppUtils.relaunchApp();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getStatusBarHeight() {
        return BarUtils.getStatusBarHeight();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getNavBarHeight() {
        return BarUtils.getNavBarHeight();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String bytes2HexString(byte[] bArr) {
        return ConvertUtils.bytes2HexString(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] hexString2Bytes(String str) {
        return ConvertUtils.hexString2Bytes(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] string2Bytes(String str) {
        return ConvertUtils.string2Bytes(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String bytes2String(byte[] bArr) {
        return ConvertUtils.bytes2String(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] jsonObject2Bytes(JSONObject jSONObject) {
        return ConvertUtils.jsonObject2Bytes(jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static JSONObject bytes2JSONObject(byte[] bArr) {
        return ConvertUtils.bytes2JSONObject(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] jsonArray2Bytes(JSONArray jSONArray) {
        return ConvertUtils.jsonArray2Bytes(jSONArray);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static JSONArray bytes2JSONArray(byte[] bArr) {
        return ConvertUtils.bytes2JSONArray(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] parcelable2Bytes(Parcelable parcelable) {
        return ConvertUtils.parcelable2Bytes(parcelable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T bytes2Parcelable(byte[] bArr, Parcelable.Creator<T> creator) {
        return (T) ConvertUtils.bytes2Parcelable(bArr, creator);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] serializable2Bytes(Serializable serializable) {
        return ConvertUtils.serializable2Bytes(serializable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object bytes2Object(byte[] bArr) {
        return ConvertUtils.bytes2Object(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String byte2FitMemorySize(long j) {
        return ConvertUtils.byte2FitMemorySize(j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] inputStream2Bytes(InputStream inputStream) {
        return ConvertUtils.inputStream2Bytes(inputStream);
    }

    static ByteArrayOutputStream input2OutputStream(InputStream inputStream) {
        return ConvertUtils.input2OutputStream(inputStream);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<String> inputStream2Lines(InputStream inputStream, String str) {
        return ConvertUtils.inputStream2Lines(inputStream, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isValid(View view, long j) {
        if (view == null) {
            throw new NullPointerException("Argument 'view' of type View (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        return DebouncingUtils.isValid(view, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] base64Encode(byte[] bArr) {
        return EncodeUtils.base64Encode(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] base64Decode(byte[] bArr) {
        return EncodeUtils.base64Decode(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] hashTemplate(byte[] bArr, String str) {
        return EncryptUtils.hashTemplate(bArr, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean writeFileFromBytes(File file, byte[] bArr) {
        return FileIOUtils.writeFileFromBytesByChannel(file, bArr, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] readFile2Bytes(File file) {
        return FileIOUtils.readFile2BytesByChannel(file);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean writeFileFromString(String str, String str2, boolean z) {
        return FileIOUtils.writeFileFromString(str, str2, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean writeFileFromIS(String str, InputStream inputStream) {
        return FileIOUtils.writeFileFromIS(str, inputStream);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isFileExists(File file) {
        return FileUtils.isFileExists(file);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static File getFileByPath(String str) {
        return FileUtils.getFileByPath(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean deleteAllInDir(File file) {
        return FileUtils.deleteAllInDir(file);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean createOrExistsFile(File file) {
        return FileUtils.createOrExistsFile(file);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean createOrExistsDir(File file) {
        return FileUtils.createOrExistsDir(file);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean createFileByDeleteOldFile(File file) {
        return FileUtils.createFileByDeleteOldFile(file);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long getFsTotalSize(String str) {
        return FileUtils.getFsTotalSize(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long getFsAvailableSize(String str) {
        return FileUtils.getFsAvailableSize(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void notifySystemToScan(File file) {
        FileUtils.notifySystemToScan(file);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String toJson(Object obj) {
        return GsonUtils.toJson(obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T fromJson(String str, Type type) {
        return (T) GsonUtils.fromJson(str, type);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Gson getGson4LogUtils() {
        return GsonUtils.getGson4LogUtils();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] bitmap2Bytes(Bitmap bitmap) {
        return ImageUtils.bitmap2Bytes(bitmap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] bitmap2Bytes(Bitmap bitmap, Bitmap.CompressFormat compressFormat, int i) {
        return ImageUtils.bitmap2Bytes(bitmap, compressFormat, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Bitmap bytes2Bitmap(byte[] bArr) {
        return ImageUtils.bytes2Bitmap(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] drawable2Bytes(Drawable drawable) {
        return ImageUtils.drawable2Bytes(drawable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] drawable2Bytes(Drawable drawable, Bitmap.CompressFormat compressFormat, int i) {
        return ImageUtils.drawable2Bytes(drawable, compressFormat, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Drawable bytes2Drawable(byte[] bArr) {
        return ImageUtils.bytes2Drawable(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Bitmap view2Bitmap(View view) {
        return ImageUtils.view2Bitmap(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Bitmap drawable2Bitmap(Drawable drawable) {
        return ImageUtils.drawable2Bitmap(drawable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Drawable bitmap2Drawable(Bitmap bitmap) {
        return ImageUtils.bitmap2Drawable(bitmap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isIntentAvailable(Intent intent) {
        return IntentUtils.isIntentAvailable(intent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Intent getLaunchAppIntent(String str) {
        return IntentUtils.getLaunchAppIntent(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Intent getInstallAppIntent(File file) {
        return IntentUtils.getInstallAppIntent(file);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Intent getInstallAppIntent(Uri uri) {
        return IntentUtils.getInstallAppIntent(uri);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Intent getUninstallAppIntent(String str) {
        return IntentUtils.getUninstallAppIntent(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Intent getDialIntent(String str) {
        return IntentUtils.getDialIntent(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Intent getCallIntent(String str) {
        return IntentUtils.getCallIntent(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Intent getSendSmsIntent(String str, String str2) {
        return IntentUtils.getSendSmsIntent(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Intent getLaunchAppDetailsSettingsIntent(String str, boolean z) {
        return IntentUtils.getLaunchAppDetailsSettingsIntent(str, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String formatJson(String str) {
        return JsonUtils.formatJson(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void fixSoftInputLeaks(Activity activity) {
        KeyboardUtils.fixSoftInputLeaks(activity);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Notification getNotification(NotificationUtils.ChannelConfig channelConfig, Utils.Consumer<NotificationCompat.Builder> consumer) {
        return NotificationUtils.getNotification(channelConfig, consumer);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isGranted(String... strArr) {
        return PermissionUtils.isGranted(strArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isGrantedDrawOverlays() {
        return PermissionUtils.isGrantedDrawOverlays();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isMainProcess() {
        return ProcessUtils.isMainProcess();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getForegroundProcessName() {
        return ProcessUtils.getForegroundProcessName();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getCurrentProcessName() {
        return ProcessUtils.getCurrentProcessName();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isSamsung() {
        return RomUtils.isSamsung();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getAppScreenWidth() {
        return ScreenUtils.getAppScreenWidth();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isSDCardEnableByEnvironment() {
        return SDCardUtils.isSDCardEnableByEnvironment();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isServiceRunning(String str) {
        return ServiceUtils.isServiceRunning(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ShellUtils.CommandResult execCmd(String str, boolean z) {
        return ShellUtils.execCmd(str, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int dp2px(float f) {
        return SizeUtils.dp2px(f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int px2dp(float f) {
        return SizeUtils.px2dp(f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int sp2px(float f) {
        return SizeUtils.sp2px(f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int px2sp(float f) {
        return SizeUtils.px2sp(f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SPUtils getSpUtils4Utils() {
        return SPUtils.getInstance("Utils");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isSpace(String str) {
        return StringUtils.isSpace(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean equals(CharSequence charSequence, CharSequence charSequence2) {
        return StringUtils.equals(charSequence, charSequence2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getString(int i) {
        return StringUtils.getString(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getString(int i, Object... objArr) {
        return StringUtils.getString(i, objArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String format(String str, Object... objArr) {
        return StringUtils.format(str, objArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> Utils.Task<T> doAsync(Utils.Task<T> task) {
        ThreadUtils.getCachedPool().execute(task);
        return task;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void runOnUiThread(Runnable runnable) {
        ThreadUtils.runOnUiThread(runnable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void runOnUiThreadDelayed(Runnable runnable, long j) {
        ThreadUtils.runOnUiThreadDelayed(runnable, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getFullStackTrace(Throwable th) {
        return ThrowableUtils.getFullStackTrace(th);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String millis2FitTimeSpan(long j, int i) {
        return TimeUtils.millis2FitTimeSpan(j, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void toastShowShort(CharSequence charSequence) {
        ToastUtils.showShort(charSequence);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void toastCancel() {
        ToastUtils.cancel();
    }

    private static void preLoad(Runnable... runnableArr) {
        for (Runnable runnable : runnableArr) {
            ThreadUtils.getCachedPool().execute(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Uri file2Uri(File file) {
        return UriUtils.file2Uri(file);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static File uri2File(Uri uri) {
        return UriUtils.uri2File(uri);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static View layoutId2View(int i) {
        return ViewUtils.layoutId2View(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class FileHead {
        private LinkedHashMap<String, String> mFirst = new LinkedHashMap<>();
        private LinkedHashMap<String, String> mLast = new LinkedHashMap<>();
        private String mName;

        /* JADX INFO: Access modifiers changed from: package-private */
        public FileHead(String str) {
            this.mName = str;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void addFirst(String str, String str2) {
            append2Host(this.mFirst, str, str2);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void append(Map<String, String> map) {
            append2Host(this.mLast, map);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void append(String str, String str2) {
            append2Host(this.mLast, str, str2);
        }

        private void append2Host(Map<String, String> map, Map<String, String> map2) {
            if (map2 == null || map2.isEmpty()) {
                return;
            }
            for (Map.Entry<String, String> entry : map2.entrySet()) {
                append2Host(map, entry.getKey(), entry.getValue());
            }
        }

        private void append2Host(Map<String, String> map, String str, String str2) {
            int length;
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return;
            }
            if (19 - str.length() > 0) {
                str = str + "                   ".substring(0, length);
            }
            map.put(str, str2);
        }

        public String getAppended() {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, String> entry : this.mLast.entrySet()) {
                sb.append(entry.getKey());
                sb.append(": ");
                sb.append(entry.getValue());
                sb.append("\n");
            }
            return sb.toString();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            String str = "************* " + this.mName + " Head ****************\n";
            sb.append(str);
            for (Map.Entry<String, String> entry : this.mFirst.entrySet()) {
                sb.append(entry.getKey());
                sb.append(": ");
                sb.append(entry.getValue());
                sb.append("\n");
            }
            sb.append("Rom Info           : ");
            sb.append(RomUtils.getRomInfo());
            sb.append("\n");
            sb.append("Device Manufacturer: ");
            sb.append(Build.MANUFACTURER);
            sb.append("\n");
            sb.append("Device Model       : ");
            sb.append(Build.MODEL);
            sb.append("\n");
            sb.append("Android Version    : ");
            sb.append(Build.VERSION.RELEASE);
            sb.append("\n");
            sb.append("Android SDK        : ");
            sb.append(Build.VERSION.SDK_INT);
            sb.append("\n");
            sb.append("App VersionName    : ");
            sb.append(AppUtils.getAppVersionName());
            sb.append("\n");
            sb.append("App VersionCode    : ");
            sb.append(AppUtils.getAppVersionCode());
            sb.append("\n");
            sb.append(getAppended());
            sb.append(str);
            sb.append("\n");
            return sb.toString();
        }
    }
}
