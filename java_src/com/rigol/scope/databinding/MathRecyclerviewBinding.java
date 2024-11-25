package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.rigol.scope.R;
import com.rigol.scope.data.MathParam;
import com.rigol.scope.views.SwitchButton;
/* loaded from: classes2.dex */
public abstract class MathRecyclerviewBinding extends ViewDataBinding {
    @Bindable
    protected MathParam mParam;
    public final Guideline mathGuidelineCenter;
    public final ConstraintLayout mathView;
    public final RecyclerView mathViewRecycle;
    public final TextView operation;
    public final TextView operator;
    public final TextView operatorSpinner;
    public final SwitchButton operatorSwitch;

    public abstract void setParam(MathParam mathParam);

    /* JADX INFO: Access modifiers changed from: protected */
    public MathRecyclerviewBinding(Object obj, View view, int i, Guideline guideline, ConstraintLayout constraintLayout, RecyclerView recyclerView, TextView textView, TextView textView2, TextView textView3, SwitchButton switchButton) {
        super(obj, view, i);
        this.mathGuidelineCenter = guideline;
        this.mathView = constraintLayout;
        this.mathViewRecycle = recyclerView;
        this.operation = textView;
        this.operator = textView2;
        this.operatorSpinner = textView3;
        this.operatorSwitch = switchButton;
    }

    public MathParam getParam() {
        return this.mParam;
    }

    public static MathRecyclerviewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MathRecyclerviewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MathRecyclerviewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.math_recyclerview, viewGroup, z, obj);
    }

    public static MathRecyclerviewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MathRecyclerviewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MathRecyclerviewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.math_recyclerview, null, false, obj);
    }

    public static MathRecyclerviewBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MathRecyclerviewBinding bind(View view, Object obj) {
        return (MathRecyclerviewBinding) bind(obj, view, R.layout.math_recyclerview);
    }
}
