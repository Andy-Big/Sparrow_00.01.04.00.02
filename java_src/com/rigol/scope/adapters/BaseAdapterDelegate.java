package com.rigol.scope.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
/* loaded from: classes.dex */
public abstract class BaseAdapterDelegate<T> extends AdapterDelegate<T> {
    private final int layoutId;

    public BaseAdapterDelegate(int i) {
        this.layoutId = i;
    }

    public int getLayoutId() {
        return this.layoutId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rigol.scope.adapters.AdapterDelegate
    public BaseViewHolder<? extends ViewDataBinding> onCreateViewHolder(ViewGroup viewGroup) {
        return new BaseViewHolder<>(DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), this.layoutId, viewGroup, false));
    }
}
