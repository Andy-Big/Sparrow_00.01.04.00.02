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
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.rigol.scope.R;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.utilities.ColorUtil;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.views.busAnalyse.BusAnalyseUsbParam;

/* loaded from: classes2.dex */
public class AdapterBusUsbAnalyseBindingImpl extends AdapterBusUsbAnalyseBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.guideline_left, 10);
        sViewsWithIds.put(R.id.guideline_center, 11);
        sViewsWithIds.put(R.id.guideline_right, 12);
        sViewsWithIds.put(R.id.bus_analyse_usb_type_label, 13);
        sViewsWithIds.put(R.id.bus_analyse_divider1, 14);
        sViewsWithIds.put(R.id.bus_analyse_usb_auto_set_button, 15);
        sViewsWithIds.put(R.id.bus_analyse_usb_test_button, 16);
    }

    public AdapterBusUsbAnalyseBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 17, sIncludes, sViewsWithIds));
    }

    private AdapterBusUsbAnalyseBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 6, (View) objArr[14], (Button) objArr[15], (TextView) objArr[7], (TextView) objArr[8], (ConstraintLayout) objArr[0], (TextView) objArr[3], (TextView) objArr[5], (TextView) objArr[6], (TextView) objArr[9], (TextView) objArr[2], (TextView) objArr[4], (Button) objArr[16], (TextView) objArr[13], (TextView) objArr[1], (Guideline) objArr[11], (Guideline) objArr[10], (Guideline) objArr[12]);
        this.mDirtyFlags = -1L;
        this.busAnalyseUsbDiffsrcLabel.setTag(null);
        this.busAnalyseUsbDiffsrcValue.setTag(null);
        this.busAnalyseUsbLayout.setTag(null);
        this.busAnalyseUsbPointLabel.setTag(null);
        this.busAnalyseUsbPointValue.setTag(null);
        this.busAnalyseUsbSourceDpLabel.setTag(null);
        this.busAnalyseUsbSourceDpValue.setTag(null);
        this.busAnalyseUsbSourceDsLabel.setTag(null);
        this.busAnalyseUsbSourceDsValue.setTag(null);
        this.busAnalyseUsbTypeValue.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
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
            setParam((BusAnalyseUsbParam) obj);
            return true;
        }
        return false;
    }

    @Override // com.rigol.scope.databinding.AdapterBusUsbAnalyseBinding
    public void setParam(BusAnalyseUsbParam busAnalyseUsbParam) {
        updateRegistration(2, busAnalyseUsbParam);
        this.mParam = busAnalyseUsbParam;
        synchronized (this) {
            this.mDirtyFlags |= 4;
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
                            return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgUsbAnalyseDiffParamUsbDiffSource((MappingObject) obj, i2);
                        }
                        return onChangeViewUtilGetListComRigolScopeRArrayMsgUsbAnalyseTypeGetParamUsbType((MappingObject) obj, i2);
                    }
                    return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgUsbAnalyseDsParamUsbSourceDs((MappingObject) obj, i2);
                }
                return onChangeParam((BusAnalyseUsbParam) obj, i2);
            }
            return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgUsbAnalysePointParamUsbPoint((MappingObject) obj, i2);
        }
        return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgUsbAnalyseDpParamUsbSourceDp((MappingObject) obj, i2);
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgUsbAnalyseDpParamUsbSourceDp(MappingObject mappingObject, int i) {
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

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgUsbAnalysePointParamUsbPoint(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
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

    private boolean onChangeParam(BusAnalyseUsbParam busAnalyseUsbParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else if (i == 1011) {
            synchronized (this) {
                this.mDirtyFlags |= 256;
            }
            return true;
        } else if (i == 1010) {
            synchronized (this) {
                this.mDirtyFlags |= 512;
            }
            return true;
        } else if (i == 1007) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 1002) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
            }
            return true;
        } else if (i == 1009) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgUsbAnalyseDsParamUsbSourceDs(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetListComRigolScopeRArrayMsgUsbAnalyseTypeGetParamUsbType(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
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

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgUsbAnalyseDiffParamUsbDiffSource(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
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

    /* JADX WARN: Removed duplicated region for block: B:24:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x014e  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void executeBindings() {
        long j;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        boolean z;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        long j2;
        long j3;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        BusAnalyseUsbParam busAnalyseUsbParam = this.mParam;
        String str6 = null;
        if ((131071 & j) != 0) {
            if ((j & 74252) != 0) {
                int usb_source_ds = busAnalyseUsbParam != null ? busAnalyseUsbParam.getUsb_source_ds() : 0;
                i3 = (j & 66052) != 0 ? ColorUtil.getColor(getRoot().getContext(), ServiceEnum.getChanFromValue1(usb_source_ds)) : 0;
                MappingObject mappingObject = ViewUtil.getMappingObject(R.array.msg_usb_analyse_ds, usb_source_ds);
                updateRegistration(3, mappingObject);
                if (mappingObject != null) {
                    str2 = mappingObject.getStr();
                    if ((j & 100388) == 0) {
                        int usb_diff_source = busAnalyseUsbParam != null ? busAnalyseUsbParam.getUsb_diff_source() : 0;
                        i2 = (j & 67588) != 0 ? ColorUtil.getColor(getRoot().getContext(), ServiceEnum.getChanFromValue1(usb_diff_source)) : 0;
                        MappingObject mappingObject2 = ViewUtil.getMappingObject(R.array.msg_usb_analyse_diff, usb_diff_source);
                        updateRegistration(5, mappingObject2);
                        if (mappingObject2 != null) {
                            str4 = mappingObject2.getStr();
                            if ((j & 69701) != 0) {
                                int usb_source_dp = busAnalyseUsbParam != null ? busAnalyseUsbParam.getUsb_source_dp() : 0;
                                MappingObject mappingObject3 = ViewUtil.getMappingObject(R.array.msg_usb_analyse_dp, usb_source_dp);
                                updateRegistration(0, mappingObject3);
                                str5 = mappingObject3 != null ? mappingObject3.getStr() : null;
                                if ((j & 69636) != 0) {
                                    i = ColorUtil.getColor(getRoot().getContext(), ServiceEnum.getChanFromValue1(usb_source_dp));
                                    if ((j & 82196) == 0) {
                                        i4 = busAnalyseUsbParam != null ? busAnalyseUsbParam.getUsb_type() : 0;
                                        int i7 = ((j & 65796) > 0L ? 1 : ((j & 65796) == 0L ? 0 : -1));
                                        if (i7 != 0) {
                                            z = i4 == 4;
                                            if (i7 != 0) {
                                                j = z ? j | 4194304 : j | PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
                                            }
                                        } else {
                                            z = false;
                                        }
                                        MappingObject mappingObject4 = ViewUtil.getList((int) R.array.msg_usb_analyse_type).get(i4);
                                        updateRegistration(4, mappingObject4);
                                        str3 = mappingObject4 != null ? mappingObject4.getStr() : null;
                                    } else {
                                        str3 = null;
                                        z = false;
                                        i4 = 0;
                                    }
                                    if ((j & 66694) != 0) {
                                        MappingObject mappingObject5 = ViewUtil.getMappingObject(R.array.msg_usb_analyse_point, busAnalyseUsbParam != null ? busAnalyseUsbParam.getUsb_point() : 0);
                                        updateRegistration(1, mappingObject5);
                                        if (mappingObject5 != null) {
                                            str6 = mappingObject5.getStr();
                                        }
                                    }
                                    str = str6;
                                }
                            } else {
                                str5 = null;
                            }
                            i = 0;
                            if ((j & 82196) == 0) {
                            }
                            if ((j & 66694) != 0) {
                            }
                            str = str6;
                        }
                    } else {
                        i2 = 0;
                    }
                    str4 = null;
                    if ((j & 69701) != 0) {
                    }
                    i = 0;
                    if ((j & 82196) == 0) {
                    }
                    if ((j & 66694) != 0) {
                    }
                    str = str6;
                }
            } else {
                i3 = 0;
            }
            str2 = null;
            if ((j & 100388) == 0) {
            }
            str4 = null;
            if ((j & 69701) != 0) {
            }
            i = 0;
            if ((j & 82196) == 0) {
            }
            if ((j & 66694) != 0) {
            }
            str = str6;
        } else {
            str = null;
            str2 = null;
            str3 = null;
            str4 = null;
            str5 = null;
            z = false;
            i = 0;
            i2 = 0;
            i3 = 0;
            i4 = 0;
        }
        boolean z2 = (j & PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE) != 0 && i4 == 5;
        int i8 = ((j & 65796) > 0L ? 1 : ((j & 65796) == 0L ? 0 : -1));
        if (i8 != 0) {
            boolean z3 = z ? true : z2;
            if (i8 != 0) {
                if (z3) {
                    j2 = j | PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
                    j3 = PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
                } else {
                    j2 = j | PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
                    j3 = PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
                }
                j = j2 | j3;
            }
            i6 = z3 ? 4 : 0;
            i5 = z3 ? 0 : 4;
        } else {
            i5 = 0;
            i6 = 0;
        }
        if ((j & 65796) != 0) {
            this.busAnalyseUsbDiffsrcLabel.setVisibility(i5);
            this.busAnalyseUsbDiffsrcValue.setVisibility(i5);
            this.busAnalyseUsbPointLabel.setVisibility(i5);
            this.busAnalyseUsbPointValue.setVisibility(i5);
            this.busAnalyseUsbSourceDpLabel.setVisibility(i6);
            this.busAnalyseUsbSourceDpValue.setVisibility(i6);
            this.busAnalyseUsbSourceDsLabel.setVisibility(i6);
            this.busAnalyseUsbSourceDsValue.setVisibility(i6);
        }
        if ((j & 100388) != 0) {
            TextViewBindingAdapter.setText(this.busAnalyseUsbDiffsrcValue, str4);
        }
        if ((j & 67588) != 0) {
            this.busAnalyseUsbDiffsrcValue.setTextColor(i2);
        }
        if ((66694 & j) != 0) {
            TextViewBindingAdapter.setText(this.busAnalyseUsbPointValue, str);
        }
        if ((j & 69701) != 0) {
            TextViewBindingAdapter.setText(this.busAnalyseUsbSourceDpValue, str5);
        }
        if ((69636 & j) != 0) {
            this.busAnalyseUsbSourceDpValue.setTextColor(i);
        }
        if ((j & 74252) != 0) {
            TextViewBindingAdapter.setText(this.busAnalyseUsbSourceDsValue, str2);
        }
        if ((66052 & j) != 0) {
            this.busAnalyseUsbSourceDsValue.setTextColor(i3);
        }
        if ((j & 82196) != 0) {
            TextViewBindingAdapter.setText(this.busAnalyseUsbTypeValue, str3);
        }
    }
}
