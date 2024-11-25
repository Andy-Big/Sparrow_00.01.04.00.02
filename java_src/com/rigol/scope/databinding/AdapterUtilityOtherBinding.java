package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
import com.rigol.scope.data.HorizontalParam;
import com.rigol.scope.data.UtilityParam;
import com.rigol.scope.views.SwitchButton;
/* loaded from: classes2.dex */
public abstract class AdapterUtilityOtherBinding extends ViewDataBinding {
    public final ConstraintLayout filter1Layout;
    public final ConstraintLayout filter2Layout;
    public final TextView hdmi;
    public final TextView hdmiSpinner;
    public final ImageView imageView11;
    @Bindable
    protected HorizontalParam mHorizontalParam;
    @Bindable
    protected UtilityParam mUtilityParam;
    public final TextView openSourceLicense;
    public final ConstraintLayout openSourceLicenseLayout;
    public final TextView refClock;
    public final ConstraintLayout refClockLayout;
    public final SwitchButton switchButtonFilter1;
    public final SwitchButton switchButtonFilter2;
    public final SwitchButton switchButtonRefClock;
    public final SwitchButton switchButtonZbd;
    public final TextView tvFilter1;
    public final TextView tvFilter2;
    public final TextView zbd;
    public final ConstraintLayout zbdLayout;

    public abstract void setHorizontalParam(HorizontalParam horizontalParam);

    public abstract void setUtilityParam(UtilityParam utilityParam);

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterUtilityOtherBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, TextView textView, TextView textView2, ImageView imageView, TextView textView3, ConstraintLayout constraintLayout3, TextView textView4, ConstraintLayout constraintLayout4, SwitchButton switchButton, SwitchButton switchButton2, SwitchButton switchButton3, SwitchButton switchButton4, TextView textView5, TextView textView6, TextView textView7, ConstraintLayout constraintLayout5) {
        super(obj, view, i);
        this.filter1Layout = constraintLayout;
        this.filter2Layout = constraintLayout2;
        this.hdmi = textView;
        this.hdmiSpinner = textView2;
        this.imageView11 = imageView;
        this.openSourceLicense = textView3;
        this.openSourceLicenseLayout = constraintLayout3;
        this.refClock = textView4;
        this.refClockLayout = constraintLayout4;
        this.switchButtonFilter1 = switchButton;
        this.switchButtonFilter2 = switchButton2;
        this.switchButtonRefClock = switchButton3;
        this.switchButtonZbd = switchButton4;
        this.tvFilter1 = textView5;
        this.tvFilter2 = textView6;
        this.zbd = textView7;
        this.zbdLayout = constraintLayout5;
    }

    public HorizontalParam getHorizontalParam() {
        return this.mHorizontalParam;
    }

    public UtilityParam getUtilityParam() {
        return this.mUtilityParam;
    }

    public static AdapterUtilityOtherBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterUtilityOtherBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterUtilityOtherBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_utility_other, viewGroup, z, obj);
    }

    public static AdapterUtilityOtherBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterUtilityOtherBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterUtilityOtherBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_utility_other, null, false, obj);
    }

    public static AdapterUtilityOtherBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterUtilityOtherBinding bind(View view, Object obj) {
        return (AdapterUtilityOtherBinding) bind(obj, view, R.layout.adapter_utility_other);
    }
}
