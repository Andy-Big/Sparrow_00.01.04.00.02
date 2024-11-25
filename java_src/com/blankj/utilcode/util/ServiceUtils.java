package com.blankj.utilcode.util;

import android.app.ActivityManager;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public final class ServiceUtils {
    private ServiceUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static Set<String> getAllRunningServices() {
        List<ActivityManager.RunningServiceInfo> runningServices = ((ActivityManager) Utils.getApp().getSystemService("activity")).getRunningServices(Integer.MAX_VALUE);
        HashSet hashSet = new HashSet();
        if (runningServices == null || runningServices.size() == 0) {
            return null;
        }
        for (ActivityManager.RunningServiceInfo runningServiceInfo : runningServices) {
            hashSet.add(runningServiceInfo.service.getClassName());
        }
        return hashSet;
    }

    public static void startService(String str) {
        if (str == null) {
            throw new NullPointerException("Argument 'className' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        try {
            startService(Class.forName(str));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void startService(Class<?> cls) {
        if (cls == null) {
            throw new NullPointerException("Argument 'cls' of type Class<?> (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        startService(new Intent(Utils.getApp(), cls));
    }

    public static void startService(Intent intent) {
        try {
            intent.setFlags(32);
            if (Build.VERSION.SDK_INT >= 26) {
                Utils.getApp().startForegroundService(intent);
            } else {
                Utils.getApp().startService(intent);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean stopService(String str) {
        if (str == null) {
            throw new NullPointerException("Argument 'className' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        try {
            return stopService(Class.forName(str));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean stopService(Class<?> cls) {
        if (cls == null) {
            throw new NullPointerException("Argument 'cls' of type Class<?> (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        return stopService(new Intent(Utils.getApp(), cls));
    }

    public static boolean stopService(Intent intent) {
        if (intent == null) {
            throw new NullPointerException("Argument 'intent' of type Intent (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        try {
            return Utils.getApp().stopService(intent);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void bindService(String str, ServiceConnection serviceConnection, int i) {
        if (str == null) {
            throw new NullPointerException("Argument 'className' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        if (serviceConnection == null) {
            throw new NullPointerException("Argument 'conn' of type ServiceConnection (#1 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        try {
            bindService(Class.forName(str), serviceConnection, i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void bindService(Class<?> cls, ServiceConnection serviceConnection, int i) {
        if (cls == null) {
            throw new NullPointerException("Argument 'cls' of type Class<?> (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        if (serviceConnection == null) {
            throw new NullPointerException("Argument 'conn' of type ServiceConnection (#1 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        bindService(new Intent(Utils.getApp(), cls), serviceConnection, i);
    }

    public static void bindService(Intent intent, ServiceConnection serviceConnection, int i) {
        if (intent == null) {
            throw new NullPointerException("Argument 'intent' of type Intent (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        if (serviceConnection == null) {
            throw new NullPointerException("Argument 'conn' of type ServiceConnection (#1 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        try {
            Utils.getApp().bindService(intent, serviceConnection, i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void unbindService(ServiceConnection serviceConnection) {
        if (serviceConnection == null) {
            throw new NullPointerException("Argument 'conn' of type ServiceConnection (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        Utils.getApp().unbindService(serviceConnection);
    }

    public static boolean isServiceRunning(Class<?> cls) {
        if (cls == null) {
            throw new NullPointerException("Argument 'cls' of type Class<?> (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        return isServiceRunning(cls.getName());
    }

    public static boolean isServiceRunning(String str) {
        if (str == null) {
            throw new NullPointerException("Argument 'className' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        try {
            List<ActivityManager.RunningServiceInfo> runningServices = ((ActivityManager) Utils.getApp().getSystemService("activity")).getRunningServices(Integer.MAX_VALUE);
            if (runningServices != null && runningServices.size() != 0) {
                for (ActivityManager.RunningServiceInfo runningServiceInfo : runningServices) {
                    if (str.equals(runningServiceInfo.service.getClassName())) {
                        return true;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }
}
