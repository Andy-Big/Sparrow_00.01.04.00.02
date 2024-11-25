package com.rigol.scope.views.window;

import android.graphics.PointF;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;
/* compiled from: WindowNode.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010+\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 E2\u00020\u0001:\u0001EB\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(J\u0006\u0010)\u001a\u00020\"J\b\u0010*\u001a\u00020\"H\u0002J\b\u0010+\u001a\u00020\"H\u0002J\"\u0010+\u001a\u00020\"2\b\u0010,\u001a\u0004\u0018\u00010\u00002\u000e\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010.H\u0002J\b\u0010/\u001a\u00020\"H\u0002J\u0012\u00100\u001a\u0004\u0018\u00010\u00002\b\u00101\u001a\u0004\u0018\u00010$J\n\u00102\u001a\u0004\u0018\u00010\u0000H\u0002J\n\u00103\u001a\u0004\u0018\u00010\u0000H\u0002J\u0012\u00104\u001a\u0004\u0018\u00010\u00012\u0006\u0010%\u001a\u00020&H\u0002J\u0006\u00105\u001a\u00020&J\u0010\u00105\u001a\u00020&2\b\u0010,\u001a\u0004\u0018\u00010\u0000J\u0018\u00106\u001a\n\u0018\u000107j\u0004\u0018\u0001`82\u0006\u00109\u001a\u00020&H\u0002J\u0018\u0010:\u001a\u00020\u00002\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0002J\u0006\u0010;\u001a\u00020\nJ\u0012\u0010<\u001a\u00020&2\b\u0010=\u001a\u0004\u0018\u00010\u0001H\u0002J\u0010\u0010>\u001a\u00020\n2\b\u0010'\u001a\u0004\u0018\u00010(J\u0010\u0010?\u001a\u00020\u00002\u0006\u0010=\u001a\u00020$H\u0002J\u0006\u0010@\u001a\u00020\"J\u0010\u0010@\u001a\u00020\"2\u0006\u00109\u001a\u00020&H\u0002J\u000e\u0010@\u001a\u00020\"2\u0006\u0010A\u001a\u00020BJ\u0006\u0010C\u001a\u00020\"J\u0010\u0010C\u001a\u00020\"2\u0006\u00109\u001a\u00020&H\u0002J\u0006\u0010D\u001a\u00020\"R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\t\u0010\u000bR\u0011\u0010\f\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\r\u001a\u0004\u0018\u00010\u00018F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0000X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006F"}, d2 = {"Lcom/rigol/scope/views/window/WindowNode;", "", "()V", "children", "", "getChildren", "()Ljava/util/List;", "setChildren", "(Ljava/util/List;)V", "isEmpty", "", "()Z", "isEnableReverse", "lastElement", "getLastElement", "()Ljava/lang/Object;", "parent", "getParent", "()Lcom/rigol/scope/views/window/WindowNode;", "setParent", "(Lcom/rigol/scope/views/window/WindowNode;)V", "size", "Landroid/graphics/PointF;", "getSize", "()Landroid/graphics/PointF;", "setSize", "(Landroid/graphics/PointF;)V", "type", "Lcom/rigol/scope/views/window/WindowType;", "getType", "()Lcom/rigol/scope/views/window/WindowType;", "setType", "(Lcom/rigol/scope/views/window/WindowType;)V", "addElement", "", "view", "Landroid/view/View;", "index", "", "direction", "Lcom/rigol/scope/views/window/WindowDirection;", "clean", "cleanEmptyNode", "cleanOneElementNode", "node", "listIterator", "", "cleanSameTypeAsParentNode", "findByWindow", "window", "findEmptyNode", "findSameTypeAsParentNode", "getElement", "getElementTotalCount", "getLineHead", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "level", "getOrCreateNodeThatCanAddWindow", "hasParent", "indexOfElement", "element", "isNeedReverseThroughInsertDirection", "makeMiddleNode", "printLog", "prefix", "", "printLog2", "reverse", "Companion", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class WindowNode {
    public static final Companion Companion = new Companion(null);
    private List<Object> children;
    private WindowNode parent;
    private PointF size;
    private WindowType type = WindowType.HORIZONTAL;

    @JvmStatic
    public static final boolean isNode(Object obj) {
        return Companion.isNode(obj);
    }

    public final void printLog() {
    }

    public final void printLog(String prefix) {
        Intrinsics.checkNotNullParameter(prefix, "prefix");
    }

    public WindowNode() {
        PointF pointF = new PointF();
        pointF.set(1.0f, 1.0f);
        Unit unit = Unit.INSTANCE;
        this.size = pointF;
        this.children = new ArrayList();
    }

    public final WindowType getType() {
        return this.type;
    }

    public final void setType(WindowType windowType) {
        Intrinsics.checkNotNullParameter(windowType, "<set-?>");
        this.type = windowType;
    }

    public final PointF getSize() {
        return this.size;
    }

    public final void setSize(PointF pointF) {
        Intrinsics.checkNotNullParameter(pointF, "<set-?>");
        this.size = pointF;
    }

    public final WindowNode getParent() {
        return this.parent;
    }

    public final void setParent(WindowNode windowNode) {
        this.parent = windowNode;
    }

    public final List<Object> getChildren() {
        return this.children;
    }

    public final void setChildren(List<Object> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.children = list;
    }

    public final boolean isEmpty() {
        return this.children.isEmpty();
    }

    public final Object getLastElement() {
        if (isEmpty()) {
            return null;
        }
        List<Object> list = this.children;
        return list.get(list.size() - 1);
    }

    public final boolean hasParent() {
        return this.parent != null;
    }

    private final Object getElement(int i) {
        if (this.children.isEmpty() || i == -1) {
            return null;
        }
        return this.children.get(i);
    }

    public final int getElementTotalCount() {
        return getElementTotalCount(this);
    }

    public final int getElementTotalCount(WindowNode windowNode) {
        int i = 0;
        if (windowNode == null) {
            return 0;
        }
        for (Object obj : windowNode.children) {
            if (obj instanceof WindowNode) {
                i += getElementTotalCount((WindowNode) obj);
            } else if (obj instanceof Window) {
                i++;
            }
        }
        return i;
    }

    private final int indexOfElement(Object obj) {
        if (obj == null || this.children.size() == 0) {
            return -1;
        }
        return this.children.indexOf(obj);
    }

    public final void addElement(View view, int i, WindowDirection direction) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(direction, "direction");
        WindowNode orCreateNodeThatCanAddWindow = getOrCreateNodeThatCanAddWindow(i, direction);
        if (orCreateNodeThatCanAddWindow == this) {
            if (isEmpty()) {
                this.children.add(view);
                return;
            }
            List<Object> list = this.children;
            if (!direction.isHead()) {
                i++;
            }
            list.add(i, view);
        } else if (direction.isHead()) {
            orCreateNodeThatCanAddWindow.children.add(0, view);
        } else {
            orCreateNodeThatCanAddWindow.children.add(view);
        }
    }

    private final WindowNode makeMiddleNode(View view) {
        WindowNode windowNode = new WindowNode();
        windowNode.type = this.type == WindowType.HORIZONTAL ? WindowType.VERTICAL : WindowType.HORIZONTAL;
        windowNode.parent = this;
        windowNode.children.add(view);
        int indexOf = this.children.indexOf(view);
        this.children.remove(indexOf);
        this.children.add(indexOf, windowNode);
        return windowNode;
    }

    private final WindowNode getOrCreateNodeThatCanAddWindow(int i, WindowDirection windowDirection) {
        Object element = getElement(i);
        if (element != null) {
            if (Companion.isNode(element)) {
                if (element != null) {
                    WindowNode windowNode = (WindowNode) element;
                    return windowNode.type.same(windowDirection) ? windowNode : this;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.rigol.scope.views.window.WindowNode");
            } else if (this.type.same(windowDirection)) {
                return this;
            } else {
                if (element != null) {
                    return makeMiddleNode((View) element);
                }
                throw new NullPointerException("null cannot be cast to non-null type android.view.View");
            }
        }
        return this;
    }

    public final boolean isEnableReverse() {
        if (this.children.size() < 2) {
            return false;
        }
        int size = this.children.size();
        for (int i = 0; i < size; i++) {
            if (!Companion.isNode(this.children.get(i))) {
                return false;
            }
        }
        int size2 = this.children.size();
        for (int i2 = 1; i2 < size2; i2++) {
            Object obj = this.children.get(i2 - 1);
            Object obj2 = this.children.get(i2);
            if (!(obj2 instanceof WindowNode) || !(obj instanceof WindowNode) || ((WindowNode) obj2).size != ((WindowNode) obj).size) {
                return false;
            }
        }
        return true;
    }

    public final boolean isNeedReverseThroughInsertDirection(WindowDirection windowDirection) {
        if (windowDirection != null && hasParent()) {
            if (this.type != WindowType.HORIZONTAL || (windowDirection != WindowDirection.START && windowDirection != WindowDirection.END)) {
                if (this.type != WindowType.VERTICAL) {
                    return false;
                }
                if (windowDirection != WindowDirection.TOP && windowDirection != WindowDirection.BOTTOM) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public final void reverse() {
        WindowNode windowNode = new WindowNode();
        if (this.type == WindowType.HORIZONTAL) {
            windowNode.type = WindowType.VERTICAL;
        } else {
            windowNode.type = WindowType.HORIZONTAL;
        }
        if (this.children.size() < 2) {
            return;
        }
        Object obj = this.children.get(0);
        if (Companion.isNode(obj)) {
            if (obj != null) {
                int size = ((WindowNode) obj).children.size();
                for (int i = 0; i < size; i++) {
                    WindowNode windowNode2 = new WindowNode();
                    windowNode2.type = this.type;
                    windowNode2.parent = this;
                    windowNode.children.add(windowNode2);
                }
                int size2 = windowNode.children.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    Object obj2 = windowNode.children.get(i2);
                    if (obj2 instanceof WindowNode) {
                        int size3 = this.children.size();
                        for (int i3 = 0; i3 < size3; i3++) {
                            Object obj3 = this.children.get(i3);
                            if (obj3 instanceof WindowNode) {
                                ((WindowNode) obj2).children.add(((WindowNode) obj3).children.get(i2));
                            }
                        }
                    }
                }
                this.type = windowNode.type;
                List<Object> list = this.children;
                list.removeAll(list);
                this.children.addAll(windowNode.children);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.rigol.scope.views.window.WindowNode");
        }
    }

    private final void printLog(int i) {
        StringBuilder lineHead = getLineHead(i);
        if (lineHead != null) {
            lineHead.append("-------------");
            lineHead.append(this.type.toString());
            lineHead.append("(size:");
            lineHead.append(this.children.size());
            lineHead.append(")-------------");
            lineHead.append(toString());
            Timber.v(lineHead.toString(), new Object[0]);
        }
        int size = this.children.size();
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = this.children.get(i2);
            if (obj instanceof WindowNode) {
                ((WindowNode) obj).printLog(i + 1);
            } else {
                StringBuilder lineHead2 = getLineHead(i + 1);
                if (lineHead2 != null) {
                    lineHead2.append(obj.toString());
                    Timber.v(lineHead2.toString(), new Object[0]);
                }
            }
        }
    }

    public final void printLog2() {
        System.out.println((Object) "ROOT NODE👇");
        printLog2(1);
    }

    private final void printLog2(int i) {
        StringBuilder lineHead = getLineHead(i);
        if (lineHead != null) {
            lineHead.append("-------------");
            lineHead.append(this.type.toString());
            lineHead.append("(size:");
            lineHead.append(this.children.size());
            lineHead.append(")-------------");
            System.out.println((Object) lineHead.toString());
        }
        int size = this.children.size();
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = this.children.get(i2);
            if (obj instanceof WindowNode) {
                ((WindowNode) obj).printLog2(i + 1);
            } else {
                StringBuilder lineHead2 = getLineHead(i + 1);
                if (lineHead2 != null) {
                    lineHead2.append(obj.toString());
                    System.out.println((Object) lineHead2.toString());
                }
            }
        }
    }

    private final StringBuilder getLineHead(int i) {
        if (i < 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 == i - 1) {
                sb.append("|--");
                sb.append(i);
                sb.append(".");
            } else {
                sb.append("|  ");
            }
        }
        return sb;
    }

    public final void clean() {
        cleanEmptyNode();
        cleanOneElementNode();
        cleanSameTypeAsParentNode();
    }

    private final void cleanEmptyNode() {
        if (this.children.size() == 0) {
            return;
        }
        WindowNode findEmptyNode = findEmptyNode();
        while (findEmptyNode != null && findEmptyNode.hasParent()) {
            WindowNode windowNode = findEmptyNode.parent;
            Intrinsics.checkNotNull(windowNode);
            if (!windowNode.children.contains(findEmptyNode)) {
                return;
            }
            WindowNode windowNode2 = findEmptyNode.parent;
            Intrinsics.checkNotNull(windowNode2);
            windowNode2.children.remove(findEmptyNode);
            findEmptyNode = findEmptyNode();
        }
    }

    private final WindowNode findEmptyNode() {
        if (this.children.size() == 0 && hasParent()) {
            return this;
        }
        int size = this.children.size();
        for (int i = 0; i < size; i++) {
            Object obj = this.children.get(i);
            if (Companion.isNode(obj)) {
                if (obj == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.rigol.scope.views.window.WindowNode");
                }
                WindowNode findEmptyNode = ((WindowNode) obj).findEmptyNode();
                if (findEmptyNode != null) {
                    return findEmptyNode;
                }
            }
        }
        return null;
    }

    private final void cleanOneElementNode() {
        cleanOneElementNode(this, null);
    }

    private final void cleanOneElementNode(WindowNode windowNode, ListIterator<Object> listIterator) {
        if (windowNode != null) {
            if (windowNode.hasParent() && windowNode.children.size() == 1) {
                WindowNode windowNode2 = windowNode.parent;
                if (windowNode2 == null || windowNode2.indexOfElement(windowNode) == -1) {
                    return;
                }
                Object obj = windowNode.children.get(0);
                if (listIterator != null) {
                    listIterator.remove();
                    listIterator.add(obj);
                }
                if (obj instanceof WindowNode) {
                    WindowNode windowNode3 = (WindowNode) obj;
                    windowNode3.parent = windowNode2;
                    cleanOneElementNode(windowNode3, listIterator);
                    return;
                }
                return;
            }
            ListIterator<Object> listIterator2 = windowNode.children.listIterator();
            while (listIterator2.hasNext()) {
                Object next = listIterator2.next();
                if (next instanceof WindowNode) {
                    cleanOneElementNode((WindowNode) next, listIterator2);
                }
            }
        }
    }

    private final void cleanSameTypeAsParentNode() {
        WindowNode findSameTypeAsParentNode = findSameTypeAsParentNode();
        while (findSameTypeAsParentNode != null && findSameTypeAsParentNode.hasParent()) {
            WindowNode windowNode = findSameTypeAsParentNode.parent;
            Intrinsics.checkNotNull(windowNode);
            int indexOfElement = windowNode.indexOfElement(findSameTypeAsParentNode);
            if (indexOfElement < 0) {
                return;
            }
            WindowNode windowNode2 = findSameTypeAsParentNode.parent;
            Intrinsics.checkNotNull(windowNode2);
            windowNode2.children.remove(indexOfElement);
            WindowNode windowNode3 = findSameTypeAsParentNode.parent;
            Intrinsics.checkNotNull(windowNode3);
            windowNode3.children.addAll(indexOfElement, findSameTypeAsParentNode.children);
            findSameTypeAsParentNode = findSameTypeAsParentNode();
        }
    }

    private final WindowNode findSameTypeAsParentNode() {
        if (hasParent()) {
            WindowNode windowNode = this.parent;
            Intrinsics.checkNotNull(windowNode);
            if (windowNode.type == this.type) {
                return this;
            }
        }
        int size = this.children.size();
        for (int i = 0; i < size; i++) {
            Object obj = this.children.get(i);
            if (Companion.isNode(obj)) {
                if (obj == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.rigol.scope.views.window.WindowNode");
                }
                WindowNode findSameTypeAsParentNode = ((WindowNode) obj).findSameTypeAsParentNode();
                if (findSameTypeAsParentNode != null) {
                    return findSameTypeAsParentNode;
                }
            }
        }
        return null;
    }

    public final WindowNode findByWindow(View view) {
        if (view == null) {
            return null;
        }
        int size = this.children.size();
        for (int i = 0; i < size; i++) {
            Object obj = this.children.get(i);
            if (Companion.isNode(obj)) {
                if (obj == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.rigol.scope.views.window.WindowNode");
                }
                WindowNode findByWindow = ((WindowNode) obj).findByWindow(view);
                if (findByWindow != null) {
                    return findByWindow;
                }
            }
            if (obj == view) {
                return this;
            }
        }
        return null;
    }

    /* compiled from: WindowNode.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001H\u0007¨\u0006\u0006"}, d2 = {"Lcom/rigol/scope/views/window/WindowNode$Companion;", "", "()V", "isNode", "", "element", "app_release"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final boolean isNode(Object obj) {
            return obj instanceof WindowNode;
        }
    }
}
