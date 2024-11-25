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
import com.rigol.scope.data.StorageSaveParam;
/* loaded from: classes2.dex */
public abstract class PopupviewSaveBinding extends ViewDataBinding {
    public final TextView fileFormat;
    public final TextView fileFormatSpinner;
    public final TextView fileName;
    public final EditText fileNameText;
    public final TextView filePath;
    public final EditText filePathText;
    public final Guideline guidelineCenter;
    @Bindable
    protected StorageSaveParam mParam;
    public final Button saveBtn;

    public abstract void setParam(StorageSaveParam storageSaveParam);

    /* JADX INFO: Access modifiers changed from: protected */
    public PopupviewSaveBinding(Object obj, View view, int i, TextView textView, TextView textView2, TextView textView3, EditText editText, TextView textView4, EditText editText2, Guideline guideline, Button button) {
        super(obj, view, i);
        this.fileFormat = textView;
        this.fileFormatSpinner = textView2;
        this.fileName = textView3;
        this.fileNameText = editText;
        this.filePath = textView4;
        this.filePathText = editText2;
        this.guidelineCenter = guideline;
        this.saveBtn = button;
    }

    public StorageSaveParam getParam() {
        return this.mParam;
    }

    public static PopupviewSaveBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewSaveBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (PopupviewSaveBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_save, viewGroup, z, obj);
    }

    public static PopupviewSaveBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewSaveBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (PopupviewSaveBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_save, null, false, obj);
    }

    public static PopupviewSaveBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewSaveBinding bind(View view, Object obj) {
        return (PopupviewSaveBinding) bind(obj, view, R.layout.popupview_save);
    }
}
