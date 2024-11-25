package com.rigol.scope.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
import com.rigol.scope.data.DecodeParam;
import com.rigol.scope.data.MappingObject;
/* loaded from: classes2.dex */
public class AdapterDecodeMostBindingImpl extends AdapterDecodeMostBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.decode_most_layout, 4);
        sViewsWithIds.put(R.id.guideline_left, 5);
        sViewsWithIds.put(R.id.guideline_center, 6);
        sViewsWithIds.put(R.id.guideline_right, 7);
        sViewsWithIds.put(R.id.guideline_33, 8);
        sViewsWithIds.put(R.id.guideline_66, 9);
        sViewsWithIds.put(R.id.decode_most_src_label, 10);
        sViewsWithIds.put(R.id.decode_most_thres_label, 11);
        sViewsWithIds.put(R.id.decode_most_signal_type_label, 12);
    }

    public AdapterDecodeMostBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 13, sIncludes, sViewsWithIds));
    }

    private AdapterDecodeMostBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3, (ConstraintLayout) objArr[4], (TextView) objArr[12], (TextView) objArr[3], (TextView) objArr[10], (TextView) objArr[1], (TextView) objArr[11], (TextView) objArr[2], (Guideline) objArr[8], (Guideline) objArr[9], (Guideline) objArr[6], (Guideline) objArr[5], (Guideline) objArr[7]);
        this.mDirtyFlags = -1L;
        this.decodeMostSignalTypeValue.setTag(null);
        this.decodeMostSrcValue.setTag(null);
        this.decodeMostThresValue.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
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
            setParam((DecodeParam) obj);
            return true;
        }
        return false;
    }

    @Override // com.rigol.scope.databinding.AdapterDecodeMostBinding
    public void setParam(DecodeParam decodeParam) {
        updateRegistration(1, decodeParam);
        this.mParam = decodeParam;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(594);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    return false;
                }
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDecodeMostSignalTypeParamMostSignalType((MappingObject) obj, i2);
            }
            return onChangeParam((DecodeParam) obj, i2);
        }
        return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDecodeMostSrcParamMostSource((MappingObject) obj, i2);
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDecodeMostSrcParamMostSource(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeParam(DecodeParam decodeParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        } else if (i == 552) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        } else if (i == 553) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        } else if (i == 551) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDecodeMostSignalTypeParamMostSignalType(MappingObject mappingObject, int i) {
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

    /* JADX WARN: Removed duplicated region for block: B:19:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0069  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void executeBindings() {
        /*
            r20 = this;
            r1 = r20
            monitor-enter(r20)
            long r2 = r1.mDirtyFlags     // Catch: java.lang.Throwable -> Lc9
            r4 = 0
            r1.mDirtyFlags = r4     // Catch: java.lang.Throwable -> Lc9
            monitor-exit(r20)     // Catch: java.lang.Throwable -> Lc9
            com.rigol.scope.data.DecodeParam r0 = r1.mParam
            r6 = 255(0xff, double:1.26E-321)
            long r6 = r6 & r2
            int r6 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            r7 = 139(0x8b, double:6.87E-322)
            r9 = 146(0x92, double:7.2E-322)
            r11 = 138(0x8a, double:6.8E-322)
            r13 = 230(0xe6, double:1.136E-321)
            r15 = 0
            r16 = 0
            if (r6 == 0) goto L98
            long r17 = r2 & r13
            int r6 = (r17 > r4 ? 1 : (r17 == r4 ? 0 : -1))
            if (r6 == 0) goto L3e
            if (r0 == 0) goto L2b
            int r6 = r0.getMost_signal_type()
            goto L2c
        L2b:
            r6 = r15
        L2c:
            r13 = 2130903255(0x7f0300d7, float:1.7413323E38)
            com.rigol.scope.data.MappingObject r6 = com.rigol.scope.utilities.ViewUtil.getMappingObject(r13, r6)
            r13 = 2
            r1.updateRegistration(r13, r6)
            if (r6 == 0) goto L3e
            java.lang.String r6 = r6.getStr()
            goto L40
        L3e:
            r6 = r16
        L40:
            long r13 = r2 & r9
            int r13 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1))
            if (r13 == 0) goto L61
            if (r0 == 0) goto L53
            long r13 = r0.getMost_thres()
            com.rigol.scope.cil.ServiceEnum$Unit r19 = r0.getUnit()
            r9 = r19
            goto L56
        L53:
            r13 = r4
            r9 = r16
        L56:
            com.rigol.scope.utilities.UnitFormat$SI r10 = com.rigol.scope.utilities.UnitFormat.SI.MICRO
            com.rigol.scope.utilities.UnitFormat r10 = com.rigol.scope.utilities.UnitFormat.newBuilder(r10)
            java.lang.String r9 = r10.convert(r13, r9)
            goto L63
        L61:
            r9 = r16
        L63:
            long r13 = r2 & r7
            int r10 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1))
            if (r10 == 0) goto L93
            if (r0 == 0) goto L70
            int r0 = r0.getMost_source()
            goto L71
        L70:
            r0 = r15
        L71:
            r10 = 2130903256(0x7f0300d8, float:1.7413325E38)
            com.rigol.scope.data.MappingObject r10 = com.rigol.scope.utilities.ViewUtil.getMappingObject(r10, r0)
            r1.updateRegistration(r15, r10)
            if (r10 == 0) goto L81
            java.lang.String r16 = r10.getStr()
        L81:
            long r13 = r2 & r11
            int r10 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1))
            if (r10 == 0) goto L93
            android.view.View r10 = r20.getRoot()
            android.content.Context r10 = r10.getContext()
            int r15 = com.rigol.scope.utilities.ColorUtil.getColor(r10, r0)
        L93:
            r0 = r16
            r13 = 230(0xe6, double:1.136E-321)
            goto L9c
        L98:
            r0 = r16
            r6 = r0
            r9 = r6
        L9c:
            long r13 = r13 & r2
            int r10 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1))
            if (r10 == 0) goto La6
            android.widget.TextView r10 = r1.decodeMostSignalTypeValue
            androidx.databinding.adapters.TextViewBindingAdapter.setText(r10, r6)
        La6:
            long r10 = r2 & r11
            int r6 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r6 == 0) goto Lb1
            android.widget.TextView r6 = r1.decodeMostSrcValue
            r6.setTextColor(r15)
        Lb1:
            long r6 = r2 & r7
            int r6 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r6 == 0) goto Lbc
            android.widget.TextView r6 = r1.decodeMostSrcValue
            androidx.databinding.adapters.TextViewBindingAdapter.setText(r6, r0)
        Lbc:
            r6 = 146(0x92, double:7.2E-322)
            long r2 = r2 & r6
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto Lc8
            android.widget.TextView r0 = r1.decodeMostThresValue
            androidx.databinding.adapters.TextViewBindingAdapter.setText(r0, r9)
        Lc8:
            return
        Lc9:
            r0 = move-exception
            monitor-exit(r20)     // Catch: java.lang.Throwable -> Lc9
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rigol.scope.databinding.AdapterDecodeMostBindingImpl.executeBindings():void");
    }
}
