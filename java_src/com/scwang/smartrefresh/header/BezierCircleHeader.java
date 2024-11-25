package com.scwang.smartrefresh.header;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.core.graphics.ColorUtils;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.internal.InternalAbstract;
import com.scwang.smartrefresh.layout.util.DensityUtil;
/* loaded from: classes2.dex */
public class BezierCircleHeader extends InternalAbstract implements RefreshHeader {
    protected static final int TARGET_DEGREE = 270;
    protected Paint mBackPaint;
    protected float mBollRadius;
    protected float mBollY;
    protected float mFinishRatio;
    protected Paint mFrontPaint;
    protected float mHeadHeight;
    protected boolean mOuterIsStart;
    protected Paint mOuterPaint;
    protected Path mPath;
    protected int mRefreshStart;
    protected int mRefreshStop;
    protected boolean mShowBoll;
    protected boolean mShowBollTail;
    protected boolean mShowOuter;
    protected float mSpringRatio;
    protected float mWaveHeight;
    protected boolean mWavePulling;

    public BezierCircleHeader(Context context) {
        this(context, null);
    }

    public BezierCircleHeader(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BezierCircleHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRefreshStop = 90;
        this.mRefreshStart = 90;
        this.mOuterIsStart = true;
        this.mWavePulling = false;
        this.mSpinnerStyle = SpinnerStyle.Scale;
        setMinimumHeight(DensityUtil.dp2px(100.0f));
        Paint paint = new Paint();
        this.mBackPaint = paint;
        paint.setColor(-15614977);
        this.mBackPaint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.mFrontPaint = paint2;
        paint2.setColor(-1);
        this.mFrontPaint.setAntiAlias(true);
        Paint paint3 = new Paint();
        this.mOuterPaint = paint3;
        paint3.setAntiAlias(true);
        this.mOuterPaint.setColor(-1);
        this.mOuterPaint.setStyle(Paint.Style.STROKE);
        this.mOuterPaint.setStrokeWidth(DensityUtil.dp2px(2.0f));
        this.mPath = new Path();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int width = getWidth();
        int height = getHeight();
        if (isInEditMode()) {
            this.mShowBoll = true;
            this.mShowOuter = true;
            float f = height;
            this.mHeadHeight = f;
            this.mRefreshStop = 270;
            this.mBollY = f / 2.0f;
            this.mBollRadius = f / 6.0f;
        }
        drawWave(canvas, width, height);
        drawSpringUp(canvas, width);
        drawBoll(canvas, width);
        drawOuter(canvas, width);
        drawFinish(canvas, width);
        super.dispatchDraw(canvas);
    }

    private void drawWave(Canvas canvas, int i, int i2) {
        float min = Math.min(this.mHeadHeight, i2);
        if (this.mWaveHeight != 0.0f) {
            this.mPath.reset();
            float f = i;
            this.mPath.lineTo(f, 0.0f);
            this.mPath.lineTo(f, min);
            this.mPath.quadTo(i / 2, (this.mWaveHeight * 2.0f) + min, 0.0f, min);
            this.mPath.close();
            canvas.drawPath(this.mPath, this.mBackPaint);
            return;
        }
        canvas.drawRect(0.0f, 0.0f, i, min, this.mBackPaint);
    }

    private void drawSpringUp(Canvas canvas, int i) {
        float f = this.mSpringRatio;
        if (f > 0.0f) {
            float f2 = i / 2;
            float f3 = this.mBollRadius;
            float f4 = (f2 - (4.0f * f3)) + (3.0f * f * f3);
            if (f < 0.9d) {
                this.mPath.reset();
                this.mPath.moveTo(f4, this.mBollY);
                Path path = this.mPath;
                float f5 = this.mBollY;
                path.quadTo(f2, f5 - ((this.mBollRadius * this.mSpringRatio) * 2.0f), i - f4, f5);
                canvas.drawPath(this.mPath, this.mFrontPaint);
                return;
            }
            canvas.drawCircle(f2, this.mBollY, f3, this.mFrontPaint);
        }
    }

    private void drawBoll(Canvas canvas, int i) {
        if (this.mShowBoll) {
            canvas.drawCircle(i / 2, this.mBollY, this.mBollRadius, this.mFrontPaint);
            float f = this.mHeadHeight;
            drawBollTail(canvas, i, (this.mWaveHeight + f) / f);
        }
    }

