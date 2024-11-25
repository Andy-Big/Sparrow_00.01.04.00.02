package com.rigol.scope.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes2.dex */
public class DisableTouchEventRecyclerView extends RecyclerView {
    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public DisableTouchEventRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DisableTouchEventRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
