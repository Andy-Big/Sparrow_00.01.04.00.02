package com.bumptech.glide.load.resource;

import android.content.Context;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public final class UnitTransformation<T> implements Transformation<T> {
    private static final Transformation<?> TRANSFORMATION = new UnitTransformation();

    @Override // com.bumptech.glide.load.Transformation
    public Resource<T> transform(Context context, Resource<T> resource, int i, int i2) {
        return resource;
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest messageDigest) {
    }

    public static <T> UnitTransformation<T> get() {
        return (UnitTransformation) TRANSFORMATION;
    }

    private UnitTransformation() {
    }
}
