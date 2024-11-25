package com.bumptech.glide.load.resource.drawable;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.engine.Resource;
/* loaded from: classes.dex */
final class NonOwnedDrawableResource extends DrawableResource<Drawable> {
    @Override // com.bumptech.glide.load.engine.Resource
    public void recycle() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Resource<Drawable> newInstance(Drawable drawable) {
        if (drawable != null) {
            return new NonOwnedDrawableResource(drawable);
        }
        return null;
    }

    private NonOwnedDrawableResource(Drawable drawable) {
        super(drawable);
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public Class<Drawable> getResourceClass() {
        return this.drawable.getClass();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public int getSize() {
        return Math.max(1, this.drawable.getIntrinsicWidth() * this.drawable.getIntrinsicHeight() * 4);
    }
}
