package androidx.core.hardware.display;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.view.Display;
import android.view.WindowManager;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class DisplayManagerCompat {
    public static final String DISPLAY_CATEGORY_PRESENTATION = "android.hardware.display.category.PRESENTATION";
    private static final WeakHashMap<Context, DisplayManagerCompat> sInstances = new WeakHashMap<>();
    private final Context mContext;

    private DisplayManagerCompat(Context context) {
        this.mContext = context;
    }

    public static DisplayManagerCompat getInstance(Context context) {
        DisplayManagerCompat displayManagerCompat;
        synchronized (sInstances) {
            displayManagerCompat = sInstances.get(context);
            if (displayManagerCompat == null) {
                displayManagerCompat = new DisplayManagerCompat(context);
                sInstances.put(context, displayManagerCompat);
            }
        }
        return displayManagerCompat;
    }

    public Display getDisplay(int i) {
        if (Build.VERSION.SDK_INT >= 17) {
            return ((DisplayManager) this.mContext.getSystemService("display")).getDisplay(i);
        }
        Display defaultDisplay = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay();
        if (defaultDisplay.getDisplayId() == i) {
            return defaultDisplay;
        }
        return null;
    }

    public Display[] getDisplays() {
        return Build.VERSION.SDK_INT >= 17 ? ((DisplayManager) this.mContext.getSystemService("display")).getDisplays() : new Display[]{((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay()};
    }

    public Display[] getDisplays(String str) {
        if (Build.VERSION.SDK_INT >= 17) {
            return ((DisplayManager) this.mContext.getSystemService("display")).getDisplays(str);
        }
        return str == null ? new Display[0] : new Display[]{((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay()};
    }
}
