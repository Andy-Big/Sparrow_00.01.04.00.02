package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.SearchParam;
/* loaded from: classes2.dex */
public abstract class AdapterSearchEdgeBinding extends ViewDataBinding {
    public final RadioButton edgeEitherRadioButton;
    public final RadioButton edgeFallingRadioButton;
    public final RadioButton edgeRisingRadioButton;
    public final ImageView edgeSlopeImage;
    public final TextView edgeSlopetype;
    public final RadioGroup edgeSlopetypeRadioGroup;
    public final TextView edgeSource;
    public final TextView edgeSourceSpinner;
    @Bindable
    protected MappingObject mEdgeEitherMapping;
    @Bindable
    protected MappingObject mEdgeFallingMapping;
    @Bindable
    protected MappingObject mEdgeRisingMapping;
    @Bindable
    protected SearchParam mParam;
    public final TextView thre;
    public final EditText threEditText;

    public abstract void setEdgeEitherMapping(MappingObject mappingObject);

    public abstract void setEdgeFallingMapping(MappingObject mappingObject);

    public abstract void setEdgeRisingMapping(MappingObject mappingObject);

    public abstract void setParam(SearchParam searchParam);

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterSearchEdgeBinding(Object obj, View view, int i, RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, ImageView imageView, TextView textView, RadioGroup radioGroup, TextView textView2, TextView textView3, TextView textView4, EditText editText) {
        super(obj, view, i);
        this.edgeEitherRadioButton = radioButton;
        this.edgeFallingRadioButton = radioButton2;
        this.edgeRisingRadioButton = radioButton3;
        this.edgeSlopeImage = imageView;
        this.edgeSlopetype = textView;
        this.edgeSlopetypeRadioGroup = radioGroup;
        this.edgeSource = textView2;
        this.edgeSourceSpinner = textView3;
        this.thre = textView4;
        this.threEditText = editText;
    }

    public SearchParam getParam() {
        return this.mParam;
    }

    public MappingObject getEdgeRisingMapping() {
        return this.mEdgeRisingMapping;
    }

    public MappingObject getEdgeFallingMapping() {
        return this.mEdgeFallingMapping;
    }

    public MappingObject getEdgeEitherMapping() {
        return this.mEdgeEitherMapping;
    }

    public static AdapterSearchEdgeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterSearchEdgeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterSearchEdgeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_search_edge, viewGroup, z, obj);
    }

    public static AdapterSearchEdgeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterSearchEdgeBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterSearchEdgeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_search_edge, null, false, obj);
    }

    public static AdapterSearchEdgeBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterSearchEdgeBinding bind(View view, Object obj) {
        return (AdapterSearchEdgeBinding) bind(obj, view, R.layout.adapter_search_edge);
    }
}
