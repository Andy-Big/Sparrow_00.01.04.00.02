package kotlinx.coroutines.selects;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletedExceptionally;
import kotlinx.coroutines.CompletedExceptionallyKt;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.DispatchedKt;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobCancellingNode;
import kotlinx.coroutines.internal.AtomicDesc;
import kotlinx.coroutines.internal.AtomicOp;
import kotlinx.coroutines.internal.LockFreeLinkedListHead;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.OpDescriptor;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.intrinsics.CancellableKt;
import kotlinx.coroutines.intrinsics.UndispatchedKt;
import kotlinx.coroutines.selects.SelectBuilder;
/* compiled from: Select.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0001\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u00022\b\u0012\u0004\u0012\u00028\u00000\u00032\b\u0012\u0004\u0012\u00028\u00000\u00042\b\u0012\u0004\u0012\u00028\u00000\u00052\u00060\u0006j\u0002`\u0007:\u0003RSTB\u0015\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J.\u0010\u0016\u001a\u00020\r2\u000e\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u00122\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\r0\u0012H\u0082\b¢\u0006\u0004\b\u0016\u0010\u0017J\u0011\u0010\u0018\u001a\u0004\u0018\u00010\u0013H\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001c\u001a\n\u0018\u00010\u001aj\u0004\u0018\u0001`\u001bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010 \u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u001eH\u0001¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\rH\u0002¢\u0006\u0004\b\"\u0010\u0011J8\u0010&\u001a\u00020\r2\u0006\u0010$\u001a\u00020#2\u001c\u0010\u0015\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00130%H\u0016ø\u0001\u0000¢\u0006\u0004\b&\u0010'J\u0019\u0010*\u001a\u0004\u0018\u00010\u00132\u0006\u0010)\u001a\u00020(H\u0016¢\u0006\u0004\b*\u0010+J\u0017\u0010-\u001a\u00020\r2\u0006\u0010,\u001a\u00020\u001eH\u0016¢\u0006\u0004\b-\u0010!J \u00100\u001a\u00020\r2\f\u0010/\u001a\b\u0012\u0004\u0012\u00028\u00000.H\u0016ø\u0001\u0000¢\u0006\u0004\b0\u00101J\u0019\u00104\u001a\u0002032\b\u00102\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b4\u00105J5\u00107\u001a\u00020\r*\u0002062\u001c\u0010\u0015\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00130%H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b7\u00108JG\u00107\u001a\u00020\r\"\u0004\b\u0001\u00109*\b\u0012\u0004\u0012\u00028\u00010:2\"\u0010\u0015\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00130;H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b7\u0010<J[\u00107\u001a\u00020\r\"\u0004\b\u0001\u0010=\"\u0004\b\u0002\u00109*\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020>2\u0006\u0010?\u001a\u00028\u00012\"\u0010\u0015\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00130;H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b7\u0010@R\u001e\u0010C\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u00078V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\bA\u0010BR\u001c\u0010F\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\bD\u0010ER\u0016\u0010J\u001a\u00020G8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\bH\u0010IR\u0016\u0010K\u001a\u0002038V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\bK\u0010LR\u0018\u0010M\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010NR\u0018\u0010P\u001a\u0004\u0018\u00010\u00138B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bO\u0010\u0019R\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010Q\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006U"}, d2 = {"Lkotlinx/coroutines/selects/SelectBuilderImpl;", "R", "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "Lkotlinx/coroutines/selects/SelectBuilder;", "Lkotlinx/coroutines/selects/SelectInstance;", "Lkotlin/coroutines/Continuation;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "uCont", "<init>", "(Lkotlin/coroutines/Continuation;)V", "Lkotlinx/coroutines/DisposableHandle;", "handle", "", "disposeOnSelect", "(Lkotlinx/coroutines/DisposableHandle;)V", "doAfterSelect", "()V", "Lkotlin/Function0;", "", "value", "block", "doResume", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "getResult", "()Ljava/lang/Object;", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "getStackTraceElement", "()Ljava/lang/StackTraceElement;", "", "e", "handleBuilderException", "(Ljava/lang/Throwable;)V", "initCancellability", "", "timeMillis", "Lkotlin/Function1;", "onTimeout", "(JLkotlin/jvm/functions/Function1;)V", "Lkotlinx/coroutines/internal/AtomicDesc;", "desc", "performAtomicTrySelect", "(Lkotlinx/coroutines/internal/AtomicDesc;)Ljava/lang/Object;", "exception", "resumeSelectCancellableWithException", "Lkotlin/Result;", "result", "resumeWith", "(Ljava/lang/Object;)V", "idempotent", "", "trySelect", "(Ljava/lang/Object;)Z", "Lkotlinx/coroutines/selects/SelectClause0;", "invoke", "(Lkotlinx/coroutines/selects/SelectClause0;Lkotlin/jvm/functions/Function1;)V", "Q", "Lkotlinx/coroutines/selects/SelectClause1;", "Lkotlin/Function2;", "(Lkotlinx/coroutines/selects/SelectClause1;Lkotlin/jvm/functions/Function2;)V", "P", "Lkotlinx/coroutines/selects/SelectClause2;", "param", "(Lkotlinx/coroutines/selects/SelectClause2;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "callerFrame", "getCompletion", "()Lkotlin/coroutines/Continuation;", "completion", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "context", "isSelected", "()Z", "parentHandle", "Lkotlinx/coroutines/DisposableHandle;", "getState", "state", "Lkotlin/coroutines/Continuation;", "AtomicSelectOp", "DisposeNode", "SelectOnCancelling", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class SelectBuilderImpl<R> extends LockFreeLinkedListHead implements SelectBuilder<R>, SelectInstance<R>, Continuation<R>, CoroutineStackFrame {
    volatile Object _result;
    volatile Object _state;
    private volatile DisposableHandle parentHandle;
    private final Continuation<R> uCont;
    static final AtomicReferenceFieldUpdater _state$FU = AtomicReferenceFieldUpdater.newUpdater(SelectBuilderImpl.class, Object.class, "_state");
    static final AtomicReferenceFieldUpdater _result$FU = AtomicReferenceFieldUpdater.newUpdater(SelectBuilderImpl.class, Object.class, "_result");

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlinx.coroutines.selects.SelectBuilder
    public <P, Q> void invoke(SelectClause2<? super P, ? extends Q> invoke, Function2<? super Q, ? super Continuation<? super R>, ? extends Object> block) {
        Intrinsics.checkParameterIsNotNull(invoke, "$this$invoke");
        Intrinsics.checkParameterIsNotNull(block, "block");
        SelectBuilder.DefaultImpls.invoke(this, invoke, block);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SelectBuilderImpl(Continuation<? super R> uCont) {
        Object obj;
        Intrinsics.checkParameterIsNotNull(uCont, "uCont");
        this.uCont = uCont;
        this._state = this;
        obj = SelectKt.UNDECIDED;
        this._result = obj;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public CoroutineStackFrame getCallerFrame() {
        Continuation<R> continuation = this.uCont;
        if (!(continuation instanceof CoroutineStackFrame)) {
            continuation = null;
        }
        return (CoroutineStackFrame) continuation;
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return this.uCont.getContext();
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public Continuation<R> getCompletion() {
        return this;
    }

    private final void doResume(Function0<? extends Object> function0, Function0<Unit> function02) {
        Object obj;
        Object obj2;
        Object obj3;
        if (DebugKt.getASSERTIONS_ENABLED() && !isSelected()) {
            throw new AssertionError();
        }
        while (true) {
            Object obj4 = this._result;
            obj = SelectKt.UNDECIDED;
            if (obj4 == obj) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _result$FU;
                obj2 = SelectKt.UNDECIDED;
                if (atomicReferenceFieldUpdater.compareAndSet(this, obj2, function0.invoke())) {
                    return;
                }
            } else if (obj4 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = _result$FU;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                obj3 = SelectKt.RESUMED;
                if (atomicReferenceFieldUpdater2.compareAndSet(this, coroutine_suspended, obj3)) {
                    function02.invoke();
                    return;
                }
            } else {
                throw new IllegalStateException("Already resumed");
            }
        }
    }

    public final Object getResult() {
        Object obj;
        Object obj2;
        Object obj3;
        if (!isSelected()) {
            initCancellability();
        }
        Object obj4 = this._result;
        obj = SelectKt.UNDECIDED;
        if (obj4 == obj) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _result$FU;
            obj3 = SelectKt.UNDECIDED;
            if (atomicReferenceFieldUpdater.compareAndSet(this, obj3, IntrinsicsKt.getCOROUTINE_SUSPENDED())) {
                return IntrinsicsKt.getCOROUTINE_SUSPENDED();
            }
            obj4 = this._result;
        }
        obj2 = SelectKt.RESUMED;
        if (obj4 == obj2) {
            throw new IllegalStateException("Already resumed");
        }
        if (obj4 instanceof CompletedExceptionally) {
            throw ((CompletedExceptionally) obj4).cause;
        }
        return obj4;
    }

    private final void initCancellability() {
        Job job = (Job) getContext().get(Job.Key);
        if (job != null) {
            DisposableHandle invokeOnCompletion$default = Job.DefaultImpls.invokeOnCompletion$default(job, true, false, new SelectOnCancelling(this, job), 2, null);
            this.parentHandle = invokeOnCompletion$default;
            if (isSelected()) {
                invokeOnCompletion$default.dispose();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Select.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0096\u0002J\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lkotlinx/coroutines/selects/SelectBuilderImpl$SelectOnCancelling;", "Lkotlinx/coroutines/JobCancellingNode;", "Lkotlinx/coroutines/Job;", "job", "(Lkotlinx/coroutines/selects/SelectBuilderImpl;Lkotlinx/coroutines/Job;)V", "invoke", "", "cause", "", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15})
    /* loaded from: classes2.dex */
    public final class SelectOnCancelling extends JobCancellingNode<Job> {
        final /* synthetic */ SelectBuilderImpl this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SelectOnCancelling(SelectBuilderImpl selectBuilderImpl, Job job) {
            super(job);
            Intrinsics.checkParameterIsNotNull(job, "job");
            this.this$0 = selectBuilderImpl;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            invoke2(th);
            return Unit.INSTANCE;
        }

        @Override // kotlinx.coroutines.CompletionHandlerBase
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public void invoke2(Throwable th) {
            if (this.this$0.trySelect(null)) {
                this.this$0.resumeSelectCancellableWithException(this.job.getCancellationException());
            }
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
        public String toString() {
            return "SelectOnCancelling[" + this.this$0 + ']';
        }
    }

    public final void handleBuilderException(Throwable e) {
        Intrinsics.checkParameterIsNotNull(e, "e");
        if (trySelect(null)) {
            Result.Companion companion = Result.Companion;
            resumeWith(Result.m28constructorimpl(ResultKt.createFailure(e)));
        } else if (e instanceof CancellationException) {
        } else {
            Object result = getResult();
            if ((result instanceof CompletedExceptionally) && StackTraceRecoveryKt.unwrap(((CompletedExceptionally) result).cause) == StackTraceRecoveryKt.unwrap(e)) {
                return;
            }
            CoroutineExceptionHandlerKt.handleCoroutineException(getContext(), e);
        }
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public boolean isSelected() {
        return getState() != this;
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public void disposeOnSelect(DisposableHandle handle) {
        Intrinsics.checkParameterIsNotNull(handle, "handle");
        DisposeNode disposeNode = new DisposeNode(handle);
        if (!isSelected()) {
            addLast(disposeNode);
            if (!isSelected()) {
                return;
            }
        }
        handle.dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doAfterSelect() {
        DisposableHandle disposableHandle = this.parentHandle;
        if (disposableHandle != null) {
            disposableHandle.dispose();
        }
        Object next = getNext();
        if (next == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
        }
        for (LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) next; !Intrinsics.areEqual(lockFreeLinkedListNode, this); lockFreeLinkedListNode = lockFreeLinkedListNode.getNextNode()) {
            if (lockFreeLinkedListNode instanceof DisposeNode) {
                ((DisposeNode) lockFreeLinkedListNode).handle.dispose();
            }
        }
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public boolean trySelect(Object obj) {
        if (!DebugKt.getASSERTIONS_ENABLED() || (!(obj instanceof OpDescriptor))) {
            do {
                Object state = getState();
                if (state != this) {
                    return obj != null && state == obj;
                }
            } while (!_state$FU.compareAndSet(this, this, obj));
            doAfterSelect();
            return true;
        }
        throw new AssertionError();
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public Object performAtomicTrySelect(AtomicDesc desc) {
        Intrinsics.checkParameterIsNotNull(desc, "desc");
        return new AtomicSelectOp(this, desc).perform(null);
    }

    /* compiled from: Select.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u001c\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\n\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0002J\u0014\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\f\u001a\u0004\u0018\u00010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lkotlinx/coroutines/selects/SelectBuilderImpl$AtomicSelectOp;", "Lkotlinx/coroutines/internal/AtomicOp;", "", "desc", "Lkotlinx/coroutines/internal/AtomicDesc;", "(Lkotlinx/coroutines/selects/SelectBuilderImpl;Lkotlinx/coroutines/internal/AtomicDesc;)V", "complete", "", "affected", "failure", "completeSelect", "prepare", "prepareIfNotSelected", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15})
    /* loaded from: classes2.dex */
    private final class AtomicSelectOp extends AtomicOp<Object> {
        public final AtomicDesc desc;
        final /* synthetic */ SelectBuilderImpl this$0;

        public AtomicSelectOp(SelectBuilderImpl selectBuilderImpl, AtomicDesc desc) {
            Intrinsics.checkParameterIsNotNull(desc, "desc");
            this.this$0 = selectBuilderImpl;
            this.desc = desc;
        }

        @Override // kotlinx.coroutines.internal.AtomicOp
        public Object prepare(Object obj) {
            Object prepareIfNotSelected;
            return (obj != null || (prepareIfNotSelected = prepareIfNotSelected()) == null) ? this.desc.prepare(this) : prepareIfNotSelected;
        }

        @Override // kotlinx.coroutines.internal.AtomicOp
        public void complete(Object obj, Object obj2) {
            completeSelect(obj2);
            this.desc.complete(this, obj2);
        }

        public final Object prepareIfNotSelected() {
            SelectBuilderImpl selectBuilderImpl = this.this$0;
            while (true) {
                Object obj = selectBuilderImpl._state;
                if (obj == this) {
                    return null;
                }
                if (obj instanceof OpDescriptor) {
                    ((OpDescriptor) obj).perform(this.this$0);
                } else {
                    SelectBuilderImpl selectBuilderImpl2 = this.this$0;
                    if (obj == selectBuilderImpl2) {
                        if (SelectBuilderImpl._state$FU.compareAndSet(selectBuilderImpl2, this.this$0, this)) {
                            return null;
                        }
                    } else {
                        return SelectKt.getALREADY_SELECTED();
                    }
                }
            }
        }

        private final void completeSelect(Object obj) {
            boolean z = obj == null;
            if (SelectBuilderImpl._state$FU.compareAndSet(this.this$0, this, z ? null : this.this$0) && z) {
                this.this$0.doAfterSelect();
            }
        }
    }

    @Override // kotlinx.coroutines.selects.SelectBuilder
    public void invoke(SelectClause0 invoke, Function1<? super Continuation<? super R>, ? extends Object> block) {
        Intrinsics.checkParameterIsNotNull(invoke, "$this$invoke");
        Intrinsics.checkParameterIsNotNull(block, "block");
        invoke.registerSelectClause0(this, block);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.selects.SelectBuilder
    public <Q> void invoke(SelectClause1<? extends Q> invoke, Function2<? super Q, ? super Continuation<? super R>, ? extends Object> block) {
        Intrinsics.checkParameterIsNotNull(invoke, "$this$invoke");
        Intrinsics.checkParameterIsNotNull(block, "block");
        invoke.registerSelectClause1(this, block);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.selects.SelectBuilder
    public <P, Q> void invoke(SelectClause2<? super P, ? extends Q> invoke, P p, Function2<? super Q, ? super Continuation<? super R>, ? extends Object> block) {
        Intrinsics.checkParameterIsNotNull(invoke, "$this$invoke");
        Intrinsics.checkParameterIsNotNull(block, "block");
        invoke.registerSelectClause2(this, p, block);
    }

    @Override // kotlinx.coroutines.selects.SelectBuilder
    public void onTimeout(long j, final Function1<? super Continuation<? super R>, ? extends Object> block) {
        Intrinsics.checkParameterIsNotNull(block, "block");
        if (j <= 0) {
            if (trySelect(null)) {
                UndispatchedKt.startCoroutineUnintercepted(block, getCompletion());
                return;
            }
            return;
        }
        disposeOnSelect(DelayKt.getDelay(getContext()).invokeOnTimeout(j, new Runnable() { // from class: kotlinx.coroutines.selects.SelectBuilderImpl$onTimeout$$inlined$Runnable$1
            @Override // java.lang.Runnable
            public final void run() {
                if (SelectBuilderImpl.this.trySelect(null)) {
                    CancellableKt.startCoroutineCancellable(block, SelectBuilderImpl.this.getCompletion());
                }
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Select.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lkotlinx/coroutines/selects/SelectBuilderImpl$DisposeNode;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "handle", "Lkotlinx/coroutines/DisposableHandle;", "(Lkotlinx/coroutines/DisposableHandle;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15})
    /* loaded from: classes2.dex */
    public static final class DisposeNode extends LockFreeLinkedListNode {
        public final DisposableHandle handle;

        public DisposeNode(DisposableHandle handle) {
            Intrinsics.checkParameterIsNotNull(handle, "handle");
            this.handle = handle;
        }
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object obj) {
        Object obj2;
        Object obj3;
        Object obj4;
        if (DebugKt.getASSERTIONS_ENABLED() && !isSelected()) {
            throw new AssertionError();
        }
        while (true) {
            Object obj5 = this._result;
            obj2 = SelectKt.UNDECIDED;
            if (obj5 == obj2) {
                obj3 = SelectKt.UNDECIDED;
                if (_result$FU.compareAndSet(this, obj3, CompletedExceptionallyKt.toState(obj))) {
                    return;
                }
            } else if (obj5 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _result$FU;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                obj4 = SelectKt.RESUMED;
                if (atomicReferenceFieldUpdater.compareAndSet(this, coroutine_suspended, obj4)) {
                    if (Result.m34isFailureimpl(obj)) {
                        Continuation<R> continuation = this.uCont;
                        Throwable m31exceptionOrNullimpl = Result.m31exceptionOrNullimpl(obj);
                        if (m31exceptionOrNullimpl == null) {
                            Intrinsics.throwNpe();
                        }
                        Result.Companion companion = Result.Companion;
                        continuation.resumeWith(Result.m28constructorimpl(ResultKt.createFailure(StackTraceRecoveryKt.recoverStackTrace(m31exceptionOrNullimpl, continuation))));
                        return;
                    }
                    this.uCont.resumeWith(obj);
                    return;
                }
            } else {
                throw new IllegalStateException("Already resumed");
            }
        }
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public void resumeSelectCancellableWithException(Throwable exception) {
        Object obj;
        Object obj2;
        Object obj3;
        Intrinsics.checkParameterIsNotNull(exception, "exception");
        if (DebugKt.getASSERTIONS_ENABLED() && !isSelected()) {
            throw new AssertionError();
        }
        while (true) {
            Object obj4 = this._result;
            obj = SelectKt.UNDECIDED;
            if (obj4 == obj) {
                obj2 = SelectKt.UNDECIDED;
                if (_result$FU.compareAndSet(this, obj2, new CompletedExceptionally(exception, false, 2, null))) {
                    return;
                }
            } else if (obj4 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _result$FU;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                obj3 = SelectKt.RESUMED;
                if (atomicReferenceFieldUpdater.compareAndSet(this, coroutine_suspended, obj3)) {
                    DispatchedKt.resumeCancellableWithException(IntrinsicsKt.intercepted(this.uCont), exception);
                    return;
                }
            } else {
                throw new IllegalStateException("Already resumed");
            }
        }
    }

    private final Object getState() {
        while (true) {
            Object obj = this._state;
            if (!(obj instanceof OpDescriptor)) {
                return obj;
            }
            ((OpDescriptor) obj).perform(this);
        }
    }
}
