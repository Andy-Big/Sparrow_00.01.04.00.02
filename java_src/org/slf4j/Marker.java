package org.slf4j;

import java.io.Serializable;
import java.util.Iterator;
/* loaded from: classes2.dex */
public interface Marker extends Serializable {
    public static final String ANY_MARKER = "*";
    public static final String ANY_NON_NULL_MARKER = "+";

    void add(Marker marker);

    boolean contains(String str);

    boolean contains(Marker marker);

    boolean equals(Object obj);

    String getName();

    boolean hasChildren();

    boolean hasReferences();

    int hashCode();

    Iterator<Marker> iterator();

    boolean remove(Marker marker);
}
