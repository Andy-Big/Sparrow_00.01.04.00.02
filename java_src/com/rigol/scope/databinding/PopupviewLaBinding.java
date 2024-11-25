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
public abstract class PopupviewLaBinding extends ViewDataBinding {
    public final TabLayout tabs;
    public final ViewPager2 viewPager;

    /* JADX INFO: Access modifiers changed from: protected */
    public PopupviewLaBinding(Object obj, View view, int i, TabLayout tabLayout, ViewPager2 viewPager2) {
        super(obj, view, i);
        this.tabs = tabLayout;
        this.viewPager = viewPager2;
    }

    public static PopupviewLaBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewLaBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (PopupviewLaBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_la, viewGroup, z, obj);
    }

    public static PopupviewLaBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewLaBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (PopupviewLaBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_la, null, false, obj);
    }

    public static PopupviewLaBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewLaBinding bind(View view, Object obj) {
        return (PopupviewLaBinding) bind(obj, view, R.layout.popupview_la);
    }
}
