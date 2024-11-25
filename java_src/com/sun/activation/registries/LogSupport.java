package com.sun.activation.registries;

import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;
/* loaded from: classes2.dex */
public class LogSupport {
    private static boolean debug = false;
    private static final Level level = Level.FINE;
    private static Logger logger;

    static {
        try {
            debug = Boolean.getBoolean("javax.activation.debug");
        } catch (Throwable unused) {
        }
        logger = Logger.getLogger("javax.activation");
    }

    private LogSupport() {
    }

    public static void log(String str) {
        if (debug) {
            System.out.println(str);
        }
        logger.log(level, str);
    }

    public static void log(String str, Throwable th) {
        if (debug) {
            PrintStream printStream = System.out;
            printStream.println(str + "; Exception: " + th);
        }
        logger.log(level, str, th);
    }

    public static boolean isLoggable() {
        return debug || logger.isLoggable(level);
    }
}
