package com.rigol.scope.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.VerticalParam;
/* loaded from: classes2.dex */
public class AdapterItemVerticalBindingImpl extends AdapterItemVerticalBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    public AdapterItemVerticalBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 9, sIncludes, sViewsWithIds));
    }

    private AdapterItemVerticalBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3, (ImageView) objArr[6], (TextView) objArr[7], (ImageView) objArr[4], (ImageView) objArr[5], (ImageView) objArr[8], (TextView) objArr[3], (TextView) objArr[2], (TextView) objArr[1]);
        this.mDirtyFlags = -1L;
        this.bandLimit.setTag(null);
        this.bandLimitText.setTag(null);
        this.coupling1.setTag(null);
        this.impedance.setTag(null);
        this.invert.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.position.setTag(null);
        this.scale.setTag(null);
        this.title.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = PlaybackStateCompat.ACTION_PLAY_FROM_URI;
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
            setParam((VerticalParam) obj);
            return true;
        }
        return false;
    }

    @Override // com.rigol.scope.databinding.AdapterItemVerticalBinding
    public void setParam(VerticalParam verticalParam) {
        updateRegistration(1, verticalParam);
        this.mParam = verticalParam;
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
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgChanBwlimitParamBandLimitValue1((MappingObject) obj, i2);
            }
            return onChangeParam((VerticalParam) obj, i2);
        }
        return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgChanCoupParamCouplingValue1((MappingObject) obj, i2);
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgChanCoupParamCouplingValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i == 638) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeParam(VerticalParam verticalParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        } else if (i == 909) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        } else if (i == 774) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        } else if (i == 987) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        } else if (i == 565) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
            }
            return true;
        } else if (i == 193) {
            synchronized (this) {
                this.mDirtyFlags |= 256;
            }
            return true;
        } else if (i == 431) {
            synchronized (this) {
                this.mDirtyFlags |= 512;
            }
            return true;
        } else if (i == 71) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 444) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgChanBwlimitParamBandLimitValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
            }
            return true;
        } else {
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:150:0x0236, code lost:
        if (r40 != false) goto L194;
     */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0288  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x02a6  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0309  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x033f  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0346  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0393  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x039d  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x03ad  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x03b9  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x03c4  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x03d0  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x03de  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x03ec  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x03fa  */
    /* JADX WARN: Removed duplicated region for block: B:227:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0103 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0111  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 1029
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rigol.scope.databinding.AdapterItemVerticalBindingImpl.executeBindings():void");
    }
}
