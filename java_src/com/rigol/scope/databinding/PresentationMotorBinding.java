package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
import com.rigol.scope.data.MotorParam;
import com.rigol.scope.views.baseview.FanScaleView;
/* loaded from: classes2.dex */
public abstract class PresentationMotorBinding extends ViewDataBinding {
    public final Button btnAngleFirst;
    public final LinearLayout btnAngleGroup;
    public final Button btnAngleSecond;
    public final Button btnAngleThird;
    public final ImageView btnDefaultSetting;
    public final LinearLayout btnFanGroup;
    public final Button btnHide;
    public final FanScaleView fanScaleView;
    @Bindable
    protected MotorParam mParam;
    public final ConstraintLayout topTip;
    public final TextView txtDescription2Tip;
    public final ConstraintLayout txtDescriptionGroup;
    public final TextView txtDescriptionTip;
    public final TextView txtDetalutTip;
    public final TextView txtFanTip;

    public abstract void setParam(MotorParam motorParam);

    /* JADX INFO: Access modifiers changed from: protected */
    public PresentationMotorBinding(Object obj, View view, int i, Button button, LinearLayout linearLayout, Button button2, Button button3, ImageView imageView, LinearLayout linearLayout2, Button button4, FanScaleView fanScaleView, ConstraintLayout constraintLayout, TextView textView, ConstraintLayout constraintLayout2, TextView textView2, TextView textView3, TextView textView4) {
        super(obj, view, i);
        this.btnAngleFirst = button;
        this.btnAngleGroup = linearLayout;
        this.btnAngleSecond = button2;
        this.btnAngleThird = button3;
        this.btnDefaultSetting = imageView;
        this.btnFanGroup = linearLayout2;
        this.btnHide = button4;
        this.fanScaleView = fanScaleView;
        this.topTip = constraintLayout;
        this.txtDescription2Tip = textView;
        this.txtDescriptionGroup = constraintLayout2;
        this.txtDescriptionTip = textView2;
        this.txtDetalutTip = textView3;
        this.txtFanTip = textView4;
    }

    public MotorParam getParam() {
        return this.mParam;
    }

    public static PresentationMotorBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PresentationMotorBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (PresentationMotorBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.presentation_motor, viewGroup, z, obj);
    }

    public static PresentationMotorBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PresentationMotorBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (PresentationMotorBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.presentation_motor, null, false, obj);
    }

    public static PresentationMotorBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PresentationMotorBinding bind(View view, Object obj) {
        return (PresentationMotorBinding) bind(obj, view, R.layout.presentation_motor);
    }
}
