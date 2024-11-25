package com.blankj.utilcode.util;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.SystemClock;
import android.util.Log;
import android.util.StateSet;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.blankj.utilcode.util.ShadowUtils;
/* loaded from: classes.dex */
public class ClickUtils {
    private static final long DEBOUNCING_DEFAULT_VALUE = 1000;
    private static final float PRESSED_BG_ALPHA_DEFAULT_VALUE = 0.9f;
    private static final int PRESSED_BG_ALPHA_STYLE = 4;
    private static final float PRESSED_BG_DARK_DEFAULT_VALUE = 0.9f;
    private static final int PRESSED_BG_DARK_STYLE = 5;
    private static final float PRESSED_VIEW_ALPHA_DEFAULT_VALUE = 0.8f;
    private static final int PRESSED_VIEW_ALPHA_SRC_TAG = -3;
    private static final int PRESSED_VIEW_ALPHA_TAG = -2;
    private static final float PRESSED_VIEW_SCALE_DEFAULT_VALUE = -0.06f;
    private static final int PRESSED_VIEW_SCALE_TAG = -1;
    private static final long TIP_DURATION = 2000;
    private static int sClickCount;
    private static long sLastClickMillis;

    /* loaded from: classes.dex */
    public interface Back2HomeFriendlyListener {
        public static final Back2HomeFriendlyListener DEFAULT = new Back2HomeFriendlyListener() { // from class: com.blankj.utilcode.util.ClickUtils.Back2HomeFriendlyListener.1
            @Override // com.blankj.utilcode.util.ClickUtils.Back2HomeFriendlyListener
            public void show(CharSequence charSequence, long j) {
                UtilsBridge.toastShowShort(charSequence);
            }

            @Override // com.blankj.utilcode.util.ClickUtils.Back2HomeFriendlyListener
            public void dismiss() {
                UtilsBridge.toastCancel();
            }
        };

        void dismiss();

        void show(CharSequence charSequence, long j);
    }

    private ClickUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static void applyPressedViewScale(View... viewArr) {
        applyPressedViewScale(viewArr, (float[]) null);
    }

    public static void applyPressedViewScale(View[] viewArr, float[] fArr) {
        if (viewArr == null || viewArr.length == 0) {
            return;
        }
        for (int i = 0; i < viewArr.length; i++) {
            if (fArr == null || i >= fArr.length) {
                applyPressedViewScale(viewArr[i], (float) PRESSED_VIEW_SCALE_DEFAULT_VALUE);
            } else {
                applyPressedViewScale(viewArr[i], fArr[i]);
            }
        }
    }

    public static void applyPressedViewScale(View view, float f) {
        if (view == null) {
            return;
        }
        view.setTag(-1, Float.valueOf(f));
        view.setClickable(true);
        view.setOnTouchListener(OnUtilsTouchListener.getInstance());
    }

    public static void applyPressedViewAlpha(View... viewArr) {
        applyPressedViewAlpha(viewArr, (float[]) null);
    }

    public static void applyPressedViewAlpha(View[] viewArr, float[] fArr) {
        if (viewArr == null || viewArr.length == 0) {
            return;
        }
        for (int i = 0; i < viewArr.length; i++) {
            if (fArr == null || i >= fArr.length) {
                applyPressedViewAlpha(viewArr[i], (float) PRESSED_VIEW_ALPHA_DEFAULT_VALUE);
            } else {
                applyPressedViewAlpha(viewArr[i], fArr[i]);
            }
        }
    }

    public static void applyPressedViewAlpha(View view, float f) {
        if (view == null) {
            return;
        }
        view.setTag(-2, Float.valueOf(f));
        view.setTag(-3, Float.valueOf(view.getAlpha()));
        view.setClickable(true);
        view.setOnTouchListener(OnUtilsTouchListener.getInstance());
    }

    public static void applyPressedBgAlpha(View view) {
        applyPressedBgAlpha(view, 0.9f);
    }

    public static void applyPressedBgAlpha(View view, float f) {
        applyPressedBgStyle(view, 4, f);
    }

