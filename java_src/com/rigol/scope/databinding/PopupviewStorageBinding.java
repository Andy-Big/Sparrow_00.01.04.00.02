package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.rigol.scope.R;

/* loaded from: classes2.dex */
public abstract class PopupviewStorageBinding extends ViewDataBinding {
    public final Button diskManage;
    public final Guideline guideline;
    public final Button smbSetting;
    public final TabLayout tabs;
    public final TextView tvMem;
    public final ViewPager2 viewPager;

    protected PopupviewStorageBinding(Object obj, View view, int i, Button button, Guideline guideline, Button button2, TabLayout tabLayout, TextView textView, ViewPager2 viewPager2) {
        super(obj, view, i);
        this.diskManage = button;
        this.guideline = guideline;
        this.smbSetting = button2;
        this.tabs = tabLayout;
        this.tvMem = textView;
        this.viewPager = viewPager2;
    }

    public static PopupviewStorageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewStorageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (PopupviewStorageBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_storage, viewGroup, z, obj);
    }

    public static PopupviewStorageBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewStorageBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (PopupviewStorageBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_storage, null, false, obj);
    }

    public static PopupviewStorageBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewStorageBinding bind(View view, Object obj) {
        return (PopupviewStorageBinding) bind(obj, view, R.layout.popupview_storage);
    }
}
