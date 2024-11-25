package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
import com.rigol.scope.data.LaParam;
import com.rigol.scope.data.UtilityParam;
import com.rigol.scope.views.NumberProgressBar;
/* loaded from: classes2.dex */
public abstract class PopupviewLaCalibrationBinding extends ViewDataBinding {
    public final Button close;
    public final TextView detail;
    public final ImageView detailArrow;
    public final TextView detailContent;
    public final ScrollView detailScroll;
    public final View dividingLine;
    public final Guideline guidelineCenter;
    public final Guideline guidelineLeft;
    public final TextView lastTime;
    public final TextView lastTimeContent;
    @Bindable
    protected ObservableBoolean mIsProbe;
    @Bindable
    protected LaParam mLaParam;
    @Bindable
    protected View.OnClickListener mOnClickListener;
    @Bindable
    protected UtilityParam mUtilityParam;
    public final TextView notice;
    public final TextView noticeContent;
    public final ConstraintLayout popup;
    public final NumberProgressBar progress;
    public final TextView result;
    public final TextView resultContent;
    public final Button startOrStop;
    public final TextView title;

    public abstract void setIsProbe(ObservableBoolean observableBoolean);

    public abstract void setLaParam(LaParam laParam);

    public abstract void setOnClickListener(View.OnClickListener onClickListener);

    public abstract void setUtilityParam(UtilityParam utilityParam);

    /* JADX INFO: Access modifiers changed from: protected */
    public PopupviewLaCalibrationBinding(Object obj, View view, int i, Button button, TextView textView, ImageView imageView, TextView textView2, ScrollView scrollView, View view2, Guideline guideline, Guideline guideline2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, ConstraintLayout constraintLayout, NumberProgressBar numberProgressBar, TextView textView7, TextView textView8, Button button2, TextView textView9) {
        super(obj, view, i);
        this.close = button;
        this.detail = textView;
        this.detailArrow = imageView;
        this.detailContent = textView2;
        this.detailScroll = scrollView;
        this.dividingLine = view2;
        this.guidelineCenter = guideline;
        this.guidelineLeft = guideline2;
        this.lastTime = textView3;
        this.lastTimeContent = textView4;
        this.notice = textView5;
        this.noticeContent = textView6;
        this.popup = constraintLayout;
        this.progress = numberProgressBar;
        this.result = textView7;
        this.resultContent = textView8;
        this.startOrStop = button2;
        this.title = textView9;
    }

    public LaParam getLaParam() {
        return this.mLaParam;
    }

    public UtilityParam getUtilityParam() {
        return this.mUtilityParam;
    }

    public ObservableBoolean getIsProbe() {
        return this.mIsProbe;
    }

    public View.OnClickListener getOnClickListener() {
        return this.mOnClickListener;
    }

    public static PopupviewLaCalibrationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewLaCalibrationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (PopupviewLaCalibrationBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_la_calibration, viewGroup, z, obj);
    }

    public static PopupviewLaCalibrationBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewLaCalibrationBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (PopupviewLaCalibrationBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_la_calibration, null, false, obj);
    }

    public static PopupviewLaCalibrationBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewLaCalibrationBinding bind(View view, Object obj) {
        return (PopupviewLaCalibrationBinding) bind(obj, view, R.layout.popupview_la_calibration);
    }
}
