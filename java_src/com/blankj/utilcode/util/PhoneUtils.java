package com.blankj.utilcode.util;

import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

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
    */
    public static String getImeiOrMeid(boolean z) {
        String str;
        String str2 = "";
        if (Build.VERSION.SDK_INT >= 29) {
            return "";
        }
        TelephonyManager telephonyManager = getTelephonyManager();
        int i = 1;
        if (Build.VERSION.SDK_INT >= 26) {
            if (z) {
                return getMinOne(telephonyManager.getImei(0), telephonyManager.getImei(1));
            }
            return getMinOne(telephonyManager.getMeid(0), telephonyManager.getMeid(1));
        } else if (Build.VERSION.SDK_INT >= 21) {
            String systemPropertyByReflect = getSystemPropertyByReflect(z ? "ril.gsm.imei" : "ril.cdma.meid");
            if (!TextUtils.isEmpty(systemPropertyByReflect)) {
                String[] split = systemPropertyByReflect.split(",");
                if (split.length == 2) {
                    return getMinOne(split[0], split[1]);
                }
                return split[0];
            }
            String deviceId = telephonyManager.getDeviceId();
            try {
                Method method = telephonyManager.getClass().getMethod("getDeviceId", Integer.TYPE);
                Object[] objArr = new Object[1];
                if (!z) {
                    i = 2;
                }
                objArr[0] = Integer.valueOf(i);
                str = (String) method.invoke(telephonyManager, objArr);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                str = "";
                if (!z) {
                }
                return getMinOne(deviceId, str2);
            } catch (NoSuchMethodException e2) {
                e2.printStackTrace();
                str = "";
                if (!z) {
                }
                return getMinOne(deviceId, str2);
            } catch (InvocationTargetException e3) {
                e3.printStackTrace();
                str = "";
                if (!z) {
                }
                return getMinOne(deviceId, str2);
            }
            if (!z) {
                if (deviceId != null && deviceId.length() < 15) {
                    deviceId = "";
                }
                if (str != null) {
                }
                str2 = str;
            } else {
                if (deviceId != null && deviceId.length() == 14) {
                    deviceId = "";
                }
                if (str != null) {
                }
                str2 = str;
            }
            return getMinOne(deviceId, str2);
        } else {
            String deviceId2 = telephonyManager.getDeviceId();
            if (z) {
                if (deviceId2 != null && deviceId2.length() >= 15) {
                    return deviceId2;
                }
            } else if (deviceId2 != null && deviceId2.length() == 14) {
                return deviceId2;
            }
            return "";
        }
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
