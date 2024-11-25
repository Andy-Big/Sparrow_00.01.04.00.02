package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.StorageSaveParam;
/* loaded from: classes2.dex */
public abstract class AdapterUtilitySaveWaveBinding extends ViewDataBinding {
    public final CheckBox checkBoxCh1;
    public final CheckBox checkBoxCh2;
    public final CheckBox checkBoxCh3;
    public final CheckBox checkBoxCh4;
    @Bindable
    protected MappingObject mMemoryMapping;
    @Bindable
    protected StorageSaveParam mParam;
    @Bindable
    protected MappingObject mScreenMapping;
    public final RadioButton radioButtonBin;
    public final RadioButton radioButtonCsv;
    public final RadioButton radioButtonMemory;
    public final RadioButton radioButtonScreen;
    public final RadioButton radioButtonWfm;
    public final RadioGroup radiogroupDataSource;
    public final RadioGroup radiogroupFormat;
    public final ConstraintLayout savechannelLayout;
    public final TextView textView35;
    public final TextView tvFormat;
    public final TextView tvSavechannel;

    public abstract void setMemoryMapping(MappingObject mappingObject);

    public abstract void setParam(StorageSaveParam storageSaveParam);

    public abstract void setScreenMapping(MappingObject mappingObject);

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterUtilitySaveWaveBinding(Object obj, View view, int i, CheckBox checkBox, CheckBox checkBox2, CheckBox checkBox3, CheckBox checkBox4, RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, RadioButton radioButton4, RadioButton radioButton5, RadioGroup radioGroup, RadioGroup radioGroup2, ConstraintLayout constraintLayout, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.checkBoxCh1 = checkBox;
        this.checkBoxCh2 = checkBox2;
        this.checkBoxCh3 = checkBox3;
        this.checkBoxCh4 = checkBox4;
        this.radioButtonBin = radioButton;
        this.radioButtonCsv = radioButton2;
        this.radioButtonMemory = radioButton3;
        this.radioButtonScreen = radioButton4;
        this.radioButtonWfm = radioButton5;
        this.radiogroupDataSource = radioGroup;
        this.radiogroupFormat = radioGroup2;
        this.savechannelLayout = constraintLayout;
        this.textView35 = textView;
        this.tvFormat = textView2;
        this.tvSavechannel = textView3;
    }

    public StorageSaveParam getParam() {
        return this.mParam;
    }

    public MappingObject getScreenMapping() {
        return this.mScreenMapping;
    }

    public MappingObject getMemoryMapping() {
        return this.mMemoryMapping;
    }

    public static AdapterUtilitySaveWaveBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterUtilitySaveWaveBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterUtilitySaveWaveBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_utility_save_wave, viewGroup, z, obj);
    }

    public static AdapterUtilitySaveWaveBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterUtilitySaveWaveBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterUtilitySaveWaveBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_utility_save_wave, null, false, obj);
    }

    public static AdapterUtilitySaveWaveBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterUtilitySaveWaveBinding bind(View view, Object obj) {
        return (AdapterUtilitySaveWaveBinding) bind(obj, view, R.layout.adapter_utility_save_wave);
    }
}
