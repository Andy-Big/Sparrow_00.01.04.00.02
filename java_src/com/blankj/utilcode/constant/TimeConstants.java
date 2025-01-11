package com.blankj.utilcode.constant;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes.dex */
public final class TimeConstants {
    public static final int DAY = 86400000;
    public static final int HOUR = 3600000;
    public static final int MIN = 60000;
    public static final int MSEC = 1;
    public static final int SEC = 1000;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface Unit {
    }
}
