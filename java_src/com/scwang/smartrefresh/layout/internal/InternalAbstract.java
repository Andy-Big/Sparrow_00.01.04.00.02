package com.scwang.smartrefresh.layout.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshInternal;
import com.scwang.smartrefresh.layout.api.RefreshKernel;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.impl.RefreshFooterWrapper;
import com.scwang.smartrefresh.layout.impl.RefreshHeaderWrapper;
/* loaded from: classes2.dex */
public abstract class InternalAbstract extends RelativeLayout implements RefreshInternal {
    protected SpinnerStyle mSpinnerStyle;
    protected RefreshInternal mWrappedInternal;
    protected View mWrappedView;

    /* JADX INFO: Access modifiers changed from: protected */
    public InternalAbstract(View view) {
        this(view, view instanceof RefreshInternal ? (RefreshInternal) view : null);
    }

    protected InternalAbstract(View view, RefreshInternal refreshInternal) {
        super(view.getContext(), null, 0);
        this.mWrappedView = view;
        this.mWrappedInternal = refreshInternal;
        if ((this instanceof RefreshFooterWrapper) && (refreshInternal instanceof RefreshHeader) && refreshInternal.getSpinnerStyle() == SpinnerStyle.MatchLayout) {
            refreshInternal.getView().setScaleY(-1.0f);
        } else if (this instanceof RefreshHeaderWrapper) {
            RefreshInternal refreshInternal2 = this.mWrappedInternal;
            if ((refreshInternal2 instanceof RefreshFooter) && refreshInternal2.getSpinnerStyle() == SpinnerStyle.MatchLayout) {
                refreshInternal.getView().setScaleY(-1.0f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public InternalAbstract(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            return true;
        }
        return (obj instanceof RefreshInternal) && getView() == ((RefreshInternal) obj).getView();
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshInternal
    public View getView() {
        View view = this.mWrappedView;
        return view == null ? this : view;
    }

    public int onFinish(RefreshLayout refreshLayout, boolean z) {
        RefreshInternal refreshInternal = this.mWrappedInternal;
        if (refreshInternal == null || refreshInternal == this) {
            return 0;
        }
        return refreshInternal.onFinish(refreshLayout, z);
    }

    public void setPrimaryColors(int... iArr) {
        RefreshInternal refreshInternal = this.mWrappedInternal;
        if (refreshInternal == null || refreshInternal == this) {
            return;
        }
        refreshInternal.setPrimaryColors(iArr);
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshInternal
    public SpinnerStyle getSpinnerStyle() {
        SpinnerStyle spinnerStyle = this.mSpinnerStyle;
        if (spinnerStyle != null) {
            return spinnerStyle;
        }
        RefreshInternal refreshInternal = this.mWrappedInternal;
        if (refreshInternal != null && refreshInternal != this) {
            return refreshInternal.getSpinnerStyle();
        }
        View view = this.mWrappedView;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof SmartRefreshLayout.LayoutParams) {
                SpinnerStyle spinnerStyle2 = ((SmartRefreshLayout.LayoutParams) layoutParams).spinnerStyle;
                this.mSpinnerStyle = spinnerStyle2;
                if (spinnerStyle2 != null) {
                    return spinnerStyle2;
                }
            }
            if (layoutParams != null && (layoutParams.height == 0 || layoutParams.height == -1)) {
                SpinnerStyle spinnerStyle3 = SpinnerStyle.Scale;
                this.mSpinnerStyle = spinnerStyle3;
                return spinnerStyle3;
            }
        }
        SpinnerStyle spinnerStyle4 = SpinnerStyle.Translate;
        this.mSpinnerStyle = spinnerStyle4;
        return spinnerStyle4;
    }

    public void onInitialized(RefreshKernel refreshKernel, int i, int i2) {
        RefreshInternal refreshInternal = this.mWrappedInternal;
        if (refreshInternal != null && refreshInternal != this) {
            refreshInternal.onInitialized(refreshKernel, i, i2);
            return;
        }
        View view = this.mWrappedView;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof SmartRefreshLayout.LayoutParams) {
                refreshKernel.requestDrawBackgroundFor(this, ((SmartRefreshLayout.LayoutParams) layoutParams).backgroundColor);
            }
        }
    }

    public boolean isSupportHorizontalDrag() {
        RefreshInternal refreshInternal = this.mWrappedInternal;
        return (refreshInternal == null || refreshInternal == this || !refreshInternal.isSupportHorizontalDrag()) ? false : true;
    }

    public void onHorizontalDrag(float f, int i, int i2) {
        RefreshInternal refreshInternal = this.mWrappedInternal;
        if (refreshInternal == null || refreshInternal == this) {
            return;
        }
        refreshInternal.onHorizontalDrag(f, i, i2);
    }

    public void onMoving(boolean z, float f, int i, int i2, int i3) {
        RefreshInternal refreshInternal = this.mWrappedInternal;
        if (refreshInternal == null || refreshInternal == this) {
            return;
        }
        refreshInternal.onMoving(z, f, i, i2, i3);
    }

    public void onReleased(RefreshLayout refreshLayout, int i, int i2) {
        RefreshInternal refreshInternal = this.mWrappedInternal;
        if (refreshInternal == null || refreshInternal == this) {
            return;
        }
        refreshInternal.onReleased(refreshLayout, i, i2);
    }

    public void onStartAnimator(RefreshLayout refreshLayout, int i, int i2) {
        RefreshInternal refreshInternal = this.mWrappedInternal;
        if (refreshInternal == null || refreshInternal == this) {
            return;
        }
        refreshInternal.onStartAnimator(refreshLayout, i, i2);
    }

    public void onStateChanged(RefreshLayout refreshLayout, RefreshState refreshState, RefreshState refreshState2) {
        RefreshInternal refreshInternal = this.mWrappedInternal;
        if (refreshInternal == null || refreshInternal == this) {
            return;
        }
        if ((this instanceof RefreshFooterWrapper) && (refreshInternal instanceof RefreshHeader)) {
            if (refreshState.isFooter) {
                refreshState = refreshState.toHeader();
            }
            if (refreshState2.isFooter) {
                refreshState2 = refreshState2.toHeader();
            }
        } else if ((this instanceof RefreshHeaderWrapper) && (this.mWrappedInternal instanceof RefreshFooter)) {
            if (refreshState.isHeader) {
                refreshState = refreshState.toFooter();
            }
            if (refreshState2.isHeader) {
                refreshState2 = refreshState2.toFooter();
            }
        }
        RefreshInternal refreshInternal2 = this.mWrappedInternal;
        if (refreshInternal2 != null) {
            refreshInternal2.onStateChanged(refreshLayout, refreshState, refreshState2);
        }
    }
}
