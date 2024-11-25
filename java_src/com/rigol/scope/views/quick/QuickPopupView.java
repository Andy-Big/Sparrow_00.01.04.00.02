package com.rigol.scope.views.quick;

import android.content.Context;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.rigol.scope.R;
import com.rigol.scope.adapters.BaseAdapter;
import com.rigol.scope.adapters.BaseViewHolder;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.databinding.AdapterItemSimpleBinding;
import com.rigol.scope.databinding.PopupviewCustomListBinding;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.views.baseview.BasePopupView;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: QuickPopupView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002\u0011\u0012B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/rigol/scope/views/quick/QuickPopupView;", "Lcom/rigol/scope/views/baseview/BasePopupView;", "dataResId", "", "(I)V", "getDataResId", "()I", "onItemClickListener", "Lcom/rigol/scope/views/quick/QuickPopupView$OnItemClickListener;", "getOnItemClickListener", "()Lcom/rigol/scope/views/quick/QuickPopupView$OnItemClickListener;", "setOnItemClickListener", "(Lcom/rigol/scope/views/quick/QuickPopupView$OnItemClickListener;)V", "quickAdapter", "Lcom/rigol/scope/views/quick/QuickPopupView$QuickAdapter;", "onLocaleChanged", "", "OnItemClickListener", "QuickAdapter", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class QuickPopupView extends BasePopupView {
    private final int dataResId;
    private OnItemClickListener onItemClickListener;
    private QuickAdapter quickAdapter;

    /* compiled from: QuickPopupView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J.\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&¨\u0006\f"}, d2 = {"Lcom/rigol/scope/views/quick/QuickPopupView$OnItemClickListener;", "", "onItemClick", "", "view", "Landroid/view/View;", "holder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "position", "", "item", "Lcom/rigol/scope/data/MappingObject;", "app_release"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes2.dex */
    public interface OnItemClickListener {
        void onItemClick(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject);
    }

    public QuickPopupView(int i) {
        super((int) R.style.App_PopupWindow_MeasureQuickSetting);
        this.dataResId = i;
        setOutsideTouchable(true);
        PopupviewCustomListBinding inflate = PopupviewCustomListBinding.inflate(LayoutInflater.from(this.context));
        Intrinsics.checkNotNullExpressionValue(inflate, "PopupviewCustomListBindi…utInflater.from(context))");
        setContentView(inflate.getRoot());
        this.quickAdapter = new QuickAdapter(this.context, ViewUtil.getList(this.dataResId), R.layout.adapter_item_simple);
        RecyclerView recyclerView = inflate.recyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.recyclerView");
        recyclerView.setAdapter(this.quickAdapter);
        QuickAdapter quickAdapter = this.quickAdapter;
        if (quickAdapter != null) {
            quickAdapter.setOnItemClickListener(new com.rigol.scope.adapters.OnItemClickListener() { // from class: com.rigol.scope.views.quick.QuickPopupView.1
                /* JADX WARN: Type inference failed for: r1v4, types: [java.util.List] */
                @Override // com.rigol.scope.adapters.OnItemClickListener
                public final void onItemClick(View view, RecyclerView.ViewHolder viewHolder, int i2) {
                    ?? items;
                    OnItemClickListener onItemClickListener = QuickPopupView.this.getOnItemClickListener();
                    if (onItemClickListener != null) {
                        QuickAdapter quickAdapter2 = QuickPopupView.this.quickAdapter;
                        onItemClickListener.onItemClick(view, viewHolder, i2, (quickAdapter2 == null || (items = quickAdapter2.getItems()) == 0) ? null : (MappingObject) items.get(i2));
                    }
                    QuickPopupView.this.dismiss();
                }
            });
        }
    }

    public final int getDataResId() {
        return this.dataResId;
    }

    /* compiled from: QuickPopupView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00020\u0001B)\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ4\u0010\n\u001a\u00020\u000b2\u0010\u0010\f\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u000e\u0018\u00010\r2\u0010\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00022\u0006\u0010\u0010\u001a\u00020\bH\u0014J\"\u0010\u0011\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000e0\r2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\bH\u0016¨\u0006\u0015"}, d2 = {"Lcom/rigol/scope/views/quick/QuickPopupView$QuickAdapter;", "Lcom/rigol/scope/adapters/BaseAdapter;", "", "Lcom/rigol/scope/data/MappingObject;", "context", "Landroid/content/Context;", "data", "layoutId", "", "(Landroid/content/Context;Ljava/util/List;I)V", "convert", "", "holder", "Lcom/rigol/scope/adapters/BaseViewHolder;", "Landroidx/databinding/ViewDataBinding;", "t", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "app_release"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes2.dex */
    public static final class QuickAdapter extends BaseAdapter<List<? extends MappingObject>> {
        public QuickAdapter(Context context, List<? extends MappingObject> list, int i) {
            super(context, list, i);
        }

        @Override // com.rigol.scope.adapters.MultiItemTypeAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
        public BaseViewHolder<? extends ViewDataBinding> onCreateViewHolder(ViewGroup parent, int i) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            BaseViewHolder<? extends ViewDataBinding> onCreateViewHolder = super.onCreateViewHolder(parent, i);
            Intrinsics.checkNotNullExpressionValue(onCreateViewHolder, "super.onCreateViewHolder(parent, viewType)");
            ViewDataBinding binding = onCreateViewHolder.getBinding();
            if (binding == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.rigol.scope.databinding.AdapterItemSimpleBinding");
            }
            AdapterItemSimpleBinding adapterItemSimpleBinding = (AdapterItemSimpleBinding) binding;
            ImageView imageView = adapterItemSimpleBinding.icon;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.icon");
            imageView.setVisibility(8);
            TextView textView = adapterItemSimpleBinding.text1;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.text1");
            textView.setGravity(17);
            View root = adapterItemSimpleBinding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.root");
            ViewGroup.LayoutParams layoutParams = root.getLayoutParams();
            layoutParams.height = 50;
            View root2 = adapterItemSimpleBinding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root2, "binding.root");
            root2.setLayoutParams(layoutParams);
            TypedValue typedValue = new TypedValue();
            View root3 = adapterItemSimpleBinding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root3, "binding.root");
            Context context = root3.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "binding.root.context");
            context.getTheme().resolveAttribute(16843534, typedValue, true);
            View root4 = adapterItemSimpleBinding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root4, "binding.root");
            View root5 = adapterItemSimpleBinding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root5, "binding.root");
            root4.setForeground(ContextCompat.getDrawable(root5.getContext(), typedValue.resourceId));
            return onCreateViewHolder;
        }

        @Override // com.rigol.scope.adapters.BaseAdapter
        protected void convert(BaseViewHolder<? extends ViewDataBinding> baseViewHolder, List<? extends MappingObject> list, int i) {
            MappingObject mappingObject;
            AdapterItemSimpleBinding adapterItemSimpleBinding = (AdapterItemSimpleBinding) (baseViewHolder != null ? baseViewHolder.getBinding() : null);
            Intrinsics.checkNotNull(adapterItemSimpleBinding);
            TextView textView = adapterItemSimpleBinding.text1;
            Intrinsics.checkNotNullExpressionValue(textView, "binding!!.text1");
            textView.setText((list == null || (mappingObject = list.get(i)) == null || (r3 = mappingObject.getStr()) == null) ? "" : "");
        }
    }

    public final OnItemClickListener getOnItemClickListener() {
        return this.onItemClickListener;
    }

    public final void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override // com.rigol.scope.views.baseview.BasePopupView
    public void onLocaleChanged() {
        super.onLocaleChanged();
        QuickAdapter quickAdapter = this.quickAdapter;
        if (quickAdapter != null) {
            quickAdapter.setItems(ViewUtil.getList(this.dataResId));
        }
        QuickAdapter quickAdapter2 = this.quickAdapter;
        if (quickAdapter2 != null) {
            quickAdapter2.notifyDataSetChanged();
        }
    }
}
