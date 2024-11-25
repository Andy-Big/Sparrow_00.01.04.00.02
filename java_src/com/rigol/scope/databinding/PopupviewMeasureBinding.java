package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableInt;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.rigol.scope.R;
import com.rigol.scope.data.MeasureSettingParam;
/* loaded from: classes2.dex */
public abstract class PopupviewMeasureBinding extends ViewDataBinding {
    public final ConstraintLayout header;
    public final TextView holder1Spinner;
    public final TextView holder1Title;
    public final TextView holder2Spinner;
    public final TextView holder2Title;
    @Bindable
    protected View.OnClickListener mOnClickListener;
    @Bindable
    protected MeasureSettingParam mParam;
    @Bindable
    protected ObservableInt mPicObservable;
    public final ImageView pic;
    public final Button settingBtn;
    public final TabLayout tabs;
    public final Button verticalSetting;
    public final ViewPager2 viewPager;

    public abstract void setOnClickListener(View.OnClickListener onClickListener);

    public abstract void setParam(MeasureSettingParam measureSettingParam);

    public abstract void setPicObservable(ObservableInt observableInt);

    /* JADX INFO: Access modifiers changed from: protected */
    public PopupviewMeasureBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, ImageView imageView, Button button, TabLayout tabLayout, Button button2, ViewPager2 viewPager2) {
        super(obj, view, i);
        this.header = constraintLayout;
        this.holder1Spinner = textView;
        this.holder1Title = textView2;
        this.holder2Spinner = textView3;
        this.holder2Title = textView4;
        this.pic = imageView;
        this.settingBtn = button;
        this.tabs = tabLayout;
        this.verticalSetting = button2;
        this.viewPager = viewPager2;
    }

    public MeasureSettingParam getParam() {
        return this.mParam;
    }

    public View.OnClickListener getOnClickListener() {
        return this.mOnClickListener;
    }

    public ObservableInt getPicObservable() {
        return this.mPicObservable;
    }

    public static PopupviewMeasureBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewMeasureBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (PopupviewMeasureBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_measure, viewGroup, z, obj);
    }

    public static PopupviewMeasureBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewMeasureBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (PopupviewMeasureBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_measure, null, false, obj);
    }

    public static PopupviewMeasureBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewMeasureBinding bind(View view, Object obj) {
        return (PopupviewMeasureBinding) bind(obj, view, R.layout.popupview_measure);
    }
}
