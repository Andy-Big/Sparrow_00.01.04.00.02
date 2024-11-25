package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
import com.rigol.scope.data.BodeParam;
import com.rigol.scope.data.FftParam;
import com.rigol.scope.data.MappingObject;
/* loaded from: classes2.dex */
public abstract class BodeResultPopuwinBinding extends ViewDataBinding {
    public final Guideline guidelineCenter;
    public final Guideline guidelineCenter12;
    public final Guideline guidelineCenter2;
    @Bindable
    protected MappingObject mAmpOrderMapping;
    @Bindable
    protected BodeParam mBodeParam;
    @Bindable
    protected MappingObject mFreqOrderMapping;
    @Bindable
    protected FftParam mParam;
    public final TextView nothingText;
    public final TextView nothingText1;
    public final TextView nothingText12;
    public final TextView nothingText2;
    public final TextView nothingText21;
    public final TextView nothingText6;

    public abstract void setAmpOrderMapping(MappingObject mappingObject);

    public abstract void setBodeParam(BodeParam bodeParam);

    public abstract void setFreqOrderMapping(MappingObject mappingObject);

    public abstract void setParam(FftParam fftParam);

    /* JADX INFO: Access modifiers changed from: protected */
    public BodeResultPopuwinBinding(Object obj, View view, int i, Guideline guideline, Guideline guideline2, Guideline guideline3, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6) {
        super(obj, view, i);
        this.guidelineCenter = guideline;
        this.guidelineCenter12 = guideline2;
        this.guidelineCenter2 = guideline3;
        this.nothingText = textView;
        this.nothingText1 = textView2;
        this.nothingText12 = textView3;
        this.nothingText2 = textView4;
        this.nothingText21 = textView5;
        this.nothingText6 = textView6;
    }

    public FftParam getParam() {
        return this.mParam;
    }

    public BodeParam getBodeParam() {
        return this.mBodeParam;
    }

    public MappingObject getAmpOrderMapping() {
        return this.mAmpOrderMapping;
    }

    public MappingObject getFreqOrderMapping() {
        return this.mFreqOrderMapping;
    }

    public static BodeResultPopuwinBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BodeResultPopuwinBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (BodeResultPopuwinBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.bode_result_popuwin, viewGroup, z, obj);
    }

    public static BodeResultPopuwinBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BodeResultPopuwinBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (BodeResultPopuwinBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.bode_result_popuwin, null, false, obj);
    }

    public static BodeResultPopuwinBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BodeResultPopuwinBinding bind(View view, Object obj) {
        return (BodeResultPopuwinBinding) bind(obj, view, R.layout.bode_result_popuwin);
    }
}
