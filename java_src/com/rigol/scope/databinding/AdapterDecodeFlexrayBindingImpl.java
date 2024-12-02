package com.rigol.scope.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.CompoundButtonBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.rigol.scope.R;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.DecodeParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.utilities.ColorUtil;
import com.rigol.scope.utilities.UnitFormat;
import com.rigol.scope.utilities.ViewUtil;

/* loaded from: classes2.dex */
public class AdapterDecodeFlexrayBindingImpl extends AdapterDecodeFlexrayBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.decode_flexray_layout, 8);
        sViewsWithIds.put(R.id.guideline_left, 9);
        sViewsWithIds.put(R.id.guideline_center, 10);
        sViewsWithIds.put(R.id.guideline_right, 11);
        sViewsWithIds.put(R.id.guideline_33, 12);
        sViewsWithIds.put(R.id.guideline_66, 13);
        sViewsWithIds.put(R.id.decode_flex_baud_label, 14);
        sViewsWithIds.put(R.id.decode_flex_signal_label, 15);
        sViewsWithIds.put(R.id.decode_flex_src_label, 16);
        sViewsWithIds.put(R.id.decode_flex_thres_label, 17);
        sViewsWithIds.put(R.id.decode_flex_samp_label, 18);
        sViewsWithIds.put(R.id.decode_flex_channel_label, 19);
        sViewsWithIds.put(R.id.decode_flex_channel_radioGroup, 20);
    }

    public AdapterDecodeFlexrayBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 21, sIncludes, sViewsWithIds));
    }

    private AdapterDecodeFlexrayBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 6, (TextView) objArr[14], (TextView) objArr[1], (RadioButton) objArr[6], (RadioButton) objArr[7], (TextView) objArr[19], (RadioGroup) objArr[20], (TextView) objArr[18], (TextView) objArr[5], (TextView) objArr[15], (TextView) objArr[4], (TextView) objArr[16], (TextView) objArr[2], (TextView) objArr[17], (TextView) objArr[3], (ConstraintLayout) objArr[8], (Guideline) objArr[12], (Guideline) objArr[13], (Guideline) objArr[10], (Guideline) objArr[9], (Guideline) objArr[11]);
        this.mDirtyFlags = -1L;
        this.decodeFlexBaudValue.setTag(null);
        this.decodeFlexChannelARadioButton.setTag(null);
        this.decodeFlexChannelBRadioButton.setTag(null);
        this.decodeFlexSampValue.setTag(null);
        this.decodeFlexSignalValue.setTag(null);
        this.decodeFlexSrcValue.setTag(null);
        this.decodeFlexThresValue.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
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
        if (172 == i) {
            setChannelAMapping((MappingObject) obj);
        } else if (594 == i) {
            setParam((DecodeParam) obj);
        } else if (174 != i) {
            return false;
        } else {
            setChannelBMapping((MappingObject) obj);
        }
        return true;
    }

    @Override // com.rigol.scope.databinding.AdapterDecodeFlexrayBinding
    public void setChannelAMapping(MappingObject mappingObject) {
        updateRegistration(1, mappingObject);
        this.mChannelAMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(172);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterDecodeFlexrayBinding
    public void setParam(DecodeParam decodeParam) {
        updateRegistration(4, decodeParam);
        this.mParam = decodeParam;
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        notifyPropertyChanged(594);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterDecodeFlexrayBinding
    public void setChannelBMapping(MappingObject mappingObject) {
        updateRegistration(5, mappingObject);
        this.mChannelBMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        notifyPropertyChanged(174);
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
                            return onChangeChannelBMapping((MappingObject) obj, i2);
                        }
                        return onChangeParam((DecodeParam) obj, i2);
                    }
                    return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDecodeFlexSignalParamFlexSignal((MappingObject) obj, i2);
                }
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDecodeFlexSrcParamFlexSource((MappingObject) obj, i2);
            }
            return onChangeChannelAMapping((MappingObject) obj, i2);
        }
        return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDecodeFlexBaudParamFlexBaud((MappingObject) obj, i2);
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDecodeFlexBaudParamFlexBaud(MappingObject mappingObject, int i) {
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

    private boolean onChangeChannelAMapping(MappingObject mappingObject, int i) {
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

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDecodeFlexSrcParamFlexSource(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDecodeFlexSignalParamFlexSignal(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
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

    private boolean onChangeParam(DecodeParam decodeParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        } else if (i == 323) {
            synchronized (this) {
                this.mDirtyFlags |= 512;
            }
            return true;
        } else if (i == 327) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 328) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
            }
            return true;
        } else if (i == 326) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
            }
            return true;
        } else if (i == 325) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            }
            return true;
        } else if (i == 324) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeChannelBMapping(MappingObject mappingObject, int i) {
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

    /* JADX WARN: Removed duplicated region for block: B:31:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0110  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void executeBindings() {
        long j;
        String str;
        boolean z;
        String str2;
        int i;
        String str3;
        boolean z2;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        boolean z3;
        long j2;
        ServiceEnum.Unit unit;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        MappingObject mappingObject = this.mChannelAMapping;
        DecodeParam decodeParam = this.mParam;
        MappingObject mappingObject2 = this.mChannelBMapping;
        int i2 = ((65666 & j) > 0L ? 1 : ((65666 & j) == 0L ? 0 : -1));
        String str10 = (i2 == 0 || mappingObject == null) ? null : mappingObject.getStr();
        if ((98141 & j) != 0) {
            if ((j & 67600) != 0) {
                if (decodeParam != null) {
                    unit = decodeParam.getUnit();
                    j2 = decodeParam.getFlex_thres();
                } else {
                    j2 = 0;
                    unit = null;
                }
                str6 = UnitFormat.newBuilder(UnitFormat.SI.NANO).convert(j2, unit);
            } else {
                str6 = null;
            }
            if ((j & 66129) != 0) {
                MappingObject mappingObject3 = ViewUtil.getMappingObject(R.array.msg_decode_flex_baud, decodeParam != null ? decodeParam.getFlex_baud() : 0);
                updateRegistration(0, mappingObject3);
                if (mappingObject3 != null) {
                    str7 = mappingObject3.getStr();
                    if ((j & 69912) != 0) {
                        MappingObject mappingObject4 = ViewUtil.getMappingObject(R.array.msg_decode_flex_signal, decodeParam != null ? decodeParam.getFlex_signal() : 0);
                        updateRegistration(3, mappingObject4);
                        if (mappingObject4 != null) {
                            str8 = mappingObject4.getStr();
                            if ((j & 73744) != 0) {
                                str9 = UnitFormat.newBuilder(UnitFormat.SI.NONE).convert(decodeParam != null ? decodeParam.getFlex_samp() : 0L, ServiceEnum.Unit.Unit_percent);
                            } else {
                                str9 = null;
                            }
                            if ((j & 81936) != 0) {
                                z2 = decodeParam != null ? decodeParam.isFlex_channel() : false;
                                z3 = !z2;
                            } else {
                                z2 = false;
                                z3 = false;
                            }
                            if ((j & 66580) != 0) {
                                int flex_source = decodeParam != null ? decodeParam.getFlex_source() : 0;
                                int color = (j & 66576) != 0 ? ColorUtil.getColor(getRoot().getContext(), flex_source) : 0;
                                MappingObject mappingObject5 = ViewUtil.getMappingObject(R.array.msg_decode_flex_src, flex_source);
                                updateRegistration(2, mappingObject5);
                                if (mappingObject5 != null) {
                                    str = mappingObject5.getStr();
                                    str5 = str8;
                                } else {
                                    str5 = str8;
                                    str = null;
                                }
                                str3 = str6;
                                str2 = str9;
                                z = z3;
                                str4 = str7;
                                i = color;
                            } else {
                                str5 = str8;
                                str = null;
                                str3 = str6;
                                str2 = str9;
                                z = z3;
                                str4 = str7;
                                i = 0;
                            }
                        }
                    }
                    str8 = null;
                    if ((j & 73744) != 0) {
                    }
                    if ((j & 81936) != 0) {
                    }
                    if ((j & 66580) != 0) {
                    }
                }
            }
            str7 = null;
            if ((j & 69912) != 0) {
            }
            str8 = null;
            if ((j & 73744) != 0) {
            }
            if ((j & 81936) != 0) {
            }
            if ((j & 66580) != 0) {
            }
        } else {
            str = null;
            z = false;
            str2 = null;
            i = 0;
            str3 = null;
            z2 = false;
            str4 = null;
            str5 = null;
        }
        int i3 = ((j & 98336) > 0L ? 1 : ((j & 98336) == 0L ? 0 : -1));
        String str11 = (i3 == 0 || mappingObject2 == null) ? null : mappingObject2.getStr();
        if ((j & 66129) != 0) {
            TextViewBindingAdapter.setText(this.decodeFlexBaudValue, str4);
        }
        if ((j & 81936) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.decodeFlexChannelARadioButton, z);
            CompoundButtonBindingAdapter.setChecked(this.decodeFlexChannelBRadioButton, z2);
        }
        if (i2 != 0) {
            TextViewBindingAdapter.setText(this.decodeFlexChannelARadioButton, str10);
        }
        if (i3 != 0) {
            TextViewBindingAdapter.setText(this.decodeFlexChannelBRadioButton, str11);
        }
        if ((73744 & j) != 0) {
            TextViewBindingAdapter.setText(this.decodeFlexSampValue, str2);
        }
        if ((j & 69912) != 0) {
            TextViewBindingAdapter.setText(this.decodeFlexSignalValue, str5);
        }
        if ((66580 & j) != 0) {
            TextViewBindingAdapter.setText(this.decodeFlexSrcValue, str);
        }
        if ((66576 & j) != 0) {
            this.decodeFlexSrcValue.setTextColor(i);
        }
        if ((j & 67600) != 0) {
            TextViewBindingAdapter.setText(this.decodeFlexThresValue, str3);
        }
    }
}
