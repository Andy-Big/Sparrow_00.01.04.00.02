package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
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
public abstract class AdapterTriggerCanBinding extends ViewDataBinding {
    public final Button buttonLevel;
    public final Guideline guidelineCenter;
    public final Guideline guidelineFifth;
    public final Guideline guidelineForth;
    public final Guideline guidelineLeft;
    public final Guideline guidelineRight;
    public final Guideline layout2GuidelineCenter;
    public final Guideline layout2GuidelineFifth;
    public final Guideline layout2GuidelineForth;
    public final Guideline layout2GuidelineLeft;
    public final Guideline layout2GuidelineRight;
    public final Guideline layout3GuidelineCenter;
    public final Guideline layout3GuidelineFifth;
    public final Guideline layout3GuidelineForth;
    public final Guideline layout3GuidelineLeft;
    public final Guideline layout3GuidelineRight;
    public final Guideline layout4GuidelineCenter;
    public final Guideline layout4GuidelineFifth;
    public final Guideline layout4GuidelineForth;
    public final Guideline layout4GuidelineLeft;
    public final Guideline layout4GuidelineRight;
    @Bindable
    protected MappingObject mDataMapping;
    @Bindable
    protected MappingObject mDefineDataMapping;
    @Bindable
    protected MappingObject mDefineIdMapping;
    @Bindable
    protected TriggerParam mParam;
    @Bindable
    protected MappingObject mSweepAutoMapping;
    @Bindable
    protected MappingObject mSweepNormalMapping;
    @Bindable
    protected MappingObject mSweepSingleMapping;
    public final Guideline sourceGuidelineCenter;
    public final Guideline sourceGuidelineFifth;
    public final Guideline sourceGuidelineForth;
    public final Guideline sourceGuidelineLeft;
    public final Guideline sourceGuidelineRight;
    public final TextView triggerCanDataByteLabel;
    public final TextView triggerCanDataByteValue;
    public final TextView triggerCanDataLabel;
    public final ConstraintLayout triggerCanDataLayout;
    public final EditText triggerCanDataValue;
    public final TextView triggerCanIdExtendedLabel;
    public final SwitchButton triggerCanIdExtendedValue;
    public final TextView triggerCanIdLabel;
    public final EditText triggerCanIdValue;
    public final ConstraintLayout triggerCanLayout;
    public final ConstraintLayout triggerDelayLayout;
    public final TextView triggerLabel;
    public final TextView triggerLevel;
    public final EditText triggerLevelValue;
    public final TextView triggerNoiseLabel;
    public final SwitchButton triggerNoiseSwitch;
    public final TextView triggerSamplePointsFdLabel;
    public final EditText triggerSamplePointsFdValue;
    public final TextView triggerSamplePointsLabel;
    public final EditText triggerSamplePointsValue;
    public final ConstraintLayout triggerSlopeLayout;
    public final TextView triggerSourceCanBaudLabel2;
    public final TextView triggerSourceCanBaudValue;
    public final TextView triggerSourceCanFdBaudLabel2;
    public final TextView triggerSourceCanFdBaudValue;
    public final TextView triggerSourceCanHLabel;
    public final TextView triggerSourceCanHValue;
    public final TextView triggerSourceCanLabel;
    public final TextView triggerSourceCanValue;
    public final TextView triggerSourceCanWhenValue;
    public final View view16;
    public final View view2;

    public abstract void setDataMapping(MappingObject mappingObject);

    public abstract void setDefineDataMapping(MappingObject mappingObject);

    public abstract void setDefineIdMapping(MappingObject mappingObject);

    public abstract void setParam(TriggerParam triggerParam);

    public abstract void setSweepAutoMapping(MappingObject mappingObject);

    public abstract void setSweepNormalMapping(MappingObject mappingObject);

