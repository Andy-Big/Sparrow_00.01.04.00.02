package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
import com.rigol.scope.views.busAnalyse.BusAnalyseEthParam;
/* loaded from: classes2.dex */
public abstract class AdapterBusEthAnalyse10basetBinding extends ViewDataBinding {
    public final CheckBox busAnalyseEthDifferentVoltageCheckbox;
    public final CheckBox busAnalyseEthHarmonicsCheckbox;
    public final CheckBox busAnalyseEthJitterCheckbox;
    public final CheckBox busAnalyseEthLinkPluseCheckbox;
    public final CheckBox busAnalyseEthMauCheckbox;
    public final CheckBox busAnalyseEthTpidlCheckbox;
    @Bindable
    protected BusAnalyseEthParam mParam;

    public abstract void setParam(BusAnalyseEthParam busAnalyseEthParam);

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterBusEthAnalyse10basetBinding(Object obj, View view, int i, CheckBox checkBox, CheckBox checkBox2, CheckBox checkBox3, CheckBox checkBox4, CheckBox checkBox5, CheckBox checkBox6) {
        super(obj, view, i);
        this.busAnalyseEthDifferentVoltageCheckbox = checkBox;
        this.busAnalyseEthHarmonicsCheckbox = checkBox2;
        this.busAnalyseEthJitterCheckbox = checkBox3;
        this.busAnalyseEthLinkPluseCheckbox = checkBox4;
        this.busAnalyseEthMauCheckbox = checkBox5;
        this.busAnalyseEthTpidlCheckbox = checkBox6;
    }

    public BusAnalyseEthParam getParam() {
        return this.mParam;
    }

    public static AdapterBusEthAnalyse10basetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterBusEthAnalyse10basetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterBusEthAnalyse10basetBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_bus_eth_analyse_10baset, viewGroup, z, obj);
    }

    public static AdapterBusEthAnalyse10basetBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterBusEthAnalyse10basetBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterBusEthAnalyse10basetBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_bus_eth_analyse_10baset, null, false, obj);
    }

    public static AdapterBusEthAnalyse10basetBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterBusEthAnalyse10basetBinding bind(View view, Object obj) {
        return (AdapterBusEthAnalyse10basetBinding) bind(obj, view, R.layout.adapter_bus_eth_analyse_10baset);
    }
}
