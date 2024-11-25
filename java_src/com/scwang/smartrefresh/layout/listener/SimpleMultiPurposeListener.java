package com.scwang.smartrefresh.layout.listener;

import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
/* loaded from: classes2.dex */
public class SimpleMultiPurposeListener implements OnMultiPurposeListener {
    @Override // com.scwang.smartrefresh.layout.listener.OnMultiPurposeListener
    public void onFooterFinish(RefreshFooter refreshFooter, boolean z) {
    }

    @Override // com.scwang.smartrefresh.layout.listener.OnMultiPurposeListener
    public void onFooterMoving(RefreshFooter refreshFooter, boolean z, float f, int i, int i2, int i3) {
    }

    @Override // com.scwang.smartrefresh.layout.listener.OnMultiPurposeListener
    public void onFooterReleased(RefreshFooter refreshFooter, int i, int i2) {
    }

    @Override // com.scwang.smartrefresh.layout.listener.OnMultiPurposeListener
    public void onFooterStartAnimator(RefreshFooter refreshFooter, int i, int i2) {
    }

    @Override // com.scwang.smartrefresh.layout.listener.OnMultiPurposeListener
    public void onHeaderFinish(RefreshHeader refreshHeader, boolean z) {
    }

    @Override // com.scwang.smartrefresh.layout.listener.OnMultiPurposeListener
    public void onHeaderMoving(RefreshHeader refreshHeader, boolean z, float f, int i, int i2, int i3) {
    }

    @Override // com.scwang.smartrefresh.layout.listener.OnMultiPurposeListener
    public void onHeaderReleased(RefreshHeader refreshHeader, int i, int i2) {
    }

    @Override // com.scwang.smartrefresh.layout.listener.OnMultiPurposeListener
    public void onHeaderStartAnimator(RefreshHeader refreshHeader, int i, int i2) {
    }

    @Override // com.scwang.smartrefresh.layout.listener.OnLoadMoreListener
    public void onLoadMore(RefreshLayout refreshLayout) {
    }

    @Override // com.scwang.smartrefresh.layout.listener.OnRefreshListener
    public void onRefresh(RefreshLayout refreshLayout) {
    }

    @Override // com.scwang.smartrefresh.layout.listener.OnStateChangedListener
    public void onStateChanged(RefreshLayout refreshLayout, RefreshState refreshState, RefreshState refreshState2) {
    }
}
