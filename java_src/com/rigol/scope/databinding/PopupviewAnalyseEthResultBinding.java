package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.rigol.scope.R;
import com.rigol.scope.views.busAnalyse.BusAnalyseParam;
/* loaded from: classes2.dex */
public abstract class PopupviewAnalyseEthResultBinding extends ViewDataBinding {
    public final Button busAnalyseEthResultSave;
    public final ConstraintLayout ethEyeLayout;
    public final ConstraintLayout ethEyeXLayout;
    public final TextView ethEyeXruler1;
    public final TextView ethEyeXruler10;
    public final TextView ethEyeXruler11;
    public final TextView ethEyeXruler12;
    public final TextView ethEyeXruler13;
    public final TextView ethEyeXruler14;
    public final TextView ethEyeXruler15;
    public final TextView ethEyeXruler16;
    public final TextView ethEyeXruler17;
    public final TextView ethEyeXruler2;
    public final TextView ethEyeXruler3;
    public final TextView ethEyeXruler4;
    public final TextView ethEyeXruler5;
    public final TextView ethEyeXruler6;
    public final TextView ethEyeXruler7;
    public final TextView ethEyeXruler8;
    public final TextView ethEyeXruler9;
    public final ConstraintLayout ethEyeYLayout;
    public final TextView ethEyeYruler1;
    public final TextView ethEyeYruler10;
    public final TextView ethEyeYruler11;
    public final TextView ethEyeYruler2;
    public final TextView ethEyeYruler3;
    public final TextView ethEyeYruler4;
    public final TextView ethEyeYruler5;
    public final TextView ethEyeYruler6;
    public final TextView ethEyeYruler7;
    public final TextView ethEyeYruler8;
    public final TextView ethEyeYruler9;
    public final ConstraintLayout ethJitterLayout;
    public final ConstraintLayout ethJitterXLayout;
    public final TextView ethJitterXruler1;
    public final TextView ethJitterXruler10;
    public final TextView ethJitterXruler11;
    public final TextView ethJitterXruler12;
    public final TextView ethJitterXruler13;
    public final TextView ethJitterXruler14;
    public final TextView ethJitterXruler15;
    public final TextView ethJitterXruler16;
    public final TextView ethJitterXruler17;
    public final TextView ethJitterXruler2;
    public final TextView ethJitterXruler3;
    public final TextView ethJitterXruler4;
    public final TextView ethJitterXruler5;
    public final TextView ethJitterXruler6;
    public final TextView ethJitterXruler7;
    public final TextView ethJitterXruler8;
    public final TextView ethJitterXruler9;
    public final ConstraintLayout ethJitterYLayout;
    public final TextView ethJitterYruler1;
    public final TextView ethJitterYruler10;
    public final TextView ethJitterYruler11;
    public final TextView ethJitterYruler2;
    public final TextView ethJitterYruler3;
    public final TextView ethJitterYruler4;
    public final TextView ethJitterYruler5;
    public final TextView ethJitterYruler6;
    public final TextView ethJitterYruler7;
    public final TextView ethJitterYruler8;
    public final TextView ethJitterYruler9;
    public final ImageView eye;
    public final TextView eyeText;
    public final RecyclerView header;
    public final ImageView jitter;
    public final TextView jitterText;
    @Bindable
    protected BusAnalyseParam mParam;
    public final RecyclerView result;
    public final TextView resultText;
    public final ScrollView scrollView;
    public final View titleLayout;

    public abstract void setParam(BusAnalyseParam busAnalyseParam);

