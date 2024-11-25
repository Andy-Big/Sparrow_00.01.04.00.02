package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
/* loaded from: classes2.dex */
public abstract class AdapterTypeSwitchItemBinding extends ViewDataBinding {
    public final Switch switchButton;
    public final TextView text1;

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterTypeSwitchItemBinding(Object obj, View view, int i, Switch r4, TextView textView) {
        super(obj, view, i);
        this.switchButton = r4;
        this.text1 = textView;
    }

    public static AdapterTypeSwitchItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterTypeSwitchItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterTypeSwitchItemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_type_switch_item, viewGroup, z, obj);
    }

    public static AdapterTypeSwitchItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterTypeSwitchItemBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterTypeSwitchItemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_type_switch_item, null, false, obj);
    }

    public static AdapterTypeSwitchItemBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterTypeSwitchItemBinding bind(View view, Object obj) {
        return (AdapterTypeSwitchItemBinding) bind(obj, view, R.layout.adapter_type_switch_item);
    }
}
