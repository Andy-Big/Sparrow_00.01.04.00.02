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
public abstract class AdapterDecodeCanBinding extends ViewDataBinding {
    public final TextView decodeCanBaudLabel;
    public final TextView decodeCanBaudValue;
    public final TextView decodeCanFdBaudLabel;
    public final TextView decodeCanFdBaudValue;
    public final TextView decodeCanFdSampLabel;
    public final TextView decodeCanFdSampValue;
    public final ConstraintLayout decodeCanLayout;
    public final TextView decodeCanSampLabel;
    public final TextView decodeCanSampValue;
    public final TextView decodeCanSignalLabel;
    public final TextView decodeCanSignalValue;
    public final TextView decodeCanSrcLabel;
    public final TextView decodeCanSrcValue;
    public final TextView decodeCanThresLabel;
    public final TextView decodeCanThresValue;
    public final Guideline guideline33;
    public final Guideline guideline66;
    public final Guideline guidelineCenter;
    public final Guideline guidelineLeft;
    public final Guideline guidelineRight;
    @Bindable
    protected DecodeParam mParam;

    public abstract void setParam(DecodeParam decodeParam);

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterDecodeCanBinding(Object obj, View view, int i, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, ConstraintLayout constraintLayout, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, Guideline guideline, Guideline guideline2, Guideline guideline3, Guideline guideline4, Guideline guideline5) {
        super(obj, view, i);
        this.decodeCanBaudLabel = textView;
        this.decodeCanBaudValue = textView2;
        this.decodeCanFdBaudLabel = textView3;
        this.decodeCanFdBaudValue = textView4;
        this.decodeCanFdSampLabel = textView5;
        this.decodeCanFdSampValue = textView6;
        this.decodeCanLayout = constraintLayout;
        this.decodeCanSampLabel = textView7;
        this.decodeCanSampValue = textView8;
        this.decodeCanSignalLabel = textView9;
        this.decodeCanSignalValue = textView10;
        this.decodeCanSrcLabel = textView11;
        this.decodeCanSrcValue = textView12;
        this.decodeCanThresLabel = textView13;
        this.decodeCanThresValue = textView14;
        this.guideline33 = guideline;
        this.guideline66 = guideline2;
        this.guidelineCenter = guideline3;
        this.guidelineLeft = guideline4;
        this.guidelineRight = guideline5;
    }

    public DecodeParam getParam() {
        return this.mParam;
    }

    public static AdapterDecodeCanBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterDecodeCanBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterDecodeCanBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_decode_can, viewGroup, z, obj);
    }

    public static AdapterDecodeCanBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterDecodeCanBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterDecodeCanBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_decode_can, null, false, obj);
    }

    public static AdapterDecodeCanBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterDecodeCanBinding bind(View view, Object obj) {
        return (AdapterDecodeCanBinding) bind(obj, view, R.layout.adapter_decode_can);
    }
}
