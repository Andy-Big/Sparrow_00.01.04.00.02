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
public abstract class PopupviewRtsaBinding extends ViewDataBinding {
    public final TabLayout rtsaTabs;
    public final ViewPager2 rtsaViewPager;

    /* JADX INFO: Access modifiers changed from: protected */
    public PopupviewRtsaBinding(Object obj, View view, int i, TabLayout tabLayout, ViewPager2 viewPager2) {
        super(obj, view, i);
        this.rtsaTabs = tabLayout;
        this.rtsaViewPager = viewPager2;
    }

    public static PopupviewRtsaBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewRtsaBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (PopupviewRtsaBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_rtsa, viewGroup, z, obj);
    }

    public static PopupviewRtsaBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewRtsaBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (PopupviewRtsaBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_rtsa, null, false, obj);
    }

    public static PopupviewRtsaBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewRtsaBinding bind(View view, Object obj) {
        return (PopupviewRtsaBinding) bind(obj, view, R.layout.popupview_rtsa);
    }
}
