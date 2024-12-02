package com.rigol.util;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.storage.StorageManager;
import android.os.storage.StorageVolume;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.Utils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DiskUtil.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004J\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, d2 = {"Lcom/rigol/util/DiskUtil;", "", "()V", "getMountedDiskInfos", "", "Lcom/rigol/util/DiskInfo;", "hasRemovableDisk", "", "isNetworkConnected", "context", "Landroid/content/Context;", "lib_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class DiskUtil {
    public static final DiskUtil INSTANCE = new DiskUtil();

    private DiskUtil() {
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:101:0x003b */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:24:0x00a6 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:31:0x00d1 */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00d1, code lost:
        if (r9 == null) goto L94;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11, types: [java.io.IOException] */
    /* JADX WARN: Type inference failed for: r8v20 */
    /* JADX WARN: Type inference failed for: r8v21 */
    /* JADX WARN: Type inference failed for: r8v22 */
    /* JADX WARN: Type inference failed for: r8v24 */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<DiskInfo> getMountedDiskInfos() {
        Throwable th;
        BufferedReader bufferedReader;
        String sb;
        ArrayList arrayList = new ArrayList();
        Object systemService = Utils.getApp().getSystemService("storage");
        if (systemService == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.os.storage.StorageManager");
        }
        StorageManager storageManager = (StorageManager) systemService;
        Application app = Utils.getApp();
        Intrinsics.checkNotNullExpressionValue(app, "Utils.getApp()");
        boolean isNetworkConnected = isNetworkConnected(app);
        StringBuilder sb2 = new StringBuilder();
        Process process = null;
        BufferedReader bufferedReader2 = null;
        try {
            if (isNetworkConnected) {
                try {
                    process = Runtime.getRuntime().exec(new String[]{"sh", "-c", "mount | grep /storage/smb"});
                    Intrinsics.checkNotNullExpressionValue(process, "process");
                    BufferedReader bufferedReader3 = new BufferedReader(new InputStreamReader(process.getInputStream()));
                    while (true) {
                        try {
                            String readLine = bufferedReader3.readLine();
                            if (readLine == null) {
                                break;
                            }
                            sb2.append(readLine);
                            sb2.append("\n");
                        } catch (IOException e) {
                            e = e;
                            bufferedReader2 = bufferedReader3;
                            sb2.append("IOException: ");
                            sb2.append(e.getMessage());
                            sb2.append("\n");
                            Intrinsics.checkNotNullExpressionValue(sb2, "sOut.append(\"IOException…d(e.message).append(\"\\n\")");
                            bufferedReader2 = bufferedReader2;
                            if (bufferedReader2 != null) {
                                try {
                                    bufferedReader2.close();
                                    bufferedReader2 = bufferedReader2;
                                } catch (IOException e2) {
                                    IOException iOException = e2;
                                    sb2.append("IOException on close: ");
                                    sb2.append(iOException.getMessage());
                                    sb2.append("\n");
                                    Intrinsics.checkNotNullExpressionValue(sb2, "sOut.append(\"IOException…d(e.message).append(\"\\n\")");
                                    bufferedReader2 = iOException;
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            bufferedReader = bufferedReader3;
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException e3) {
                                    sb2.append("IOException on close: ");
                                    sb2.append(e3.getMessage());
                                    sb2.append("\n");
                                    Intrinsics.checkNotNullExpressionValue(sb2, "sOut.append(\"IOException…d(e.message).append(\"\\n\")");
                                }
                            }
                            if (process != null) {
                                process.destroy();
                            }
                            throw th;
                        }
                    }
                    int waitFor = process.waitFor();
                    bufferedReader2 = bufferedReader2;
                    if (waitFor != 0) {
                        sb2.append("Error: Command exited with value ");
                        sb2.append(waitFor);
                        sb2.append("\n");
                        bufferedReader2 = "Error: Command exited with value ";
                    }
                    try {
                        bufferedReader3.close();
                    } catch (IOException e4) {
                        bufferedReader2 = e4;
                        sb2.append("IOException on close: ");
                        sb2.append(bufferedReader2.getMessage());
                        sb2.append("\n");
                        Intrinsics.checkNotNullExpressionValue(sb2, "sOut.append(\"IOException…d(e.message).append(\"\\n\")");
                    }
                } catch (IOException e5) {
                    e = e5;
                }
                process.destroy();
                sb = sb2.toString();
                Intrinsics.checkNotNullExpressionValue(sb, "sOut.toString()");
            } else {
                sb = "Error";
            }
            if (sb != null) {
                int i = 0;
                String substring = sb.substring(0, 5);
                Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                if (Intrinsics.areEqual(substring, "Error")) {
                    LogUtils.e("no smb");
                } else {
                    LogUtils.e("has smb");
                    arrayList.add(new DiskInfo("/storage/smb", "mounted", false));
                }
                if (Build.VERSION.SDK_INT >= 24) {
                    List<StorageVolume> storageVolumes = storageManager.getStorageVolumes();
                    try {
                        Method method = StorageVolume.class.getMethod("getPath", new Class[0]);
                        Intrinsics.checkNotNullExpressionValue(method, "StorageVolume::class.java.getMethod(\"getPath\")");
                        for (StorageVolume storageVolume : storageVolumes) {
                            Intrinsics.checkNotNullExpressionValue(storageVolume, "storageVolume");
                            boolean isRemovable = storageVolume.isRemovable();
                            String state = storageVolume.getState();
                            Object invoke = method.invoke(storageVolume, new Object[0]);
                            if (invoke == null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                            }
                            String str = (String) invoke;
                            if (Intrinsics.areEqual("mounted", state)) {
                                arrayList.add(new DiskInfo(str, state, isRemovable));
                            }
                        }
                    } catch (IllegalAccessException e6) {
                        e6.printStackTrace();
                    } catch (NoSuchMethodException e7) {
                        e7.printStackTrace();
                    } catch (InvocationTargetException e8) {
                        e8.printStackTrace();
                    }
                } else {
                    try {
                        Class<?> cls = Class.forName("android.os.storage.StorageVolume");
                        Intrinsics.checkNotNullExpressionValue(cls, "Class.forName(\"android.os.storage.StorageVolume\")");
                        Method method2 = cls.getMethod("getPath", new Class[0]);
                        Intrinsics.checkNotNullExpressionValue(method2, "storageVolumeClazz.getMethod(\"getPath\")");
                        Method method3 = cls.getMethod("isRemovable", new Class[0]);
                        Intrinsics.checkNotNullExpressionValue(method3, "storageVolumeClazz.getMethod(\"isRemovable\")");
                        Method method4 = StorageManager.class.getMethod("getVolumeState", String.class);
                        Intrinsics.checkNotNullExpressionValue(method4, "StorageManager::class.ja…ate\", String::class.java)");
                        Method method5 = StorageManager.class.getMethod("getVolumeList", new Class[0]);
                        Intrinsics.checkNotNullExpressionValue(method5, "StorageManager::class.ja…etMethod(\"getVolumeList\")");
                        Object invoke2 = method5.invoke(storageManager, new Object[0]);
                        if (invoke2 != null) {
                            int length = Array.getLength(invoke2);
                            int i2 = 0;
                            while (i2 < length) {
                                Object obj = Array.get(invoke2, i2);
                                Object invoke3 = method2.invoke(obj, new Object[i]);
                                if (invoke3 == null) {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                }
                                String str2 = (String) invoke3;
                                Object invoke4 = method3.invoke(obj, new Object[i]);
                                if (invoke4 == null) {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                                }
                                boolean booleanValue = ((Boolean) invoke4).booleanValue();
                                Object[] objArr = new Object[1];
                                objArr[i] = str2;
                                Object invoke5 = method4.invoke(storageManager, objArr);
                                if (invoke5 == null) {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                }
                                String str3 = (String) invoke5;
                                if (Intrinsics.areEqual("mounted", str3)) {
                                    arrayList.add(new DiskInfo(str2, str3, booleanValue));
                                }
                                i2++;
                                i = 0;
                            }
                        }
                    } catch (ClassNotFoundException e9) {
                        e9.printStackTrace();
                    } catch (IllegalAccessException e10) {
                        e10.printStackTrace();
                    } catch (NoSuchMethodException e11) {
                        e11.printStackTrace();
                    } catch (InvocationTargetException e12) {
                        e12.printStackTrace();
                    }
                }
                return arrayList;
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = bufferedReader2;
        }
    }

    public final boolean hasRemovableDisk() {
        try {
            for (DiskInfo diskInfo : getMountedDiskInfos()) {
                if (diskInfo != null && Intrinsics.areEqual("mounted", diskInfo.getState()) && diskInfo.isRemovable()) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public final boolean isNetworkConnected(Context context) {
        NetworkCapabilities networkCapabilities;
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("connectivity");
        if (systemService == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.net.ConnectivityManager");
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
        if (Build.VERSION.SDK_INT >= 23) {
            Network activeNetwork = connectivityManager.getActiveNetwork();
            if (activeNetwork == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null) {
                return false;
            }
            return networkCapabilities.hasCapability(12);
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            return activeNetworkInfo.isConnected();
        }
        return false;
    }
}
