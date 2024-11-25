package com.scwang.smartrefresh.layout.api;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnMultiPurposeListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
/* loaded from: classes2.dex */
public interface RefreshLayout {
    boolean autoLoadMore();

    @Deprecated
    boolean autoLoadMore(int i);

    boolean autoLoadMore(int i, int i2, float f, boolean z);

    boolean autoLoadMoreAnimationOnly();

    boolean autoRefresh();

    @Deprecated
    boolean autoRefresh(int i);

    boolean autoRefresh(int i, int i2, float f, boolean z);

    boolean autoRefreshAnimationOnly();

    RefreshLayout closeHeaderOrFooter();

    RefreshLayout finishLoadMore();

    RefreshLayout finishLoadMore(int i);

    RefreshLayout finishLoadMore(int i, boolean z, boolean z2);

    RefreshLayout finishLoadMore(boolean z);

    RefreshLayout finishLoadMoreWithNoMoreData();

    RefreshLayout finishRefresh();

    RefreshLayout finishRefresh(int i);

    RefreshLayout finishRefresh(int i, boolean z);

    RefreshLayout finishRefresh(boolean z);

    ViewGroup getLayout();

    RefreshFooter getRefreshFooter();

    RefreshHeader getRefreshHeader();

    RefreshState getState();

    RefreshLayout resetNoMoreData();

    RefreshLayout setDisableContentWhenLoading(boolean z);

    RefreshLayout setDisableContentWhenRefresh(boolean z);

    RefreshLayout setDragRate(float f);

    RefreshLayout setEnableAutoLoadMore(boolean z);

    RefreshLayout setEnableClipFooterWhenFixedBehind(boolean z);

    RefreshLayout setEnableClipHeaderWhenFixedBehind(boolean z);

    @Deprecated
    RefreshLayout setEnableFooterFollowWhenLoadFinished(boolean z);

    RefreshLayout setEnableFooterFollowWhenNoMoreData(boolean z);

    RefreshLayout setEnableFooterTranslationContent(boolean z);

    RefreshLayout setEnableHeaderTranslationContent(boolean z);

    RefreshLayout setEnableLoadMore(boolean z);

    RefreshLayout setEnableLoadMoreWhenContentNotFull(boolean z);

    RefreshLayout setEnableNestedScroll(boolean z);

    RefreshLayout setEnableOverScrollBounce(boolean z);

    RefreshLayout setEnableOverScrollDrag(boolean z);

    RefreshLayout setEnablePureScrollMode(boolean z);

    RefreshLayout setEnableRefresh(boolean z);

    RefreshLayout setEnableScrollContentWhenLoaded(boolean z);

    RefreshLayout setEnableScrollContentWhenRefreshed(boolean z);

    RefreshLayout setFooterHeight(float f);

    RefreshLayout setFooterInsetStart(float f);

    RefreshLayout setFooterMaxDragRate(float f);

    RefreshLayout setFooterTriggerRate(float f);

    RefreshLayout setHeaderHeight(float f);

    RefreshLayout setHeaderInsetStart(float f);

    RefreshLayout setHeaderMaxDragRate(float f);

    RefreshLayout setHeaderTriggerRate(float f);

    RefreshLayout setNoMoreData(boolean z);

    RefreshLayout setOnLoadMoreListener(OnLoadMoreListener onLoadMoreListener);

    RefreshLayout setOnMultiPurposeListener(OnMultiPurposeListener onMultiPurposeListener);

    RefreshLayout setOnRefreshListener(OnRefreshListener onRefreshListener);

    RefreshLayout setOnRefreshLoadMoreListener(OnRefreshLoadMoreListener onRefreshLoadMoreListener);

    RefreshLayout setPrimaryColors(int... iArr);

    RefreshLayout setPrimaryColorsId(int... iArr);

    RefreshLayout setReboundDuration(int i);

    RefreshLayout setReboundInterpolator(Interpolator interpolator);

    RefreshLayout setRefreshContent(View view);

    RefreshLayout setRefreshContent(View view, int i, int i2);

    RefreshLayout setRefreshFooter(RefreshFooter refreshFooter);

    RefreshLayout setRefreshFooter(RefreshFooter refreshFooter, int i, int i2);

    RefreshLayout setRefreshHeader(RefreshHeader refreshHeader);

    RefreshLayout setRefreshHeader(RefreshHeader refreshHeader, int i, int i2);

    RefreshLayout setScrollBoundaryDecider(ScrollBoundaryDecider scrollBoundaryDecider);
}
