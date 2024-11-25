package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TimePicker;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
/* loaded from: classes2.dex */
public abstract class CustomTimepickerDialogAntBinding extends ViewDataBinding {
    public final Button confirmButton;
    public final View included;
    public final TimePicker timePicker;

    /* JADX INFO: Access modifiers changed from: protected */
    public CustomTimepickerDialogAntBinding(Object obj, View view, int i, Button button, View view2, TimePicker timePicker) {
        super(obj, view, i);
        this.confirmButton = button;
        this.included = view2;
        this.timePicker = timePicker;
    }

    public static CustomTimepickerDialogAntBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CustomTimepickerDialogAntBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (CustomTimepickerDialogAntBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.custom_timepicker_dialog_ant, viewGroup, z, obj);
    }

    public static CustomTimepickerDialogAntBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CustomTimepickerDialogAntBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (CustomTimepickerDialogAntBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.custom_timepicker_dialog_ant, null, false, obj);
    }

    public static CustomTimepickerDialogAntBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CustomTimepickerDialogAntBinding bind(View view, Object obj) {
        return (CustomTimepickerDialogAntBinding) bind(obj, view, R.layout.custom_timepicker_dialog_ant);
    }
}
