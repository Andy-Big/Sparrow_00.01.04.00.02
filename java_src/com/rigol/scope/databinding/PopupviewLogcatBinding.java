package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
/* loaded from: classes2.dex */
public abstract class PopupviewLogcatBinding extends ViewDataBinding {
    public final Button buttonRefresh;
    public final Button buttonSave;
    public final View dividingLine;
    public final TextView filter;
    public final TextView filterEdit;
    public final TextView grade;
    public final TextView gradeSpinner;
    public final TextView log;

    /* JADX INFO: Access modifiers changed from: protected */
    public PopupviewLogcatBinding(Object obj, View view, int i, Button button, Button button2, View view2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        super(obj, view, i);
        this.buttonRefresh = button;
        this.buttonSave = button2;
        this.dividingLine = view2;
        this.filter = textView;
        this.filterEdit = textView2;
        this.grade = textView3;
        this.gradeSpinner = textView4;
        this.log = textView5;
    }

    public static PopupviewLogcatBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewLogcatBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (PopupviewLogcatBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_logcat, viewGroup, z, obj);
    }

    public static PopupviewLogcatBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewLogcatBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (PopupviewLogcatBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_logcat, null, false, obj);
    }

    public static PopupviewLogcatBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewLogcatBinding bind(View view, Object obj) {
        return (PopupviewLogcatBinding) bind(obj, view, R.layout.popupview_logcat);
    }
}
