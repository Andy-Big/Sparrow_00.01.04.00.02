package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.HashMap;
/* loaded from: classes.dex */
public class Barrier extends HelperWidget {
    public static final int BOTTOM = 3;
    public static final int LEFT = 0;
    public static final int RIGHT = 1;
    public static final int TOP = 2;
    private static final boolean USE_RELAX_GONE = false;
    private static final boolean USE_RESOLUTION = true;
    private int mBarrierType = 0;
    private boolean mAllowsGoneWidget = true;
    private int mMargin = 0;
    boolean resolved = false;

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public boolean allowedInBarrier() {
        return true;
    }

    public Barrier() {
    }

    public Barrier(String str) {
        setDebugName(str);
    }

    public int getBarrierType() {
        return this.mBarrierType;
    }

    public void setBarrierType(int i) {
        this.mBarrierType = i;
    }

    public void setAllowsGoneWidget(boolean z) {
        this.mAllowsGoneWidget = z;
    }

    public boolean allowsGoneWidget() {
        return this.mAllowsGoneWidget;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public boolean isResolvedHorizontally() {
        return this.resolved;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public boolean isResolvedVertically() {
        return this.resolved;
    }

    @Override // androidx.constraintlayout.core.widgets.HelperWidget, androidx.constraintlayout.core.widgets.ConstraintWidget
    public void copy(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> hashMap) {
        super.copy(constraintWidget, hashMap);
        Barrier barrier = (Barrier) constraintWidget;
        this.mBarrierType = barrier.mBarrierType;
        this.mAllowsGoneWidget = barrier.mAllowsGoneWidget;
        this.mMargin = barrier.mMargin;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public String toString() {
        String str = "[Barrier] " + getDebugName() + " {";
        for (int i = 0; i < this.mWidgetsCount; i++) {
            ConstraintWidget constraintWidget = this.mWidgets[i];
            if (i > 0) {
                str = str + ", ";
            }
            str = str + constraintWidget.getDebugName();
        }
        return str + "}";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void markWidgets() {
        for (int i = 0; i < this.mWidgetsCount; i++) {
            ConstraintWidget constraintWidget = this.mWidgets[i];
            int i2 = this.mBarrierType;
            if (i2 == 0 || i2 == 1) {
                constraintWidget.setInBarrier(0, true);
            } else if (i2 == 2 || i2 == 3) {
                constraintWidget.setInBarrier(1, true);
            }
        }
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void addToSolver(LinearSystem linearSystem, boolean z) {
        boolean z2;
        int i;
        int i2;
        this.mListAnchors[0] = this.mLeft;
        this.mListAnchors[2] = this.mTop;
        this.mListAnchors[1] = this.mRight;
        this.mListAnchors[3] = this.mBottom;
        for (int i3 = 0; i3 < this.mListAnchors.length; i3++) {
            this.mListAnchors[i3].mSolverVariable = linearSystem.createObjectVariable(this.mListAnchors[i3]);
        }
        int i4 = this.mBarrierType;
        if (i4 < 0 || i4 >= 4) {
            return;
        }
        ConstraintAnchor constraintAnchor = this.mListAnchors[this.mBarrierType];
        if (!this.resolved) {
            allSolved();
        }
        if (this.resolved) {
            this.resolved = false;
            int i5 = this.mBarrierType;
            if (i5 == 0 || i5 == 1) {
                linearSystem.addEquality(this.mLeft.mSolverVariable, this.mX);
                linearSystem.addEquality(this.mRight.mSolverVariable, this.mX);
                return;
            } else if (i5 == 2 || i5 == 3) {
                linearSystem.addEquality(this.mTop.mSolverVariable, this.mY);
                linearSystem.addEquality(this.mBottom.mSolverVariable, this.mY);
                return;
            } else {
                return;
            }
        }
        for (int i6 = 0; i6 < this.mWidgetsCount; i6++) {
            ConstraintWidget constraintWidget = this.mWidgets[i6];
            if ((this.mAllowsGoneWidget || constraintWidget.allowedInBarrier()) && ((((i = this.mBarrierType) == 0 || i == 1) && constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.mLeft.mTarget != null && constraintWidget.mRight.mTarget != null) || (((i2 = this.mBarrierType) == 2 || i2 == 3) && constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.mTop.mTarget != null && constraintWidget.mBottom.mTarget != null))) {
                z2 = true;
                break;
            }
        }
        z2 = false;
        boolean z3 = this.mLeft.hasCenteredDependents() || this.mRight.hasCenteredDependents();
        boolean z4 = this.mTop.hasCenteredDependents() || this.mBottom.hasCenteredDependents();
        int i7 = !z2 && ((this.mBarrierType == 0 && z3) || ((this.mBarrierType == 2 && z4) || ((this.mBarrierType == 1 && z3) || (this.mBarrierType == 3 && z4)))) ? 5 : 4;
        for (int i8 = 0; i8 < this.mWidgetsCount; i8++) {
            ConstraintWidget constraintWidget2 = this.mWidgets[i8];
            if (this.mAllowsGoneWidget || constraintWidget2.allowedInBarrier()) {
                SolverVariable createObjectVariable = linearSystem.createObjectVariable(constraintWidget2.mListAnchors[this.mBarrierType]);
                constraintWidget2.mListAnchors[this.mBarrierType].mSolverVariable = createObjectVariable;
                int i9 = (constraintWidget2.mListAnchors[this.mBarrierType].mTarget == null || constraintWidget2.mListAnchors[this.mBarrierType].mTarget.mOwner != this) ? 0 : constraintWidget2.mListAnchors[this.mBarrierType].mMargin + 0;
                int i10 = this.mBarrierType;
                if (i10 == 0 || i10 == 2) {
                    linearSystem.addLowerBarrier(constraintAnchor.mSolverVariable, createObjectVariable, this.mMargin - i9, z2);
                } else {
                    linearSystem.addGreaterBarrier(constraintAnchor.mSolverVariable, createObjectVariable, this.mMargin + i9, z2);
                }
                linearSystem.addEquality(constraintAnchor.mSolverVariable, createObjectVariable, this.mMargin + i9, i7);
            }
        }
        int i11 = this.mBarrierType;
        if (i11 == 0) {
            linearSystem.addEquality(this.mRight.mSolverVariable, this.mLeft.mSolverVariable, 0, 8);
            linearSystem.addEquality(this.mLeft.mSolverVariable, this.mParent.mRight.mSolverVariable, 0, 4);
            linearSystem.addEquality(this.mLeft.mSolverVariable, this.mParent.mLeft.mSolverVariable, 0, 0);
        } else if (i11 == 1) {
            linearSystem.addEquality(this.mLeft.mSolverVariable, this.mRight.mSolverVariable, 0, 8);
            linearSystem.addEquality(this.mLeft.mSolverVariable, this.mParent.mLeft.mSolverVariable, 0, 4);
            linearSystem.addEquality(this.mLeft.mSolverVariable, this.mParent.mRight.mSolverVariable, 0, 0);
        } else if (i11 == 2) {
            linearSystem.addEquality(this.mBottom.mSolverVariable, this.mTop.mSolverVariable, 0, 8);
            linearSystem.addEquality(this.mTop.mSolverVariable, this.mParent.mBottom.mSolverVariable, 0, 4);
            linearSystem.addEquality(this.mTop.mSolverVariable, this.mParent.mTop.mSolverVariable, 0, 0);
        } else if (i11 == 3) {
            linearSystem.addEquality(this.mTop.mSolverVariable, this.mBottom.mSolverVariable, 0, 8);
            linearSystem.addEquality(this.mTop.mSolverVariable, this.mParent.mTop.mSolverVariable, 0, 4);
            linearSystem.addEquality(this.mTop.mSolverVariable, this.mParent.mBottom.mSolverVariable, 0, 0);
        }
    }

    public void setMargin(int i) {
        this.mMargin = i;
    }

    public int getMargin() {
        return this.mMargin;
    }

    public int getOrientation() {
        int i = this.mBarrierType;
        if (i == 0 || i == 1) {
            return 0;
        }
        return (i == 2 || i == 3) ? 1 : -1;
    }

    public boolean allSolved() {
        int i;
        int i2;
        boolean z = true;
        for (int i3 = 0; i3 < this.mWidgetsCount; i3++) {
            ConstraintWidget constraintWidget = this.mWidgets[i3];
            if ((this.mAllowsGoneWidget || constraintWidget.allowedInBarrier()) && ((((i = this.mBarrierType) == 0 || i == 1) && !constraintWidget.isResolvedHorizontally()) || (((i2 = this.mBarrierType) == 2 || i2 == 3) && !constraintWidget.isResolvedVertically()))) {
                z = false;
            }
        }
        if (!z || this.mWidgetsCount <= 0) {
            return false;
        }
        int i4 = 0;
        boolean z2 = false;
        for (int i5 = 0; i5 < this.mWidgetsCount; i5++) {
            ConstraintWidget constraintWidget2 = this.mWidgets[i5];
            if (this.mAllowsGoneWidget || constraintWidget2.allowedInBarrier()) {
                if (!z2) {
                    int i6 = this.mBarrierType;
                    if (i6 == 0) {
                        i4 = constraintWidget2.getAnchor(ConstraintAnchor.Type.LEFT).getFinalValue();
                    } else if (i6 == 1) {
                        i4 = constraintWidget2.getAnchor(ConstraintAnchor.Type.RIGHT).getFinalValue();
                    } else if (i6 == 2) {
                        i4 = constraintWidget2.getAnchor(ConstraintAnchor.Type.TOP).getFinalValue();
                    } else if (i6 == 3) {
                        i4 = constraintWidget2.getAnchor(ConstraintAnchor.Type.BOTTOM).getFinalValue();
                    }
                    z2 = true;
                }
                int i7 = this.mBarrierType;
                if (i7 == 0) {
                    i4 = Math.min(i4, constraintWidget2.getAnchor(ConstraintAnchor.Type.LEFT).getFinalValue());
                } else if (i7 == 1) {
                    i4 = Math.max(i4, constraintWidget2.getAnchor(ConstraintAnchor.Type.RIGHT).getFinalValue());
                } else if (i7 == 2) {
                    i4 = Math.min(i4, constraintWidget2.getAnchor(ConstraintAnchor.Type.TOP).getFinalValue());
                } else if (i7 == 3) {
                    i4 = Math.max(i4, constraintWidget2.getAnchor(ConstraintAnchor.Type.BOTTOM).getFinalValue());
                }
            }
        }
        int i8 = i4 + this.mMargin;
        int i9 = this.mBarrierType;
        if (i9 == 0 || i9 == 1) {
            setFinalHorizontal(i8, i8);
        } else {
            setFinalVertical(i8, i8);
        }
        this.resolved = true;
        return true;
    }
}
