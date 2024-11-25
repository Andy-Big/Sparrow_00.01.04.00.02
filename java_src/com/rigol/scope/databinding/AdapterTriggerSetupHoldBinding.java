package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
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
import com.rigol.scope.views.vertical.VerticalSeekBar;
import com.rigol.scope.views.vertical.VerticalSeekBarWrapper;
/* loaded from: classes2.dex */
public abstract class AdapterTriggerSetupHoldBinding extends ViewDataBinding {
    public final Button buttonLevel;
    public final Button buttonLevelB;
    public final RadioButton dataTypeH;
    public final RadioButton dataTypeL;
    public final RadioButton edgeClockFalling;
    public final RadioButton edgeClockRising;
    public final Guideline guidelineCenter;
    public final Guideline guidelineFifth;
    public final Guideline guidelineForth;
    public final Guideline guidelineLeft;
    public final Guideline guidelineRight;
    public final RadioButton hold;
    public final TextView holdLabel;
    public final EditText holdValue;
    public final ImageView imageView2;
    @Bindable
    protected TriggerParam mParam;
    @Bindable
    protected MappingObject mSlopeFallingMapping;
    @Bindable
    protected MappingObject mSlopeRisingMapping;
    @Bindable
    protected MappingObject mSweepAutoMapping;
    @Bindable
    protected MappingObject mSweepNormalMapping;
    @Bindable
    protected MappingObject mSweepSingleMapping;
    @Bindable
    protected MappingObject mTypeHMapping;
    @Bindable
    protected MappingObject mTypeLMapping;
    @Bindable
    protected MappingObject mWhenHoldMapping;
    @Bindable
    protected MappingObject mWhenSetupHoldMapping;
    @Bindable
    protected MappingObject mWhenSetupMapping;
    public final RadioButton setup;
    public final RadioButton setupHold;
    public final TextView setupLabel;
    public final TextView setupTypeLabel;
    public final EditText setupValue;
    public final TextView triggerDataTypeLabel;
    public final TextView triggerEdgeClockLabel;
    public final EditText triggerHoldoff;
    public final TextView triggerHoldoffLabel;
    public final TextView triggerLevel;
    public final EditText triggerLevelAValue;
    public final VerticalSeekBar triggerLevelAView;
    public final TextView triggerLevelB;
    public final EditText triggerLevelBValue;
    public final VerticalSeekBar triggerLevelBView;
    public final TextView triggerNoiseLabel;
    public final SwitchButton triggerNoiseSwitch;
    public final TextView triggerSourceClock;
    public final TextView triggerSourceClockLabel;
    public final TextView triggerSourceData;
    public final TextView triggerSourceDataLabel;
    public final VerticalSeekBarWrapper verticalSeekBarWrapper2;
    public final VerticalSeekBarWrapper verticalSeekBarWrapper3;
    public final View view1;
    public final View view2;
    public final View viewLine1;
    public final View viewLine2;
    public final View viewTop;

    public abstract void setParam(TriggerParam triggerParam);

    public abstract void setSlopeFallingMapping(MappingObject mappingObject);

    public abstract void setSlopeRisingMapping(MappingObject mappingObject);

    public abstract void setSweepAutoMapping(MappingObject mappingObject);

    public abstract void setSweepNormalMapping(MappingObject mappingObject);

    public abstract void setSweepSingleMapping(MappingObject mappingObject);

    public abstract void setTypeHMapping(MappingObject mappingObject);

    public abstract void setTypeLMapping(MappingObject mappingObject);

    public abstract void setWhenHoldMapping(MappingObject mappingObject);

    public abstract void setWhenSetupHoldMapping(MappingObject mappingObject);

