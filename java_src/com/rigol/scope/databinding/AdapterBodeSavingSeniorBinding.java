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
import com.rigol.scope.data.BodeParam;
import com.rigol.scope.data.StorageLoadParam;
import com.rigol.scope.data.StorageSaveParam;
/* loaded from: classes2.dex */
public abstract class AdapterBodeSavingSeniorBinding extends ViewDataBinding {
    public final TextView fileFormat;
    public final TextView fileFormatSpinner;
    public final TextView fileName;
    public final EditText fileNameText;
    public final TextView filePath;
    public final EditText filePathText;
    public final Guideline guidelineCenter;
    public final Button loadBtn;
    public final TextView loadText;
    @Bindable
    protected BodeParam mBodeParam;
    @Bindable
    protected StorageSaveParam mParam;
    @Bindable
    protected StorageLoadParam mStorageParam;
    public final TextView pathLoadName;
    public final EditText pathNameEditLoad;
    public final Button saveBtn;
    public final TextView waveFileFormatSpinner;
    public final TextView waveFileLoadText;

    public abstract void setBodeParam(BodeParam bodeParam);

    public abstract void setParam(StorageSaveParam storageSaveParam);

    public abstract void setStorageParam(StorageLoadParam storageLoadParam);

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterBodeSavingSeniorBinding(Object obj, View view, int i, TextView textView, TextView textView2, TextView textView3, EditText editText, TextView textView4, EditText editText2, Guideline guideline, Button button, TextView textView5, TextView textView6, EditText editText3, Button button2, TextView textView7, TextView textView8) {
        super(obj, view, i);
        this.fileFormat = textView;
        this.fileFormatSpinner = textView2;
        this.fileName = textView3;
        this.fileNameText = editText;
        this.filePath = textView4;
        this.filePathText = editText2;
        this.guidelineCenter = guideline;
        this.loadBtn = button;
        this.loadText = textView5;
        this.pathLoadName = textView6;
        this.pathNameEditLoad = editText3;
        this.saveBtn = button2;
        this.waveFileFormatSpinner = textView7;
        this.waveFileLoadText = textView8;
    }

    public StorageSaveParam getParam() {
        return this.mParam;
    }

    public StorageLoadParam getStorageParam() {
        return this.mStorageParam;
    }

    public BodeParam getBodeParam() {
        return this.mBodeParam;
    }

    public static AdapterBodeSavingSeniorBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterBodeSavingSeniorBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterBodeSavingSeniorBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_bode_saving_senior, viewGroup, z, obj);
    }

    public static AdapterBodeSavingSeniorBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterBodeSavingSeniorBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterBodeSavingSeniorBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_bode_saving_senior, null, false, obj);
    }

    public static AdapterBodeSavingSeniorBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterBodeSavingSeniorBinding bind(View view, Object obj) {
        return (AdapterBodeSavingSeniorBinding) bind(obj, view, R.layout.adapter_bode_saving_senior);
    }
}
