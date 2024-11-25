package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.TriggerParam;
import com.rigol.scope.views.SwitchButton;
/* loaded from: classes2.dex */
public abstract class AdapterTriggerFlexrayBinding extends ViewDataBinding {
    public final Button buttonLevel;
    public final Guideline guidelineCenter;
    public final Guideline guidelineFifth;
    public final Guideline guidelineForth;
    public final Guideline guidelineLeft;
    public final Guideline guidelineRight;
    public final Guideline guidelineSpecial1;
    public final Guideline guidelineSpecial2;
    public final Guideline layout2GuidelineCenter;
    public final Guideline layout2GuidelineFifth;
    public final Guideline layout2GuidelineForth;
    public final Guideline layout2GuidelineLeft;
    public final Guideline layout2GuidelineRight;
    public final Guideline layout2GuidelineSpecial1;
    public final Guideline layout2GuidelineSpecial2;
    @Bindable
    protected MappingObject mChanceAMapping;
    @Bindable
    protected MappingObject mChanceBMapping;
    @Bindable
    protected MappingObject mDefineCycMapping;
    @Bindable
    protected TriggerParam mParam;
    @Bindable
    protected MappingObject mSweepAutoMapping;
    @Bindable
    protected MappingObject mSweepNormalMapping;
    @Bindable
    protected MappingObject mSweepSingleMapping;
    @Bindable
    protected MappingObject mWhenErrorMapping;
    @Bindable
    protected MappingObject mWhenFrameMapping;
    @Bindable
    protected MappingObject mWhenPostMapping;
    @Bindable
    protected MappingObject mWhenSymbolMapping;
    public final TextView triggerBaudLabel;
    public final TextView triggerBaudValue;
    public final TextView triggerChanAbLabel;
    public final RadioButton triggerChanceAValue;
    public final RadioButton triggerChanceBValue;
    public final TextView triggerDownLimitCycLabel;
    public final EditText triggerDownLimitCycValue;
    public final TextView triggerDownLimitIdLabel;
    public final EditText triggerDownLimitIdValue;
    public final TextView triggerFlexrayCycCompLabel;
    public final TextView triggerFlexrayCycCompValue;
    public final RadioButton triggerFlexrayDefineCyc;
    public final RadioButton triggerFlexrayDefineId;
    public final TextView triggerFlexrayDefineLabel;
    public final RadioButton triggerFlexrayError;
    public final TextView triggerFlexrayErrorLabel;
    public final TextView triggerFlexrayErrorValue;
    public final RadioButton triggerFlexrayFrame;
    public final TextView triggerFlexrayFrameLabel;
    public final TextView triggerFlexrayFrameValue;
    public final TextView triggerFlexrayIdCompLabel;
    public final TextView triggerFlexrayIdCompValue;
    public final RadioButton triggerFlexrayPost;
    public final TextView triggerFlexrayPostTypeLabel;
    public final TextView triggerFlexrayPostTypeValue;
    public final RadioButton triggerFlexraySymbol;
    public final TextView triggerFlexraySymbolLabel;
    public final TextView triggerFlexraySymbolValue;
    public final TextView triggerLabel;
    public final TextView triggerLevel;
    public final EditText triggerLevelValue;
    public final TextView triggerNoiseLabel;
    public final SwitchButton triggerNoiseSwitch;
    public final TextView triggerSource;
    public final TextView triggerSourceLabel;
    public final TextView triggerSourceLabel2;
    public final TextView triggerUpLimitCycLabel;
    public final EditText triggerUpLimitCycValue;
    public final TextView triggerUpLimitIdLabel;
    public final EditText triggerUpLimitIdValue;
    public final ConstraintLayout view2;
    public final View view3;
    public final View view4;
    public final View viewLine1;
    public final View viewLine2;
    public final View viewTop;

    public abstract void setChanceAMapping(MappingObject mappingObject);

    public abstract void setChanceBMapping(MappingObject mappingObject);

    public abstract void setDefineCycMapping(MappingObject mappingObject);

    public abstract void setParam(TriggerParam triggerParam);

    public abstract void setSweepAutoMapping(MappingObject mappingObject);

    public abstract void setSweepNormalMapping(MappingObject mappingObject);

    public abstract void setSweepSingleMapping(MappingObject mappingObject);

    public abstract void setWhenErrorMapping(MappingObject mappingObject);

    public abstract void setWhenFrameMapping(MappingObject mappingObject);

    public abstract void setWhenPostMapping(MappingObject mappingObject);

