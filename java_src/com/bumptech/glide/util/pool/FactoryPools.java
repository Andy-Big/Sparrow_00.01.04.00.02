package com.bumptech.glide.util.pool;

import android.util.Log;
import androidx.core.util.Pools;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public final class FactoryPools {
    private static final int DEFAULT_POOL_SIZE = 20;
    private static final Resetter<Object> EMPTY_RESETTER = new Resetter<Object>() { // from class: com.bumptech.glide.util.pool.FactoryPools.1
        @Override // com.bumptech.glide.util.pool.FactoryPools.Resetter
        public void reset(Object obj) {
        }
    };
    private static final String TAG = "FactoryPools";

    /* loaded from: classes.dex */
    public interface Factory<T> {
        T create();
    }

    /* loaded from: classes.dex */
    public interface Poolable {
        StateVerifier getVerifier();
    }

    /* loaded from: classes.dex */
    public interface Resetter<T> {
        void reset(T t);
    }

    private FactoryPools() {
    }

    public static <T extends Poolable> Pools.Pool<T> simple(int i, Factory<T> factory) {
        return build(new Pools.SimplePool(i), factory);
    }

    public static <T extends Poolable> Pools.Pool<T> threadSafe(int i, Factory<T> factory) {
        return build(new Pools.SynchronizedPool(i), factory);
    }

    public static <T> Pools.Pool<List<T>> threadSafeList() {
        return threadSafeList(20);
    }

    public static <T> Pools.Pool<List<T>> threadSafeList(int i) {
        return build(new Pools.SynchronizedPool(i), new Factory<List<T>>() { // from class: com.bumptech.glide.util.pool.FactoryPools.2
            @Override // com.bumptech.glide.util.pool.FactoryPools.Factory
            public List<T> create() {
                return new ArrayList();
            }
        }, new Resetter<List<T>>() { // from class: com.bumptech.glide.util.pool.FactoryPools.3
            @Override // com.bumptech.glide.util.pool.FactoryPools.Resetter
            public /* bridge */ /* synthetic */ void reset(Object obj) {
                reset((List) ((List) obj));
            }

            public void reset(List<T> list) {
                list.clear();
            }
        });
    }

    private static <T extends Poolable> Pools.Pool<T> build(Pools.Pool<T> pool, Factory<T> factory) {
        return build(pool, factory, emptyResetter());
    }

    private static <T> Pools.Pool<T> build(Pools.Pool<T> pool, Factory<T> factory, Resetter<T> resetter) {
        return new FactoryPool(pool, factory, resetter);
    }

    private static <T> Resetter<T> emptyResetter() {
        return (Resetter<T>) EMPTY_RESETTER;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class FactoryPool<T> implements Pools.Pool<T> {
        private final Factory<T> factory;
        private final Pools.Pool<T> pool;
        private final Resetter<T> resetter;

        FactoryPool(Pools.Pool<T> pool, Factory<T> factory, Resetter<T> resetter) {
            this.pool = pool;
            this.factory = factory;
            this.resetter = resetter;
        }

        @Override // androidx.core.util.Pools.Pool
        public T acquire() {
            T acquire = this.pool.acquire();
            if (acquire == null) {
                acquire = this.factory.create();
                if (Log.isLoggable(FactoryPools.TAG, 2)) {
                    Log.v(FactoryPools.TAG, "Created new " + acquire.getClass());
                }
            }
            if (acquire instanceof Poolable) {
                ((Poolable) acquire).getVerifier().setRecycled(false);
            }
            return acquire;
        }

        @Override // androidx.core.util.Pools.Pool
        public boolean release(T t) {
            if (t instanceof Poolable) {
                ((Poolable) t).getVerifier().setRecycled(true);
            }
            this.resetter.reset(t);
            return this.pool.release(t);
        }
    }
}
