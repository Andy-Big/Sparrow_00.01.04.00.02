package org.slf4j.helpers;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.slf4j.IMarkerFactory;
import org.slf4j.Marker;
/* loaded from: classes2.dex */
public class BasicMarkerFactory implements IMarkerFactory {
    private final ConcurrentMap<String, Marker> markerMap = new ConcurrentHashMap();

    @Override // org.slf4j.IMarkerFactory
    public Marker getMarker(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Marker name cannot be null");
        }
        Marker marker = this.markerMap.get(str);
        if (marker == null) {
            BasicMarker basicMarker = new BasicMarker(str);
            Marker putIfAbsent = this.markerMap.putIfAbsent(str, basicMarker);
            return putIfAbsent != null ? putIfAbsent : basicMarker;
        }
        return marker;
    }

    @Override // org.slf4j.IMarkerFactory
    public boolean exists(String str) {
        if (str == null) {
            return false;
        }
        return this.markerMap.containsKey(str);
    }

    @Override // org.slf4j.IMarkerFactory
    public boolean detachMarker(String str) {
        return (str == null || this.markerMap.remove(str) == null) ? false : true;
    }

    @Override // org.slf4j.IMarkerFactory
    public Marker getDetachedMarker(String str) {
        return new BasicMarker(str);
    }
}
