package com.rigol.scope.databinding;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.ImageViewBindingAdapter;
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
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 10, sIncludes, sViewsWithIds));
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
    */
    protected void executeBindings() {
        long j;
        int i;
        int i2;
        long j2;
        long j3;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        SharedParam sharedParam = this.mSharedParam;
        Drawable drawable = null;
        ObservableBoolean observableBoolean = this.mShowMainContent;
        int i3 = ((j & 13) > 0L ? 1 : ((j & 13) == 0L ? 0 : -1));
        int i4 = 0;
        if (i3 != 0) {
            boolean showResultBar = sharedParam != null ? sharedParam.getShowResultBar() : false;
            if (i3 != 0) {
                if (showResultBar) {
                    j2 = j | 32;
                    j3 = 128;
                } else {
                    j2 = j | 16;
                    j3 = 64;
                }
                j = j2 | j3;
            }
            drawable = AppCompatResources.getDrawable(this.resultsBarIcon.getContext(), showResultBar ? R.drawable.ic_menu_close : R.drawable.ic_menu_open);
            if (!showResultBar) {
                i = 8;
                i2 = ((j & 10) > 0L ? 1 : ((j & 10) == 0L ? 0 : -1));
                if (i2 != 0) {
                    boolean z = observableBoolean != null ? observableBoolean.get() : false;
                    if (i2 != 0) {
                        j |= z ? 512L : 256L;
                    }
                    i4 = z ? 8 : 0;
                }
                if ((j & 10) != 0) {
                    this.mboundView3.setVisibility(i4);
                    this.progress.setVisibility(i4);
                }
                if ((j & 13) == 0) {
                    this.resultsBar.setVisibility(i);
                    ImageViewBindingAdapter.setImageDrawable(this.resultsBarIcon, drawable);
                    return;
                }
                return;
            }
        }
        i = 0;
        i2 = ((j & 10) > 0L ? 1 : ((j & 10) == 0L ? 0 : -1));
        if (i2 != 0) {
        }
        if ((j & 10) != 0) {
        }
        if ((j & 13) == 0) {
        }
    }
}
