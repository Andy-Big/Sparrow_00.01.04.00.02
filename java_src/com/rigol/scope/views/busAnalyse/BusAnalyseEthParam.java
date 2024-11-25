package com.rigol.scope.views.busAnalyse;

import android.view.View;
import android.widget.TextView;
import androidx.databinding.Bindable;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.BaseParam;
import com.rigol.scope.utilities.ColorUtil;
/* loaded from: classes2.dex */
public class BusAnalyseEthParam extends BaseParam {
    private static final boolean DEFAULT_CLKTRIGGER = false;
    private boolean eth1000_diff_voltage;
    private boolean eth1000_master_jitter;
    private boolean eth1000_out_droop;
    private boolean eth1000_out_temp;
    private boolean eth1000_slave_jitter;
    private int eth100_clk;
    private boolean eth100_clk_trigger;
    private boolean eth100_diff_voltage;
    private boolean eth100_dutycycle;
    private boolean eth100_eye;
    private boolean eth100_eye_ui;
    private boolean eth100_jitter;
    private boolean eth100_overshoot;
    private boolean eth100_rfsymmetry;
    private boolean eth100_rftime;
    private boolean eth100_sigas;
    private int eth100_value1;
    private int eth100_value2;
    private boolean eth10_auto_set;
    private boolean eth10_different_voltage;
    private boolean eth10_harmonics;
    private boolean eth10_jitter;
    private boolean eth10_link_pluse;
    private boolean eth10_mau;
    private boolean eth10_test;
    private boolean eth10_tp_idl;
    private int eth_source;
    private int eth_type;
    private static final int DEFAULT_ETHTYPE = ServiceEnum.AnalyseEthType.ethernet_100_baset.value1;
    private static final int DEFAULT_SOURCE = ServiceEnum.Chan.chan1.value1;
    private static final int DEFAULT_CLOCK_SOURCE = ServiceEnum.Chan.chan2.value1;

    @Bindable
    public int getEth_type() {
        return this.eth_type;
    }

    public void saveEth_type(int i) {
        this.eth_type = i;
        notifyPropertyChanged(283);
        saveInt(MessageID.MSG_ETH_ANALYSE_SIGNAL, i);
    }

    @Bindable
    public int getEth_source() {
        return this.eth_source;
    }

    public void saveEth_source(int i) {
        this.eth_source = i;
        notifyPropertyChanged(282);
        saveInt(MessageID.MSG_ETH_ANALYSE_SRC, i);
    }

    public void readEth_source() {
        this.eth_source = readInt(MessageID.MSG_ETH_ANALYSE_SRC);
        notifyPropertyChanged(282);
    }

    public boolean isEth10_link_pluse() {
        return this.eth10_link_pluse;
    }

    public void saveEth10_link_pluse(boolean z) {
        this.eth10_link_pluse = z;
        saveBool(MessageID.MSG_ETH_ANALYSE_10BASET_LINKPLUSE, z);
    }

    public boolean isEth10_tp_idl() {
        return this.eth10_tp_idl;
    }

    public void saveEth10_tp_idl(boolean z) {
        this.eth10_tp_idl = z;
        saveBool(MessageID.MSG_ETH_ANALYSE_10BASET_TP_IDL, z);
    }

    public boolean isEth10_mau() {
        return this.eth10_mau;
    }

    public void saveEth10_mau(boolean z) {
        this.eth10_mau = z;
        saveBool(MessageID.MSG_ETH_ANALYSE_10BASET_MAU, z);
    }

    public boolean isEth10_jitter() {
        return this.eth10_jitter;
    }

    public void saveEth10_jitter(boolean z) {
        this.eth10_jitter = z;
        saveBool(MessageID.MSG_ETH_ANALYSE_10BASET_JITTER, z);
    }

    public boolean isEth10_different_voltage() {
        return this.eth10_different_voltage;
    }

    public void saveEth10_different_voltage(boolean z) {
        this.eth10_different_voltage = z;
        saveBool(MessageID.MSG_ETH_ANALYSE_10BASET_DIFF_VOL, z);
    }

    public boolean isEth10_harmonics() {
        return this.eth10_harmonics;
    }

    public void saveEth10_harmonics(boolean z) {
        this.eth10_harmonics = z;
        saveBool(MessageID.MSG_ETH_ANALYSE_10BASET_HARMONICS, z);
    }

    public boolean isEth10_auto_set() {
        return this.eth10_auto_set;
    }

    public void setEth10_auto_set(boolean z) {
        this.eth10_auto_set = z;
    }

    public boolean isEth10_test() {
        return this.eth10_test;
    }

    public void setEth10_test(boolean z) {
        this.eth10_test = z;
    }

    public boolean isEth100_diff_voltage() {
        return this.eth100_diff_voltage;
    }

    public void saveEth100_diff_voltage(boolean z) {
        this.eth100_diff_voltage = z;
        saveBool(MessageID.MSG_ETH_ANALYSE_100BASET_VOUT, z);
    }

    public boolean isEth100_sigas() {
        return this.eth100_sigas;
    }