    public abstract void setSweepSingleMapping(MappingObject mappingObject);

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterTriggerCanBinding(Object obj, View view, int i, Button button, Guideline guideline, Guideline guideline2, Guideline guideline3, Guideline guideline4, Guideline guideline5, Guideline guideline6, Guideline guideline7, Guideline guideline8, Guideline guideline9, Guideline guideline10, Guideline guideline11, Guideline guideline12, Guideline guideline13, Guideline guideline14, Guideline guideline15, Guideline guideline16, Guideline guideline17, Guideline guideline18, Guideline guideline19, Guideline guideline20, Guideline guideline21, Guideline guideline22, Guideline guideline23, Guideline guideline24, Guideline guideline25, TextView textView, TextView textView2, TextView textView3, ConstraintLayout constraintLayout, EditText editText, TextView textView4, SwitchButton switchButton, TextView textView5, EditText editText2, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, TextView textView6, TextView textView7, EditText editText3, TextView textView8, SwitchButton switchButton2, TextView textView9, EditText editText4, TextView textView10, EditText editText5, ConstraintLayout constraintLayout4, TextView textView11, TextView textView12, TextView textView13, TextView textView14, TextView textView15, TextView textView16, TextView textView17, TextView textView18, TextView textView19, View view2, View view3) {
        super(obj, view, i);
        this.buttonLevel = button;
        this.guidelineCenter = guideline;
        this.guidelineFifth = guideline2;
        this.guidelineForth = guideline3;
        this.guidelineLeft = guideline4;
        this.guidelineRight = guideline5;
        this.layout2GuidelineCenter = guideline6;
        this.layout2GuidelineFifth = guideline7;
        this.layout2GuidelineForth = guideline8;
        this.layout2GuidelineLeft = guideline9;
        this.layout2GuidelineRight = guideline10;
        this.layout3GuidelineCenter = guideline11;
        this.layout3GuidelineFifth = guideline12;
        this.layout3GuidelineForth = guideline13;
        this.layout3GuidelineLeft = guideline14;
        this.layout3GuidelineRight = guideline15;
        this.layout4GuidelineCenter = guideline16;
        this.layout4GuidelineFifth = guideline17;
        this.layout4GuidelineForth = guideline18;
        this.layout4GuidelineLeft = guideline19;
        this.layout4GuidelineRight = guideline20;
        this.sourceGuidelineCenter = guideline21;
        this.sourceGuidelineFifth = guideline22;
        this.sourceGuidelineForth = guideline23;
        this.sourceGuidelineLeft = guideline24;
        this.sourceGuidelineRight = guideline25;
        this.triggerCanDataByteLabel = textView;
        this.triggerCanDataByteValue = textView2;
        this.triggerCanDataLabel = textView3;
        this.triggerCanDataLayout = constraintLayout;
        this.triggerCanDataValue = editText;
        this.triggerCanIdExtendedLabel = textView4;
        this.triggerCanIdExtendedValue = switchButton;
        this.triggerCanIdLabel = textView5;
        this.triggerCanIdValue = editText2;
        this.triggerCanLayout = constraintLayout2;
        this.triggerDelayLayout = constraintLayout3;
        this.triggerLabel = textView6;
        this.triggerLevel = textView7;
        this.triggerLevelValue = editText3;
        this.triggerNoiseLabel = textView8;
        this.triggerNoiseSwitch = switchButton2;
        this.triggerSamplePointsFdLabel = textView9;
        this.triggerSamplePointsFdValue = editText4;
        this.triggerSamplePointsLabel = textView10;
        this.triggerSamplePointsValue = editText5;
        this.triggerSlopeLayout = constraintLayout4;
        this.triggerSourceCanBaudLabel2 = textView11;
        this.triggerSourceCanBaudValue = textView12;
        this.triggerSourceCanFdBaudLabel2 = textView13;
        this.triggerSourceCanFdBaudValue = textView14;
        this.triggerSourceCanHLabel = textView15;
        this.triggerSourceCanHValue = textView16;
        this.triggerSourceCanLabel = textView17;
        this.triggerSourceCanValue = textView18;
        this.triggerSourceCanWhenValue = textView19;
        this.view16 = view2;
        this.view2 = view3;
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

    public MappingObject getDefineDataMapping() {
        return this.mDefineDataMapping;
    }

    public MappingObject getDefineIdMapping() {
        return this.mDefineIdMapping;
    }

    public MappingObject getDataMapping() {
        return this.mDataMapping;
    }

    public static AdapterTriggerCanBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterTriggerCanBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterTriggerCanBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_trigger_can, viewGroup, z, obj);
    }

    public static AdapterTriggerCanBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterTriggerCanBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterTriggerCanBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_trigger_can, null, false, obj);
    }

    public static AdapterTriggerCanBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterTriggerCanBinding bind(View view, Object obj) {
        return (AdapterTriggerCanBinding) bind(obj, view, R.layout.adapter_trigger_can);
    }
}
