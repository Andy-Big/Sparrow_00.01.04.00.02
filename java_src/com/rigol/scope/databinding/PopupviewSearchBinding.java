package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.rigol.scope.R;
import com.rigol.scope.data.HorizontalParam;
import com.rigol.scope.data.SearchParam;
import com.rigol.scope.views.SwitchButton;
/* loaded from: classes2.dex */
public abstract class PopupviewSearchBinding extends ViewDataBinding {
    public final Button copyFromTriggerBtn;
    public final Button copyToTriggerBtn;
    public final View dividingLine1;
    public final View dividingLine2;
    public final TextView enable;
    public final SwitchButton enableSwitchButton;
    public final Guideline guidelineCenter;
    @Bindable
    protected HorizontalParam mHorizontal;
    @Bindable
    protected SearchParam mParam;
    public final TextView markTable;
    public final SwitchButton markTableSwitchButton;
    public final Button navigateBut;
    public final EditText navigation;
    public final ImageView playLastImage;
    public final ImageView playnextImage;
    public final Button saveBtn;
    public final RecyclerView searchView;
    public final TextView type;
    public final TextView typeSpinner;

    public abstract void setHorizontal(HorizontalParam horizontalParam);

    public abstract void setParam(SearchParam searchParam);

    /* JADX INFO: Access modifiers changed from: protected */
    public PopupviewSearchBinding(Object obj, View view, int i, Button button, Button button2, View view2, View view3, TextView textView, SwitchButton switchButton, Guideline guideline, TextView textView2, SwitchButton switchButton2, Button button3, EditText editText, ImageView imageView, ImageView imageView2, Button button4, RecyclerView recyclerView, TextView textView3, TextView textView4) {
        super(obj, view, i);
        this.copyFromTriggerBtn = button;
        this.copyToTriggerBtn = button2;
        this.dividingLine1 = view2;
        this.dividingLine2 = view3;
        this.enable = textView;
        this.enableSwitchButton = switchButton;
        this.guidelineCenter = guideline;
        this.markTable = textView2;
        this.markTableSwitchButton = switchButton2;
        this.navigateBut = button3;
        this.navigation = editText;
        this.playLastImage = imageView;
        this.playnextImage = imageView2;
        this.saveBtn = button4;
        this.searchView = recyclerView;
        this.type = textView3;
        this.typeSpinner = textView4;
    }

    public SearchParam getParam() {
        return this.mParam;
    }

    public HorizontalParam getHorizontal() {
        return this.mHorizontal;
    }

    public static PopupviewSearchBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewSearchBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (PopupviewSearchBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_search, viewGroup, z, obj);
    }

    public static PopupviewSearchBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewSearchBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (PopupviewSearchBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_search, null, false, obj);
    }

    public static PopupviewSearchBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewSearchBinding bind(View view, Object obj) {
        return (PopupviewSearchBinding) bind(obj, view, R.layout.popupview_search);
    }
}
