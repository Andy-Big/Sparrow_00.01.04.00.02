package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
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
public abstract class AdapterTriggerPatternBinding extends ViewDataBinding {
    public final Button buttonLevel;
    public final TextView ch1;
    public final TextView ch2;
    public final TextView ch3;
    public final TextView ch4;
    public final TextView d0;
    public final TextView d1;
    public final TextView d10;
    public final TextView d11;
    public final TextView d12;
    public final TextView d13;
    public final TextView d14;
    public final TextView d15;
    public final TextView d2;
    public final TextView d3;
    public final TextView d4;
    public final TextView d5;
    public final TextView d6;
    public final TextView d7;
    public final TextView d8;
    public final TextView d9;
    public final Guideline guidelineCenter;
    public final Guideline guidelineForth;
    public final Guideline guidelineLeft;
    public final Guideline guidelineRight;
    public final ImageView imageView2;
    public final ImageButton keyAll;
    public final ImageButton keyFalling;
    public final ImageButton keyNext;
    public final ImageButton keyOne;
    public final ImageButton keyReturn;
    public final ImageButton keyRising;
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
    public final View view21;
    public final View viewTop;

    public abstract void setParam(TriggerParam triggerParam);

    public abstract void setSweepAutoMapping(MappingObject mappingObject);

    public abstract void setSweepNormalMapping(MappingObject mappingObject);

    public abstract void setSweepSingleMapping(MappingObject mappingObject);

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterTriggerPatternBinding(Object obj, View view, int i, Button button, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, TextView textView15, TextView textView16, TextView textView17, TextView textView18, TextView textView19, TextView textView20, Guideline guideline, Guideline guideline2, Guideline guideline3, Guideline guideline4, ImageView imageView, ImageButton imageButton, ImageButton imageButton2, ImageButton imageButton3, ImageButton imageButton4, ImageButton imageButton5, ImageButton imageButton6, ImageButton imageButton7, ImageButton imageButton8, EditText editText, TextView textView21, TextView textView22, EditText editText2, VerticalSeekBar verticalSeekBar, TextView textView23, SwitchButton switchButton, TextView textView24, TextView textView25, ImageButton imageButton9, ImageButton imageButton10, ImageButton imageButton11, ImageButton imageButton12, ImageButton imageButton13, ImageButton imageButton14, ImageButton imageButton15, ImageButton imageButton16, ImageButton imageButton17, ImageButton imageButton18, ImageButton imageButton19, ImageButton imageButton20, ImageButton imageButton21, ImageButton imageButton22, ImageButton imageButton23, ImageButton imageButton24, ImageButton imageButton25, ImageButton imageButton26, ImageButton imageButton27, ImageButton imageButton28, VerticalSeekBarWrapper verticalSeekBarWrapper, View view2, View view3, View view4) {
        super(obj, view, i);
        this.buttonLevel = button;
        this.ch1 = textView;
        this.ch2 = textView2;
        this.ch3 = textView3;
        this.ch4 = textView4;
        this.d0 = textView5;
        this.d1 = textView6;
        this.d10 = textView7;
        this.d11 = textView8;
        this.d12 = textView9;
        this.d13 = textView10;
        this.d14 = textView11;
        this.d15 = textView12;
        this.d2 = textView13;
        this.d3 = textView14;
        this.d4 = textView15;
        this.d5 = textView16;
        this.d6 = textView17;
        this.d7 = textView18;
        this.d8 = textView19;
        this.d9 = textView20;
        this.guidelineCenter = guideline;
        this.guidelineForth = guideline2;
        this.guidelineLeft = guideline3;
        this.guidelineRight = guideline4;
        this.imageView2 = imageView;
        this.keyAll = imageButton;
        this.keyFalling = imageButton2;
        this.keyNext = imageButton3;
        this.keyOne = imageButton4;
        this.keyReturn = imageButton5;
        this.keyRising = imageButton6;
        this.keyX = imageButton7;
        this.keyZero = imageButton8;
        this.triggerHoldoff = editText;
        this.triggerHoldoffLabel = textView21;
        this.triggerLevel = textView22;
        this.triggerLevelValue = editText2;
        this.triggerLevelView = verticalSeekBar;
        this.triggerNoiseLabel = textView23;
        this.triggerNoiseSwitch = switchButton;
        this.triggerSource = textView24;
        this.triggerSourceLabel = textView25;
        this.valueCh1 = imageButton9;
        this.valueCh2 = imageButton10;
        this.valueCh3 = imageButton11;
        this.valueCh4 = imageButton12;
        this.valueD0 = imageButton13;
        this.valueD1 = imageButton14;
        this.valueD10 = imageButton15;
        this.valueD11 = imageButton16;
        this.valueD12 = imageButton17;
        this.valueD13 = imageButton18;
        this.valueD14 = imageButton19;
        this.valueD15 = imageButton20;
        this.valueD2 = imageButton21;
        this.valueD3 = imageButton22;
        this.valueD4 = imageButton23;
        this.valueD5 = imageButton24;
        this.valueD6 = imageButton25;
        this.valueD7 = imageButton26;
        this.valueD8 = imageButton27;
        this.valueD9 = imageButton28;
        this.verticalSeekBarWrapper2 = verticalSeekBarWrapper;
        this.view = view2;
        this.view21 = view3;
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

    public static AdapterTriggerPatternBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterTriggerPatternBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterTriggerPatternBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_trigger_pattern, viewGroup, z, obj);
    }

    public static AdapterTriggerPatternBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterTriggerPatternBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterTriggerPatternBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_trigger_pattern, null, false, obj);
    }

    public static AdapterTriggerPatternBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterTriggerPatternBinding bind(View view, Object obj) {
        return (AdapterTriggerPatternBinding) bind(obj, view, R.layout.adapter_trigger_pattern);
    }
}
