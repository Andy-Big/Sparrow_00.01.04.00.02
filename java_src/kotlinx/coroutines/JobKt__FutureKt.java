package kotlinx.coroutines;

import java.util.concurrent.Future;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Future.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00022\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004\u001a\u0018\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0007¨\u0006\b"}, d2 = {"cancelFutureOnCancellation", "", "Lkotlinx/coroutines/CancellableContinuation;", "future", "Ljava/util/concurrent/Future;", "cancelFutureOnCompletion", "Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/Job;", "kotlinx-coroutines-core"}, k = 5, mv = {1, 1, 15}, xs = "kotlinx/coroutines/JobKt")
/* loaded from: classes2.dex */
public final /* synthetic */ class JobKt__FutureKt {
    public static final DisposableHandle cancelFutureOnCompletion(Job cancelFutureOnCompletion, Future<?> future) {
        Intrinsics.checkParameterIsNotNull(cancelFutureOnCompletion, "$this$cancelFutureOnCompletion");
        Intrinsics.checkParameterIsNotNull(future, "future");
        return cancelFutureOnCompletion.invokeOnCompletion(new CancelFutureOnCompletion(cancelFutureOnCompletion, future));
    }

    public static final void cancelFutureOnCancellation(CancellableContinuation<?> cancelFutureOnCancellation, Future<?> future) {
        Intrinsics.checkParameterIsNotNull(cancelFutureOnCancellation, "$this$cancelFutureOnCancellation");
        Intrinsics.checkParameterIsNotNull(future, "future");
        cancelFutureOnCancellation.invokeOnCancellation(new CancelFutureOnCancel(future));
    }
}
