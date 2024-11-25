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
public abstract class AdapterTriggerI2cBinding extends ViewDataBinding {
    public final Button buttonLevel;
    public final Button buttonLevelb;
    public final Guideline guidelineCenter;
    public final Guideline guidelineFifth;
    public final Guideline guidelineForth;
    public final Guideline guidelineLeft;
    public final Guideline guidelineRight;
    @Bindable
    protected TriggerParam mParam;
    @Bindable
    protected MappingObject mSweepAutoMapping;
    @Bindable
    protected MappingObject mSweepNormalMapping;
    @Bindable
    protected MappingObject mSweepSingleMapping;
    @Bindable
    protected MappingObject mWhenAdMapping;
    @Bindable
    protected MappingObject mWhenAddressMapping;
    @Bindable
    protected MappingObject mWhenDataMapping;
    @Bindable
    protected MappingObject mWhenMissMapping;
    @Bindable
    protected MappingObject mWhenRestartMapping;
    @Bindable
    protected MappingObject mWhenStartMapping;
    @Bindable
    protected MappingObject mWhenStopMapping;
    public final TextView triggerAddrWidthLabel;
    public final TextView triggerAddrWidthValue;
    public final RadioButton triggerI2cAddr;
    public final RadioButton triggerI2cAddrData;
    public final TextView triggerI2cAddrLabel;
    public final EditText triggerI2cAddrValue;
    public final TextView triggerI2cBytelengthLabel;
    public final TextView triggerI2cBytelengthValue;
    public final RadioButton triggerI2cData;
    public final TextView triggerI2cDataLabel;
    public final EditText triggerI2cDataValue;
    public final TextView triggerI2cDirectionLabel;
    public final TextView triggerI2cDirectionValue;
    public final RadioButton triggerI2cMissedAck;
    public final RadioButton triggerI2cRestart;
    public final RadioButton triggerI2cStart;
    public final RadioButton triggerI2cStop;
    public final TextView triggerLabel;
    public final TextView triggerLevel;
    public final EditText triggerLevelValue;
    public final TextView triggerLevelb;
    public final EditText triggerLevelbValue;
    public final TextView triggerNoiseLabel;
    public final SwitchButton triggerNoiseSwitch;
    public final TextView triggerSourceScl;
    public final TextView triggerSourceSclLabel;
    public final TextView triggerSourceSda;
    public final TextView triggerSourceSdaLabel;
    public final View view1;
    public final View view2;
    public final View view3;
    public final View viewLine1;
    public final View viewLine2;
    public final View viewTop;

    public abstract void setParam(TriggerParam triggerParam);

    public abstract void setSweepAutoMapping(MappingObject mappingObject);

    public abstract void setSweepNormalMapping(MappingObject mappingObject);

    public abstract void setSweepSingleMapping(MappingObject mappingObject);

    public abstract void setWhenAdMapping(MappingObject mappingObject);

    public abstract void setWhenAddressMapping(MappingObject mappingObject);

    public abstract void setWhenDataMapping(MappingObject mappingObject);

    public abstract void setWhenMissMapping(MappingObject mappingObject);

    public abstract void setWhenRestartMapping(MappingObject mappingObject);

    public abstract void setWhenStartMapping(MappingObject mappingObject);

    public abstract void setWhenStopMapping(MappingObject mappingObject);

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterTriggerI2cBinding(Object obj, View view, int i, Button button, Button button2, Guideline guideline, Guideline guideline2, Guideline guideline3, Guideline guideline4, Guideline guideline5, TextView textView, TextView textView2, RadioButton radioButton, RadioButton radioButton2, TextView textView3, EditText editText, TextView textView4, TextView textView5, RadioButton radioButton3, TextView textView6, EditText editText2, TextView textView7, TextView textView8, RadioButton radioButton4, RadioButton radioButton5, RadioButton radioButton6, RadioButton radioButton7, TextView textView9, TextView textView10, EditText editText3, TextView textView11, EditText editText4, TextView textView12, SwitchButton switchButton, TextView textView13, TextView textView14, TextView textView15, TextView textView16, View view2, View view3, View view4, View view5, View view6, View view7) {
        super(obj, view, i);
        this.buttonLevel = button;
        this.buttonLevelb = button2;
        this.guidelineCenter = guideline;
        this.guidelineFifth = guideline2;
        this.guidelineForth = guideline3;
        this.guidelineLeft = guideline4;
        this.guidelineRight = guideline5;
        this.triggerAddrWidthLabel = textView;
        this.triggerAddrWidthValue = textView2;
        this.triggerI2cAddr = radioButton;
        this.triggerI2cAddrData = radioButton2;
        this.triggerI2cAddrLabel = textView3;
        this.triggerI2cAddrValue = editText;
        this.triggerI2cBytelengthLabel = textView4;
        this.triggerI2cBytelengthValue = textView5;
        this.triggerI2cData = radioButton3;
        this.triggerI2cDataLabel = textView6;
        this.triggerI2cDataValue = editText2;
        this.triggerI2cDirectionLabel = textView7;
        this.triggerI2cDirectionValue = textView8;
        this.triggerI2cMissedAck = radioButton4;
        this.triggerI2cRestart = radioButton5;
        this.triggerI2cStart = radioButton6;
        this.triggerI2cStop = radioButton7;
        this.triggerLabel = textView9;
        this.triggerLevel = textView10;
        this.triggerLevelValue = editText3;
        this.triggerLevelb = textView11;
        this.triggerLevelbValue = editText4;
        this.triggerNoiseLabel = textView12;
        this.triggerNoiseSwitch = switchButton;
        this.triggerSourceScl = textView13;
        this.triggerSourceSclLabel = textView14;
        this.triggerSourceSda = textView15;
        this.triggerSourceSdaLabel = textView16;
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

    public MappingObject getWhenStartMapping() {
        return this.mWhenStartMapping;
    }

    public MappingObject getWhenStopMapping() {
        return this.mWhenStopMapping;
    }

    public MappingObject getWhenRestartMapping() {
        return this.mWhenRestartMapping;
    }

    public MappingObject getWhenMissMapping() {
        return this.mWhenMissMapping;
    }

    public MappingObject getWhenAddressMapping() {
        return this.mWhenAddressMapping;
    }

    public MappingObject getWhenDataMapping() {
        return this.mWhenDataMapping;
    }

    public MappingObject getWhenAdMapping() {
        return this.mWhenAdMapping;
    }

    public static AdapterTriggerI2cBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterTriggerI2cBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterTriggerI2cBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_trigger_i2c, viewGroup, z, obj);
    }

    public static AdapterTriggerI2cBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterTriggerI2cBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterTriggerI2cBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_trigger_i2c, null, false, obj);
    }

    public static AdapterTriggerI2cBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterTriggerI2cBinding bind(View view, Object obj) {
        return (AdapterTriggerI2cBinding) bind(obj, view, R.layout.adapter_trigger_i2c);
    }
}
