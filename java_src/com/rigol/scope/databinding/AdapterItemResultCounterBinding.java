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
import com.rigol.scope.data.CounterResultParam;
/* loaded from: classes2.dex */
public abstract class AdapterItemResultCounterBinding extends ViewDataBinding {
    public final TextView avg;
    public final TextView avgTitle;
    public final TextView currentResult;
    public final ImageView icon;
    @Bindable
    protected CounterResultParam mParam;
    public final TextView max;
    public final TextView maxTitle;
    public final TextView min;
    public final TextView minTitle;
    public final ConstraintLayout resultLayout;
    public final TextView title;
    public final ConstraintLayout titleLayout;
    public final TextView type;
    public final TextView typeTitle;

    public abstract void setParam(CounterResultParam counterResultParam);

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterItemResultCounterBinding(Object obj, View view, int i, TextView textView, TextView textView2, TextView textView3, ImageView imageView, TextView textView4, TextView textView5, TextView textView6, TextView textView7, ConstraintLayout constraintLayout, TextView textView8, ConstraintLayout constraintLayout2, TextView textView9, TextView textView10) {
        super(obj, view, i);
        this.avg = textView;
        this.avgTitle = textView2;
        this.currentResult = textView3;
        this.icon = imageView;
        this.max = textView4;
        this.maxTitle = textView5;
        this.min = textView6;
        this.minTitle = textView7;
        this.resultLayout = constraintLayout;
        this.title = textView8;
        this.titleLayout = constraintLayout2;
        this.type = textView9;
        this.typeTitle = textView10;
    }

    public CounterResultParam getParam() {
        return this.mParam;
    }

    public static AdapterItemResultCounterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterItemResultCounterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterItemResultCounterBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_item_result_counter, viewGroup, z, obj);
    }

    public static AdapterItemResultCounterBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterItemResultCounterBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterItemResultCounterBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_item_result_counter, null, false, obj);
    }

    public static AdapterItemResultCounterBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterItemResultCounterBinding bind(View view, Object obj) {
        return (AdapterItemResultCounterBinding) bind(obj, view, R.layout.adapter_item_result_counter);
    }
}
