package com.rigol.scope.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.rigol.scope.R;
import com.rigol.scope.data.DecodeParam;
import com.rigol.scope.data.HorizontalParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.views.SwitchButton;
/* loaded from: classes2.dex */
public class AdapterItemPopupviewDecodeBindingImpl extends AdapterItemPopupviewDecodeBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.decode_common_layout, 12);
        sViewsWithIds.put(R.id.guideline_left, 13);
        sViewsWithIds.put(R.id.guideline_center, 14);
        sViewsWithIds.put(R.id.guideline_right, 15);
        sViewsWithIds.put(R.id.guideline_33, 16);
        sViewsWithIds.put(R.id.guideline_66, 17);
        sViewsWithIds.put(R.id.decode_type_label, 18);
        sViewsWithIds.put(R.id.decode_onOff_label, 19);
        sViewsWithIds.put(R.id.decode_divider1, 20);
        sViewsWithIds.put(R.id.decode_busType_view, 21);
        sViewsWithIds.put(R.id.decode_divider2, 22);
        sViewsWithIds.put(R.id.decode_format_label, 23);
        sViewsWithIds.put(R.id.decode_label_label, 24);
        sViewsWithIds.put(R.id.decode_evt_label, 25);
        sViewsWithIds.put(R.id.decode_evt_format_label, 26);
    }

    public AdapterItemPopupviewDecodeBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 27, sIncludes, sViewsWithIds));
    }

    private AdapterItemPopupviewDecodeBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 6, (RecyclerView) objArr[21], (ConstraintLayout) objArr[12], (Button) objArr[11], (View) objArr[20], (View) objArr[22], (Button) objArr[9], (TextView) objArr[26], (TextView) objArr[6], (Button) objArr[10], (TextView) objArr[25], (SwitchButton) objArr[5], (TextView) objArr[7], (TextView) objArr[8], (TextView) objArr[23], (TextView) objArr[3], (TextView) objArr[24], (SwitchButton) objArr[4], (TextView) objArr[19], (SwitchButton) objArr[2], (TextView) objArr[18], (TextView) objArr[1], (Guideline) objArr[16], (Guideline) objArr[17], (Guideline) objArr[14], (Guideline) objArr[13], (Guideline) objArr[15]);
        this.mDirtyFlags = -1L;
        this.decodeCopyTrig.setTag(null);
        this.decodeEvtExport.setTag(null);
        this.decodeEvtFormatValue.setTag(null);
        this.decodeEvtJump.setTag(null);
        this.decodeEvtValue.setTag(null);
        this.decodeEvtViewLabel.setTag(null);
        this.decodeEvtViewValue.setTag(null);
        this.decodeFormatValue.setTag(null);
        this.decodeLabelValue.setTag(null);
        this.decodeOnOffValue.setTag(null);
        this.decodeTypeValue.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
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
        } else if (382 != i) {
            return false;
        } else {
            setHorizontalParam((HorizontalParam) obj);
        }
        return true;
    }

    @Override // com.rigol.scope.databinding.AdapterItemPopupviewDecodeBinding
    public void setParam(DecodeParam decodeParam) {
        updateRegistration(1, decodeParam);
        this.mParam = decodeParam;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(594);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterItemPopupviewDecodeBinding
    public void setHorizontalParam(HorizontalParam horizontalParam) {
        updateRegistration(4, horizontalParam);
        this.mHorizontalParam = horizontalParam;
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        notifyPropertyChanged(382);
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
                            return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDecodeTypeParamTypeValue1((MappingObject) obj, i2);
                        }
                        return onChangeHorizontalParam((HorizontalParam) obj, i2);
                    }
                    return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDecodeEvtViewParamEventView((MappingObject) obj, i2);
                }
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDecodeEvtFormatParamEventFormat((MappingObject) obj, i2);
            }
            return onChangeParam((DecodeParam) obj, i2);
        }
        return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDecodeFormatParamFormat((MappingObject) obj, i2);
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDecodeFormatParamFormat(MappingObject mappingObject, int i) {
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

    private boolean onChangeParam(DecodeParam decodeParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        } else if (i == 978) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
            }
            return true;
        } else if (i == 570) {
            synchronized (this) {
                this.mDirtyFlags |= 256;
            }
            return true;
        } else if (i == 334) {
            synchronized (this) {
                this.mDirtyFlags |= 512;
            }
            return true;
        } else if (i == 475) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 284) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
            }
            return true;
        } else if (i == 285) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
            }
            return true;
        } else if (i == 286) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDecodeEvtFormatParamEventFormat(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDecodeEvtViewParamEventView(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeHorizontalParam(HorizontalParam horizontalParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        } else if (i == 760) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDecodeTypeParamTypeValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x013a A[ADDED_TO_REGION] */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 593
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rigol.scope.databinding.AdapterItemPopupviewDecodeBindingImpl.executeBindings():void");
    }
}
