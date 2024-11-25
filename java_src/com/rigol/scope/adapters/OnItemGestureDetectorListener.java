package com.rigol.scope.adapters;

import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes.dex */
public class OnItemGestureDetectorListener {
    public boolean onContextClick(MotionEvent motionEvent, View view, RecyclerView.ViewHolder viewHolder, int i) {
        return false;
    }

    public boolean onDoubleTap(MotionEvent motionEvent, View view, RecyclerView.ViewHolder viewHolder, int i) {
        return false;
    }

    public boolean onDoubleTapEvent(MotionEvent motionEvent, View view, RecyclerView.ViewHolder viewHolder, int i) {
        return false;
    }

    public boolean onDown(MotionEvent motionEvent, View view, RecyclerView.ViewHolder viewHolder, int i) {
        return false;
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2, View view, RecyclerView.ViewHolder viewHolder, int i) {
        return false;
    }

    public void onLongPress(MotionEvent motionEvent, View view, RecyclerView.ViewHolder viewHolder, int i) {
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2, View view, RecyclerView.ViewHolder viewHolder, int i) {
        return false;
    }

    public void onShowPress(MotionEvent motionEvent, View view, RecyclerView.ViewHolder viewHolder, int i) {
    }

    public boolean onSingleTapConfirmed(MotionEvent motionEvent, View view, RecyclerView.ViewHolder viewHolder, int i) {
        return false;
    }

    public boolean onSingleTapUp(MotionEvent motionEvent, View view, RecyclerView.ViewHolder viewHolder, int i) {
        return false;
    }
}
