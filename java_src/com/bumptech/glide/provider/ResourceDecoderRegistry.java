package com.bumptech.glide.provider;

import com.bumptech.glide.load.ResourceDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class ResourceDecoderRegistry {
    private final List<String> bucketPriorityList = new ArrayList();
    private final Map<String, List<Entry<?, ?>>> decoders = new HashMap();

    public synchronized void setBucketPriorityList(List<String> list) {
        ArrayList<String> arrayList = new ArrayList(this.bucketPriorityList);
        this.bucketPriorityList.clear();
        for (String str : list) {
            this.bucketPriorityList.add(str);
        }
        for (String str2 : arrayList) {
            if (!list.contains(str2)) {
                this.bucketPriorityList.add(str2);
            }
        }
    }

    public synchronized <T, R> List<ResourceDecoder<T, R>> getDecoders(Class<T> cls, Class<R> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (String str : this.bucketPriorityList) {
            List<Entry<?, ?>> list = this.decoders.get(str);
            if (list != null) {
                for (Entry<?, ?> entry : list) {
                    if (entry.handles(cls, cls2)) {
                        arrayList.add(entry.decoder);
                    }
                }
            }
        }
        return arrayList;
    }

    public synchronized <T, R> List<Class<R>> getResourceClasses(Class<T> cls, Class<R> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (String str : this.bucketPriorityList) {
            List<Entry<?, ?>> list = this.decoders.get(str);
            if (list != null) {
                for (Entry<?, ?> entry : list) {
                    if (entry.handles(cls, cls2) && !arrayList.contains(entry.resourceClass)) {
                        arrayList.add(entry.resourceClass);
                    }
                }
            }
        }
        return arrayList;
    }

    public synchronized <T, R> void append(String str, ResourceDecoder<T, R> resourceDecoder, Class<T> cls, Class<R> cls2) {
        getOrAddEntryList(str).add(new Entry<>(cls, cls2, resourceDecoder));
    }

    public synchronized <T, R> void prepend(String str, ResourceDecoder<T, R> resourceDecoder, Class<T> cls, Class<R> cls2) {
        getOrAddEntryList(str).add(0, new Entry<>(cls, cls2, resourceDecoder));
    }

    private synchronized List<Entry<?, ?>> getOrAddEntryList(String str) {
        List<Entry<?, ?>> list;
        if (!this.bucketPriorityList.contains(str)) {
            this.bucketPriorityList.add(str);
        }
        list = this.decoders.get(str);
        if (list == null) {
            list = new ArrayList<>();
            this.decoders.put(str, list);
        }
        return list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class Entry<T, R> {
        private final Class<T> dataClass;
        final ResourceDecoder<T, R> decoder;
        final Class<R> resourceClass;

        public Entry(Class<T> cls, Class<R> cls2, ResourceDecoder<T, R> resourceDecoder) {
            this.dataClass = cls;
            this.resourceClass = cls2;
            this.decoder = resourceDecoder;
        }

        public boolean handles(Class<?> cls, Class<?> cls2) {
            return this.dataClass.isAssignableFrom(cls) && cls2.isAssignableFrom(this.resourceClass);
        }
    }
}
