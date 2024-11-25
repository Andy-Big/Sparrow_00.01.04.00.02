package com.rigol.scope.views.window;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: WindowNode.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/rigol/scope/views/window/WindowType;", "", "(Ljava/lang/String;I)V", "same", "", "direction", "Lcom/rigol/scope/views/window/WindowDirection;", "HORIZONTAL", "VERTICAL", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public enum WindowType {
    HORIZONTAL,
    VERTICAL;

    public final boolean same(WindowDirection direction) {
        Intrinsics.checkNotNullParameter(direction, "direction");
        if (this == HORIZONTAL) {
            if (direction != WindowDirection.START && direction != WindowDirection.END) {
                return false;
            }
        } else if (direction != WindowDirection.TOP && direction != WindowDirection.BOTTOM) {
            return false;
        }
        return true;
    }
}
