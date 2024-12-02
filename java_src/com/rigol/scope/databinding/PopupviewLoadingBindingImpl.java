package com.rigol.scope.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.core.widget.ContentLoadingProgressBar;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;

/* loaded from: classes2.dex */
public class PopupviewLoadingBindingImpl extends PopupviewLoadingBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.guideline_center, 5);
        sViewsWithIds.put(R.id.title, 6);
        sViewsWithIds.put(R.id.loading, 7);
        sViewsWithIds.put(R.id.content, 8);
    }

    public PopupviewLoadingBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 9, sIncludes, sViewsWithIds));
    }

    private PopupviewLoadingBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3, (Button) objArr[3], (Button) objArr[4], (TextView) objArr[8], (View) objArr[2], (Guideline) objArr[5], (ContentLoadingProgressBar) objArr[7], (TextView) objArr[6], (TextView) objArr[1]);
        this.mDirtyFlags = -1L;
        this.cancel.setTag(null);
        this.confirm.setTag(null);
        this.dividingLine.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.wrning.setTag(null);
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
        if (826 == i) {
            setShowConfirm((ObservableBoolean) obj);
        } else if (844 == i) {
            setShowWrning((ObservableBoolean) obj);
        } else if (825 != i) {
            return false;
        } else {
            setShowCancel((ObservableBoolean) obj);
        }
        return true;
    }

    @Override // com.rigol.scope.databinding.PopupviewLoadingBinding
    public void setShowConfirm(ObservableBoolean observableBoolean) {
        updateRegistration(0, observableBoolean);
        this.mShowConfirm = observableBoolean;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(826);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewLoadingBinding
    public void setShowWrning(ObservableBoolean observableBoolean) {
        updateRegistration(1, observableBoolean);
        this.mShowWrning = observableBoolean;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(844);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewLoadingBinding
    public void setShowCancel(ObservableBoolean observableBoolean) {
        updateRegistration(2, observableBoolean);
        this.mShowCancel = observableBoolean;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(825);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    return false;
                }
                return onChangeShowCancel((ObservableBoolean) obj, i2);
            }
            return onChangeShowWrning((ObservableBoolean) obj, i2);
        }
        return onChangeShowConfirm((ObservableBoolean) obj, i2);
    }

    private boolean onChangeShowConfirm(ObservableBoolean observableBoolean, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeShowWrning(ObservableBoolean observableBoolean, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeShowCancel(ObservableBoolean observableBoolean, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:95:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void executeBindings() {
        long j;
        int i;
        boolean z;
        int i2;
        int i3;
        boolean z2;
        int i4;
        int i5;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        ObservableBoolean observableBoolean = this.mShowConfirm;
        ObservableBoolean observableBoolean2 = this.mShowWrning;
        ObservableBoolean observableBoolean3 = this.mShowCancel;
        int i6 = ((j & 9) > 0L ? 1 : ((j & 9) == 0L ? 0 : -1));
        int i7 = 0;
        if (i6 != 0) {
            z = observableBoolean != null ? observableBoolean.get() : false;
            if (i6 != 0) {
                j = z ? j | 32 : j | 16;
            }
            i = z ? 0 : 8;
        } else {
            i = 0;
            z = false;
        }
        int i8 = ((j & 10) > 0L ? 1 : ((j & 10) == 0L ? 0 : -1));
        if (i8 != 0) {
            boolean z3 = observableBoolean2 != null ? observableBoolean2.get() : false;
            if (i8 != 0) {
                j |= z3 ? 128L : 64L;
            }
            if (!z3) {
                i2 = 8;
                i3 = ((j & 13) > 0L ? 1 : ((j & 13) == 0L ? 0 : -1));
                if (i3 == 0) {
                    z2 = observableBoolean3 != null ? observableBoolean3.get() : false;
                    if (i3 != 0) {
                        j = z2 ? j | 512 : j | 256;
                    }
                    if ((j & 12) != 0) {
                        j |= z2 ? PlaybackStateCompat.ACTION_PLAY_FROM_URI : PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
                    }
                    if ((j & 12) != 0) {
                        i4 = z2 ? 0 : 8;
                    } else {
                        i4 = 0;
                    }
                } else {
                    z2 = false;
                    i4 = 0;
                }
                if ((j & 256) != 0) {
                    if (observableBoolean != null) {
                        z = observableBoolean.get();
                    }
                    if ((j & 9) != 0) {
                        j = z ? j | 32 : j | 16;
                    }
                }
                i5 = ((j & 13) > 0L ? 1 : ((j & 13) == 0L ? 0 : -1));
                if (i5 != 0) {
                    if (z2) {
                        z = true;
                    }
                    if (i5 != 0) {
                        j |= z ? PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH : PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
                    }
                    if (!z) {
                        i7 = 8;
                    }
                }
                int i9 = i7;
                if ((j & 12) != 0) {
                    this.cancel.setVisibility(i4);
                }
                if ((j & 9) != 0) {
                    this.confirm.setVisibility(i);
                }
                if ((j & 13) != 0) {
                    this.dividingLine.setVisibility(i9);
                }
                if ((j & 10) == 0) {
                    this.wrning.setVisibility(i2);
                    return;
                }
                return;
            }
        }
        i2 = 0;
        i3 = ((j & 13) > 0L ? 1 : ((j & 13) == 0L ? 0 : -1));
        if (i3 == 0) {
        }
        if ((j & 256) != 0) {
        }
        i5 = ((j & 13) > 0L ? 1 : ((j & 13) == 0L ? 0 : -1));
        if (i5 != 0) {
        }
        int i92 = i7;
        if ((j & 12) != 0) {
        }
        if ((j & 9) != 0) {
        }
        if ((j & 13) != 0) {
        }
        if ((j & 10) == 0) {
        }
    }
}
