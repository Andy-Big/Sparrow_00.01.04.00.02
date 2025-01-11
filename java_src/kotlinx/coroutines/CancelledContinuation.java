package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CompletedExceptionally.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B%\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\r\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lkotlinx/coroutines/CancelledContinuation;", "Lkotlinx/coroutines/CompletedExceptionally;", "Lkotlin/coroutines/Continuation;", "continuation", "", "cause", "", "handled", "<init>", "(Lkotlin/coroutines/Continuation;Ljava/lang/Throwable;Z)V", "makeResumed", "()Z", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class CancelledContinuation extends CompletedExceptionally {
    private static final AtomicIntegerFieldUpdater _resumed$FU = AtomicIntegerFieldUpdater.newUpdater(CancelledContinuation.class, "_resumed");
    private volatile int _resumed;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public CancelledContinuation(Continuation<?> continuation, Throwable th, boolean z) {
        super(th, z);
        Intrinsics.checkParameterIsNotNull(continuation, "continuation");
        if (th == null) {
            th = new CancellationException("Continuation " + continuation + " was cancelled normally");
        }
        this._resumed = 0;
    }

    public final boolean makeResumed() {
        return _resumed$FU.compareAndSet(this, 0, 1);
    }
}
