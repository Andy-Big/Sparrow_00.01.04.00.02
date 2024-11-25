package com.rigol.scope.views.histogram;

import com.rigol.scope.cil.ServiceEnum;
import com.rigol.util.PackageUtilKt;
import kotlin.Metadata;
/* compiled from: HistogramResultParam.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082D¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0082D¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0082D¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001X\u0082D¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001X\u0082D¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"DEFAULT_HISTO_BOTTOM", "", "DEFAULT_HISTO_CHAN", "Lcom/rigol/scope/cil/ServiceEnum$Chan;", "DEFAULT_HISTO_ENABLE", "", "DEFAULT_HISTO_HEIGHT", "DEFAULT_HISTO_LEFT", "DEFAULT_HISTO_REAL_BOTTOM", "", "DEFAULT_HISTO_REAL_LEFT", "DEFAULT_HISTO_REAL_RIGHT", "DEFAULT_HISTO_REAL_TOP", "DEFAULT_HISTO_RIGHT", "DEFAULT_HISTO_TOP", "DEFAULT_HISTO_TYPE", "Lcom/rigol/scope/cil/ServiceEnum$HistoType;", "app_release"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class HistogramResultParamKt {
    private static final boolean DEFAULT_HISTO_ENABLE = false;
    private static final ServiceEnum.HistoType DEFAULT_HISTO_TYPE = ServiceEnum.HistoType.histoHori;
    private static final ServiceEnum.Chan DEFAULT_HISTO_CHAN = ServiceEnum.Chan.chan1;
    private static final int DEFAULT_HISTO_HEIGHT = PackageUtilKt.ERROR_PACKAGE_FILE_DOWNLOAD;
    private static final int DEFAULT_HISTO_TOP = 120;
    private static final int DEFAULT_HISTO_BOTTOM = 300;
    private static final int DEFAULT_HISTO_LEFT = 300;
    private static final int DEFAULT_HISTO_RIGHT = 700;
    private static final long DEFAULT_HISTO_REAL_TOP = 200000000;
    private static final long DEFAULT_HISTO_REAL_BOTTOM = -100000000;
    private static final long DEFAULT_HISTO_REAL_LEFT = -10000000;
    private static final long DEFAULT_HISTO_REAL_RIGHT = 10000000;
}
