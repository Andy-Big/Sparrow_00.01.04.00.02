package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class CompositeGeneratedAdaptersObserver implements LifecycleEventObserver {
    private final GeneratedAdapter[] mGeneratedAdapters;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CompositeGeneratedAdaptersObserver(GeneratedAdapter[] generatedAdapterArr) {
        this.mGeneratedAdapters = generatedAdapterArr;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        MethodCallsLogger methodCallsLogger = new MethodCallsLogger();
        for (GeneratedAdapter generatedAdapter : this.mGeneratedAdapters) {
            generatedAdapter.callMethods(lifecycleOwner, event, false, methodCallsLogger);
        }
        for (GeneratedAdapter generatedAdapter2 : this.mGeneratedAdapters) {
            generatedAdapter2.callMethods(lifecycleOwner, event, true, methodCallsLogger);
        }
    }
}
