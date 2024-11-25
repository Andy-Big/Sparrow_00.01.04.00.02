package com.blankj.utilcode.util;

import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.Locale;
/* loaded from: classes.dex */
public class ViewUtils {
    public static void setViewEnabled(View view, boolean z) {
        setViewEnabled(view, z, null);
    }

    public static void setViewEnabled(View view, boolean z, View... viewArr) {
        if (view == null) {
            return;
        }
        if (viewArr != null) {
            for (View view2 : viewArr) {
                if (view == view2) {
                    return;
                }
            }
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                setViewEnabled(viewGroup.getChildAt(i), z, viewArr);
            }
        }
        view.setEnabled(z);
    }

    public static void runOnUiThread(Runnable runnable) {
        UtilsBridge.runOnUiThread(runnable);
    }

    public static void runOnUiThreadDelayed(Runnable runnable, long j) {
        UtilsBridge.runOnUiThreadDelayed(runnable, j);
    }

    public static boolean isLayoutRtl() {
        Locale locale;
        if (Build.VERSION.SDK_INT >= 17) {
            if (Build.VERSION.SDK_INT >= 24) {
                locale = Utils.getApp().getResources().getConfiguration().getLocales().get(0);
            } else {
                locale = Utils.getApp().getResources().getConfiguration().locale;
            }
            return TextUtils.getLayoutDirectionFromLocale(locale) == 1;
        }
        return false;
    }

    public static void fixScrollViewTopping(View view) {
        view.setFocusable(false);
        ViewGroup viewGroup = view instanceof ViewGroup ? (ViewGroup) view : null;
        if (viewGroup == null) {
            return;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            childAt.setFocusable(false);
            if (childAt instanceof ViewGroup) {
                fixScrollViewTopping(childAt);
            }
        }
    }

    public static View layoutId2View(int i) {
        return ((LayoutInflater) Utils.getApp().getSystemService("layout_inflater")).inflate(i, (ViewGroup) null);
    }
}
