package kotlinx.coroutines.internal;

import androidx.exifinterface.media.ExifInterface;
import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

/* compiled from: LockFreeTaskQueue.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\b\u0010\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00028\u0000¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\u0003¢\u0006\u0004\b\r\u0010\u000eJ-\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u0012\"\u0004\b\u0001\u0010\u000f2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0010¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0015\u0010\u0016J&\u0010\u0018\u001a\u0004\u0018\u00018\u00002\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00030\u0010H\u0086\b¢\u0006\u0004\b\u0018\u0010\u0019R\u0013\u0010\u001a\u001a\u00020\u00038F@\u0006¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u000eR\u0013\u0010\u001e\u001a\u00020\u001b8F@\u0006¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001f"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeTaskQueue;", "", ExifInterface.LONGITUDE_EAST, "", "singleConsumer", "<init>", "(Z)V", "element", "addLast", "(Ljava/lang/Object;)Z", "", "close", "()V", "isClosed", "()Z", "R", "Lkotlin/Function1;", "transform", "", "map", "(Lkotlin/jvm/functions/Function1;)Ljava/util/List;", "removeFirstOrNull", "()Ljava/lang/Object;", "predicate", "removeFirstOrNullIf", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "isEmpty", "", "getSize", "()I", "size", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public class LockFreeTaskQueue<E> {
    public static final /* synthetic */ AtomicReferenceFieldUpdater _cur$FU$internal = AtomicReferenceFieldUpdater.newUpdater(LockFreeTaskQueue.class, Object.class, "_cur$internal");
    public volatile /* synthetic */ Object _cur$internal;

    public LockFreeTaskQueue(boolean z) {
        this._cur$internal = new LockFreeTaskQueueCore(8, z);
    }

    public final boolean isEmpty() {
        return ((LockFreeTaskQueueCore) this._cur$internal).isEmpty();
    }

    public final int getSize() {
        return ((LockFreeTaskQueueCore) this._cur$internal).getSize();
    }

    public final <R> List<R> map(Function1<? super E, ? extends R> transform) {
        Intrinsics.checkParameterIsNotNull(transform, "transform");
        return ((LockFreeTaskQueueCore) this._cur$internal).map(transform);
    }

    public final boolean isClosed() {
        return ((LockFreeTaskQueueCore) this._cur$internal).isClosed();
    }

    public final void close() {
        while (true) {
            LockFreeTaskQueueCore lockFreeTaskQueueCore = (LockFreeTaskQueueCore) this._cur$internal;
            if (lockFreeTaskQueueCore.close()) {
                return;
            }
            _cur$FU$internal.compareAndSet(this, lockFreeTaskQueueCore, lockFreeTaskQueueCore.next());
        }
    }

    public final boolean addLast(E element) {
        Intrinsics.checkParameterIsNotNull(element, "element");
        while (true) {
            LockFreeTaskQueueCore lockFreeTaskQueueCore = (LockFreeTaskQueueCore) this._cur$internal;
            int addLast = lockFreeTaskQueueCore.addLast(element);
            if (addLast == 0) {
                return true;
            }
            if (addLast == 1) {
                _cur$FU$internal.compareAndSet(this, lockFreeTaskQueueCore, lockFreeTaskQueueCore.next());
            } else if (addLast == 2) {
                return false;
            }
        }
    }

    public final E removeFirstOrNull() {
        E e;
        Object obj;
        while (true) {
            LockFreeTaskQueueCore lockFreeTaskQueueCore = (LockFreeTaskQueueCore) this._cur$internal;
            while (true) {
                long j = lockFreeTaskQueueCore._state$internal;
                e = null;
                if ((LockFreeTaskQueueCore.FROZEN_MASK & j) != 0) {
                    e = (E) LockFreeTaskQueueCore.REMOVE_FROZEN;
                    break;
                }
                LockFreeTaskQueueCore.Companion companion = LockFreeTaskQueueCore.Companion;
                int i = (int) ((LockFreeTaskQueueCore.HEAD_MASK & j) >> 0);
                if ((((int) ((LockFreeTaskQueueCore.TAIL_MASK & j) >> 30)) & lockFreeTaskQueueCore.mask) == (lockFreeTaskQueueCore.mask & i)) {
                    break;
                }
                obj = lockFreeTaskQueueCore.array$internal.get(lockFreeTaskQueueCore.mask & i);
                if (obj == null) {
                    if (lockFreeTaskQueueCore.singleConsumer) {
                        break;
                    }
                } else if (!(obj instanceof LockFreeTaskQueueCore.Placeholder)) {
                    int i2 = (i + 1) & LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
                    if (LockFreeTaskQueueCore._state$FU$internal.compareAndSet(lockFreeTaskQueueCore, j, LockFreeTaskQueueCore.Companion.updateHead(j, i2))) {
                        lockFreeTaskQueueCore.array$internal.set(lockFreeTaskQueueCore.mask & i, null);
                        break;
                    } else if (lockFreeTaskQueueCore.singleConsumer) {
                        LockFreeTaskQueueCore lockFreeTaskQueueCore2 = lockFreeTaskQueueCore;
                        do {
                            lockFreeTaskQueueCore2 = lockFreeTaskQueueCore2.removeSlowPath(i, i2);
                        } while (lockFreeTaskQueueCore2 != null);
                        break;
                    }
                } else {
                    break;
                }
            }
            e = (E) obj;
            if (e != LockFreeTaskQueueCore.REMOVE_FROZEN) {
                return e;
            }
            _cur$FU$internal.compareAndSet(this, lockFreeTaskQueueCore, lockFreeTaskQueueCore.next());
        }
    }

    /* JADX DEBUG: Type inference failed for r9v0. Raw type applied. Possible types: ? super E */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x008f, code lost:
        r7 = (E) r9;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final E removeFirstOrNullIf(Function1<? super E, Boolean> predicate) {
        E e;
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        while (true) {
            LockFreeTaskQueueCore lockFreeTaskQueueCore = (LockFreeTaskQueueCore) this._cur$internal;
            while (true) {
                long j = lockFreeTaskQueueCore._state$internal;
                e = null;
                if ((LockFreeTaskQueueCore.FROZEN_MASK & j) != 0) {
                    e = (E) LockFreeTaskQueueCore.REMOVE_FROZEN;
                    break;
                }
                LockFreeTaskQueueCore.Companion companion = LockFreeTaskQueueCore.Companion;
                int i = (int) ((LockFreeTaskQueueCore.HEAD_MASK & j) >> 0);
                if ((((int) ((LockFreeTaskQueueCore.TAIL_MASK & j) >> 30)) & lockFreeTaskQueueCore.mask) == (lockFreeTaskQueueCore.mask & i)) {
                    break;
                }
                Object obj = (Object) lockFreeTaskQueueCore.array$internal.get(lockFreeTaskQueueCore.mask & i);
                if (obj == null) {
                    if (lockFreeTaskQueueCore.singleConsumer) {
                        break;
                    }
                } else if ((obj instanceof LockFreeTaskQueueCore.Placeholder) || !predicate.invoke(obj).booleanValue()) {
                    break;
                } else {
                    int i2 = (i + 1) & LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
                    if (LockFreeTaskQueueCore._state$FU$internal.compareAndSet(lockFreeTaskQueueCore, j, LockFreeTaskQueueCore.Companion.updateHead(j, i2))) {
                        lockFreeTaskQueueCore.array$internal.set(lockFreeTaskQueueCore.mask & i, null);
                        break;
                    } else if (lockFreeTaskQueueCore.singleConsumer) {
                        LockFreeTaskQueueCore lockFreeTaskQueueCore2 = lockFreeTaskQueueCore;
                        do {
                            lockFreeTaskQueueCore2 = lockFreeTaskQueueCore2.removeSlowPath(i, i2);
                        } while (lockFreeTaskQueueCore2 != null);
                        break;
                    }
                }
            }
            if (e != LockFreeTaskQueueCore.REMOVE_FROZEN) {
                return e;
            }
            _cur$FU$internal.compareAndSet(this, lockFreeTaskQueueCore, lockFreeTaskQueueCore.next());
        }
    }
}
