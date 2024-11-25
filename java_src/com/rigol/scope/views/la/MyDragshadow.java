package com.rigol.scope.views.la;

import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.rigol.scope.R;
/* loaded from: classes2.dex */
public class MyDragshadow extends View.DragShadowBuilder {
    private Drawable shadow;

    public MyDragshadow(View view) {
        super(view);
        this.shadow = new ColorDrawable(getView().getContext().getColor(R.color.red));
    }

    @Override // android.view.View.DragShadowBuilder
    public void onProvideShadowMetrics(Point point, Point point2) {
        int width = getView().getWidth();
        int height = getView().getHeight() / 16;
        this.shadow.setBounds(0, 0, width, height);
        point.set(width, 10);
        point2.set(width / 2, height / 2);
    }

    @Override // android.view.View.DragShadowBuilder
    public void onDrawShadow(Canvas canvas) {
        this.shadow.draw(canvas);
    }
}
