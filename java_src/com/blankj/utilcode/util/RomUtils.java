package com.blankj.utilcode.util;

import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;
/* loaded from: classes.dex */
public final class RomUtils {
    private static final String UNKNOWN = "unknown";
    private static final String VERSION_PROPERTY_360 = "ro.build.uiversion";
    private static final String VERSION_PROPERTY_HUAWEI = "ro.build.version.emui";
    private static final String VERSION_PROPERTY_LEECO = "ro.letv.release.version";
    private static final String VERSION_PROPERTY_NUBIA = "ro.build.rom.id";
    private static final String VERSION_PROPERTY_ONEPLUS = "ro.rom.version";
    private static final String VERSION_PROPERTY_OPPO = "ro.build.version.opporom";
    private static final String VERSION_PROPERTY_VIVO = "ro.vivo.os.build.display.id";
    private static final String VERSION_PROPERTY_XIAOMI = "ro.build.version.incremental";
    private static final String VERSION_PROPERTY_ZTE = "ro.build.MiFavor_version";
    private static final String[] ROM_HUAWEI = {"huawei"};
    private static final String[] ROM_VIVO = {"vivo"};
    private static final String[] ROM_XIAOMI = {"xiaomi"};
    private static final String[] ROM_OPPO = {"oppo"};
    private static final String[] ROM_LEECO = {"leeco", "letv"};
    private static final String[] ROM_360 = {"360", "qiku"};
    private static final String[] ROM_ZTE = {"zte"};
    private static final String[] ROM_ONEPLUS = {"oneplus"};
    private static final String[] ROM_NUBIA = {"nubia"};
    private static final String[] ROM_COOLPAD = {"coolpad", "yulong"};
    private static final String[] ROM_LG = {"lg", "lge"};
    private static final String[] ROM_GOOGLE = {"google"};
    private static final String[] ROM_SAMSUNG = {"samsung"};
    private static final String[] ROM_MEIZU = {"meizu"};
    private static final String[] ROM_LENOVO = {"lenovo"};
    private static final String[] ROM_SMARTISAN = {"smartisan"};
    private static final String[] ROM_HTC = {"htc"};
    private static final String[] ROM_SONY = {"sony"};
    private static final String[] ROM_GIONEE = {"gionee", "amigo"};
    private static final String[] ROM_MOTOROLA = {"motorola"};
    private static RomInfo bean = null;

    private RomUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static boolean isHuawei() {
        return ROM_HUAWEI[0].equals(getRomInfo().name);
    }

    public static boolean isVivo() {
        return ROM_VIVO[0].equals(getRomInfo().name);
    }

    public static boolean isXiaomi() {
        return ROM_XIAOMI[0].equals(getRomInfo().name);
    }

    public static boolean isOppo() {
        return ROM_OPPO[0].equals(getRomInfo().name);
    }

    public static boolean isLeeco() {
        return ROM_LEECO[0].equals(getRomInfo().name);
    }

    public static boolean is360() {
        return ROM_360[0].equals(getRomInfo().name);
    }

    public static boolean isZte() {
        return ROM_ZTE[0].equals(getRomInfo().name);
    }

    public static boolean isOneplus() {
        return ROM_ONEPLUS[0].equals(getRomInfo().name);
    }

    public static boolean isNubia() {
        return ROM_NUBIA[0].equals(getRomInfo().name);
    }

    public static boolean isCoolpad() {
        return ROM_COOLPAD[0].equals(getRomInfo().name);
    }

    public static boolean isLg() {
        return ROM_LG[0].equals(getRomInfo().name);
    }

    public static boolean isGoogle() {
        return ROM_GOOGLE[0].equals(getRomInfo().name);
    }

    public static boolean isSamsung() {
        return ROM_SAMSUNG[0].equals(getRomInfo().name);
    }

    public static boolean isMeizu() {
        return ROM_MEIZU[0].equals(getRomInfo().name);
    }

    public static boolean isLenovo() {
        return ROM_LENOVO[0].equals(getRomInfo().name);
    }

