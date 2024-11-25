package com.bumptech.glide.load.model;

import com.bumptech.glide.util.LruCache;
import com.bumptech.glide.util.Util;
import java.util.Queue;
/* loaded from: classes.dex */
public class ModelCache<A, B> {
    private static final int DEFAULT_SIZE = 250;
    private final LruCache<ModelKey<A>, B> cache;

    public ModelCache() {
        this(250L);
    }

    public ModelCache(long j) {
        this.cache = new LruCache<ModelKey<A>, B>(j) { // from class: com.bumptech.glide.load.model.ModelCache.1
            @Override // com.bumptech.glide.util.LruCache
            protected /* bridge */ /* synthetic */ void onItemEvicted(Object obj, Object obj2) {
                onItemEvicted((ModelKey) ((ModelKey) obj), (ModelKey<A>) obj2);
            }

            protected void onItemEvicted(ModelKey<A> modelKey, B b) {
                modelKey.release();
            }
        };
    }

    public B get(A a, int i, int i2) {
        ModelKey<A> modelKey = ModelKey.get(a, i, i2);
        B b = this.cache.get(modelKey);
        modelKey.release();
        return b;
    }

    public void put(A a, int i, int i2, B b) {
        this.cache.put(ModelKey.get(a, i, i2), b);
    }

    public void clear() {
        this.cache.clearMemory();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class ModelKey<A> {
        private static final Queue<ModelKey<?>> KEY_QUEUE = Util.createQueue(0);
        private int height;
        private A model;
        private int width;

        static <A> ModelKey<A> get(A a, int i, int i2) {
            ModelKey<A> modelKey;
            synchronized (KEY_QUEUE) {
                modelKey = (ModelKey<A>) KEY_QUEUE.poll();
            }
            if (modelKey == null) {
                modelKey = new ModelKey<>();
            }
            modelKey.init(a, i, i2);
            return modelKey;
        }

        private ModelKey() {
        }

        private void init(A a, int i, int i2) {
            this.model = a;
            this.width = i;
            this.height = i2;
        }

        public void release() {
            synchronized (KEY_QUEUE) {
                KEY_QUEUE.offer(this);
            }
        }

        public boolean equals(Object obj) {
            if (obj instanceof ModelKey) {
                ModelKey modelKey = (ModelKey) obj;
                return this.width == modelKey.width && this.height == modelKey.height && this.model.equals(modelKey.model);
            }
            return false;
        }

        public int hashCode() {
            return (((this.height * 31) + this.width) * 31) + this.model.hashCode();
        }
    }
}
