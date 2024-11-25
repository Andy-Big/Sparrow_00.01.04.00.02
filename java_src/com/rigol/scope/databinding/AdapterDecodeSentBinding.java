package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
import com.rigol.scope.data.DecodeParam;
/* loaded from: classes2.dex */
public abstract class AdapterDecodeSentBinding extends ViewDataBinding {
    public final TextView decodeSentCrcLabel;
    public final TextView decodeSentCrcValue;
    public final TextView decodeSentIdleLabel;
    public final TextView decodeSentIdleValue;
    public final ConstraintLayout decodeSentLayout;
    public final TextView decodeSentNibbnumLabel;
    public final TextView decodeSentNibbnumValue;
    public final TextView decodeSentPauseLabel;
    public final TextView decodeSentPauseValue;
    public final TextView decodeSentSignalTypeLabel;
    public final TextView decodeSentSignalTypeValue;
    public final TextView decodeSentSrcLabel;
    public final TextView decodeSentSrcValue;
    public final TextView decodeSentThresLabel;
    public final TextView decodeSentThresValue;
    public final TextView decodeSentTickLabel;
    public final TextView decodeSentTickValue;
    public final TextView decodeSentToleranceLabel;
    public final TextView decodeSentToleranceValue;
    public final Guideline guideline33;
    public final Guideline guideline66;
    public final Guideline guidelineCenter;
    public final Guideline guidelineLeft;
    public final Guideline guidelineRight;
    @Bindable
    protected DecodeParam mParam;

    public abstract void setParam(DecodeParam decodeParam);

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterDecodeSentBinding(Object obj, View view, int i, TextView textView, TextView textView2, TextView textView3, TextView textView4, ConstraintLayout constraintLayout, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, TextView textView15, TextView textView16, TextView textView17, TextView textView18, Guideline guideline, Guideline guideline2, Guideline guideline3, Guideline guideline4, Guideline guideline5) {
        super(obj, view, i);
        this.decodeSentCrcLabel = textView;
        this.decodeSentCrcValue = textView2;
        this.decodeSentIdleLabel = textView3;
        this.decodeSentIdleValue = textView4;
        this.decodeSentLayout = constraintLayout;
        this.decodeSentNibbnumLabel = textView5;
        this.decodeSentNibbnumValue = textView6;
        this.decodeSentPauseLabel = textView7;
        this.decodeSentPauseValue = textView8;
        this.decodeSentSignalTypeLabel = textView9;
        this.decodeSentSignalTypeValue = textView10;
        this.decodeSentSrcLabel = textView11;
        this.decodeSentSrcValue = textView12;
        this.decodeSentThresLabel = textView13;
        this.decodeSentThresValue = textView14;
        this.decodeSentTickLabel = textView15;
        this.decodeSentTickValue = textView16;
        this.decodeSentToleranceLabel = textView17;
        this.decodeSentToleranceValue = textView18;
        this.guideline33 = guideline;
        this.guideline66 = guideline2;
        this.guidelineCenter = guideline3;
        this.guidelineLeft = guideline4;
        this.guidelineRight = guideline5;
    }

    public DecodeParam getParam() {
        return this.mParam;
    }

    public static AdapterDecodeSentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterDecodeSentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterDecodeSentBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_decode_sent, viewGroup, z, obj);
    }

    public static AdapterDecodeSentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterDecodeSentBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterDecodeSentBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_decode_sent, null, false, obj);
    }

    public static AdapterDecodeSentBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterDecodeSentBinding bind(View view, Object obj) {
        return (AdapterDecodeSentBinding) bind(obj, view, R.layout.adapter_decode_sent);
    }
}
