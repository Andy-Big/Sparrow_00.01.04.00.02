package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.rigol.scope.R;
import com.rigol.scope.views.busAnalyse.BusAnalyseParam;
/* loaded from: classes2.dex */
public abstract class PopupviewBusAnalyseBinding extends ViewDataBinding {
    public final View busAnalyseDivider1;
    public final TextView busAnalyseSelectLabel;
    public final TextView busAnalyseSelectValue;
    public final RecyclerView busAnalyseView;
    public final Guideline guidelineLeft;
    public final Guideline guidelineRight;
    @Bindable
    protected View.OnClickListener mOnClickListener;
    @Bindable
    protected BusAnalyseParam mParam;
    @Bindable
    protected View mView;

    public abstract void setOnClickListener(View.OnClickListener onClickListener);

    public abstract void setParam(BusAnalyseParam busAnalyseParam);

    public abstract void setView(View view);

    /* JADX INFO: Access modifiers changed from: protected */
    public PopupviewBusAnalyseBinding(Object obj, View view, int i, View view2, TextView textView, TextView textView2, RecyclerView recyclerView, Guideline guideline, Guideline guideline2) {
        super(obj, view, i);
        this.busAnalyseDivider1 = view2;
        this.busAnalyseSelectLabel = textView;
        this.busAnalyseSelectValue = textView2;
        this.busAnalyseView = recyclerView;
        this.guidelineLeft = guideline;
        this.guidelineRight = guideline2;
    }

    public View getView() {
        return this.mView;
    }

    public BusAnalyseParam getParam() {
        return this.mParam;
    }

    public View.OnClickListener getOnClickListener() {
        return this.mOnClickListener;
    }

    public static PopupviewBusAnalyseBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewBusAnalyseBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (PopupviewBusAnalyseBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_bus_analyse, viewGroup, z, obj);
    }

    public static PopupviewBusAnalyseBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewBusAnalyseBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (PopupviewBusAnalyseBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_bus_analyse, null, false, obj);
    }

    public static PopupviewBusAnalyseBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewBusAnalyseBinding bind(View view, Object obj) {
        return (PopupviewBusAnalyseBinding) bind(obj, view, R.layout.popupview_bus_analyse);
    }
}
