package com.bumptech.glide.manager;

import com.bumptech.glide.util.Util;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
class ActivityFragmentLifecycle implements Lifecycle {
    private boolean isDestroyed;
    private boolean isStarted;
    private final Set<LifecycleListener> lifecycleListeners = Collections.newSetFromMap(new WeakHashMap());

    ActivityFragmentLifecycle() {
    }

    @Override // com.bumptech.glide.manager.Lifecycle
    public void addListener(LifecycleListener lifecycleListener) {
        this.lifecycleListeners.add(lifecycleListener);
        if (this.isDestroyed) {
            lifecycleListener.onDestroy();
        } else if (this.isStarted) {
            lifecycleListener.onStart();
        } else {
            lifecycleListener.onStop();
        }
    }

    @Override // com.bumptech.glide.manager.Lifecycle
    public void removeListener(LifecycleListener lifecycleListener) {
        this.lifecycleListeners.remove(lifecycleListener);
    }

    void onStart() {
        this.isStarted = true;
        for (LifecycleListener lifecycleListener : Util.getSnapshot(this.lifecycleListeners)) {
            lifecycleListener.onStart();
        }
    }

    void onStop() {
        this.isStarted = false;
        for (LifecycleListener lifecycleListener : Util.getSnapshot(this.lifecycleListeners)) {
            lifecycleListener.onStop();
        }
    }

    void onDestroy() {
        this.isDestroyed = true;
        for (LifecycleListener lifecycleListener : Util.getSnapshot(this.lifecycleListeners)) {
            lifecycleListener.onDestroy();
        }
    }
}
