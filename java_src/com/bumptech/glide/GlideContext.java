package com.bumptech.glide;

import android.content.Context;
import android.content.ContextWrapper;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.ImageViewTargetFactory;
import com.bumptech.glide.request.target.ViewTarget;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class GlideContext extends ContextWrapper {
    static final TransitionOptions<?, ?> DEFAULT_TRANSITION_OPTIONS = new GenericTransitionOptions();
    private final ArrayPool arrayPool;
    private final List<RequestListener<Object>> defaultRequestListeners;
    private RequestOptions defaultRequestOptions;
    private final Glide.RequestOptionsFactory defaultRequestOptionsFactory;
    private final Map<Class<?>, TransitionOptions<?, ?>> defaultTransitionOptions;
    private final Engine engine;
    private final ImageViewTargetFactory imageViewTargetFactory;
    private final boolean isLoggingRequestOriginsEnabled;
    private final int logLevel;
    private final Registry registry;

    public GlideContext(Context context, ArrayPool arrayPool, Registry registry, ImageViewTargetFactory imageViewTargetFactory, Glide.RequestOptionsFactory requestOptionsFactory, Map<Class<?>, TransitionOptions<?, ?>> map, List<RequestListener<Object>> list, Engine engine, boolean z, int i) {
        super(context.getApplicationContext());
        this.arrayPool = arrayPool;
        this.registry = registry;
        this.imageViewTargetFactory = imageViewTargetFactory;
        this.defaultRequestOptionsFactory = requestOptionsFactory;
        this.defaultRequestListeners = list;
        this.defaultTransitionOptions = map;
        this.engine = engine;
        this.isLoggingRequestOriginsEnabled = z;
        this.logLevel = i;
    }

    public List<RequestListener<Object>> getDefaultRequestListeners() {
        return this.defaultRequestListeners;
    }

    public synchronized RequestOptions getDefaultRequestOptions() {
        if (this.defaultRequestOptions == null) {
            this.defaultRequestOptions = this.defaultRequestOptionsFactory.build().lock();
        }
        return this.defaultRequestOptions;
    }

    public <T> TransitionOptions<?, T> getDefaultTransitionOptions(Class<T> cls) {
        TransitionOptions<?, T> transitionOptions = (TransitionOptions<?, T>) this.defaultTransitionOptions.get(cls);
        if (transitionOptions == null) {
            for (Map.Entry<Class<?>, TransitionOptions<?, ?>> entry : this.defaultTransitionOptions.entrySet()) {
                if (entry.getKey().isAssignableFrom(cls)) {
                    transitionOptions = (TransitionOptions<?, T>) entry.getValue();
                }
            }
        }
        return transitionOptions == null ? (TransitionOptions<?, T>) DEFAULT_TRANSITION_OPTIONS : transitionOptions;
    }

    public <X> ViewTarget<ImageView, X> buildImageViewTarget(ImageView imageView, Class<X> cls) {
        return this.imageViewTargetFactory.buildTarget(imageView, cls);
    }

    public Engine getEngine() {
        return this.engine;
    }

    public Registry getRegistry() {
        return this.registry;
    }

    public int getLogLevel() {
        return this.logLevel;
    }

    public ArrayPool getArrayPool() {
        return this.arrayPool;
    }

    public boolean isLoggingRequestOriginsEnabled() {
        return this.isLoggingRequestOriginsEnabled;
    }
}
