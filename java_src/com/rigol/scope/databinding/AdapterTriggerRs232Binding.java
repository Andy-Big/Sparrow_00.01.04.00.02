package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.TriggerParam;
import com.rigol.scope.views.SwitchButton;
/* loaded from: classes2.dex */
public abstract class AdapterTriggerRs232Binding extends ViewDataBinding {
    public final Button buttonLevel;
    public final TextView dataLabel;
    public final EditText dataValue;
    public final Guideline guidelineCenter;
    public final Guideline guidelineFifth;
    public final Guideline guidelineForth;
    public final Guideline guidelineLeft;
    public final Guideline guidelineRight;
    @Bindable
    protected TriggerParam mParam;
    @Bindable
    protected MappingObject mParityEvenMapping;
    @Bindable
    protected MappingObject mParityNoneMapping;
    @Bindable
    protected MappingObject mParityOddMapping;
    @Bindable
    protected MappingObject mPolarityNegativeMapping;
    @Bindable
    protected MappingObject mPolarityPositiveMapping;
    @Bindable
    protected MappingObject mStopBit15Mapping;
    @Bindable
    protected MappingObject mStopBit1Mapping;
    @Bindable
    protected MappingObject mStopBit2Mapping;
    @Bindable
    protected MappingObject mSweepAutoMapping;
    @Bindable
    protected MappingObject mSweepNormalMapping;
    @Bindable
    protected MappingObject mSweepSingleMapping;
    @Bindable
    protected MappingObject mWhenCheckMapping;
    @Bindable
    protected MappingObject mWhenDataMapping;
    @Bindable
    protected MappingObject mWhenErrorMapping;
    @Bindable
    protected MappingObject mWhenStartMapping;
    public final TextView triggerBaudrate;
    public final TextView triggerBaudrateLabel;
    public final RadioButton triggerCheckEven;
    public final TextView triggerCheckLabel;
    public final RadioButton triggerCheckNone;
    public final RadioButton triggerCheckOdd;
    public final TextView triggerDataWidth;
    public final TextView triggerDataWidthLabel;
    public final TextView triggerLabel;
    public final TextView triggerLevel;
    public final EditText triggerLevelValue;
    public final TextView triggerNoiseLabel;
    public final SwitchButton triggerNoiseSwitch;
    public final TextView triggerPolarityLabel;
    public final RadioButton triggerRs232Check;
    public final RadioButton triggerRs232Data;
    public final RadioButton triggerRs232Error;
    public final RadioButton triggerRs232Negative;
    public final RadioButton triggerRs232Positive;
    public final RadioButton triggerRs232Start;
    public final TextView triggerSource;
    public final TextView triggerSourceLabel;
    public final RadioButton triggerStopBit1;
    public final RadioButton triggerStopBit15;
    public final RadioButton triggerStopBit2;
    public final TextView triggerStopBitLabel;
    public final View view1;
    public final View view2;
    public final View view3;
    public final View viewLine1;
    public final View viewLine2;
    public final View viewTop;

    public abstract void setParam(TriggerParam triggerParam);

    public abstract void setParityEvenMapping(MappingObject mappingObject);

    public abstract void setParityNoneMapping(MappingObject mappingObject);

    public abstract void setParityOddMapping(MappingObject mappingObject);

    public abstract void setPolarityNegativeMapping(MappingObject mappingObject);

    public abstract void setPolarityPositiveMapping(MappingObject mappingObject);

    public abstract void setStopBit15Mapping(MappingObject mappingObject);

    public abstract void setStopBit1Mapping(MappingObject mappingObject);

    public abstract void setStopBit2Mapping(MappingObject mappingObject);

    public abstract void setSweepAutoMapping(MappingObject mappingObject);

    public abstract void setSweepNormalMapping(MappingObject mappingObject);

    public abstract void setSweepSingleMapping(MappingObject mappingObject);

    public abstract void setWhenCheckMapping(MappingObject mappingObject);

    public abstract void setWhenDataMapping(MappingObject mappingObject);

    public abstract void setWhenErrorMapping(MappingObject mappingObject);

