package kotlinx.coroutines.sync;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.internal.SegmentQueue;
import kotlinx.coroutines.internal.Symbol;

/* compiled from: Semaphore.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\n\u001a\u00020\tH\u0096@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\f\u001a\u00020\tH\u0082@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\u000bJ\r\u0010\r\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\tH\u0000¢\u0006\u0004\b\u0016\u0010\u0015J\u000f\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001c\u001a\u00020\u00048V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u000eR\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001d\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001e"}, d2 = {"Lkotlinx/coroutines/sync/SemaphoreImpl;", "Lkotlinx/coroutines/sync/Semaphore;", "Lkotlinx/coroutines/internal/SegmentQueue;", "Lkotlinx/coroutines/sync/SemaphoreSegment;", "", "permits", "acquiredPermits", "<init>", "(II)V", "", "acquire", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addToQueueAndSuspend", "incPermits", "()I", "", "id", "prev", "newSegment", "(JLkotlinx/coroutines/sync/SemaphoreSegment;)Lkotlinx/coroutines/sync/SemaphoreSegment;", "release", "()V", "resumeNextFromQueue$kotlinx_coroutines_core", "resumeNextFromQueue", "", "tryAcquire", "()Z", "getAvailablePermits", "availablePermits", "I", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
final class SemaphoreImpl extends SegmentQueue<SemaphoreSegment> implements Semaphore {
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

    /* JADX DEBUG: Method merged with bridge method */
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
    */
    final /* synthetic */ Object addToQueueAndSuspend(Continuation<? super Unit> continuation) {
        int i;
        int i2;
        Object result;
        Symbol symbol;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 0);
        CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        SemaphoreSegment access$getTail$p = access$getTail$p(this);
        long andIncrement = enqIdx$FU.getAndIncrement(this);
        i = SemaphoreKt.SEGMENT_SIZE;
        SemaphoreSegment access$getSegment = access$getSegment(this, access$getTail$p, andIncrement / i);
        i2 = SemaphoreKt.SEGMENT_SIZE;
        int i3 = (int) (andIncrement % i2);
        if (access$getSegment != null) {
            Object obj = access$getSegment.acquirers.get(i3);
            symbol = SemaphoreKt.RESUMED;
            if (obj != symbol && access$getSegment.acquirers.compareAndSet(i3, null, cancellableContinuationImpl2)) {
                cancellableContinuationImpl2.invokeOnCancellation(new CancelSemaphoreAcquisitionHandler(this, access$getSegment, i3));
                result = cancellableContinuationImpl.getResult();
                if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    DebugProbesKt.probeCoroutineSuspended(continuation);
                }
                return result;
            }
        }
        Unit unit = Unit.INSTANCE;
        Result.Companion companion = Result.Companion;
        cancellableContinuationImpl2.resumeWith(Result.m28constructorimpl(unit));
        result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
        }
        return result;
    }
}
