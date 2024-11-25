package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
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
public abstract class AdapterTriggerDurationBinding extends ViewDataBinding {
    public final Button buttonLevel;
    public final TextView ch1;
    public final TextView ch2;
    public final TextView ch3;
    public final TextView ch4;
    public final RadioButton durationLessthan;
    public final RadioButton durationMoreless;
    public final RadioButton durationMorethan;
    public final RadioButton durationUnmoreless;
    public final Guideline guidelineCenter;
    public final Guideline guidelineForth;
    public final Guideline guidelineLeft;
    public final Guideline guidelineRight;
    public final ImageView imageView2;
    public final ImageButton keyAll;
    public final ImageButton keyNext;
    public final ImageButton keyOne;
    public final ImageButton keyReturn;
    public final ImageButton keyX;
    public final ImageButton keyZero;
    @Bindable
    protected TriggerParam mParam;
    @Bindable
    protected MappingObject mSweepAutoMapping;
    @Bindable
    protected MappingObject mSweepNormalMapping;
    @Bindable
    protected MappingObject mSweepSingleMapping;
    public final TextView triggerDurationLimitLow;
    public final EditText triggerDurationLimitLowValues;
    public final TextView triggerDurationLimitUp;
    public final EditText triggerDurationLimitUpValues;
    public final TextView triggerFactorLabel;
    public final EditText triggerHoldoff;
    public final TextView triggerHoldoffLabel;
    public final TextView triggerLevel;
    public final EditText triggerLevelValue;
    public final VerticalSeekBar triggerLevelView;
    public final TextView triggerNoiseLabel;
    public final SwitchButton triggerNoiseSwitch;
    public final TextView triggerSource;
    public final TextView triggerSourceLabel;
    public final ImageButton valueCh1;
    public final ImageButton valueCh2;
    public final ImageButton valueCh3;
    public final ImageButton valueCh4;
    public final ImageButton valueD0;
    public final ImageButton valueD1;
    public final ImageButton valueD10;
    public final ImageButton valueD11;
    public final ImageButton valueD12;
    public final ImageButton valueD13;
    public final ImageButton valueD14;
    public final ImageButton valueD15;
    public final ImageButton valueD2;
    public final ImageButton valueD3;
    public final ImageButton valueD4;
    public final ImageButton valueD5;
    public final ImageButton valueD6;
    public final ImageButton valueD7;
    public final ImageButton valueD8;
    public final ImageButton valueD9;
    public final VerticalSeekBarWrapper verticalSeekBarWrapper2;
    public final View view;
    public final View view1;
    public final View view21;
    public final View viewTop;

    public abstract void setParam(TriggerParam triggerParam);

    public abstract void setSweepAutoMapping(MappingObject mappingObject);

    public abstract void setSweepNormalMapping(MappingObject mappingObject);

    public abstract void setSweepSingleMapping(MappingObject mappingObject);

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterTriggerDurationBinding(Object obj, View view, int i, Button button, TextView textView, TextView textView2, TextView textView3, TextView textView4, RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, RadioButton radioButton4, Guideline guideline, Guideline guideline2, Guideline guideline3, Guideline guideline4, ImageView imageView, ImageButton imageButton, ImageButton imageButton2, ImageButton imageButton3, ImageButton imageButton4, ImageButton imageButton5, ImageButton imageButton6, TextView textView5, EditText editText, TextView textView6, EditText editText2, TextView textView7, EditText editText3, TextView textView8, TextView textView9, EditText editText4, VerticalSeekBar verticalSeekBar, TextView textView10, SwitchButton switchButton, TextView textView11, TextView textView12, ImageButton imageButton7, ImageButton imageButton8, ImageButton imageButton9, ImageButton imageButton10, ImageButton imageButton11, ImageButton imageButton12, ImageButton imageButton13, ImageButton imageButton14, ImageButton imageButton15, ImageButton imageButton16, ImageButton imageButton17, ImageButton imageButton18, ImageButton imageButton19, ImageButton imageButton20, ImageButton imageButton21, ImageButton imageButton22, ImageButton imageButton23, ImageButton imageButton24, ImageButton imageButton25, ImageButton imageButton26, VerticalSeekBarWrapper verticalSeekBarWrapper, View view2, View view3, View view4, View view5) {
        super(obj, view, i);
        this.buttonLevel = button;
        this.ch1 = textView;
        this.ch2 = textView2;
        this.ch3 = textView3;
        this.ch4 = textView4;
        this.durationLessthan = radioButton;
        this.durationMoreless = radioButton2;
        this.durationMorethan = radioButton3;
        this.durationUnmoreless = radioButton4;
        this.guidelineCenter = guideline;
        this.guidelineForth = guideline2;
        this.guidelineLeft = guideline3;
        this.guidelineRight = guideline4;
        this.imageView2 = imageView;
        this.keyAll = imageButton;
        this.keyNext = imageButton2;
        this.keyOne = imageButton3;
        this.keyReturn = imageButton4;
        this.keyX = imageButton5;
        this.keyZero = imageButton6;
        this.triggerDurationLimitLow = textView5;
        this.triggerDurationLimitLowValues = editText;
        this.triggerDurationLimitUp = textView6;
        this.triggerDurationLimitUpValues = editText2;
        this.triggerFactorLabel = textView7;
        this.triggerHoldoff = editText3;
        this.triggerHoldoffLabel = textView8;
        this.triggerLevel = textView9;
        this.triggerLevelValue = editText4;
        this.triggerLevelView = verticalSeekBar;
        this.triggerNoiseLabel = textView10;
        this.triggerNoiseSwitch = switchButton;
        this.triggerSource = textView11;
        this.triggerSourceLabel = textView12;
        this.valueCh1 = imageButton7;
        this.valueCh2 = imageButton8;
        this.valueCh3 = imageButton9;
        this.valueCh4 = imageButton10;
        this.valueD0 = imageButton11;
        this.valueD1 = imageButton12;
        this.valueD10 = imageButton13;
        this.valueD11 = imageButton14;
        this.valueD12 = imageButton15;
        this.valueD13 = imageButton16;
        this.valueD14 = imageButton17;
        this.valueD15 = imageButton18;
        this.valueD2 = imageButton19;
        this.valueD3 = imageButton20;
        this.valueD4 = imageButton21;
        this.valueD5 = imageButton22;
        this.valueD6 = imageButton23;
        this.valueD7 = imageButton24;
        this.valueD8 = imageButton25;
        this.valueD9 = imageButton26;
        this.verticalSeekBarWrapper2 = verticalSeekBarWrapper;
        this.view = view2;
        this.view1 = view3;
        this.view21 = view4;
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

    public static AdapterTriggerDurationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterTriggerDurationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterTriggerDurationBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_trigger_duration, viewGroup, z, obj);
    }

    public static AdapterTriggerDurationBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterTriggerDurationBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterTriggerDurationBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_trigger_duration, null, false, obj);
    }

    public static AdapterTriggerDurationBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterTriggerDurationBinding bind(View view, Object obj) {
        return (AdapterTriggerDurationBinding) bind(obj, view, R.layout.adapter_trigger_duration);
    }
}
