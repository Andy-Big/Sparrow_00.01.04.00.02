package org.slf4j.event;

import java.util.Queue;
import org.slf4j.Logger;
import org.slf4j.Marker;
import org.slf4j.helpers.SubstituteLogger;
/* loaded from: classes2.dex */
public class EventRecodingLogger implements Logger {
    Queue<SubstituteLoggingEvent> eventQueue;
    SubstituteLogger logger;
    String name;

    @Override // org.slf4j.Logger
    public boolean isDebugEnabled() {
        return true;
    }

    @Override // org.slf4j.Logger
    public boolean isDebugEnabled(Marker marker) {
        return true;
    }

    @Override // org.slf4j.Logger
    public boolean isErrorEnabled() {
        return true;
    }

    @Override // org.slf4j.Logger
    public boolean isErrorEnabled(Marker marker) {
        return true;
    }

    @Override // org.slf4j.Logger
    public boolean isInfoEnabled() {
        return true;
    }

    @Override // org.slf4j.Logger
    public boolean isInfoEnabled(Marker marker) {
        return true;
    }

    @Override // org.slf4j.Logger
    public boolean isTraceEnabled() {
        return true;
    }

    @Override // org.slf4j.Logger
    public boolean isTraceEnabled(Marker marker) {
        return true;
    }

    @Override // org.slf4j.Logger
    public boolean isWarnEnabled() {
        return true;
    }

    @Override // org.slf4j.Logger
    public boolean isWarnEnabled(Marker marker) {
        return true;
    }

    public EventRecodingLogger(SubstituteLogger substituteLogger, Queue<SubstituteLoggingEvent> queue) {
        this.logger = substituteLogger;
        this.name = substituteLogger.getName();
        this.eventQueue = queue;
    }

    @Override // org.slf4j.Logger
    public String getName() {
        return this.name;
    }

    private void recordEvent(Level level, String str, Object[] objArr, Throwable th) {
        recordEvent(level, null, str, objArr, th);
    }

    private void recordEvent(Level level, Marker marker, String str, Object[] objArr, Throwable th) {
        SubstituteLoggingEvent substituteLoggingEvent = new SubstituteLoggingEvent();
        substituteLoggingEvent.setTimeStamp(System.currentTimeMillis());
        substituteLoggingEvent.setLevel(level);
        substituteLoggingEvent.setLogger(this.logger);
        substituteLoggingEvent.setLoggerName(this.name);
        substituteLoggingEvent.setMarker(marker);
        substituteLoggingEvent.setMessage(str);
        substituteLoggingEvent.setArgumentArray(objArr);
        substituteLoggingEvent.setThrowable(th);
        substituteLoggingEvent.setThreadName(Thread.currentThread().getName());
        this.eventQueue.add(substituteLoggingEvent);
    }

    @Override // org.slf4j.Logger
    public void trace(String str) {
        recordEvent(Level.TRACE, str, null, null);
    }

    @Override // org.slf4j.Logger
    public void trace(String str, Object obj) {
        recordEvent(Level.TRACE, str, new Object[]{obj}, null);
    }

    @Override // org.slf4j.Logger
    public void trace(String str, Object obj, Object obj2) {
        recordEvent(Level.TRACE, str, new Object[]{obj, obj2}, null);
    }

    @Override // org.slf4j.Logger
    public void trace(String str, Object... objArr) {
        recordEvent(Level.TRACE, str, objArr, null);
    }

    @Override // org.slf4j.Logger
    public void trace(String str, Throwable th) {
        recordEvent(Level.TRACE, str, null, th);
    }

    @Override // org.slf4j.Logger
    public void trace(Marker marker, String str) {
        recordEvent(Level.TRACE, marker, str, null, null);
    }

    @Override // org.slf4j.Logger
    public void trace(Marker marker, String str, Object obj) {
        recordEvent(Level.TRACE, marker, str, new Object[]{obj}, null);
    }

    @Override // org.slf4j.Logger
    public void trace(Marker marker, String str, Object obj, Object obj2) {
        recordEvent(Level.TRACE, marker, str, new Object[]{obj, obj2}, null);
    }

    @Override // org.slf4j.Logger
    public void trace(Marker marker, String str, Object... objArr) {
        recordEvent(Level.TRACE, marker, str, objArr, null);
    }

    @Override // org.slf4j.Logger
    public void trace(Marker marker, String str, Throwable th) {
        recordEvent(Level.TRACE, marker, str, null, th);
    }

    @Override // org.slf4j.Logger
    public void debug(String str) {
        recordEvent(Level.TRACE, str, null, null);
    }

    @Override // org.slf4j.Logger
    public void debug(String str, Object obj) {
        recordEvent(Level.DEBUG, str, new Object[]{obj}, null);
    }

    @Override // org.slf4j.Logger
    public void debug(String str, Object obj, Object obj2) {
        recordEvent(Level.DEBUG, str, new Object[]{obj, obj2}, null);
    }

    @Override // org.slf4j.Logger
    public void debug(String str, Object... objArr) {
        recordEvent(Level.DEBUG, str, objArr, null);
    }

    @Override // org.slf4j.Logger
    public void debug(String str, Throwable th) {
        recordEvent(Level.DEBUG, str, null, th);
    }

    @Override // org.slf4j.Logger
    public void debug(Marker marker, String str) {
        recordEvent(Level.DEBUG, marker, str, null, null);
    }

    @Override // org.slf4j.Logger
    public void debug(Marker marker, String str, Object obj) {
        recordEvent(Level.DEBUG, marker, str, new Object[]{obj}, null);
    }

