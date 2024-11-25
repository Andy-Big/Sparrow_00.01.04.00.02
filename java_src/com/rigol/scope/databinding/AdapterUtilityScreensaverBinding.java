package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
import com.rigol.scope.data.UtilityParam;
/* loaded from: classes2.dex */
public abstract class AdapterUtilityScreensaverBinding extends ViewDataBinding {
    public final View divider3;
    @Bindable
    protected UtilityParam mParam;
    public final ConstraintLayout picture;
    public final ConstraintLayout picturePathLayout;
    public final RadioButton radioButtonClose;
    public final RadioButton radioButtonPicture;
    public final RadioButton radioButtonText;
    public final RadioGroup radiogroupScreenType;
    public final ConstraintLayout textLayout;
    public final TextView textView91;
    public final TextView tvDefault;
    public final TextView tvPicture;
    public final TextView tvPictureValue;
    public final TextView tvPreview;
    public final TextView tvScreenSaver;
    public final TextView tvText;
    public final TextView tvTextValue;
    public final TextView tvWatitimeValue;
    public final View view10;
    public final ConstraintLayout watitimeLayout;

    public abstract void setParam(UtilityParam utilityParam);

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterUtilityScreensaverBinding(Object obj, View view, int i, View view2, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, RadioGroup radioGroup, ConstraintLayout constraintLayout3, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, View view3, ConstraintLayout constraintLayout4) {
        super(obj, view, i);
        this.divider3 = view2;
        this.picture = constraintLayout;
        this.picturePathLayout = constraintLayout2;
        this.radioButtonClose = radioButton;
        this.radioButtonPicture = radioButton2;
        this.radioButtonText = radioButton3;
        this.radiogroupScreenType = radioGroup;
        this.textLayout = constraintLayout3;
        this.textView91 = textView;
        this.tvDefault = textView2;
        this.tvPicture = textView3;
        this.tvPictureValue = textView4;
        this.tvPreview = textView5;
        this.tvScreenSaver = textView6;
        this.tvText = textView7;
        this.tvTextValue = textView8;
        this.tvWatitimeValue = textView9;
        this.view10 = view3;
        this.watitimeLayout = constraintLayout4;
    }

    public UtilityParam getParam() {
        return this.mParam;
    }

    public static AdapterUtilityScreensaverBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterUtilityScreensaverBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterUtilityScreensaverBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_utility_screensaver, viewGroup, z, obj);
    }

    public static AdapterUtilityScreensaverBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterUtilityScreensaverBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterUtilityScreensaverBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_utility_screensaver, null, false, obj);
    }

    public static AdapterUtilityScreensaverBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterUtilityScreensaverBinding bind(View view, Object obj) {
        return (AdapterUtilityScreensaverBinding) bind(obj, view, R.layout.adapter_utility_screensaver);
    }
}
