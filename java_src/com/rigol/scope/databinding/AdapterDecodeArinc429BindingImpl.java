package com.rigol.scope.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.rigol.scope.R;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.DecodeParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.utilities.ColorUtil;
import com.rigol.scope.utilities.UnitFormat;
import com.rigol.scope.utilities.ViewUtil;

/* loaded from: classes2.dex */
public class AdapterDecodeArinc429BindingImpl extends AdapterDecodeArinc429Binding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.decode_arinc429_layout, 7);
        sViewsWithIds.put(R.id.guideline_left, 8);
        sViewsWithIds.put(R.id.guideline_center, 9);
        sViewsWithIds.put(R.id.guideline_right, 10);
        sViewsWithIds.put(R.id.guideline_33, 11);
        sViewsWithIds.put(R.id.guideline_66, 12);
        sViewsWithIds.put(R.id.decode_arinc429_src_label, 13);
        sViewsWithIds.put(R.id.decode_arinc429_up_thres_label, 14);
        sViewsWithIds.put(R.id.decode_arinc429_baud_label, 15);
        sViewsWithIds.put(R.id.decode_arinc429_down_thre_label, 16);
        sViewsWithIds.put(R.id.decode_arinc429_byte_format_label, 17);
        sViewsWithIds.put(R.id.decode_arinc429_signal_type_label, 18);
    }

    public AdapterDecodeArinc429BindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 19, sIncludes, sViewsWithIds));
    }

    private AdapterDecodeArinc429BindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 5, (TextView) objArr[15], (TextView) objArr[3], (TextView) objArr[17], (TextView) objArr[6], (TextView) objArr[16], (TextView) objArr[4], (ConstraintLayout) objArr[7], (TextView) objArr[18], (TextView) objArr[5], (TextView) objArr[13], (TextView) objArr[1], (TextView) objArr[14], (TextView) objArr[2], (Guideline) objArr[11], (Guideline) objArr[12], (Guideline) objArr[9], (Guideline) objArr[8], (Guideline) objArr[10]);
        this.mDirtyFlags = -1L;
        this.decodeArinc429BaudValue.setTag(null);
        this.decodeArinc429ByteFormatTypeValue.setTag(null);
        this.decodeArinc429DownThresValue.setTag(null);
        this.decodeArinc429SingalTypeValue.setTag(null);
        this.decodeArinc429SrcValue.setTag(null);
        this.decodeArinc429UpThresValue.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = PlaybackStateCompat.ACTION_PREPARE;
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

    @Override // com.rigol.scope.databinding.AdapterDecodeArinc429Binding
    public void setParam(DecodeParam decodeParam) {
        updateRegistration(2, decodeParam);
        this.mParam = decodeParam;
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
                            return false;
                        }
                        return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDecodeArinc429SrcParamArinc429Source((MappingObject) obj, i2);
                    }
                    return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDecodeArinc429ByteFormatParamArinc429ByteFormat((MappingObject) obj, i2);
                }
                return onChangeParam((DecodeParam) obj, i2);
            }
            return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDecodeArinc429BaudParamArinc429Baud((MappingObject) obj, i2);
        }
        return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDecodeArinc429SignalTypeParamArinc429SingalType((MappingObject) obj, i2);
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDecodeArinc429SignalTypeParamArinc429SingalType(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDecodeArinc429BaudParamArinc429Baud(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
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
                this.mDirtyFlags |= 4;
            }
            return true;
        } else if (i == 54) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
            }
            return true;
        } else if (i == 55) {
            synchronized (this) {
                this.mDirtyFlags |= 256;
            }
            return true;
        } else if (i == 50) {
            synchronized (this) {
                this.mDirtyFlags |= 512;
            }
            return true;
        } else if (i == 52) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 53) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
            }
            return true;
        } else if (i == 51) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDecodeArinc429ByteFormatParamArinc429ByteFormat(MappingObject mappingObject, int i) {
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

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDecodeArinc429SrcParamArinc429Source(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00f9  */
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
        String str6;
        int i;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        DecodeParam decodeParam = this.mParam;
        String str7 = null;
        if ((32767 & j) != 0) {
            int i2 = ((j & 16644) > 0L ? 1 : ((j & 16644) == 0L ? 0 : -1));
            long arinc429_up_thres = (i2 == 0 || decodeParam == null) ? 0L : decodeParam.getArinc429_up_thres();
            if ((j & 16532) != 0) {
                int arinc429_source = decodeParam != null ? decodeParam.getArinc429_source() : 0;
                i = (j & 16516) != 0 ? ColorUtil.getColor(getRoot().getContext(), arinc429_source) : 0;
                MappingObject mappingObject = ViewUtil.getMappingObject(R.array.msg_decode_arinc429_src, arinc429_source);
                updateRegistration(4, mappingObject);
                if (mappingObject != null) {
                    str3 = mappingObject.getStr();
                    int i3 = ((j & 17412) > 0L ? 1 : ((j & 17412) == 0L ? 0 : -1));
                    long arinc429_down_thres = (i3 != 0 || decodeParam == null) ? 0L : decodeParam.getArinc429_down_thres();
                    if ((j & 17668) == 0) {
                        ServiceEnum.Unit unit = decodeParam != null ? decodeParam.getUnit() : null;
                        str4 = i3 != 0 ? UnitFormat.newBuilder(UnitFormat.SI.MICRO).convert(arinc429_down_thres, unit) : null;
                        str2 = i2 != 0 ? UnitFormat.newBuilder(UnitFormat.SI.MICRO).convert(arinc429_up_thres, unit) : null;
                    } else {
                        str2 = null;
                        str4 = null;
                    }
                    if ((j & 16966) != 0) {
                        MappingObject mappingObject2 = ViewUtil.getMappingObject(R.array.msg_decode_arinc429_baud, decodeParam != null ? decodeParam.getArinc429_baud() : 0);
                        updateRegistration(1, mappingObject2);
                        if (mappingObject2 != null) {
                            str5 = mappingObject2.getStr();
                            if ((j & 18469) != 0) {
                                MappingObject mappingObject3 = ViewUtil.getMappingObject(R.array.msg_decode_arinc429_signal_type, decodeParam != null ? decodeParam.getArinc429_singal_type() : 0);
                                updateRegistration(0, mappingObject3);
                                if (mappingObject3 != null) {
                                    str6 = mappingObject3.getStr();
                                    if ((j & 28684) != 0) {
                                        MappingObject mappingObject4 = ViewUtil.getMappingObject(R.array.msg_decode_arinc429_byte_format, decodeParam != null ? decodeParam.getArinc429_byte_format() : 0);
                                        updateRegistration(3, mappingObject4);
                                        if (mappingObject4 != null) {
                                            str7 = mappingObject4.getStr();
                                        }
                                    }
                                    r15 = i;
                                    str = str7;
                                }
                            }
                            str6 = null;
                            if ((j & 28684) != 0) {
                            }
                            r15 = i;
                            str = str7;
                        }
                    }
                    str5 = null;
                    if ((j & 18469) != 0) {
                    }
                    str6 = null;
                    if ((j & 28684) != 0) {
                    }
                    r15 = i;
                    str = str7;
                }
            } else {
                i = 0;
            }
            str3 = null;
            int i32 = ((j & 17412) > 0L ? 1 : ((j & 17412) == 0L ? 0 : -1));
            if (i32 != 0) {
            }
            if ((j & 17668) == 0) {
            }
            if ((j & 16966) != 0) {
            }
            str5 = null;
            if ((j & 18469) != 0) {
            }
            str6 = null;
            if ((j & 28684) != 0) {
            }
            r15 = i;
            str = str7;
        } else {
            str = null;
            str2 = null;
            str3 = null;
            str4 = null;
            str5 = null;
            str6 = null;
        }
        if ((j & 16966) != 0) {
            TextViewBindingAdapter.setText(this.decodeArinc429BaudValue, str5);
        }
        if ((28684 & j) != 0) {
            TextViewBindingAdapter.setText(this.decodeArinc429ByteFormatTypeValue, str);
        }
        if ((17412 & j) != 0) {
            TextViewBindingAdapter.setText(this.decodeArinc429DownThresValue, str4);
        }
        if ((18469 & j) != 0) {
            TextViewBindingAdapter.setText(this.decodeArinc429SingalTypeValue, str6);
        }
        if ((16532 & j) != 0) {
            TextViewBindingAdapter.setText(this.decodeArinc429SrcValue, str3);
        }
        if ((16516 & j) != 0) {
            this.decodeArinc429SrcValue.setTextColor(r15);
        }
        if ((j & 16644) != 0) {
            TextViewBindingAdapter.setText(this.decodeArinc429UpThresValue, str2);
        }
    }
}
