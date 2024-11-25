package com.rigol.scope.adapters;

import android.view.ViewGroup;
import androidx.collection.SparseArrayCompat;
import androidx.databinding.ViewDataBinding;
/* loaded from: classes.dex */
public class AdapterDelegatesManager<T> {
    SparseArrayCompat<AdapterDelegate<T>> delegates = new SparseArrayCompat<>();

    public SparseArrayCompat<AdapterDelegate<T>> getDelegates() {
        return this.delegates;
    }

    public AdapterDelegatesManager<T> addDelegate(AdapterDelegate<T> adapterDelegate) {
        int size = this.delegates.size();
        while (this.delegates.get(size) != null) {
            size++;
        }
        this.delegates.put(size, adapterDelegate);
        return this;
    }

    public int getItemViewType(T t, int i) {
        int size = this.delegates.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.delegates.valueAt(i2).isForViewType(t, i)) {
                return this.delegates.keyAt(i2);
            }
        }
        throw new IllegalArgumentException("No AdapterDelegate added that matches position=" + i + " in data source");
    }

    public BaseViewHolder<? extends ViewDataBinding> onCreateViewHolder(ViewGroup viewGroup, int i) {
        AdapterDelegate<T> adapterDelegate = this.delegates.get(i);
        if (adapterDelegate == null) {
            throw new NullPointerException("No AdapterDelegateBinding added for ViewType " + i);
        }
        BaseViewHolder<? extends ViewDataBinding> onCreateViewHolder = adapterDelegate.onCreateViewHolder(viewGroup);
        if (onCreateViewHolder != null) {
            return onCreateViewHolder;
        }
        throw new NullPointerException("ViewHolder returned from AdapterDelegateBinding " + adapterDelegate + " for ViewType =" + i + " is null!");
    }

    public void onBindViewHolder(T t, int i, BaseViewHolder<? extends ViewDataBinding> baseViewHolder) {
        AdapterDelegate<T> adapterDelegate = this.delegates.get(baseViewHolder.getItemViewType());
        if (adapterDelegate == null) {
            throw new NullPointerException("No delegate found for item at position = " + i + " for viewType = " + baseViewHolder.getItemViewType());
        }
        adapterDelegate.onBindViewHolder(t, i, baseViewHolder);
    }
}
