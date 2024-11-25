package com.rigol.scope.adapters;

import android.content.Context;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
import com.rigol.scope.data.OptionInfo;
import com.rigol.scope.databinding.AdapterItemOptionBinding;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: UtilityOptionAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J0\u0010\u0007\u001a\u00020\b2\u000e\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\n2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\u000eH\u0014¨\u0006\u000f"}, d2 = {"Lcom/rigol/scope/adapters/UtilityOptionAdapter;", "Lcom/rigol/scope/adapters/BaseAdapter;", "", "Lcom/rigol/scope/data/OptionInfo;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "convert", "", "holder", "Lcom/rigol/scope/adapters/BaseViewHolder;", "Landroidx/databinding/ViewDataBinding;", "t", "position", "", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes.dex */
public final class UtilityOptionAdapter extends BaseAdapter<List<? extends OptionInfo>> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UtilityOptionAdapter(Context context) {
        super(context, R.layout.adapter_item_option);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.rigol.scope.adapters.BaseAdapter
    protected void convert(BaseViewHolder<? extends ViewDataBinding> holder, List<? extends OptionInfo> list, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        ViewDataBinding binding = holder.getBinding();
        if (!(binding instanceof AdapterItemOptionBinding) || list == null) {
            return;
        }
        AdapterItemOptionBinding adapterItemOptionBinding = (AdapterItemOptionBinding) binding;
        TextView textView = adapterItemOptionBinding.index;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.index");
        textView.setText(String.valueOf(i + 1));
        TextView textView2 = adapterItemOptionBinding.text1;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.text1");
        textView2.setText(list.get(i).getInfo());
        TextView textView3 = adapterItemOptionBinding.text2;
        Intrinsics.checkNotNullExpressionValue(textView3, "binding.text2");
        textView3.setText(list.get(i).getExp());
    }
}
