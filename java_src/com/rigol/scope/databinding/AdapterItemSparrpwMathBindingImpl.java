package com.rigol.scope.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.MathParam;
/* loaded from: classes2.dex */
public class AdapterItemSparrpwMathBindingImpl extends AdapterItemSparrpwMathBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;

    public AdapterItemSparrpwMathBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 2, sIncludes, sViewsWithIds));
    }

    private AdapterItemSparrpwMathBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (ConstraintLayout) objArr[0], (TextView) objArr[1]);
        this.mDirtyFlags = -1L;
        this.itemView.setTag(null);
        this.text1.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 16L;
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
            setParam((MathParam) obj);
            return true;
        }
        return false;
    }

    @Override // com.rigol.scope.databinding.AdapterItemSparrpwMathBinding
    public void setParam(MathParam mathParam) {
        updateRegistration(0, mathParam);
        this.mParam = mathParam;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(594);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            if (i != 1) {
                return false;
            }
            return onChangeViewUtilGetListComRigolScopeRArrayMsgMathList2GetParamGetServiceIdInt17((MappingObject) obj, i2);
        }
        return onChangeParam((MathParam) obj, i2);
    }

    private boolean onChangeParam(MathParam mathParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i == 909) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetListComRigolScopeRArrayMsgMathList2GetParamGetServiceIdInt17(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        } else {
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
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
            long r2 = r1.mDirtyFlags     // Catch: java.lang.Throwable -> La1
            r4 = 0
            r1.mDirtyFlags = r4     // Catch: java.lang.Throwable -> La1
            monitor-exit(r20)     // Catch: java.lang.Throwable -> La1
            com.rigol.scope.data.MathParam r6 = r1.mParam
            r7 = 31
            long r7 = r7 & r2
            int r7 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            r8 = 27
            r10 = 64
            r12 = 21
            r14 = 32
            r16 = 0
            if (r7 == 0) goto L5f
            long r17 = r2 & r12
            int r7 = (r17 > r4 ? 1 : (r17 == r4 ? 0 : -1))
            if (r7 == 0) goto L34
            if (r6 == 0) goto L2a
            boolean r17 = r6.getStatus()
            goto L2c
        L2a:
            r17 = r16
        L2c:
            if (r7 == 0) goto L36
            if (r17 == 0) goto L32
            long r2 = r2 | r10
            goto L36
        L32:
            long r2 = r2 | r14
            goto L36
        L34:
            r17 = r16
        L36:
            long r18 = r2 & r8
            int r7 = (r18 > r4 ? 1 : (r18 == r4 ? 0 : -1))
            if (r7 == 0) goto L61
            if (r6 == 0) goto L43
            int r7 = r6.getServiceId()
            goto L45
        L43:
            r7 = r16
        L45:
            int r7 = r7 + (-17)
            r18 = 2130903409(0x7f030171, float:1.7413635E38)
            java.util.List r0 = com.rigol.scope.utilities.ViewUtil.getList(r18)
            java.lang.Object r0 = r0.get(r7)
            com.rigol.scope.data.MappingObject r0 = (com.rigol.scope.data.MappingObject) r0
            r7 = 1
            r1.updateRegistration(r7, r0)
            if (r0 == 0) goto L61
            java.lang.String r0 = r0.getStr()
            goto L62
        L5f:
            r17 = r16
        L61:
            r0 = 0
        L62:
            long r14 = r14 & r2
            int r7 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
            if (r7 == 0) goto L6e
            if (r6 == 0) goto L6e
            int r7 = r6.getClosedColor()
            goto L70
        L6e:
            r7 = r16
        L70:
            long r10 = r10 & r2
            int r10 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r10 == 0) goto L7c
            if (r6 == 0) goto L7c
            int r6 = r6.getDefaultColor()
            goto L7e
        L7c:
            r6 = r16
        L7e:
            long r10 = r2 & r12
            int r10 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r10 == 0) goto L8b
            if (r17 == 0) goto L89
            r16 = r6
            goto L8b
        L89:
            r16 = r7
        L8b:
            if (r10 == 0) goto L96
            android.widget.TextView r6 = r1.text1
            android.graphics.drawable.ColorDrawable r7 = androidx.databinding.adapters.Converters.convertColorToDrawable(r16)
            androidx.databinding.adapters.ViewBindingAdapter.setBackground(r6, r7)
        L96:
            long r2 = r2 & r8
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto La0
            android.widget.TextView r2 = r1.text1
            androidx.databinding.adapters.TextViewBindingAdapter.setText(r2, r0)
        La0:
            return
        La1:
            r0 = move-exception
            monitor-exit(r20)     // Catch: java.lang.Throwable -> La1
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rigol.scope.databinding.AdapterItemSparrpwMathBindingImpl.executeBindings():void");
    }
}
