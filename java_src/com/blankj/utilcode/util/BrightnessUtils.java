package com.blankj.utilcode.util;

import android.content.ContentResolver;
import android.provider.Settings;
import android.view.Window;
import android.view.WindowManager;
/* loaded from: classes.dex */
public final class BrightnessUtils {
    private BrightnessUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static boolean isAutoBrightnessEnabled() {
        try {
            return Settings.System.getInt(Utils.getApp().getContentResolver(), "screen_brightness_mode") == 1;
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean setAutoBrightnessEnabled(boolean z) {
        return Settings.System.putInt(Utils.getApp().getContentResolver(), "screen_brightness_mode", z ? 1 : 0);
    }

    public static int getBrightness() {
        try {
            return Settings.System.getInt(Utils.getApp().getContentResolver(), "screen_brightness");
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static boolean setBrightness(int i) {
        ContentResolver contentResolver = Utils.getApp().getContentResolver();
        boolean putInt = Settings.System.putInt(contentResolver, "screen_brightness", i);
        contentResolver.notifyChange(Settings.System.getUriFor("screen_brightness"), null);
        return putInt;
    }

    public static void setWindowBrightness(Window window, int i) {
        if (window == null) {
            throw new NullPointerException("Argument 'window' of type Window (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.screenBrightness = i / 255.0f;
        window.setAttributes(attributes);
    }

    public static int getWindowBrightness(Window window) {
        float f = window.getAttributes().screenBrightness;
        return f < 0.0f ? getBrightness() : (int) (f * 255.0f);
    }
}
