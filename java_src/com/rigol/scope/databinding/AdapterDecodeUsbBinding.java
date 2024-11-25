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
import com.rigol.scope.data.DecodeParam;
import com.rigol.scope.data.MappingObject;
/* loaded from: classes2.dex */
public abstract class AdapterDecodeUsbBinding extends ViewDataBinding {
    public final TextView decodeUsbDiffLabel;
    public final TextView decodeUsbDiffThreHLabel;
    public final TextView decodeUsbDiffThreHValue;
    public final TextView decodeUsbDiffThreLLabel;
    public final TextView decodeUsbDiffThreLValue;
    public final TextView decodeUsbDiffValue;
    public final TextView decodeUsbDpLabel;
    public final TextView decodeUsbDpThresLabel;
    public final TextView decodeUsbDpThresValue;
    public final TextView decodeUsbDpValue;
    public final TextView decodeUsbDsLabel;
    public final TextView decodeUsbDsThresLabel;
    public final TextView decodeUsbDsThresValue;
    public final TextView decodeUsbDsValue;
    public final RadioButton decodeUsbHighRadioButton;
    public final ConstraintLayout decodeUsbLayout;
    public final RadioButton decodeUsbLowRadioButton;
    public final RadioButton decodeUsbMidRadioButton;
    public final TextView decodeUsbSigLabel;
    public final RadioGroup decodeUsbSigRadioGroup;
    public final View divider1;
    @Bindable
    protected DecodeParam mParam;
    @Bindable
    protected MappingObject mUsbHighMapping;
    @Bindable
    protected MappingObject mUsbLowMapping;
    @Bindable
    protected MappingObject mUsbMidMapping;

    public abstract void setParam(DecodeParam decodeParam);

    public abstract void setUsbHighMapping(MappingObject mappingObject);

    public abstract void setUsbLowMapping(MappingObject mappingObject);

    public abstract void setUsbMidMapping(MappingObject mappingObject);

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterDecodeUsbBinding(Object obj, View view, int i, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, RadioButton radioButton, ConstraintLayout constraintLayout, RadioButton radioButton2, RadioButton radioButton3, TextView textView15, RadioGroup radioGroup, View view2) {
        super(obj, view, i);
        this.decodeUsbDiffLabel = textView;
        this.decodeUsbDiffThreHLabel = textView2;
        this.decodeUsbDiffThreHValue = textView3;
        this.decodeUsbDiffThreLLabel = textView4;
        this.decodeUsbDiffThreLValue = textView5;
        this.decodeUsbDiffValue = textView6;
        this.decodeUsbDpLabel = textView7;
        this.decodeUsbDpThresLabel = textView8;
        this.decodeUsbDpThresValue = textView9;
        this.decodeUsbDpValue = textView10;
        this.decodeUsbDsLabel = textView11;
        this.decodeUsbDsThresLabel = textView12;
        this.decodeUsbDsThresValue = textView13;
        this.decodeUsbDsValue = textView14;
        this.decodeUsbHighRadioButton = radioButton;
        this.decodeUsbLayout = constraintLayout;
        this.decodeUsbLowRadioButton = radioButton2;
        this.decodeUsbMidRadioButton = radioButton3;
        this.decodeUsbSigLabel = textView15;
        this.decodeUsbSigRadioGroup = radioGroup;
        this.divider1 = view2;
    }

    public DecodeParam getParam() {
        return this.mParam;
    }

    public MappingObject getUsbLowMapping() {
        return this.mUsbLowMapping;
    }

    public MappingObject getUsbMidMapping() {
        return this.mUsbMidMapping;
    }

    public MappingObject getUsbHighMapping() {
        return this.mUsbHighMapping;
    }

    public static AdapterDecodeUsbBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterDecodeUsbBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterDecodeUsbBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_decode_usb, viewGroup, z, obj);
    }

    public static AdapterDecodeUsbBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterDecodeUsbBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterDecodeUsbBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_decode_usb, null, false, obj);
    }

    public static AdapterDecodeUsbBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterDecodeUsbBinding bind(View view, Object obj) {
        return (AdapterDecodeUsbBinding) bind(obj, view, R.layout.adapter_decode_usb);
    }
}
