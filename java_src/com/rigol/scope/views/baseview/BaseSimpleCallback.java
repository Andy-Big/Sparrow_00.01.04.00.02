package com.rigol.scope.views.baseview;

import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes2.dex */
public class BaseSimpleCallback extends ItemTouchHelper.SimpleCallback {
    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
        return false;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int i) {
    }

    public BaseSimpleCallback(int i, int i2) {
        super(i, i2);
    }
}
