package androidx.lifecycle;

import androidx.arch.core.executor.ArchTaskExecutor;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public abstract class ComputableLiveData<T> {
    final AtomicBoolean mComputing;
    final Executor mExecutor;
    final AtomicBoolean mInvalid;
    final Runnable mInvalidationRunnable;
    final LiveData<T> mLiveData;
    final Runnable mRefreshRunnable;

    protected abstract T compute();

    public ComputableLiveData() {
        this(ArchTaskExecutor.getIOThreadExecutor());
    }

    public ComputableLiveData(Executor executor) {
        this.mInvalid = new AtomicBoolean(true);
        this.mComputing = new AtomicBoolean(false);
        this.mRefreshRunnable = new Runnable() { // from class: androidx.lifecycle.ComputableLiveData.2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                do {
                    boolean z = false;
                    if (ComputableLiveData.this.mComputing.compareAndSet(false, true)) {
                        Object obj = null;
                        boolean z2 = false;
                        while (ComputableLiveData.this.mInvalid.compareAndSet(true, false)) {
                            try {
                                obj = ComputableLiveData.this.compute();
                                z2 = true;
                            } catch (Throwable th) {
                                ComputableLiveData.this.mComputing.set(false);
                                throw th;
                            }
                        }
                        if (z2) {
                            ComputableLiveData.this.mLiveData.postValue(obj);
                        }
                        ComputableLiveData.this.mComputing.set(false);
                        z = z2;
                    }
                    if (!z) {
                        return;
                    }
                } while (ComputableLiveData.this.mInvalid.get());
            }
        };
        this.mInvalidationRunnable = new Runnable() { // from class: androidx.lifecycle.ComputableLiveData.3
            @Override // java.lang.Runnable
            public void run() {
                boolean hasActiveObservers = ComputableLiveData.this.mLiveData.hasActiveObservers();
                if (ComputableLiveData.this.mInvalid.compareAndSet(false, true) && hasActiveObservers) {
                    ComputableLiveData.this.mExecutor.execute(ComputableLiveData.this.mRefreshRunnable);
                }
            }
        };
        this.mExecutor = executor;
        this.mLiveData = new LiveData<T>() { // from class: androidx.lifecycle.ComputableLiveData.1
            @Override // androidx.lifecycle.LiveData
            protected void onActive() {
                ComputableLiveData.this.mExecutor.execute(ComputableLiveData.this.mRefreshRunnable);
            }
        };
    }

    public LiveData<T> getLiveData() {
        return this.mLiveData;
    }

    public void invalidate() {
        ArchTaskExecutor.getInstance().executeOnMainThread(this.mInvalidationRunnable);
    }
}
