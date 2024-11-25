package com.scwang.smartrefresh.layout.impl;

import android.view.View;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.internal.InternalAbstract;
/* loaded from: classes2.dex */
public class RefreshFooterWrapper extends InternalAbstract implements RefreshFooter {
    public RefreshFooterWrapper(View view) {
        super(view);
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshFooter
    public boolean setNoMoreData(boolean z) {
        return (this.mWrappedInternal instanceof RefreshFooter) && ((RefreshFooter) this.mWrappedInternal).setNoMoreData(z);
    }
}
