package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
/* loaded from: classes2.dex */
public abstract class PopupviewUpgradeBinding extends ViewDataBinding {
    /* JADX INFO: Access modifiers changed from: protected */
    public PopupviewUpgradeBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static PopupviewUpgradeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewUpgradeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (PopupviewUpgradeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_upgrade, viewGroup, z, obj);
    }

    public static PopupviewUpgradeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewUpgradeBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (PopupviewUpgradeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_upgrade, null, false, obj);
    }

    public static PopupviewUpgradeBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewUpgradeBinding bind(View view, Object obj) {
        return (PopupviewUpgradeBinding) bind(obj, view, R.layout.popupview_upgrade);
    }
}
