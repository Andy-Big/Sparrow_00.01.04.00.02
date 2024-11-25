package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
import com.rigol.scope.data.FftParam;
/* loaded from: classes2.dex */
public abstract class AdapterRtsaMarkerBinding extends ViewDataBinding {
    public final Button addAllBtn;
    public final CheckBox checkBoxMarker1;
    public final CheckBox checkBoxMarker2;
    public final CheckBox checkBoxMarker3;
    public final CheckBox checkBoxMarker4;
    public final CheckBox checkBoxMarker5;
    public final CheckBox checkBoxMarker6;
    public final CheckBox checkBoxMarker7;
    public final CheckBox checkBoxMarker8;
    @Bindable
    protected FftParam mParam;
    public final Button removeAllBtn;

    public abstract void setParam(FftParam fftParam);

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterRtsaMarkerBinding(Object obj, View view, int i, Button button, CheckBox checkBox, CheckBox checkBox2, CheckBox checkBox3, CheckBox checkBox4, CheckBox checkBox5, CheckBox checkBox6, CheckBox checkBox7, CheckBox checkBox8, Button button2) {
        super(obj, view, i);
        this.addAllBtn = button;
        this.checkBoxMarker1 = checkBox;
        this.checkBoxMarker2 = checkBox2;
        this.checkBoxMarker3 = checkBox3;
        this.checkBoxMarker4 = checkBox4;
        this.checkBoxMarker5 = checkBox5;
        this.checkBoxMarker6 = checkBox6;
        this.checkBoxMarker7 = checkBox7;
        this.checkBoxMarker8 = checkBox8;
        this.removeAllBtn = button2;
    }

    public FftParam getParam() {
        return this.mParam;
    }

    public static AdapterRtsaMarkerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterRtsaMarkerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterRtsaMarkerBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_rtsa_marker, viewGroup, z, obj);
    }

    public static AdapterRtsaMarkerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterRtsaMarkerBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterRtsaMarkerBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_rtsa_marker, null, false, obj);
    }

    public static AdapterRtsaMarkerBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterRtsaMarkerBinding bind(View view, Object obj) {
        return (AdapterRtsaMarkerBinding) bind(obj, view, R.layout.adapter_rtsa_marker);
    }
}
