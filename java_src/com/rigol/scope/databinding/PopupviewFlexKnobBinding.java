package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.rigol.scope.R;
import com.rigol.scope.data.FlexKnobParam;
/* loaded from: classes2.dex */
public abstract class PopupviewFlexKnobBinding extends ViewDataBinding {
    public final RadioButton autoRadioButton;
    public final RadioGroup directionRadioGroup;
    public final TextView directionType;
    public final Guideline guidelineCenter;
    public final Guideline guidelineLeft;
    public final Guideline guidelineRight;
    @Bindable
    protected CompoundButton.OnCheckedChangeListener mCheckedChangeListener;
    @Bindable
    protected FlexKnobParam mParam;
    @Bindable
    protected FlexKnobParam mPopupviewFlexKnobBinding;
    public final RadioButton offRadioButton;
    public final ImageView pic;
    public final RecyclerView recyclerView;
    public final View titleLayout;
    public final TextView tvAHint;
    public final TextView tvAHintContent;
    public final TextView tvBHint;
    public final TextView tvBHintContent;
    public final TextView tvHint;
    public final TextView tvHintContent;
    public final View viewTop;

    public abstract void setCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener);

    public abstract void setParam(FlexKnobParam flexKnobParam);

    public abstract void setPopupviewFlexKnobBinding(FlexKnobParam flexKnobParam);

    /* JADX INFO: Access modifiers changed from: protected */
    public PopupviewFlexKnobBinding(Object obj, View view, int i, RadioButton radioButton, RadioGroup radioGroup, TextView textView, Guideline guideline, Guideline guideline2, Guideline guideline3, RadioButton radioButton2, ImageView imageView, RecyclerView recyclerView, View view2, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, View view3) {
        super(obj, view, i);
        this.autoRadioButton = radioButton;
        this.directionRadioGroup = radioGroup;
        this.directionType = textView;
        this.guidelineCenter = guideline;
        this.guidelineLeft = guideline2;
        this.guidelineRight = guideline3;
        this.offRadioButton = radioButton2;
        this.pic = imageView;
        this.recyclerView = recyclerView;
        this.titleLayout = view2;
        this.tvAHint = textView2;
        this.tvAHintContent = textView3;
        this.tvBHint = textView4;
        this.tvBHintContent = textView5;
        this.tvHint = textView6;
        this.tvHintContent = textView7;
        this.viewTop = view3;
    }

    public FlexKnobParam getParam() {
        return this.mParam;
    }

    public FlexKnobParam getPopupviewFlexKnobBinding() {
        return this.mPopupviewFlexKnobBinding;
    }

    public CompoundButton.OnCheckedChangeListener getCheckedChangeListener() {
        return this.mCheckedChangeListener;
    }

    public static PopupviewFlexKnobBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewFlexKnobBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (PopupviewFlexKnobBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_flex_knob, viewGroup, z, obj);
    }

    public static PopupviewFlexKnobBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewFlexKnobBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (PopupviewFlexKnobBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_flex_knob, null, false, obj);
    }

    public static PopupviewFlexKnobBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewFlexKnobBinding bind(View view, Object obj) {
        return (PopupviewFlexKnobBinding) bind(obj, view, R.layout.popupview_flex_knob);
    }
}
