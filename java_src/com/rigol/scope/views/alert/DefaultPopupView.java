package com.rigol.scope.views.alert;

import android.view.View;
import androidx.core.content.ContextCompat;
import com.rigol.scope.R;
import com.rigol.scope.cil.API;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.data.MessageBus;
import com.rigol.scope.utilities.KtUtilKt;
import kotlin.Metadata;
/* compiled from: AlertPopupView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/rigol/scope/views/alert/DefaultPopupView;", "Lcom/rigol/scope/views/alert/AlertPopupView;", "()V", "onLocaleChanged", "", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class DefaultPopupView extends AlertPopupView {
    public DefaultPopupView() {
        this.dismissOthers = false;
        setTitle(this.context.getString(R.string.msg_restore_default));
        setContent(this.context.getString(R.string.inf_default));
        setDrawable(ContextCompat.getDrawable(this.context, R.drawable.ic_help));
        setConfirmListener(new View.OnClickListener() { // from class: com.rigol.scope.views.alert.DefaultPopupView.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                API.getInstance().UI_PostInt32(12, MessageID.MSG_RESTORE_DEFAULT, 0);
                MessageBus.getInstance().onSyncData(MessageBus.getKey(25, MessageID.MSG_SEARCH_MARK_TABEL_EN), false);
                KtUtilKt.resetAll();
            }
        });
    }

    @Override // com.rigol.scope.views.alert.AlertPopupView, com.rigol.scope.views.baseview.BasePopupView
    public void onLocaleChanged() {
        super.onLocaleChanged();
        getBinding().title.setText(R.string.msg_title_warning);
        getBinding().content.setText(R.string.inf_default);
    }
}
