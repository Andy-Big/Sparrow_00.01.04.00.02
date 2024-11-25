package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.text.StringsKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SystemProps.common.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\u0000\u001a,\u0010\u0000\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005H\u0000\u001a,\u0010\u0000\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\b2\b\b\u0002\u0010\u0006\u001a\u00020\b2\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0000¨\u0006\t"}, d2 = {"systemProp", "", "propertyName", "", "defaultValue", "", "minValue", "maxValue", "", "kotlinx-coroutines-core"}, k = 5, mv = {1, 1, 15}, xs = "kotlinx/coroutines/internal/SystemPropsKt")
/* loaded from: classes2.dex */
public final /* synthetic */ class SystemPropsKt__SystemProps_commonKt {
    public static final boolean systemProp(String propertyName, boolean z) {
        Intrinsics.checkParameterIsNotNull(propertyName, "propertyName");
        String systemProp = SystemPropsKt.systemProp(propertyName);
        return systemProp != null ? Boolean.parseBoolean(systemProp) : z;
    }

    public static /* synthetic */ int systemProp$default(String str, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i2 = 1;
        }
        if ((i4 & 8) != 0) {
            i3 = Integer.MAX_VALUE;
        }
        return SystemPropsKt.systemProp(str, i, i2, i3);
    }

    public static final int systemProp(String propertyName, int i, int i2, int i3) {
        Intrinsics.checkParameterIsNotNull(propertyName, "propertyName");
        return (int) SystemPropsKt.systemProp(propertyName, i, i2, i3);
    }

    public static /* synthetic */ long systemProp$default(String str, long j, long j2, long j3, int i, Object obj) {
        if ((i & 4) != 0) {
            j2 = 1;
        }
        long j4 = j2;
        if ((i & 8) != 0) {
            j3 = LongCompanionObject.MAX_VALUE;
        }
        return SystemPropsKt.systemProp(str, j, j4, j3);
    }

    public static final long systemProp(String propertyName, long j, long j2, long j3) {
        Intrinsics.checkParameterIsNotNull(propertyName, "propertyName");
        String systemProp = SystemPropsKt.systemProp(propertyName);
        if (systemProp != null) {
            Long longOrNull = StringsKt.toLongOrNull(systemProp);
            if (longOrNull == null) {
                throw new IllegalStateException(("System property '" + propertyName + "' has unrecognized value '" + systemProp + '\'').toString());
            }
            long longValue = longOrNull.longValue();
            if (j2 > longValue || j3 < longValue) {
                throw new IllegalStateException(("System property '" + propertyName + "' should be in range " + j2 + ".." + j3 + ", but is '" + longValue + '\'').toString());
            }
            return longValue;
        }
        return j;
    }
}
