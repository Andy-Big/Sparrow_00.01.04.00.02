package kotlinx.coroutines;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Executors.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0007¢\u0006\u0002\b\u0003\u001a\u0011\u0010\u0000\u001a\u00020\u0004*\u00020\u0005H\u0007¢\u0006\u0002\b\u0003\u001a\n\u0010\u0006\u001a\u00020\u0002*\u00020\u0001¨\u0006\u0007"}, d2 = {"asCoroutineDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "Ljava/util/concurrent/Executor;", "from", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "Ljava/util/concurrent/ExecutorService;", "asExecutor", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class ExecutorsKt {
    public static final ExecutorCoroutineDispatcher from(ExecutorService asCoroutineDispatcher) {
        Intrinsics.checkParameterIsNotNull(asCoroutineDispatcher, "$this$asCoroutineDispatcher");
        return new ExecutorCoroutineDispatcherImpl(asCoroutineDispatcher);
    }

    public static final CoroutineDispatcher from(Executor asCoroutineDispatcher) {
        CoroutineDispatcher coroutineDispatcher;
        Intrinsics.checkParameterIsNotNull(asCoroutineDispatcher, "$this$asCoroutineDispatcher");
        DispatcherExecutor dispatcherExecutor = (DispatcherExecutor) (!(asCoroutineDispatcher instanceof DispatcherExecutor) ? null : asCoroutineDispatcher);
        return (dispatcherExecutor == null || (coroutineDispatcher = dispatcherExecutor.dispatcher) == null) ? new ExecutorCoroutineDispatcherImpl(asCoroutineDispatcher) : coroutineDispatcher;
    }

    public static final Executor asExecutor(CoroutineDispatcher asExecutor) {
        Executor executor;
        Intrinsics.checkParameterIsNotNull(asExecutor, "$this$asExecutor");
        ExecutorCoroutineDispatcher executorCoroutineDispatcher = (ExecutorCoroutineDispatcher) (!(asExecutor instanceof ExecutorCoroutineDispatcher) ? null : asExecutor);
        return (executorCoroutineDispatcher == null || (executor = executorCoroutineDispatcher.getExecutor()) == null) ? new DispatcherExecutor(asExecutor) : executor;
    }
}
