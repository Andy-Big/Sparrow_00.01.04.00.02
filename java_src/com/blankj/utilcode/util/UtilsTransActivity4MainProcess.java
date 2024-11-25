package com.blankj.utilcode.util;

import android.app.Activity;
import android.content.Intent;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.UtilsTransActivity;
/* loaded from: classes.dex */
public class UtilsTransActivity4MainProcess extends UtilsTransActivity {
    public static void start(UtilsTransActivity.TransActivityDelegate transActivityDelegate) {
        start(null, null, transActivityDelegate, UtilsTransActivity4MainProcess.class);
    }

    public static void start(Utils.Consumer<Intent> consumer, UtilsTransActivity.TransActivityDelegate transActivityDelegate) {
        start(null, consumer, transActivityDelegate, UtilsTransActivity4MainProcess.class);
    }

    public static void start(Activity activity, UtilsTransActivity.TransActivityDelegate transActivityDelegate) {
        start(activity, null, transActivityDelegate, UtilsTransActivity4MainProcess.class);
    }

    public static void start(Activity activity, Utils.Consumer<Intent> consumer, UtilsTransActivity.TransActivityDelegate transActivityDelegate) {
        start(activity, consumer, transActivityDelegate, UtilsTransActivity4MainProcess.class);
    }
}
