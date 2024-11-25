package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.ThreadLocalElement;
import kotlinx.coroutines.internal.ThreadLocalKey;
/* compiled from: ThreadContextElement.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u001a+\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u0002H\u0002¢\u0006\u0002\u0010\u0005\u001a\u0019\u0010\u0006\u001a\u00020\u0007*\u0006\u0012\u0002\b\u00030\u0003H\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\b\u001a\u0019\u0010\t\u001a\u00020\n*\u0006\u0012\u0002\b\u00030\u0003H\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"asContextElement", "Lkotlinx/coroutines/ThreadContextElement;", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/lang/ThreadLocal;", "value", "(Ljava/lang/ThreadLocal;Ljava/lang/Object;)Lkotlinx/coroutines/ThreadContextElement;", "ensurePresent", "", "(Ljava/lang/ThreadLocal;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isPresent", "", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class ThreadContextElementKt {
    public static /* synthetic */ ThreadContextElement asContextElement$default(ThreadLocal threadLocal, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = threadLocal.get();
        }
        return asContextElement(threadLocal, obj);
    }

    public static final <T> ThreadContextElement<T> asContextElement(ThreadLocal<T> asContextElement, T t) {
        Intrinsics.checkParameterIsNotNull(asContextElement, "$this$asContextElement");
        return new ThreadLocalElement(t, asContextElement);
    }

    public static final Object isPresent(ThreadLocal<?> threadLocal, Continuation<? super Boolean> continuation) {
        return Boxing.boxBoolean(continuation.getContext().get(new ThreadLocalKey(threadLocal)) != null);
    }

    private static final Object isPresent$$forInline(ThreadLocal threadLocal, Continuation continuation) {
        InlineMarker.mark(3);
        Continuation continuation2 = null;
        return Boolean.valueOf(continuation2.getContext().get(new ThreadLocalKey(threadLocal)) != null);
    }

    public static final Object ensurePresent(ThreadLocal<?> threadLocal, Continuation<? super Unit> continuation) {
        if (Boxing.boxBoolean(continuation.getContext().get(new ThreadLocalKey(threadLocal)) != null).booleanValue()) {
            return Unit.INSTANCE;
        }
        throw new IllegalStateException(("ThreadLocal " + threadLocal + " is missing from context " + continuation.getContext()).toString());
    }

    private static final Object ensurePresent$$forInline(ThreadLocal threadLocal, Continuation continuation) {
        InlineMarker.mark(3);
        Continuation continuation2 = null;
        if (continuation2.getContext().get(new ThreadLocalKey(threadLocal)) != null) {
            return Unit.INSTANCE;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("ThreadLocal ");
        sb.append(threadLocal);
        sb.append(" is missing from context ");
        InlineMarker.mark(3);
        sb.append(continuation2.getContext());
        throw new IllegalStateException(sb.toString().toString());
    }
}
