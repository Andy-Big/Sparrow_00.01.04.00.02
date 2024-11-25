package kotlinx.coroutines.sync;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.Metadata;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.Symbol;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Semaphore.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ,\u0010\u000f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\fH\u0086\b¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0011\u001a\u0004\u0018\u00010\f2\u0006\u0010\b\u001a\u00020\u0007H\u0086\b¢\u0006\u0004\b\u0011\u0010\u0012J$\u0010\u0013\u001a\u0004\u0018\u00010\f2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\fH\u0086\b¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\t8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001b"}, d2 = {"Lkotlinx/coroutines/sync/SemaphoreSegment;", "Lkotlinx/coroutines/internal/Segment;", "", "id", "prev", "<init>", "(JLkotlinx/coroutines/sync/SemaphoreSegment;)V", "", "index", "", "cancel", "(I)Z", "", "expected", "value", "cas", "(ILjava/lang/Object;Ljava/lang/Object;)Z", "get", "(I)Ljava/lang/Object;", "getAndSet", "(ILjava/lang/Object;)Ljava/lang/Object;", "", "toString", "()Ljava/lang/String;", "getRemoved", "()Z", "removed", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class SemaphoreSegment extends Segment<SemaphoreSegment> {
    private static final AtomicIntegerFieldUpdater cancelledSlots$FU = AtomicIntegerFieldUpdater.newUpdater(SemaphoreSegment.class, "cancelledSlots");
    AtomicReferenceArray acquirers;
    private volatile int cancelledSlots;

    public SemaphoreSegment(long j, SemaphoreSegment semaphoreSegment) {
        super(j, semaphoreSegment);
        int i;
        i = SemaphoreKt.SEGMENT_SIZE;
        this.acquirers = new AtomicReferenceArray(i);
        this.cancelledSlots = 0;
    }

    @Override // kotlinx.coroutines.internal.Segment
    public boolean getRemoved() {
        int i;
        int i2 = this.cancelledSlots;
        i = SemaphoreKt.SEGMENT_SIZE;
        return i2 == i;
    }

    public final Object get(int i) {
        return this.acquirers.get(i);
    }

    public final boolean cas(int i, Object obj, Object obj2) {
        return this.acquirers.compareAndSet(i, obj, obj2);
    }

    public final Object getAndSet(int i, Object obj) {
        return this.acquirers.getAndSet(i, obj);
    }

    public final boolean cancel(int i) {
        Symbol symbol;
        Symbol symbol2;
        int i2;
        symbol = SemaphoreKt.CANCELLED;
        Object andSet = this.acquirers.getAndSet(i, symbol);
        symbol2 = SemaphoreKt.RESUMED;
        boolean z = andSet != symbol2;
        int incrementAndGet = cancelledSlots$FU.incrementAndGet(this);
        i2 = SemaphoreKt.SEGMENT_SIZE;
        if (incrementAndGet == i2) {
            remove();
        }
        return z;
    }

    public String toString() {
        return "SemaphoreSegment[id=" + getId() + ", hashCode=" + hashCode() + ']';
    }
}
