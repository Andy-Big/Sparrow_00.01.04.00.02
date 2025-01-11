package com.bumptech.glide.provider;

import com.bumptech.glide.load.ImageHeaderParser;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class ImageHeaderParserRegistry {
    private final List<ImageHeaderParser> parsers = new ArrayList();

    public synchronized List<ImageHeaderParser> getParsers() {
        return this.parsers;
    }

    public synchronized void add(ImageHeaderParser imageHeaderParser) {
        this.parsers.add(imageHeaderParser);
    }
}
