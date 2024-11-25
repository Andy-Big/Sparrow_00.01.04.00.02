package kotlinx.coroutines;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
/* compiled from: CompletableJob.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007"}, d2 = {"Lkotlinx/coroutines/CompletableJob;", "Lkotlinx/coroutines/Job;", "complete", "", "completeExceptionally", "exception", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public interface CompletableJob extends Job {

    /* compiled from: CompletableJob.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 15})
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        public static <R> R fold(CompletableJob completableJob, R r, Function2<? super R, ? super CoroutineContext.Element, ? extends R> operation) {
            Intrinsics.checkParameterIsNotNull(operation, "operation");
            return (R) Job.DefaultImpls.fold(completableJob, r, operation);
        }

        public static <E extends CoroutineContext.Element> E get(CompletableJob completableJob, CoroutineContext.Key<E> key) {
            Intrinsics.checkParameterIsNotNull(key, "key");
            return (E) Job.DefaultImpls.get(completableJob, key);
        }

        public static CoroutineContext minusKey(CompletableJob completableJob, CoroutineContext.Key<?> key) {
            Intrinsics.checkParameterIsNotNull(key, "key");
            return Job.DefaultImpls.minusKey(completableJob, key);
        }

        public static CoroutineContext plus(CompletableJob completableJob, CoroutineContext context) {
            Intrinsics.checkParameterIsNotNull(context, "context");
            return Job.DefaultImpls.plus(completableJob, context);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
        public static Job plus(CompletableJob completableJob, Job other) {
            Intrinsics.checkParameterIsNotNull(other, "other");
            return Job.DefaultImpls.plus((Job) completableJob, other);
        }
    }

    boolean complete();

    boolean completeExceptionally(Throwable th);
}
