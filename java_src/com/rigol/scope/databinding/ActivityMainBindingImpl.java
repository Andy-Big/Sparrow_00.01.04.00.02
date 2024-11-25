package com.rigol.scope.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentContainerView;
import com.rigol.scope.R;
import com.rigol.scope.data.SharedParam;
/* loaded from: classes2.dex */
public class ActivityMainBindingImpl extends ActivityMainBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView3;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.navigation_bar, 5);
        sViewsWithIds.put(R.id.settings_bar, 6);
        sViewsWithIds.put(R.id.waveform, 7);
        sViewsWithIds.put(R.id.image_logo, 8);
    }

    public ActivityMainBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 9, sIncludes, sViewsWithIds));
    }

    private ActivityMainBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (ImageView) objArr[8], (ConstraintLayout) objArr[0], (FragmentContainerView) objArr[5], (ImageView) objArr[4], (FragmentContainerView) objArr[2], (ImageView) objArr[1], (FragmentContainerView) objArr[6], (FragmentContainerView) objArr[7]);
        this.mDirtyFlags = -1L;
        this.mainLayout.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[3];
        this.mboundView3 = constraintLayout;
        constraintLayout.setTag(null);
        this.progress.setTag(null);
        this.resultsBar.setTag(null);
        this.resultsBarIcon.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 8L;
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
        if (823 == i) {
            setSharedParam((SharedParam) obj);
        } else if (829 != i) {
            return false;
        } else {
            setShowMainContent((ObservableBoolean) obj);
        }
        return true;
    }

    @Override // com.rigol.scope.databinding.ActivityMainBinding
    public void setSharedParam(SharedParam sharedParam) {
        updateRegistration(0, sharedParam);
        this.mSharedParam = sharedParam;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(823);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.ActivityMainBinding
    public void setShowMainContent(ObservableBoolean observableBoolean) {
        updateRegistration(1, observableBoolean);
        this.mShowMainContent = observableBoolean;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(829);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            if (i != 1) {
                return false;
            }
            return onChangeShowMainContent((ObservableBoolean) obj, i2);
        }
        return onChangeSharedParam((SharedParam) obj, i2);
    }

    private boolean onChangeSharedParam(SharedParam sharedParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i == 833) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeShowMainContent(ObservableBoolean observableBoolean, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
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
            com.rigol.scope.data.SharedParam r0 = r1.mSharedParam
            r6 = 0
            androidx.databinding.ObservableBoolean r7 = r1.mShowMainContent
            r8 = 13
            long r10 = r2 & r8
            int r10 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            r11 = 8
            r12 = 0
            if (r10 == 0) goto L4a
            if (r0 == 0) goto L21
            boolean r0 = r0.getShowResultBar()
            goto L22
        L21:
            r0 = r12
        L22:
            if (r10 == 0) goto L32
            if (r0 == 0) goto L2c
            r13 = 32
            long r2 = r2 | r13
            r13 = 128(0x80, double:6.32E-322)
            goto L31
        L2c:
            r13 = 16
            long r2 = r2 | r13
            r13 = 64
        L31:
            long r2 = r2 | r13
        L32:
            android.widget.ImageView r6 = r1.resultsBarIcon
            android.content.Context r6 = r6.getContext()
            if (r0 == 0) goto L3e
            r10 = 2131231950(0x7f0804ce, float:1.8079995E38)
            goto L41
        L3e:
            r10 = 2131231951(0x7f0804cf, float:1.8079998E38)
        L41:
            android.graphics.drawable.Drawable r6 = androidx.appcompat.content.res.AppCompatResources.getDrawable(r6, r10)
            if (r0 == 0) goto L48
            goto L4a
        L48:
            r0 = r11
            goto L4b
        L4a:
            r0 = r12
        L4b:
            r13 = 10
            long r15 = r2 & r13
            int r10 = (r15 > r4 ? 1 : (r15 == r4 ? 0 : -1))
            if (r10 == 0) goto L6a
            if (r7 == 0) goto L5a
            boolean r7 = r7.get()
            goto L5b
        L5a:
            r7 = r12
        L5b:
            if (r10 == 0) goto L65
            if (r7 == 0) goto L62
            r15 = 512(0x200, double:2.53E-321)
            goto L64
        L62:
            r15 = 256(0x100, double:1.265E-321)
        L64:
            long r2 = r2 | r15
        L65:
            if (r7 == 0) goto L68
            goto L69
        L68:
            r11 = r12
        L69:
            r12 = r11
        L6a:
            long r10 = r2 & r13
            int r7 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r7 == 0) goto L7a
            androidx.constraintlayout.widget.ConstraintLayout r7 = r1.mboundView3
            r7.setVisibility(r12)
            android.widget.ImageView r7 = r1.progress
            r7.setVisibility(r12)
        L7a:
            long r2 = r2 & r8
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L89
            androidx.fragment.app.FragmentContainerView r2 = r1.resultsBar
            r2.setVisibility(r0)
            android.widget.ImageView r0 = r1.resultsBarIcon
            androidx.databinding.adapters.ImageViewBindingAdapter.setImageDrawable(r0, r6)
        L89:
            return
        L8a:
            r0 = move-exception
            monitor-exit(r17)     // Catch: java.lang.Throwable -> L8a
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rigol.scope.databinding.ActivityMainBindingImpl.executeBindings():void");
    }
}
