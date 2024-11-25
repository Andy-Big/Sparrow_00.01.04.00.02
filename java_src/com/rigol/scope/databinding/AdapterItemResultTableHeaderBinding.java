package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
/* loaded from: classes2.dex */
public abstract class AdapterItemResultTableHeaderBinding extends ViewDataBinding {
    public final TextView text;

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterItemResultTableHeaderBinding(Object obj, View view, int i, TextView textView) {
        super(obj, view, i);
        this.text = textView;
    }

    public static AdapterItemResultTableHeaderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterItemResultTableHeaderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterItemResultTableHeaderBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_item_result_table_header, viewGroup, z, obj);
    }

    public static AdapterItemResultTableHeaderBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterItemResultTableHeaderBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterItemResultTableHeaderBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_item_result_table_header, null, false, obj);
    }

    public static AdapterItemResultTableHeaderBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterItemResultTableHeaderBinding bind(View view, Object obj) {
        return (AdapterItemResultTableHeaderBinding) bind(obj, view, R.layout.adapter_item_result_table_header);
    }
}
