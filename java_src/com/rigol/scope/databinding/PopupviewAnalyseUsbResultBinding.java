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
import com.rigol.scope.views.busAnalyse.BusAnalyseUsbParam;
/* loaded from: classes2.dex */
public abstract class PopupviewAnalyseUsbResultBinding extends ViewDataBinding {
    public final Button busAnalyseUsbResultSave;
    public final ImageView eye;
    public final ConstraintLayout eye11Xlayout;
    public final ConstraintLayout eye11Ylayout;
    public final ConstraintLayout eye1Xlayout;
    public final ConstraintLayout eye1Ylayout;
    public final ConstraintLayout eye2Xlayout;
    public final ConstraintLayout eye2Ylayout;
    public final ConstraintLayout eyeLayout;
    public final TextView eyeText;
    public final TextView eyexruler11;
    public final RecyclerView header;
    @Bindable
    protected BusAnalyseUsbParam mParam;
    public final ConstraintLayout plotLayout;
    public final ConstraintLayout plotXLayout;
    public final ConstraintLayout plotYLayout;
    public final ImageView polt;
    public final TextView poltText;
    public final RecyclerView result;
    public final TextView resultText;
    public final ScrollView scrollView;
    public final View titleLayout;
    public final TextView xruler1;
    public final TextView xruler10;
    public final TextView xruler11;
    public final TextView xruler111;
    public final TextView xruler12;
    public final TextView xruler2;
    public final TextView xruler21;
    public final TextView xruler211;
    public final TextView xruler22;
    public final TextView xruler3;
    public final TextView xruler31;
    public final TextView xruler311;
    public final TextView xruler32;
    public final TextView xruler4;
    public final TextView xruler41;
    public final TextView xruler411;
    public final TextView xruler42;
    public final TextView xruler5;
    public final TextView xruler51;
    public final TextView xruler511;
    public final TextView xruler52;
    public final TextView xruler6;
    public final TextView xruler61;
    public final TextView xruler611;
    public final TextView xruler7;
    public final TextView xruler71;
    public final TextView xruler711;
    public final TextView xruler8;
    public final TextView xruler811;
    public final TextView xruler9;
    public final TextView xruler911;
    public final TextView yruler1;
    public final TextView yruler102;
    public final TextView yruler11;
    public final TextView yruler111;
    public final TextView yruler112;
    public final TextView yruler12;
    public final TextView yruler2;
    public final TextView yruler21;
    public final TextView yruler211;
    public final TextView yruler22;
    public final TextView yruler3;
    public final TextView yruler31;
    public final TextView yruler311;
    public final TextView yruler32;
    public final TextView yruler4;
    public final TextView yruler41;
    public final TextView yruler411;
    public final TextView yruler42;
    public final TextView yruler5;
    public final TextView yruler51;
    public final TextView yruler511;
    public final TextView yruler52;
    public final TextView yruler6;
    public final TextView yruler61;
    public final TextView yruler611;
    public final TextView yruler62;
    public final TextView yruler7;
    public final TextView yruler71;
    public final TextView yruler72;
    public final TextView yruler8;
    public final TextView yruler81;
    public final TextView yruler82;
    public final TextView yruler9;
    public final TextView yruler91;
    public final TextView yruler92;

    public abstract void setParam(BusAnalyseUsbParam busAnalyseUsbParam);

