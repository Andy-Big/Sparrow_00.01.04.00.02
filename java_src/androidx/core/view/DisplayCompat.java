package androidx.core.view;

import android.app.UiModeManager;
import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.text.TextUtils;
import android.view.Display;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class DisplayCompat {
    private static final int DISPLAY_SIZE_4K_HEIGHT = 2160;
    private static final int DISPLAY_SIZE_4K_WIDTH = 3840;

    private DisplayCompat() {
    }

    public static ModeCompat[] getSupportedModes(Context context, Display display) {
        Point physicalDisplaySize = getPhysicalDisplaySize(context, display);
        if (Build.VERSION.SDK_INT >= 23) {
            Display.Mode[] supportedModes = display.getSupportedModes();
            ArrayList arrayList = new ArrayList(supportedModes.length);
            boolean z = false;
            for (int i = 0; i < supportedModes.length; i++) {
                if (physicalSizeEquals(supportedModes[i], physicalDisplaySize)) {
                    arrayList.add(i, new ModeCompat(supportedModes[i], true));
                    z = true;
                } else {
                    arrayList.add(i, new ModeCompat(supportedModes[i], false));
                }
            }
            if (!z) {
                arrayList.add(new ModeCompat(physicalDisplaySize));
            }
            return (ModeCompat[]) arrayList.toArray(new ModeCompat[0]);
        }
        return new ModeCompat[]{new ModeCompat(physicalDisplaySize)};
    }

    private static Point parseDisplaySize(String str) throws NumberFormatException {
        String[] split = str.trim().split("x", -1);
        if (split.length == 2) {
            int parseInt = Integer.parseInt(split[0]);
            int parseInt2 = Integer.parseInt(split[1]);
            if (parseInt > 0 && parseInt2 > 0) {
                return new Point(parseInt, parseInt2);
            }
        }
        throw new NumberFormatException();
    }

    private static String getSystemProperty(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class).invoke(cls, str);
        } catch (Exception unused) {
            return null;
        }
    }

    private static boolean physicalSizeEquals(Display.Mode mode, Point point) {
        return (mode.getPhysicalWidth() == point.x && mode.getPhysicalHeight() == point.y) || (mode.getPhysicalWidth() == point.y && mode.getPhysicalHeight() == point.x);
    }

    private static boolean isTv(Context context) {
        UiModeManager uiModeManager = (UiModeManager) context.getSystemService("uimode");
        return uiModeManager != null && uiModeManager.getCurrentModeType() == 4;
    }

    private static Point parsePhysicalDisplaySizeFromSystemProperties(String str, Display display) {
        if (display.getDisplayId() == 0) {
            String systemProperty = getSystemProperty(str);
            if (TextUtils.isEmpty(systemProperty)) {
                return null;
            }
            try {
                return parseDisplaySize(systemProperty);
            } catch (NumberFormatException unused) {
                return null;
            }
        }
        return null;
    }

    private static Point getPhysicalDisplaySize(Context context, Display display) {
        Point parsePhysicalDisplaySizeFromSystemProperties;
        if (Build.VERSION.SDK_INT < 28) {
            parsePhysicalDisplaySizeFromSystemProperties = parsePhysicalDisplaySizeFromSystemProperties("sys.display-size", display);
        } else {
            parsePhysicalDisplaySizeFromSystemProperties = parsePhysicalDisplaySizeFromSystemProperties("vendor.display-size", display);
        }
        if (parsePhysicalDisplaySizeFromSystemProperties != null) {
            return parsePhysicalDisplaySizeFromSystemProperties;
        }
        if (isSonyBravia4kTv(context)) {
            return new Point(3840, DISPLAY_SIZE_4K_HEIGHT);
        }
        Point point = new Point();
        if (Build.VERSION.SDK_INT >= 23) {
            Display.Mode mode = display.getMode();
            point.x = mode.getPhysicalWidth();
            point.y = mode.getPhysicalHeight();
        } else if (Build.VERSION.SDK_INT >= 17) {
            display.getRealSize(point);
        } else {
            display.getSize(point);
        }
        return point;
    }

    private static boolean isSonyBravia4kTv(Context context) {
        return isTv(context) && "Sony".equals(Build.MANUFACTURER) && Build.MODEL.startsWith("BRAVIA") && context.getPackageManager().hasSystemFeature("com.sony.dtv.hardware.panel.qfhd");
    }

    /* loaded from: classes.dex */
    public static final class ModeCompat {
        private final boolean mIsNative;
        private final Display.Mode mMode;
        private final Point mPhysicalDisplaySize;

        ModeCompat(Point point) {
            Preconditions.checkNotNull(point, "physicalDisplaySize == null");
            this.mIsNative = true;
            this.mPhysicalDisplaySize = point;
            this.mMode = null;
        }

        ModeCompat(Display.Mode mode, boolean z) {
            Preconditions.checkNotNull(mode, "Display.Mode == null, can't wrap a null reference");
            this.mIsNative = z;
            this.mPhysicalDisplaySize = new Point(mode.getPhysicalWidth(), mode.getPhysicalHeight());
            this.mMode = mode;
        }

        public int getPhysicalWidth() {
            return this.mPhysicalDisplaySize.x;
        }

        public int getPhysicalHeight() {
            return this.mPhysicalDisplaySize.y;
        }

        public Display.Mode toMode() {
            return this.mMode;
        }

        public boolean isNative() {
            return this.mIsNative;
        }
    }
}
