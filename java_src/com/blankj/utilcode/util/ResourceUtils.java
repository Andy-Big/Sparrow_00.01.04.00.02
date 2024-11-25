package com.blankj.utilcode.util;

import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public final class ResourceUtils {
    private static final int BUFFER_SIZE = 8192;

    private ResourceUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static Drawable getDrawable(int i) {
        return ContextCompat.getDrawable(Utils.getApp(), i);
    }

    public static int getIdByName(String str) {
        return Utils.getApp().getResources().getIdentifier(str, "id", Utils.getApp().getPackageName());
    }

    public static int getStringIdByName(String str) {
        return Utils.getApp().getResources().getIdentifier(str, "string", Utils.getApp().getPackageName());
    }

    public static int getColorIdByName(String str) {
        return Utils.getApp().getResources().getIdentifier(str, "color", Utils.getApp().getPackageName());
    }

    public static int getDimenIdByName(String str) {
        return Utils.getApp().getResources().getIdentifier(str, "dimen", Utils.getApp().getPackageName());
    }

    public static int getDrawableIdByName(String str) {
        return Utils.getApp().getResources().getIdentifier(str, "drawable", Utils.getApp().getPackageName());
    }

    public static int getMipmapIdByName(String str) {
        return Utils.getApp().getResources().getIdentifier(str, "mipmap", Utils.getApp().getPackageName());
    }

    public static int getLayoutIdByName(String str) {
        return Utils.getApp().getResources().getIdentifier(str, "layout", Utils.getApp().getPackageName());
    }

    public static int getStyleIdByName(String str) {
        return Utils.getApp().getResources().getIdentifier(str, "style", Utils.getApp().getPackageName());
    }

    public static int getAnimIdByName(String str) {
        return Utils.getApp().getResources().getIdentifier(str, "anim", Utils.getApp().getPackageName());
    }

    public static int getMenuIdByName(String str) {
        return Utils.getApp().getResources().getIdentifier(str, "menu", Utils.getApp().getPackageName());
    }

    public static boolean copyFileFromAssets(String str, String str2) {
        try {
            String[] list = Utils.getApp().getAssets().list(str);
            if (list != null && list.length > 0) {
                boolean z = true;
                for (String str3 : list) {
                    z &= copyFileFromAssets(str + "/" + str3, str2 + "/" + str3);
                }
                return z;
            }
            return UtilsBridge.writeFileFromIS(str2, Utils.getApp().getAssets().open(str));
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String readAssets2String(String str) {
        return readAssets2String(str, null);
    }

    public static String readAssets2String(String str, String str2) {
        try {
            byte[] inputStream2Bytes = UtilsBridge.inputStream2Bytes(Utils.getApp().getAssets().open(str));
            if (inputStream2Bytes == null) {
                return "";
            }
            if (UtilsBridge.isSpace(str2)) {
                return new String(inputStream2Bytes);
            }
            try {
                return new String(inputStream2Bytes, str2);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                return "";
            }
        } catch (IOException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static List<String> readAssets2List(String str) {
        return readAssets2List(str, "");
    }

    public static List<String> readAssets2List(String str, String str2) {
        try {
            return UtilsBridge.inputStream2Lines(Utils.getApp().getResources().getAssets().open(str), str2);
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public static boolean copyFileFromRaw(int i, String str) {
        return UtilsBridge.writeFileFromIS(str, Utils.getApp().getResources().openRawResource(i));
    }

    public static String readRaw2String(int i) {
        return readRaw2String(i, null);
    }

    public static String readRaw2String(int i, String str) {
        byte[] inputStream2Bytes = UtilsBridge.inputStream2Bytes(Utils.getApp().getResources().openRawResource(i));
        if (inputStream2Bytes == null) {
            return null;
        }
        if (UtilsBridge.isSpace(str)) {
            return new String(inputStream2Bytes);
        }
        try {
            return new String(inputStream2Bytes, str);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static List<String> readRaw2List(int i) {
        return readRaw2List(i, "");
    }

    public static List<String> readRaw2List(int i, String str) {
        return UtilsBridge.inputStream2Lines(Utils.getApp().getResources().openRawResource(i), str);
    }
}
