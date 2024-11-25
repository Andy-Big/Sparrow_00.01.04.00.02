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
public abstract class AdapterBusEthAnalyse1000basetBinding extends ViewDataBinding {
    public final CheckBox eth1000basetDiffVoltageCheckbox;
    public final CheckBox eth1000basetMasterJitterCheckbox;
    public final CheckBox eth1000basetOutDroopCheckbox;
    public final CheckBox eth1000basetOutTempCheckbox;
    public final CheckBox eth1000basetSlaveJitterCheckbox;
    @Bindable
    protected BusAnalyseEthParam mParam;

    public abstract void setParam(BusAnalyseEthParam busAnalyseEthParam);

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterBusEthAnalyse1000basetBinding(Object obj, View view, int i, CheckBox checkBox, CheckBox checkBox2, CheckBox checkBox3, CheckBox checkBox4, CheckBox checkBox5) {
        super(obj, view, i);
        this.eth1000basetDiffVoltageCheckbox = checkBox;
        this.eth1000basetMasterJitterCheckbox = checkBox2;
        this.eth1000basetOutDroopCheckbox = checkBox3;
        this.eth1000basetOutTempCheckbox = checkBox4;
        this.eth1000basetSlaveJitterCheckbox = checkBox5;
    }

    public BusAnalyseEthParam getParam() {
        return this.mParam;
    }

    public static AdapterBusEthAnalyse1000basetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterBusEthAnalyse1000basetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterBusEthAnalyse1000basetBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_bus_eth_analyse_1000baset, viewGroup, z, obj);
    }

    public static AdapterBusEthAnalyse1000basetBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterBusEthAnalyse1000basetBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterBusEthAnalyse1000basetBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_bus_eth_analyse_1000baset, null, false, obj);
    }

    public static AdapterBusEthAnalyse1000basetBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterBusEthAnalyse1000basetBinding bind(View view, Object obj) {
        return (AdapterBusEthAnalyse1000basetBinding) bind(obj, view, R.layout.adapter_bus_eth_analyse_1000baset);
    }
}
