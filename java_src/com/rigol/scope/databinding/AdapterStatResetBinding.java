package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.UtilityParam;
/* loaded from: classes2.dex */
public abstract class AdapterStatResetBinding extends ViewDataBinding {
    @Bindable
    protected MappingObject mMaskMapping;
    @Bindable
    protected MappingObject mMeasureMapping;
    @Bindable
    protected UtilityParam mParam;
    public final RadioButton radioButtonMask;
    public final RadioButton radioButtonMeasure;
    public final RadioGroup statResetRadioGroup;
    public final TextView tvStatReset;

    public abstract void setMaskMapping(MappingObject mappingObject);

    public abstract void setMeasureMapping(MappingObject mappingObject);

    public abstract void setParam(UtilityParam utilityParam);

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterStatResetBinding(Object obj, View view, int i, RadioButton radioButton, RadioButton radioButton2, RadioGroup radioGroup, TextView textView) {
        super(obj, view, i);
        this.radioButtonMask = radioButton;
        this.radioButtonMeasure = radioButton2;
        this.statResetRadioGroup = radioGroup;
        this.tvStatReset = textView;
    }

    public UtilityParam getParam() {
        return this.mParam;
    }

    public MappingObject getMeasureMapping() {
        return this.mMeasureMapping;
    }

    public MappingObject getMaskMapping() {
        return this.mMaskMapping;
    }

    public static AdapterStatResetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterStatResetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterStatResetBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_stat_reset, viewGroup, z, obj);
    }

    public static AdapterStatResetBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterStatResetBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterStatResetBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_stat_reset, null, false, obj);
    }

    public static AdapterStatResetBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterStatResetBinding bind(View view, Object obj) {
        return (AdapterStatResetBinding) bind(obj, view, R.layout.adapter_stat_reset);
    }
}
