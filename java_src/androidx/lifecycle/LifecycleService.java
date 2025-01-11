package androidx.lifecycle;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/* loaded from: classes.dex */
public class LifecycleService extends Service implements LifecycleOwner {
    private final ServiceLifecycleDispatcher mDispatcher = new ServiceLifecycleDispatcher(this);

    @Override // android.app.Service
    public void onCreate() {
        this.mDispatcher.onServicePreSuperOnCreate();
        super.onCreate();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        this.mDispatcher.onServicePreSuperOnBind();
        return null;
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        this.mDispatcher.onServicePreSuperOnStart();
        super.onStart(intent, i);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        return super.onStartCommand(intent, i, i2);
    }

    @Override // android.app.Service
    public void onDestroy() {
        this.mDispatcher.onServicePreSuperOnDestroy();
        super.onDestroy();
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public Lifecycle getLifecycle() {
        return this.mDispatcher.getLifecycle();
    }
}