    public static boolean isSmartisan() {
        return ROM_SMARTISAN[0].equals(getRomInfo().name);
    }

    public static boolean isHtc() {
        return ROM_HTC[0].equals(getRomInfo().name);
    }

    public static boolean isSony() {
        return ROM_SONY[0].equals(getRomInfo().name);
    }

    public static boolean isGionee() {
        return ROM_GIONEE[0].equals(getRomInfo().name);
    }

    public static boolean isMotorola() {
        return ROM_MOTOROLA[0].equals(getRomInfo().name);
    }

    public static RomInfo getRomInfo() {
        RomInfo romInfo = bean;
        if (romInfo != null) {
            return romInfo;
        }
        bean = new RomInfo();
        String brand = getBrand();
        String manufacturer = getManufacturer();
        if (isRightRom(brand, manufacturer, ROM_HUAWEI)) {
            bean.name = ROM_HUAWEI[0];
            String romVersion = getRomVersion(VERSION_PROPERTY_HUAWEI);
            String[] split = romVersion.split("_");
            if (split.length > 1) {
                bean.version = split[1];
            } else {
                bean.version = romVersion;
            }
            return bean;
        } else if (isRightRom(brand, manufacturer, ROM_VIVO)) {
            bean.name = ROM_VIVO[0];
            bean.version = getRomVersion(VERSION_PROPERTY_VIVO);
            return bean;
        } else if (isRightRom(brand, manufacturer, ROM_XIAOMI)) {
            bean.name = ROM_XIAOMI[0];
            bean.version = getRomVersion(VERSION_PROPERTY_XIAOMI);
            return bean;
        } else if (isRightRom(brand, manufacturer, ROM_OPPO)) {
            bean.name = ROM_OPPO[0];
            bean.version = getRomVersion(VERSION_PROPERTY_OPPO);
            return bean;
        } else if (isRightRom(brand, manufacturer, ROM_LEECO)) {
            bean.name = ROM_LEECO[0];
            bean.version = getRomVersion(VERSION_PROPERTY_LEECO);
            return bean;
        } else if (isRightRom(brand, manufacturer, ROM_360)) {
            bean.name = ROM_360[0];
            bean.version = getRomVersion(VERSION_PROPERTY_360);
            return bean;
        } else if (isRightRom(brand, manufacturer, ROM_ZTE)) {
            bean.name = ROM_ZTE[0];
            bean.version = getRomVersion(VERSION_PROPERTY_ZTE);
            return bean;
        } else if (isRightRom(brand, manufacturer, ROM_ONEPLUS)) {
            bean.name = ROM_ONEPLUS[0];
            bean.version = getRomVersion(VERSION_PROPERTY_ONEPLUS);
            return bean;
        } else if (isRightRom(brand, manufacturer, ROM_NUBIA)) {
            bean.name = ROM_NUBIA[0];
            bean.version = getRomVersion(VERSION_PROPERTY_NUBIA);
            return bean;
        } else {
            if (isRightRom(brand, manufacturer, ROM_COOLPAD)) {
                bean.name = ROM_COOLPAD[0];
            } else if (isRightRom(brand, manufacturer, ROM_LG)) {
                bean.name = ROM_LG[0];
            } else if (isRightRom(brand, manufacturer, ROM_GOOGLE)) {
                bean.name = ROM_GOOGLE[0];
            } else if (isRightRom(brand, manufacturer, ROM_SAMSUNG)) {
                bean.name = ROM_SAMSUNG[0];
            } else if (isRightRom(brand, manufacturer, ROM_MEIZU)) {
                bean.name = ROM_MEIZU[0];
            } else if (isRightRom(brand, manufacturer, ROM_LENOVO)) {
                bean.name = ROM_LENOVO[0];
            } else if (isRightRom(brand, manufacturer, ROM_SMARTISAN)) {
                bean.name = ROM_SMARTISAN[0];
            } else if (isRightRom(brand, manufacturer, ROM_HTC)) {
                bean.name = ROM_HTC[0];
            } else if (isRightRom(brand, manufacturer, ROM_SONY)) {
                bean.name = ROM_SONY[0];
            } else if (isRightRom(brand, manufacturer, ROM_GIONEE)) {
                bean.name = ROM_GIONEE[0];
            } else if (isRightRom(brand, manufacturer, ROM_MOTOROLA)) {
                bean.name = ROM_MOTOROLA[0];
            } else {
                bean.name = manufacturer;
            }
            bean.version = getRomVersion("");
            return bean;
        }
    }

