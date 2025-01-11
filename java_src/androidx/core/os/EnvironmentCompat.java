package androidx.core.os;

import android.os.Build;
import android.os.Environment;
import android.util.Log;
import java.io.File;
import java.io.IOException;

/* loaded from: classes.dex */
public final class EnvironmentCompat {
    public static final String MEDIA_UNKNOWN = "unknown";
    private static final String TAG = "EnvironmentCompat";

    public static String getStorageState(File file) {
        if (Build.VERSION.SDK_INT >= 21) {
            return Environment.getExternalStorageState(file);
        }
        if (Build.VERSION.SDK_INT >= 19) {
            return Environment.getStorageState(file);
        }
        try {
            return file.getCanonicalPath().startsWith(Environment.getExternalStorageDirectory().getCanonicalPath()) ? Environment.getExternalStorageState() : MEDIA_UNKNOWN;
        } catch (IOException e) {
            Log.w(TAG, "Failed to resolve canonical path: " + e);
            return MEDIA_UNKNOWN;
        }
    }

    private EnvironmentCompat() {
    }
}
