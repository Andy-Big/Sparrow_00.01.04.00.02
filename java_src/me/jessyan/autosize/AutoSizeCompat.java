package me.jessyan.autosize;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import me.jessyan.autosize.external.ExternalAdaptInfo;
import me.jessyan.autosize.internal.CustomAdapt;
import me.jessyan.autosize.unit.Subunits;
import me.jessyan.autosize.utils.Preconditions;
/* loaded from: classes2.dex */
public final class AutoSizeCompat {
    private static final int MODE_DEVICE_SIZE = Integer.MIN_VALUE;
    private static final int MODE_MASK = -1073741824;
    private static final int MODE_ON_WIDTH = 1073741824;
    private static final int MODE_SHIFT = 30;
    private static SparseArray<DisplayMetricsInfo> mCache = new SparseArray<>();

    private AutoSizeCompat() {
        throw new IllegalStateException("you can't instantiate me!");
    }

    public static void autoConvertDensityOfGlobal(Resources resources) {
        if (AutoSizeConfig.getInstance().isBaseOnWidth()) {
            autoConvertDensityBaseOnWidth(resources, AutoSizeConfig.getInstance().getDesignWidthInDp());
        } else {
            autoConvertDensityBaseOnHeight(resources, AutoSizeConfig.getInstance().getDesignHeightInDp());
        }
    }

    public static void autoConvertDensityOfCustomAdapt(Resources resources, CustomAdapt customAdapt) {
        int designHeightInDp;
        Preconditions.checkNotNull(customAdapt, "customAdapt == null");
        float sizeInDp = customAdapt.getSizeInDp();
        if (sizeInDp <= 0.0f) {
            if (customAdapt.isBaseOnWidth()) {
                designHeightInDp = AutoSizeConfig.getInstance().getDesignWidthInDp();
            } else {
                designHeightInDp = AutoSizeConfig.getInstance().getDesignHeightInDp();
            }
            sizeInDp = designHeightInDp;
        }
        autoConvertDensity(resources, sizeInDp, customAdapt.isBaseOnWidth());
    }

    public static void autoConvertDensityOfExternalAdaptInfo(Resources resources, ExternalAdaptInfo externalAdaptInfo) {
        int designHeightInDp;
        Preconditions.checkNotNull(externalAdaptInfo, "externalAdaptInfo == null");
        float sizeInDp = externalAdaptInfo.getSizeInDp();
        if (sizeInDp <= 0.0f) {
            if (externalAdaptInfo.isBaseOnWidth()) {
                designHeightInDp = AutoSizeConfig.getInstance().getDesignWidthInDp();
            } else {
                designHeightInDp = AutoSizeConfig.getInstance().getDesignHeightInDp();
            }
            sizeInDp = designHeightInDp;
        }
        autoConvertDensity(resources, sizeInDp, externalAdaptInfo.isBaseOnWidth());
    }

    public static void autoConvertDensityBaseOnWidth(Resources resources, float f) {
        autoConvertDensity(resources, f, true);
    }

    public static void autoConvertDensityBaseOnHeight(Resources resources, float f) {
        autoConvertDensity(resources, f, false);
    }

    public static void autoConvertDensity(Resources resources, float f, boolean z) {
        float designHeight;
        int screenHeight;
        float density;
        int densityDpi;
        float scaledDensity;
        float xdpi;
        int screenWidthDp;
        int screenHeightDp;
        int screenHeight2;
        float initScaledDensity;
        int screenHeight3;
        Preconditions.checkNotNull(resources, "resources == null");
        Preconditions.checkMainThread();
        if (z) {
            designHeight = AutoSizeConfig.getInstance().getUnitsManager().getDesignWidth();
        } else {
            designHeight = AutoSizeConfig.getInstance().getUnitsManager().getDesignHeight();
        }
        if (designHeight <= 0.0f) {
            designHeight = f;
        }
        if (z) {
            screenHeight = AutoSizeConfig.getInstance().getScreenWidth();
        } else {
            screenHeight = AutoSizeConfig.getInstance().getScreenHeight();
        }
        int round = Math.round((f + designHeight + screenHeight) * AutoSizeConfig.getInstance().getInitScaledDensity()) & LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
        int i = z ? round | 1073741824 : round & (-1073741825);
        int i2 = AutoSizeConfig.getInstance().isUseDeviceSize() ? i | Integer.MIN_VALUE : i & Integer.MAX_VALUE;
        DisplayMetricsInfo displayMetricsInfo = mCache.get(i2);
        if (displayMetricsInfo == null) {
            if (z) {
                screenHeight2 = AutoSizeConfig.getInstance().getScreenWidth();
            } else {
                screenHeight2 = AutoSizeConfig.getInstance().getScreenHeight();
            }
            density = (screenHeight2 * 1.0f) / f;
            if (AutoSizeConfig.getInstance().getPrivateFontScale() > 0.0f) {
                initScaledDensity = AutoSizeConfig.getInstance().getPrivateFontScale();
            } else {
                initScaledDensity = AutoSizeConfig.getInstance().isExcludeFontScale() ? 1.0f : (AutoSizeConfig.getInstance().getInitScaledDensity() * 1.0f) / AutoSizeConfig.getInstance().getInitDensity();
            }
            scaledDensity = initScaledDensity * density;
            densityDpi = (int) (160.0f * density);
            screenWidthDp = (int) (AutoSizeConfig.getInstance().getScreenWidth() / density);
            screenHeightDp = (int) (AutoSizeConfig.getInstance().getScreenHeight() / density);
            if (z) {
                screenHeight3 = AutoSizeConfig.getInstance().getScreenWidth();
            } else {
                screenHeight3 = AutoSizeConfig.getInstance().getScreenHeight();
            }
            float f2 = (screenHeight3 * 1.0f) / designHeight;
            mCache.put(i2, new DisplayMetricsInfo(density, densityDpi, scaledDensity, f2, screenWidthDp, screenHeightDp));
            xdpi = f2;
        } else {
            density = displayMetricsInfo.getDensity();
            densityDpi = displayMetricsInfo.getDensityDpi();
            scaledDensity = displayMetricsInfo.getScaledDensity();
            xdpi = displayMetricsInfo.getXdpi();
            screenWidthDp = displayMetricsInfo.getScreenWidthDp();
            screenHeightDp = displayMetricsInfo.getScreenHeightDp();
        }
        setDensity(resources, density, densityDpi, scaledDensity, xdpi);
        setScreenSizeDp(resources, screenWidthDp, screenHeightDp);
    }

