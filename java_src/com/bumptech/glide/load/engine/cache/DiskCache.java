package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.load.Key;
import java.io.File;
/* loaded from: classes.dex */
public interface DiskCache {

    /* loaded from: classes.dex */
    public interface Factory {
        public static final String DEFAULT_DISK_CACHE_DIR = "image_manager_disk_cache";
        public static final int DEFAULT_DISK_CACHE_SIZE = 262144000;

        DiskCache build();
    }

    /* loaded from: classes.dex */
    public interface Writer {
        boolean write(File file);
    }

    void clear();

    void delete(Key key);

    File get(Key key);

    void put(Key key, Writer writer);
}
