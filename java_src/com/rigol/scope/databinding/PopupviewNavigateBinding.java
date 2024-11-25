package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
import com.rigol.scope.data.HorizontalParam;
import com.rigol.scope.data.NavigateParam;
/* loaded from: classes2.dex */
public abstract class PopupviewNavigateBinding extends ViewDataBinding {
    public final TextView currentFrameText;
    public final TextView currentText;
    public final RadioButton eventRadio;
    public final RelativeLayout frameLinear;
    public final RadioButton frameRadio;
    public final TextView frameSpeedSpinner;
    public final TextView frameSpeedText;
    public final TextView frameText;
    public final View lineView;
    @Bindable
    protected HorizontalParam mHorizontal;
    @Bindable
    protected NavigateParam mParam;
    public final RadioGroup modeRadio;
    public final TextView modeText;
    public final ConstraintLayout navigateLayout;
    public final ImageView playImage;
    public final ImageView playLastImage;
    public final ImageView playNextImage;
    public final ImageView recordToEndImage;
    public final ImageView recordToStartImage;
    public final Button serchButton;
    public final LinearLayout speedLinear;
    public final TextView speedSpinner;
    public final TextView speedText;
    public final TextView startFrameEdit;
    public final TextView startFrameText;
    public final RadioButton timeRadio;
    public final LinearLayout typeLinear;
    public final TextView typeSpinner;
    public final TextView typeText;
    public final TextView visibleFrameText;
    public final TextView visibleSpinner;
    public final TextView visibleText;

    public abstract void setHorizontal(HorizontalParam horizontalParam);

    public abstract void setParam(NavigateParam navigateParam);

    /* JADX INFO: Access modifiers changed from: protected */
    public PopupviewNavigateBinding(Object obj, View view, int i, TextView textView, TextView textView2, RadioButton radioButton, RelativeLayout relativeLayout, RadioButton radioButton2, TextView textView3, TextView textView4, TextView textView5, View view2, RadioGroup radioGroup, TextView textView6, ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, Button button, LinearLayout linearLayout, TextView textView7, TextView textView8, TextView textView9, TextView textView10, RadioButton radioButton3, LinearLayout linearLayout2, TextView textView11, TextView textView12, TextView textView13, TextView textView14, TextView textView15) {
        super(obj, view, i);
        this.currentFrameText = textView;
        this.currentText = textView2;
        this.eventRadio = radioButton;
        this.frameLinear = relativeLayout;
        this.frameRadio = radioButton2;
        this.frameSpeedSpinner = textView3;
        this.frameSpeedText = textView4;
        this.frameText = textView5;
        this.lineView = view2;
        this.modeRadio = radioGroup;
        this.modeText = textView6;
        this.navigateLayout = constraintLayout;
        this.playImage = imageView;
        this.playLastImage = imageView2;
        this.playNextImage = imageView3;
        this.recordToEndImage = imageView4;
        this.recordToStartImage = imageView5;
        this.serchButton = button;
        this.speedLinear = linearLayout;
        this.speedSpinner = textView7;
        this.speedText = textView8;
        this.startFrameEdit = textView9;
        this.startFrameText = textView10;
        this.timeRadio = radioButton3;
        this.typeLinear = linearLayout2;
        this.typeSpinner = textView11;
        this.typeText = textView12;
        this.visibleFrameText = textView13;
        this.visibleSpinner = textView14;
        this.visibleText = textView15;
    }

    public NavigateParam getParam() {
        return this.mParam;
    }

    public HorizontalParam getHorizontal() {
        return this.mHorizontal;
    }

    public static PopupviewNavigateBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewNavigateBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (PopupviewNavigateBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_navigate, viewGroup, z, obj);
    }

    public static PopupviewNavigateBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewNavigateBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (PopupviewNavigateBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_navigate, null, false, obj);
    }

    public static PopupviewNavigateBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewNavigateBinding bind(View view, Object obj) {
        return (PopupviewNavigateBinding) bind(obj, view, R.layout.popupview_navigate);
    }
}
