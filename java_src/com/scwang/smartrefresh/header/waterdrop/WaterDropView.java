package com.scwang.smartrefresh.header.waterdrop;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import com.scwang.smartrefresh.layout.util.DensityUtil;
/* loaded from: classes2.dex */
public class WaterDropView extends View {
    protected static final int BACK_ANIM_DURATION = 180;
    protected static int STROKE_WIDTH = 2;
    protected Circle bottomCircle;
    protected int mMaxCircleRadius;
    protected int mMinCircleRadius;
    protected Paint mPaint;
    protected Path mPath;
    protected Circle topCircle;

    public void updateCompleteState(int i, int i2) {
    }

    public WaterDropView(Context context) {
        super(context);
        this.topCircle = new Circle();
        this.bottomCircle = new Circle();
        this.mPath = new Path();
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setColor(-7829368);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        Paint paint2 = this.mPaint;
        int dp2px = DensityUtil.dp2px(1.0f);
        STROKE_WIDTH = dp2px;
        paint2.setStrokeWidth(dp2px);
        Paint paint3 = this.mPaint;
        int i = STROKE_WIDTH;
        paint3.setShadowLayer(i, i / 2, i, -1728053248);
        setLayerType(1, null);
        int i2 = STROKE_WIDTH * 4;
        setPadding(i2, i2, i2, i2);
        this.mPaint.setColor(-7829368);
        int dp2px2 = DensityUtil.dp2px(20.0f);
        this.mMaxCircleRadius = dp2px2;
        this.mMinCircleRadius = dp2px2 / 5;
        this.topCircle.radius = dp2px2;
        this.bottomCircle.radius = this.mMaxCircleRadius;
        this.topCircle.x = STROKE_WIDTH + this.mMaxCircleRadius;
        this.topCircle.y = STROKE_WIDTH + this.mMaxCircleRadius;
        this.bottomCircle.x = STROKE_WIDTH + this.mMaxCircleRadius;
        this.bottomCircle.y = STROKE_WIDTH + this.mMaxCircleRadius;
    }

    public int getMaxCircleRadius() {
        return this.mMaxCircleRadius;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.setMeasuredDimension(((this.mMaxCircleRadius + STROKE_WIDTH) * 2) + getPaddingLeft() + getPaddingRight(), View.resolveSize(((int) Math.ceil(this.bottomCircle.y + this.bottomCircle.radius + (STROKE_WIDTH * 2))) + getPaddingTop() + getPaddingBottom(), i2));
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        updateCompleteState(getHeight());
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int paddingTop = getPaddingTop();
        int paddingLeft = getPaddingLeft();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        canvas.save();
        float f = height;
        float f2 = paddingTop;
        float f3 = paddingBottom;
        if (f <= (this.topCircle.radius * 2.0f) + f2 + f3) {
            canvas.translate(paddingLeft, (f - (this.topCircle.radius * 2.0f)) - f3);
            canvas.drawCircle(this.topCircle.x, this.topCircle.y, this.topCircle.radius, this.mPaint);
        } else {
            canvas.translate(paddingLeft, f2);
            makeBezierPath();
            canvas.drawPath(this.mPath, this.mPaint);
        }
        canvas.restore();
    }

    private void makeBezierPath() {
        this.mPath.reset();
        this.mPath.addCircle(this.topCircle.x, this.topCircle.y, this.topCircle.radius, Path.Direction.CCW);
        if (this.bottomCircle.y > this.topCircle.y + DensityUtil.dp2px(1.0f)) {
            this.mPath.addCircle(this.bottomCircle.x, this.bottomCircle.y, this.bottomCircle.radius, Path.Direction.CCW);
            double angle = getAngle();
            float sin = (float) (this.topCircle.y + (this.topCircle.radius * Math.sin(angle)));
            float sin2 = (float) (this.bottomCircle.y + (this.bottomCircle.radius * Math.sin(angle)));
            float cos = (float) (this.bottomCircle.x + (this.bottomCircle.radius * Math.cos(angle)));
            this.mPath.moveTo(this.topCircle.x, this.topCircle.y);
            this.mPath.lineTo((float) (this.topCircle.x - (this.topCircle.radius * Math.cos(angle))), sin);
            this.mPath.quadTo(this.bottomCircle.x - this.bottomCircle.radius, (this.bottomCircle.y + this.topCircle.y) / 2.0f, (float) (this.bottomCircle.x - (this.bottomCircle.radius * Math.cos(angle))), sin2);
            this.mPath.lineTo(cos, sin2);
            this.mPath.quadTo(this.bottomCircle.x + this.bottomCircle.radius, (this.bottomCircle.y + sin) / 2.0f, (float) (this.topCircle.x + (this.topCircle.radius * Math.cos(angle))), sin);
        }
        this.mPath.close();
    }

    private double getAngle() {
        if (this.bottomCircle.radius > this.topCircle.radius) {
            return 0.0d;
        }
        return Math.asin((this.topCircle.radius - this.bottomCircle.radius) / (this.bottomCircle.y - this.topCircle.y));
    }

    public ValueAnimator createAnimator() {
        ValueAnimator duration = ValueAnimator.ofFloat(1.0f, 0.001f).setDuration(180L);
        duration.setInterpolator(new DecelerateInterpolator());
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.scwang.smartrefresh.header.waterdrop.WaterDropView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                WaterDropView.this.updateCompleteState(((Float) valueAnimator.getAnimatedValue()).floatValue());
                WaterDropView.this.postInvalidate();
            }
        });
        return duration;
    }

    public void updateCompleteState(float f) {
        int i = this.mMaxCircleRadius;
        float f2 = f * 4.0f * i;
        this.topCircle.radius = (float) (i - ((f * 0.25d) * i));
        this.bottomCircle.radius = ((this.mMinCircleRadius - i) * f) + i;
        this.bottomCircle.y = this.topCircle.y + f2;
    }

    public void updateCompleteState(int i) {
        float f;
        float f2;
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i2 = this.mMaxCircleRadius;
        if (i < (i2 * 2) + paddingTop + paddingBottom) {
            this.topCircle.radius = i2;
            this.bottomCircle.radius = this.mMaxCircleRadius;
            this.bottomCircle.y = this.topCircle.y;
            return;
        }
        float pow = (float) ((i2 - this.mMinCircleRadius) * (1.0d - Math.pow(100.0d, (-Math.max(0.0f, f2 - f)) / DensityUtil.dp2px(200.0f))));
        this.topCircle.radius = this.mMaxCircleRadius - (pow / 4.0f);
        this.bottomCircle.radius = this.mMaxCircleRadius - pow;
        Circle circle = this.bottomCircle;
        circle.y = ((i - paddingTop) - paddingBottom) - circle.radius;
    }

    public Circle getTopCircle() {
        return this.topCircle;
    }

    public Circle getBottomCircle() {
        return this.bottomCircle;
    }

    public void setIndicatorColor(int i) {
        this.mPaint.setColor(i);
    }

    public int getIndicatorColor() {
        return this.mPaint.getColor();
    }
}
