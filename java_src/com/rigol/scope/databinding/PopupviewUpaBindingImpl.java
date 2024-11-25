package com.rigol.scope.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.rigol.scope.R;
import com.rigol.scope.data.HorizontalParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.UpaParam;
import com.rigol.scope.data.UpaRippleParam;
import com.rigol.scope.views.SwitchButton;
/* loaded from: classes2.dex */
public class PopupviewUpaBindingImpl extends PopupviewUpaBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.right_guideline, 3);
        sViewsWithIds.put(R.id.left_guideline, 4);
        sViewsWithIds.put(R.id.left_guideline2, 5);
        sViewsWithIds.put(R.id.upa_spring, 6);
        sViewsWithIds.put(R.id.no_text, 7);
        sViewsWithIds.put(R.id.adaper_upa_view, 8);
    }

    public PopupviewUpaBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 9, sIncludes, sViewsWithIds));
    }

    private PopupviewUpaBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 5, (RecyclerView) objArr[8], (SwitchButton) objArr[2], (Guideline) objArr[4], (Guideline) objArr[5], (TextView) objArr[7], (Guideline) objArr[3], (TextView) objArr[1], (TextView) objArr[6]);
        this.mDirtyFlags = -1L;
        this.displayOnoffSwitchButton.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.upaAnalysisSpinner.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 512L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.mDirtyFlags != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (594 == i) {
            setParam((UpaParam) obj);
        } else if (992 == i) {
            setUpaMappingObj((MappingObject) obj);
        } else if (993 == i) {
            setUpaRippleParam((UpaRippleParam) obj);
        } else if (382 != i) {
            return false;
        } else {
            setHorizontalParam((HorizontalParam) obj);
        }
        return true;
    }

    @Override // com.rigol.scope.databinding.PopupviewUpaBinding
    public void setParam(UpaParam upaParam) {
        updateRegistration(0, upaParam);
        this.mParam = upaParam;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(594);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewUpaBinding
    public void setUpaMappingObj(MappingObject mappingObject) {
        this.mUpaMappingObj = mappingObject;
    }

    @Override // com.rigol.scope.databinding.PopupviewUpaBinding
    public void setUpaRippleParam(UpaRippleParam upaRippleParam) {
        updateRegistration(2, upaRippleParam);
        this.mUpaRippleParam = upaRippleParam;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(993);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewUpaBinding
    public void setHorizontalParam(HorizontalParam horizontalParam) {
        this.mHorizontalParam = horizontalParam;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            return false;
                        }
                        return onChangeHorizontalParam((HorizontalParam) obj, i2);
                    }
                    return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgUpaTypeParamType((MappingObject) obj, i2);
                }
                return onChangeUpaRippleParam((UpaRippleParam) obj, i2);
            }
            return onChangeUpaMappingObj((MappingObject) obj, i2);
        }
        return onChangeParam((UpaParam) obj, i2);
    }

    private boolean onChangeParam(UpaParam upaParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i == 978) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        } else if (i == 726) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeUpaMappingObj(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeUpaRippleParam(UpaRippleParam upaRippleParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else if (i == 726) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgUpaTypeParamType(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 256;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeHorizontalParam(HorizontalParam horizontalParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void executeBindings() {
        /*
            r22 = this;
            r1 = r22
            monitor-enter(r22)
            long r2 = r1.mDirtyFlags     // Catch: java.lang.Throwable -> L96
            r4 = 0
            r1.mDirtyFlags = r4     // Catch: java.lang.Throwable -> L96
            monitor-exit(r22)     // Catch: java.lang.Throwable -> L96
            com.rigol.scope.data.UpaParam r0 = r1.mParam
            com.rigol.scope.data.UpaRippleParam r7 = r1.mUpaRippleParam
            r8 = 1005(0x3ed, double:4.965E-321)
            long r8 = r8 & r2
            int r8 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            r9 = 809(0x329, double:3.997E-321)
            r11 = 741(0x2e5, double:3.66E-321)
            r13 = 2048(0x800, double:1.0118E-320)
            r15 = 1024(0x400, double:5.06E-321)
            r17 = 0
            if (r8 == 0) goto L57
            if (r0 == 0) goto L26
            int r8 = r0.getType()
            goto L28
        L26:
            r8 = r17
        L28:
            long r18 = r2 & r11
            int r18 = (r18 > r4 ? 1 : (r18 == r4 ? 0 : -1))
            if (r18 == 0) goto L3d
            if (r8 != 0) goto L33
            r19 = 1
            goto L35
        L33:
            r19 = r17
        L35:
            if (r18 == 0) goto L3f
            if (r19 == 0) goto L3b
            long r2 = r2 | r13
            goto L3f
        L3b:
            long r2 = r2 | r15
            goto L3f
        L3d:
            r19 = r17
        L3f:
            long r20 = r2 & r9
            int r18 = (r20 > r4 ? 1 : (r20 == r4 ? 0 : -1))
            if (r18 == 0) goto L59
            r6 = 2130903615(0x7f03023f, float:1.7414053E38)
            com.rigol.scope.data.MappingObject r6 = com.rigol.scope.utilities.ViewUtil.getMappingObject(r6, r8)
            r8 = 3
            r1.updateRegistration(r8, r6)
            if (r6 == 0) goto L59
            java.lang.String r6 = r6.getStr()
            goto L5a
        L57:
            r19 = r17
        L59:
            r6 = 0
        L5a:
            long r15 = r15 & r2
            int r8 = (r15 > r4 ? 1 : (r15 == r4 ? 0 : -1))
            if (r8 == 0) goto L66
            if (r7 == 0) goto L66
            boolean r7 = r7.getRefPowerDisp()
            goto L68
        L66:
            r7 = r17
        L68:
            long r13 = r13 & r2
            int r8 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1))
            if (r8 == 0) goto L74
            if (r0 == 0) goto L74
            boolean r0 = r0.getRefPowerDisp()
            goto L76
        L74:
            r0 = r17
        L76:
            long r11 = r11 & r2
            int r8 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r8 == 0) goto L82
            if (r19 == 0) goto L80
            r17 = r0
            goto L82
        L80:
            r17 = r7
        L82:
            r0 = r17
            if (r8 == 0) goto L8b
            com.rigol.scope.views.SwitchButton r7 = r1.displayOnoffSwitchButton
            androidx.databinding.adapters.CompoundButtonBindingAdapter.setChecked(r7, r0)
        L8b:
            long r2 = r2 & r9
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L95
            android.widget.TextView r0 = r1.upaAnalysisSpinner
            androidx.databinding.adapters.TextViewBindingAdapter.setText(r0, r6)
        L95:
            return
        L96:
            r0 = move-exception
            monitor-exit(r22)     // Catch: java.lang.Throwable -> L96
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rigol.scope.databinding.PopupviewUpaBindingImpl.executeBindings():void");
    }
}
