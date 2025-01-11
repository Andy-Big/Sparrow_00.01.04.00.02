package com.scwang.smartrefresh.header.fungame;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.scwang.smartrefresh.layout.api.RefreshContent;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshKernel;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.internal.InternalAbstract;
import com.scwang.smartrefresh.layout.util.DensityUtil;

/* loaded from: classes2.dex */
public abstract class FunGameBase extends InternalAbstract implements RefreshHeader {
    protected int mHeaderHeight;
    protected boolean mIsFinish;
    protected boolean mLastFinish;
    protected boolean mManualOperation;
    protected int mOffset;
    protected RefreshContent mRefreshContent;
    protected RefreshKernel mRefreshKernel;
    protected int mScreenHeightPixels;
    protected RefreshState mState;
    protected float mTouchY;

    protected abstract void onManualOperationMove(float f, int i, int i2, int i3);

    public FunGameBase(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setMinimumHeight(DensityUtil.dp2px(100.0f));
        this.mScreenHeightPixels = getResources().getDisplayMetrics().heightPixels;
        this.mSpinnerStyle = SpinnerStyle.MatchLayout;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.mState == RefreshState.Refreshing || super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x002b, code lost:
        if (r1 != 3) goto L17;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mState == RefreshState.Refreshing || this.mState == RefreshState.RefreshFinish) {
            if (!this.mManualOperation) {
                onManualOperationStart();
            }
            int action = motionEvent.getAction() & 255;
            if (action == 0) {
                this.mTouchY = motionEvent.getRawY();
                this.mRefreshKernel.moveSpinner(0, true);
            } else {
                if (action != 1) {
                    if (action == 2) {
                        float rawY = motionEvent.getRawY() - this.mTouchY;
                        if (rawY >= 0.0f) {
                            double d = (this.mScreenHeightPixels * 2) / 3;
                            double max = Math.max(0.0d, rawY * 0.5d);
                            this.mRefreshKernel.moveSpinner(Math.max(1, (int) Math.min(this.mHeaderHeight * 2 * (1.0d - Math.pow(100.0d, (-max) / d)), max)), false);
                        } else {
                            this.mRefreshKernel.moveSpinner(1, false);
                        }
                    }
                }
                onManualOperationRelease();
                this.mTouchY = -1.0f;
                if (this.mIsFinish) {
                    this.mRefreshKernel.moveSpinner(this.mHeaderHeight, true);
                }
            }
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    protected void onManualOperationStart() {
        if (this.mManualOperation) {
            return;
        }
        this.mManualOperation = true;
        RefreshContent refreshContent = this.mRefreshKernel.getRefreshContent();
        this.mRefreshContent = refreshContent;
        View view = refreshContent.getView();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        marginLayoutParams.topMargin += this.mHeaderHeight;
        view.setLayoutParams(marginLayoutParams);
    }

    protected void onManualOperationRelease() {
        if (this.mIsFinish) {
            this.mManualOperation = false;
            if (this.mTouchY != -1.0f) {
                onFinish(this.mRefreshKernel.getRefreshLayout(), this.mLastFinish);
                this.mRefreshKernel.setState(RefreshState.RefreshFinish);
                this.mRefreshKernel.animSpinner(0);
            } else {
                this.mRefreshKernel.moveSpinner(this.mHeaderHeight, true);
            }
            View view = this.mRefreshContent.getView();
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            marginLayoutParams.topMargin -= this.mHeaderHeight;
            view.setLayoutParams(marginLayoutParams);
            return;
        }
        this.mRefreshKernel.moveSpinner(0, true);
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public void onMoving(boolean z, float f, int i, int i2, int i3) {
        if (this.mManualOperation) {
            onManualOperationMove(f, i, i2, i3);
            return;
        }
        this.mOffset = i;
        setTranslationY(i - this.mHeaderHeight);
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public void onStartAnimator(RefreshLayout refreshLayout, int i, int i2) {
        this.mIsFinish = false;
        setTranslationY(0.0f);
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.listener.OnStateChangedListener
    public void onStateChanged(RefreshLayout refreshLayout, RefreshState refreshState, RefreshState refreshState2) {
        this.mState = refreshState2;
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public void onInitialized(RefreshKernel refreshKernel, int i, int i2) {
        this.mRefreshKernel = refreshKernel;
        this.mHeaderHeight = i;
        if (isInEditMode()) {
            return;
        }
        setTranslationY(this.mOffset - this.mHeaderHeight);
        refreshKernel.requestNeedTouchEventFor(this, true);
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public int onFinish(RefreshLayout refreshLayout, boolean z) {
        this.mLastFinish = z;
        if (!this.mIsFinish) {
            this.mIsFinish = true;
            if (this.mManualOperation) {
                if (this.mTouchY == -1.0f) {
                    onManualOperationRelease();
                    onFinish(refreshLayout, z);
                    return 0;
                }
                return Integer.MAX_VALUE;
            }
        }
        return 0;
    }
}
