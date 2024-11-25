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
public abstract class AdapterDecodeSpiBinding extends ViewDataBinding {
    public final RadioButton decodeSpiClkEdgeDownRadioButton;
    public final TextView decodeSpiClkEdgeLabel;
    public final RadioGroup decodeSpiClkEdgeRadioGroup;
    public final RadioButton decodeSpiClkEdgeUpRadioButton;
    public final TextView decodeSpiClkLabel;
    public final TextView decodeSpiClkThresLabel;
    public final TextView decodeSpiClkThresValue;
    public final TextView decodeSpiClkValue;
    public final TextView decodeSpiCsLabel;
    public final TextView decodeSpiCsPolLabel;
    public final RadioButton decodeSpiCsPolNegativeRadioButton;
    public final RadioButton decodeSpiCsPolPositiveRadioButton;
    public final RadioGroup decodeSpiCsPolRadioGroup;
    public final TextView decodeSpiCsThresLabel;
    public final TextView decodeSpiCsThresValue;
    public final TextView decodeSpiCsValue;
    public final RadioButton decodeSpiEndianLSBRadioButton;
    public final TextView decodeSpiEndianLabel;
    public final RadioButton decodeSpiEndianMSBRadioButton;
    public final RadioGroup decodeSpiEndianRadioGroup;
    public final ConstraintLayout decodeSpiLayout;
    public final TextView decodeSpiMisoLabel;
    public final TextView decodeSpiMisoThresLabel;
    public final TextView decodeSpiMisoThresValue;
    public final TextView decodeSpiMisoValue;
    public final RadioButton decodeSpiModeCsRadioButton;
    public final TextView decodeSpiModeLabel;
    public final RadioGroup decodeSpiModeRadioGroup;
    public final RadioButton decodeSpiModeTimeoutRadioButton;
    public final TextView decodeSpiMosiLabel;
    public final TextView decodeSpiMosiThresLabel;
    public final TextView decodeSpiMosiThresValue;
    public final TextView decodeSpiMosiValue;
    public final TextView decodeSpiPolarityLabel;
    public final RadioButton decodeSpiPolarityNegativeRadioButton;
    public final RadioButton decodeSpiPolarityPositiveRadioButton;
    public final RadioGroup decodeSpiPolarityRadioGroup;
    public final TextView decodeSpiTmoLabel;
    public final TextView decodeSpiTmoValue;
    public final TextView decodeSpiWidthLabel;
    public final TextView decodeSpiWidthValue;
    public final View divider1;
    public final Guideline guideline33;
    public final Guideline guideline66;
    public final Guideline guidelineCenter;
    public final Guideline guidelineLeft;
    public final Guideline guidelineRight;
    @Bindable
    protected MappingObject mCsNegativeMapping;
    @Bindable
    protected MappingObject mCsPositiveMapping;
    @Bindable
    protected MappingObject mEdgeDownMapping;
    @Bindable
    protected MappingObject mEdgeUpMapping;
    @Bindable
    protected MappingObject mEndianLsbMapping;
    @Bindable
    protected MappingObject mEndianMsbMapping;
    @Bindable
    protected MappingObject mModeCsMapping;
    @Bindable
    protected MappingObject mModeTimeoutMapping;
    @Bindable
    protected DecodeParam mParam;
    @Bindable
    protected MappingObject mPolarityNegativeMapping;
    @Bindable
    protected MappingObject mPolarityPositiveMapping;

    public abstract void setCsNegativeMapping(MappingObject mappingObject);

    public abstract void setCsPositiveMapping(MappingObject mappingObject);

    public abstract void setEdgeDownMapping(MappingObject mappingObject);

    public abstract void setEdgeUpMapping(MappingObject mappingObject);

    public abstract void setEndianLsbMapping(MappingObject mappingObject);

    public abstract void setEndianMsbMapping(MappingObject mappingObject);

    public abstract void setModeCsMapping(MappingObject mappingObject);

    public abstract void setModeTimeoutMapping(MappingObject mappingObject);

    public abstract void setParam(DecodeParam decodeParam);

    public abstract void setPolarityNegativeMapping(MappingObject mappingObject);

