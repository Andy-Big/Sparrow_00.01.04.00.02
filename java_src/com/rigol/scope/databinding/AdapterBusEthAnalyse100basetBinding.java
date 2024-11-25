package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
import com.rigol.scope.views.busAnalyse.BusAnalyseEthParam;
/* loaded from: classes2.dex */
public abstract class AdapterBusEthAnalyse100basetBinding extends ViewDataBinding {
    public final View busAnalyseDivider1;
    public final CheckBox ethAnalyse1000basetDiffVoltageCheckbox;
    public final TextView ethAnalyse100basetClkLabel;
    public final CheckBox ethAnalyse100basetClkTriggerCheckbox;
    public final TextView ethAnalyse100basetClkValue;
    public final CheckBox ethAnalyse100basetDutycycleCheckbox;
    public final CheckBox ethAnalyse100basetEyeCheckbox;
    public final CheckBox ethAnalyse100basetJitterCheckbox;
    public final CheckBox ethAnalyse100basetOvershootCheckbox;
    public final CheckBox ethAnalyse100basetRfsymmetryCheckbox;
    public final CheckBox ethAnalyse100basetRftimeCheckbox;
    public final CheckBox ethAnalyse100basetSigasCheckbox;
    @Bindable
    protected BusAnalyseEthParam mParam;

    public abstract void setParam(BusAnalyseEthParam busAnalyseEthParam);

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterBusEthAnalyse100basetBinding(Object obj, View view, int i, View view2, CheckBox checkBox, TextView textView, CheckBox checkBox2, TextView textView2, CheckBox checkBox3, CheckBox checkBox4, CheckBox checkBox5, CheckBox checkBox6, CheckBox checkBox7, CheckBox checkBox8, CheckBox checkBox9) {
        super(obj, view, i);
        this.busAnalyseDivider1 = view2;
        this.ethAnalyse1000basetDiffVoltageCheckbox = checkBox;
        this.ethAnalyse100basetClkLabel = textView;
        this.ethAnalyse100basetClkTriggerCheckbox = checkBox2;
        this.ethAnalyse100basetClkValue = textView2;
        this.ethAnalyse100basetDutycycleCheckbox = checkBox3;
        this.ethAnalyse100basetEyeCheckbox = checkBox4;
        this.ethAnalyse100basetJitterCheckbox = checkBox5;
        this.ethAnalyse100basetOvershootCheckbox = checkBox6;
        this.ethAnalyse100basetRfsymmetryCheckbox = checkBox7;
        this.ethAnalyse100basetRftimeCheckbox = checkBox8;
        this.ethAnalyse100basetSigasCheckbox = checkBox9;
    }

    public BusAnalyseEthParam getParam() {
        return this.mParam;
    }

    public static AdapterBusEthAnalyse100basetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterBusEthAnalyse100basetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterBusEthAnalyse100basetBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_bus_eth_analyse_100baset, viewGroup, z, obj);
    }

    public static AdapterBusEthAnalyse100basetBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterBusEthAnalyse100basetBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterBusEthAnalyse100basetBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_bus_eth_analyse_100baset, null, false, obj);
    }

    public static AdapterBusEthAnalyse100basetBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterBusEthAnalyse100basetBinding bind(View view, Object obj) {
        return (AdapterBusEthAnalyse100basetBinding) bind(obj, view, R.layout.adapter_bus_eth_analyse_100baset);
    }
}
