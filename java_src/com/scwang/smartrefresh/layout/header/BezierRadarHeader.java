package com.scwang.smartrefresh.layout.header;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.core.view.ViewCompat;
import com.scwang.smartrefresh.layout.R;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.internal.InternalAbstract;
import com.scwang.smartrefresh.layout.util.DensityUtil;
import com.scwang.smartrefresh.layout.util.SmartUtil;
/* loaded from: classes2.dex */
public class BezierRadarHeader extends InternalAbstract implements RefreshHeader {
    protected static final byte PROPERTY_DOT_ALPHA = 2;
    protected static final byte PROPERTY_RADAR_ANGLE = 4;
    protected static final byte PROPERTY_RADAR_SCALE = 0;
    protected static final byte PROPERTY_RIPPLE_RADIUS = 3;
    protected static final byte PROPERTY_WAVE_HEIGHT = 1;
    protected int mAccentColor;
    protected Animator mAnimatorSet;
    protected float mDotAlpha;
    protected float mDotFraction;
    protected float mDotRadius;
    protected boolean mEnableHorizontalDrag;
    protected boolean mManualAccentColor;
    protected boolean mManualPrimaryColor;
    protected Paint mPaint;
    protected Path mPath;
    protected int mPrimaryColor;
    protected int mRadarAngle;
    protected float mRadarCircle;
    protected float mRadarRadius;
    protected RectF mRadarRect;
    protected float mRadarScale;
    protected float mRippleRadius;
    protected int mWaveHeight;
    protected int mWaveOffsetX;
    protected boolean mWavePulling;
    protected int mWaveTop;

    public BezierRadarHeader(Context context) {
        this(context, null);
    }

