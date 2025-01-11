package com.bumptech.glide.load.engine.cache;

import android.content.Context;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.DiskLruCacheFactory;
import java.io.File;

@Deprecated
/* loaded from: classes.dex */
public final class ExternalCacheDiskCacheFactory extends DiskLruCacheFactory {
    public ExternalCacheDiskCacheFactory(Context context) {
        this(context, DiskCache.Factory.DEFAULT_DISK_CACHE_DIR, DiskCache.Factory.DEFAULT_DISK_CACHE_SIZE);
    }

    public ExternalCacheDiskCacheFactory(Context context, int i) {
        this(context, DiskCache.Factory.DEFAULT_DISK_CACHE_DIR, i);
    }

    public ExternalCacheDiskCacheFactory(final Context context, final String str, int i) {
        super(new DiskLruCacheFactory.CacheDirectoryGetter() { // from class: com.bumptech.glide.load.engine.cache.ExternalCacheDiskCacheFactory.1
            @Override // com.bumptech.glide.load.engine.cache.DiskLruCacheFactory.CacheDirectoryGetter
            public File getCacheDirectory() {
                File externalCacheDir = context.getExternalCacheDir();
                if (externalCacheDir == null) {
                    return null;
                }
                return str != null ? new File(externalCacheDir, str) : externalCacheDir;
            }
        }, i);
    }
}
