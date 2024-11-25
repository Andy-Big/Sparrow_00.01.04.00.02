package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.rigol.scope.R;
import com.rigol.scope.data.UtilityParam;
/* loaded from: classes2.dex */
public abstract class AdapterUtilityCalibrationBinding extends ViewDataBinding {
    public final Button calExport;
    public final TextView calItems;
    public final RecyclerView calItemsList;
    public final Button calLoadDefault;
    public final Button calLoadUser;
    public final View dividing;
    public final ImageView image;
    @Bindable
    protected UtilityParam mParam;
    public final TextView notice;
    public final TextView noticeContent;
    public final Button start;

    public abstract void setParam(UtilityParam utilityParam);

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterUtilityCalibrationBinding(Object obj, View view, int i, Button button, TextView textView, RecyclerView recyclerView, Button button2, Button button3, View view2, ImageView imageView, TextView textView2, TextView textView3, Button button4) {
        super(obj, view, i);
        this.calExport = button;
        this.calItems = textView;
        this.calItemsList = recyclerView;
        this.calLoadDefault = button2;
        this.calLoadUser = button3;
        this.dividing = view2;
        this.image = imageView;
        this.notice = textView2;
        this.noticeContent = textView3;
        this.start = button4;
    }

    public UtilityParam getParam() {
        return this.mParam;
    }

    public static AdapterUtilityCalibrationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterUtilityCalibrationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterUtilityCalibrationBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_utility_calibration, viewGroup, z, obj);
    }

    public static AdapterUtilityCalibrationBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterUtilityCalibrationBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterUtilityCalibrationBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_utility_calibration, null, false, obj);
    }

    public static AdapterUtilityCalibrationBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterUtilityCalibrationBinding bind(View view, Object obj) {
        return (AdapterUtilityCalibrationBinding) bind(obj, view, R.layout.adapter_utility_calibration);
    }
}
