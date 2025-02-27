package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;

/* loaded from: classes2.dex */
public abstract class AdapterItemResultItemBinding extends ViewDataBinding {
    public final TextView text;

    protected AdapterItemResultItemBinding(Object obj, View view, int i, TextView textView) {
        super(obj, view, i);
        this.text = textView;
    }

    public static AdapterItemResultItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterItemResultItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterItemResultItemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_item_result_item, viewGroup, z, obj);
    }

    public static AdapterItemResultItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterItemResultItemBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterItemResultItemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_item_result_item, null, false, obj);
    }

    public static AdapterItemResultItemBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterItemResultItemBinding bind(View view, Object obj) {
        return (AdapterItemResultItemBinding) bind(obj, view, R.layout.adapter_item_result_item);
    }
}
