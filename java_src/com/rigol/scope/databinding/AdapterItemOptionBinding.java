package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
/* loaded from: classes2.dex */
public abstract class AdapterItemOptionBinding extends ViewDataBinding {
    public final TextView index;
    public final TextView text1;
    public final TextView text2;

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterItemOptionBinding(Object obj, View view, int i, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.index = textView;
        this.text1 = textView2;
        this.text2 = textView3;
    }

    public static AdapterItemOptionBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterItemOptionBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterItemOptionBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_item_option, viewGroup, z, obj);
    }

    public static AdapterItemOptionBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterItemOptionBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterItemOptionBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_item_option, null, false, obj);
    }

    public static AdapterItemOptionBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterItemOptionBinding bind(View view, Object obj) {
        return (AdapterItemOptionBinding) bind(obj, view, R.layout.adapter_item_option);
    }
}
