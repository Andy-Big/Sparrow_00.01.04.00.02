package com.rigol.scope.utilities;

import android.app.Activity;
import android.app.backup.BackupManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.LocaleList;
import android.util.DisplayMetrics;
import com.blankj.utilcode.util.ActivityUtils;
import com.rigol.scope.cil.API;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import java.util.Locale;
import timber.log.Timber;
/* loaded from: classes2.dex */
public class LanguageUtil {
    public static boolean isFirstStart = false;

    public static String getSystemLanguage() {
        return Locale.getDefault().getLanguage();
    }

    public static ServiceEnum.SystemLanguage getAppLanguage() {
        return ServiceEnum.getSystemLanguageFromValue1(API.getInstance().UI_QueryInt32(11, MessageID.MSG_APP_UTILITY_LANGUAGE));
    }

    public static String getCountry() {
        return Locale.getDefault().getCountry();
    }

    public static void changeLanguage(Activity activity, Locale locale) {
        Resources resources = activity.getResources();
        Configuration configuration = resources.getConfiguration();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        configuration.setLocale(locale);
        activity.createConfigurationContext(configuration);
        resources.updateConfiguration(configuration, displayMetrics);
        activity.onConfigurationChanged(configuration);
    }

    public static void changeSystemLanguage(Locale locale) {
        LocaleList localeList = new LocaleList(locale);
        if (locale != null) {
            try {
                Class<?> cls = Class.forName("android.app.ActivityManagerNative");
                Object invoke = cls.getDeclaredMethod("getDefault", new Class[0]).invoke(cls, new Object[0]);
                Class<?> cls2 = Class.forName("android.app.IActivityManager");
                Configuration configuration = (Configuration) cls2.getDeclaredMethod("getConfiguration", new Class[0]).invoke(invoke, new Object[0]);
                configuration.setLocales(localeList);
                if (isFirstStart) {
                    configuration.setToDefaults();
                } else {
                    isFirstStart = true;
                }
                cls2.getDeclaredMethod("updatePersistentConfiguration", Configuration.class).invoke(invoke, configuration);
                BackupManager.dataChanged("com.android.providers.settings");
            } catch (Exception e) {
                Timber.e(e);
            }
        }
    }

    /* renamed from: com.rigol.scope.utilities.LanguageUtil$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$rigol$scope$cil$ServiceEnum$SystemLanguage;

        static {
            int[] iArr = new int[ServiceEnum.SystemLanguage.values().length];
            $SwitchMap$com$rigol$scope$cil$ServiceEnum$SystemLanguage = iArr;
            try {
                iArr[ServiceEnum.SystemLanguage.language_chinese.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$SystemLanguage[ServiceEnum.SystemLanguage.language_traditional_chinese.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$SystemLanguage[ServiceEnum.SystemLanguage.language_portugal.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$SystemLanguage[ServiceEnum.SystemLanguage.language_german.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$SystemLanguage[ServiceEnum.SystemLanguage.language_borland.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$SystemLanguage[ServiceEnum.SystemLanguage.language_korean.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$SystemLanguage[ServiceEnum.SystemLanguage.language_japan.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$SystemLanguage[ServiceEnum.SystemLanguage.language_french.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$SystemLanguage[ServiceEnum.SystemLanguage.language_russia.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$SystemLanguage[ServiceEnum.SystemLanguage.language_spanish.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$SystemLanguage[ServiceEnum.SystemLanguage.language_thailand.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$SystemLanguage[ServiceEnum.SystemLanguage.language_indonesia.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$SystemLanguage[ServiceEnum.SystemLanguage.language_english.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    public static void setLanguage(int i) {
        Locale locale;
        switch (AnonymousClass1.$SwitchMap$com$rigol$scope$cil$ServiceEnum$SystemLanguage[ServiceEnum.getSystemLanguageFromValue1(i).ordinal()]) {
            case 1:
                locale = new Locale("zh", "CN");
                break;
            case 2:
                locale = new Locale("zh", "HK");
                break;
            case 3:
                locale = new Locale("pt", "PT");
                break;
            case 4:
                locale = new Locale("de", "DE");
                break;
            case 5:
                locale = new Locale("pl", "PL");
                break;
            case 6:
                locale = new Locale("ko", "KR");
                break;
            case 7:
                locale = new Locale("ja", "JP");
                break;
            case 8:
                locale = new Locale("fr", "FR");
                break;
            case 9:
                locale = new Locale("ru", "RU");
                break;
            case 10:
                locale = new Locale("es", "ES");
                break;
            case 11:
                locale = new Locale("th", "TH");
                break;
            case 12:
                locale = new Locale("id", "ID");
                break;
            default:
                locale = new Locale("en", "US");
                break;
        }
        changeLanguage(ActivityUtils.getTopActivity(), locale);
        if (SystemUtil.isSystemApp(ActivityUtils.getTopActivity())) {
            changeSystemLanguage(locale);
        }
    }
}
