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
import androidx.databinding.adapters.CompoundButtonBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.rigol.scope.R;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.DecodeParam;
import com.rigol.scope.data.HorizontalParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.ViewUtil;
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
    */
    protected void executeBindings() {
        long j;
        float f;
        String str;
        String str2;
        String str3;
        String str4;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        int i;
        boolean z5;
        float f2;
        boolean z6;
        String str5;
        int i2;
        boolean z7;
        long j2;
        int i3;
        long j3;
        long j4;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        DecodeParam decodeParam = this.mParam;
        HorizontalParam horizontalParam = this.mHorizontalParam;
        if ((196591 & j) != 0) {
            z = ((j & 131330) == 0 || decodeParam == null) ? false : decodeParam.isOnOff();
            if ((j & 151558) != 0) {
                MappingObject mappingObject = ViewUtil.getMappingObject(R.array.msg_decode_evt_format, decodeParam != null ? decodeParam.getEvent_format() : 0);
                updateRegistration(2, mappingObject);
                if (mappingObject != null) {
                    str2 = mappingObject.getStr();
                    i2 = ((j & 133122) > 0L ? 1 : ((j & 133122) == 0L ? 0 : -1));
                    if (i2 == 0) {
                        z2 = decodeParam != null ? decodeParam.isEvent() : false;
                        boolean z8 = !z2;
                        if (i2 != 0) {
                            if (z8) {
                                j3 = j | 8388608;
                                j4 = 33554432;
                            } else {
                                j3 = j | 4194304;
                                j4 = 16777216;
                            }
                            j = j3 | j4;
                        }
                        f = z8 ? 0.5f : 1.0f;
                        z7 = !z8;
                    } else {
                        z2 = false;
                        z7 = false;
                        f = 0.0f;
                    }
                    if ((j & 131651) != 0) {
                        MappingObject mappingObject2 = ViewUtil.getMappingObject(R.array.msg_decode_format, decodeParam != null ? decodeParam.getFormat() : 0);
                        updateRegistration(0, mappingObject2);
                        if (mappingObject2 != null) {
                            str4 = mappingObject2.getStr();
                            if ((j & 172042) != 0) {
                                MappingObject mappingObject3 = ViewUtil.getMappingObject(R.array.msg_decode_evt_view, decodeParam != null ? decodeParam.getEvent_view() : 0);
                                updateRegistration(3, mappingObject3);
                                if (mappingObject3 != null) {
                                    str = mappingObject3.getStr();
                                    if ((j & 131234) == 0) {
                                        ServiceEnum.DecodeBusType type = decodeParam != null ? decodeParam.getType() : null;
                                        int i4 = ((j & 131202) > 0L ? 1 : ((j & 131202) == 0L ? 0 : -1));
                                        if (i4 != 0) {
                                            boolean isCopyTrigShow = decodeParam != null ? decodeParam.isCopyTrigShow(type) : false;
                                            if (i4 != 0) {
                                                j |= isCopyTrigShow ? PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE : PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
                                            }
                                            if (isCopyTrigShow) {
                                                i3 = 4;
                                                MappingObject mappingObject4 = ViewUtil.getMappingObject(R.array.msg_decode_type, type == null ? type.value1 : 0);
                                                updateRegistration(5, mappingObject4);
                                                str3 = mappingObject4 == null ? mappingObject4.getStr() : null;
                                                j2 = 132098;
                                            }
                                        }
                                        i3 = 0;
                                        MappingObject mappingObject42 = ViewUtil.getMappingObject(R.array.msg_decode_type, type == null ? type.value1 : 0);
                                        updateRegistration(5, mappingObject42);
                                        if (mappingObject42 == null) {
                                        }
                                        j2 = 132098;
                                    } else {
                                        str3 = null;
                                        j2 = 132098;
                                        i3 = 0;
                                    }
                                    if ((j & j2) != 0 || decodeParam == null) {
                                        z4 = z7;
                                        i = i3;
                                        z3 = false;
                                    } else {
                                        z3 = decodeParam.isLabel();
                                        z4 = z7;
                                        i = i3;
                                    }
                                }
                            }
                            str = null;
                            if ((j & 131234) == 0) {
                            }
                            if ((j & j2) != 0) {
                            }
                            z4 = z7;
                            i = i3;
                            z3 = false;
                        }
                    }
                    str4 = null;
                    if ((j & 172042) != 0) {
                    }
                    str = null;
                    if ((j & 131234) == 0) {
                    }
                    if ((j & j2) != 0) {
                    }
                    z4 = z7;
                    i = i3;
                    z3 = false;
                }
            }
            str2 = null;
            i2 = ((j & 133122) > 0L ? 1 : ((j & 133122) == 0L ? 0 : -1));
            if (i2 == 0) {
            }
            if ((j & 131651) != 0) {
            }
            str4 = null;
            if ((j & 172042) != 0) {
            }
            str = null;
            if ((j & 131234) == 0) {
            }
            if ((j & j2) != 0) {
            }
            z4 = z7;
            i = i3;
            z3 = false;
        } else {
            f = 0.0f;
            str = null;
            str2 = null;
            str3 = null;
            str4 = null;
            z = false;
            z2 = false;
            z3 = false;
            z4 = false;
            i = 0;
        }
        int i5 = ((j & 198674) > 0L ? 1 : ((j & 198674) == 0L ? 0 : -1));
        if (i5 != 0) {
            z5 = (horizontalParam != null ? horizontalParam.getRunStop() : null) == ServiceEnum.ControlAction.Control_Stop;
            if (i5 != 0) {
                j = z5 ? j | PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED : j | PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
            }
        } else {
            z5 = false;
        }
        if ((j & PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) != 0 && decodeParam != null) {
            z2 = decodeParam.isEvent();
        }
        int i6 = ((j & 198674) > 0L ? 1 : ((j & 198674) == 0L ? 0 : -1));
        if (i6 != 0) {
            boolean z9 = z5 ? z2 : false;
            f2 = ContextUtil.getAlpha(z9);
            z6 = z9;
        } else {
            f2 = 0.0f;
            z6 = false;
        }
        if ((j & 131202) != 0) {
            str5 = str3;
            this.decodeCopyTrig.setVisibility(i);
        } else {
            str5 = str3;
        }
        if (i6 != 0) {
            if (getBuildSdkInt() >= 11) {
                this.decodeEvtExport.setAlpha(f2);
                this.decodeEvtJump.setAlpha(f2);
            }
            this.decodeEvtExport.setEnabled(z6);
            this.decodeEvtJump.setEnabled(z6);
        }
        if ((j & 151558) != 0) {
            TextViewBindingAdapter.setText(this.decodeEvtFormatValue, str2);
        }
        if ((j & 133122) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.decodeEvtValue, z2);
            this.decodeEvtViewLabel.setEnabled(z4);
            this.decodeEvtViewValue.setEnabled(z4);
            if (getBuildSdkInt() >= 11) {
                this.decodeEvtViewLabel.setAlpha(f);
                this.decodeEvtViewValue.setAlpha(f);
            }
        }
        if ((172042 & j) != 0) {
            TextViewBindingAdapter.setText(this.decodeEvtViewValue, str);
        }
        if ((131651 & j) != 0) {
            TextViewBindingAdapter.setText(this.decodeFormatValue, str4);
        }
        if ((132098 & j) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.decodeLabelValue, z3);
        }
        if ((j & 131330) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.decodeOnOffValue, z);
        }
        if ((j & 131234) != 0) {
            TextViewBindingAdapter.setText(this.decodeTypeValue, str5);
        }
    }
}
