package com.rigol.scope.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.blankj.utilcode.util.ActivityUtils;
import com.rigol.scope.R;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.OptionParam;
import com.rigol.scope.databinding.AdapterItemSimple2Binding;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.KtUtilKt;
import com.rigol.scope.viewmodels.OptionViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: FunctionAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00020\u0001B)\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ4\u0010\f\u001a\u00020\r2\u0010\u0010\u000e\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0010\u0018\u00010\u000f2\u0010\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00022\u0006\u0010\u0012\u001a\u00020\bH\u0014J \u0010\u0013\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00100\u000f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\bH\u0016R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/rigol/scope/adapters/StartMenuFunctionAdapter;", "Lcom/rigol/scope/adapters/BaseAdapter;", "", "Lcom/rigol/scope/data/MappingObject;", "context", "Landroid/content/Context;", "data", "layoutId", "", "(Landroid/content/Context;Ljava/util/List;I)V", "optionParam", "Lcom/rigol/scope/data/OptionParam;", "convert", "", "holder", "Lcom/rigol/scope/adapters/BaseViewHolder;", "Landroidx/databinding/ViewDataBinding;", "t", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes.dex */
public final class StartMenuFunctionAdapter extends BaseAdapter<List<? extends MappingObject>> {
    private OptionParam optionParam;

    public StartMenuFunctionAdapter(Context context, List<? extends MappingObject> list, int i) {
        super(context, list, i);
        LiveData<OptionParam> liveData;
        OptionViewModel optionViewModel = (OptionViewModel) ContextUtil.getAppViewModel(OptionViewModel.class);
        if (optionViewModel == null || (liveData = optionViewModel.getLiveData()) == null) {
            return;
        }
        Activity topActivity = ActivityUtils.getTopActivity();
        if (topActivity != null) {
            liveData.observe((LifecycleOwner) topActivity, new Observer<OptionParam>() { // from class: com.rigol.scope.adapters.StartMenuFunctionAdapter.1
                @Override // androidx.lifecycle.Observer
                public final void onChanged(OptionParam optionParam) {
                    Intrinsics.checkNotNullParameter(optionParam, "optionParam");
                    StartMenuFunctionAdapter.this.optionParam = optionParam;
                }
            });
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
    }

    @Override // com.rigol.scope.adapters.BaseAdapter
    protected void convert(BaseViewHolder<? extends ViewDataBinding> baseViewHolder, List<? extends MappingObject> list, int i) {
        ViewDataBinding binding = baseViewHolder != null ? baseViewHolder.getBinding() : null;
        if (binding == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.rigol.scope.databinding.AdapterItemSimple2Binding");
        }
        AdapterItemSimple2Binding adapterItemSimple2Binding = (AdapterItemSimple2Binding) binding;
        MappingObject mappingObject = list != null ? list.get(i) : null;
        TextView textView = adapterItemSimple2Binding.text1;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.text1");
        textView.setText(mappingObject != null ? mappingObject.getStr() : null);
        ServiceEnum.Function functionFromValue1 = mappingObject != null ? ServiceEnum.getFunctionFromValue1(mappingObject.getValue()) : null;
        adapterItemSimple2Binding.icon.setImageDrawable(ContextUtil.getDrawable(this.context, functionFromValue1 != null ? functionFromValue1.pic1 : null));
        boolean functionEnable = KtUtilKt.functionEnable(functionFromValue1, this.optionParam);
        View root = adapterItemSimple2Binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        root.setAlpha(ContextUtil.getAlpha(functionEnable));
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
        ConstraintSet constraintSet = new ConstraintSet();
        View root = adapterItemSimple2Binding.getRoot();
        if (root == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        }
        constraintSet.clone((ConstraintLayout) root);
        constraintSet.constrainWidth(R.id.icon, 45);
        constraintSet.constrainHeight(R.id.icon, 45);
        View root2 = adapterItemSimple2Binding.getRoot();
        if (root2 != null) {
            constraintSet.applyTo((ConstraintLayout) root2);
            return onCreateViewHolder;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
    }
}
