package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlinx.coroutines.Job;
/* compiled from: Job.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u001a\u0019\u0010\u0004\u001a\u00020\u00052\u000e\b\u0004\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0087\b\u001a\u0012\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u001a\u0019\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007¢\u0006\u0002\b\t\u001a\f\u0010\u000e\u001a\u00020\b*\u00020\u0002H\u0007\u001a\u0018\u0010\u000e\u001a\u00020\u0001*\u00020\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0007\u001a\u001c\u0010\u000e\u001a\u00020\b*\u00020\u00022\u0010\b\u0002\u0010\u000f\u001a\n\u0018\u00010\u0011j\u0004\u0018\u0001`\u0012\u001a\u001e\u0010\u000e\u001a\u00020\b*\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u001a\u0015\u0010\u0015\u001a\u00020\b*\u00020\fH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0016\u001a\f\u0010\u0017\u001a\u00020\b*\u00020\u0002H\u0007\u001a\u0018\u0010\u0017\u001a\u00020\b*\u00020\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0007\u001a\u001c\u0010\u0017\u001a\u00020\b*\u00020\u00022\u0010\b\u0002\u0010\u000f\u001a\n\u0018\u00010\u0011j\u0004\u0018\u0001`\u0012\u001a\f\u0010\u0017\u001a\u00020\b*\u00020\fH\u0007\u001a\u0018\u0010\u0017\u001a\u00020\b*\u00020\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0007\u001a\u001c\u0010\u0017\u001a\u00020\b*\u00020\f2\u0010\b\u0002\u0010\u000f\u001a\n\u0018\u00010\u0011j\u0004\u0018\u0001`\u0012\u001a\u0014\u0010\u0018\u001a\u00020\u0005*\u00020\f2\u0006\u0010\u0019\u001a\u00020\u0005H\u0000\u001a\n\u0010\u001a\u001a\u00020\b*\u00020\u0002\u001a\n\u0010\u001a\u001a\u00020\b*\u00020\f\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0003\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001b"}, d2 = {"isActive", "", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlin/coroutines/CoroutineContext;)Z", "DisposableHandle", "Lkotlinx/coroutines/DisposableHandle;", "block", "Lkotlin/Function0;", "", "Job", "Lkotlinx/coroutines/CompletableJob;", "parent", "Lkotlinx/coroutines/Job;", "Job0", "cancel", "cause", "", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "message", "", "cancelAndJoin", "(Lkotlinx/coroutines/Job;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancelChildren", "disposeOnCompletion", "handle", "ensureActive", "kotlinx-coroutines-core"}, k = 5, mv = {1, 1, 15}, xs = "kotlinx/coroutines/JobKt")
/* loaded from: classes2.dex */
public final /* synthetic */ class JobKt__JobKt {
    public static final CompletableJob Job(Job job) {
        return new JobImpl(job);
    }

    public static /* synthetic */ CompletableJob Job$default(Job job, int i, Object obj) {
        if ((i & 1) != 0) {
            job = null;
        }
        return JobKt.Job(job);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    /* renamed from: Job */
    public static final /* synthetic */ Job m1344Job(Job job) {
        return JobKt.Job(job);
    }

    /* renamed from: Job$default */
    public static /* synthetic */ Job m1345Job$default(Job job, int i, Object obj) {
        Job m1344Job;
        if ((i & 1) != 0) {
            job = null;
        }
        m1344Job = m1344Job(job);
        return m1344Job;
    }

    public static final DisposableHandle DisposableHandle(final Function0<Unit> block) {
        Intrinsics.checkParameterIsNotNull(block, "block");
        return new DisposableHandle() { // from class: kotlinx.coroutines.JobKt__JobKt$DisposableHandle$1
            @Override // kotlinx.coroutines.DisposableHandle
            public void dispose() {
                Function0.this.invoke();
            }
        };
    }

    public static final DisposableHandle disposeOnCompletion(Job disposeOnCompletion, DisposableHandle handle) {
        Intrinsics.checkParameterIsNotNull(disposeOnCompletion, "$this$disposeOnCompletion");
        Intrinsics.checkParameterIsNotNull(handle, "handle");
        return disposeOnCompletion.invokeOnCompletion(new DisposeOnCompletion(disposeOnCompletion, handle));
    }

    public static final Object cancelAndJoin(Job job, Continuation<? super Unit> continuation) {
        Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        return job.join(continuation);
    }

    public static /* synthetic */ void cancelChildren$default(Job job, CancellationException cancellationException, int i, Object obj) {
        if ((i & 1) != 0) {
            cancellationException = null;
        }
        JobKt.cancelChildren(job, cancellationException);
    }

    public static final void cancelChildren(Job cancelChildren, CancellationException cancellationException) {
        Intrinsics.checkParameterIsNotNull(cancelChildren, "$this$cancelChildren");
        for (Job job : cancelChildren.getChildren()) {
            job.cancel(cancellationException);
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public static final /* synthetic */ void cancelChildren(Job cancelChildren) {
        Intrinsics.checkParameterIsNotNull(cancelChildren, "$this$cancelChildren");
        JobKt.cancelChildren(cancelChildren, (CancellationException) null);
    }

    public static /* synthetic */ void cancelChildren$default(Job job, Throwable th, int i, Object obj) {
        if ((i & 1) != 0) {
            th = null;
        }
        cancelChildren(job, th);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public static final /* synthetic */ void cancelChildren(Job cancelChildren, Throwable th) {
        Intrinsics.checkParameterIsNotNull(cancelChildren, "$this$cancelChildren");
        for (Job job : cancelChildren.getChildren()) {
            if (!(job instanceof JobSupport)) {
                job = null;
            }
            JobSupport jobSupport = (JobSupport) job;
            if (jobSupport != null) {
                jobSupport.cancel(th);
            }
        }
    }

    public static final boolean isActive(CoroutineContext isActive) {
        Intrinsics.checkParameterIsNotNull(isActive, "$this$isActive");
        Job job = (Job) isActive.get(Job.Key);
        return job != null && job.isActive();
    }

    public static /* synthetic */ void cancel$default(CoroutineContext coroutineContext, CancellationException cancellationException, int i, Object obj) {
        if ((i & 1) != 0) {
            cancellationException = null;
        }
        JobKt.cancel(coroutineContext, cancellationException);
    }

    public static final void cancel(CoroutineContext cancel, CancellationException cancellationException) {
        Intrinsics.checkParameterIsNotNull(cancel, "$this$cancel");
        Job job = (Job) cancel.get(Job.Key);
        if (job != null) {
            job.cancel(cancellationException);
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public static final /* synthetic */ void cancel(CoroutineContext cancel) {
        Intrinsics.checkParameterIsNotNull(cancel, "$this$cancel");
        JobKt.cancel(cancel, (CancellationException) null);
    }

    public static final void ensureActive(Job ensureActive) {
        Intrinsics.checkParameterIsNotNull(ensureActive, "$this$ensureActive");
        if (!ensureActive.isActive()) {
            throw ensureActive.getCancellationException();
        }
    }

    public static final void ensureActive(CoroutineContext ensureActive) {
        Intrinsics.checkParameterIsNotNull(ensureActive, "$this$ensureActive");
        Job job = (Job) ensureActive.get(Job.Key);
        if (job == null) {
            throw new IllegalStateException(("Context cannot be checked for liveness because it does not have a job: " + ensureActive).toString());
        }
        JobKt.ensureActive(job);
    }

    public static final void cancel(Job cancel, String message, Throwable th) {
        Intrinsics.checkParameterIsNotNull(cancel, "$this$cancel");
        Intrinsics.checkParameterIsNotNull(message, "message");
        cancel.cancel(ExceptionsKt.CancellationException(message, th));
    }

    public static /* synthetic */ void cancel$default(Job job, String str, Throwable th, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        JobKt.cancel(job, str, th);
    }

    public static /* synthetic */ boolean cancel$default(CoroutineContext coroutineContext, Throwable th, int i, Object obj) {
        boolean cancel;
        if ((i & 1) != 0) {
            th = null;
        }
        cancel = cancel(coroutineContext, th);
        return cancel;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public static final /* synthetic */ boolean cancel(CoroutineContext cancel, Throwable th) {
        Intrinsics.checkParameterIsNotNull(cancel, "$this$cancel");
        CoroutineContext.Element element = cancel.get(Job.Key);
        if (!(element instanceof JobSupport)) {
            element = null;
        }
        JobSupport jobSupport = (JobSupport) element;
        if (jobSupport != null) {
            return jobSupport.cancel(th);
        }
        return false;
    }

    public static /* synthetic */ void cancelChildren$default(CoroutineContext coroutineContext, CancellationException cancellationException, int i, Object obj) {
        if ((i & 1) != 0) {
            cancellationException = null;
        }
        JobKt.cancelChildren(coroutineContext, cancellationException);
    }

    public static final void cancelChildren(CoroutineContext cancelChildren, CancellationException cancellationException) {
        Sequence<Job> children;
        Intrinsics.checkParameterIsNotNull(cancelChildren, "$this$cancelChildren");
        Job job = (Job) cancelChildren.get(Job.Key);
        if (job == null || (children = job.getChildren()) == null) {
            return;
        }
        for (Job job2 : children) {
            job2.cancel(cancellationException);
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public static final /* synthetic */ void cancelChildren(CoroutineContext cancelChildren) {
        Intrinsics.checkParameterIsNotNull(cancelChildren, "$this$cancelChildren");
        JobKt.cancelChildren(cancelChildren, (CancellationException) null);
    }

    public static /* synthetic */ void cancelChildren$default(CoroutineContext coroutineContext, Throwable th, int i, Object obj) {
        if ((i & 1) != 0) {
            th = null;
        }
        cancelChildren(coroutineContext, th);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public static final /* synthetic */ void cancelChildren(CoroutineContext cancelChildren, Throwable th) {
        Sequence<Job> children;
        Intrinsics.checkParameterIsNotNull(cancelChildren, "$this$cancelChildren");
        Job job = (Job) cancelChildren.get(Job.Key);
        if (job == null || (children = job.getChildren()) == null) {
            return;
        }
        for (Job job2 : children) {
            if (!(job2 instanceof JobSupport)) {
                job2 = null;
            }
            JobSupport jobSupport = (JobSupport) job2;
            if (jobSupport != null) {
                jobSupport.cancel(th);
            }
        }
    }
}
