package com.bumptech.glide.load.model.stream;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.mediastore.MediaStoreUtil;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import com.bumptech.glide.signature.ObjectKey;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
/* loaded from: classes.dex */
public final class QMediaStoreUriLoader<DataT> implements ModelLoader<Uri, DataT> {
    private final Context context;
    private final Class<DataT> dataClass;
    private final ModelLoader<File, DataT> fileDelegate;
    private final ModelLoader<Uri, DataT> uriDelegate;

    QMediaStoreUriLoader(Context context, ModelLoader<File, DataT> modelLoader, ModelLoader<Uri, DataT> modelLoader2, Class<DataT> cls) {
        this.context = context.getApplicationContext();
        this.fileDelegate = modelLoader;
        this.uriDelegate = modelLoader2;
        this.dataClass = cls;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public ModelLoader.LoadData<DataT> buildLoadData(Uri uri, int i, int i2, Options options) {
        return new ModelLoader.LoadData<>(new ObjectKey(uri), new QMediaStoreUriFetcher(this.context, this.fileDelegate, this.uriDelegate, uri, i, i2, options, this.dataClass));
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public boolean handles(Uri uri) {
        return Build.VERSION.SDK_INT >= 29 && MediaStoreUtil.isMediaStoreUri(uri);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class QMediaStoreUriFetcher<DataT> implements DataFetcher<DataT> {
        private static final String[] PROJECTION = {"_data"};
        private final Context context;
        private final Class<DataT> dataClass;
        private volatile DataFetcher<DataT> delegate;
        private final ModelLoader<File, DataT> fileDelegate;
        private final int height;
        private volatile boolean isCancelled;
        private final Options options;
        private final Uri uri;
        private final ModelLoader<Uri, DataT> uriDelegate;
        private final int width;

        QMediaStoreUriFetcher(Context context, ModelLoader<File, DataT> modelLoader, ModelLoader<Uri, DataT> modelLoader2, Uri uri, int i, int i2, Options options, Class<DataT> cls) {
            this.context = context.getApplicationContext();
            this.fileDelegate = modelLoader;
            this.uriDelegate = modelLoader2;
            this.uri = uri;
            this.width = i;
            this.height = i2;
            this.options = options;
            this.dataClass = cls;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void loadData(Priority priority, DataFetcher.DataCallback<? super DataT> dataCallback) {
            try {
                DataFetcher<DataT> buildDelegateFetcher = buildDelegateFetcher();
                if (buildDelegateFetcher == null) {
                    dataCallback.onLoadFailed(new IllegalArgumentException("Failed to build fetcher for: " + this.uri));
                    return;
                }
                this.delegate = buildDelegateFetcher;
                if (this.isCancelled) {
                    cancel();
                } else {
                    buildDelegateFetcher.loadData(priority, dataCallback);
                }
            } catch (FileNotFoundException e) {
                dataCallback.onLoadFailed(e);
            }
        }

        private DataFetcher<DataT> buildDelegateFetcher() throws FileNotFoundException {
            ModelLoader.LoadData<DataT> buildDelegateData = buildDelegateData();
            if (buildDelegateData != null) {
                return buildDelegateData.fetcher;
            }
            return null;
        }

        private ModelLoader.LoadData<DataT> buildDelegateData() throws FileNotFoundException {
            if (Environment.isExternalStorageLegacy()) {
                return this.fileDelegate.buildLoadData(queryForFilePath(this.uri), this.width, this.height, this.options);
            }
            return this.uriDelegate.buildLoadData(isAccessMediaLocationGranted() ? MediaStore.setRequireOriginal(this.uri) : this.uri, this.width, this.height, this.options);
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cleanup() {
            DataFetcher<DataT> dataFetcher = this.delegate;
            if (dataFetcher != null) {
                dataFetcher.cleanup();
            }
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cancel() {
            this.isCancelled = true;
            DataFetcher<DataT> dataFetcher = this.delegate;
            if (dataFetcher != null) {
                dataFetcher.cancel();
            }
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public Class<DataT> getDataClass() {
            return this.dataClass;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public DataSource getDataSource() {
            return DataSource.LOCAL;
        }

        private File queryForFilePath(Uri uri) throws FileNotFoundException {
            Cursor cursor = null;
            try {
                Cursor query = this.context.getContentResolver().query(uri, PROJECTION, null, null, null);
                if (query == null || !query.moveToFirst()) {
                    throw new FileNotFoundException("Failed to media store entry for: " + uri);
                }
                String string = query.getString(query.getColumnIndexOrThrow("_data"));
                if (TextUtils.isEmpty(string)) {
                    throw new FileNotFoundException("File path was empty in media store for: " + uri);
                }
                File file = new File(string);
                if (query != null) {
                    query.close();
                }
                return file;
            } catch (Throwable th) {
                if (0 != 0) {
                    cursor.close();
                }
                throw th;
            }
        }

        private boolean isAccessMediaLocationGranted() {
            return this.context.checkSelfPermission("android.permission.ACCESS_MEDIA_LOCATION") == 0;
        }
    }

    /* loaded from: classes.dex */
    public static final class InputStreamFactory extends Factory<InputStream> {
        public InputStreamFactory(Context context) {
            super(context, InputStream.class);
        }
    }

    /* loaded from: classes.dex */
    public static final class FileDescriptorFactory extends Factory<ParcelFileDescriptor> {
        public FileDescriptorFactory(Context context) {
            super(context, ParcelFileDescriptor.class);
        }
    }

    /* loaded from: classes.dex */
    private static abstract class Factory<DataT> implements ModelLoaderFactory<Uri, DataT> {
        private final Context context;
        private final Class<DataT> dataClass;

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public final void teardown() {
        }

        Factory(Context context, Class<DataT> cls) {
            this.context = context;
            this.dataClass = cls;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public final ModelLoader<Uri, DataT> build(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new QMediaStoreUriLoader(this.context, multiModelLoaderFactory.build(File.class, this.dataClass), multiModelLoaderFactory.build(Uri.class, this.dataClass), this.dataClass);
        }
    }
}
