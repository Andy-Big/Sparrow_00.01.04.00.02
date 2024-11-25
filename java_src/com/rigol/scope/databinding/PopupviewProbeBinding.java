package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.rigol.scope.R;
/* loaded from: classes2.dex */
public abstract class PopupviewProbeBinding extends ViewDataBinding {
    @Bindable
    protected View.OnClickListener mClickListener;
    public final TabLayout tabs;
    public final Button verticalSetting;
    public final ViewPager2 viewPager;

    public abstract void setClickListener(View.OnClickListener onClickListener);

    /* JADX INFO: Access modifiers changed from: protected */
    public PopupviewProbeBinding(Object obj, View view, int i, TabLayout tabLayout, Button button, ViewPager2 viewPager2) {
        super(obj, view, i);
        this.tabs = tabLayout;
        this.verticalSetting = button;
        this.viewPager = viewPager2;
    }

    public View.OnClickListener getClickListener() {
        return this.mClickListener;
    }

    public static PopupviewProbeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewProbeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (PopupviewProbeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_probe, viewGroup, z, obj);
    }

    public static PopupviewProbeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewProbeBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (PopupviewProbeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_probe, null, false, obj);
    }

    public static PopupviewProbeBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewProbeBinding bind(View view, Object obj) {
        return (PopupviewProbeBinding) bind(obj, view, R.layout.popupview_probe);
    }
}