    private static boolean isRightRom(String str, String str2, String... strArr) {
        for (String str3 : strArr) {
            if (str.contains(str3) || str2.contains(str3)) {
                return true;
            }
        }
        return false;
    }

    private static String getManufacturer() {
        try {
            String str = Build.MANUFACTURER;
            return !TextUtils.isEmpty(str) ? str.toLowerCase() : "unknown";
        } catch (Throwable unused) {
            return "unknown";
        }
    }

    private static String getBrand() {
        try {
            String str = Build.BRAND;
            return !TextUtils.isEmpty(str) ? str.toLowerCase() : "unknown";
        } catch (Throwable unused) {
            return "unknown";
        }
    }

    private static String getRomVersion(String str) {
        String systemProperty = !TextUtils.isEmpty(str) ? getSystemProperty(str) : "";
        if (TextUtils.isEmpty(systemProperty) || systemProperty.equals("unknown")) {
            try {
                String str2 = Build.DISPLAY;
                if (!TextUtils.isEmpty(str2)) {
                    systemProperty = str2.toLowerCase();
                }
            } catch (Throwable unused) {
            }
        }
        return TextUtils.isEmpty(systemProperty) ? "unknown" : systemProperty;
    }

    private static String getSystemProperty(String str) {
        String systemPropertyByShell = getSystemPropertyByShell(str);
        if (TextUtils.isEmpty(systemPropertyByShell)) {
            String systemPropertyByStream = getSystemPropertyByStream(str);
            return (TextUtils.isEmpty(systemPropertyByStream) && Build.VERSION.SDK_INT < 28) ? getSystemPropertyByReflect(str) : systemPropertyByStream;
        }
        return systemPropertyByShell;
    }

    private static String getSystemPropertyByShell(String str) {
        BufferedReader bufferedReader;
        String readLine;
        BufferedReader bufferedReader2 = null;
        try {
            try {
                Runtime runtime = Runtime.getRuntime();
                bufferedReader = new BufferedReader(new InputStreamReader(runtime.exec("getprop " + str).getInputStream()), 1024);
            } catch (IOException unused) {
                return "";
            }
        } catch (IOException unused2) {
        } catch (Throwable th) {
            th = th;
        }
        try {
            readLine = bufferedReader.readLine();
        } catch (IOException unused3) {
            bufferedReader2 = bufferedReader;
            if (bufferedReader2 != null) {
                bufferedReader2.close();
                return "";
            }
            return "";
        } catch (Throwable th2) {
            th = th2;
            bufferedReader2 = bufferedReader;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (IOException unused4) {
                }
            }
            throw th;
        }
        if (readLine != null) {
            try {
                bufferedReader.close();
            } catch (IOException unused5) {
            }
            return readLine;
        }
        bufferedReader.close();
        return "";
    }

    private static String getSystemPropertyByStream(String str) {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream(new File(Environment.getRootDirectory(), "build.prop")));
            return properties.getProperty(str, "");
        } catch (Exception unused) {
            return "";
        }
    }

    private static String getSystemPropertyByReflect(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, "");
        } catch (Exception unused) {
            return "";
        }
    }

    /* loaded from: classes.dex */
    public static class RomInfo {
        private String name;
        private String version;

        public String getName() {
            return this.name;
        }

        public String getVersion() {
            return this.version;
        }

        public String toString() {
            return "RomInfo{name=" + this.name + ", version=" + this.version + "}";
        }
    }
}
