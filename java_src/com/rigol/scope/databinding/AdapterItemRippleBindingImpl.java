package com.rigol.scope.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.UpaParam;
import com.rigol.scope.data.UpaRippleParam;
/* loaded from: classes2.dex */
public class AdapterItemRippleBindingImpl extends AdapterItemRippleBinding {
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
        sViewsWithIds.put(R.id.upa_spring1, 7);
        sViewsWithIds.put(R.id.upa_reccovery, 8);
        sViewsWithIds.put(R.id.upa_rippel_reccovery, 9);
    }

    public AdapterItemRippleBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 10, sIncludes, sViewsWithIds));
    }

    private AdapterItemRippleBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 4, (Guideline) objArr[4], (Guideline) objArr[5], (Guideline) objArr[3], (Button) objArr[8], (Button) objArr[9], (EditText) objArr[2], (TextView) objArr[1], (TextView) objArr[6], (TextView) objArr[7]);
        this.mDirtyFlags = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.upaRippleEditText.setTag(null);
        this.upaRippleSpinner.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 128L;
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
            setParam((UpaRippleParam) obj);
        } else if (992 == i) {
            setUpaMappingObj((MappingObject) obj);
        } else if (683 != i) {
            return false;
        } else {
            setQualityParam((UpaParam) obj);
        }
        return true;
    }

    @Override // com.rigol.scope.databinding.AdapterItemRippleBinding
    public void setParam(UpaRippleParam upaRippleParam) {
        updateRegistration(0, upaRippleParam);
        this.mParam = upaRippleParam;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(594);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterItemRippleBinding
    public void setUpaMappingObj(MappingObject mappingObject) {
        this.mUpaMappingObj = mappingObject;
    }

    @Override // com.rigol.scope.databinding.AdapterItemRippleBinding
    public void setQualityParam(UpaParam upaParam) {
        this.mQualityParam = upaParam;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return false;
                    }
                    return onChangeQualityParam((UpaParam) obj, i2);
                }
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgUpaRippleSourceParamRefPowerCurr((MappingObject) obj, i2);
            }
            return onChangeUpaMappingObj((MappingObject) obj, i2);
        }
        return onChangeParam((UpaRippleParam) obj, i2);
    }

    private boolean onChangeParam(UpaRippleParam upaRippleParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i == 724) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        } else if (i == 904) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
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

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgUpaRippleSourceParamRefPowerCurr(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeQualityParam(UpaParam upaParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void executeBindings() {
        /*
            r17 = this;
            r1 = r17
            monitor-enter(r17)
            long r2 = r1.mDirtyFlags     // Catch: java.lang.Throwable -> L8a
            r4 = 0
            r1.mDirtyFlags = r4     // Catch: java.lang.Throwable -> L8a
            monitor-exit(r17)     // Catch: java.lang.Throwable -> L8a
            com.rigol.scope.data.UpaRippleParam r0 = r1.mParam
            r6 = 245(0xf5, double:1.21E-321)
            long r6 = r6 & r2
            int r6 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            r7 = 145(0x91, double:7.16E-322)
            r9 = 213(0xd5, double:1.05E-321)
            r11 = 161(0xa1, double:7.95E-322)
            r14 = 0
            if (r6 == 0) goto L69
            long r15 = r2 & r9
            int r6 = (r15 > r4 ? 1 : (r15 == r4 ? 0 : -1))
            if (r6 == 0) goto L52
            if (r0 == 0) goto L27
            int r6 = r0.getRefPowerCurr()
            goto L28
        L27:
            r6 = r14
        L28:
            long r15 = r2 & r7
            int r15 = (r15 > r4 ? 1 : (r15 == r4 ? 0 : -1))
            if (r15 == 0) goto L3f
            com.rigol.scope.cil.ServiceEnum$Chan r15 = com.rigol.scope.cil.ServiceEnum.getChanFromValue1(r6)
            android.view.View r16 = r17.getRoot()
            android.content.Context r13 = r16.getContext()
            int r13 = com.rigol.scope.utilities.ColorUtil.getColor(r13, r15)
            goto L40
        L3f:
            r13 = r14
        L40:
            r15 = 2130903614(0x7f03023e, float:1.741405E38)
            com.rigol.scope.data.MappingObject r6 = com.rigol.scope.utilities.ViewUtil.getMappingObject(r15, r6)
            r15 = 2
            r1.updateRegistration(r15, r6)
            if (r6 == 0) goto L53
            java.lang.String r6 = r6.getStr()
            goto L54
        L52:
            r13 = r14
        L53:
            r6 = 0
        L54:
            long r15 = r2 & r11
            int r15 = (r15 > r4 ? 1 : (r15 == r4 ? 0 : -1))
            if (r15 == 0) goto L67
            if (r0 == 0) goto L60
            int r14 = r0.getStatCounts()
        L60:
            java.lang.String r0 = java.lang.String.valueOf(r14)
            r14 = r13
            r13 = r0
            goto L6b
        L67:
            r14 = r13
            goto L6a
        L69:
            r6 = 0
        L6a:
            r13 = 0
        L6b:
            long r11 = r11 & r2
            int r0 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r0 == 0) goto L75
            android.widget.EditText r0 = r1.upaRippleEditText
            androidx.databinding.adapters.TextViewBindingAdapter.setText(r0, r13)
        L75:
            long r9 = r9 & r2
            int r0 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r0 == 0) goto L7f
            android.widget.TextView r0 = r1.upaRippleSpinner
            androidx.databinding.adapters.TextViewBindingAdapter.setText(r0, r6)
        L7f:
            long r2 = r2 & r7
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L89
            android.widget.TextView r0 = r1.upaRippleSpinner
            r0.setTextColor(r14)
        L89:
            return
        L8a:
            r0 = move-exception
            monitor-exit(r17)     // Catch: java.lang.Throwable -> L8a
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rigol.scope.databinding.AdapterItemRippleBindingImpl.executeBindings():void");
    }
}
