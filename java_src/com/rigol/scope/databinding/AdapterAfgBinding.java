package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
import com.rigol.scope.data.AfgParam;
import com.rigol.scope.data.StorageLoadParam;
import com.rigol.scope.views.SwitchButton;
import com.rigol.scope.views.baseview.BaseEditText;
/* loaded from: classes2.dex */
public abstract class AdapterAfgBinding extends ViewDataBinding {
    public final BaseEditText basicAmpEdit;
    public final TextView basicAmpText;
    public final TextView basicBasicPathText;
    public final TextView basicBasicWidthText;
    public final BaseEditText basicDeviationEdit;
    public final TextView basicDeviationText;
    public final BaseEditText basicDutycycleEdit;
    public final TextView basicDutycycleText;
    public final BaseEditText basicPathEdit;
    public final BaseEditText basicPhaseEdit;
    public final TextView basicPhaseText;
    public final BaseEditText basicSymmetryEdit;
    public final TextView basicSymmetryText;
    public final BaseEditText basicWidthEdit;
    public final TextView declineText;
    public final TextView fraguencyText;
    public final ImageView iconAfg;
    public final BaseEditText labelDeclineText;
    public final BaseEditText labelEditText;
    public final BaseEditText labelRiseedgeText;
    public final SwitchButton labelSwitch;
    public final Guideline leftGuideline;
    public final Guideline leftGuideline1;
    public final Guideline leftGuideline2;
    public final Button loadBtn;
    @Bindable
    protected AfgParam mParam;
    @Bindable
    protected StorageLoadParam mStorageLoadParam;
    public final TextView riseText;
    public final TextView sourceTypeSpinner;
    public final TextView sourceTypeText;
    public final TextView sweepOutText;

    public abstract void setParam(AfgParam afgParam);

    public abstract void setStorageLoadParam(StorageLoadParam storageLoadParam);

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterAfgBinding(Object obj, View view, int i, BaseEditText baseEditText, TextView textView, TextView textView2, TextView textView3, BaseEditText baseEditText2, TextView textView4, BaseEditText baseEditText3, TextView textView5, BaseEditText baseEditText4, BaseEditText baseEditText5, TextView textView6, BaseEditText baseEditText6, TextView textView7, BaseEditText baseEditText7, TextView textView8, TextView textView9, ImageView imageView, BaseEditText baseEditText8, BaseEditText baseEditText9, BaseEditText baseEditText10, SwitchButton switchButton, Guideline guideline, Guideline guideline2, Guideline guideline3, Button button, TextView textView10, TextView textView11, TextView textView12, TextView textView13) {
        super(obj, view, i);
        this.basicAmpEdit = baseEditText;
        this.basicAmpText = textView;
        this.basicBasicPathText = textView2;
        this.basicBasicWidthText = textView3;
        this.basicDeviationEdit = baseEditText2;
        this.basicDeviationText = textView4;
        this.basicDutycycleEdit = baseEditText3;
        this.basicDutycycleText = textView5;
        this.basicPathEdit = baseEditText4;
        this.basicPhaseEdit = baseEditText5;
        this.basicPhaseText = textView6;
        this.basicSymmetryEdit = baseEditText6;
        this.basicSymmetryText = textView7;
        this.basicWidthEdit = baseEditText7;
        this.declineText = textView8;
        this.fraguencyText = textView9;
        this.iconAfg = imageView;
        this.labelDeclineText = baseEditText8;
        this.labelEditText = baseEditText9;
        this.labelRiseedgeText = baseEditText10;
        this.labelSwitch = switchButton;
        this.leftGuideline = guideline;
        this.leftGuideline1 = guideline2;
        this.leftGuideline2 = guideline3;
        this.loadBtn = button;
        this.riseText = textView10;
        this.sourceTypeSpinner = textView11;
        this.sourceTypeText = textView12;
        this.sweepOutText = textView13;
    }

    public AfgParam getParam() {
        return this.mParam;
    }

    public StorageLoadParam getStorageLoadParam() {
        return this.mStorageLoadParam;
    }

    public static AdapterAfgBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterAfgBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterAfgBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_afg, viewGroup, z, obj);
    }

    public static AdapterAfgBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterAfgBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterAfgBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_afg, null, false, obj);
    }

    public static AdapterAfgBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterAfgBinding bind(View view, Object obj) {
        return (AdapterAfgBinding) bind(obj, view, R.layout.adapter_afg);
    }
}
