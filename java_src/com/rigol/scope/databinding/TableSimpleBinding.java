package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.rigol.scope.R;
/* loaded from: classes2.dex */
public abstract class TableSimpleBinding extends ViewDataBinding {
    public final RecyclerView list;

    /* JADX INFO: Access modifiers changed from: protected */
    public TableSimpleBinding(Object obj, View view, int i, RecyclerView recyclerView) {
        super(obj, view, i);
        this.list = recyclerView;
    }

    public static TableSimpleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static TableSimpleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (TableSimpleBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.table_simple, viewGroup, z, obj);
    }

    public static TableSimpleBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static TableSimpleBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (TableSimpleBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.table_simple, null, false, obj);
    }

    public static TableSimpleBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static TableSimpleBinding bind(View view, Object obj) {
        return (TableSimpleBinding) bind(obj, view, R.layout.table_simple);
    }
}
