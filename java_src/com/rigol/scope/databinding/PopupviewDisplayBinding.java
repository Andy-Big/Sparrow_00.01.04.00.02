package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
import com.rigol.scope.data.DisplayParam;
import com.rigol.scope.data.HorizontalParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.views.SwitchButton;
/* loaded from: classes2.dex */
public abstract class PopupviewDisplayBinding extends ViewDataBinding {
    public final TextView cIntensityText;
    public final TextView cViewBgAlpha;
    public final SeekBar cViewBgAlphaSeekbar;
    public final RadioButton dotsRadioButton;
    public final TextView freeze;
    public final SwitchButton freezeSwitchButton;
    public final RadioButton fullRadioButton;
    public final TextView gridIntensity;
    public final SeekBar gridIntensitySeekbar;
    public final TextView gridIntensityText;
    public final TextView gridType;
    public final RadioGroup gridTypeRadioGroup;
    public final RadioButton halfRadioButton;
    @Bindable
    protected MappingObject mGridFullMapping;
    @Bindable
    protected MappingObject mGridHalfMapping;
    @Bindable
    protected MappingObject mGridNoneMapping;
    @Bindable
    protected HorizontalParam mHori;
    @Bindable
    protected DisplayParam mParam;
    @Bindable
    protected MappingObject mTypeDptsMapping;
    @Bindable
    protected MappingObject mTypeVectorMapping;
    public final RadioButton noneRadioButton;
    public final TextView palette;
    public final SwitchButton paletteSwitchButton;
    public final TextView persisTime;
    public final TextView persisTimeText;
    public final TextView popupViewBgAlpha;
    public final SeekBar popupViewBgAlphaSeekbar;
    public final TextView popupViewBgAlphaText;
    public final TextView ruler;
    public final SwitchButton rulerSwitchButton;
    public final TextView type;
    public final RadioGroup typeRadioGroup;
    public final RadioButton vectorRadioButton;
    public final TextView waveIntensity;
    public final SeekBar waveIntensitySeekbar;
    public final TextView waveIntensityText;

    public abstract void setGridFullMapping(MappingObject mappingObject);

    public abstract void setGridHalfMapping(MappingObject mappingObject);

    public abstract void setGridNoneMapping(MappingObject mappingObject);

    public abstract void setHori(HorizontalParam horizontalParam);

    public abstract void setParam(DisplayParam displayParam);

    public abstract void setTypeDptsMapping(MappingObject mappingObject);

    public abstract void setTypeVectorMapping(MappingObject mappingObject);

    /* JADX INFO: Access modifiers changed from: protected */
    public PopupviewDisplayBinding(Object obj, View view, int i, TextView textView, TextView textView2, SeekBar seekBar, RadioButton radioButton, TextView textView3, SwitchButton switchButton, RadioButton radioButton2, TextView textView4, SeekBar seekBar2, TextView textView5, TextView textView6, RadioGroup radioGroup, RadioButton radioButton3, RadioButton radioButton4, TextView textView7, SwitchButton switchButton2, TextView textView8, TextView textView9, TextView textView10, SeekBar seekBar3, TextView textView11, TextView textView12, SwitchButton switchButton3, TextView textView13, RadioGroup radioGroup2, RadioButton radioButton5, TextView textView14, SeekBar seekBar4, TextView textView15) {
        super(obj, view, i);
        this.cIntensityText = textView;
        this.cViewBgAlpha = textView2;
        this.cViewBgAlphaSeekbar = seekBar;
        this.dotsRadioButton = radioButton;
        this.freeze = textView3;
        this.freezeSwitchButton = switchButton;
        this.fullRadioButton = radioButton2;
        this.gridIntensity = textView4;
        this.gridIntensitySeekbar = seekBar2;
        this.gridIntensityText = textView5;
        this.gridType = textView6;
        this.gridTypeRadioGroup = radioGroup;
        this.halfRadioButton = radioButton3;
        this.noneRadioButton = radioButton4;
        this.palette = textView7;
        this.paletteSwitchButton = switchButton2;
        this.persisTime = textView8;
        this.persisTimeText = textView9;
        this.popupViewBgAlpha = textView10;
        this.popupViewBgAlphaSeekbar = seekBar3;
        this.popupViewBgAlphaText = textView11;
        this.ruler = textView12;
        this.rulerSwitchButton = switchButton3;
        this.type = textView13;
        this.typeRadioGroup = radioGroup2;
        this.vectorRadioButton = radioButton5;
        this.waveIntensity = textView14;
        this.waveIntensitySeekbar = seekBar4;
        this.waveIntensityText = textView15;
    }

    public DisplayParam getParam() {
        return this.mParam;
    }

    public MappingObject getTypeVectorMapping() {
        return this.mTypeVectorMapping;
    }

    public MappingObject getTypeDptsMapping() {
        return this.mTypeDptsMapping;
    }

    public MappingObject getGridFullMapping() {
        return this.mGridFullMapping;
    }

    public MappingObject getGridHalfMapping() {
        return this.mGridHalfMapping;
    }

    public MappingObject getGridNoneMapping() {
        return this.mGridNoneMapping;
    }

    public HorizontalParam getHori() {
        return this.mHori;
    }

    public static PopupviewDisplayBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewDisplayBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (PopupviewDisplayBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_display, viewGroup, z, obj);
    }

    public static PopupviewDisplayBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewDisplayBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (PopupviewDisplayBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_display, null, false, obj);
    }

    public static PopupviewDisplayBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewDisplayBinding bind(View view, Object obj) {
        return (PopupviewDisplayBinding) bind(obj, view, R.layout.popupview_display);
    }
}
