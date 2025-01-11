package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.ArrayRow;
import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class Chain {
    private static final boolean DEBUG = false;
    public static final boolean USE_CHAIN_OPTIMIZATION = false;

    public static void applyChainConstraints(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, ArrayList<ConstraintWidget> arrayList, int i) {
        ChainHead[] chainHeadArr;
        int i2;
        int i3;
        if (i == 0) {
            i3 = constraintWidgetContainer.mHorizontalChainsSize;
            chainHeadArr = constraintWidgetContainer.mHorizontalChainsArray;
            i2 = 0;
        } else {
            int i4 = constraintWidgetContainer.mVerticalChainsSize;
            chainHeadArr = constraintWidgetContainer.mVerticalChainsArray;
            i2 = 2;
            i3 = i4;
        }
        for (int i5 = 0; i5 < i3; i5++) {
            ChainHead chainHead = chainHeadArr[i5];
            chainHead.define();
            if (arrayList == null || (arrayList != null && arrayList.contains(chainHead.mFirst))) {
                applyChainConstraints(constraintWidgetContainer, linearSystem, i, i2, chainHead);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v63, resolved type: androidx.constraintlayout.core.widgets.ConstraintWidget */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0035, code lost:
        if (r2.mHorizontalChainStyle == 2) goto L317;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0048, code lost:
        if (r2.mVerticalChainStyle == 2) goto L317;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x004a, code lost:
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x004c, code lost:
        r5 = false;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x03c9  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x03e7  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x04bb  */
    /* JADX WARN: Removed duplicated region for block: B:283:0x04f0  */
    /* JADX WARN: Removed duplicated region for block: B:293:0x0517  */
    /* JADX WARN: Removed duplicated region for block: B:294:0x051c  */
    /* JADX WARN: Removed duplicated region for block: B:297:0x0522  */
    /* JADX WARN: Removed duplicated region for block: B:298:0x0527  */
    /* JADX WARN: Removed duplicated region for block: B:300:0x052b  */
    /* JADX WARN: Removed duplicated region for block: B:304:0x053c  */
    /* JADX WARN: Removed duplicated region for block: B:306:0x053f  */
    /* JADX WARN: Removed duplicated region for block: B:323:0x03ca A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static void applyChainConstraints(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, int i, int i2, ChainHead chainHead) {
        boolean z;
        boolean z2;
        boolean z3;
        ArrayList<ConstraintWidget> arrayList;
        ConstraintWidget constraintWidget;
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        ConstraintAnchor constraintAnchor3;
        int i3;
        ConstraintWidget constraintWidget2;
        int i4;
        ConstraintAnchor constraintAnchor4;
        SolverVariable solverVariable;
        SolverVariable solverVariable2;
        ConstraintWidget constraintWidget3;
        ConstraintAnchor constraintAnchor5;
        SolverVariable solverVariable3;
        SolverVariable solverVariable4;
        ConstraintWidget constraintWidget4;
        SolverVariable solverVariable5;
        SolverVariable solverVariable6;
        float f;
        int size;
        int i5;
        ArrayList<ConstraintWidget> arrayList2;
        int i6;
        boolean z4;
        ConstraintWidget constraintWidget5;
        boolean z5;
        int i7;
        ConstraintWidget constraintWidget6 = chainHead.mFirst;
        ConstraintWidget constraintWidget7 = chainHead.mLast;
        ConstraintWidget constraintWidget8 = chainHead.mFirstVisibleWidget;
        ConstraintWidget constraintWidget9 = chainHead.mLastVisibleWidget;
        ConstraintWidget constraintWidget10 = chainHead.mHead;
        float f2 = chainHead.mTotalWeight;
        ConstraintWidget constraintWidget11 = chainHead.mFirstMatchConstraintWidget;
        ConstraintWidget constraintWidget12 = chainHead.mLastMatchConstraintWidget;
        boolean z6 = constraintWidgetContainer.mListDimensionBehaviors[i] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (i == 0) {
            z = constraintWidget10.mHorizontalChainStyle == 0;
            z2 = constraintWidget10.mHorizontalChainStyle == 1;
        } else {
            z = constraintWidget10.mVerticalChainStyle == 0;
            z2 = constraintWidget10.mVerticalChainStyle == 1;
        }
        ConstraintWidget constraintWidget13 = constraintWidget6;
        boolean z7 = z2;
        boolean z8 = z;
        boolean z9 = false;
        while (true) {
            if (z9) {
                break;
            }
            ConstraintAnchor constraintAnchor6 = constraintWidget13.mListAnchors[i2];
            int i8 = z3 ? 1 : 4;
            int margin = constraintAnchor6.getMargin();
            float f3 = f2;
            boolean z10 = z9;
            boolean z11 = constraintWidget13.mListDimensionBehaviors[i] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget13.mResolvedMatchConstraintDefault[i] == 0;
            if (constraintAnchor6.mTarget != null && constraintWidget13 != constraintWidget6) {
                margin += constraintAnchor6.mTarget.getMargin();
            }
            int i9 = margin;
            if (!z3 || constraintWidget13 == constraintWidget6 || constraintWidget13 == constraintWidget8) {
                z4 = z7;
            } else {
                z4 = z7;
                i8 = 8;
            }
            if (constraintAnchor6.mTarget != null) {
                if (constraintWidget13 == constraintWidget8) {
                    z5 = z8;
                    constraintWidget5 = constraintWidget10;
                    linearSystem.addGreaterThan(constraintAnchor6.mSolverVariable, constraintAnchor6.mTarget.mSolverVariable, i9, 6);
                } else {
                    constraintWidget5 = constraintWidget10;
                    z5 = z8;
                    linearSystem.addGreaterThan(constraintAnchor6.mSolverVariable, constraintAnchor6.mTarget.mSolverVariable, i9, 8);
                }
                linearSystem.addEquality(constraintAnchor6.mSolverVariable, constraintAnchor6.mTarget.mSolverVariable, i9, (!z11 || z3) ? i8 : 5);
            } else {
                constraintWidget5 = constraintWidget10;
                z5 = z8;
            }
            if (z6) {
                if (constraintWidget13.getVisibility() == 8 || constraintWidget13.mListDimensionBehaviors[i] != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    i7 = 0;
                } else {
                    i7 = 0;
                    linearSystem.addGreaterThan(constraintWidget13.mListAnchors[i2 + 1].mSolverVariable, constraintWidget13.mListAnchors[i2].mSolverVariable, 0, 5);
                }
                linearSystem.addGreaterThan(constraintWidget13.mListAnchors[i2].mSolverVariable, constraintWidgetContainer.mListAnchors[i2].mSolverVariable, i7, 8);
            }
            ConstraintAnchor constraintAnchor7 = constraintWidget13.mListAnchors[i2 + 1].mTarget;
            if (constraintAnchor7 != null) {
                ConstraintWidget constraintWidget14 = constraintAnchor7.mOwner;
                if (constraintWidget14.mListAnchors[i2].mTarget != null && constraintWidget14.mListAnchors[i2].mTarget.mOwner == constraintWidget13) {
                    r21 = constraintWidget14;
                }
            }
            if (r21 != null) {
                constraintWidget13 = r21;
                z9 = z10;
            } else {
                z9 = true;
            }
            z7 = z4;
            f2 = f3;
            z8 = z5;
            constraintWidget10 = constraintWidget5;
        }
        ConstraintWidget constraintWidget15 = constraintWidget10;
        float f4 = f2;
        boolean z12 = z8;
        boolean z13 = z7;
        if (constraintWidget9 != null) {
            int i10 = i2 + 1;
            if (constraintWidget7.mListAnchors[i10].mTarget != null) {
                ConstraintAnchor constraintAnchor8 = constraintWidget9.mListAnchors[i10];
                if ((constraintWidget9.mListDimensionBehaviors[i] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget9.mResolvedMatchConstraintDefault[i] == 0) && !z3 && constraintAnchor8.mTarget.mOwner == constraintWidgetContainer) {
                    linearSystem.addEquality(constraintAnchor8.mSolverVariable, constraintAnchor8.mTarget.mSolverVariable, -constraintAnchor8.getMargin(), 5);
                } else if (z3 && constraintAnchor8.mTarget.mOwner == constraintWidgetContainer) {
                    linearSystem.addEquality(constraintAnchor8.mSolverVariable, constraintAnchor8.mTarget.mSolverVariable, -constraintAnchor8.getMargin(), 4);
                }
                linearSystem.addLowerThan(constraintAnchor8.mSolverVariable, constraintWidget7.mListAnchors[i10].mTarget.mSolverVariable, -constraintAnchor8.getMargin(), 6);
                if (z6) {
                    int i11 = i2 + 1;
                    linearSystem.addGreaterThan(constraintWidgetContainer.mListAnchors[i11].mSolverVariable, constraintWidget7.mListAnchors[i11].mSolverVariable, constraintWidget7.mListAnchors[i11].getMargin(), 8);
                }
                arrayList = chainHead.mWeightedMatchConstraintsWidgets;
                if (arrayList != null && (size = arrayList.size()) > 1) {
                    float f5 = (chainHead.mHasUndefinedWeights || chainHead.mHasComplexMatchWeights) ? f4 : chainHead.mWidgetsMatchCount;
                    float f6 = 0.0f;
                    float f7 = 0.0f;
                    ConstraintWidget constraintWidget16 = null;
                    i5 = 0;
                    while (i5 < size) {
                        ConstraintWidget constraintWidget17 = arrayList.get(i5);
                        float f8 = constraintWidget17.mWeight[i];
                        if (f8 < f6) {
                            if (chainHead.mHasComplexMatchWeights) {
                                linearSystem.addEquality(constraintWidget17.mListAnchors[i2 + 1].mSolverVariable, constraintWidget17.mListAnchors[i2].mSolverVariable, 0, 4);
                                arrayList2 = arrayList;
                                i6 = size;
                                i5++;
                                size = i6;
                                arrayList = arrayList2;
                                f6 = 0.0f;
                            } else {
                                f8 = 1.0f;
                                f6 = 0.0f;
                            }
                        }
                        if (f8 == f6) {
                            linearSystem.addEquality(constraintWidget17.mListAnchors[i2 + 1].mSolverVariable, constraintWidget17.mListAnchors[i2].mSolverVariable, 0, 8);
                            arrayList2 = arrayList;
                            i6 = size;
                            i5++;
                            size = i6;
                            arrayList = arrayList2;
                            f6 = 0.0f;
                        } else {
                            if (constraintWidget16 != null) {
                                SolverVariable solverVariable7 = constraintWidget16.mListAnchors[i2].mSolverVariable;
                                int i12 = i2 + 1;
                                SolverVariable solverVariable8 = constraintWidget16.mListAnchors[i12].mSolverVariable;
                                SolverVariable solverVariable9 = constraintWidget17.mListAnchors[i2].mSolverVariable;
                                arrayList2 = arrayList;
                                SolverVariable solverVariable10 = constraintWidget17.mListAnchors[i12].mSolverVariable;
                                i6 = size;
                                ArrayRow createRow = linearSystem.createRow();
                                createRow.createRowEqualMatchDimensions(f7, f5, f8, solverVariable7, solverVariable8, solverVariable9, solverVariable10);
                                linearSystem.addConstraint(createRow);
                            } else {
                                arrayList2 = arrayList;
                                i6 = size;
                            }
                            f7 = f8;
                            constraintWidget16 = constraintWidget17;
                            i5++;
                            size = i6;
                            arrayList = arrayList2;
                            f6 = 0.0f;
                        }
                    }
                }
                if (constraintWidget8 == null && (constraintWidget8 == constraintWidget9 || z3)) {
                    ConstraintAnchor constraintAnchor9 = constraintWidget6.mListAnchors[i2];
                    int i13 = i2 + 1;
                    ConstraintAnchor constraintAnchor10 = constraintWidget7.mListAnchors[i13];
                    SolverVariable solverVariable11 = constraintAnchor9.mTarget != null ? constraintAnchor9.mTarget.mSolverVariable : null;
                    SolverVariable solverVariable12 = constraintAnchor10.mTarget != null ? constraintAnchor10.mTarget.mSolverVariable : null;
                    ConstraintAnchor constraintAnchor11 = constraintWidget8.mListAnchors[i2];
                    ConstraintAnchor constraintAnchor12 = constraintWidget9.mListAnchors[i13];
                    if (solverVariable11 != null && solverVariable12 != null) {
                        if (i == 0) {
                            f = constraintWidget15.mHorizontalBiasPercent;
                        } else {
                            f = constraintWidget15.mVerticalBiasPercent;
                        }
                        linearSystem.addCentering(constraintAnchor11.mSolverVariable, solverVariable11, constraintAnchor11.getMargin(), f, solverVariable12, constraintAnchor12.mSolverVariable, constraintAnchor12.getMargin(), 7);
                    }
                } else if (z12 || constraintWidget8 == null) {
                    int i14 = 8;
                    if (z13 && constraintWidget8 != null) {
                        boolean z14 = chainHead.mWidgetsMatchCount <= 0 && chainHead.mWidgetsCount == chainHead.mWidgetsMatchCount;
                        constraintWidget = constraintWidget8;
                        ConstraintWidget constraintWidget18 = constraintWidget;
                        while (constraintWidget != null) {
                            ConstraintWidget constraintWidget19 = constraintWidget.mNextChainWidget[i];
                            while (constraintWidget19 != null && constraintWidget19.getVisibility() == i14) {
                                constraintWidget19 = constraintWidget19.mNextChainWidget[i];
                            }
                            if (constraintWidget == constraintWidget8 || constraintWidget == constraintWidget9 || constraintWidget19 == null) {
                                constraintWidget2 = constraintWidget18;
                                i4 = i14;
                            } else {
                                ConstraintWidget constraintWidget20 = constraintWidget19 == constraintWidget9 ? null : constraintWidget19;
                                ConstraintAnchor constraintAnchor13 = constraintWidget.mListAnchors[i2];
                                SolverVariable solverVariable13 = constraintAnchor13.mSolverVariable;
                                if (constraintAnchor13.mTarget != null) {
                                    SolverVariable solverVariable14 = constraintAnchor13.mTarget.mSolverVariable;
                                }
                                int i15 = i2 + 1;
                                SolverVariable solverVariable15 = constraintWidget18.mListAnchors[i15].mSolverVariable;
                                int margin2 = constraintAnchor13.getMargin();
                                int margin3 = constraintWidget.mListAnchors[i15].getMargin();
                                if (constraintWidget20 != null) {
                                    constraintAnchor4 = constraintWidget20.mListAnchors[i2];
                                    solverVariable = constraintAnchor4.mSolverVariable;
                                    solverVariable2 = constraintAnchor4.mTarget != null ? constraintAnchor4.mTarget.mSolverVariable : null;
                                } else {
                                    constraintAnchor4 = constraintWidget9.mListAnchors[i2];
                                    solverVariable = constraintAnchor4 != null ? constraintAnchor4.mSolverVariable : null;
                                    solverVariable2 = constraintWidget.mListAnchors[i15].mSolverVariable;
                                }
                                if (constraintAnchor4 != null) {
                                    margin3 += constraintAnchor4.getMargin();
                                }
                                int i16 = margin3;
                                if (constraintWidget18 != null) {
                                    margin2 += constraintWidget18.mListAnchors[i15].getMargin();
                                }
                                int i17 = margin2;
                                int i18 = z14 ? 8 : 4;
                                if (solverVariable13 == null || solverVariable15 == null || solverVariable == null || solverVariable2 == null) {
                                    constraintWidget3 = constraintWidget20;
                                    constraintWidget2 = constraintWidget18;
                                    i4 = 8;
                                } else {
                                    constraintWidget3 = constraintWidget20;
                                    constraintWidget2 = constraintWidget18;
                                    i4 = 8;
                                    linearSystem.addCentering(solverVariable13, solverVariable15, i17, 0.5f, solverVariable, solverVariable2, i16, i18);
                                }
                                constraintWidget19 = constraintWidget3;
                            }
                            if (constraintWidget.getVisibility() == i4) {
                                constraintWidget = constraintWidget2;
                            }
                            i14 = i4;
                            constraintWidget18 = constraintWidget;
                            constraintWidget = constraintWidget19;
                        }
                        ConstraintAnchor constraintAnchor14 = constraintWidget8.mListAnchors[i2];
                        constraintAnchor = constraintWidget6.mListAnchors[i2].mTarget;
                        int i19 = i2 + 1;
                        constraintAnchor2 = constraintWidget9.mListAnchors[i19];
                        constraintAnchor3 = constraintWidget7.mListAnchors[i19].mTarget;
                        if (constraintAnchor != null) {
                            i3 = 5;
                        } else if (constraintWidget8 != constraintWidget9) {
                            i3 = 5;
                            linearSystem.addEquality(constraintAnchor14.mSolverVariable, constraintAnchor.mSolverVariable, constraintAnchor14.getMargin(), 5);
                        } else {
                            i3 = 5;
                            if (constraintAnchor3 != null) {
                                linearSystem.addCentering(constraintAnchor14.mSolverVariable, constraintAnchor.mSolverVariable, constraintAnchor14.getMargin(), 0.5f, constraintAnchor2.mSolverVariable, constraintAnchor3.mSolverVariable, constraintAnchor2.getMargin(), 5);
                            }
                        }
                        if (constraintAnchor3 != null && constraintWidget8 != constraintWidget9) {
                            linearSystem.addEquality(constraintAnchor2.mSolverVariable, constraintAnchor3.mSolverVariable, -constraintAnchor2.getMargin(), i3);
                        }
                    }
                } else {
                    boolean z15 = chainHead.mWidgetsMatchCount > 0 && chainHead.mWidgetsCount == chainHead.mWidgetsMatchCount;
                    ConstraintWidget constraintWidget21 = constraintWidget8;
                    ConstraintWidget constraintWidget22 = constraintWidget21;
                    while (constraintWidget21 != null) {
                        ConstraintWidget constraintWidget23 = constraintWidget21.mNextChainWidget[i];
                        while (constraintWidget23 != null && constraintWidget23.getVisibility() == 8) {
                            constraintWidget23 = constraintWidget23.mNextChainWidget[i];
                        }
                        if (constraintWidget23 != null || constraintWidget21 == constraintWidget9) {
                            ConstraintAnchor constraintAnchor15 = constraintWidget21.mListAnchors[i2];
                            SolverVariable solverVariable16 = constraintAnchor15.mSolverVariable;
                            SolverVariable solverVariable17 = constraintAnchor15.mTarget != null ? constraintAnchor15.mTarget.mSolverVariable : null;
                            if (constraintWidget22 != constraintWidget21) {
                                solverVariable17 = constraintWidget22.mListAnchors[i2 + 1].mSolverVariable;
                            } else if (constraintWidget21 == constraintWidget8 && constraintWidget22 == constraintWidget21) {
                                solverVariable17 = constraintWidget6.mListAnchors[i2].mTarget != null ? constraintWidget6.mListAnchors[i2].mTarget.mSolverVariable : null;
                            }
                            int margin4 = constraintAnchor15.getMargin();
                            int i20 = i2 + 1;
                            int margin5 = constraintWidget21.mListAnchors[i20].getMargin();
                            if (constraintWidget23 != null) {
                                constraintAnchor5 = constraintWidget23.mListAnchors[i2];
                                SolverVariable solverVariable18 = constraintAnchor5.mSolverVariable;
                                solverVariable4 = constraintWidget21.mListAnchors[i20].mSolverVariable;
                                solverVariable3 = solverVariable18;
                            } else {
                                constraintAnchor5 = constraintWidget7.mListAnchors[i20].mTarget;
                                solverVariable3 = constraintAnchor5 != null ? constraintAnchor5.mSolverVariable : null;
                                solverVariable4 = constraintWidget21.mListAnchors[i20].mSolverVariable;
                            }
                            if (constraintAnchor5 != null) {
                                margin5 += constraintAnchor5.getMargin();
                            }
                            if (constraintWidget22 != null) {
                                margin4 += constraintWidget22.mListAnchors[i20].getMargin();
                            }
                            if (solverVariable16 != null && solverVariable17 != null && solverVariable3 != null && solverVariable4 != null) {
                                if (constraintWidget21 == constraintWidget8) {
                                    margin4 = constraintWidget8.mListAnchors[i2].getMargin();
                                }
                                int i21 = margin4;
                                constraintWidget4 = constraintWidget23;
                                linearSystem.addCentering(solverVariable16, solverVariable17, i21, 0.5f, solverVariable3, solverVariable4, constraintWidget21 == constraintWidget9 ? constraintWidget9.mListAnchors[i20].getMargin() : margin5, z15 ? 8 : 5);
                                if (constraintWidget21.getVisibility() == 8) {
                                    constraintWidget22 = constraintWidget21;
                                }
                                constraintWidget21 = constraintWidget4;
                            }
                        }
                        constraintWidget4 = constraintWidget23;
                        if (constraintWidget21.getVisibility() == 8) {
                        }
                        constraintWidget21 = constraintWidget4;
                    }
                }
                if ((z12 && !z13) || constraintWidget8 == null || constraintWidget8 == constraintWidget9) {
                    return;
                }
                ConstraintAnchor constraintAnchor16 = constraintWidget8.mListAnchors[i2];
                int i22 = i2 + 1;
                ConstraintAnchor constraintAnchor17 = constraintWidget9.mListAnchors[i22];
                solverVariable5 = constraintAnchor16.mTarget == null ? constraintAnchor16.mTarget.mSolverVariable : null;
                SolverVariable solverVariable19 = constraintAnchor17.mTarget == null ? constraintAnchor17.mTarget.mSolverVariable : null;
                if (constraintWidget7 == constraintWidget9) {
                    ConstraintAnchor constraintAnchor18 = constraintWidget7.mListAnchors[i22];
                    solverVariable6 = constraintAnchor18.mTarget != null ? constraintAnchor18.mTarget.mSolverVariable : null;
                } else {
                    solverVariable6 = solverVariable19;
                }
                if (constraintWidget8 == constraintWidget9) {
                    constraintAnchor16 = constraintWidget8.mListAnchors[i2];
                    constraintAnchor17 = constraintWidget8.mListAnchors[i22];
                }
                if (solverVariable5 != null || solverVariable6 == null) {
                }
                int margin6 = constraintAnchor16.getMargin();
                if (constraintWidget9 != null) {
                    constraintWidget7 = constraintWidget9;
                }
                linearSystem.addCentering(constraintAnchor16.mSolverVariable, solverVariable5, margin6, 0.5f, solverVariable6, constraintAnchor17.mSolverVariable, constraintWidget7.mListAnchors[i22].getMargin(), 5);
                return;
            }
        }
        if (z6) {
        }
        arrayList = chainHead.mWeightedMatchConstraintsWidgets;
        if (arrayList != null) {
            if (chainHead.mHasUndefinedWeights) {
            }
            float f62 = 0.0f;
            float f72 = 0.0f;
            ConstraintWidget constraintWidget162 = null;
            i5 = 0;
            while (i5 < size) {
            }
        }
        if (constraintWidget8 == null) {
        }
        if (z12) {
        }
        int i142 = 8;
        if (z13) {
            if (chainHead.mWidgetsMatchCount <= 0) {
            }
            constraintWidget = constraintWidget8;
            ConstraintWidget constraintWidget182 = constraintWidget;
            while (constraintWidget != null) {
            }
            ConstraintAnchor constraintAnchor142 = constraintWidget8.mListAnchors[i2];
            constraintAnchor = constraintWidget6.mListAnchors[i2].mTarget;
            int i192 = i2 + 1;
            constraintAnchor2 = constraintWidget9.mListAnchors[i192];
            constraintAnchor3 = constraintWidget7.mListAnchors[i192].mTarget;
            if (constraintAnchor != null) {
            }
            if (constraintAnchor3 != null) {
                linearSystem.addEquality(constraintAnchor2.mSolverVariable, constraintAnchor3.mSolverVariable, -constraintAnchor2.getMargin(), i3);
            }
        }
        if (z12) {
        }
        ConstraintAnchor constraintAnchor162 = constraintWidget8.mListAnchors[i2];
        int i222 = i2 + 1;
        ConstraintAnchor constraintAnchor172 = constraintWidget9.mListAnchors[i222];
        if (constraintAnchor162.mTarget == null) {
        }
        if (constraintAnchor172.mTarget == null) {
        }
        if (constraintWidget7 == constraintWidget9) {
        }
        if (constraintWidget8 == constraintWidget9) {
        }
        if (solverVariable5 != null) {
        }
    }
}
