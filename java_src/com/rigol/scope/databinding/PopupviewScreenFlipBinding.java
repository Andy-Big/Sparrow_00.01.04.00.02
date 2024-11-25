package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
/* loaded from: classes2.dex */
public abstract class PopupviewScreenFlipBinding extends ViewDataBinding {
    public final TextView content;

    /* JADX INFO: Access modifiers changed from: protected */
    public PopupviewScreenFlipBinding(Object obj, View view, int i, TextView textView) {
        super(obj, view, i);
        this.content = textView;
    }

    public static PopupviewScreenFlipBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewScreenFlipBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (PopupviewScreenFlipBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_screen_flip, viewGroup, z, obj);
    }

    public static PopupviewScreenFlipBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewScreenFlipBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (PopupviewScreenFlipBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_screen_flip, null, false, obj);
    }

    public static PopupviewScreenFlipBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewScreenFlipBinding bind(View view, Object obj) {
        return (PopupviewScreenFlipBinding) bind(obj, view, R.layout.popupview_screen_flip);
    }
}
