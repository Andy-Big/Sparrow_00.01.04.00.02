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
public abstract class AdapterDecodeI2sBinding extends ViewDataBinding {
    public final TextView decodeI2sAlignLabel;
    public final TextView decodeI2sAlignValue;
    public final TextView decodeI2sDataLabel;
    public final TextView decodeI2sDataThresLabel;
    public final TextView decodeI2sDataThresValue;
    public final TextView decodeI2sDataValue;
    public final RadioButton decodeI2sEndianLSBRadioButton;
    public final TextView decodeI2sEndianLabel;
    public final RadioButton decodeI2sEndianMSBRadioButton;
    public final RadioGroup decodeI2sEndianRadioGroup;
    public final ConstraintLayout decodeI2sLayout;
    public final TextView decodeI2sPolLabel;
    public final RadioButton decodeI2sPolNegativeRadioButton;
    public final RadioButton decodeI2sPolPositiveRadioButton;
    public final RadioGroup decodeI2sPolRadioGroup;
    public final TextView decodeI2sReceiveLabel;
    public final TextView decodeI2sReceiveValue;
    public final TextView decodeI2sSclkLabel;
    public final TextView decodeI2sSclkThresLabel;
    public final TextView decodeI2sSclkThresValue;
    public final TextView decodeI2sSclkValue;
    public final RadioButton decodeI2sSclkedgeDownRadioButton;
    public final TextView decodeI2sSclkedgeLabel;
    public final RadioGroup decodeI2sSclkedgeRadioGroup;
    public final RadioButton decodeI2sSclkedgeUpRadioButton;
    public final TextView decodeI2sWordLabel;
    public final TextView decodeI2sWordValue;
    public final TextView decodeI2sWsLabel;
    public final TextView decodeI2sWsThreLabel;
    public final TextView decodeI2sWsThresValue;
    public final TextView decodeI2sWsValue;
    public final TextView decodeI2sWslowLabel;
    public final TextView decodeI2sWslowValue;
    public final View divider1;
    public final Guideline guideline33;
    public final Guideline guideline66;
    public final Guideline guidelineCenter;
    public final Guideline guidelineLeft;
    public final Guideline guidelineRight;
    @Bindable
    protected MappingObject mDataNegativeMapping;
    @Bindable
    protected MappingObject mDataPositiveMapping;
    @Bindable
    protected MappingObject mEdgeDownMapping;
    @Bindable
    protected MappingObject mEdgeUpMapping;
    @Bindable
    protected MappingObject mEndianLsbMapping;
    @Bindable
    protected MappingObject mEndianMsbMapping;
    @Bindable
    protected DecodeParam mParam;

    public abstract void setDataNegativeMapping(MappingObject mappingObject);

    public abstract void setDataPositiveMapping(MappingObject mappingObject);

    public abstract void setEdgeDownMapping(MappingObject mappingObject);

    public abstract void setEdgeUpMapping(MappingObject mappingObject);

    public abstract void setEndianLsbMapping(MappingObject mappingObject);

    public abstract void setEndianMsbMapping(MappingObject mappingObject);

    public abstract void setParam(DecodeParam decodeParam);

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterDecodeI2sBinding(Object obj, View view, int i, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, RadioButton radioButton, TextView textView7, RadioButton radioButton2, RadioGroup radioGroup, ConstraintLayout constraintLayout, TextView textView8, RadioButton radioButton3, RadioButton radioButton4, RadioGroup radioGroup2, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, RadioButton radioButton5, TextView textView15, RadioGroup radioGroup3, RadioButton radioButton6, TextView textView16, TextView textView17, TextView textView18, TextView textView19, TextView textView20, TextView textView21, TextView textView22, TextView textView23, View view2, Guideline guideline, Guideline guideline2, Guideline guideline3, Guideline guideline4, Guideline guideline5) {
        super(obj, view, i);
        this.decodeI2sAlignLabel = textView;
        this.decodeI2sAlignValue = textView2;
        this.decodeI2sDataLabel = textView3;
        this.decodeI2sDataThresLabel = textView4;
        this.decodeI2sDataThresValue = textView5;
        this.decodeI2sDataValue = textView6;
        this.decodeI2sEndianLSBRadioButton = radioButton;
        this.decodeI2sEndianLabel = textView7;
        this.decodeI2sEndianMSBRadioButton = radioButton2;
        this.decodeI2sEndianRadioGroup = radioGroup;
        this.decodeI2sLayout = constraintLayout;
        this.decodeI2sPolLabel = textView8;
        this.decodeI2sPolNegativeRadioButton = radioButton3;
        this.decodeI2sPolPositiveRadioButton = radioButton4;
        this.decodeI2sPolRadioGroup = radioGroup2;
        this.decodeI2sReceiveLabel = textView9;
        this.decodeI2sReceiveValue = textView10;
        this.decodeI2sSclkLabel = textView11;
        this.decodeI2sSclkThresLabel = textView12;
        this.decodeI2sSclkThresValue = textView13;
        this.decodeI2sSclkValue = textView14;
        this.decodeI2sSclkedgeDownRadioButton = radioButton5;
        this.decodeI2sSclkedgeLabel = textView15;
        this.decodeI2sSclkedgeRadioGroup = radioGroup3;
        this.decodeI2sSclkedgeUpRadioButton = radioButton6;
        this.decodeI2sWordLabel = textView16;
        this.decodeI2sWordValue = textView17;
        this.decodeI2sWsLabel = textView18;
        this.decodeI2sWsThreLabel = textView19;
        this.decodeI2sWsThresValue = textView20;
        this.decodeI2sWsValue = textView21;
        this.decodeI2sWslowLabel = textView22;
        this.decodeI2sWslowValue = textView23;
        this.divider1 = view2;
        this.guideline33 = guideline;
        this.guideline66 = guideline2;
        this.guidelineCenter = guideline3;
        this.guidelineLeft = guideline4;
        this.guidelineRight = guideline5;
    }

    public DecodeParam getParam() {
        return this.mParam;
    }

    public MappingObject getEdgeUpMapping() {
        return this.mEdgeUpMapping;
    }

    public MappingObject getEdgeDownMapping() {
        return this.mEdgeDownMapping;
    }

    public MappingObject getEndianLsbMapping() {
        return this.mEndianLsbMapping;
    }

    public MappingObject getEndianMsbMapping() {
        return this.mEndianMsbMapping;
    }

    public MappingObject getDataNegativeMapping() {
        return this.mDataNegativeMapping;
    }

    public MappingObject getDataPositiveMapping() {
        return this.mDataPositiveMapping;
    }

    public static AdapterDecodeI2sBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterDecodeI2sBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterDecodeI2sBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_decode_i2s, viewGroup, z, obj);
    }

    public static AdapterDecodeI2sBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterDecodeI2sBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterDecodeI2sBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_decode_i2s, null, false, obj);
    }

    public static AdapterDecodeI2sBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterDecodeI2sBinding bind(View view, Object obj) {
        return (AdapterDecodeI2sBinding) bind(obj, view, R.layout.adapter_decode_i2s);
    }
}
