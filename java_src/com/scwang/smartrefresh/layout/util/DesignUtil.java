package com.scwang.smartrefresh.layout.util;

import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.scwang.smartrefresh.layout.api.RefreshKernel;
import com.scwang.smartrefresh.layout.listener.CoordinatorLayoutListener;
/* loaded from: classes2.dex */
public class DesignUtil {
    public static void checkCoordinatorLayout(View view, RefreshKernel refreshKernel, CoordinatorLayoutListener coordinatorLayoutListener) {
        try {
            if (view instanceof CoordinatorLayout) {
                refreshKernel.getRefreshLayout().setEnableNestedScroll(false);
                wrapperCoordinatorLayout((ViewGroup) view, coordinatorLayoutListener);
            }
        } catch (Throwable unused) {
        }
    }

    private static void wrapperCoordinatorLayout(ViewGroup viewGroup, final CoordinatorLayoutListener coordinatorLayoutListener) {
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount);
            if (childAt instanceof AppBarLayout) {
                ((AppBarLayout) childAt).addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() { // from class: com.scwang.smartrefresh.layout.util.DesignUtil.1
                    @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
                    public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                        CoordinatorLayoutListener.this.onCoordinatorUpdate(i >= 0, appBarLayout.getTotalScrollRange() + i <= 0);
                    }
                });
            }
        }
    }
}
