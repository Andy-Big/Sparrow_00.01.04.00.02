package com.bumptech.glide.load.engine.bitmap_recycle;

/* loaded from: classes.dex */
public final class IntegerArrayAdapter implements ArrayAdapterInterface<int[]> {
    private static final String TAG = "IntegerArrayPool";

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayAdapterInterface
    public int getElementSizeInBytes() {
        return 4;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayAdapterInterface
    public String getTag() {
        return TAG;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayAdapterInterface
    public int getArrayLength(int[] iArr) {
        return iArr.length;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayAdapterInterface
    public int[] newArray(int i) {
        return new int[i];
    }
}
