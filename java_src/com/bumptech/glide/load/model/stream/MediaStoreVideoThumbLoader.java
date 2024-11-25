package com.bumptech.glide.load.model.stream;

import android.content.Context;
import android.net.Uri;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.mediastore.MediaStoreUtil;
import com.bumptech.glide.load.data.mediastore.ThumbFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import com.bumptech.glide.load.resource.bitmap.VideoDecoder;
import com.bumptech.glide.signature.ObjectKey;
import java.io.InputStream;
/* loaded from: classes.dex */
public class MediaStoreVideoThumbLoader implements ModelLoader<Uri, InputStream> {
    private final Context context;

    public MediaStoreVideoThumbLoader(Context context) {
        this.context = context.getApplicationContext();
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public ModelLoader.LoadData<InputStream> buildLoadData(Uri uri, int i, int i2, Options options) {
        if (MediaStoreUtil.isThumbnailSize(i, i2) && isRequestingDefaultFrame(options)) {
            return new ModelLoader.LoadData<>(new ObjectKey(uri), ThumbFetcher.buildVideoFetcher(this.context, uri));
        }
        return null;
    }

    private boolean isRequestingDefaultFrame(Options options) {
        Long l = (Long) options.get(VideoDecoder.TARGET_FRAME);
        return l != null && l.longValue() == -1;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public boolean handles(Uri uri) {
        return MediaStoreUtil.isMediaStoreVideoUri(uri);
    }

    /* loaded from: classes.dex */
    public static class Factory implements ModelLoaderFactory<Uri, InputStream> {
        private final Context context;

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }

        public Factory(Context context) {
            this.context = context;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader<Uri, InputStream> build(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new MediaStoreVideoThumbLoader(this.context);
        }
    }
}
