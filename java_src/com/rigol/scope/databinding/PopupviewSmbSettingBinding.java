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
import com.rigol.scope.views.SwitchButton;
/* loaded from: classes2.dex */
public abstract class PopupviewSmbSettingBinding extends ViewDataBinding {
    public final Button connect;
    public final Button disconnect;
    public final Guideline guidelineCenter;
    @Bindable
    protected StorageSaveParam mParam;
    public final TextView passwordLable;
    public final EditText passwordSpinner;
    public final TextView serverPathLable;
    public final EditText serverPathSpinner;
    public final TextView smbAutoConnectLabel;
    public final SwitchButton smbAutoConnectSwitch;
    public final TextView smbConnectStateLabel;
    public final TextView smbConnectStateValue;
    public final TextView smbDriveLetter;
    public final EditText smbDriveLetterText;
    public final TextView userNameLable;
    public final EditText userNameSpinner;

    public abstract void setParam(StorageSaveParam storageSaveParam);

    /* JADX INFO: Access modifiers changed from: protected */
    public PopupviewSmbSettingBinding(Object obj, View view, int i, Button button, Button button2, Guideline guideline, TextView textView, EditText editText, TextView textView2, EditText editText2, TextView textView3, SwitchButton switchButton, TextView textView4, TextView textView5, TextView textView6, EditText editText3, TextView textView7, EditText editText4) {
        super(obj, view, i);
        this.connect = button;
        this.disconnect = button2;
        this.guidelineCenter = guideline;
        this.passwordLable = textView;
        this.passwordSpinner = editText;
        this.serverPathLable = textView2;
        this.serverPathSpinner = editText2;
        this.smbAutoConnectLabel = textView3;
        this.smbAutoConnectSwitch = switchButton;
        this.smbConnectStateLabel = textView4;
        this.smbConnectStateValue = textView5;
        this.smbDriveLetter = textView6;
        this.smbDriveLetterText = editText3;
        this.userNameLable = textView7;
        this.userNameSpinner = editText4;
    }

    public StorageSaveParam getParam() {
        return this.mParam;
    }

    public static PopupviewSmbSettingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewSmbSettingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (PopupviewSmbSettingBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_smb_setting, viewGroup, z, obj);
    }

    public static PopupviewSmbSettingBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewSmbSettingBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (PopupviewSmbSettingBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_smb_setting, null, false, obj);
    }

    public static PopupviewSmbSettingBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewSmbSettingBinding bind(View view, Object obj) {
        return (PopupviewSmbSettingBinding) bind(obj, view, R.layout.popupview_smb_setting);
    }
}
