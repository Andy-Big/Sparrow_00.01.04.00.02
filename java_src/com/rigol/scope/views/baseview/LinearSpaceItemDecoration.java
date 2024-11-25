package com.rigol.scope.views.baseview;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes2.dex */
public class LinearSpaceItemDecoration extends RecyclerView.ItemDecoration {
    private final int spacing;

    public LinearSpaceItemDecoration(int i) {
        this.spacing = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        if (linearLayoutManager == null) {
            super.getItemOffsets(rect, view, recyclerView, state);
        } else if (linearLayoutManager.getOrientation() == 1) {
            if (recyclerView.getChildAdapterPosition(view) == linearLayoutManager.getItemCount() - 1) {
                rect.bottom = this.spacing;
            }
            rect.top = this.spacing;
            rect.left = this.spacing;
            rect.right = this.spacing;
        } else {
            if (recyclerView.getChildAdapterPosition(view) == linearLayoutManager.getItemCount() - 1) {
                rect.right = this.spacing;
            }
            rect.top = this.spacing;
            rect.left = this.spacing;
            rect.bottom = this.spacing;
        }
    }
}
