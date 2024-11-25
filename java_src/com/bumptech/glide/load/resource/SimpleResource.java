package com.bumptech.glide.load.resource;

import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.Preconditions;
/* loaded from: classes.dex */
public class SimpleResource<T> implements Resource<T> {
    protected final T data;

    @Override // com.bumptech.glide.load.engine.Resource
    public final int getSize() {
        return 1;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public void recycle() {
    }

    public SimpleResource(T t) {
        this.data = (T) Preconditions.checkNotNull(t);
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public Class<T> getResourceClass() {
        return (Class<T>) this.data.getClass();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public final T get() {
        return this.data;
    }
}
