package com.rigol.scope.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.core.widget.ContentLoadingProgressBar;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.rigol.lib.data.Firmware;
import com.rigol.scope.R;
import com.rigol.scope.data.UpdateParam;
import com.rigol.scope.data.UtilityParam;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.views.NumberProgressBar;

/* loaded from: classes2.dex */
public class PopupviewUpdateBindingImpl extends PopupviewUpdateBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.guideline_center, 7);
        sViewsWithIds.put(R.id.content_layout, 8);
        sViewsWithIds.put(R.id.install_progress, 9);
        sViewsWithIds.put(R.id.install_text, 10);
        sViewsWithIds.put(R.id.button_layout, 11);
    }

    public PopupviewUpdateBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 12, sIncludes, sViewsWithIds));
    }

    private PopupviewUpdateBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (View) objArr[11], (Button) objArr[5], (TextView) objArr[1], (ScrollView) objArr[8], (NumberProgressBar) objArr[2], (TextView) objArr[4], (Guideline) objArr[7], (ConstraintLayout) objArr[3], (ContentLoadingProgressBar) objArr[9], (TextView) objArr[10], (Button) objArr[6]);
        this.mDirtyFlags = -1L;
        this.cancel.setTag(null);
        this.content.setTag(null);
        this.downloadProgress.setTag(null);
        this.errorText.setTag(null);
        this.installLayout.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.ok.setTag(null);
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
        if (994 == i) {
            setUpdateParam((UpdateParam) obj);
        } else if (1013 == i) {
            setUtilityParam((UtilityParam) obj);
        } else if (320 != i) {
            return false;
        } else {
            setFirmware((Firmware) obj);
        }
        return true;
    }

    @Override // com.rigol.scope.databinding.PopupviewUpdateBinding
    public void setUpdateParam(UpdateParam updateParam) {
        updateRegistration(0, updateParam);
        this.mUpdateParam = updateParam;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(994);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewUpdateBinding
    public void setUtilityParam(UtilityParam utilityParam) {
        updateRegistration(1, utilityParam);
        this.mUtilityParam = utilityParam;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(1013);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewUpdateBinding
    public void setFirmware(Firmware firmware) {
        this.mFirmware = firmware;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(320);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            if (i != 1) {
                return false;
            }
            return onChangeUtilityParam((UtilityParam) obj, i2);
        }
        return onChangeUpdateParam((UpdateParam) obj, i2);
    }

    private boolean onChangeUpdateParam(UpdateParam updateParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i == 248) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        } else if (i == 671) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        } else if (i == 437) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        } else if (i == 278) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        } else if (i == 279) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeUtilityParam(UtilityParam utilityParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        } else if (i == 478) {
            synchronized (this) {
                this.mDirtyFlags |= 256;
            }
            return true;
        } else {
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0161, code lost:
        if (r9 == 0) goto L86;
     */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void executeBindings() {
        long j;
        String str;
        int i;
        int i2;
        int i3;
        boolean z;
        boolean z2;
        int i4;
        int i5;
        boolean z3;
        boolean z4;
        float f;
        int i6;
        boolean z5;
        int i7;
        String str2;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        UpdateParam updateParam = this.mUpdateParam;
        UtilityParam utilityParam = this.mUtilityParam;
        Firmware firmware = this.mFirmware;
        String str3 = null;
        boolean z6 = true;
        if ((761 & j) != 0) {
            int i8 = 8;
            if ((j & 705) != 0) {
                if (updateParam != null) {
                    i = updateParam.getErrorCode();
                    str2 = updateParam.getErrorMessage();
                } else {
                    str2 = null;
                    i = 0;
                }
                int i9 = ((j & 577) > 0L ? 1 : ((j & 577) == 0L ? 0 : -1));
                if (i9 != 0) {
                    boolean z7 = i != 0;
                    if (i9 != 0) {
                        j |= z7 ? PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH : PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
                    }
                    if (!z7) {
                        i6 = 8;
                        str = ViewUtil.getErrorMessage(i, str2);
                    }
                }
                i6 = 0;
                str = ViewUtil.getErrorMessage(i, str2);
            } else {
                str = null;
                i = 0;
                i6 = 0;
            }
            if ((j & 617) != 0) {
                boolean isInstall = updateParam != null ? updateParam.isInstall() : false;
                if ((j & 545) != 0) {
                    j |= isInstall ? PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID : PlaybackStateCompat.ACTION_PREPARE;
                }
                i7 = ((j & 545) == 0 || isInstall) ? 0 : 8;
                z5 = !isInstall;
                if ((j & 617) != 0) {
                    j = z5 ? j | PlaybackStateCompat.ACTION_PREPARE_FROM_URI : j | PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
                }
            } else {
                z5 = false;
                i7 = 0;
            }
            int i10 = ((j & 521) > 0L ? 1 : ((j & 521) == 0L ? 0 : -1));
            if (i10 != 0) {
                z2 = updateParam != null ? updateParam.isDownload() : false;
                if (i10 != 0) {
                    j = z2 ? j | PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED : j | PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
                }
                if (z2) {
                    i8 = 0;
                }
            } else {
                i8 = 0;
                z2 = false;
            }
            if ((j & 529) == 0 || updateParam == null) {
                i5 = 0;
                i2 = i8;
                i3 = i6;
                z = z5;
                i4 = i7;
            } else {
                i2 = i8;
                i3 = i6;
                z = z5;
                i4 = i7;
                i5 = updateParam.getProgress();
            }
        } else {
            str = null;
            i = 0;
            i2 = 0;
            i3 = 0;
            z = false;
            z2 = false;
            i4 = 0;
            i5 = 0;
        }
        if ((j & 774) != 0) {
            str3 = ViewUtil.getUpdateContent(utilityParam != null ? utilityParam.getLanguage() : 0, firmware);
        }
        String str4 = str3;
        if ((j & PlaybackStateCompat.ACTION_PREPARE_FROM_URI) != 0) {
            if (updateParam != null) {
                z2 = updateParam.isDownload();
            }
            if ((j & 521) != 0) {
                j = z2 ? j | PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED : j | PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
            }
            z3 = !z2;
        } else {
            z3 = false;
        }
        int i11 = ((j & 617) > 0L ? 1 : ((j & 617) == 0L ? 0 : -1));
        if (i11 != 0) {
            if (!z) {
                z3 = false;
            }
            if (i11 != 0) {
                j = z3 ? j | PlaybackStateCompat.ACTION_PLAY_FROM_URI : j | PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
            }
        } else {
            z3 = false;
        }
        if ((j & PlaybackStateCompat.ACTION_PLAY_FROM_URI) != 0) {
            if (updateParam != null) {
                i = updateParam.getErrorCode();
            }
        }
        z6 = false;
        int i12 = ((j & 617) > 0L ? 1 : ((j & 617) == 0L ? 0 : -1));
        if (i12 != 0) {
            boolean z8 = z3 ? z6 : false;
            f = ContextUtil.getAlpha(z8);
            z4 = z8;
        } else {
            z4 = false;
            f = 0.0f;
        }
        if (i12 != 0) {
            if (getBuildSdkInt() >= 11) {
                this.cancel.setAlpha(f);
                this.ok.setAlpha(f);
            }
            this.cancel.setEnabled(z4);
            this.ok.setEnabled(z4);
        }
        if ((j & 774) != 0) {
            TextViewBindingAdapter.setText(this.content, str4);
        }
        if ((j & 521) != 0) {
            this.downloadProgress.setVisibility(i2);
        }
        if ((529 & j) != 0) {
            this.downloadProgress.setProgress(i5);
        }
        if ((j & 705) != 0) {
            TextViewBindingAdapter.setText(this.errorText, str);
        }
        if ((j & 577) != 0) {
            this.errorText.setVisibility(i3);
        }
        if ((j & 545) != 0) {
            this.installLayout.setVisibility(i4);
        }
    }
}
