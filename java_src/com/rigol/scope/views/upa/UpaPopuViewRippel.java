package com.rigol.scope.views.upa;

import android.view.LayoutInflater;
import com.rigol.scope.R;
import com.rigol.scope.databinding.UpaPoppviewRipperBinding;
import com.rigol.scope.databinding.UpaPoppviewRipperBindingImpl;
import com.rigol.scope.views.baseview.BasePopupView;
/* loaded from: classes2.dex */
public class UpaPopuViewRippel extends BasePopupView {
    UpaPoppviewRipperBinding upaPoppviewRipperBinding;

    public UpaPopuViewRippel() {
        super((int) R.style.App_PopupWindow_popuview_upa_tip);
        this.upaPoppviewRipperBinding = UpaPoppviewRipperBindingImpl.inflate(LayoutInflater.from(this.context));
        this.dismissOthers = false;
        setContentView(this.upaPoppviewRipperBinding.getRoot());
    }
}
