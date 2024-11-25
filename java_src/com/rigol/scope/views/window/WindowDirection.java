package com.rigol.scope.views.window;

import kotlin.Metadata;
/* compiled from: WindowNode.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/rigol/scope/views/window/WindowDirection;", "", "(Ljava/lang/String;I)V", "isHead", "", "()Z", "START", "END", "TOP", "BOTTOM", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public enum WindowDirection {
    START,
    END,
    TOP,
    BOTTOM;

    public final boolean isHead() {
        WindowDirection windowDirection = this;
        return windowDirection == START || windowDirection == TOP;
    }
}
