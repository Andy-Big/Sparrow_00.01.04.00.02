package com.rigol.scope.views.window;

import android.graphics.Canvas;
import android.graphics.Point;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: WindowDragShadowBuilder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\"\u0012\u000b\u0010\u0002\u001a\u00070\u0003¢\u0006\u0002\b\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u001c\u0010\u0010\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/rigol/scope/views/window/WindowDragShadowBuilder;", "Landroid/view/View$DragShadowBuilder;", "v", "Landroid/view/View;", "Lorg/jetbrains/annotations/NotNull;", "x", "", "y", "(Landroid/view/View;FF)V", "getX", "()F", "getY", "onDrawShadow", "", "canvas", "Landroid/graphics/Canvas;", "onProvideShadowMetrics", "outShadowSize", "Landroid/graphics/Point;", "outShadowTouchPoint", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class WindowDragShadowBuilder extends View.DragShadowBuilder {
    private final float x;
    private final float y;

    public final float getX() {
        return this.x;
    }

    public final float getY() {
        return this.y;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WindowDragShadowBuilder(View v, float f, float f2) {
        super(v);
        Intrinsics.checkNotNullParameter(v, "v");
        this.x = f;
        this.y = f2;
    }

    @Override // android.view.View.DragShadowBuilder
    public void onProvideShadowMetrics(Point point, Point point2) {
        super.onProvideShadowMetrics(point, point2);
        if (getView() != null && point != null) {
            View view = getView();
            Intrinsics.checkNotNullExpressionValue(view, "view");
            View view2 = getView();
            Intrinsics.checkNotNullExpressionValue(view2, "view");
            point.set((int) (view.getWidth() * 0.5f), (int) (view2.getHeight() * 0.5f));
        }
        if (point2 != null) {
            point2.set((int) (((int) this.x) * 0.5f), (int) (((int) this.y) * 0.5f));
        }
    }

    @Override // android.view.View.DragShadowBuilder
    public void onDrawShadow(Canvas canvas) {
        if (canvas != null) {
            canvas.save();
        }
        if (canvas != null) {
            canvas.scale(0.5f, 0.5f);
        }
        super.onDrawShadow(canvas);
        if (canvas != null) {
            canvas.restore();
        }
    }
}
