package com.bumptech.glide.request;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.engine.Resource;

/* loaded from: classes.dex */
public interface ResourceCallback {
    Object getLock();

    void onLoadFailed(GlideException glideException);

    void onResourceReady(Resource<?> resource, DataSource dataSource);
}
