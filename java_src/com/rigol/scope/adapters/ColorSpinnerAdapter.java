package com.rigol.scope.adapters;

import android.content.Context;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.databinding.AdapterItemSpinnerBinding;
import com.rigol.scope.utilities.ColorUtil;
import java.util.List;
import kotlin.Metadata;
/* compiled from: ColorSpinnerAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B'\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ2\u0010\n\u001a\u00020\u000b2\u0010\u0010\f\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u000e\u0018\u00010\r2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0006\u0010\u0010\u001a\u00020\bH\u0014¨\u0006\u0011"}, d2 = {"Lcom/rigol/scope/adapters/ColorSpinnerAdapter;", "Lcom/rigol/scope/adapters/SpinnerAdapter;", "context", "Landroid/content/Context;", "data", "", "Lcom/rigol/scope/data/MappingObject;", "width", "", "(Landroid/content/Context;Ljava/util/List;I)V", "convert", "", "holder", "Lcom/rigol/scope/adapters/BaseViewHolder;", "Landroidx/databinding/ViewDataBinding;", "mappingObjects", "position", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes.dex */
public final class ColorSpinnerAdapter extends SpinnerAdapter {
    public ColorSpinnerAdapter(Context context, List<MappingObject> list, int i) {
        super(context, list, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rigol.scope.adapters.SpinnerAdapter, com.rigol.scope.adapters.BaseAdapter
    public void convert(BaseViewHolder<? extends ViewDataBinding> baseViewHolder, List<MappingObject> list, int i) {
        MappingObject mappingObject;
        int color;
        super.convert(baseViewHolder, list, i);
        if (list == null || (mappingObject = list.get(i)) == null || (color = ColorUtil.getColor(this.context, mappingObject.getValue())) == -1) {
            return;
        }
        ViewDataBinding binding = baseViewHolder != null ? baseViewHolder.getBinding() : null;
        if (binding == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.rigol.scope.databinding.AdapterItemSpinnerBinding");
        }
        ((AdapterItemSpinnerBinding) binding).title.setTextColor(color);
    }
}
