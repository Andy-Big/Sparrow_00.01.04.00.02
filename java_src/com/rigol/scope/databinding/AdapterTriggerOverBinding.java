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
public abstract class AdapterTriggerOverBinding extends ViewDataBinding {
    public final Button buttonLevel;
    public final Button buttonLevelB;
    public final Guideline guidelineCenter;
    public final Guideline guidelineFifth;
    public final Guideline guidelineForth;
    public final Guideline guidelineLeft;
    public final Guideline guidelineRight;
    public final ImageView imageView2;
    @Bindable
    protected TriggerParam mParam;
    @Bindable
    protected MappingObject mPositionEnterMapping;
    @Bindable
    protected MappingObject mPositionExitMapping;
    @Bindable
    protected MappingObject mPositionTimeMapping;
    @Bindable
    protected MappingObject mSlopeEitherMapping;
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
    public final RadioButton overTriggerEnter;
    public final RadioButton overTriggerExit;
    public final TextView overTriggerLabel;
    public final RadioButton overTriggerTime;
    public final TextView overTriggerTimeLabel;
    public final EditText overTriggerTimeValue;
    public final EditText triggerHoldoff;
    public final TextView triggerHoldoffLabel;
    public final TextView triggerLevel;
    public final EditText triggerLevelAValue;
    public final VerticalSeekBar triggerLevelAView;
    public final TextView triggerLevelB;
    public final EditText triggerLevelBValue;
    public final VerticalSeekBar triggerLevelBView;
    public final TextView triggerLevelSelect;
    public final CheckBox triggerLevelSelectAb;
    public final TextView triggerNoiseLabel;
    public final SwitchButton triggerNoiseSwitch;
    public final RadioButton triggerOverEdgeEither;
    public final RadioButton triggerOverEdgeFalling;
    public final TextView triggerOverEdgeLabel;
    public final RadioButton triggerOverEdgeRising;
    public final TextView triggerSource;
    public final TextView triggerSourceLabel;
    public final VerticalSeekBarWrapper verticalSeekBarWrapper2;
    public final VerticalSeekBarWrapper verticalSeekBarWrapper3;
    public final View view1;
    public final View viewLine1;
    public final View viewLine2;
    public final View viewTop;

    public abstract void setParam(TriggerParam triggerParam);

    public abstract void setPositionEnterMapping(MappingObject mappingObject);

    public abstract void setPositionExitMapping(MappingObject mappingObject);

    public abstract void setPositionTimeMapping(MappingObject mappingObject);

    public abstract void setSlopeEitherMapping(MappingObject mappingObject);

    public abstract void setSlopeFallingMapping(MappingObject mappingObject);

    public abstract void setSlopeRisingMapping(MappingObject mappingObject);

    public abstract void setSweepAutoMapping(MappingObject mappingObject);

    public abstract void setSweepNormalMapping(MappingObject mappingObject);

    public abstract void setSweepSingleMapping(MappingObject mappingObject);

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterTriggerOverBinding(Object obj, View view, int i, Button button, Button button2, Guideline guideline, Guideline guideline2, Guideline guideline3, Guideline guideline4, Guideline guideline5, ImageView imageView, RadioButton radioButton, RadioButton radioButton2, TextView textView, RadioButton radioButton3, TextView textView2, EditText editText, EditText editText2, TextView textView3, TextView textView4, EditText editText3, VerticalSeekBar verticalSeekBar, TextView textView5, EditText editText4, VerticalSeekBar verticalSeekBar2, TextView textView6, CheckBox checkBox, TextView textView7, SwitchButton switchButton, RadioButton radioButton4, RadioButton radioButton5, TextView textView8, RadioButton radioButton6, TextView textView9, TextView textView10, VerticalSeekBarWrapper verticalSeekBarWrapper, VerticalSeekBarWrapper verticalSeekBarWrapper2, View view2, View view3, View view4, View view5) {
        super(obj, view, i);
        this.buttonLevel = button;
        this.buttonLevelB = button2;
        this.guidelineCenter = guideline;
        this.guidelineFifth = guideline2;
        this.guidelineForth = guideline3;
        this.guidelineLeft = guideline4;
        this.guidelineRight = guideline5;
        this.imageView2 = imageView;
        this.overTriggerEnter = radioButton;
        this.overTriggerExit = radioButton2;
        this.overTriggerLabel = textView;
        this.overTriggerTime = radioButton3;
        this.overTriggerTimeLabel = textView2;
        this.overTriggerTimeValue = editText;
        this.triggerHoldoff = editText2;
        this.triggerHoldoffLabel = textView3;
        this.triggerLevel = textView4;
        this.triggerLevelAValue = editText3;
        this.triggerLevelAView = verticalSeekBar;
        this.triggerLevelB = textView5;
        this.triggerLevelBValue = editText4;
        this.triggerLevelBView = verticalSeekBar2;
        this.triggerLevelSelect = textView6;
        this.triggerLevelSelectAb = checkBox;
        this.triggerNoiseLabel = textView7;
        this.triggerNoiseSwitch = switchButton;
        this.triggerOverEdgeEither = radioButton4;
        this.triggerOverEdgeFalling = radioButton5;
        this.triggerOverEdgeLabel = textView8;
        this.triggerOverEdgeRising = radioButton6;
        this.triggerSource = textView9;
        this.triggerSourceLabel = textView10;
        this.verticalSeekBarWrapper2 = verticalSeekBarWrapper;
        this.verticalSeekBarWrapper3 = verticalSeekBarWrapper2;
        this.view1 = view2;
        this.viewLine1 = view3;
        this.viewLine2 = view4;
        this.viewTop = view5;
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

    public MappingObject getSlopeEitherMapping() {
        return this.mSlopeEitherMapping;
    }

    public MappingObject getPositionEnterMapping() {
        return this.mPositionEnterMapping;
    }

    public MappingObject getPositionExitMapping() {
        return this.mPositionExitMapping;
    }

    public MappingObject getPositionTimeMapping() {
        return this.mPositionTimeMapping;
    }

    public static AdapterTriggerOverBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterTriggerOverBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterTriggerOverBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_trigger_over, viewGroup, z, obj);
    }

    public static AdapterTriggerOverBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterTriggerOverBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterTriggerOverBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_trigger_over, null, false, obj);
    }

    public static AdapterTriggerOverBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterTriggerOverBinding bind(View view, Object obj) {
        return (AdapterTriggerOverBinding) bind(obj, view, R.layout.adapter_trigger_over);
    }
}
