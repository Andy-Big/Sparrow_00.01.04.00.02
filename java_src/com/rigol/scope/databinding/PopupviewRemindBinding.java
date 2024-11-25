package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
/* loaded from: classes2.dex */
public abstract class PopupviewRemindBinding extends ViewDataBinding {
    public final Button cancel;
    public final TextView content;
    public final View dividingLine;
    public final Guideline guidelineCenter;
    public final Button ok;
    public final TextView title;

    /* JADX INFO: Access modifiers changed from: protected */
    public PopupviewRemindBinding(Object obj, View view, int i, Button button, TextView textView, View view2, Guideline guideline, Button button2, TextView textView2) {
        super(obj, view, i);
        this.cancel = button;
        this.content = textView;
        this.dividingLine = view2;
        this.guidelineCenter = guideline;
        this.ok = button2;
        this.title = textView2;
    }

    public static PopupviewRemindBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewRemindBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (PopupviewRemindBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_remind, viewGroup, z, obj);
    }

    public static PopupviewRemindBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewRemindBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (PopupviewRemindBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_remind, null, false, obj);
    }

    public static PopupviewRemindBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewRemindBinding bind(View view, Object obj) {
        return (PopupviewRemindBinding) bind(obj, view, R.layout.popupview_remind);
    }
}
