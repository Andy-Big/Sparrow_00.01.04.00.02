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
public abstract class AdapterDecode1553bBinding extends ViewDataBinding {
    public final ConstraintLayout decode1553bLayout;
    public final TextView decode1553bSrcLabel;
    public final TextView decode1553bSrcValue;
    public final TextView decode1553bThresLabel;
    public final TextView decode1553bThresValue;
    public final Guideline guideline33;
    public final Guideline guideline66;
    public final Guideline guidelineCenter;
    public final Guideline guidelineLeft;
    public final Guideline guidelineRight;
    @Bindable
    protected DecodeParam mParam;

    public abstract void setParam(DecodeParam decodeParam);

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterDecode1553bBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, Guideline guideline, Guideline guideline2, Guideline guideline3, Guideline guideline4, Guideline guideline5) {
        super(obj, view, i);
        this.decode1553bLayout = constraintLayout;
        this.decode1553bSrcLabel = textView;
        this.decode1553bSrcValue = textView2;
        this.decode1553bThresLabel = textView3;
        this.decode1553bThresValue = textView4;
        this.guideline33 = guideline;
        this.guideline66 = guideline2;
        this.guidelineCenter = guideline3;
        this.guidelineLeft = guideline4;
        this.guidelineRight = guideline5;
    }

    public DecodeParam getParam() {
        return this.mParam;
    }

    public static AdapterDecode1553bBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterDecode1553bBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterDecode1553bBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_decode_1553b, viewGroup, z, obj);
    }

    public static AdapterDecode1553bBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterDecode1553bBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterDecode1553bBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_decode_1553b, null, false, obj);
    }

    public static AdapterDecode1553bBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterDecode1553bBinding bind(View view, Object obj) {
        return (AdapterDecode1553bBinding) bind(obj, view, R.layout.adapter_decode_1553b);
    }
}
