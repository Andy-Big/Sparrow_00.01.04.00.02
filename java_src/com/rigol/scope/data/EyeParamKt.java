package com.rigol.scope.data;

import com.rigol.scope.utilities.UnitFormat;
import kotlin.Metadata;
/* compiled from: EyeParam.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"DEFAULT_DATARATE", "", "DEFAULT_LOOPBW", "", "DEFAULT_NOISEHOLDUP", "app_release"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class EyeParamKt {
    private static final float DEFAULT_DATARATE;
    private static final double DEFAULT_LOOPBW;
    private static final float DEFAULT_NOISEHOLDUP;

    static {
        float pow = 300 * ((float) Math.pow(1000, UnitFormat.SI.NONE.scale - UnitFormat.SI.MICRO.scale));
        DEFAULT_DATARATE = pow;
        DEFAULT_LOOPBW = pow / 1667.0d;
        DEFAULT_NOISEHOLDUP = (float) Math.pow((float) 0.2d, UnitFormat.SI.NONE.scale - UnitFormat.SI.MICRO.scale);
    }
}
