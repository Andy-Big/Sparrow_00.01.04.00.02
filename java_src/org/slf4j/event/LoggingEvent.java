package org.slf4j.event;

import org.slf4j.Marker;
/* loaded from: classes2.dex */
public interface LoggingEvent {
    Object[] getArgumentArray();

    Level getLevel();

    String getLoggerName();

    Marker getMarker();

    String getMessage();

    String getThreadName();

    Throwable getThrowable();

    long getTimeStamp();
}
