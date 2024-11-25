package com.rigol.scope.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
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
import com.rigol.scope.data.SharedParam;
import com.rigol.scope.data.VerticalParam;
/* loaded from: classes2.dex */
public class AdapterItemPopupviewProbeBindingImpl extends AdapterItemPopupviewProbeBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;
    private final TextView mboundView8;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.guideline_center, 19);
        sViewsWithIds.put(R.id.guideline_left, 20);
        sViewsWithIds.put(R.id.guideline_right, 21);
        sViewsWithIds.put(R.id.probe_delay, 22);
    }

    public AdapterItemPopupviewProbeBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 23, sIncludes, sViewsWithIds));
    }

    private AdapterItemPopupviewProbeBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3, (Guideline) objArr[19], (Guideline) objArr[20], (Guideline) objArr[21], (TextView) objArr[4], (EditText) objArr[5], (TextView) objArr[6], (Button) objArr[7], (TextView) objArr[17], (TextView) objArr[18], (TextView) objArr[22], (EditText) objArr[3], (TextView) objArr[9], (Button) objArr[10], (TextView) objArr[11], (TextView) objArr[12], (TextView) objArr[15], (TextView) objArr[16], (TextView) objArr[1], (TextView) objArr[2], (TextView) objArr[13], (TextView) objArr[14]);
        this.mDirtyFlags = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView = (TextView) objArr[8];
        this.mboundView8 = textView;
        textView.setTag(null);
        this.probeBias.setTag(null);
        this.probeBiasEditText.setTag(null);
        this.probeCal.setTag(null);
        this.probeCalButton.setTag(null);
        this.probeCalTime.setTag(null);
        this.probeCalTimeText.setTag(null);
        this.probeDelayEditText.setTag(null);
        this.probeDemag.setTag(null);
        this.probeDemagButton.setTag(null);
        this.probeMfr.setTag(null);
        this.probeMfrText.setTag(null);
        this.probeModel.setTag(null);
        this.probeModelText.setTag(null);
        this.probeRatio.setTag(null);
        this.probeRatioSpinner.setTag(null);
        this.probeSn.setTag(null);
        this.probeSnText.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
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
        if (1027 == i) {
            setVerticalParam((VerticalParam) obj);
        } else if (179 == i) {
            setClickListener((View.OnClickListener) obj);
        } else if (823 != i) {
            return false;
        } else {
            setSharedParam((SharedParam) obj);
        }
        return true;
    }

    @Override // com.rigol.scope.databinding.AdapterItemPopupviewProbeBinding
    public void setVerticalParam(VerticalParam verticalParam) {
        updateRegistration(0, verticalParam);
        this.mVerticalParam = verticalParam;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(1027);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterItemPopupviewProbeBinding
    public void setClickListener(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(179);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterItemPopupviewProbeBinding
    public void setSharedParam(SharedParam sharedParam) {
        this.mSharedParam = sharedParam;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    return false;
                }
                return onChangeSharedParam((SharedParam) obj, i2);
            }
            return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgChanProbeVerticalParamProbeRatioValue1((MappingObject) obj, i2);
        }
        return onChangeVerticalParam((VerticalParam) obj, i2);
    }

    private boolean onChangeVerticalParam(VerticalParam verticalParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i == 666) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        } else if (i == 662) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        } else if (i == 670) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        } else if (i == 665) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
            }
            return true;
        } else if (i == 659) {
            synchronized (this) {
                this.mDirtyFlags |= 256;
            }
            return true;
        } else if (i == 664) {
            synchronized (this) {
                this.mDirtyFlags |= 512;
            }
            return true;
        } else if (i == 658) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 655) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
            }
            return true;
        } else if (i == 656) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
            }
            return true;
        } else if (i == 660) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            }
            return true;
        } else if (i == 663) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE;
            }
            return true;
        } else if (i == 669) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 657) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgChanProbeVerticalParamProbeRatioValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeSharedParam(SharedParam sharedParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:323:0x0541  */
    /* JADX WARN: Removed duplicated region for block: B:337:0x0565  */
    /* JADX WARN: Removed duplicated region for block: B:349:0x0587  */
    /* JADX WARN: Removed duplicated region for block: B:352:0x0593  */
    /* JADX WARN: Removed duplicated region for block: B:363:0x05ad  */
    /* JADX WARN: Removed duplicated region for block: B:366:0x05be  */
    /* JADX WARN: Removed duplicated region for block: B:370:0x05f1  */
    /* JADX WARN: Removed duplicated region for block: B:373:0x05fd  */
    /* JADX WARN: Removed duplicated region for block: B:379:0x0623  */
    /* JADX WARN: Removed duplicated region for block: B:382:0x0644  */
    /* JADX WARN: Removed duplicated region for block: B:385:0x0651  */
    /* JADX WARN: Removed duplicated region for block: B:390:0x06a9  */
    /* JADX WARN: Removed duplicated region for block: B:393:0x06bb  */
    /* JADX WARN: Removed duplicated region for block: B:396:0x06c8  */
    /* JADX WARN: Removed duplicated region for block: B:399:0x06d5  */
    /* JADX WARN: Removed duplicated region for block: B:402:0x06e7  */
    /* JADX WARN: Removed duplicated region for block: B:405:0x06fb  */
    /* JADX WARN: Removed duplicated region for block: B:408:0x0708  */
    /* JADX WARN: Removed duplicated region for block: B:411:0x071c  */
    /* JADX WARN: Removed duplicated region for block: B:414:0x0729  */
    /* JADX WARN: Removed duplicated region for block: B:420:0x0753  */
    /* JADX WARN: Removed duplicated region for block: B:423:0x0760  */
    /* JADX WARN: Removed duplicated region for block: B:426:0x0774  */
    /* JADX WARN: Removed duplicated region for block: B:433:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x016b  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 1919
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rigol.scope.databinding.AdapterItemPopupviewProbeBindingImpl.executeBindings():void");
    }
}
