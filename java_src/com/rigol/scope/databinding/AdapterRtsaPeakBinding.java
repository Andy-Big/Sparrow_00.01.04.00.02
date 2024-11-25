package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
import com.rigol.scope.data.FftParam;
import com.rigol.scope.data.HorizontalParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.views.SwitchButton;
/* loaded from: classes2.dex */
public abstract class AdapterRtsaPeakBinding extends ViewDataBinding {
    public final RadioButton AmpRadioButton;
    public final RadioButton FreqRadioButton;
    public final TextView excursion;
    public final EditText excursionText;
    public final Button leftPeakBtn;
    @Bindable
    protected MappingObject mAmpOrderMapping;
    @Bindable
    protected MappingObject mFreqOrderMapping;
    @Bindable
    protected HorizontalParam mHoriParam;
    @Bindable
    protected FftParam mParam;
    public final Button nextPeakBtn;
    public final TextView peak;
    public final TextView peakNum;
    public final EditText peakNumText;
    public final ImageView peakRectangle;
    public final TextView peakTable;
    public final TextView peakTableEn;
    public final SwitchButton peakTableEnswitch;
    public final ImageView peakTableRectangle;
    public final TextView peaken;
    public final SwitchButton peakenSwitch;
    public final Button rightPeakBtn;
    public final ImageView searchParamRectangle;
    public final TextView span;
    public final TextView tableOrder;
    public final RadioGroup tableOrderRadioGroup;
    public final TextView threshold;
    public final EditText thresholdText;

    public abstract void setAmpOrderMapping(MappingObject mappingObject);

    public abstract void setFreqOrderMapping(MappingObject mappingObject);

    public abstract void setHoriParam(HorizontalParam horizontalParam);

    public abstract void setParam(FftParam fftParam);

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterRtsaPeakBinding(Object obj, View view, int i, RadioButton radioButton, RadioButton radioButton2, TextView textView, EditText editText, Button button, Button button2, TextView textView2, TextView textView3, EditText editText2, ImageView imageView, TextView textView4, TextView textView5, SwitchButton switchButton, ImageView imageView2, TextView textView6, SwitchButton switchButton2, Button button3, ImageView imageView3, TextView textView7, TextView textView8, RadioGroup radioGroup, TextView textView9, EditText editText3) {
        super(obj, view, i);
        this.AmpRadioButton = radioButton;
        this.FreqRadioButton = radioButton2;
        this.excursion = textView;
        this.excursionText = editText;
        this.leftPeakBtn = button;
        this.nextPeakBtn = button2;
        this.peak = textView2;
        this.peakNum = textView3;
        this.peakNumText = editText2;
        this.peakRectangle = imageView;
        this.peakTable = textView4;
        this.peakTableEn = textView5;
        this.peakTableEnswitch = switchButton;
        this.peakTableRectangle = imageView2;
        this.peaken = textView6;
        this.peakenSwitch = switchButton2;
        this.rightPeakBtn = button3;
        this.searchParamRectangle = imageView3;
        this.span = textView7;
        this.tableOrder = textView8;
        this.tableOrderRadioGroup = radioGroup;
        this.threshold = textView9;
        this.thresholdText = editText3;
    }

    public FftParam getParam() {
        return this.mParam;
    }

    public HorizontalParam getHoriParam() {
        return this.mHoriParam;
    }

    public MappingObject getAmpOrderMapping() {
        return this.mAmpOrderMapping;
    }

    public MappingObject getFreqOrderMapping() {
        return this.mFreqOrderMapping;
    }

    public static AdapterRtsaPeakBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterRtsaPeakBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterRtsaPeakBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_rtsa_peak, viewGroup, z, obj);
    }

    public static AdapterRtsaPeakBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterRtsaPeakBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterRtsaPeakBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_rtsa_peak, null, false, obj);
    }

    public static AdapterRtsaPeakBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterRtsaPeakBinding bind(View view, Object obj) {
        return (AdapterRtsaPeakBinding) bind(obj, view, R.layout.adapter_rtsa_peak);
    }
}
