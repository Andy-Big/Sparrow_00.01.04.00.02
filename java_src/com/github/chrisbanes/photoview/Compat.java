package com.github.chrisbanes.photoview;

import android.os.Build;
import android.view.View;
/* loaded from: classes.dex */
class Compat {
    private static final int SIXTY_FPS_INTERVAL = 16;

    Compat() {
    }

    public static void postOnAnimation(View view, Runnable runnable) {
        if (Build.VERSION.SDK_INT >= 16) {
            postOnAnimationJellyBean(view, runnable);
        } else {
            view.postDelayed(runnable, 16L);
        }
    }

    private static void postOnAnimationJellyBean(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }
}
