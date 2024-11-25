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
public abstract class PopupviewVerticalBinding extends ViewDataBinding {
    public final TabLayout tabs;
    public final ViewPager2 viewPager;

    /* JADX INFO: Access modifiers changed from: protected */
    public PopupviewVerticalBinding(Object obj, View view, int i, TabLayout tabLayout, ViewPager2 viewPager2) {
        super(obj, view, i);
        this.tabs = tabLayout;
        this.viewPager = viewPager2;
    }

    public static PopupviewVerticalBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewVerticalBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (PopupviewVerticalBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_vertical, viewGroup, z, obj);
    }

    public static PopupviewVerticalBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewVerticalBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (PopupviewVerticalBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_vertical, null, false, obj);
    }

    public static PopupviewVerticalBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewVerticalBinding bind(View view, Object obj) {
        return (PopupviewVerticalBinding) bind(obj, view, R.layout.popupview_vertical);
    }
}
