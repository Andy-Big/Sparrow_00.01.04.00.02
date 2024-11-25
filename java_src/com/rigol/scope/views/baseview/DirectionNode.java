package com.rigol.scope.views.baseview;

import java.util.ArrayList;
/* loaded from: classes2.dex */
public class DirectionNode extends ArrayList<Object> {
    private float heightPercent;
    private final Layout layout;
    private DirectionNode parentNode;
    private float widthPercent;

    /* loaded from: classes2.dex */
    public enum Layout {
        HORIZONTAL,
        VERTICAL
    }

    /* loaded from: classes2.dex */
    public enum Side {
        TOP,
        BOTTOM,
        START,
        END
    }

    public DirectionNode() {
        this.layout = Layout.HORIZONTAL;
    }

    public DirectionNode(Layout layout) {
        this.layout = layout;
    }

    public boolean isHorizontalLayout() {
        return this.layout == Layout.HORIZONTAL;
    }

    public DirectionNode getParentNode() {
        return this.parentNode;
    }

    public void setParentNode(DirectionNode directionNode) {
        this.parentNode = directionNode;
    }

    public float getWidthPercent() {
        return this.widthPercent;
    }

    public void setWidthPercent(float f) {
        this.widthPercent = f;
    }

    public float getHeightPercent() {
        return this.heightPercent;
    }

    public void setHeightPercent(float f) {
        this.heightPercent = f;
    }
}
