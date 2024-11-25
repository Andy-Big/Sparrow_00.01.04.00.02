package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
/* loaded from: classes2.dex */
public abstract class AdapterItemLaBinding extends ViewDataBinding {
    public final TextView laText;

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterItemLaBinding(Object obj, View view, int i, TextView textView) {
        super(obj, view, i);
        this.laText = textView;
    }

    public static AdapterItemLaBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterItemLaBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterItemLaBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_item_la, viewGroup, z, obj);
    }

    public static AdapterItemLaBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterItemLaBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterItemLaBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_item_la, null, false, obj);
    }

    public static AdapterItemLaBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterItemLaBinding bind(View view, Object obj) {
        return (AdapterItemLaBinding) bind(obj, view, R.layout.adapter_item_la);
    }
}
