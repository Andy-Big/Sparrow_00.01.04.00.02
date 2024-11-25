package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.ContextScope;
import kotlinx.coroutines.internal.ScopeCoroutine;
import kotlinx.coroutines.intrinsics.UndispatchedKt;
/* compiled from: CoroutineScope.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\b\u001a\u0006\u0010\t\u001a\u00020\u0002\u001a@\u0010\n\u001a\u0002H\u000b\"\u0004\b\u0000\u0010\u000b2'\u0010\f\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000b0\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\r¢\u0006\u0002\b\u0010H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0011\u001a\u001e\u0010\u0012\u001a\u00020\u0013*\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u001a\u001c\u0010\u0012\u001a\u00020\u0013*\u00020\u00022\u0010\b\u0002\u0010\u0016\u001a\n\u0018\u00010\u0018j\u0004\u0018\u0001`\u0019\u001a\n\u0010\u001a\u001a\u00020\u0013*\u00020\u0002\u001a\u0015\u0010\u001b\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0086\u0002\"\u001b\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0000\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001c"}, d2 = {"isActive", "", "Lkotlinx/coroutines/CoroutineScope;", "isActive$annotations", "(Lkotlinx/coroutines/CoroutineScope;)V", "(Lkotlinx/coroutines/CoroutineScope;)Z", "CoroutineScope", "context", "Lkotlin/coroutines/CoroutineContext;", "MainScope", "coroutineScope", "R", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancel", "", "message", "", "cause", "", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "ensureActive", "plus", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class CoroutineScopeKt {
    public static /* synthetic */ void isActive$annotations(CoroutineScope coroutineScope) {
    }

    public static final CoroutineScope plus(CoroutineScope plus, CoroutineContext context) {
        Intrinsics.checkParameterIsNotNull(plus, "$this$plus");
        Intrinsics.checkParameterIsNotNull(context, "context");
        return new ContextScope(plus.getCoroutineContext().plus(context));
    }

    public static final CoroutineScope MainScope() {
        return new ContextScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain()));
    }

    public static final boolean isActive(CoroutineScope isActive) {
        Intrinsics.checkParameterIsNotNull(isActive, "$this$isActive");
        Job job = (Job) isActive.getCoroutineContext().get(Job.Key);
        if (job != null) {
            return job.isActive();
        }
        return true;
    }

    public static final <R> Object coroutineScope(Function2<? super CoroutineScope, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super R> continuation) {
        ScopeCoroutine scopeCoroutine = new ScopeCoroutine(continuation.getContext(), continuation);
        Object startUndispatchedOrReturn = UndispatchedKt.startUndispatchedOrReturn(scopeCoroutine, scopeCoroutine, function2);
        if (startUndispatchedOrReturn == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return startUndispatchedOrReturn;
    }

    public static final CoroutineScope CoroutineScope(CoroutineContext context) {
        CompletableJob Job$default;
        Intrinsics.checkParameterIsNotNull(context, "context");
        if (context.get(Job.Key) == null) {
            Job$default = JobKt__JobKt.Job$default((Job) null, 1, (Object) null);
            context = context.plus(Job$default);
        }
        return new ContextScope(context);
    }

    public static /* synthetic */ void cancel$default(CoroutineScope coroutineScope, CancellationException cancellationException, int i, Object obj) {
        if ((i & 1) != 0) {
            cancellationException = null;
        }
        cancel(coroutineScope, cancellationException);
    }

    public static final void cancel(CoroutineScope cancel, CancellationException cancellationException) {
        Intrinsics.checkParameterIsNotNull(cancel, "$this$cancel");
        Job job = (Job) cancel.getCoroutineContext().get(Job.Key);
        if (job == null) {
            throw new IllegalStateException(("Scope cannot be cancelled because it does not have a job: " + cancel).toString());
        }
        job.cancel(cancellationException);
    }

    public static final void cancel(CoroutineScope cancel, String message, Throwable th) {
        Intrinsics.checkParameterIsNotNull(cancel, "$this$cancel");
        Intrinsics.checkParameterIsNotNull(message, "message");
        cancel(cancel, ExceptionsKt.CancellationException(message, th));
    }

    public static /* synthetic */ void cancel$default(CoroutineScope coroutineScope, String str, Throwable th, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        cancel(coroutineScope, str, th);
    }

    public static final void ensureActive(CoroutineScope ensureActive) {
        Intrinsics.checkParameterIsNotNull(ensureActive, "$this$ensureActive");
        JobKt.ensureActive(ensureActive.getCoroutineContext());
    }
}
