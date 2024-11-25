package com.rigol.util;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DiskUtil.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\f\u001a\u00020\u0003H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\r"}, d2 = {"Lcom/rigol/util/DiskInfo;", "", "path", "", "state", "isRemovable", "", "(Ljava/lang/String;Ljava/lang/String;Z)V", "()Z", "getPath", "()Ljava/lang/String;", "getState", "toString", "lib_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class DiskInfo {
    private final boolean isRemovable;
    private final String path;
    private final String state;

    public DiskInfo(String path, String state, boolean z) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(state, "state");
        this.path = path;
        this.state = state;
        this.isRemovable = z;
    }

    public final String getPath() {
        return this.path;
    }

    public final String getState() {
        return this.state;
    }

    public final boolean isRemovable() {
        return this.isRemovable;
    }

    public String toString() {
        return "SDCardInfo {path = " + this.path + ", state = " + this.state + ", isRemovable = " + this.isRemovable + '}';
    }
}
