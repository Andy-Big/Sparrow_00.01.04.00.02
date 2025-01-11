package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.Util;

/* loaded from: classes.dex */
public final class UnitBitmapDecoder implements ResourceDecoder<Bitmap, Bitmap> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bumptech.glide.load.ResourceDecoder
    public boolean handles(Bitmap bitmap, Options options) {
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bumptech.glide.load.ResourceDecoder
    public Resource<Bitmap> decode(Bitmap bitmap, int i, int i2, Options options) {
        return new NonOwnedBitmapResource(bitmap);
    }

    /* loaded from: classes.dex */
    private static final class NonOwnedBitmapResource implements Resource<Bitmap> {
        private final Bitmap bitmap;

        @Override // com.bumptech.glide.load.engine.Resource
        public void recycle() {
        }

        NonOwnedBitmapResource(Bitmap bitmap) {
            this.bitmap = bitmap;
        }

        @Override // com.bumptech.glide.load.engine.Resource
        public Class<Bitmap> getResourceClass() {
            return Bitmap.class;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.bumptech.glide.load.engine.Resource
        public Bitmap get() {
            return this.bitmap;
        }

        @Override // com.bumptech.glide.load.engine.Resource
        public int getSize() {
            return Util.getBitmapByteSize(this.bitmap);
        }
    }
}
