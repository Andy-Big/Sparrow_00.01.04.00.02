package com.bumptech.glide.load.resource.file;

import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import java.io.File;
/* loaded from: classes.dex */
public class FileDecoder implements ResourceDecoder<File, File> {
    @Override // com.bumptech.glide.load.ResourceDecoder
    public boolean handles(File file, Options options) {
        return true;
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public Resource<File> decode(File file, int i, int i2, Options options) {
        return new FileResource(file);
    }
}
