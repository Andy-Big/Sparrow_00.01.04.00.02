package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* compiled from: MainDispatchers.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0019\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\u001c\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\n\u0010\u0014\u001a\u00060\u0015j\u0002`\u0016H\u0016J\u001c\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000e2\n\u0010\u0014\u001a\u00060\u0015j\u0002`\u0016H\u0016J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u001c\u001a\u00020\u0011H\u0002J\u001e\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u000e2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\f0\u001fH\u0016J\b\u0010 \u001a\u00020\u0006H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\u00018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006!"}, d2 = {"Lkotlinx/coroutines/internal/MissingMainCoroutineDispatcher;", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "Lkotlinx/coroutines/Delay;", "cause", "", "errorHint", "", "(Ljava/lang/Throwable;Ljava/lang/String;)V", "immediate", "getImmediate", "()Lkotlinx/coroutines/MainCoroutineDispatcher;", "delay", "", "time", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispatch", "", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "invokeOnTimeout", "Lkotlinx/coroutines/DisposableHandle;", "timeMillis", "isDispatchNeeded", "", "missing", "scheduleResumeAfterDelay", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "toString", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
final class MissingMainCoroutineDispatcher extends MainCoroutineDispatcher implements Delay {
    private final Throwable cause;
    private final String errorHint;

    @Override // kotlinx.coroutines.Delay
    /* renamed from: scheduleResumeAfterDelay  reason: collision with other method in class */
    public /* bridge */ /* synthetic */ void mo1362scheduleResumeAfterDelay(long j, CancellableContinuation cancellableContinuation) {
        scheduleResumeAfterDelay(j, (CancellableContinuation<? super Unit>) cancellableContinuation);
    }

    public /* synthetic */ MissingMainCoroutineDispatcher(Throwable th, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(th, (i & 2) != 0 ? null : str);
    }

    public MissingMainCoroutineDispatcher(Throwable th, String str) {
        this.cause = th;
        this.errorHint = str;
    }

    @Override // kotlinx.coroutines.MainCoroutineDispatcher
    public MainCoroutineDispatcher getImmediate() {
        return this;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public boolean isDispatchNeeded(CoroutineContext context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        missing();
        throw null;
    }

    @Override // kotlinx.coroutines.Delay
    public Object delay(long j, Continuation<? super Unit> continuation) {
        missing();
        throw null;
    }

    @Override // kotlinx.coroutines.Delay
    public DisposableHandle invokeOnTimeout(long j, Runnable block) {
        Intrinsics.checkParameterIsNotNull(block, "block");
        missing();
        throw null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Possible override for method kotlinx.coroutines.CoroutineDispatcher.dispatch(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;)V */
    @Override // kotlinx.coroutines.CoroutineDispatcher
    /* renamed from: dispatch */
    public Void mo1361dispatch(CoroutineContext context, Runnable block) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(block, "block");
        missing();
        throw null;
    }

    /* JADX DEBUG: Possible override for method kotlinx.coroutines.Delay.scheduleResumeAfterDelay(JLkotlinx/coroutines/CancellableContinuation;)V */
    public Void scheduleResumeAfterDelay(long j, CancellableContinuation<? super Unit> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "continuation");
        missing();
        throw null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0023, code lost:
        if (r1 != null) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Void missing() {
        String str;
        if (this.cause == null) {
            throw new IllegalStateException("Module with the Main dispatcher is missing. Add dependency providing the Main dispatcher, e.g. 'kotlinx-coroutines-android'");
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Module with the Main dispatcher had failed to initialize");
        String str2 = this.errorHint;
        if (str2 != null) {
            str = ". " + str2;
        }
        str = "";
        sb.append((Object) str);
        throw new IllegalStateException(sb.toString(), this.cause);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("Main[missing");
        if (this.cause != null) {
            str = ", cause=" + this.cause;
        } else {
            str = "";
        }
        sb.append(str);
        sb.append(']');
        return sb.toString();
    }
}
