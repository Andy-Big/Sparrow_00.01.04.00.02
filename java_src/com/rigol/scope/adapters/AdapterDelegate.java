package com.rigol.scope.adapters;

import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
/* loaded from: classes.dex */
public abstract class AdapterDelegate<T> {
    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean isForViewType(T t, int i);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void onBindViewHolder(T t, int i, BaseViewHolder<? extends ViewDataBinding> baseViewHolder);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract BaseViewHolder<? extends ViewDataBinding> onCreateViewHolder(ViewGroup viewGroup);
}
