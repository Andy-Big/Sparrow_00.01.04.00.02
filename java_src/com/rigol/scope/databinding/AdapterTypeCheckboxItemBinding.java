package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
/* loaded from: classes2.dex */
public abstract class AdapterTypeCheckboxItemBinding extends ViewDataBinding {
    public final CheckBox checkBox;
    public final TextView text1;

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterTypeCheckboxItemBinding(Object obj, View view, int i, CheckBox checkBox, TextView textView) {
        super(obj, view, i);
        this.checkBox = checkBox;
        this.text1 = textView;
    }

    public static AdapterTypeCheckboxItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterTypeCheckboxItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterTypeCheckboxItemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_type_checkbox_item, viewGroup, z, obj);
    }

    public static AdapterTypeCheckboxItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterTypeCheckboxItemBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterTypeCheckboxItemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_type_checkbox_item, null, false, obj);
    }

    public static AdapterTypeCheckboxItemBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterTypeCheckboxItemBinding bind(View view, Object obj) {
        return (AdapterTypeCheckboxItemBinding) bind(obj, view, R.layout.adapter_type_checkbox_item);
    }
}
