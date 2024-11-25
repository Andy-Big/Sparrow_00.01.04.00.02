package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
/* loaded from: classes2.dex */
public abstract class AdapterItemSimpleBinding extends ViewDataBinding {
    public final ImageView icon;
    public final TextView text1;

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterItemSimpleBinding(Object obj, View view, int i, ImageView imageView, TextView textView) {
        super(obj, view, i);
        this.icon = imageView;
        this.text1 = textView;
    }

    public static AdapterItemSimpleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterItemSimpleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterItemSimpleBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_item_simple, viewGroup, z, obj);
    }

    public static AdapterItemSimpleBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterItemSimpleBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterItemSimpleBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_item_simple, null, false, obj);
    }

    public static AdapterItemSimpleBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterItemSimpleBinding bind(View view, Object obj) {
        return (AdapterItemSimpleBinding) bind(obj, view, R.layout.adapter_item_simple);
    }
}
