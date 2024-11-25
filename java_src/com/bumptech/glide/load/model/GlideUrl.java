package com.bumptech.glide.load.model;

import android.net.Uri;
import android.text.TextUtils;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.Preconditions;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.util.Map;
/* loaded from: classes.dex */
public class GlideUrl implements Key {
    private static final String ALLOWED_URI_CHARS = "@#&=*+-_.,:!?()/~'%;$";
    private volatile byte[] cacheKeyBytes;
    private int hashCode;
    private final Headers headers;
    private String safeStringUrl;
    private URL safeUrl;
    private final String stringUrl;
    private final URL url;

    public GlideUrl(URL url) {
        this(url, Headers.DEFAULT);
    }

    public GlideUrl(String str) {
        this(str, Headers.DEFAULT);
    }

    public GlideUrl(URL url, Headers headers) {
        this.url = (URL) Preconditions.checkNotNull(url);
        this.stringUrl = null;
        this.headers = (Headers) Preconditions.checkNotNull(headers);
    }

    public GlideUrl(String str, Headers headers) {
        this.url = null;
        this.stringUrl = Preconditions.checkNotEmpty(str);
        this.headers = (Headers) Preconditions.checkNotNull(headers);
    }

    public URL toURL() throws MalformedURLException {
        return getSafeUrl();
    }

    private URL getSafeUrl() throws MalformedURLException {
        if (this.safeUrl == null) {
            this.safeUrl = new URL(getSafeStringUrl());
        }
        return this.safeUrl;
    }

    public String toStringUrl() {
        return getSafeStringUrl();
    }

    private String getSafeStringUrl() {
        if (TextUtils.isEmpty(this.safeStringUrl)) {
            String str = this.stringUrl;
            if (TextUtils.isEmpty(str)) {
                str = ((URL) Preconditions.checkNotNull(this.url)).toString();
            }
            this.safeStringUrl = Uri.encode(str, ALLOWED_URI_CHARS);
        }
        return this.safeStringUrl;
    }

    public Map<String, String> getHeaders() {
        return this.headers.getHeaders();
    }

    public String getCacheKey() {
        String str = this.stringUrl;
        return str != null ? str : ((URL) Preconditions.checkNotNull(this.url)).toString();
    }

    public String toString() {
        return getCacheKey();
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(getCacheKeyBytes());
    }

    private byte[] getCacheKeyBytes() {
        if (this.cacheKeyBytes == null) {
            this.cacheKeyBytes = getCacheKey().getBytes(CHARSET);
        }
        return this.cacheKeyBytes;
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (obj instanceof GlideUrl) {
            GlideUrl glideUrl = (GlideUrl) obj;
            return getCacheKey().equals(glideUrl.getCacheKey()) && this.headers.equals(glideUrl.headers);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        if (this.hashCode == 0) {
            int hashCode = getCacheKey().hashCode();
            this.hashCode = hashCode;
            this.hashCode = (hashCode * 31) + this.headers.hashCode();
        }
        return this.hashCode;
    }
}
