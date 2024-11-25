package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
/* loaded from: classes2.dex */
public abstract class AdapterItemSimple3Binding extends ViewDataBinding {
    public final CheckBox checkbox;

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterItemSimple3Binding(Object obj, View view, int i, CheckBox checkBox) {
        super(obj, view, i);
        this.checkbox = checkBox;
    }

    public static AdapterItemSimple3Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterItemSimple3Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterItemSimple3Binding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_item_simple3, viewGroup, z, obj);
    }

    public static AdapterItemSimple3Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterItemSimple3Binding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterItemSimple3Binding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_item_simple3, null, false, obj);
    }

    public static AdapterItemSimple3Binding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterItemSimple3Binding bind(View view, Object obj) {
        return (AdapterItemSimple3Binding) bind(obj, view, R.layout.adapter_item_simple3);
    }
}
