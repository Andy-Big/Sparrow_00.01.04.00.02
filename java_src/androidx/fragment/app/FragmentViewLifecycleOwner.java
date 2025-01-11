package androidx.fragment.app;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;

/* loaded from: classes.dex */
class FragmentViewLifecycleOwner implements LifecycleOwner {
    private LifecycleRegistry mLifecycleRegistry = null;

    FragmentViewLifecycleOwner() {
    }

    void initialize() {
        if (this.mLifecycleRegistry == null) {
            this.mLifecycleRegistry = new LifecycleRegistry(this);
        }
    }

    boolean isInitialized() {
        return this.mLifecycleRegistry != null;
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public Lifecycle getLifecycle() {
        initialize();
        return this.mLifecycleRegistry;
    }

    void handleLifecycleEvent(Lifecycle.Event event) {
        this.mLifecycleRegistry.handleLifecycleEvent(event);
    }
}
