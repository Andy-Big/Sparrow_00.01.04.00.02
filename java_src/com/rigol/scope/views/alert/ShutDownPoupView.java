package com.rigol.scope.views.alert;

import android.view.View;
import androidx.core.content.ContextCompat;
import com.rigol.scope.R;
import com.rigol.scope.cil.API;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.viewmodels.PanelKeyViewModel;
import kotlin.Metadata;
/* compiled from: AlertPopupView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\u0006"}, d2 = {"Lcom/rigol/scope/views/alert/ShutDownPoupView;", "Lcom/rigol/scope/views/alert/AlertPopupView;", "()V", "onDismiss", "", "onLocaleChanged", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class ShutDownPoupView extends AlertPopupView {
    public ShutDownPoupView() {
        setTitle(this.context.getString(R.string.msg_app_utility_shutdown));
        setContent(this.context.getString(R.string.msg_alert_shutdown));
        setDrawable(ContextCompat.getDrawable(this.context, R.drawable.ic_shutdown));
        setConfirmListener(new View.OnClickListener() { // from class: com.rigol.scope.views.alert.ShutDownPoupView.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                API.getInstance().UI_PostInt32(11, MessageID.MSG_HARDWARE_POWERDOWN, 1);
            }
        });
        setCancelListener(new View.OnClickListener() { // from class: com.rigol.scope.views.alert.ShutDownPoupView.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                API.getInstance().UI_PostInt32(11, MessageID.MSG_HARDWARE_POWERDOWN, 0);
            }
        });
    }

    @Override // com.rigol.scope.views.alert.AlertPopupView, com.rigol.scope.views.baseview.BasePopupView
    public void onLocaleChanged() {
        super.onLocaleChanged();
        getBinding().title.setText(R.string.msg_app_utility_shutdown);
        getBinding().content.setText(R.string.msg_alert_shutdown);
    }

    @Override // com.rigol.scope.views.baseview.BasePopupView, android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        super.onDismiss();
        PanelKeyViewModel.isPowerDown = false;
        API.getInstance().UI_PostInt32(11, MessageID.MSG_HARDWARE_POWERDOWN, 0);
    }
}
