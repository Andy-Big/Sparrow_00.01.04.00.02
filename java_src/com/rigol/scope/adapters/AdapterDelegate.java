package com.rigol.scope.adapters;

import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;

/* loaded from: classes.dex */
public abstract class AdapterDelegate<T> {
    protected abstract boolean isForViewType(T t, int i);

    protected abstract void onBindViewHolder(T t, int i, BaseViewHolder<? extends ViewDataBinding> baseViewHolder);

    protected abstract BaseViewHolder<? extends ViewDataBinding> onCreateViewHolder(ViewGroup viewGroup);
}
