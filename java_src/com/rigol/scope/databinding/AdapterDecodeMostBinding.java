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
public abstract class AdapterDecodeMostBinding extends ViewDataBinding {
    public final ConstraintLayout decodeMostLayout;
    public final TextView decodeMostSignalTypeLabel;
    public final TextView decodeMostSignalTypeValue;
    public final TextView decodeMostSrcLabel;
    public final TextView decodeMostSrcValue;
    public final TextView decodeMostThresLabel;
    public final TextView decodeMostThresValue;
    public final Guideline guideline33;
    public final Guideline guideline66;
    public final Guideline guidelineCenter;
    public final Guideline guidelineLeft;
    public final Guideline guidelineRight;
    @Bindable
    protected DecodeParam mParam;

    public abstract void setParam(DecodeParam decodeParam);

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterDecodeMostBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, Guideline guideline, Guideline guideline2, Guideline guideline3, Guideline guideline4, Guideline guideline5) {
        super(obj, view, i);
        this.decodeMostLayout = constraintLayout;
        this.decodeMostSignalTypeLabel = textView;
        this.decodeMostSignalTypeValue = textView2;
        this.decodeMostSrcLabel = textView3;
        this.decodeMostSrcValue = textView4;
        this.decodeMostThresLabel = textView5;
        this.decodeMostThresValue = textView6;
        this.guideline33 = guideline;
        this.guideline66 = guideline2;
        this.guidelineCenter = guideline3;
        this.guidelineLeft = guideline4;
        this.guidelineRight = guideline5;
    }

    public DecodeParam getParam() {
        return this.mParam;
    }

    public static AdapterDecodeMostBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterDecodeMostBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterDecodeMostBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_decode_most, viewGroup, z, obj);
    }

    public static AdapterDecodeMostBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterDecodeMostBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterDecodeMostBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_decode_most, null, false, obj);
    }

    public static AdapterDecodeMostBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterDecodeMostBinding bind(View view, Object obj) {
        return (AdapterDecodeMostBinding) bind(obj, view, R.layout.adapter_decode_most);
    }
}
