package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
/* loaded from: classes2.dex */
public abstract class AdapterStorageUpgradeBinding extends ViewDataBinding {
    public final TextView pathName;
    public final EditText pathNameEditText;
    public final TextView tvHint;
    public final TextView tvMemUnenoughHint;
    public final Button upgrade;

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterStorageUpgradeBinding(Object obj, View view, int i, TextView textView, EditText editText, TextView textView2, TextView textView3, Button button) {
        super(obj, view, i);
        this.pathName = textView;
        this.pathNameEditText = editText;
        this.tvHint = textView2;
        this.tvMemUnenoughHint = textView3;
        this.upgrade = button;
    }

    public static AdapterStorageUpgradeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterStorageUpgradeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterStorageUpgradeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_storage_upgrade, viewGroup, z, obj);
    }

    public static AdapterStorageUpgradeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterStorageUpgradeBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterStorageUpgradeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_storage_upgrade, null, false, obj);
    }

    public static AdapterStorageUpgradeBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterStorageUpgradeBinding bind(View view, Object obj) {
        return (AdapterStorageUpgradeBinding) bind(obj, view, R.layout.adapter_storage_upgrade);
    }
}
