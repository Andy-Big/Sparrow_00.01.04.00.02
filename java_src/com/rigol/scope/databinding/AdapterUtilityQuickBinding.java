package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.rigol.scope.R;
/* loaded from: classes2.dex */
public abstract class AdapterUtilityQuickBinding extends ViewDataBinding {
    public final ConstraintLayout layoutOperationType;
    public final TextView operationValue;
    public final RecyclerView recyclerContent;
    public final RecyclerView recyclerLable;
    public final TextView textView23;
    public final View view6;
    public final View view9;

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterUtilityQuickBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, TextView textView, RecyclerView recyclerView, RecyclerView recyclerView2, TextView textView2, View view2, View view3) {
        super(obj, view, i);
        this.layoutOperationType = constraintLayout;
        this.operationValue = textView;
        this.recyclerContent = recyclerView;
        this.recyclerLable = recyclerView2;
        this.textView23 = textView2;
        this.view6 = view2;
        this.view9 = view3;
    }

    public static AdapterUtilityQuickBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterUtilityQuickBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterUtilityQuickBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_utility_quick, viewGroup, z, obj);
    }

    public static AdapterUtilityQuickBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterUtilityQuickBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterUtilityQuickBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_utility_quick, null, false, obj);
    }

    public static AdapterUtilityQuickBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterUtilityQuickBinding bind(View view, Object obj) {
        return (AdapterUtilityQuickBinding) bind(obj, view, R.layout.adapter_utility_quick);
    }
}
