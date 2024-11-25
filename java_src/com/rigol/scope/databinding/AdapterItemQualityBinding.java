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
/* loaded from: classes2.dex */
public abstract class AdapterItemQualityBinding extends ViewDataBinding {
    public final View dividingLine1;
    public final View dividingLine2;
    public final View dividingLine3;
    public final Guideline leftGuideline;
    public final Guideline leftGuideline2;
    public final Guideline leftGuideline3;
    public final Guideline leftGuideline4;
    public final TextView lowEditText;
    @Bindable
    protected UpaParam mParam;
    @Bindable
    protected MappingObject mUpaMappingObj;
    public final Guideline rightGuideline;
    public final TextView upa;
    public final TextView upaConsult;
    public final TextView upaCurrent;
    public final TextView upaCurrentSpinner;
    public final TextView upaCurrentSpinner2;
    public final TextView upaCurrentText;
    public final EditText upaDownEdit;
    public final EditText upaEditText;
    public final Button upaFoundDefault;
    public final Button upaLinkDrawing;
    public final TextView upaMaxMun;
    public final TextView upaMiddleMun;
    public final EditText upaMiddleText;
    public final TextView upaOption;
    public final TextView upaPassageway;
    public final Button upaReccovery;
    public final TextView upaRecordMun;
    public final EditText upaRecordText;
    public final TextView upaSetTypeSpinner;
    public final TextView upaSettype;

    public abstract void setParam(UpaParam upaParam);

    public abstract void setUpaMappingObj(MappingObject mappingObject);

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterItemQualityBinding(Object obj, View view, int i, View view2, View view3, View view4, Guideline guideline, Guideline guideline2, Guideline guideline3, Guideline guideline4, TextView textView, Guideline guideline5, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, EditText editText, EditText editText2, Button button, Button button2, TextView textView8, TextView textView9, EditText editText3, TextView textView10, TextView textView11, Button button3, TextView textView12, EditText editText4, TextView textView13, TextView textView14) {
        super(obj, view, i);
        this.dividingLine1 = view2;
        this.dividingLine2 = view3;
        this.dividingLine3 = view4;
        this.leftGuideline = guideline;
        this.leftGuideline2 = guideline2;
        this.leftGuideline3 = guideline3;
        this.leftGuideline4 = guideline4;
        this.lowEditText = textView;
        this.rightGuideline = guideline5;
        this.upa = textView2;
        this.upaConsult = textView3;
        this.upaCurrent = textView4;
        this.upaCurrentSpinner = textView5;
        this.upaCurrentSpinner2 = textView6;
        this.upaCurrentText = textView7;
        this.upaDownEdit = editText;
        this.upaEditText = editText2;
        this.upaFoundDefault = button;
        this.upaLinkDrawing = button2;
        this.upaMaxMun = textView8;
        this.upaMiddleMun = textView9;
        this.upaMiddleText = editText3;
        this.upaOption = textView10;
        this.upaPassageway = textView11;
        this.upaReccovery = button3;
        this.upaRecordMun = textView12;
        this.upaRecordText = editText4;
        this.upaSetTypeSpinner = textView13;
        this.upaSettype = textView14;
    }

    public MappingObject getUpaMappingObj() {
        return this.mUpaMappingObj;
    }

    public UpaParam getParam() {
        return this.mParam;
    }

    public static AdapterItemQualityBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterItemQualityBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterItemQualityBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_item_quality, viewGroup, z, obj);
    }

    public static AdapterItemQualityBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterItemQualityBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterItemQualityBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_item_quality, null, false, obj);
    }

    public static AdapterItemQualityBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterItemQualityBinding bind(View view, Object obj) {
        return (AdapterItemQualityBinding) bind(obj, view, R.layout.adapter_item_quality);
    }
}