    public abstract void setWhenSymbolMapping(MappingObject mappingObject);

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterTriggerFlexrayBinding(Object obj, View view, int i, Button button, Guideline guideline, Guideline guideline2, Guideline guideline3, Guideline guideline4, Guideline guideline5, Guideline guideline6, Guideline guideline7, Guideline guideline8, Guideline guideline9, Guideline guideline10, Guideline guideline11, Guideline guideline12, Guideline guideline13, Guideline guideline14, TextView textView, TextView textView2, TextView textView3, RadioButton radioButton, RadioButton radioButton2, TextView textView4, EditText editText, TextView textView5, EditText editText2, TextView textView6, TextView textView7, RadioButton radioButton3, RadioButton radioButton4, TextView textView8, RadioButton radioButton5, TextView textView9, TextView textView10, RadioButton radioButton6, TextView textView11, TextView textView12, TextView textView13, TextView textView14, RadioButton radioButton7, TextView textView15, TextView textView16, RadioButton radioButton8, TextView textView17, TextView textView18, TextView textView19, TextView textView20, EditText editText3, TextView textView21, SwitchButton switchButton, TextView textView22, TextView textView23, TextView textView24, TextView textView25, EditText editText4, TextView textView26, EditText editText5, ConstraintLayout constraintLayout, View view2, View view3, View view4, View view5, View view6) {
        super(obj, view, i);
        this.buttonLevel = button;
        this.guidelineCenter = guideline;
        this.guidelineFifth = guideline2;
        this.guidelineForth = guideline3;
        this.guidelineLeft = guideline4;
        this.guidelineRight = guideline5;
        this.guidelineSpecial1 = guideline6;
        this.guidelineSpecial2 = guideline7;
        this.layout2GuidelineCenter = guideline8;
        this.layout2GuidelineFifth = guideline9;
        this.layout2GuidelineForth = guideline10;
        this.layout2GuidelineLeft = guideline11;
        this.layout2GuidelineRight = guideline12;
        this.layout2GuidelineSpecial1 = guideline13;
        this.layout2GuidelineSpecial2 = guideline14;
        this.triggerBaudLabel = textView;
        this.triggerBaudValue = textView2;
        this.triggerChanAbLabel = textView3;
        this.triggerChanceAValue = radioButton;
        this.triggerChanceBValue = radioButton2;
        this.triggerDownLimitCycLabel = textView4;
        this.triggerDownLimitCycValue = editText;
        this.triggerDownLimitIdLabel = textView5;
        this.triggerDownLimitIdValue = editText2;
        this.triggerFlexrayCycCompLabel = textView6;
        this.triggerFlexrayCycCompValue = textView7;
        this.triggerFlexrayDefineCyc = radioButton3;
        this.triggerFlexrayDefineId = radioButton4;
        this.triggerFlexrayDefineLabel = textView8;
        this.triggerFlexrayError = radioButton5;
        this.triggerFlexrayErrorLabel = textView9;
        this.triggerFlexrayErrorValue = textView10;
        this.triggerFlexrayFrame = radioButton6;
        this.triggerFlexrayFrameLabel = textView11;
        this.triggerFlexrayFrameValue = textView12;
        this.triggerFlexrayIdCompLabel = textView13;
        this.triggerFlexrayIdCompValue = textView14;
        this.triggerFlexrayPost = radioButton7;
        this.triggerFlexrayPostTypeLabel = textView15;
        this.triggerFlexrayPostTypeValue = textView16;
        this.triggerFlexraySymbol = radioButton8;
        this.triggerFlexraySymbolLabel = textView17;
        this.triggerFlexraySymbolValue = textView18;
        this.triggerLabel = textView19;
        this.triggerLevel = textView20;
        this.triggerLevelValue = editText3;
        this.triggerNoiseLabel = textView21;
        this.triggerNoiseSwitch = switchButton;
        this.triggerSource = textView22;
        this.triggerSourceLabel = textView23;
        this.triggerSourceLabel2 = textView24;
        this.triggerUpLimitCycLabel = textView25;
        this.triggerUpLimitCycValue = editText4;
        this.triggerUpLimitIdLabel = textView26;
        this.triggerUpLimitIdValue = editText5;
        this.view2 = constraintLayout;
        this.view3 = view2;
        this.view4 = view3;
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

    public MappingObject getWhenPostMapping() {
        return this.mWhenPostMapping;
    }

    public MappingObject getWhenFrameMapping() {
        return this.mWhenFrameMapping;
    }

    public MappingObject getWhenSymbolMapping() {
        return this.mWhenSymbolMapping;
    }

    public MappingObject getWhenErrorMapping() {
        return this.mWhenErrorMapping;
    }

    public MappingObject getDefineCycMapping() {
        return this.mDefineCycMapping;
    }

    public MappingObject getChanceAMapping() {
        return this.mChanceAMapping;
    }

    public MappingObject getChanceBMapping() {
        return this.mChanceBMapping;
    }

    public static AdapterTriggerFlexrayBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterTriggerFlexrayBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterTriggerFlexrayBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_trigger_flexray, viewGroup, z, obj);
    }

    public static AdapterTriggerFlexrayBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterTriggerFlexrayBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterTriggerFlexrayBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_trigger_flexray, null, false, obj);
    }

    public static AdapterTriggerFlexrayBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterTriggerFlexrayBinding bind(View view, Object obj) {
        return (AdapterTriggerFlexrayBinding) bind(obj, view, R.layout.adapter_trigger_flexray);
    }
}
