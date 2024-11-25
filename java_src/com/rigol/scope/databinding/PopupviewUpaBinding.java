package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.rigol.scope.R;
import com.rigol.scope.data.HorizontalParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.UpaParam;
import com.rigol.scope.data.UpaRippleParam;
import com.rigol.scope.views.SwitchButton;
/* loaded from: classes2.dex */
public abstract class PopupviewUpaBinding extends ViewDataBinding {
    public final RecyclerView adaperUpaView;
    public final SwitchButton displayOnoffSwitchButton;
    public final Guideline leftGuideline;
    public final Guideline leftGuideline2;
    @Bindable
    protected HorizontalParam mHorizontalParam;
    @Bindable
    protected UpaParam mParam;
    @Bindable
    protected MappingObject mUpaMappingObj;
    @Bindable
    protected UpaRippleParam mUpaRippleParam;
    public final TextView noText;
    public final Guideline rightGuideline;
    public final TextView upaAnalysisSpinner;
    public final TextView upaSpring;

    public abstract void setHorizontalParam(HorizontalParam horizontalParam);

    public abstract void setParam(UpaParam upaParam);

    public abstract void setUpaMappingObj(MappingObject mappingObject);

    public abstract void setUpaRippleParam(UpaRippleParam upaRippleParam);

    /* JADX INFO: Access modifiers changed from: protected */
    public PopupviewUpaBinding(Object obj, View view, int i, RecyclerView recyclerView, SwitchButton switchButton, Guideline guideline, Guideline guideline2, TextView textView, Guideline guideline3, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.adaperUpaView = recyclerView;
        this.displayOnoffSwitchButton = switchButton;
        this.leftGuideline = guideline;
        this.leftGuideline2 = guideline2;
        this.noText = textView;
        this.rightGuideline = guideline3;
        this.upaAnalysisSpinner = textView2;
        this.upaSpring = textView3;
    }

    public MappingObject getUpaMappingObj() {
        return this.mUpaMappingObj;
    }

    public UpaParam getParam() {
        return this.mParam;
    }

    public UpaRippleParam getUpaRippleParam() {
        return this.mUpaRippleParam;
    }

    public HorizontalParam getHorizontalParam() {
        return this.mHorizontalParam;
    }

    public static PopupviewUpaBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewUpaBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (PopupviewUpaBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_upa, viewGroup, z, obj);
    }

    public static PopupviewUpaBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewUpaBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (PopupviewUpaBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_upa, null, false, obj);
    }

    public static PopupviewUpaBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewUpaBinding bind(View view, Object obj) {
        return (PopupviewUpaBinding) bind(obj, view, R.layout.popupview_upa);
    }
}
