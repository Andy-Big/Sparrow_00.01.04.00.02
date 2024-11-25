package kotlinx.coroutines.scheduling;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.internal.SystemPropsKt;
import kotlinx.coroutines.internal.SystemPropsKt__SystemProps_commonKt;
/* compiled from: Tasks.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\"\u0010\u0010\u0000\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0002\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0005\u001a\u00020\u00068\u0000X\u0081\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0007\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\b\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\t\u001a\u00020\u00068\u0000X\u0081\u0004¢\u0006\u0002\n\u0000\"\u0012\u0010\n\u001a\u00020\u000b8\u0000@\u0000X\u0081\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"BLOCKING_DEFAULT_PARALLELISM", "", "CORE_POOL_SIZE", "DEFAULT_SCHEDULER_NAME", "", "IDLE_WORKER_KEEP_ALIVE_NS", "", "MAX_POOL_SIZE", "QUEUE_SIZE_OFFLOAD_THRESHOLD", "WORK_STEALING_TIME_RESOLUTION_NS", "schedulerTimeSource", "Lkotlinx/coroutines/scheduling/TimeSource;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class TasksKt {
    public static final int BLOCKING_DEFAULT_PARALLELISM;
    public static final int CORE_POOL_SIZE;
    public static final String DEFAULT_SCHEDULER_NAME = "DefaultDispatcher";
    public static final long IDLE_WORKER_KEEP_ALIVE_NS;
    public static final int MAX_POOL_SIZE;
    public static final int QUEUE_SIZE_OFFLOAD_THRESHOLD;
    public static final long WORK_STEALING_TIME_RESOLUTION_NS;
    public static TimeSource schedulerTimeSource;

    static {
        long systemProp$default;
        int systemProp$default2;
        int systemProp$default3;
        int systemProp$default4;
        int systemProp$default5;
        long systemProp$default6;
        systemProp$default = SystemPropsKt__SystemProps_commonKt.systemProp$default("kotlinx.coroutines.scheduler.resolution.ns", 100000L, 0L, 0L, 12, (Object) null);
        WORK_STEALING_TIME_RESOLUTION_NS = systemProp$default;
        systemProp$default2 = SystemPropsKt__SystemProps_commonKt.systemProp$default("kotlinx.coroutines.scheduler.offload.threshold", 96, 0, 128, 4, (Object) null);
        QUEUE_SIZE_OFFLOAD_THRESHOLD = systemProp$default2;
        systemProp$default3 = SystemPropsKt__SystemProps_commonKt.systemProp$default("kotlinx.coroutines.scheduler.blocking.parallelism", 16, 0, 0, 12, (Object) null);
        BLOCKING_DEFAULT_PARALLELISM = systemProp$default3;
        systemProp$default4 = SystemPropsKt__SystemProps_commonKt.systemProp$default("kotlinx.coroutines.scheduler.core.pool.size", RangesKt.coerceAtLeast(SystemPropsKt.getAVAILABLE_PROCESSORS(), 2), 1, 0, 8, (Object) null);
        CORE_POOL_SIZE = systemProp$default4;
        systemProp$default5 = SystemPropsKt__SystemProps_commonKt.systemProp$default("kotlinx.coroutines.scheduler.max.pool.size", RangesKt.coerceIn(SystemPropsKt.getAVAILABLE_PROCESSORS() * 128, CORE_POOL_SIZE, (int) CoroutineScheduler.MAX_SUPPORTED_POOL_SIZE), 0, (int) CoroutineScheduler.MAX_SUPPORTED_POOL_SIZE, 4, (Object) null);
        MAX_POOL_SIZE = systemProp$default5;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        systemProp$default6 = SystemPropsKt__SystemProps_commonKt.systemProp$default("kotlinx.coroutines.scheduler.keep.alive.sec", 5L, 0L, 0L, 12, (Object) null);
        IDLE_WORKER_KEEP_ALIVE_NS = timeUnit.toNanos(systemProp$default6);
        schedulerTimeSource = NanoTimeSource.INSTANCE;
    }
}
