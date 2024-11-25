package com.rigol.scope.adapters;

import android.content.Context;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.databinding.AdapterItemSpinnerBinding;
import java.util.List;
/* loaded from: classes.dex */
public class SpinnerAdapter extends BaseAdapter<List<MappingObject>> {
    private final int width;

    public SpinnerAdapter(Context context, List<MappingObject> list) {
        this(context, list, 130);
    }

    public SpinnerAdapter(Context context, List<MappingObject> list, int i) {
        super(context, list, R.layout.adapter_item_spinner);
        this.width = i;
    }

    @Override // com.rigol.scope.adapters.MultiItemTypeAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public BaseViewHolder<? extends ViewDataBinding> onCreateViewHolder(ViewGroup viewGroup, int i) {
        BaseViewHolder<? extends ViewDataBinding> onCreateViewHolder = super.onCreateViewHolder(viewGroup, i);
        ViewDataBinding binding = onCreateViewHolder.getBinding();
        ViewGroup.LayoutParams layoutParams = binding.getRoot().getLayoutParams();
        layoutParams.width = this.width;
        binding.getRoot().setLayoutParams(layoutParams);
        return onCreateViewHolder;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rigol.scope.adapters.BaseAdapter
    public void convert(BaseViewHolder<? extends ViewDataBinding> baseViewHolder, List<MappingObject> list, int i) {
        AdapterItemSpinnerBinding adapterItemSpinnerBinding = (AdapterItemSpinnerBinding) baseViewHolder.getBinding();
        adapterItemSpinnerBinding.title.setText(list.get(i).getStr());
        if (i == getCurrentItem()) {
            adapterItemSpinnerBinding.titleLayout.setSelected(true);
        } else {
            adapterItemSpinnerBinding.titleLayout.setSelected(false);
        }
    }
}
