package com.rigol.scope.adapters;

import android.content.Context;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.databinding.AdapterItemSpinnerBinding;
import com.rigol.scope.utilities.ColorUtil;
import java.util.List;
/* loaded from: classes.dex */
public class ChanSpinnerAdapter extends SpinnerAdapter {
    public ChanSpinnerAdapter(Context context, List<MappingObject> list) {
        this(context, list, 130);
    }

    public ChanSpinnerAdapter(Context context, List<MappingObject> list, int i) {
        super(context, list, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rigol.scope.adapters.SpinnerAdapter, com.rigol.scope.adapters.BaseAdapter
    public void convert(BaseViewHolder<? extends ViewDataBinding> baseViewHolder, List<MappingObject> list, int i) {
        super.convert(baseViewHolder, list, i);
        AdapterItemSpinnerBinding adapterItemSpinnerBinding = (AdapterItemSpinnerBinding) baseViewHolder.getBinding();
        int color = ColorUtil.getColor(adapterItemSpinnerBinding.getRoot().getContext(), ServiceEnum.getChanFromValue1(list.get(i).getValue()));
        if (color != -1) {
            adapterItemSpinnerBinding.title.setTextColor(color);
        } else {
            adapterItemSpinnerBinding.title.setTextColor(-1);
        }
    }
}
