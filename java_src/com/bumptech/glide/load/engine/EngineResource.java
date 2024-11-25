package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.Preconditions;
/* loaded from: classes.dex */
class EngineResource<Z> implements Resource<Z> {
    private int acquired;
    private final boolean isMemoryCacheable;
    private final boolean isRecyclable;
    private boolean isRecycled;
    private final Key key;
    private final ResourceListener listener;
    private final Resource<Z> resource;

    /* loaded from: classes.dex */
    interface ResourceListener {
        void onResourceReleased(Key key, EngineResource<?> engineResource);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public EngineResource(Resource<Z> resource, boolean z, boolean z2, Key key, ResourceListener resourceListener) {
        this.resource = (Resource) Preconditions.checkNotNull(resource);
        this.isMemoryCacheable = z;
        this.isRecyclable = z2;
        this.key = key;
        this.listener = (ResourceListener) Preconditions.checkNotNull(resourceListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Resource<Z> getResource() {
        return this.resource;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isMemoryCacheable() {
        return this.isMemoryCacheable;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public Class<Z> getResourceClass() {
        return this.resource.getResourceClass();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public Z get() {
        return this.resource.get();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public int getSize() {
        return this.resource.getSize();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public synchronized void recycle() {
        if (this.acquired > 0) {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        }
        if (this.isRecycled) {
            throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
        }
        this.isRecycled = true;
        if (this.isRecyclable) {
            this.resource.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void acquire() {
        if (this.isRecycled) {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        }
        this.acquired++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void release() {
        boolean z;
        synchronized (this) {
            if (this.acquired <= 0) {
                throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
            }
            z = true;
            int i = this.acquired - 1;
            this.acquired = i;
            if (i != 0) {
                z = false;
            }
        }
        if (z) {
            this.listener.onResourceReleased(this.key, this);
        }
    }

    public synchronized String toString() {
        return "EngineResource{isMemoryCacheable=" + this.isMemoryCacheable + ", listener=" + this.listener + ", key=" + this.key + ", acquired=" + this.acquired + ", isRecycled=" + this.isRecycled + ", resource=" + this.resource + '}';
    }
}
