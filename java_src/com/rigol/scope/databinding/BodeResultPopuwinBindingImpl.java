package com.rigol.scope.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
import com.rigol.scope.data.BodeParam;
import com.rigol.scope.data.FftParam;
import com.rigol.scope.data.MappingObject;
/* loaded from: classes2.dex */
public class BodeResultPopuwinBindingImpl extends BodeResultPopuwinBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;
    private final TextView mboundView2;
    private final TextView mboundView3;
    private final TextView mboundView4;
    private final TextView mboundView5;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.guideline_center, 6);
        sViewsWithIds.put(R.id.guideline_center2, 7);
        sViewsWithIds.put(R.id.guideline_center12, 8);
        sViewsWithIds.put(R.id.nothing_text1, 9);
        sViewsWithIds.put(R.id.nothing_text2, 10);
        sViewsWithIds.put(R.id.nothing_text6, 11);
        sViewsWithIds.put(R.id.nothing_text12, 12);
        sViewsWithIds.put(R.id.nothing_text21, 13);
    }

    public BodeResultPopuwinBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 14, sIncludes, sViewsWithIds));
    }

    private BodeResultPopuwinBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 4, (Guideline) objArr[6], (Guideline) objArr[8], (Guideline) objArr[7], (TextView) objArr[1], (TextView) objArr[9], (TextView) objArr[12], (TextView) objArr[10], (TextView) objArr[13], (TextView) objArr[11]);
        this.mDirtyFlags = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView = (TextView) objArr[2];
        this.mboundView2 = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[3];
        this.mboundView3 = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) objArr[4];
        this.mboundView4 = textView3;
        textView3.setTag(null);
        TextView textView4 = (TextView) objArr[5];
        this.mboundView5 = textView4;
        textView4.setTag(null);
        this.nothingText.setTag(null);
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
        if (1 == i) {
            setAmpOrderMapping((MappingObject) obj);
            return true;
        } else if (594 == i) {
            setParam((FftParam) obj);
            return true;
        } else if (6 == i) {
            setFreqOrderMapping((MappingObject) obj);
            return true;
        } else if (100 == i) {
            setBodeParam((BodeParam) obj);
            return true;
        } else {
            return false;
        }
    }

    @Override // com.rigol.scope.databinding.BodeResultPopuwinBinding
    public void setAmpOrderMapping(MappingObject mappingObject) {
        this.mAmpOrderMapping = mappingObject;
    }

    @Override // com.rigol.scope.databinding.BodeResultPopuwinBinding
    public void setParam(FftParam fftParam) {
        this.mParam = fftParam;
    }

    @Override // com.rigol.scope.databinding.BodeResultPopuwinBinding
    public void setFreqOrderMapping(MappingObject mappingObject) {
        this.mFreqOrderMapping = mappingObject;
    }

    @Override // com.rigol.scope.databinding.BodeResultPopuwinBinding
    public void setBodeParam(BodeParam bodeParam) {
        updateRegistration(3, bodeParam);
        this.mBodeParam = bodeParam;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(100);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return false;
                    }
                    return onChangeBodeParam((BodeParam) obj, i2);
                }
                return onChangeFreqOrderMapping((MappingObject) obj, i2);
            }
            return onChangeParam((FftParam) obj, i2);
        }
        return onChangeAmpOrderMapping((MappingObject) obj, i2);
    }

    private boolean onChangeAmpOrderMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeParam(FftParam fftParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeFreqOrderMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeBodeParam(BodeParam bodeParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void executeBindings() {
        /*
            r7 = this;
            monitor-enter(r7)
            long r0 = r7.mDirtyFlags     // Catch: java.lang.Throwable -> L61
            r2 = 0
            r7.mDirtyFlags = r2     // Catch: java.lang.Throwable -> L61
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L61
            com.rigol.scope.data.BodeParam r4 = r7.mBodeParam
            r5 = 24
            long r0 = r0 & r5
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            r1 = 0
            if (r0 == 0) goto L41
            if (r4 == 0) goto L19
            java.util.ArrayList r2 = r4.getBode_resultlist()
            goto L1a
        L19:
            r2 = r1
        L1a:
            if (r2 == 0) goto L41
            r1 = 4
            java.lang.Object r1 = r2.get(r1)
            java.lang.String r1 = (java.lang.String) r1
            r3 = 8
            java.lang.Object r3 = r2.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            r4 = 7
            java.lang.Object r4 = r2.get(r4)
            java.lang.String r4 = (java.lang.String) r4
            r5 = 3
            java.lang.Object r5 = r2.get(r5)
            java.lang.String r5 = (java.lang.String) r5
            r6 = 5
            java.lang.Object r2 = r2.get(r6)
            java.lang.String r2 = (java.lang.String) r2
            goto L45
        L41:
            r2 = r1
            r3 = r2
            r4 = r3
            r5 = r4
        L45:
            if (r0 == 0) goto L60
            android.widget.TextView r0 = r7.mboundView2
            androidx.databinding.adapters.TextViewBindingAdapter.setText(r0, r1)
            android.widget.TextView r0 = r7.mboundView3
            androidx.databinding.adapters.TextViewBindingAdapter.setText(r0, r2)
            android.widget.TextView r0 = r7.mboundView4
            androidx.databinding.adapters.TextViewBindingAdapter.setText(r0, r4)
            android.widget.TextView r0 = r7.mboundView5
            androidx.databinding.adapters.TextViewBindingAdapter.setText(r0, r3)
            android.widget.TextView r0 = r7.nothingText
            androidx.databinding.adapters.TextViewBindingAdapter.setText(r0, r5)
        L60:
            return
        L61:
            r0 = move-exception
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L61
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rigol.scope.databinding.BodeResultPopuwinBindingImpl.executeBindings():void");
    }
}
