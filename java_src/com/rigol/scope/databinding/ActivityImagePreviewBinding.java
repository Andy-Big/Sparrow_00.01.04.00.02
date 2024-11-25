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
public abstract class ActivityImagePreviewBinding extends ViewDataBinding {
    public final TextView close;
    public final ImageView image;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityImagePreviewBinding(Object obj, View view, int i, TextView textView, ImageView imageView) {
        super(obj, view, i);
        this.close = textView;
        this.image = imageView;
    }

    public static ActivityImagePreviewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityImagePreviewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityImagePreviewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_image_preview, viewGroup, z, obj);
    }

    public static ActivityImagePreviewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityImagePreviewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityImagePreviewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_image_preview, null, false, obj);
    }

    public static ActivityImagePreviewBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityImagePreviewBinding bind(View view, Object obj) {
        return (ActivityImagePreviewBinding) bind(obj, view, R.layout.activity_image_preview);
    }
}
