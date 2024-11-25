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
public abstract class AdapterTriggerI2sBinding extends ViewDataBinding {
    public final Button buttonLevel;
    public final Button buttonLevelb;
    public final Button buttonLevelc;
    public final Guideline guidelineCenter;
    public final Guideline guidelineFifth;
    public final Guideline guidelineForth;
    public final Guideline guidelineLeft;
    public final Guideline guidelineRight;
    public final View height10;
    @Bindable
    protected TriggerParam mParam;
    @Bindable
    protected MappingObject mSweepAutoMapping;
    @Bindable
    protected MappingObject mSweepNormalMapping;
    @Bindable
    protected MappingObject mSweepSingleMapping;
    public final TextView triggerAudioLabel;
    public final TextView triggerAudioValue;
    public final TextView triggerI2sDataLabel;
    public final TextView triggerI2sDataLowLabel;
    public final EditText triggerI2sDataLowValue;
    public final TextView triggerI2sDataUpLabel;
    public final EditText triggerI2sDataUpValue;
    public final EditText triggerI2sDataValue;
    public final TextView triggerIisAlignmentLabel;
    public final TextView triggerIisAlignmentValue;
    public final TextView triggerIisAllwidthLabel;
    public final EditText triggerIisAllwidthValue;
    public final RadioButton triggerIisEq;
    public final RadioButton triggerIisLessthan;
    public final RadioButton triggerIisMoreless;
    public final RadioButton triggerIisMorethan;
    public final RadioButton triggerIisNeq;
    public final RadioButton triggerIisUnmoreless;
    public final TextView triggerIisWidthLabel;
    public final EditText triggerIisWidthValue;
    public final TextView triggerLabel;
    public final TextView triggerLevel;
    public final EditText triggerLevelValue;
    public final TextView triggerLevelb;
    public final EditText triggerLevelbValue;
    public final TextView triggerLevelc;
    public final EditText triggerLevelcValue;
    public final TextView triggerNoiseLabel;
    public final SwitchButton triggerNoiseSwitch;
    public final TextView triggerSourceScl;
    public final TextView triggerSourceSclLabel;
    public final TextView triggerSourceSclkEdgeLabel;
    public final TextView triggerSourceSclkEdgeValue;
    public final TextView triggerSourceSda;
    public final TextView triggerSourceSdaLabel;
    public final TextView triggerSourceWs;
    public final TextView triggerSourceWsLabel;
    public final View view16;
    public final View view2;
    public final View viewBottom;
    public final View viewMiddle;
    public final View viewTop;

    public abstract void setParam(TriggerParam triggerParam);

    public abstract void setSweepAutoMapping(MappingObject mappingObject);

    public abstract void setSweepNormalMapping(MappingObject mappingObject);

    public abstract void setSweepSingleMapping(MappingObject mappingObject);

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterTriggerI2sBinding(Object obj, View view, int i, Button button, Button button2, Button button3, Guideline guideline, Guideline guideline2, Guideline guideline3, Guideline guideline4, Guideline guideline5, View view2, TextView textView, TextView textView2, TextView textView3, TextView textView4, EditText editText, TextView textView5, EditText editText2, EditText editText3, TextView textView6, TextView textView7, TextView textView8, EditText editText4, RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, RadioButton radioButton4, RadioButton radioButton5, RadioButton radioButton6, TextView textView9, EditText editText5, TextView textView10, TextView textView11, EditText editText6, TextView textView12, EditText editText7, TextView textView13, EditText editText8, TextView textView14, SwitchButton switchButton, TextView textView15, TextView textView16, TextView textView17, TextView textView18, TextView textView19, TextView textView20, TextView textView21, TextView textView22, View view3, View view4, View view5, View view6, View view7) {
        super(obj, view, i);
        this.buttonLevel = button;
        this.buttonLevelb = button2;
        this.buttonLevelc = button3;
        this.guidelineCenter = guideline;
        this.guidelineFifth = guideline2;
        this.guidelineForth = guideline3;
        this.guidelineLeft = guideline4;
        this.guidelineRight = guideline5;
        this.height10 = view2;
        this.triggerAudioLabel = textView;
        this.triggerAudioValue = textView2;
        this.triggerI2sDataLabel = textView3;
        this.triggerI2sDataLowLabel = textView4;
        this.triggerI2sDataLowValue = editText;
        this.triggerI2sDataUpLabel = textView5;
        this.triggerI2sDataUpValue = editText2;
        this.triggerI2sDataValue = editText3;
        this.triggerIisAlignmentLabel = textView6;
        this.triggerIisAlignmentValue = textView7;
        this.triggerIisAllwidthLabel = textView8;
        this.triggerIisAllwidthValue = editText4;
        this.triggerIisEq = radioButton;
        this.triggerIisLessthan = radioButton2;
        this.triggerIisMoreless = radioButton3;
        this.triggerIisMorethan = radioButton4;
        this.triggerIisNeq = radioButton5;
        this.triggerIisUnmoreless = radioButton6;
        this.triggerIisWidthLabel = textView9;
        this.triggerIisWidthValue = editText5;
        this.triggerLabel = textView10;
        this.triggerLevel = textView11;
        this.triggerLevelValue = editText6;
        this.triggerLevelb = textView12;
        this.triggerLevelbValue = editText7;
        this.triggerLevelc = textView13;
        this.triggerLevelcValue = editText8;
        this.triggerNoiseLabel = textView14;
        this.triggerNoiseSwitch = switchButton;
        this.triggerSourceScl = textView15;
        this.triggerSourceSclLabel = textView16;
        this.triggerSourceSclkEdgeLabel = textView17;
        this.triggerSourceSclkEdgeValue = textView18;
        this.triggerSourceSda = textView19;
        this.triggerSourceSdaLabel = textView20;
        this.triggerSourceWs = textView21;
        this.triggerSourceWsLabel = textView22;
        this.view16 = view3;
        this.view2 = view4;
        this.viewBottom = view5;
        this.viewMiddle = view6;
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

    public static AdapterTriggerI2sBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterTriggerI2sBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterTriggerI2sBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_trigger_i2s, viewGroup, z, obj);
    }

    public static AdapterTriggerI2sBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterTriggerI2sBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterTriggerI2sBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_trigger_i2s, null, false, obj);
    }

    public static AdapterTriggerI2sBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterTriggerI2sBinding bind(View view, Object obj) {
        return (AdapterTriggerI2sBinding) bind(obj, view, R.layout.adapter_trigger_i2s);
    }
}
