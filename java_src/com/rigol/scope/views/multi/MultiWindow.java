package com.rigol.scope.views.multi;

import android.content.ClipData;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.customview.widget.ViewDragHelper;
import com.rigol.scope.R;
import com.rigol.scope.data.TwoTuple;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.viewmodels.SharedViewModel;
import com.rigol.scope.views.window.Window;
import com.rigol.scope.views.window.WindowDirection;
import com.rigol.scope.views.window.WindowDragShadowBuilder;
import com.rigol.scope.views.window.WindowHolder;
import com.rigol.scope.views.window.WindowNode;
import com.rigol.scope.views.window.WindowOnDragListener;
import com.rigol.scope.views.window.WindowType;
import com.rigol.util.ToastUtils;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class MultiWindow extends ConstraintLayout {
    private static final WindowType DEFAULT_TYPE = WindowType.HORIZONTAL;
    Callback callback;
    private final ViewDragHelper dragHelper;
    private WindowOnDragListener onDragListener;
    Paint paint;
    WindowNode root;
    Deque<Integer> windowIds;

    /* loaded from: classes2.dex */
    public interface Callback {
        void onAdded(Window window);

        void onClosed(WindowHolder windowHolder);
    }

    public MultiWindow(Context context) {
        super(context);
        this.windowIds = new LinkedList<Integer>() { // from class: com.rigol.scope.views.multi.MultiWindow.1
            {
                add(Integer.valueOf((int) R.id.multi_window_0));
                add(Integer.valueOf((int) R.id.multi_window_1));
                add(Integer.valueOf((int) R.id.multi_window_2));
                add(Integer.valueOf((int) R.id.multi_window_3));
                add(Integer.valueOf((int) R.id.multi_window_4));
                add(Integer.valueOf((int) R.id.multi_window_5));
                add(Integer.valueOf((int) R.id.multi_window_6));
                add(Integer.valueOf((int) R.id.multi_window_7));
                add(Integer.valueOf((int) R.id.multi_window_8));
                add(Integer.valueOf((int) R.id.multi_window_9));
                add(Integer.valueOf((int) R.id.multi_window_10));
                add(Integer.valueOf((int) R.id.multi_window_11));
                add(Integer.valueOf((int) R.id.multi_window_12));
                add(Integer.valueOf((int) R.id.multi_window_13));
                add(Integer.valueOf((int) R.id.multi_window_14));
                add(Integer.valueOf((int) R.id.multi_window_15));
            }
        };
        WindowNode windowNode = new WindowNode();
        this.root = windowNode;
        windowNode.setType(DEFAULT_TYPE);
        setClipChildren(false);
        this.dragHelper = ViewDragHelper.create(this, new ViewDragHelper.Callback() { // from class: com.rigol.scope.views.multi.MultiWindow.2
            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public boolean tryCaptureView(View view, int i) {
                return false;
            }
        });
        this.onDragListener = null;
        Paint paint = new Paint();
        this.paint = paint;
        paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(getContext().getColor(R.color.multi_window_prompt));
    }

    public MultiWindow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.windowIds = new LinkedList<Integer>() { // from class: com.rigol.scope.views.multi.MultiWindow.1
            {
                add(Integer.valueOf((int) R.id.multi_window_0));
                add(Integer.valueOf((int) R.id.multi_window_1));
                add(Integer.valueOf((int) R.id.multi_window_2));
                add(Integer.valueOf((int) R.id.multi_window_3));
                add(Integer.valueOf((int) R.id.multi_window_4));
                add(Integer.valueOf((int) R.id.multi_window_5));
                add(Integer.valueOf((int) R.id.multi_window_6));
                add(Integer.valueOf((int) R.id.multi_window_7));
                add(Integer.valueOf((int) R.id.multi_window_8));
                add(Integer.valueOf((int) R.id.multi_window_9));
                add(Integer.valueOf((int) R.id.multi_window_10));
                add(Integer.valueOf((int) R.id.multi_window_11));
                add(Integer.valueOf((int) R.id.multi_window_12));
                add(Integer.valueOf((int) R.id.multi_window_13));
                add(Integer.valueOf((int) R.id.multi_window_14));
                add(Integer.valueOf((int) R.id.multi_window_15));
            }
        };
        WindowNode windowNode = new WindowNode();
        this.root = windowNode;
        windowNode.setType(DEFAULT_TYPE);
        setClipChildren(false);
        this.dragHelper = ViewDragHelper.create(this, new ViewDragHelper.Callback() { // from class: com.rigol.scope.views.multi.MultiWindow.2
            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public boolean tryCaptureView(View view, int i) {
                return false;
            }
        });
        this.onDragListener = null;
        Paint paint = new Paint();
        this.paint = paint;
        paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(getContext().getColor(R.color.multi_window_prompt));
    }

    public MultiWindow(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.windowIds = new LinkedList<Integer>() { // from class: com.rigol.scope.views.multi.MultiWindow.1
            {
                add(Integer.valueOf((int) R.id.multi_window_0));
                add(Integer.valueOf((int) R.id.multi_window_1));
                add(Integer.valueOf((int) R.id.multi_window_2));
                add(Integer.valueOf((int) R.id.multi_window_3));
                add(Integer.valueOf((int) R.id.multi_window_4));
                add(Integer.valueOf((int) R.id.multi_window_5));
                add(Integer.valueOf((int) R.id.multi_window_6));
                add(Integer.valueOf((int) R.id.multi_window_7));
                add(Integer.valueOf((int) R.id.multi_window_8));
                add(Integer.valueOf((int) R.id.multi_window_9));
                add(Integer.valueOf((int) R.id.multi_window_10));
                add(Integer.valueOf((int) R.id.multi_window_11));
                add(Integer.valueOf((int) R.id.multi_window_12));
                add(Integer.valueOf((int) R.id.multi_window_13));
                add(Integer.valueOf((int) R.id.multi_window_14));
                add(Integer.valueOf((int) R.id.multi_window_15));
            }
        };
        WindowNode windowNode = new WindowNode();
        this.root = windowNode;
        windowNode.setType(DEFAULT_TYPE);
        setClipChildren(false);
        this.dragHelper = ViewDragHelper.create(this, new ViewDragHelper.Callback() { // from class: com.rigol.scope.views.multi.MultiWindow.2
            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public boolean tryCaptureView(View view, int i2) {
                return false;
            }
        });
        this.onDragListener = null;
        Paint paint = new Paint();
        this.paint = paint;
        paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(getContext().getColor(R.color.multi_window_prompt));
    }

    public MultiWindow(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.windowIds = new LinkedList<Integer>() { // from class: com.rigol.scope.views.multi.MultiWindow.1
            {
                add(Integer.valueOf((int) R.id.multi_window_0));
                add(Integer.valueOf((int) R.id.multi_window_1));
                add(Integer.valueOf((int) R.id.multi_window_2));
                add(Integer.valueOf((int) R.id.multi_window_3));
                add(Integer.valueOf((int) R.id.multi_window_4));
                add(Integer.valueOf((int) R.id.multi_window_5));
                add(Integer.valueOf((int) R.id.multi_window_6));
                add(Integer.valueOf((int) R.id.multi_window_7));
                add(Integer.valueOf((int) R.id.multi_window_8));
                add(Integer.valueOf((int) R.id.multi_window_9));
                add(Integer.valueOf((int) R.id.multi_window_10));
                add(Integer.valueOf((int) R.id.multi_window_11));
                add(Integer.valueOf((int) R.id.multi_window_12));
                add(Integer.valueOf((int) R.id.multi_window_13));
                add(Integer.valueOf((int) R.id.multi_window_14));
                add(Integer.valueOf((int) R.id.multi_window_15));
            }
        };
        WindowNode windowNode = new WindowNode();
        this.root = windowNode;
        windowNode.setType(DEFAULT_TYPE);
        setClipChildren(false);
        this.dragHelper = ViewDragHelper.create(this, new ViewDragHelper.Callback() { // from class: com.rigol.scope.views.multi.MultiWindow.2
            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public boolean tryCaptureView(View view, int i22) {
                return false;
            }
        });
        this.onDragListener = null;
        Paint paint = new Paint();
        this.paint = paint;
        paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(getContext().getColor(R.color.multi_window_prompt));
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 0) {
            if (getWindowCount() <= 1) {
                return super.onTouchEvent(motionEvent);
            }
            View findTopChildUnder = this.dragHelper.findTopChildUnder((int) motionEvent.getX(), (int) motionEvent.getY());
            if (findTopChildUnder instanceof Window) {
                View findViewById = findTopChildUnder.findViewById(R.id.title_layout);
                if (findViewById instanceof ConstraintLayout) {
                    float x = motionEvent.getX() - findTopChildUnder.getX();
                    float y = motionEvent.getY() - findTopChildUnder.getY();
                    if (x >= findViewById.getLeft() && x <= findViewById.getRight() && y >= findViewById.getTop() && y <= findViewById.getBottom()) {
                        WindowOnDragListener windowOnDragListener = this.onDragListener;
                        if (windowOnDragListener == null || windowOnDragListener.getResult() == 4) {
                            ClipData clipData = new ClipData("", new String[]{"text/plain"}, new ClipData.Item(""));
                            WindowDragShadowBuilder windowDragShadowBuilder = new WindowDragShadowBuilder(findTopChildUnder, x, y);
                            findTopChildUnder.cancelDragAndDrop();
                            findTopChildUnder.startDragAndDrop(clipData, windowDragShadowBuilder, findTopChildUnder, 0);
                            return true;
                        }
                        return true;
                    }
                }
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public int getWindowCount() {
        WindowNode windowNode = this.root;
        if (windowNode == null || windowNode.getChildren().isEmpty()) {
            return 0;
        }
        return getNodeCount(this.root);
    }

    private int getNodeCount(WindowNode windowNode) {
        int i = 0;
        if (windowNode == null) {
            return 0;
        }
        List<Object> children = windowNode.getChildren();
        if (children.isEmpty()) {
            return 0;
        }
        for (Object obj : children) {
            if (obj instanceof WindowNode) {
                i += getNodeCount((WindowNode) obj);
            } else if (obj instanceof Window) {
                i++;
            }
        }
        return i;
    }

    public void parseNodeTreeRelative() {
        System.currentTimeMillis();
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(this);
        parseNodeTreeRelative(this.root, constraintSet);
        constraintSet.applyTo(this);
        this.root.printLog();
    }

    public void parseNodeTreeRelative(WindowNode windowNode, ConstraintSet constraintSet) {
        WindowNode windowNode2;
        View view;
        List<Object> children = windowNode.getChildren();
        float size = windowNode.getType() == WindowType.HORIZONTAL ? windowNode.getSize().x / children.size() : windowNode.getSize().x;
        float size2 = windowNode.getType() == WindowType.VERTICAL ? windowNode.getSize().y / children.size() : windowNode.getSize().y;
        for (int i = 0; i < children.size(); i++) {
            Object obj = children.get(i);
            if (WindowNode.isNode(obj)) {
                WindowNode windowNode3 = (WindowNode) obj;
                windowNode3.setParent(windowNode);
                windowNode3.getSize().set(size, size2);
                parseNodeTreeRelative(windowNode3, constraintSet);
            } else {
                View view2 = (View) obj;
                constraintSet.constrainWidth(view2.getId(), 0);
                constraintSet.constrainHeight(view2.getId(), 0);
                setWindowSizePercent(view2.getId(), constraintSet, size, size2);
                TwoTuple<Object, WindowNode> elementBefore = getElementBefore(windowNode, i);
                View view3 = null;
                if (elementBefore != null) {
                    WindowNode second = elementBefore.getSecond();
                    if (WindowNode.isNode(elementBefore.getFirst())) {
                        view = getRelativeView((WindowNode) elementBefore.getFirst(), second.getType());
                    } else {
                        view = (View) elementBefore.getFirst();
                    }
                    view3 = view;
                    windowNode2 = second;
                } else {
                    windowNode2 = null;
                }
                setConstrainWithRelativeView(constraintSet, view2.getId(), view3, windowNode2 != null ? windowNode2.getType() : windowNode.getType());
            }
        }
    }

    private View getRelativeView(WindowNode windowNode, WindowType windowType) {
        if (windowType == WindowType.HORIZONTAL) {
            return getUpperRightCornerView(windowNode);
        }
        return getLowerLeftCornerView(windowNode);
    }

    private View getLowerLeftCornerView(WindowNode windowNode) {
        Object obj;
        if (windowNode.getType() == WindowType.VERTICAL) {
            obj = windowNode.getChildren().get(windowNode.getChildren().size() - 1);
        } else {
            obj = windowNode.getChildren().get(0);
        }
        if (WindowNode.isNode(obj)) {
            return getLowerLeftCornerView((WindowNode) obj);
        }
        return (View) obj;
    }

    private View getUpperRightCornerView(WindowNode windowNode) {
        Object obj;
        if (windowNode.getType() == WindowType.HORIZONTAL) {
            obj = windowNode.getChildren().get(windowNode.getChildren().size() - 1);
        } else {
            obj = windowNode.getChildren().get(0);
        }
        if (WindowNode.isNode(obj)) {
            return getUpperRightCornerView((WindowNode) obj);
        }
        return (View) obj;
    }

    private void setConstrainWithRelativeView(ConstraintSet constraintSet, int i, View view, WindowType windowType) {
        if (view == null) {
            constraintSet.connect(i, 3, 0, 3);
            constraintSet.connect(i, 6, 0, 6);
            return;
        }
        constraintSet.connect(i, 3, view.getId(), windowType == WindowType.HORIZONTAL ? 3 : 4);
        constraintSet.connect(i, 6, view.getId(), windowType == WindowType.HORIZONTAL ? 7 : 6);
    }

    private TwoTuple<Object, WindowNode> getElementBefore(WindowNode windowNode, int i) {
        if (i == 0) {
            while (windowNode != null && windowNode.getParent() != null) {
                int indexOf = windowNode.getParent().getChildren().indexOf(windowNode);
                if (indexOf != -1 && indexOf != 0) {
                    return new TwoTuple<>(windowNode.getParent().getChildren().get(indexOf - 1), windowNode.getParent());
                }
                windowNode = windowNode.getParent();
            }
            return null;
        }
        return new TwoTuple<>(windowNode.getChildren().get(i - 1), windowNode);
    }

    private void setWindowSizePercent(int i, ConstraintSet constraintSet, float f, float f2) {
        if (f == 1.0f) {
            constraintSet.constrainWidth(i, -1);
        } else {
            constraintSet.constrainPercentWidth(i, f);
        }
        if (f2 == 1.0f) {
            constraintSet.constrainHeight(i, -1);
        } else {
            constraintSet.constrainPercentHeight(i, f2);
        }
    }

    public void onWindowClose(WindowHolder windowHolder) {
        removeWindow(windowHolder.getWindow(), true);
        parseNodeTreeRelative();
    }

    public View findWindow(View view, PointF pointF) {
        return findWindow(view, this.root, pointF);
    }

    public View findWindow(View view, WindowNode windowNode, PointF pointF) {
        if (pointF == null || pointF.x < 0.0f || pointF.y < 0.0f || windowNode.getChildren().isEmpty()) {
            return null;
        }
        for (int i = 0; i < windowNode.getChildren().size(); i++) {
            Object obj = windowNode.getChildren().get(i);
            if (obj instanceof WindowNode) {
                View findWindow = findWindow(view, (WindowNode) obj, pointF);
                if (findWindow != null) {
                    return findWindow;
                }
            } else if (obj instanceof View) {
                View view2 = (View) obj;
                int left = view2.getLeft();
                int top = view2.getTop();
                int right = view2.getRight();
                int bottom = view2.getBottom();
                if (pointF.x > left && pointF.x < right && pointF.y > top && pointF.y < bottom && obj != view) {
                    return view2;
                }
            } else {
                continue;
            }
        }
        return null;
    }

    public void addWindow(View view) {
        WindowDirection windowDirection;
        if (view == null) {
            return;
        }
        if (this.root.isEmpty() || getWindowCount() == 1) {
            windowDirection = WindowDirection.END;
        } else if (this.root.getLastElement() instanceof View) {
            windowDirection = WindowDirection.BOTTOM;
        } else {
            windowDirection = WindowDirection.END;
        }
        addWindow(view, windowDirection);
    }

    public void addWindow(View view, WindowDirection windowDirection) {
        if (view == null) {
            return;
        }
        view.setOnDragListener(new WindowOnDragListener(false) { // from class: com.rigol.scope.views.multi.MultiWindow.3
            @Override // com.rigol.scope.views.window.WindowOnDragListener, android.view.View.OnDragListener
            public boolean onDrag(View view2, DragEvent dragEvent) {
                if (dragEvent != null && dragEvent.getAction() == 5) {
                    MultiWindow.this.onDragListener = this;
                }
                if (dragEvent.getAction() == 4) {
                    ((SharedViewModel) ContextUtil.getAppViewModel(SharedViewModel.class)).getLiveData().getValue().setViewonDrag(true);
                }
                return super.onDrag(view2, dragEvent);
            }
        });
        System.currentTimeMillis();
        WindowNode windowNode = this.root;
        addWindow(view, windowNode, windowNode.getChildren().size() - 1, windowDirection, true);
        Callback callback = this.callback;
        if (callback == null || !(view instanceof Window)) {
            return;
        }
        callback.onAdded((Window) view);
    }

    public synchronized void addWindow(View view, View view2, WindowDirection windowDirection, boolean z) {
        WindowNode findByWindow = this.root.findByWindow(view2);
        if (findByWindow != null && view != null && windowDirection != null) {
            addWindow(view, findByWindow, findByWindow.getChildren().indexOf(view2), windowDirection, z);
        }
    }

    public void addWindow(View view, WindowNode windowNode, int i, WindowDirection windowDirection, boolean z) {
        if (this.windowIds.isEmpty()) {
            ToastUtils.showShort(getResources().getString(R.string.inf_max_multi_window_size));
            return;
        }
        if (z) {
            addView(view);
        }
        view.setId(this.windowIds.removeFirst().intValue());
        windowNode.addElement(view, i, windowDirection);
        this.root.clean();
        parseNodeTreeRelative();
    }

    public void removeWindow(WindowHolder windowHolder) {
        removeWindow(windowHolder.getWindow(), true);
        parseNodeTreeRelative();
        Callback callback = this.callback;
        if (callback != null) {
            callback.onClosed(windowHolder);
        }
    }

    public void removeWindow(View view, boolean z) {
        WindowNode windowNode = this.root;
        if (windowNode == null || windowNode.getChildren().isEmpty()) {
            return;
        }
        WindowNode findByWindow = this.root.findByWindow(view);
        if (findByWindow != null) {
            findByWindow.getChildren().remove(view);
        }
        if (z) {
            removeView(view);
        }
        this.windowIds.addLast(Integer.valueOf(view.getId()));
        this.root.clean();
        this.root.printLog("remove");
    }

    public void setSelectedWindow(int i) {
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof Window) {
                childAt.setSelected(childAt.getId() == i);
                childAt.invalidate();
            }
        }
    }

    public List<Window> getWindows() {
        return getWindows(this.root, new ArrayList());
    }

    private List<Window> getWindows(WindowNode windowNode, List<Window> list) {
        if (windowNode == null || windowNode.isEmpty()) {
            return null;
        }
        for (int i = 0; i < windowNode.getChildren().size(); i++) {
            Object obj = windowNode.getChildren().get(i);
            if (obj instanceof WindowNode) {
                List<Window> windows = getWindows((WindowNode) obj, new ArrayList());
                if (windows != null) {
                    list.addAll(windows);
                }
            } else if (obj instanceof Window) {
                list.add((Window) obj);
            }
        }
        return list;
    }

    @Override // android.view.View
    public void onDrawForeground(Canvas canvas) {
        super.onDrawForeground(canvas);
        WindowOnDragListener windowOnDragListener = this.onDragListener;
        if (windowOnDragListener == null || windowOnDragListener.getTarget() == null || this.onDragListener.getDirection() == null) {
            return;
        }
        int left = this.onDragListener.getTarget().getLeft();
        int top = this.onDragListener.getTarget().getTop();
        int right = this.onDragListener.getTarget().getRight();
        int bottom = this.onDragListener.getTarget().getBottom();
        int i = (left + right) / 2;
        int i2 = (top + bottom) / 2;
        if (this.onDragListener.getDirection() == WindowDirection.START) {
            right = i;
        } else if (this.onDragListener.getDirection() == WindowDirection.END) {
            left = i;
        } else if (this.onDragListener.getDirection() == WindowDirection.TOP) {
            bottom = i2;
        } else if (this.onDragListener.getDirection() == WindowDirection.BOTTOM) {
            top = i2;
        }
        canvas.drawRect(left, top, right, bottom, this.paint);
    }

    public boolean isFull() {
        return this.windowIds.isEmpty();
    }

    public void setCallback(Callback callback) {
        this.callback = callback;
    }

    public Callback getCallback() {
        return this.callback;
    }
}
