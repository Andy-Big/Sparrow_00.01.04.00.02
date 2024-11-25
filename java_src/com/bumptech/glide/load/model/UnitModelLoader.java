package com.bumptech.glide.load.model;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.signature.ObjectKey;
/* loaded from: classes.dex */
public class UnitModelLoader<Model> implements ModelLoader<Model, Model> {
    private static final UnitModelLoader<?> INSTANCE = new UnitModelLoader<>();

    @Override // com.bumptech.glide.load.model.ModelLoader
    public boolean handles(Model model) {
        return true;
    }

    public static <T> UnitModelLoader<T> getInstance() {
        return (UnitModelLoader<T>) INSTANCE;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public ModelLoader.LoadData<Model> buildLoadData(Model model, int i, int i2, Options options) {
        return new ModelLoader.LoadData<>(new ObjectKey(model), new UnitFetcher(model));
    }

    /* loaded from: classes.dex */
    private static class UnitFetcher<Model> implements DataFetcher<Model> {
        private final Model resource;

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cancel() {
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cleanup() {
        }

        UnitFetcher(Model model) {
            this.resource = model;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void loadData(Priority priority, DataFetcher.DataCallback<? super Model> dataCallback) {
            dataCallback.onDataReady((Model) this.resource);
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public Class<Model> getDataClass() {
            return (Class<Model>) this.resource.getClass();
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public DataSource getDataSource() {
            return DataSource.LOCAL;
        }
    }

    /* loaded from: classes.dex */
    public static class Factory<Model> implements ModelLoaderFactory<Model, Model> {
        private static final Factory<?> FACTORY = new Factory<>();

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }

        public static <T> Factory<T> getInstance() {
            return (Factory<T>) FACTORY;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader<Model, Model> build(MultiModelLoaderFactory multiModelLoaderFactory) {
            return UnitModelLoader.getInstance();
        }
    }
}
