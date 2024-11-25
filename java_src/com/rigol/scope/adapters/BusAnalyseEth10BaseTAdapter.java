package com.rigol.scope.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.recyclerview.widget.RecyclerView;
import com.rigol.scope.R;
import com.rigol.scope.databinding.AdapterBusEthAnalyse10basetBinding;
import com.rigol.scope.views.busAnalyse.BusAnalyseEthParam;
/* loaded from: classes.dex */
public class BusAnalyseEth10BaseTAdapter extends RecyclerView.Adapter<BusAnalyseEth10BaseTViewHolder> implements CompoundButton.OnCheckedChangeListener {
    private AdapterBusEthAnalyse10basetBinding binding;
    private BusAnalyseEthParam param;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return 1;
    }

    public BusAnalyseEth10BaseTAdapter(BusAnalyseEthParam busAnalyseEthParam) {
        this.param = busAnalyseEthParam;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public BusAnalyseEth10BaseTViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        this.binding = AdapterBusEthAnalyse10basetBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        return new BusAnalyseEth10BaseTViewHolder(this.binding);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(BusAnalyseEth10BaseTViewHolder busAnalyseEth10BaseTViewHolder, int i) {
        this.binding.busAnalyseEthLinkPluseCheckbox.setOnCheckedChangeListener(this);
        this.binding.busAnalyseEthTpidlCheckbox.setOnCheckedChangeListener(this);
        this.binding.busAnalyseEthMauCheckbox.setOnCheckedChangeListener(this);
        this.binding.busAnalyseEthJitterCheckbox.setOnCheckedChangeListener(this);
        this.binding.busAnalyseEthDifferentVoltageCheckbox.setOnCheckedChangeListener(this);
        this.binding.busAnalyseEthHarmonicsCheckbox.setOnCheckedChangeListener(this);
        this.binding.setParam(this.param);
    }

    public void setParam(BusAnalyseEthParam busAnalyseEthParam) {
        this.param = busAnalyseEthParam;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (compoundButton.isPressed()) {
            int id = compoundButton.getId();
            if (id != R.id.bus_analyse_eth_different_voltage_checkbox) {
                if (id != R.id.bus_analyse_eth_tpidl_checkbox) {
                    switch (id) {
                        case R.id.bus_analyse_eth_harmonics_checkbox /* 2131362157 */:
                        case R.id.bus_analyse_eth_jitter_checkbox /* 2131362158 */:
                        case R.id.bus_analyse_eth_mau_checkbox /* 2131362160 */:
                            break;
                        case R.id.bus_analyse_eth_link_pluse_checkbox /* 2131362159 */:
                            this.binding.busAnalyseEthLinkPluseCheckbox.setChecked(z);
                            this.param.saveEth10_link_pluse(z);
                            if (z) {
                                this.binding.busAnalyseEthTpidlCheckbox.setChecked(false);
                                this.binding.busAnalyseEthMauCheckbox.setChecked(false);
                                this.binding.busAnalyseEthJitterCheckbox.setChecked(false);
                                this.binding.busAnalyseEthDifferentVoltageCheckbox.setChecked(false);
                                this.binding.busAnalyseEthHarmonicsCheckbox.setChecked(false);
                                this.param.saveEth10_tp_idl(false);
                                this.param.saveEth10_mau(false);
                                this.param.saveEth10_jitter(false);
                                this.param.saveEth10_different_voltage(false);
                                this.param.saveEth10_harmonics(false);
                            }
                            this.binding.setParam(this.param);
                            return;
                        default:
                            return;
                    }
                } else {
                    this.binding.busAnalyseEthTpidlCheckbox.setChecked(z);
                    this.param.saveEth10_tp_idl(z);
                    if (z) {
                        this.binding.busAnalyseEthLinkPluseCheckbox.setChecked(false);
                        this.binding.busAnalyseEthMauCheckbox.setChecked(false);
                        this.binding.busAnalyseEthJitterCheckbox.setChecked(false);
                        this.binding.busAnalyseEthDifferentVoltageCheckbox.setChecked(false);
                        this.binding.busAnalyseEthHarmonicsCheckbox.setChecked(false);
                        this.param.saveEth10_link_pluse(false);
                        this.param.saveEth10_mau(false);
                        this.param.saveEth10_jitter(false);
                        this.param.saveEth10_different_voltage(false);
                        this.param.saveEth10_harmonics(false);
                        return;
                    }
                    return;
                }
            }
            this.binding.busAnalyseEthMauCheckbox.setChecked(z);
            this.binding.busAnalyseEthJitterCheckbox.setChecked(z);
            this.binding.busAnalyseEthDifferentVoltageCheckbox.setChecked(z);
            this.binding.busAnalyseEthHarmonicsCheckbox.setChecked(z);
            this.param.saveEth10_mau(z);
            this.param.saveEth10_jitter(z);
            this.param.saveEth10_different_voltage(z);
            this.param.saveEth10_harmonics(z);
            if (z) {
                this.binding.busAnalyseEthLinkPluseCheckbox.setChecked(false);
                this.binding.busAnalyseEthTpidlCheckbox.setChecked(false);
                this.param.saveEth10_link_pluse(false);
                this.param.saveEth10_tp_idl(false);
            }
            this.binding.setParam(this.param);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class BusAnalyseEth10BaseTViewHolder extends RecyclerView.ViewHolder {
        public BusAnalyseEth10BaseTViewHolder(AdapterBusEthAnalyse10basetBinding adapterBusEthAnalyse10basetBinding) {
            super(adapterBusEthAnalyse10basetBinding.getRoot());
        }
    }
}
