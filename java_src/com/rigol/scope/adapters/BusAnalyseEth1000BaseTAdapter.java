package com.rigol.scope.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.recyclerview.widget.RecyclerView;
import com.rigol.scope.R;
import com.rigol.scope.databinding.AdapterBusEthAnalyse1000basetBinding;
import com.rigol.scope.views.busAnalyse.BusAnalyseEthParam;
/* loaded from: classes.dex */
public class BusAnalyseEth1000BaseTAdapter extends RecyclerView.Adapter<BusAnalyseEth1000BaseTViewHolder> implements CompoundButton.OnCheckedChangeListener {
    private AdapterBusEthAnalyse1000basetBinding binding;
    private BusAnalyseEthParam param;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return 1;
    }

    public BusAnalyseEth1000BaseTAdapter(BusAnalyseEthParam busAnalyseEthParam) {
        this.param = busAnalyseEthParam;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public BusAnalyseEth1000BaseTViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        this.binding = AdapterBusEthAnalyse1000basetBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        return new BusAnalyseEth1000BaseTViewHolder(this.binding);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(BusAnalyseEth1000BaseTViewHolder busAnalyseEth1000BaseTViewHolder, int i) {
        this.binding.eth1000basetSlaveJitterCheckbox.setOnCheckedChangeListener(this);
        this.binding.eth1000basetMasterJitterCheckbox.setOnCheckedChangeListener(this);
        this.binding.eth1000basetOutTempCheckbox.setOnCheckedChangeListener(this);
        this.binding.eth1000basetOutDroopCheckbox.setOnCheckedChangeListener(this);
        this.binding.eth1000basetDiffVoltageCheckbox.setOnCheckedChangeListener(this);
        this.binding.setParam(this.param);
    }

    public void setParam(BusAnalyseEthParam busAnalyseEthParam) {
        this.param = busAnalyseEthParam;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (compoundButton.isPressed()) {
            switch (compoundButton.getId()) {
                case R.id.eth_1000baset_diff_voltage_checkbox /* 2131362773 */:
                case R.id.eth_1000baset_out_droop_checkbox /* 2131362775 */:
                case R.id.eth_1000baset_out_temp_checkbox /* 2131362776 */:
                    this.binding.eth1000basetDiffVoltageCheckbox.setChecked(z);
                    this.binding.eth1000basetOutDroopCheckbox.setChecked(z);
                    this.binding.eth1000basetOutTempCheckbox.setChecked(z);
                    if (z) {
                        this.binding.eth1000basetMasterJitterCheckbox.setChecked(false);
                        this.binding.eth1000basetSlaveJitterCheckbox.setChecked(false);
                        return;
                    }
                    return;
                case R.id.eth_1000baset_master_jitter_checkbox /* 2131362774 */:
                    this.binding.eth1000basetMasterJitterCheckbox.setChecked(z);
                    if (z) {
                        this.binding.eth1000basetDiffVoltageCheckbox.setChecked(false);
                        this.binding.eth1000basetOutDroopCheckbox.setChecked(false);
                        this.binding.eth1000basetOutTempCheckbox.setChecked(false);
                        this.binding.eth1000basetSlaveJitterCheckbox.setChecked(false);
                        return;
                    }
                    return;
                case R.id.eth_1000baset_slave_jitter_checkbox /* 2131362777 */:
                    this.binding.eth1000basetSlaveJitterCheckbox.setChecked(z);
                    if (z) {
                        this.binding.eth1000basetDiffVoltageCheckbox.setChecked(false);
                        this.binding.eth1000basetOutDroopCheckbox.setChecked(false);
                        this.binding.eth1000basetOutTempCheckbox.setChecked(false);
                        this.binding.eth1000basetMasterJitterCheckbox.setChecked(false);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class BusAnalyseEth1000BaseTViewHolder extends RecyclerView.ViewHolder {
        public BusAnalyseEth1000BaseTViewHolder(AdapterBusEthAnalyse1000basetBinding adapterBusEthAnalyse1000basetBinding) {
            super(adapterBusEthAnalyse1000basetBinding.getRoot());
        }
    }
}
