package com.rigol.pinyinkeyboard;

import android.app.Activity;
import android.os.Build;
import android.widget.EditText;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class TypeWritingUtils {
    public static final int CHINESE_INPUT_NO_START = 1000000;

    /* loaded from: classes.dex */
    public enum TKeyBoardTypeEnum {
        ENGLISH,
        SIMPLIFY_CHINESE,
        CHINESE,
        NUMBER
    }

    /* loaded from: classes.dex */
    public enum TKeyboardInputModeEnum {
        GRAPH,
        NUMBER
    }

    public static void hideSystemSoftware(Activity activity, EditText editText) {
        if (editText != null) {
            activity.getWindow().setSoftInputMode(3);
            int i = Build.VERSION.SDK_INT;
            String str = null;
            if (i >= 16) {
                str = "setShowSoftInputOnFocus";
            } else if (i >= 14) {
                str = "setSoftInputShownOnFocus";
            }
            if (str == null) {
                editText.setInputType(0);
                return;
            }
            try {
                Method method = EditText.class.getMethod(str, Boolean.TYPE);
                method.setAccessible(true);
                method.invoke(editText, false);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException e2) {
                e2.printStackTrace();
            } catch (NoSuchMethodException e3) {
                editText.setInputType(0);
                e3.printStackTrace();
            } catch (InvocationTargetException e4) {
                e4.printStackTrace();
            }
        }
    }
}
