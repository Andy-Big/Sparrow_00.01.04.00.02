package com.rigol.scope.views;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.blankj.utilcode.util.ActivityUtils;
import com.rigol.lib.data.Firmware;
import com.rigol.scope.R;
import com.rigol.scope.data.UpdateParam;
import com.rigol.scope.data.UtilityParam;
import com.rigol.scope.databinding.PopupviewUpdateBinding;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.PopupViewManager;
import com.rigol.scope.viewmodels.UpdateViewModel;
import com.rigol.scope.viewmodels.UtilityViewModel;
import com.rigol.scope.views.alert.OnlineUpgradeTermsPopupView;
import com.rigol.scope.views.baseview.BasePopupView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: UpdatePopupView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0006\u0010\n\u001a\u00020\u0007J\u000e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\rJ\u000e\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0013J\u000e\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/rigol/scope/views/UpdatePopupView;", "Lcom/rigol/scope/views/baseview/BasePopupView;", "Landroid/view/View$OnClickListener;", "()V", "updateParam", "Lcom/rigol/scope/data/UpdateParam;", "onClick", "", "v", "Landroid/view/View;", "reset", "setDownding", "isDownload", "", "setErrorCode", "errorCode", "", "setErrorMessage", "errorMessage", "", "setInstalling", "isInstall", "setMessage", "message", "setProgress", "progress", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class UpdatePopupView extends BasePopupView implements View.OnClickListener {
    private final UpdateParam updateParam;

    public UpdatePopupView() {
        super((int) R.style.App_PopupWindow_Update);
        MutableLiveData<Firmware> liveData;
        LiveData<UtilityParam> liveData2;
        this.updateParam = new UpdateParam();
        final PopupviewUpdateBinding inflate = PopupviewUpdateBinding.inflate(LayoutInflater.from(this.context));
        Intrinsics.checkNotNullExpressionValue(inflate, "PopupviewUpdateBinding.i…utInflater.from(context))");
        setContentView(inflate.getRoot());
        inflate.setUpdateParam(this.updateParam);
        UtilityViewModel utilityViewModel = (UtilityViewModel) ContextUtil.getAppViewModel(UtilityViewModel.class);
        if (utilityViewModel != null && (liveData2 = utilityViewModel.getLiveData()) != null) {
            Activity topActivity = ActivityUtils.getTopActivity();
            if (topActivity == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
            liveData2.observe((LifecycleOwner) topActivity, new Observer<UtilityParam>() { // from class: com.rigol.scope.views.UpdatePopupView.1
                @Override // androidx.lifecycle.Observer
                public final void onChanged(UtilityParam utilityParam) {
                    PopupviewUpdateBinding.this.setUtilityParam(utilityParam);
                }
            });
        }
        UpdateViewModel updateViewModel = (UpdateViewModel) ContextUtil.getAppViewModel(UpdateViewModel.class);
        if (updateViewModel != null && (liveData = updateViewModel.getLiveData()) != null) {
            Activity topActivity2 = ActivityUtils.getTopActivity();
            if (topActivity2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
            liveData.observe((LifecycleOwner) topActivity2, new Observer<Firmware>() { // from class: com.rigol.scope.views.UpdatePopupView.2
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Firmware firmware) {
                    PopupviewUpdateBinding.this.setFirmware(firmware);
                }
            });
        }
        UpdatePopupView updatePopupView = this;
        inflate.ok.setOnClickListener(updatePopupView);
        inflate.cancel.setOnClickListener(updatePopupView);
    }

    public final void setProgress(int i) {
        this.updateParam.setProgress(i);
    }

    public final void setDownding(boolean z) {
        this.updateParam.setDownload(z);
    }

    public final void setInstalling(boolean z) {
        this.updateParam.setInstall(z);
    }

    public final void setMessage(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        this.updateParam.setMessage(message);
    }

    public final void setErrorMessage(String errorMessage) {
        Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
        this.updateParam.setErrorMessage(errorMessage);
    }

    public final void setErrorCode(int i) {
        this.updateParam.setErrorCode(i);
    }

    public final void reset() {
        this.updateParam.setErrorCode(0);
        this.updateParam.setErrorMessage("");
        this.updateParam.setDownload(false);
        this.updateParam.setInstall(false);
        this.updateParam.setProgress(0);
        this.updateParam.setMessage("");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        BasePopupView basePopupView;
        Intrinsics.checkNotNullParameter(v, "v");
        int id = v.getId();
        if (id != R.id.cancel) {
            if (id == R.id.ok && (basePopupView = PopupViewManager.getInstance().get(OnlineUpgradeTermsPopupView.class)) != null && (basePopupView instanceof OnlineUpgradeTermsPopupView)) {
                ((OnlineUpgradeTermsPopupView) basePopupView).setConfirmListener(new View.OnClickListener() { // from class: com.rigol.scope.views.UpdatePopupView$onClick$1$1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        Intent intent = new Intent();
                        intent.setAction("com.rigol.watchdog.update.app");
                        ActivityUtils.getTopActivity().sendBroadcast(intent);
                    }
                });
                basePopupView.show();
                return;
            }
            return;
        }
        dismiss();
    }
}
