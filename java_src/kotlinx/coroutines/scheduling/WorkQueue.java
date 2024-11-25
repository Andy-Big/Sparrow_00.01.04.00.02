package kotlinx.coroutines.scheduling;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
/* compiled from: WorkQueue.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\nJ\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0012\u0010\u0010J\u000f\u0010\u0013\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0013\u0010\u0014J(\u0010\u0017\u001a\u0004\u0018\u00010\u00042\u0014\b\u0002\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0015H\u0082\b¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001c\u001a\u00020\u0019H\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u001d\u0010 \u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b \u0010!J'\u0010$\u001a\u00020\b2\u0006\u0010#\u001a\u00020\"2\u0006\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b$\u0010%R\u001e\u0010'\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040&8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010*\u001a\u00020\u00198@@\u0000X\u0080\u0004¢\u0006\u0006\u001a\u0004\b)\u0010\u001b¨\u0006+"}, d2 = {"Lkotlinx/coroutines/scheduling/WorkQueue;", "", "<init>", "()V", "Lkotlinx/coroutines/scheduling/Task;", "task", "Lkotlinx/coroutines/scheduling/GlobalQueue;", "globalQueue", "", "add", "(Lkotlinx/coroutines/scheduling/Task;Lkotlinx/coroutines/scheduling/GlobalQueue;)Z", "addLast", "", "addToGlobalQueue", "(Lkotlinx/coroutines/scheduling/GlobalQueue;Lkotlinx/coroutines/scheduling/Task;)V", "offloadAllWork$kotlinx_coroutines_core", "(Lkotlinx/coroutines/scheduling/GlobalQueue;)V", "offloadAllWork", "offloadWork", "poll", "()Lkotlinx/coroutines/scheduling/Task;", "Lkotlin/Function1;", "predicate", "pollExternal", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/scheduling/Task;", "", "size$kotlinx_coroutines_core", "()I", "size", "tryAddLast", "(Lkotlinx/coroutines/scheduling/Task;)Z", "victim", "trySteal", "(Lkotlinx/coroutines/scheduling/WorkQueue;Lkotlinx/coroutines/scheduling/GlobalQueue;)Z", "", "time", "tryStealLastScheduled", "(JLkotlinx/coroutines/scheduling/WorkQueue;Lkotlinx/coroutines/scheduling/GlobalQueue;)Z", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "buffer", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "getBufferSize$kotlinx_coroutines_core", "bufferSize", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class WorkQueue {
    private static final AtomicReferenceFieldUpdater lastScheduledTask$FU = AtomicReferenceFieldUpdater.newUpdater(WorkQueue.class, Object.class, "lastScheduledTask");
    static final AtomicIntegerFieldUpdater producerIndex$FU = AtomicIntegerFieldUpdater.newUpdater(WorkQueue.class, "producerIndex");
    static final AtomicIntegerFieldUpdater consumerIndex$FU = AtomicIntegerFieldUpdater.newUpdater(WorkQueue.class, "consumerIndex");
    private final AtomicReferenceArray<Task> buffer = new AtomicReferenceArray<>(128);
    private volatile Object lastScheduledTask = null;
    volatile int producerIndex = 0;
    volatile int consumerIndex = 0;

    public final int getBufferSize$kotlinx_coroutines_core() {
        return this.producerIndex - this.consumerIndex;
    }

    public final Task poll() {
        Task task = (Task) lastScheduledTask$FU.getAndSet(this, null);
        if (task != null) {
            return task;
        }
        while (true) {
            int i = this.consumerIndex;
            if (i - this.producerIndex == 0) {
                return null;
            }
            int i2 = i & 127;
            if (((Task) this.buffer.get(i2)) != null && consumerIndex$FU.compareAndSet(this, i, i + 1)) {
                return (Task) this.buffer.getAndSet(i2, null);
            }
        }
    }

    public final boolean add(Task task, GlobalQueue globalQueue) {
        Intrinsics.checkParameterIsNotNull(task, "task");
        Intrinsics.checkParameterIsNotNull(globalQueue, "globalQueue");
        Task task2 = (Task) lastScheduledTask$FU.getAndSet(this, task);
        if (task2 != null) {
            return addLast(task2, globalQueue);
        }
        return true;
    }

    public final boolean addLast(Task task, GlobalQueue globalQueue) {
        Intrinsics.checkParameterIsNotNull(task, "task");
        Intrinsics.checkParameterIsNotNull(globalQueue, "globalQueue");
        boolean z = true;
        while (!tryAddLast(task)) {
            offloadWork(globalQueue);
            z = false;
        }
        return z;
    }

    public final boolean trySteal(WorkQueue victim, GlobalQueue globalQueue) {
        Task task;
        Intrinsics.checkParameterIsNotNull(victim, "victim");
        Intrinsics.checkParameterIsNotNull(globalQueue, "globalQueue");
        long nanoTime = TasksKt.schedulerTimeSource.nanoTime();
        int bufferSize$kotlinx_coroutines_core = victim.getBufferSize$kotlinx_coroutines_core();
        if (bufferSize$kotlinx_coroutines_core == 0) {
            return tryStealLastScheduled(nanoTime, victim, globalQueue);
        }
        int coerceAtLeast = RangesKt.coerceAtLeast(bufferSize$kotlinx_coroutines_core / 2, 1);
        int i = 0;
        boolean z = false;
        while (i < coerceAtLeast) {
            while (true) {
                int i2 = victim.consumerIndex;
                task = null;
                if (i2 - victim.producerIndex != 0) {
                    int i3 = i2 & 127;
                    Task task2 = (Task) victim.buffer.get(i3);
                    if (task2 != null) {
                        if (!(nanoTime - task2.submissionTime >= TasksKt.WORK_STEALING_TIME_RESOLUTION_NS || victim.getBufferSize$kotlinx_coroutines_core() > TasksKt.QUEUE_SIZE_OFFLOAD_THRESHOLD)) {
                            break;
                        } else if (consumerIndex$FU.compareAndSet(victim, i2, i2 + 1)) {
                            task = (Task) victim.buffer.getAndSet(i3, null);
                            break;
                        }
                    }
                } else {
                    break;
                }
            }
            if (task == null) {
                break;
            }
            add(task, globalQueue);
            i++;
            z = true;
        }
        return z;
    }

    private final boolean tryStealLastScheduled(long j, WorkQueue workQueue, GlobalQueue globalQueue) {
        Task task = (Task) workQueue.lastScheduledTask;
        if (task == null || j - task.submissionTime < TasksKt.WORK_STEALING_TIME_RESOLUTION_NS || !lastScheduledTask$FU.compareAndSet(workQueue, task, null)) {
            return false;
        }
        add(task, globalQueue);
        return true;
    }

    public final int size$kotlinx_coroutines_core() {
        return this.lastScheduledTask != null ? getBufferSize$kotlinx_coroutines_core() + 1 : getBufferSize$kotlinx_coroutines_core();
    }

    private final void offloadWork(GlobalQueue globalQueue) {
        Task task;
        int coerceAtLeast = RangesKt.coerceAtLeast(getBufferSize$kotlinx_coroutines_core() / 2, 1);
        for (int i = 0; i < coerceAtLeast; i++) {
            while (true) {
                int i2 = this.consumerIndex;
                task = null;
                if (i2 - this.producerIndex == 0) {
                    break;
                }
                int i3 = i2 & 127;
                if (((Task) this.buffer.get(i3)) != null && consumerIndex$FU.compareAndSet(this, i2, i2 + 1)) {
                    task = (Task) this.buffer.getAndSet(i3, null);
                    break;
                }
            }
            if (task == null) {
                return;
            }
            addToGlobalQueue(globalQueue, task);
        }
    }

    private final void addToGlobalQueue(GlobalQueue globalQueue, Task task) {
        if (!globalQueue.addLast(task)) {
            throw new IllegalStateException("GlobalQueue could not be closed yet".toString());
        }
    }

    public final void offloadAllWork$kotlinx_coroutines_core(GlobalQueue globalQueue) {
        Task task;
        Intrinsics.checkParameterIsNotNull(globalQueue, "globalQueue");
        Task task2 = (Task) lastScheduledTask$FU.getAndSet(this, null);
        if (task2 != null) {
            addToGlobalQueue(globalQueue, task2);
        }
        while (true) {
            int i = this.consumerIndex;
            if (i - this.producerIndex == 0) {
                task = null;
            } else {
                int i2 = i & 127;
                if (((Task) this.buffer.get(i2)) != null && consumerIndex$FU.compareAndSet(this, i, i + 1)) {
                    task = (Task) this.buffer.getAndSet(i2, null);
                }
            }
            if (task == null) {
                return;
            }
            addToGlobalQueue(globalQueue, task);
        }
    }

    static /* synthetic */ Task pollExternal$default(WorkQueue workQueue, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = new Function1<Task, Boolean>() { // from class: kotlinx.coroutines.scheduling.WorkQueue$pollExternal$1
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final boolean invoke2(Task it) {
                    Intrinsics.checkParameterIsNotNull(it, "it");
                    return true;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Boolean invoke(Task task) {
                    return Boolean.valueOf(invoke2(task));
                }
            };
        }
        while (true) {
            int i2 = workQueue.consumerIndex;
            if (i2 - workQueue.producerIndex == 0) {
                return null;
            }
            int i3 = i2 & 127;
            Task task = (Task) workQueue.buffer.get(i3);
            if (task != null) {
                if (!((Boolean) function1.invoke(task)).booleanValue()) {
                    return null;
                }
                if (consumerIndex$FU.compareAndSet(workQueue, i2, i2 + 1)) {
                    return (Task) workQueue.buffer.getAndSet(i3, null);
                }
            }
        }
    }

    private final Task pollExternal(Function1<? super Task, Boolean> function1) {
        while (true) {
            int i = this.consumerIndex;
            if (i - this.producerIndex == 0) {
                return null;
            }
            int i2 = i & 127;
            Task task = (Task) this.buffer.get(i2);
            if (task != null) {
                if (!function1.invoke(task).booleanValue()) {
                    return null;
                }
                if (consumerIndex$FU.compareAndSet(this, i, i + 1)) {
                    return (Task) this.buffer.getAndSet(i2, null);
                }
            }
        }
    }

    private final boolean tryAddLast(Task task) {
        if (getBufferSize$kotlinx_coroutines_core() == 127) {
            return false;
        }
        int i = this.producerIndex & 127;
        if (this.buffer.get(i) != null) {
            return false;
        }
        this.buffer.lazySet(i, task);
        producerIndex$FU.incrementAndGet(this);
        return true;
    }
}
