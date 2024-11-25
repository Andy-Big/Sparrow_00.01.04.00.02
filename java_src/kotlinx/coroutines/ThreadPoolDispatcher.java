package kotlinx.coroutines;

import com.sun.mail.imap.IMAPStore;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ThreadPoolDispatcher.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0005H\u0016R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lkotlinx/coroutines/ThreadPoolDispatcher;", "Lkotlinx/coroutines/ExecutorCoroutineDispatcherBase;", "nThreads", "", IMAPStore.ID_NAME, "", "(ILjava/lang/String;)V", "executor", "Ljava/util/concurrent/Executor;", "getExecutor", "()Ljava/util/concurrent/Executor;", "threadNo", "Ljava/util/concurrent/atomic/AtomicInteger;", "close", "", "toString", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class ThreadPoolDispatcher extends ExecutorCoroutineDispatcherBase {
    private final Executor executor;
    private final int nThreads;
    private final String name;
    private final AtomicInteger threadNo;

    public ThreadPoolDispatcher(int i, String name) {
        Intrinsics.checkParameterIsNotNull(name, "name");
        this.nThreads = i;
        this.name = name;
        this.threadNo = new AtomicInteger();
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(this.nThreads, new ThreadFactory() { // from class: kotlinx.coroutines.ThreadPoolDispatcher$executor$1
            @Override // java.util.concurrent.ThreadFactory
            public final PoolThread newThread(Runnable target) {
                int i2;
                String str;
                AtomicInteger atomicInteger;
                String sb;
                ThreadPoolDispatcher threadPoolDispatcher = ThreadPoolDispatcher.this;
                Intrinsics.checkExpressionValueIsNotNull(target, "target");
                i2 = ThreadPoolDispatcher.this.nThreads;
                if (i2 == 1) {
                    sb = ThreadPoolDispatcher.this.name;
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    str = ThreadPoolDispatcher.this.name;
                    sb2.append(str);
                    sb2.append("-");
                    atomicInteger = ThreadPoolDispatcher.this.threadNo;
                    sb2.append(atomicInteger.incrementAndGet());
                    sb = sb2.toString();
                }
                return new PoolThread(threadPoolDispatcher, target, sb);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(newScheduledThreadPool, "Executors.newScheduledTh….incrementAndGet())\n    }");
        this.executor = newScheduledThreadPool;
        initFutureCancellation$kotlinx_coroutines_core();
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher
    public Executor getExecutor() {
        return this.executor;
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcherBase, kotlinx.coroutines.ExecutorCoroutineDispatcher, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Executor executor = getExecutor();
        if (executor == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.util.concurrent.ExecutorService");
        }
        ((ExecutorService) executor).shutdown();
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcherBase, kotlinx.coroutines.CoroutineDispatcher
    public String toString() {
        return "ThreadPoolDispatcher[" + this.nThreads + ", " + this.name + ']';
    }
}
