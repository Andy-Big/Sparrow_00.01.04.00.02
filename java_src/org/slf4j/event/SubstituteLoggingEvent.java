package org.slf4j.event;

import org.slf4j.Marker;
import org.slf4j.helpers.SubstituteLogger;
/* loaded from: classes2.dex */
public class SubstituteLoggingEvent implements LoggingEvent {
    Object[] argArray;
    Level level;
    SubstituteLogger logger;
    String loggerName;
    Marker marker;
    String message;
    String threadName;
    Throwable throwable;
    long timeStamp;

    @Override // org.slf4j.event.LoggingEvent
    public Level getLevel() {
        return this.level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    @Override // org.slf4j.event.LoggingEvent
    public Marker getMarker() {
        return this.marker;
    }

    public void setMarker(Marker marker) {
        this.marker = marker;
    }

    @Override // org.slf4j.event.LoggingEvent
    public String getLoggerName() {
        return this.loggerName;
    }

    public void setLoggerName(String str) {
        this.loggerName = str;
    }

    public SubstituteLogger getLogger() {
        return this.logger;
    }

    public void setLogger(SubstituteLogger substituteLogger) {
        this.logger = substituteLogger;
    }

    @Override // org.slf4j.event.LoggingEvent
    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    @Override // org.slf4j.event.LoggingEvent
    public Object[] getArgumentArray() {
        return this.argArray;
    }

    public void setArgumentArray(Object[] objArr) {
        this.argArray = objArr;
    }

    @Override // org.slf4j.event.LoggingEvent
    public long getTimeStamp() {
        return this.timeStamp;
    }

    public void setTimeStamp(long j) {
        this.timeStamp = j;
    }

    @Override // org.slf4j.event.LoggingEvent
    public String getThreadName() {
        return this.threadName;
    }

    public void setThreadName(String str) {
        this.threadName = str;
    }

    @Override // org.slf4j.event.LoggingEvent
    public Throwable getThrowable() {
        return this.throwable;
    }

    public void setThrowable(Throwable th) {
        this.throwable = th;
    }
}
