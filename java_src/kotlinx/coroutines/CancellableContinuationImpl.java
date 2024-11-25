package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import com.sun.mail.imap.IMAPStore;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
/* compiled from: CancellableContinuationImpl.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0011\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u00032\u00060\u0004j\u0002`\u0005B\u001d\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J!\u0010\u0019\u001a\u00020\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0010¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\fH\u0016¢\u0006\u0004\b\u001b\u0010\u0010J\u0017\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010#\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020!H\u0016¢\u0006\u0004\b#\u0010$J\u0011\u0010%\u001a\u0004\u0018\u00010\fH\u0001¢\u0006\u0004\b%\u0010&J\u0017\u0010)\u001a\n\u0018\u00010'j\u0004\u0018\u0001`(H\u0016¢\u0006\u0004\b)\u0010*J\u001f\u0010-\u001a\u00028\u0001\"\u0004\b\u0001\u0010\u00012\b\u0010\u0016\u001a\u0004\u0018\u00010\fH\u0010¢\u0006\u0004\b+\u0010,J\u000f\u0010.\u001a\u00020\u000eH\u0016¢\u0006\u0004\b.\u0010 J\u000f\u0010/\u001a\u00020\u000eH\u0002¢\u0006\u0004\b/\u0010 J\u001e\u00102\u001a\u00020\u000e2\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u000e00H\u0082\b¢\u0006\u0004\b2\u00103J8\u00109\u001a\u00020\u000e2'\u00108\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0011¢\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u000e04j\u0002`7H\u0016¢\u0006\u0004\b9\u0010:J8\u0010<\u001a\u00020;2'\u00108\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0011¢\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u000e04j\u0002`7H\u0002¢\u0006\u0004\b<\u0010=JB\u0010>\u001a\u00020\u000e2'\u00108\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0011¢\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u000e04j\u0002`72\b\u0010\u0016\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b>\u0010?J\u000f\u0010A\u001a\u00020@H\u0014¢\u0006\u0004\bA\u0010BJ:\u0010E\u001a\u00020\u000e2\u0006\u0010C\u001a\u00028\u00002!\u0010D\u001a\u001d\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u000e04H\u0016¢\u0006\u0004\bE\u0010FJ#\u0010H\u001a\u0004\u0018\u00010G2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\bH\u0010IJ \u0010L\u001a\u00020\u000e2\f\u0010K\u001a\b\u0012\u0004\u0012\u00028\u00000JH\u0016ø\u0001\u0000¢\u0006\u0004\bL\u0010\u0010J!\u0010P\u001a\u0004\u0018\u00010G2\u0006\u0010M\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\bH\u0000¢\u0006\u0004\bN\u0010OJ\u0011\u0010R\u001a\u0004\u0018\u00010\fH\u0010¢\u0006\u0004\bQ\u0010&J\u000f\u0010S\u001a\u00020@H\u0016¢\u0006\u0004\bS\u0010BJ\u000f\u0010T\u001a\u00020\u0013H\u0002¢\u0006\u0004\bT\u0010UJ#\u0010T\u001a\u0004\u0018\u00010\f2\u0006\u0010C\u001a\u00028\u00002\b\u0010V\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\bT\u0010WJ\u0019\u0010X\u001a\u0004\u0018\u00010\f2\u0006\u0010M\u001a\u00020\u0011H\u0016¢\u0006\u0004\bX\u0010YJ\u000f\u0010Z\u001a\u00020\u0013H\u0002¢\u0006\u0004\bZ\u0010UJ\u001b\u0010\\\u001a\u00020\u000e*\u00020[2\u0006\u0010C\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\\\u0010]J\u001b\u0010^\u001a\u00020\u000e*\u00020[2\u0006\u0010M\u001a\u00020\u0011H\u0016¢\u0006\u0004\b^\u0010_R\u001e\u0010b\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u00058V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b`\u0010aR\u001c\u0010d\u001a\u00020c8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\bd\u0010e\u001a\u0004\bf\u0010gR\"\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00068\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0007\u0010h\u001a\u0004\bi\u0010jR\u0016\u0010k\u001a\u00020\u00138V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\bk\u0010UR\u0016\u0010l\u001a\u00020\u00138V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\bl\u0010UR\u0016\u0010m\u001a\u00020\u00138V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\bm\u0010UR\u0018\u0010o\u001a\u0004\u0018\u00010n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bo\u0010pR\u0018\u0010\u0016\u001a\u0004\u0018\u00010\f8@@\u0000X\u0080\u0004¢\u0006\u0006\u001a\u0004\bq\u0010&\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006r"}, d2 = {"Lkotlinx/coroutines/CancellableContinuationImpl;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/DispatchedTask;", "Lkotlinx/coroutines/CancellableContinuation;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "Lkotlin/coroutines/Continuation;", "delegate", "", "resumeMode", "<init>", "(Lkotlin/coroutines/Continuation;I)V", "", "proposedUpdate", "", "alreadyResumedError", "(Ljava/lang/Object;)V", "", "cause", "", "cancel", "(Ljava/lang/Throwable;)Z", "state", "cancelResult$kotlinx_coroutines_core", "(Ljava/lang/Object;Ljava/lang/Throwable;)V", "cancelResult", "token", "completeResume", "mode", "dispatchResume", "(I)V", "disposeParentHandle", "()V", "Lkotlinx/coroutines/Job;", "parent", "getContinuationCancellationCause", "(Lkotlinx/coroutines/Job;)Ljava/lang/Throwable;", "getResult", "()Ljava/lang/Object;", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "getStackTraceElement", "()Ljava/lang/StackTraceElement;", "getSuccessfulResult$kotlinx_coroutines_core", "(Ljava/lang/Object;)Ljava/lang/Object;", "getSuccessfulResult", "initCancellability", "installParentCancellationHandler", "Lkotlin/Function0;", "block", "invokeHandlerSafely", "(Lkotlin/jvm/functions/Function0;)V", "Lkotlin/Function1;", "Lkotlin/ParameterName;", IMAPStore.ID_NAME, "Lkotlinx/coroutines/CompletionHandler;", "handler", "invokeOnCancellation", "(Lkotlin/jvm/functions/Function1;)V", "Lkotlinx/coroutines/CancelHandler;", "makeHandler", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/CancelHandler;", "multipleHandlersError", "(Lkotlin/jvm/functions/Function1;Ljava/lang/Object;)V", "", "nameString", "()Ljava/lang/String;", "value", "onCancellation", "resume", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "Lkotlinx/coroutines/CancelledContinuation;", "resumeImpl", "(Ljava/lang/Object;I)Lkotlinx/coroutines/CancelledContinuation;", "Lkotlin/Result;", "result", "resumeWith", "exception", "resumeWithExceptionMode$kotlinx_coroutines_core", "(Ljava/lang/Throwable;I)Lkotlinx/coroutines/CancelledContinuation;", "resumeWithExceptionMode", "takeState$kotlinx_coroutines_core", "takeState", "toString", "tryResume", "()Z", "idempotent", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "tryResumeWithException", "(Ljava/lang/Throwable;)Ljava/lang/Object;", "trySuspend", "Lkotlinx/coroutines/CoroutineDispatcher;", "resumeUndispatched", "(Lkotlinx/coroutines/CoroutineDispatcher;Ljava/lang/Object;)V", "resumeUndispatchedWithException", "(Lkotlinx/coroutines/CoroutineDispatcher;Ljava/lang/Throwable;)V", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "callerFrame", "Lkotlin/coroutines/CoroutineContext;", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "Lkotlin/coroutines/Continuation;", "getDelegate$kotlinx_coroutines_core", "()Lkotlin/coroutines/Continuation;", "isActive", "isCancelled", "isCompleted", "Lkotlinx/coroutines/DisposableHandle;", "parentHandle", "Lkotlinx/coroutines/DisposableHandle;", "getState$kotlinx_coroutines_core", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public class CancellableContinuationImpl<T> extends DispatchedTask<T> implements CancellableContinuation<T>, CoroutineStackFrame {
    private static final AtomicIntegerFieldUpdater _decision$FU = AtomicIntegerFieldUpdater.newUpdater(CancellableContinuationImpl.class, "_decision");
    private static final AtomicReferenceFieldUpdater _state$FU = AtomicReferenceFieldUpdater.newUpdater(CancellableContinuationImpl.class, Object.class, "_state");
    private volatile int _decision;
    private volatile Object _state;
    private final CoroutineContext context;
    private final Continuation<T> delegate;
    private volatile DisposableHandle parentHandle;

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public /* synthetic */ void initCancellability() {
    }

    protected String nameString() {
        return "CancellableContinuation";
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public final Continuation<T> getDelegate$kotlinx_coroutines_core() {
        return this.delegate;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CancellableContinuationImpl(Continuation<? super T> delegate, int i) {
        super(i);
        Intrinsics.checkParameterIsNotNull(delegate, "delegate");
        this.delegate = delegate;
        this.context = delegate.getContext();
        this._decision = 0;
        this._state = Active.INSTANCE;
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return this.context;
    }

    public final Object getState$kotlinx_coroutines_core() {
        return this._state;
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public boolean isActive() {
        return getState$kotlinx_coroutines_core() instanceof NotCompleted;
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public boolean isCompleted() {
        return !(getState$kotlinx_coroutines_core() instanceof NotCompleted);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public boolean isCancelled() {
        return getState$kotlinx_coroutines_core() instanceof CancelledContinuation;
    }

    private final void installParentCancellationHandler() {
        Job job;
        if (isCompleted() || (job = (Job) this.delegate.getContext().get(Job.Key)) == null) {
            return;
        }
        job.start();
        DisposableHandle invokeOnCompletion$default = Job.DefaultImpls.invokeOnCompletion$default(job, true, false, new ChildContinuation(job, this), 2, null);
        this.parentHandle = invokeOnCompletion$default;
        if (isCompleted()) {
            invokeOnCompletion$default.dispose();
            this.parentHandle = NonDisposableHandle.INSTANCE;
        }
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public CoroutineStackFrame getCallerFrame() {
        Continuation<T> continuation = this.delegate;
        if (!(continuation instanceof CoroutineStackFrame)) {
            continuation = null;
        }
        return (CoroutineStackFrame) continuation;
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public Object takeState$kotlinx_coroutines_core() {
        return getState$kotlinx_coroutines_core();
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public void cancelResult$kotlinx_coroutines_core(Object obj, Throwable cause) {
        Intrinsics.checkParameterIsNotNull(cause, "cause");
        if (obj instanceof CompletedWithCancellation) {
            try {
                ((CompletedWithCancellation) obj).onCancellation.invoke(cause);
            } catch (Throwable th) {
                CoroutineContext context = getContext();
                CoroutineExceptionHandlerKt.handleCoroutineException(context, new CompletionHandlerException("Exception in cancellation handler for " + this, th));
            }
        }
    }

    private final void invokeHandlerSafely(Function0<Unit> function0) {
        try {
            function0.invoke();
        } catch (Throwable th) {
            CoroutineContext context = getContext();
            CoroutineExceptionHandlerKt.handleCoroutineException(context, new CompletionHandlerException("Exception in cancellation handler for " + this, th));
        }
    }

    public Throwable getContinuationCancellationCause(Job parent) {
        Intrinsics.checkParameterIsNotNull(parent, "parent");
        return parent.getCancellationException();
    }

    public final Object getResult() {
        Job job;
        installParentCancellationHandler();
        if (trySuspend()) {
            return IntrinsicsKt.getCOROUTINE_SUSPENDED();
        }
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (state$kotlinx_coroutines_core instanceof CompletedExceptionally) {
            throw StackTraceRecoveryKt.recoverStackTrace(((CompletedExceptionally) state$kotlinx_coroutines_core).cause, this);
        }
        if (this.resumeMode == 1 && (job = (Job) getContext().get(Job.Key)) != null && !job.isActive()) {
            CancellationException cancellationException = job.getCancellationException();
            cancelResult$kotlinx_coroutines_core(state$kotlinx_coroutines_core, cancellationException);
            throw StackTraceRecoveryKt.recoverStackTrace(cancellationException, this);
        }
        return getSuccessfulResult$kotlinx_coroutines_core(state$kotlinx_coroutines_core);
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object obj) {
        resumeImpl(CompletedExceptionallyKt.toState(obj), this.resumeMode);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public void resume(T t, Function1<? super Throwable, Unit> onCancellation) {
        Intrinsics.checkParameterIsNotNull(onCancellation, "onCancellation");
        CancelledContinuation resumeImpl = resumeImpl(new CompletedWithCancellation(t, onCancellation), this.resumeMode);
        if (resumeImpl != null) {
            try {
                onCancellation.invoke(resumeImpl.cause);
            } catch (Throwable th) {
                CoroutineContext context = getContext();
                CoroutineExceptionHandlerKt.handleCoroutineException(context, new CompletionHandlerException("Exception in cancellation handler for " + this, th));
            }
        }
    }

    public final CancelledContinuation resumeWithExceptionMode$kotlinx_coroutines_core(Throwable exception, int i) {
        Intrinsics.checkParameterIsNotNull(exception, "exception");
        return resumeImpl(new CompletedExceptionally(exception, false, 2, null), i);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public void invokeOnCancellation(Function1<? super Throwable, Unit> handler) {
        Intrinsics.checkParameterIsNotNull(handler, "handler");
        CancelHandler cancelHandler = null;
        while (true) {
            Object obj = this._state;
            if (obj instanceof Active) {
                if (cancelHandler == null) {
                    cancelHandler = makeHandler(handler);
                }
                if (_state$FU.compareAndSet(this, obj, cancelHandler)) {
                    return;
                }
            } else if (!(obj instanceof CancelHandler)) {
                if (obj instanceof CancelledContinuation) {
                    if (!((CancelledContinuation) obj).makeHandled()) {
                        multipleHandlersError(handler, obj);
                    }
                    try {
                        if (!(obj instanceof CompletedExceptionally)) {
                            obj = null;
                        }
                        CompletedExceptionally completedExceptionally = (CompletedExceptionally) obj;
                        handler.invoke(completedExceptionally != null ? completedExceptionally.cause : null);
                        return;
                    } catch (Throwable th) {
                        CoroutineExceptionHandlerKt.handleCoroutineException(getContext(), new CompletionHandlerException("Exception in cancellation handler for " + this, th));
                        return;
                    }
                }
                return;
            } else {
                multipleHandlersError(handler, obj);
            }
        }
    }

    private final void multipleHandlersError(Function1<? super Throwable, Unit> function1, Object obj) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + function1 + ", already has " + obj).toString());
    }

    private final CancelHandler makeHandler(Function1<? super Throwable, Unit> function1) {
        return function1 instanceof CancelHandler ? (CancelHandler) function1 : new InvokeOnCancel(function1);
    }

    private final void dispatchResume(int i) {
        if (tryResume()) {
            return;
        }
        DispatchedKt.dispatch(this, i);
    }

    private final void alreadyResumedError(Object obj) {
        throw new IllegalStateException(("Already resumed, but proposed with update " + obj).toString());
    }

    private final void disposeParentHandle() {
        DisposableHandle disposableHandle = this.parentHandle;
        if (disposableHandle != null) {
            disposableHandle.dispose();
            this.parentHandle = NonDisposableHandle.INSTANCE;
        }
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public void completeResume(Object token) {
        Intrinsics.checkParameterIsNotNull(token, "token");
        dispatchResume(this.resumeMode);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public void resumeUndispatched(CoroutineDispatcher resumeUndispatched, T t) {
        Intrinsics.checkParameterIsNotNull(resumeUndispatched, "$this$resumeUndispatched");
        Continuation<T> continuation = this.delegate;
        if (!(continuation instanceof DispatchedContinuation)) {
            continuation = null;
        }
        DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) continuation;
        resumeImpl(t, (dispatchedContinuation != null ? dispatchedContinuation.dispatcher : null) == resumeUndispatched ? 3 : this.resumeMode);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public void resumeUndispatchedWithException(CoroutineDispatcher resumeUndispatchedWithException, Throwable exception) {
        Intrinsics.checkParameterIsNotNull(resumeUndispatchedWithException, "$this$resumeUndispatchedWithException");
        Intrinsics.checkParameterIsNotNull(exception, "exception");
        Continuation<T> continuation = this.delegate;
        if (!(continuation instanceof DispatchedContinuation)) {
            continuation = null;
        }
        DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) continuation;
        resumeImpl(new CompletedExceptionally(exception, false, 2, null), (dispatchedContinuation != null ? dispatchedContinuation.dispatcher : null) == resumeUndispatchedWithException ? 3 : this.resumeMode);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.DispatchedTask
    public <T> T getSuccessfulResult$kotlinx_coroutines_core(Object obj) {
        return obj instanceof CompletedIdempotentResult ? (T) ((CompletedIdempotentResult) obj).result : obj instanceof CompletedWithCancellation ? (T) ((CompletedWithCancellation) obj).result : obj;
    }

    public String toString() {
        return nameString() + '(' + DebugStringsKt.toDebugString(this.delegate) + "){" + getState$kotlinx_coroutines_core() + "}@" + DebugStringsKt.getHexAddress(this);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public boolean cancel(Throwable th) {
        Object obj;
        boolean z;
        do {
            obj = this._state;
            if (!(obj instanceof NotCompleted)) {
                return false;
            }
            z = obj instanceof CancelHandler;
        } while (!_state$FU.compareAndSet(this, obj, new CancelledContinuation(this, th, z)));
        if (z) {
            try {
                ((CancelHandler) obj).invoke(th);
            } catch (Throwable th2) {
                CoroutineContext context = getContext();
                CoroutineExceptionHandlerKt.handleCoroutineException(context, new CompletionHandlerException("Exception in cancellation handler for " + this, th2));
            }
        }
        disposeParentHandle();
        dispatchResume(0);
        return true;
    }

    private final boolean trySuspend() {
        do {
            int i = this._decision;
            if (i != 0) {
                if (i == 2) {
                    return false;
                }
                throw new IllegalStateException("Already suspended".toString());
            }
        } while (!_decision$FU.compareAndSet(this, 0, 1));
        return true;
    }

    private final boolean tryResume() {
        do {
            int i = this._decision;
            if (i != 0) {
                if (i == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed".toString());
            }
        } while (!_decision$FU.compareAndSet(this, 0, 2));
        return true;
    }

    private final CancelledContinuation resumeImpl(Object obj, int i) {
        while (true) {
            Object obj2 = this._state;
            if (obj2 instanceof NotCompleted) {
                if (_state$FU.compareAndSet(this, obj2, obj)) {
                    disposeParentHandle();
                    dispatchResume(i);
                    return null;
                }
            } else {
                if (obj2 instanceof CancelledContinuation) {
                    CancelledContinuation cancelledContinuation = (CancelledContinuation) obj2;
                    if (cancelledContinuation.makeResumed()) {
                        return cancelledContinuation;
                    }
                }
                alreadyResumedError(obj);
            }
        }
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public Object tryResume(T t, Object obj) {
        Object obj2;
        do {
            obj2 = this._state;
            if (!(obj2 instanceof NotCompleted)) {
                if (obj2 instanceof CompletedIdempotentResult) {
                    CompletedIdempotentResult completedIdempotentResult = (CompletedIdempotentResult) obj2;
                    if (completedIdempotentResult.idempotentResume == obj) {
                        if (DebugKt.getASSERTIONS_ENABLED()) {
                            if (!(completedIdempotentResult.result == t)) {
                                throw new AssertionError();
                            }
                        }
                        return completedIdempotentResult.token;
                    }
                    return null;
                }
                return null;
            }
        } while (!_state$FU.compareAndSet(this, obj2, obj == null ? t : new CompletedIdempotentResult(obj, t, (NotCompleted) obj2)));
        disposeParentHandle();
        return obj2;
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public Object tryResumeWithException(Throwable exception) {
        Object obj;
        Intrinsics.checkParameterIsNotNull(exception, "exception");
        do {
            obj = this._state;
            if (!(obj instanceof NotCompleted)) {
                return null;
            }
        } while (!_state$FU.compareAndSet(this, obj, new CompletedExceptionally(exception, false, 2, null)));
        disposeParentHandle();
        return obj;
    }
}
