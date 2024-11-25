package com.rigol.scope.utilities;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;
/* loaded from: classes2.dex */
public class WeakRefHandler extends Handler {
    private final WeakReference<Handler.Callback> weakReference;

    public WeakRefHandler(Handler.Callback callback) {
        super(callback);
        this.weakReference = new WeakReference<>(callback);
    }

    public WeakRefHandler(Looper looper, Handler.Callback callback) {
        super(looper, callback);
        this.weakReference = new WeakReference<>(callback);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        WeakReference<Handler.Callback> weakReference = this.weakReference;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.weakReference.get().handleMessage(message);
    }
}
