package com.blankj.utilcode.util;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.util.Pair;
import android.view.MotionEvent;
import androidx.core.content.ContextCompat;
import com.blankj.utilcode.constant.PermissionConstants;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.UtilsTransActivity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public final class PermissionUtils {
    private static PermissionUtils sInstance;
    private static SimpleCallback sSimpleCallback4DrawOverlays;
    private static SimpleCallback sSimpleCallback4WriteSettings;
    private FullCallback mFullCallback;
    private OnExplainListener mOnExplainListener;
    private OnRationaleListener mOnRationaleListener;
    private Set<String> mPermissions;
    private List<String> mPermissionsDenied;
    private List<String> mPermissionsDeniedForever;
    private List<String> mPermissionsGranted;
    private String[] mPermissionsParam;
    private List<String> mPermissionsRequest;
    private SimpleCallback mSimpleCallback;
    private SingleCallback mSingleCallback;
    private ThemeCallback mThemeCallback;

    /* loaded from: classes.dex */
    public interface FullCallback {
        void onDenied(List<String> list, List<String> list2);

        void onGranted(List<String> list);
    }

    /* loaded from: classes.dex */
    public interface OnExplainListener {

        /* loaded from: classes.dex */
        public interface ShouldRequest {
            void start(boolean z);
        }

        void explain(UtilsTransActivity utilsTransActivity, List<String> list, ShouldRequest shouldRequest);
    }

    /* loaded from: classes.dex */
    public interface OnRationaleListener {

        /* loaded from: classes.dex */
        public interface ShouldRequest {
            void again(boolean z);
        }

        void rationale(UtilsTransActivity utilsTransActivity, ShouldRequest shouldRequest);
    }

    /* loaded from: classes.dex */
    public interface SimpleCallback {
        void onDenied();

        void onGranted();
    }

    /* loaded from: classes.dex */
    public interface SingleCallback {
        void callback(boolean z, List<String> list, List<String> list2, List<String> list3);
    }

    /* loaded from: classes.dex */
    public interface ThemeCallback {
        void onActivityCreate(Activity activity);
    }

    public static List<String> getPermissions() {
        return getPermissions(Utils.getApp().getPackageName());
    }

    public static List<String> getPermissions(String str) {
        try {
            String[] strArr = Utils.getApp().getPackageManager().getPackageInfo(str, 4096).requestedPermissions;
            if (strArr == null) {
                return Collections.emptyList();
            }
            return Arrays.asList(strArr);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public static boolean isGranted(String... strArr) {
        Pair<List<String>, List<String>> requestAndDeniedPermissions = getRequestAndDeniedPermissions(strArr);
        if (((List) requestAndDeniedPermissions.second).isEmpty()) {
            for (String str : (List) requestAndDeniedPermissions.first) {
                if (!isGranted(str)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    private static Pair<List<String>, List<String>> getRequestAndDeniedPermissions(String... strArr) {
        String[] permissions;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        List<String> permissions2 = getPermissions();
        for (String str : strArr) {
            boolean z = false;
            for (String str2 : PermissionConstants.getPermissions(str)) {
                if (permissions2.contains(str2)) {
                    arrayList.add(str2);
                    z = true;
                }
            }
            if (!z) {
                arrayList2.add(str);
                Log.e("PermissionUtils", "U should add the permission of " + str + " in manifest.");
            }
        }
        return Pair.create(arrayList, arrayList2);
    }

    private static boolean isGranted(String str) {
        return Build.VERSION.SDK_INT < 23 || ContextCompat.checkSelfPermission(Utils.getApp(), str) == 0;
    }

    public static boolean isGrantedWriteSettings() {
        return Settings.System.canWrite(Utils.getApp());
    }

    public static void requestWriteSettings(SimpleCallback simpleCallback) {
        if (!isGrantedWriteSettings()) {
            sSimpleCallback4WriteSettings = simpleCallback;
            PermissionActivityImpl.start(2);
        } else if (simpleCallback != null) {
            simpleCallback.onGranted();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void startWriteSettingsActivity(Activity activity, int i) {
        Intent intent = new Intent("android.settings.action.MANAGE_WRITE_SETTINGS");
        intent.setData(Uri.parse("package:" + Utils.getApp().getPackageName()));
        if (!UtilsBridge.isIntentAvailable(intent)) {
            launchAppDetailsSettings();
        } else {
            activity.startActivityForResult(intent, i);
        }
    }

    public static boolean isGrantedDrawOverlays() {
        return Settings.canDrawOverlays(Utils.getApp());
    }

    public static void requestDrawOverlays(SimpleCallback simpleCallback) {
        if (!isGrantedDrawOverlays()) {
            sSimpleCallback4DrawOverlays = simpleCallback;
            PermissionActivityImpl.start(3);
        } else if (simpleCallback != null) {
            simpleCallback.onGranted();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void startOverlayPermissionActivity(Activity activity, int i) {
        Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
        intent.setData(Uri.parse("package:" + Utils.getApp().getPackageName()));
        if (!UtilsBridge.isIntentAvailable(intent)) {
            launchAppDetailsSettings();
        } else {
            activity.startActivityForResult(intent, i);
        }
    }

    public static void launchAppDetailsSettings() {
        Intent launchAppDetailsSettingsIntent = UtilsBridge.getLaunchAppDetailsSettingsIntent(Utils.getApp().getPackageName(), true);
        if (UtilsBridge.isIntentAvailable(launchAppDetailsSettingsIntent)) {
            Utils.getApp().startActivity(launchAppDetailsSettingsIntent);
        }
    }

    public static PermissionUtils permissionGroup(String... strArr) {
        return permission(strArr);
    }

    public static PermissionUtils permission(String... strArr) {
        return new PermissionUtils(strArr);
    }

    private PermissionUtils(String... strArr) {
        this.mPermissionsParam = strArr;
        sInstance = this;
    }

    public PermissionUtils explain(OnExplainListener onExplainListener) {
        this.mOnExplainListener = onExplainListener;
        return this;
    }

    public PermissionUtils rationale(OnRationaleListener onRationaleListener) {
        this.mOnRationaleListener = onRationaleListener;
        return this;
    }

    public PermissionUtils callback(SingleCallback singleCallback) {
        this.mSingleCallback = singleCallback;
        return this;
    }

    public PermissionUtils callback(SimpleCallback simpleCallback) {
        this.mSimpleCallback = simpleCallback;
        return this;
    }

    public PermissionUtils callback(FullCallback fullCallback) {
        this.mFullCallback = fullCallback;
        return this;
    }

    public PermissionUtils theme(ThemeCallback themeCallback) {
        this.mThemeCallback = themeCallback;
        return this;
    }

    public void request() {
        String[] strArr = this.mPermissionsParam;
        if (strArr == null || strArr.length <= 0) {
            Log.w("PermissionUtils", "No permissions to request.");
            return;
        }
        this.mPermissions = new LinkedHashSet();
        this.mPermissionsRequest = new ArrayList();
        this.mPermissionsGranted = new ArrayList();
        this.mPermissionsDenied = new ArrayList();
        this.mPermissionsDeniedForever = new ArrayList();
        Pair<List<String>, List<String>> requestAndDeniedPermissions = getRequestAndDeniedPermissions(this.mPermissionsParam);
        this.mPermissions.addAll((Collection) requestAndDeniedPermissions.first);
        this.mPermissionsDenied.addAll((Collection) requestAndDeniedPermissions.second);
        if (Build.VERSION.SDK_INT < 23) {
            this.mPermissionsGranted.addAll(this.mPermissions);
            requestCallback();
            return;
        }
        for (String str : this.mPermissions) {
            if (isGranted(str)) {
                this.mPermissionsGranted.add(str);
            } else {
                this.mPermissionsRequest.add(str);
            }
        }
        if (this.mPermissionsRequest.isEmpty()) {
            requestCallback();
        } else {
            startPermissionActivity();
        }
    }

    private void startPermissionActivity() {
        PermissionActivityImpl.start(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean shouldRationale(UtilsTransActivity utilsTransActivity, Runnable runnable) {
        boolean z = false;
        if (this.mOnRationaleListener != null) {
            Iterator<String> it = this.mPermissionsRequest.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (utilsTransActivity.shouldShowRequestPermissionRationale(it.next())) {
                    rationalInner(utilsTransActivity, runnable);
                    z = true;
                    break;
                }
            }
            this.mOnRationaleListener = null;
        }
        return z;
    }

    private void rationalInner(final UtilsTransActivity utilsTransActivity, final Runnable runnable) {
        getPermissionsStatus(utilsTransActivity);
        this.mOnRationaleListener.rationale(utilsTransActivity, new OnRationaleListener.ShouldRequest() { // from class: com.blankj.utilcode.util.PermissionUtils.1
            @Override // com.blankj.utilcode.util.PermissionUtils.OnRationaleListener.ShouldRequest
            public void again(boolean z) {
                if (z) {
                    PermissionUtils.this.mPermissionsDenied = new ArrayList();
                    PermissionUtils.this.mPermissionsDeniedForever = new ArrayList();
                    runnable.run();
                    return;
                }
                utilsTransActivity.finish();
                PermissionUtils.this.requestCallback();
            }
        });
    }

    private void getPermissionsStatus(Activity activity) {
        for (String str : this.mPermissionsRequest) {
            if (isGranted(str)) {
                this.mPermissionsGranted.add(str);
            } else {
                this.mPermissionsDenied.add(str);
                if (!activity.shouldShowRequestPermissionRationale(str)) {
                    this.mPermissionsDeniedForever.add(str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestCallback() {
        SingleCallback singleCallback = this.mSingleCallback;
        if (singleCallback != null) {
            singleCallback.callback(this.mPermissionsDenied.isEmpty(), this.mPermissionsGranted, this.mPermissionsDeniedForever, this.mPermissionsDenied);
            this.mSingleCallback = null;
        }
        if (this.mSimpleCallback != null) {
            if (this.mPermissionsDenied.isEmpty()) {
                this.mSimpleCallback.onGranted();
            } else {
                this.mSimpleCallback.onDenied();
            }
            this.mSimpleCallback = null;
        }
        if (this.mFullCallback != null) {
            if (this.mPermissionsRequest.size() == 0 || this.mPermissionsGranted.size() > 0) {
                this.mFullCallback.onGranted(this.mPermissionsGranted);
            }
            if (!this.mPermissionsDenied.isEmpty()) {
                this.mFullCallback.onDenied(this.mPermissionsDeniedForever, this.mPermissionsDenied);
            }
            this.mFullCallback = null;
        }
        this.mOnRationaleListener = null;
        this.mThemeCallback = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onRequestPermissionsResult(Activity activity) {
        getPermissionsStatus(activity);
        requestCallback();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class PermissionActivityImpl extends UtilsTransActivity.TransActivityDelegate {
        private static PermissionActivityImpl INSTANCE = new PermissionActivityImpl();
        private static final String TYPE = "TYPE";
        private static final int TYPE_DRAW_OVERLAYS = 3;
        private static final int TYPE_RUNTIME = 1;
        private static final int TYPE_WRITE_SETTINGS = 2;
        private static int currentRequestCode = -1;

        PermissionActivityImpl() {
        }

        public static void start(final int i) {
            UtilsTransActivity.start(new Utils.Consumer<Intent>() { // from class: com.blankj.utilcode.util.PermissionUtils.PermissionActivityImpl.1
                @Override // com.blankj.utilcode.util.Utils.Consumer
                public void accept(Intent intent) {
                    intent.putExtra(PermissionActivityImpl.TYPE, i);
                }
            }, INSTANCE);
        }

        @Override // com.blankj.utilcode.util.UtilsTransActivity.TransActivityDelegate
        public void onCreated(final UtilsTransActivity utilsTransActivity, Bundle bundle) {
            if (utilsTransActivity == null) {
                throw new NullPointerException("Argument 'activity' of type UtilsTransActivity (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            }
            utilsTransActivity.getWindow().addFlags(262160);
            int intExtra = utilsTransActivity.getIntent().getIntExtra(TYPE, -1);
            if (intExtra != 1) {
                if (intExtra == 2) {
                    currentRequestCode = 2;
                    PermissionUtils.startWriteSettingsActivity(utilsTransActivity, 2);
                } else if (intExtra == 3) {
                    currentRequestCode = 3;
                    PermissionUtils.startOverlayPermissionActivity(utilsTransActivity, 3);
                } else {
                    utilsTransActivity.finish();
                    Log.e("PermissionUtils", "type is wrong.");
                }
            } else if (PermissionUtils.sInstance != null) {
                if (PermissionUtils.sInstance.mPermissionsRequest != null) {
                    if (PermissionUtils.sInstance.mPermissionsRequest.size() > 0) {
                        if (PermissionUtils.sInstance.mThemeCallback != null) {
                            PermissionUtils.sInstance.mThemeCallback.onActivityCreate(utilsTransActivity);
                        }
                        if (PermissionUtils.sInstance.mOnExplainListener != null) {
                            PermissionUtils.sInstance.mOnExplainListener.explain(utilsTransActivity, PermissionUtils.sInstance.mPermissionsRequest, new OnExplainListener.ShouldRequest() { // from class: com.blankj.utilcode.util.PermissionUtils.PermissionActivityImpl.2
                                @Override // com.blankj.utilcode.util.PermissionUtils.OnExplainListener.ShouldRequest
                                public void start(boolean z) {
                                    if (z) {
                                        PermissionActivityImpl.this.requestPermissions(utilsTransActivity);
                                    } else {
                                        utilsTransActivity.finish();
                                    }
                                }
                            });
                            PermissionUtils.sInstance.mOnExplainListener = null;
                            return;
                        }
                        requestPermissions(utilsTransActivity);
                        return;
                    }
                    Log.e("PermissionUtils", "mPermissionsRequest's size is no more than 0.");
                    utilsTransActivity.finish();
                    return;
                }
                Log.e("PermissionUtils", "mPermissionsRequest is null.");
                utilsTransActivity.finish();
            } else {
                Log.e("PermissionUtils", "sInstance is null.");
                utilsTransActivity.finish();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void requestPermissions(final UtilsTransActivity utilsTransActivity) {
            if (PermissionUtils.sInstance.shouldRationale(utilsTransActivity, new Runnable() { // from class: com.blankj.utilcode.util.PermissionUtils.PermissionActivityImpl.3
                @Override // java.lang.Runnable
                public void run() {
                    utilsTransActivity.requestPermissions((String[]) PermissionUtils.sInstance.mPermissionsRequest.toArray(new String[0]), 1);
                }
            })) {
                return;
            }
            utilsTransActivity.requestPermissions((String[]) PermissionUtils.sInstance.mPermissionsRequest.toArray(new String[0]), 1);
        }

        @Override // com.blankj.utilcode.util.UtilsTransActivity.TransActivityDelegate
        public void onRequestPermissionsResult(UtilsTransActivity utilsTransActivity, int i, String[] strArr, int[] iArr) {
            if (utilsTransActivity == null) {
                throw new NullPointerException("Argument 'activity' of type UtilsTransActivity (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            }
            if (strArr == null) {
                throw new NullPointerException("Argument 'permissions' of type String[] (#2 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            }
            if (iArr == null) {
                throw new NullPointerException("Argument 'grantResults' of type int[] (#3 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            }
            utilsTransActivity.finish();
            if (PermissionUtils.sInstance == null || PermissionUtils.sInstance.mPermissionsRequest == null) {
                return;
            }
            PermissionUtils.sInstance.onRequestPermissionsResult(utilsTransActivity);
        }

        @Override // com.blankj.utilcode.util.UtilsTransActivity.TransActivityDelegate
        public boolean dispatchTouchEvent(UtilsTransActivity utilsTransActivity, MotionEvent motionEvent) {
            if (utilsTransActivity == null) {
                throw new NullPointerException("Argument 'activity' of type UtilsTransActivity (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            }
            utilsTransActivity.finish();
            return true;
        }

        @Override // com.blankj.utilcode.util.UtilsTransActivity.TransActivityDelegate
        public void onDestroy(UtilsTransActivity utilsTransActivity) {
            if (utilsTransActivity == null) {
                throw new NullPointerException("Argument 'activity' of type UtilsTransActivity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            }
            int i = currentRequestCode;
            if (i != -1) {
                checkRequestCallback(i);
                currentRequestCode = -1;
            }
            super.onDestroy(utilsTransActivity);
        }

        @Override // com.blankj.utilcode.util.UtilsTransActivity.TransActivityDelegate
        public void onActivityResult(UtilsTransActivity utilsTransActivity, int i, int i2, Intent intent) {
            if (utilsTransActivity == null) {
                throw new NullPointerException("Argument 'activity' of type UtilsTransActivity (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            }
            utilsTransActivity.finish();
        }

        private void checkRequestCallback(int i) {
            if (i == 2) {
                if (PermissionUtils.sSimpleCallback4WriteSettings == null) {
                    return;
                }
                if (PermissionUtils.isGrantedWriteSettings()) {
                    PermissionUtils.sSimpleCallback4WriteSettings.onGranted();
                } else {
                    PermissionUtils.sSimpleCallback4WriteSettings.onDenied();
                }
                SimpleCallback unused = PermissionUtils.sSimpleCallback4WriteSettings = null;
            } else if (i != 3 || PermissionUtils.sSimpleCallback4DrawOverlays == null) {
            } else {
                if (PermissionUtils.isGrantedDrawOverlays()) {
                    PermissionUtils.sSimpleCallback4DrawOverlays.onGranted();
                } else {
                    PermissionUtils.sSimpleCallback4DrawOverlays.onDenied();
                }
                SimpleCallback unused2 = PermissionUtils.sSimpleCallback4DrawOverlays = null;
            }
        }
    }
}