    public abstract void setWhenSetupMapping(MappingObject mappingObject);

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterTriggerSetupHoldBinding(Object obj, View view, int i, Button button, Button button2, RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, RadioButton radioButton4, Guideline guideline, Guideline guideline2, Guideline guideline3, Guideline guideline4, Guideline guideline5, RadioButton radioButton5, TextView textView, EditText editText, ImageView imageView, RadioButton radioButton6, RadioButton radioButton7, TextView textView2, TextView textView3, EditText editText2, TextView textView4, TextView textView5, EditText editText3, TextView textView6, TextView textView7, EditText editText4, VerticalSeekBar verticalSeekBar, TextView textView8, EditText editText5, VerticalSeekBar verticalSeekBar2, TextView textView9, SwitchButton switchButton, TextView textView10, TextView textView11, TextView textView12, TextView textView13, VerticalSeekBarWrapper verticalSeekBarWrapper, VerticalSeekBarWrapper verticalSeekBarWrapper2, View view2, View view3, View view4, View view5, View view6) {
        super(obj, view, i);
        this.buttonLevel = button;
        this.buttonLevelB = button2;
        this.dataTypeH = radioButton;
        this.dataTypeL = radioButton2;
        this.edgeClockFalling = radioButton3;
        this.edgeClockRising = radioButton4;
        this.guidelineCenter = guideline;
        this.guidelineFifth = guideline2;
        this.guidelineForth = guideline3;
        this.guidelineLeft = guideline4;
        this.guidelineRight = guideline5;
        this.hold = radioButton5;
        this.holdLabel = textView;
        this.holdValue = editText;
        this.imageView2 = imageView;
        this.setup = radioButton6;
        this.setupHold = radioButton7;
        this.setupLabel = textView2;
        this.setupTypeLabel = textView3;
        this.setupValue = editText2;
        this.triggerDataTypeLabel = textView4;
        this.triggerEdgeClockLabel = textView5;
        this.triggerHoldoff = editText3;
        this.triggerHoldoffLabel = textView6;
        this.triggerLevel = textView7;
        this.triggerLevelAValue = editText4;
        this.triggerLevelAView = verticalSeekBar;
        this.triggerLevelB = textView8;
        this.triggerLevelBValue = editText5;
        this.triggerLevelBView = verticalSeekBar2;
        this.triggerNoiseLabel = textView9;
        this.triggerNoiseSwitch = switchButton;
        this.triggerSourceClock = textView10;
        this.triggerSourceClockLabel = textView11;
        this.triggerSourceData = textView12;
        this.triggerSourceDataLabel = textView13;
        this.verticalSeekBarWrapper2 = verticalSeekBarWrapper;
        this.verticalSeekBarWrapper3 = verticalSeekBarWrapper2;
        this.view1 = view2;
        this.view2 = view3;
        this.viewLine1 = view4;
        this.viewLine2 = view5;
        this.viewTop = view6;
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

    public MappingObject getSlopeRisingMapping() {
        return this.mSlopeRisingMapping;
    }

    public MappingObject getSlopeFallingMapping() {
        return this.mSlopeFallingMapping;
    }

    public MappingObject getTypeHMapping() {
        return this.mTypeHMapping;
    }

    public MappingObject getTypeLMapping() {
        return this.mTypeLMapping;
    }

    public MappingObject getWhenSetupMapping() {
        return this.mWhenSetupMapping;
    }

    public MappingObject getWhenHoldMapping() {
        return this.mWhenHoldMapping;
    }

    public MappingObject getWhenSetupHoldMapping() {
        return this.mWhenSetupHoldMapping;
    }

    public static AdapterTriggerSetupHoldBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterTriggerSetupHoldBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterTriggerSetupHoldBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_trigger_setup_hold, viewGroup, z, obj);
    }

    public static AdapterTriggerSetupHoldBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterTriggerSetupHoldBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterTriggerSetupHoldBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_trigger_setup_hold, null, false, obj);
    }

    public static AdapterTriggerSetupHoldBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterTriggerSetupHoldBinding bind(View view, Object obj) {
        return (AdapterTriggerSetupHoldBinding) bind(obj, view, R.layout.adapter_trigger_setup_hold);
    }
}