    /* JADX INFO: Access modifiers changed from: protected */
    public PopupviewAnalyseEthResultBinding(Object obj, View view, int i, Button button, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, TextView textView15, TextView textView16, TextView textView17, ConstraintLayout constraintLayout3, TextView textView18, TextView textView19, TextView textView20, TextView textView21, TextView textView22, TextView textView23, TextView textView24, TextView textView25, TextView textView26, TextView textView27, TextView textView28, ConstraintLayout constraintLayout4, ConstraintLayout constraintLayout5, TextView textView29, TextView textView30, TextView textView31, TextView textView32, TextView textView33, TextView textView34, TextView textView35, TextView textView36, TextView textView37, TextView textView38, TextView textView39, TextView textView40, TextView textView41, TextView textView42, TextView textView43, TextView textView44, TextView textView45, ConstraintLayout constraintLayout6, TextView textView46, TextView textView47, TextView textView48, TextView textView49, TextView textView50, TextView textView51, TextView textView52, TextView textView53, TextView textView54, TextView textView55, TextView textView56, ImageView imageView, TextView textView57, RecyclerView recyclerView, ImageView imageView2, TextView textView58, RecyclerView recyclerView2, TextView textView59, ScrollView scrollView, View view2) {
        super(obj, view, i);
        this.busAnalyseEthResultSave = button;
        this.ethEyeLayout = constraintLayout;
        this.ethEyeXLayout = constraintLayout2;
        this.ethEyeXruler1 = textView;
        this.ethEyeXruler10 = textView2;
        this.ethEyeXruler11 = textView3;
        this.ethEyeXruler12 = textView4;
        this.ethEyeXruler13 = textView5;
        this.ethEyeXruler14 = textView6;
        this.ethEyeXruler15 = textView7;
        this.ethEyeXruler16 = textView8;
        this.ethEyeXruler17 = textView9;
        this.ethEyeXruler2 = textView10;
        this.ethEyeXruler3 = textView11;
        this.ethEyeXruler4 = textView12;
        this.ethEyeXruler5 = textView13;
        this.ethEyeXruler6 = textView14;
        this.ethEyeXruler7 = textView15;
        this.ethEyeXruler8 = textView16;
        this.ethEyeXruler9 = textView17;
        this.ethEyeYLayout = constraintLayout3;
        this.ethEyeYruler1 = textView18;
        this.ethEyeYruler10 = textView19;
        this.ethEyeYruler11 = textView20;
        this.ethEyeYruler2 = textView21;
        this.ethEyeYruler3 = textView22;
        this.ethEyeYruler4 = textView23;
        this.ethEyeYruler5 = textView24;
        this.ethEyeYruler6 = textView25;
        this.ethEyeYruler7 = textView26;
        this.ethEyeYruler8 = textView27;
        this.ethEyeYruler9 = textView28;
        this.ethJitterLayout = constraintLayout4;
        this.ethJitterXLayout = constraintLayout5;
        this.ethJitterXruler1 = textView29;
        this.ethJitterXruler10 = textView30;
        this.ethJitterXruler11 = textView31;
        this.ethJitterXruler12 = textView32;
        this.ethJitterXruler13 = textView33;
        this.ethJitterXruler14 = textView34;
        this.ethJitterXruler15 = textView35;
        this.ethJitterXruler16 = textView36;
        this.ethJitterXruler17 = textView37;
        this.ethJitterXruler2 = textView38;
        this.ethJitterXruler3 = textView39;
        this.ethJitterXruler4 = textView40;
        this.ethJitterXruler5 = textView41;
        this.ethJitterXruler6 = textView42;
        this.ethJitterXruler7 = textView43;
        this.ethJitterXruler8 = textView44;
        this.ethJitterXruler9 = textView45;
        this.ethJitterYLayout = constraintLayout6;
        this.ethJitterYruler1 = textView46;
        this.ethJitterYruler10 = textView47;
        this.ethJitterYruler11 = textView48;
        this.ethJitterYruler2 = textView49;
        this.ethJitterYruler3 = textView50;
        this.ethJitterYruler4 = textView51;
        this.ethJitterYruler5 = textView52;
        this.ethJitterYruler6 = textView53;
        this.ethJitterYruler7 = textView54;
        this.ethJitterYruler8 = textView55;
        this.ethJitterYruler9 = textView56;
        this.eye = imageView;
        this.eyeText = textView57;
        this.header = recyclerView;
        this.jitter = imageView2;
        this.jitterText = textView58;
        this.result = recyclerView2;
        this.resultText = textView59;
        this.scrollView = scrollView;
        this.titleLayout = view2;
    }

    public BusAnalyseParam getParam() {
        return this.mParam;
    }

    public static PopupviewAnalyseEthResultBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewAnalyseEthResultBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (PopupviewAnalyseEthResultBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_analyse_eth_result, viewGroup, z, obj);
    }

    public static PopupviewAnalyseEthResultBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewAnalyseEthResultBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (PopupviewAnalyseEthResultBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_analyse_eth_result, null, false, obj);
    }

    public static PopupviewAnalyseEthResultBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewAnalyseEthResultBinding bind(View view, Object obj) {
        return (PopupviewAnalyseEthResultBinding) bind(obj, view, R.layout.popupview_analyse_eth_result);
    }
}
