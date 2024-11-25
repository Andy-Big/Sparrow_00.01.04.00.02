package com.rigol.scope.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.rigol.scope.R;
import com.rigol.scope.cil.API;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.databinding.AdapterBusEthAnalyseBinding;
import com.rigol.scope.utilities.PopupViewManager;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.views.AnalysingPopupView;
import com.rigol.scope.views.baseview.BasePopupView;
import com.rigol.scope.views.busAnalyse.BusAnalyseEthParam;
import com.rigol.scope.views.busAnalyse.BusAnalysePopupView;
import com.rigol.scope.views.spinner.PopupSpinner;
/* loaded from: classes.dex */
public class BusAnalyseEthAdapter extends RecyclerView.Adapter<BusAnalyseEthHolder> implements View.OnClickListener {
    private final BasePopupView basePopupView;
    private AdapterBusEthAnalyseBinding binding;
    private final BusAnalyseEthParam param;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return 1;
    }

    public BusAnalyseEthAdapter(BasePopupView basePopupView, BusAnalyseEthParam busAnalyseEthParam) {
        this.param = busAnalyseEthParam;
        this.basePopupView = basePopupView;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public BusAnalyseEthHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        AdapterBusEthAnalyseBinding inflate = AdapterBusEthAnalyseBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        this.binding = inflate;
        inflate.setOnClickListener(this);
        this.binding.setParam(this.param);
        return new BusAnalyseEthHolder(this.binding);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(BusAnalyseEthHolder busAnalyseEthHolder, int i) {
        showBusAnalyseEthAdapter(this.param.getEth_type());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.bus_analyse_eth_type_value) {
            ViewUtil.showSpinner(this.basePopupView.getAnchor(), view, (int) R.array.msg_eth_analyse_signal, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$BusAnalyseEthAdapter$Ob3naQANJL9wxbAwIJuoXAUiI_c
                @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                    BusAnalyseEthAdapter.this.lambda$onClick$0$BusAnalyseEthAdapter(view2, viewHolder, i, (MappingObject) obj);
                }
            });
        } else if (id == R.id.bus_analyse_eth_source_value) {
            ViewUtil.showChanSpinner(this.basePopupView.getAnchor(), view, (int) R.array.msg_eth_analyse_src, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$BusAnalyseEthAdapter$Tp6eQfRohuGiyI0bc13qL4UqD2c
                @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                    BusAnalyseEthAdapter.this.lambda$onClick$1$BusAnalyseEthAdapter(view2, viewHolder, i, (MappingObject) obj);
                }
            });
        } else if (id == R.id.bus_analyse_eth_auto_set_button) {
            API.getInstance().UI_PostInt32(49, MessageID.MSG_ETH_ANALYSE_AUTO_SET, this.param.getEth_type());
        } else if (id == R.id.bus_analyse_eth_test_button && this.param.getEth_type() == ServiceEnum.AnalyseEthType.ethernet_100_baset.value1) {
            API.getInstance().UI_PostBool(49, MessageID.MSG_ETH_ANALYSE_ENABLE, true);
            PopupViewManager.getInstance().dismiss(BusAnalysePopupView.class);
            BasePopupView basePopupView = PopupViewManager.getInstance().get(AnalysingPopupView.class);
            if (basePopupView instanceof AnalysingPopupView) {
                ((AnalysingPopupView) basePopupView).setCancelListener(new View.OnClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$BusAnalyseEthAdapter$ITA7b3PLaomcAp0TUnBNjOzZk8Q
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        BusAnalyseEthAdapter.lambda$onClick$2(view2);
                    }
                });
                basePopupView.show();
            }
        }
    }

    public /* synthetic */ void lambda$onClick$0$BusAnalyseEthAdapter(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        this.param.saveEth_type(mappingObject.getValue());
        showBusAnalyseEthAdapter(mappingObject.getValue());
    }

    public /* synthetic */ void lambda$onClick$1$BusAnalyseEthAdapter(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        this.param.saveEth_source(mappingObject.getValue());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$onClick$2(View view) {
        API.getInstance().UI_PostBool(49, MessageID.MSG_ETH_ANALYSE_ENABLE, false);
        PopupViewManager.getInstance().show(BusAnalysePopupView.class);
    }

    public void showBusAnalyseEthAdapter(int i) {
        if (this.binding == null) {
            return;
        }
        if (i == ServiceEnum.AnalyseEthType.ethernet_10_baset.value1) {
            this.binding.busEthAnalyseView.setAdapter(new BusAnalyseEth10BaseTAdapter(this.param));
        } else if (i == ServiceEnum.AnalyseEthType.ethernet_100_baset.value1) {
            this.binding.busEthAnalyseView.setAdapter(new BusAnalyseEth100BaseTAdapter(this.basePopupView.getAnchor(), this.param));
        } else if (i == ServiceEnum.AnalyseEthType.ethernet_1000_baset.value1) {
            this.binding.busEthAnalyseView.setAdapter(new BusAnalyseEth1000BaseTAdapter(this.param));
        }
    }

    /* loaded from: classes.dex */
    public static class BusAnalyseEthHolder extends RecyclerView.ViewHolder {
        public BusAnalyseEthHolder(AdapterBusEthAnalyseBinding adapterBusEthAnalyseBinding) {
            super(adapterBusEthAnalyseBinding.getRoot());
        }
    }
}
