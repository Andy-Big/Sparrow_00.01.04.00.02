package com.blankj.utilcode.util;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public class TouchUtils {
    public static final int DOWN = 8;
    public static final int LEFT = 1;
    public static final int RIGHT = 4;
    public static final int UNKNOWN = 0;
    public static final int UP = 2;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface Direction {
    }

    private TouchUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static void setOnTouchListener(View view, OnTouchUtilsListener onTouchUtilsListener) {
        if (view == null || onTouchUtilsListener == null) {
            return;
        }
        view.setOnTouchListener(onTouchUtilsListener);
    }

    /* loaded from: classes.dex */
    public static abstract class OnTouchUtilsListener implements View.OnTouchListener {
        private static final int MIN_TAP_TIME = 1000;
        private static final int STATE_DOWN = 0;
        private static final int STATE_MOVE = 1;
        private static final int STATE_STOP = 2;
        private int direction;
        private int downX;
        private int downY;
        private int lastX;
        private int lastY;
        private int maximumFlingVelocity;
        private int minimumFlingVelocity;
        private int state;
        private int touchSlop;
        private VelocityTracker velocityTracker;

        public abstract boolean onDown(View view, int i, int i2, MotionEvent motionEvent);

        public abstract boolean onMove(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, MotionEvent motionEvent);

        public abstract boolean onStop(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, MotionEvent motionEvent);

        public OnTouchUtilsListener() {
            resetTouch(-1, -1);
        }

        private void resetTouch(int i, int i2) {
            this.downX = i;
            this.downY = i2;
            this.lastX = i;
            this.lastY = i2;
            this.state = 0;
            this.direction = 0;
            VelocityTracker velocityTracker = this.velocityTracker;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (this.touchSlop == 0) {
                this.touchSlop = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
            }
            if (this.maximumFlingVelocity == 0) {
                this.maximumFlingVelocity = ViewConfiguration.get(view.getContext()).getScaledMaximumFlingVelocity();
            }
            if (this.minimumFlingVelocity == 0) {
                this.minimumFlingVelocity = ViewConfiguration.get(view.getContext()).getScaledMinimumFlingVelocity();
            }
            if (this.velocityTracker == null) {
                this.velocityTracker = VelocityTracker.obtain();
            }
            this.velocityTracker.addMovement(motionEvent);
            int action = motionEvent.getAction();
            if (action == 0) {
                return onUtilsDown(view, motionEvent);
            }
            if (action != 1) {
                if (action == 2) {
                    return onUtilsMove(view, motionEvent);
                }
                if (action != 3) {
                    return false;
                }
            }
            return onUtilsStop(view, motionEvent);
        }

        public boolean onUtilsDown(View view, MotionEvent motionEvent) {
            int rawX = (int) motionEvent.getRawX();
            int rawY = (int) motionEvent.getRawY();
            resetTouch(rawX, rawY);
            view.setPressed(true);
            return onDown(view, rawX, rawY, motionEvent);
        }

        public boolean onUtilsMove(View view, MotionEvent motionEvent) {
            int rawX = (int) motionEvent.getRawX();
            int rawY = (int) motionEvent.getRawY();
            if (this.downX == -1) {
                resetTouch(rawX, rawY);
                view.setPressed(true);
            }
            if (this.state != 1) {
                if (Math.abs(rawX - this.lastX) < this.touchSlop && Math.abs(rawY - this.lastY) < this.touchSlop) {
                    return true;
                }
                this.state = 1;
                if (Math.abs(rawX - this.lastX) >= Math.abs(rawY - this.lastY)) {
                    if (rawX - this.lastX < 0) {
                        this.direction = 1;
                    } else {
                        this.direction = 4;
                    }
                } else if (rawY - this.lastY < 0) {
                    this.direction = 2;
                } else {
                    this.direction = 8;
                }
            }
            boolean onMove = onMove(view, this.direction, rawX, rawY, rawX - this.lastX, rawY - this.lastY, rawX - this.downX, rawY - this.downY, motionEvent);
            this.lastX = rawX;
            this.lastY = rawY;
            return onMove;
        }

        public boolean onUtilsStop(View view, MotionEvent motionEvent) {
            int i;
            int i2;
            int rawX = (int) motionEvent.getRawX();
            int rawY = (int) motionEvent.getRawY();
            VelocityTracker velocityTracker = this.velocityTracker;
            if (velocityTracker != null) {
                velocityTracker.computeCurrentVelocity(1000, this.maximumFlingVelocity);
                int xVelocity = (int) this.velocityTracker.getXVelocity();
                int yVelocity = (int) this.velocityTracker.getYVelocity();
                this.velocityTracker.recycle();
                if (Math.abs(xVelocity) < this.minimumFlingVelocity) {
                    xVelocity = 0;
                }
                if (Math.abs(yVelocity) < this.minimumFlingVelocity) {
                    yVelocity = 0;
                }
                this.velocityTracker = null;
                i = xVelocity;
                i2 = yVelocity;
            } else {
                i = 0;
                i2 = 0;
            }
            view.setPressed(false);
            boolean onStop = onStop(view, this.direction, rawX, rawY, rawX - this.downX, rawY - this.downY, i, i2, motionEvent);
            if (motionEvent.getAction() == 1 && this.state == 0) {
                if (motionEvent.getEventTime() - motionEvent.getDownTime() <= 1000) {
                    view.performClick();
                } else {
                    view.performLongClick();
                }
            }
            resetTouch(-1, -1);
            return onStop;
        }
    }
}
