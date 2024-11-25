package com.scwang.smartrefresh.layout.util;

import android.content.res.Resources;
/* loaded from: classes2.dex */
public class DensityUtil {
    public float density = Resources.getSystem().getDisplayMetrics().density;

    public static int dp2px(float f) {
        return (int) ((f * Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }

    public static float px2dp(int i) {
        return i / Resources.getSystem().getDisplayMetrics().density;
    }

    public int dip2px(float f) {
        return (int) ((f * this.density) + 0.5f);
    }

    public float px2dip(int i) {
        return i / this.density;
    }
}
