package kotlinx.coroutines.internal;

import androidx.exifinterface.media.ExifInterface;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.Segment;
/* compiled from: SegmentQueue.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\f\b \u0018\u0000*\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u00012\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J!\u0010\t\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\b\u001a\u00020\u0007H\u0004¢\u0006\u0004\b\t\u0010\nJ!\u0010\u000b\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\b\u001a\u00020\u0007H\u0004¢\u0006\u0004\b\u000b\u0010\nJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\r2\u0006\u0010\f\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0010\u0010\u000fJ#\u0010\u0012\u001a\u00028\u00002\u0006\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00018\u0000H&¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0016\u001a\u00028\u00008D@\u0004X\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0018\u001a\u00028\u00008D@\u0004X\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0015¨\u0006\u0019"}, d2 = {"Lkotlinx/coroutines/internal/SegmentQueue;", "Lkotlinx/coroutines/internal/Segment;", ExifInterface.LATITUDE_SOUTH, "", "<init>", "()V", "startFrom", "", "id", "getSegment", "(Lkotlinx/coroutines/internal/Segment;J)Lkotlinx/coroutines/internal/Segment;", "getSegmentAndMoveHead", "new", "", "moveHeadForward", "(Lkotlinx/coroutines/internal/Segment;)V", "moveTailForward", "prev", "newSegment", "(JLkotlinx/coroutines/internal/Segment;)Lkotlinx/coroutines/internal/Segment;", "getHead", "()Lkotlinx/coroutines/internal/Segment;", "head", "getTail", "tail", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public abstract class SegmentQueue<S extends Segment<S>> {
    private static final AtomicReferenceFieldUpdater _head$FU = AtomicReferenceFieldUpdater.newUpdater(SegmentQueue.class, Object.class, "_head");
    private static final AtomicReferenceFieldUpdater _tail$FU = AtomicReferenceFieldUpdater.newUpdater(SegmentQueue.class, Object.class, "_tail");
    private volatile Object _head;
    private volatile Object _tail;

    public abstract S newSegment(long j, S s);

    public SegmentQueue() {
        Segment newSegment$default = newSegment$default(this, 0L, null, 2, null);
        this._head = newSegment$default;
        this._tail = newSegment$default;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final S getHead() {
        return (S) this._head;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final S getTail() {
        return (S) this._tail;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Segment newSegment$default(SegmentQueue segmentQueue, long j, Segment segment, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                segment = null;
            }
            return segmentQueue.newSegment(j, segment);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: newSegment");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public final S getSegment(S startFrom, long j) {
        Intrinsics.checkParameterIsNotNull(startFrom, "startFrom");
        while (startFrom.getId() < j) {
            Object next = startFrom.getNext();
            if (next == null) {
                next = newSegment(startFrom.getId() + 1, startFrom);
                if (startFrom.casNext(null, next)) {
                    if (startFrom.getRemoved()) {
                        startFrom.remove();
                    }
                    moveTailForward(next);
                } else {
                    next = startFrom.getNext();
                    if (next == null) {
                        Intrinsics.throwNpe();
                    }
                }
            }
            startFrom = (S) next;
        }
        if (startFrom.getId() != j) {
            return null;
        }
        return startFrom;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final S getSegmentAndMoveHead(S startFrom, long j) {
        Intrinsics.checkParameterIsNotNull(startFrom, "startFrom");
        if (startFrom.getId() == j) {
            return startFrom;
        }
        S segment = getSegment(startFrom, j);
        if (segment != null) {
            moveHeadForward(segment);
            return segment;
        }
        return null;
    }

    private final void moveHeadForward(S s) {
        Segment segment;
        do {
            segment = (Segment) this._head;
            if (segment.getId() > s.getId()) {
                return;
            }
        } while (!_head$FU.compareAndSet(this, segment, s));
        s.prev = null;
    }

    private final void moveTailForward(S s) {
        Segment segment;
        do {
            segment = (Segment) this._tail;
            if (segment.getId() > s.getId()) {
                return;
            }
        } while (!_tail$FU.compareAndSet(this, segment, s));
    }
}
