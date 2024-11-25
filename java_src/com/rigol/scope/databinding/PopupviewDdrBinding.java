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
import com.rigol.scope.views.NumberProgressBar;
/* loaded from: classes2.dex */
public abstract class PopupviewDdrBinding extends ViewDataBinding {
    public final TextView fileName;
    public final EditText fileNameText;
    public final TextView filePath;
    public final EditText filePathText;
    public final Guideline guidelineCenter;
    public final Button loadBtn;
    @Bindable
    protected StorageSaveParam mParam;
    public final NumberProgressBar progress;
    public final Button saveBtn;
    public final TextView size;
    public final EditText sizeText;
    public final TextView startAddr;
    public final EditText startAddrText;

    public abstract void setParam(StorageSaveParam storageSaveParam);

    /* JADX INFO: Access modifiers changed from: protected */
    public PopupviewDdrBinding(Object obj, View view, int i, TextView textView, EditText editText, TextView textView2, EditText editText2, Guideline guideline, Button button, NumberProgressBar numberProgressBar, Button button2, TextView textView3, EditText editText3, TextView textView4, EditText editText4) {
        super(obj, view, i);
        this.fileName = textView;
        this.fileNameText = editText;
        this.filePath = textView2;
        this.filePathText = editText2;
        this.guidelineCenter = guideline;
        this.loadBtn = button;
        this.progress = numberProgressBar;
        this.saveBtn = button2;
        this.size = textView3;
        this.sizeText = editText3;
        this.startAddr = textView4;
        this.startAddrText = editText4;
    }

    public StorageSaveParam getParam() {
        return this.mParam;
    }

    public static PopupviewDdrBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewDdrBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (PopupviewDdrBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_ddr, viewGroup, z, obj);
    }

    public static PopupviewDdrBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewDdrBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (PopupviewDdrBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_ddr, null, false, obj);
    }

    public static PopupviewDdrBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewDdrBinding bind(View view, Object obj) {
        return (PopupviewDdrBinding) bind(obj, view, R.layout.popupview_ddr);
    }
}
