package com.scwang.smartrefresh.header;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.scwang.smartrefresh.header.flyrefresh.MountainSceneView;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshKernel;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.header.FalsifyHeader;
import com.scwang.smartrefresh.layout.util.DensityUtil;
/* loaded from: classes2.dex */
public class FlyRefreshHeader extends FalsifyHeader implements RefreshHeader {
    protected float mCurrentPercent;
    protected AnimatorSet mFlyAnimator;
    protected View mFlyView;
    protected boolean mIsRefreshing;
    protected int mOffset;
    protected RefreshKernel mRefreshKernel;
    protected RefreshLayout mRefreshLayout;
    protected MountainSceneView mSceneView;

    public FlyRefreshHeader(Context context) {
        super(context);
        this.mOffset = 0;
        this.mIsRefreshing = false;
    }

    public FlyRefreshHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mOffset = 0;
        this.mIsRefreshing = false;
    }

    public FlyRefreshHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mOffset = 0;
        this.mIsRefreshing = false;
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public void onMoving(boolean z, float f, int i, int i2, int i3) {
        if (z || !this.mIsRefreshing) {
            if (i < 0) {
                if (this.mOffset <= 0) {
                    return;
                }
                i = 0;
                f = 0.0f;
            }
            this.mOffset = i;
            this.mCurrentPercent = f;
            MountainSceneView mountainSceneView = this.mSceneView;
            if (mountainSceneView != null) {
                mountainSceneView.updatePercent(f);
                this.mSceneView.postInvalidate();
            }
            View view = this.mFlyView;
            if (view != null) {
                int i4 = i2 + i3;
                if (i4 > 0) {
                    view.setRotation((i * (-45.0f)) / i4);
                } else {
                    view.setRotation(f * (-45.0f));
                }
            }
        }
    }

    @Override // com.scwang.smartrefresh.layout.header.FalsifyHeader, com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public void onReleased(RefreshLayout refreshLayout, int i, int i2) {
        this.mRefreshKernel.animSpinner(0);
        float f = this.mCurrentPercent;
        if (f > 0.0f) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(f, 0.0f);
            ofFloat.setDuration(300L);
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.scwang.smartrefresh.header.FlyRefreshHeader.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    FlyRefreshHeader.this.onMoving(true, ((Float) valueAnimator.getAnimatedValue()).floatValue(), 0, 0, 0);
                }
            });
            ofFloat.start();
            this.mCurrentPercent = 0.0f;
        }
        if (this.mFlyView == null || this.mIsRefreshing) {
            return;
        }
        AnimatorSet animatorSet = this.mFlyAnimator;
        if (animatorSet != null) {
            animatorSet.end();
            this.mFlyView.clearAnimation();
        }
        this.mIsRefreshing = true;
        refreshLayout.setEnableRefresh(false);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mFlyView, Key.TRANSLATION_X, 0.0f, ((View) this.mRefreshLayout).getWidth() - this.mFlyView.getLeft());
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.mFlyView, Key.TRANSLATION_Y, 0.0f, ((-(this.mFlyView.getTop() - this.mOffset)) * 2) / 3);
        ofFloat3.setInterpolator(PathInterpolatorCompat.create(0.7f, 1.0f));
        View view = this.mFlyView;
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(view, Key.ROTATION, view.getRotation(), 0.0f);
        ofFloat4.setInterpolator(new DecelerateInterpolator());
        View view2 = this.mFlyView;
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(view2, Key.ROTATION_X, view2.getRotationX(), 50.0f);
        ofFloat5.setInterpolator(new DecelerateInterpolator());
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.setDuration(800L);
        View view3 = this.mFlyView;
        float[] fArr = {view3.getScaleX(), 0.5f};
        View view4 = this.mFlyView;
        animatorSet2.playTogether(ofFloat2, ofFloat3, ofFloat4, ofFloat5, ObjectAnimator.ofFloat(view3, Key.SCALE_X, fArr), ObjectAnimator.ofFloat(view4, Key.SCALE_Y, view4.getScaleY(), 0.5f));
        this.mFlyAnimator = animatorSet2;
        animatorSet2.start();
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    @Deprecated
    public void setPrimaryColors(int... iArr) {
        MountainSceneView mountainSceneView;
        if (iArr.length <= 0 || (mountainSceneView = this.mSceneView) == null) {
            return;
        }
        mountainSceneView.setPrimaryColor(iArr[0]);
    }

    @Override // com.scwang.smartrefresh.layout.header.FalsifyHeader, com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public void onInitialized(RefreshKernel refreshKernel, int i, int i2) {
        this.mRefreshKernel = refreshKernel;
        RefreshLayout refreshLayout = refreshKernel.getRefreshLayout();
        this.mRefreshLayout = refreshLayout;
        refreshLayout.setEnableOverScrollDrag(false);
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public int onFinish(RefreshLayout refreshLayout, boolean z) {
        if (this.mIsRefreshing) {
            finishRefresh();
        }
        return super.onFinish(refreshLayout, z);
    }

    public void setUp(MountainSceneView mountainSceneView, View view) {
        this.mFlyView = view;
        this.mSceneView = mountainSceneView;
    }

    public void finishRefresh() {
        finishRefresh(null);
    }

    public void finishRefresh(final AnimatorListenerAdapter animatorListenerAdapter) {
        if (this.mFlyView == null || !this.mIsRefreshing || this.mRefreshLayout == null) {
            return;
        }
        AnimatorSet animatorSet = this.mFlyAnimator;
        if (animatorSet != null) {
            animatorSet.end();
            this.mFlyView.clearAnimation();
        }
        this.mIsRefreshing = false;
        this.mRefreshLayout.finishRefresh(0);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.setDuration(800L);
        View view = this.mFlyView;
        float f = -this.mFlyView.getRight();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, Key.TRANSLATION_X, view.getTranslationX(), f);
        View view2 = this.mFlyView;
        float f2 = -DensityUtil.dp2px(10.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view2, Key.TRANSLATION_Y, view2.getTranslationY(), f2);
        ofFloat2.setInterpolator(PathInterpolatorCompat.create(0.1f, 1.0f));
        View view3 = this.mFlyView;
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view3, Key.ROTATION, view3.getRotation(), 0.0f);
        View view4 = this.mFlyView;
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(view4, Key.ROTATION_X, view4.getRotationX(), 30.0f);
        ofFloat3.setInterpolator(new AccelerateInterpolator());
        View view5 = this.mFlyView;
        float[] fArr = {view5.getScaleX(), 0.9f};
        View view6 = this.mFlyView;
        animatorSet2.playTogether(ofFloat, ofFloat2, ofFloat3, ofFloat4, ObjectAnimator.ofFloat(view5, Key.SCALE_X, fArr), ObjectAnimator.ofFloat(view6, Key.SCALE_Y, view6.getScaleY(), 0.9f));
        animatorSet2.addListener(new AnimatorListenerAdapter() { // from class: com.scwang.smartrefresh.header.FlyRefreshHeader.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (FlyRefreshHeader.this.mFlyView != null) {
                    FlyRefreshHeader.this.mFlyView.setRotationY(180.0f);
                }
            }
        });
        AnimatorSet animatorSet3 = new AnimatorSet();
        animatorSet3.setDuration(800L);
        animatorSet3.setInterpolator(new DecelerateInterpolator());
        animatorSet3.playTogether(ObjectAnimator.ofFloat(this.mFlyView, Key.TRANSLATION_X, f, 0.0f), ObjectAnimator.ofFloat(this.mFlyView, Key.TRANSLATION_Y, f2, 0.0f), ObjectAnimator.ofFloat(this.mFlyView, Key.ROTATION_X, 30.0f, 0.0f), ObjectAnimator.ofFloat(this.mFlyView, Key.SCALE_X, 0.9f, 1.0f), ObjectAnimator.ofFloat(this.mFlyView, Key.SCALE_Y, 0.9f, 1.0f));
        animatorSet3.setStartDelay(100L);
        animatorSet3.addListener(new AnimatorListenerAdapter() { // from class: com.scwang.smartrefresh.header.FlyRefreshHeader.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (FlyRefreshHeader.this.mFlyView != null) {
                    FlyRefreshHeader.this.mFlyView.setRotationY(0.0f);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (FlyRefreshHeader.this.mRefreshLayout != null) {
                    FlyRefreshHeader.this.mRefreshLayout.setEnableRefresh(true);
                }
                AnimatorListenerAdapter animatorListenerAdapter2 = animatorListenerAdapter;
                if (animatorListenerAdapter2 != null) {
                    animatorListenerAdapter2.onAnimationEnd(animator);
                }
            }
        });
        AnimatorSet animatorSet4 = new AnimatorSet();
        this.mFlyAnimator = animatorSet4;
        animatorSet4.playSequentially(animatorSet2, animatorSet3);
        this.mFlyAnimator.start();
    }
}
