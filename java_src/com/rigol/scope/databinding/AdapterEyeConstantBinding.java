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
public abstract class AdapterEyeConstantBinding extends ViewDataBinding {
    public final ConstraintLayout eyeConstantLayout;
    public final TextView eyeDataRateLabel;
    public final TextView eyeDataRateValue;
    public final RadioButton eyeTypeAtuoRadioButton;
    public final TextView eyeTypeLabel;
    public final RadioButton eyeTypeManualRadioButton;
    public final RadioGroup eyeTypeRadioGroup;
    public final RadioButton eyeTypeSemiautoRadioButton;
    public final Guideline leftGuideline;
    @Bindable
    protected MappingObject mAtuoMapping;
    @Bindable
    protected MappingObject mManualMapping;
    @Bindable
    protected RadioGroup.OnCheckedChangeListener mOnCheckedChangeListener;
    @Bindable
    protected View.OnClickListener mOnClickListener;
    @Bindable
    protected EyeParam mParam;
    @Bindable
    protected MappingObject mSemiautoMapping;
    public final Guideline rightGuideline;

    public abstract void setAtuoMapping(MappingObject mappingObject);

    public abstract void setManualMapping(MappingObject mappingObject);

    public abstract void setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener onCheckedChangeListener);

    public abstract void setOnClickListener(View.OnClickListener onClickListener);

    public abstract void setParam(EyeParam eyeParam);

    public abstract void setSemiautoMapping(MappingObject mappingObject);

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterEyeConstantBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, TextView textView, TextView textView2, RadioButton radioButton, TextView textView3, RadioButton radioButton2, RadioGroup radioGroup, RadioButton radioButton3, Guideline guideline, Guideline guideline2) {
        super(obj, view, i);
        this.eyeConstantLayout = constraintLayout;
        this.eyeDataRateLabel = textView;
        this.eyeDataRateValue = textView2;
        this.eyeTypeAtuoRadioButton = radioButton;
        this.eyeTypeLabel = textView3;
        this.eyeTypeManualRadioButton = radioButton2;
        this.eyeTypeRadioGroup = radioGroup;
        this.eyeTypeSemiautoRadioButton = radioButton3;
        this.leftGuideline = guideline;
        this.rightGuideline = guideline2;
    }

    public EyeParam getParam() {
        return this.mParam;
    }

    public MappingObject getAtuoMapping() {
        return this.mAtuoMapping;
    }

    public MappingObject getSemiautoMapping() {
        return this.mSemiautoMapping;
    }

    public MappingObject getManualMapping() {
        return this.mManualMapping;
    }

    public View.OnClickListener getOnClickListener() {
        return this.mOnClickListener;
    }

    public RadioGroup.OnCheckedChangeListener getOnCheckedChangeListener() {
        return this.mOnCheckedChangeListener;
    }

    public static AdapterEyeConstantBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterEyeConstantBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterEyeConstantBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_eye_constant, viewGroup, z, obj);
    }

    public static AdapterEyeConstantBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterEyeConstantBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterEyeConstantBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_eye_constant, null, false, obj);
    }

    public static AdapterEyeConstantBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterEyeConstantBinding bind(View view, Object obj) {
        return (AdapterEyeConstantBinding) bind(obj, view, R.layout.adapter_eye_constant);
    }
}
