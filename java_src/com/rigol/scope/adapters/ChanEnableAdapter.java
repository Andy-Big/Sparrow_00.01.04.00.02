package com.rigol.scope.adapters;

import android.content.Context;
import androidx.collection.SparseArrayCompat;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.databinding.AdapterItemSpinnerBinding;
import com.rigol.scope.utilities.ContextUtil;
import java.util.List;
/* loaded from: classes.dex */
public class ChanEnableAdapter extends ChanSpinnerAdapter {
    private final SparseArrayCompat<Boolean> arrayCompat;

    public ChanEnableAdapter(Context context, List<MappingObject> list, SparseArrayCompat<Boolean> sparseArrayCompat) {
        this(context, list, sparseArrayCompat, 130);
    }

    public ChanEnableAdapter(Context context, List<MappingObject> list, SparseArrayCompat<Boolean> sparseArrayCompat, int i) {
        super(context, list, i);
        this.arrayCompat = sparseArrayCompat;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rigol.scope.adapters.ChanSpinnerAdapter, com.rigol.scope.adapters.SpinnerAdapter, com.rigol.scope.adapters.BaseAdapter
    public void convert(BaseViewHolder<? extends ViewDataBinding> baseViewHolder, List<MappingObject> list, int i) {
        Boolean valueAt;
        super.convert(baseViewHolder, list, i);
        AdapterItemSpinnerBinding adapterItemSpinnerBinding = (AdapterItemSpinnerBinding) baseViewHolder.getBinding();
        SparseArrayCompat<Boolean> sparseArrayCompat = this.arrayCompat;
        if (sparseArrayCompat == null || (valueAt = sparseArrayCompat.valueAt(i)) == null) {
            return;
        }
        adapterItemSpinnerBinding.getRoot().setEnabled(valueAt.booleanValue());
        adapterItemSpinnerBinding.title.setAlpha(ContextUtil.getAlpha(valueAt.booleanValue()));
    }
}
