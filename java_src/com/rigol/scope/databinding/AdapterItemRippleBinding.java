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
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.UpaParam;
import com.rigol.scope.data.UpaRippleParam;
/* loaded from: classes2.dex */
public abstract class AdapterItemRippleBinding extends ViewDataBinding {
    public final Guideline leftGuideline;
    public final Guideline leftGuideline2;
    @Bindable
    protected UpaRippleParam mParam;
    @Bindable
    protected UpaParam mQualityParam;
    @Bindable
    protected MappingObject mUpaMappingObj;
    public final Guideline rightGuideline;
    public final Button upaReccovery;
    public final Button upaRippelReccovery;
    public final EditText upaRippleEditText;
    public final TextView upaRippleSpinner;
    public final TextView upaSpring;
    public final TextView upaSpring1;

    public abstract void setParam(UpaRippleParam upaRippleParam);

    public abstract void setQualityParam(UpaParam upaParam);

    public abstract void setUpaMappingObj(MappingObject mappingObject);

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterItemRippleBinding(Object obj, View view, int i, Guideline guideline, Guideline guideline2, Guideline guideline3, Button button, Button button2, EditText editText, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.leftGuideline = guideline;
        this.leftGuideline2 = guideline2;
        this.rightGuideline = guideline3;
        this.upaReccovery = button;
        this.upaRippelReccovery = button2;
        this.upaRippleEditText = editText;
        this.upaRippleSpinner = textView;
        this.upaSpring = textView2;
        this.upaSpring1 = textView3;
    }

    public MappingObject getUpaMappingObj() {
        return this.mUpaMappingObj;
    }

    public UpaRippleParam getParam() {
        return this.mParam;
    }

    public UpaParam getQualityParam() {
        return this.mQualityParam;
    }

    public static AdapterItemRippleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterItemRippleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterItemRippleBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_item_ripple, viewGroup, z, obj);
    }

    public static AdapterItemRippleBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterItemRippleBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterItemRippleBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_item_ripple, null, false, obj);
    }

    public static AdapterItemRippleBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterItemRippleBinding bind(View view, Object obj) {
        return (AdapterItemRippleBinding) bind(obj, view, R.layout.adapter_item_ripple);
    }
}
