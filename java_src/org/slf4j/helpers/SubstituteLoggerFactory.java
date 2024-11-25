package org.slf4j.helpers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.event.SubstituteLoggingEvent;
/* loaded from: classes2.dex */
public class SubstituteLoggerFactory implements ILoggerFactory {
    boolean postInitialization = false;
    final Map<String, SubstituteLogger> loggers = new HashMap();
    final LinkedBlockingQueue<SubstituteLoggingEvent> eventQueue = new LinkedBlockingQueue<>();

    @Override // org.slf4j.ILoggerFactory
    public synchronized Logger getLogger(String str) {
        SubstituteLogger substituteLogger;
        substituteLogger = this.loggers.get(str);
        if (substituteLogger == null) {
            substituteLogger = new SubstituteLogger(str, this.eventQueue, this.postInitialization);
            this.loggers.put(str, substituteLogger);
        }
        return substituteLogger;
    }

    public List<String> getLoggerNames() {
        return new ArrayList(this.loggers.keySet());
    }

    public List<SubstituteLogger> getLoggers() {
        return new ArrayList(this.loggers.values());
    }

    public LinkedBlockingQueue<SubstituteLoggingEvent> getEventQueue() {
        return this.eventQueue;
    }

    public void postInitialization() {
        this.postInitialization = true;
    }

    public void clear() {
        this.loggers.clear();
        this.eventQueue.clear();
    }
}
