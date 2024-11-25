package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
import com.rigol.scope.data.DecodeParam;
import com.rigol.scope.views.SwitchButton;
/* loaded from: classes2.dex */
public abstract class AdapterDecodeParallelBinding extends ViewDataBinding {
    public final Button bitOne;
    public final Button bitThree;
    public final Button bitTwo;
    public final TextView bitZero;
    public final TextView decodeBusChLabel;
    public final AppCompatTextView decodeBusChValue;
    public final TextView decodeBusWidthLabel;
    public final TextView decodeBusWidthValue;
    public final SwitchButton decodeNoiseSwitch;
    public final TextView decodePalBitxLabel;
    public final TextView decodePalBusLabel;
    public final TextView decodePalBusValue;
    public final TextView decodePalClkEdgeLabel;
    public final RadioGroup decodePalClkEdgeRadioGroup;
    public final TextView decodePalClkLabel;
    public final TextView decodePalClkValue;
    public final TextView decodePalDatThresLabel;
    public final TextView decodePalDatThresValue;
    public final RadioButton decodePalDownRadioButton;
    public final TextView decodePalEndianLabel;
    public final RadioGroup decodePalEndianRadioGroup;
    public final RadioButton decodePalInvertRadioButton;
    public final RadioButton decodePalNegativeRadioButton;
    public final RadioButton decodePalNormalRadioButton;
    public final TextView decodePalNrjtimeLabel;
    public final TextView decodePalNrjtimeValue;
    public final TextView decodePalPolarityLabel;
    public final RadioGroup decodePalPolarityRadioGroup;
    public final RadioButton decodePalPositiveRadioButton;
    public final TextView decodePalThresLabel;
    public final TextView decodePalThresValue;
    public final RadioButton decodePalUpRadioButton;
    public final RadioButton decodePalUpdownRadioButton;
    public final ConstraintLayout decodeParallelLayout;
    public final View divider2;
    public final Guideline guideline33;
    public final Guideline guideline66;
    public final Guideline guidelineCenter;
    public final Guideline guidelineLeft;
    public final Guideline guidelineRight;
    @Bindable
    protected DecodeParam mParam;
    public final TextView triggerNoiseLabel;

    public abstract void setParam(DecodeParam decodeParam);

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterDecodeParallelBinding(Object obj, View view, int i, Button button, Button button2, Button button3, TextView textView, TextView textView2, AppCompatTextView appCompatTextView, TextView textView3, TextView textView4, SwitchButton switchButton, TextView textView5, TextView textView6, TextView textView7, TextView textView8, RadioGroup radioGroup, TextView textView9, TextView textView10, TextView textView11, TextView textView12, RadioButton radioButton, TextView textView13, RadioGroup radioGroup2, RadioButton radioButton2, RadioButton radioButton3, RadioButton radioButton4, TextView textView14, TextView textView15, TextView textView16, RadioGroup radioGroup3, RadioButton radioButton5, TextView textView17, TextView textView18, RadioButton radioButton6, RadioButton radioButton7, ConstraintLayout constraintLayout, View view2, Guideline guideline, Guideline guideline2, Guideline guideline3, Guideline guideline4, Guideline guideline5, TextView textView19) {
        super(obj, view, i);
        this.bitOne = button;
        this.bitThree = button2;
        this.bitTwo = button3;
        this.bitZero = textView;
        this.decodeBusChLabel = textView2;
        this.decodeBusChValue = appCompatTextView;
        this.decodeBusWidthLabel = textView3;
        this.decodeBusWidthValue = textView4;
        this.decodeNoiseSwitch = switchButton;
        this.decodePalBitxLabel = textView5;
        this.decodePalBusLabel = textView6;
        this.decodePalBusValue = textView7;
        this.decodePalClkEdgeLabel = textView8;
        this.decodePalClkEdgeRadioGroup = radioGroup;
        this.decodePalClkLabel = textView9;
        this.decodePalClkValue = textView10;
        this.decodePalDatThresLabel = textView11;
        this.decodePalDatThresValue = textView12;
        this.decodePalDownRadioButton = radioButton;
        this.decodePalEndianLabel = textView13;
        this.decodePalEndianRadioGroup = radioGroup2;
        this.decodePalInvertRadioButton = radioButton2;
        this.decodePalNegativeRadioButton = radioButton3;
        this.decodePalNormalRadioButton = radioButton4;
        this.decodePalNrjtimeLabel = textView14;
        this.decodePalNrjtimeValue = textView15;
        this.decodePalPolarityLabel = textView16;
        this.decodePalPolarityRadioGroup = radioGroup3;
        this.decodePalPositiveRadioButton = radioButton5;
        this.decodePalThresLabel = textView17;
        this.decodePalThresValue = textView18;
        this.decodePalUpRadioButton = radioButton6;
        this.decodePalUpdownRadioButton = radioButton7;
        this.decodeParallelLayout = constraintLayout;
        this.divider2 = view2;
        this.guideline33 = guideline;
        this.guideline66 = guideline2;
        this.guidelineCenter = guideline3;
        this.guidelineLeft = guideline4;
        this.guidelineRight = guideline5;
        this.triggerNoiseLabel = textView19;
    }

    public DecodeParam getParam() {
        return this.mParam;
    }

    public static AdapterDecodeParallelBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterDecodeParallelBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterDecodeParallelBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_decode_parallel, viewGroup, z, obj);
    }

    public static AdapterDecodeParallelBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterDecodeParallelBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterDecodeParallelBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_decode_parallel, null, false, obj);
    }

    public static AdapterDecodeParallelBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterDecodeParallelBinding bind(View view, Object obj) {
        return (AdapterDecodeParallelBinding) bind(obj, view, R.layout.adapter_decode_parallel);
    }
}
