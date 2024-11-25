package com.rigol.scope.views.la;

import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: MyDragShadowBuilder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/rigol/scope/views/la/MyDragShadowBuilder;", "Landroid/view/View$DragShadowBuilder;", "v", "Landroid/view/View;", "(Landroid/view/View;)V", "shadow", "Landroid/graphics/drawable/ColorDrawable;", "onDrawShadow", "", "canvas", "Landroid/graphics/Canvas;", "onProvideShadowMetrics", "size", "Landroid/graphics/Point;", "touch", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
final class MyDragShadowBuilder extends View.DragShadowBuilder {
    private final ColorDrawable shadow;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MyDragShadowBuilder(View v) {
        super(v);
        Intrinsics.checkNotNullParameter(v, "v");
        this.shadow = new ColorDrawable(-3355444);
    }

    @Override // android.view.View.DragShadowBuilder
    public void onProvideShadowMetrics(Point size, Point touch) {
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(touch, "touch");
        View view = getView();
        Intrinsics.checkNotNullExpressionValue(view, "view");
        int width = view.getWidth() / 2;
        View view2 = getView();
        Intrinsics.checkNotNullExpressionValue(view2, "view");
        int height = view2.getHeight() / 2;
        this.shadow.setBounds(0, 0, width, height);
        size.set(width, height);
        touch.set(width / 2, height / 2);
    }

    @Override // android.view.View.DragShadowBuilder
    public void onDrawShadow(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        this.shadow.draw(canvas);
    }
}
