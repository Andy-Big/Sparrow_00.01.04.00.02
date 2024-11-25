package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
/* loaded from: classes2.dex */
public abstract class PopupviewEyeconfigBinding extends ViewDataBinding {
    public final TextView eyeMove;
    public final Button eyeResult;
    public final Button eyeSetting;
    public final ConstraintLayout triggerEdgeLayout;

    /* JADX INFO: Access modifiers changed from: protected */
    public PopupviewEyeconfigBinding(Object obj, View view, int i, TextView textView, Button button, Button button2, ConstraintLayout constraintLayout) {
        super(obj, view, i);
        this.eyeMove = textView;
        this.eyeResult = button;
        this.eyeSetting = button2;
        this.triggerEdgeLayout = constraintLayout;
    }

    public static PopupviewEyeconfigBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewEyeconfigBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (PopupviewEyeconfigBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_eyeconfig, viewGroup, z, obj);
    }

    public static PopupviewEyeconfigBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewEyeconfigBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (PopupviewEyeconfigBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_eyeconfig, null, false, obj);
    }

    public static PopupviewEyeconfigBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewEyeconfigBinding bind(View view, Object obj) {
        return (PopupviewEyeconfigBinding) bind(obj, view, R.layout.popupview_eyeconfig);
    }
}