    public void saveEth100_sigas(boolean z) {
        this.eth100_sigas = z;
        saveBool(MessageID.MSG_ETH_ANALYSE_100BASET_SIGAS, z);
    }

    public boolean isEth100_rftime() {
        return this.eth100_rftime;
    }

    public void saveEth100_rftime(boolean z) {
        this.eth100_rftime = z;
        saveBool(MessageID.MSG_ETH_ANALYSE_100BASET_RFTIME, z);
    }

    public boolean isEth100_rfsymmetry() {
        return this.eth100_rfsymmetry;
    }

    public void saveEth100_rfsymmetry(boolean z) {
        this.eth100_rfsymmetry = z;
        saveBool(MessageID.MSG_ETH_ANALYSE_100BASET_RFSYMMETRY, z);
    }

    public boolean isEth100_overshoot() {
        return this.eth100_overshoot;
    }

    public void saveEth100_overshoot(boolean z) {
        this.eth100_overshoot = z;
        saveBool(MessageID.MSG_ETH_ANALYSE_100BASET_OVERSHOOT, z);
    }

    public boolean isEth100_dutycycle() {
        return this.eth100_dutycycle;
    }

    public void saveEth100_dutycycle(boolean z) {
        this.eth100_dutycycle = z;
        saveBool(MessageID.MSG_ETH_ANALYSE_100BASET_DUTYCYCLE, z);
    }

    public boolean isEth100_eye() {
        return this.eth100_eye;
    }

    public void saveEth100_eye(boolean z) {
        this.eth100_eye = z;
        saveBool(MessageID.MSG_ETH_ANALYSE_100BASET_EYE, z);
    }

    public boolean isEth100_eye_ui() {
        return this.eth100_eye_ui;
    }

    public void saveEth100_eye_ui(boolean z) {
        this.eth100_eye_ui = z;
        saveBool(MessageID.MSG_ETH_ANALYSE_100BASET_EYEUI, z);
    }

    public boolean isEth100_jitter() {
        return this.eth100_jitter;
    }

    public void saveEth100_jitter(boolean z) {
        this.eth100_jitter = z;
        saveBool(MessageID.MSG_ETH_ANALYSE_100BASET_JITTER, z);
    }

    @Bindable
    public boolean isEth100_clk_trigger() {
        return this.eth100_clk_trigger;
    }

    public void saveEth100_clk_trigger(boolean z) {
        this.eth100_clk_trigger = z;
        notifyPropertyChanged(281);
        saveBool(MessageID.MSG_ETH_ANALYSE_100BASET_CLK_TRIGGER, z);
    }

    @Bindable
    public int getEth100_clk() {
        return this.eth100_clk;
    }

    public void saveEth100_clk(int i) {
        this.eth100_clk = i;
        notifyPropertyChanged(280);
        saveInt(MessageID.MSG_ETH_ANALYSE_100BASET_CLK, i);
    }

    public int getEth100_value1() {
        return this.eth100_value1;
    }

    public void saveEth100_value1(int i) {
        this.eth100_value1 = i;
    }

    public int getEth100_value2() {
        return this.eth100_value2;
    }

    public void saveEth100_value2(int i) {
        this.eth100_value2 = i;
    }

    public boolean isEth1000_diff_voltage() {
        return this.eth1000_diff_voltage;
    }

    public void setEth1000_diff_voltage(boolean z) {
        this.eth1000_diff_voltage = z;
    }

    public boolean isEth1000_master_jitter() {
        return this.eth1000_master_jitter;
    }

    public void saveEth1000_master_jitter(boolean z) {
        this.eth1000_master_jitter = z;
    }

    public boolean isEth1000_out_temp() {
        return this.eth1000_out_temp;
    }

    public void saveEth1000_out_temp(boolean z) {
        this.eth1000_out_temp = z;
    }

    public boolean isEth1000_slave_jitter() {
        return this.eth1000_slave_jitter;
    }

    public void saveEth1000_slave_jitter(boolean z) {
        this.eth1000_slave_jitter = z;
    }

    public boolean isEth1000_out_droop() {
        return this.eth1000_out_droop;
    }

    public void saveEth1000_out_droop(boolean z) {
        this.eth1000_out_droop = z;
    }

    public BusAnalyseEthParam() {
        super(49);
        this.eth_type = DEFAULT_ETHTYPE;
        this.eth_source = DEFAULT_SOURCE;
        this.eth100_clk = 2;
    }

    @Override // com.rigol.scope.data.BaseParam
    public void readAll() {
        readParams();
    }

    public BusAnalyseEthParam readParams() {
        readEth_source();
        return this;
    }

    public void setChanColor(View view, ServiceEnum.Chan chan) {
        if (chan != null) {
            ((TextView) view).setTextColor(ColorUtil.getColor(view.getContext(), chan));
        }
    }

    @Override // com.rigol.scope.data.BaseParam
    public void reset() {
        super.reset();
        saveEth_type(DEFAULT_ETHTYPE);
        saveEth_source(DEFAULT_SOURCE);
        saveEth100_clk_trigger(false);
        saveEth100_clk(DEFAULT_CLOCK_SOURCE);
    }
}
