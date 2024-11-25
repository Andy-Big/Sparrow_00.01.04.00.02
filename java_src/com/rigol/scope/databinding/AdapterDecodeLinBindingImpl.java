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
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.UnitFormat;
import com.rigol.scope.utilities.ViewUtil;
/* loaded from: classes2.dex */
public class AdapterDecodeLinBindingImpl extends AdapterDecodeLinBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.decode_lin_layout, 9);
        sViewsWithIds.put(R.id.guideline_left, 10);
        sViewsWithIds.put(R.id.guideline_center, 11);
        sViewsWithIds.put(R.id.guideline_right, 12);
        sViewsWithIds.put(R.id.guideline_33, 13);
        sViewsWithIds.put(R.id.guideline_66, 14);
        sViewsWithIds.put(R.id.decode_lin_src_label, 15);
        sViewsWithIds.put(R.id.decode_lin_thres_label, 16);
        sViewsWithIds.put(R.id.decode_lin_version_radioGroup, 17);
        sViewsWithIds.put(R.id.decode_lin_baud_label, 18);
        sViewsWithIds.put(R.id.decode_lin_parity_label, 19);
        sViewsWithIds.put(R.id.decode_lin_parity_radioGroup, 20);
        sViewsWithIds.put(R.id.decode_lin_ver_label, 21);
    }

    public AdapterDecodeLinBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 22, sIncludes, sViewsWithIds));
    }

    private AdapterDecodeLinBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 7, (RadioButton) objArr[3], (RadioButton) objArr[4], (TextView) objArr[18], (TextView) objArr[6], (RadioButton) objArr[5], (ConstraintLayout) objArr[9], (TextView) objArr[19], (RadioGroup) objArr[20], (TextView) objArr[15], (TextView) objArr[1], (TextView) objArr[16], (TextView) objArr[2], (TextView) objArr[21], (RadioGroup) objArr[17], (RadioButton) objArr[8], (RadioButton) objArr[7], (Guideline) objArr[13], (Guideline) objArr[14], (Guideline) objArr[11], (Guideline) objArr[10], (Guideline) objArr[12]);
        this.mDirtyFlags = -1L;
        this.decodeLin1xRadioButton.setTag(null);
        this.decodeLin2xRadioButton.setTag(null);
        this.decodeLinBaudValue.setTag(null);
        this.decodeLinBothRadioButton.setTag(null);
        this.decodeLinSrcValue.setTag(null);
        this.decodeLinThresValue.setTag(null);
        this.decodeLinWithRadioButton.setTag(null);
        this.decodeLinWithoutRadioButton.setTag(null);
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
        if (1017 == i) {
            setVer2Mapping((MappingObject) obj);
        } else if (598 == i) {
            setParityWithMapping((MappingObject) obj);
        } else if (599 == i) {
            setParityWithoutMapping((MappingObject) obj);
        } else if (594 == i) {
            setParam((DecodeParam) obj);
        } else if (1018 == i) {
            setVerBothMapping((MappingObject) obj);
        } else if (1016 != i) {
            return false;
        } else {
            setVer1Mapping((MappingObject) obj);
        }
        return true;
    }

    @Override // com.rigol.scope.databinding.AdapterDecodeLinBinding
    public void setVer2Mapping(MappingObject mappingObject) {
        updateRegistration(0, mappingObject);
        this.mVer2Mapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(1017);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterDecodeLinBinding
    public void setParityWithMapping(MappingObject mappingObject) {
        updateRegistration(1, mappingObject);
        this.mParityWithMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(598);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterDecodeLinBinding
    public void setParityWithoutMapping(MappingObject mappingObject) {
        updateRegistration(2, mappingObject);
        this.mParityWithoutMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(599);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterDecodeLinBinding
    public void setParam(DecodeParam decodeParam) {
        updateRegistration(4, decodeParam);
        this.mParam = decodeParam;
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        notifyPropertyChanged(594);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterDecodeLinBinding
    public void setVerBothMapping(MappingObject mappingObject) {
        updateRegistration(5, mappingObject);
        this.mVerBothMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        notifyPropertyChanged(1018);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterDecodeLinBinding
    public void setVer1Mapping(MappingObject mappingObject) {
        updateRegistration(6, mappingObject);
        this.mVer1Mapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        notifyPropertyChanged(1016);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return onChangeVer2Mapping((MappingObject) obj, i2);
            case 1:
                return onChangeParityWithMapping((MappingObject) obj, i2);
            case 2:
                return onChangeParityWithoutMapping((MappingObject) obj, i2);
            case 3:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDecodeLinSrcParamLinSource((MappingObject) obj, i2);
            case 4:
                return onChangeParam((DecodeParam) obj, i2);
            case 5:
                return onChangeVerBothMapping((MappingObject) obj, i2);
            case 6:
                return onChangeVer1Mapping((MappingObject) obj, i2);
            default:
                return false;
        }
    }

    private boolean onChangeVer2Mapping(MappingObject mappingObject, int i) {
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

    private boolean onChangeParityWithMapping(MappingObject mappingObject, int i) {
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

    private boolean onChangeParityWithoutMapping(MappingObject mappingObject, int i) {
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

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDecodeLinSrcParamLinSource(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeParam(DecodeParam decodeParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        } else if (i == 498) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 499) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
            }
            return true;
        } else if (i == 500) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
            }
            return true;
        } else if (i == 495) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            }
            return true;
        } else if (i == 496) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeVerBothMapping(MappingObject mappingObject, int i) {
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

    private boolean onChangeVer1Mapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
            }
            return true;
        } else {
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r14v11 */
    /* JADX WARN: Type inference failed for: r14v12 */
    /* JADX WARN: Type inference failed for: r14v5 */
    /* JADX WARN: Type inference failed for: r14v6, types: [int] */
    /* JADX WARN: Type inference failed for: r44v0, types: [com.rigol.scope.databinding.AdapterDecodeLinBindingImpl] */
    /* JADX WARN: Type inference failed for: r9v10, types: [int] */
    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        boolean z;
        boolean z2;
        boolean z3;
        ?? r14;
        boolean z4;
        boolean z5;
        String str2;
        String str3;
        String str4;
        float f;
        String str5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        boolean z11;
        float f2;
        ServiceEnum.Unit unit;
        long j2;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        MappingObject mappingObject = this.mVer2Mapping;
        MappingObject mappingObject2 = this.mParityWithMapping;
        MappingObject mappingObject3 = this.mParityWithoutMapping;
        DecodeParam decodeParam = this.mParam;
        MappingObject mappingObject4 = this.mVerBothMapping;
        MappingObject mappingObject5 = this.mVer1Mapping;
        String str6 = ((j & 131201) == 0 || mappingObject == null) ? null : mappingObject.getStr();
        String str7 = ((j & 131330) == 0 || mappingObject2 == null) ? null : mappingObject2.getStr();
        String str8 = ((j & 131588) == 0 || mappingObject3 == null) ? null : mappingObject3.getStr();
        if ((j & 162840) != 0) {
            if ((j & 147472) != 0) {
                z8 = decodeParam != null ? decodeParam.isLin_parity_bit() : false;
                z9 = !z8;
            } else {
                z8 = false;
                z9 = false;
            }
            if ((j & 139280) != 0) {
                str2 = UnitFormat.newBuilder(" 0.###  ", UnitFormat.SI.NONE).convert(decodeParam != null ? decodeParam.getLin_baud() : 0, ServiceEnum.Unit.Unit_none) + "bps";
            } else {
                str2 = null;
            }
            if ((j & 133136) != 0) {
                if (decodeParam != null) {
                    j2 = decodeParam.getLin_thres();
                    unit = decodeParam.getUnit();
                } else {
                    unit = null;
                    j2 = 0;
                }
                str3 = UnitFormat.newBuilder(UnitFormat.SI.NANO).convert(j2, unit);
            } else {
                str3 = null;
            }
            int i = ((j & 135184) > 0L ? 1 : ((j & 135184) == 0L ? 0 : -1));
            if (i != 0) {
                int lin_version = decodeParam != null ? decodeParam.getLin_version() : 0;
                z4 = lin_version == 2;
                z10 = lin_version == 0;
                z3 = lin_version == 1;
                if (i != 0) {
                    j |= z4 ? PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED : PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
                }
                if ((j & 135184) != 0) {
                    j |= z10 ? PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE : PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
                }
                if ((j & 135184) != 0) {
                    j |= z3 ? 8388608L : 4194304L;
                }
            } else {
                z3 = false;
                z4 = false;
                z10 = false;
            }
            if ((j & 132120) != 0) {
                int lin_source = decodeParam != null ? decodeParam.getLin_source() : 0;
                if ((j & 132112) != 0) {
                    ?? colorDoedCode = ColorUtil.getColorDoedCode(getRoot().getContext(), lin_source);
                    r32 = lin_source < 8;
                    f2 = ContextUtil.getAlpha(r32);
                    boolean z12 = r32;
                    r32 = colorDoedCode;
                    z11 = z12;
                } else {
                    z11 = false;
                    f2 = 0.0f;
                }
                MappingObject mappingObject6 = ViewUtil.getMappingObject(R.array.msg_decode_lin_src, lin_source);
                updateRegistration(3, mappingObject6);
                if (mappingObject6 != null) {
                    str4 = mappingObject6.getStr();
                    z5 = z9;
                    z2 = z10;
                } else {
                    z5 = z9;
                    z2 = z10;
                    str4 = null;
                }
                str = str7;
                z = z8;
                r14 = r32;
                str5 = str8;
                z6 = z11;
                f = f2;
            } else {
                z5 = z9;
                z2 = z10;
                str4 = null;
                f = 0.0f;
                str = str7;
                z = z8;
                r14 = 0;
                str5 = str8;
                z6 = false;
            }
        } else {
            str = str7;
            z = false;
            z2 = false;
            z3 = false;
            r14 = 0;
            z4 = false;
            z5 = false;
            str2 = null;
            str3 = null;
            str4 = null;
            f = 0.0f;
            str5 = str8;
            z6 = false;
        }
        int i2 = ((j & 163872) > 0L ? 1 : ((j & 163872) == 0L ? 0 : -1));
        String str9 = (i2 == 0 || mappingObject4 == null) ? null : mappingObject4.getStr();
        int i3 = ((j & 196672) > 0L ? 1 : ((j & 196672) == 0L ? 0 : -1));
        String str10 = (i3 == 0 || mappingObject5 == null) ? null : mappingObject5.getStr();
        if ((j & 135184) != 0) {
            z7 = z;
            CompoundButtonBindingAdapter.setChecked(this.decodeLin1xRadioButton, z2);
            CompoundButtonBindingAdapter.setChecked(this.decodeLin2xRadioButton, z3);
            CompoundButtonBindingAdapter.setChecked(this.decodeLinBothRadioButton, z4);
        } else {
            z7 = z;
        }
        if (i3 != 0) {
            TextViewBindingAdapter.setText(this.decodeLin1xRadioButton, str10);
        }
        if ((131201 & j) != 0) {
            TextViewBindingAdapter.setText(this.decodeLin2xRadioButton, str6);
        }
        if ((j & 139280) != 0) {
            TextViewBindingAdapter.setText(this.decodeLinBaudValue, str2);
        }
        if (i2 != 0) {
            TextViewBindingAdapter.setText(this.decodeLinBothRadioButton, str9);
        }
        if ((j & 132120) != 0) {
            TextViewBindingAdapter.setText(this.decodeLinSrcValue, str4);
        }
        if ((j & 132112) != 0) {
            this.decodeLinSrcValue.setTextColor(r14);
            this.decodeLinThresValue.setEnabled(z6);
            if (getBuildSdkInt() >= 11) {
                this.decodeLinThresValue.setAlpha(f);
            }
        }
        if ((j & 133136) != 0) {
            TextViewBindingAdapter.setText(this.decodeLinThresValue, str3);
        }
        if ((j & 147472) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.decodeLinWithRadioButton, z7);
            CompoundButtonBindingAdapter.setChecked(this.decodeLinWithoutRadioButton, z5);
        }
        if ((j & 131330) != 0) {
            TextViewBindingAdapter.setText(this.decodeLinWithRadioButton, str);
        }
        if ((j & 131588) != 0) {
            TextViewBindingAdapter.setText(this.decodeLinWithoutRadioButton, str5);
        }
    }
}
