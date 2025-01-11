package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.transition.Transition;

/* loaded from: classes.dex */
public final class PreloadTarget<Z> extends CustomTarget<Z> {
    private static final Handler HANDLER = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.bumptech.glide.request.target.PreloadTarget.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 1) {
                ((PreloadTarget) message.obj).clear();
                return true;
            }
            return false;
        }
    });
    private static final int MESSAGE_CLEAR = 1;
    private final RequestManager requestManager;

    @Override // com.bumptech.glide.request.target.Target
    public void onLoadCleared(Drawable drawable) {
    }

    public static <Z> PreloadTarget<Z> obtain(RequestManager requestManager, int i, int i2) {
        return new PreloadTarget<>(requestManager, i, i2);
    }

    private PreloadTarget(RequestManager requestManager, int i, int i2) {
        super(i, i2);
        this.requestManager = requestManager;
    }

    @Override // com.bumptech.glide.request.target.Target
    public void onResourceReady(Z z, Transition<? super Z> transition) {
        HANDLER.obtainMessage(1, this).sendToTarget();
    }

    void clear() {
        this.requestManager.clear(this);
    }
}
