package com.rigol.scope.adapters;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.blankj.utilcode.util.ActivityUtils;
import com.rigol.scope.R;
import com.rigol.scope.cil.API;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.OptionParam;
import com.rigol.scope.databinding.AdapterItemSimple4BindingImpl;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.FunctionManager;
import com.rigol.scope.utilities.PopupViewManager;
import com.rigol.scope.viewmodels.OptionViewModel;
import com.rigol.scope.views.mask.MaskPopupView;
import com.rigol.scope.views.record.RecordPopupView;
import com.rigol.util.ToastUtils;
import java.util.List;
/* loaded from: classes.dex */
public class AnalyseAdapter extends BaseAdapter<List<ServiceEnum.Function>> {
    private List<MappingObject> mappings;
    private OptionParam optionParam;

    public AnalyseAdapter(Context context, List<ServiceEnum.Function> list, int i, List<MappingObject> list2) {
        super(context, list, i);
        OptionViewModel optionViewModel = (OptionViewModel) ContextUtil.getAppViewModel(OptionViewModel.class);
        if (optionViewModel != null) {
            optionViewModel.getLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.adapters.-$$Lambda$AnalyseAdapter$rs-p9cVFd40pW63wtBHwxQMlM0o
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    AnalyseAdapter.this.lambda$new$0$AnalyseAdapter((OptionParam) obj);
                }
            });
        }
        this.mappings = list2;
    }

    public /* synthetic */ void lambda$new$0$AnalyseAdapter(OptionParam optionParam) {
        this.optionParam = optionParam;
    }

    @Override // com.rigol.scope.adapters.BaseAdapter
    protected void convert(BaseViewHolder<? extends ViewDataBinding> baseViewHolder, List<ServiceEnum.Function> list, int i) {
        AdapterItemSimple4BindingImpl adapterItemSimple4BindingImpl = (AdapterItemSimple4BindingImpl) baseViewHolder.getBinding();
        final ServiceEnum.Function function = list.get(i);
        adapterItemSimple4BindingImpl.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.adapters.AnalyseAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i2 = AnonymousClass2.$SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[function.ordinal()];
                if (i2 == 1) {
                    FunctionManager.getInstance().toggle(ServiceEnum.Function.FUN_DVM);
                } else if (i2 == 2) {
                    FunctionManager.getInstance().toggle(ServiceEnum.Function.FUN_COUNTER);
                } else if (i2 == 3) {
                    if (API.getInstance().UI_QueryInt32(10, MessageID.MSG_ACQ_MODE) != ServiceEnum.AcquireMode.Acquire_Ultra.value1) {
                        PopupViewManager.getInstance().toggle(RecordPopupView.class);
                    } else {
                        ToastUtils.showShort(AnalyseAdapter.this.context.getResources().getString(R.string.err_action_disabled));
                    }
                } else if (i2 != 4) {
                } else {
                    if (API.getInstance().UI_QueryInt32(10, MessageID.MSG_ACQ_MODE) != ServiceEnum.AcquireMode.Acquire_Ultra.value1) {
                        PopupViewManager.getInstance().toggle(MaskPopupView.class);
                    } else {
                        ToastUtils.showShort(AnalyseAdapter.this.context.getResources().getString(R.string.err_action_disabled));
                    }
                }
            }
        });
        if (i < this.mappings.size()) {
            if (list.get(i) != null && !TextUtils.isEmpty(list.get(i).pic1)) {
                adapterItemSimple4BindingImpl.icon.setImageDrawable(ContextUtil.getDrawable(this.context, list.get(i).pic1));
            }
            adapterItemSimple4BindingImpl.text1.setText(this.mappings.get(i).getStr());
        }
    }

    /* renamed from: com.rigol.scope.adapters.AnalyseAdapter$2  reason: invalid class name */
    /* loaded from: classes.dex */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$rigol$scope$cil$ServiceEnum$Function;

        static {
            int[] iArr = new int[ServiceEnum.Function.values().length];
            $SwitchMap$com$rigol$scope$cil$ServiceEnum$Function = iArr;
            try {
                iArr[ServiceEnum.Function.FUN_DVM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[ServiceEnum.Function.FUN_COUNTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[ServiceEnum.Function.FUN_RECORD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[ServiceEnum.Function.FUN_MASK.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }
}
