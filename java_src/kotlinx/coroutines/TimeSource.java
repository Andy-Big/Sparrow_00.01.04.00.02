package kotlinx.coroutines;

import kotlin.Metadata;
/* compiled from: TimeSource.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\u0006H&J\b\u0010\n\u001a\u00020\u0006H&J\b\u0010\u000b\u001a\u00020\u0006H&J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eH&J\b\u0010\u000f\u001a\u00020\u0006H&J\u0018\u0010\u0010\u001a\u00060\u0011j\u0002`\u00122\n\u0010\u0013\u001a\u00060\u0011j\u0002`\u0012H&¨\u0006\u0014"}, d2 = {"Lkotlinx/coroutines/TimeSource;", "", "currentTimeMillis", "", "nanoTime", "parkNanos", "", "blocker", "nanos", "registerTimeLoopThread", "trackTask", "unTrackTask", "unpark", "thread", "Ljava/lang/Thread;", "unregisterTimeLoopThread", "wrapTask", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public interface TimeSource {
    long currentTimeMillis();

    long nanoTime();

    void parkNanos(Object obj, long j);

    void registerTimeLoopThread();

    void trackTask();

    void unTrackTask();

    void unpark(Thread thread);

    void unregisterTimeLoopThread();

    Runnable wrapTask(Runnable runnable);
}
