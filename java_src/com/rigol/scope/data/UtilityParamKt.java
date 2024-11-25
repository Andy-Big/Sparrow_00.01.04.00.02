package com.rigol.scope.data;

import com.blankj.utilcode.util.TimeUtils;
import com.rigol.scope.cil.API;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: UtilityParam.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\u001a\u0006\u0010\u0016\u001a\u00020\u0017\u001a\u000e\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u001a\u001a\u000e\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u001a\u001a\u0006\u0010\u001c\u001a\u00020\u0017\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u0011\u0010\r\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u000e\u0010\u0010\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0014\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0015\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"DATE_PATTERN", "", "DEFAULT_AUX_OUT", "", "DEFAULT_BEEPER", "DEFAULT_EXPAND", "DEFAULT_LOCK_KEYBOARD", "DEFAULT_POWER_ON_SET", "DEFAULT_POWER_STATUS", "DEFAULT_PROJECT_MODE", "DEFAULT_QUICKOPER", "", "DEFAULT_SCREEN_PICTURE", "DEFAULT_SCREEN_SELECT", "getDEFAULT_SCREEN_SELECT", "()I", "DEFAULT_SCREEN_TIME", "DEFAULT_SCREEN_WORD", "DEFAULT_SHOW_TIME", "DEFAULT_VIBRATION", "DEFAULT_ZBD_LED", "TIME_PATTERN", "applyTime", "", "millis2Date", "millis", "", "millis2Time", "saveTone", "app_release"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class UtilityParamKt {
    public static final String DATE_PATTERN = "yyyy/MM/dd";
    private static final boolean DEFAULT_AUX_OUT = false;
    private static final boolean DEFAULT_BEEPER = false;
    private static final boolean DEFAULT_EXPAND = false;
    private static final boolean DEFAULT_LOCK_KEYBOARD = false;
    private static final boolean DEFAULT_POWER_ON_SET = false;
    private static final boolean DEFAULT_POWER_STATUS = false;
    private static final boolean DEFAULT_PROJECT_MODE = false;
    private static final int DEFAULT_QUICKOPER = 0;
    public static final String DEFAULT_SCREEN_PICTURE = "";
    private static final int DEFAULT_SCREEN_SELECT = ServiceEnum.UtilityScreenSaver.SCR_OFF.value1;
    public static final String DEFAULT_SCREEN_TIME = "30";
    public static final String DEFAULT_SCREEN_WORD = "Rigol Scope";
    private static final boolean DEFAULT_SHOW_TIME = false;
    private static final boolean DEFAULT_VIBRATION = true;
    private static final boolean DEFAULT_ZBD_LED = false;
    public static final String TIME_PATTERN = "HH:mm:ss";

    public static final int getDEFAULT_SCREEN_SELECT() {
        return DEFAULT_SCREEN_SELECT;
    }

    public static final void saveTone() {
        API.getInstance().UI_PostInt32(11, MessageID.MSG_APP_UTILITY_TONE, 0);
    }

    public static final void applyTime() {
        API.getInstance().UI_PostInt32(11, MessageID.MSG_APP_UTILITY_APPLY_TIME, 0);
    }

    public static final String millis2Time(long j) {
        String millis2String = TimeUtils.millis2String(j, TIME_PATTERN);
        Intrinsics.checkNotNullExpressionValue(millis2String, "TimeUtils.millis2String(millis, TIME_PATTERN)");
        return millis2String;
    }

    public static final String millis2Date(long j) {
        String millis2String = TimeUtils.millis2String(j, DATE_PATTERN);
        Intrinsics.checkNotNullExpressionValue(millis2String, "TimeUtils.millis2String(millis, DATE_PATTERN)");
        return millis2String;
    }
}
