package com.rigol.scope.views.alert;

import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LiveData;
import com.rigol.scope.R;
import com.rigol.scope.data.BaseProperty;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.viewmodels.AutosetViewModel;
import com.rigol.scope.views.auto.AutosetParam;
import com.rigol.util.ToastUtils;
import kotlin.Metadata;
/* compiled from: AlertPopupView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/rigol/scope/views/alert/AutoLockPopupView;", "Lcom/rigol/scope/views/alert/AlertPopupView;", "()V", "onLocaleChanged", "", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class AutoLockPopupView extends AlertPopupView {
    public AutoLockPopupView() {
        setTitle(this.context.getString(R.string.msg_auto_lock));
        setContent(this.context.getString(R.string.info_lock_sure));
        setDrawable(ContextCompat.getDrawable(this.context, R.drawable.ic_help));
        setConfirmListener(new View.OnClickListener() { // from class: com.rigol.scope.views.alert.AutoLockPopupView.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaseProperty<Boolean> lock;
                LiveData<AutosetParam> liveData;
                AutosetViewModel autosetViewModel = (AutosetViewModel) ContextUtil.getAppViewModel(AutosetViewModel.class);
                AutosetParam value = (autosetViewModel == null || (liveData = autosetViewModel.getLiveData()) == null) ? null : liveData.getValue();
                if (value != null && (lock = value.getLock()) != null) {
                    lock.save(true);
                }
                ToastUtils.showShort((int) R.string.err_auto_locked);
            }
        });
        this.dismissOthers = false;
    }

    @Override // com.rigol.scope.views.alert.AlertPopupView, com.rigol.scope.views.baseview.BasePopupView
    public void onLocaleChanged() {
        super.onLocaleChanged();
        getBinding().title.setText(R.string.msg_auto_lock);
        getBinding().content.setText(R.string.info_lock_sure);
    }
}