    private void drawBollTail(Canvas canvas, int i, float f) {
        float f2;
        if (this.mShowBollTail) {
            float f3 = this.mHeadHeight + this.mWaveHeight;
            float f4 = this.mBollY + ((this.mBollRadius * f) / 2.0f);
            float f5 = i / 2;
            float sqrt = ((float) Math.sqrt(f2 * f2 * (1.0f - ((f * f) / 4.0f)))) + f5;
            float f6 = this.mBollRadius;
            float f7 = f5 + (((3.0f * f6) / 4.0f) * (1.0f - f));
            float f8 = f6 + f7;
            this.mPath.reset();
            this.mPath.moveTo(sqrt, f4);
            this.mPath.quadTo(f7, f3, f8, f3);
            float f9 = i;
            this.mPath.lineTo(f9 - f8, f3);
            this.mPath.quadTo(f9 - f7, f3, f9 - sqrt, f4);
            canvas.drawPath(this.mPath, this.mFrontPaint);
        }
    }

    private void drawOuter(Canvas canvas, int i) {
        if (this.mShowOuter) {
            float strokeWidth = this.mBollRadius + (this.mOuterPaint.getStrokeWidth() * 2.0f);
            this.mRefreshStart += this.mOuterIsStart ? 3 : 10;
            int i2 = this.mRefreshStop + (this.mOuterIsStart ? 10 : 3);
            this.mRefreshStop = i2;
            int i3 = this.mRefreshStart % 360;
            this.mRefreshStart = i3;
            int i4 = i2 % 360;
            this.mRefreshStop = i4;
            int i5 = i4 - i3;
            if (i5 < 0) {
                i5 += 360;
            }
            float f = i / 2;
            float f2 = this.mBollY;
            canvas.drawArc(new RectF(f - strokeWidth, f2 - strokeWidth, f + strokeWidth, f2 + strokeWidth), this.mRefreshStart, i5, false, this.mOuterPaint);
            if (i5 >= 270) {
                this.mOuterIsStart = false;
            } else if (i5 <= 10) {
                this.mOuterIsStart = true;
            }
            invalidate();
        }
    }

