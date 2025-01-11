package com.sun.mail.util.logging;

import java.util.logging.Filter;
import java.util.logging.LogRecord;

/* loaded from: classes2.dex */
public class DurationFilter implements Filter {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private long count;
    private final long duration;
    private long peak;
    private final long records;
    private long start;

    private static long checkDuration(long j) {
        if (j > 0) {
            return j;
        }
        return 900000L;
    }

    private static long checkRecords(long j) {
        if (j > 0) {
            return j;
        }
        return 1000L;
    }

    public DurationFilter() {
        this.records = checkRecords(initLong(".records"));
        this.duration = checkDuration(initLong(".duration"));
    }

    public DurationFilter(long j, long j2) {
        this.records = checkRecords(j);
        this.duration = checkDuration(j2);
    }

    public boolean equals(Object obj) {
        long j;
        long j2;
        long j3;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        DurationFilter durationFilter = (DurationFilter) obj;
        if (this.records == durationFilter.records && this.duration == durationFilter.duration) {
            synchronized (this) {
                j = this.count;
                j2 = this.peak;
                j3 = this.start;
            }
            synchronized (durationFilter) {
                if (j == durationFilter.count && j2 == durationFilter.peak && j3 == durationFilter.start) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    public boolean isIdle() {
        return test(0L, System.currentTimeMillis());
    }

    public int hashCode() {
        long j = this.records;
        long j2 = this.duration;
        return ((267 + ((int) (j ^ (j >>> 32)))) * 89) + ((int) (j2 ^ (j2 >>> 32)));
    }

    @Override // java.util.logging.Filter
    public boolean isLoggable(LogRecord logRecord) {
        return accept(logRecord.getMillis());
    }

    public boolean isLoggable() {
        return test(this.records, System.currentTimeMillis());
    }

    public String toString() {
        boolean test;
        boolean test2;
        synchronized (this) {
            long currentTimeMillis = System.currentTimeMillis();
            test = test(0L, currentTimeMillis);
            test2 = test(this.records, currentTimeMillis);
        }
        return getClass().getName() + "{records=" + this.records + ", duration=" + this.duration + ", idle=" + test + ", loggable=" + test2 + '}';
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: clone */
    public DurationFilter m18clone() throws CloneNotSupportedException {
        DurationFilter durationFilter = (DurationFilter) super.clone();
        durationFilter.count = 0L;
        durationFilter.peak = 0L;
        durationFilter.start = 0L;
        return durationFilter;
    }

    private boolean test(long j, long j2) {
        long j3;
        long j4;
        synchronized (this) {
            j3 = this.count;
            j4 = this.start;
        }
        int i = (j3 > 0L ? 1 : (j3 == 0L ? 0 : -1));
        return i > 0 ? j2 - j4 >= this.duration || j3 < j : j2 - j4 >= 0 || i == 0;
    }

    private synchronized boolean accept(long j) {
        boolean z;
        z = false;
        if (this.count > 0) {
            if (j - this.peak > 0) {
                this.peak = j;
            }
            if (this.count != this.records) {
                this.count++;
            } else if (this.peak - this.start >= this.duration) {
                this.count = 1L;
                this.start = this.peak;
            } else {
                this.count = -1L;
                this.start = this.peak + this.duration;
            }
            z = true;
        } else if (j - this.start >= 0 || this.count == 0) {
            this.count = 1L;
            this.start = j;
            this.peak = j;
            z = true;
        }
        return z;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private long initLong(String str) {
        long parseDurationToMillis;
        String[] strArr;
        String fromLogManager = LogManagerProperties.fromLogManager(getClass().getName().concat(str));
        if (fromLogManager == null || fromLogManager.length() == 0) {
            return Long.MIN_VALUE;
        }
        String trim = fromLogManager.trim();
        if (isTimeEntry(str, trim)) {
            try {
                parseDurationToMillis = LogManagerProperties.parseDurationToMillis(trim);
            } catch (RuntimeException | Exception | LinkageError unused) {
            }
            if (parseDurationToMillis != 0) {
                long j = 1;
                try {
                    for (String str2 : tokenizeLongs(trim)) {
                        if (str2.endsWith("L") || str2.endsWith("l")) {
                            str2 = str2.substring(0, str2.length() - 1);
                        }
                        j = multiplyExact(j, Long.parseLong(str2));
                    }
                    return j;
                } catch (RuntimeException unused2) {
                    return Long.MIN_VALUE;
                }
            }
            return parseDurationToMillis;
        }
        parseDurationToMillis = 0;
        if (parseDurationToMillis != 0) {
        }
    }

    private boolean isTimeEntry(String str, String str2) {
        return (str2.charAt(0) == 'P' || str2.charAt(0) == 'p') && str.equals(".duration");
    }

    private static String[] tokenizeLongs(String str) {
        int indexOf = str.indexOf(42);
        if (indexOf > -1) {
            String[] split = str.split("\\s*\\*\\s*");
            if (split.length != 0) {
                if (indexOf == 0 || str.charAt(str.length() - 1) == '*') {
                    throw new NumberFormatException(str);
                }
                if (split.length != 1) {
                    return split;
                }
                throw new NumberFormatException(split[0]);
            }
        }
        return new String[]{str};
    }

    private static long multiplyExact(long j, long j2) {
        long j3 = j * j2;
        if (((Math.abs(j) | Math.abs(j2)) >>> 31) == 0 || ((j2 == 0 || j3 / j2 == j) && !(j == Long.MIN_VALUE && j2 == -1))) {
            return j3;
        }
        throw new ArithmeticException();
    }
}
