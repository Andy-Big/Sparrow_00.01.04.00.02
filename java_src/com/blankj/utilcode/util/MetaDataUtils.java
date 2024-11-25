package com.blankj.utilcode.util;

import android.app.Activity;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.pm.PackageManager;
/* loaded from: classes.dex */
public final class MetaDataUtils {
    private MetaDataUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static String getMetaDataInApp(String str) {
        if (str == null) {
            throw new NullPointerException("Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        try {
            return String.valueOf(Utils.getApp().getPackageManager().getApplicationInfo(Utils.getApp().getPackageName(), 128).metaData.get(str));
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String getMetaDataInActivity(Activity activity, String str) {
        if (activity != null) {
            if (str == null) {
                throw new NullPointerException("Argument 'key' of type String (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            }
            return getMetaDataInActivity((Class<? extends Activity>) activity.getClass(), str);
        }
        throw new NullPointerException("Argument 'activity' of type Activity (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    public static String getMetaDataInActivity(Class<? extends Activity> cls, String str) {
        if (cls != null) {
            if (str == null) {
                throw new NullPointerException("Argument 'key' of type String (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            }
            try {
                return String.valueOf(Utils.getApp().getPackageManager().getActivityInfo(new ComponentName(Utils.getApp(), cls), 128).metaData.get(str));
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
                return "";
            }
        }
        throw new NullPointerException("Argument 'clz' of type Class<? extends Activity> (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    public static String getMetaDataInService(Service service, String str) {
        if (service != null) {
            if (str == null) {
                throw new NullPointerException("Argument 'key' of type String (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            }
            return getMetaDataInService((Class<? extends Service>) service.getClass(), str);
        }
        throw new NullPointerException("Argument 'service' of type Service (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    public static String getMetaDataInService(Class<? extends Service> cls, String str) {
        if (cls != null) {
            if (str == null) {
                throw new NullPointerException("Argument 'key' of type String (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            }
            try {
                return String.valueOf(Utils.getApp().getPackageManager().getServiceInfo(new ComponentName(Utils.getApp(), cls), 128).metaData.get(str));
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
                return "";
            }
        }
        throw new NullPointerException("Argument 'clz' of type Class<? extends Service> (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    public static String getMetaDataInReceiver(BroadcastReceiver broadcastReceiver, String str) {
        if (broadcastReceiver != null) {
            if (str == null) {
                throw new NullPointerException("Argument 'key' of type String (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            }
            return getMetaDataInReceiver(broadcastReceiver, str);
        }
        throw new NullPointerException("Argument 'receiver' of type BroadcastReceiver (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    public static String getMetaDataInReceiver(Class<? extends BroadcastReceiver> cls, String str) {
        if (cls != null) {
            if (str == null) {
                throw new NullPointerException("Argument 'key' of type String (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            }
            try {
                return String.valueOf(Utils.getApp().getPackageManager().getReceiverInfo(new ComponentName(Utils.getApp(), cls), 128).metaData.get(str));
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
                return "";
            }
        }
        throw new NullPointerException("Argument 'clz' of type Class<? extends BroadcastReceiver> (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }
}
