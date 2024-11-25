package com.rigol.scope.adapters;

import android.content.Context;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.VerticalParam;
import com.rigol.scope.databinding.AdapterItemVerticalBinding;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.views.vertical.VerticalPopupView;
import java.util.List;
/* loaded from: classes.dex */
public class VerticalAdapter extends BaseAdapter<List<VerticalParam>> {
    final int[] locationOnScreen;

    public VerticalAdapter(Context context, int i) {
        super(context, i);
        this.locationOnScreen = new int[2];
    }

    @Override // com.rigol.scope.adapters.BaseAdapter
    protected void convert(BaseViewHolder<? extends ViewDataBinding> baseViewHolder, List<VerticalParam> list, int i) {
        AdapterItemVerticalBinding adapterItemVerticalBinding = (AdapterItemVerticalBinding) baseViewHolder.getBinding();
        adapterItemVerticalBinding.setParam(list.get(i));
        adapterItemVerticalBinding.getRoot().setTag(VerticalPopupView.class.getSimpleName());
    }

    @Override // com.rigol.scope.adapters.MultiItemTypeAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public BaseViewHolder<? extends ViewDataBinding> onCreateViewHolder(ViewGroup viewGroup, int i) {
        BaseViewHolder<? extends ViewDataBinding> onCreateViewHolder = super.onCreateViewHolder(viewGroup, i);
        ViewUtil.addOutsideEnableClickRects(this.locationOnScreen, onCreateViewHolder.getBinding().getRoot(), VerticalPopupView.class);
        return onCreateViewHolder;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [java.util.List] */
    @Override // com.rigol.scope.adapters.MultiItemTypeAdapter
    public int getCurrentItem() {
        for (int i = 0; i < getItemCount(); i++) {
            VerticalParam verticalParam = (VerticalParam) getItems().get(i);
            if (verticalParam != null && verticalParam.getStatus() == ServiceEnum.enChanStatus.CHAN_ACTIVE) {
                return i;
            }
        }
        return 0;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.List] */
    @Override // com.rigol.scope.adapters.MultiItemTypeAdapter
    public void setCurrentItem(int i) {
        VerticalParam verticalItem = ViewUtil.getVerticalItem((List<VerticalParam>) getItems(), i);
        if (verticalItem != null) {
            verticalItem.toggleStatus();
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.List] */
    public VerticalParam getItem(int i) {
        ?? items = getItems();
        if (items == 0 || items.isEmpty() || i < 0 || i >= items.size()) {
            return null;
        }
        return (VerticalParam) items.get(i);
    }
}
