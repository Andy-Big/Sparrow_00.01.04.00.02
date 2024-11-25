package com.blankj.utilcode.util;

import android.util.Pair;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes.dex */
public class MapUtils {

    /* loaded from: classes.dex */
    public interface Closure<K, V> {
        void execute(K k, V v);
    }

    /* loaded from: classes.dex */
    public interface Transformer<K1, V1, K2, V2> {
        Pair<K2, V2> transform(K1 k1, V1 v1);
    }

    private MapUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    @SafeVarargs
    public static <K, V> Map<K, V> newUnmodifiableMap(Pair<K, V>... pairArr) {
        return Collections.unmodifiableMap(newHashMap(pairArr));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SafeVarargs
    public static <K, V> HashMap<K, V> newHashMap(Pair<K, V>... pairArr) {
        HashMap<K, V> hashMap = (HashMap<K, V>) new HashMap();
        if (pairArr != null && pairArr.length != 0) {
            for (Pair<K, V> pair : pairArr) {
                if (pair != null) {
                    hashMap.put(pair.first, pair.second);
                }
            }
        }
        return hashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SafeVarargs
    public static <K, V> LinkedHashMap<K, V> newLinkedHashMap(Pair<K, V>... pairArr) {
        LinkedHashMap<K, V> linkedHashMap = (LinkedHashMap<K, V>) new LinkedHashMap();
        if (pairArr != null && pairArr.length != 0) {
            for (Pair<K, V> pair : pairArr) {
                if (pair != null) {
                    linkedHashMap.put(pair.first, pair.second);
                }
            }
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SafeVarargs
    public static <K, V> TreeMap<K, V> newTreeMap(Comparator<K> comparator, Pair<K, V>... pairArr) {
        if (comparator == null) {
            throw new IllegalArgumentException("comparator must not be null");
        }
        TreeMap<K, V> treeMap = (TreeMap<K, V>) new TreeMap(comparator);
        if (pairArr != null && pairArr.length != 0) {
            for (Pair<K, V> pair : pairArr) {
                if (pair != null) {
                    treeMap.put(pair.first, pair.second);
                }
            }
        }
        return treeMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SafeVarargs
    public static <K, V> Hashtable<K, V> newHashTable(Pair<K, V>... pairArr) {
        Hashtable<K, V> hashtable = (Hashtable<K, V>) new Hashtable();
        if (pairArr != null && pairArr.length != 0) {
            for (Pair<K, V> pair : pairArr) {
                if (pair != null) {
                    hashtable.put(pair.first, pair.second);
                }
            }
        }
        return hashtable;
    }

    public static boolean isEmpty(Map map) {
        return map == null || map.size() == 0;
    }

    public static boolean isNotEmpty(Map map) {
        return !isEmpty(map);
    }

    public static int size(Map map) {
        if (map == null) {
            return 0;
        }
        return map.size();
    }

    public static <K, V> void forAllDo(Map<K, V> map, Closure<K, V> closure) {
        if (map == null || closure == null) {
            return;
        }
        for (Map.Entry<K, V> entry : map.entrySet()) {
            closure.execute(entry.getKey(), entry.getValue());
        }
    }

    public static <K1, V1, K2, V2> Map<K2, V2> transform(Map<K1, V1> map, final Transformer<K1, V1, K2, V2> transformer) {
        if (map != null && transformer != null) {
            try {
                final Map<K2, V2> map2 = (Map) map.getClass().newInstance();
                forAllDo(map, new Closure<K1, V1>() { // from class: com.blankj.utilcode.util.MapUtils.1
                    @Override // com.blankj.utilcode.util.MapUtils.Closure
                    public void execute(K1 k1, V1 v1) {
                        Pair transform = Transformer.this.transform(k1, v1);
                        map2.put(transform.first, transform.second);
                    }
                });
                return map2;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    public static String toString(Map map) {
        return map == null ? "null" : map.toString();
    }
}
