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
import com.rigol.scope.data.DecodeParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.views.SwitchButton;
/* loaded from: classes2.dex */
public abstract class AdapterDecodeI2cBinding extends ViewDataBinding {
    public final TextView decodeI2cClkLabel;
    public final TextView decodeI2cClkValue;
    public final TextView decodeI2cExcLabel;
    public final SwitchButton decodeI2cExcSwtichButton;
    public final ConstraintLayout decodeI2cLayout;
    public final TextView decodeI2cRwLabel;
    public final RadioGroup decodeI2cRwRadioGroup;
    public final RadioButton decodeI2cRwWithRadioButton;
    public final RadioButton decodeI2cRwWithoutRadioButton;
    public final TextView decodeI2cSclThresLabel;
    public final TextView decodeI2cSclThresValue;
    public final TextView decodeI2cSdaLabel;
    public final TextView decodeI2cSdaThresLabel;
    public final TextView decodeI2cSdaThresValue;
    public final TextView decodeI2cSdaValue;
    public final Guideline guideline33;
    public final Guideline guideline66;
    public final Guideline guidelineCenter;
    public final Guideline guidelineLeft;
    public final Guideline guidelineRight;
    public final Guideline guidelineRightest;
    @Bindable
    protected MappingObject mChannelAMapping;
    @Bindable
    protected MappingObject mChannelBMapping;
    @Bindable
    protected DecodeParam mParam;
    @Bindable
    protected MappingObject mRwWithMapping;
    @Bindable
    protected MappingObject mRwWithoutMapping;

    public abstract void setChannelAMapping(MappingObject mappingObject);

    public abstract void setChannelBMapping(MappingObject mappingObject);

    public abstract void setParam(DecodeParam decodeParam);

    public abstract void setRwWithMapping(MappingObject mappingObject);

    public abstract void setRwWithoutMapping(MappingObject mappingObject);

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterDecodeI2cBinding(Object obj, View view, int i, TextView textView, TextView textView2, TextView textView3, SwitchButton switchButton, ConstraintLayout constraintLayout, TextView textView4, RadioGroup radioGroup, RadioButton radioButton, RadioButton radioButton2, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, Guideline guideline, Guideline guideline2, Guideline guideline3, Guideline guideline4, Guideline guideline5, Guideline guideline6) {
        super(obj, view, i);
        this.decodeI2cClkLabel = textView;
        this.decodeI2cClkValue = textView2;
        this.decodeI2cExcLabel = textView3;
        this.decodeI2cExcSwtichButton = switchButton;
        this.decodeI2cLayout = constraintLayout;
        this.decodeI2cRwLabel = textView4;
        this.decodeI2cRwRadioGroup = radioGroup;
        this.decodeI2cRwWithRadioButton = radioButton;
        this.decodeI2cRwWithoutRadioButton = radioButton2;
        this.decodeI2cSclThresLabel = textView5;
        this.decodeI2cSclThresValue = textView6;
        this.decodeI2cSdaLabel = textView7;
        this.decodeI2cSdaThresLabel = textView8;
        this.decodeI2cSdaThresValue = textView9;
        this.decodeI2cSdaValue = textView10;
        this.guideline33 = guideline;
        this.guideline66 = guideline2;
        this.guidelineCenter = guideline3;
        this.guidelineLeft = guideline4;
        this.guidelineRight = guideline5;
        this.guidelineRightest = guideline6;
    }

    public DecodeParam getParam() {
        return this.mParam;
    }

    public MappingObject getChannelAMapping() {
        return this.mChannelAMapping;
    }

    public MappingObject getChannelBMapping() {
        return this.mChannelBMapping;
    }

    public MappingObject getRwWithMapping() {
        return this.mRwWithMapping;
    }

    public MappingObject getRwWithoutMapping() {
        return this.mRwWithoutMapping;
    }

    public static AdapterDecodeI2cBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterDecodeI2cBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterDecodeI2cBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_decode_i2c, viewGroup, z, obj);
    }

    public static AdapterDecodeI2cBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterDecodeI2cBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterDecodeI2cBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_decode_i2c, null, false, obj);
    }

    public static AdapterDecodeI2cBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterDecodeI2cBinding bind(View view, Object obj) {
        return (AdapterDecodeI2cBinding) bind(obj, view, R.layout.adapter_decode_i2c);
    }
}