    public BezierRadarHeader(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BezierRadarHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mEnableHorizontalDrag = false;
        this.mWaveOffsetX = -1;
        this.mRadarAngle = 0;
        this.mRadarRadius = 0.0f;
        this.mRadarCircle = 0.0f;
        this.mRadarScale = 0.0f;
        this.mRadarRect = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        this.mSpinnerStyle = SpinnerStyle.Scale;
        DensityUtil densityUtil = new DensityUtil();
        this.mPath = new Path();
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        this.mDotRadius = densityUtil.dip2px(7.0f);
        this.mRadarRadius = densityUtil.dip2px(20.0f);
        this.mRadarCircle = densityUtil.dip2px(7.0f);
        this.mPaint.setStrokeWidth(densityUtil.dip2px(3.0f));
        setMinimumHeight(densityUtil.dip2px(100.0f));
        if (isInEditMode()) {
            this.mWaveTop = 1000;
            this.mRadarScale = 1.0f;
            this.mRadarAngle = 270;
        } else {
            this.mRadarScale = 0.0f;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BezierRadarHeader);
        this.mEnableHorizontalDrag = obtainStyledAttributes.getBoolean(R.styleable.BezierRadarHeader_srlEnableHorizontalDrag, this.mEnableHorizontalDrag);
        setAccentColor(obtainStyledAttributes.getColor(R.styleable.BezierRadarHeader_srlAccentColor, -1));
        setPrimaryColor(obtainStyledAttributes.getColor(R.styleable.BezierRadarHeader_srlPrimaryColor, -14540254));
        this.mManualAccentColor = obtainStyledAttributes.hasValue(R.styleable.BezierRadarHeader_srlAccentColor);
        this.mManualPrimaryColor = obtainStyledAttributes.hasValue(R.styleable.BezierRadarHeader_srlPrimaryColor);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Animator animator = this.mAnimatorSet;
        if (animator != null) {
            animator.removeAllListeners();
            this.mAnimatorSet.end();
            this.mAnimatorSet = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int width = getWidth();
        int height = getHeight();
        drawWave(canvas, width);
        drawDot(canvas, width, height);
        drawRadar(canvas, width, height);
        drawRipple(canvas, width, height);
        super.dispatchDraw(canvas);
    }

    protected void drawWave(Canvas canvas, int i) {
        int i2;
        this.mPath.reset();
        this.mPath.lineTo(0.0f, this.mWaveTop);
        Path path = this.mPath;
        int i3 = this.mWaveOffsetX;
        if (i3 < 0) {
            i3 = i / 2;
        }
        float f = i;
        path.quadTo(i3, this.mWaveHeight + i2, f, this.mWaveTop);
        this.mPath.lineTo(f, 0.0f);
        this.mPaint.setColor(this.mPrimaryColor);
        canvas.drawPath(this.mPath, this.mPaint);
    }

    protected void drawDot(Canvas canvas, int i, int i2) {
        if (this.mDotAlpha > 0.0f) {
            this.mPaint.setColor(this.mAccentColor);
            float px2dp = DensityUtil.px2dp(i2);
            float f = i / 7;
            float f2 = this.mDotFraction;
            float f3 = 1.0f;
            float f4 = (f * f2) - (f2 > 1.0f ? ((f2 - 1.0f) * f) / f2 : 0.0f);
            float f5 = i2;
            float f6 = this.mDotFraction;
            float f7 = f5 - (f6 > 1.0f ? (((f6 - 1.0f) * f5) / 2.0f) / f6 : 0.0f);
            int i3 = 0;
            while (i3 < 7) {
                float f8 = (i3 + f3) - 4.0f;
                this.mPaint.setAlpha((int) (this.mDotAlpha * (f3 - ((Math.abs(f8) / 7.0f) * 2.0f)) * 255.0f * (1.0d - (1.0d / Math.pow((px2dp / 800.0d) + 1.0d, 15.0d)))));
                float f9 = this.mDotRadius * (1.0f - (1.0f / ((px2dp / 10.0f) + 1.0f)));
                canvas.drawCircle(((i / 2) - (f9 / 2.0f)) + (f8 * f4), f7 / 2.0f, f9, this.mPaint);
                i3++;
                f3 = 1.0f;
            }
            this.mPaint.setAlpha(255);
        }
    }

    protected void drawRadar(Canvas canvas, int i, int i2) {
        if (this.mAnimatorSet != null || isInEditMode()) {
            float f = this.mRadarRadius;
            float f2 = this.mRadarScale;
            float f3 = f * f2;
            float f4 = this.mRadarCircle * f2;
            this.mPaint.setColor(this.mAccentColor);
            this.mPaint.setStyle(Paint.Style.FILL);
            float f5 = i / 2;
            float f6 = i2 / 2;
            canvas.drawCircle(f5, f6, f3, this.mPaint);
            this.mPaint.setStyle(Paint.Style.STROKE);
            float f7 = f4 + f3;
            canvas.drawCircle(f5, f6, f7, this.mPaint);
            this.mPaint.setColor((this.mPrimaryColor & ViewCompat.MEASURED_SIZE_MASK) | 1426063360);
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mRadarRect.set(f5 - f3, f6 - f3, f5 + f3, f3 + f6);
            canvas.drawArc(this.mRadarRect, 270.0f, this.mRadarAngle, true, this.mPaint);
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mRadarRect.set(f5 - f7, f6 - f7, f5 + f7, f6 + f7);
            canvas.drawArc(this.mRadarRect, 270.0f, this.mRadarAngle, false, this.mPaint);
            this.mPaint.setStyle(Paint.Style.FILL);
        }
    }

    protected void drawRipple(Canvas canvas, int i, int i2) {
        if (this.mRippleRadius > 0.0f) {
            this.mPaint.setColor(this.mAccentColor);
            canvas.drawCircle(i / 2, i2 / 2, this.mRippleRadius, this.mPaint);
        }
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public void onMoving(boolean z, float f, int i, int i2, int i3) {
        if (z || this.mWavePulling) {
            this.mWavePulling = true;
            this.mWaveTop = Math.min(i2, i);
            this.mWaveHeight = (int) (Math.max(0, i - i2) * 1.9f);
            this.mDotFraction = f;
        }
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public void onReleased(RefreshLayout refreshLayout, int i, int i2) {
        this.mWaveTop = i;
        this.mWavePulling = false;
        ValueAnimator ofInt = ValueAnimator.ofInt(0, 360);
        ofInt.setDuration(720L);
        ofInt.setRepeatCount(-1);
        ofInt.setInterpolator(new AccelerateDecelerateInterpolator());
        ofInt.addUpdateListener(new AnimatorUpdater((byte) 4));
        DecelerateInterpolator decelerateInterpolator = new DecelerateInterpolator();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat.setInterpolator(decelerateInterpolator);
        ofFloat.addUpdateListener(new AnimatorUpdater((byte) 2));
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setInterpolator(decelerateInterpolator);
        ofFloat2.addUpdateListener(new AnimatorUpdater((byte) 0));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(ofFloat, ofFloat2, ofInt);
        animatorSet.start();
        int i3 = this.mWaveHeight;
        ValueAnimator ofInt2 = ValueAnimator.ofInt(i3, 0, -((int) (i3 * 0.8f)), 0, -((int) (i3 * 0.4f)), 0);
        ofInt2.addUpdateListener(new AnimatorUpdater((byte) 1));
        ofInt2.setInterpolator(decelerateInterpolator);
        ofInt2.setDuration(800L);
        ofInt2.start();
        this.mAnimatorSet = animatorSet;
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public int onFinish(RefreshLayout refreshLayout, boolean z) {
        Animator animator = this.mAnimatorSet;
        if (animator != null) {
            animator.removeAllListeners();
            this.mAnimatorSet.end();
            this.mAnimatorSet = null;
        }
        int width = getWidth();
        int height = getHeight();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, (float) Math.sqrt((width * width) + (height * height)));
        ofFloat.setDuration(400L);
        ofFloat.addUpdateListener(new AnimatorUpdater((byte) 3));
        ofFloat.start();
        return 400;
    }

    /* renamed from: com.scwang.smartrefresh.layout.header.BezierRadarHeader$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$scwang$smartrefresh$layout$constant$RefreshState;

        static {
            int[] iArr = new int[RefreshState.values().length];
            $SwitchMap$com$scwang$smartrefresh$layout$constant$RefreshState = iArr;
            try {
                iArr[RefreshState.None.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$scwang$smartrefresh$layout$constant$RefreshState[RefreshState.PullDownToRefresh.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.listener.OnStateChangedListener
    public void onStateChanged(RefreshLayout refreshLayout, RefreshState refreshState, RefreshState refreshState2) {
        int i = AnonymousClass1.$SwitchMap$com$scwang$smartrefresh$layout$constant$RefreshState[refreshState2.ordinal()];
        if (i == 1 || i == 2) {
            this.mDotAlpha = 1.0f;
            this.mRadarScale = 0.0f;
            this.mRippleRadius = 0.0f;
        }
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    @Deprecated
    public void setPrimaryColors(int... iArr) {
        if (iArr.length > 0 && !this.mManualPrimaryColor) {
            setPrimaryColor(iArr[0]);
            this.mManualPrimaryColor = false;
        }
        if (iArr.length <= 1 || this.mManualAccentColor) {
            return;
        }
        setAccentColor(iArr[1]);
        this.mManualAccentColor = false;
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public boolean isSupportHorizontalDrag() {
        return this.mEnableHorizontalDrag;
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public void onHorizontalDrag(float f, int i, int i2) {
        this.mWaveOffsetX = i;
        if (Build.VERSION.SDK_INT >= 16) {
            postInvalidateOnAnimation();
        } else {
            invalidate();
        }
    }

    public BezierRadarHeader setPrimaryColor(int i) {
        this.mPrimaryColor = i;
        this.mManualPrimaryColor = true;
        return this;
    }

    public BezierRadarHeader setAccentColor(int i) {
        this.mAccentColor = i;
        this.mManualAccentColor = true;
        return this;
    }

    public BezierRadarHeader setPrimaryColorId(int i) {
        setPrimaryColor(SmartUtil.getColor(getContext(), i));
        return this;
    }

    public BezierRadarHeader setAccentColorId(int i) {
        setAccentColor(SmartUtil.getColor(getContext(), i));
        return this;
    }

    public BezierRadarHeader setEnableHorizontalDrag(boolean z) {
        this.mEnableHorizontalDrag = z;
        if (!z) {
            this.mWaveOffsetX = -1;
        }
        return this;
    }

    /* loaded from: classes2.dex */
    protected class AnimatorUpdater implements ValueAnimator.AnimatorUpdateListener {
        byte propertyName;

        AnimatorUpdater(byte b) {
            this.propertyName = b;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            byte b = this.propertyName;
            if (b == 0) {
                BezierRadarHeader.this.mRadarScale = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            } else if (1 == b) {
                if (BezierRadarHeader.this.mWavePulling) {
                    valueAnimator.cancel();
                    return;
                } else {
                    BezierRadarHeader.this.mWaveHeight = ((Integer) valueAnimator.getAnimatedValue()).intValue() / 2;
                }
            } else if (2 == b) {
                BezierRadarHeader.this.mDotAlpha = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            } else if (3 == b) {
                BezierRadarHeader.this.mRippleRadius = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            } else if (4 == b) {
                BezierRadarHeader.this.mRadarAngle = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            }
            BezierRadarHeader.this.invalidate();
        }
    }
}
