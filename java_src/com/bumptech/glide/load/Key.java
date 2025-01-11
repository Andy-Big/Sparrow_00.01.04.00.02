package com.bumptech.glide.load;

import java.nio.charset.Charset;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public interface Key {
    public static final Charset CHARSET = Charset.forName("UTF-8");
    public static final String STRING_CHARSET_NAME = "UTF-8";

    boolean equals(Object obj);

    int hashCode();

    void updateDiskCacheKey(MessageDigest messageDigest);
}
