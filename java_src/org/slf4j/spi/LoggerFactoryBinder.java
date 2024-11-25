package org.slf4j.spi;

import org.slf4j.ILoggerFactory;
/* loaded from: classes2.dex */
public interface LoggerFactoryBinder {
    ILoggerFactory getLoggerFactory();

    String getLoggerFactoryClassStr();
}
