package org.slf4j;
/* loaded from: classes2.dex */
public interface IMarkerFactory {
    boolean detachMarker(String str);

    boolean exists(String str);

    Marker getDetachedMarker(String str);

    Marker getMarker(String str);
}
