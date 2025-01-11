package androidx.transition;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build;
import android.util.Property;
import android.view.View;
import androidx.core.view.ViewCompat;

/* loaded from: classes.dex */
class ViewUtils {
    static final Property<View, Rect> CLIP_BOUNDS;
    private static final ViewUtilsBase IMPL;
    private static final String TAG = "ViewUtils";
    static final Property<View, Float> TRANSITION_ALPHA;

    static {
        if (Build.VERSION.SDK_INT >= 29) {
            IMPL = new ViewUtilsApi29();
        } else if (Build.VERSION.SDK_INT >= 23) {
            IMPL = new ViewUtilsApi23();
        } else if (Build.VERSION.SDK_INT >= 22) {
            IMPL = new ViewUtilsApi22();
        } else if (Build.VERSION.SDK_INT >= 21) {
            IMPL = new ViewUtilsApi21();
        } else if (Build.VERSION.SDK_INT >= 19) {
            IMPL = new ViewUtilsApi19();
        } else {
            IMPL = new ViewUtilsBase();
        }
        TRANSITION_ALPHA = new Property<View, Float>(Float.class, "translationAlpha") { // from class: androidx.transition.ViewUtils.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.util.Property
            public Float get(View view) {
                return Float.valueOf(ViewUtils.getTransitionAlpha(view));
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.util.Property
            public void set(View view, Float f) {
                ViewUtils.setTransitionAlpha(view, f.floatValue());
            }
        };
        CLIP_BOUNDS = new Property<View, Rect>(Rect.class, "clipBounds") { // from class: androidx.transition.ViewUtils.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.util.Property
            public Rect get(View view) {
                return ViewCompat.getClipBounds(view);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.util.Property
            public void set(View view, Rect rect) {
                ViewCompat.setClipBounds(view, rect);
            }
        };
    }

    static ViewOverlayImpl getOverlay(View view) {
        if (Build.VERSION.SDK_INT >= 18) {
            return new ViewOverlayApi18(view);
        }
        return ViewOverlayApi14.createFrom(view);
    }

    static WindowIdImpl getWindowId(View view) {
        if (Build.VERSION.SDK_INT >= 18) {
            return new WindowIdApi18(view);
        }
        return new WindowIdApi14(view.getWindowToken());
    }

    static void setTransitionAlpha(View view, float f) {
        IMPL.setTransitionAlpha(view, f);
    }

    static float getTransitionAlpha(View view) {
        return IMPL.getTransitionAlpha(view);
    }

    static void saveNonTransitionAlpha(View view) {
        IMPL.saveNonTransitionAlpha(view);
    }

    static void clearNonTransitionAlpha(View view) {
        IMPL.clearNonTransitionAlpha(view);
    }

    static void setTransitionVisibility(View view, int i) {
        IMPL.setTransitionVisibility(view, i);
    }

    static void transformMatrixToGlobal(View view, Matrix matrix) {
        IMPL.transformMatrixToGlobal(view, matrix);
    }

    static void transformMatrixToLocal(View view, Matrix matrix) {
        IMPL.transformMatrixToLocal(view, matrix);
    }

    static void setAnimationMatrix(View view, Matrix matrix) {
        IMPL.setAnimationMatrix(view, matrix);
    }

    static void setLeftTopRightBottom(View view, int i, int i2, int i3, int i4) {
        IMPL.setLeftTopRightBottom(view, i, i2, i3, i4);
    }

    private ViewUtils() {
    }
}
