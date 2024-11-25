package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.rigol.scope.R;
import com.rigol.scope.data.EyeParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.views.SwitchButton;
/* loaded from: classes2.dex */
public abstract class PopupviewEyeBinding extends ViewDataBinding {
    public final Guideline centerGuideline;
    public final RadioButton eyeConstantRadioButton;
    public final View eyeDivider;
    public final View eyeDivider1;
    public final View eyeDivider2;
    public final TextView eyeEnabledLabel;
    public final RadioButton eyeExplicitRadioButton;
    public final SwitchButton eyeEyeEnSwitchButton;
    public final TextView eyeHighThresLabel;
    public final TextView eyeHighThresValue;
    public final TextView eyeLowThresLabel;
    public final TextView eyeLowThresValue;
    public final TextView eyeMeasEnLabel;
    public final SwitchButton eyeMeasEnSwitchButton;
    public final TextView eyeMidThresLabel;
    public final TextView eyeMidThresValue;
    public final TextView eyeNoiseHoldupLabel;
    public final TextView eyeNoiseHoldupValue;
    public final TextView eyePersistanceLabel;
    public final SwitchButton eyePersistanceSwitchButton;
    public final RadioButton eyePllRadioButton;
    public final TextView eyeRecoverTypeLabel;
    public final RadioGroup eyeRecoverTypeRadioGroup;
    public final RecyclerView eyeRecoverTypeView;
    public final TextView eyeSourceLabel;
    public final TextView eyeSourceValue;
    public final TextView eyeTemplate;
    public final TextView eyeTemplateStatusLabel;
    public final SwitchButton eyeTemplateStatusSwitchButton;
    public final TextView eyeTemplateValue;
    public final RadioButton fullRadioButton;
    public final TextView gridType;
    public final RadioGroup gridTypeRadioGroup;
    public final RadioButton halfRadioButton;
    public final Guideline leftGuideline;
    @Bindable
    protected MappingObject mConstantMapping;
    @Bindable
    protected MappingObject mExplicitMapping;
    @Bindable
    protected MappingObject mGridFullMapping;
    @Bindable
    protected MappingObject mGridHalfMapping;
    @Bindable
    protected MappingObject mGridNoneMapping;
    @Bindable
    protected RadioGroup.OnCheckedChangeListener mOnCheckedChangeListener;
    @Bindable
    protected View.OnClickListener mOnClickListener;
    @Bindable
    protected CompoundButton.OnCheckedChangeListener mOnSwitchCheckedChangeListener;
    @Bindable
    protected EyeParam mParam;
    @Bindable
    protected MappingObject mPllMapping;
    @Bindable
    protected View mView;
    public final RadioButton noneRadioButton;
    public final Button resetColorButton;
    public final Guideline rightGuideline;

    public abstract void setConstantMapping(MappingObject mappingObject);

    public abstract void setExplicitMapping(MappingObject mappingObject);

    public abstract void setGridFullMapping(MappingObject mappingObject);

    public abstract void setGridHalfMapping(MappingObject mappingObject);

    public abstract void setGridNoneMapping(MappingObject mappingObject);

    public abstract void setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener onCheckedChangeListener);

    public abstract void setOnClickListener(View.OnClickListener onClickListener);

    public abstract void setOnSwitchCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener);

    public abstract void setParam(EyeParam eyeParam);

    public abstract void setPllMapping(MappingObject mappingObject);

    public abstract void setView(View view);

    /* JADX INFO: Access modifiers changed from: protected */
    public PopupviewEyeBinding(Object obj, View view, int i, Guideline guideline, RadioButton radioButton, View view2, View view3, View view4, TextView textView, RadioButton radioButton2, SwitchButton switchButton, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, SwitchButton switchButton2, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, SwitchButton switchButton3, RadioButton radioButton3, TextView textView12, RadioGroup radioGroup, RecyclerView recyclerView, TextView textView13, TextView textView14, TextView textView15, TextView textView16, SwitchButton switchButton4, TextView textView17, RadioButton radioButton4, TextView textView18, RadioGroup radioGroup2, RadioButton radioButton5, Guideline guideline2, RadioButton radioButton6, Button button, Guideline guideline3) {
        super(obj, view, i);
        this.centerGuideline = guideline;
        this.eyeConstantRadioButton = radioButton;
        this.eyeDivider = view2;
        this.eyeDivider1 = view3;
        this.eyeDivider2 = view4;
        this.eyeEnabledLabel = textView;
        this.eyeExplicitRadioButton = radioButton2;
        this.eyeEyeEnSwitchButton = switchButton;
        this.eyeHighThresLabel = textView2;
        this.eyeHighThresValue = textView3;
        this.eyeLowThresLabel = textView4;
        this.eyeLowThresValue = textView5;
        this.eyeMeasEnLabel = textView6;
        this.eyeMeasEnSwitchButton = switchButton2;
        this.eyeMidThresLabel = textView7;
        this.eyeMidThresValue = textView8;
        this.eyeNoiseHoldupLabel = textView9;
        this.eyeNoiseHoldupValue = textView10;
        this.eyePersistanceLabel = textView11;
        this.eyePersistanceSwitchButton = switchButton3;
        this.eyePllRadioButton = radioButton3;
        this.eyeRecoverTypeLabel = textView12;
        this.eyeRecoverTypeRadioGroup = radioGroup;
        this.eyeRecoverTypeView = recyclerView;
        this.eyeSourceLabel = textView13;
        this.eyeSourceValue = textView14;
        this.eyeTemplate = textView15;
        this.eyeTemplateStatusLabel = textView16;
        this.eyeTemplateStatusSwitchButton = switchButton4;
        this.eyeTemplateValue = textView17;
        this.fullRadioButton = radioButton4;
        this.gridType = textView18;
        this.gridTypeRadioGroup = radioGroup2;
        this.halfRadioButton = radioButton5;
        this.leftGuideline = guideline2;
        this.noneRadioButton = radioButton6;
        this.resetColorButton = button;
        this.rightGuideline = guideline3;
    }

    public View getView() {
        return this.mView;
    }

    public EyeParam getParam() {
        return this.mParam;
    }

    public MappingObject getGridFullMapping() {
        return this.mGridFullMapping;
    }

    public MappingObject getGridHalfMapping() {
        return this.mGridHalfMapping;
    }

    public MappingObject getGridNoneMapping() {
        return this.mGridNoneMapping;
    }

    public MappingObject getConstantMapping() {
        return this.mConstantMapping;
    }

    public MappingObject getPllMapping() {
        return this.mPllMapping;
    }

    public MappingObject getExplicitMapping() {
        return this.mExplicitMapping;
    }

    public View.OnClickListener getOnClickListener() {
        return this.mOnClickListener;
    }

    public RadioGroup.OnCheckedChangeListener getOnCheckedChangeListener() {
        return this.mOnCheckedChangeListener;
    }

    public CompoundButton.OnCheckedChangeListener getOnSwitchCheckedChangeListener() {
        return this.mOnSwitchCheckedChangeListener;
    }

    public static PopupviewEyeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewEyeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (PopupviewEyeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_eye, viewGroup, z, obj);
    }

    public static PopupviewEyeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewEyeBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (PopupviewEyeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_eye, null, false, obj);
    }

    public static PopupviewEyeBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewEyeBinding bind(View view, Object obj) {
        return (PopupviewEyeBinding) bind(obj, view, R.layout.popupview_eye);
    }
}
