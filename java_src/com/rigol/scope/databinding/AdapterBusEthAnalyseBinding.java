package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.rigol.scope.R;
import com.rigol.scope.views.busAnalyse.BusAnalyseEthParam;
/* loaded from: classes2.dex */
public abstract class AdapterBusEthAnalyseBinding extends ViewDataBinding {
    public final Button busAnalyseEthAutoSetButton;
    public final ConstraintLayout busAnalyseEthCommonLayout;
    public final View busAnalyseEthDivider1;
    public final View busAnalyseEthDivider2;
    public final TextView busAnalyseEthSourceLabel;
    public final TextView busAnalyseEthSourceValue;
    public final Button busAnalyseEthTestButton;
    public final TextView busAnalyseEthTypeLabel;
    public final TextView busAnalyseEthTypeValue;
    public final RecyclerView busEthAnalyseView;
    public final Guideline guidelineCenter;
    public final Guideline guidelineLeft;
    public final Guideline guidelineRight;
    @Bindable
    protected View.OnClickListener mOnClickListener;
    @Bindable
    protected BusAnalyseEthParam mParam;

    public abstract void setOnClickListener(View.OnClickListener onClickListener);

    public abstract void setParam(BusAnalyseEthParam busAnalyseEthParam);

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterBusEthAnalyseBinding(Object obj, View view, int i, Button button, ConstraintLayout constraintLayout, View view2, View view3, TextView textView, TextView textView2, Button button2, TextView textView3, TextView textView4, RecyclerView recyclerView, Guideline guideline, Guideline guideline2, Guideline guideline3) {
        super(obj, view, i);
        this.busAnalyseEthAutoSetButton = button;
        this.busAnalyseEthCommonLayout = constraintLayout;
        this.busAnalyseEthDivider1 = view2;
        this.busAnalyseEthDivider2 = view3;
        this.busAnalyseEthSourceLabel = textView;
        this.busAnalyseEthSourceValue = textView2;
        this.busAnalyseEthTestButton = button2;
        this.busAnalyseEthTypeLabel = textView3;
        this.busAnalyseEthTypeValue = textView4;
        this.busEthAnalyseView = recyclerView;
        this.guidelineCenter = guideline;
        this.guidelineLeft = guideline2;
        this.guidelineRight = guideline3;
    }

    public BusAnalyseEthParam getParam() {
        return this.mParam;
    }

    public View.OnClickListener getOnClickListener() {
        return this.mOnClickListener;
    }

    public static AdapterBusEthAnalyseBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterBusEthAnalyseBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterBusEthAnalyseBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_bus_eth_analyse, viewGroup, z, obj);
    }

    public static AdapterBusEthAnalyseBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterBusEthAnalyseBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterBusEthAnalyseBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_bus_eth_analyse, null, false, obj);
    }

    public static AdapterBusEthAnalyseBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterBusEthAnalyseBinding bind(View view, Object obj) {
        return (AdapterBusEthAnalyseBinding) bind(obj, view, R.layout.adapter_bus_eth_analyse);
    }
}
