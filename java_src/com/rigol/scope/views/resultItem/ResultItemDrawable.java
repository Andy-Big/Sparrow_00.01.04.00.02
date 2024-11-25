package com.rigol.scope.views.resultItem;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
/* loaded from: classes2.dex */
public class ResultItemDrawable extends Drawable {
    public static final int STATE_CHECKED = 1;
    public static final int STATE_NORMAL = 0;
    private int currentState;
    private Rect mBounds;
    private int mTopWidth;
    private Paint normalPaint;
    private Paint selectedPaint;
    private int mTopHeight = 30;
    private int mRadius = 7;

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    public ResultItemDrawable(int i, int i2) {
        this.mTopWidth = i2;
        this.currentState = i;
        init();
    }

    private void init() {
        Paint paint = new Paint();
        this.normalPaint = paint;
        paint.setColor(Color.parseColor("#4F5C5F"));
        this.normalPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.normalPaint.setAntiAlias(true);
        this.normalPaint.setStrokeWidth(2.0f);
        Paint paint2 = new Paint();
        this.selectedPaint = paint2;
        paint2.setColor(Color.parseColor("#1FC980"));
        this.selectedPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.selectedPaint.setAntiAlias(true);
        this.selectedPaint.setStrokeWidth(2.0f);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int i = this.mBounds.right - (this.mBounds.right - this.mTopWidth);
        int i2 = this.currentState;
        if (i2 == 0) {
            float f = i;
            float f2 = this.mBounds.bottom;
            int i3 = this.mRadius;
            canvas.drawRoundRect(0.0f, 0.0f, f, f2, i3, i3, this.normalPaint);
            float f3 = this.mBounds.left;
            float f4 = this.mBounds.top + this.mTopHeight;
            float f5 = this.mBounds.right;
            float f6 = this.mBounds.bottom;
            int i4 = this.mRadius;
            canvas.drawRoundRect(f3, f4, f5, f6, i4, i4, this.normalPaint);
        } else if (i2 != 1) {
        } else {
            float f7 = this.mBounds.bottom;
            int i5 = this.mRadius;
            canvas.drawRoundRect(this.mBounds.left, 0.0f, i, f7, i5 + 1, i5 + 1, this.selectedPaint);
            float f8 = i - 2;
            float f9 = this.mBounds.bottom;
            int i6 = this.mRadius;
            canvas.drawRoundRect(this.mBounds.left + 3, 3.0f, f8, f9, i6 - 2, i6 - 2, this.normalPaint);
            float f10 = this.mBounds.left;
            float f11 = this.mBounds.top + this.mTopHeight;
            float f12 = this.mBounds.right;
            float f13 = this.mBounds.bottom;
            int i7 = this.mRadius;
            canvas.drawRoundRect(f10, f11, f12, f13, i7 + 1, i7 + 1, this.selectedPaint);
            int i8 = this.mRadius;
            canvas.drawRoundRect(this.mBounds.left + 3, this.mBounds.top + this.mTopHeight + 2, this.mBounds.right - 3, this.mBounds.bottom - 3, i8 - 2, i8 - 2, this.normalPaint);
            float f14 = this.mBounds.left + 3;
            int i9 = this.mTopHeight;
            canvas.drawRect(f14, i9 - 2, this.mTopWidth - 2, i9 + 10, this.normalPaint);
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.mBounds = rect;
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i, int i2, int i3, int i4) {
        super.setBounds(i, i2, i3, i4);
    }
}
