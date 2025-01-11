package kotlinx.coroutines.sync;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.SystemPropsKt__SystemProps_commonKt;

/* compiled from: Semaphore.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u0007\u001a)\u0010\r\u001a\u0002H\u000e\"\u0004\b\u0000\u0010\u000e*\u00020\n2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u0010H\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\u0011\"\u0016\u0010\u0000\u001a\u00020\u00018\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0002\u0010\u0003\"\u0016\u0010\u0004\u001a\u00020\u00018\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0003\"\u0016\u0010\u0006\u001a\u00020\u00078\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\b\u0010\u0003\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"CANCELLED", "Lkotlinx/coroutines/internal/Symbol;", "CANCELLED$annotations", "()V", "RESUMED", "RESUMED$annotations", "SEGMENT_SIZE", "", "SEGMENT_SIZE$annotations", "Semaphore", "Lkotlinx/coroutines/sync/Semaphore;", "permits", "acquiredPermits", "withPermit", ExifInterface.GPS_DIRECTION_TRUE, "action", "Lkotlin/Function0;", "(Lkotlinx/coroutines/sync/Semaphore;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class SemaphoreKt {
    private static final int SEGMENT_SIZE;
    private static final Symbol RESUMED = new Symbol("RESUMED");
    private static final Symbol CANCELLED = new Symbol("CANCELLED");

    private static /* synthetic */ void CANCELLED$annotations() {
    }

    private static /* synthetic */ void RESUMED$annotations() {
    }

    private static /* synthetic */ void SEGMENT_SIZE$annotations() {
    }

    public static final Semaphore Semaphore(int i, int i2) {
        return new SemaphoreImpl(i, i2);
    }

    public static /* synthetic */ Semaphore Semaphore$default(int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return Semaphore(i, i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object withPermit(Semaphore semaphore, Function0<? extends T> function0, Continuation<? super T> continuation) {
        SemaphoreKt$withPermit$1 semaphoreKt$withPermit$1;
        int i;
        try {
            if (continuation instanceof SemaphoreKt$withPermit$1) {
                semaphoreKt$withPermit$1 = (SemaphoreKt$withPermit$1) continuation;
                if ((semaphoreKt$withPermit$1.label & Integer.MIN_VALUE) != 0) {
                    semaphoreKt$withPermit$1.label -= Integer.MIN_VALUE;
                    Object obj = semaphoreKt$withPermit$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = semaphoreKt$withPermit$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        semaphoreKt$withPermit$1.L$0 = semaphore;
                        semaphoreKt$withPermit$1.L$1 = function0;
                        semaphoreKt$withPermit$1.label = 1;
                        if (semaphore.acquire(semaphoreKt$withPermit$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        function0 = (Function0) semaphoreKt$withPermit$1.L$1;
                        semaphore = (Semaphore) semaphoreKt$withPermit$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    }
                    return function0.invoke();
                }
            }
            return function0.invoke();
        } finally {
            InlineMarker.finallyStart(1);
            semaphore.release();
            InlineMarker.finallyEnd(1);
        }
        semaphoreKt$withPermit$1 = new SemaphoreKt$withPermit$1(continuation);
        Object obj2 = semaphoreKt$withPermit$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = semaphoreKt$withPermit$1.label;
        if (i != 0) {
        }
    }

    private static final Object withPermit$$forInline(Semaphore semaphore, Function0 function0, Continuation continuation) {
        InlineMarker.mark(0);
        semaphore.acquire(continuation);
        InlineMarker.mark(2);
        InlineMarker.mark(1);
        try {
            return function0.invoke();
        } finally {
            InlineMarker.finallyStart(1);
            semaphore.release();
            InlineMarker.finallyEnd(1);
        }
    }

    static {
        int systemProp$default;
        systemProp$default = SystemPropsKt__SystemProps_commonKt.systemProp$default("kotlinx.coroutines.semaphore.segmentSize", 16, 0, 0, 12, (Object) null);
        SEGMENT_SIZE = systemProp$default;
    }
}
