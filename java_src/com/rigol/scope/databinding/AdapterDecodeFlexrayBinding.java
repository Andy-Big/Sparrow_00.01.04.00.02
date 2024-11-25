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
public abstract class AdapterDecodeFlexrayBinding extends ViewDataBinding {
    public final TextView decodeFlexBaudLabel;
    public final TextView decodeFlexBaudValue;
    public final RadioButton decodeFlexChannelARadioButton;
    public final RadioButton decodeFlexChannelBRadioButton;
    public final TextView decodeFlexChannelLabel;
    public final RadioGroup decodeFlexChannelRadioGroup;
    public final TextView decodeFlexSampLabel;
    public final TextView decodeFlexSampValue;
    public final TextView decodeFlexSignalLabel;
    public final TextView decodeFlexSignalValue;
    public final TextView decodeFlexSrcLabel;
    public final TextView decodeFlexSrcValue;
    public final TextView decodeFlexThresLabel;
    public final TextView decodeFlexThresValue;
    public final ConstraintLayout decodeFlexrayLayout;
    public final Guideline guideline33;
    public final Guideline guideline66;
    public final Guideline guidelineCenter;
    public final Guideline guidelineLeft;
    public final Guideline guidelineRight;
    @Bindable
    protected MappingObject mChannelAMapping;
    @Bindable
    protected MappingObject mChannelBMapping;
    @Bindable
    protected DecodeParam mParam;

    public abstract void setChannelAMapping(MappingObject mappingObject);

    public abstract void setChannelBMapping(MappingObject mappingObject);

    public abstract void setParam(DecodeParam decodeParam);

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterDecodeFlexrayBinding(Object obj, View view, int i, TextView textView, TextView textView2, RadioButton radioButton, RadioButton radioButton2, TextView textView3, RadioGroup radioGroup, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, ConstraintLayout constraintLayout, Guideline guideline, Guideline guideline2, Guideline guideline3, Guideline guideline4, Guideline guideline5) {
        super(obj, view, i);
        this.decodeFlexBaudLabel = textView;
        this.decodeFlexBaudValue = textView2;
        this.decodeFlexChannelARadioButton = radioButton;
        this.decodeFlexChannelBRadioButton = radioButton2;
        this.decodeFlexChannelLabel = textView3;
        this.decodeFlexChannelRadioGroup = radioGroup;
        this.decodeFlexSampLabel = textView4;
        this.decodeFlexSampValue = textView5;
        this.decodeFlexSignalLabel = textView6;
        this.decodeFlexSignalValue = textView7;
        this.decodeFlexSrcLabel = textView8;
        this.decodeFlexSrcValue = textView9;
        this.decodeFlexThresLabel = textView10;
        this.decodeFlexThresValue = textView11;
        this.decodeFlexrayLayout = constraintLayout;
        this.guideline33 = guideline;
        this.guideline66 = guideline2;
        this.guidelineCenter = guideline3;
        this.guidelineLeft = guideline4;
        this.guidelineRight = guideline5;
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

    public static AdapterDecodeFlexrayBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterDecodeFlexrayBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterDecodeFlexrayBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_decode_flexray, viewGroup, z, obj);
    }

    public static AdapterDecodeFlexrayBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterDecodeFlexrayBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterDecodeFlexrayBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_decode_flexray, null, false, obj);
    }

    public static AdapterDecodeFlexrayBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterDecodeFlexrayBinding bind(View view, Object obj) {
        return (AdapterDecodeFlexrayBinding) bind(obj, view, R.layout.adapter_decode_flexray);
    }
}