    public static void cancelAdapt(Resources resources) {
        float f;
        Preconditions.checkMainThread();
        float initXdpi = AutoSizeConfig.getInstance().getInitXdpi();
        int i = AnonymousClass1.$SwitchMap$me$jessyan$autosize$unit$Subunits[AutoSizeConfig.getInstance().getUnitsManager().getSupportSubunits().ordinal()];
        if (i != 1) {
            f = i == 2 ? 25.4f : 72.0f;
            setDensity(resources, AutoSizeConfig.getInstance().getInitDensity(), AutoSizeConfig.getInstance().getInitDensityDpi(), AutoSizeConfig.getInstance().getInitScaledDensity(), initXdpi);
            setScreenSizeDp(resources, AutoSizeConfig.getInstance().getInitScreenWidthDp(), AutoSizeConfig.getInstance().getInitScreenHeightDp());
        }
        initXdpi /= f;
        setDensity(resources, AutoSizeConfig.getInstance().getInitDensity(), AutoSizeConfig.getInstance().getInitDensityDpi(), AutoSizeConfig.getInstance().getInitScaledDensity(), initXdpi);
        setScreenSizeDp(resources, AutoSizeConfig.getInstance().getInitScreenWidthDp(), AutoSizeConfig.getInstance().getInitScreenHeightDp());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: me.jessyan.autosize.AutoSizeCompat$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$me$jessyan$autosize$unit$Subunits;

        static {
            int[] iArr = new int[Subunits.values().length];
            $SwitchMap$me$jessyan$autosize$unit$Subunits = iArr;
            try {
                iArr[Subunits.PT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$me$jessyan$autosize$unit$Subunits[Subunits.MM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$me$jessyan$autosize$unit$Subunits[Subunits.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$me$jessyan$autosize$unit$Subunits[Subunits.IN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private static void setDensity(Resources resources, float f, int i, float f2, float f3) {
        setDensity(resources.getDisplayMetrics(), f, i, f2, f3);
        setDensity(AutoSizeConfig.getInstance().getApplication().getResources().getDisplayMetrics(), f, i, f2, f3);
        DisplayMetrics metricsOnMiui = getMetricsOnMiui(resources);
        DisplayMetrics metricsOnMiui2 = getMetricsOnMiui(AutoSizeConfig.getInstance().getApplication().getResources());
        if (metricsOnMiui != null) {
            setDensity(metricsOnMiui, f, i, f2, f3);
        }
        if (metricsOnMiui2 != null) {
            setDensity(metricsOnMiui2, f, i, f2, f3);
        }
    }

    private static void setDensity(DisplayMetrics displayMetrics, float f, int i, float f2, float f3) {
        if (AutoSizeConfig.getInstance().getUnitsManager().isSupportDP()) {
            displayMetrics.density = f;
            displayMetrics.densityDpi = i;
        }
        if (AutoSizeConfig.getInstance().getUnitsManager().isSupportSP()) {
            displayMetrics.scaledDensity = f2;
        }
        int i2 = AnonymousClass1.$SwitchMap$me$jessyan$autosize$unit$Subunits[AutoSizeConfig.getInstance().getUnitsManager().getSupportSubunits().ordinal()];
        if (i2 == 1) {
            displayMetrics.xdpi = f3 * 72.0f;
        } else if (i2 == 2) {
            displayMetrics.xdpi = f3 * 25.4f;
        } else if (i2 != 4) {
        } else {
            displayMetrics.xdpi = f3;
        }
    }

    private static void setScreenSizeDp(Resources resources, int i, int i2) {
        if (AutoSizeConfig.getInstance().getUnitsManager().isSupportDP() && AutoSizeConfig.getInstance().getUnitsManager().isSupportScreenSizeDP()) {
            setScreenSizeDp(resources.getConfiguration(), i, i2);
            setScreenSizeDp(AutoSizeConfig.getInstance().getApplication().getResources().getConfiguration(), i, i2);
        }
    }

    private static void setScreenSizeDp(Configuration configuration, int i, int i2) {
        configuration.screenWidthDp = i;
        configuration.screenHeightDp = i2;
    }

    private static DisplayMetrics getMetricsOnMiui(Resources resources) {
        if (AutoSizeConfig.getInstance().isMiui() && AutoSizeConfig.getInstance().getTmpMetricsField() != null) {
            try {
                return (DisplayMetrics) AutoSizeConfig.getInstance().getTmpMetricsField().get(resources);
            } catch (Exception unused) {
            }
        }
        return null;
    }
}
