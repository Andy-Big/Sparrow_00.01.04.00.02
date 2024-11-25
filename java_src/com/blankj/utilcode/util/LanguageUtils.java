package com.blankj.utilcode.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.blankj.utilcode.util.Utils;
import java.util.Locale;
/* loaded from: classes.dex */
public class LanguageUtils {
    private static final String KEY_LOCALE = "KEY_LOCALE";
    private static final String VALUE_FOLLOW_SYSTEM = "VALUE_FOLLOW_SYSTEM";

    private LanguageUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static void applySystemLanguage() {
        applySystemLanguage(false);
    }

    public static void applySystemLanguage(boolean z) {
        applyLanguageReal(null, z);
    }

    public static void applyLanguage(Locale locale) {
        if (locale == null) {
            throw new NullPointerException("Argument 'locale' of type Locale (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        applyLanguage(locale, false);
    }

    public static void applyLanguage(Locale locale, boolean z) {
        if (locale == null) {
            throw new NullPointerException("Argument 'locale' of type Locale (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        applyLanguageReal(locale, z);
    }

    private static void applyLanguageReal(Locale locale, final boolean z) {
        if (locale == null) {
            UtilsBridge.getSpUtils4Utils().put(KEY_LOCALE, VALUE_FOLLOW_SYSTEM, true);
        } else {
            UtilsBridge.getSpUtils4Utils().put(KEY_LOCALE, locale2String(locale), true);
        }
        if (locale == null) {
            locale = getLocal(Resources.getSystem().getConfiguration());
        }
        updateAppContextLanguage(locale, new Utils.Consumer<Boolean>() { // from class: com.blankj.utilcode.util.LanguageUtils.1
            @Override // com.blankj.utilcode.util.Utils.Consumer
            public void accept(Boolean bool) {
                if (bool.booleanValue()) {
                    LanguageUtils.restart(z);
                } else {
                    UtilsBridge.relaunchApp();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void restart(boolean z) {
        if (z) {
            UtilsBridge.relaunchApp();
            return;
        }
        for (Activity activity : UtilsBridge.getActivityList()) {
            activity.recreate();
        }
    }

    public static boolean isAppliedLanguage() {
        return getAppliedLanguage() != null;
    }

    public static boolean isAppliedLanguage(Locale locale) {
        if (locale == null) {
            throw new NullPointerException("Argument 'locale' of type Locale (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        Locale appliedLanguage = getAppliedLanguage();
        if (appliedLanguage == null) {
            return false;
        }
        return isSameLocale(locale, appliedLanguage);
    }

    public static Locale getAppliedLanguage() {
        String string = UtilsBridge.getSpUtils4Utils().getString(KEY_LOCALE);
        if (TextUtils.isEmpty(string) || VALUE_FOLLOW_SYSTEM.equals(string)) {
            return null;
        }
        return string2Locale(string);
    }

    public static Locale getContextLanguage(Context context) {
        return getLocal(context.getResources().getConfiguration());
    }

    public static Locale getAppContextLanguage() {
        return getContextLanguage(Utils.getApp());
    }

    public static Locale getSystemLanguage() {
        return getLocal(Resources.getSystem().getConfiguration());
    }

    public static void updateAppContextLanguage(Locale locale, Utils.Consumer<Boolean> consumer) {
        if (locale == null) {
            throw new NullPointerException("Argument 'destLocale' of type Locale (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        pollCheckAppContextLocal(locale, 0, consumer);
    }

    static void pollCheckAppContextLocal(final Locale locale, final int i, final Utils.Consumer<Boolean> consumer) {
        Resources resources = Utils.getApp().getResources();
        Configuration configuration = resources.getConfiguration();
        Locale local = getLocal(configuration);
        setLocal(configuration, locale);
        Utils.getApp().getResources().updateConfiguration(configuration, resources.getDisplayMetrics());
        if (consumer == null) {
            return;
        }
        if (isSameLocale(local, locale)) {
            consumer.accept(true);
        } else if (i < 20) {
            UtilsBridge.runOnUiThreadDelayed(new Runnable() { // from class: com.blankj.utilcode.util.LanguageUtils.2
                @Override // java.lang.Runnable
                public void run() {
                    LanguageUtils.pollCheckAppContextLocal(locale, i + 1, consumer);
                }
            }, 16L);
        } else {
            Log.e("LanguageUtils", "appLocal didn't update.");
            consumer.accept(false);
        }
    }

    public static Context attachBaseContext(Context context) {
        Locale string2Locale;
        String string = UtilsBridge.getSpUtils4Utils().getString(KEY_LOCALE);
        if (TextUtils.isEmpty(string) || VALUE_FOLLOW_SYSTEM.equals(string) || (string2Locale = string2Locale(string)) == null) {
            return context;
        }
        Resources resources = context.getResources();
        Configuration configuration = resources.getConfiguration();
        setLocal(configuration, string2Locale);
        if (Build.VERSION.SDK_INT >= 17) {
            return context.createConfigurationContext(configuration);
        }
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
        return context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void applyLanguage(Activity activity) {
        Locale string2Locale;
        String string = UtilsBridge.getSpUtils4Utils().getString(KEY_LOCALE);
        if (TextUtils.isEmpty(string)) {
            return;
        }
        if (VALUE_FOLLOW_SYSTEM.equals(string)) {
            string2Locale = getLocal(Resources.getSystem().getConfiguration());
        } else {
            string2Locale = string2Locale(string);
        }
        if (string2Locale == null) {
            return;
        }
        updateConfiguration(activity, string2Locale);
        updateConfiguration(Utils.getApp(), string2Locale);
    }

    private static void updateConfiguration(Context context, Locale locale) {
        Resources resources = context.getResources();
        Configuration configuration = resources.getConfiguration();
        setLocal(configuration, locale);
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
    }

    private static String locale2String(Locale locale) {
        String language = locale.getLanguage();
        String country = locale.getCountry();
        return language + "$" + country;
    }

    private static Locale string2Locale(String str) {
        Locale string2LocaleReal = string2LocaleReal(str);
        if (string2LocaleReal == null) {
            Log.e("LanguageUtils", "The string of " + str + " is not in the correct format.");
            UtilsBridge.getSpUtils4Utils().remove(KEY_LOCALE);
        }
        return string2LocaleReal;
    }

    private static Locale string2LocaleReal(String str) {
        if (isRightFormatLocalStr(str)) {
            try {
                int indexOf = str.indexOf("$");
                return new Locale(str.substring(0, indexOf), str.substring(indexOf + 1));
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }

    private static boolean isRightFormatLocalStr(String str) {
        int i = 0;
        for (char c : str.toCharArray()) {
            if (c == '$') {
                if (i >= 1) {
                    return false;
                }
                i++;
            }
        }
        return i == 1;
    }

    private static boolean isSameLocale(Locale locale, Locale locale2) {
        return UtilsBridge.equals(locale2.getLanguage(), locale.getLanguage()) && UtilsBridge.equals(locale2.getCountry(), locale.getCountry());
    }

    private static Locale getLocal(Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 24) {
            return configuration.getLocales().get(0);
        }
        return configuration.locale;
    }

    private static void setLocal(Configuration configuration, Locale locale) {
        if (Build.VERSION.SDK_INT >= 17) {
            configuration.setLocale(locale);
        } else {
            configuration.locale = locale;
        }
    }
}
