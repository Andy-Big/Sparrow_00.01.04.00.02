package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.rigol.scope.R;
import com.rigol.scope.data.BodeParam;
/* loaded from: classes2.dex */
public abstract class PopupviewBodeBinding extends ViewDataBinding {
    public final Guideline leftGuideline;
    public final Guideline leftGuideline1;
    public final Guideline leftGuideline2;
    public final Guideline leftGuideline3;
    @Bindable
    protected BodeParam mParma;
    public final TabLayout tabs;
    public final ViewPager2 viewPager;

    public abstract void setParma(BodeParam bodeParam);

    /* JADX INFO: Access modifiers changed from: protected */
    public PopupviewBodeBinding(Object obj, View view, int i, Guideline guideline, Guideline guideline2, Guideline guideline3, Guideline guideline4, TabLayout tabLayout, ViewPager2 viewPager2) {
        super(obj, view, i);
        this.leftGuideline = guideline;
        this.leftGuideline1 = guideline2;
        this.leftGuideline2 = guideline3;
        this.leftGuideline3 = guideline4;
        this.tabs = tabLayout;
        this.viewPager = viewPager2;
    }

    public BodeParam getParma() {
        return this.mParma;
    }

    public static PopupviewBodeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewBodeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (PopupviewBodeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_bode, viewGroup, z, obj);
    }

    public static PopupviewBodeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewBodeBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (PopupviewBodeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_bode, null, false, obj);
    }

    public static PopupviewBodeBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewBodeBinding bind(View view, Object obj) {
        return (PopupviewBodeBinding) bind(obj, view, R.layout.popupview_bode);
    }
}
