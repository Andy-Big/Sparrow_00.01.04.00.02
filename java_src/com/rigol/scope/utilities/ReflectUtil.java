package com.rigol.scope.utilities;

import android.os.Build;
import android.util.Log;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/* loaded from: classes2.dex */
public class ReflectUtil {
    public static String getVariableNameByValue(Class cls, Object obj) {
        Field[] declaredFields;
        for (Field field : cls.getDeclaredFields()) {
            if (((~field.getModifiers()) & 24) == 0) {
                try {
                    if (field.get(cls).equals(obj)) {
                        return field.getName();
                    }
                    continue;
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public static void hookWebView() {
        Method declaredMethod;
        int i = Build.VERSION.SDK_INT;
        try {
            Class<?> cls = Class.forName("android.webkit.WebViewFactory");
            Field declaredField = cls.getDeclaredField("sProviderInstance");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(null);
            if (obj != null) {
                Log.i("", "sProviderInstance isn't null");
                return;
            }
            if (i > 22) {
                declaredMethod = cls.getDeclaredMethod("getProviderClass", new Class[0]);
            } else if (i == 22) {
                declaredMethod = cls.getDeclaredMethod("getFactoryClass", new Class[0]);
            } else {
                Log.i("", "Don't need to Hook WebView");
                return;
            }
            declaredMethod.setAccessible(true);
            Class cls2 = (Class) declaredMethod.invoke(cls, new Object[0]);
            Class<?> cls3 = Class.forName("android.webkit.WebViewDelegate");
            Constructor<?> declaredConstructor = cls3.getDeclaredConstructor(new Class[0]);
            declaredConstructor.setAccessible(true);
            if (i < 26) {
                Constructor constructor = cls2.getConstructor(cls3);
                if (constructor != null) {
                    constructor.setAccessible(true);
                    obj = constructor.newInstance(declaredConstructor.newInstance(new Object[0]));
                }
            } else {
                Field declaredField2 = cls.getDeclaredField("CHROMIUM_WEBVIEW_FACTORY_METHOD");
                declaredField2.setAccessible(true);
                String str = (String) declaredField2.get(null);
                if (str == null) {
                    str = "create";
                }
                Method method = cls2.getMethod(str, cls3);
                if (method != null) {
                    obj = method.invoke(null, declaredConstructor.newInstance(new Object[0]));
                }
            }
            if (obj != null) {
                declaredField.set("sProviderInstance", obj);
                Log.i("", "Hook success!");
                return;
            }
            Log.i("", "Hook failed!");
        } catch (Throwable th) {
            Log.w("", th.getMessage());
        }
    }

    public static String getProperty(String str, String str2) {
        try {
            try {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, str2);
            } catch (Exception e) {
                e.printStackTrace();
                return str2;
            }
        } catch (Throwable unused) {
            return str2;
        }
    }

    public static void setProperty(String str, String str2) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            cls.getMethod("set", String.class, String.class).invoke(cls, str, str2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
