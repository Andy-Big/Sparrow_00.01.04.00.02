package com.rigol.scope.views.analyse;

import android.view.LayoutInflater;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.rigol.scope.R;
import com.rigol.scope.adapters.AnalyseAdapter;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.databinding.PopupviewAnalyseBinding;
import com.rigol.scope.databinding.PopupviewAnalyseBindingImpl;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.viewmodels.SyncDataViewModel;
import com.rigol.scope.views.baseview.BasePopupView;
import com.rigol.scope.views.grid.GridSpaceItemDecoration;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class AnalysePopupView extends BasePopupView {
    AnalyseAdapter analyseAdapter;
    PopupviewAnalyseBinding analyseBinding;
    SyncDataViewModel syncDataView;

    public AnalysePopupView() {
        super((int) R.style.App_PopupWindow_AnalysePopupView);
        this.syncDataView = (SyncDataViewModel) ContextUtil.getAppViewModel(SyncDataViewModel.class);
        PopupviewAnalyseBinding inflate = PopupviewAnalyseBindingImpl.inflate(LayoutInflater.from(this.context));
        this.analyseBinding = inflate;
        setContentView(inflate.getRoot());
        ArrayList<ServiceEnum.Function> arrayList = new ArrayList<ServiceEnum.Function>() { // from class: com.rigol.scope.views.analyse.AnalysePopupView.1
            {
                add(ServiceEnum.Function.FUN_DVM);
                add(ServiceEnum.Function.FUN_COUNTER);
                add(ServiceEnum.Function.FUN_RECORD);
                add(ServiceEnum.Function.FUN_MASK);
            }
        };
        List<MappingObject> list = ViewUtil.getList((int) R.array.msg_app_start_menu1);
        if (ViewUtil.serialize == ServiceEnum.ProductSeries.SERIES_1000.value1 && list != null && list.size() > 2) {
            list.remove(2);
            arrayList.remove(2);
        }
        this.analyseAdapter = new AnalyseAdapter(this.context, arrayList, R.layout.adapter_item_simple4, list);
        this.analyseBinding.analyseList.addItemDecoration(new GridSpaceItemDecoration(20, true));
        this.analyseBinding.analyseList.setAdapter(this.analyseAdapter);
        this.syncDataView.get(10, MessageID.MSG_ACQ_MODE).observe((LifecycleOwner) this.context, new Observer<Object>() { // from class: com.rigol.scope.views.analyse.AnalysePopupView.2
            @Override // androidx.lifecycle.Observer
            public void onChanged(Object obj) {
                AnalysePopupView.this.analyseAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override // com.rigol.scope.views.baseview.BasePopupView
    public void onLocaleChanged() {
        super.onLocaleChanged();
        this.analyseAdapter.notifyDataSetChanged();
    }
}
