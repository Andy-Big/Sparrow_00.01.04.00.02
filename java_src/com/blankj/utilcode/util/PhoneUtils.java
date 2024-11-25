package com.blankj.utilcode.util;

import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
/* loaded from: classes.dex */
public final class PhoneUtils {
    private PhoneUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static boolean isPhone() {
        return getTelephonyManager().getPhoneType() != 0;
    }

    public static String getDeviceId() {
        if (Build.VERSION.SDK_INT >= 29) {
            return "";
        }
        TelephonyManager telephonyManager = getTelephonyManager();
        String deviceId = telephonyManager.getDeviceId();
        if (TextUtils.isEmpty(deviceId)) {
            if (Build.VERSION.SDK_INT >= 26) {
                String imei = telephonyManager.getImei();
                if (TextUtils.isEmpty(imei)) {
                    String meid = telephonyManager.getMeid();
                    return TextUtils.isEmpty(meid) ? "" : meid;
                }
                return imei;
            }
            return "";
        }
        return deviceId;
    }

    public static String getSerial() {
        if (Build.VERSION.SDK_INT < 29) {
            return Build.VERSION.SDK_INT >= 26 ? Build.getSerial() : Build.SERIAL;
        }
        try {
            return Build.getSerial();
        } catch (SecurityException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String getIMEI() {
        return getImeiOrMeid(true);
    }

    public static String getMEID() {
        return getImeiOrMeid(false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x00a9, code lost:
        if (r0.length() < 15) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00bb, code lost:
        if (r0.length() == 14) goto L38;
     */
    /* JADX WARN: Removed duplicated region for block: B:40:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00ac  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String getImeiOrMeid(boolean r12) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            java.lang.String r1 = ""
            r2 = 29
            if (r0 < r2) goto L9
            return r1
        L9:
            android.telephony.TelephonyManager r0 = getTelephonyManager()
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 26
            r4 = 1
            r5 = 0
            if (r2 < r3) goto L31
            if (r12 == 0) goto L24
            java.lang.String r12 = r0.getImei(r5)
            java.lang.String r0 = r0.getImei(r4)
            java.lang.String r12 = getMinOne(r12, r0)
            return r12
        L24:
            java.lang.String r12 = r0.getMeid(r5)
            java.lang.String r0 = r0.getMeid(r4)
            java.lang.String r12 = getMinOne(r12, r0)
            return r12
        L31:
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 21
            r6 = 15
            r7 = 14
            if (r2 < r3) goto Lc4
            if (r12 == 0) goto L40
            java.lang.String r2 = "ril.gsm.imei"
            goto L42
        L40:
            java.lang.String r2 = "ril.cdma.meid"
        L42:
            java.lang.String r2 = getSystemPropertyByReflect(r2)
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            r8 = 2
            if (r3 != 0) goto L62
            java.lang.String r12 = ","
            java.lang.String[] r12 = r2.split(r12)
            int r0 = r12.length
            if (r0 != r8) goto L5f
            r0 = r12[r5]
            r12 = r12[r4]
            java.lang.String r12 = getMinOne(r0, r12)
            return r12
        L5f:
            r12 = r12[r5]
            return r12
        L62:
            java.lang.String r2 = r0.getDeviceId()
            java.lang.Class r3 = r0.getClass()     // Catch: java.lang.reflect.InvocationTargetException -> L89 java.lang.IllegalAccessException -> L8e java.lang.NoSuchMethodException -> L93
            java.lang.String r9 = "getDeviceId"
            java.lang.Class[] r10 = new java.lang.Class[r4]     // Catch: java.lang.reflect.InvocationTargetException -> L89 java.lang.IllegalAccessException -> L8e java.lang.NoSuchMethodException -> L93
            java.lang.Class r11 = java.lang.Integer.TYPE     // Catch: java.lang.reflect.InvocationTargetException -> L89 java.lang.IllegalAccessException -> L8e java.lang.NoSuchMethodException -> L93
            r10[r5] = r11     // Catch: java.lang.reflect.InvocationTargetException -> L89 java.lang.IllegalAccessException -> L8e java.lang.NoSuchMethodException -> L93
            java.lang.reflect.Method r3 = r3.getMethod(r9, r10)     // Catch: java.lang.reflect.InvocationTargetException -> L89 java.lang.IllegalAccessException -> L8e java.lang.NoSuchMethodException -> L93
            java.lang.Object[] r9 = new java.lang.Object[r4]     // Catch: java.lang.reflect.InvocationTargetException -> L89 java.lang.IllegalAccessException -> L8e java.lang.NoSuchMethodException -> L93
            if (r12 == 0) goto L7b
            goto L7c
        L7b:
            r4 = r8
        L7c:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch: java.lang.reflect.InvocationTargetException -> L89 java.lang.IllegalAccessException -> L8e java.lang.NoSuchMethodException -> L93
            r9[r5] = r4     // Catch: java.lang.reflect.InvocationTargetException -> L89 java.lang.IllegalAccessException -> L8e java.lang.NoSuchMethodException -> L93
            java.lang.Object r0 = r3.invoke(r0, r9)     // Catch: java.lang.reflect.InvocationTargetException -> L89 java.lang.IllegalAccessException -> L8e java.lang.NoSuchMethodException -> L93
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.reflect.InvocationTargetException -> L89 java.lang.IllegalAccessException -> L8e java.lang.NoSuchMethodException -> L93
            goto L98
        L89:
            r0 = move-exception
            r0.printStackTrace()
            goto L97
        L8e:
            r0 = move-exception
            r0.printStackTrace()
            goto L97
        L93:
            r0 = move-exception
            r0.printStackTrace()
        L97:
            r0 = r1
        L98:
            if (r12 == 0) goto Lac
            if (r2 == 0) goto La3
            int r12 = r2.length()
            if (r12 >= r6) goto La3
            r2 = r1
        La3:
            if (r0 == 0) goto Lbe
            int r12 = r0.length()
            if (r12 >= r6) goto Lbe
            goto Lbf
        Lac:
            if (r2 == 0) goto Lb5
            int r12 = r2.length()
            if (r12 != r7) goto Lb5
            r2 = r1
        Lb5:
            if (r0 == 0) goto Lbe
            int r12 = r0.length()
            if (r12 != r7) goto Lbe
            goto Lbf
        Lbe:
            r1 = r0
        Lbf:
            java.lang.String r12 = getMinOne(r2, r1)
            return r12
        Lc4:
            java.lang.String r0 = r0.getDeviceId()
            if (r12 == 0) goto Ld3
            if (r0 == 0) goto Ldc
            int r12 = r0.length()
            if (r12 < r6) goto Ldc
            return r0
        Ld3:
            if (r0 == 0) goto Ldc
            int r12 = r0.length()
            if (r12 != r7) goto Ldc
            return r0
        Ldc:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blankj.utilcode.util.PhoneUtils.getImeiOrMeid(boolean):java.lang.String");
    }

    private static String getMinOne(String str, String str2) {
        boolean isEmpty = TextUtils.isEmpty(str);
        boolean isEmpty2 = TextUtils.isEmpty(str2);
        return (isEmpty && isEmpty2) ? "" : (isEmpty || isEmpty2) ? !isEmpty ? str : str2 : str.compareTo(str2) <= 0 ? str : str2;
    }

    private static String getSystemPropertyByReflect(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, "");
        } catch (Exception unused) {
            return "";
        }
    }

    public static String getIMSI() {
        if (Build.VERSION.SDK_INT >= 29) {
            try {
                getTelephonyManager().getSubscriberId();
            } catch (SecurityException e) {
                e.printStackTrace();
                return "";
            }
        }
        return getTelephonyManager().getSubscriberId();
    }

    public static int getPhoneType() {
        return getTelephonyManager().getPhoneType();
    }

    public static boolean isSimCardReady() {
        return getTelephonyManager().getSimState() == 5;
    }

    public static String getSimOperatorName() {
        return getTelephonyManager().getSimOperatorName();
    }

    public static String getSimOperatorByMnc() {
        String simOperator = getTelephonyManager().getSimOperator();
        if (simOperator == null) {
            return "";
        }
        char c = 65535;
        int hashCode = simOperator.hashCode();
        if (hashCode != 49679479) {
            if (hashCode != 49679502) {
                if (hashCode != 49679532) {
                    switch (hashCode) {
                        case 49679470:
                            if (simOperator.equals("46000")) {
                                c = 0;
                                break;
                            }
                            break;
                        case 49679471:
                            if (simOperator.equals("46001")) {
                                c = 4;
                                break;
                            }
                            break;
                        case 49679472:
                            if (simOperator.equals("46002")) {
                                c = 1;
                                break;
                            }
                            break;
                        case 49679473:
                            if (simOperator.equals("46003")) {
                                c = 7;
                                break;
                            }
                            break;
                        default:
                            switch (hashCode) {
                                case 49679475:
                                    if (simOperator.equals("46005")) {
                                        c = '\b';
                                        break;
                                    }
                                    break;
                                case 49679476:
                                    if (simOperator.equals("46006")) {
                                        c = 5;
                                        break;
                                    }
                                    break;
                                case 49679477:
                                    if (simOperator.equals("46007")) {
                                        c = 2;
                                        break;
                                    }
                                    break;
                            }
                    }
                } else if (simOperator.equals("46020")) {
                    c = 3;
                }
            } else if (simOperator.equals("46011")) {
                c = '\t';
            }
        } else if (simOperator.equals("46009")) {
            c = 6;
        }
        switch (c) {
            case 0:
            case 1:
            case 2:
            case 3:
                return "中国移动";
            case 4:
            case 5:
            case 6:
                return "中国联通";
            case 7:
            case '\b':
            case '\t':
                return "中国电信";
            default:
                return simOperator;
        }
    }

    public static void dial(String str) {
        Utils.getApp().startActivity(UtilsBridge.getDialIntent(str));
    }

    public static void call(String str) {
        Utils.getApp().startActivity(UtilsBridge.getCallIntent(str));
    }

    public static void sendSms(String str, String str2) {
        Utils.getApp().startActivity(UtilsBridge.getSendSmsIntent(str, str2));
    }

    private static TelephonyManager getTelephonyManager() {
        return (TelephonyManager) Utils.getApp().getSystemService("phone");
    }
}
