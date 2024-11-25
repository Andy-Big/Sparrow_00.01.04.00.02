package com.scwang.smartrefresh.layout.internal;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.view.animation.LinearInterpolator;
import com.blankj.utilcode.constant.CacheConstants;
/* loaded from: classes2.dex */
public class ProgressDrawable extends PaintDrawable implements Animatable, ValueAnimator.AnimatorUpdateListener {
    protected ValueAnimator mValueAnimator;
    protected int mWidth = 0;
    protected int mHeight = 0;
    protected int mProgressDegree = 0;
    protected Path mPath = new Path();

    public ProgressDrawable() {
        ValueAnimator ofInt = ValueAnimator.ofInt(30, CacheConstants.HOUR);
        this.mValueAnimator = ofInt;
        ofInt.setDuration(10000L);
        this.mValueAnimator.setInterpolator(new LinearInterpolator());
        this.mValueAnimator.setRepeatCount(-1);
        this.mValueAnimator.setRepeatMode(1);
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.mProgressDegree = (((Integer) valueAnimator.getAnimatedValue()).intValue() / 30) * 30;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int i;
        Rect bounds = getBounds();
        int width = bounds.width();
        int height = bounds.height();
        int max = Math.max(1, width / 20);
        if (this.mWidth != width || this.mHeight != height) {
            this.mPath.reset();
            float f = width - max;
            float f2 = height / 2;
            float f3 = max;
            this.mPath.addCircle(f, f2, f3, Path.Direction.CW);
            float f4 = width - (max * 5);
            this.mPath.addRect(f4, i - max, f, i + max, Path.Direction.CW);
            this.mPath.addCircle(f4, f2, f3, Path.Direction.CW);
            this.mWidth = width;
            this.mHeight = height;
        }
        canvas.save();
        float f5 = width / 2;
        float f6 = height / 2;
        canvas.rotate(this.mProgressDegree, f5, f6);
        for (int i2 = 0; i2 < 12; i2++) {
            this.mPaint.setAlpha((i2 + 5) * 17);
            canvas.rotate(30.0f, f5, f6);
            canvas.drawPath(this.mPath, this.mPaint);
        }
        canvas.restore();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (this.mValueAnimator.isRunning()) {
            return;
        }
        this.mValueAnimator.addUpdateListener(this);
        this.mValueAnimator.start();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        if (this.mValueAnimator.isRunning()) {
            this.mValueAnimator.removeAllListeners();
            this.mValueAnimator.removeAllUpdateListeners();
            this.mValueAnimator.cancel();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.mValueAnimator.isRunning();
    }
}
