package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
import com.rigol.scope.data.UtilityParam;
/* loaded from: classes2.dex */
public abstract class AdapterUtilityAllmeasureBinding extends ViewDataBinding {
    @Bindable
    protected UtilityParam mParam;
    public final TextView tvAllmeasure;
    public final TextView tvAllmeasureValue;

    public abstract void setParam(UtilityParam utilityParam);

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterUtilityAllmeasureBinding(Object obj, View view, int i, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.tvAllmeasure = textView;
        this.tvAllmeasureValue = textView2;
    }

    public UtilityParam getParam() {
        return this.mParam;
    }

    public static AdapterUtilityAllmeasureBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterUtilityAllmeasureBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterUtilityAllmeasureBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_utility_allmeasure, viewGroup, z, obj);
    }

    public static AdapterUtilityAllmeasureBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterUtilityAllmeasureBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterUtilityAllmeasureBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_utility_allmeasure, null, false, obj);
    }

    public static AdapterUtilityAllmeasureBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterUtilityAllmeasureBinding bind(View view, Object obj) {
        return (AdapterUtilityAllmeasureBinding) bind(obj, view, R.layout.adapter_utility_allmeasure);
    }
}
