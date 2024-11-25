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
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class DecodeHelper<Transcode> {
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public <R> void init(GlideContext glideContext, Object obj, Key key, int i, int i2, DiskCacheStrategy diskCacheStrategy, Class<?> cls, Class<R> cls2, Priority priority, Options options, Map<Class<?>, Transformation<?>> map, boolean z, boolean z2, DecodeJob.DiskCacheProvider diskCacheProvider) {
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clear() {
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public DiskCache getDiskCache() {
        return this.diskCacheProvider.getDiskCache();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DiskCacheStrategy getDiskCacheStrategy() {
        return this.diskCacheStrategy;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Priority getPriority() {
        return this.priority;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Options getOptions() {
        return this.options;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Key getSignature() {
        return this.signature;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getWidth() {
        return this.width;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getHeight() {
        return this.height;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayPool getArrayPool() {
        return this.glideContext.getArrayPool();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class<?> getTranscodeClass() {
        return (Class<Transcode>) this.transcodeClass;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class<?> getModelClass() {
        return this.model.getClass();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<Class<?>> getRegisteredResourceClasses() {
        return this.glideContext.getRegistry().getRegisteredResourceClasses(this.model.getClass(), this.resourceClass, this.transcodeClass);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean hasLoadPath(Class<?> cls) {
        return getLoadPath(cls) != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <Data> LoadPath<Data, ?, Transcode> getLoadPath(Class<Data> cls) {
        return this.glideContext.getRegistry().getLoadPath(cls, this.resourceClass, this.transcodeClass);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isScaleOnlyOrNoTransform() {
        return this.isScaleOnlyOrNoTransform;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <Z> Transformation<Z> getTransformation(Class<Z> cls) {
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isResourceEncoderAvailable(Resource<?> resource) {
        return this.glideContext.getRegistry().isResourceEncoderAvailable(resource);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <Z> ResourceEncoder<Z> getResultEncoder(Resource<Z> resource) {
        return this.glideContext.getRegistry().getResultEncoder(resource);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ModelLoader<File, ?>> getModelLoaders(File file) throws Registry.NoModelLoaderAvailableException {
        return this.glideContext.getRegistry().getModelLoaders(file);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isSourceKey(Key key) {
        List<ModelLoader.LoadData<?>> loadData = getLoadData();
        int size = loadData.size();
        for (int i = 0; i < size; i++) {
            if (loadData.get(i).sourceKey.equals(key)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ModelLoader.LoadData<?>> getLoadData() {
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<Key> getCacheKeys() {
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public <X> Encoder<X> getSourceEncoder(X x) throws Registry.NoSourceEncoderAvailableException {
        return this.glideContext.getRegistry().getSourceEncoder(x);
    }
}
