package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.SearchParam;
/* loaded from: classes2.dex */
public abstract class AdapterSearchTriggerPulseBinding extends ViewDataBinding {
    public final ImageView imageView2;
    public final RadioButton lessMore;
    public final RadioButton lessThan;
    public final TextView lowerLimit;
    public final EditText lowerLimitEditText;
    @Bindable
    protected SearchParam mParam;
    @Bindable
    protected MappingObject mPolarityNegativeMapping;
    @Bindable
    protected MappingObject mPolarityPositiveMapping;
    @Bindable
    protected MappingObject mSweepAutoMapping;
    @Bindable
    protected MappingObject mSweepNormalMapping;
    @Bindable
    protected MappingObject mSweepSingleMapping;
    public final TextView maxLimit;
    public final RadioButton moreThan;
    public final RadioButton polarityN;
    public final RadioButton polarityP;
    public final EditText threEditText;
    public final View triggerNoise;
    public final TextView triggerPolarityLabel;
    public final TextView triggerPulseLabel;
    public final ConstraintLayout triggerSlopeLayout;
    public final TextView triggerSource;
    public final TextView triggerSourceLabel;
    public final TextView upperLimit;
    public final EditText upperLimitEditText;
    public final View view;
    public final View view2;

    public abstract void setParam(SearchParam searchParam);

    public abstract void setPolarityNegativeMapping(MappingObject mappingObject);

    public abstract void setPolarityPositiveMapping(MappingObject mappingObject);

    public abstract void setSweepAutoMapping(MappingObject mappingObject);

    public abstract void setSweepNormalMapping(MappingObject mappingObject);

    public abstract void setSweepSingleMapping(MappingObject mappingObject);

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterSearchTriggerPulseBinding(Object obj, View view, int i, ImageView imageView, RadioButton radioButton, RadioButton radioButton2, TextView textView, EditText editText, TextView textView2, RadioButton radioButton3, RadioButton radioButton4, RadioButton radioButton5, EditText editText2, View view2, TextView textView3, TextView textView4, ConstraintLayout constraintLayout, TextView textView5, TextView textView6, TextView textView7, EditText editText3, View view3, View view4) {
        super(obj, view, i);
        this.imageView2 = imageView;
        this.lessMore = radioButton;
        this.lessThan = radioButton2;
        this.lowerLimit = textView;
        this.lowerLimitEditText = editText;
        this.maxLimit = textView2;
        this.moreThan = radioButton3;
        this.polarityN = radioButton4;
        this.polarityP = radioButton5;
        this.threEditText = editText2;
        this.triggerNoise = view2;
        this.triggerPolarityLabel = textView3;
        this.triggerPulseLabel = textView4;
        this.triggerSlopeLayout = constraintLayout;
        this.triggerSource = textView5;
        this.triggerSourceLabel = textView6;
        this.upperLimit = textView7;
        this.upperLimitEditText = editText3;
        this.view = view3;
        this.view2 = view4;
    }

    public SearchParam getParam() {
        return this.mParam;
    }

    public MappingObject getSweepAutoMapping() {
        return this.mSweepAutoMapping;
    }

    public MappingObject getSweepNormalMapping() {
        return this.mSweepNormalMapping;
    }

    public MappingObject getSweepSingleMapping() {
        return this.mSweepSingleMapping;
    }

    public MappingObject getPolarityPositiveMapping() {
        return this.mPolarityPositiveMapping;
    }

    public MappingObject getPolarityNegativeMapping() {
        return this.mPolarityNegativeMapping;
    }

    public static AdapterSearchTriggerPulseBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterSearchTriggerPulseBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterSearchTriggerPulseBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_search_trigger_pulse, viewGroup, z, obj);
    }

    public static AdapterSearchTriggerPulseBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterSearchTriggerPulseBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterSearchTriggerPulseBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_search_trigger_pulse, null, false, obj);
    }

    public static AdapterSearchTriggerPulseBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterSearchTriggerPulseBinding bind(View view, Object obj) {
        return (AdapterSearchTriggerPulseBinding) bind(obj, view, R.layout.adapter_search_trigger_pulse);
    }
}
