package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
import com.rigol.scope.views.DisableTouchEventRecyclerView;
import com.rigol.scope.views.histogram.MeasHistogramResultParam;
/* loaded from: classes2.dex */
public abstract class AdapterItemResultMeasHistogramBinding extends ViewDataBinding {
    public final ImageView icon;
    @Bindable
    protected MeasHistogramResultParam mParam;
    public final DisableTouchEventRecyclerView resultList;
    public final TextView title;
    public final ConstraintLayout titleLayout;

    public abstract void setParam(MeasHistogramResultParam measHistogramResultParam);

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterItemResultMeasHistogramBinding(Object obj, View view, int i, ImageView imageView, DisableTouchEventRecyclerView disableTouchEventRecyclerView, TextView textView, ConstraintLayout constraintLayout) {
        super(obj, view, i);
        this.icon = imageView;
        this.resultList = disableTouchEventRecyclerView;
        this.title = textView;
        this.titleLayout = constraintLayout;
    }

    public MeasHistogramResultParam getParam() {
        return this.mParam;
    }

    public static AdapterItemResultMeasHistogramBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterItemResultMeasHistogramBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterItemResultMeasHistogramBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_item_result_meas_histogram, viewGroup, z, obj);
    }

    public static AdapterItemResultMeasHistogramBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterItemResultMeasHistogramBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterItemResultMeasHistogramBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_item_result_meas_histogram, null, false, obj);
    }

    public static AdapterItemResultMeasHistogramBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterItemResultMeasHistogramBinding bind(View view, Object obj) {
        return (AdapterItemResultMeasHistogramBinding) bind(obj, view, R.layout.adapter_item_result_meas_histogram);
    }
}
