package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
/* loaded from: classes2.dex */
public abstract class AdapterItemResultTableContentBinding extends ViewDataBinding {
    public final TextView content;

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterItemResultTableContentBinding(Object obj, View view, int i, TextView textView) {
        super(obj, view, i);
        this.content = textView;
    }

    public static AdapterItemResultTableContentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterItemResultTableContentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterItemResultTableContentBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_item_result_table_content, viewGroup, z, obj);
    }

    public static AdapterItemResultTableContentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterItemResultTableContentBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterItemResultTableContentBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_item_result_table_content, null, false, obj);
    }

    public static AdapterItemResultTableContentBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterItemResultTableContentBinding bind(View view, Object obj) {
        return (AdapterItemResultTableContentBinding) bind(obj, view, R.layout.adapter_item_result_table_content);
    }
}
