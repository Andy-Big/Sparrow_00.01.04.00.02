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
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r17) {
        /*
            r16 = this;
            r0 = r16
            com.scwang.smartrefresh.layout.constant.RefreshState r1 = r0.mState
            com.scwang.smartrefresh.layout.constant.RefreshState r2 = com.scwang.smartrefresh.layout.constant.RefreshState.Refreshing
            if (r1 == r2) goto L14
            com.scwang.smartrefresh.layout.constant.RefreshState r1 = r0.mState
            com.scwang.smartrefresh.layout.constant.RefreshState r2 = com.scwang.smartrefresh.layout.constant.RefreshState.RefreshFinish
            if (r1 != r2) goto Lf
            goto L14
        Lf:
            boolean r1 = super.onTouchEvent(r17)
            return r1
        L14:
            boolean r1 = r0.mManualOperation
            if (r1 != 0) goto L1b
            r16.onManualOperationStart()
        L1b:
            int r1 = r17.getAction()
            r1 = r1 & 255(0xff, float:3.57E-43)
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L81
            if (r1 == r3) goto L6e
            r4 = 3
            r5 = 2
            if (r1 == r5) goto L2e
            if (r1 == r4) goto L6e
            goto L8c
        L2e:
            float r1 = r17.getRawY()
            float r6 = r0.mTouchY
            float r1 = r1 - r6
            r6 = 0
            int r6 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r6 < 0) goto L68
            int r6 = r0.mHeaderHeight
            int r6 = r6 * r5
            double r6 = (double) r6
            int r8 = r0.mScreenHeightPixels
            int r8 = r8 * r5
            int r8 = r8 / r4
            double r4 = (double) r8
            r8 = 0
            double r10 = (double) r1
            r12 = 4602678819172646912(0x3fe0000000000000, double:0.5)
            double r10 = r10 * r12
            double r8 = java.lang.Math.max(r8, r10)
            r10 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            r12 = 4636737291354636288(0x4059000000000000, double:100.0)
            double r14 = -r8
            double r14 = r14 / r4
            double r4 = java.lang.Math.pow(r12, r14)
            double r10 = r10 - r4
            double r6 = r6 * r10
            double r4 = java.lang.Math.min(r6, r8)
            com.scwang.smartrefresh.layout.api.RefreshKernel r1 = r0.mRefreshKernel
            int r4 = (int) r4
            int r4 = java.lang.Math.max(r3, r4)
            r1.moveSpinner(r4, r2)
            goto L8c
        L68:
            com.scwang.smartrefresh.layout.api.RefreshKernel r1 = r0.mRefreshKernel
            r1.moveSpinner(r3, r2)
            goto L8c
        L6e:
            r16.onManualOperationRelease()
            r1 = -1082130432(0xffffffffbf800000, float:-1.0)
            r0.mTouchY = r1
            boolean r1 = r0.mIsFinish
            if (r1 == 0) goto L8c
            com.scwang.smartrefresh.layout.api.RefreshKernel r1 = r0.mRefreshKernel
            int r2 = r0.mHeaderHeight
            r1.moveSpinner(r2, r3)
            goto L8c
        L81:
            float r1 = r17.getRawY()
            r0.mTouchY = r1
            com.scwang.smartrefresh.layout.api.RefreshKernel r1 = r0.mRefreshKernel
            r1.moveSpinner(r2, r3)
        L8c:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scwang.smartrefresh.header.fungame.FunGameBase.onTouchEvent(android.view.MotionEvent):boolean");
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
