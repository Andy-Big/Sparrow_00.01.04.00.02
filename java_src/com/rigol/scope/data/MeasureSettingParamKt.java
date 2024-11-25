package com.rigol.scope.data;

import com.rigol.scope.cil.ServiceEnum;
import kotlin.Metadata;
/* compiled from: MeasureSettingParam.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0014\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0015\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0016\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0017\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u001a\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"DEFAULT_ALLITEMSOURCE", "Lcom/rigol/scope/cil/ServiceEnum$Chan;", "DEFAULT_BASEMETHOD", "", "DEFAULT_CURSORA", "", "DEFAULT_CURSORB", "DEFAULT_CURSORBOTHAB", "DEFAULT_CURSOR_INDICATOR", "", "DEFAULT_HISTO_ENABLE", "DEFAULT_METHODSTATE", "DEFAULT_MODE", "DEFAULT_REGION", "DEFAULT_SELECT_SOURCE_A", "DEFAULT_SELECT_SOURCE_B", "DEFAULT_SHOW", "DEFAULT_SHOW_SELECT_SOURCE_B", "DEFAULT_STATCOUNT", "DEFAULT_STATISTIC_State", "DEFAULT_THRESHOLDHIGH", "DEFAULT_THRESHOLDLOW", "DEFAULT_THRESHOLDMIDDLE", "DEFAULT_THRESHOLDSOURCE", "DEFAULT_THRESHOLDTYPE", "Lcom/rigol/scope/cil/ServiceEnum$ThreType;", "DEFAULT_TOPMETHOD", "app_release"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class MeasureSettingParamKt {
    private static final int DEFAULT_BASEMETHOD = 0;
    private static final long DEFAULT_CURSORA = 200;
    private static final long DEFAULT_CURSORB = 800;
    private static final long DEFAULT_CURSORBOTHAB = 0;
    private static final boolean DEFAULT_CURSOR_INDICATOR = false;
    private static final boolean DEFAULT_HISTO_ENABLE = false;
    private static final boolean DEFAULT_METHODSTATE = false;
    private static final int DEFAULT_MODE = 0;
    private static final int DEFAULT_REGION = 0;
    private static final boolean DEFAULT_SHOW = false;
    private static final boolean DEFAULT_SHOW_SELECT_SOURCE_B = false;
    private static final int DEFAULT_STATCOUNT = 1000;
    private static final boolean DEFAULT_STATISTIC_State = false;
    private static final long DEFAULT_THRESHOLDHIGH = 90;
    private static final long DEFAULT_THRESHOLDLOW = 10;
    private static final long DEFAULT_THRESHOLDMIDDLE = 50;
    private static final int DEFAULT_TOPMETHOD = 0;
    private static final ServiceEnum.Chan DEFAULT_SELECT_SOURCE_A = ServiceEnum.Chan.chan1;
    private static final ServiceEnum.Chan DEFAULT_SELECT_SOURCE_B = ServiceEnum.Chan.chan2;
    private static final ServiceEnum.Chan DEFAULT_ALLITEMSOURCE = ServiceEnum.Chan.chan1;
    private static final ServiceEnum.ThreType DEFAULT_THRESHOLDTYPE = ServiceEnum.ThreType.TH_TYPE_PER;
    private static final ServiceEnum.Chan DEFAULT_THRESHOLDSOURCE = ServiceEnum.Chan.chan1;
}
