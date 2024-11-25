package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: JobSupport.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0003\n\u0000\b\u0010\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\f\u001a\u00020\u0007H\u0016J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0003R\u0014\u0010\u0006\u001a\u00020\u0007X\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078PX\u0090\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\t¨\u0006\u0010"}, d2 = {"Lkotlinx/coroutines/JobImpl;", "Lkotlinx/coroutines/JobSupport;", "Lkotlinx/coroutines/CompletableJob;", "parent", "Lkotlinx/coroutines/Job;", "(Lkotlinx/coroutines/Job;)V", "handlesException", "", "getHandlesException$kotlinx_coroutines_core", "()Z", "onCancelComplete", "getOnCancelComplete$kotlinx_coroutines_core", "complete", "completeExceptionally", "exception", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public class JobImpl extends JobSupport implements CompletableJob {
    private final boolean handlesException;

    @Override // kotlinx.coroutines.JobSupport
    public boolean getOnCancelComplete$kotlinx_coroutines_core() {
        return true;
    }

    public JobImpl(Job job) {
        super(true);
        initParentJobInternal$kotlinx_coroutines_core(job);
        this.handlesException = handlesException();
    }

    @Override // kotlinx.coroutines.JobSupport
    public boolean getHandlesException$kotlinx_coroutines_core() {
        return this.handlesException;
    }

    @Override // kotlinx.coroutines.CompletableJob
    public boolean complete() {
        return makeCompleting$kotlinx_coroutines_core(Unit.INSTANCE);
    }

    @Override // kotlinx.coroutines.CompletableJob
    public boolean completeExceptionally(Throwable exception) {
        Intrinsics.checkParameterIsNotNull(exception, "exception");
        return makeCompleting$kotlinx_coroutines_core(new CompletedExceptionally(exception, false, 2, null));
    }

    private final boolean handlesException() {
        JobSupport jobSupport;
        ChildHandle childHandle = this.parentHandle;
        if (!(childHandle instanceof ChildHandleNode)) {
            childHandle = null;
        }
        ChildHandleNode childHandleNode = (ChildHandleNode) childHandle;
        if (childHandleNode != null && (jobSupport = (JobSupport) childHandleNode.job) != null) {
            while (!jobSupport.getHandlesException$kotlinx_coroutines_core()) {
                ChildHandle childHandle2 = jobSupport.parentHandle;
                if (!(childHandle2 instanceof ChildHandleNode)) {
                    childHandle2 = null;
                }
                ChildHandleNode childHandleNode2 = (ChildHandleNode) childHandle2;
                if (childHandleNode2 != null) {
                    jobSupport = (JobSupport) childHandleNode2.job;
                    if (jobSupport == null) {
                    }
                }
            }
            return true;
        }
        return false;
    }
}
