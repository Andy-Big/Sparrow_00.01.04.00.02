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
public abstract class AdapterDecodeArinc429Binding extends ViewDataBinding {
    public final TextView decodeArinc429BaudLabel;
    public final TextView decodeArinc429BaudValue;
    public final TextView decodeArinc429ByteFormatLabel;
    public final TextView decodeArinc429ByteFormatTypeValue;
    public final TextView decodeArinc429DownThreLabel;
    public final TextView decodeArinc429DownThresValue;
    public final ConstraintLayout decodeArinc429Layout;
    public final TextView decodeArinc429SignalTypeLabel;
    public final TextView decodeArinc429SingalTypeValue;
    public final TextView decodeArinc429SrcLabel;
    public final TextView decodeArinc429SrcValue;
    public final TextView decodeArinc429UpThresLabel;
    public final TextView decodeArinc429UpThresValue;
    public final Guideline guideline33;
    public final Guideline guideline66;
    public final Guideline guidelineCenter;
    public final Guideline guidelineLeft;
    public final Guideline guidelineRight;
    @Bindable
    protected DecodeParam mParam;

    public abstract void setParam(DecodeParam decodeParam);

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterDecodeArinc429Binding(Object obj, View view, int i, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, ConstraintLayout constraintLayout, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, Guideline guideline, Guideline guideline2, Guideline guideline3, Guideline guideline4, Guideline guideline5) {
        super(obj, view, i);
        this.decodeArinc429BaudLabel = textView;
        this.decodeArinc429BaudValue = textView2;
        this.decodeArinc429ByteFormatLabel = textView3;
        this.decodeArinc429ByteFormatTypeValue = textView4;
        this.decodeArinc429DownThreLabel = textView5;
        this.decodeArinc429DownThresValue = textView6;
        this.decodeArinc429Layout = constraintLayout;
        this.decodeArinc429SignalTypeLabel = textView7;
        this.decodeArinc429SingalTypeValue = textView8;
        this.decodeArinc429SrcLabel = textView9;
        this.decodeArinc429SrcValue = textView10;
        this.decodeArinc429UpThresLabel = textView11;
        this.decodeArinc429UpThresValue = textView12;
        this.guideline33 = guideline;
        this.guideline66 = guideline2;
        this.guidelineCenter = guideline3;
        this.guidelineLeft = guideline4;
        this.guidelineRight = guideline5;
    }

    public DecodeParam getParam() {
        return this.mParam;
    }

    public static AdapterDecodeArinc429Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterDecodeArinc429Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterDecodeArinc429Binding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_decode_arinc429, viewGroup, z, obj);
    }

    public static AdapterDecodeArinc429Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterDecodeArinc429Binding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterDecodeArinc429Binding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_decode_arinc429, null, false, obj);
    }

    public static AdapterDecodeArinc429Binding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterDecodeArinc429Binding bind(View view, Object obj) {
        return (AdapterDecodeArinc429Binding) bind(obj, view, R.layout.adapter_decode_arinc429);
    }
}
