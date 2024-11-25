package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
import com.rigol.scope.views.busAnalyse.BusAnalyseUsbParam;
/* loaded from: classes2.dex */
public abstract class AdapterBusUsbAnalyseBinding extends ViewDataBinding {
    public final View busAnalyseDivider1;
    public final Button busAnalyseUsbAutoSetButton;
    public final TextView busAnalyseUsbDiffsrcLabel;
    public final TextView busAnalyseUsbDiffsrcValue;
    public final ConstraintLayout busAnalyseUsbLayout;
    public final TextView busAnalyseUsbPointLabel;
    public final TextView busAnalyseUsbPointValue;
    public final TextView busAnalyseUsbSourceDpLabel;
    public final TextView busAnalyseUsbSourceDpValue;
    public final TextView busAnalyseUsbSourceDsLabel;
    public final TextView busAnalyseUsbSourceDsValue;
    public final Button busAnalyseUsbTestButton;
    public final TextView busAnalyseUsbTypeLabel;
    public final TextView busAnalyseUsbTypeValue;
    public final Guideline guidelineCenter;
    public final Guideline guidelineLeft;
    public final Guideline guidelineRight;
    @Bindable
    protected BusAnalyseUsbParam mParam;

    public abstract void setParam(BusAnalyseUsbParam busAnalyseUsbParam);

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterBusUsbAnalyseBinding(Object obj, View view, int i, View view2, Button button, TextView textView, TextView textView2, ConstraintLayout constraintLayout, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, Button button2, TextView textView9, TextView textView10, Guideline guideline, Guideline guideline2, Guideline guideline3) {
        super(obj, view, i);
        this.busAnalyseDivider1 = view2;
        this.busAnalyseUsbAutoSetButton = button;
        this.busAnalyseUsbDiffsrcLabel = textView;
        this.busAnalyseUsbDiffsrcValue = textView2;
        this.busAnalyseUsbLayout = constraintLayout;
        this.busAnalyseUsbPointLabel = textView3;
        this.busAnalyseUsbPointValue = textView4;
        this.busAnalyseUsbSourceDpLabel = textView5;
        this.busAnalyseUsbSourceDpValue = textView6;
        this.busAnalyseUsbSourceDsLabel = textView7;
        this.busAnalyseUsbSourceDsValue = textView8;
        this.busAnalyseUsbTestButton = button2;
        this.busAnalyseUsbTypeLabel = textView9;
        this.busAnalyseUsbTypeValue = textView10;
        this.guidelineCenter = guideline;
        this.guidelineLeft = guideline2;
        this.guidelineRight = guideline3;
    }

    public BusAnalyseUsbParam getParam() {
        return this.mParam;
    }

    public static AdapterBusUsbAnalyseBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterBusUsbAnalyseBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterBusUsbAnalyseBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_bus_usb_analyse, viewGroup, z, obj);
    }

    public static AdapterBusUsbAnalyseBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterBusUsbAnalyseBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterBusUsbAnalyseBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_bus_usb_analyse, null, false, obj);
    }

    public static AdapterBusUsbAnalyseBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterBusUsbAnalyseBinding bind(View view, Object obj) {
        return (AdapterBusUsbAnalyseBinding) bind(obj, view, R.layout.adapter_bus_usb_analyse);
    }
}