    private void drawFinish(Canvas canvas, int i) {
        int i2;
        int i3;
        if (this.mFinishRatio > 0.0f) {
            int color = this.mOuterPaint.getColor();
            if (this.mFinishRatio < 0.3d) {
                canvas.drawCircle(i / 2, this.mBollY, this.mBollRadius, this.mFrontPaint);
                float f = this.mBollRadius;
                float f2 = this.mFinishRatio;
                int strokeWidth = (int) (f + (this.mOuterPaint.getStrokeWidth() * 2.0f * ((f2 / 0.3f) + 1.0f)));
                this.mOuterPaint.setColor(ColorUtils.setAlphaComponent(color, (int) ((1.0f - (f2 / 0.3f)) * 255.0f)));
                float f3 = this.mBollY;
                float f4 = strokeWidth;
                canvas.drawArc(new RectF(i3 - strokeWidth, f3 - f4, i3 + strokeWidth, f3 + f4), 0.0f, 360.0f, false, this.mOuterPaint);
            }
            this.mOuterPaint.setColor(color);
            float f5 = this.mFinishRatio;
            if (f5 >= 0.3d && f5 < 0.7d) {
                float f6 = (f5 - 0.3f) / 0.4f;
                float f7 = this.mHeadHeight;
                float f8 = (int) ((f7 / 2.0f) + ((f7 - (f7 / 2.0f)) * f6));
                this.mBollY = f8;
                canvas.drawCircle(i / 2, f8, this.mBollRadius, this.mFrontPaint);
                if (this.mBollY >= this.mHeadHeight - (this.mBollRadius * 2.0f)) {
                    this.mShowBollTail = true;
                    drawBollTail(canvas, i, f6);
                }
                this.mShowBollTail = false;
            }
            float f9 = this.mFinishRatio;
            if (f9 < 0.7d || f9 > 1.0f) {
                return;
            }
            float f10 = (f9 - 0.7f) / 0.3f;
            float f11 = i / 2;
            float f12 = this.mBollRadius;
            this.mPath.reset();
            this.mPath.moveTo((int) ((f11 - f12) - ((f12 * 2.0f) * f10)), this.mHeadHeight);
            Path path = this.mPath;
            float f13 = this.mHeadHeight;
            path.quadTo(f11, f13 - (this.mBollRadius * (1.0f - f10)), i - i2, f13);
            canvas.drawPath(this.mPath, this.mFrontPaint);
        }
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public void onMoving(boolean z, float f, int i, int i2, int i3) {
        if (z || this.mWavePulling) {
            this.mWavePulling = true;
            this.mHeadHeight = i2;
            this.mWaveHeight = Math.max(i - i2, 0) * 0.8f;
        }
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public void onReleased(RefreshLayout refreshLayout, int i, int i2) {
        this.mWavePulling = false;
        this.mHeadHeight = i;
        this.mBollRadius = i / 6;
        DecelerateInterpolator decelerateInterpolator = new DecelerateInterpolator();
        final float min = Math.min(this.mWaveHeight * 0.8f, this.mHeadHeight / 2.0f);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(this.mWaveHeight, 0.0f, -(1.0f * min), 0.0f, -(0.4f * min), 0.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.scwang.smartrefresh.header.BezierCircleHeader.1
            float springBollY;
            float speed = 0.0f;
            float springRatio = 0.0f;
            int status = 0;

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (this.status == 0 && floatValue <= 0.0f) {
                    this.status = 1;
                    this.speed = Math.abs(floatValue - BezierCircleHeader.this.mWaveHeight);
                }
                if (this.status == 1) {
                    float f = (-floatValue) / min;
                    this.springRatio = f;
                    if (f >= BezierCircleHeader.this.mSpringRatio) {
                        BezierCircleHeader.this.mSpringRatio = this.springRatio;
                        BezierCircleHeader bezierCircleHeader = BezierCircleHeader.this;
                        bezierCircleHeader.mBollY = bezierCircleHeader.mHeadHeight + floatValue;
                        this.speed = Math.abs(floatValue - BezierCircleHeader.this.mWaveHeight);
                    } else {
                        this.status = 2;
                        BezierCircleHeader.this.mSpringRatio = 0.0f;
                        BezierCircleHeader.this.mShowBoll = true;
                        BezierCircleHeader.this.mShowBollTail = true;
                        this.springBollY = BezierCircleHeader.this.mBollY;
                    }
                }
                if (this.status == 2 && BezierCircleHeader.this.mBollY > BezierCircleHeader.this.mHeadHeight / 2.0f) {
                    BezierCircleHeader bezierCircleHeader2 = BezierCircleHeader.this;
                    bezierCircleHeader2.mBollY = Math.max(bezierCircleHeader2.mHeadHeight / 2.0f, BezierCircleHeader.this.mBollY - this.speed);
                    float animatedFraction = valueAnimator.getAnimatedFraction();
                    float f2 = this.springBollY;
                    float f3 = (animatedFraction * ((BezierCircleHeader.this.mHeadHeight / 2.0f) - f2)) + f2;
                    if (BezierCircleHeader.this.mBollY > f3) {
                        BezierCircleHeader.this.mBollY = f3;
                    }
                }
                if (BezierCircleHeader.this.mShowBollTail && floatValue < BezierCircleHeader.this.mWaveHeight) {
                    BezierCircleHeader.this.mShowOuter = true;
                    BezierCircleHeader.this.mShowBollTail = false;
                    BezierCircleHeader.this.mOuterIsStart = true;
                    BezierCircleHeader.this.mRefreshStart = 90;
                    BezierCircleHeader.this.mRefreshStop = 90;
                }
                if (BezierCircleHeader.this.mWavePulling) {
                    return;
                }
                BezierCircleHeader.this.mWaveHeight = floatValue;
                BezierCircleHeader.this.invalidate();
            }
        });
        ofFloat.setInterpolator(decelerateInterpolator);
        ofFloat.setDuration(1000L);
        ofFloat.start();
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public int onFinish(RefreshLayout refreshLayout, boolean z) {
        this.mShowBoll = false;
        this.mShowOuter = false;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.scwang.smartrefresh.header.BezierCircleHeader.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                BezierCircleHeader bezierCircleHeader = BezierCircleHeader.this;
                bezierCircleHeader.mFinishRatio = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                bezierCircleHeader.invalidate();
            }
        });
        ofFloat.setInterpolator(new AccelerateInterpolator());
        ofFloat.setDuration(800L);
        ofFloat.start();
        return 800;
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    @Deprecated
    public void setPrimaryColors(int... iArr) {
        if (iArr.length > 0) {
            this.mBackPaint.setColor(iArr[0]);
            if (iArr.length > 1) {
                this.mFrontPaint.setColor(iArr[1]);
                this.mOuterPaint.setColor(iArr[1]);
            }
        }
    }
}
