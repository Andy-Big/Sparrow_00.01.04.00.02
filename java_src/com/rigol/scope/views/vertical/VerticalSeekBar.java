package com.rigol.scope.views.vertical;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.core.view.ViewCompat;
import com.rigol.scope.R;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes2.dex */
public class VerticalSeekBar extends AppCompatSeekBar {
    public static final int ROTATION_ANGLE_CW_270 = 270;
    public static final int ROTATION_ANGLE_CW_90 = 90;
    private boolean mIsDragging;
    private Method mMethodSetProgressFromUser;
    private int mRotationAngle;
    private Drawable mThumb_;

    private static boolean isValidRotationAngle(int i) {
        return i == 90 || i == 270;
    }

    public VerticalSeekBar(Context context) {
        super(context);
        this.mRotationAngle = 90;
        initialize(context, null, 0, 0);
    }

    public VerticalSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRotationAngle = 90;
        initialize(context, attributeSet, 0, 0);
    }

    public VerticalSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRotationAngle = 90;
        initialize(context, attributeSet, i, 0);
    }

    private void initialize(Context context, AttributeSet attributeSet, int i, int i2) {
        ViewCompat.setLayoutDirection(this, 0);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.VerticalSeekBar, i, i2);
            int integer = obtainStyledAttributes.getInteger(0, 0);
            if (isValidRotationAngle(integer)) {
                this.mRotationAngle = integer;
            }
            obtainStyledAttributes.recycle();
        }
    }

    @Override // android.widget.AbsSeekBar
    public void setThumb(Drawable drawable) {
        this.mThumb_ = drawable;
        super.setThumb(drawable);
    }

    @Override // android.widget.AbsSeekBar, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (useViewRotation()) {
            return onTouchEventUseViewRotation(motionEvent);
        }
        return onTouchEventTraditionalRotation(motionEvent);
    }

    private boolean onTouchEventTraditionalRotation(MotionEvent motionEvent) {
        if (isEnabled()) {
            int action = motionEvent.getAction();
            if (action == 0) {
                setPressed(true);
                onStartTrackingTouch();
                trackTouchEvent(motionEvent);
                attemptClaimDrag(true);
                invalidate();
            } else if (action == 1) {
                if (this.mIsDragging) {
                    trackTouchEvent(motionEvent);
                    onStopTrackingTouch();
                    setPressed(false);
                } else {
                    onStartTrackingTouch();
                    trackTouchEvent(motionEvent);
                    onStopTrackingTouch();
                    attemptClaimDrag(false);
                }
                invalidate();
            } else if (action != 2) {
                if (action == 3) {
                    if (this.mIsDragging) {
                        onStopTrackingTouch();
                        setPressed(false);
                    }
                    invalidate();
                }
            } else if (this.mIsDragging) {
                trackTouchEvent(motionEvent);
            }
            return true;
        }
        return false;
    }

    private boolean onTouchEventUseViewRotation(MotionEvent motionEvent) {
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        if (onTouchEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                attemptClaimDrag(true);
            } else if (action == 1 || action == 3) {
                attemptClaimDrag(false);
            }
        }
        return onTouchEvent;
    }

    private void trackTouchEvent(MotionEvent motionEvent) {
        int height;
        int paddingLeft = super.getPaddingLeft();
        int paddingRight = super.getPaddingRight();
        int height2 = (getHeight() - paddingLeft) - paddingRight;
        int y = (int) motionEvent.getY();
        int i = this.mRotationAngle;
        float f = 0.0f;
        float f2 = i != 90 ? i != 270 ? 0.0f : height - y : y - paddingLeft;
        if (f2 >= 0.0f && height2 != 0) {
            float f3 = height2;
            f = f2 > f3 ? 1.0f : f2 / f3;
        }
        _setProgressFromUser((int) (f * getMax()), true);
    }

    private void attemptClaimDrag(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    private void onStartTrackingTouch() {
        this.mIsDragging = true;
    }

    private void onStopTrackingTouch() {
        this.mIsDragging = false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001a, code lost:
        if (r4.mRotationAngle == 270) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x001c, code lost:
        r0 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x001d, code lost:
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0013, code lost:
        if (r4.mRotationAngle == 90) goto L18;
     */
    @Override // android.widget.AbsSeekBar, android.view.View, android.view.KeyEvent.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onKeyDown(int r5, android.view.KeyEvent r6) {
        /*
            r4 = this;
            boolean r0 = r4.isEnabled()
            if (r0 == 0) goto L36
            r0 = -1
            r1 = 0
            r2 = 1
            switch(r5) {
                case 19: goto L16;
                case 20: goto Lf;
                case 21: goto Le;
                case 22: goto Le;
                default: goto Lc;
            }
        Lc:
            r0 = r1
            goto L1e
        Le:
            return r1
        Lf:
            int r1 = r4.mRotationAngle
            r3 = 90
            if (r1 != r3) goto L1d
            goto L1c
        L16:
            int r1 = r4.mRotationAngle
            r3 = 270(0x10e, float:3.78E-43)
            if (r1 != r3) goto L1d
        L1c:
            r0 = r2
        L1d:
            r1 = r2
        L1e:
            if (r1 == 0) goto L36
            int r5 = r4.getKeyProgressIncrement()
            int r6 = r4.getProgress()
            int r0 = r0 * r5
            int r6 = r6 + r0
            if (r6 < 0) goto L35
            int r5 = r4.getMax()
            if (r6 > r5) goto L35
            r4._setProgressFromUser(r6, r2)
        L35:
            return r2
        L36:
            boolean r5 = super.onKeyDown(r5, r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rigol.scope.views.vertical.VerticalSeekBar.onKeyDown(int, android.view.KeyEvent):boolean");
    }

    @Override // android.widget.ProgressBar
    public synchronized void setProgress(int i) {
        super.setProgress(i);
        if (!useViewRotation()) {
            refreshThumb();
        }
    }

    private synchronized void _setProgressFromUser(int i, boolean z) {
        if (this.mMethodSetProgressFromUser == null) {
            try {
                Method declaredMethod = ProgressBar.class.getDeclaredMethod("setProgress", Integer.TYPE, Boolean.TYPE);
                declaredMethod.setAccessible(true);
                this.mMethodSetProgressFromUser = declaredMethod;
            } catch (NoSuchMethodException unused) {
            }
        }
        if (this.mMethodSetProgressFromUser != null) {
            try {
                this.mMethodSetProgressFromUser.invoke(this, Integer.valueOf(i), Boolean.valueOf(z));
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused2) {
            }
        } else {
            super.setProgress(i);
        }
        refreshThumb();
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected synchronized void onMeasure(int i, int i2) {
        if (useViewRotation()) {
            super.onMeasure(i, i2);
        } else {
            super.onMeasure(i2, i);
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (isInEditMode() && layoutParams != null && layoutParams.height >= 0) {
                setMeasuredDimension(super.getMeasuredHeight(), layoutParams.height);
            } else {
                setMeasuredDimension(super.getMeasuredHeight(), super.getMeasuredWidth());
            }
        }
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        if (useViewRotation()) {
            super.onSizeChanged(i, i2, i3, i4);
        } else {
            super.onSizeChanged(i2, i, i4, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.AppCompatSeekBar, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public synchronized void onDraw(Canvas canvas) {
        if (!useViewRotation()) {
            int i = this.mRotationAngle;
            if (i == 90) {
                canvas.rotate(90.0f);
                canvas.translate(0.0f, -super.getWidth());
            } else if (i == 270) {
                canvas.rotate(-90.0f);
                canvas.translate(-super.getHeight(), 0.0f);
            }
        }
        super.onDraw(canvas);
    }

    public int getRotationAngle() {
        return this.mRotationAngle;
    }

    public void setRotationAngle(int i) {
        if (!isValidRotationAngle(i)) {
            throw new IllegalArgumentException("Invalid angle specified :" + i);
        } else if (this.mRotationAngle == i) {
        } else {
            this.mRotationAngle = i;
            if (useViewRotation()) {
                VerticalSeekBarWrapper wrapper = getWrapper();
                if (wrapper != null) {
                    wrapper.applyViewRotation();
                    return;
                }
                return;
            }
            requestLayout();
        }
    }

    private void refreshThumb() {
        onSizeChanged(super.getWidth(), super.getHeight(), 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean useViewRotation() {
        return !isInEditMode();
    }

    private VerticalSeekBarWrapper getWrapper() {
        ViewParent parent = getParent();
        if (parent instanceof VerticalSeekBarWrapper) {
            return (VerticalSeekBarWrapper) parent;
        }
        return null;
    }
}
