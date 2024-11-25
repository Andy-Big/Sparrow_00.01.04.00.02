package kotlinx.coroutines.sync;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
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
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <T> java.lang.Object withLock(kotlinx.coroutines.sync.Mutex r4, java.lang.Object r5, kotlin.jvm.functions.Function0<? extends T> r6, kotlin.coroutines.Continuation<? super T> r7) {
        /*
            boolean r0 = r7 instanceof kotlinx.coroutines.sync.MutexKt$withLock$1
            if (r0 == 0) goto L14
            r0 = r7
            kotlinx.coroutines.sync.MutexKt$withLock$1 r0 = (kotlinx.coroutines.sync.MutexKt$withLock$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            kotlinx.coroutines.sync.MutexKt$withLock$1 r0 = new kotlinx.coroutines.sync.MutexKt$withLock$1
            r0.<init>(r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r4 = r0.L$2
            r6 = r4
            kotlin.jvm.functions.Function0 r6 = (kotlin.jvm.functions.Function0) r6
            java.lang.Object r5 = r0.L$1
            java.lang.Object r4 = r0.L$0
            kotlinx.coroutines.sync.Mutex r4 = (kotlinx.coroutines.sync.Mutex) r4
            kotlin.ResultKt.throwOnFailure(r7)
            goto L4f
        L35:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3d:
            kotlin.ResultKt.throwOnFailure(r7)
            r0.L$0 = r4
            r0.L$1 = r5
            r0.L$2 = r6
            r0.label = r3
            java.lang.Object r7 = r4.lock(r5, r0)
            if (r7 != r1) goto L4f
            return r1
        L4f:
            java.lang.Object r6 = r6.invoke()     // Catch: java.lang.Throwable -> L5d
            kotlin.jvm.internal.InlineMarker.finallyStart(r3)
            r4.unlock(r5)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r3)
            return r6
        L5d:
            r6 = move-exception
            kotlin.jvm.internal.InlineMarker.finallyStart(r3)
            r4.unlock(r5)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r3)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.sync.MutexKt.withLock(kotlinx.coroutines.sync.Mutex, java.lang.Object, kotlin.jvm.functions.Function0, kotlin.coroutines.Continuation):java.lang.Object");
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
