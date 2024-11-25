package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
import com.rigol.scope.data.StorageLoadParam;
/* loaded from: classes2.dex */
public abstract class PopupviewLoadBinding extends ViewDataBinding {
    public final TextView fileFormat;
    public final TextView fileFormatSpinner;
    public final TextView filePath;
    public final EditText filePathText;
    public final Guideline guidelineCenter;
    public final Button loadBtn;
    @Bindable
    protected StorageLoadParam mParam;

    public abstract void setParam(StorageLoadParam storageLoadParam);

    /* JADX INFO: Access modifiers changed from: protected */
    public PopupviewLoadBinding(Object obj, View view, int i, TextView textView, TextView textView2, TextView textView3, EditText editText, Guideline guideline, Button button) {
        super(obj, view, i);
        this.fileFormat = textView;
        this.fileFormatSpinner = textView2;
        this.filePath = textView3;
        this.filePathText = editText;
        this.guidelineCenter = guideline;
        this.loadBtn = button;
    }

    public StorageLoadParam getParam() {
        return this.mParam;
    }

    public static PopupviewLoadBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewLoadBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (PopupviewLoadBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_load, viewGroup, z, obj);
    }

    public static PopupviewLoadBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewLoadBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (PopupviewLoadBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_load, null, false, obj);
    }

    public static PopupviewLoadBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewLoadBinding bind(View view, Object obj) {
        return (PopupviewLoadBinding) bind(obj, view, R.layout.popupview_load);
    }
}
