package com.rigol.scope.adapters;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.blankj.utilcode.util.LogUtils;
import com.rigol.scope.R;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.databinding.AdapterItemLaBinding;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.viewmodels.LaViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: FunctionAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00020\u0001B)\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ4\u0010\n\u001a\u00020\u000b2\u0010\u0010\f\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u000e\u0018\u00010\r2\u0010\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00022\u0006\u0010\u0010\u001a\u00020\bH\u0014J \u0010\u0011\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\r2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\bH\u0016¨\u0006\u0015"}, d2 = {"Lcom/rigol/scope/adapters/LaFunctionAdapter;", "Lcom/rigol/scope/adapters/BaseAdapter;", "", "Lcom/rigol/scope/data/MappingObject;", "context", "Landroid/content/Context;", "data", "layoutId", "", "(Landroid/content/Context;Ljava/util/List;I)V", "convert", "", "holder", "Lcom/rigol/scope/adapters/BaseViewHolder;", "Landroidx/databinding/ViewDataBinding;", "t", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes.dex */
public final class LaFunctionAdapter extends BaseAdapter<List<? extends MappingObject>> {
    public LaFunctionAdapter(Context context, List<? extends MappingObject> list, int i) {
        super(context, list, i);
    }

    @Override // com.rigol.scope.adapters.BaseAdapter
    protected void convert(BaseViewHolder<? extends ViewDataBinding> baseViewHolder, List<? extends MappingObject> list, int i) {
        ViewDataBinding binding = baseViewHolder != null ? baseViewHolder.getBinding() : null;
        if (binding == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.rigol.scope.databinding.AdapterItemLaBinding");
        }
        AdapterItemLaBinding adapterItemLaBinding = (AdapterItemLaBinding) binding;
        MappingObject mappingObject = list != null ? list.get(i) : null;
        TextView textView = adapterItemLaBinding.laText;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.laText");
        textView.setText(String.valueOf(mappingObject != null ? Integer.valueOf(mappingObject.getValue()) : null));
        if (((LaViewModel) ContextUtil.getAppViewModel(LaViewModel.class)).getValue().getInputLabellist64().size() > 10) {
            if (Integer.parseInt(((LaViewModel) ContextUtil.getAppViewModel(LaViewModel.class)).getValue().getInputLabellist64().get(((i + 1) * 4) - 3)) == 1) {
                adapterItemLaBinding.laText.setTextColor(this.context.getColor(R.color.chartreuse));
                LogUtils.e("chartreuse", "chartreuse");
                return;
            }
            adapterItemLaBinding.laText.setTextColor(this.context.getColor(R.color.white));
        }
    }

    @Override // com.rigol.scope.adapters.MultiItemTypeAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public BaseViewHolder<? extends ViewDataBinding> onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        BaseViewHolder<? extends ViewDataBinding> onCreateViewHolder = super.onCreateViewHolder(parent, i);
        Intrinsics.checkNotNullExpressionValue(onCreateViewHolder, "super.onCreateViewHolder(parent, viewType)");
        return onCreateViewHolder;
    }
}
