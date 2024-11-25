package com.rigol.scope.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.recyclerview.widget.RecyclerView;
import com.rigol.scope.R;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.databinding.AdapterBusEthAnalyse100basetBinding;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.views.busAnalyse.BusAnalyseEthParam;
import com.rigol.scope.views.spinner.PopupSpinner;
/* loaded from: classes.dex */
public class BusAnalyseEth100BaseTAdapter extends RecyclerView.Adapter<BusAnalyseEth100BaseTViewHolder> implements CompoundButton.OnCheckedChangeListener, View.OnClickListener {
    private final View anchorView;
    private AdapterBusEthAnalyse100basetBinding binding;
    private BusAnalyseEthParam param;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return 1;
    }

    public BusAnalyseEth100BaseTAdapter(View view, BusAnalyseEthParam busAnalyseEthParam) {
        this.anchorView = view;
        this.param = busAnalyseEthParam;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public BusAnalyseEth100BaseTViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        this.binding = AdapterBusEthAnalyse100basetBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        return new BusAnalyseEth100BaseTViewHolder(this.binding);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(BusAnalyseEth100BaseTViewHolder busAnalyseEth100BaseTViewHolder, int i) {
        this.binding.ethAnalyse100basetClkValue.setOnClickListener(this);
        this.binding.ethAnalyse100basetClkTriggerCheckbox.setOnCheckedChangeListener(this);
        this.binding.ethAnalyse100basetDutycycleCheckbox.setOnCheckedChangeListener(this);
        this.binding.ethAnalyse100basetJitterCheckbox.setOnCheckedChangeListener(this);
        this.binding.ethAnalyse100basetOvershootCheckbox.setOnCheckedChangeListener(this);
        this.binding.ethAnalyse100basetRfsymmetryCheckbox.setOnCheckedChangeListener(this);
        this.binding.ethAnalyse100basetRftimeCheckbox.setOnCheckedChangeListener(this);
        this.binding.ethAnalyse100basetSigasCheckbox.setOnCheckedChangeListener(this);
        this.binding.ethAnalyse1000basetDiffVoltageCheckbox.setOnCheckedChangeListener(this);
        this.binding.ethAnalyse100basetEyeCheckbox.setOnCheckedChangeListener(this);
        this.binding.ethAnalyse100basetClkValue.setEnabled(this.param.isEth100_clk_trigger());
        this.binding.ethAnalyse100basetClkValue.setTextColor(this.param.isEth100_clk_trigger() ? -1 : -7829368);
        this.binding.setParam(this.param);
    }

    public void setParam(BusAnalyseEthParam busAnalyseEthParam) {
        this.param = busAnalyseEthParam;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (compoundButton.isPressed() && compoundButton.getId() == R.id.eth_analyse_100baset_clk_trigger_checkbox) {
            this.param.saveEth100_clk_trigger(z);
            this.binding.ethAnalyse100basetClkValue.setEnabled(z);
            if (z) {
                this.param.setChanColor(this.binding.ethAnalyse100basetClkValue, ServiceEnum.getChanFromValue1(this.param.getEth100_clk()));
            } else {
                this.binding.ethAnalyse100basetClkValue.setTextColor(-7829368);
            }
            this.binding.setParam(this.param);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.eth_analyse_100baset_clk_value) {
            ViewUtil.showChanSpinner(this.anchorView, view, (int) R.array.msg_eth_analyse_100baset_clk, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$BusAnalyseEth100BaseTAdapter$tiVrFPtH8kBWIKinb6lZkD4rLfE
                @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                    BusAnalyseEth100BaseTAdapter.this.lambda$onClick$0$BusAnalyseEth100BaseTAdapter(view2, viewHolder, i, (MappingObject) obj);
                }
            });
        }
    }

    public /* synthetic */ void lambda$onClick$0$BusAnalyseEth100BaseTAdapter(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        this.param.saveEth100_clk(mappingObject.getValue());
        this.binding.setParam(this.param);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class BusAnalyseEth100BaseTViewHolder extends RecyclerView.ViewHolder {
        public BusAnalyseEth100BaseTViewHolder(AdapterBusEthAnalyse100basetBinding adapterBusEthAnalyse100basetBinding) {
            super(adapterBusEthAnalyse100basetBinding.getRoot());
        }
    }
}
