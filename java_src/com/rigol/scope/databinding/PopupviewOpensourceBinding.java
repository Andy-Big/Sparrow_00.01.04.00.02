package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
/* loaded from: classes2.dex */
public abstract class PopupviewOpensourceBinding extends ViewDataBinding {
    public final View titleLayout;
    public final LinearLayout webview;

    /* JADX INFO: Access modifiers changed from: protected */
    public PopupviewOpensourceBinding(Object obj, View view, int i, View view2, LinearLayout linearLayout) {
        super(obj, view, i);
        this.titleLayout = view2;
        this.webview = linearLayout;
    }

    public static PopupviewOpensourceBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewOpensourceBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (PopupviewOpensourceBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_opensource, viewGroup, z, obj);
    }

    public static PopupviewOpensourceBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewOpensourceBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (PopupviewOpensourceBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_opensource, null, false, obj);
    }

    public static PopupviewOpensourceBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewOpensourceBinding bind(View view, Object obj) {
        return (PopupviewOpensourceBinding) bind(obj, view, R.layout.popupview_opensource);
    }
}
