package kotlinx.coroutines.internal;

import com.rigol.scope.utilities.ViewUtil;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ThreadContext.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001J\u0006\u0010\u0010\u001a\u00020\u000eJ\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001R\u0018\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lkotlinx/coroutines/internal/ThreadState;", "", "context", "Lkotlin/coroutines/CoroutineContext;", "n", "", "(Lkotlin/coroutines/CoroutineContext;I)V", ViewUtil.KEY_A, "", "[Ljava/lang/Object;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "i", "append", "", "value", "start", "take", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class ThreadState {
    private Object[] a;
    private final CoroutineContext context;
    private int i;

    public ThreadState(CoroutineContext context, int i) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.context = context;
        this.a = new Object[i];
    }

    public final CoroutineContext getContext() {
        return this.context;
    }

    public final void append(Object obj) {
        Object[] objArr = this.a;
        int i = this.i;
        this.i = i + 1;
        objArr[i] = obj;
    }

    public final Object take() {
        Object[] objArr = this.a;
        int i = this.i;
        this.i = i + 1;
        return objArr[i];
    }

    public final void start() {
        this.i = 0;
    }
}
