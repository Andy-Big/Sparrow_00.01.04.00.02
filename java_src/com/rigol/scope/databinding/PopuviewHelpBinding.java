package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.github.barteksc.pdfviewer.PDFView;
import com.rigol.scope.R;
/* loaded from: classes2.dex */
public abstract class PopuviewHelpBinding extends ViewDataBinding {
    public final View titleLayout;
    public final PDFView webview;

    /* JADX INFO: Access modifiers changed from: protected */
    public PopuviewHelpBinding(Object obj, View view, int i, View view2, PDFView pDFView) {
        super(obj, view, i);
        this.titleLayout = view2;
        this.webview = pDFView;
    }

    public static PopuviewHelpBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopuviewHelpBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (PopuviewHelpBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popuview_help, viewGroup, z, obj);
    }

    public static PopuviewHelpBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopuviewHelpBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (PopuviewHelpBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popuview_help, null, false, obj);
    }

    public static PopuviewHelpBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopuviewHelpBinding bind(View view, Object obj) {
        return (PopuviewHelpBinding) bind(obj, view, R.layout.popuview_help);
    }
}
