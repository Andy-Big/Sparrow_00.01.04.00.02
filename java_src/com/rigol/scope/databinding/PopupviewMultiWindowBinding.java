package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableInt;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.rigol.scope.R;
import com.rigol.scope.data.WindowParam;
/* loaded from: classes2.dex */
public abstract class PopupviewMultiWindowBinding extends ViewDataBinding {
    public final View dividingLine;
    public final TextView holder1Spinner;
    public final TextView holder1Title;
    public final TextView holder2Spinner;
    public final TextView holder2Title;
    public final TextView holder3Spinner;
    public final TextView holder3Title;
    public final TextView holder4Spinner;
    public final TextView holder4Title;
    @Bindable
    protected ObservableBoolean mOkButtonEnable;
    @Bindable
    protected View.OnClickListener mOnClickListener;
    @Bindable
    protected ObservableBoolean mShowSource1;
    @Bindable
    protected ObservableBoolean mShowSource2;
    @Bindable
    protected ObservableBoolean mShowSource3;
    @Bindable
    protected ObservableBoolean mShowType;
    @Bindable
    protected ObservableInt mSourceArrayId;
    @Bindable
    protected ObservableInt mTypeArrayId;
    @Bindable
    protected ObservableBoolean mUiEnable;
    @Bindable
    protected WindowParam mWindowParam;
    public final Button okButton;
    public final ImageView pic;
    public final ConstraintLayout sourceLayout;
    public final TextView typeDiagram;
    public final RecyclerView typeDiagramList;
    public final TextView typeResultTable;
    public final RecyclerView typeResultTableList;

    public abstract void setOkButtonEnable(ObservableBoolean observableBoolean);

    public abstract void setOnClickListener(View.OnClickListener onClickListener);

    public abstract void setShowSource1(ObservableBoolean observableBoolean);

    public abstract void setShowSource2(ObservableBoolean observableBoolean);

    public abstract void setShowSource3(ObservableBoolean observableBoolean);

    public abstract void setShowType(ObservableBoolean observableBoolean);

    public abstract void setSourceArrayId(ObservableInt observableInt);

    public abstract void setTypeArrayId(ObservableInt observableInt);

    public abstract void setUiEnable(ObservableBoolean observableBoolean);

    public abstract void setWindowParam(WindowParam windowParam);

    /* JADX INFO: Access modifiers changed from: protected */
    public PopupviewMultiWindowBinding(Object obj, View view, int i, View view2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, Button button, ImageView imageView, ConstraintLayout constraintLayout, TextView textView9, RecyclerView recyclerView, TextView textView10, RecyclerView recyclerView2) {
        super(obj, view, i);
        this.dividingLine = view2;
        this.holder1Spinner = textView;
        this.holder1Title = textView2;
        this.holder2Spinner = textView3;
        this.holder2Title = textView4;
        this.holder3Spinner = textView5;
        this.holder3Title = textView6;
        this.holder4Spinner = textView7;
        this.holder4Title = textView8;
        this.okButton = button;
        this.pic = imageView;
        this.sourceLayout = constraintLayout;
        this.typeDiagram = textView9;
        this.typeDiagramList = recyclerView;
        this.typeResultTable = textView10;
        this.typeResultTableList = recyclerView2;
    }

    public WindowParam getWindowParam() {
        return this.mWindowParam;
    }

    public ObservableBoolean getUiEnable() {
        return this.mUiEnable;
    }

    public ObservableBoolean getOkButtonEnable() {
        return this.mOkButtonEnable;
    }

    public ObservableBoolean getShowSource1() {
        return this.mShowSource1;
    }

    public ObservableBoolean getShowSource2() {
        return this.mShowSource2;
    }

    public ObservableBoolean getShowSource3() {
        return this.mShowSource3;
    }

    public ObservableBoolean getShowType() {
        return this.mShowType;
    }

    public ObservableInt getSourceArrayId() {
        return this.mSourceArrayId;
    }

    public ObservableInt getTypeArrayId() {
        return this.mTypeArrayId;
    }

    public View.OnClickListener getOnClickListener() {
        return this.mOnClickListener;
    }

    public static PopupviewMultiWindowBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewMultiWindowBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (PopupviewMultiWindowBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_multi_window, viewGroup, z, obj);
    }

    public static PopupviewMultiWindowBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewMultiWindowBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (PopupviewMultiWindowBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_multi_window, null, false, obj);
    }

    public static PopupviewMultiWindowBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewMultiWindowBinding bind(View view, Object obj) {
        return (PopupviewMultiWindowBinding) bind(obj, view, R.layout.popupview_multi_window);
    }
}
