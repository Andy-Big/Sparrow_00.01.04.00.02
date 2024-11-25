package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.rigol.scope.R;
/* loaded from: classes2.dex */
public abstract class AdapterItemRecyclerviewBinding extends ViewDataBinding {
    public final RecyclerView recyclerView;

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterItemRecyclerviewBinding(Object obj, View view, int i, RecyclerView recyclerView) {
        super(obj, view, i);
        this.recyclerView = recyclerView;
    }

    public static AdapterItemRecyclerviewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterItemRecyclerviewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterItemRecyclerviewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_item_recyclerview, viewGroup, z, obj);
    }

    public static AdapterItemRecyclerviewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterItemRecyclerviewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterItemRecyclerviewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_item_recyclerview, null, false, obj);
    }

    public static AdapterItemRecyclerviewBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterItemRecyclerviewBinding bind(View view, Object obj) {
        return (AdapterItemRecyclerviewBinding) bind(obj, view, R.layout.adapter_item_recyclerview);
    }
}
