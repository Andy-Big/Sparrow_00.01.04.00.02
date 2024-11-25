package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
import com.rigol.scope.data.JitterParam;
/* loaded from: classes2.dex */
public abstract class AdapterJitterPllBinding extends ViewDataBinding {
    public final TextView jitterDampFactorLabel;
    public final TextView jitterDampFactorValue;
    public final TextView jitterDataRateLabel;
    public final TextView jitterDataRateValue;
    public final RadioButton jitterFirstOrderRadioButton;
    public final ConstraintLayout jitterPllLayout;
    public final TextView jitterPllOrderLabel;
    public final RadioGroup jitterPllOrderRadioGroup;
    public final TextView jitterPllWidthLabel;
    public final TextView jitterPllWidthValue;
    public final RadioButton jitterSecondOrderRadioButton;
    @Bindable
    protected JitterParam mParam;

    public abstract void setParam(JitterParam jitterParam);

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterJitterPllBinding(Object obj, View view, int i, TextView textView, TextView textView2, TextView textView3, TextView textView4, RadioButton radioButton, ConstraintLayout constraintLayout, TextView textView5, RadioGroup radioGroup, TextView textView6, TextView textView7, RadioButton radioButton2) {
        super(obj, view, i);
        this.jitterDampFactorLabel = textView;
        this.jitterDampFactorValue = textView2;
        this.jitterDataRateLabel = textView3;
        this.jitterDataRateValue = textView4;
        this.jitterFirstOrderRadioButton = radioButton;
        this.jitterPllLayout = constraintLayout;
        this.jitterPllOrderLabel = textView5;
        this.jitterPllOrderRadioGroup = radioGroup;
        this.jitterPllWidthLabel = textView6;
        this.jitterPllWidthValue = textView7;
        this.jitterSecondOrderRadioButton = radioButton2;
    }

    public JitterParam getParam() {
        return this.mParam;
    }

    public static AdapterJitterPllBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterJitterPllBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterJitterPllBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_jitter_pll, viewGroup, z, obj);
    }

    public static AdapterJitterPllBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterJitterPllBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterJitterPllBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_jitter_pll, null, false, obj);
    }

    public static AdapterJitterPllBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterJitterPllBinding bind(View view, Object obj) {
        return (AdapterJitterPllBinding) bind(obj, view, R.layout.adapter_jitter_pll);
    }
}
