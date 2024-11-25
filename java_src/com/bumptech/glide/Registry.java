package com.bumptech.glide;

import androidx.core.util.Pools;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.data.DataRewinderRegistry;
import com.bumptech.glide.load.engine.DecodePath;
import com.bumptech.glide.load.engine.LoadPath;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.ModelLoaderRegistry;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.bumptech.glide.load.resource.transcode.TranscoderRegistry;
import com.bumptech.glide.provider.EncoderRegistry;
import com.bumptech.glide.provider.ImageHeaderParserRegistry;
import com.bumptech.glide.provider.LoadPathCache;
import com.bumptech.glide.provider.ModelToResourceClassCache;
import com.bumptech.glide.provider.ResourceDecoderRegistry;
import com.bumptech.glide.provider.ResourceEncoderRegistry;
import com.bumptech.glide.util.pool.FactoryPools;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public class Registry {
    private static final String BUCKET_APPEND_ALL = "legacy_append";
    public static final String BUCKET_BITMAP = "Bitmap";
    public static final String BUCKET_BITMAP_DRAWABLE = "BitmapDrawable";
    public static final String BUCKET_GIF = "Gif";
    private static final String BUCKET_PREPEND_ALL = "legacy_prepend_all";
    private final ModelToResourceClassCache modelToResourceClassCache = new ModelToResourceClassCache();
    private final LoadPathCache loadPathCache = new LoadPathCache();
    private final Pools.Pool<List<Throwable>> throwableListPool = FactoryPools.threadSafeList();
    private final ModelLoaderRegistry modelLoaderRegistry = new ModelLoaderRegistry(this.throwableListPool);
    private final EncoderRegistry encoderRegistry = new EncoderRegistry();
    private final ResourceDecoderRegistry decoderRegistry = new ResourceDecoderRegistry();
    private final ResourceEncoderRegistry resourceEncoderRegistry = new ResourceEncoderRegistry();
    private final DataRewinderRegistry dataRewinderRegistry = new DataRewinderRegistry();
    private final TranscoderRegistry transcoderRegistry = new TranscoderRegistry();
    private final ImageHeaderParserRegistry imageHeaderParserRegistry = new ImageHeaderParserRegistry();

    public Registry() {
        setResourceDecoderBucketPriorityList(Arrays.asList(BUCKET_GIF, BUCKET_BITMAP, BUCKET_BITMAP_DRAWABLE));
    }

    @Deprecated
    public <Data> Registry register(Class<Data> cls, Encoder<Data> encoder) {
        return append(cls, encoder);
    }

    public <Data> Registry append(Class<Data> cls, Encoder<Data> encoder) {
        this.encoderRegistry.append(cls, encoder);
        return this;
    }

    public <Data> Registry prepend(Class<Data> cls, Encoder<Data> encoder) {
        this.encoderRegistry.prepend(cls, encoder);
        return this;
    }

    public <Data, TResource> Registry append(Class<Data> cls, Class<TResource> cls2, ResourceDecoder<Data, TResource> resourceDecoder) {
        append(BUCKET_APPEND_ALL, cls, cls2, resourceDecoder);
        return this;
    }

    public <Data, TResource> Registry append(String str, Class<Data> cls, Class<TResource> cls2, ResourceDecoder<Data, TResource> resourceDecoder) {
        this.decoderRegistry.append(str, resourceDecoder, cls, cls2);
        return this;
    }

    public <Data, TResource> Registry prepend(Class<Data> cls, Class<TResource> cls2, ResourceDecoder<Data, TResource> resourceDecoder) {
        prepend(BUCKET_PREPEND_ALL, cls, cls2, resourceDecoder);
        return this;
    }

    public <Data, TResource> Registry prepend(String str, Class<Data> cls, Class<TResource> cls2, ResourceDecoder<Data, TResource> resourceDecoder) {
        this.decoderRegistry.prepend(str, resourceDecoder, cls, cls2);
        return this;
    }

    public final Registry setResourceDecoderBucketPriorityList(List<String> list) {
        ArrayList arrayList = new ArrayList(list.size());
        arrayList.addAll(list);
        arrayList.add(0, BUCKET_PREPEND_ALL);
        arrayList.add(BUCKET_APPEND_ALL);
        this.decoderRegistry.setBucketPriorityList(arrayList);
        return this;
    }

    @Deprecated
    public <TResource> Registry register(Class<TResource> cls, ResourceEncoder<TResource> resourceEncoder) {
        return append((Class) cls, (ResourceEncoder) resourceEncoder);
    }

    public <TResource> Registry append(Class<TResource> cls, ResourceEncoder<TResource> resourceEncoder) {
        this.resourceEncoderRegistry.append(cls, resourceEncoder);
        return this;
    }

    public <TResource> Registry prepend(Class<TResource> cls, ResourceEncoder<TResource> resourceEncoder) {
        this.resourceEncoderRegistry.prepend(cls, resourceEncoder);
        return this;
    }

    public Registry register(DataRewinder.Factory<?> factory) {
        this.dataRewinderRegistry.register(factory);
        return this;
    }

    public <TResource, Transcode> Registry register(Class<TResource> cls, Class<Transcode> cls2, ResourceTranscoder<TResource, Transcode> resourceTranscoder) {
        this.transcoderRegistry.register(cls, cls2, resourceTranscoder);
        return this;
    }

    public Registry register(ImageHeaderParser imageHeaderParser) {
        this.imageHeaderParserRegistry.add(imageHeaderParser);
        return this;
    }

    public <Model, Data> Registry append(Class<Model> cls, Class<Data> cls2, ModelLoaderFactory<Model, Data> modelLoaderFactory) {
        this.modelLoaderRegistry.append(cls, cls2, modelLoaderFactory);
        return this;
    }

    public <Model, Data> Registry prepend(Class<Model> cls, Class<Data> cls2, ModelLoaderFactory<Model, Data> modelLoaderFactory) {
        this.modelLoaderRegistry.prepend(cls, cls2, modelLoaderFactory);
        return this;
    }

    public <Model, Data> Registry replace(Class<Model> cls, Class<Data> cls2, ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory) {
        this.modelLoaderRegistry.replace(cls, cls2, modelLoaderFactory);
        return this;
    }

    public <Data, TResource, Transcode> LoadPath<Data, TResource, Transcode> getLoadPath(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        LoadPath<Data, TResource, Transcode> loadPath = this.loadPathCache.get(cls, cls2, cls3);
        if (this.loadPathCache.isEmptyLoadPath(loadPath)) {
            return null;
        }
        if (loadPath == null) {
            List<DecodePath<Data, TResource, Transcode>> decodePaths = getDecodePaths(cls, cls2, cls3);
            loadPath = decodePaths.isEmpty() ? null : new LoadPath<>(cls, cls2, cls3, decodePaths, this.throwableListPool);
            this.loadPathCache.put(cls, cls2, cls3, loadPath);
        }
        return loadPath;
    }

    private <Data, TResource, Transcode> List<DecodePath<Data, TResource, Transcode>> getDecodePaths(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        ArrayList arrayList = new ArrayList();
        for (Class cls4 : this.decoderRegistry.getResourceClasses(cls, cls2)) {
            for (Class cls5 : this.transcoderRegistry.getTranscodeClasses(cls4, cls3)) {
                arrayList.add(new DecodePath(cls, cls4, cls5, this.decoderRegistry.getDecoders(cls, cls4), this.transcoderRegistry.get(cls4, cls5), this.throwableListPool));
            }
        }
        return arrayList;
    }

    public <Model, TResource, Transcode> List<Class<?>> getRegisteredResourceClasses(Class<Model> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        List<Class<?>> list = this.modelToResourceClassCache.get(cls, cls2, cls3);
        if (list == null) {
            list = new ArrayList<>();
            for (Class<?> cls4 : this.modelLoaderRegistry.getDataClasses(cls)) {
                for (Class<?> cls5 : this.decoderRegistry.getResourceClasses(cls4, cls2)) {
                    if (!this.transcoderRegistry.getTranscodeClasses(cls5, cls3).isEmpty() && !list.contains(cls5)) {
                        list.add(cls5);
                    }
                }
            }
            this.modelToResourceClassCache.put(cls, cls2, cls3, Collections.unmodifiableList(list));
        }
        return list;
    }

    public boolean isResourceEncoderAvailable(Resource<?> resource) {
        return this.resourceEncoderRegistry.get(resource.getResourceClass()) != null;
    }

    public <X> ResourceEncoder<X> getResultEncoder(Resource<X> resource) throws NoResultEncoderAvailableException {
        ResourceEncoder<X> resourceEncoder = this.resourceEncoderRegistry.get(resource.getResourceClass());
        if (resourceEncoder != null) {
            return resourceEncoder;
        }
        throw new NoResultEncoderAvailableException(resource.getResourceClass());
    }

    public <X> Encoder<X> getSourceEncoder(X x) throws NoSourceEncoderAvailableException {
        Encoder<X> encoder = this.encoderRegistry.getEncoder(x.getClass());
        if (encoder != null) {
            return encoder;
        }
        throw new NoSourceEncoderAvailableException(x.getClass());
    }

    public <X> DataRewinder<X> getRewinder(X x) {
        return this.dataRewinderRegistry.build(x);
    }

    public <Model> List<ModelLoader<Model, ?>> getModelLoaders(Model model) {
        return this.modelLoaderRegistry.getModelLoaders(model);
    }

    public List<ImageHeaderParser> getImageHeaderParsers() {
        List<ImageHeaderParser> parsers = this.imageHeaderParserRegistry.getParsers();
        if (parsers.isEmpty()) {
            throw new NoImageHeaderParserException();
        }
        return parsers;
    }

    /* loaded from: classes.dex */
    public static class NoModelLoaderAvailableException extends MissingComponentException {
        public NoModelLoaderAvailableException(Object obj) {
            super("Failed to find any ModelLoaders registered for model class: " + obj.getClass());
        }

        public <M> NoModelLoaderAvailableException(M m, List<ModelLoader<M, ?>> list) {
            super("Found ModelLoaders for model class: " + list + ", but none that handle this specific model instance: " + m);
        }

        public NoModelLoaderAvailableException(Class<?> cls, Class<?> cls2) {
            super("Failed to find any ModelLoaders for model: " + cls + " and data: " + cls2);
        }
    }

    /* loaded from: classes.dex */
    public static class NoResultEncoderAvailableException extends MissingComponentException {
        public NoResultEncoderAvailableException(Class<?> cls) {
            super("Failed to find result encoder for resource class: " + cls + ", you may need to consider registering a new Encoder for the requested type or DiskCacheStrategy.DATA/DiskCacheStrategy.NONE if caching your transformed resource is unnecessary.");
        }
    }

    /* loaded from: classes.dex */
    public static class NoSourceEncoderAvailableException extends MissingComponentException {
        public NoSourceEncoderAvailableException(Class<?> cls) {
            super("Failed to find source encoder for data class: " + cls);
        }
    }

    /* loaded from: classes.dex */
    public static class MissingComponentException extends RuntimeException {
        public MissingComponentException(String str) {
            super(str);
        }
    }

    /* loaded from: classes.dex */
    public static final class NoImageHeaderParserException extends MissingComponentException {
        public NoImageHeaderParserException() {
            super("Failed to find image header parser.");
        }
    }
}