    public abstract void setPolarityPositiveMapping(MappingObject mappingObject);

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterDecodeSpiBinding(Object obj, View view, int i, RadioButton radioButton, TextView textView, RadioGroup radioGroup, RadioButton radioButton2, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, RadioButton radioButton3, RadioButton radioButton4, RadioGroup radioGroup2, TextView textView8, TextView textView9, TextView textView10, RadioButton radioButton5, TextView textView11, RadioButton radioButton6, RadioGroup radioGroup3, ConstraintLayout constraintLayout, TextView textView12, TextView textView13, TextView textView14, TextView textView15, RadioButton radioButton7, TextView textView16, RadioGroup radioGroup4, RadioButton radioButton8, TextView textView17, TextView textView18, TextView textView19, TextView textView20, TextView textView21, RadioButton radioButton9, RadioButton radioButton10, RadioGroup radioGroup5, TextView textView22, TextView textView23, TextView textView24, TextView textView25, View view2, Guideline guideline, Guideline guideline2, Guideline guideline3, Guideline guideline4, Guideline guideline5) {
        super(obj, view, i);
        this.decodeSpiClkEdgeDownRadioButton = radioButton;
        this.decodeSpiClkEdgeLabel = textView;
        this.decodeSpiClkEdgeRadioGroup = radioGroup;
        this.decodeSpiClkEdgeUpRadioButton = radioButton2;
        this.decodeSpiClkLabel = textView2;
        this.decodeSpiClkThresLabel = textView3;
        this.decodeSpiClkThresValue = textView4;
        this.decodeSpiClkValue = textView5;
        this.decodeSpiCsLabel = textView6;
        this.decodeSpiCsPolLabel = textView7;
        this.decodeSpiCsPolNegativeRadioButton = radioButton3;
        this.decodeSpiCsPolPositiveRadioButton = radioButton4;
        this.decodeSpiCsPolRadioGroup = radioGroup2;
        this.decodeSpiCsThresLabel = textView8;
        this.decodeSpiCsThresValue = textView9;
        this.decodeSpiCsValue = textView10;
        this.decodeSpiEndianLSBRadioButton = radioButton5;
        this.decodeSpiEndianLabel = textView11;
        this.decodeSpiEndianMSBRadioButton = radioButton6;
        this.decodeSpiEndianRadioGroup = radioGroup3;
        this.decodeSpiLayout = constraintLayout;
        this.decodeSpiMisoLabel = textView12;
        this.decodeSpiMisoThresLabel = textView13;
        this.decodeSpiMisoThresValue = textView14;
        this.decodeSpiMisoValue = textView15;
        this.decodeSpiModeCsRadioButton = radioButton7;
        this.decodeSpiModeLabel = textView16;
        this.decodeSpiModeRadioGroup = radioGroup4;
        this.decodeSpiModeTimeoutRadioButton = radioButton8;
        this.decodeSpiMosiLabel = textView17;
        this.decodeSpiMosiThresLabel = textView18;
        this.decodeSpiMosiThresValue = textView19;
        this.decodeSpiMosiValue = textView20;
        this.decodeSpiPolarityLabel = textView21;
        this.decodeSpiPolarityNegativeRadioButton = radioButton9;
        this.decodeSpiPolarityPositiveRadioButton = radioButton10;
        this.decodeSpiPolarityRadioGroup = radioGroup5;
        this.decodeSpiTmoLabel = textView22;
        this.decodeSpiTmoValue = textView23;
        this.decodeSpiWidthLabel = textView24;
        this.decodeSpiWidthValue = textView25;
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

    public MappingObject getModeTimeoutMapping() {
        return this.mModeTimeoutMapping;
    }

    public MappingObject getModeCsMapping() {
        return this.mModeCsMapping;
    }

    public MappingObject getEndianMsbMapping() {
        return this.mEndianMsbMapping;
    }

    public MappingObject getEndianLsbMapping() {
        return this.mEndianLsbMapping;
    }

    public MappingObject getCsPositiveMapping() {
        return this.mCsPositiveMapping;
    }

    public MappingObject getCsNegativeMapping() {
        return this.mCsNegativeMapping;
    }

    public MappingObject getPolarityPositiveMapping() {
        return this.mPolarityPositiveMapping;
    }

    public MappingObject getPolarityNegativeMapping() {
        return this.mPolarityNegativeMapping;
    }

    public static AdapterDecodeSpiBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterDecodeSpiBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterDecodeSpiBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_decode_spi, viewGroup, z, obj);
    }

    public static AdapterDecodeSpiBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterDecodeSpiBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterDecodeSpiBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_decode_spi, null, false, obj);
    }

    public static AdapterDecodeSpiBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterDecodeSpiBinding bind(View view, Object obj) {
        return (AdapterDecodeSpiBinding) bind(obj, view, R.layout.adapter_decode_spi);
    }
}