    /* JADX INFO: Access modifiers changed from: protected */
    public PopupviewAnalyseUsbResultBinding(Object obj, View view, int i, Button button, ImageView imageView, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, ConstraintLayout constraintLayout5, ConstraintLayout constraintLayout6, ConstraintLayout constraintLayout7, TextView textView, TextView textView2, RecyclerView recyclerView, ConstraintLayout constraintLayout8, ConstraintLayout constraintLayout9, ConstraintLayout constraintLayout10, ImageView imageView2, TextView textView3, RecyclerView recyclerView2, TextView textView4, ScrollView scrollView, View view2, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, TextView textView15, TextView textView16, TextView textView17, TextView textView18, TextView textView19, TextView textView20, TextView textView21, TextView textView22, TextView textView23, TextView textView24, TextView textView25, TextView textView26, TextView textView27, TextView textView28, TextView textView29, TextView textView30, TextView textView31, TextView textView32, TextView textView33, TextView textView34, TextView textView35, TextView textView36, TextView textView37, TextView textView38, TextView textView39, TextView textView40, TextView textView41, TextView textView42, TextView textView43, TextView textView44, TextView textView45, TextView textView46, TextView textView47, TextView textView48, TextView textView49, TextView textView50, TextView textView51, TextView textView52, TextView textView53, TextView textView54, TextView textView55, TextView textView56, TextView textView57, TextView textView58, TextView textView59, TextView textView60, TextView textView61, TextView textView62, TextView textView63, TextView textView64, TextView textView65, TextView textView66, TextView textView67, TextView textView68, TextView textView69, TextView textView70) {
        super(obj, view, i);
        this.busAnalyseUsbResultSave = button;
        this.eye = imageView;
        this.eye11Xlayout = constraintLayout;
        this.eye11Ylayout = constraintLayout2;
        this.eye1Xlayout = constraintLayout3;
        this.eye1Ylayout = constraintLayout4;
        this.eye2Xlayout = constraintLayout5;
        this.eye2Ylayout = constraintLayout6;
        this.eyeLayout = constraintLayout7;
        this.eyeText = textView;
        this.eyexruler11 = textView2;
        this.header = recyclerView;
        this.plotLayout = constraintLayout8;
        this.plotXLayout = constraintLayout9;
        this.plotYLayout = constraintLayout10;
        this.polt = imageView2;
        this.poltText = textView3;
        this.result = recyclerView2;
        this.resultText = textView4;
        this.scrollView = scrollView;
        this.titleLayout = view2;
        this.xruler1 = textView5;
        this.xruler10 = textView6;
        this.xruler11 = textView7;
        this.xruler111 = textView8;
        this.xruler12 = textView9;
        this.xruler2 = textView10;
        this.xruler21 = textView11;
        this.xruler211 = textView12;
        this.xruler22 = textView13;
        this.xruler3 = textView14;
        this.xruler31 = textView15;
        this.xruler311 = textView16;
        this.xruler32 = textView17;
        this.xruler4 = textView18;
        this.xruler41 = textView19;
        this.xruler411 = textView20;
        this.xruler42 = textView21;
        this.xruler5 = textView22;
        this.xruler51 = textView23;
        this.xruler511 = textView24;
        this.xruler52 = textView25;
        this.xruler6 = textView26;
        this.xruler61 = textView27;
        this.xruler611 = textView28;
        this.xruler7 = textView29;
        this.xruler71 = textView30;
        this.xruler711 = textView31;
        this.xruler8 = textView32;
        this.xruler811 = textView33;
        this.xruler9 = textView34;
        this.xruler911 = textView35;
        this.yruler1 = textView36;
        this.yruler102 = textView37;
        this.yruler11 = textView38;
        this.yruler111 = textView39;
        this.yruler112 = textView40;
        this.yruler12 = textView41;
        this.yruler2 = textView42;
        this.yruler21 = textView43;
        this.yruler211 = textView44;
        this.yruler22 = textView45;
        this.yruler3 = textView46;
        this.yruler31 = textView47;
        this.yruler311 = textView48;
        this.yruler32 = textView49;
        this.yruler4 = textView50;
        this.yruler41 = textView51;
        this.yruler411 = textView52;
        this.yruler42 = textView53;
        this.yruler5 = textView54;
        this.yruler51 = textView55;
        this.yruler511 = textView56;
        this.yruler52 = textView57;
        this.yruler6 = textView58;
        this.yruler61 = textView59;
        this.yruler611 = textView60;
        this.yruler62 = textView61;
        this.yruler7 = textView62;
        this.yruler71 = textView63;
        this.yruler72 = textView64;
        this.yruler8 = textView65;
        this.yruler81 = textView66;
        this.yruler82 = textView67;
        this.yruler9 = textView68;
        this.yruler91 = textView69;
        this.yruler92 = textView70;
    }

    public BusAnalyseUsbParam getParam() {
        return this.mParam;
    }

    public static PopupviewAnalyseUsbResultBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewAnalyseUsbResultBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (PopupviewAnalyseUsbResultBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_analyse_usb_result, viewGroup, z, obj);
    }

    public static PopupviewAnalyseUsbResultBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewAnalyseUsbResultBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (PopupviewAnalyseUsbResultBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_analyse_usb_result, null, false, obj);
    }

    public static PopupviewAnalyseUsbResultBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewAnalyseUsbResultBinding bind(View view, Object obj) {
        return (PopupviewAnalyseUsbResultBinding) bind(obj, view, R.layout.popupview_analyse_usb_result);
    }
}
