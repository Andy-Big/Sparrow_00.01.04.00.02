package com.rigol.scope.data;

import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.utilities.UnitFormat;
import com.rigol.util.PackageUtilKt;
import kotlin.Metadata;

/* compiled from: HorizontalParam.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0011X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0015\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0016\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0017\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0018\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u001b\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001c\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u001d\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010 \u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010!\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010$\u001a\u00020%X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010&\u001a\u00020\u0003X\u0082D¢\u0006\u0002\n\u0000\"\u000e\u0010'\u001a\u00020\u0003X\u0082D¢\u0006\u0002\n\u0000\"\u000e\u0010(\u001a\u00020\u0003X\u0082D¢\u0006\u0002\n\u0000\"\u000e\u0010)\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010*\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010+\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"DEFAULT_ACQUIRE_MODE", "Lcom/rigol/scope/cil/ServiceEnum$AcquireMode;", "DEFAULT_ANTI_ALIASING", "", "DEFAULT_AVG_TIMES", "", "DEFAULT_DEPTH", "Lcom/rigol/scope/cil/ServiceEnum$AcquireDepth;", "DEFAULT_DEPTHEN", "DEFAULT_DEPTH_MEM_END", "", "DEFAULT_DEPTH_MEM_START", "DEFAULT_DEPTH_SCR_END", "DEFAULT_DEPTH_SCR_START", "DEFAULT_DEPTH_VALUE", "DEFAULT_DISPLAY", "DEFAULT_DOTTIME", "", "DEFAULT_EXPANDGND", "DEFAULT_EXPANDMODE", "Lcom/rigol/scope/cil/ServiceEnum$HorizontalExpand;", "DEFAULT_EXPANDUSER", "DEFAULT_FILTER1", "DEFAULT_FILTER2", "DEFAULT_FINE_ON", "DEFAULT_HIGHBIT", "Lcom/rigol/scope/cil/ServiceEnum$HighResBit;", "DEFAULT_MAIN_OFFSET", "DEFAULT_MAIN_SCALE", "DEFAULT_ROLL", "DEFAULT_RUNSTOP", "Lcom/rigol/scope/cil/ServiceEnum$ControlAction;", "DEFAULT_SAMPLE", "DEFAULT_SHOW2G", "DEFAULT_TIMEMODE", "Lcom/rigol/scope/cil/ServiceEnum$HoriTimeMode;", "DEFAULT_TRIGGERSTATUS", "Lcom/rigol/scope/cil/ServiceEnum$ControlStatus;", "DEFAULT_ULTRA_ENABLE", "DEFAULT_XY_CHECK", "DEFAULT_XY_CHECK_ENABLE", "DEFAULT_ZOOM_OFFSET", "DEFAULT_ZOOM_ON", "DEFAULT_ZOOM_SCALE", "app_release"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class HorizontalParamKt {
    private static final boolean DEFAULT_ANTI_ALIASING = false;
    private static final int DEFAULT_AVG_TIMES = 2;
    private static final boolean DEFAULT_DEPTHEN = true;
    private static final long DEFAULT_DEPTH_MEM_END = 0;
    private static final long DEFAULT_DEPTH_MEM_START = 0;
    private static final long DEFAULT_DEPTH_SCR_END = 0;
    private static final long DEFAULT_DEPTH_SCR_START = 0;
    private static final long DEFAULT_DEPTH_VALUE = 10000;
    private static final int DEFAULT_DISPLAY = 0;
    private static final float DEFAULT_DOTTIME = 250.0f;
    private static final int DEFAULT_EXPANDGND = 0;
    private static final int DEFAULT_EXPANDUSER = 0;
    private static final boolean DEFAULT_FILTER1 = true;
    private static final boolean DEFAULT_FILTER2 = true;
    private static final boolean DEFAULT_FINE_ON = false;
    private static final long DEFAULT_MAIN_OFFSET = 0;
    private static final float DEFAULT_MAIN_SCALE;
    private static final long DEFAULT_SAMPLE = 4000000000L;
    private static final boolean DEFAULT_SHOW2G = false;
    private static final boolean DEFAULT_ULTRA_ENABLE = true;
    private static final boolean DEFAULT_XY_CHECK = false;
    private static final boolean DEFAULT_XY_CHECK_ENABLE = true;
    private static final long DEFAULT_ZOOM_OFFSET = 0;
    private static final boolean DEFAULT_ZOOM_ON = false;
    private static final float DEFAULT_ZOOM_SCALE;
    private static final ServiceEnum.AcquireMode DEFAULT_ACQUIRE_MODE = ServiceEnum.AcquireMode.Acquire_Normal;
    private static final ServiceEnum.AcquireDepth DEFAULT_DEPTH = ServiceEnum.AcquireDepth.Acquire_Depth_10K;
    private static final ServiceEnum.HorizontalExpand DEFAULT_EXPANDMODE = ServiceEnum.HorizontalExpand.Horizontal_Expand_Center;
    private static final int DEFAULT_ROLL = Roll.AUTO.getValue();
    private static final ServiceEnum.HighResBit DEFAULT_HIGHBIT = ServiceEnum.HighResBit.HIGH_RES_14;
    private static final ServiceEnum.ControlAction DEFAULT_RUNSTOP = ServiceEnum.ControlAction.Control_Run;
    private static final ServiceEnum.ControlStatus DEFAULT_TRIGGERSTATUS = ServiceEnum.ControlStatus.Status_Autoing;
    private static final ServiceEnum.HoriTimeMode DEFAULT_TIMEMODE = ServiceEnum.HoriTimeMode.Horizontal_YT;

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.rigol.scope.data.HorizontalParam.<init>():void, com.rigol.scope.data.HorizontalParam.reset():void] */
    public static final /* synthetic */ ServiceEnum.AcquireMode access$getDEFAULT_ACQUIRE_MODE$p() {
        return DEFAULT_ACQUIRE_MODE;
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.rigol.scope.data.HorizontalParam.<init>():void, com.rigol.scope.data.HorizontalParam.reset():void] */
    public static final /* synthetic */ ServiceEnum.AcquireDepth access$getDEFAULT_DEPTH$p() {
        return DEFAULT_DEPTH;
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.rigol.scope.data.HorizontalParam.<init>():void] */
    public static final /* synthetic */ long access$getDEFAULT_DEPTH_MEM_END$p() {
        return DEFAULT_DEPTH_MEM_END;
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.rigol.scope.data.HorizontalParam.<init>():void] */
    public static final /* synthetic */ long access$getDEFAULT_DEPTH_MEM_START$p() {
        return DEFAULT_DEPTH_MEM_START;
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.rigol.scope.data.HorizontalParam.<init>():void] */
    public static final /* synthetic */ long access$getDEFAULT_DEPTH_SCR_END$p() {
        return DEFAULT_DEPTH_SCR_END;
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.rigol.scope.data.HorizontalParam.<init>():void] */
    public static final /* synthetic */ long access$getDEFAULT_DEPTH_SCR_START$p() {
        return DEFAULT_DEPTH_SCR_START;
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.rigol.scope.data.HorizontalParam.<init>():void, com.rigol.scope.data.HorizontalParam.reset():void] */
    public static final /* synthetic */ ServiceEnum.HorizontalExpand access$getDEFAULT_EXPANDMODE$p() {
        return DEFAULT_EXPANDMODE;
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.rigol.scope.data.HorizontalParam.<init>():void, com.rigol.scope.data.HorizontalParam.reset():void] */
    public static final /* synthetic */ ServiceEnum.HighResBit access$getDEFAULT_HIGHBIT$p() {
        return DEFAULT_HIGHBIT;
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.rigol.scope.data.HorizontalParam.<init>():void, com.rigol.scope.data.HorizontalParam.reset():void] */
    public static final /* synthetic */ float access$getDEFAULT_MAIN_SCALE$p() {
        return DEFAULT_MAIN_SCALE;
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.rigol.scope.data.HorizontalParam.<init>():void, com.rigol.scope.data.HorizontalParam.reset():void] */
    public static final /* synthetic */ int access$getDEFAULT_ROLL$p() {
        return DEFAULT_ROLL;
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.rigol.scope.data.HorizontalParam.<init>():void, com.rigol.scope.data.HorizontalParam.reset():void] */
    public static final /* synthetic */ ServiceEnum.ControlAction access$getDEFAULT_RUNSTOP$p() {
        return DEFAULT_RUNSTOP;
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.rigol.scope.data.HorizontalParam.<init>():void, com.rigol.scope.data.HorizontalParam.reset():void] */
    public static final /* synthetic */ ServiceEnum.HoriTimeMode access$getDEFAULT_TIMEMODE$p() {
        return DEFAULT_TIMEMODE;
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.rigol.scope.data.HorizontalParam.<init>():void, com.rigol.scope.data.HorizontalParam.reset():void] */
    public static final /* synthetic */ ServiceEnum.ControlStatus access$getDEFAULT_TRIGGERSTATUS$p() {
        return DEFAULT_TRIGGERSTATUS;
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.rigol.scope.data.HorizontalParam.<init>():void, com.rigol.scope.data.HorizontalParam.reset():void] */
    public static final /* synthetic */ boolean access$getDEFAULT_ULTRA_ENABLE$p() {
        return DEFAULT_ULTRA_ENABLE;
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.rigol.scope.data.HorizontalParam.<init>():void, com.rigol.scope.data.HorizontalParam.reset():void] */
    public static final /* synthetic */ boolean access$getDEFAULT_XY_CHECK$p() {
        return DEFAULT_XY_CHECK;
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.rigol.scope.data.HorizontalParam.<init>():void, com.rigol.scope.data.HorizontalParam.reset():void] */
    public static final /* synthetic */ boolean access$getDEFAULT_XY_CHECK_ENABLE$p() {
        return DEFAULT_XY_CHECK_ENABLE;
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.rigol.scope.data.HorizontalParam.<init>():void, com.rigol.scope.data.HorizontalParam.reset():void] */
    public static final /* synthetic */ float access$getDEFAULT_ZOOM_SCALE$p() {
        return DEFAULT_ZOOM_SCALE;
    }

    static {
        double d = 1000;
        DEFAULT_MAIN_SCALE = ((float) PackageUtilKt.ERROR_PACKAGE_FILE_DOWNLOAD) / ((float) Math.pow(d, UnitFormat.SI.FEMTO.scale - UnitFormat.SI.NANO.scale));
        DEFAULT_ZOOM_SCALE = 500 / ((float) Math.pow(d, UnitFormat.SI.FEMTO.scale - UnitFormat.SI.PICO.scale));
    }
}
