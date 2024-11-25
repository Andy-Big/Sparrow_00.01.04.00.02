package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
import com.rigol.scope.data.RefParam;
import com.rigol.scope.views.SwitchButton;
import com.rigol.scope.views.baseview.BaseEditText;
/* loaded from: classes2.dex */
public abstract class PopupviewRefBinding extends ViewDataBinding {
    public final TextView clean;
    public final Button cleanBtn;
    public final Button importBtn;
    public final TextView label;
    public final BaseEditText labelEditText;
    public final SwitchButton labelSwitch;
    @Bindable
    protected RefParam mParam;
    public final ImageButton mainScaleNomal;
    public final ImageButton mainScaleVertical;
    public final View mathDividingLine;
    public final Guideline mathGuidelineCenter;
    public final ImageButton mathOffsetDown;
    public final ImageButton mathOffsetUp;
    public final TextView offset;
    public final EditText offsetEditText;
    public final TextView refChannel;
    public final TextView refChannelSpinner;
    public final TextView refColor;
    public final TextView refColorSpinner;
    public final TextView refExport;
    public final Button refExportBtn;
    public final TextView refImport;
    public final TextView refReset;
    public final Button refResetBtn;
    public final TextView save;
    public final Button saveBtn;
    public final TextView scale;
    public final EditText scaleEditText;
    public final TextView source;
    public final TextView sourceSpinner;

    public abstract void setParam(RefParam refParam);

    /* JADX INFO: Access modifiers changed from: protected */
    public PopupviewRefBinding(Object obj, View view, int i, TextView textView, Button button, Button button2, TextView textView2, BaseEditText baseEditText, SwitchButton switchButton, ImageButton imageButton, ImageButton imageButton2, View view2, Guideline guideline, ImageButton imageButton3, ImageButton imageButton4, TextView textView3, EditText editText, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, Button button3, TextView textView9, TextView textView10, Button button4, TextView textView11, Button button5, TextView textView12, EditText editText2, TextView textView13, TextView textView14) {
        super(obj, view, i);
        this.clean = textView;
        this.cleanBtn = button;
        this.importBtn = button2;
        this.label = textView2;
        this.labelEditText = baseEditText;
        this.labelSwitch = switchButton;
        this.mainScaleNomal = imageButton;
        this.mainScaleVertical = imageButton2;
        this.mathDividingLine = view2;
        this.mathGuidelineCenter = guideline;
        this.mathOffsetDown = imageButton3;
        this.mathOffsetUp = imageButton4;
        this.offset = textView3;
        this.offsetEditText = editText;
        this.refChannel = textView4;
        this.refChannelSpinner = textView5;
        this.refColor = textView6;
        this.refColorSpinner = textView7;
        this.refExport = textView8;
        this.refExportBtn = button3;
        this.refImport = textView9;
        this.refReset = textView10;
        this.refResetBtn = button4;
        this.save = textView11;
        this.saveBtn = button5;
        this.scale = textView12;
        this.scaleEditText = editText2;
        this.source = textView13;
        this.sourceSpinner = textView14;
    }

    public RefParam getParam() {
        return this.mParam;
    }

    public static PopupviewRefBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewRefBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (PopupviewRefBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_ref, viewGroup, z, obj);
    }

    public static PopupviewRefBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewRefBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (PopupviewRefBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_ref, null, false, obj);
    }

    public static PopupviewRefBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewRefBinding bind(View view, Object obj) {
        return (PopupviewRefBinding) bind(obj, view, R.layout.popupview_ref);
    }
}
