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
/* loaded from: classes2.dex */
public abstract class AdapterDecodeLinBinding extends ViewDataBinding {
    public final RadioButton decodeLin1xRadioButton;
    public final RadioButton decodeLin2xRadioButton;
    public final TextView decodeLinBaudLabel;
    public final TextView decodeLinBaudValue;
    public final RadioButton decodeLinBothRadioButton;
    public final ConstraintLayout decodeLinLayout;
    public final TextView decodeLinParityLabel;
    public final RadioGroup decodeLinParityRadioGroup;
    public final TextView decodeLinSrcLabel;
    public final TextView decodeLinSrcValue;
    public final TextView decodeLinThresLabel;
    public final TextView decodeLinThresValue;
    public final TextView decodeLinVerLabel;
    public final RadioGroup decodeLinVersionRadioGroup;
    public final RadioButton decodeLinWithRadioButton;
    public final RadioButton decodeLinWithoutRadioButton;
    public final Guideline guideline33;
    public final Guideline guideline66;
    public final Guideline guidelineCenter;
    public final Guideline guidelineLeft;
    public final Guideline guidelineRight;
    @Bindable
    protected DecodeParam mParam;
    @Bindable
    protected MappingObject mParityWithMapping;
    @Bindable
    protected MappingObject mParityWithoutMapping;
    @Bindable
    protected MappingObject mVer1Mapping;
    @Bindable
    protected MappingObject mVer2Mapping;
    @Bindable
    protected MappingObject mVerBothMapping;

    public abstract void setParam(DecodeParam decodeParam);

    public abstract void setParityWithMapping(MappingObject mappingObject);

    public abstract void setParityWithoutMapping(MappingObject mappingObject);

    public abstract void setVer1Mapping(MappingObject mappingObject);

    public abstract void setVer2Mapping(MappingObject mappingObject);

    public abstract void setVerBothMapping(MappingObject mappingObject);

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterDecodeLinBinding(Object obj, View view, int i, RadioButton radioButton, RadioButton radioButton2, TextView textView, TextView textView2, RadioButton radioButton3, ConstraintLayout constraintLayout, TextView textView3, RadioGroup radioGroup, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, RadioGroup radioGroup2, RadioButton radioButton4, RadioButton radioButton5, Guideline guideline, Guideline guideline2, Guideline guideline3, Guideline guideline4, Guideline guideline5) {
        super(obj, view, i);
        this.decodeLin1xRadioButton = radioButton;
        this.decodeLin2xRadioButton = radioButton2;
        this.decodeLinBaudLabel = textView;
        this.decodeLinBaudValue = textView2;
        this.decodeLinBothRadioButton = radioButton3;
        this.decodeLinLayout = constraintLayout;
        this.decodeLinParityLabel = textView3;
        this.decodeLinParityRadioGroup = radioGroup;
        this.decodeLinSrcLabel = textView4;
        this.decodeLinSrcValue = textView5;
        this.decodeLinThresLabel = textView6;
        this.decodeLinThresValue = textView7;
        this.decodeLinVerLabel = textView8;
        this.decodeLinVersionRadioGroup = radioGroup2;
        this.decodeLinWithRadioButton = radioButton4;
        this.decodeLinWithoutRadioButton = radioButton5;
        this.guideline33 = guideline;
        this.guideline66 = guideline2;
        this.guidelineCenter = guideline3;
        this.guidelineLeft = guideline4;
        this.guidelineRight = guideline5;
    }

    public DecodeParam getParam() {
        return this.mParam;
    }

    public MappingObject getParityWithoutMapping() {
        return this.mParityWithoutMapping;
    }

    public MappingObject getParityWithMapping() {
        return this.mParityWithMapping;
    }

    public MappingObject getVer1Mapping() {
        return this.mVer1Mapping;
    }

    public MappingObject getVer2Mapping() {
        return this.mVer2Mapping;
    }

    public MappingObject getVerBothMapping() {
        return this.mVerBothMapping;
    }

    public static AdapterDecodeLinBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterDecodeLinBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterDecodeLinBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_decode_lin, viewGroup, z, obj);
    }

    public static AdapterDecodeLinBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterDecodeLinBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterDecodeLinBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_decode_lin, null, false, obj);
    }

    public static AdapterDecodeLinBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterDecodeLinBinding bind(View view, Object obj) {
        return (AdapterDecodeLinBinding) bind(obj, view, R.layout.adapter_decode_lin);
    }
}