    public static void applyPressedBgDark(View view) {
        applyPressedBgDark(view, 0.9f);
    }

    public static void applyPressedBgDark(View view, float f) {
        applyPressedBgStyle(view, 5, f);
    }

    private static void applyPressedBgStyle(View view, int i, float f) {
        if (view == null) {
            return;
        }
        Drawable background = view.getBackground();
        int i2 = -i;
        Object tag = view.getTag(i2);
        if (tag instanceof Drawable) {
            ViewCompat.setBackground(view, (Drawable) tag);
            return;
        }
        Drawable createStyleDrawable = createStyleDrawable(background, i, f);
        ViewCompat.setBackground(view, createStyleDrawable);
        view.setTag(i2, createStyleDrawable);
    }

    private static Drawable createStyleDrawable(Drawable drawable, int i, float f) {
        if (drawable == null) {
            drawable = new ColorDrawable(0);
        }
        if (drawable.getConstantState() == null) {
            return drawable;
        }
        Drawable mutate = drawable.getConstantState().newDrawable().mutate();
        if (i == 4) {
            mutate = createAlphaDrawable(mutate, f);
        } else if (i == 5) {
            mutate = createDarkDrawable(mutate, f);
        }
        Drawable createAlphaDrawable = createAlphaDrawable(drawable.getConstantState().newDrawable().mutate(), 0.5f);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842919}, mutate);
        stateListDrawable.addState(new int[]{-16842910}, createAlphaDrawable);
        stateListDrawable.addState(StateSet.WILD_CARD, drawable);
        return stateListDrawable;
    }

    private static Drawable createAlphaDrawable(Drawable drawable, float f) {
        ClickDrawableWrapper clickDrawableWrapper = new ClickDrawableWrapper(drawable);
        clickDrawableWrapper.setAlpha((int) (f * 255.0f));
        return clickDrawableWrapper;
    }

    private static Drawable createDarkDrawable(Drawable drawable, float f) {
        ClickDrawableWrapper clickDrawableWrapper = new ClickDrawableWrapper(drawable);
        clickDrawableWrapper.setColorFilter(getDarkColorFilter(f));
        return clickDrawableWrapper;
    }

    private static ColorMatrixColorFilter getDarkColorFilter(float f) {
        return new ColorMatrixColorFilter(new ColorMatrix(new float[]{f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 2.0f, 0.0f}));
    }

    public static void applySingleDebouncing(View view, View.OnClickListener onClickListener) {
        applySingleDebouncing(new View[]{view}, onClickListener);
    }

    public static void applySingleDebouncing(View view, long j, View.OnClickListener onClickListener) {
        applySingleDebouncing(new View[]{view}, j, onClickListener);
    }

    public static void applySingleDebouncing(View[] viewArr, View.OnClickListener onClickListener) {
        applySingleDebouncing(viewArr, 1000L, onClickListener);
    }

    public static void applySingleDebouncing(View[] viewArr, long j, View.OnClickListener onClickListener) {
        applyDebouncing(viewArr, false, j, onClickListener);
    }

    public static void applyGlobalDebouncing(View view, View.OnClickListener onClickListener) {
        applyGlobalDebouncing(new View[]{view}, onClickListener);
    }

    public static void applyGlobalDebouncing(View view, long j, View.OnClickListener onClickListener) {
        applyGlobalDebouncing(new View[]{view}, j, onClickListener);
    }

    public static void applyGlobalDebouncing(View[] viewArr, View.OnClickListener onClickListener) {
        applyGlobalDebouncing(viewArr, 1000L, onClickListener);
    }

    public static void applyGlobalDebouncing(View[] viewArr, long j, View.OnClickListener onClickListener) {
        applyDebouncing(viewArr, true, j, onClickListener);
    }

    private static void applyDebouncing(View[] viewArr, boolean z, long j, final View.OnClickListener onClickListener) {
        if (viewArr == null || viewArr.length == 0 || onClickListener == null) {
            return;
        }
        for (View view : viewArr) {
            if (view != null) {
                view.setOnClickListener(new OnDebouncingClickListener(z, j) { // from class: com.blankj.utilcode.util.ClickUtils.1
                    @Override // com.blankj.utilcode.util.ClickUtils.OnDebouncingClickListener
                    public void onDebouncingClick(View view2) {
                        onClickListener.onClick(view2);
                    }
                });
            }
        }
    }

    public static void expandClickArea(View view, int i) {
        if (view == null) {
            throw new NullPointerException("Argument 'view' of type View (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        expandClickArea(view, i, i, i, i);
    }

    public static void expandClickArea(final View view, final int i, final int i2, final int i3, final int i4) {
        if (view == null) {
            throw new NullPointerException("Argument 'view' of type View (#0 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        final View view2 = (View) view.getParent();
        if (view2 == null) {
            Log.e("ClickUtils", "expandClickArea must have parent view.");
        } else {
            view2.post(new Runnable() { // from class: com.blankj.utilcode.util.ClickUtils.2
                @Override // java.lang.Runnable
                public void run() {
                    Rect rect = new Rect();
                    view.getHitRect(rect);
                    rect.top -= i;
                    rect.bottom += i4;
                    rect.left -= i2;
                    rect.right += i3;
                    view2.setTouchDelegate(new TouchDelegate(rect, view));
                }
            });
        }
    }

    public static void back2HomeFriendly(CharSequence charSequence) {
        back2HomeFriendly(charSequence, TIP_DURATION, Back2HomeFriendlyListener.DEFAULT);
    }

    public static void back2HomeFriendly(CharSequence charSequence, long j, Back2HomeFriendlyListener back2HomeFriendlyListener) {
        if (charSequence == null) {
            throw new NullPointerException("Argument 'tip' of type CharSequence (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        if (back2HomeFriendlyListener == null) {
            throw new NullPointerException("Argument 'listener' of type Back2HomeFriendlyListener (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (Math.abs(elapsedRealtime - sLastClickMillis) < j) {
            int i = sClickCount + 1;
            sClickCount = i;
            if (i == 2) {
                UtilsBridge.startHomeActivity();
                back2HomeFriendlyListener.dismiss();
                sLastClickMillis = 0L;
                return;
            }
            return;
        }
        sClickCount = 1;
        back2HomeFriendlyListener.show(charSequence, j);
        sLastClickMillis = elapsedRealtime;
    }

    /* loaded from: classes.dex */
    public static abstract class OnDebouncingClickListener implements View.OnClickListener {
        private static final Runnable ENABLE_AGAIN = new Runnable() { // from class: com.blankj.utilcode.util.ClickUtils.OnDebouncingClickListener.1
            @Override // java.lang.Runnable
            public void run() {
                boolean unused = OnDebouncingClickListener.mEnabled = true;
            }
        };
        private static boolean mEnabled = true;
        private long mDuration;
        private boolean mIsGlobal;

        public abstract void onDebouncingClick(View view);

        private static boolean isValid(View view, long j) {
            if (view == null) {
                throw new NullPointerException("Argument 'view' of type View (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            }
            return UtilsBridge.isValid(view, j);
        }

        public OnDebouncingClickListener() {
            this(true, 1000L);
        }

        public OnDebouncingClickListener(boolean z) {
            this(z, 1000L);
        }

        public OnDebouncingClickListener(long j) {
            this(true, j);
        }

        public OnDebouncingClickListener(boolean z, long j) {
            this.mIsGlobal = z;
            this.mDuration = j;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (this.mIsGlobal) {
                if (mEnabled) {
                    mEnabled = false;
                    view.postDelayed(ENABLE_AGAIN, this.mDuration);
                    onDebouncingClick(view);
                }
            } else if (isValid(view, this.mDuration)) {
                onDebouncingClick(view);
            }
        }
    }

    /* loaded from: classes.dex */
    public static abstract class OnMultiClickListener implements View.OnClickListener {
        private static final long INTERVAL_DEFAULT_VALUE = 666;
        private int mClickCount;
        private final long mClickInterval;
        private long mLastClickTime;
        private final int mTriggerClickCount;

        public abstract void onBeforeTriggerClick(View view, int i);

        public abstract void onTriggerClick(View view);

        public OnMultiClickListener(int i) {
            this(i, INTERVAL_DEFAULT_VALUE);
        }

        public OnMultiClickListener(int i, long j) {
            this.mTriggerClickCount = i;
            this.mClickInterval = j;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.mTriggerClickCount <= 1) {
                onTriggerClick(view);
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.mLastClickTime < this.mClickInterval) {
                int i = this.mClickCount + 1;
                this.mClickCount = i;
                int i2 = this.mTriggerClickCount;
                if (i == i2) {
                    onTriggerClick(view);
                } else if (i < i2) {
                    onBeforeTriggerClick(view, i);
                } else {
                    this.mClickCount = 1;
                    onBeforeTriggerClick(view, 1);
                }
            } else {
                this.mClickCount = 1;
                onBeforeTriggerClick(view, 1);
            }
            this.mLastClickTime = currentTimeMillis;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class OnUtilsTouchListener implements View.OnTouchListener {
        public static OnUtilsTouchListener getInstance() {
            return LazyHolder.INSTANCE;
        }

        private OnUtilsTouchListener() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                processScale(view, true);
                processAlpha(view, true);
            } else if (action == 1 || action == 3) {
                processScale(view, false);
                processAlpha(view, false);
            }
            return false;
        }

        private void processScale(View view, boolean z) {
            Object tag = view.getTag(-1);
            if (tag instanceof Float) {
                float floatValue = z ? 1.0f + ((Float) tag).floatValue() : 1.0f;
                view.animate().scaleX(floatValue).scaleY(floatValue).setDuration(200L).start();
            }
        }

        private void processAlpha(View view, boolean z) {
            Object tag = view.getTag(z ? -2 : -3);
            if (tag instanceof Float) {
                view.setAlpha(((Float) tag).floatValue());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static class LazyHolder {
            private static final OnUtilsTouchListener INSTANCE = new OnUtilsTouchListener();

            private LazyHolder() {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class ClickDrawableWrapper extends ShadowUtils.DrawableWrapper {
        private BitmapDrawable mBitmapDrawable;
        private Paint mColorPaint;

        public ClickDrawableWrapper(Drawable drawable) {
            super(drawable);
            this.mBitmapDrawable = null;
            this.mColorPaint = null;
            if (drawable instanceof ColorDrawable) {
                Paint paint = new Paint(5);
                this.mColorPaint = paint;
                paint.setColor(((ColorDrawable) drawable).getColor());
            }
        }

        @Override // com.blankj.utilcode.util.ShadowUtils.DrawableWrapper, android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter colorFilter) {
            Paint paint;
            super.setColorFilter(colorFilter);
            if (Build.VERSION.SDK_INT >= 21 || (paint = this.mColorPaint) == null) {
                return;
            }
            paint.setColorFilter(colorFilter);
        }

        @Override // com.blankj.utilcode.util.ShadowUtils.DrawableWrapper, android.graphics.drawable.Drawable
        public void setAlpha(int i) {
            Paint paint;
            super.setAlpha(i);
            if (Build.VERSION.SDK_INT >= 21 || (paint = this.mColorPaint) == null) {
                return;
            }
            paint.setColor(((ColorDrawable) getWrappedDrawable()).getColor());
        }

        @Override // com.blankj.utilcode.util.ShadowUtils.DrawableWrapper, android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            if (this.mBitmapDrawable == null) {
                Bitmap createBitmap = Bitmap.createBitmap(getBounds().width(), getBounds().height(), Bitmap.Config.ARGB_8888);
                Canvas canvas2 = new Canvas(createBitmap);
                if (this.mColorPaint != null) {
                    canvas2.drawRect(getBounds(), this.mColorPaint);
                } else {
                    super.draw(canvas2);
                }
                BitmapDrawable bitmapDrawable = new BitmapDrawable(Resources.getSystem(), createBitmap);
                this.mBitmapDrawable = bitmapDrawable;
                bitmapDrawable.setBounds(getBounds());
            }
            this.mBitmapDrawable.draw(canvas);
        }
    }
}
