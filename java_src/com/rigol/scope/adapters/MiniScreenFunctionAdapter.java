package com.rigol.scope.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.content.ContextCompat;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.databinding.AdapterItemSimple2Binding;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: FunctionAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00020\u0001B\u0017\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ4\u0010\t\u001a\u00020\n2\u0010\u0010\u000b\u001a\f\u0012\u0006\b\u0001\u0012\u00020\r\u0018\u00010\f2\u0010\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00022\u0006\u0010\u000f\u001a\u00020\u0007H\u0014J\"\u0010\u0010\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\r0\f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0007H\u0016¨\u0006\u0014"}, d2 = {"Lcom/rigol/scope/adapters/MiniScreenFunctionAdapter;", "Lcom/rigol/scope/adapters/BaseAdapter;", "", "Lcom/rigol/scope/data/MappingObject;", "context", "Landroid/content/Context;", "layoutId", "", "(Landroid/content/Context;I)V", "convert", "", "holder", "Lcom/rigol/scope/adapters/BaseViewHolder;", "Landroidx/databinding/ViewDataBinding;", "objects", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes.dex */
public class MiniScreenFunctionAdapter extends BaseAdapter<List<? extends MappingObject>> {
    public MiniScreenFunctionAdapter(Context context, int i) {
        super(context, i);
    }

    @Override // com.rigol.scope.adapters.MultiItemTypeAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public BaseViewHolder<? extends ViewDataBinding> onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        BaseViewHolder<? extends ViewDataBinding> onCreateViewHolder = super.onCreateViewHolder(parent, i);
        Intrinsics.checkNotNullExpressionValue(onCreateViewHolder, "super.onCreateViewHolder(parent, viewType)");
        ViewDataBinding binding = onCreateViewHolder.getBinding();
        if (binding == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.rigol.scope.databinding.AdapterItemSimple2Binding");
        }
        AdapterItemSimple2Binding adapterItemSimple2Binding = (AdapterItemSimple2Binding) binding;
        View root = adapterItemSimple2Binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        root.setBackground(null);
        ImageView imageView = adapterItemSimple2Binding.icon;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.icon");
        imageView.setForeground(ContextCompat.getDrawable(this.context, R.drawable.sel_panel_item));
        adapterItemSimple2Binding.icon.setBackgroundResource(R.drawable.ic_panel_bg);
        ImageView imageView2 = adapterItemSimple2Binding.icon;
        Intrinsics.checkNotNullExpressionValue(imageView2, "binding.icon");
        ViewGroup.LayoutParams layoutParams = imageView2.getLayoutParams();
        layoutParams.width = 92;
        layoutParams.height = 92;
        if (layoutParams instanceof ConstraintLayout.LayoutParams) {
            ((ConstraintLayout.LayoutParams) layoutParams).topMargin = 0;
            ImageView imageView3 = adapterItemSimple2Binding.icon;
            Intrinsics.checkNotNullExpressionValue(imageView3, "binding.icon");
            imageView3.setLayoutParams(layoutParams);
        }
        if (adapterItemSimple2Binding.getRoot() instanceof ConstraintLayout) {
            ConstraintSet constraintSet = new ConstraintSet();
            View root2 = adapterItemSimple2Binding.getRoot();
            if (root2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
            }
            constraintSet.clone((ConstraintLayout) root2);
            constraintSet.setMargin(R.id.text1, 3, 0);
            View root3 = adapterItemSimple2Binding.getRoot();
            if (root3 == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
            }
            constraintSet.applyTo((ConstraintLayout) root3);
            adapterItemSimple2Binding.getRoot().setPadding(0, 5, 0, 0);
        }
        ImageView imageView4 = adapterItemSimple2Binding.icon;
        Intrinsics.checkNotNullExpressionValue(imageView4, "binding.icon");
        imageView4.setLayoutParams(layoutParams);
        ImageView imageView5 = adapterItemSimple2Binding.icon;
        Intrinsics.checkNotNullExpressionValue(imageView5, "binding.icon");
        imageView5.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        adapterItemSimple2Binding.text1.setTextColor(Color.rgb(209, 209, 209));
        return onCreateViewHolder;
    }

    @Override // com.rigol.scope.adapters.BaseAdapter
    protected void convert(BaseViewHolder<? extends ViewDataBinding> baseViewHolder, List<? extends MappingObject> list, int i) {
        AdapterItemSimple2Binding adapterItemSimple2Binding = (AdapterItemSimple2Binding) (baseViewHolder != null ? baseViewHolder.getBinding() : null);
        MappingObject mappingObject = list != null ? list.get(i) : null;
        Intrinsics.checkNotNull(adapterItemSimple2Binding);
        TextView textView = adapterItemSimple2Binding.text1;
        Intrinsics.checkNotNullExpressionValue(textView, "binding!!.text1");
        textView.setText(mappingObject != null ? mappingObject.getStr() : null);
        adapterItemSimple2Binding.icon.setImageDrawable(mappingObject != null ? mappingObject.getPic() : null);
    }
}
