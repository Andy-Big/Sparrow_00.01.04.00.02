package com.bumptech.glide.signature;

import com.bumptech.glide.load.Key;
import java.security.MessageDigest;
/* loaded from: classes.dex */
public final class EmptySignature implements Key {
    private static final EmptySignature EMPTY_KEY = new EmptySignature();

    public String toString() {
        return "EmptySignature";
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest messageDigest) {
    }

    public static EmptySignature obtain() {
        return EMPTY_KEY;
    }

    private EmptySignature() {
    }
}
