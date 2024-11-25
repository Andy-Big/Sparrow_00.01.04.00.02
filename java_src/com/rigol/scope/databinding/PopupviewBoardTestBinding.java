package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.rigol.scope.R;
/* loaded from: classes2.dex */
public abstract class PopupviewBoardTestBinding extends ViewDataBinding {
    public final View divider5;
    public final View divider6;
    public final RecyclerView selfTestRecycler;
    public final TextView textView14;
    public final TextView textView48;
    public final TextView textView52;
    public final TextView textView57;
    public final TextView textView59;
    public final TextView tvItemValue;
    public final TextView tvSelfRange;
    public final TextView tvSelfTestItem;
    public final TextView tvWarning;

    /* JADX INFO: Access modifiers changed from: protected */
    public PopupviewBoardTestBinding(Object obj, View view, int i, View view2, View view3, RecyclerView recyclerView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9) {
        super(obj, view, i);
        this.divider5 = view2;
        this.divider6 = view3;
        this.selfTestRecycler = recyclerView;
        this.textView14 = textView;
        this.textView48 = textView2;
        this.textView52 = textView3;
        this.textView57 = textView4;
        this.textView59 = textView5;
        this.tvItemValue = textView6;
        this.tvSelfRange = textView7;
        this.tvSelfTestItem = textView8;
        this.tvWarning = textView9;
    }

    public static PopupviewBoardTestBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewBoardTestBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (PopupviewBoardTestBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_board_test, viewGroup, z, obj);
    }

    public static PopupviewBoardTestBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewBoardTestBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (PopupviewBoardTestBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_board_test, null, false, obj);
    }

    public static PopupviewBoardTestBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewBoardTestBinding bind(View view, Object obj) {
        return (PopupviewBoardTestBinding) bind(obj, view, R.layout.popupview_board_test);
    }
}
