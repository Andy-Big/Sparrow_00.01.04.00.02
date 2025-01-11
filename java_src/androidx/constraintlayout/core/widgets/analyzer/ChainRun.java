package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class ChainRun extends WidgetRun {
    private int chainStyle;
    ArrayList<WidgetRun> widgets;

    public ChainRun(ConstraintWidget constraintWidget, int i) {
        super(constraintWidget);
        this.widgets = new ArrayList<>();
        this.orientation = i;
        build();
    }

    public String toString() {
        Iterator<WidgetRun> it;
        StringBuilder sb = new StringBuilder();
        sb.append("ChainRun ");
        sb.append(this.orientation == 0 ? "horizontal : " : "vertical : ");
        String sb2 = sb.toString();
        while (this.widgets.iterator().hasNext()) {
            sb2 = ((sb2 + "<") + it.next()) + "> ";
        }
        return sb2;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    boolean supportsWrapComputation() {
        int size = this.widgets.size();
        for (int i = 0; i < size; i++) {
            if (!this.widgets.get(i).supportsWrapComputation()) {
                return false;
            }
        }
        return true;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public long getWrapDimension() {
        int size = this.widgets.size();
        long j = 0;
        for (int i = 0; i < size; i++) {
            WidgetRun widgetRun = this.widgets.get(i);
            j = j + widgetRun.start.margin + widgetRun.getWrapDimension() + widgetRun.end.margin;
        }
        return j;
    }

    private void build() {
        ConstraintWidget constraintWidget;
        ConstraintWidget constraintWidget2 = this.widget;
        ConstraintWidget previousChainMember = constraintWidget2.getPreviousChainMember(this.orientation);
        while (true) {
            ConstraintWidget constraintWidget3 = previousChainMember;
            constraintWidget = constraintWidget2;
            constraintWidget2 = constraintWidget3;
            if (constraintWidget2 == null) {
                break;
            }
            previousChainMember = constraintWidget2.getPreviousChainMember(this.orientation);
        }
        this.widget = constraintWidget;
        this.widgets.add(constraintWidget.getRun(this.orientation));
        ConstraintWidget nextChainMember = constraintWidget.getNextChainMember(this.orientation);
        while (nextChainMember != null) {
            this.widgets.add(nextChainMember.getRun(this.orientation));
            nextChainMember = nextChainMember.getNextChainMember(this.orientation);
        }
        Iterator<WidgetRun> it = this.widgets.iterator();
        while (it.hasNext()) {
            WidgetRun next = it.next();
            if (this.orientation == 0) {
                next.widget.horizontalChainRun = this;
            } else if (this.orientation == 1) {
                next.widget.verticalChainRun = this;
            }
        }
        if ((this.orientation == 0 && ((ConstraintWidgetContainer) this.widget.getParent()).isRtl()) && this.widgets.size() > 1) {
            ArrayList<WidgetRun> arrayList = this.widgets;
            this.widget = arrayList.get(arrayList.size() - 1).widget;
        }
        this.chainStyle = this.orientation == 0 ? this.widget.getHorizontalChainStyle() : this.widget.getVerticalChainStyle();
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    void clear() {
        this.runGroup = null;
        Iterator<WidgetRun> it = this.widgets.iterator();
        while (it.hasNext()) {
            it.next().clear();
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    void reset() {
        this.start.resolved = false;
        this.end.resolved = false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:275:0x040e, code lost:
        r3 = r3 - r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00cf, code lost:
        if (r2.dimension.resolved != false) goto L68;
     */
    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun, androidx.constraintlayout.core.widgets.analyzer.Dependency
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void update(Dependency dependency) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        float f;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        float f2;
        int i11;
        if (this.start.resolved && this.end.resolved) {
            ConstraintWidget parent = this.widget.getParent();
            boolean isRtl = (parent == null || !(parent instanceof ConstraintWidgetContainer)) ? false : ((ConstraintWidgetContainer) parent).isRtl();
            int i12 = this.end.value - this.start.value;
            int size = this.widgets.size();
            int i13 = 0;
            while (true) {
                i = -1;
                i2 = 8;
                if (i13 >= size) {
                    i13 = -1;
                    break;
                } else if (this.widgets.get(i13).widget.getVisibility() != 8) {
                    break;
                } else {
                    i13++;
                }
            }
            int i14 = size - 1;
            int i15 = i14;
            while (true) {
                if (i15 < 0) {
                    break;
                }
                if (this.widgets.get(i15).widget.getVisibility() != 8) {
                    i = i15;
                    break;
                }
                i15--;
            }
            int i16 = 0;
            while (i16 < 2) {
                int i17 = 0;
                i4 = 0;
                i5 = 0;
                int i18 = 0;
                f = 0.0f;
                while (i17 < size) {
                    WidgetRun widgetRun = this.widgets.get(i17);
                    if (widgetRun.widget.getVisibility() != i2) {
                        i18++;
                        if (i17 > 0 && i17 >= i13) {
                            i4 += widgetRun.start.margin;
                        }
                        int i19 = widgetRun.dimension.value;
                        boolean z = widgetRun.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                        if (z) {
                            if (this.orientation == 0 && !widgetRun.widget.horizontalRun.dimension.resolved) {
                                return;
                            }
                            if (this.orientation == 1 && !widgetRun.widget.verticalRun.dimension.resolved) {
                                return;
                            }
                        } else {
                            if (widgetRun.matchConstraintsType == 1 && i16 == 0) {
                                i19 = widgetRun.dimension.wrapValue;
                                i5++;
                            }
                            z = true;
                        }
                        if (z) {
                            i4 += i19;
                        } else {
                            i5++;
                            float f3 = widgetRun.widget.mWeight[this.orientation];
                            if (f3 >= 0.0f) {
                                f += f3;
                            }
                        }
                        if (i17 < i14 && i17 < i) {
                            i4 += -widgetRun.end.margin;
                        }
                    }
                    i17++;
                    i2 = 8;
                }
                if (i4 < i12 || i5 == 0) {
                    i3 = i18;
                    break;
                } else {
                    i16++;
                    i2 = 8;
                }
            }
            i3 = 0;
            i4 = 0;
            i5 = 0;
            f = 0.0f;
            int i20 = this.start.value;
            if (isRtl) {
                i20 = this.end.value;
            }
            if (i4 > i12) {
                i20 = isRtl ? i20 + ((int) (((i4 - i12) / 2.0f) + 0.5f)) : i20 - ((int) (((i4 - i12) / 2.0f) + 0.5f));
            }
            if (i5 > 0) {
                float f4 = i12 - i4;
                int i21 = (int) ((f4 / i5) + 0.5f);
                int i22 = 0;
                int i23 = 0;
                while (i22 < size) {
                    WidgetRun widgetRun2 = this.widgets.get(i22);
                    int i24 = i21;
                    if (widgetRun2.widget.getVisibility() == 8 || widgetRun2.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || widgetRun2.dimension.resolved) {
                        i10 = i20;
                        f2 = f4;
                        i11 = i4;
                    } else {
                        int i25 = f > 0.0f ? (int) (((widgetRun2.widget.mWeight[this.orientation] * f4) / f) + 0.5f) : i24;
                        if (this.orientation == 0) {
                            int i26 = widgetRun2.widget.mMatchConstraintMaxWidth;
                            f2 = f4;
                            i11 = i4;
                            i10 = i20;
                            int max = Math.max(widgetRun2.widget.mMatchConstraintMinWidth, widgetRun2.matchConstraintsType == 1 ? Math.min(i25, widgetRun2.dimension.wrapValue) : i25);
                            if (i26 > 0) {
                                max = Math.min(i26, max);
                            }
                            if (max != i25) {
                                i23++;
                                i25 = max;
                            }
                        } else {
                            i10 = i20;
                            f2 = f4;
                            i11 = i4;
                            int i27 = widgetRun2.widget.mMatchConstraintMaxHeight;
                            int max2 = Math.max(widgetRun2.widget.mMatchConstraintMinHeight, widgetRun2.matchConstraintsType == 1 ? Math.min(i25, widgetRun2.dimension.wrapValue) : i25);
                            if (i27 > 0) {
                                max2 = Math.min(i27, max2);
                            }
                            if (max2 != i25) {
                                i23++;
                                i25 = max2;
                            }
                        }
                        widgetRun2.dimension.resolve(i25);
                    }
                    i22++;
                    i21 = i24;
                    f4 = f2;
                    i4 = i11;
                    i20 = i10;
                }
                i6 = i20;
                int i28 = i4;
                if (i23 > 0) {
                    i5 -= i23;
                    int i29 = 0;
                    for (int i30 = 0; i30 < size; i30++) {
                        WidgetRun widgetRun3 = this.widgets.get(i30);
                        if (widgetRun3.widget.getVisibility() != 8) {
                            if (i30 > 0 && i30 >= i13) {
                                i29 += widgetRun3.start.margin;
                            }
                            i29 += widgetRun3.dimension.value;
                            if (i30 < i14 && i30 < i) {
                                i29 += -widgetRun3.end.margin;
                            }
                        }
                    }
                    i4 = i29;
                } else {
                    i4 = i28;
                }
                i8 = 2;
                if (this.chainStyle == 2 && i23 == 0) {
                    i7 = 0;
                    this.chainStyle = 0;
                } else {
                    i7 = 0;
                }
            } else {
                i6 = i20;
                i7 = 0;
                i8 = 2;
            }
            if (i4 > i12) {
                this.chainStyle = i8;
            }
            if (i3 > 0 && i5 == 0 && i13 == i) {
                this.chainStyle = i8;
            }
            int i31 = this.chainStyle;
            if (i31 == 1) {
                if (i3 > 1) {
                    i9 = (i12 - i4) / (i3 - 1);
                } else {
                    i9 = i3 == 1 ? (i12 - i4) / 2 : i7;
                }
                if (i5 > 0) {
                    i9 = i7;
                }
                int i32 = i6;
                for (int i33 = i7; i33 < size; i33++) {
                    WidgetRun widgetRun4 = this.widgets.get(isRtl ? size - (i33 + 1) : i33);
                    if (widgetRun4.widget.getVisibility() == 8) {
                        widgetRun4.start.resolve(i32);
                        widgetRun4.end.resolve(i32);
                    } else {
                        if (i33 > 0) {
                            i32 = isRtl ? i32 - i9 : i32 + i9;
                        }
                        if (i33 > 0 && i33 >= i13) {
                            if (isRtl) {
                                i32 -= widgetRun4.start.margin;
                            } else {
                                i32 += widgetRun4.start.margin;
                            }
                        }
                        if (isRtl) {
                            widgetRun4.end.resolve(i32);
                        } else {
                            widgetRun4.start.resolve(i32);
                        }
                        int i34 = widgetRun4.dimension.value;
                        if (widgetRun4.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && widgetRun4.matchConstraintsType == 1) {
                            i34 = widgetRun4.dimension.wrapValue;
                        }
                        i32 = isRtl ? i32 - i34 : i32 + i34;
                        if (isRtl) {
                            widgetRun4.start.resolve(i32);
                        } else {
                            widgetRun4.end.resolve(i32);
                        }
                        widgetRun4.resolved = true;
                        if (i33 < i14 && i33 < i) {
                            if (isRtl) {
                                i32 -= -widgetRun4.end.margin;
                            } else {
                                i32 += -widgetRun4.end.margin;
                            }
                        }
                    }
                }
            } else if (i31 == 0) {
                int i35 = (i12 - i4) / (i3 + 1);
                if (i5 > 0) {
                    i35 = i7;
                }
                int i36 = i6;
                for (int i37 = i7; i37 < size; i37++) {
                    WidgetRun widgetRun5 = this.widgets.get(isRtl ? size - (i37 + 1) : i37);
                    if (widgetRun5.widget.getVisibility() == 8) {
                        widgetRun5.start.resolve(i36);
                        widgetRun5.end.resolve(i36);
                    } else {
                        int i38 = isRtl ? i36 - i35 : i36 + i35;
                        if (i37 > 0 && i37 >= i13) {
                            if (isRtl) {
                                i38 -= widgetRun5.start.margin;
                            } else {
                                i38 += widgetRun5.start.margin;
                            }
                        }
                        if (isRtl) {
                            widgetRun5.end.resolve(i38);
                        } else {
                            widgetRun5.start.resolve(i38);
                        }
                        int i39 = widgetRun5.dimension.value;
                        if (widgetRun5.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && widgetRun5.matchConstraintsType == 1) {
                            i39 = Math.min(i39, widgetRun5.dimension.wrapValue);
                        }
                        i36 = isRtl ? i38 - i39 : i38 + i39;
                        if (isRtl) {
                            widgetRun5.start.resolve(i36);
                        } else {
                            widgetRun5.end.resolve(i36);
                        }
                        if (i37 < i14 && i37 < i) {
                            if (isRtl) {
                                i36 -= -widgetRun5.end.margin;
                            } else {
                                i36 += -widgetRun5.end.margin;
                            }
                        }
                    }
                }
            } else if (i31 == 2) {
                float horizontalBiasPercent = this.orientation == 0 ? this.widget.getHorizontalBiasPercent() : this.widget.getVerticalBiasPercent();
                if (isRtl) {
                    horizontalBiasPercent = 1.0f - horizontalBiasPercent;
                }
                int i40 = (int) (((i12 - i4) * horizontalBiasPercent) + 0.5f);
                if (i40 < 0 || i5 > 0) {
                    i40 = i7;
                }
                int i41 = isRtl ? i6 - i40 : i6 + i40;
                for (int i42 = i7; i42 < size; i42++) {
                    WidgetRun widgetRun6 = this.widgets.get(isRtl ? size - (i42 + 1) : i42);
                    if (widgetRun6.widget.getVisibility() == 8) {
                        widgetRun6.start.resolve(i41);
                        widgetRun6.end.resolve(i41);
                    } else {
                        if (i42 > 0 && i42 >= i13) {
                            if (isRtl) {
                                i41 -= widgetRun6.start.margin;
                            } else {
                                i41 += widgetRun6.start.margin;
                            }
                        }
                        if (isRtl) {
                            widgetRun6.end.resolve(i41);
                        } else {
                            widgetRun6.start.resolve(i41);
                        }
                        int i43 = widgetRun6.dimension.value;
                        if (widgetRun6.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && widgetRun6.matchConstraintsType == 1) {
                            i43 = widgetRun6.dimension.wrapValue;
                        }
                        i41 += i43;
                        if (isRtl) {
                            widgetRun6.start.resolve(i41);
                        } else {
                            widgetRun6.end.resolve(i41);
                        }
                        if (i42 < i14 && i42 < i) {
                            if (isRtl) {
                                i41 -= -widgetRun6.end.margin;
                            } else {
                                i41 += -widgetRun6.end.margin;
                            }
                        }
                    }
                }
            }
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void applyToWidget() {
        for (int i = 0; i < this.widgets.size(); i++) {
            this.widgets.get(i).applyToWidget();
        }
    }

    private ConstraintWidget getFirstVisibleWidget() {
        for (int i = 0; i < this.widgets.size(); i++) {
            WidgetRun widgetRun = this.widgets.get(i);
            if (widgetRun.widget.getVisibility() != 8) {
                return widgetRun.widget;
            }
        }
        return null;
    }

    private ConstraintWidget getLastVisibleWidget() {
        for (int size = this.widgets.size() - 1; size >= 0; size--) {
            WidgetRun widgetRun = this.widgets.get(size);
            if (widgetRun.widget.getVisibility() != 8) {
                return widgetRun.widget;
            }
        }
        return null;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    void apply() {
        Iterator<WidgetRun> it = this.widgets.iterator();
        while (it.hasNext()) {
            it.next().apply();
        }
        int size = this.widgets.size();
        if (size < 1) {
            return;
        }
        ConstraintWidget constraintWidget = this.widgets.get(0).widget;
        ConstraintWidget constraintWidget2 = this.widgets.get(size - 1).widget;
        if (this.orientation == 0) {
            ConstraintAnchor constraintAnchor = constraintWidget.mLeft;
            ConstraintAnchor constraintAnchor2 = constraintWidget2.mRight;
            DependencyNode target = getTarget(constraintAnchor, 0);
            int margin = constraintAnchor.getMargin();
            ConstraintWidget firstVisibleWidget = getFirstVisibleWidget();
            if (firstVisibleWidget != null) {
                margin = firstVisibleWidget.mLeft.getMargin();
            }
            if (target != null) {
                addTarget(this.start, target, margin);
            }
            DependencyNode target2 = getTarget(constraintAnchor2, 0);
            int margin2 = constraintAnchor2.getMargin();
            ConstraintWidget lastVisibleWidget = getLastVisibleWidget();
            if (lastVisibleWidget != null) {
                margin2 = lastVisibleWidget.mRight.getMargin();
            }
            if (target2 != null) {
                addTarget(this.end, target2, -margin2);
            }
        } else {
            ConstraintAnchor constraintAnchor3 = constraintWidget.mTop;
            ConstraintAnchor constraintAnchor4 = constraintWidget2.mBottom;
            DependencyNode target3 = getTarget(constraintAnchor3, 1);
            int margin3 = constraintAnchor3.getMargin();
            ConstraintWidget firstVisibleWidget2 = getFirstVisibleWidget();
            if (firstVisibleWidget2 != null) {
                margin3 = firstVisibleWidget2.mTop.getMargin();
            }
            if (target3 != null) {
                addTarget(this.start, target3, margin3);
            }
            DependencyNode target4 = getTarget(constraintAnchor4, 1);
            int margin4 = constraintAnchor4.getMargin();
            ConstraintWidget lastVisibleWidget2 = getLastVisibleWidget();
            if (lastVisibleWidget2 != null) {
                margin4 = lastVisibleWidget2.mBottom.getMargin();
            }
            if (target4 != null) {
                addTarget(this.end, target4, -margin4);
            }
        }
        this.start.updateDelegate = this;
        this.end.updateDelegate = this;
    }
}
