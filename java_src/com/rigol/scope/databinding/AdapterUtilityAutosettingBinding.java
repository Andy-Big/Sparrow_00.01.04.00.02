package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
import com.rigol.scope.views.SwitchButton;
import com.rigol.scope.views.auto.AutosetParam;
/* loaded from: classes2.dex */
public abstract class AdapterUtilityAutosettingBinding extends ViewDataBinding {
    public final ConstraintLayout autoRangeLayout;
    public final ConstraintLayout channelLayout;
    public final Button configuration;
    public final EditText edtConfirmPassword;
    public final EditText edtNewPassword;
    public final EditText edtOldPassword;
    public final ImageView imageViewLock;
    public final ConstraintLayout keepcoupLayout;
    public final ConstraintLayout lockLayout;
    @Bindable
    protected AutosetParam mParam;
    public final ConstraintLayout overlayLayout;
    public final SwitchButton switchAutorange;
    public final SwitchButton switchChannel;
    public final SwitchButton switchKeepcoup;
    public final SwitchButton switchOverlay;
    public final TextView textView55;
    public final TextView textView60;
    public final TextView textView61;
    public final TextView textView63;
    public final TextView textView64;
    public final TextView textView68;
    public final TextView textView69;
    public final TextView textView70;
    public final TextView textView71;
    public final View view7;
    public final View view8;

    public abstract void setParam(AutosetParam autosetParam);

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterUtilityAutosettingBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, Button button, EditText editText, EditText editText2, EditText editText3, ImageView imageView, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, ConstraintLayout constraintLayout5, SwitchButton switchButton, SwitchButton switchButton2, SwitchButton switchButton3, SwitchButton switchButton4, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, View view2, View view3) {
        super(obj, view, i);
        this.autoRangeLayout = constraintLayout;
        this.channelLayout = constraintLayout2;
        this.configuration = button;
        this.edtConfirmPassword = editText;
        this.edtNewPassword = editText2;
        this.edtOldPassword = editText3;
        this.imageViewLock = imageView;
        this.keepcoupLayout = constraintLayout3;
        this.lockLayout = constraintLayout4;
        this.overlayLayout = constraintLayout5;
        this.switchAutorange = switchButton;
        this.switchChannel = switchButton2;
        this.switchKeepcoup = switchButton3;
        this.switchOverlay = switchButton4;
        this.textView55 = textView;
        this.textView60 = textView2;
        this.textView61 = textView3;
        this.textView63 = textView4;
        this.textView64 = textView5;
        this.textView68 = textView6;
        this.textView69 = textView7;
        this.textView70 = textView8;
        this.textView71 = textView9;
        this.view7 = view2;
        this.view8 = view3;
    }

    public AutosetParam getParam() {
        return this.mParam;
    }

    public static AdapterUtilityAutosettingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterUtilityAutosettingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterUtilityAutosettingBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_utility_autosetting, viewGroup, z, obj);
    }

    public static AdapterUtilityAutosettingBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterUtilityAutosettingBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterUtilityAutosettingBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_utility_autosetting, null, false, obj);
    }

    public static AdapterUtilityAutosettingBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterUtilityAutosettingBinding bind(View view, Object obj) {
        return (AdapterUtilityAutosettingBinding) bind(obj, view, R.layout.adapter_utility_autosetting);
    }
}
