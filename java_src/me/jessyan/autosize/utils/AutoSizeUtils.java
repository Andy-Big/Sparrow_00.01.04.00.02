package me.jessyan.autosize.utils;

import android.app.Application;
import android.content.Context;
import android.util.TypedValue;
import java.lang.reflect.InvocationTargetException;
/* loaded from: classes2.dex */
public class AutoSizeUtils {
    private AutoSizeUtils() {
        throw new IllegalStateException("you can't instantiate me!");
    }

    public static int dp2px(Context context, float f) {
        return (int) (TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics()) + 0.5f);
    }

    public static int sp2px(Context context, float f) {
        return (int) (TypedValue.applyDimension(2, f, context.getResources().getDisplayMetrics()) + 0.5f);
    }

    public static int pt2px(Context context, float f) {
        return (int) (TypedValue.applyDimension(3, f, context.getResources().getDisplayMetrics()) + 0.5f);
    }

    public static int in2px(Context context, float f) {
        return (int) (TypedValue.applyDimension(4, f, context.getResources().getDisplayMetrics()) + 0.5f);
    }

    public static int mm2px(Context context, float f) {
        return (int) (TypedValue.applyDimension(5, f, context.getResources().getDisplayMetrics()) + 0.5f);
    }

    public static Application getApplicationByReflect() {
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Object invoke = cls.getMethod("getApplication", new Class[0]).invoke(cls.getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]), new Object[0]);
            if (invoke == null) {
                throw new NullPointerException("you should init first");
            }
            return (Application) invoke;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new NullPointerException("you should init first");
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            throw new NullPointerException("you should init first");
        } catch (NoSuchMethodException e3) {
            e3.printStackTrace();
            throw new NullPointerException("you should init first");
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
            throw new NullPointerException("you should init first");
        }
    }
}
