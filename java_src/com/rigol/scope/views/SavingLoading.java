package com.rigol.scope.views;

import com.rigol.scope.R;
import kotlin.Metadata;

/* compiled from: LoadingPopupView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/rigol/scope/views/SavingLoading;", "Lcom/rigol/scope/views/LoadingPopupView;", "()V", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class SavingLoading extends LoadingPopupView {
    public SavingLoading() {
        setTitleResId(R.string.msg_storage_save);
        setContentResId(R.string.msg_storage_save_toast);
        setWrningResId(R.string.msg_storage_usb);
        isShowCancel().set(true);
    }
}
