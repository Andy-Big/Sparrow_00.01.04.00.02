package com.rigol.scope.views;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: TableItemDecoration.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J(\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J \u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001e"}, d2 = {"Lcom/rigol/scope/views/TableItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "()V", "footerHeight", "", "getFooterHeight", "()I", "setFooterHeight", "(I)V", "footerPaint", "Landroid/graphics/Paint;", "footerText", "", "getFooterText", "()Ljava/lang/String;", "setFooterText", "(Ljava/lang/String;)V", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "onDraw", "c", "Landroid/graphics/Canvas;", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class TableItemDecoration extends RecyclerView.ItemDecoration {
    private int footerHeight;
    private final Paint footerPaint;
    private String footerText;

    public TableItemDecoration() {
        Paint paint = new Paint(1);
        paint.setTextSize(20.0f);
        paint.setColor(ViewCompat.MEASURED_STATE_MASK);
        Unit unit = Unit.INSTANCE;
        this.footerPaint = paint;
    }

    public final String getFooterText() {
        return this.footerText;
    }

    public final void setFooterText(String str) {
        this.footerText = str;
    }

    public final int getFooterHeight() {
        return this.footerHeight;
    }

    public final void setFooterHeight(int i) {
        this.footerHeight = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        RecyclerView.Adapter it;
        Intrinsics.checkNotNullParameter(outRect, "outRect");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        super.getItemOffsets(outRect, view, parent, state);
        int childAdapterPosition = parent.getChildAdapterPosition(view);
        if (this.footerText == null || (it = parent.getAdapter()) == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(it, "it");
        if (childAdapterPosition == it.getItemCount() - 1) {
            outRect.set(0, 0, 0, this.footerHeight);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        RecyclerView.Adapter adapter;
        View childAt;
        Intrinsics.checkNotNullParameter(c, "c");
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        super.onDraw(c, parent, state);
        String str = this.footerText;
        if (str == null || (adapter = parent.getAdapter()) == null || (childAt = parent.getChildAt(parent.getChildCount() - 1)) == null) {
            return;
        }
        int childAdapterPosition = parent.getChildAdapterPosition(childAt);
        Intrinsics.checkNotNullExpressionValue(adapter, "adapter");
        if (childAdapterPosition == adapter.getItemCount() - 1) {
            float f = 2;
            c.drawText(str, (parent.getWidth() / 2) - (this.footerPaint.measureText(str) / f), childAt.getBottom() + (this.footerHeight / 2) + ((this.footerPaint.ascent() + this.footerPaint.descent()) / f), this.footerPaint);
        }
    }
}
