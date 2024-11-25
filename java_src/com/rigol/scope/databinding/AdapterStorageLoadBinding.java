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
public abstract class AdapterStorageLoadBinding extends ViewDataBinding {
    public final TextView choose;
    public final View chooseDividingLine;
    public final TextView chooseSpinnerLoad;
    public final Guideline guideline;
    public final Button load;
    @Bindable
    protected StorageLoadParam mParam;
    public final TextView pathName;
    public final EditText pathNameEditText;
    public final TextView setupFileFormat;
    public final TextView setupFileFormatSpinner;
    public final TextView waveFileFormat;
    public final TextView waveFileFormatSpinner;

    public abstract void setParam(StorageLoadParam storageLoadParam);

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterStorageLoadBinding(Object obj, View view, int i, TextView textView, View view2, TextView textView2, Guideline guideline, Button button, TextView textView3, EditText editText, TextView textView4, TextView textView5, TextView textView6, TextView textView7) {
        super(obj, view, i);
        this.choose = textView;
        this.chooseDividingLine = view2;
        this.chooseSpinnerLoad = textView2;
        this.guideline = guideline;
        this.load = button;
        this.pathName = textView3;
        this.pathNameEditText = editText;
        this.setupFileFormat = textView4;
        this.setupFileFormatSpinner = textView5;
        this.waveFileFormat = textView6;
        this.waveFileFormatSpinner = textView7;
    }

    public StorageLoadParam getParam() {
        return this.mParam;
    }

    public static AdapterStorageLoadBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterStorageLoadBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterStorageLoadBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_storage_load, viewGroup, z, obj);
    }

    public static AdapterStorageLoadBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterStorageLoadBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterStorageLoadBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_storage_load, null, false, obj);
    }

    public static AdapterStorageLoadBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterStorageLoadBinding bind(View view, Object obj) {
        return (AdapterStorageLoadBinding) bind(obj, view, R.layout.adapter_storage_load);
    }
}
