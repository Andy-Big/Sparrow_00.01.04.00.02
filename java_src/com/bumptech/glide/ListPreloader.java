package com.bumptech.glide;

import android.graphics.drawable.Drawable;
import android.widget.AbsListView;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.util.Util;
import java.util.List;
import java.util.Queue;
/* loaded from: classes.dex */
public class ListPreloader<T> implements AbsListView.OnScrollListener {
    private int lastEnd;
    private int lastStart;
    private final int maxPreload;
    private final PreloadSizeProvider<T> preloadDimensionProvider;
    private final PreloadModelProvider<T> preloadModelProvider;
    private final PreloadTargetQueue preloadTargetQueue;
    private final RequestManager requestManager;
    private int totalItemCount;
    private int lastFirstVisible = -1;
    private boolean isIncreasing = true;

    /* loaded from: classes.dex */
    public interface PreloadModelProvider<U> {
        List<U> getPreloadItems(int i);

        RequestBuilder<?> getPreloadRequestBuilder(U u);
    }

    /* loaded from: classes.dex */
    public interface PreloadSizeProvider<T> {
        int[] getPreloadSize(T t, int i, int i2);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    public ListPreloader(RequestManager requestManager, PreloadModelProvider<T> preloadModelProvider, PreloadSizeProvider<T> preloadSizeProvider, int i) {
        this.requestManager = requestManager;
        this.preloadModelProvider = preloadModelProvider;
        this.preloadDimensionProvider = preloadSizeProvider;
        this.maxPreload = i;
        this.preloadTargetQueue = new PreloadTargetQueue(i + 1);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        this.totalItemCount = i3;
        int i4 = this.lastFirstVisible;
        if (i > i4) {
            preload(i2 + i, true);
        } else if (i < i4) {
            preload(i, false);
        }
        this.lastFirstVisible = i;
    }

    private void preload(int i, boolean z) {
        if (this.isIncreasing != z) {
            this.isIncreasing = z;
            cancelAll();
        }
        preload(i, (z ? this.maxPreload : -this.maxPreload) + i);
    }

    private void preload(int i, int i2) {
        int min;
        int i3;
        if (i < i2) {
            i3 = Math.max(this.lastEnd, i);
            min = i2;
        } else {
            min = Math.min(this.lastStart, i);
            i3 = i2;
        }
        int min2 = Math.min(this.totalItemCount, min);
        int min3 = Math.min(this.totalItemCount, Math.max(0, i3));
        if (i < i2) {
            for (int i4 = min3; i4 < min2; i4++) {
                preloadAdapterPosition(this.preloadModelProvider.getPreloadItems(i4), i4, true);
            }
        } else {
            for (int i5 = min2 - 1; i5 >= min3; i5--) {
                preloadAdapterPosition(this.preloadModelProvider.getPreloadItems(i5), i5, false);
            }
        }
        this.lastStart = min3;
        this.lastEnd = min2;
    }

    private void preloadAdapterPosition(List<T> list, int i, boolean z) {
        int size = list.size();
        if (z) {
            for (int i2 = 0; i2 < size; i2++) {
                preloadItem(list.get(i2), i, i2);
            }
            return;
        }
        for (int i3 = size - 1; i3 >= 0; i3--) {
            preloadItem(list.get(i3), i, i3);
        }
    }

    private void preloadItem(T t, int i, int i2) {
        int[] preloadSize;
        RequestBuilder<?> preloadRequestBuilder;
        if (t == null || (preloadSize = this.preloadDimensionProvider.getPreloadSize(t, i, i2)) == null || (preloadRequestBuilder = this.preloadModelProvider.getPreloadRequestBuilder(t)) == null) {
            return;
        }
        preloadRequestBuilder.into((RequestBuilder<?>) this.preloadTargetQueue.next(preloadSize[0], preloadSize[1]));
    }

    private void cancelAll() {
        for (int i = 0; i < this.preloadTargetQueue.queue.size(); i++) {
            this.requestManager.clear(this.preloadTargetQueue.next(0, 0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class PreloadTargetQueue {
        final Queue<PreloadTarget> queue;

        PreloadTargetQueue(int i) {
            this.queue = Util.createQueue(i);
            for (int i2 = 0; i2 < i; i2++) {
                this.queue.offer(new PreloadTarget());
            }
        }

        public PreloadTarget next(int i, int i2) {
            PreloadTarget poll = this.queue.poll();
            this.queue.offer(poll);
            poll.photoWidth = i;
            poll.photoHeight = i2;
            return poll;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class PreloadTarget implements Target<Object> {
        int photoHeight;
        int photoWidth;
        private Request request;

        @Override // com.bumptech.glide.manager.LifecycleListener
        public void onDestroy() {
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onLoadCleared(Drawable drawable) {
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onLoadFailed(Drawable drawable) {
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onLoadStarted(Drawable drawable) {
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onResourceReady(Object obj, Transition<? super Object> transition) {
        }

        @Override // com.bumptech.glide.manager.LifecycleListener
        public void onStart() {
        }

        @Override // com.bumptech.glide.manager.LifecycleListener
        public void onStop() {
        }

        @Override // com.bumptech.glide.request.target.Target
        public void removeCallback(SizeReadyCallback sizeReadyCallback) {
        }

        PreloadTarget() {
        }

        @Override // com.bumptech.glide.request.target.Target
        public void getSize(SizeReadyCallback sizeReadyCallback) {
            sizeReadyCallback.onSizeReady(this.photoWidth, this.photoHeight);
        }

        @Override // com.bumptech.glide.request.target.Target
        public void setRequest(Request request) {
            this.request = request;
        }

        @Override // com.bumptech.glide.request.target.Target
        public Request getRequest() {
            return this.request;
        }
    }
}
