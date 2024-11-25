package com.blankj.utilcode.util;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public final class SizeUtils {

    /* loaded from: classes.dex */
    public interface OnGetSizeListener {
        void onGetSize(View view);
    }

    private SizeUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static int dp2px(float f) {
        return (int) ((f * Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }

    public static int px2dp(float f) {
        return (int) ((f / Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }

    public static int sp2px(float f) {
        return (int) ((f * Resources.getSystem().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public static int px2sp(float f) {
        return (int) ((f / Resources.getSystem().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public static float applyDimension(float f, int i) {
        float f2;
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        if (i != 0) {
            if (i == 1) {
                f2 = displayMetrics.density;
            } else if (i == 2) {
                f2 = displayMetrics.scaledDensity;
            } else if (i == 3) {
                f *= displayMetrics.xdpi;
                f2 = 0.013888889f;
            } else if (i == 4) {
                f2 = displayMetrics.xdpi;
            } else if (i != 5) {
                return 0.0f;
            } else {
                f *= displayMetrics.xdpi;
                f2 = 0.03937008f;
            }
            return f * f2;
        }
        return f;
    }

    public static void forceGetViewSize(final View view, final OnGetSizeListener onGetSizeListener) {
        view.post(new Runnable() { // from class: com.blankj.utilcode.util.SizeUtils.1
            @Override // java.lang.Runnable
            public void run() {
                OnGetSizeListener onGetSizeListener2 = OnGetSizeListener.this;
                if (onGetSizeListener2 != null) {
                    onGetSizeListener2.onGetSize(view);
                }
            }
        });
    }

    public static int getMeasuredWidth(View view) {
        return measureView(view)[0];
    }

    public static int getMeasuredHeight(View view) {
        return measureView(view)[1];
    }

    public static int[] measureView(View view) {
        int makeMeasureSpec;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -2);
        }
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(0, 0, layoutParams.width);
        int i = layoutParams.height;
        if (i > 0) {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i, 1073741824);
        } else {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        view.measure(childMeasureSpec, makeMeasureSpec);
        return new int[]{view.getMeasuredWidth(), view.getMeasuredHeight()};
    }
}
