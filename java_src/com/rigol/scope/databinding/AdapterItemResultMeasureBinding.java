package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
import com.rigol.scope.data.MeasureResultParam;
import com.rigol.scope.views.DisableTouchEventRecyclerView;
/* loaded from: classes2.dex */
public abstract class AdapterItemResultMeasureBinding extends ViewDataBinding {
    public final ImageView arrow;
    public final TextView currentResult;
    public final ImageView icon;
    @Bindable
    protected MeasureResultParam mParam;
    public final DisableTouchEventRecyclerView resultList;
    public final TextView title;
    public final LinearLayout titleLayout;

    public abstract void setParam(MeasureResultParam measureResultParam);

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterItemResultMeasureBinding(Object obj, View view, int i, ImageView imageView, TextView textView, ImageView imageView2, DisableTouchEventRecyclerView disableTouchEventRecyclerView, TextView textView2, LinearLayout linearLayout) {
        super(obj, view, i);
        this.arrow = imageView;
        this.currentResult = textView;
        this.icon = imageView2;
        this.resultList = disableTouchEventRecyclerView;
        this.title = textView2;
        this.titleLayout = linearLayout;
    }

    public MeasureResultParam getParam() {
        return this.mParam;
    }

    public static AdapterItemResultMeasureBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterItemResultMeasureBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterItemResultMeasureBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_item_result_measure, viewGroup, z, obj);
    }

    public static AdapterItemResultMeasureBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterItemResultMeasureBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterItemResultMeasureBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_item_result_measure, null, false, obj);
    }

    public static AdapterItemResultMeasureBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterItemResultMeasureBinding bind(View view, Object obj) {
        return (AdapterItemResultMeasureBinding) bind(obj, view, R.layout.adapter_item_result_measure);
    }
}
