package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
import com.rigol.scope.data.BodeParam;
import com.rigol.scope.views.SwitchButton;
/* loaded from: classes2.dex */
public abstract class PopuviewMiniBodeBinding extends ViewDataBinding {
    public final Guideline leftGuideline;
    public final Guideline leftGuideline1;
    public final Guideline leftGuideline2;
    public final Guideline leftGuideline3;
    @Bindable
    protected BodeParam mParma;
    public final ImageView operateButton;
    public final SwitchButton showBodeSwitch;

    public abstract void setParma(BodeParam bodeParam);

    /* JADX INFO: Access modifiers changed from: protected */
    public PopuviewMiniBodeBinding(Object obj, View view, int i, Guideline guideline, Guideline guideline2, Guideline guideline3, Guideline guideline4, ImageView imageView, SwitchButton switchButton) {
        super(obj, view, i);
        this.leftGuideline = guideline;
        this.leftGuideline1 = guideline2;
        this.leftGuideline2 = guideline3;
        this.leftGuideline3 = guideline4;
        this.operateButton = imageView;
        this.showBodeSwitch = switchButton;
    }

    public BodeParam getParma() {
        return this.mParma;
    }

    public static PopuviewMiniBodeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopuviewMiniBodeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (PopuviewMiniBodeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popuview_mini_bode, viewGroup, z, obj);
    }

    public static PopuviewMiniBodeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopuviewMiniBodeBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (PopuviewMiniBodeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popuview_mini_bode, null, false, obj);
    }

    public static PopuviewMiniBodeBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopuviewMiniBodeBinding bind(View view, Object obj) {
        return (PopuviewMiniBodeBinding) bind(obj, view, R.layout.popuview_mini_bode);
    }
}
