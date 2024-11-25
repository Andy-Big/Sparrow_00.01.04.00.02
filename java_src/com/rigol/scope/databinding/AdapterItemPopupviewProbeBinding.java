package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
import com.rigol.scope.data.SharedParam;
import com.rigol.scope.data.VerticalParam;
/* loaded from: classes2.dex */
public abstract class AdapterItemPopupviewProbeBinding extends ViewDataBinding {
    public final Guideline guidelineCenter;
    public final Guideline guidelineLeft;
    public final Guideline guidelineRight;
    @Bindable
    protected View.OnClickListener mClickListener;
    @Bindable
    protected SharedParam mSharedParam;
    @Bindable
    protected VerticalParam mVerticalParam;
    public final TextView probeBias;
    public final EditText probeBiasEditText;
    public final TextView probeCal;
    public final Button probeCalButton;
    public final TextView probeCalTime;
    public final TextView probeCalTimeText;
    public final TextView probeDelay;
    public final EditText probeDelayEditText;
    public final TextView probeDemag;
    public final Button probeDemagButton;
    public final TextView probeMfr;
    public final TextView probeMfrText;
    public final TextView probeModel;
    public final TextView probeModelText;
    public final TextView probeRatio;
    public final TextView probeRatioSpinner;
    public final TextView probeSn;
    public final TextView probeSnText;

    public abstract void setClickListener(View.OnClickListener onClickListener);

    public abstract void setSharedParam(SharedParam sharedParam);

    public abstract void setVerticalParam(VerticalParam verticalParam);

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterItemPopupviewProbeBinding(Object obj, View view, int i, Guideline guideline, Guideline guideline2, Guideline guideline3, TextView textView, EditText editText, TextView textView2, Button button, TextView textView3, TextView textView4, TextView textView5, EditText editText2, TextView textView6, Button button2, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14) {
        super(obj, view, i);
        this.guidelineCenter = guideline;
        this.guidelineLeft = guideline2;
        this.guidelineRight = guideline3;
        this.probeBias = textView;
        this.probeBiasEditText = editText;
        this.probeCal = textView2;
        this.probeCalButton = button;
        this.probeCalTime = textView3;
        this.probeCalTimeText = textView4;
        this.probeDelay = textView5;
        this.probeDelayEditText = editText2;
        this.probeDemag = textView6;
        this.probeDemagButton = button2;
        this.probeMfr = textView7;
        this.probeMfrText = textView8;
        this.probeModel = textView9;
        this.probeModelText = textView10;
        this.probeRatio = textView11;
        this.probeRatioSpinner = textView12;
        this.probeSn = textView13;
        this.probeSnText = textView14;
    }

    public VerticalParam getVerticalParam() {
        return this.mVerticalParam;
    }

    public SharedParam getSharedParam() {
        return this.mSharedParam;
    }

    public View.OnClickListener getClickListener() {
        return this.mClickListener;
    }

    public static AdapterItemPopupviewProbeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterItemPopupviewProbeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterItemPopupviewProbeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_item_popupview_probe, viewGroup, z, obj);
    }

    public static AdapterItemPopupviewProbeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterItemPopupviewProbeBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterItemPopupviewProbeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_item_popupview_probe, null, false, obj);
    }

    public static AdapterItemPopupviewProbeBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterItemPopupviewProbeBinding bind(View view, Object obj) {
        return (AdapterItemPopupviewProbeBinding) bind(obj, view, R.layout.adapter_item_popupview_probe);
    }
}
