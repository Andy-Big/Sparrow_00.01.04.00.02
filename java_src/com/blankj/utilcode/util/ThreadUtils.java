package com.blankj.utilcode.util;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import java.lang.Thread;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes.dex */
public final class ThreadUtils {
    private static final byte TYPE_CACHED = -2;
    private static final byte TYPE_CPU = -8;
    private static final byte TYPE_IO = -4;
    private static final byte TYPE_SINGLE = -1;
    private static Executor sDeliver;
    private static final Handler HANDLER = new Handler(Looper.getMainLooper());
    private static final Map<Integer, Map<Integer, ExecutorService>> TYPE_PRIORITY_POOLS = new HashMap();
    private static final Map<Task, ExecutorService> TASK_POOL_MAP = new ConcurrentHashMap();
    private static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
    private static final Timer TIMER = new Timer();

    static /* synthetic */ Executor access$600() {
        return getGlobalDeliver();
    }

    public static boolean isMainThread() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static Handler getMainHandler() {
        return HANDLER;
    }

    public static void runOnUiThread(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            HANDLER.post(runnable);
        }
    }

    public static void runOnUiThreadDelayed(Runnable runnable, long j) {
        HANDLER.postDelayed(runnable, j);
    }

    public static ExecutorService getFixedPool(int i) {
        return getPoolByTypeAndPriority(i);
    }

    public static ExecutorService getFixedPool(int i, int i2) {
        return getPoolByTypeAndPriority(i, i2);
    }

    public static ExecutorService getSinglePool() {
        return getPoolByTypeAndPriority(-1);
    }

    public static ExecutorService getSinglePool(int i) {
        return getPoolByTypeAndPriority(-1, i);
    }

    public static ExecutorService getCachedPool() {
        return getPoolByTypeAndPriority(-2);
    }

    public static ExecutorService getCachedPool(int i) {
        return getPoolByTypeAndPriority(-2, i);
    }

    public static ExecutorService getIoPool() {
        return getPoolByTypeAndPriority(-4);
    }

    public static ExecutorService getIoPool(int i) {
        return getPoolByTypeAndPriority(-4, i);
    }

    public static ExecutorService getCpuPool() {
        return getPoolByTypeAndPriority(-8);
    }

    public static ExecutorService getCpuPool(int i) {
        return getPoolByTypeAndPriority(-8, i);
    }

    public static <T> void executeByFixed(int i, Task<T> task) {
        execute(getPoolByTypeAndPriority(i), task);
    }

    public static <T> void executeByFixed(int i, Task<T> task, int i2) {
        execute(getPoolByTypeAndPriority(i, i2), task);
    }

    public static <T> void executeByFixedWithDelay(int i, Task<T> task, long j, TimeUnit timeUnit) {
        executeWithDelay(getPoolByTypeAndPriority(i), task, j, timeUnit);
    }

    public static <T> void executeByFixedWithDelay(int i, Task<T> task, long j, TimeUnit timeUnit, int i2) {
        executeWithDelay(getPoolByTypeAndPriority(i, i2), task, j, timeUnit);
    }

    public static <T> void executeByFixedAtFixRate(int i, Task<T> task, long j, TimeUnit timeUnit) {
        executeAtFixedRate(getPoolByTypeAndPriority(i), task, 0L, j, timeUnit);
    }

    public static <T> void executeByFixedAtFixRate(int i, Task<T> task, long j, TimeUnit timeUnit, int i2) {
        executeAtFixedRate(getPoolByTypeAndPriority(i, i2), task, 0L, j, timeUnit);
    }

    public static <T> void executeByFixedAtFixRate(int i, Task<T> task, long j, long j2, TimeUnit timeUnit) {
        executeAtFixedRate(getPoolByTypeAndPriority(i), task, j, j2, timeUnit);
    }

    public static <T> void executeByFixedAtFixRate(int i, Task<T> task, long j, long j2, TimeUnit timeUnit, int i2) {
        executeAtFixedRate(getPoolByTypeAndPriority(i, i2), task, j, j2, timeUnit);
    }

    public static <T> void executeBySingle(Task<T> task) {
        execute(getPoolByTypeAndPriority(-1), task);
    }

    public static <T> void executeBySingle(Task<T> task, int i) {
        execute(getPoolByTypeAndPriority(-1, i), task);
    }

    public static <T> void executeBySingleWithDelay(Task<T> task, long j, TimeUnit timeUnit) {
        executeWithDelay(getPoolByTypeAndPriority(-1), task, j, timeUnit);
    }

    public static <T> void executeBySingleWithDelay(Task<T> task, long j, TimeUnit timeUnit, int i) {
        executeWithDelay(getPoolByTypeAndPriority(-1, i), task, j, timeUnit);
    }

    public static <T> void executeBySingleAtFixRate(Task<T> task, long j, TimeUnit timeUnit) {
        executeAtFixedRate(getPoolByTypeAndPriority(-1), task, 0L, j, timeUnit);
    }

    public static <T> void executeBySingleAtFixRate(Task<T> task, long j, TimeUnit timeUnit, int i) {
        executeAtFixedRate(getPoolByTypeAndPriority(-1, i), task, 0L, j, timeUnit);
    }

    public static <T> void executeBySingleAtFixRate(Task<T> task, long j, long j2, TimeUnit timeUnit) {
        executeAtFixedRate(getPoolByTypeAndPriority(-1), task, j, j2, timeUnit);
    }

    public static <T> void executeBySingleAtFixRate(Task<T> task, long j, long j2, TimeUnit timeUnit, int i) {
        executeAtFixedRate(getPoolByTypeAndPriority(-1, i), task, j, j2, timeUnit);
    }

    public static <T> void executeByCached(Task<T> task) {
        execute(getPoolByTypeAndPriority(-2), task);
    }

    public static <T> void executeByCached(Task<T> task, int i) {
        execute(getPoolByTypeAndPriority(-2, i), task);
    }

    public static <T> void executeByCachedWithDelay(Task<T> task, long j, TimeUnit timeUnit) {
        executeWithDelay(getPoolByTypeAndPriority(-2), task, j, timeUnit);
    }

    public static <T> void executeByCachedWithDelay(Task<T> task, long j, TimeUnit timeUnit, int i) {
        executeWithDelay(getPoolByTypeAndPriority(-2, i), task, j, timeUnit);
    }

    public static <T> void executeByCachedAtFixRate(Task<T> task, long j, TimeUnit timeUnit) {
        executeAtFixedRate(getPoolByTypeAndPriority(-2), task, 0L, j, timeUnit);
    }

    public static <T> void executeByCachedAtFixRate(Task<T> task, long j, TimeUnit timeUnit, int i) {
        executeAtFixedRate(getPoolByTypeAndPriority(-2, i), task, 0L, j, timeUnit);
    }

    public static <T> void executeByCachedAtFixRate(Task<T> task, long j, long j2, TimeUnit timeUnit) {
        executeAtFixedRate(getPoolByTypeAndPriority(-2), task, j, j2, timeUnit);
    }

    public static <T> void executeByCachedAtFixRate(Task<T> task, long j, long j2, TimeUnit timeUnit, int i) {
        executeAtFixedRate(getPoolByTypeAndPriority(-2, i), task, j, j2, timeUnit);
    }

    public static <T> void executeByIo(Task<T> task) {
        execute(getPoolByTypeAndPriority(-4), task);
    }

    public static <T> void executeByIo(Task<T> task, int i) {
        execute(getPoolByTypeAndPriority(-4, i), task);
    }

    public static <T> void executeByIoWithDelay(Task<T> task, long j, TimeUnit timeUnit) {
        executeWithDelay(getPoolByTypeAndPriority(-4), task, j, timeUnit);
    }

    public static <T> void executeByIoWithDelay(Task<T> task, long j, TimeUnit timeUnit, int i) {
        executeWithDelay(getPoolByTypeAndPriority(-4, i), task, j, timeUnit);
    }

    public static <T> void executeByIoAtFixRate(Task<T> task, long j, TimeUnit timeUnit) {
        executeAtFixedRate(getPoolByTypeAndPriority(-4), task, 0L, j, timeUnit);
    }

    public static <T> void executeByIoAtFixRate(Task<T> task, long j, TimeUnit timeUnit, int i) {
        executeAtFixedRate(getPoolByTypeAndPriority(-4, i), task, 0L, j, timeUnit);
    }

    public static <T> void executeByIoAtFixRate(Task<T> task, long j, long j2, TimeUnit timeUnit) {
        executeAtFixedRate(getPoolByTypeAndPriority(-4), task, j, j2, timeUnit);
    }

    public static <T> void executeByIoAtFixRate(Task<T> task, long j, long j2, TimeUnit timeUnit, int i) {
        executeAtFixedRate(getPoolByTypeAndPriority(-4, i), task, j, j2, timeUnit);
    }

    public static <T> void executeByCpu(Task<T> task) {
        execute(getPoolByTypeAndPriority(-8), task);
    }

    public static <T> void executeByCpu(Task<T> task, int i) {
        execute(getPoolByTypeAndPriority(-8, i), task);
    }

    public static <T> void executeByCpuWithDelay(Task<T> task, long j, TimeUnit timeUnit) {
        executeWithDelay(getPoolByTypeAndPriority(-8), task, j, timeUnit);
    }

    public static <T> void executeByCpuWithDelay(Task<T> task, long j, TimeUnit timeUnit, int i) {
        executeWithDelay(getPoolByTypeAndPriority(-8, i), task, j, timeUnit);
    }

    public static <T> void executeByCpuAtFixRate(Task<T> task, long j, TimeUnit timeUnit) {
        executeAtFixedRate(getPoolByTypeAndPriority(-8), task, 0L, j, timeUnit);
    }

    public static <T> void executeByCpuAtFixRate(Task<T> task, long j, TimeUnit timeUnit, int i) {
        executeAtFixedRate(getPoolByTypeAndPriority(-8, i), task, 0L, j, timeUnit);
    }

    public static <T> void executeByCpuAtFixRate(Task<T> task, long j, long j2, TimeUnit timeUnit) {
        executeAtFixedRate(getPoolByTypeAndPriority(-8), task, j, j2, timeUnit);
    }

    public static <T> void executeByCpuAtFixRate(Task<T> task, long j, long j2, TimeUnit timeUnit, int i) {
        executeAtFixedRate(getPoolByTypeAndPriority(-8, i), task, j, j2, timeUnit);
    }

    public static <T> void executeByCustom(ExecutorService executorService, Task<T> task) {
        execute(executorService, task);
    }

    public static <T> void executeByCustomWithDelay(ExecutorService executorService, Task<T> task, long j, TimeUnit timeUnit) {
        executeWithDelay(executorService, task, j, timeUnit);
    }

    public static <T> void executeByCustomAtFixRate(ExecutorService executorService, Task<T> task, long j, TimeUnit timeUnit) {
        executeAtFixedRate(executorService, task, 0L, j, timeUnit);
    }

    public static <T> void executeByCustomAtFixRate(ExecutorService executorService, Task<T> task, long j, long j2, TimeUnit timeUnit) {
        executeAtFixedRate(executorService, task, j, j2, timeUnit);
    }

    public static void cancel(Task task) {
        if (task == null) {
            return;
        }
        task.cancel();
    }

    public static void cancel(Task... taskArr) {
        if (taskArr == null || taskArr.length == 0) {
            return;
        }
        for (Task task : taskArr) {
            if (task != null) {
                task.cancel();
            }
        }
    }

    public static void cancel(List<Task> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        for (Task task : list) {
            if (task != null) {
                task.cancel();
            }
        }
    }

    public static void cancel(ExecutorService executorService) {
        if (executorService instanceof ThreadPoolExecutor4Util) {
            for (Map.Entry<Task, ExecutorService> entry : TASK_POOL_MAP.entrySet()) {
                if (entry.getValue() == executorService) {
                    cancel(entry.getKey());
                }
            }
            return;
        }
        Log.e("ThreadUtils", "The executorService is not ThreadUtils's pool.");
    }

    public static void setDeliver(Executor executor) {
        sDeliver = executor;
    }

    private static <T> void execute(ExecutorService executorService, Task<T> task) {
        execute(executorService, task, 0L, 0L, null);
    }

    private static <T> void executeWithDelay(ExecutorService executorService, Task<T> task, long j, TimeUnit timeUnit) {
        execute(executorService, task, j, 0L, timeUnit);
    }

    private static <T> void executeAtFixedRate(ExecutorService executorService, Task<T> task, long j, long j2, TimeUnit timeUnit) {
        execute(executorService, task, j, j2, timeUnit);
    }

    private static <T> void execute(final ExecutorService executorService, final Task<T> task, long j, long j2, TimeUnit timeUnit) {
        synchronized (TASK_POOL_MAP) {
            if (TASK_POOL_MAP.get(task) != null) {
                Log.e("ThreadUtils", "Task can only be executed once.");
                return;
            }
            TASK_POOL_MAP.put(task, executorService);
            if (j2 != 0) {
                task.setSchedule(true);
                TIMER.scheduleAtFixedRate(new TimerTask() { // from class: com.blankj.utilcode.util.ThreadUtils.2
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        executorService.execute(task);
                    }
                }, timeUnit.toMillis(j), timeUnit.toMillis(j2));
            } else if (j == 0) {
                executorService.execute(task);
            } else {
                TIMER.schedule(new TimerTask() { // from class: com.blankj.utilcode.util.ThreadUtils.1
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        executorService.execute(task);
                    }
                }, timeUnit.toMillis(j));
            }
        }
    }

    private static ExecutorService getPoolByTypeAndPriority(int i) {
        return getPoolByTypeAndPriority(i, 5);
    }

    private static ExecutorService getPoolByTypeAndPriority(int i, int i2) {
        ExecutorService executorService;
        synchronized (TYPE_PRIORITY_POOLS) {
            Map<Integer, ExecutorService> map = TYPE_PRIORITY_POOLS.get(Integer.valueOf(i));
            if (map == null) {
                ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                executorService = ThreadPoolExecutor4Util.createPool(i, i2);
                concurrentHashMap.put(Integer.valueOf(i2), executorService);
                TYPE_PRIORITY_POOLS.put(Integer.valueOf(i), concurrentHashMap);
            } else {
                executorService = map.get(Integer.valueOf(i2));
                if (executorService == null) {
                    executorService = ThreadPoolExecutor4Util.createPool(i, i2);
                    map.put(Integer.valueOf(i2), executorService);
                }
            }
        }
        return executorService;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class ThreadPoolExecutor4Util extends ThreadPoolExecutor {
        private final AtomicInteger mSubmittedCount;
        private LinkedBlockingQueue4Util mWorkQueue;

        /* JADX INFO: Access modifiers changed from: private */
        public static ExecutorService createPool(int i, int i2) {
            if (i != -8) {
                if (i != -4) {
                    if (i != -2) {
                        if (i == -1) {
                            return new ThreadPoolExecutor4Util(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue4Util(), new UtilsThreadFactory("single", i2));
                        }
                        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                        LinkedBlockingQueue4Util linkedBlockingQueue4Util = new LinkedBlockingQueue4Util();
                        return new ThreadPoolExecutor4Util(i, i, 0L, timeUnit, linkedBlockingQueue4Util, new UtilsThreadFactory("fixed(" + i + ")", i2));
                    }
                    return new ThreadPoolExecutor4Util(0, 128, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue4Util(true), new UtilsThreadFactory("cached", i2));
                }
                return new ThreadPoolExecutor4Util((ThreadUtils.CPU_COUNT * 2) + 1, (ThreadUtils.CPU_COUNT * 2) + 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue4Util(), new UtilsThreadFactory("io", i2));
            }
            return new ThreadPoolExecutor4Util(ThreadUtils.CPU_COUNT + 1, (ThreadUtils.CPU_COUNT * 2) + 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue4Util(true), new UtilsThreadFactory("cpu", i2));
        }

        ThreadPoolExecutor4Util(int i, int i2, long j, TimeUnit timeUnit, LinkedBlockingQueue4Util linkedBlockingQueue4Util, ThreadFactory threadFactory) {
            super(i, i2, j, timeUnit, linkedBlockingQueue4Util, threadFactory);
            this.mSubmittedCount = new AtomicInteger();
            linkedBlockingQueue4Util.mPool = this;
            this.mWorkQueue = linkedBlockingQueue4Util;
        }

        private int getSubmittedCount() {
            return this.mSubmittedCount.get();
        }

        @Override // java.util.concurrent.ThreadPoolExecutor
        protected void afterExecute(Runnable runnable, Throwable th) {
            this.mSubmittedCount.decrementAndGet();
            super.afterExecute(runnable, th);
        }

        @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            if (runnable == null) {
                throw new NullPointerException("Argument 'command' of type Runnable (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            }
            if (isShutdown()) {
                return;
            }
            this.mSubmittedCount.incrementAndGet();
            try {
                super.execute(runnable);
            } catch (RejectedExecutionException unused) {
                Log.e("ThreadUtils", "This will not happen!");
                this.mWorkQueue.offer(runnable);
            } catch (Throwable unused2) {
                this.mSubmittedCount.decrementAndGet();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class LinkedBlockingQueue4Util extends LinkedBlockingQueue<Runnable> {
        private int mCapacity;
        private volatile ThreadPoolExecutor4Util mPool;

        LinkedBlockingQueue4Util() {
            this.mCapacity = Integer.MAX_VALUE;
        }

        LinkedBlockingQueue4Util(boolean z) {
            this.mCapacity = Integer.MAX_VALUE;
            if (z) {
                this.mCapacity = 0;
            }
        }

        LinkedBlockingQueue4Util(int i) {
            this.mCapacity = Integer.MAX_VALUE;
            this.mCapacity = i;
        }

        @Override // java.util.concurrent.LinkedBlockingQueue, java.util.Queue, java.util.concurrent.BlockingQueue
        public boolean offer(Runnable runnable) {
            if (runnable == null) {
                throw new NullPointerException("Argument 'runnable' of type Runnable (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            }
            if (this.mCapacity > size() || this.mPool == null || this.mPool.getPoolSize() >= this.mPool.getMaximumPoolSize()) {
                return super.offer((LinkedBlockingQueue4Util) runnable);
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class UtilsThreadFactory extends AtomicLong implements ThreadFactory {
        private static final AtomicInteger POOL_NUMBER = new AtomicInteger(1);
        private static final long serialVersionUID = -9209200509960368598L;
        private final boolean isDaemon;
        private final String namePrefix;
        private final int priority;

        UtilsThreadFactory(String str, int i) {
            this(str, i, false);
        }

        UtilsThreadFactory(String str, int i, boolean z) {
            this.namePrefix = str + "-pool-" + POOL_NUMBER.getAndIncrement() + "-thread-";
            this.priority = i;
            this.isDaemon = z;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            if (runnable == null) {
                throw new NullPointerException("Argument 'r' of type Runnable (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            }
            Thread thread = new Thread(runnable, this.namePrefix + getAndIncrement()) { // from class: com.blankj.utilcode.util.ThreadUtils.UtilsThreadFactory.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    try {
                        super.run();
                    } catch (Throwable th) {
                        Log.e("ThreadUtils", "Request threw uncaught throwable", th);
                    }
                }
            };
            thread.setDaemon(this.isDaemon);
            thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: com.blankj.utilcode.util.ThreadUtils.UtilsThreadFactory.2
                @Override // java.lang.Thread.UncaughtExceptionHandler
                public void uncaughtException(Thread thread2, Throwable th) {
                    System.out.println(th);
                }
            });
            thread.setPriority(this.priority);
            return thread;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class SimpleTask<T> extends Task<T> {
        @Override // com.blankj.utilcode.util.ThreadUtils.Task
        public void onCancel() {
            Log.e("ThreadUtils", "onCancel: " + Thread.currentThread());
        }

        @Override // com.blankj.utilcode.util.ThreadUtils.Task
        public void onFail(Throwable th) {
            Log.e("ThreadUtils", "onFail: ", th);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class Task<T> implements Runnable {
        private static final int CANCELLED = 4;
        private static final int COMPLETING = 3;
        private static final int EXCEPTIONAL = 2;
        private static final int INTERRUPTED = 5;
        private static final int NEW = 0;
        private static final int RUNNING = 1;
        private static final int TIMEOUT = 6;
        private Executor deliver;
        private volatile boolean isSchedule;
        private OnTimeoutListener mTimeoutListener;
        private long mTimeoutMillis;
        private Timer mTimer;
        private volatile Thread runner;
        private final AtomicInteger state = new AtomicInteger(0);

        /* loaded from: classes.dex */
        public interface OnTimeoutListener {
            void onTimeout();
        }

        public abstract T doInBackground() throws Throwable;

        public abstract void onCancel();

        public abstract void onFail(Throwable th);

        public abstract void onSuccess(T t);

        @Override // java.lang.Runnable
        public void run() {
            if (this.isSchedule) {
                if (this.runner == null) {
                    if (!this.state.compareAndSet(0, 1)) {
                        return;
                    }
                    this.runner = Thread.currentThread();
                    if (this.mTimeoutListener != null) {
                        Log.w("ThreadUtils", "Scheduled task doesn't support timeout.");
                    }
                } else if (this.state.get() != 1) {
                    return;
                }
            } else if (!this.state.compareAndSet(0, 1)) {
                return;
            } else {
                this.runner = Thread.currentThread();
                if (this.mTimeoutListener != null) {
                    Timer timer = new Timer();
                    this.mTimer = timer;
                    timer.schedule(new TimerTask() { // from class: com.blankj.utilcode.util.ThreadUtils.Task.1
                        @Override // java.util.TimerTask, java.lang.Runnable
                        public void run() {
                            if (Task.this.isDone() || Task.this.mTimeoutListener == null) {
                                return;
                            }
                            Task.this.timeout();
                            Task.this.mTimeoutListener.onTimeout();
                        }
                    }, this.mTimeoutMillis);
                }
            }
            try {
                final T doInBackground = doInBackground();
                if (this.isSchedule) {
                    if (this.state.get() != 1) {
                        return;
                    }
                    getDeliver().execute(new Runnable() { // from class: com.blankj.utilcode.util.ThreadUtils.Task.2
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.lang.Runnable
                        public void run() {
                            Task.this.onSuccess(doInBackground);
                        }
                    });
                } else if (this.state.compareAndSet(1, 3)) {
                    getDeliver().execute(new Runnable() { // from class: com.blankj.utilcode.util.ThreadUtils.Task.3
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.lang.Runnable
                        public void run() {
                            Task.this.onSuccess(doInBackground);
                            Task.this.onDone();
                        }
                    });
                }
            } catch (InterruptedException unused) {
                this.state.compareAndSet(4, 5);
            } catch (Throwable th) {
                if (this.state.compareAndSet(1, 2)) {
                    getDeliver().execute(new Runnable() { // from class: com.blankj.utilcode.util.ThreadUtils.Task.4
                        @Override // java.lang.Runnable
                        public void run() {
                            Task.this.onFail(th);
                            Task.this.onDone();
                        }
                    });
                }
            }
        }

        public void cancel() {
            cancel(true);
        }

        public void cancel(boolean z) {
            synchronized (this.state) {
                if (this.state.get() > 1) {
                    return;
                }
                this.state.set(4);
                if (z && this.runner != null) {
                    this.runner.interrupt();
                }
                getDeliver().execute(new Runnable() { // from class: com.blankj.utilcode.util.ThreadUtils.Task.5
                    @Override // java.lang.Runnable
                    public void run() {
                        Task.this.onCancel();
                        Task.this.onDone();
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void timeout() {
            synchronized (this.state) {
                if (this.state.get() > 1) {
                    return;
                }
                this.state.set(6);
                if (this.runner != null) {
                    this.runner.interrupt();
                }
                onDone();
            }
        }

        public boolean isCanceled() {
            return this.state.get() >= 4;
        }

        public boolean isDone() {
            return this.state.get() > 1;
        }

        public Task<T> setDeliver(Executor executor) {
            this.deliver = executor;
            return this;
        }

        public Task<T> setTimeout(long j, OnTimeoutListener onTimeoutListener) {
            this.mTimeoutMillis = j;
            this.mTimeoutListener = onTimeoutListener;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSchedule(boolean z) {
            this.isSchedule = z;
        }

        private Executor getDeliver() {
            Executor executor = this.deliver;
            return executor == null ? ThreadUtils.access$600() : executor;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void onDone() {
            ThreadUtils.TASK_POOL_MAP.remove(this);
            Timer timer = this.mTimer;
            if (timer != null) {
                timer.cancel();
                this.mTimer = null;
                this.mTimeoutListener = null;
            }
        }
    }

    /* loaded from: classes.dex */
    public static class SyncValue<T> {
        private T mValue;
        private CountDownLatch mLatch = new CountDownLatch(1);
        private AtomicBoolean mFlag = new AtomicBoolean();

        public void setValue(T t) {
            if (this.mFlag.compareAndSet(false, true)) {
                this.mValue = t;
                this.mLatch.countDown();
            }
        }

        public T getValue() {
            if (!this.mFlag.get()) {
                try {
                    this.mLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return this.mValue;
        }
    }

    private static Executor getGlobalDeliver() {
        if (sDeliver == null) {
            sDeliver = new Executor() { // from class: com.blankj.utilcode.util.ThreadUtils.3
                @Override // java.util.concurrent.Executor
                public void execute(Runnable runnable) {
                    if (runnable == null) {
                        throw new NullPointerException("Argument 'command' of type Runnable (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
                    }
                    ThreadUtils.runOnUiThread(runnable);
                }
            };
        }
        return sDeliver;
    }
}
