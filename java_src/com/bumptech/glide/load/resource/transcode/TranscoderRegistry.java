package com.bumptech.glide.load.resource.transcode;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class TranscoderRegistry {
    private final List<Entry<?, ?>> transcoders = new ArrayList();

    public synchronized <Z, R> void register(Class<Z> cls, Class<R> cls2, ResourceTranscoder<Z, R> resourceTranscoder) {
        this.transcoders.add(new Entry<>(cls, cls2, resourceTranscoder));
    }

    public synchronized <Z, R> ResourceTranscoder<Z, R> get(Class<Z> cls, Class<R> cls2) {
        if (cls2.isAssignableFrom(cls)) {
            return UnitTranscoder.get();
        }
        for (Entry<?, ?> entry : this.transcoders) {
            if (entry.handles(cls, cls2)) {
                return (ResourceTranscoder<Z, R>) entry.transcoder;
            }
        }
        throw new IllegalArgumentException("No transcoder registered to transcode from " + cls + " to " + cls2);
    }

    public synchronized <Z, R> List<Class<R>> getTranscodeClasses(Class<Z> cls, Class<R> cls2) {
        ArrayList arrayList = new ArrayList();
        if (cls2.isAssignableFrom(cls)) {
            arrayList.add(cls2);
            return arrayList;
        }
        for (Entry<?, ?> entry : this.transcoders) {
            if (entry.handles(cls, cls2)) {
                arrayList.add(cls2);
            }
        }
        return arrayList;
    }

    /* loaded from: classes.dex */
    private static final class Entry<Z, R> {
        private final Class<Z> fromClass;
        private final Class<R> toClass;
        final ResourceTranscoder<Z, R> transcoder;

        Entry(Class<Z> cls, Class<R> cls2, ResourceTranscoder<Z, R> resourceTranscoder) {
            this.fromClass = cls;
            this.toClass = cls2;
            this.transcoder = resourceTranscoder;
        }

        public boolean handles(Class<?> cls, Class<?> cls2) {
            return this.fromClass.isAssignableFrom(cls) && cls2.isAssignableFrom(this.toClass);
        }
    }
}
