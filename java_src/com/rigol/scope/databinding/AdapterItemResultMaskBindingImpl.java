package com.rigol.scope.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
import com.rigol.scope.data.ResultParam;
import com.rigol.scope.views.DisableTouchEventRecyclerView;
import com.rigol.scope.views.resultItem.ResultItemConstraintLayout;
/* loaded from: classes2.dex */
public class AdapterItemResultMaskBindingImpl extends AdapterItemResultMaskBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ResultItemConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.title_layout, 3);
        sViewsWithIds.put(R.id.result_list, 4);
    }

    public AdapterItemResultMaskBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 5, sIncludes, sViewsWithIds));
    }

    private AdapterItemResultMaskBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (ImageView) objArr[1], (DisableTouchEventRecyclerView) objArr[4], (TextView) objArr[2], (ConstraintLayout) objArr[3]);
        this.mDirtyFlags = -1L;
        this.icon.setTag(null);
        ResultItemConstraintLayout resultItemConstraintLayout = (ResultItemConstraintLayout) objArr[0];
        this.mboundView0 = resultItemConstraintLayout;
        resultItemConstraintLayout.setTag(null);
        this.title.setTag(null);
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
            setParam((ResultParam) obj);
            return true;
        }
        return false;
    }

    @Override // com.rigol.scope.databinding.AdapterItemResultMaskBinding
    public void setParam(ResultParam resultParam) {
        updateRegistration(0, resultParam);
        this.mParam = resultParam;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(594);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return onChangeParam((ResultParam) obj, i2);
    }

    private boolean onChangeParam(ResultParam resultParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i == 528) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        } else if (i == 939) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else if (i == 862) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        } else {
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:64:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void executeBindings() {
        /*
            r21 = this;
            r1 = r21
            monitor-enter(r21)
            long r2 = r1.mDirtyFlags     // Catch: java.lang.Throwable -> Lb1
            r4 = 0
            r1.mDirtyFlags = r4     // Catch: java.lang.Throwable -> Lb1
            monitor-exit(r21)     // Catch: java.lang.Throwable -> Lb1
            com.rigol.scope.data.ResultParam r0 = r1.mParam
            r6 = 31
            long r6 = r6 & r2
            int r6 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            r8 = 29
            r10 = 64
            r12 = 19
            r15 = 0
            if (r6 == 0) goto L6f
            long r16 = r2 & r8
            int r6 = (r16 > r4 ? 1 : (r16 == r4 ? 0 : -1))
            if (r6 == 0) goto L3c
            if (r0 == 0) goto L2d
            java.lang.String r6 = r0.getTitle()
            com.rigol.scope.cil.ServiceEnum$Chan r16 = r0.getSourceA()
            r7 = r16
            goto L2f
        L2d:
            r6 = 0
            r7 = 0
        L2f:
            android.view.View r17 = r21.getRoot()
            android.content.Context r14 = r17.getContext()
            android.text.SpannableString r6 = com.rigol.scope.utilities.ViewUtil.getTitleWithSrc(r14, r6, r7)
            goto L3d
        L3c:
            r6 = 0
        L3d:
            long r19 = r2 & r12
            int r7 = (r19 > r4 ? 1 : (r19 == r4 ? 0 : -1))
            if (r7 == 0) goto L6d
            if (r0 == 0) goto L4a
            com.rigol.scope.cil.ServiceEnum$MeasType r0 = r0.getMeasType()
            goto L4b
        L4a:
            r0 = 0
        L4b:
            if (r0 == 0) goto L50
            java.lang.String r14 = r0.pic1
            goto L51
        L50:
            r14 = 0
        L51:
            if (r0 == 0) goto L55
            r0 = 1
            goto L56
        L55:
            r0 = r15
        L56:
            if (r7 == 0) goto L60
            if (r0 == 0) goto L5c
            long r2 = r2 | r10
            goto L60
        L5c:
            r17 = 32
            long r2 = r2 | r17
        L60:
            android.view.View r7 = r21.getRoot()
            android.content.Context r7 = r7.getContext()
            android.graphics.drawable.Drawable r14 = com.rigol.scope.utilities.ContextUtil.getDrawable(r7, r14)
            goto L72
        L6d:
            r0 = r15
            goto L71
        L6f:
            r0 = r15
            r6 = 0
        L71:
            r14 = 0
        L72:
            long r10 = r10 & r2
            int r7 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r7 == 0) goto L7b
            if (r14 == 0) goto L7b
            r7 = 1
            goto L7c
        L7b:
            r7 = r15
        L7c:
            long r10 = r2 & r12
            int r10 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r10 == 0) goto L96
            if (r0 == 0) goto L85
            goto L86
        L85:
            r7 = r15
        L86:
            if (r10 == 0) goto L90
            if (r7 == 0) goto L8d
            r10 = 256(0x100, double:1.265E-321)
            goto L8f
        L8d:
            r10 = 128(0x80, double:6.32E-322)
        L8f:
            long r2 = r2 | r10
        L90:
            if (r7 == 0) goto L93
            goto L96
        L93:
            r0 = 8
            r15 = r0
        L96:
            long r10 = r2 & r12
            int r0 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r0 == 0) goto La6
            android.widget.ImageView r0 = r1.icon
            androidx.databinding.adapters.ImageViewBindingAdapter.setImageDrawable(r0, r14)
            android.widget.ImageView r0 = r1.icon
            r0.setVisibility(r15)
        La6:
            long r2 = r2 & r8
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto Lb0
            android.widget.TextView r0 = r1.title
            androidx.databinding.adapters.TextViewBindingAdapter.setText(r0, r6)
        Lb0:
            return
        Lb1:
            r0 = move-exception
            monitor-exit(r21)     // Catch: java.lang.Throwable -> Lb1
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rigol.scope.databinding.AdapterItemResultMaskBindingImpl.executeBindings():void");
    }
}
