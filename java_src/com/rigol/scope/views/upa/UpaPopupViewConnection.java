package com.rigol.scope.views.upa;

import android.view.LayoutInflater;
import com.rigol.scope.R;
import com.rigol.scope.databinding.UpaPopupviewConnectionBinding;
import com.rigol.scope.databinding.UpaPopupviewConnectionBindingImpl;
import com.rigol.scope.views.baseview.BasePopupView;
/* loaded from: classes2.dex */
public class UpaPopupViewConnection extends BasePopupView {
    UpaPopupviewConnectionBinding upaPopupviewConnectionBinding;

    public UpaPopupViewConnection() {
        super((int) R.style.App_PopupWindow_popuview_upa_tip);
        this.upaPopupviewConnectionBinding = UpaPopupviewConnectionBindingImpl.inflate(LayoutInflater.from(this.context));
        this.dismissOthers = false;
        setContentView(this.upaPopupviewConnectionBinding.getRoot());
    }
}
