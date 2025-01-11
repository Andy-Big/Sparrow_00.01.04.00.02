package androidx.lifecycle;

/* loaded from: classes.dex */
public interface DefaultLifecycleObserver extends FullLifecycleObserver {
    @Override // androidx.lifecycle.FullLifecycleObserver
    default void onCreate(LifecycleOwner lifecycleOwner) {
    }

    @Override // androidx.lifecycle.FullLifecycleObserver
    default void onDestroy(LifecycleOwner lifecycleOwner) {
    }

    @Override // androidx.lifecycle.FullLifecycleObserver
    default void onPause(LifecycleOwner lifecycleOwner) {
    }

    @Override // androidx.lifecycle.FullLifecycleObserver
    default void onResume(LifecycleOwner lifecycleOwner) {
    }

    @Override // androidx.lifecycle.FullLifecycleObserver
    default void onStart(LifecycleOwner lifecycleOwner) {
    }

    @Override // androidx.lifecycle.FullLifecycleObserver
    default void onStop(LifecycleOwner lifecycleOwner) {
    }
}
