package androidx.databinding.adapters;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import androidx.databinding.library.baseAdapters.R;
/* loaded from: classes.dex */
public class ViewBindingAdapter {
    public static final int FADING_EDGE_HORIZONTAL = 1;
    public static final int FADING_EDGE_NONE = 0;
    public static final int FADING_EDGE_VERTICAL = 2;

    /* loaded from: classes.dex */
    public interface OnViewAttachedToWindow {
        void onViewAttachedToWindow(View view);
    }

    /* loaded from: classes.dex */
    public interface OnViewDetachedFromWindow {
        void onViewDetachedFromWindow(View view);
    }

    private static int pixelsToDimensionPixelSize(float f) {
        int i = (int) (0.5f + f);
        if (i != 0) {
            return i;
        }
        int i2 = (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1));
        if (i2 == 0) {
            return 0;
        }
        return i2 > 0 ? 1 : -1;
    }

    public static void setPadding(View view, float f) {
        int pixelsToDimensionPixelSize = pixelsToDimensionPixelSize(f);
        view.setPadding(pixelsToDimensionPixelSize, pixelsToDimensionPixelSize, pixelsToDimensionPixelSize, pixelsToDimensionPixelSize);
    }

    public static void setPaddingBottom(View view, float f) {
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), pixelsToDimensionPixelSize(f));
    }

    public static void setPaddingEnd(View view, float f) {
        int pixelsToDimensionPixelSize = pixelsToDimensionPixelSize(f);
        if (Build.VERSION.SDK_INT >= 17) {
            view.setPaddingRelative(view.getPaddingStart(), view.getPaddingTop(), pixelsToDimensionPixelSize, view.getPaddingBottom());
        } else {
            view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), pixelsToDimensionPixelSize, view.getPaddingBottom());
        }
    }

    public static void setPaddingLeft(View view, float f) {
        view.setPadding(pixelsToDimensionPixelSize(f), view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom());
    }

    public static void setPaddingRight(View view, float f) {
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), pixelsToDimensionPixelSize(f), view.getPaddingBottom());
    }

    public static void setPaddingStart(View view, float f) {
        int pixelsToDimensionPixelSize = pixelsToDimensionPixelSize(f);
        if (Build.VERSION.SDK_INT >= 17) {
            view.setPaddingRelative(pixelsToDimensionPixelSize, view.getPaddingTop(), view.getPaddingEnd(), view.getPaddingBottom());
        } else {
            view.setPadding(pixelsToDimensionPixelSize, view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom());
        }
    }

    public static void setPaddingTop(View view, float f) {
        view.setPadding(view.getPaddingLeft(), pixelsToDimensionPixelSize(f), view.getPaddingRight(), view.getPaddingBottom());
    }

    public static void setRequiresFadingEdge(View view, int i) {
        boolean z = (i & 2) != 0;
        boolean z2 = (i & 1) != 0;
        view.setVerticalFadingEdgeEnabled(z);
        view.setHorizontalFadingEdgeEnabled(z2);
    }

    public static void setClickListener(View view, View.OnClickListener onClickListener, boolean z) {
        view.setOnClickListener(onClickListener);
        view.setClickable(z);
    }

    public static void setOnClick(View view, View.OnClickListener onClickListener, boolean z) {
        view.setOnClickListener(onClickListener);
        view.setClickable(z);
    }

    public static void setOnLongClickListener(View view, View.OnLongClickListener onLongClickListener, boolean z) {
        view.setOnLongClickListener(onLongClickListener);
        view.setLongClickable(z);
    }

    public static void setOnLongClick(View view, View.OnLongClickListener onLongClickListener, boolean z) {
        view.setOnLongClickListener(onLongClickListener);
        view.setLongClickable(z);
    }

    public static void setOnAttachStateChangeListener(View view, final OnViewDetachedFromWindow onViewDetachedFromWindow, final OnViewAttachedToWindow onViewAttachedToWindow) {
        View.OnAttachStateChangeListener onAttachStateChangeListener = (onViewDetachedFromWindow == null && onViewAttachedToWindow == null) ? null : new View.OnAttachStateChangeListener() { // from class: androidx.databinding.adapters.ViewBindingAdapter.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                OnViewAttachedToWindow onViewAttachedToWindow2 = OnViewAttachedToWindow.this;
                if (onViewAttachedToWindow2 != null) {
                    onViewAttachedToWindow2.onViewAttachedToWindow(view2);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                OnViewDetachedFromWindow onViewDetachedFromWindow2 = onViewDetachedFromWindow;
                if (onViewDetachedFromWindow2 != null) {
                    onViewDetachedFromWindow2.onViewDetachedFromWindow(view2);
                }
            }
        };
        View.OnAttachStateChangeListener onAttachStateChangeListener2 = (View.OnAttachStateChangeListener) ListenerUtil.trackListener(view, onAttachStateChangeListener, R.id.onAttachStateChangeListener);
        if (onAttachStateChangeListener2 != null) {
            view.removeOnAttachStateChangeListener(onAttachStateChangeListener2);
        }
        if (onAttachStateChangeListener != null) {
            view.addOnAttachStateChangeListener(onAttachStateChangeListener);
        }
    }

    public static void setOnLayoutChangeListener(View view, View.OnLayoutChangeListener onLayoutChangeListener, View.OnLayoutChangeListener onLayoutChangeListener2) {
        if (onLayoutChangeListener != null) {
            view.removeOnLayoutChangeListener(onLayoutChangeListener);
        }
        if (onLayoutChangeListener2 != null) {
            view.addOnLayoutChangeListener(onLayoutChangeListener2);
        }
    }

    public static void setBackground(View view, Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.setBackground(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }
}
