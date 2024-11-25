package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.rigol.scope.R;
import com.rigol.scope.data.MeasureSettingParam;
/* loaded from: classes2.dex */
public abstract class FragmentResultsBarBinding extends ViewDataBinding {
    @Bindable
    protected MeasureSettingParam mParam;
    public final ConstraintLayout resultLayout;
    public final RecyclerView resultList;
    public final TextView resultTitle;
    public final View resultTitleBg;

    public abstract void setParam(MeasureSettingParam measureSettingParam);

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentResultsBarBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, RecyclerView recyclerView, TextView textView, View view2) {
        super(obj, view, i);
        this.resultLayout = constraintLayout;
        this.resultList = recyclerView;
        this.resultTitle = textView;
        this.resultTitleBg = view2;
    }

    public MeasureSettingParam getParam() {
        return this.mParam;
    }

    public static FragmentResultsBarBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentResultsBarBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentResultsBarBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_results_bar, viewGroup, z, obj);
    }

    public static FragmentResultsBarBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentResultsBarBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentResultsBarBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_results_bar, null, false, obj);
    }

    public static FragmentResultsBarBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentResultsBarBinding bind(View view, Object obj) {
        return (FragmentResultsBarBinding) bind(obj, view, R.layout.fragment_results_bar);
    }
}
