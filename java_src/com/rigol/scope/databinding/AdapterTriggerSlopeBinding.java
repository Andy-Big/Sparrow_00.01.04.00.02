package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
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
public abstract class AdapterTriggerSlopeBinding extends ViewDataBinding {
    public final Button buttonLevel;
    public final Button buttonLevelB;
    public final RadioButton edgeFalling;
    public final RadioButton edgeRising;
    public final Guideline guidelineCenter;
    public final Guideline guidelineFifth;
    public final Guideline guidelineForth;
    public final Guideline guidelineLeft;
    public final Guideline guidelineRight;
    public final ImageView imageView2;
    public final RadioButton lessMore;
    public final RadioButton lessThan;
    public final TextView lowerLimit;
    public final EditText lowerLimitValue;
    @Bindable
    protected TriggerParam mParam;
    @Bindable
    protected MappingObject mSelectLevelAMapping;
    @Bindable
    protected MappingObject mSelectLevelBMapping;
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
    public final RadioButton moreThan;
    public final TextView slopeTypeLabel;
    public final TextView triggerEdgeLabel;
    public final EditText triggerHoldoff;
    public final TextView triggerHoldoffLabel;
    public final TextView triggerLevel;
    public final EditText triggerLevelAValue;
    public final VerticalSeekBar triggerLevelAView;
    public final TextView triggerLevelB;
    public final EditText triggerLevelBValue;
    public final VerticalSeekBar triggerLevelBView;
    public final RadioButton triggerLevelSelectA;
    public final CheckBox triggerLevelSelectAb;
    public final RadioButton triggerLevelSelectB;
    public final TextView triggerLevelSelectLabel;
    public final View triggerNoise;
    public final TextView triggerNoiseLabel;
    public final SwitchButton triggerNoiseSwitch;
    public final TextView triggerSource;
    public final TextView triggerSourceLabel;
    public final TextView upperLimit;
    public final EditText upperLimitValue;
    public final VerticalSeekBarWrapper verticalSeekBarWrapper2;
    public final VerticalSeekBarWrapper verticalSeekBarWrapper3;
    public final View view1;
    public final View viewTop;

    public abstract void setParam(TriggerParam triggerParam);

    public abstract void setSelectLevelAMapping(MappingObject mappingObject);

    public abstract void setSelectLevelBMapping(MappingObject mappingObject);

    public abstract void setSlopeFallingMapping(MappingObject mappingObject);

    public abstract void setSlopeRisingMapping(MappingObject mappingObject);

    public abstract void setSweepAutoMapping(MappingObject mappingObject);

    public abstract void setSweepNormalMapping(MappingObject mappingObject);

    public abstract void setSweepSingleMapping(MappingObject mappingObject);

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterTriggerSlopeBinding(Object obj, View view, int i, Button button, Button button2, RadioButton radioButton, RadioButton radioButton2, Guideline guideline, Guideline guideline2, Guideline guideline3, Guideline guideline4, Guideline guideline5, ImageView imageView, RadioButton radioButton3, RadioButton radioButton4, TextView textView, EditText editText, RadioButton radioButton5, TextView textView2, TextView textView3, EditText editText2, TextView textView4, TextView textView5, EditText editText3, VerticalSeekBar verticalSeekBar, TextView textView6, EditText editText4, VerticalSeekBar verticalSeekBar2, RadioButton radioButton6, CheckBox checkBox, RadioButton radioButton7, TextView textView7, View view2, TextView textView8, SwitchButton switchButton, TextView textView9, TextView textView10, TextView textView11, EditText editText5, VerticalSeekBarWrapper verticalSeekBarWrapper, VerticalSeekBarWrapper verticalSeekBarWrapper2, View view3, View view4) {
        super(obj, view, i);
        this.buttonLevel = button;
        this.buttonLevelB = button2;
        this.edgeFalling = radioButton;
        this.edgeRising = radioButton2;
        this.guidelineCenter = guideline;
        this.guidelineFifth = guideline2;
        this.guidelineForth = guideline3;
        this.guidelineLeft = guideline4;
        this.guidelineRight = guideline5;
        this.imageView2 = imageView;
        this.lessMore = radioButton3;
        this.lessThan = radioButton4;
        this.lowerLimit = textView;
        this.lowerLimitValue = editText;
        this.moreThan = radioButton5;
        this.slopeTypeLabel = textView2;
        this.triggerEdgeLabel = textView3;
        this.triggerHoldoff = editText2;
        this.triggerHoldoffLabel = textView4;
        this.triggerLevel = textView5;
        this.triggerLevelAValue = editText3;
        this.triggerLevelAView = verticalSeekBar;
        this.triggerLevelB = textView6;
        this.triggerLevelBValue = editText4;
        this.triggerLevelBView = verticalSeekBar2;
        this.triggerLevelSelectA = radioButton6;
        this.triggerLevelSelectAb = checkBox;
        this.triggerLevelSelectB = radioButton7;
        this.triggerLevelSelectLabel = textView7;
        this.triggerNoise = view2;
        this.triggerNoiseLabel = textView8;
        this.triggerNoiseSwitch = switchButton;
        this.triggerSource = textView9;
        this.triggerSourceLabel = textView10;
        this.upperLimit = textView11;
        this.upperLimitValue = editText5;
        this.verticalSeekBarWrapper2 = verticalSeekBarWrapper;
        this.verticalSeekBarWrapper3 = verticalSeekBarWrapper2;
        this.view1 = view3;
        this.viewTop = view4;
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

    public MappingObject getSelectLevelAMapping() {
        return this.mSelectLevelAMapping;
    }

    public MappingObject getSelectLevelBMapping() {
        return this.mSelectLevelBMapping;
    }

    public static AdapterTriggerSlopeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterTriggerSlopeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterTriggerSlopeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_trigger_slope, viewGroup, z, obj);
    }

    public static AdapterTriggerSlopeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterTriggerSlopeBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterTriggerSlopeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_trigger_slope, null, false, obj);
    }

    public static AdapterTriggerSlopeBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterTriggerSlopeBinding bind(View view, Object obj) {
        return (AdapterTriggerSlopeBinding) bind(obj, view, R.layout.adapter_trigger_slope);
    }
}
