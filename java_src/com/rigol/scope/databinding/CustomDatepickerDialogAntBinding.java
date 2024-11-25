package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
/* loaded from: classes2.dex */
public abstract class CustomDatepickerDialogAntBinding extends ViewDataBinding {
    public final Button confirmButton;
    public final DatePicker datePicker;
    public final View included;

    /* JADX INFO: Access modifiers changed from: protected */
    public CustomDatepickerDialogAntBinding(Object obj, View view, int i, Button button, DatePicker datePicker, View view2) {
        super(obj, view, i);
        this.confirmButton = button;
        this.datePicker = datePicker;
        this.included = view2;
    }

    public static CustomDatepickerDialogAntBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CustomDatepickerDialogAntBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (CustomDatepickerDialogAntBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.custom_datepicker_dialog_ant, viewGroup, z, obj);
    }

    public static CustomDatepickerDialogAntBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CustomDatepickerDialogAntBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (CustomDatepickerDialogAntBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.custom_datepicker_dialog_ant, null, false, obj);
    }

    public static CustomDatepickerDialogAntBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CustomDatepickerDialogAntBinding bind(View view, Object obj) {
        return (CustomDatepickerDialogAntBinding) bind(obj, view, R.layout.custom_datepicker_dialog_ant);
    }
}
