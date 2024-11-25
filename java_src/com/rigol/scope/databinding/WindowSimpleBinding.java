package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
import com.rigol.scope.views.window.Window;
/* loaded from: classes2.dex */
public abstract class WindowSimpleBinding extends ViewDataBinding {
    public final ConstraintLayout contentLayout;
    public final TextView empty;
    public final TextView loading;
    public final TextView status;
    public final TextView title;
    public final ConstraintLayout titleLayout;
    public final TextView warning;
    public final ImageButton windowClose;
    public final Window windowLayout;
    public final ImageButton windowMove;
    public final ImageButton windowSetting;

    /* JADX INFO: Access modifiers changed from: protected */
    public WindowSimpleBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, ConstraintLayout constraintLayout2, TextView textView5, ImageButton imageButton, Window window, ImageButton imageButton2, ImageButton imageButton3) {
        super(obj, view, i);
        this.contentLayout = constraintLayout;
        this.empty = textView;
        this.loading = textView2;
        this.status = textView3;
        this.title = textView4;
        this.titleLayout = constraintLayout2;
        this.warning = textView5;
        this.windowClose = imageButton;
        this.windowLayout = window;
        this.windowMove = imageButton2;
        this.windowSetting = imageButton3;
    }

    public static WindowSimpleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WindowSimpleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (WindowSimpleBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.window_simple, viewGroup, z, obj);
    }

    public static WindowSimpleBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WindowSimpleBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (WindowSimpleBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.window_simple, null, false, obj);
    }

    public static WindowSimpleBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WindowSimpleBinding bind(View view, Object obj) {
        return (WindowSimpleBinding) bind(obj, view, R.layout.window_simple);
    }
}
