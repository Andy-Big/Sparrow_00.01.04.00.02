package com.just.agentweb;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import androidx.constraintlayout.motion.widget.Key;
/* loaded from: classes.dex */
public class WebIndicator extends BaseIndicatorView implements BaseIndicatorSpec {
    public static final int DO_END_ANIMATION_DURATION = 600;
    public static final int FINISH = 2;
    public static final int MAX_DECELERATE_SPEED_DURATION = 450;
    public static final int MAX_UNIFORM_SPEED_DURATION = 8000;
    public static final int STARTED = 1;
    public static final int UN_START = 0;
    private int indicatorStatus;
    private Animator mAnimator;
    private AnimatorListenerAdapter mAnimatorListenerAdapter;
    private ValueAnimator.AnimatorUpdateListener mAnimatorUpdateListener;
    private int mColor;
    private int mCurrentDoEndAnimationDuration;
    private int mCurrentMaxDecelerateSpeedDuration;
    private int mCurrentMaxUniformSpeedDuration;
    private float mCurrentProgress;
    private Paint mPaint;
    private int mTargetWidth;
    public int mWebIndicatorDefaultHeight;

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
    }

    public WebIndicator(Context context) {
        this(context, null);
    }

    public WebIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WebIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mTargetWidth = 0;
        this.mCurrentMaxUniformSpeedDuration = MAX_UNIFORM_SPEED_DURATION;
        this.mCurrentMaxDecelerateSpeedDuration = 450;
        this.mCurrentDoEndAnimationDuration = 600;
        this.indicatorStatus = 0;
        this.mCurrentProgress = 0.0f;
        this.mWebIndicatorDefaultHeight = 3;
        this.mAnimatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: com.just.agentweb.WebIndicator.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                WebIndicator.this.mCurrentProgress = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                WebIndicator.this.invalidate();
            }
        };
        this.mAnimatorListenerAdapter = new AnimatorListenerAdapter() { // from class: com.just.agentweb.WebIndicator.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                WebIndicator.this.doEnd();
            }
        };
        init(context, attributeSet, i);
    }

    private void init(Context context, AttributeSet attributeSet, int i) {
        this.mPaint = new Paint();
        this.mColor = Color.parseColor("#1aad19");
        this.mPaint.setAntiAlias(true);
        this.mPaint.setColor(this.mColor);
        this.mPaint.setDither(true);
        this.mPaint.setStrokeCap(Paint.Cap.SQUARE);
        this.mTargetWidth = context.getResources().getDisplayMetrics().widthPixels;
        this.mWebIndicatorDefaultHeight = AgentWebUtils.dp2px(context, 3.0f);
    }

    public void setColor(int i) {
        this.mColor = i;
        this.mPaint.setColor(i);
    }

    public void setColor(String str) {
        setColor(Color.parseColor(str));
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode == Integer.MIN_VALUE && size > getContext().getResources().getDisplayMetrics().widthPixels) {
            size = getContext().getResources().getDisplayMetrics().widthPixels;
        }
        if (mode2 == Integer.MIN_VALUE) {
            size2 = this.mWebIndicatorDefaultHeight;
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.drawRect(0.0f, 0.0f, (this.mCurrentProgress / 100.0f) * Float.valueOf(getWidth()).floatValue(), getHeight(), this.mPaint);
    }

    @Override // com.just.agentweb.BaseIndicatorView, com.just.agentweb.BaseIndicatorSpec
    public void show() {
        if (getVisibility() == 8) {
            setVisibility(0);
            this.mCurrentProgress = 0.0f;
            startAnim(false);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mTargetWidth = getMeasuredWidth();
        int i5 = getContext().getResources().getDisplayMetrics().widthPixels;
        int i6 = this.mTargetWidth;
        if (i6 >= i5) {
            this.mCurrentMaxDecelerateSpeedDuration = 450;
            this.mCurrentMaxUniformSpeedDuration = MAX_UNIFORM_SPEED_DURATION;
            this.mCurrentDoEndAnimationDuration = 450;
        } else {
            float floatValue = i6 / Float.valueOf(i5).floatValue();
            this.mCurrentMaxUniformSpeedDuration = (int) (8000.0f * floatValue);
            this.mCurrentMaxDecelerateSpeedDuration = (int) (450.0f * floatValue);
            this.mCurrentDoEndAnimationDuration = (int) (floatValue * 600.0f);
        }
        LogUtils.i("WebProgress", "CURRENT_MAX_UNIFORM_SPEED_DURATION" + this.mCurrentMaxUniformSpeedDuration);
    }

    public void setProgress(float f) {
        if (getVisibility() == 8) {
            setVisibility(0);
        }
        if (f >= 95.0f && this.indicatorStatus != 2) {
            startAnim(true);
        }
    }

    @Override // com.just.agentweb.BaseIndicatorView, com.just.agentweb.BaseIndicatorSpec
    public void hide() {
        this.indicatorStatus = 2;
    }

    private void startAnim(boolean z) {
        float f = z ? 100.0f : 95.0f;
        Animator animator = this.mAnimator;
        if (animator != null && animator.isStarted()) {
            this.mAnimator.cancel();
        }
        float f2 = this.mCurrentProgress;
        if (f2 == 0.0f) {
            f2 = 1.0E-8f;
        }
        this.mCurrentProgress = f2;
        if (!z) {
            AnimatorSet animatorSet = new AnimatorSet();
            float f3 = f * 0.6f;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(this.mCurrentProgress, f3);
            ValueAnimator ofFloat2 = ValueAnimator.ofFloat(f3, f);
            ofFloat.setInterpolator(new LinearInterpolator());
            ofFloat.setDuration(r0 * 0.4f);
            ofFloat.addUpdateListener(this.mAnimatorUpdateListener);
            ofFloat2.setInterpolator(new LinearInterpolator());
            ofFloat2.setDuration(0.6f * r0);
            ofFloat2.addUpdateListener(this.mAnimatorUpdateListener);
            animatorSet.play(ofFloat2).after(ofFloat);
            animatorSet.start();
            this.mAnimator = animatorSet;
        } else {
            ValueAnimator valueAnimator = null;
            if (f2 < 95.0f) {
                valueAnimator = ValueAnimator.ofFloat(f2, 95.0f);
                valueAnimator.setDuration(((1.0f - (this.mCurrentProgress / 100.0f)) - 0.05f) * this.mCurrentMaxDecelerateSpeedDuration);
                valueAnimator.setInterpolator(new DecelerateInterpolator());
                valueAnimator.addUpdateListener(this.mAnimatorUpdateListener);
            }
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this, Key.ALPHA, 1.0f, 0.0f);
            ofFloat3.setDuration(this.mCurrentDoEndAnimationDuration);
            ValueAnimator ofFloat4 = ValueAnimator.ofFloat(95.0f, 100.0f);
            ofFloat4.setDuration(this.mCurrentDoEndAnimationDuration);
            ofFloat4.addUpdateListener(this.mAnimatorUpdateListener);
            AnimatorSet animatorSet2 = new AnimatorSet();
            animatorSet2.playTogether(ofFloat3, ofFloat4);
            if (valueAnimator != null) {
                AnimatorSet animatorSet3 = new AnimatorSet();
                animatorSet3.play(animatorSet2).after(valueAnimator);
                animatorSet2 = animatorSet3;
            }
            animatorSet2.addListener(this.mAnimatorListenerAdapter);
            animatorSet2.start();
            this.mAnimator = animatorSet2;
        }
        this.indicatorStatus = 1;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Animator animator = this.mAnimator;
        if (animator == null || !animator.isStarted()) {
            return;
        }
        this.mAnimator.cancel();
        this.mAnimator = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doEnd() {
        if (this.indicatorStatus == 2 && this.mCurrentProgress == 100.0f) {
            setVisibility(8);
            this.mCurrentProgress = 0.0f;
            setAlpha(1.0f);
        }
        this.indicatorStatus = 0;
    }

    @Override // com.just.agentweb.BaseIndicatorView, com.just.agentweb.BaseIndicatorSpec
    public void reset() {
        this.mCurrentProgress = 0.0f;
        Animator animator = this.mAnimator;
        if (animator == null || !animator.isStarted()) {
            return;
        }
        this.mAnimator.cancel();
    }

    @Override // com.just.agentweb.BaseIndicatorView, com.just.agentweb.BaseIndicatorSpec
    public void setProgress(int i) {
        setProgress(Float.valueOf(i).floatValue());
    }

    @Override // com.just.agentweb.LayoutParamsOffer
    public FrameLayout.LayoutParams offerLayoutParams() {
        return new FrameLayout.LayoutParams(-1, this.mWebIndicatorDefaultHeight);
    }
}
