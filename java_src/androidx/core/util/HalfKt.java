package androidx.core.util;

import android.util.Half;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Half.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0002\u0010\n\n\u0002\u0010\u000e\n\u0000\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\b\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0003H\u0087\b\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0004H\u0087\b\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0005H\u0087\b¨\u0006\u0006"}, d2 = {"toHalf", "Landroid/util/Half;", "", "", "", "", "core-ktx_release"}, k = 2, mv = {1, 1, 16})
/* loaded from: classes.dex */
public final class HalfKt {
    public static final Half toHalf(short s) {
        Half valueOf = Half.valueOf(s);
        Intrinsics.checkExpressionValueIsNotNull(valueOf, "Half.valueOf(this)");
        return valueOf;
    }

    public static final Half toHalf(float f) {
        Half valueOf = Half.valueOf(f);
        Intrinsics.checkExpressionValueIsNotNull(valueOf, "Half.valueOf(this)");
        return valueOf;
    }

    public static final Half toHalf(String toHalf) {
        Intrinsics.checkParameterIsNotNull(toHalf, "$this$toHalf");
        Half valueOf = Half.valueOf(toHalf);
        Intrinsics.checkExpressionValueIsNotNull(valueOf, "Half.valueOf(this)");
        return valueOf;
    }

    public static final Half toHalf(double d) {
        Half valueOf = Half.valueOf((float) d);
        Intrinsics.checkExpressionValueIsNotNull(valueOf, "Half.valueOf(this)");
        return valueOf;
    }
}
