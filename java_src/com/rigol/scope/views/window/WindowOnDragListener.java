package com.rigol.scope.views.window;

import android.view.DragEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.app.NotificationCompat;
import com.rigol.scope.views.multi.MultiWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: WindowOnDragListener.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001c\u0010\u0017\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u00122\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u001a\u0010\u001b\u001a\u00020\u001c2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0012\u0010\u001d\u001a\u00020\u001c2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0012H\u0002R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u001e"}, d2 = {"Lcom/rigol/scope/views/window/WindowOnDragListener;", "Landroid/view/View$OnDragListener;", "hideWindowWhenDragging", "", "(Z)V", "direction", "Lcom/rigol/scope/views/window/WindowDirection;", "getDirection", "()Lcom/rigol/scope/views/window/WindowDirection;", "setDirection", "(Lcom/rigol/scope/views/window/WindowDirection;)V", "result", "", "getResult", "()I", "setResult", "(I)V", "target", "Landroid/view/View;", "getTarget", "()Landroid/view/View;", "setTarget", "(Landroid/view/View;)V", "onDrag", "v", NotificationCompat.CATEGORY_EVENT, "Landroid/view/DragEvent;", "refreshShadow", "", "resetShadow", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public class WindowOnDragListener implements View.OnDragListener {
    private WindowDirection direction;
    private final boolean hideWindowWhenDragging;
    private int result = 4;
    private View target;

    public WindowOnDragListener(boolean z) {
        this.hideWindowWhenDragging = z;
    }

    public final View getTarget() {
        return this.target;
    }

    public final void setTarget(View view) {
        this.target = view;
    }

    public final WindowDirection getDirection() {
        return this.direction;
    }

    public final void setDirection(WindowDirection windowDirection) {
        this.direction = windowDirection;
    }

    public final int getResult() {
        return this.result;
    }

    public final void setResult(int i) {
        this.result = i;
    }

    @Override // android.view.View.OnDragListener
    public boolean onDrag(View view, DragEvent dragEvent) {
        ViewParent parent;
        if (dragEvent != null) {
            switch (dragEvent.getAction()) {
                case 1:
                    if (Intrinsics.areEqual(dragEvent.getLocalState(), view) && this.hideWindowWhenDragging && view != null) {
                        view.setVisibility(4);
                        break;
                    }
                    break;
                case 2:
                    if ((!Intrinsics.areEqual(dragEvent.getLocalState(), view)) && this.target != null) {
                        refreshShadow(view, dragEvent);
                        break;
                    }
                    break;
                case 3:
                    if ((!Intrinsics.areEqual(dragEvent.getLocalState(), view)) && this.target != null && view != null && (parent = view.getParent()) != null && (parent instanceof MultiWindow)) {
                        Object localState = dragEvent.getLocalState();
                        if (localState != null) {
                            MultiWindow multiWindow = (MultiWindow) parent;
                            if (localState == null) {
                                throw new NullPointerException("null cannot be cast to non-null type android.view.View");
                            }
                            View view2 = (View) localState;
                            multiWindow.removeWindow(view2, false);
                            multiWindow.addWindow(view2, this.target, this.direction, false);
                        }
                        resetShadow(view);
                        break;
                    }
                    break;
                case 4:
                    if (Intrinsics.areEqual(dragEvent.getLocalState(), view) && this.hideWindowWhenDragging && view != null) {
                        view.setVisibility(0);
                        break;
                    }
                    break;
                case 5:
                    if (!Intrinsics.areEqual(dragEvent.getLocalState(), view)) {
                        this.target = view;
                        break;
                    }
                    break;
                case 6:
                    resetShadow(view);
                    break;
            }
            this.result = dragEvent.getAction();
        }
        return true;
    }

    private final void resetShadow(View view) {
        ViewParent parent;
        this.target = null;
        this.direction = null;
        if (view == null || (parent = view.getParent()) == null || !(parent instanceof ViewGroup)) {
            return;
        }
        ((ViewGroup) parent).invalidate();
    }

    private final void refreshShadow(View view, DragEvent dragEvent) {
        WindowDirection windowDirection;
        ViewParent parent;
        WindowDirection windowDirection2;
        View view2 = this.target;
        if (view2 != null) {
            int left = view2.getLeft();
            int top = view2.getTop();
            int right = view2.getRight();
            float x = dragEvent.getX() + view2.getLeft();
            float y = dragEvent.getY() + view2.getTop();
            float f = (left + right) / 2;
            float bottom = (top + view2.getBottom()) / 2;
            if (Math.abs(x - f) > Math.abs(y - bottom)) {
                if (x < f) {
                    windowDirection2 = WindowDirection.START;
                } else {
                    windowDirection2 = WindowDirection.END;
                }
                this.direction = windowDirection2;
            } else {
                if (y < bottom) {
                    windowDirection = WindowDirection.TOP;
                } else {
                    windowDirection = WindowDirection.BOTTOM;
                }
                this.direction = windowDirection;
            }
            if (view == null || (parent = view.getParent()) == null || !(parent instanceof ViewGroup)) {
                return;
            }
            ((ViewGroup) parent).invalidate();
        }
    }
}
