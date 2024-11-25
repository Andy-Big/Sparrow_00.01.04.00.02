package com.rigol.scope.views.busAnalyse;

import android.view.LayoutInflater;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.ActivityUtils;
import com.rigol.scope.R;
import com.rigol.scope.adapters.BusAnalyseEthAdapter;
import com.rigol.scope.adapters.BusAnalyseUsbAdapter;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.OptionParam;
import com.rigol.scope.databinding.PopupviewBusAnalyseBinding;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.KtUtilKt;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.viewmodels.BusAnalyseViewModel;
import com.rigol.scope.viewmodels.OptionViewModel;
import com.rigol.scope.viewmodels.SyncDataViewModel;
import com.rigol.scope.views.baseview.BasePopupView;
import com.rigol.scope.views.spinner.PopupSpinner;
import java.util.List;
import kotlin.jvm.functions.Function1;
/* loaded from: classes2.dex */
public class BusAnalysePopupView extends BasePopupView implements View.OnClickListener {
    private final PopupviewBusAnalyseBinding binding;
    private BusAnalyseEthAdapter busAnalyseEthAdapter;
    private BusAnalyseUsbAdapter busAnalyseUsbAdapter;
    private List<MappingObject> list;
    private OptionParam optionParam;
    private BusAnalyseParam param;

    public BusAnalysePopupView() {
        super((int) R.style.App_PopupWindow_BusAnalyse);
        PopupviewBusAnalyseBinding inflate = PopupviewBusAnalyseBinding.inflate(LayoutInflater.from(this.context));
        this.binding = inflate;
        inflate.setOnClickListener(this);
        setContentView(this.binding.getRoot());
        BusAnalyseViewModel busAnalyseViewModel = (BusAnalyseViewModel) ContextUtil.getAppViewModel(BusAnalyseViewModel.class);
        if (busAnalyseViewModel != null) {
            busAnalyseViewModel.getLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.views.busAnalyse.-$$Lambda$BusAnalysePopupView$rETj0FNaixgusP8BEqsfF3zl14k
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    BusAnalysePopupView.this.lambda$new$0$BusAnalysePopupView((BusAnalyseParam) obj);
                }
            });
        }
        OptionViewModel optionViewModel = (OptionViewModel) ContextUtil.getAppViewModel(OptionViewModel.class);
        if (optionViewModel != null) {
            optionViewModel.getLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.views.busAnalyse.-$$Lambda$BusAnalysePopupView$GQ6l15DrGhAK6NRLyBoI1OvP7EY
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    BusAnalysePopupView.this.lambda$new$1$BusAnalysePopupView((OptionParam) obj);
                }
            });
        }
        SyncDataViewModel syncDataViewModel = (SyncDataViewModel) ContextUtil.getAppViewModel(SyncDataViewModel.class);
        if (syncDataViewModel != null) {
            syncDataViewModel.get(36, MessageID.MSG_LICENSE_CHANGED).observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.views.busAnalyse.-$$Lambda$BusAnalysePopupView$KQDLDjSMCTyhzcxyuLAemisjwpo
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    BusAnalysePopupView.this.lambda$new$2$BusAnalysePopupView(obj);
                }
            });
        }
    }

    public /* synthetic */ void lambda$new$0$BusAnalysePopupView(BusAnalyseParam busAnalyseParam) {
        this.param = busAnalyseParam;
        this.binding.setParam(busAnalyseParam);
        this.busAnalyseUsbAdapter = new BusAnalyseUsbAdapter(this, this.param.getUsb());
        this.busAnalyseEthAdapter = new BusAnalyseEthAdapter(this, this.param.getEth());
        showAdapter();
    }

    public /* synthetic */ void lambda$new$1$BusAnalysePopupView(OptionParam optionParam) {
        this.optionParam = optionParam;
        updateList(optionParam);
        showAdapter();
    }

    public /* synthetic */ void lambda$new$2$BusAnalysePopupView(Object obj) {
        updateList(this.optionParam);
        showAdapter();
    }

    private void updateList(final OptionParam optionParam) {
        this.list = KtUtilKt.filter(ViewUtil.getList((int) R.array.msg_analyse_type_list), new Function1() { // from class: com.rigol.scope.views.busAnalyse.-$$Lambda$BusAnalysePopupView$qb9q-L-ikhFVB3jhZOJHtwxDKjA
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BusAnalysePopupView.lambda$updateList$3(OptionParam.this, (MappingObject) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Boolean lambda$updateList$3(OptionParam optionParam, MappingObject mappingObject) {
        if (mappingObject == null) {
            return true;
        }
        if (mappingObject.getValue() == ServiceEnum.BusAnalyseType.AnalyseUsb.value1) {
            if (optionParam != null) {
                return Boolean.valueOf(optionParam.get(ServiceEnum.OptType.OPT_CM_USB));
            }
        } else if (mappingObject.getValue() == ServiceEnum.BusAnalyseType.AnalyseEth.value1 && optionParam != null) {
            return Boolean.valueOf(optionParam.get(ServiceEnum.OptType.OPT_CM_ENET));
        }
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        List<MappingObject> list;
        if (view.getId() != R.id.bus_analyse_select_value || (list = this.list) == null || list.isEmpty()) {
            return;
        }
        ViewUtil.showSpinner(this.anchor, view, this.list, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.views.busAnalyse.-$$Lambda$BusAnalysePopupView$TJQaaQO7NN8ATO4dS0h9Bia1P8U
            @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
            public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                BusAnalysePopupView.this.lambda$onClick$4$BusAnalysePopupView(view2, viewHolder, i, (MappingObject) obj);
            }
        });
    }

    public /* synthetic */ void lambda$onClick$4$BusAnalysePopupView(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        showAdapter(mappingObject);
    }

    private void showAdapter() {
        List<MappingObject> list = this.list;
        if (list == null || list.isEmpty()) {
            this.binding.busAnalyseView.setAdapter(null);
            return;
        }
        MappingObject mappingObject = this.list.get(0);
        if (mappingObject != null) {
            showAdapter(mappingObject);
        }
    }

    private void showAdapter(MappingObject mappingObject) {
        if (mappingObject == null) {
            return;
        }
        if (mappingObject.getValue() == ServiceEnum.BusAnalyseType.AnalyseUsb.value1) {
            showAdapterUsb();
        } else if (mappingObject.getValue() == ServiceEnum.BusAnalyseType.AnalyseEth.value1) {
            showAdapterEth();
        }
    }

    public void showAdapterUsb() {
        BusAnalyseParam busAnalyseParam = this.param;
        if (busAnalyseParam == null) {
            return;
        }
        busAnalyseParam.setAnalyse_select(ServiceEnum.BusAnalyseType.AnalyseUsb.value1);
        this.binding.busAnalyseView.setAdapter(this.busAnalyseUsbAdapter);
    }

    public void showAdapterEth() {
        BusAnalyseParam busAnalyseParam = this.param;
        if (busAnalyseParam == null) {
            return;
        }
        busAnalyseParam.setAnalyse_select(ServiceEnum.BusAnalyseType.AnalyseEth.value1);
        this.binding.busAnalyseView.setAdapter(this.busAnalyseEthAdapter);
    }

    public BusAnalyseEthAdapter getBusAnalyseEthAdapter() {
        return this.busAnalyseEthAdapter;
    }

    public PopupviewBusAnalyseBinding getBinding() {
        return this.binding;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rigol.scope.views.baseview.BasePopupView
    public void onPrepare() {
        super.onPrepare();
        updateList(this.optionParam);
        showAdapter();
    }
}
