package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
import com.rigol.scope.data.UtilityParam;
/* loaded from: classes2.dex */
public abstract class AdapterUtilitySaveGroupBinding extends ViewDataBinding {
    public final CheckBox checkBoxSaveWave;
    public final CheckBox checkBoxSettingSave;
    public final CheckBox checkboxScreenshot;
    @Bindable
    protected UtilityParam mParam;
    public final TextView textView46;

    public abstract void setParam(UtilityParam utilityParam);

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterUtilitySaveGroupBinding(Object obj, View view, int i, CheckBox checkBox, CheckBox checkBox2, CheckBox checkBox3, TextView textView) {
        super(obj, view, i);
        this.checkBoxSaveWave = checkBox;
        this.checkBoxSettingSave = checkBox2;
        this.checkboxScreenshot = checkBox3;
        this.textView46 = textView;
    }

    public UtilityParam getParam() {
        return this.mParam;
    }

    public static AdapterUtilitySaveGroupBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterUtilitySaveGroupBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterUtilitySaveGroupBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_utility_save_group, viewGroup, z, obj);
    }

    public static AdapterUtilitySaveGroupBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterUtilitySaveGroupBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterUtilitySaveGroupBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_utility_save_group, null, false, obj);
    }

    public static AdapterUtilitySaveGroupBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterUtilitySaveGroupBinding bind(View view, Object obj) {
        return (AdapterUtilitySaveGroupBinding) bind(obj, view, R.layout.adapter_utility_save_group);
    }
}