    @Override // org.slf4j.Logger
    public void debug(Marker marker, String str, Object obj, Object obj2) {
        recordEvent(Level.DEBUG, marker, str, new Object[]{obj, obj2}, null);
    }

    @Override // org.slf4j.Logger
    public void debug(Marker marker, String str, Object... objArr) {
        recordEvent(Level.DEBUG, marker, str, objArr, null);
    }

    @Override // org.slf4j.Logger
    public void debug(Marker marker, String str, Throwable th) {
        recordEvent(Level.DEBUG, marker, str, null, th);
    }

    @Override // org.slf4j.Logger
    public void info(String str) {
        recordEvent(Level.INFO, str, null, null);
    }

    @Override // org.slf4j.Logger
    public void info(String str, Object obj) {
        recordEvent(Level.INFO, str, new Object[]{obj}, null);
    }

    @Override // org.slf4j.Logger
    public void info(String str, Object obj, Object obj2) {
        recordEvent(Level.INFO, str, new Object[]{obj, obj2}, null);
    }

    @Override // org.slf4j.Logger
    public void info(String str, Object... objArr) {
        recordEvent(Level.INFO, str, objArr, null);
    }

    @Override // org.slf4j.Logger
    public void info(String str, Throwable th) {
        recordEvent(Level.INFO, str, null, th);
    }

    @Override // org.slf4j.Logger
    public void info(Marker marker, String str) {
        recordEvent(Level.INFO, marker, str, null, null);
    }

    @Override // org.slf4j.Logger
    public void info(Marker marker, String str, Object obj) {
        recordEvent(Level.INFO, marker, str, new Object[]{obj}, null);
    }

    @Override // org.slf4j.Logger
    public void info(Marker marker, String str, Object obj, Object obj2) {
        recordEvent(Level.INFO, marker, str, new Object[]{obj, obj2}, null);
    }

    @Override // org.slf4j.Logger
    public void info(Marker marker, String str, Object... objArr) {
        recordEvent(Level.INFO, marker, str, objArr, null);
    }

    @Override // org.slf4j.Logger
    public void info(Marker marker, String str, Throwable th) {
        recordEvent(Level.INFO, marker, str, null, th);
    }

    @Override // org.slf4j.Logger
    public void warn(String str) {
        recordEvent(Level.WARN, str, null, null);
    }

    @Override // org.slf4j.Logger
    public void warn(String str, Object obj) {
        recordEvent(Level.WARN, str, new Object[]{obj}, null);
    }

    @Override // org.slf4j.Logger
    public void warn(String str, Object obj, Object obj2) {
        recordEvent(Level.WARN, str, new Object[]{obj, obj2}, null);
    }

    @Override // org.slf4j.Logger
    public void warn(String str, Object... objArr) {
        recordEvent(Level.WARN, str, objArr, null);
    }

    @Override // org.slf4j.Logger
    public void warn(String str, Throwable th) {
        recordEvent(Level.WARN, str, null, th);
    }

    @Override // org.slf4j.Logger
    public void warn(Marker marker, String str) {
        recordEvent(Level.WARN, str, null, null);
    }

    @Override // org.slf4j.Logger
    public void warn(Marker marker, String str, Object obj) {
        recordEvent(Level.WARN, str, new Object[]{obj}, null);
    }

    @Override // org.slf4j.Logger
    public void warn(Marker marker, String str, Object obj, Object obj2) {
        recordEvent(Level.WARN, marker, str, new Object[]{obj, obj2}, null);
    }

    @Override // org.slf4j.Logger
    public void warn(Marker marker, String str, Object... objArr) {
        recordEvent(Level.WARN, marker, str, objArr, null);
    }

    @Override // org.slf4j.Logger
    public void warn(Marker marker, String str, Throwable th) {
        recordEvent(Level.WARN, marker, str, null, th);
    }

    @Override // org.slf4j.Logger
    public void error(String str) {
        recordEvent(Level.ERROR, str, null, null);
    }

    @Override // org.slf4j.Logger
    public void error(String str, Object obj) {
        recordEvent(Level.ERROR, str, new Object[]{obj}, null);
    }

    @Override // org.slf4j.Logger
    public void error(String str, Object obj, Object obj2) {
        recordEvent(Level.ERROR, str, new Object[]{obj, obj2}, null);
    }

    @Override // org.slf4j.Logger
    public void error(String str, Object... objArr) {
        recordEvent(Level.ERROR, str, objArr, null);
    }

    @Override // org.slf4j.Logger
    public void error(String str, Throwable th) {
        recordEvent(Level.ERROR, str, null, th);
    }

    @Override // org.slf4j.Logger
    public void error(Marker marker, String str) {
        recordEvent(Level.ERROR, marker, str, null, null);
    }

    @Override // org.slf4j.Logger
    public void error(Marker marker, String str, Object obj) {
        recordEvent(Level.ERROR, marker, str, new Object[]{obj}, null);
    }

    @Override // org.slf4j.Logger
    public void error(Marker marker, String str, Object obj, Object obj2) {
        recordEvent(Level.ERROR, marker, str, new Object[]{obj, obj2}, null);
    }

    @Override // org.slf4j.Logger
    public void error(Marker marker, String str, Object... objArr) {
        recordEvent(Level.ERROR, marker, str, objArr, null);
    }

    @Override // org.slf4j.Logger
    public void error(Marker marker, String str, Throwable th) {
        recordEvent(Level.ERROR, marker, str, null, th);
    }
}
