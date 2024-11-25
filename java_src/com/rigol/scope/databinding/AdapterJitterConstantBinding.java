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
public abstract class AdapterJitterConstantBinding extends ViewDataBinding {
    public final ConstraintLayout jitterConstantLayout;
    public final TextView jitterDataRateLabel;
    public final TextView jitterDataRateValue;
    public final RadioButton jitterTypeAtuoRadioButton;
    public final TextView jitterTypeLabel;
    public final RadioButton jitterTypeManualRadioButton;
    public final RadioGroup jitterTypeRadioGroup;
    public final RadioButton jitterTypeSemiautoRadioButton;
    @Bindable
    protected JitterParam mParam;

    public abstract void setParam(JitterParam jitterParam);

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterJitterConstantBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, TextView textView, TextView textView2, RadioButton radioButton, TextView textView3, RadioButton radioButton2, RadioGroup radioGroup, RadioButton radioButton3) {
        super(obj, view, i);
        this.jitterConstantLayout = constraintLayout;
        this.jitterDataRateLabel = textView;
        this.jitterDataRateValue = textView2;
        this.jitterTypeAtuoRadioButton = radioButton;
        this.jitterTypeLabel = textView3;
        this.jitterTypeManualRadioButton = radioButton2;
        this.jitterTypeRadioGroup = radioGroup;
        this.jitterTypeSemiautoRadioButton = radioButton3;
    }

    public JitterParam getParam() {
        return this.mParam;
    }

    public static AdapterJitterConstantBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterJitterConstantBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterJitterConstantBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_jitter_constant, viewGroup, z, obj);
    }

    public static AdapterJitterConstantBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterJitterConstantBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterJitterConstantBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_jitter_constant, null, false, obj);
    }

    public static AdapterJitterConstantBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterJitterConstantBinding bind(View view, Object obj) {
        return (AdapterJitterConstantBinding) bind(obj, view, R.layout.adapter_jitter_constant);
    }
}
