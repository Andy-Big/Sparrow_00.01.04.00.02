package kotlinx.coroutines.internal;

import androidx.exifinterface.media.ExifInterface;
import com.rigol.scope.utilities.ViewUtil;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ThreadSafeHeap.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\u001a$\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0004H\u0080\b¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"clear", "", ExifInterface.GPS_DIRECTION_TRUE, ViewUtil.KEY_A, "", "([Ljava/lang/Object;)V", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class ThreadSafeHeapKt {
    public static final <T> void clear(T[] a) {
        Intrinsics.checkParameterIsNotNull(a, "a");
        ArraysKt.fill$default(a, (Object) null, 0, 0, 6, (Object) null);
    }
}
