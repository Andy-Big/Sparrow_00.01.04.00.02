package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.cache.DiskCache;
import java.io.File;
/* loaded from: classes.dex */
class DataCacheWriter<DataType> implements DiskCache.Writer {
    private final DataType data;
    private final Encoder<DataType> encoder;
    private final Options options;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DataCacheWriter(Encoder<DataType> encoder, DataType datatype, Options options) {
        this.encoder = encoder;
        this.data = datatype;
        this.options = options;
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache.Writer
    public boolean write(File file) {
        return this.encoder.encode(this.data, file, this.options);
    }
}
