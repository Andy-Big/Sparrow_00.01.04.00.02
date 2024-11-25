package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
/* loaded from: classes2.dex */
public abstract class AdapterItemDiskManageBinding extends ViewDataBinding {
    public final TextView fileInfo;
    public final TextView fileName;
    public final TextView fileSize;
    public final ImageView image;
    public final ImageView status;

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterItemDiskManageBinding(Object obj, View view, int i, TextView textView, TextView textView2, TextView textView3, ImageView imageView, ImageView imageView2) {
        super(obj, view, i);
        this.fileInfo = textView;
        this.fileName = textView2;
        this.fileSize = textView3;
        this.image = imageView;
        this.status = imageView2;
    }

    public static AdapterItemDiskManageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterItemDiskManageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterItemDiskManageBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_item_disk_manage, viewGroup, z, obj);
    }

    public static AdapterItemDiskManageBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterItemDiskManageBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterItemDiskManageBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_item_disk_manage, null, false, obj);
    }

    public static AdapterItemDiskManageBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterItemDiskManageBinding bind(View view, Object obj) {
        return (AdapterItemDiskManageBinding) bind(obj, view, R.layout.adapter_item_disk_manage);
    }
}
