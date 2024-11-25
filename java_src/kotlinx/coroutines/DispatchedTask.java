package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.ThreadContextKt;
import kotlinx.coroutines.scheduling.Task;
import kotlinx.coroutines.scheduling.TaskContext;
/* compiled from: Dispatched.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u000e\b \u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00060\u0002j\u0002`\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001f\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0010¢\u0006\u0002\b\u0011J\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00102\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0000¢\u0006\u0002\b\u0013J\u001f\u0010\u0014\u001a\u0002H\u0001\"\u0004\b\u0001\u0010\u00012\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0010¢\u0006\u0004\b\u0015\u0010\u0016J!\u0010\u0017\u001a\u00020\f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00102\b\u0010\u0019\u001a\u0004\u0018\u00010\u0010H\u0000¢\u0006\u0002\b\u001aJ\u0006\u0010\u001b\u001a\u00020\fJ\u000f\u0010\u001c\u001a\u0004\u0018\u00010\u000eH ¢\u0006\u0002\b\u001dR\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bX \u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lkotlinx/coroutines/DispatchedTask;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/scheduling/Task;", "Lkotlinx/coroutines/SchedulerTask;", "resumeMode", "", "(I)V", "delegate", "Lkotlin/coroutines/Continuation;", "getDelegate$kotlinx_coroutines_core", "()Lkotlin/coroutines/Continuation;", "cancelResult", "", "state", "", "cause", "", "cancelResult$kotlinx_coroutines_core", "getExceptionalResult", "getExceptionalResult$kotlinx_coroutines_core", "getSuccessfulResult", "getSuccessfulResult$kotlinx_coroutines_core", "(Ljava/lang/Object;)Ljava/lang/Object;", "handleFatalException", "exception", "finallyException", "handleFatalException$kotlinx_coroutines_core", "run", "takeState", "takeState$kotlinx_coroutines_core", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public abstract class DispatchedTask<T> extends Task {
    public int resumeMode;

    public void cancelResult$kotlinx_coroutines_core(Object obj, Throwable cause) {
        Intrinsics.checkParameterIsNotNull(cause, "cause");
    }

    public abstract Continuation<T> getDelegate$kotlinx_coroutines_core();

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T getSuccessfulResult$kotlinx_coroutines_core(Object obj) {
        return obj;
    }

    public abstract Object takeState$kotlinx_coroutines_core();

    public DispatchedTask(int i) {
        this.resumeMode = i;
    }

    public final Throwable getExceptionalResult$kotlinx_coroutines_core(Object obj) {
        if (!(obj instanceof CompletedExceptionally)) {
            obj = null;
        }
        CompletedExceptionally completedExceptionally = (CompletedExceptionally) obj;
        if (completedExceptionally != null) {
            return completedExceptionally.cause;
        }
        return null;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object m28constructorimpl;
        Object m28constructorimpl2;
        TaskContext taskContext = this.taskContext;
        Throwable th = null;
        try {
            Continuation<T> delegate$kotlinx_coroutines_core = getDelegate$kotlinx_coroutines_core();
            if (delegate$kotlinx_coroutines_core == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.DispatchedContinuation<T>");
            }
            DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) delegate$kotlinx_coroutines_core;
            Continuation<T> continuation = dispatchedContinuation.continuation;
            CoroutineContext context = continuation.getContext();
            Object takeState$kotlinx_coroutines_core = takeState$kotlinx_coroutines_core();
            Object updateThreadContext = ThreadContextKt.updateThreadContext(context, dispatchedContinuation.countOrElement);
            Throwable exceptionalResult$kotlinx_coroutines_core = getExceptionalResult$kotlinx_coroutines_core(takeState$kotlinx_coroutines_core);
            Job job = ResumeModeKt.isCancellableMode(this.resumeMode) ? (Job) context.get(Job.Key) : null;
            if (exceptionalResult$kotlinx_coroutines_core == null && job != null && !job.isActive()) {
                CancellationException cancellationException = job.getCancellationException();
                cancelResult$kotlinx_coroutines_core(takeState$kotlinx_coroutines_core, cancellationException);
                Result.Companion companion = Result.Companion;
                continuation.resumeWith(Result.m28constructorimpl(ResultKt.createFailure(StackTraceRecoveryKt.recoverStackTrace(cancellationException, continuation))));
            } else if (exceptionalResult$kotlinx_coroutines_core == null) {
                T successfulResult$kotlinx_coroutines_core = getSuccessfulResult$kotlinx_coroutines_core(takeState$kotlinx_coroutines_core);
                Result.Companion companion2 = Result.Companion;
                continuation.resumeWith(Result.m28constructorimpl(successfulResult$kotlinx_coroutines_core));
            } else {
                Result.Companion companion3 = Result.Companion;
                continuation.resumeWith(Result.m28constructorimpl(ResultKt.createFailure(StackTraceRecoveryKt.recoverStackTrace(exceptionalResult$kotlinx_coroutines_core, continuation))));
            }
            Unit unit = Unit.INSTANCE;
            ThreadContextKt.restoreThreadContext(context, updateThreadContext);
            try {
                Result.Companion companion4 = Result.Companion;
                DispatchedTask<T> dispatchedTask = this;
                taskContext.afterTask();
                m28constructorimpl2 = Result.m28constructorimpl(Unit.INSTANCE);
            } catch (Throwable th2) {
                Result.Companion companion5 = Result.Companion;
                m28constructorimpl2 = Result.m28constructorimpl(ResultKt.createFailure(th2));
            }
            handleFatalException$kotlinx_coroutines_core(th, Result.m31exceptionOrNullimpl(m28constructorimpl2));
        } catch (Throwable th3) {
            try {
                Result.Companion companion6 = Result.Companion;
                DispatchedTask<T> dispatchedTask2 = this;
                taskContext.afterTask();
                m28constructorimpl = Result.m28constructorimpl(Unit.INSTANCE);
            } catch (Throwable th4) {
                Result.Companion companion7 = Result.Companion;
                m28constructorimpl = Result.m28constructorimpl(ResultKt.createFailure(th4));
            }
            handleFatalException$kotlinx_coroutines_core(th3, Result.m31exceptionOrNullimpl(m28constructorimpl));
        }
    }

    public final void handleFatalException$kotlinx_coroutines_core(Throwable th, Throwable th2) {
        if (th == null && th2 == null) {
            return;
        }
        if (th != null && th2 != null) {
            kotlin.ExceptionsKt.addSuppressed(th, th2);
        }
        if (th == null) {
            th = th2;
        }
        String str = "Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers";
        if (th == null) {
            Intrinsics.throwNpe();
        }
        CoroutineExceptionHandlerKt.handleCoroutineException(getDelegate$kotlinx_coroutines_core().getContext(), new CoroutinesInternalError(str, th));
    }
}
