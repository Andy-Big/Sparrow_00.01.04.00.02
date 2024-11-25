package com.blankj.utilcode.util;

import android.os.Build;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.snackbar.Snackbar;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public final class SnackbarUtils {
    private static final int COLOR_DEFAULT = -16777217;
    private static final int COLOR_ERROR = -65536;
    private static final int COLOR_MESSAGE = -1;
    private static final int COLOR_SUCCESS = -13912576;
    private static final int COLOR_WARNING = -16128;
    public static final int LENGTH_INDEFINITE = -2;
    public static final int LENGTH_LONG = 0;
    public static final int LENGTH_SHORT = -1;
    private static WeakReference<Snackbar> sReference;
    private View.OnClickListener actionListener;
    private CharSequence actionText;
    private int actionTextColor;
    private int bgColor;
    private int bgResource;
    private int bottomMargin;
    private int duration;
    private CharSequence message;
    private int messageColor;
    private View view;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface Duration {
    }

    private SnackbarUtils(View view) {
        setDefault();
        this.view = view;
    }

    private void setDefault() {
        this.message = "";
        this.messageColor = COLOR_DEFAULT;
        this.bgColor = COLOR_DEFAULT;
        this.bgResource = -1;
        this.duration = -1;
        this.actionText = "";
        this.actionTextColor = COLOR_DEFAULT;
        this.bottomMargin = 0;
    }

    public static SnackbarUtils with(View view) {
        if (view == null) {
            throw new NullPointerException("Argument 'view' of type View (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        return new SnackbarUtils(view);
    }

    public SnackbarUtils setMessage(CharSequence charSequence) {
        if (charSequence == null) {
            throw new NullPointerException("Argument 'msg' of type CharSequence (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        this.message = charSequence;
        return this;
    }

    public SnackbarUtils setMessageColor(int i) {
        this.messageColor = i;
        return this;
    }

    public SnackbarUtils setBgColor(int i) {
        this.bgColor = i;
        return this;
    }

    public SnackbarUtils setBgResource(int i) {
        this.bgResource = i;
        return this;
    }

    public SnackbarUtils setDuration(int i) {
        this.duration = i;
        return this;
    }

    public SnackbarUtils setAction(CharSequence charSequence, View.OnClickListener onClickListener) {
        if (charSequence != null) {
            if (onClickListener == null) {
                throw new NullPointerException("Argument 'listener' of type View.OnClickListener (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            }
            return setAction(charSequence, COLOR_DEFAULT, onClickListener);
        }
        throw new NullPointerException("Argument 'text' of type CharSequence (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    public SnackbarUtils setAction(CharSequence charSequence, int i, View.OnClickListener onClickListener) {
        if (charSequence != null) {
            if (onClickListener == null) {
                throw new NullPointerException("Argument 'listener' of type View.OnClickListener (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            }
            this.actionText = charSequence;
            this.actionTextColor = i;
            this.actionListener = onClickListener;
            return this;
        }
        throw new NullPointerException("Argument 'text' of type CharSequence (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    public SnackbarUtils setBottomMargin(int i) {
        this.bottomMargin = i;
        return this;
    }

    public Snackbar show() {
        return show(false);
    }

    public Snackbar show(boolean z) {
        View view = this.view;
        if (view == null) {
            return null;
        }
        if (z) {
            ViewGroup findSuitableParentCopyFromSnackbar = findSuitableParentCopyFromSnackbar(view);
            View findViewWithTag = findSuitableParentCopyFromSnackbar.findViewWithTag("topSnackBarCoordinatorLayout");
            CoordinatorLayout coordinatorLayout = findViewWithTag;
            if (findViewWithTag == null) {
                CoordinatorLayout coordinatorLayout2 = new CoordinatorLayout(view.getContext());
                coordinatorLayout2.setTag("topSnackBarCoordinatorLayout");
                coordinatorLayout2.setRotation(180.0f);
                if (Build.VERSION.SDK_INT >= 21) {
                    coordinatorLayout2.setElevation(100.0f);
                }
                findSuitableParentCopyFromSnackbar.addView(coordinatorLayout2, -1, -1);
                coordinatorLayout = coordinatorLayout2;
            }
            view = coordinatorLayout;
        }
        if (this.messageColor != COLOR_DEFAULT) {
            SpannableString spannableString = new SpannableString(this.message);
            spannableString.setSpan(new ForegroundColorSpan(this.messageColor), 0, spannableString.length(), 33);
            sReference = new WeakReference<>(Snackbar.make(view, spannableString, this.duration));
        } else {
            sReference = new WeakReference<>(Snackbar.make(view, this.message, this.duration));
        }
        Snackbar snackbar = sReference.get();
        Snackbar.SnackbarLayout snackbarLayout = (Snackbar.SnackbarLayout) snackbar.getView();
        if (z) {
            for (int i = 0; i < snackbarLayout.getChildCount(); i++) {
                snackbarLayout.getChildAt(i).setRotation(180.0f);
            }
        }
        int i2 = this.bgResource;
        if (i2 != -1) {
            snackbarLayout.setBackgroundResource(i2);
        } else {
            int i3 = this.bgColor;
            if (i3 != COLOR_DEFAULT) {
                snackbarLayout.setBackgroundColor(i3);
            }
        }
        if (this.bottomMargin != 0) {
            ((ViewGroup.MarginLayoutParams) snackbarLayout.getLayoutParams()).bottomMargin = this.bottomMargin;
        }
        if (this.actionText.length() > 0 && this.actionListener != null) {
            int i4 = this.actionTextColor;
            if (i4 != COLOR_DEFAULT) {
                snackbar.setActionTextColor(i4);
            }
            snackbar.setAction(this.actionText, this.actionListener);
        }
        snackbar.show();
        return snackbar;
    }

    public void showSuccess() {
        showSuccess(false);
    }

    public void showSuccess(boolean z) {
        this.bgColor = COLOR_SUCCESS;
        this.messageColor = -1;
        this.actionTextColor = -1;
        show(z);
    }

    public void showWarning() {
        showWarning(false);
    }

    public void showWarning(boolean z) {
        this.bgColor = COLOR_WARNING;
        this.messageColor = -1;
        this.actionTextColor = -1;
        show(z);
    }

    public void showError() {
        showError(false);
    }

    public void showError(boolean z) {
        this.bgColor = -65536;
        this.messageColor = -1;
        this.actionTextColor = -1;
        show(z);
    }

    public static void dismiss() {
        WeakReference<Snackbar> weakReference = sReference;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        sReference.get().dismiss();
        sReference = null;
    }

    public static View getView() {
        Snackbar snackbar = sReference.get();
        if (snackbar == null) {
            return null;
        }
        return snackbar.getView();
    }

    public static void addView(int i, ViewGroup.LayoutParams layoutParams) {
        if (layoutParams == null) {
            throw new NullPointerException("Argument 'params' of type ViewGroup.LayoutParams (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        View view = getView();
        if (view != null) {
            view.setPadding(0, 0, 0, 0);
            ((Snackbar.SnackbarLayout) view).addView(LayoutInflater.from(view.getContext()).inflate(i, (ViewGroup) null), -1, layoutParams);
        }
    }

    public static void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (view == null) {
            throw new NullPointerException("Argument 'child' of type View (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        if (layoutParams == null) {
            throw new NullPointerException("Argument 'params' of type ViewGroup.LayoutParams (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        View view2 = getView();
        if (view2 != null) {
            view2.setPadding(0, 0, 0, 0);
            ((Snackbar.SnackbarLayout) view2).addView(view, layoutParams);
        }
    }

    private static ViewGroup findSuitableParentCopyFromSnackbar(View view) {
        ViewGroup viewGroup = null;
        while (!(view instanceof CoordinatorLayout)) {
            if (view instanceof FrameLayout) {
                if (view.getId() == 16908290) {
                    return (ViewGroup) view;
                }
                viewGroup = (ViewGroup) view;
            }
            if (view != null) {
                ViewParent parent = view.getParent();
                if (parent instanceof View) {
                    view = (View) parent;
                    continue;
                } else {
                    view = null;
                    continue;
                }
            }
            if (view == null) {
                return viewGroup;
            }
        }
        return (ViewGroup) view;
    }
}
