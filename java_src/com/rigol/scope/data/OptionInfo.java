package com.rigol.scope.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: OptionParam.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/rigol/scope/data/OptionInfo;", "", "id", "", "exp", "(Ljava/lang/String;Ljava/lang/String;)V", "getExp", "()Ljava/lang/String;", "getId", "info", "getInfo", "setInfo", "(Ljava/lang/String;)V", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class OptionInfo {
    private final String exp;
    private final String id;
    private String info;

    public OptionInfo(String id, String exp) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(exp, "exp");
        this.id = id;
        this.exp = exp;
    }

    public final String getExp() {
        return this.exp;
    }

    public final String getId() {
        return this.id;
    }

    public final String getInfo() {
        return this.info;
    }

    public final void setInfo(String str) {
        this.info = str;
    }
}
