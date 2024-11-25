package com.rigol.scope.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.rigol.scope.R;
import com.rigol.scope.cil.API;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.HorizontalParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.VerticalParam;
import com.rigol.scope.databinding.AdapterBusUsbAnalyseBinding;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.PopupViewManager;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.viewmodels.HorizontalViewModel;
import com.rigol.scope.viewmodels.VerticalViewModel;
import com.rigol.scope.views.AnalysingPopupView;
import com.rigol.scope.views.baseview.BasePopupView;
import com.rigol.scope.views.busAnalyse.BusAnalysePopupView;
import com.rigol.scope.views.busAnalyse.BusAnalyseUsbParam;
import com.rigol.scope.views.spinner.PopupSpinner;
/* loaded from: classes.dex */
public class BusAnalyseUsbAdapter extends RecyclerView.Adapter<BusAnalyseUsbHolder> implements View.OnClickListener {
    private AdapterBusUsbAnalyseBinding binding;
    private final BusAnalyseUsbParam param;
    private final BasePopupView popupView;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return 1;
    }

    public BusAnalyseUsbAdapter(BasePopupView basePopupView, BusAnalyseUsbParam busAnalyseUsbParam) {
        this.param = busAnalyseUsbParam;
        this.popupView = basePopupView;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public BusAnalyseUsbHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        this.binding = AdapterBusUsbAnalyseBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        return new BusAnalyseUsbHolder(this.binding);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(BusAnalyseUsbHolder busAnalyseUsbHolder, int i) {
        this.binding.busAnalyseUsbTypeValue.setOnClickListener(this);
        this.binding.busAnalyseUsbSourceDsValue.setOnClickListener(this);
        this.binding.busAnalyseUsbSourceDpValue.setOnClickListener(this);
        this.binding.busAnalyseUsbPointValue.setOnClickListener(this);
        this.binding.busAnalyseUsbDiffsrcValue.setOnClickListener(this);
        this.binding.busAnalyseUsbAutoSetButton.setOnClickListener(this);
        this.binding.busAnalyseUsbTestButton.setOnClickListener(this);
        this.binding.setParam(this.param);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int usb_diff_source;
        int i;
        VerticalParam verticalParam;
        HorizontalParam value;
        switch (view.getId()) {
            case R.id.bus_analyse_usb_auto_set_button /* 2131362170 */:
                API.getInstance().UI_PostInt32(48, MessageID.MSG_USB_ANALYSE_AUTO_SET, this.param.getUsb_type());
                return;
            case R.id.bus_analyse_usb_diffsrc_value /* 2131362172 */:
                ViewUtil.showChanSpinner(this.popupView.getAnchor(), view, (int) R.array.msg_usb_analyse_diff, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$BusAnalyseUsbAdapter$iwszn45sDyLkokgCgrDjKZPoFyY
                    @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                    public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i2, Object obj) {
                        BusAnalyseUsbAdapter.this.lambda$onClick$1$BusAnalyseUsbAdapter(view2, viewHolder, i2, (MappingObject) obj);
                    }
                });
                return;
            case R.id.bus_analyse_usb_point_value /* 2131362175 */:
                ViewUtil.showSpinner(this.popupView.getAnchor(), view, (int) R.array.msg_usb_analyse_point, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$BusAnalyseUsbAdapter$KSB6JIhEbMDLWgLlWvM1X1gLS7s
                    @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                    public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i2, Object obj) {
                        BusAnalyseUsbAdapter.this.lambda$onClick$2$BusAnalyseUsbAdapter(view2, viewHolder, i2, (MappingObject) obj);
                    }
                });
                return;
            case R.id.bus_analyse_usb_sourceDp_value /* 2131362178 */:
                ViewUtil.showChanSpinner(this.popupView.getAnchor(), view, (int) R.array.msg_usb_analyse_dp, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$BusAnalyseUsbAdapter$GcqN_caPlYpk7Vd1pbQEpVCp1d8
                    @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                    public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i2, Object obj) {
                        BusAnalyseUsbAdapter.this.lambda$onClick$4$BusAnalyseUsbAdapter(view2, viewHolder, i2, (MappingObject) obj);
                    }
                });
                return;
            case R.id.bus_analyse_usb_sourceDs_value /* 2131362180 */:
                ViewUtil.showChanSpinner(this.popupView.getAnchor(), view, (int) R.array.msg_usb_analyse_ds, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$BusAnalyseUsbAdapter$8gLeIAZL1wbRFLqGVbNCx154q-M
                    @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                    public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i2, Object obj) {
                        BusAnalyseUsbAdapter.this.lambda$onClick$3$BusAnalyseUsbAdapter(view2, viewHolder, i2, (MappingObject) obj);
                    }
                });
                return;
            case R.id.bus_analyse_usb_test_button /* 2131362181 */:
                API.getInstance().UI_PostBool(48, MessageID.MSG_USB_ANALYSE_ENABLE, true);
                PopupViewManager.getInstance().dismiss(BusAnalysePopupView.class);
                BasePopupView basePopupView = PopupViewManager.getInstance().get(AnalysingPopupView.class);
                if (basePopupView instanceof AnalysingPopupView) {
                    ((AnalysingPopupView) basePopupView).setCancelListener(new View.OnClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$BusAnalyseUsbAdapter$_L7ZfZ5HqpWFb7UtyixGeg5xUko
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) {
                            BusAnalyseUsbAdapter.lambda$onClick$5(view2);
                        }
                    });
                    basePopupView.show();
                }
                HorizontalViewModel horizontalViewModel = (HorizontalViewModel) ContextUtil.getAppViewModel(HorizontalViewModel.class);
                if (horizontalViewModel != null && (value = horizontalViewModel.getLiveData().getValue()) != null) {
                    this.param.setSrcHscale(value.getMainScale());
                }
                if (this.param.getUsb_type() == 4 || this.param.getUsb_type() == 5) {
                    usb_diff_source = this.param.getUsb_diff_source();
                    i = ServiceEnum.Chan.chan1.value1;
                } else {
                    usb_diff_source = this.param.getUsb_source_dp();
                    i = ServiceEnum.Chan.chan1.value1;
                }
                int i2 = usb_diff_source - i;
                VerticalViewModel verticalViewModel = (VerticalViewModel) ContextUtil.getAppViewModel(VerticalViewModel.class);
                if (verticalViewModel == null || (verticalParam = verticalViewModel.getLiveData().getValue().get(i2)) == null) {
                    return;
                }
                this.param.setSrcVscale(verticalParam.getScale());
                return;
            case R.id.bus_analyse_usb_type_value /* 2131362183 */:
                ViewUtil.showSpinner(this.popupView.getAnchor(), view, (int) R.array.msg_usb_analyse_type, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$BusAnalyseUsbAdapter$16HEd9g6uwGpZGgiBzNiGUhOddw
                    @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                    public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i3, Object obj) {
                        BusAnalyseUsbAdapter.this.lambda$onClick$0$BusAnalyseUsbAdapter(view2, viewHolder, i3, (MappingObject) obj);
                    }
                });
                return;
            default:
                return;
        }
    }

    public /* synthetic */ void lambda$onClick$0$BusAnalyseUsbAdapter(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        this.param.saveUsb_type(i);
        this.binding.setParam(this.param);
    }

    public /* synthetic */ void lambda$onClick$1$BusAnalyseUsbAdapter(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        this.param.saveUsb_diff_source(mappingObject.getValue());
        this.binding.setParam(this.param);
    }

    public /* synthetic */ void lambda$onClick$2$BusAnalyseUsbAdapter(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        this.param.saveUsb_point(i);
        this.binding.setParam(this.param);
    }

    public /* synthetic */ void lambda$onClick$3$BusAnalyseUsbAdapter(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        this.param.saveUsb_source_ds(mappingObject.getValue());
        this.binding.setParam(this.param);
    }

    public /* synthetic */ void lambda$onClick$4$BusAnalyseUsbAdapter(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        this.param.saveUsb_source_dp(mappingObject.getValue());
        this.binding.setParam(this.param);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$onClick$5(View view) {
        API.getInstance().UI_PostBool(48, MessageID.MSG_USB_ANALYSE_ENABLE, false);
        PopupViewManager.getInstance().show(BusAnalysePopupView.class);
    }

    /* loaded from: classes.dex */
    public static class BusAnalyseUsbHolder extends RecyclerView.ViewHolder {
        public BusAnalyseUsbHolder(AdapterBusUsbAnalyseBinding adapterBusUsbAnalyseBinding) {
            super(adapterBusUsbAnalyseBinding.getRoot());
        }
    }
}
