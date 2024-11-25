package com.bumptech.glide.load.engine.bitmap_recycle;

import android.util.Log;
import com.bumptech.glide.util.Preconditions;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;
/* loaded from: classes.dex */
public final class LruArrayPool implements ArrayPool {
    private static final int DEFAULT_SIZE = 4194304;
    static final int MAX_OVER_SIZE_MULTIPLE = 8;
    private static final int SINGLE_ARRAY_MAX_SIZE_DIVISOR = 2;
    private final Map<Class<?>, ArrayAdapterInterface<?>> adapters;
    private int currentSize;
    private final GroupedLinkedMap<Key, Object> groupedMap;
    private final KeyPool keyPool;
    private final int maxSize;
    private final Map<Class<?>, NavigableMap<Integer, Integer>> sortedSizes;

    public LruArrayPool() {
        this.groupedMap = new GroupedLinkedMap<>();
        this.keyPool = new KeyPool();
        this.sortedSizes = new HashMap();
        this.adapters = new HashMap();
        this.maxSize = 4194304;
    }

    public LruArrayPool(int i) {
        this.groupedMap = new GroupedLinkedMap<>();
        this.keyPool = new KeyPool();
        this.sortedSizes = new HashMap();
        this.adapters = new HashMap();
        this.maxSize = i;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
    @Deprecated
    public <T> void put(T t, Class<T> cls) {
        put(t);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
    public synchronized <T> void put(T t) {
        Class<?> cls = t.getClass();
        ArrayAdapterInterface<T> adapterFromType = getAdapterFromType(cls);
        int arrayLength = adapterFromType.getArrayLength(t);
        int elementSizeInBytes = adapterFromType.getElementSizeInBytes() * arrayLength;
        if (isSmallEnoughForReuse(elementSizeInBytes)) {
            Key key = this.keyPool.get(arrayLength, cls);
            this.groupedMap.put(key, t);
            NavigableMap<Integer, Integer> sizesForAdapter = getSizesForAdapter(cls);
            Integer num = (Integer) sizesForAdapter.get(Integer.valueOf(key.size));
            Integer valueOf = Integer.valueOf(key.size);
            int i = 1;
            if (num != null) {
                i = 1 + num.intValue();
            }
            sizesForAdapter.put(valueOf, Integer.valueOf(i));
            this.currentSize += elementSizeInBytes;
            evict();
        }
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
    public synchronized <T> T getExact(int i, Class<T> cls) {
        return (T) getForKey(this.keyPool.get(i, cls), cls);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
    public synchronized <T> T get(int i, Class<T> cls) {
        Key key;
        Integer ceilingKey = getSizesForAdapter(cls).ceilingKey(Integer.valueOf(i));
        if (mayFillRequest(i, ceilingKey)) {
            key = this.keyPool.get(ceilingKey.intValue(), cls);
        } else {
            key = this.keyPool.get(i, cls);
        }
        return (T) getForKey(key, cls);
    }

    private <T> T getForKey(Key key, Class<T> cls) {
        ArrayAdapterInterface<T> adapterFromType = getAdapterFromType(cls);
        T t = (T) getArrayForKey(key);
        if (t != null) {
            this.currentSize -= adapterFromType.getArrayLength(t) * adapterFromType.getElementSizeInBytes();
            decrementArrayOfSize(adapterFromType.getArrayLength(t), cls);
        }
        if (t == null) {
            if (Log.isLoggable(adapterFromType.getTag(), 2)) {
                Log.v(adapterFromType.getTag(), "Allocated " + key.size + " bytes");
            }
            return adapterFromType.newArray(key.size);
        }
        return t;
    }

    private <T> T getArrayForKey(Key key) {
        return (T) this.groupedMap.get(key);
    }

    private boolean isSmallEnoughForReuse(int i) {
        return i <= this.maxSize / 2;
    }

    private boolean mayFillRequest(int i, Integer num) {
        return num != null && (isNoMoreThanHalfFull() || num.intValue() <= i * 8);
    }

    private boolean isNoMoreThanHalfFull() {
        int i = this.currentSize;
        return i == 0 || this.maxSize / i >= 2;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
    public synchronized void clearMemory() {
        evictToSize(0);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
    public synchronized void trimMemory(int i) {
        try {
            if (i >= 40) {
                clearMemory();
            } else if (i >= 20 || i == 15) {
                evictToSize(this.maxSize / 2);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private void evict() {
        evictToSize(this.maxSize);
    }

    private void evictToSize(int i) {
        while (this.currentSize > i) {
            Object removeLast = this.groupedMap.removeLast();
            Preconditions.checkNotNull(removeLast);
            ArrayAdapterInterface adapterFromObject = getAdapterFromObject(removeLast);
            this.currentSize -= adapterFromObject.getArrayLength(removeLast) * adapterFromObject.getElementSizeInBytes();
            decrementArrayOfSize(adapterFromObject.getArrayLength(removeLast), removeLast.getClass());
            if (Log.isLoggable(adapterFromObject.getTag(), 2)) {
                Log.v(adapterFromObject.getTag(), "evicted: " + adapterFromObject.getArrayLength(removeLast));
            }
        }
    }

    private void decrementArrayOfSize(int i, Class<?> cls) {
        NavigableMap<Integer, Integer> sizesForAdapter = getSizesForAdapter(cls);
        Integer num = (Integer) sizesForAdapter.get(Integer.valueOf(i));
        if (num == null) {
            throw new NullPointerException("Tried to decrement empty size, size: " + i + ", this: " + this);
        } else if (num.intValue() == 1) {
            sizesForAdapter.remove(Integer.valueOf(i));
        } else {
            sizesForAdapter.put(Integer.valueOf(i), Integer.valueOf(num.intValue() - 1));
        }
    }

    private NavigableMap<Integer, Integer> getSizesForAdapter(Class<?> cls) {
        NavigableMap<Integer, Integer> navigableMap = this.sortedSizes.get(cls);
        if (navigableMap == null) {
            TreeMap treeMap = new TreeMap();
            this.sortedSizes.put(cls, treeMap);
            return treeMap;
        }
        return navigableMap;
    }

    private <T> ArrayAdapterInterface<T> getAdapterFromObject(T t) {
        return getAdapterFromType(t.getClass());
    }

    private <T> ArrayAdapterInterface<T> getAdapterFromType(Class<T> cls) {
        IntegerArrayAdapter integerArrayAdapter = (ArrayAdapterInterface<T>) this.adapters.get(cls);
        if (integerArrayAdapter == null) {
            if (cls.equals(int[].class)) {
                integerArrayAdapter = new IntegerArrayAdapter();
            } else if (cls.equals(byte[].class)) {
                integerArrayAdapter = new ByteArrayAdapter();
            } else {
                throw new IllegalArgumentException("No array pool found for: " + cls.getSimpleName());
            }
            this.adapters.put(cls, integerArrayAdapter);
        }
        return integerArrayAdapter;
    }

    int getCurrentSize() {
        int i = 0;
        for (Class<?> cls : this.sortedSizes.keySet()) {
            for (Integer num : this.sortedSizes.get(cls).keySet()) {
                i += num.intValue() * ((Integer) this.sortedSizes.get(cls).get(num)).intValue() * getAdapterFromType(cls).getElementSizeInBytes();
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class KeyPool extends BaseKeyPool<Key> {
        KeyPool() {
        }

        Key get(int i, Class<?> cls) {
            Key key = get();
            key.init(i, cls);
            return key;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.bumptech.glide.load.engine.bitmap_recycle.BaseKeyPool
        public Key create() {
            return new Key(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class Key implements Poolable {
        private Class<?> arrayClass;
        private final KeyPool pool;
        int size;

        Key(KeyPool keyPool) {
            this.pool = keyPool;
        }

        void init(int i, Class<?> cls) {
            this.size = i;
            this.arrayClass = cls;
        }

        public boolean equals(Object obj) {
            if (obj instanceof Key) {
                Key key = (Key) obj;
                return this.size == key.size && this.arrayClass == key.arrayClass;
            }
            return false;
        }

        public String toString() {
            return "Key{size=" + this.size + "array=" + this.arrayClass + '}';
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.Poolable
        public void offer() {
            this.pool.offer(this);
        }

        public int hashCode() {
            int i = this.size * 31;
            Class<?> cls = this.arrayClass;
            return i + (cls != null ? cls.hashCode() : 0);
        }
    }
}
