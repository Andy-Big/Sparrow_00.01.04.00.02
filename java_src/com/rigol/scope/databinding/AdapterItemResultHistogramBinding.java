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
import com.rigol.scope.views.histogram.HistogramResultParam;
/* loaded from: classes2.dex */
public abstract class AdapterItemResultHistogramBinding extends ViewDataBinding {
    public final ImageView icon;
    @Bindable
    protected HistogramResultParam mParam;
    public final DisableTouchEventRecyclerView resultList;
    public final TextView title;
    public final ConstraintLayout titleLayout;

    public abstract void setParam(HistogramResultParam histogramResultParam);

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterItemResultHistogramBinding(Object obj, View view, int i, ImageView imageView, DisableTouchEventRecyclerView disableTouchEventRecyclerView, TextView textView, ConstraintLayout constraintLayout) {
        super(obj, view, i);
        this.icon = imageView;
        this.resultList = disableTouchEventRecyclerView;
        this.title = textView;
        this.titleLayout = constraintLayout;
    }

    public HistogramResultParam getParam() {
        return this.mParam;
    }

    public static AdapterItemResultHistogramBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterItemResultHistogramBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterItemResultHistogramBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_item_result_histogram, viewGroup, z, obj);
    }

    public static AdapterItemResultHistogramBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterItemResultHistogramBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterItemResultHistogramBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_item_result_histogram, null, false, obj);
    }

    public static AdapterItemResultHistogramBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterItemResultHistogramBinding bind(View view, Object obj) {
        return (AdapterItemResultHistogramBinding) bind(obj, view, R.layout.adapter_item_result_histogram);
    }
}
