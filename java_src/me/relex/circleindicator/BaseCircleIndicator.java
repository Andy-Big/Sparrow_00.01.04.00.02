package me.relex.circleindicator;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
/* loaded from: classes2.dex */
class BaseCircleIndicator extends LinearLayout {
    private static final int DEFAULT_INDICATOR_WIDTH = 5;
    protected Animator mAnimatorIn;
    protected Animator mAnimatorOut;
    protected Animator mImmediateAnimatorIn;
    protected Animator mImmediateAnimatorOut;
    protected int mIndicatorBackgroundResId;
    private IndicatorCreatedListener mIndicatorCreatedListener;
    protected int mIndicatorHeight;
    protected int mIndicatorMargin;
    protected ColorStateList mIndicatorTintColor;
    protected ColorStateList mIndicatorTintUnselectedColor;
    protected int mIndicatorUnselectedBackgroundResId;
    protected int mIndicatorWidth;
    protected int mLastPosition;

    /* loaded from: classes2.dex */
    public interface IndicatorCreatedListener {
        void onIndicatorCreated(View view, int i);
    }

    public BaseCircleIndicator(Context context) {
        super(context);
        this.mIndicatorMargin = -1;
        this.mIndicatorWidth = -1;
        this.mIndicatorHeight = -1;
        this.mLastPosition = -1;
        init(context, null);
    }

