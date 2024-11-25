package com.rigol.scope.data;

import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.utilities.UnitFormat;
import kotlin.Metadata;
/* compiled from: MaskParam.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0014\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0015\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"DEFAULT_AUX", "", "DEFAULT_ENABLE", "DEFAULT_ERRACTION", "", "DEFAULT_FORCESTOP", "DEFAULT_MINIMIZE_WINDOW", "DEFAULT_OPERATE", "DEFAULT_OUTEVENT", "Lcom/rigol/scope/cil/ServiceEnum$MaskActionEvent;", "DEFAULT_OUTHL", "Lcom/rigol/scope/cil/ServiceEnum$MaskPolarity;", "DEFAULT_OUTPULSE", "", "DEFAULT_RANGE", "Lcom/rigol/scope/cil/ServiceEnum$MaskRange;", "DEFAULT_SHOWSTAT", "DEFAULT_SOURCE", "DEFAULT_XRATIO", "DEFAULT_XVALUE", "DEFAULT_YRATIO", "DEFAULT_YVALUE", "app_release"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class MaskParamKt {
    private static final boolean DEFAULT_AUX = false;
    private static final boolean DEFAULT_ENABLE = false;
    private static final int DEFAULT_ERRACTION = 1;
    private static final boolean DEFAULT_FORCESTOP = false;
    private static final boolean DEFAULT_MINIMIZE_WINDOW = false;
    private static final boolean DEFAULT_OPERATE = false;
    private static final boolean DEFAULT_SHOWSTAT = false;
    private static final int DEFAULT_XRATIO = 10;
    private static final int DEFAULT_XVALUE = 240;
    private static final int DEFAULT_YRATIO = 40;
    private static final int DEFAULT_YVALUE = 480;
    private static final int DEFAULT_SOURCE = ServiceEnum.Chan.chan1.value1;
    private static final ServiceEnum.MaskRange DEFAULT_RANGE = ServiceEnum.MaskRange.mask_range_screen;
    private static final float DEFAULT_OUTPULSE = 1 / ((float) Math.pow(1000, UnitFormat.SI.FEMTO.scale - UnitFormat.SI.MICRO.scale));
    private static final ServiceEnum.MaskActionEvent DEFAULT_OUTEVENT = ServiceEnum.MaskActionEvent.mask_action_on_fail;
    private static final ServiceEnum.MaskPolarity DEFAULT_OUTHL = ServiceEnum.MaskPolarity.mask_polarity_positive;
}
