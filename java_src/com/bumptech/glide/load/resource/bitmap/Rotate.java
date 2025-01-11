package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Util;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public class Rotate extends BitmapTransformation {
    private static final String ID = "com.bumptech.glide.load.resource.bitmap.Rotate";
    private static final byte[] ID_BYTES = ID.getBytes(CHARSET);
    private final int degreesToRotate;

    public Rotate(int i) {
        this.degreesToRotate = i;
    }

    @Override // com.bumptech.glide.load.resource.bitmap.BitmapTransformation
    protected Bitmap transform(BitmapPool bitmapPool, Bitmap bitmap, int i, int i2) {
        return TransformationUtils.rotateImage(bitmap, this.degreesToRotate);
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        return (obj instanceof Rotate) && this.degreesToRotate == ((Rotate) obj).degreesToRotate;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return Util.hashCode(-950519196, Util.hashCode(this.degreesToRotate));
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(ID_BYTES);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.degreesToRotate).array());
    }
}
