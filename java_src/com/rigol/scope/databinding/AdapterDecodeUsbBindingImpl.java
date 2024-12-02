package com.rigol.scope.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.CompoundButtonBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.rigol.scope.R;
import com.rigol.scope.data.DecodeParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.utilities.ColorUtil;
import com.rigol.scope.utilities.ViewUtil;

/* loaded from: classes2.dex */
public class AdapterDecodeUsbBindingImpl extends AdapterDecodeUsbBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.decode_usb_layout, 18);
        sViewsWithIds.put(R.id.divider1, 19);
        sViewsWithIds.put(R.id.decode_usb_sig_label, 20);
        sViewsWithIds.put(R.id.decode_usb_sig_radioGroup, 21);
    }

    public AdapterDecodeUsbBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 22, sIncludes, sViewsWithIds));
    }

    private AdapterDecodeUsbBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 7, (TextView) objArr[12], (TextView) objArr[14], (TextView) objArr[17], (TextView) objArr[15], (TextView) objArr[16], (TextView) objArr[13], (TextView) objArr[1], (TextView) objArr[3], (TextView) objArr[4], (TextView) objArr[2], (TextView) objArr[8], (TextView) objArr[11], (TextView) objArr[10], (TextView) objArr[9], (RadioButton) objArr[7], (ConstraintLayout) objArr[18], (RadioButton) objArr[5], (RadioButton) objArr[6], (TextView) objArr[20], (RadioGroup) objArr[21], (View) objArr[19]);
        this.mDirtyFlags = -1L;
        this.decodeUsbDiffLabel.setTag(null);
        this.decodeUsbDiffThreHLabel.setTag(null);
        this.decodeUsbDiffThreHValue.setTag(null);
        this.decodeUsbDiffThreLLabel.setTag(null);
        this.decodeUsbDiffThreLValue.setTag(null);
        this.decodeUsbDiffValue.setTag(null);
        this.decodeUsbDpLabel.setTag(null);
        this.decodeUsbDpThresLabel.setTag(null);
        this.decodeUsbDpThresValue.setTag(null);
        this.decodeUsbDpValue.setTag(null);
        this.decodeUsbDsLabel.setTag(null);
        this.decodeUsbDsThresLabel.setTag(null);
        this.decodeUsbDsThresValue.setTag(null);
        this.decodeUsbDsValue.setTag(null);
        this.decodeUsbHighRadioButton.setTag(null);
        this.decodeUsbLowRadioButton.setTag(null);
        this.decodeUsbMidRadioButton.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
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
        if (996 == i) {
            setUsbHighMapping((MappingObject) obj);
        } else if (998 == i) {
            setUsbMidMapping((MappingObject) obj);
        } else if (997 == i) {
            setUsbLowMapping((MappingObject) obj);
        } else if (594 != i) {
            return false;
        } else {
            setParam((DecodeParam) obj);
        }
        return true;
    }

    @Override // com.rigol.scope.databinding.AdapterDecodeUsbBinding
    public void setUsbHighMapping(MappingObject mappingObject) {
        updateRegistration(1, mappingObject);
        this.mUsbHighMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(996);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterDecodeUsbBinding
    public void setUsbMidMapping(MappingObject mappingObject) {
        updateRegistration(2, mappingObject);
        this.mUsbMidMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(998);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterDecodeUsbBinding
    public void setUsbLowMapping(MappingObject mappingObject) {
        updateRegistration(4, mappingObject);
        this.mUsbLowMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        notifyPropertyChanged(997);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterDecodeUsbBinding
    public void setParam(DecodeParam decodeParam) {
        updateRegistration(6, decodeParam);
        this.mParam = decodeParam;
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        notifyPropertyChanged(594);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDecodeUsbDiffParamUsbDiff((MappingObject) obj, i2);
            case 1:
                return onChangeUsbHighMapping((MappingObject) obj, i2);
            case 2:
                return onChangeUsbMidMapping((MappingObject) obj, i2);
            case 3:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDecodeUsbDsParamUsbDs((MappingObject) obj, i2);
            case 4:
                return onChangeUsbLowMapping((MappingObject) obj, i2);
            case 5:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDecodeUsbDpParamUsbDp((MappingObject) obj, i2);
            case 6:
                return onChangeParam((DecodeParam) obj, i2);
            default:
                return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDecodeUsbDiffParamUsbDiff(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
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

    private boolean onChangeUsbHighMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 256;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeUsbMidMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 512;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDecodeUsbDsParamUsbDs(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeUsbLowMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDecodeUsbDpParamUsbDp(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
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

    private boolean onChangeParam(DecodeParam decodeParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        } else if (i == 1008) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            }
            return true;
        } else if (i == 1003) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE;
            }
            return true;
        } else if (i == 1004) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 1005) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
            }
            return true;
        } else if (i == 1006) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
            }
            return true;
        } else if (i == 999) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
            }
            return true;
        } else if (i == 1001) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
            }
            return true;
        } else if (i == 1000) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
            }
            return true;
        } else {
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x016c  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void executeBindings() {
        long j;
        int i;
        String str;
        boolean z;
        boolean z2;
        int i2;
        int i3;
        boolean z3;
        int i4;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        int i5;
        String str11;
        String str12;
        int i6;
        int i7;
        int i8;
        boolean z4;
        boolean z5;
        int i9;
        String str13;
        int i10;
        String str14;
        String str15;
        long j2;
        int i11;
        String str16;
        String str17;
        int i12;
        int i13;
        long j3;
        String str18;
        long j4;
        long j5;
        int i14;
        long j6;
        long j7;
        long j8;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        MappingObject mappingObject = this.mUsbHighMapping;
        MappingObject mappingObject2 = this.mUsbMidMapping;
        MappingObject mappingObject3 = this.mUsbLowMapping;
        DecodeParam decodeParam = this.mParam;
        String str19 = ((j & 2097410) == 0 || mappingObject == null) ? null : mappingObject.getStr();
        String str20 = ((j & 2097668) == 0 || mappingObject2 == null) ? null : mappingObject2.getStr();
        String str21 = ((j & 2099216) == 0 || mappingObject3 == null) ? null : mappingObject3.getStr();
        if ((j & 4191465) != 0) {
            if ((j & 2129984) != 0) {
                long usb_dp_thres = decodeParam != null ? decodeParam.getUsb_dp_thres() : 0L;
                if (decodeParam != null) {
                    str12 = decodeParam.getDecodeLevelStr(usb_dp_thres);
                    i6 = ((j & 2105408) > 0L ? 1 : ((j & 2105408) == 0L ? 0 : -1));
                    if (i6 == 0) {
                        long usb_rate = decodeParam != null ? decodeParam.getUsb_rate() : 0L;
                        z3 = usb_rate == 2;
                        z5 = usb_rate == 0;
                        z4 = usb_rate == 1;
                        if (i6 != 0) {
                            if (z3) {
                                j7 = j | 33554432 | 134217728;
                                j8 = 536870912;
                            } else {
                                j7 = j | 16777216 | 67108864;
                                j8 = 268435456;
                            }
                            j = j7 | j8;
                        }
                        if ((j & 2105408) != 0) {
                            j |= z5 ? 2147483648L : 1073741824L;
                        }
                        if ((j & 2105408) != 0) {
                            j |= z4 ? 8388608L : 4194304L;
                        }
                        i7 = 8;
                        i8 = z3 ? 8 : 0;
                        if (z3) {
                            i7 = 0;
                        }
                    } else {
                        i7 = 0;
                        z3 = false;
                        i8 = 0;
                        z4 = false;
                        z5 = false;
                    }
                    if ((j & 2117728) == 0) {
                        int usb_dp = decodeParam != null ? decodeParam.getUsb_dp() : 0;
                        i9 = (j & 2113600) != 0 ? ColorUtil.getColor(getRoot().getContext(), usb_dp) : 0;
                        MappingObject mappingObject4 = ViewUtil.getMappingObject(R.array.msg_decode_usb_dp, usb_dp);
                        updateRegistration(5, mappingObject4);
                        if (mappingObject4 != null) {
                            str13 = mappingObject4.getStr();
                            if ((j & 2621504) != 0) {
                                if (decodeParam != null) {
                                    i10 = i7;
                                    j6 = decodeParam.getUsb_diff_low_thres();
                                } else {
                                    i10 = i7;
                                    j6 = 0;
                                }
                                if (decodeParam != null) {
                                    str14 = decodeParam.getDecodeLevelStr(j6);
                                    if ((j & 2228288) != 0) {
                                        long usb_ds_thres = decodeParam != null ? decodeParam.getUsb_ds_thres() : 0L;
                                        if (decodeParam != null) {
                                            str15 = decodeParam.getDecodeLevelStr(usb_ds_thres);
                                            if ((j & 2163784) != 0) {
                                                int usb_ds = decodeParam != null ? decodeParam.getUsb_ds() : 0;
                                                MappingObject mappingObject5 = ViewUtil.getMappingObject(R.array.msg_decode_usb_ds, usb_ds);
                                                updateRegistration(3, mappingObject5);
                                                str16 = mappingObject5 != null ? mappingObject5.getStr() : null;
                                                j2 = 0;
                                                i11 = (j & 2162752) != 0 ? ColorUtil.getColor(getRoot().getContext(), usb_ds) : 0;
                                            } else {
                                                j2 = 0;
                                                i11 = 0;
                                                str16 = null;
                                            }
                                            if ((j & 2359489) != j2) {
                                                if (decodeParam != null) {
                                                    i14 = decodeParam.getUsb_diff();
                                                    str17 = str15;
                                                } else {
                                                    str17 = str15;
                                                    i14 = 0;
                                                }
                                                MappingObject mappingObject6 = ViewUtil.getMappingObject(R.array.msg_decode_usb_diff, i14);
                                                i12 = i11;
                                                i13 = 0;
                                                updateRegistration(0, mappingObject6);
                                                str18 = mappingObject6 != null ? mappingObject6.getStr() : null;
                                                j3 = 0;
                                                if ((j & 2359360) != 0) {
                                                    i13 = ColorUtil.getColor(getRoot().getContext(), i14);
                                                }
                                            } else {
                                                str17 = str15;
                                                i12 = i11;
                                                i13 = 0;
                                                j3 = 0;
                                                str18 = null;
                                            }
                                            if ((j & 3145792) != j3) {
                                                if (decodeParam != null) {
                                                    long j9 = j;
                                                    j5 = decodeParam.getUsb_diff_high_thres();
                                                    j4 = j9;
                                                } else {
                                                    j4 = j;
                                                    j5 = 0;
                                                }
                                                if (decodeParam != null) {
                                                    String decodeLevelStr = decodeParam.getDecodeLevelStr(j5);
                                                    str3 = str21;
                                                    i5 = i9;
                                                    str9 = str12;
                                                    str10 = str16;
                                                    z2 = z4;
                                                    i4 = i12;
                                                    str6 = decodeLevelStr;
                                                    str8 = str18;
                                                    i3 = i13;
                                                    i = i8;
                                                    z = z5;
                                                    j = j4;
                                                    str = str19;
                                                    str4 = str17;
                                                    int i15 = i10;
                                                    str2 = str20;
                                                    str5 = str13;
                                                    str7 = str14;
                                                    i2 = i15;
                                                }
                                            } else {
                                                j4 = j;
                                            }
                                            str3 = str21;
                                            i5 = i9;
                                            str9 = str12;
                                            str10 = str16;
                                            z2 = z4;
                                            i4 = i12;
                                            j = j4;
                                            str6 = null;
                                            str8 = str18;
                                            i3 = i13;
                                            i = i8;
                                            z = z5;
                                            str = str19;
                                            str4 = str17;
                                            int i152 = i10;
                                            str2 = str20;
                                            str5 = str13;
                                            str7 = str14;
                                            i2 = i152;
                                        }
                                    }
                                    str15 = null;
                                    if ((j & 2163784) != 0) {
                                    }
                                    if ((j & 2359489) != j2) {
                                    }
                                    if ((j & 3145792) != j3) {
                                    }
                                    str3 = str21;
                                    i5 = i9;
                                    str9 = str12;
                                    str10 = str16;
                                    z2 = z4;
                                    i4 = i12;
                                    j = j4;
                                    str6 = null;
                                    str8 = str18;
                                    i3 = i13;
                                    i = i8;
                                    z = z5;
                                    str = str19;
                                    str4 = str17;
                                    int i1522 = i10;
                                    str2 = str20;
                                    str5 = str13;
                                    str7 = str14;
                                    i2 = i1522;
                                }
                            } else {
                                i10 = i7;
                            }
                            str14 = null;
                            if ((j & 2228288) != 0) {
                            }
                            str15 = null;
                            if ((j & 2163784) != 0) {
                            }
                            if ((j & 2359489) != j2) {
                            }
                            if ((j & 3145792) != j3) {
                            }
                            str3 = str21;
                            i5 = i9;
                            str9 = str12;
                            str10 = str16;
                            z2 = z4;
                            i4 = i12;
                            j = j4;
                            str6 = null;
                            str8 = str18;
                            i3 = i13;
                            i = i8;
                            z = z5;
                            str = str19;
                            str4 = str17;
                            int i15222 = i10;
                            str2 = str20;
                            str5 = str13;
                            str7 = str14;
                            i2 = i15222;
                        }
                    } else {
                        i9 = 0;
                    }
                    str13 = null;
                    if ((j & 2621504) != 0) {
                    }
                    str14 = null;
                    if ((j & 2228288) != 0) {
                    }
                    str15 = null;
                    if ((j & 2163784) != 0) {
                    }
                    if ((j & 2359489) != j2) {
                    }
                    if ((j & 3145792) != j3) {
                    }
                    str3 = str21;
                    i5 = i9;
                    str9 = str12;
                    str10 = str16;
                    z2 = z4;
                    i4 = i12;
                    j = j4;
                    str6 = null;
                    str8 = str18;
                    i3 = i13;
                    i = i8;
                    z = z5;
                    str = str19;
                    str4 = str17;
                    int i152222 = i10;
                    str2 = str20;
                    str5 = str13;
                    str7 = str14;
                    i2 = i152222;
                }
            }
            str12 = null;
            i6 = ((j & 2105408) > 0L ? 1 : ((j & 2105408) == 0L ? 0 : -1));
            if (i6 == 0) {
            }
            if ((j & 2117728) == 0) {
            }
            str13 = null;
            if ((j & 2621504) != 0) {
            }
            str14 = null;
            if ((j & 2228288) != 0) {
            }
            str15 = null;
            if ((j & 2163784) != 0) {
            }
            if ((j & 2359489) != j2) {
            }
            if ((j & 3145792) != j3) {
            }
            str3 = str21;
            i5 = i9;
            str9 = str12;
            str10 = str16;
            z2 = z4;
            i4 = i12;
            j = j4;
            str6 = null;
            str8 = str18;
            i3 = i13;
            i = i8;
            z = z5;
            str = str19;
            str4 = str17;
            int i1522222 = i10;
            str2 = str20;
            str5 = str13;
            str7 = str14;
            i2 = i1522222;
        } else {
            i = 0;
            str = str19;
            z = false;
            z2 = false;
            i2 = 0;
            i3 = 0;
            z3 = false;
            i4 = 0;
            str2 = str20;
            str3 = str21;
            str4 = null;
            str5 = null;
            str6 = null;
            str7 = null;
            str8 = null;
            str9 = null;
            str10 = null;
            i5 = 0;
        }
        if ((j & 2105408) != 0) {
            str11 = str4;
            this.decodeUsbDiffLabel.setVisibility(i2);
            this.decodeUsbDiffThreHLabel.setVisibility(i2);
            this.decodeUsbDiffThreHValue.setVisibility(i2);
            this.decodeUsbDiffThreLLabel.setVisibility(i2);
            this.decodeUsbDiffThreLValue.setVisibility(i2);
            this.decodeUsbDiffValue.setVisibility(i2);
            this.decodeUsbDpLabel.setVisibility(i);
            this.decodeUsbDpThresLabel.setVisibility(i);
            this.decodeUsbDpThresValue.setVisibility(i);
            this.decodeUsbDpValue.setVisibility(i);
            this.decodeUsbDsLabel.setVisibility(i);
            this.decodeUsbDsThresLabel.setVisibility(i);
            this.decodeUsbDsThresValue.setVisibility(i);
            this.decodeUsbDsValue.setVisibility(i);
            CompoundButtonBindingAdapter.setChecked(this.decodeUsbHighRadioButton, z3);
            CompoundButtonBindingAdapter.setChecked(this.decodeUsbLowRadioButton, z);
            CompoundButtonBindingAdapter.setChecked(this.decodeUsbMidRadioButton, z2);
        } else {
            str11 = str4;
        }
        if ((j & 3145792) != 0) {
            TextViewBindingAdapter.setText(this.decodeUsbDiffThreHValue, str6);
        }
        if ((j & 2621504) != 0) {
            TextViewBindingAdapter.setText(this.decodeUsbDiffThreLValue, str7);
        }
        if ((j & 2359489) != 0) {
            TextViewBindingAdapter.setText(this.decodeUsbDiffValue, str8);
        }
        if ((j & 2359360) != 0) {
            this.decodeUsbDiffValue.setTextColor(i3);
        }
        if ((j & 2129984) != 0) {
            TextViewBindingAdapter.setText(this.decodeUsbDpThresValue, str9);
        }
        if ((j & 2117728) != 0) {
            TextViewBindingAdapter.setText(this.decodeUsbDpValue, str5);
        }
        if ((j & 2113600) != 0) {
            this.decodeUsbDpValue.setTextColor(i5);
        }
        if ((j & 2228288) != 0) {
            TextViewBindingAdapter.setText(this.decodeUsbDsThresValue, str11);
        }
        if ((j & 2163784) != 0) {
            TextViewBindingAdapter.setText(this.decodeUsbDsValue, str10);
        }
        if ((j & 2162752) != 0) {
            this.decodeUsbDsValue.setTextColor(i4);
        }
        if ((2097410 & j) != 0) {
            TextViewBindingAdapter.setText(this.decodeUsbHighRadioButton, str);
        }
        if ((2099216 & j) != 0) {
            TextViewBindingAdapter.setText(this.decodeUsbLowRadioButton, str3);
        }
        if ((j & 2097668) != 0) {
            TextViewBindingAdapter.setText(this.decodeUsbMidRadioButton, str2);
        }
    }
}
