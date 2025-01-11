package androidx.lifecycle;

import androidx.arch.core.internal.SafeIterableMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public class MediatorLiveData<T> extends MutableLiveData<T> {
    private SafeIterableMap<LiveData<?>, Source<?>> mSources = new SafeIterableMap<>();

    public <S> void addSource(LiveData<S> liveData, Observer<? super S> observer) {
        Source<?> source = new Source<>(liveData, observer);
        Source<?> putIfAbsent = this.mSources.putIfAbsent(liveData, source);
        if (putIfAbsent != null && putIfAbsent.mObserver != observer) {
            throw new IllegalArgumentException("This source was already added with the different observer");
        }
        if (putIfAbsent == null && hasActiveObservers()) {
            source.plug();
        }
    }

    public <S> void removeSource(LiveData<S> liveData) {
        Source<?> remove = this.mSources.remove(liveData);
        if (remove != null) {
            remove.unplug();
        }
    }

    @Override // androidx.lifecycle.LiveData
    protected void onActive() {
        Iterator<Map.Entry<LiveData<?>, Source<?>>> it = this.mSources.iterator();
        while (it.hasNext()) {
            it.next().getValue().plug();
        }
    }

    @Override // androidx.lifecycle.LiveData
    protected void onInactive() {
        Iterator<Map.Entry<LiveData<?>, Source<?>>> it = this.mSources.iterator();
        while (it.hasNext()) {
            it.next().getValue().unplug();
        }
    }

    /* loaded from: classes.dex */
    private static class Source<V> implements Observer<V> {
        final LiveData<V> mLiveData;
        final Observer<? super V> mObserver;
        int mVersion = -1;

        Source(LiveData<V> liveData, Observer<? super V> observer) {
            this.mLiveData = liveData;
            this.mObserver = observer;
        }

        void plug() {
            this.mLiveData.observeForever(this);
        }

        void unplug() {
            this.mLiveData.removeObserver(this);
        }

        @Override // androidx.lifecycle.Observer
        public void onChanged(V v) {
            if (this.mVersion != this.mLiveData.getVersion()) {
                this.mVersion = this.mLiveData.getVersion();
                this.mObserver.onChanged(v);
            }
        }
    }
}
