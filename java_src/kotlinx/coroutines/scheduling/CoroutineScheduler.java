package kotlinx.coroutines.scheduling;

import com.rigol.scope.utilities.ViewUtil;
import com.sun.mail.imap.IMAPStore;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.TimeSourceKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.SystemPropsKt__SystemProps_commonKt;
/* compiled from: CoroutineScheduler.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0006\b\u0000\u0018\u0000 U2\u00020\u00012\u00020\u0002:\u0003UVWB+\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0006H\u0082\b¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J#\u0010\u001c\u001a\u00020\u00192\n\u0010\u0016\u001a\u00060\u0014j\u0002`\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\u0018\u0010\u001d\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0006H\u0082\b¢\u0006\u0004\b\u001d\u0010\u000eJ\u0015\u0010\u001f\u001a\b\u0018\u00010\u001eR\u00020\u0000H\u0002¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\u000fH\u0082\b¢\u0006\u0004\b!\u0010\u0011J\u0010\u0010\"\u001a\u00020\u0003H\u0082\b¢\u0006\u0004\b\"\u0010\u0013J-\u0010%\u001a\u00020\u000f2\n\u0010\u0016\u001a\u00060\u0014j\u0002`\u00152\b\b\u0002\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010$\u001a\u00020#¢\u0006\u0004\b%\u0010&J\u001b\u0010(\u001a\u00020\u000f2\n\u0010'\u001a\u00060\u0014j\u0002`\u0015H\u0016¢\u0006\u0004\b(\u0010)J\u0010\u0010*\u001a\u00020\u000fH\u0082\b¢\u0006\u0004\b*\u0010\u0011J\u0010\u0010+\u001a\u00020\u0003H\u0082\b¢\u0006\u0004\b+\u0010\u0013J\u001b\u0010-\u001a\u00020\u00032\n\u0010,\u001a\u00060\u001eR\u00020\u0000H\u0002¢\u0006\u0004\b-\u0010.J\u0015\u0010/\u001a\b\u0018\u00010\u001eR\u00020\u0000H\u0002¢\u0006\u0004\b/\u0010 J\u001b\u00100\u001a\u00020\u000f2\n\u0010,\u001a\u00060\u001eR\u00020\u0000H\u0002¢\u0006\u0004\b0\u00101J+\u00104\u001a\u00020\u000f2\n\u0010,\u001a\u00060\u001eR\u00020\u00002\u0006\u00102\u001a\u00020\u00032\u0006\u00103\u001a\u00020\u0003H\u0002¢\u0006\u0004\b4\u00105J\u000f\u00106\u001a\u00020\u000fH\u0002¢\u0006\u0004\b6\u0010\u0011J\u0017\u00108\u001a\u00020\u000f2\u0006\u00107\u001a\u00020\u0019H\u0002¢\u0006\u0004\b8\u00109J\u0015\u0010;\u001a\u00020\u000f2\u0006\u0010:\u001a\u00020\u0006¢\u0006\u0004\b;\u0010<J\u001f\u0010=\u001a\u00020\u00032\u0006\u00107\u001a\u00020\u00192\u0006\u0010$\u001a\u00020#H\u0002¢\u0006\u0004\b=\u0010>J\u000f\u0010?\u001a\u00020\bH\u0016¢\u0006\u0004\b?\u0010@J\u000f\u0010A\u001a\u00020#H\u0002¢\u0006\u0004\bA\u0010BR\u0017\u0010\r\u001a\u00020\u00038Â\u0002@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bC\u0010\u0013R\u0016\u0010\u0004\u001a\u00020\u00038\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010DR\u0016\u0010F\u001a\u00020E8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bF\u0010GR\u0017\u0010\u001d\u001a\u00020\u00038Â\u0002@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bH\u0010\u0013R\u0016\u0010J\u001a\u00020I8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010LR\u0016\u0010M\u001a\u00020#8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bM\u0010BR\u0016\u0010\u0005\u001a\u00020\u00038\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010DR\u0016\u0010O\u001a\u00020N8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010QR\"\u0010S\u001a\u000e\u0012\n\u0012\b\u0018\u00010\u001eR\u00020\u00000R8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bS\u0010T¨\u0006X"}, d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "Ljava/util/concurrent/Executor;", "Ljava/io/Closeable;", "", "corePoolSize", "maxPoolSize", "", "idleWorkerKeepAliveNs", "", "schedulerName", "<init>", "(IIJLjava/lang/String;)V", "state", "blockingWorkers", "(J)I", "", "close", "()V", "createNewWorker", "()I", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "Lkotlinx/coroutines/scheduling/TaskContext;", "taskContext", "Lkotlinx/coroutines/scheduling/Task;", "createTask$kotlinx_coroutines_core", "(Ljava/lang/Runnable;Lkotlinx/coroutines/scheduling/TaskContext;)Lkotlinx/coroutines/scheduling/Task;", "createTask", "createdWorkers", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", "currentWorker", "()Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", "decrementBlockingWorkers", "decrementCreatedWorkers", "", "fair", "dispatch", "(Ljava/lang/Runnable;Lkotlinx/coroutines/scheduling/TaskContext;Z)V", IMAPStore.ID_COMMAND, "execute", "(Ljava/lang/Runnable;)V", "incrementBlockingWorkers", "incrementCreatedWorkers", "worker", "parkedWorkersStackNextIndex", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;)I", "parkedWorkersStackPop", "parkedWorkersStackPush", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;)V", "oldIndex", "newIndex", "parkedWorkersStackTopUpdate", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;II)V", "requestCpuWorker", "task", "runSafely", "(Lkotlinx/coroutines/scheduling/Task;)V", "timeout", "shutdown", "(J)V", "submitToLocalQueue", "(Lkotlinx/coroutines/scheduling/Task;Z)I", "toString", "()Ljava/lang/String;", "tryUnpark", "()Z", "getBlockingWorkers", "I", "Ljava/util/concurrent/Semaphore;", "cpuPermits", "Ljava/util/concurrent/Semaphore;", "getCreatedWorkers", "Lkotlinx/coroutines/scheduling/GlobalQueue;", "globalQueue", "Lkotlinx/coroutines/scheduling/GlobalQueue;", "J", "isTerminated", "Ljava/util/Random;", "random", "Ljava/util/Random;", "Ljava/lang/String;", "", "workers", "[Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", "Companion", "Worker", "WorkerState", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class CoroutineScheduler implements Executor, Closeable {
    private static final int ADDED = -1;
    private static final int ADDED_REQUIRES_HELP = 0;
    private static final int ALLOWED = 0;
    private static final long BLOCKING_MASK = 4398044413952L;
    private static final int BLOCKING_SHIFT = 21;
    private static final long CREATED_MASK = 2097151;
    public static final Companion Companion = new Companion(null);
    private static final int FORBIDDEN = -1;
    private static final int MAX_PARK_TIME_NS;
    private static final int MAX_SPINS;
    public static final int MAX_SUPPORTED_POOL_SIZE = 2097150;
    private static final int MAX_YIELDS;
    private static final int MIN_PARK_TIME_NS;
    public static final int MIN_SUPPORTED_POOL_SIZE = 1;
    private static final int NOT_ADDED = 1;
    private static final Symbol NOT_IN_STACK;
    private static final long PARKED_INDEX_MASK = 2097151;
    private static final long PARKED_VERSION_INC = 2097152;
    private static final long PARKED_VERSION_MASK = -2097152;
    private static final int TERMINATED = 1;
    private static final AtomicIntegerFieldUpdater _isTerminated$FU;
    static final AtomicLongFieldUpdater controlState$FU;
    private static final AtomicLongFieldUpdater parkedWorkersStack$FU;
    private volatile int _isTerminated;
    volatile long controlState;
    private final int corePoolSize;
    private final Semaphore cpuPermits;
    private final GlobalQueue globalQueue;
    private final long idleWorkerKeepAliveNs;
    private final int maxPoolSize;
    private volatile long parkedWorkersStack;
    private final Random random;
    private final String schedulerName;
    private final Worker[] workers;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 15})
    /* loaded from: classes2.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[WorkerState.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[WorkerState.PARKING.ordinal()] = 1;
            $EnumSwitchMapping$0[WorkerState.BLOCKING.ordinal()] = 2;
            $EnumSwitchMapping$0[WorkerState.CPU_ACQUIRED.ordinal()] = 3;
            $EnumSwitchMapping$0[WorkerState.RETIRING.ordinal()] = 4;
            $EnumSwitchMapping$0[WorkerState.TERMINATED.ordinal()] = 5;
        }
    }

    /* compiled from: CoroutineScheduler.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "", "(Ljava/lang/String;I)V", "CPU_ACQUIRED", "BLOCKING", "PARKING", "RETIRING", "TERMINATED", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15})
    /* loaded from: classes2.dex */
    public enum WorkerState {
        CPU_ACQUIRED,
        BLOCKING,
        PARKING,
        RETIRING,
        TERMINATED
    }

    private final int blockingWorkers(long j) {
        return (int) ((j & BLOCKING_MASK) >> 21);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int createdWorkers(long j) {
        return (int) (j & 2097151);
    }

    public CoroutineScheduler(int i, int i2, long j, String schedulerName) {
        Intrinsics.checkParameterIsNotNull(schedulerName, "schedulerName");
        this.corePoolSize = i;
        this.maxPoolSize = i2;
        this.idleWorkerKeepAliveNs = j;
        this.schedulerName = schedulerName;
        if (!(i >= 1)) {
            throw new IllegalArgumentException(("Core pool size " + this.corePoolSize + " should be at least 1").toString());
        }
        if (!(this.maxPoolSize >= this.corePoolSize)) {
            throw new IllegalArgumentException(("Max pool size " + this.maxPoolSize + " should be greater than or equals to core pool size " + this.corePoolSize).toString());
        }
        if (!(this.maxPoolSize <= 2097150)) {
            throw new IllegalArgumentException(("Max pool size " + this.maxPoolSize + " should not exceed maximal supported number of threads 2097150").toString());
        }
        if (!(this.idleWorkerKeepAliveNs > 0)) {
            throw new IllegalArgumentException(("Idle worker keep alive time " + this.idleWorkerKeepAliveNs + " must be positive").toString());
        }
        this.globalQueue = new GlobalQueue();
        this.cpuPermits = new Semaphore(this.corePoolSize, false);
        this.parkedWorkersStack = 0L;
        this.workers = new Worker[this.maxPoolSize + 1];
        this.controlState = 0L;
        this.random = new Random();
        this._isTerminated = 0;
    }

    public /* synthetic */ CoroutineScheduler(int i, int i2, long j, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, (i3 & 4) != 0 ? TasksKt.IDLE_WORKER_KEEP_ALIVE_NS : j, (i3 & 8) != 0 ? TasksKt.DEFAULT_SCHEDULER_NAME : str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void parkedWorkersStackPush(Worker worker) {
        long j;
        long j2;
        int indexInArray;
        if (worker.getNextParkedWorker() != NOT_IN_STACK) {
            return;
        }
        do {
            j = this.parkedWorkersStack;
            int i = (int) (2097151 & j);
            j2 = (2097152 + j) & PARKED_VERSION_MASK;
            indexInArray = worker.getIndexInArray();
            if (DebugKt.getASSERTIONS_ENABLED()) {
                if (!(indexInArray != 0)) {
                    throw new AssertionError();
                }
            }
            worker.setNextParkedWorker(this.workers[i]);
        } while (!parkedWorkersStack$FU.compareAndSet(this, j, indexInArray | j2));
    }

    private final int parkedWorkersStackNextIndex(Worker worker) {
        Object nextParkedWorker = worker.getNextParkedWorker();
        while (nextParkedWorker != NOT_IN_STACK) {
            if (nextParkedWorker == null) {
                return 0;
            }
            Worker worker2 = (Worker) nextParkedWorker;
            int indexInArray = worker2.getIndexInArray();
            if (indexInArray != 0) {
                return indexInArray;
            }
            nextParkedWorker = worker2.getNextParkedWorker();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getCreatedWorkers() {
        return (int) (this.controlState & 2097151);
    }

    private final int getBlockingWorkers() {
        return (int) ((this.controlState & BLOCKING_MASK) >> 21);
    }

    private final int incrementCreatedWorkers() {
        return (int) (controlState$FU.incrementAndGet(this) & 2097151);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int decrementCreatedWorkers() {
        return (int) (controlState$FU.getAndDecrement(this) & 2097151);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void incrementBlockingWorkers() {
        controlState$FU.addAndGet(this, 2097152L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void decrementBlockingWorkers() {
        controlState$FU.addAndGet(this, PARKED_VERSION_MASK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isTerminated() {
        return this._isTerminated != 0;
    }

    /* compiled from: CoroutineScheduler.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\u00020\u00048\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\r\u0010\u0002R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\u00020\u00048\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0012\u0010\u0002R\u000e\u0010\u0013\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler$Companion;", "", "()V", "ADDED", "", "ADDED_REQUIRES_HELP", "ALLOWED", "BLOCKING_MASK", "", "BLOCKING_SHIFT", "CREATED_MASK", "FORBIDDEN", "MAX_PARK_TIME_NS", "MAX_PARK_TIME_NS$annotations", "MAX_SPINS", "MAX_SUPPORTED_POOL_SIZE", "MAX_YIELDS", "MIN_PARK_TIME_NS", "MIN_PARK_TIME_NS$annotations", "MIN_SUPPORTED_POOL_SIZE", "NOT_ADDED", "NOT_IN_STACK", "Lkotlinx/coroutines/internal/Symbol;", "PARKED_INDEX_MASK", "PARKED_VERSION_INC", "PARKED_VERSION_MASK", "TERMINATED", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15})
    /* loaded from: classes2.dex */
    public static final class Companion {
        @JvmStatic
        private static /* synthetic */ void MAX_PARK_TIME_NS$annotations() {
        }

        @JvmStatic
        private static /* synthetic */ void MIN_PARK_TIME_NS$annotations() {
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        int systemProp$default;
        int systemProp$default2;
        systemProp$default = SystemPropsKt__SystemProps_commonKt.systemProp$default("kotlinx.coroutines.scheduler.spins", 1000, 1, 0, 8, (Object) null);
        MAX_SPINS = systemProp$default;
        systemProp$default2 = SystemPropsKt__SystemProps_commonKt.systemProp$default("kotlinx.coroutines.scheduler.yields", 0, 0, 0, 8, (Object) null);
        MAX_YIELDS = systemProp$default + systemProp$default2;
        MAX_PARK_TIME_NS = (int) TimeUnit.SECONDS.toNanos(1L);
        MIN_PARK_TIME_NS = (int) RangesKt.coerceAtMost(RangesKt.coerceAtLeast(TasksKt.WORK_STEALING_TIME_RESOLUTION_NS / 4, 10L), MAX_PARK_TIME_NS);
        NOT_IN_STACK = new Symbol("NOT_IN_STACK");
        parkedWorkersStack$FU = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "parkedWorkersStack");
        controlState$FU = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "controlState");
        _isTerminated$FU = AtomicIntegerFieldUpdater.newUpdater(CoroutineScheduler.class, "_isTerminated");
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable command) {
        Intrinsics.checkParameterIsNotNull(command, "command");
        dispatch$default(this, command, null, false, 6, null);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        shutdown(10000L);
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x006d, code lost:
        if (r9 != null) goto L39;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void shutdown(long r9) {
        /*
            r8 = this;
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = kotlinx.coroutines.scheduling.CoroutineScheduler._isTerminated$FU
            r1 = 0
            r2 = 1
            boolean r0 = r0.compareAndSet(r8, r1, r2)
            if (r0 != 0) goto Lb
            return
        Lb:
            kotlinx.coroutines.scheduling.CoroutineScheduler$Worker r0 = r8.currentWorker()
            kotlinx.coroutines.scheduling.CoroutineScheduler$Worker[] r3 = r8.workers
            monitor-enter(r3)
            long r4 = r8.controlState     // Catch: java.lang.Throwable -> La8
            r6 = 2097151(0x1fffff, double:1.0361303E-317)
            long r4 = r4 & r6
            int r4 = (int) r4
            monitor-exit(r3)
            if (r2 > r4) goto L62
            r3 = r2
        L1d:
            kotlinx.coroutines.scheduling.CoroutineScheduler$Worker[] r5 = r8.workers
            r5 = r5[r3]
            if (r5 != 0) goto L26
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L26:
            if (r5 == r0) goto L5d
        L28:
            boolean r6 = r5.isAlive()
            if (r6 == 0) goto L38
            r6 = r5
            java.lang.Thread r6 = (java.lang.Thread) r6
            java.util.concurrent.locks.LockSupport.unpark(r6)
            r5.join(r9)
            goto L28
        L38:
            kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState r6 = r5.getState()
            boolean r7 = kotlinx.coroutines.DebugKt.getASSERTIONS_ENABLED()
            if (r7 == 0) goto L54
            kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState r7 = kotlinx.coroutines.scheduling.CoroutineScheduler.WorkerState.TERMINATED
            if (r6 != r7) goto L48
            r6 = r2
            goto L49
        L48:
            r6 = r1
        L49:
            if (r6 == 0) goto L4c
            goto L54
        L4c:
            java.lang.AssertionError r9 = new java.lang.AssertionError
            r9.<init>()
            java.lang.Throwable r9 = (java.lang.Throwable) r9
            throw r9
        L54:
            kotlinx.coroutines.scheduling.WorkQueue r5 = r5.getLocalQueue()
            kotlinx.coroutines.scheduling.GlobalQueue r6 = r8.globalQueue
            r5.offloadAllWork$kotlinx_coroutines_core(r6)
        L5d:
            if (r3 == r4) goto L62
            int r3 = r3 + 1
            goto L1d
        L62:
            kotlinx.coroutines.scheduling.GlobalQueue r9 = r8.globalQueue
            r9.close()
        L67:
            if (r0 == 0) goto L70
            kotlinx.coroutines.scheduling.Task r9 = r0.findTask$kotlinx_coroutines_core()
            if (r9 == 0) goto L70
            goto L78
        L70:
            kotlinx.coroutines.scheduling.GlobalQueue r9 = r8.globalQueue
            java.lang.Object r9 = r9.removeFirstOrNull()
            kotlinx.coroutines.scheduling.Task r9 = (kotlinx.coroutines.scheduling.Task) r9
        L78:
            if (r9 == 0) goto L7e
            r8.runSafely(r9)
            goto L67
        L7e:
            if (r0 == 0) goto L85
            kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState r9 = kotlinx.coroutines.scheduling.CoroutineScheduler.WorkerState.TERMINATED
            r0.tryReleaseCpu$kotlinx_coroutines_core(r9)
        L85:
            boolean r9 = kotlinx.coroutines.DebugKt.getASSERTIONS_ENABLED()
            if (r9 == 0) goto La1
            java.util.concurrent.Semaphore r9 = r8.cpuPermits
            int r9 = r9.availablePermits()
            int r10 = r8.corePoolSize
            if (r9 != r10) goto L96
            r1 = r2
        L96:
            if (r1 == 0) goto L99
            goto La1
        L99:
            java.lang.AssertionError r9 = new java.lang.AssertionError
            r9.<init>()
            java.lang.Throwable r9 = (java.lang.Throwable) r9
            throw r9
        La1:
            r9 = 0
            r8.parkedWorkersStack = r9
            r8.controlState = r9
            return
        La8:
            r9 = move-exception
            monitor-exit(r3)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.scheduling.CoroutineScheduler.shutdown(long):void");
    }

    public static /* synthetic */ void dispatch$default(CoroutineScheduler coroutineScheduler, Runnable runnable, TaskContext taskContext, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            taskContext = NonBlockingContext.INSTANCE;
        }
        if ((i & 4) != 0) {
            z = false;
        }
        coroutineScheduler.dispatch(runnable, taskContext, z);
    }

    public final void dispatch(Runnable block, TaskContext taskContext, boolean z) {
        Intrinsics.checkParameterIsNotNull(block, "block");
        Intrinsics.checkParameterIsNotNull(taskContext, "taskContext");
        kotlinx.coroutines.TimeSource timeSource = TimeSourceKt.getTimeSource();
        if (timeSource != null) {
            timeSource.trackTask();
        }
        Task createTask$kotlinx_coroutines_core = createTask$kotlinx_coroutines_core(block, taskContext);
        int submitToLocalQueue = submitToLocalQueue(createTask$kotlinx_coroutines_core, z);
        if (submitToLocalQueue != -1) {
            if (submitToLocalQueue == 1) {
                if (!this.globalQueue.addLast(createTask$kotlinx_coroutines_core)) {
                    throw new RejectedExecutionException(this.schedulerName + " was terminated");
                }
                requestCpuWorker();
                return;
            }
            requestCpuWorker();
        }
    }

    public final Task createTask$kotlinx_coroutines_core(Runnable block, TaskContext taskContext) {
        Intrinsics.checkParameterIsNotNull(block, "block");
        Intrinsics.checkParameterIsNotNull(taskContext, "taskContext");
        long nanoTime = TasksKt.schedulerTimeSource.nanoTime();
        if (block instanceof Task) {
            Task task = (Task) block;
            task.submissionTime = nanoTime;
            task.taskContext = taskContext;
            return task;
        }
        return new TaskImpl(block, nanoTime, taskContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void requestCpuWorker() {
        if (this.cpuPermits.availablePermits() == 0) {
            tryUnpark();
        } else if (tryUnpark()) {
        } else {
            long j = this.controlState;
            if (((int) (2097151 & j)) - ((int) ((j & BLOCKING_MASK) >> 21)) < this.corePoolSize) {
                int createNewWorker = createNewWorker();
                if (createNewWorker == 1 && this.corePoolSize > 1) {
                    createNewWorker();
                }
                if (createNewWorker > 0) {
                    return;
                }
            }
            tryUnpark();
        }
    }

    private final boolean tryUnpark() {
        while (true) {
            Worker parkedWorkersStackPop = parkedWorkersStackPop();
            if (parkedWorkersStackPop == null) {
                return false;
            }
            parkedWorkersStackPop.idleResetBeforeUnpark();
            boolean isParking = parkedWorkersStackPop.isParking();
            LockSupport.unpark(parkedWorkersStackPop);
            if (isParking && parkedWorkersStackPop.tryForbidTermination()) {
                return true;
            }
        }
    }

    private final int createNewWorker() {
        synchronized (this.workers) {
            if (isTerminated()) {
                return -1;
            }
            long j = this.controlState;
            int i = (int) (j & 2097151);
            int i2 = i - ((int) ((j & BLOCKING_MASK) >> 21));
            if (i2 >= this.corePoolSize) {
                return 0;
            }
            if (i < this.maxPoolSize && this.cpuPermits.availablePermits() != 0) {
                int i3 = ((int) (this.controlState & 2097151)) + 1;
                if (!(i3 > 0 && this.workers[i3] == null)) {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
                Worker worker = new Worker(this, i3);
                worker.start();
                if (!(i3 == ((int) (2097151 & controlState$FU.incrementAndGet(this))))) {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
                this.workers[i3] = worker;
                return i2 + 1;
            }
            return 0;
        }
    }

    private final int submitToLocalQueue(Task task, boolean z) {
        boolean add;
        Worker currentWorker = currentWorker();
        if (currentWorker == null || currentWorker.getState() == WorkerState.TERMINATED) {
            return 1;
        }
        int i = -1;
        if (task.getMode() == TaskMode.NON_BLOCKING) {
            if (currentWorker.isBlocking()) {
                i = 0;
            } else if (!currentWorker.tryAcquireCpuPermit()) {
                return 1;
            }
        }
        if (z) {
            add = currentWorker.getLocalQueue().addLast(task, this.globalQueue);
        } else {
            add = currentWorker.getLocalQueue().add(task, this.globalQueue);
        }
        if (!add || currentWorker.getLocalQueue().getBufferSize$kotlinx_coroutines_core() > TasksKt.QUEUE_SIZE_OFFLOAD_THRESHOLD) {
            return 0;
        }
        return i;
    }

    private final Worker currentWorker() {
        Thread currentThread = Thread.currentThread();
        if (!(currentThread instanceof Worker)) {
            currentThread = null;
        }
        Worker worker = (Worker) currentThread;
        if (worker == null || !Intrinsics.areEqual(worker.getScheduler(), this)) {
            return null;
        }
        return worker;
    }

    public String toString() {
        Worker[] workerArr;
        ArrayList arrayList = new ArrayList();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        for (Worker worker : this.workers) {
            if (worker != null) {
                int size$kotlinx_coroutines_core = worker.getLocalQueue().size$kotlinx_coroutines_core();
                int i6 = WhenMappings.$EnumSwitchMapping$0[worker.getState().ordinal()];
                if (i6 == 1) {
                    i3++;
                } else if (i6 == 2) {
                    i2++;
                    arrayList.add(String.valueOf(size$kotlinx_coroutines_core) + ViewUtil.KEY_B);
                } else if (i6 == 3) {
                    i++;
                    arrayList.add(String.valueOf(size$kotlinx_coroutines_core) + "c");
                } else if (i6 == 4) {
                    i4++;
                    if (size$kotlinx_coroutines_core > 0) {
                        arrayList.add(String.valueOf(size$kotlinx_coroutines_core) + "r");
                    }
                } else if (i6 == 5) {
                    i5++;
                }
            }
        }
        long j = this.controlState;
        return this.schedulerName + '@' + DebugStringsKt.getHexAddress(this) + "[Pool Size {core = " + this.corePoolSize + ", max = " + this.maxPoolSize + "}, Worker States {CPU = " + i + ", blocking = " + i2 + ", parked = " + i3 + ", retired = " + i4 + ", terminated = " + i5 + "}, running workers queues = " + arrayList + ", global queue size = " + this.globalQueue.getSize() + ", Control State Workers {created = " + ((int) (2097151 & j)) + ", blocking = " + ((int) ((j & BLOCKING_MASK) >> 21)) + "}]";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void runSafely(Task task) {
        try {
            task.run();
        } catch (Throwable th) {
            try {
                Thread thread = Thread.currentThread();
                Intrinsics.checkExpressionValueIsNotNull(thread, "thread");
                thread.getUncaughtExceptionHandler().uncaughtException(thread, th);
                kotlinx.coroutines.TimeSource timeSource = TimeSourceKt.getTimeSource();
                if (timeSource == null) {
                }
            } finally {
                kotlinx.coroutines.TimeSource timeSource2 = TimeSourceKt.getTimeSource();
                if (timeSource2 != null) {
                    timeSource2.unTrackTask();
                }
            }
        }
    }

    /* compiled from: CoroutineScheduler.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000e\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0015\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0011\u0010\u001c\u001a\u0004\u0018\u00010\u0019H\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\u0011\u0010\u001d\u001a\u0004\u0018\u00010\u0019H\u0002¢\u0006\u0004\b\u001d\u0010\u001bJ\u0017\u0010\u001f\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001f\u0010\u000bJ\r\u0010 \u001a\u00020\t¢\u0006\u0004\b \u0010\u0014J\u0017\u0010$\u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\"\u0010#J\u000f\u0010%\u001a\u00020\tH\u0016¢\u0006\u0004\b%\u0010\u0014J\r\u0010&\u001a\u00020\u0010¢\u0006\u0004\b&\u0010\u0012J\r\u0010'\u001a\u00020\u0010¢\u0006\u0004\b'\u0010\u0012J\u0017\u0010,\u001a\u00020\u00102\u0006\u0010)\u001a\u00020(H\u0000¢\u0006\u0004\b*\u0010+J\u0011\u0010-\u001a\u0004\u0018\u00010\u0019H\u0002¢\u0006\u0004\b-\u0010\u001bJ\u000f\u0010.\u001a\u00020\tH\u0002¢\u0006\u0004\b.\u0010\u0014R*\u0010/\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u0013\u00105\u001a\u00020\u00108F@\u0006¢\u0006\u0006\u001a\u0004\b5\u0010\u0012R\u0013\u00106\u001a\u00020\u00108F@\u0006¢\u0006\u0006\u001a\u0004\b6\u0010\u0012R\u0016\u00107\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u00109\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u00100R\u0019\u0010;\u001a\u00020:8\u0006@\u0006¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>R$\u0010@\u001a\u0004\u0018\u00010?8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u0016\u0010F\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u00100R\u0016\u0010G\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u00100R\u0013\u0010K\u001a\u00020H8F@\u0006¢\u0006\u0006\u001a\u0004\bI\u0010JR\u0016\u0010L\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u00100R\"\u0010M\u001a\u00020(8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bM\u0010N\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\u0016\u0010S\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u00108¨\u0006T"}, d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", "Ljava/lang/Thread;", "", "index", "<init>", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler;I)V", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler;)V", "Lkotlinx/coroutines/scheduling/TaskMode;", "taskMode", "", "afterTask", "(Lkotlinx/coroutines/scheduling/TaskMode;)V", "", "taskSubmissionTime", "beforeTask", "(Lkotlinx/coroutines/scheduling/TaskMode;J)V", "", "blockingQuiescence", "()Z", "blockingWorkerIdle", "()V", "cpuWorkerIdle", "nanos", "doPark", "(J)Z", "Lkotlinx/coroutines/scheduling/Task;", "findTask$kotlinx_coroutines_core", "()Lkotlinx/coroutines/scheduling/Task;", "findTask", "findTaskWithCpuPermit", "mode", "idleReset", "idleResetBeforeUnpark", "upperBound", "nextInt$kotlinx_coroutines_core", "(I)I", "nextInt", "run", "tryAcquireCpuPermit", "tryForbidTermination", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "newState", "tryReleaseCpu$kotlinx_coroutines_core", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;)Z", "tryReleaseCpu", "trySteal", "tryTerminateWorker", "indexInArray", "I", "getIndexInArray", "()I", "setIndexInArray", "(I)V", "isBlocking", "isParking", "lastExhaustionTime", "J", "lastStealIndex", "Lkotlinx/coroutines/scheduling/WorkQueue;", "localQueue", "Lkotlinx/coroutines/scheduling/WorkQueue;", "getLocalQueue", "()Lkotlinx/coroutines/scheduling/WorkQueue;", "", "nextParkedWorker", "Ljava/lang/Object;", "getNextParkedWorker", "()Ljava/lang/Object;", "setNextParkedWorker", "(Ljava/lang/Object;)V", "parkTimeNs", "rngState", "Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "getScheduler", "()Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "scheduler", "spins", "state", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "getState", "()Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "setState", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;)V", "terminationDeadline", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15})
    /* loaded from: classes2.dex */
    public final class Worker extends Thread {
        private static final AtomicIntegerFieldUpdater terminationState$FU = AtomicIntegerFieldUpdater.newUpdater(Worker.class, "terminationState");
        private volatile int indexInArray;
        private long lastExhaustionTime;
        private int lastStealIndex;
        private final WorkQueue localQueue;
        private volatile Object nextParkedWorker;
        private int parkTimeNs;
        private int rngState;
        private volatile int spins;
        private volatile WorkerState state;
        private long terminationDeadline;
        private volatile int terminationState;

        private Worker() {
            setDaemon(true);
            this.localQueue = new WorkQueue();
            this.state = WorkerState.RETIRING;
            this.terminationState = 0;
            this.nextParkedWorker = CoroutineScheduler.NOT_IN_STACK;
            this.parkTimeNs = CoroutineScheduler.MIN_PARK_TIME_NS;
            this.rngState = CoroutineScheduler.this.random.nextInt();
        }

        public final int getIndexInArray() {
            return this.indexInArray;
        }

        public final void setIndexInArray(int i) {
            StringBuilder sb = new StringBuilder();
            sb.append(CoroutineScheduler.this.schedulerName);
            sb.append("-worker-");
            sb.append(i == 0 ? "TERMINATED" : String.valueOf(i));
            setName(sb.toString());
            this.indexInArray = i;
        }

        public Worker(CoroutineScheduler coroutineScheduler, int i) {
            this();
            setIndexInArray(i);
        }

        public final CoroutineScheduler getScheduler() {
            return CoroutineScheduler.this;
        }

        public final WorkQueue getLocalQueue() {
            return this.localQueue;
        }

        @Override // java.lang.Thread
        public final WorkerState getState() {
            return this.state;
        }

        public final void setState(WorkerState workerState) {
            Intrinsics.checkParameterIsNotNull(workerState, "<set-?>");
            this.state = workerState;
        }

        public final boolean isParking() {
            return this.state == WorkerState.PARKING;
        }

        public final boolean isBlocking() {
            return this.state == WorkerState.BLOCKING;
        }

        public final Object getNextParkedWorker() {
            return this.nextParkedWorker;
        }

        public final void setNextParkedWorker(Object obj) {
            this.nextParkedWorker = obj;
        }

        public final boolean tryForbidTermination() {
            int i = this.terminationState;
            if (i == 1 || i == -1) {
                return false;
            }
            if (i == 0) {
                return terminationState$FU.compareAndSet(this, 0, -1);
            }
            throw new IllegalStateException(("Invalid terminationState = " + i).toString());
        }

        public final boolean tryAcquireCpuPermit() {
            if (this.state == WorkerState.CPU_ACQUIRED) {
                return true;
            }
            if (CoroutineScheduler.this.cpuPermits.tryAcquire()) {
                this.state = WorkerState.CPU_ACQUIRED;
                return true;
            }
            return false;
        }

        public final boolean tryReleaseCpu$kotlinx_coroutines_core(WorkerState newState) {
            Intrinsics.checkParameterIsNotNull(newState, "newState");
            WorkerState workerState = this.state;
            boolean z = workerState == WorkerState.CPU_ACQUIRED;
            if (z) {
                CoroutineScheduler.this.cpuPermits.release();
            }
            if (workerState != newState) {
                this.state = newState;
            }
            return z;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            boolean z = false;
            while (!CoroutineScheduler.this.isTerminated() && this.state != WorkerState.TERMINATED) {
                Task findTask$kotlinx_coroutines_core = findTask$kotlinx_coroutines_core();
                if (findTask$kotlinx_coroutines_core == null) {
                    if (this.state == WorkerState.CPU_ACQUIRED) {
                        cpuWorkerIdle();
                    } else {
                        blockingWorkerIdle();
                    }
                    z = true;
                } else {
                    TaskMode mode = findTask$kotlinx_coroutines_core.getMode();
                    if (z) {
                        idleReset(mode);
                        z = false;
                    }
                    beforeTask(mode, findTask$kotlinx_coroutines_core.submissionTime);
                    CoroutineScheduler.this.runSafely(findTask$kotlinx_coroutines_core);
                    afterTask(mode);
                }
            }
            tryReleaseCpu$kotlinx_coroutines_core(WorkerState.TERMINATED);
        }

        private final void beforeTask(TaskMode taskMode, long j) {
            if (taskMode == TaskMode.NON_BLOCKING) {
                if (CoroutineScheduler.this.cpuPermits.availablePermits() == 0) {
                    return;
                }
                long nanoTime = TasksKt.schedulerTimeSource.nanoTime();
                if (nanoTime - j < TasksKt.WORK_STEALING_TIME_RESOLUTION_NS || nanoTime - this.lastExhaustionTime < TasksKt.WORK_STEALING_TIME_RESOLUTION_NS * 5) {
                    return;
                }
                this.lastExhaustionTime = nanoTime;
                CoroutineScheduler.this.requestCpuWorker();
                return;
            }
            CoroutineScheduler.controlState$FU.addAndGet(CoroutineScheduler.this, 2097152L);
            if (tryReleaseCpu$kotlinx_coroutines_core(WorkerState.BLOCKING)) {
                CoroutineScheduler.this.requestCpuWorker();
            }
        }

        private final void afterTask(TaskMode taskMode) {
            if (taskMode != TaskMode.NON_BLOCKING) {
                CoroutineScheduler.controlState$FU.addAndGet(CoroutineScheduler.this, CoroutineScheduler.PARKED_VERSION_MASK);
                WorkerState workerState = this.state;
                if (workerState != WorkerState.TERMINATED) {
                    if (DebugKt.getASSERTIONS_ENABLED()) {
                        if (!(workerState == WorkerState.BLOCKING)) {
                            throw new AssertionError();
                        }
                    }
                    this.state = WorkerState.RETIRING;
                }
            }
        }

        public final int nextInt$kotlinx_coroutines_core(int i) {
            int i2 = this.rngState;
            int i3 = i2 ^ (i2 << 13);
            this.rngState = i3;
            int i4 = i3 ^ (i3 >> 17);
            this.rngState = i4;
            int i5 = i4 ^ (i4 << 5);
            this.rngState = i5;
            int i6 = i - 1;
            return (i6 & i) == 0 ? i5 & i6 : (i5 & Integer.MAX_VALUE) % i;
        }

        private final void cpuWorkerIdle() {
            int i = this.spins;
            if (i > CoroutineScheduler.MAX_YIELDS) {
                if (this.parkTimeNs < CoroutineScheduler.MAX_PARK_TIME_NS) {
                    this.parkTimeNs = RangesKt.coerceAtMost((this.parkTimeNs * 3) >>> 1, CoroutineScheduler.MAX_PARK_TIME_NS);
                }
                tryReleaseCpu$kotlinx_coroutines_core(WorkerState.PARKING);
                doPark(this.parkTimeNs);
                return;
            }
            this.spins = i + 1;
            if (i >= CoroutineScheduler.MAX_SPINS) {
                Thread.yield();
            }
        }

        private final void blockingWorkerIdle() {
            tryReleaseCpu$kotlinx_coroutines_core(WorkerState.PARKING);
            if (blockingQuiescence()) {
                this.terminationState = 0;
                if (this.terminationDeadline == 0) {
                    this.terminationDeadline = System.nanoTime() + CoroutineScheduler.this.idleWorkerKeepAliveNs;
                }
                if (doPark(CoroutineScheduler.this.idleWorkerKeepAliveNs) && System.nanoTime() - this.terminationDeadline >= 0) {
                    this.terminationDeadline = 0L;
                    tryTerminateWorker();
                }
            }
        }

        private final boolean doPark(long j) {
            CoroutineScheduler.this.parkedWorkersStackPush(this);
            if (blockingQuiescence()) {
                LockSupport.parkNanos(j);
                return true;
            }
            return false;
        }

        private final void tryTerminateWorker() {
            synchronized (CoroutineScheduler.this.workers) {
                if (CoroutineScheduler.this.isTerminated()) {
                    return;
                }
                if (CoroutineScheduler.this.getCreatedWorkers() <= CoroutineScheduler.this.corePoolSize) {
                    return;
                }
                if (blockingQuiescence()) {
                    if (terminationState$FU.compareAndSet(this, 0, 1)) {
                        int i = this.indexInArray;
                        setIndexInArray(0);
                        CoroutineScheduler.this.parkedWorkersStackTopUpdate(this, i, 0);
                        int andDecrement = (int) (CoroutineScheduler.controlState$FU.getAndDecrement(CoroutineScheduler.this) & 2097151);
                        if (andDecrement != i) {
                            Worker worker = CoroutineScheduler.this.workers[andDecrement];
                            if (worker == null) {
                                Intrinsics.throwNpe();
                            }
                            CoroutineScheduler.this.workers[i] = worker;
                            worker.setIndexInArray(i);
                            CoroutineScheduler.this.parkedWorkersStackTopUpdate(worker, andDecrement, i);
                        }
                        CoroutineScheduler.this.workers[andDecrement] = null;
                        Unit unit = Unit.INSTANCE;
                        this.state = WorkerState.TERMINATED;
                    }
                }
            }
        }

        private final boolean blockingQuiescence() {
            Task removeFirstWithModeOrNull = CoroutineScheduler.this.globalQueue.removeFirstWithModeOrNull(TaskMode.PROBABLY_BLOCKING);
            if (removeFirstWithModeOrNull != null) {
                this.localQueue.add(removeFirstWithModeOrNull, CoroutineScheduler.this.globalQueue);
                return false;
            }
            return true;
        }

        private final void idleReset(TaskMode taskMode) {
            this.terminationDeadline = 0L;
            this.lastStealIndex = 0;
            if (this.state == WorkerState.PARKING) {
                if (DebugKt.getASSERTIONS_ENABLED()) {
                    if (!(taskMode == TaskMode.PROBABLY_BLOCKING)) {
                        throw new AssertionError();
                    }
                }
                this.state = WorkerState.BLOCKING;
                this.parkTimeNs = CoroutineScheduler.MIN_PARK_TIME_NS;
            }
            this.spins = 0;
        }

        public final void idleResetBeforeUnpark() {
            this.parkTimeNs = CoroutineScheduler.MIN_PARK_TIME_NS;
            this.spins = 0;
        }

        public final Task findTask$kotlinx_coroutines_core() {
            if (tryAcquireCpuPermit()) {
                return findTaskWithCpuPermit();
            }
            Task poll = this.localQueue.poll();
            return poll != null ? poll : CoroutineScheduler.this.globalQueue.removeFirstWithModeOrNull(TaskMode.PROBABLY_BLOCKING);
        }

        private final Task findTaskWithCpuPermit() {
            Task removeFirstOrNull;
            Task removeFirstWithModeOrNull;
            boolean z = nextInt$kotlinx_coroutines_core(CoroutineScheduler.this.corePoolSize * 2) == 0;
            if (!z || (removeFirstWithModeOrNull = CoroutineScheduler.this.globalQueue.removeFirstWithModeOrNull(TaskMode.NON_BLOCKING)) == null) {
                Task poll = this.localQueue.poll();
                return poll != null ? poll : (z || (removeFirstOrNull = CoroutineScheduler.this.globalQueue.removeFirstOrNull()) == null) ? trySteal() : removeFirstOrNull;
            }
            return removeFirstWithModeOrNull;
        }

        private final Task trySteal() {
            int createdWorkers = CoroutineScheduler.this.getCreatedWorkers();
            if (createdWorkers < 2) {
                return null;
            }
            int i = this.lastStealIndex;
            if (i == 0) {
                i = nextInt$kotlinx_coroutines_core(createdWorkers);
            }
            int i2 = i + 1;
            int i3 = i2 <= createdWorkers ? i2 : 1;
            this.lastStealIndex = i3;
            Worker worker = CoroutineScheduler.this.workers[i3];
            if (worker == null || worker == this || !this.localQueue.trySteal(worker.localQueue, CoroutineScheduler.this.globalQueue)) {
                return null;
            }
            return this.localQueue.poll();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void parkedWorkersStackTopUpdate(Worker worker, int i, int i2) {
        while (true) {
            long j = this.parkedWorkersStack;
            int i3 = (int) (2097151 & j);
            long j2 = (2097152 + j) & PARKED_VERSION_MASK;
            if (i3 == i) {
                i3 = i2 == 0 ? parkedWorkersStackNextIndex(worker) : i2;
            }
            if (i3 >= 0 && parkedWorkersStack$FU.compareAndSet(this, j, j2 | i3)) {
                return;
            }
        }
    }

    private final Worker parkedWorkersStackPop() {
        while (true) {
            long j = this.parkedWorkersStack;
            Worker worker = this.workers[(int) (2097151 & j)];
            if (worker == null) {
                return null;
            }
            long j2 = (2097152 + j) & PARKED_VERSION_MASK;
            int parkedWorkersStackNextIndex = parkedWorkersStackNextIndex(worker);
            if (parkedWorkersStackNextIndex >= 0 && parkedWorkersStack$FU.compareAndSet(this, j, parkedWorkersStackNextIndex | j2)) {
                worker.setNextParkedWorker(NOT_IN_STACK);
                return worker;
            }
        }
    }
}
