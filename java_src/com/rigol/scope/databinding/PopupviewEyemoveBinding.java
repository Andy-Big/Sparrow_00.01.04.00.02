package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
import com.rigol.scope.views.SwitchButton;
/* loaded from: classes2.dex */
public abstract class PopupviewEyemoveBinding extends ViewDataBinding {
    public final TextView eyeMove;
    public final ImageButton moveDown;
    public final ImageButton moveLeft;
    public final SwitchButton moveRate;
    public final ImageButton moveRight;
    public final ImageButton moveUp;
    public final ImageButton reset;

    /* JADX INFO: Access modifiers changed from: protected */
    public PopupviewEyemoveBinding(Object obj, View view, int i, TextView textView, ImageButton imageButton, ImageButton imageButton2, SwitchButton switchButton, ImageButton imageButton3, ImageButton imageButton4, ImageButton imageButton5) {
        super(obj, view, i);
        this.eyeMove = textView;
        this.moveDown = imageButton;
        this.moveLeft = imageButton2;
        this.moveRate = switchButton;
        this.moveRight = imageButton3;
        this.moveUp = imageButton4;
        this.reset = imageButton5;
    }

    public static PopupviewEyemoveBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewEyemoveBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (PopupviewEyemoveBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_eyemove, viewGroup, z, obj);
    }

    public static PopupviewEyemoveBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewEyemoveBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (PopupviewEyemoveBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_eyemove, null, false, obj);
    }

    public static PopupviewEyemoveBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewEyemoveBinding bind(View view, Object obj) {
        return (PopupviewEyemoveBinding) bind(obj, view, R.layout.popupview_eyemove);
    }
}
