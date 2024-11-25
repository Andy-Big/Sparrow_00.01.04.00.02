package androidx.savedstate;

import android.os.Bundle;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.lifecycle.GenericLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.savedstate.Recreator;
import java.util.Map;
/* loaded from: classes.dex */
public final class SavedStateRegistry {
    private static final String SAVED_COMPONENTS_KEY = "androidx.lifecycle.BundlableSavedStateRegistry.key";
    private Recreator.SavedStateProvider mRecreatorProvider;
    private boolean mRestored;
    private Bundle mRestoredState;
    private SafeIterableMap<String, SavedStateProvider> mComponents = new SafeIterableMap<>();
    boolean mAllowingSavingState = true;

    /* loaded from: classes.dex */
    public interface AutoRecreated {
        void onRecreated(SavedStateRegistryOwner savedStateRegistryOwner);
    }

    /* loaded from: classes.dex */
    public interface SavedStateProvider {
        Bundle saveState();
    }

    public Bundle consumeRestoredStateForKey(String str) {
        if (!this.mRestored) {
            throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component");
        }
        Bundle bundle = this.mRestoredState;
        if (bundle != null) {
            Bundle bundle2 = bundle.getBundle(str);
            this.mRestoredState.remove(str);
            if (this.mRestoredState.isEmpty()) {
                this.mRestoredState = null;
            }
            return bundle2;
        }
        return null;
    }

    public void registerSavedStateProvider(String str, SavedStateProvider savedStateProvider) {
        if (this.mComponents.putIfAbsent(str, savedStateProvider) != null) {
            throw new IllegalArgumentException("SavedStateProvider with the given key is already registered");
        }
    }

    public void unregisterSavedStateProvider(String str) {
        this.mComponents.remove(str);
    }

    public boolean isRestored() {
        return this.mRestored;
    }

    public void runOnNextRecreation(Class<? extends AutoRecreated> cls) {
        if (!this.mAllowingSavingState) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
        if (this.mRecreatorProvider == null) {
            this.mRecreatorProvider = new Recreator.SavedStateProvider(this);
        }
        try {
            cls.getDeclaredConstructor(new Class[0]);
            this.mRecreatorProvider.add(cls.getName());
        } catch (NoSuchMethodException e) {
            throw new IllegalArgumentException("Class" + cls.getSimpleName() + " must have default constructor in order to be automatically recreated", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void performRestore(Lifecycle lifecycle, Bundle bundle) {
        if (this.mRestored) {
            throw new IllegalStateException("SavedStateRegistry was already restored.");
        }
        if (bundle != null) {
            this.mRestoredState = bundle.getBundle(SAVED_COMPONENTS_KEY);
        }
        lifecycle.addObserver(new GenericLifecycleObserver() { // from class: androidx.savedstate.SavedStateRegistry.1
            @Override // androidx.lifecycle.LifecycleEventObserver
            public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                if (event == Lifecycle.Event.ON_START) {
                    SavedStateRegistry.this.mAllowingSavingState = true;
                } else if (event == Lifecycle.Event.ON_STOP) {
                    SavedStateRegistry.this.mAllowingSavingState = false;
                }
            }
        });
        this.mRestored = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void performSave(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = this.mRestoredState;
        if (bundle3 != null) {
            bundle2.putAll(bundle3);
        }
        SafeIterableMap<String, SavedStateProvider>.IteratorWithAdditions iteratorWithAdditions = this.mComponents.iteratorWithAdditions();
        while (iteratorWithAdditions.hasNext()) {
            Map.Entry next = iteratorWithAdditions.next();
            bundle2.putBundle((String) next.getKey(), ((SavedStateProvider) next.getValue()).saveState());
        }
        bundle.putBundle(SAVED_COMPONENTS_KEY, bundle2);
    }
}
