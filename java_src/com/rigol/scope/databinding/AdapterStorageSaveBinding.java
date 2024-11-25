package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
import com.rigol.scope.data.StorageSaveParam;
import com.rigol.scope.views.SwitchButton;
/* loaded from: classes2.dex */
public abstract class AdapterStorageSaveBinding extends ViewDataBinding {
    public final TextView autoName;
    public final SwitchButton autoNameSwitch;
    public final CheckBox checkBoxCH1;
    public final CheckBox checkBoxCH2;
    public final CheckBox checkBoxCH3;
    public final CheckBox checkBoxCH4;
    public final TextView choose;
    public final View chooseDividingLine;
    public final TextView chooseSpinnerSave;
    public final View fileDividingLine;
    public final Guideline guideline;
    public final TextView imageColor;
    public final SwitchButton imageColorSwitch;
    public final TextView imageFormat;
    public final TextView imageFormatSpinner;
    public final TextView imageHeader;
    public final SwitchButton imageHeaderSwitch;
    public final TextView imageInvert;
    public final SwitchButton imageInvertSwitch;
    @Bindable
    protected StorageSaveParam mParam;
    public final TextView pathName;
    public final EditText pathNameEditText;
    public final TextView prefix;
    public final EditText prefixEditText;
    public final Button save;
    public final TextView setupFormat;
    public final TextView setupFormatSpinner;
    public final TextView smbEnLabel;
    public final SwitchButton smbEnSwitch;
    public final TextView storageChannel;
    public final TextView waveDepth;
    public final TextView waveDepthSpinner;
    public final TextView waveFormat;
    public final TextView waveFormatSpinner;

    public abstract void setParam(StorageSaveParam storageSaveParam);

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterStorageSaveBinding(Object obj, View view, int i, TextView textView, SwitchButton switchButton, CheckBox checkBox, CheckBox checkBox2, CheckBox checkBox3, CheckBox checkBox4, TextView textView2, View view2, TextView textView3, View view3, Guideline guideline, TextView textView4, SwitchButton switchButton2, TextView textView5, TextView textView6, TextView textView7, SwitchButton switchButton3, TextView textView8, SwitchButton switchButton4, TextView textView9, EditText editText, TextView textView10, EditText editText2, Button button, TextView textView11, TextView textView12, TextView textView13, SwitchButton switchButton5, TextView textView14, TextView textView15, TextView textView16, TextView textView17, TextView textView18) {
        super(obj, view, i);
        this.autoName = textView;
        this.autoNameSwitch = switchButton;
        this.checkBoxCH1 = checkBox;
        this.checkBoxCH2 = checkBox2;
        this.checkBoxCH3 = checkBox3;
        this.checkBoxCH4 = checkBox4;
        this.choose = textView2;
        this.chooseDividingLine = view2;
        this.chooseSpinnerSave = textView3;
        this.fileDividingLine = view3;
        this.guideline = guideline;
        this.imageColor = textView4;
        this.imageColorSwitch = switchButton2;
        this.imageFormat = textView5;
        this.imageFormatSpinner = textView6;
        this.imageHeader = textView7;
        this.imageHeaderSwitch = switchButton3;
        this.imageInvert = textView8;
        this.imageInvertSwitch = switchButton4;
        this.pathName = textView9;
        this.pathNameEditText = editText;
        this.prefix = textView10;
        this.prefixEditText = editText2;
        this.save = button;
        this.setupFormat = textView11;
        this.setupFormatSpinner = textView12;
        this.smbEnLabel = textView13;
        this.smbEnSwitch = switchButton5;
        this.storageChannel = textView14;
        this.waveDepth = textView15;
        this.waveDepthSpinner = textView16;
        this.waveFormat = textView17;
        this.waveFormatSpinner = textView18;
    }

    public StorageSaveParam getParam() {
        return this.mParam;
    }

    public static AdapterStorageSaveBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterStorageSaveBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterStorageSaveBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_storage_save, viewGroup, z, obj);
    }

    public static AdapterStorageSaveBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterStorageSaveBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterStorageSaveBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_storage_save, null, false, obj);
    }

    public static AdapterStorageSaveBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterStorageSaveBinding bind(View view, Object obj) {
        return (AdapterStorageSaveBinding) bind(obj, view, R.layout.adapter_storage_save);
    }
}
