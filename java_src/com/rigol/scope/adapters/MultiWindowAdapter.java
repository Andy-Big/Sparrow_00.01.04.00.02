package com.rigol.scope.adapters;

import android.content.Context;
import android.text.TextUtils;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.blankj.utilcode.util.ActivityUtils;
import com.rigol.scope.R;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.OptionParam;
import com.rigol.scope.databinding.AdapterItemSimple2Binding;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.KtUtilKt;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.viewmodels.OptionViewModel;
import java.util.List;
/* loaded from: classes.dex */
public class MultiWindowAdapter extends BaseAdapter<List<ServiceEnum.WindowType>> {
    private OptionParam optionParam;

    public MultiWindowAdapter(Context context, List<ServiceEnum.WindowType> list, int i) {
        super(context, list, i);
        OptionViewModel optionViewModel = (OptionViewModel) ContextUtil.getAppViewModel(OptionViewModel.class);
        if (optionViewModel != null) {
            optionViewModel.getLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.adapters.-$$Lambda$MultiWindowAdapter$jwAnnPQanAn9FC0EotErMT9l58M
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    MultiWindowAdapter.this.lambda$new$0$MultiWindowAdapter((OptionParam) obj);
                }
            });
        }
    }

    public /* synthetic */ void lambda$new$0$MultiWindowAdapter(OptionParam optionParam) {
        this.optionParam = optionParam;
    }

    @Override // com.rigol.scope.adapters.BaseAdapter
    protected void convert(BaseViewHolder<? extends ViewDataBinding> baseViewHolder, List<ServiceEnum.WindowType> list, int i) {
        AdapterItemSimple2Binding adapterItemSimple2Binding = (AdapterItemSimple2Binding) baseViewHolder.getBinding();
        ServiceEnum.WindowType windowType = list.get(i);
        MappingObject mappingObject = ViewUtil.getMappingObject(R.array.window_type_list, windowType.value1);
        if (mappingObject != null) {
            adapterItemSimple2Binding.text1.setText(mappingObject.getStr());
        }
        if (list.get(i) != null && !TextUtils.isEmpty(list.get(i).pic1)) {
            adapterItemSimple2Binding.icon.setImageDrawable(ContextUtil.getDrawable(this.context, list.get(i).pic1));
        }
        adapterItemSimple2Binding.getRoot().setSelected(i == getCurrentItem());
        adapterItemSimple2Binding.getRoot().setAlpha(ContextUtil.getAlpha(KtUtilKt.windowTypeEnable(windowType, this.optionParam)));
    }
}
