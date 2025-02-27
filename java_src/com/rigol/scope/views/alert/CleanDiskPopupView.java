package com.rigol.scope.views.alert;

import androidx.core.content.ContextCompat;
import com.rigol.scope.R;
import kotlin.Metadata;

/* compiled from: AlertPopupView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/rigol/scope/views/alert/CleanDiskPopupView;", "Lcom/rigol/scope/views/alert/AlertPopupView;", "()V", "onLocaleChanged", "", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class CleanDiskPopupView extends AlertPopupView {
    public CleanDiskPopupView() {
        this.dismissOthers = false;
        setTitle(this.context.getString(R.string.msg_storage_securityclear));
        setContent(this.context.getString(R.string.inf_security_clear));
        setDrawable(ContextCompat.getDrawable(this.context, R.drawable.ic_delete));
    }

    @Override // com.rigol.scope.views.alert.AlertPopupView, com.rigol.scope.views.baseview.BasePopupView
    public void onLocaleChanged() {
        super.onLocaleChanged();
        getBinding().title.setText(R.string.msg_storage_securityclear);
        getBinding().content.setText(R.string.inf_security_clear);
    }
}
