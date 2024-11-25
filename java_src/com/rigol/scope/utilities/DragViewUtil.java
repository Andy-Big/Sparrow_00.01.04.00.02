package com.rigol.scope.utilities;

import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import com.blankj.utilcode.util.LogUtils;
import com.rigol.scope.views.baseview.BasePopupView;
import timber.log.Timber;
/* loaded from: classes2.dex */
public class DragViewUtil {

    /* loaded from: classes2.dex */
    public interface Callback {
        void onMove(float f);
    }

    /* loaded from: classes2.dex */
    public interface Callback2 {
        void onMoveEnd();

        void onMovePoint(PointF pointF, float f, float f2);

        void onMoveStart();
    }

    public static void dragX(View view) {
        view.setOnTouchListener(new XTouchListener(null));
    }

    public static void dragX(View view, Callback callback) {
        view.setOnTouchListener(new XTouchListener(callback));
    }

    public static void dragY(View view) {
        view.setOnTouchListener(new YTouchListener(null));
    }

    public static void dragY(View view, Callback callback) {
        view.setOnTouchListener(new YTouchListener(callback));
    }

    public static void drag(View view, View view2, Callback2 callback2) {
        view.setOnTouchListener(new TouchListener(view2, callback2));
    }

    /* loaded from: classes2.dex */
    private static class TouchListener implements View.OnTouchListener {
        private final Callback2 callback2;
        private float downX;
        private float downY;
        private final View dragView;
        private int dragViewWidth;

        public TouchListener(View view, Callback2 callback2) {
            this.dragView = view;
            this.callback2 = callback2;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (view.isEnabled() && this.dragView != null) {
                Timber.d("e:" + motionEvent.toString() + ", v:" + this.dragView.toString(), new Object[0]);
                int action = motionEvent.getAction();
                if (action == 0) {
                    this.downX = motionEvent.getX();
                    this.downY = motionEvent.getY();
                    Callback2 callback2 = this.callback2;
                    if (callback2 != null) {
                        callback2.onMoveStart();
                    }
                    this.dragViewWidth = this.dragView.getWidth();
                } else if (action == 1) {
                    view.performClick();
                    Callback2 callback22 = this.callback2;
                    if (callback22 != null) {
                        callback22.onMoveEnd();
                    }
                } else if (action == 2) {
                    float x = motionEvent.getX() - this.downX;
                    float y = motionEvent.getY() - this.downY;
                    Timber.d("xDistance:" + x + ", yDistance:" + y, new Object[0]);
                    if (x != 0.0f && y != 0.0f) {
                        int top = (int) (this.dragView.getTop() + y);
                        this.dragView.layout((int) (this.dragView.getLeft() + x), top, (int) (this.dragView.getLeft() + this.dragViewWidth + x), (int) (this.dragView.getBottom() + y));
                    }
                    Callback2 callback23 = this.callback2;
                    if (callback23 != null) {
                        callback23.onMovePoint(new PointF(motionEvent.getRawX(), motionEvent.getRawY()), x, y);
                    }
                }
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes2.dex */
    private static class XTouchListener implements View.OnTouchListener {
        private final Callback callback;
        private float downX;
        private float downY;
        private float left;

        private XTouchListener(Callback callback) {
            this.callback = callback;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (view.isEnabled()) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    this.left = view.getLeft();
                    this.downX = motionEvent.getX();
                    this.downY = motionEvent.getY();
                } else if (action == 1) {
                    view.setPressed(false);
                    if (motionEvent.getY() == this.downY && motionEvent.getX() == this.downX) {
                        view.performClick();
                    }
                    Callback callback = this.callback;
                    if (callback != null) {
                        callback.onMove(view.getLeft() - this.left);
                    }
                } else if (action == 2) {
                    float x = motionEvent.getX() - this.downX;
                    float y = motionEvent.getY() - this.downY;
                    if (x != 0.0f && y != 0.0f) {
                        view.layout((int) (view.getLeft() + x), view.getTop(), (int) (view.getRight() + x), view.getBottom());
                    }
                } else if (action == 3) {
                    view.setPressed(false);
                }
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes2.dex */
    private static class YTouchListener implements View.OnTouchListener {
        private final Callback callback;
        private float downX;
        private float downY;
        private float top;

        private YTouchListener(Callback callback) {
            this.callback = callback;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (view.isEnabled()) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    this.downX = motionEvent.getX();
                    this.downY = motionEvent.getY();
                    this.top = view.getTop();
                } else if (action == 1) {
                    view.setPressed(false);
                    if (motionEvent.getY() == this.downY && motionEvent.getX() == this.downX) {
                        view.performClick();
                    }
                    Callback callback = this.callback;
                    if (callback != null) {
                        callback.onMove(view.getTop() - this.top);
                    }
                } else if (action == 2) {
                    float x = motionEvent.getX() - this.downX;
                    float y = motionEvent.getY() - this.downY;
                    if (x != 0.0f && y != 0.0f) {
                        view.layout(view.getLeft(), (int) (view.getTop() + y), view.getRight(), (int) (view.getBottom() + y));
                    }
                } else if (action == 3) {
                    view.setPressed(false);
                }
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes2.dex */
    public static class PopupWindowTouchListener implements View.OnTouchListener {
        private float downX;
        private float downY;
        private boolean isAtLocation;
        private final int[] popupDownRect = new int[2];
        private final PopupWindow popupWindow;

        public PopupWindowTouchListener(PopupWindow popupWindow) {
            this.popupWindow = popupWindow;
        }

        public void setAtLocation(boolean z) {
            this.isAtLocation = z;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1) {
                    view.performClick();
                } else if (action == 2) {
                    float rawX = motionEvent.getRawX() - this.downX;
                    float rawY = motionEvent.getRawY() - this.downY;
                    if (this.isAtLocation) {
                        PopupWindow popupWindow = this.popupWindow;
                        if (popupWindow instanceof BasePopupView) {
                            int[] iArr = this.popupDownRect;
                            ((BasePopupView) popupWindow).updateLocation((int) (rawX + iArr[0]), (int) (rawY + iArr[1]));
                        }
                    } else if (this.popupWindow != null) {
                        LogUtils.e("offsetX", Float.valueOf(rawX), Float.valueOf(rawY));
                        this.popupWindow.update((int) rawX, (int) rawY, -1, -1, false);
                    }
                }
            } else if (this.isAtLocation) {
                PopupWindow popupWindow2 = this.popupWindow;
                if (popupWindow2 instanceof BasePopupView) {
                    ((BasePopupView) popupWindow2).updateOriginLocation();
                }
                this.downX = motionEvent.getRawX();
                this.downY = motionEvent.getRawY();
                this.popupWindow.getContentView().getLocationOnScreen(this.popupDownRect);
            } else {
                this.downX = motionEvent.getX();
                this.downY = motionEvent.getY();
            }
            return true;
        }
    }

    public static View findClosestChildUnder(ViewGroup viewGroup, int i, int i2) {
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount);
            if (i >= childAt.getLeft() && i < childAt.getRight() && i2 >= childAt.getTop() && i2 < childAt.getBottom() && (!(childAt instanceof ViewGroup) || (childAt = findClosestChildUnder((ViewGroup) childAt, i, i2)) != null)) {
                return childAt;
            }
        }
        return null;
    }
}
