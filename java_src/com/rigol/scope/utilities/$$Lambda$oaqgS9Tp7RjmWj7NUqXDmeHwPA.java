package com.rigol.scope.utilities;

import com.rigol.scope.utilities.UnitFormat;
import java.util.function.BiConsumer;
/* compiled from: lambda */
/* renamed from: com.rigol.scope.utilities.-$$Lambda$oaqgS9T-p7RjmWj7NUqXDmeHwPA  reason: invalid class name */
/* loaded from: classes2.dex */
public final /* synthetic */ class $$Lambda$oaqgS9Tp7RjmWj7NUqXDmeHwPA implements BiConsumer {
    public static final /* synthetic */ $$Lambda$oaqgS9Tp7RjmWj7NUqXDmeHwPA INSTANCE = new $$Lambda$oaqgS9Tp7RjmWj7NUqXDmeHwPA();

    private /* synthetic */ $$Lambda$oaqgS9Tp7RjmWj7NUqXDmeHwPA() {
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        ((UnitFormat) obj).setSi((UnitFormat.SI) obj2);
    }
}
