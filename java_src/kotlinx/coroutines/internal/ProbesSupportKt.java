package kotlinx.coroutines.internal;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ProbesSupport.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a#\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0080\b¨\u0006\u0004"}, d2 = {"probeCoroutineCreated", "Lkotlin/coroutines/Continuation;", ExifInterface.GPS_DIRECTION_TRUE, "completion", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class ProbesSupportKt {
    public static final <T> Continuation<T> probeCoroutineCreated(Continuation<? super T> completion) {
        Intrinsics.checkParameterIsNotNull(completion, "completion");
        return DebugProbesKt.probeCoroutineCreated(completion);
    }
}
