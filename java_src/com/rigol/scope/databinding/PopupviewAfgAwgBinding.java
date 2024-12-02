package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.rigol.scope.R;

/* loaded from: classes2.dex */
public abstract class PopupviewAfgAwgBinding extends ViewDataBinding {
    public final TabLayout tabs;
    public final ViewPager2 viewPager;

    protected PopupviewAfgAwgBinding(Object obj, View view, int i, TabLayout tabLayout, ViewPager2 viewPager2) {
        super(obj, view, i);
        this.tabs = tabLayout;
        this.viewPager = viewPager2;
    }

    public static PopupviewAfgAwgBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewAfgAwgBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (PopupviewAfgAwgBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_afg_awg, viewGroup, z, obj);
    }

    public static PopupviewAfgAwgBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewAfgAwgBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (PopupviewAfgAwgBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_afg_awg, null, false, obj);
    }

    public static PopupviewAfgAwgBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewAfgAwgBinding bind(View view, Object obj) {
        return (PopupviewAfgAwgBinding) bind(obj, view, R.layout.popupview_afg_awg);
    }
}
