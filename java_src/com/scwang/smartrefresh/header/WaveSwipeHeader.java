package com.scwang.smartrefresh.header;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;
import com.scwang.smartrefresh.header.internal.MaterialProgressDrawable;
import com.scwang.smartrefresh.header.waveswipe.WaveView;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.internal.InternalAbstract;
import com.scwang.smartrefresh.layout.util.DensityUtil;
/* loaded from: classes2.dex */
public class WaveSwipeHeader extends InternalAbstract implements RefreshHeader {
    protected static final float MAX_PROGRESS_ROTATION_RATE = 0.8f;
    protected ProgressAnimationImageView mCircleView;
    protected float mLastFirstBounds;
    protected MaterialProgressDrawable mProgress;
    protected RefreshState mState;
    protected WaveView mWaveView;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes2.dex */
    public enum VERTICAL_DRAG_THRESHOLD {
        FIRST(0.1f),
        SECOND(FIRST.val + 0.16f),
        THIRD(FIRST.val + 0.5f);
        
        final float val;

        VERTICAL_DRAG_THRESHOLD(float f) {
            this.val = f;
        }
    }

    public WaveSwipeHeader(Context context) {
        this(context, null);
    }

    public WaveSwipeHeader(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WaveSwipeHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSpinnerStyle = SpinnerStyle.MatchLayout;
        WaveView waveView = new WaveView(context);
        this.mWaveView = waveView;
        addView(waveView);
        ProgressAnimationImageView progressAnimationImageView = new ProgressAnimationImageView(context);
        this.mCircleView = progressAnimationImageView;
        addView(progressAnimationImageView);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.WaveSwipeHeader);
        int color = obtainStyledAttributes.getColor(R.styleable.WaveSwipeHeader_wshPrimaryColor, 0);
        int color2 = obtainStyledAttributes.getColor(R.styleable.WaveSwipeHeader_wshAccentColor, 0);
        if (color != 0) {
            this.mWaveView.setWaveColor(color);
        }
        if (color2 != 0) {
            this.mProgress.setColorSchemeColors(color2);
        } else {
            this.mProgress.setColorSchemeColors(-1);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.WaveSwipeHeader_wshShadowRadius)) {
            this.mWaveView.setShadow(obtainStyledAttributes.getDimensionPixelOffset(R.styleable.WaveSwipeHeader_wshShadowRadius, 0), obtainStyledAttributes.getColor(R.styleable.WaveSwipeHeader_wshShadowColor, ViewCompat.MEASURED_STATE_MASK));
        }
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.setMeasuredDimension(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
        WaveView waveView = this.mWaveView;
        ProgressAnimationImageView progressAnimationImageView = this.mCircleView;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.mProgress.getIntrinsicWidth(), 1073741824);
        progressAnimationImageView.measure(makeMeasureSpec, makeMeasureSpec);
        waveView.measure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), 1073741824), View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i2), 1073741824));
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        WaveView waveView = this.mWaveView;
        ProgressAnimationImageView progressAnimationImageView = this.mCircleView;
        waveView.layout(0, 0, getMeasuredWidth(), getMeasuredHeight());
        int measuredWidth = getMeasuredWidth();
        int measuredWidth2 = progressAnimationImageView.getMeasuredWidth();
        progressAnimationImageView.layout((measuredWidth - measuredWidth2) / 2, -progressAnimationImageView.getMeasuredHeight(), (measuredWidth + measuredWidth2) / 2, 0);
        if (isInEditMode()) {
            onMoving(true, 0.99f, DensityUtil.dp2px(99.0f), DensityUtil.dp2px(100.0f), DensityUtil.dp2px(100.0f));
        }
    }

    public void setColorSchemeColors(int... iArr) {
        this.mProgress.setColorSchemeColors(iArr);
    }

    public void setColorSchemeColorIds(int... iArr) {
        Resources resources = getResources();
        int[] iArr2 = new int[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            if (Build.VERSION.SDK_INT >= 23) {
                iArr2[i] = resources.getColor(iArr[i], getContext().getTheme());
            } else {
                iArr2[i] = resources.getColor(iArr[i]);
            }
        }
        this.mProgress.setColorSchemeColors(iArr2);
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public void onMoving(boolean z, float f, int i, int i2, int i3) {
        if (z) {
            if (this.mState == RefreshState.Refreshing) {
                return;
            }
            ProgressAnimationImageView progressAnimationImageView = this.mCircleView;
            float max = (((float) Math.max(Math.min(1.0f, f) - 0.4d, 0.0d)) * 5.0f) / 3.0f;
            float f2 = f > 3.0f ? 2.0f : f > 1.0f ? f - 1.0f : 0.0f;
            float f3 = ((4.0f - f2) * f2) / 8.0f;
            if (f < 1.0f) {
                this.mProgress.setStartEndTrim(0.0f, Math.min((float) MAX_PROGRESS_ROTATION_RATE, max * MAX_PROGRESS_ROTATION_RATE));
                this.mProgress.setArrowScale(Math.min(1.0f, max));
            }
            this.mProgress.setProgressRotation((((max * 0.4f) - 0.25f) + (f3 * 2.0f)) * 0.5f);
            progressAnimationImageView.setTranslationY(this.mWaveView.getCurrentCircleCenterY());
            float min = (i * 1.0f) / Math.min(getMeasuredWidth(), getMeasuredHeight());
            float f4 = (min * (5.0f - (2.0f * min))) / 3.5f;
            float f5 = f4 - VERTICAL_DRAG_THRESHOLD.FIRST.val;
            float f6 = (f4 - VERTICAL_DRAG_THRESHOLD.SECOND.val) / 5.0f;
            this.mLastFirstBounds = f4;
            if (f4 < VERTICAL_DRAG_THRESHOLD.FIRST.val) {
                this.mWaveView.beginPhase(f4);
            } else if (f4 < VERTICAL_DRAG_THRESHOLD.SECOND.val) {
                this.mWaveView.appearPhase(f4, f5);
            } else {
                this.mWaveView.expandPhase(f4, f5, f6);
            }
        } else if (this.mLastFirstBounds == 0.0f || this.mState != RefreshState.None) {
        } else {
            this.mProgress.showArrow(false);
            this.mProgress.setProgressRotation(0.0f);
            this.mProgress.setStartEndTrim(0.0f, 0.0f);
            this.mWaveView.startWaveAnimation(this.mLastFirstBounds);
            this.mLastFirstBounds = 0.0f;
        }
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public void onReleased(RefreshLayout refreshLayout, int i, int i2) {
        this.mLastFirstBounds = 0.0f;
        this.mWaveView.animationDropCircle();
        this.mProgress.setAlpha(255);
        this.mProgress.start();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 0.0f);
        ofFloat.setDuration(500L);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.scwang.smartrefresh.header.WaveSwipeHeader.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ProgressAnimationImageView progressAnimationImageView = WaveSwipeHeader.this.mCircleView;
                progressAnimationImageView.setTranslationY(WaveSwipeHeader.this.mWaveView.getCurrentCircleCenterY() + (progressAnimationImageView.getHeight() / 2.0f));
            }
        });
        ofFloat.start();
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.listener.OnStateChangedListener
    public void onStateChanged(RefreshLayout refreshLayout, RefreshState refreshState, RefreshState refreshState2) {
        ProgressAnimationImageView progressAnimationImageView = this.mCircleView;
        this.mState = refreshState2;
        int i = AnonymousClass4.$SwitchMap$com$scwang$smartrefresh$layout$constant$RefreshState[refreshState2.ordinal()];
        if (i == 2) {
            this.mProgress.showArrow(true);
            progressAnimationImageView.setScaleX(1.0f);
            progressAnimationImageView.setScaleY(1.0f);
            this.mProgress.setAlpha(255);
        } else if (i != 3) {
        } else {
            this.mProgress.showArrow(false);
            this.mProgress.setProgressRotation(0.0f);
            this.mProgress.setStartEndTrim(0.0f, 0.0f);
            this.mWaveView.startWaveAnimation(this.mLastFirstBounds);
            this.mLastFirstBounds = 0.0f;
        }
    }

    /* renamed from: com.scwang.smartrefresh.header.WaveSwipeHeader$4  reason: invalid class name */
    /* loaded from: classes2.dex */
    static /* synthetic */ class AnonymousClass4 {
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
            try {
                $SwitchMap$com$scwang$smartrefresh$layout$constant$RefreshState[RefreshState.PullDownCanceled.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$scwang$smartrefresh$layout$constant$RefreshState[RefreshState.ReleaseToRefresh.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$scwang$smartrefresh$layout$constant$RefreshState[RefreshState.Refreshing.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public int onFinish(RefreshLayout refreshLayout, boolean z) {
        final ProgressAnimationImageView progressAnimationImageView = this.mCircleView;
        Animation animation = new Animation() { // from class: com.scwang.smartrefresh.header.WaveSwipeHeader.2
            @Override // android.view.animation.Animation
            public void applyTransformation(float f, Transformation transformation) {
                float f2 = 1.0f - f;
                progressAnimationImageView.setScaleX(f2);
                progressAnimationImageView.setScaleY(f2);
            }
        };
        animation.setDuration(200L);
        this.mCircleView.setAnimationListener(new Animation.AnimationListener() { // from class: com.scwang.smartrefresh.header.WaveSwipeHeader.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation2) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation2) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation2) {
                WaveSwipeHeader.this.mProgress.stop();
                WaveSwipeHeader.this.mProgress.setAlpha(255);
                WaveSwipeHeader.this.mWaveView.startDisappearCircleAnimation();
            }
        });
        progressAnimationImageView.clearAnimation();
        progressAnimationImageView.startAnimation(animation);
        return 0;
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    @Deprecated
    public void setPrimaryColors(int... iArr) {
        if (iArr.length > 0) {
            this.mWaveView.setWaveColor(iArr[0]);
            if (iArr.length > 1) {
                this.mProgress.setColorSchemeColors(iArr[1]);
            }
        }
    }

    public static boolean isOver600dp() {
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        return ((float) displayMetrics.widthPixels) / displayMetrics.density >= 600.0f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes2.dex */
    public class ProgressAnimationImageView extends ImageView {
        protected Animation.AnimationListener mListener;

        public void setAnimationListener(Animation.AnimationListener animationListener) {
            this.mListener = animationListener;
        }

        @Override // android.view.View
        public void onAnimationStart() {
            super.onAnimationStart();
            Animation.AnimationListener animationListener = this.mListener;
            if (animationListener != null) {
                animationListener.onAnimationStart(getAnimation());
            }
        }

        @Override // android.view.View
        public void onAnimationEnd() {
            super.onAnimationEnd();
            Animation.AnimationListener animationListener = this.mListener;
            if (animationListener != null) {
                animationListener.onAnimationEnd(getAnimation());
            }
        }

        public ProgressAnimationImageView(Context context) {
            super(context);
            WaveSwipeHeader.this.mProgress = new MaterialProgressDrawable(WaveSwipeHeader.this);
            WaveSwipeHeader.this.mProgress.setBackgroundColor(0);
            if (WaveSwipeHeader.isOver600dp()) {
                WaveSwipeHeader.this.mProgress.updateSizes(0);
            }
            super.setImageDrawable(WaveSwipeHeader.this.mProgress);
        }
    }
}
