package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
/* loaded from: classes2.dex */
public abstract class AdapterTypeTextItemBinding extends ViewDataBinding {
    public final TextView text1;
    public final TextView text2;

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterTypeTextItemBinding(Object obj, View view, int i, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.text1 = textView;
        this.text2 = textView2;
    }

    public static AdapterTypeTextItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterTypeTextItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterTypeTextItemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_type_text_item, viewGroup, z, obj);
    }

    public static AdapterTypeTextItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterTypeTextItemBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterTypeTextItemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_type_text_item, null, false, obj);
    }

    public static AdapterTypeTextItemBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterTypeTextItemBinding bind(View view, Object obj) {
        return (AdapterTypeTextItemBinding) bind(obj, view, R.layout.adapter_type_text_item);
    }
}
