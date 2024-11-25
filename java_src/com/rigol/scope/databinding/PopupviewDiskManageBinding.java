package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.rigol.scope.R;
import com.rigol.scope.data.DiskManageParam;
import com.rigol.scope.data.SharedParam;
/* loaded from: classes2.dex */
public abstract class PopupviewDiskManageBinding extends ViewDataBinding {
    public final ImageView backward;
    public final View bottomDividingLine;
    public final ConstraintLayout bottomLayout;
    public final Button cancel;
    public final Button cleanAll;
    public final Button copy;
    public final Button createFile;
    public final Button createFolder;
    public final TextView currentPath;
    public final Button cut;
    public final Button delete;
    public final ImageView diskListArrow;
    public final View dividingLine;
    public final TextView empty;
    public final RecyclerView fileList;
    public final ImageView forward;
    public final TextView loading;
    @Bindable
    protected View.OnClickListener mClickListener;
    @Bindable
    protected DiskManageParam mDiskParam;
    @Bindable
    protected ObservableBoolean mLoadingFiles;
    @Bindable
    protected SharedParam mShareParam;
    public final Button ok;
    public final Button paste;
    public final Button rename;
    public final ImageButton selectAll;
    public final ImageButton selectCancel;

    public abstract void setClickListener(View.OnClickListener onClickListener);

    public abstract void setDiskParam(DiskManageParam diskManageParam);

    public abstract void setLoadingFiles(ObservableBoolean observableBoolean);

    public abstract void setShareParam(SharedParam sharedParam);

    /* JADX INFO: Access modifiers changed from: protected */
    public PopupviewDiskManageBinding(Object obj, View view, int i, ImageView imageView, View view2, ConstraintLayout constraintLayout, Button button, Button button2, Button button3, Button button4, Button button5, TextView textView, Button button6, Button button7, ImageView imageView2, View view3, TextView textView2, RecyclerView recyclerView, ImageView imageView3, TextView textView3, Button button8, Button button9, Button button10, ImageButton imageButton, ImageButton imageButton2) {
        super(obj, view, i);
        this.backward = imageView;
        this.bottomDividingLine = view2;
        this.bottomLayout = constraintLayout;
        this.cancel = button;
        this.cleanAll = button2;
        this.copy = button3;
        this.createFile = button4;
        this.createFolder = button5;
        this.currentPath = textView;
        this.cut = button6;
        this.delete = button7;
        this.diskListArrow = imageView2;
        this.dividingLine = view3;
        this.empty = textView2;
        this.fileList = recyclerView;
        this.forward = imageView3;
        this.loading = textView3;
        this.ok = button8;
        this.paste = button9;
        this.rename = button10;
        this.selectAll = imageButton;
        this.selectCancel = imageButton2;
    }

    public DiskManageParam getDiskParam() {
        return this.mDiskParam;
    }

    public SharedParam getShareParam() {
        return this.mShareParam;
    }

    public ObservableBoolean getLoadingFiles() {
        return this.mLoadingFiles;
    }

    public View.OnClickListener getClickListener() {
        return this.mClickListener;
    }

    public static PopupviewDiskManageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewDiskManageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (PopupviewDiskManageBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_disk_manage, viewGroup, z, obj);
    }

    public static PopupviewDiskManageBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewDiskManageBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (PopupviewDiskManageBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_disk_manage, null, false, obj);
    }

    public static PopupviewDiskManageBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewDiskManageBinding bind(View view, Object obj) {
        return (PopupviewDiskManageBinding) bind(obj, view, R.layout.popupview_disk_manage);
    }
}
