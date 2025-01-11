package com.bumptech.glide.load.engine;

import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DecodeJob;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.resource.UnitTransformation;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
final class DecodeHelper<Transcode> {
    private DecodeJob.DiskCacheProvider diskCacheProvider;
    private DiskCacheStrategy diskCacheStrategy;
    private GlideContext glideContext;
    private int height;
    private boolean isCacheKeysSet;
    private boolean isLoadDataSet;
    private boolean isScaleOnlyOrNoTransform;
    private boolean isTransformationRequired;
    private Object model;
    private Options options;
    private Priority priority;
    private Class<?> resourceClass;
    private Key signature;
    private Class<Transcode> transcodeClass;
    private Map<Class<?>, Transformation<?>> transformations;
    private int width;
    private final List<ModelLoader.LoadData<?>> loadData = new ArrayList();
    private final List<Key> cacheKeys = new ArrayList();

    DecodeHelper() {
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: java.lang.Class<R> */
    /* JADX WARN: Multi-variable type inference failed */
    <R> void init(GlideContext glideContext, Object obj, Key key, int i, int i2, DiskCacheStrategy diskCacheStrategy, Class<?> cls, Class<R> cls2, Priority priority, Options options, Map<Class<?>, Transformation<?>> map, boolean z, boolean z2, DecodeJob.DiskCacheProvider diskCacheProvider) {
        this.glideContext = glideContext;
        this.model = obj;
        this.signature = key;
        this.width = i;
        this.height = i2;
        this.diskCacheStrategy = diskCacheStrategy;
        this.resourceClass = cls;
        this.diskCacheProvider = diskCacheProvider;
        this.transcodeClass = cls2;
        this.priority = priority;
        this.options = options;
        this.transformations = map;
        this.isTransformationRequired = z;
        this.isScaleOnlyOrNoTransform = z2;
    }

    void clear() {
        this.glideContext = null;
        this.model = null;
        this.signature = null;
        this.resourceClass = null;
        this.transcodeClass = null;
        this.options = null;
        this.priority = null;
        this.transformations = null;
        this.diskCacheStrategy = null;
        this.loadData.clear();
        this.isLoadDataSet = false;
        this.cacheKeys.clear();
        this.isCacheKeysSet = false;
    }

    DiskCache getDiskCache() {
        return this.diskCacheProvider.getDiskCache();
    }

    DiskCacheStrategy getDiskCacheStrategy() {
        return this.diskCacheStrategy;
    }

    Priority getPriority() {
        return this.priority;
    }

    Options getOptions() {
        return this.options;
    }

    Key getSignature() {
        return this.signature;
    }

    int getWidth() {
        return this.width;
    }

    int getHeight() {
        return this.height;
    }

    ArrayPool getArrayPool() {
        return this.glideContext.getArrayPool();
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: java.lang.Class<Transcode>, java.lang.Class<?> */
    Class<?> getTranscodeClass() {
        return (Class<Transcode>) this.transcodeClass;
    }

    Class<?> getModelClass() {
        return this.model.getClass();
    }

    List<Class<?>> getRegisteredResourceClasses() {
        return this.glideContext.getRegistry().getRegisteredResourceClasses(this.model.getClass(), this.resourceClass, this.transcodeClass);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Class<?> */
    /* JADX WARN: Multi-variable type inference failed */
    boolean hasLoadPath(Class<?> cls) {
        return getLoadPath(cls) != null;
    }

    <Data> LoadPath<Data, ?, Transcode> getLoadPath(Class<Data> cls) {
        return this.glideContext.getRegistry().getLoadPath(cls, this.resourceClass, this.transcodeClass);
    }

    boolean isScaleOnlyOrNoTransform() {
        return this.isScaleOnlyOrNoTransform;
    }

    <Z> Transformation<Z> getTransformation(Class<Z> cls) {
        Transformation<Z> transformation = (Transformation<Z>) this.transformations.get(cls);
        if (transformation == null) {
            Iterator<Map.Entry<Class<?>, Transformation<?>>> it = this.transformations.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<Class<?>, Transformation<?>> next = it.next();
                if (next.getKey().isAssignableFrom(cls)) {
                    transformation = (Transformation<Z>) next.getValue();
                    break;
                }
            }
        }
        if (transformation == null) {
            if (this.transformations.isEmpty() && this.isTransformationRequired) {
                throw new IllegalArgumentException("Missing transformation for " + cls + ". If you wish to ignore unknown resource types, use the optional transformation methods.");
            }
            return UnitTransformation.get();
        }
        return transformation;
    }

    boolean isResourceEncoderAvailable(Resource<?> resource) {
        return this.glideContext.getRegistry().isResourceEncoderAvailable(resource);
    }

    <Z> ResourceEncoder<Z> getResultEncoder(Resource<Z> resource) {
        return this.glideContext.getRegistry().getResultEncoder(resource);
    }

    List<ModelLoader<File, ?>> getModelLoaders(File file) throws Registry.NoModelLoaderAvailableException {
        return this.glideContext.getRegistry().getModelLoaders(file);
    }

    boolean isSourceKey(Key key) {
        List<ModelLoader.LoadData<?>> loadData = getLoadData();
        int size = loadData.size();
        for (int i = 0; i < size; i++) {
            if (loadData.get(i).sourceKey.equals(key)) {
                return true;
            }
        }
        return false;
    }

    List<ModelLoader.LoadData<?>> getLoadData() {
        if (!this.isLoadDataSet) {
            this.isLoadDataSet = true;
            this.loadData.clear();
            List modelLoaders = this.glideContext.getRegistry().getModelLoaders(this.model);
            int size = modelLoaders.size();
            for (int i = 0; i < size; i++) {
                ModelLoader.LoadData<?> buildLoadData = ((ModelLoader) modelLoaders.get(i)).buildLoadData(this.model, this.width, this.height, this.options);
                if (buildLoadData != null) {
                    this.loadData.add(buildLoadData);
                }
            }
        }
        return this.loadData;
    }

    List<Key> getCacheKeys() {
        if (!this.isCacheKeysSet) {
            this.isCacheKeysSet = true;
            this.cacheKeys.clear();
            List<ModelLoader.LoadData<?>> loadData = getLoadData();
            int size = loadData.size();
            for (int i = 0; i < size; i++) {
                ModelLoader.LoadData<?> loadData2 = loadData.get(i);
                if (!this.cacheKeys.contains(loadData2.sourceKey)) {
                    this.cacheKeys.add(loadData2.sourceKey);
                }
                for (int i2 = 0; i2 < loadData2.alternateKeys.size(); i2++) {
                    if (!this.cacheKeys.contains(loadData2.alternateKeys.get(i2))) {
                        this.cacheKeys.add(loadData2.alternateKeys.get(i2));
                    }
                }
            }
        }
        return this.cacheKeys;
    }

    <X> Encoder<X> getSourceEncoder(X x) throws Registry.NoSourceEncoderAvailableException {
        return this.glideContext.getRegistry().getSourceEncoder(x);
    }
}
