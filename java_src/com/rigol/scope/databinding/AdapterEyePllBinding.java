package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
import com.rigol.scope.data.EyeParam;
import com.rigol.scope.data.MappingObject;
/* loaded from: classes2.dex */
public abstract class AdapterEyePllBinding extends ViewDataBinding {
    public final Guideline centerGuideline;
    public final TextView eyeDampFactorLabel;
    public final TextView eyeDampFactorValue;
    public final TextView eyeDataRateLabel;
    public final TextView eyeDataRateValue;
    public final RadioButton eyeFirstOrderRadioButton;
    public final ConstraintLayout eyePllLayout;
    public final TextView eyePllOrderLabel;
    public final RadioGroup eyePllOrderRadioGroup;
    public final TextView eyePllWidthLabel;
    public final TextView eyePllWidthValue;
    public final RadioButton eyeSecondOrderRadioButton;
    public final Guideline leftGuideline;
    @Bindable
    protected MappingObject mFirstOrderMapping;
    @Bindable
    protected RadioGroup.OnCheckedChangeListener mOnCheckedChangeListener;
    @Bindable
    protected View.OnClickListener mOnClickListener;
    @Bindable
    protected EyeParam mParam;
    @Bindable
    protected MappingObject mSecondOrderMapping;
    public final Guideline rightGuideline;

    public abstract void setFirstOrderMapping(MappingObject mappingObject);

    public abstract void setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener onCheckedChangeListener);

    public abstract void setOnClickListener(View.OnClickListener onClickListener);

    public abstract void setParam(EyeParam eyeParam);

    public abstract void setSecondOrderMapping(MappingObject mappingObject);

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterEyePllBinding(Object obj, View view, int i, Guideline guideline, TextView textView, TextView textView2, TextView textView3, TextView textView4, RadioButton radioButton, ConstraintLayout constraintLayout, TextView textView5, RadioGroup radioGroup, TextView textView6, TextView textView7, RadioButton radioButton2, Guideline guideline2, Guideline guideline3) {
        super(obj, view, i);
        this.centerGuideline = guideline;
        this.eyeDampFactorLabel = textView;
        this.eyeDampFactorValue = textView2;
        this.eyeDataRateLabel = textView3;
        this.eyeDataRateValue = textView4;
        this.eyeFirstOrderRadioButton = radioButton;
        this.eyePllLayout = constraintLayout;
        this.eyePllOrderLabel = textView5;
        this.eyePllOrderRadioGroup = radioGroup;
        this.eyePllWidthLabel = textView6;
        this.eyePllWidthValue = textView7;
        this.eyeSecondOrderRadioButton = radioButton2;
        this.leftGuideline = guideline2;
        this.rightGuideline = guideline3;
    }

    public EyeParam getParam() {
        return this.mParam;
    }

    public MappingObject getFirstOrderMapping() {
        return this.mFirstOrderMapping;
    }

    public MappingObject getSecondOrderMapping() {
        return this.mSecondOrderMapping;
    }

    public View.OnClickListener getOnClickListener() {
        return this.mOnClickListener;
    }

    public RadioGroup.OnCheckedChangeListener getOnCheckedChangeListener() {
        return this.mOnCheckedChangeListener;
    }

    public static AdapterEyePllBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterEyePllBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterEyePllBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_eye_pll, viewGroup, z, obj);
    }

    public static AdapterEyePllBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterEyePllBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterEyePllBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_eye_pll, null, false, obj);
    }

    public static AdapterEyePllBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterEyePllBinding bind(View view, Object obj) {
        return (AdapterEyePllBinding) bind(obj, view, R.layout.adapter_eye_pll);
    }
}
