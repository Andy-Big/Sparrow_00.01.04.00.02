package com.scwang.smartrefresh.header.internal.pathview;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes2.dex */
public class PathsView extends View {
    protected PathsDrawable mPathsDrawable;

    public PathsView(Context context) {
        this(context, null);
    }

    public PathsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPathsDrawable = new PathsDrawable();
        this.mPathsDrawable = new PathsDrawable();
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        if (getTag() instanceof String) {
            parserPaths(getTag().toString());
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        PathsDrawable pathsDrawable = this.mPathsDrawable;
        super.setMeasuredDimension(View.resolveSize(pathsDrawable.getBounds().width() + getPaddingLeft() + getPaddingRight(), i), View.resolveSize(pathsDrawable.getBounds().height() + getPaddingTop() + getPaddingBottom(), i2));
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.mPathsDrawable.setBounds(getPaddingLeft(), getPaddingTop(), Math.max((i3 - i) - getPaddingRight(), getPaddingLeft()), Math.max((i4 - i2) - getPaddingTop(), getPaddingTop()));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.mPathsDrawable.draw(canvas);
    }

    public boolean parserPaths(String... strArr) {
        return this.mPathsDrawable.parserPaths(strArr);
    }

    public void parserColors(int... iArr) {
        this.mPathsDrawable.parserColors(iArr);
    }
}
