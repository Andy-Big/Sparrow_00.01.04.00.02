package com.rigol.scope.utilities;

import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.display.IDisplayManager;
import android.os.Build;
import android.os.IBinder;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.IWindowManager;
import java.lang.reflect.InvocationTargetException;
/* loaded from: classes2.dex */
public class SystemUtil {
    private static final String TAG = SystemUtil.class.getSimpleName();

    public static void restart(Context context) {
        try {
            ((PowerManager) context.getSystemService("power")).reboot("重启");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void shutdown() {
        try {
            Object invoke = Class.forName("android.os.IPowerManager$Stub").getMethod("asInterface", IBinder.class).invoke(null, Class.forName("android.os.ServiceManager").getMethod("getService", String.class).invoke(null, "power"));
            invoke.getClass().getMethod("shutdown", Boolean.TYPE, String.class, Boolean.TYPE).invoke(invoke, false, "userrequested", true);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (NoSuchMethodException e3) {
            e3.printStackTrace();
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
        }
    }

    public static boolean isSystemApp(Context context) {
        return "android.uid.system".equals(getAppSharedUserID(context, context.getPackageName()));
    }

    public static String getAppSharedUserID(Context context, String str) {
        PackageManager packageManager;
        String str2;
        if (context != null && (packageManager = context.getPackageManager()) != null) {
            try {
                if (Build.VERSION.SDK_INT >= 24) {
                    str2 = packageManager.getNameForUid(packageManager.getPackageUid(str, 0));
                    Log.d(TAG, "callingName = " + str2);
                } else {
                    str2 = null;
                }
                if (!TextUtils.isEmpty(str2)) {
                    if (!str2.contains(":")) {
                        return str2;
                    }
                    String[] split = str2.split(":");
                    if (split.length >= 2) {
                        return split[0];
                    }
                }
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static IWindowManager getWindowManager() {
        try {
            return IWindowManager.Stub.asInterface((IBinder) Class.forName("android.os.ServiceManager").getDeclaredMethod("getService", String.class).invoke(null, "window"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return null;
        } catch (NoSuchMethodException e3) {
            e3.printStackTrace();
            return null;
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public static IDisplayManager getDisplayManager() {
        try {
            return IDisplayManager.Stub.asInterface((IBinder) Class.forName("android.os.ServiceManager").getDeclaredMethod("getService", String.class).invoke(null, "display"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return null;
        } catch (NoSuchMethodException e3) {
            e3.printStackTrace();
            return null;
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
            return null;
        }
    }
}
