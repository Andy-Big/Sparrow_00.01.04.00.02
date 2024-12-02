package com.rigol.scope.data;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UpdateParam.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R&\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR&\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR&\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00108G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R&\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00108G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R&\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\r\"\u0004\b\u0019\u0010\u000fR&\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0007\"\u0004\b\u001c\u0010\t¨\u0006\u001d"}, d2 = {"Lcom/rigol/scope/data/UpdateParam;", "Landroidx/databinding/BaseObservable;", "()V", "value", "", "errorCode", "getErrorCode", "()I", "setErrorCode", "(I)V", "", "errorMessage", "getErrorMessage", "()Ljava/lang/String;", "setErrorMessage", "(Ljava/lang/String;)V", "", "isDownload", "()Z", "setDownload", "(Z)V", "isInstall", "setInstall", "message", "getMessage", "setMessage", "progress", "getProgress", "setProgress", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class UpdateParam extends BaseObservable {
    private int errorCode;
    private boolean isDownload;
    private boolean isInstall;
    private int progress;
    private String message = "";
    private String errorMessage = "";

    @Bindable
    public final boolean isDownload() {
        return this.isDownload;
    }

    public final void setDownload(boolean z) {
        this.isDownload = z;
        notifyPropertyChanged(248);
    }

    @Bindable
    public final boolean isInstall() {
        return this.isInstall;
    }

    public final void setInstall(boolean z) {
        this.isInstall = z;
        notifyPropertyChanged(437);
    }

    @Bindable
    public final int getProgress() {
        return this.progress;
    }

    public final void setProgress(int i) {
        this.progress = i;
        notifyPropertyChanged(671);
    }

    @Bindable
    public final String getMessage() {
        return this.message;
    }

    public final void setMessage(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.message = value;
        notifyPropertyChanged(534);
    }

    @Bindable
    public final int getErrorCode() {
        return this.errorCode;
    }

    public final void setErrorCode(int i) {
        this.errorCode = i;
        notifyPropertyChanged(278);
    }

    @Bindable
    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final void setErrorMessage(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.errorMessage = value;
        notifyPropertyChanged(279);
    }
}
