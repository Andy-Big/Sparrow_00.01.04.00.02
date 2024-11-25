package com.rigol.scope.data;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import com.sun.mail.imap.IMAPStore;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* compiled from: DiskParam.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0019\u001a\u00020\u0004J\u000e\u0010\u0019\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004R*\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00048G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR&\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR&\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R&\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR*\u0010\u0016\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00048G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\t¨\u0006\u001a"}, d2 = {"Lcom/rigol/scope/data/DiskParam;", "Landroidx/databinding/BaseObservable;", "()V", "value", "", IMAPStore.ID_NAME, "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "path", "getPath", "setPath", "", "removable", "getRemovable", "()Z", "setRemovable", "(Z)V", "root", "getRoot", "setRoot", "shorterName", "getShorterName", "setShorterName", "getFormattedPath", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class DiskParam extends BaseObservable {
    private boolean removable;
    private String path = DiskManageParam.DEFAULT_PATH;
    private String root = DiskManageParam.DEFAULT_PATH;
    private String name = "Local Disk (C)";
    private String shorterName = DiskParamKt.DEFAULT_SHORTER_NAME;

    @Bindable
    public final String getPath() {
        return this.path;
    }

    public final void setPath(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.path = value;
        notifyPropertyChanged(602);
    }

    @Bindable
    public final String getRoot() {
        return this.root;
    }

    public final void setRoot(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.root = value;
        notifyPropertyChanged(743);
    }

    @Bindable
    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        this.name = str;
        notifyPropertyChanged(555);
    }

    @Bindable
    public final String getShorterName() {
        return this.shorterName;
    }

    public final void setShorterName(String str) {
        this.shorterName = str;
        notifyPropertyChanged(824);
    }

    @Bindable
    public final boolean getRemovable() {
        return this.removable;
    }

    public final void setRemovable(boolean z) {
        this.removable = z;
        notifyPropertyChanged(737);
    }

    public final String getFormattedPath() {
        if (StringsKt.startsWith$default(this.path, this.root, false, 2, (Object) null)) {
            String str = this.path;
            String str2 = this.root;
            String str3 = this.shorterName;
            if (str3 == null) {
                str3 = "";
            }
            return StringsKt.replace(StringsKt.replaceFirst(str, str2, str3, false), "/", "\\", false);
        }
        return StringsKt.replace(this.path, "/", "\\", false);
    }

    public final String getFormattedPath(String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        if (StringsKt.startsWith$default(path, this.root, false, 2, (Object) null)) {
            String str = this.root;
            String str2 = this.shorterName;
            if (str2 == null) {
                str2 = "";
            }
            return StringsKt.replace(StringsKt.replaceFirst(path, str, str2, false), "/", "\\", false);
        }
        return StringsKt.replace(path, "/", "\\", false);
    }
}
