package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
/* loaded from: classes2.dex */
public abstract class AdapterBusAnalyseSelectItemBinding extends ViewDataBinding {
    public final CheckBox busEthernet;
    public final CheckBox busUsb;

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterBusAnalyseSelectItemBinding(Object obj, View view, int i, CheckBox checkBox, CheckBox checkBox2) {
        super(obj, view, i);
        this.busEthernet = checkBox;
        this.busUsb = checkBox2;
    }

    public static AdapterBusAnalyseSelectItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterBusAnalyseSelectItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterBusAnalyseSelectItemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_bus_analyse_select_item, viewGroup, z, obj);
    }

    public static AdapterBusAnalyseSelectItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterBusAnalyseSelectItemBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterBusAnalyseSelectItemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_bus_analyse_select_item, null, false, obj);
    }

    public static AdapterBusAnalyseSelectItemBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterBusAnalyseSelectItemBinding bind(View view, Object obj) {
        return (AdapterBusAnalyseSelectItemBinding) bind(obj, view, R.layout.adapter_bus_analyse_select_item);
    }
}
