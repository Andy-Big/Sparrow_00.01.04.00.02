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
import androidx.recyclerview.widget.RecyclerView;
import com.rigol.scope.R;
import com.rigol.scope.data.DecodeParam;
import com.rigol.scope.data.HorizontalParam;
import com.rigol.scope.views.SwitchButton;
/* loaded from: classes2.dex */
public abstract class AdapterItemPopupviewDecodeBinding extends ViewDataBinding {
    public final RecyclerView decodeBusTypeView;
    public final ConstraintLayout decodeCommonLayout;
    public final Button decodeCopyTrig;
    public final View decodeDivider1;
    public final View decodeDivider2;
    public final Button decodeEvtExport;
    public final TextView decodeEvtFormatLabel;
    public final TextView decodeEvtFormatValue;
    public final Button decodeEvtJump;
    public final TextView decodeEvtLabel;
    public final SwitchButton decodeEvtValue;
    public final TextView decodeEvtViewLabel;
    public final TextView decodeEvtViewValue;
    public final TextView decodeFormatLabel;
    public final TextView decodeFormatValue;
    public final TextView decodeLabelLabel;
    public final SwitchButton decodeLabelValue;
    public final TextView decodeOnOffLabel;
    public final SwitchButton decodeOnOffValue;
    public final TextView decodeTypeLabel;
    public final TextView decodeTypeValue;
    public final Guideline guideline33;
    public final Guideline guideline66;
    public final Guideline guidelineCenter;
    public final Guideline guidelineLeft;
    public final Guideline guidelineRight;
    @Bindable
    protected HorizontalParam mHorizontalParam;
    @Bindable
    protected DecodeParam mParam;

    public abstract void setHorizontalParam(HorizontalParam horizontalParam);

    public abstract void setParam(DecodeParam decodeParam);

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterItemPopupviewDecodeBinding(Object obj, View view, int i, RecyclerView recyclerView, ConstraintLayout constraintLayout, Button button, View view2, View view3, Button button2, TextView textView, TextView textView2, Button button3, TextView textView3, SwitchButton switchButton, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, SwitchButton switchButton2, TextView textView9, SwitchButton switchButton3, TextView textView10, TextView textView11, Guideline guideline, Guideline guideline2, Guideline guideline3, Guideline guideline4, Guideline guideline5) {
        super(obj, view, i);
        this.decodeBusTypeView = recyclerView;
        this.decodeCommonLayout = constraintLayout;
        this.decodeCopyTrig = button;
        this.decodeDivider1 = view2;
        this.decodeDivider2 = view3;
        this.decodeEvtExport = button2;
        this.decodeEvtFormatLabel = textView;
        this.decodeEvtFormatValue = textView2;
        this.decodeEvtJump = button3;
        this.decodeEvtLabel = textView3;
        this.decodeEvtValue = switchButton;
        this.decodeEvtViewLabel = textView4;
        this.decodeEvtViewValue = textView5;
        this.decodeFormatLabel = textView6;
        this.decodeFormatValue = textView7;
        this.decodeLabelLabel = textView8;
        this.decodeLabelValue = switchButton2;
        this.decodeOnOffLabel = textView9;
        this.decodeOnOffValue = switchButton3;
        this.decodeTypeLabel = textView10;
        this.decodeTypeValue = textView11;
        this.guideline33 = guideline;
        this.guideline66 = guideline2;
        this.guidelineCenter = guideline3;
        this.guidelineLeft = guideline4;
        this.guidelineRight = guideline5;
    }

    public DecodeParam getParam() {
        return this.mParam;
    }

    public HorizontalParam getHorizontalParam() {
        return this.mHorizontalParam;
    }

    public static AdapterItemPopupviewDecodeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterItemPopupviewDecodeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterItemPopupviewDecodeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_item_popupview_decode, viewGroup, z, obj);
    }

    public static AdapterItemPopupviewDecodeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterItemPopupviewDecodeBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterItemPopupviewDecodeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_item_popupview_decode, null, false, obj);
    }

    public static AdapterItemPopupviewDecodeBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterItemPopupviewDecodeBinding bind(View view, Object obj) {
        return (AdapterItemPopupviewDecodeBinding) bind(obj, view, R.layout.adapter_item_popupview_decode);
    }
}
