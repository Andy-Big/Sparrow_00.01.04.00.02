package com.rigol.scope.views.grid;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes2.dex */
public class GridSpaceItemDecoration extends RecyclerView.ItemDecoration {
    protected final boolean includeEdge;
    protected final int spacing;

    public GridSpaceItemDecoration(int i, boolean z) {
        this.spacing = i;
        this.includeEdge = z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        int spanCount = layoutManager instanceof GridLayoutManager ? ((GridLayoutManager) layoutManager).getSpanCount() : 0;
        if (spanCount == 0) {
            super.getItemOffsets(rect, view, recyclerView, state);
            return;
        }
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        int i = childAdapterPosition % spanCount;
        GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
        int i2 = gridLayoutManager.getOrientation() == 0 ? childAdapterPosition / spanCount : i;
        int i3 = childAdapterPosition / spanCount;
        if (gridLayoutManager.getOrientation() != 0) {
            i = i3;
        }
        if (this.includeEdge) {
            int i4 = this.spacing;
            rect.left = i4 - ((i2 * i4) / spanCount);
            rect.right = ((i2 + 1) * this.spacing) / spanCount;
            rect.bottom = this.spacing;
            int i5 = this.spacing;
            rect.top = i5 - ((i * i5) / spanCount);
            rect.bottom = ((i + 1) * this.spacing) / spanCount;
        } else {
            rect.left = (this.spacing * i2) / spanCount;
            int i6 = this.spacing;
            rect.right = i6 - (((i2 + 1) * i6) / spanCount);
            rect.top = (this.spacing * i) / spanCount;
            int i7 = this.spacing;
            rect.bottom = i7 - (((i + 1) * i7) / spanCount);
        }
        Log.d("KEY_RECYCLERVIEW", "position:" + childAdapterPosition + ", column:" + i2 + ", outRect.left:" + rect.left + ", outRect.right:" + rect.right + ", outRect.top:" + rect.top + ", outRect.bottom:" + rect.bottom);
    }
}
