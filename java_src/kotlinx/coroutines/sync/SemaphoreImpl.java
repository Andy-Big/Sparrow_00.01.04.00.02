package kotlinx.coroutines.sync;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.internal.SegmentQueue;
import kotlinx.coroutines.internal.Symbol;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Semaphore.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\n\u001a\u00020\tH\u0096@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\f\u001a\u00020\tH\u0082@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\u000bJ\r\u0010\r\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\tH\u0000¢\u0006\u0004\b\u0016\u0010\u0015J\u000f\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001c\u001a\u00020\u00048V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u000eR\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001d\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001e"}, d2 = {"Lkotlinx/coroutines/sync/SemaphoreImpl;", "Lkotlinx/coroutines/sync/Semaphore;", "Lkotlinx/coroutines/internal/SegmentQueue;", "Lkotlinx/coroutines/sync/SemaphoreSegment;", "", "permits", "acquiredPermits", "<init>", "(II)V", "", "acquire", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addToQueueAndSuspend", "incPermits", "()I", "", "id", "prev", "newSegment", "(JLkotlinx/coroutines/sync/SemaphoreSegment;)Lkotlinx/coroutines/sync/SemaphoreSegment;", "release", "()V", "resumeNextFromQueue$kotlinx_coroutines_core", "resumeNextFromQueue", "", "tryAcquire", "()Z", "getAvailablePermits", "availablePermits", "I", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class SemaphoreImpl extends SegmentQueue<SemaphoreSegment> implements Semaphore {
    private volatile int _availablePermits;
    private volatile long deqIdx;
    volatile long enqIdx;
    private final int permits;
    private static final AtomicIntegerFieldUpdater _availablePermits$FU = AtomicIntegerFieldUpdater.newUpdater(SemaphoreImpl.class, "_availablePermits");
    static final AtomicLongFieldUpdater enqIdx$FU = AtomicLongFieldUpdater.newUpdater(SemaphoreImpl.class, "enqIdx");
    private static final AtomicLongFieldUpdater deqIdx$FU = AtomicLongFieldUpdater.newUpdater(SemaphoreImpl.class, "deqIdx");

    public static final /* synthetic */ SemaphoreSegment access$getSegment(SemaphoreImpl semaphoreImpl, SemaphoreSegment semaphoreSegment, long j) {
        return semaphoreImpl.getSegment(semaphoreSegment, j);
    }

    public static final /* synthetic */ SemaphoreSegment access$getTail$p(SemaphoreImpl semaphoreImpl) {
        return semaphoreImpl.getTail();
    }

    public SemaphoreImpl(int i, int i2) {
        this.permits = i;
        boolean z = true;
        if (!(i > 0)) {
            throw new IllegalArgumentException(("Semaphore should have at least 1 permit, but had " + this.permits).toString());
        }
        if (!((i2 < 0 || this.permits < i2) ? false : z)) {
            throw new IllegalArgumentException(("The number of acquired permits should be in 0.." + this.permits).toString());
        }
        this._availablePermits = this.permits - i2;
        this.enqIdx = 0L;
        this.deqIdx = 0L;
    }

    @Override // kotlinx.coroutines.internal.SegmentQueue
    public SemaphoreSegment newSegment(long j, SemaphoreSegment semaphoreSegment) {
        return new SemaphoreSegment(j, semaphoreSegment);
    }

    @Override // kotlinx.coroutines.sync.Semaphore
    public int getAvailablePermits() {
        return Math.max(this._availablePermits, 0);
    }

    @Override // kotlinx.coroutines.sync.Semaphore
    public Object acquire(Continuation<? super Unit> continuation) {
        if (_availablePermits$FU.getAndDecrement(this) > 0) {
            return Unit.INSTANCE;
        }
        return addToQueueAndSuspend(continuation);
    }

    @Override // kotlinx.coroutines.sync.Semaphore
    public void release() {
        if (incPermits() >= 0) {
            return;
        }
        resumeNextFromQueue$kotlinx_coroutines_core();
    }

    public final void resumeNextFromQueue$kotlinx_coroutines_core() {
        int i;
        int i2;
        Symbol symbol;
        Symbol symbol2;
        while (true) {
            long andIncrement = deqIdx$FU.getAndIncrement(this);
            i = SemaphoreKt.SEGMENT_SIZE;
            SemaphoreSegment segmentAndMoveHead = getSegmentAndMoveHead(getHead(), andIncrement / i);
            if (segmentAndMoveHead != null) {
                i2 = SemaphoreKt.SEGMENT_SIZE;
                symbol = SemaphoreKt.RESUMED;
                Object andSet = segmentAndMoveHead.acquirers.getAndSet((int) (andIncrement % i2), symbol);
                if (andSet == null) {
                    return;
                }
                symbol2 = SemaphoreKt.CANCELLED;
                if (andSet != symbol2) {
                    Unit unit = Unit.INSTANCE;
                    Result.Companion companion = Result.Companion;
                    ((CancellableContinuation) andSet).resumeWith(Result.m28constructorimpl(unit));
                    return;
                }
            }
        }
    }

    @Override // kotlinx.coroutines.sync.Semaphore
    public boolean tryAcquire() {
        int i;
        do {
            i = this._availablePermits;
            if (i <= 0) {
                return false;
            }
        } while (!_availablePermits$FU.compareAndSet(this, i, i - 1));
        return true;
    }

    public final int incPermits() {
        int i;
        do {
            i = this._availablePermits;
            if (!(i < this.permits)) {
                throw new IllegalStateException(("The number of released permits cannot be greater than " + this.permits).toString());
            }
        } while (!_availablePermits$FU.compareAndSet(this, i, i + 1));
        return i;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0065  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    final /* synthetic */ java.lang.Object addToQueueAndSuspend(kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r7 = this;
            kotlinx.coroutines.CancellableContinuationImpl r0 = new kotlinx.coroutines.CancellableContinuationImpl
            kotlin.coroutines.Continuation r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(r8)
            r2 = 0
            r0.<init>(r1, r2)
            r1 = r0
            kotlinx.coroutines.CancellableContinuation r1 = (kotlinx.coroutines.CancellableContinuation) r1
            kotlinx.coroutines.sync.SemaphoreSegment r2 = access$getTail$p(r7)
            java.util.concurrent.atomic.AtomicLongFieldUpdater r3 = kotlinx.coroutines.sync.SemaphoreImpl.enqIdx$FU
            long r3 = r3.getAndIncrement(r7)
            int r5 = kotlinx.coroutines.sync.SemaphoreKt.access$getSEGMENT_SIZE$p()
            long r5 = (long) r5
            long r5 = r3 / r5
            kotlinx.coroutines.sync.SemaphoreSegment r2 = access$getSegment(r7, r2, r5)
            int r5 = kotlinx.coroutines.sync.SemaphoreKt.access$getSEGMENT_SIZE$p()
            long r5 = (long) r5
            long r3 = r3 % r5
            int r3 = (int) r3
            if (r2 == 0) goto L4e
            java.util.concurrent.atomic.AtomicReferenceArray r4 = r2.acquirers
            java.lang.Object r4 = r4.get(r3)
            kotlinx.coroutines.internal.Symbol r5 = kotlinx.coroutines.sync.SemaphoreKt.access$getRESUMED$p()
            if (r4 == r5) goto L4e
            r4 = 0
            java.util.concurrent.atomic.AtomicReferenceArray r5 = r2.acquirers
            boolean r4 = r5.compareAndSet(r3, r4, r1)
            if (r4 != 0) goto L41
            goto L4e
        L41:
            kotlinx.coroutines.sync.CancelSemaphoreAcquisitionHandler r4 = new kotlinx.coroutines.sync.CancelSemaphoreAcquisitionHandler
            r4.<init>(r7, r2, r3)
            kotlinx.coroutines.CancelHandlerBase r4 = (kotlinx.coroutines.CancelHandlerBase) r4
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            r1.invokeOnCancellation(r4)
            goto L5b
        L4e:
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
            kotlin.Result$Companion r3 = kotlin.Result.Companion
            java.lang.Object r2 = kotlin.Result.m28constructorimpl(r2)
            r1.resumeWith(r2)
        L5b:
            java.lang.Object r0 = r0.getResult()
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r0 != r1) goto L68
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r8)
        L68:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.sync.SemaphoreImpl.addToQueueAndSuspend(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
