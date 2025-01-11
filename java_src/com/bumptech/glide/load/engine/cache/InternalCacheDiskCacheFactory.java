package com.bumptech.glide.load.engine.cache;

import android.content.Context;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.DiskLruCacheFactory;
import java.io.File;

/* loaded from: classes.dex */
public final class InternalCacheDiskCacheFactory extends DiskLruCacheFactory {
    public InternalCacheDiskCacheFactory(Context context) {
        this(context, DiskCache.Factory.DEFAULT_DISK_CACHE_DIR, 262144000L);
    }

    public InternalCacheDiskCacheFactory(Context context, long j) {
        this(context, DiskCache.Factory.DEFAULT_DISK_CACHE_DIR, j);
    }

    public InternalCacheDiskCacheFactory(final Context context, final String str, long j) {
        super(new DiskLruCacheFactory.CacheDirectoryGetter() { // from class: com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory.1
            @Override // com.bumptech.glide.load.engine.cache.DiskLruCacheFactory.CacheDirectoryGetter
            public File getCacheDirectory() {
                File cacheDir = context.getCacheDir();
                if (cacheDir == null) {
                    return null;
                }
                return str != null ? new File(cacheDir, str) : cacheDir;
            }
        }, j);
    }
}
