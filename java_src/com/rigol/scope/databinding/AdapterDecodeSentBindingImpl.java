package com.rigol.scope.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
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
public class AdapterDecodeSentBindingImpl extends AdapterDecodeSentBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.decode_sent_layout, 10);
        sViewsWithIds.put(R.id.guideline_left, 11);
        sViewsWithIds.put(R.id.guideline_center, 12);
        sViewsWithIds.put(R.id.guideline_right, 13);
        sViewsWithIds.put(R.id.guideline_33, 14);
        sViewsWithIds.put(R.id.guideline_66, 15);
        sViewsWithIds.put(R.id.decode_sent_src_label, 16);
        sViewsWithIds.put(R.id.decode_sent_thres_label, 17);
        sViewsWithIds.put(R.id.decode_sent_idle_label, 18);
        sViewsWithIds.put(R.id.decode_sent_pause_label, 19);
        sViewsWithIds.put(R.id.decode_sent_tolerance_label, 20);
        sViewsWithIds.put(R.id.decode_sent_signal_type_label, 21);
        sViewsWithIds.put(R.id.decode_sent_crc_label, 22);
        sViewsWithIds.put(R.id.decode_sent_tick_label, 23);
        sViewsWithIds.put(R.id.decode_sent_nibbnum_label, 24);
    }

    public AdapterDecodeSentBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 25, sIncludes, sViewsWithIds));
    }

    private AdapterDecodeSentBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 6, (TextView) objArr[22], (TextView) objArr[9], (TextView) objArr[18], (TextView) objArr[3], (ConstraintLayout) objArr[10], (TextView) objArr[24], (TextView) objArr[4], (TextView) objArr[19], (TextView) objArr[8], (TextView) objArr[21], (TextView) objArr[6], (TextView) objArr[16], (TextView) objArr[1], (TextView) objArr[17], (TextView) objArr[2], (TextView) objArr[23], (TextView) objArr[7], (TextView) objArr[20], (TextView) objArr[5], (Guideline) objArr[14], (Guideline) objArr[15], (Guideline) objArr[12], (Guideline) objArr[11], (Guideline) objArr[13]);
        this.mDirtyFlags = -1L;
        this.decodeSentCrcValue.setTag(null);
        this.decodeSentIdleValue.setTag(null);
        this.decodeSentNibbnumValue.setTag(null);
        this.decodeSentPauseValue.setTag(null);
        this.decodeSentSignalTypeValue.setTag(null);
        this.decodeSentSrcValue.setTag(null);
        this.decodeSentThresValue.setTag(null);
        this.decodeSentTickValue.setTag(null);
        this.decodeSentToleranceValue.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
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

    @Override // com.rigol.scope.databinding.AdapterDecodeSentBinding
    public void setParam(DecodeParam decodeParam) {
        updateRegistration(3, decodeParam);
        this.mParam = decodeParam;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(594);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
                                return false;
                            }
                            return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDecodeSentIdleParamSentIdleState((MappingObject) obj, i2);
                        }
                        return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDecodeSentSignalTypeParamSentSignalType((MappingObject) obj, i2);
                    }
                    return onChangeParam((DecodeParam) obj, i2);
                }
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDecodeSentPauseParamSentPausePlus((MappingObject) obj, i2);
            }
            return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDecodeSentSrcParamSentSource((MappingObject) obj, i2);
        }
        return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDecodeSentCrcParamSentCrcFormat((MappingObject) obj, i2);
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDecodeSentCrcParamSentCrcFormat(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
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

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDecodeSentSrcParamSentSource(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDecodeSentPauseParamSentPausePlus(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeParam(DecodeParam decodeParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        } else if (i == 803) {
            synchronized (this) {
                this.mDirtyFlags |= 256;
            }
            return true;
        } else if (i == 804) {
            synchronized (this) {
                this.mDirtyFlags |= 512;
            }
            return true;
        } else if (i == 799) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 800) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
            }
            return true;
        } else if (i == 806) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
            }
            return true;
        } else if (i == 802) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            }
            return true;
        } else if (i == 805) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE;
            }
            return true;
        } else if (i == 801) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 798) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDecodeSentSignalTypeParamSentSignalType(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
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

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDecodeSentIdleParamSentIdleState(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
            }
            return true;
        } else {
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x014c  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 474
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rigol.scope.databinding.AdapterDecodeSentBindingImpl.executeBindings():void");
    }
}
