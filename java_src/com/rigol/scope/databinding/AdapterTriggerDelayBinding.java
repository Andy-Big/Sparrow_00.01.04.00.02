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
public abstract class AdapterTriggerDelayBinding extends ViewDataBinding {
    public final Button buttonLevel;
    public final Button buttonLevelB;
    public final RadioButton edgeAFalling;
    public final RadioButton edgeARising;
    public final RadioButton edgeBFalling;
    public final RadioButton edgeBRising;
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
    protected MappingObject mEdgeFallingAMapping;
    @Bindable
    protected MappingObject mEdgeFallingBMapping;
    @Bindable
    protected MappingObject mEdgeRisingAMapping;
    @Bindable
    protected MappingObject mEdgeRisingBMapping;
    @Bindable
    protected TriggerParam mParam;
    @Bindable
    protected MappingObject mSweepAutoMapping;
    @Bindable
    protected MappingObject mSweepNormalMapping;
    @Bindable
    protected MappingObject mSweepSingleMapping;
    public final RadioButton moreLess;
    public final RadioButton moreThan;
    public final TextView slopeTypeLabel;
    public final TextView triggerEdgeALabel;
    public final TextView triggerEdgeBLabel;
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
    public final TextView triggerSourceA;
    public final TextView triggerSourceALabel;
    public final TextView triggerSourceB;
    public final TextView triggerSourceBLabel2;
    public final TextView upperLimit;
    public final EditText upperLimitValue;
    public final VerticalSeekBarWrapper verticalSeekBarWrapper2;
    public final VerticalSeekBarWrapper verticalSeekBarWrapper3;
    public final View view1;
    public final View viewLine1;
    public final View viewLine2;
    public final View viewTop;

    public abstract void setEdgeFallingAMapping(MappingObject mappingObject);

    public abstract void setEdgeFallingBMapping(MappingObject mappingObject);

    public abstract void setEdgeRisingAMapping(MappingObject mappingObject);

    public abstract void setEdgeRisingBMapping(MappingObject mappingObject);

    public abstract void setParam(TriggerParam triggerParam);

    public abstract void setSweepAutoMapping(MappingObject mappingObject);

    public abstract void setSweepNormalMapping(MappingObject mappingObject);

    public abstract void setSweepSingleMapping(MappingObject mappingObject);

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterTriggerDelayBinding(Object obj, View view, int i, Button button, Button button2, RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, RadioButton radioButton4, Guideline guideline, Guideline guideline2, Guideline guideline3, Guideline guideline4, Guideline guideline5, ImageView imageView, RadioButton radioButton5, RadioButton radioButton6, TextView textView, EditText editText, RadioButton radioButton7, RadioButton radioButton8, TextView textView2, TextView textView3, TextView textView4, EditText editText2, TextView textView5, TextView textView6, EditText editText3, VerticalSeekBar verticalSeekBar, TextView textView7, EditText editText4, VerticalSeekBar verticalSeekBar2, TextView textView8, SwitchButton switchButton, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, EditText editText5, VerticalSeekBarWrapper verticalSeekBarWrapper, VerticalSeekBarWrapper verticalSeekBarWrapper2, View view2, View view3, View view4, View view5) {
        super(obj, view, i);
        this.buttonLevel = button;
        this.buttonLevelB = button2;
        this.edgeAFalling = radioButton;
        this.edgeARising = radioButton2;
        this.edgeBFalling = radioButton3;
        this.edgeBRising = radioButton4;
        this.guidelineCenter = guideline;
        this.guidelineFifth = guideline2;
        this.guidelineForth = guideline3;
        this.guidelineLeft = guideline4;
        this.guidelineRight = guideline5;
        this.imageView2 = imageView;
        this.lessMore = radioButton5;
        this.lessThan = radioButton6;
        this.lowerLimit = textView;
        this.lowerLimitValue = editText;
        this.moreLess = radioButton7;
        this.moreThan = radioButton8;
        this.slopeTypeLabel = textView2;
        this.triggerEdgeALabel = textView3;
        this.triggerEdgeBLabel = textView4;
        this.triggerHoldoff = editText2;
        this.triggerHoldoffLabel = textView5;
        this.triggerLevel = textView6;
        this.triggerLevelAValue = editText3;
        this.triggerLevelAView = verticalSeekBar;
        this.triggerLevelB = textView7;
        this.triggerLevelBValue = editText4;
        this.triggerLevelBView = verticalSeekBar2;
        this.triggerNoiseLabel = textView8;
        this.triggerNoiseSwitch = switchButton;
        this.triggerSourceA = textView9;
        this.triggerSourceALabel = textView10;
        this.triggerSourceB = textView11;
        this.triggerSourceBLabel2 = textView12;
        this.upperLimit = textView13;
        this.upperLimitValue = editText5;
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

    public MappingObject getEdgeRisingAMapping() {
        return this.mEdgeRisingAMapping;
    }

    public MappingObject getEdgeFallingAMapping() {
        return this.mEdgeFallingAMapping;
    }

    public MappingObject getEdgeRisingBMapping() {
        return this.mEdgeRisingBMapping;
    }

    public MappingObject getEdgeFallingBMapping() {
        return this.mEdgeFallingBMapping;
    }

    public static AdapterTriggerDelayBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterTriggerDelayBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterTriggerDelayBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_trigger_delay, viewGroup, z, obj);
    }

    public static AdapterTriggerDelayBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterTriggerDelayBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterTriggerDelayBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_trigger_delay, null, false, obj);
    }

    public static AdapterTriggerDelayBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterTriggerDelayBinding bind(View view, Object obj) {
        return (AdapterTriggerDelayBinding) bind(obj, view, R.layout.adapter_trigger_delay);
    }
}
