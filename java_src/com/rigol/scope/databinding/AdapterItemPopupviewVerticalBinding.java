package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
import com.rigol.scope.data.HorizontalParam;
import com.rigol.scope.data.VerticalParam;
import com.rigol.scope.views.SwitchButton;
import com.rigol.scope.views.baseview.BaseEditText;
/* loaded from: classes2.dex */
public abstract class AdapterItemPopupviewVerticalBinding extends ViewDataBinding {
    public final Button acButton;
    public final Button acquireBtn;
    public final TextView bandwidthLimitSpinner;
    public final TextView couplingSpinner;
    public final EditText delayEditText;
    public final ImageView diagram;
    public final TextView display;
    public final SwitchButton displaySwitch;
    public final SwitchButton fineSwitch;
    public final Button gudButton;
    public final TextView impedance;
    public final SwitchButton impedanceSwitch;
    public final SwitchButton invertSwitch;
    public final ImageView ivImpedance1;
    public final ImageView ivImpedance50;
    public final ImageView ivLineImpedance1;
    public final ImageView ivLineImpedance50;
    public final BaseEditText labelEditText;
    public final SwitchButton labelSwitch;
    @Bindable
    protected HorizontalParam mHorizontalParam;
    @Bindable
    protected View.OnClickListener mOnClickListener;
    @Bindable
    protected VerticalParam mParam;
    public final Button measureBtn;
    public final EditText offsetEditText;
    public final ImageButton offsetLeft;
    public final ImageButton offsetRight;
    public final EditText positionEditText;
    public final ImageButton positionLeft;
    public final ImageButton positionRight;
    public final Button probeSettingBtn;
    public final EditText scaleEditText;
    public final ImageButton scaleLeft;
    public final ImageButton scaleRight;
    public final Button triggerBtn;
    public final TextView unitSpinner;

    public abstract void setHorizontalParam(HorizontalParam horizontalParam);

    public abstract void setOnClickListener(View.OnClickListener onClickListener);

    public abstract void setParam(VerticalParam verticalParam);

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterItemPopupviewVerticalBinding(Object obj, View view, int i, Button button, Button button2, TextView textView, TextView textView2, EditText editText, ImageView imageView, TextView textView3, SwitchButton switchButton, SwitchButton switchButton2, Button button3, TextView textView4, SwitchButton switchButton3, SwitchButton switchButton4, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, BaseEditText baseEditText, SwitchButton switchButton5, Button button4, EditText editText2, ImageButton imageButton, ImageButton imageButton2, EditText editText3, ImageButton imageButton3, ImageButton imageButton4, Button button5, EditText editText4, ImageButton imageButton5, ImageButton imageButton6, Button button6, TextView textView5) {
        super(obj, view, i);
        this.acButton = button;
        this.acquireBtn = button2;
        this.bandwidthLimitSpinner = textView;
        this.couplingSpinner = textView2;
        this.delayEditText = editText;
        this.diagram = imageView;
        this.display = textView3;
        this.displaySwitch = switchButton;
        this.fineSwitch = switchButton2;
        this.gudButton = button3;
        this.impedance = textView4;
        this.impedanceSwitch = switchButton3;
        this.invertSwitch = switchButton4;
        this.ivImpedance1 = imageView2;
        this.ivImpedance50 = imageView3;
        this.ivLineImpedance1 = imageView4;
        this.ivLineImpedance50 = imageView5;
        this.labelEditText = baseEditText;
        this.labelSwitch = switchButton5;
        this.measureBtn = button4;
        this.offsetEditText = editText2;
        this.offsetLeft = imageButton;
        this.offsetRight = imageButton2;
        this.positionEditText = editText3;
        this.positionLeft = imageButton3;
        this.positionRight = imageButton4;
        this.probeSettingBtn = button5;
        this.scaleEditText = editText4;
        this.scaleLeft = imageButton5;
        this.scaleRight = imageButton6;
        this.triggerBtn = button6;
        this.unitSpinner = textView5;
    }

    public View.OnClickListener getOnClickListener() {
        return this.mOnClickListener;
    }

    public VerticalParam getParam() {
        return this.mParam;
    }

    public HorizontalParam getHorizontalParam() {
        return this.mHorizontalParam;
    }

    public static AdapterItemPopupviewVerticalBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterItemPopupviewVerticalBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterItemPopupviewVerticalBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_item_popupview_vertical, viewGroup, z, obj);
    }

    public static AdapterItemPopupviewVerticalBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterItemPopupviewVerticalBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterItemPopupviewVerticalBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_item_popupview_vertical, null, false, obj);
    }

    public static AdapterItemPopupviewVerticalBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterItemPopupviewVerticalBinding bind(View view, Object obj) {
        return (AdapterItemPopupviewVerticalBinding) bind(obj, view, R.layout.adapter_item_popupview_vertical);
    }
}
