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
public abstract class AdapterTriggerVideoBinding extends ViewDataBinding {
    public final RadioButton allLines;
    public final Button buttonLevel;
    public final RadioButton even;
    public final Guideline guidelineCenter;
    public final Guideline guidelineForth;
    public final Guideline guidelineLeft;
    public final Guideline guidelineRight;
    public final ImageView imageView2;
    public final RadioButton lines;
    public final TextView linesNumber;
    public final EditText linesNumberValue;
    @Bindable
    protected TriggerParam mParam;
    @Bindable
    protected MappingObject mPolarityNegativeMapping;
    @Bindable
    protected MappingObject mPolarityPositiveMapping;
    @Bindable
    protected MappingObject mSweepAutoMapping;
    @Bindable
    protected MappingObject mSweepNormalMapping;
    @Bindable
    protected MappingObject mSweepSingleMapping;
    public final RadioButton odd;
    public final RadioButton polarityN;
    public final RadioButton polarityP;
    public final TextView triggerLevel;
    public final EditText triggerLevelValue;
    public final VerticalSeekBar triggerLevelView;
    public final TextView triggerNoiseLabel;
    public final SwitchButton triggerNoiseSwitch;
    public final TextView triggerPolarityLabel;
    public final TextView triggerSource;
    public final TextView triggerSourceLabel;
    public final TextView triggerVideoSync;
    public final VerticalSeekBarWrapper verticalSeekBarWrapper2;
    public final TextView videoStandard;
    public final TextView videoStandardValue;
    public final View view1;
    public final View view15;
    public final View view2;
    public final View viewTop;

    public abstract void setParam(TriggerParam triggerParam);

    public abstract void setPolarityNegativeMapping(MappingObject mappingObject);

    public abstract void setPolarityPositiveMapping(MappingObject mappingObject);

    public abstract void setSweepAutoMapping(MappingObject mappingObject);

    public abstract void setSweepNormalMapping(MappingObject mappingObject);

    public abstract void setSweepSingleMapping(MappingObject mappingObject);

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterTriggerVideoBinding(Object obj, View view, int i, RadioButton radioButton, Button button, RadioButton radioButton2, Guideline guideline, Guideline guideline2, Guideline guideline3, Guideline guideline4, ImageView imageView, RadioButton radioButton3, TextView textView, EditText editText, RadioButton radioButton4, RadioButton radioButton5, RadioButton radioButton6, TextView textView2, EditText editText2, VerticalSeekBar verticalSeekBar, TextView textView3, SwitchButton switchButton, TextView textView4, TextView textView5, TextView textView6, TextView textView7, VerticalSeekBarWrapper verticalSeekBarWrapper, TextView textView8, TextView textView9, View view2, View view3, View view4, View view5) {
        super(obj, view, i);
        this.allLines = radioButton;
        this.buttonLevel = button;
        this.even = radioButton2;
        this.guidelineCenter = guideline;
        this.guidelineForth = guideline2;
        this.guidelineLeft = guideline3;
        this.guidelineRight = guideline4;
        this.imageView2 = imageView;
        this.lines = radioButton3;
        this.linesNumber = textView;
        this.linesNumberValue = editText;
        this.odd = radioButton4;
        this.polarityN = radioButton5;
        this.polarityP = radioButton6;
        this.triggerLevel = textView2;
        this.triggerLevelValue = editText2;
        this.triggerLevelView = verticalSeekBar;
        this.triggerNoiseLabel = textView3;
        this.triggerNoiseSwitch = switchButton;
        this.triggerPolarityLabel = textView4;
        this.triggerSource = textView5;
        this.triggerSourceLabel = textView6;
        this.triggerVideoSync = textView7;
        this.verticalSeekBarWrapper2 = verticalSeekBarWrapper;
        this.videoStandard = textView8;
        this.videoStandardValue = textView9;
        this.view1 = view2;
        this.view15 = view3;
        this.view2 = view4;
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

    public MappingObject getPolarityPositiveMapping() {
        return this.mPolarityPositiveMapping;
    }

    public MappingObject getPolarityNegativeMapping() {
        return this.mPolarityNegativeMapping;
    }

    public static AdapterTriggerVideoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterTriggerVideoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterTriggerVideoBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_trigger_video, viewGroup, z, obj);
    }

    public static AdapterTriggerVideoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterTriggerVideoBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterTriggerVideoBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_trigger_video, null, false, obj);
    }

    public static AdapterTriggerVideoBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterTriggerVideoBinding bind(View view, Object obj) {
        return (AdapterTriggerVideoBinding) bind(obj, view, R.layout.adapter_trigger_video);
    }
}
