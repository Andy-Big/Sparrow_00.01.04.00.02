package kotlinx.coroutines.sync;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.internal.Symbol;

/* compiled from: Mutex.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0016\u001a5\u0010\u0017\u001a\u0002H\u0018\"\u0004\b\u0000\u0010\u0018*\u00020\u00142\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u00180\u001cH\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\u001d\"\u0016\u0010\u0000\u001a\u00020\u00018\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0002\u0010\u0003\"\u0016\u0010\u0004\u001a\u00020\u00018\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0003\"\u0016\u0010\u0006\u001a\u00020\u00078\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\b\u0010\u0003\"\u0016\u0010\t\u001a\u00020\u00078\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\n\u0010\u0003\"\u0016\u0010\u000b\u001a\u00020\u00078\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\f\u0010\u0003\"\u0016\u0010\r\u001a\u00020\u00078\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u000e\u0010\u0003\"\u0016\u0010\u000f\u001a\u00020\u00078\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0010\u0010\u0003\"\u0016\u0010\u0011\u001a\u00020\u00078\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0012\u0010\u0003\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001e"}, d2 = {"EMPTY_LOCKED", "Lkotlinx/coroutines/sync/Empty;", "EMPTY_LOCKED$annotations", "()V", "EMPTY_UNLOCKED", "EMPTY_UNLOCKED$annotations", "ENQUEUE_FAIL", "Lkotlinx/coroutines/internal/Symbol;", "ENQUEUE_FAIL$annotations", "LOCKED", "LOCKED$annotations", "LOCK_FAIL", "LOCK_FAIL$annotations", "SELECT_SUCCESS", "SELECT_SUCCESS$annotations", "UNLOCKED", "UNLOCKED$annotations", "UNLOCK_FAIL", "UNLOCK_FAIL$annotations", "Mutex", "Lkotlinx/coroutines/sync/Mutex;", "locked", "", "withLock", ExifInterface.GPS_DIRECTION_TRUE, "owner", "", "action", "Lkotlin/Function0;", "(Lkotlinx/coroutines/sync/Mutex;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class MutexKt {
    private static final Symbol LOCK_FAIL = new Symbol("LOCK_FAIL");
    private static final Symbol ENQUEUE_FAIL = new Symbol("ENQUEUE_FAIL");
    private static final Symbol UNLOCK_FAIL = new Symbol("UNLOCK_FAIL");
    private static final Symbol SELECT_SUCCESS = new Symbol("SELECT_SUCCESS");
    private static final Symbol LOCKED = new Symbol("LOCKED");
    private static final Symbol UNLOCKED = new Symbol("UNLOCKED");
    private static final Empty EMPTY_LOCKED = new Empty(LOCKED);
    private static final Empty EMPTY_UNLOCKED = new Empty(UNLOCKED);

    private static /* synthetic */ void EMPTY_LOCKED$annotations() {
    }

    private static /* synthetic */ void EMPTY_UNLOCKED$annotations() {
    }

    private static /* synthetic */ void ENQUEUE_FAIL$annotations() {
    }

    private static /* synthetic */ void LOCKED$annotations() {
    }

    private static /* synthetic */ void LOCK_FAIL$annotations() {
    }

    private static /* synthetic */ void SELECT_SUCCESS$annotations() {
    }

    private static /* synthetic */ void UNLOCKED$annotations() {
    }

    private static /* synthetic */ void UNLOCK_FAIL$annotations() {
    }

    public static /* synthetic */ Mutex Mutex$default(boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return Mutex(z);
    }

    public static final Mutex Mutex(boolean z) {
        return new MutexImpl(z);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object withLock(Mutex mutex, Object obj, Function0<? extends T> function0, Continuation<? super T> continuation) {
        MutexKt$withLock$1 mutexKt$withLock$1;
        int i;
        try {
            if (continuation instanceof MutexKt$withLock$1) {
                mutexKt$withLock$1 = (MutexKt$withLock$1) continuation;
                if ((mutexKt$withLock$1.label & Integer.MIN_VALUE) != 0) {
                    mutexKt$withLock$1.label -= Integer.MIN_VALUE;
                    Object obj2 = mutexKt$withLock$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = mutexKt$withLock$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj2);
                        mutexKt$withLock$1.L$0 = mutex;
                        mutexKt$withLock$1.L$1 = obj;
                        mutexKt$withLock$1.L$2 = function0;
                        mutexKt$withLock$1.label = 1;
                        if (mutex.lock(obj, mutexKt$withLock$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        function0 = (Function0) mutexKt$withLock$1.L$2;
                        obj = mutexKt$withLock$1.L$1;
                        mutex = (Mutex) mutexKt$withLock$1.L$0;
                        ResultKt.throwOnFailure(obj2);
                    }
                    return function0.invoke();
                }
            }
            return function0.invoke();
        } finally {
            InlineMarker.finallyStart(1);
            mutex.unlock(obj);
            InlineMarker.finallyEnd(1);
        }
        mutexKt$withLock$1 = new MutexKt$withLock$1(continuation);
        Object obj22 = mutexKt$withLock$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = mutexKt$withLock$1.label;
        if (i != 0) {
        }
    }

    private static final Object withLock$$forInline(Mutex mutex, Object obj, Function0 function0, Continuation continuation) {
        InlineMarker.mark(0);
        mutex.lock(obj, continuation);
        InlineMarker.mark(2);
        InlineMarker.mark(1);
        try {
            return function0.invoke();
        } finally {
            InlineMarker.finallyStart(1);
            mutex.unlock(obj);
            InlineMarker.finallyEnd(1);
        }
    }

    public static /* synthetic */ Object withLock$default(Mutex mutex, Object obj, Function0 function0, Continuation continuation, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = null;
        }
        InlineMarker.mark(0);
        mutex.lock(obj, continuation);
        InlineMarker.mark(2);
        InlineMarker.mark(1);
        try {
            return function0.invoke();
        } finally {
            InlineMarker.finallyStart(1);
            mutex.unlock(obj);
            InlineMarker.finallyEnd(1);
        }
    }
}
