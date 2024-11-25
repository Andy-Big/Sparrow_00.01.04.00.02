package org.slf4j.spi;

import org.slf4j.Logger;
import org.slf4j.Marker;
/* loaded from: classes2.dex */
public interface LocationAwareLogger extends Logger {
    public static final int DEBUG_INT = 10;
    public static final int ERROR_INT = 40;
    public static final int INFO_INT = 20;
    public static final int TRACE_INT = 0;
    public static final int WARN_INT = 30;

    void log(Marker marker, String str, int i, String str2, Object[] objArr, Throwable th);
}