    public BaseCircleIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIndicatorMargin = -1;
        this.mIndicatorWidth = -1;
        this.mIndicatorHeight = -1;
        this.mLastPosition = -1;
        init(context, attributeSet);
    }

    public BaseCircleIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mIndicatorMargin = -1;
        this.mIndicatorWidth = -1;
        this.mIndicatorHeight = -1;
        this.mLastPosition = -1;
        init(context, attributeSet);
    }

    public BaseCircleIndicator(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mIndicatorMargin = -1;
        this.mIndicatorWidth = -1;
        this.mIndicatorHeight = -1;
        this.mLastPosition = -1;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        initialize(handleTypedArray(context, attributeSet));
        if (isInEditMode()) {
            createIndicators(3, 1);
        }
    }

    private Config handleTypedArray(Context context, AttributeSet attributeSet) {
        Config config = new Config();
        if (attributeSet == null) {
            return config;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BaseCircleIndicator);
        config.width = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BaseCircleIndicator_ci_width, -1);
        config.height = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BaseCircleIndicator_ci_height, -1);
        config.margin = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BaseCircleIndicator_ci_margin, -1);
        config.animatorResId = obtainStyledAttributes.getResourceId(R.styleable.BaseCircleIndicator_ci_animator, R.animator.scale_with_alpha);
        config.animatorReverseResId = obtainStyledAttributes.getResourceId(R.styleable.BaseCircleIndicator_ci_animator_reverse, 0);
        config.backgroundResId = obtainStyledAttributes.getResourceId(R.styleable.BaseCircleIndicator_ci_drawable, R.drawable.white_radius);
        config.unselectedBackgroundId = obtainStyledAttributes.getResourceId(R.styleable.BaseCircleIndicator_ci_drawable_unselected, config.backgroundResId);
        config.orientation = obtainStyledAttributes.getInt(R.styleable.BaseCircleIndicator_ci_orientation, -1);
        config.gravity = obtainStyledAttributes.getInt(R.styleable.BaseCircleIndicator_ci_gravity, -1);
        obtainStyledAttributes.recycle();
        return config;
    }

    public void initialize(Config config) {
        int applyDimension = (int) (TypedValue.applyDimension(1, 5.0f, getResources().getDisplayMetrics()) + 0.5f);
        this.mIndicatorWidth = config.width < 0 ? applyDimension : config.width;
        this.mIndicatorHeight = config.height < 0 ? applyDimension : config.height;
        if (config.margin >= 0) {
            applyDimension = config.margin;
        }
        this.mIndicatorMargin = applyDimension;
        this.mAnimatorOut = createAnimatorOut(config);
        Animator createAnimatorOut = createAnimatorOut(config);
        this.mImmediateAnimatorOut = createAnimatorOut;
        createAnimatorOut.setDuration(0L);
        this.mAnimatorIn = createAnimatorIn(config);
        Animator createAnimatorIn = createAnimatorIn(config);
        this.mImmediateAnimatorIn = createAnimatorIn;
        createAnimatorIn.setDuration(0L);
        this.mIndicatorBackgroundResId = config.backgroundResId == 0 ? R.drawable.white_radius : config.backgroundResId;
        this.mIndicatorUnselectedBackgroundResId = config.unselectedBackgroundId == 0 ? config.backgroundResId : config.unselectedBackgroundId;
        setOrientation(config.orientation != 1 ? 0 : 1);
        setGravity(config.gravity >= 0 ? config.gravity : 17);
    }

    public void tintIndicator(int i) {
        tintIndicator(i, i);
    }

    public void tintIndicator(int i, int i2) {
        this.mIndicatorTintColor = ColorStateList.valueOf(i);
        this.mIndicatorTintUnselectedColor = ColorStateList.valueOf(i2);
        changeIndicatorBackground();
    }

    public void changeIndicatorResource(int i) {
        changeIndicatorResource(i, i);
    }

    public void changeIndicatorResource(int i, int i2) {
        this.mIndicatorBackgroundResId = i;
        this.mIndicatorUnselectedBackgroundResId = i2;
        changeIndicatorBackground();
    }

    public void setIndicatorCreatedListener(IndicatorCreatedListener indicatorCreatedListener) {
        this.mIndicatorCreatedListener = indicatorCreatedListener;
    }

    protected Animator createAnimatorOut(Config config) {
        return AnimatorInflater.loadAnimator(getContext(), config.animatorResId);
    }

    protected Animator createAnimatorIn(Config config) {
        if (config.animatorReverseResId == 0) {
            Animator loadAnimator = AnimatorInflater.loadAnimator(getContext(), config.animatorResId);
            loadAnimator.setInterpolator(new ReverseInterpolator());
            return loadAnimator;
        }
        return AnimatorInflater.loadAnimator(getContext(), config.animatorReverseResId);
    }

    public void createIndicators(int i, int i2) {
        if (this.mImmediateAnimatorOut.isRunning()) {
            this.mImmediateAnimatorOut.end();
            this.mImmediateAnimatorOut.cancel();
        }
        if (this.mImmediateAnimatorIn.isRunning()) {
            this.mImmediateAnimatorIn.end();
            this.mImmediateAnimatorIn.cancel();
        }
        int childCount = getChildCount();
        if (i < childCount) {
            removeViews(i, childCount - i);
        } else if (i > childCount) {
            int i3 = i - childCount;
            int orientation = getOrientation();
            for (int i4 = 0; i4 < i3; i4++) {
                addIndicator(orientation);
            }
        }
        for (int i5 = 0; i5 < i; i5++) {
            View childAt = getChildAt(i5);
            if (i2 == i5) {
                bindIndicatorBackground(childAt, this.mIndicatorBackgroundResId, this.mIndicatorTintColor);
                this.mImmediateAnimatorOut.setTarget(childAt);
                this.mImmediateAnimatorOut.start();
                this.mImmediateAnimatorOut.end();
            } else {
                bindIndicatorBackground(childAt, this.mIndicatorUnselectedBackgroundResId, this.mIndicatorTintUnselectedColor);
                this.mImmediateAnimatorIn.setTarget(childAt);
                this.mImmediateAnimatorIn.start();
                this.mImmediateAnimatorIn.end();
            }
            IndicatorCreatedListener indicatorCreatedListener = this.mIndicatorCreatedListener;
            if (indicatorCreatedListener != null) {
                indicatorCreatedListener.onIndicatorCreated(childAt, i5);
            }
        }
        this.mLastPosition = i2;
    }

    protected void addIndicator(int i) {
        View view = new View(getContext());
        LinearLayout.LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
        generateDefaultLayoutParams.width = this.mIndicatorWidth;
        generateDefaultLayoutParams.height = this.mIndicatorHeight;
        if (i == 0) {
            generateDefaultLayoutParams.leftMargin = this.mIndicatorMargin;
            generateDefaultLayoutParams.rightMargin = this.mIndicatorMargin;
        } else {
            generateDefaultLayoutParams.topMargin = this.mIndicatorMargin;
            generateDefaultLayoutParams.bottomMargin = this.mIndicatorMargin;
        }
        addView(view, generateDefaultLayoutParams);
    }

    public void animatePageSelected(int i) {
        View childAt;
        if (this.mLastPosition == i) {
            return;
        }
        if (this.mAnimatorIn.isRunning()) {
            this.mAnimatorIn.end();
            this.mAnimatorIn.cancel();
        }
        if (this.mAnimatorOut.isRunning()) {
            this.mAnimatorOut.end();
            this.mAnimatorOut.cancel();
        }
        int i2 = this.mLastPosition;
        if (i2 >= 0 && (childAt = getChildAt(i2)) != null) {
            bindIndicatorBackground(childAt, this.mIndicatorUnselectedBackgroundResId, this.mIndicatorTintUnselectedColor);
            this.mAnimatorIn.setTarget(childAt);
            this.mAnimatorIn.start();
        }
        View childAt2 = getChildAt(i);
        if (childAt2 != null) {
            bindIndicatorBackground(childAt2, this.mIndicatorBackgroundResId, this.mIndicatorTintColor);
            this.mAnimatorOut.setTarget(childAt2);
            this.mAnimatorOut.start();
        }
        this.mLastPosition = i;
    }

    protected void changeIndicatorBackground() {
        int childCount = getChildCount();
        if (childCount <= 0) {
            return;
        }
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (i == this.mLastPosition) {
                bindIndicatorBackground(childAt, this.mIndicatorBackgroundResId, this.mIndicatorTintColor);
            } else {
                bindIndicatorBackground(childAt, this.mIndicatorUnselectedBackgroundResId, this.mIndicatorTintUnselectedColor);
            }
        }
    }

    private void bindIndicatorBackground(View view, int i, ColorStateList colorStateList) {
        if (colorStateList != null) {
            Drawable wrap = DrawableCompat.wrap(ContextCompat.getDrawable(getContext(), i).mutate());
            DrawableCompat.setTintList(wrap, colorStateList);
            ViewCompat.setBackground(view, wrap);
            return;
        }
        view.setBackgroundResource(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes2.dex */
    public static class ReverseInterpolator implements Interpolator {
        protected ReverseInterpolator() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            return Math.abs(1.0f - f);
        }
    }
}
