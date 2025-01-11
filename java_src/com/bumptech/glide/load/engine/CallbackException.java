package com.bumptech.glide.load.engine;

/* loaded from: classes.dex */
final class CallbackException extends RuntimeException {
    private static final long serialVersionUID = -7530898992688511851L;

    CallbackException(Throwable th) {
        super("Unexpected exception thrown by non-Glide code", th);
    }
}
