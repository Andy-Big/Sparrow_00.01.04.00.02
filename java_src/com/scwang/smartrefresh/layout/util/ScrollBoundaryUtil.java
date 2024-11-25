package com.scwang.smartrefresh.layout.util;

import android.graphics.PointF;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
/* loaded from: classes2.dex */
public class ScrollBoundaryUtil {
    public static boolean canRefresh(View view, PointF pointF) {
        if (canScrollUp(view) && view.getVisibility() == 0) {
            return false;
        }
        if (!(view instanceof ViewGroup) || pointF == null) {
            return true;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        PointF pointF2 = new PointF();
        for (int childCount = viewGroup.getChildCount(); childCount > 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount - 1);
            if (isTransformedTouchPointInView(viewGroup, childAt, pointF.x, pointF.y, pointF2)) {
                if ("fixed".equals(childAt.getTag())) {
                    return false;
                }
                pointF.offset(pointF2.x, pointF2.y);
                boolean canRefresh = canRefresh(childAt, pointF);
                pointF.offset(-pointF2.x, -pointF2.y);
                return canRefresh;
            }
        }
        return true;
    }

    public static boolean canLoadMore(View view, PointF pointF, boolean z) {
        if (canScrollDown(view) && view.getVisibility() == 0) {
            return false;
        }
        if ((view instanceof ViewGroup) && pointF != null && !SmartUtil.isScrollableView(view)) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            PointF pointF2 = new PointF();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (isTransformedTouchPointInView(viewGroup, childAt, pointF.x, pointF.y, pointF2)) {
                    if ("fixed".equals(childAt.getTag())) {
                        return false;
                    }
                    pointF.offset(pointF2.x, pointF2.y);
                    boolean canLoadMore = canLoadMore(childAt, pointF, z);
                    pointF.offset(-pointF2.x, -pointF2.y);
                    return canLoadMore;
                }
            }
        }
        return z || canScrollUp(view);
    }

    public static boolean canScrollUp(View view) {
        if (Build.VERSION.SDK_INT < 14) {
            if (!(view instanceof AbsListView)) {
                return view.getScrollY() > 0;
            }
            ViewGroup viewGroup = (ViewGroup) view;
            return viewGroup.getChildCount() > 0 && (((AbsListView) view).getFirstVisiblePosition() > 0 || viewGroup.getChildAt(0).getTop() < view.getPaddingTop());
        }
        return view.canScrollVertically(-1);
    }

    public static boolean canScrollDown(View view) {
        int i;
        if (Build.VERSION.SDK_INT < 14) {
            if (!(view instanceof AbsListView)) {
                return view.getScrollY() < 0;
            }
            ViewGroup viewGroup = (ViewGroup) view;
            AbsListView absListView = (AbsListView) view;
            int childCount = viewGroup.getChildCount();
            return childCount > 0 && (absListView.getLastVisiblePosition() < (i = childCount - 1) || viewGroup.getChildAt(i).getBottom() > view.getPaddingBottom());
        }
        return view.canScrollVertically(1);
    }

    public static boolean isTransformedTouchPointInView(View view, View view2, float f, float f2, PointF pointF) {
        if (view2.getVisibility() != 0) {
            return false;
        }
        float[] fArr = {f, f2};
        fArr[0] = fArr[0] + (view.getScrollX() - view2.getLeft());
        fArr[1] = fArr[1] + (view.getScrollY() - view2.getTop());
        boolean z = fArr[0] >= 0.0f && fArr[1] >= 0.0f && fArr[0] < ((float) view2.getWidth()) && fArr[1] < ((float) view2.getHeight());
        if (z && pointF != null) {
            pointF.set(fArr[0] - f, fArr[1] - f2);
        }
        return z;
    }
}