    public abstract void setWhenStartMapping(MappingObject mappingObject);

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterTriggerRs232Binding(Object obj, View view, int i, Button button, TextView textView, EditText editText, Guideline guideline, Guideline guideline2, Guideline guideline3, Guideline guideline4, Guideline guideline5, TextView textView2, TextView textView3, RadioButton radioButton, TextView textView4, RadioButton radioButton2, RadioButton radioButton3, TextView textView5, TextView textView6, TextView textView7, TextView textView8, EditText editText2, TextView textView9, SwitchButton switchButton, TextView textView10, RadioButton radioButton4, RadioButton radioButton5, RadioButton radioButton6, RadioButton radioButton7, RadioButton radioButton8, RadioButton radioButton9, TextView textView11, TextView textView12, RadioButton radioButton10, RadioButton radioButton11, RadioButton radioButton12, TextView textView13, View view2, View view3, View view4, View view5, View view6, View view7) {
        super(obj, view, i);
        this.buttonLevel = button;
        this.dataLabel = textView;
        this.dataValue = editText;
        this.guidelineCenter = guideline;
        this.guidelineFifth = guideline2;
        this.guidelineForth = guideline3;
        this.guidelineLeft = guideline4;
        this.guidelineRight = guideline5;
        this.triggerBaudrate = textView2;
        this.triggerBaudrateLabel = textView3;
        this.triggerCheckEven = radioButton;
        this.triggerCheckLabel = textView4;
        this.triggerCheckNone = radioButton2;
        this.triggerCheckOdd = radioButton3;
        this.triggerDataWidth = textView5;
        this.triggerDataWidthLabel = textView6;
        this.triggerLabel = textView7;
        this.triggerLevel = textView8;
        this.triggerLevelValue = editText2;
        this.triggerNoiseLabel = textView9;
        this.triggerNoiseSwitch = switchButton;
        this.triggerPolarityLabel = textView10;
        this.triggerRs232Check = radioButton4;
        this.triggerRs232Data = radioButton5;
        this.triggerRs232Error = radioButton6;
        this.triggerRs232Negative = radioButton7;
        this.triggerRs232Positive = radioButton8;
        this.triggerRs232Start = radioButton9;
        this.triggerSource = textView11;
        this.triggerSourceLabel = textView12;
        this.triggerStopBit1 = radioButton10;
        this.triggerStopBit15 = radioButton11;
        this.triggerStopBit2 = radioButton12;
        this.triggerStopBitLabel = textView13;
        this.view1 = view2;
        this.view2 = view3;
        this.view3 = view4;
        this.viewLine1 = view5;
        this.viewLine2 = view6;
        this.viewTop = view7;
    }

    public TriggerParam getParam() {
        return this.mParam;
    }

    public MappingObject getSweepAutoMapping() {
        return this.mSweepAutoMapping;
    }

    public MappingObject getSweepNormalMapping() {
        return this.mSweepNormalMapping;
    }

    public MappingObject getSweepSingleMapping() {
        return this.mSweepSingleMapping;
    }

    public MappingObject getPolarityPositiveMapping() {
        return this.mPolarityPositiveMapping;
    }

    public MappingObject getPolarityNegativeMapping() {
        return this.mPolarityNegativeMapping;
    }

    public MappingObject getWhenStartMapping() {
        return this.mWhenStartMapping;
    }

    public MappingObject getWhenErrorMapping() {
        return this.mWhenErrorMapping;
    }

    public MappingObject getWhenCheckMapping() {
        return this.mWhenCheckMapping;
    }

    public MappingObject getWhenDataMapping() {
        return this.mWhenDataMapping;
    }

    public MappingObject getParityNoneMapping() {
        return this.mParityNoneMapping;
    }

    public MappingObject getParityEvenMapping() {
        return this.mParityEvenMapping;
    }

    public MappingObject getParityOddMapping() {
        return this.mParityOddMapping;
    }

    public MappingObject getStopBit1Mapping() {
        return this.mStopBit1Mapping;
    }

    public MappingObject getStopBit15Mapping() {
        return this.mStopBit15Mapping;
    }

    public MappingObject getStopBit2Mapping() {
        return this.mStopBit2Mapping;
    }

    public static AdapterTriggerRs232Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterTriggerRs232Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterTriggerRs232Binding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_trigger_rs232, viewGroup, z, obj);
    }

    public static AdapterTriggerRs232Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterTriggerRs232Binding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterTriggerRs232Binding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_trigger_rs232, null, false, obj);
    }

    public static AdapterTriggerRs232Binding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterTriggerRs232Binding bind(View view, Object obj) {
        return (AdapterTriggerRs232Binding) bind(obj, view, R.layout.adapter_trigger_rs232);
    }
}
