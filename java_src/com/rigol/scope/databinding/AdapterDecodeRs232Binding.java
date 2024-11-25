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
public abstract class AdapterDecodeRs232Binding extends ViewDataBinding {
    public final TextView decodeRs232BaudLabel;
    public final TextView decodeRs232BaudValue;
    public final TextView decodeRs232EndianLabel;
    public final TextView decodeRs232EndianValue;
    public final RadioButton decodeRs232InvertRadioButton;
    public final ConstraintLayout decodeRs232Layout;
    public final RadioButton decodeRs232NegativeRadioButton;
    public final TextView decodeRs232PackenLabel;
    public final SwitchButton decodeRs232PackenValue;
    public final TextView decodeRs232PackendLabel;
    public final TextView decodeRs232PackendValue;
    public final TextView decodeRs232ParityLabel;
    public final TextView decodeRs232ParityValue;
    public final TextView decodeRs232PolLabel;
    public final RadioGroup decodeRs232PolRadioGroup;
    public final TextView decodeRs232RxLabel;
    public final TextView decodeRs232RxValue;
    public final TextView decodeRs232StopLabel;
    public final TextView decodeRs232StopValue;
    public final TextView decodeRs232TxLabel;
    public final TextView decodeRs232TxValue;
    public final TextView decodeRs232WidthLabel;
    public final TextView decodeRs232WidthValue;
    public final TextView decodeRxThresLabel;
    public final TextView decodeRxThresValue;
    public final TextView decodeTxThresLabel;
    public final TextView decodeTxThresValue;
    public final View divider2;
    public final Guideline guideline33;
    public final Guideline guideline66;
    public final Guideline guidelineCenter;
    public final Guideline guidelineLeft;
    public final Guideline guidelineRight;
    @Bindable
    protected MappingObject mNegativeMapping;
    @Bindable
    protected DecodeParam mParam;
    @Bindable
    protected MappingObject mPositiveMapping;

    public abstract void setNegativeMapping(MappingObject mappingObject);

    public abstract void setParam(DecodeParam decodeParam);

    public abstract void setPositiveMapping(MappingObject mappingObject);

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterDecodeRs232Binding(Object obj, View view, int i, TextView textView, TextView textView2, TextView textView3, TextView textView4, RadioButton radioButton, ConstraintLayout constraintLayout, RadioButton radioButton2, TextView textView5, SwitchButton switchButton, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, RadioGroup radioGroup, TextView textView11, TextView textView12, TextView textView13, TextView textView14, TextView textView15, TextView textView16, TextView textView17, TextView textView18, TextView textView19, TextView textView20, TextView textView21, TextView textView22, View view2, Guideline guideline, Guideline guideline2, Guideline guideline3, Guideline guideline4, Guideline guideline5) {
        super(obj, view, i);
        this.decodeRs232BaudLabel = textView;
        this.decodeRs232BaudValue = textView2;
        this.decodeRs232EndianLabel = textView3;
        this.decodeRs232EndianValue = textView4;
        this.decodeRs232InvertRadioButton = radioButton;
        this.decodeRs232Layout = constraintLayout;
        this.decodeRs232NegativeRadioButton = radioButton2;
        this.decodeRs232PackenLabel = textView5;
        this.decodeRs232PackenValue = switchButton;
        this.decodeRs232PackendLabel = textView6;
        this.decodeRs232PackendValue = textView7;
        this.decodeRs232ParityLabel = textView8;
        this.decodeRs232ParityValue = textView9;
        this.decodeRs232PolLabel = textView10;
        this.decodeRs232PolRadioGroup = radioGroup;
        this.decodeRs232RxLabel = textView11;
        this.decodeRs232RxValue = textView12;
        this.decodeRs232StopLabel = textView13;
        this.decodeRs232StopValue = textView14;
        this.decodeRs232TxLabel = textView15;
        this.decodeRs232TxValue = textView16;
        this.decodeRs232WidthLabel = textView17;
        this.decodeRs232WidthValue = textView18;
        this.decodeRxThresLabel = textView19;
        this.decodeRxThresValue = textView20;
        this.decodeTxThresLabel = textView21;
        this.decodeTxThresValue = textView22;
        this.divider2 = view2;
        this.guideline33 = guideline;
        this.guideline66 = guideline2;
        this.guidelineCenter = guideline3;
        this.guidelineLeft = guideline4;
        this.guidelineRight = guideline5;
    }

    public DecodeParam getParam() {
        return this.mParam;
    }

    public MappingObject getPositiveMapping() {
        return this.mPositiveMapping;
    }

    public MappingObject getNegativeMapping() {
        return this.mNegativeMapping;
    }

    public static AdapterDecodeRs232Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterDecodeRs232Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterDecodeRs232Binding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_decode_rs232, viewGroup, z, obj);
    }

    public static AdapterDecodeRs232Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterDecodeRs232Binding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterDecodeRs232Binding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_decode_rs232, null, false, obj);
    }

    public static AdapterDecodeRs232Binding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterDecodeRs232Binding bind(View view, Object obj) {
        return (AdapterDecodeRs232Binding) bind(obj, view, R.layout.adapter_decode_rs232);
    }
}
