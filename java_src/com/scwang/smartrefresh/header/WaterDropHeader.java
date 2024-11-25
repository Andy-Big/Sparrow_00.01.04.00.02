package com.scwang.smartrefresh.header;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.scwang.smartrefresh.header.internal.MaterialProgressDrawable;
import com.scwang.smartrefresh.header.waterdrop.WaterDropView;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.internal.InternalAbstract;
import com.scwang.smartrefresh.layout.internal.ProgressDrawable;
import com.scwang.smartrefresh.layout.util.DensityUtil;
/* loaded from: classes2.dex */
public class WaterDropHeader extends InternalAbstract implements RefreshHeader {
    protected static final float MAX_PROGRESS_ANGLE = 0.8f;
    protected ImageView mImageView;
    protected MaterialProgressDrawable mProgress;
    protected ProgressDrawable mProgressDrawable;
    protected RefreshState mState;
    protected WaterDropView mWaterDropView;

    public WaterDropHeader(Context context) {
        this(context, null);
    }

    public WaterDropHeader(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WaterDropHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        DensityUtil densityUtil = new DensityUtil();
        this.mSpinnerStyle = SpinnerStyle.Scale;
        WaterDropView waterDropView = new WaterDropView(context);
        this.mWaterDropView = waterDropView;
        waterDropView.updateCompleteState(0);
        addView(this.mWaterDropView, -1, -1);
        ProgressDrawable progressDrawable = new ProgressDrawable();
        this.mProgressDrawable = progressDrawable;
        progressDrawable.setCallback(this);
        progressDrawable.setBounds(0, 0, densityUtil.dip2px(20.0f), densityUtil.dip2px(20.0f));
        this.mImageView = new ImageView(context);
        MaterialProgressDrawable materialProgressDrawable = new MaterialProgressDrawable(this.mImageView);
        this.mProgress = materialProgressDrawable;
        materialProgressDrawable.setBackgroundColor(-1);
        this.mProgress.setAlpha(255);
        this.mProgress.setColorSchemeColors(-1, -16737844, -48060, -10053376, -5609780, -30720);
        this.mImageView.setImageDrawable(this.mProgress);
        addView(this.mImageView, densityUtil.dip2px(30.0f), densityUtil.dip2px(30.0f));
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        ImageView imageView = this.mImageView;
        WaterDropView waterDropView = this.mWaterDropView;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
        imageView.measure(View.MeasureSpec.makeMeasureSpec(layoutParams.width, 1073741824), View.MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824));
        waterDropView.measure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), Integer.MIN_VALUE), i2);
        super.setMeasuredDimension(View.resolveSize(Math.max(imageView.getMeasuredWidth(), waterDropView.getMeasuredWidth()), i), View.resolveSize(Math.max(imageView.getMeasuredHeight(), waterDropView.getMeasuredHeight()), i2));
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        ImageView imageView = this.mImageView;
        WaterDropView waterDropView = this.mWaterDropView;
        int measuredWidth = getMeasuredWidth();
        int measuredWidth2 = waterDropView.getMeasuredWidth();
        int i5 = measuredWidth / 2;
        int i6 = measuredWidth2 / 2;
        int i7 = i5 - i6;
        waterDropView.layout(i7, 0, i7 + measuredWidth2, waterDropView.getMeasuredHeight() + 0);
        int measuredWidth3 = imageView.getMeasuredWidth();
        int measuredHeight = imageView.getMeasuredHeight();
        int i8 = measuredWidth3 / 2;
        int i9 = i5 - i8;
        int i10 = i6 - i8;
        int i11 = (measuredWidth2 - measuredWidth3) / 2;
        if (i10 + measuredHeight > waterDropView.getBottom() - i11) {
            i10 = (waterDropView.getBottom() - i11) - measuredHeight;
        }
        imageView.layout(i9, i10, measuredWidth3 + i9, measuredHeight + i10);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        WaterDropView waterDropView = this.mWaterDropView;
        ProgressDrawable progressDrawable = this.mProgressDrawable;
        if (this.mState == RefreshState.Refreshing) {
            canvas.save();
            canvas.translate((getWidth() / 2) - (progressDrawable.getBounds().width() / 2), (this.mWaterDropView.getMaxCircleRadius() + waterDropView.getPaddingTop()) - (progressDrawable.getBounds().height() / 2));
            progressDrawable.draw(canvas);
            canvas.restore();
        }
    }

    @Override // android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        invalidate();
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public void onMoving(boolean z, float f, int i, int i2, int i3) {
        if (z || (this.mState != RefreshState.Refreshing && this.mState != RefreshState.RefreshReleased)) {
            WaterDropView waterDropView = this.mWaterDropView;
            waterDropView.updateCompleteState(Math.max(i, 0), i3 + i2);
            waterDropView.postInvalidate();
        }
        if (z) {
            float f2 = i2;
            float max = (((float) Math.max(Math.min(1.0f, Math.abs((i * 1.0f) / f2)) - 0.4d, 0.0d)) * 5.0f) / 3.0f;
            double max2 = Math.max(0.0f, Math.min(Math.abs(i) - i2, f2 * 2.0f) / f2) / 4.0f;
            float f3 = max * MAX_PROGRESS_ANGLE;
            this.mProgress.showArrow(true);
            this.mProgress.setStartEndTrim(0.0f, Math.min((float) MAX_PROGRESS_ANGLE, f3));
            this.mProgress.setArrowScale(Math.min(1.0f, max));
            this.mProgress.setProgressRotation((((0.4f * max) - 0.25f) + (((float) (max2 - Math.pow(max2, 2.0d))) * 2.0f * 2.0f)) * 0.5f);
        }
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.listener.OnStateChangedListener
    public void onStateChanged(RefreshLayout refreshLayout, RefreshState refreshState, RefreshState refreshState2) {
        WaterDropView waterDropView = this.mWaterDropView;
        ImageView imageView = this.mImageView;
        this.mState = refreshState2;
        int i = AnonymousClass2.$SwitchMap$com$scwang$smartrefresh$layout$constant$RefreshState[refreshState2.ordinal()];
        if (i == 1) {
            waterDropView.setVisibility(0);
            imageView.setVisibility(0);
        } else if (i == 2) {
            waterDropView.setVisibility(0);
            imageView.setVisibility(0);
        } else if (i == 4) {
            waterDropView.setVisibility(0);
            imageView.setVisibility(0);
        } else if (i != 6) {
        } else {
            waterDropView.setVisibility(8);
            imageView.setVisibility(8);
        }
    }

    /* renamed from: com.scwang.smartrefresh.header.WaterDropHeader$2  reason: invalid class name */
    /* loaded from: classes2.dex */
    static /* synthetic */ class AnonymousClass2 {
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
            try {
                $SwitchMap$com$scwang$smartrefresh$layout$constant$RefreshState[RefreshState.RefreshFinish.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public void onReleased(RefreshLayout refreshLayout, int i, int i2) {
        ImageView imageView = this.mImageView;
        final WaterDropView waterDropView = this.mWaterDropView;
        this.mProgressDrawable.start();
        imageView.setVisibility(8);
        this.mWaterDropView.createAnimator().start();
        waterDropView.animate().setDuration(150L).alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.scwang.smartrefresh.header.WaterDropHeader.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                waterDropView.setVisibility(8);
                waterDropView.setAlpha(1.0f);
            }
        });
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public int onFinish(RefreshLayout refreshLayout, boolean z) {
        this.mProgressDrawable.stop();
        return 0;
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    @Deprecated
    public void setPrimaryColors(int... iArr) {
        if (iArr.length > 0) {
            this.mWaterDropView.setIndicatorColor(iArr[0]);
        }
    }
}
