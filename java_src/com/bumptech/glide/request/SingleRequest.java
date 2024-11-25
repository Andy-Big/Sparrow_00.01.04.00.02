package com.bumptech.glide.request;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.drawable.DrawableDecoderCompat;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.TransitionFactory;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Util;
import com.bumptech.glide.util.pool.StateVerifier;
import java.util.List;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public final class SingleRequest<R> implements Request, SizeReadyCallback, ResourceCallback {
    private static final String GLIDE_TAG = "Glide";
    private final TransitionFactory<? super R> animationFactory;
    private final Executor callbackExecutor;
    private final Context context;
    private volatile Engine engine;
    private Drawable errorDrawable;
    private Drawable fallbackDrawable;
    private final GlideContext glideContext;
    private int height;
    private boolean isCallingCallbacks;
    private Engine.LoadStatus loadStatus;
    private final Object model;
    private final int overrideHeight;
    private final int overrideWidth;
    private Drawable placeholderDrawable;
    private final Priority priority;
    private final RequestCoordinator requestCoordinator;
    private final List<RequestListener<R>> requestListeners;
    private final Object requestLock;
    private final BaseRequestOptions<?> requestOptions;
    private RuntimeException requestOrigin;
    private Resource<R> resource;
    private long startTime;
    private final StateVerifier stateVerifier;
    private Status status;
    private final String tag;
    private final Target<R> target;
    private final RequestListener<R> targetListener;
    private final Class<R> transcodeClass;
    private int width;
    private static final String TAG = "Request";
    private static final boolean IS_VERBOSE_LOGGABLE = Log.isLoggable(TAG, 2);

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum Status {
        PENDING,
        RUNNING,
        WAITING_FOR_SIZE,
        COMPLETE,
        FAILED,
        CLEARED
    }

    public static <R> SingleRequest<R> obtain(Context context, GlideContext glideContext, Object obj, Object obj2, Class<R> cls, BaseRequestOptions<?> baseRequestOptions, int i, int i2, Priority priority, Target<R> target, RequestListener<R> requestListener, List<RequestListener<R>> list, RequestCoordinator requestCoordinator, Engine engine, TransitionFactory<? super R> transitionFactory, Executor executor) {
        return new SingleRequest<>(context, glideContext, obj, obj2, cls, baseRequestOptions, i, i2, priority, target, requestListener, list, requestCoordinator, engine, transitionFactory, executor);
    }

    private SingleRequest(Context context, GlideContext glideContext, Object obj, Object obj2, Class<R> cls, BaseRequestOptions<?> baseRequestOptions, int i, int i2, Priority priority, Target<R> target, RequestListener<R> requestListener, List<RequestListener<R>> list, RequestCoordinator requestCoordinator, Engine engine, TransitionFactory<? super R> transitionFactory, Executor executor) {
        this.tag = IS_VERBOSE_LOGGABLE ? String.valueOf(super.hashCode()) : null;
        this.stateVerifier = StateVerifier.newInstance();
        this.requestLock = obj;
        this.context = context;
        this.glideContext = glideContext;
        this.model = obj2;
        this.transcodeClass = cls;
        this.requestOptions = baseRequestOptions;
        this.overrideWidth = i;
        this.overrideHeight = i2;
        this.priority = priority;
        this.target = target;
        this.targetListener = requestListener;
        this.requestListeners = list;
        this.requestCoordinator = requestCoordinator;
        this.engine = engine;
        this.animationFactory = transitionFactory;
        this.callbackExecutor = executor;
        this.status = Status.PENDING;
        if (this.requestOrigin == null && glideContext.isLoggingRequestOriginsEnabled()) {
            this.requestOrigin = new RuntimeException("Glide request origin trace");
        }
    }

    @Override // com.bumptech.glide.request.Request
    public void begin() {
        synchronized (this.requestLock) {
            assertNotCallingCallbacks();
            this.stateVerifier.throwIfRecycled();
            this.startTime = LogTime.getLogTime();
            if (this.model == null) {
                if (Util.isValidDimensions(this.overrideWidth, this.overrideHeight)) {
                    this.width = this.overrideWidth;
                    this.height = this.overrideHeight;
                }
                onLoadFailed(new GlideException("Received null model"), getFallbackDrawable() == null ? 5 : 3);
            } else if (this.status == Status.RUNNING) {
                throw new IllegalArgumentException("Cannot restart a running request");
            } else {
                if (this.status == Status.COMPLETE) {
                    onResourceReady(this.resource, DataSource.MEMORY_CACHE);
                    return;
                }
                this.status = Status.WAITING_FOR_SIZE;
                if (Util.isValidDimensions(this.overrideWidth, this.overrideHeight)) {
                    onSizeReady(this.overrideWidth, this.overrideHeight);
                } else {
                    this.target.getSize(this);
                }
                if ((this.status == Status.RUNNING || this.status == Status.WAITING_FOR_SIZE) && canNotifyStatusChanged()) {
                    this.target.onLoadStarted(getPlaceholderDrawable());
                }
                if (IS_VERBOSE_LOGGABLE) {
                    logV("finished run method in " + LogTime.getElapsedMillis(this.startTime));
                }
            }
        }
    }

    private void cancel() {
        assertNotCallingCallbacks();
        this.stateVerifier.throwIfRecycled();
        this.target.removeCallback(this);
        Engine.LoadStatus loadStatus = this.loadStatus;
        if (loadStatus != null) {
            loadStatus.cancel();
            this.loadStatus = null;
        }
    }

    private void assertNotCallingCallbacks() {
        if (this.isCallingCallbacks) {
            throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
        }
    }

    @Override // com.bumptech.glide.request.Request
    public void clear() {
        synchronized (this.requestLock) {
            assertNotCallingCallbacks();
            this.stateVerifier.throwIfRecycled();
            if (this.status == Status.CLEARED) {
                return;
            }
            cancel();
            Resource<?> resource = null;
            if (this.resource != null) {
                Resource<R> resource2 = this.resource;
                this.resource = null;
                resource = resource2;
            }
            if (canNotifyCleared()) {
                this.target.onLoadCleared(getPlaceholderDrawable());
            }
            this.status = Status.CLEARED;
            if (resource != null) {
                this.engine.release(resource);
            }
        }
    }

    @Override // com.bumptech.glide.request.Request
    public void pause() {
        synchronized (this.requestLock) {
            if (isRunning()) {
                clear();
            }
        }
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isRunning() {
        boolean z;
        synchronized (this.requestLock) {
            z = this.status == Status.RUNNING || this.status == Status.WAITING_FOR_SIZE;
        }
        return z;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isComplete() {
        boolean z;
        synchronized (this.requestLock) {
            z = this.status == Status.COMPLETE;
        }
        return z;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isCleared() {
        boolean z;
        synchronized (this.requestLock) {
            z = this.status == Status.CLEARED;
        }
        return z;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isAnyResourceSet() {
        boolean z;
        synchronized (this.requestLock) {
            z = this.status == Status.COMPLETE;
        }
        return z;
    }

    private Drawable getErrorDrawable() {
        if (this.errorDrawable == null) {
            Drawable errorPlaceholder = this.requestOptions.getErrorPlaceholder();
            this.errorDrawable = errorPlaceholder;
            if (errorPlaceholder == null && this.requestOptions.getErrorId() > 0) {
                this.errorDrawable = loadDrawable(this.requestOptions.getErrorId());
            }
        }
        return this.errorDrawable;
    }

    private Drawable getPlaceholderDrawable() {
        if (this.placeholderDrawable == null) {
            Drawable placeholderDrawable = this.requestOptions.getPlaceholderDrawable();
            this.placeholderDrawable = placeholderDrawable;
            if (placeholderDrawable == null && this.requestOptions.getPlaceholderId() > 0) {
                this.placeholderDrawable = loadDrawable(this.requestOptions.getPlaceholderId());
            }
        }
        return this.placeholderDrawable;
    }

    private Drawable getFallbackDrawable() {
        if (this.fallbackDrawable == null) {
            Drawable fallbackDrawable = this.requestOptions.getFallbackDrawable();
            this.fallbackDrawable = fallbackDrawable;
            if (fallbackDrawable == null && this.requestOptions.getFallbackId() > 0) {
                this.fallbackDrawable = loadDrawable(this.requestOptions.getFallbackId());
            }
        }
        return this.fallbackDrawable;
    }

    private Drawable loadDrawable(int i) {
        return DrawableDecoderCompat.getDrawable(this.glideContext, i, this.requestOptions.getTheme() != null ? this.requestOptions.getTheme() : this.context.getTheme());
    }

    private void setErrorPlaceholder() {
        if (canNotifyStatusChanged()) {
            Drawable fallbackDrawable = this.model == null ? getFallbackDrawable() : null;
            if (fallbackDrawable == null) {
                fallbackDrawable = getErrorDrawable();
            }
            if (fallbackDrawable == null) {
                fallbackDrawable = getPlaceholderDrawable();
            }
            this.target.onLoadFailed(fallbackDrawable);
        }
    }

    @Override // com.bumptech.glide.request.target.SizeReadyCallback
    public void onSizeReady(int i, int i2) {
        Object obj;
        this.stateVerifier.throwIfRecycled();
        Object obj2 = this.requestLock;
        synchronized (obj2) {
            try {
                try {
                    if (IS_VERBOSE_LOGGABLE) {
                        logV("Got onSizeReady in " + LogTime.getElapsedMillis(this.startTime));
                    }
                    if (this.status == Status.WAITING_FOR_SIZE) {
                        this.status = Status.RUNNING;
                        float sizeMultiplier = this.requestOptions.getSizeMultiplier();
                        this.width = maybeApplySizeMultiplier(i, sizeMultiplier);
                        this.height = maybeApplySizeMultiplier(i2, sizeMultiplier);
                        if (IS_VERBOSE_LOGGABLE) {
                            logV("finished setup for calling load in " + LogTime.getElapsedMillis(this.startTime));
                        }
                        obj = obj2;
                        try {
                            this.loadStatus = this.engine.load(this.glideContext, this.model, this.requestOptions.getSignature(), this.width, this.height, this.requestOptions.getResourceClass(), this.transcodeClass, this.priority, this.requestOptions.getDiskCacheStrategy(), this.requestOptions.getTransformations(), this.requestOptions.isTransformationRequired(), this.requestOptions.isScaleOnlyOrNoTransform(), this.requestOptions.getOptions(), this.requestOptions.isMemoryCacheable(), this.requestOptions.getUseUnlimitedSourceGeneratorsPool(), this.requestOptions.getUseAnimationPool(), this.requestOptions.getOnlyRetrieveFromCache(), this, this.callbackExecutor);
                            if (this.status != Status.RUNNING) {
                                this.loadStatus = null;
                            }
                            if (IS_VERBOSE_LOGGABLE) {
                                logV("finished onSizeReady in " + LogTime.getElapsedMillis(this.startTime));
                            }
                        } catch (Throwable th) {
                            th = th;
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                obj = obj2;
            }
        }
    }

    private static int maybeApplySizeMultiplier(int i, float f) {
        return i == Integer.MIN_VALUE ? i : Math.round(f * i);
    }

    private boolean canSetResource() {
        RequestCoordinator requestCoordinator = this.requestCoordinator;
        return requestCoordinator == null || requestCoordinator.canSetImage(this);
    }

    private boolean canNotifyCleared() {
        RequestCoordinator requestCoordinator = this.requestCoordinator;
        return requestCoordinator == null || requestCoordinator.canNotifyCleared(this);
    }

    private boolean canNotifyStatusChanged() {
        RequestCoordinator requestCoordinator = this.requestCoordinator;
        return requestCoordinator == null || requestCoordinator.canNotifyStatusChanged(this);
    }

    private boolean isFirstReadyResource() {
        RequestCoordinator requestCoordinator = this.requestCoordinator;
        return requestCoordinator == null || !requestCoordinator.getRoot().isAnyResourceSet();
    }

    private void notifyLoadSuccess() {
        RequestCoordinator requestCoordinator = this.requestCoordinator;
        if (requestCoordinator != null) {
            requestCoordinator.onRequestSuccess(this);
        }
    }

    private void notifyLoadFailed() {
        RequestCoordinator requestCoordinator = this.requestCoordinator;
        if (requestCoordinator != null) {
            requestCoordinator.onRequestFailed(this);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x004f, code lost:
        if (r6 == null) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0051, code lost:
        r5.engine.release(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0056, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00ad, code lost:
        if (r6 == null) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00af, code lost:
        r5.engine.release(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00b4, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:?, code lost:
        return;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.request.ResourceCallback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onResourceReady(com.bumptech.glide.load.engine.Resource<?> r6, com.bumptech.glide.load.DataSource r7) {
        /*
            r5 = this;
            com.bumptech.glide.util.pool.StateVerifier r0 = r5.stateVerifier
            r0.throwIfRecycled()
            r0 = 0
            java.lang.Object r1 = r5.requestLock     // Catch: java.lang.Throwable -> Lbc
            monitor-enter(r1)     // Catch: java.lang.Throwable -> Lbc
            r5.loadStatus = r0     // Catch: java.lang.Throwable -> Lb9
            if (r6 != 0) goto L2f
            com.bumptech.glide.load.engine.GlideException r6 = new com.bumptech.glide.load.engine.GlideException     // Catch: java.lang.Throwable -> Lb9
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lb9
            r7.<init>()     // Catch: java.lang.Throwable -> Lb9
            java.lang.String r2 = "Expected to receive a Resource<R> with an object of "
            r7.append(r2)     // Catch: java.lang.Throwable -> Lb9
            java.lang.Class<R> r2 = r5.transcodeClass     // Catch: java.lang.Throwable -> Lb9
            r7.append(r2)     // Catch: java.lang.Throwable -> Lb9
            java.lang.String r2 = " inside, but instead got null."
            r7.append(r2)     // Catch: java.lang.Throwable -> Lb9
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Throwable -> Lb9
            r6.<init>(r7)     // Catch: java.lang.Throwable -> Lb9
            r5.onLoadFailed(r6)     // Catch: java.lang.Throwable -> Lb9
            monitor-exit(r1)     // Catch: java.lang.Throwable -> Lb9
            return
        L2f:
            java.lang.Object r2 = r6.get()     // Catch: java.lang.Throwable -> Lb9
            if (r2 == 0) goto L5c
            java.lang.Class<R> r3 = r5.transcodeClass     // Catch: java.lang.Throwable -> Lb9
            java.lang.Class r4 = r2.getClass()     // Catch: java.lang.Throwable -> Lb9
            boolean r3 = r3.isAssignableFrom(r4)     // Catch: java.lang.Throwable -> Lb9
            if (r3 != 0) goto L42
            goto L5c
        L42:
            boolean r3 = r5.canSetResource()     // Catch: java.lang.Throwable -> Lb9
            if (r3 != 0) goto L57
            r5.resource = r0     // Catch: java.lang.Throwable -> Lb5
            com.bumptech.glide.request.SingleRequest$Status r7 = com.bumptech.glide.request.SingleRequest.Status.COMPLETE     // Catch: java.lang.Throwable -> Lb5
            r5.status = r7     // Catch: java.lang.Throwable -> Lb5
            monitor-exit(r1)     // Catch: java.lang.Throwable -> Lb5
            if (r6 == 0) goto L56
            com.bumptech.glide.load.engine.Engine r7 = r5.engine
            r7.release(r6)
        L56:
            return
        L57:
            r5.onResourceReady(r6, r2, r7)     // Catch: java.lang.Throwable -> Lb9
            monitor-exit(r1)     // Catch: java.lang.Throwable -> Lb9
            return
        L5c:
            r5.resource = r0     // Catch: java.lang.Throwable -> Lb5
            com.bumptech.glide.load.engine.GlideException r7 = new com.bumptech.glide.load.engine.GlideException     // Catch: java.lang.Throwable -> Lb5
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lb5
            r0.<init>()     // Catch: java.lang.Throwable -> Lb5
            java.lang.String r3 = "Expected to receive an object of "
            r0.append(r3)     // Catch: java.lang.Throwable -> Lb5
            java.lang.Class<R> r3 = r5.transcodeClass     // Catch: java.lang.Throwable -> Lb5
            r0.append(r3)     // Catch: java.lang.Throwable -> Lb5
            java.lang.String r3 = " but instead got "
            r0.append(r3)     // Catch: java.lang.Throwable -> Lb5
            if (r2 == 0) goto L7b
            java.lang.Class r3 = r2.getClass()     // Catch: java.lang.Throwable -> Lb5
            goto L7d
        L7b:
            java.lang.String r3 = ""
        L7d:
            r0.append(r3)     // Catch: java.lang.Throwable -> Lb5
            java.lang.String r3 = "{"
            r0.append(r3)     // Catch: java.lang.Throwable -> Lb5
            r0.append(r2)     // Catch: java.lang.Throwable -> Lb5
            java.lang.String r3 = "} inside Resource{"
            r0.append(r3)     // Catch: java.lang.Throwable -> Lb5
            r0.append(r6)     // Catch: java.lang.Throwable -> Lb5
            java.lang.String r3 = "}."
            r0.append(r3)     // Catch: java.lang.Throwable -> Lb5
            if (r2 == 0) goto L9d
            java.lang.String r2 = ""
            goto L9f
        L9d:
            java.lang.String r2 = " To indicate failure return a null Resource object, rather than a Resource object containing null data."
        L9f:
            r0.append(r2)     // Catch: java.lang.Throwable -> Lb5
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> Lb5
            r7.<init>(r0)     // Catch: java.lang.Throwable -> Lb5
            r5.onLoadFailed(r7)     // Catch: java.lang.Throwable -> Lb5
            monitor-exit(r1)     // Catch: java.lang.Throwable -> Lb5
            if (r6 == 0) goto Lb4
            com.bumptech.glide.load.engine.Engine r7 = r5.engine
            r7.release(r6)
        Lb4:
            return
        Lb5:
            r7 = move-exception
            r0 = r6
            r6 = r7
            goto Lba
        Lb9:
            r6 = move-exception
        Lba:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> Lb9
            throw r6     // Catch: java.lang.Throwable -> Lbc
        Lbc:
            r6 = move-exception
            if (r0 == 0) goto Lc4
            com.bumptech.glide.load.engine.Engine r7 = r5.engine
            r7.release(r0)
        Lc4:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.SingleRequest.onResourceReady(com.bumptech.glide.load.engine.Resource, com.bumptech.glide.load.DataSource):void");
    }

    private void onResourceReady(Resource<R> resource, R r, DataSource dataSource) {
        boolean z;
        boolean isFirstReadyResource = isFirstReadyResource();
        this.status = Status.COMPLETE;
        this.resource = resource;
        if (this.glideContext.getLogLevel() <= 3) {
            Log.d(GLIDE_TAG, "Finished loading " + r.getClass().getSimpleName() + " from " + dataSource + " for " + this.model + " with size [" + this.width + "x" + this.height + "] in " + LogTime.getElapsedMillis(this.startTime) + " ms");
        }
        boolean z2 = true;
        this.isCallingCallbacks = true;
        try {
            if (this.requestListeners != null) {
                z = false;
                for (RequestListener<R> requestListener : this.requestListeners) {
                    z |= requestListener.onResourceReady(r, this.model, this.target, dataSource, isFirstReadyResource);
                }
            } else {
                z = false;
            }
            if (this.targetListener == null || !this.targetListener.onResourceReady(r, this.model, this.target, dataSource, isFirstReadyResource)) {
                z2 = false;
            }
            if (!(z2 | z)) {
                this.target.onResourceReady(r, this.animationFactory.build(dataSource, isFirstReadyResource));
            }
            this.isCallingCallbacks = false;
            notifyLoadSuccess();
        } catch (Throwable th) {
            this.isCallingCallbacks = false;
            throw th;
        }
    }

    @Override // com.bumptech.glide.request.ResourceCallback
    public void onLoadFailed(GlideException glideException) {
        onLoadFailed(glideException, 5);
    }

    @Override // com.bumptech.glide.request.ResourceCallback
    public Object getLock() {
        this.stateVerifier.throwIfRecycled();
        return this.requestLock;
    }

    private void onLoadFailed(GlideException glideException, int i) {
        boolean z;
        this.stateVerifier.throwIfRecycled();
        synchronized (this.requestLock) {
            glideException.setOrigin(this.requestOrigin);
            int logLevel = this.glideContext.getLogLevel();
            if (logLevel <= i) {
                Log.w(GLIDE_TAG, "Load failed for " + this.model + " with size [" + this.width + "x" + this.height + "]", glideException);
                if (logLevel <= 4) {
                    glideException.logRootCauses(GLIDE_TAG);
                }
            }
            this.loadStatus = null;
            this.status = Status.FAILED;
            boolean z2 = true;
            this.isCallingCallbacks = true;
            if (this.requestListeners != null) {
                z = false;
                for (RequestListener<R> requestListener : this.requestListeners) {
                    z |= requestListener.onLoadFailed(glideException, this.model, this.target, isFirstReadyResource());
                }
            } else {
                z = false;
            }
            if (this.targetListener == null || !this.targetListener.onLoadFailed(glideException, this.model, this.target, isFirstReadyResource())) {
                z2 = false;
            }
            if (!(z | z2)) {
                setErrorPlaceholder();
            }
            this.isCallingCallbacks = false;
            notifyLoadFailed();
        }
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isEquivalentTo(Request request) {
        int i;
        int i2;
        Object obj;
        Class<R> cls;
        BaseRequestOptions<?> baseRequestOptions;
        Priority priority;
        int size;
        int i3;
        int i4;
        Object obj2;
        Class<R> cls2;
        BaseRequestOptions<?> baseRequestOptions2;
        Priority priority2;
        int size2;
        if (request instanceof SingleRequest) {
            synchronized (this.requestLock) {
                i = this.overrideWidth;
                i2 = this.overrideHeight;
                obj = this.model;
                cls = this.transcodeClass;
                baseRequestOptions = this.requestOptions;
                priority = this.priority;
                size = this.requestListeners != null ? this.requestListeners.size() : 0;
            }
            SingleRequest singleRequest = (SingleRequest) request;
            synchronized (singleRequest.requestLock) {
                i3 = singleRequest.overrideWidth;
                i4 = singleRequest.overrideHeight;
                obj2 = singleRequest.model;
                cls2 = singleRequest.transcodeClass;
                baseRequestOptions2 = singleRequest.requestOptions;
                priority2 = singleRequest.priority;
                size2 = singleRequest.requestListeners != null ? singleRequest.requestListeners.size() : 0;
            }
            return i == i3 && i2 == i4 && Util.bothModelsNullEquivalentOrEquals(obj, obj2) && cls.equals(cls2) && baseRequestOptions.equals(baseRequestOptions2) && priority == priority2 && size == size2;
        }
        return false;
    }

    private void logV(String str) {
        Log.v(TAG, str + " this: " + this.tag);
    }
}
