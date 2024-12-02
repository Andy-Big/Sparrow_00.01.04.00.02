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
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

/* loaded from: classes2.dex */
public class AdapterDecodeSpiBindingImpl extends AdapterDecodeSpiBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private long mDirtyFlags_1;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.decode_spi_layout, 28);
        sViewsWithIds.put(R.id.guideline_left, 29);
        sViewsWithIds.put(R.id.guideline_center, 30);
        sViewsWithIds.put(R.id.guideline_right, 31);
        sViewsWithIds.put(R.id.guideline_33, 32);
        sViewsWithIds.put(R.id.guideline_66, 33);
        sViewsWithIds.put(R.id.decode_spi_clk_label, 34);
        sViewsWithIds.put(R.id.decode_spi_clk_thres_label, 35);
        sViewsWithIds.put(R.id.decode_spi_mosi_label, 36);
        sViewsWithIds.put(R.id.decode_spi_clk_edge_label, 37);
        sViewsWithIds.put(R.id.decode_spi_clk_edge_radioGroup, 38);
        sViewsWithIds.put(R.id.decode_spi_mode_label, 39);
        sViewsWithIds.put(R.id.decode_spi_mode_radioGroup, 40);
        sViewsWithIds.put(R.id.decode_spi_miso_label, 41);
        sViewsWithIds.put(R.id.divider1, 42);
        sViewsWithIds.put(R.id.decode_spi_width_label, 43);
        sViewsWithIds.put(R.id.decode_spi_endian_label, 44);
        sViewsWithIds.put(R.id.decode_spi_endian_radioGroup, 45);
        sViewsWithIds.put(R.id.decode_spi_polarity_label, 46);
        sViewsWithIds.put(R.id.decode_spi_polarity_radioGroup, 47);
    }

    public AdapterDecodeSpiBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 48, sIncludes, sViewsWithIds));
    }

    private AdapterDecodeSpiBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 15, (RadioButton) objArr[11], (TextView) objArr[37], (RadioGroup) objArr[38], (RadioButton) objArr[10], (TextView) objArr[34], (TextView) objArr[35], (TextView) objArr[3], (TextView) objArr[2], (TextView) objArr[1], (TextView) objArr[24], (RadioButton) objArr[27], (RadioButton) objArr[26], (RadioGroup) objArr[25], (TextView) objArr[16], (TextView) objArr[19], (TextView) objArr[18], (RadioButton) objArr[21], (TextView) objArr[44], (RadioButton) objArr[20], (RadioGroup) objArr[45], (ConstraintLayout) objArr[28], (TextView) objArr[41], (TextView) objArr[5], (TextView) objArr[9], (TextView) objArr[15], (RadioButton) objArr[13], (TextView) objArr[39], (RadioGroup) objArr[40], (RadioButton) objArr[12], (TextView) objArr[36], (TextView) objArr[14], (TextView) objArr[8], (TextView) objArr[4], (TextView) objArr[46], (RadioButton) objArr[23], (RadioButton) objArr[22], (RadioGroup) objArr[47], (TextView) objArr[6], (TextView) objArr[7], (TextView) objArr[43], (TextView) objArr[17], (View) objArr[42], (Guideline) objArr[32], (Guideline) objArr[33], (Guideline) objArr[30], (Guideline) objArr[29], (Guideline) objArr[31]);
        this.mDirtyFlags = -1L;
        this.mDirtyFlags_1 = -1L;
        this.decodeSpiClkEdgeDownRadioButton.setTag(null);
        this.decodeSpiClkEdgeUpRadioButton.setTag(null);
        this.decodeSpiClkThresValue.setTag(null);
        this.decodeSpiClkValue.setTag(null);
        this.decodeSpiCsLabel.setTag(null);
        this.decodeSpiCsPolLabel.setTag(null);
        this.decodeSpiCsPolNegativeRadioButton.setTag(null);
        this.decodeSpiCsPolPositiveRadioButton.setTag(null);
        this.decodeSpiCsPolRadioGroup.setTag(null);
        this.decodeSpiCsThresLabel.setTag(null);
        this.decodeSpiCsThresValue.setTag(null);
        this.decodeSpiCsValue.setTag(null);
        this.decodeSpiEndianLSBRadioButton.setTag(null);
        this.decodeSpiEndianMSBRadioButton.setTag(null);
        this.decodeSpiMisoThresLabel.setTag(null);
        this.decodeSpiMisoThresValue.setTag(null);
        this.decodeSpiMisoValue.setTag(null);
        this.decodeSpiModeCsRadioButton.setTag(null);
        this.decodeSpiModeTimeoutRadioButton.setTag(null);
        this.decodeSpiMosiThresLabel.setTag(null);
        this.decodeSpiMosiThresValue.setTag(null);
        this.decodeSpiMosiValue.setTag(null);
        this.decodeSpiPolarityNegativeRadioButton.setTag(null);
        this.decodeSpiPolarityPositiveRadioButton.setTag(null);
        this.decodeSpiTmoLabel.setTag(null);
        this.decodeSpiTmoValue.setTag(null);
        this.decodeSpiWidthValue.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 1099511627776L;
            this.mDirtyFlags_1 = 0L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.mDirtyFlags == 0 && this.mDirtyFlags_1 == 0) {
                return false;
            }
            return true;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (643 == i) {
            setPolarityNegativeMapping((MappingObject) obj);
        } else if (548 == i) {
            setModeTimeoutMapping((MappingObject) obj);
        } else if (275 == i) {
            setEndianLsbMapping((MappingObject) obj);
        } else if (594 == i) {
            setParam((DecodeParam) obj);
        } else if (257 == i) {
            setEdgeDownMapping((MappingObject) obj);
        } else if (644 == i) {
            setPolarityPositiveMapping((MappingObject) obj);
        } else if (270 == i) {
            setEdgeUpMapping((MappingObject) obj);
        } else if (545 == i) {
            setModeCsMapping((MappingObject) obj);
        } else if (276 == i) {
            setEndianMsbMapping((MappingObject) obj);
        } else if (194 == i) {
            setCsNegativeMapping((MappingObject) obj);
        } else if (195 != i) {
            return false;
        } else {
            setCsPositiveMapping((MappingObject) obj);
        }
        return true;
    }

    @Override // com.rigol.scope.databinding.AdapterDecodeSpiBinding
    public void setPolarityNegativeMapping(MappingObject mappingObject) {
        updateRegistration(0, mappingObject);
        this.mPolarityNegativeMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(643);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterDecodeSpiBinding
    public void setModeTimeoutMapping(MappingObject mappingObject) {
        updateRegistration(1, mappingObject);
        this.mModeTimeoutMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(548);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterDecodeSpiBinding
    public void setEndianLsbMapping(MappingObject mappingObject) {
        updateRegistration(4, mappingObject);
        this.mEndianLsbMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        notifyPropertyChanged(275);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterDecodeSpiBinding
    public void setParam(DecodeParam decodeParam) {
        updateRegistration(5, decodeParam);
        this.mParam = decodeParam;
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        notifyPropertyChanged(594);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterDecodeSpiBinding
    public void setEdgeDownMapping(MappingObject mappingObject) {
        updateRegistration(6, mappingObject);
        this.mEdgeDownMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        notifyPropertyChanged(257);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterDecodeSpiBinding
    public void setPolarityPositiveMapping(MappingObject mappingObject) {
        updateRegistration(8, mappingObject);
        this.mPolarityPositiveMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 256;
        }
        notifyPropertyChanged(644);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterDecodeSpiBinding
    public void setEdgeUpMapping(MappingObject mappingObject) {
        updateRegistration(9, mappingObject);
        this.mEdgeUpMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 512;
        }
        notifyPropertyChanged(270);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterDecodeSpiBinding
    public void setModeCsMapping(MappingObject mappingObject) {
        updateRegistration(11, mappingObject);
        this.mModeCsMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
        }
        notifyPropertyChanged(545);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterDecodeSpiBinding
    public void setEndianMsbMapping(MappingObject mappingObject) {
        updateRegistration(12, mappingObject);
        this.mEndianMsbMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
        }
        notifyPropertyChanged(276);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterDecodeSpiBinding
    public void setCsNegativeMapping(MappingObject mappingObject) {
        updateRegistration(13, mappingObject);
        this.mCsNegativeMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
        }
        notifyPropertyChanged(194);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterDecodeSpiBinding
    public void setCsPositiveMapping(MappingObject mappingObject) {
        updateRegistration(14, mappingObject);
        this.mCsPositiveMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE;
        }
        notifyPropertyChanged(195);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return onChangePolarityNegativeMapping((MappingObject) obj, i2);
            case 1:
                return onChangeModeTimeoutMapping((MappingObject) obj, i2);
            case 2:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDecodeSpiMisoParamSpiMiso((MappingObject) obj, i2);
            case 3:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDecodeSpiClkParamSpiClock((MappingObject) obj, i2);
            case 4:
                return onChangeEndianLsbMapping((MappingObject) obj, i2);
            case 5:
                return onChangeParam((DecodeParam) obj, i2);
            case 6:
                return onChangeEdgeDownMapping((MappingObject) obj, i2);
            case 7:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDecodeSpiMosiParamSpiMosi((MappingObject) obj, i2);
            case 8:
                return onChangePolarityPositiveMapping((MappingObject) obj, i2);
            case 9:
                return onChangeEdgeUpMapping((MappingObject) obj, i2);
            case 10:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDecodeSpiCsParamSpiCs((MappingObject) obj, i2);
            case 11:
                return onChangeModeCsMapping((MappingObject) obj, i2);
            case 12:
                return onChangeEndianMsbMapping((MappingObject) obj, i2);
            case 13:
                return onChangeCsNegativeMapping((MappingObject) obj, i2);
            case 14:
                return onChangeCsPositiveMapping((MappingObject) obj, i2);
            default:
                return false;
        }
    }

    private boolean onChangePolarityNegativeMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
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

    private boolean onChangeModeTimeoutMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
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

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDecodeSpiMisoParamSpiMiso(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDecodeSpiClkParamSpiClock(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeEndianLsbMapping(MappingObject mappingObject, int i) {
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

    private boolean onChangeParam(DecodeParam decodeParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        } else if (i == 888) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
            }
            return true;
        } else if (i == 878) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
            }
            return true;
        } else if (i == 880) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
            }
            return true;
        } else if (i == 889) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
            }
            return true;
        } else if (i == 886) {
            synchronized (this) {
                this.mDirtyFlags |= 4194304;
            }
            return true;
        } else if (i == 891) {
            synchronized (this) {
                this.mDirtyFlags |= 8388608;
            }
            return true;
        } else if (i == 890) {
            synchronized (this) {
                this.mDirtyFlags |= 16777216;
            }
            return true;
        } else if (i == 887) {
            synchronized (this) {
                this.mDirtyFlags |= 33554432;
            }
            return true;
        } else if (i == 879) {
            synchronized (this) {
                this.mDirtyFlags |= 67108864;
            }
            return true;
        } else if (i == 892) {
            synchronized (this) {
                this.mDirtyFlags |= 134217728;
            }
            return true;
        } else if (i == 881) {
            synchronized (this) {
                this.mDirtyFlags |= 268435456;
            }
            return true;
        } else if (i == 883) {
            synchronized (this) {
                this.mDirtyFlags |= 536870912;
            }
            return true;
        } else if (i == 885) {
            synchronized (this) {
                this.mDirtyFlags |= 1073741824;
            }
            return true;
        } else if (i == 884) {
            synchronized (this) {
                this.mDirtyFlags |= 2147483648L;
            }
            return true;
        } else if (i == 882) {
            synchronized (this) {
                this.mDirtyFlags |= 4294967296L;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeEdgeDownMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 8589934592L;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDecodeSpiMosiParamSpiMosi(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
            }
            return true;
        }
        return false;
    }

    private boolean onChangePolarityPositiveMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 256;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 17179869184L;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeEdgeUpMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 512;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 34359738368L;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDecodeSpiCsParamSpiCs(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeModeCsMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 68719476736L;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeEndianMsbMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 137438953472L;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeCsNegativeMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 274877906944L;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeCsPositiveMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 549755813888L;
            }
            return true;
        } else {
            return false;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v35, resolved type: boolean */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x025b  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0288  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x02a0  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x02ac  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x02ef  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0303  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0325  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0339  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0345  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0355  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x03a9  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x03ba  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x0400  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x0414  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x0422  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x042a  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x04ac  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x04c4  */
    /* JADX WARN: Removed duplicated region for block: B:294:0x050d  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01c4  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void executeBindings() {
        long j;
        String str;
        String str2;
        String str3;
        long j2;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        float f;
        float f2;
        float f3;
        int i;
        boolean z;
        boolean z2;
        boolean z3;
        int i2;
        boolean z4;
        boolean z5;
        int i3;
        boolean z6;
        boolean z7;
        int i4;
        boolean z8;
        boolean z9;
        int i5;
        boolean z10;
        int i6;
        int i7;
        boolean z11;
        int i8;
        boolean z12;
        int i9;
        String str12;
        String str13;
        String str14;
        String str15;
        String str16;
        float f4;
        int i10;
        boolean z13;
        int i11;
        String str17;
        int i12;
        long j3;
        String str18;
        int i13;
        int i14;
        String str19;
        String str20;
        String str21;
        long j4;
        String str22;
        float f5;
        boolean z14;
        int i15;
        int i16;
        float f6;
        int i17;
        String str23;
        String str24;
        String str25;
        int i18;
        String str26;
        boolean z15;
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        String str27;
        String str28;
        boolean z20;
        boolean z21;
        String str29;
        boolean z22;
        String str30;
        boolean z23;
        int i19;
        int i20;
        String str31;
        boolean z24;
        boolean z25;
        boolean z26;
        String str32;
        int i21;
        boolean z27;
        boolean z28;
        boolean z29;
        int i22;
        long j5;
        int i23;
        boolean z30;
        int i24;
        boolean z31;
        int i25;
        boolean z32;
        int i26;
        int i27;
        int i28;
        int i29;
        int i30;
        int i31;
        long j6;
        int i32;
        int i33;
        long j7;
        long j8;
        int i34;
        long j9;
        int i35;
        long j10;
        int i36;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
            this.mDirtyFlags_1 = 0L;
        }
        MappingObject mappingObject = this.mPolarityNegativeMapping;
        MappingObject mappingObject2 = this.mModeTimeoutMapping;
        MappingObject mappingObject3 = this.mEndianLsbMapping;
        DecodeParam decodeParam = this.mParam;
        MappingObject mappingObject4 = this.mEdgeDownMapping;
        MappingObject mappingObject5 = this.mPolarityPositiveMapping;
        MappingObject mappingObject6 = this.mEdgeUpMapping;
        MappingObject mappingObject7 = this.mModeCsMapping;
        MappingObject mappingObject8 = this.mEndianMsbMapping;
        MappingObject mappingObject9 = this.mCsNegativeMapping;
        MappingObject mappingObject10 = this.mCsPositiveMapping;
        String str33 = null;
        String str34 = ((j & 1099511660545L) == 0 || mappingObject == null) ? null : mappingObject.getStr();
        String str35 = ((j & 1099511693314L) == 0 || mappingObject2 == null) ? null : mappingObject2.getStr();
        String str36 = ((j & 1099511758864L) == 0 || mappingObject3 == null) ? null : mappingObject3.getStr();
        float f7 = 0.0f;
        if ((j & 1108101301420L) != 0) {
            if ((j & 1099528405024L) != 0) {
                long spi_mosi_thres = decodeParam != null ? decodeParam.getSpi_mosi_thres() : 0L;
                if (decodeParam != null) {
                    str15 = decodeParam.getDecodeLevelStr(spi_mosi_thres);
                    String str37 = str15;
                    if ((j & 1099513725088L) == 0) {
                        int spi_mosi = decodeParam != null ? decodeParam.getSpi_mosi() : 0;
                        int i37 = ((j & 1099513724960L) > 0L ? 1 : ((j & 1099513724960L) == 0L ? 0 : -1));
                        if (i37 != 0) {
                            boolean z33 = spi_mosi < 8;
                            str = str34;
                            int color = ColorUtil.getColor(getRoot().getContext(), spi_mosi);
                            boolean z34 = spi_mosi != ServiceEnum.Chan.chan_none.value1;
                            if (i37 != 0) {
                                j |= z34 ? 288230376151711744L : 144115188075855872L;
                            }
                            i11 = color;
                            f4 = ContextUtil.getAlpha(z33);
                            z13 = z33;
                            j10 = j;
                            i36 = z34 ? 0 : 4;
                        } else {
                            str = str34;
                            j10 = j;
                            f4 = 0.0f;
                            i36 = 0;
                            z13 = false;
                            i11 = 0;
                        }
                        MappingObject mappingObject11 = ViewUtil.getMappingObject(R.array.msg_decode_spi_mosi, spi_mosi);
                        updateRegistration(7, mappingObject11);
                        str16 = mappingObject11 != null ? mappingObject11.getStr() : null;
                        i10 = i36;
                        j = j10;
                    } else {
                        str = str34;
                        str16 = null;
                        f4 = 0.0f;
                        i10 = 0;
                        z13 = false;
                        i11 = 0;
                    }
                    if ((j & 1099780064288L) == 0) {
                        if (decodeParam != null) {
                            i35 = decodeParam.getSpi_cs();
                            str17 = str16;
                        } else {
                            str17 = str16;
                            i35 = 0;
                        }
                        MappingObject mappingObject12 = ViewUtil.getMappingObject(R.array.msg_decode_spi_cs, i35);
                        i12 = i10;
                        updateRegistration(10, mappingObject12);
                        str18 = mappingObject12 != null ? mappingObject12.getStr() : null;
                        j3 = 0;
                        if ((j & 1099780063264L) != 0) {
                            i13 = ColorUtil.getColorDoedCode(getRoot().getContext(), i35);
                            if ((j & 1100048498720L) != j3) {
                                if (decodeParam != null) {
                                    i14 = i13;
                                    j9 = decodeParam.getSpi_cs_thres();
                                } else {
                                    i14 = i13;
                                    j9 = 0;
                                }
                                if (decodeParam != null) {
                                    str19 = decodeParam.getDecodeLevelStr(j9);
                                    if ((j & 1099515822116L) == 0) {
                                        if (decodeParam != null) {
                                            i34 = decodeParam.getSpi_miso();
                                            str20 = str18;
                                        } else {
                                            str20 = str18;
                                            i34 = 0;
                                        }
                                        MappingObject mappingObject13 = ViewUtil.getMappingObject(R.array.msg_decode_spi_miso, i34);
                                        str21 = str19;
                                        updateRegistration(2, mappingObject13);
                                        str22 = mappingObject13 != null ? mappingObject13.getStr() : null;
                                        int i38 = ((j & 1099515822112L) > 0L ? 1 : ((j & 1099515822112L) == 0L ? 0 : -1));
                                        String str38 = str22;
                                        if (i38 != 0) {
                                            str2 = str35;
                                            boolean z35 = i34 < 8;
                                            boolean z36 = i34 != ServiceEnum.Chan.chan_none.value1;
                                            str3 = str36;
                                            int colorDoedCode = ColorUtil.getColorDoedCode(getRoot().getContext(), i34);
                                            if (i38 != 0) {
                                                j |= z36 ? 4398046511104L : 2199023255552L;
                                            }
                                            float alpha = ContextUtil.getAlpha(z35);
                                            i16 = z36 ? 0 : 4;
                                            i15 = colorDoedCode;
                                            f5 = alpha;
                                            j4 = j;
                                            z14 = z35;
                                            str22 = str38;
                                            if ((j4 & 1099512676384L) != 0) {
                                                if (decodeParam != null) {
                                                    f6 = f5;
                                                    i17 = i15;
                                                    j8 = decodeParam.getSpi_clock_thres();
                                                } else {
                                                    f6 = f5;
                                                    i17 = i15;
                                                    j8 = 0;
                                                }
                                                if (decodeParam != null) {
                                                    str23 = decodeParam.getDecodeLevelStr(j8);
                                                    if ((j4 & 1099545182240L) == 0) {
                                                        if (decodeParam != null) {
                                                            str24 = str23;
                                                            j7 = decodeParam.getSpi_miso_thres();
                                                        } else {
                                                            str24 = str23;
                                                            j7 = 0;
                                                        }
                                                        if (decodeParam != null) {
                                                            str25 = decodeParam.getDecodeLevelStr(j7);
                                                            i18 = ((j4 & 1099578736672L) > 0L ? 1 : ((j4 & 1099578736672L) == 0L ? 0 : -1));
                                                            if (i18 != 0) {
                                                                if (decodeParam != null) {
                                                                    z15 = z14;
                                                                    i33 = 1;
                                                                    str26 = str22;
                                                                    i32 = decodeParam.getSpi_clock_edge();
                                                                } else {
                                                                    str26 = str22;
                                                                    z15 = z14;
                                                                    i32 = 0;
                                                                    i33 = 1;
                                                                }
                                                                z17 = i32 == i33;
                                                                z16 = i32 == 0;
                                                                if (i18 != 0) {
                                                                    j4 |= z17 ? 281474976710656L : 140737488355328L;
                                                                }
                                                                if ((j4 & 1099578736672L) != 0) {
                                                                    j4 |= z16 ? LockFreeTaskQueueCore.FROZEN_MASK : 576460752303423488L;
                                                                }
                                                            } else {
                                                                str26 = str22;
                                                                z15 = z14;
                                                                z16 = false;
                                                                z17 = false;
                                                            }
                                                            if ((j4 & 1099520016416L) != 0) {
                                                                if (decodeParam != null) {
                                                                    str27 = str25;
                                                                    j6 = decodeParam.getSpi_timeout();
                                                                } else {
                                                                    str27 = str25;
                                                                    j6 = 0;
                                                                }
                                                                z18 = z16;
                                                                z19 = z17;
                                                                str28 = UnitFormat.newBuilder(UnitFormat.SI.FEMTO).convert(j6, ServiceEnum.Unit.Unit_s);
                                                            } else {
                                                                z18 = z16;
                                                                z19 = z17;
                                                                str27 = str25;
                                                                str28 = null;
                                                            }
                                                            if ((1100585369632L & j4) != 0) {
                                                                z20 = decodeParam != null ? decodeParam.isSpi_endian() : false;
                                                                z21 = !z20;
                                                            } else {
                                                                z20 = false;
                                                                z21 = false;
                                                            }
                                                            if ((j4 & 1099512152104L) != 0) {
                                                                if (decodeParam != null) {
                                                                    i31 = decodeParam.getSpi_clock();
                                                                    str29 = str28;
                                                                } else {
                                                                    str29 = str28;
                                                                    i31 = 0;
                                                                }
                                                                MappingObject mappingObject14 = ViewUtil.getMappingObject(R.array.msg_decode_spi_clk, i31);
                                                                z22 = z20;
                                                                updateRegistration(3, mappingObject14);
                                                                str30 = mappingObject14 != null ? mappingObject14.getStr() : null;
                                                                if ((j4 & 1099512152096L) != 0) {
                                                                    int colorDoedCode2 = ColorUtil.getColorDoedCode(getRoot().getContext(), i31);
                                                                    String str39 = str30;
                                                                    boolean z37 = i31 < 8;
                                                                    f7 = ContextUtil.getAlpha(z37);
                                                                    i19 = colorDoedCode2;
                                                                    z23 = z37;
                                                                    str30 = str39;
                                                                    i20 = ((j4 & 1103806595104L) > 0L ? 1 : ((j4 & 1103806595104L) == 0L ? 0 : -1));
                                                                    if (i20 == 0) {
                                                                        if (decodeParam != null) {
                                                                            z24 = z23;
                                                                            i30 = 1;
                                                                            str31 = str30;
                                                                            i29 = decodeParam.getSpi_cs_polarity();
                                                                        } else {
                                                                            str31 = str30;
                                                                            z24 = z23;
                                                                            i29 = 0;
                                                                            i30 = 1;
                                                                        }
                                                                        z26 = i29 == i30;
                                                                        z25 = i29 == 0;
                                                                        if (i20 != 0) {
                                                                            j4 |= z26 ? 4503599627370496L : 2251799813685248L;
                                                                        }
                                                                        if ((j4 & 1103806595104L) != 0) {
                                                                            j4 |= z25 ? 70368744177664L : 35184372088832L;
                                                                        }
                                                                    } else {
                                                                        str31 = str30;
                                                                        z24 = z23;
                                                                        z25 = false;
                                                                        z26 = false;
                                                                    }
                                                                    if ((j4 & 1099645845536L) == 0) {
                                                                        str32 = String.valueOf(decodeParam != null ? decodeParam.getSpi_width() : 0L);
                                                                    } else {
                                                                        str32 = null;
                                                                    }
                                                                    i21 = ((j4 & 1099511889952L) > 0L ? 1 : ((j4 & 1099511889952L) == 0L ? 0 : -1));
                                                                    if (i21 == 0) {
                                                                        if (decodeParam != null) {
                                                                            z28 = z26;
                                                                            z27 = z25;
                                                                            i27 = decodeParam.getSpi_mode();
                                                                        } else {
                                                                            z27 = z25;
                                                                            z28 = z26;
                                                                            i27 = 0;
                                                                        }
                                                                        boolean z38 = i27 == ServiceEnum.Trigger_Spi_CS.trig_spi_idle.value1;
                                                                        z29 = z21;
                                                                        if (i27 == 0) {
                                                                            i28 = 1;
                                                                            z31 = true;
                                                                        } else {
                                                                            z31 = false;
                                                                            i28 = 1;
                                                                        }
                                                                        i22 = i19;
                                                                        z30 = i27 == i28;
                                                                        boolean z39 = i27 == ServiceEnum.Trigger_Spi_CS.trig_spi_cs.value1;
                                                                        if (i21 != 0 && !z38) {
                                                                            j4 |= Long.MIN_VALUE;
                                                                        }
                                                                        if ((j4 & 1099511889952L) != 0) {
                                                                            j4 |= z31 ? 18014398509481984L : 9007199254740992L;
                                                                        }
                                                                        if ((j4 & 1099511889952L) != 0) {
                                                                            j4 |= z30 ? 4611686018427387904L : LockFreeTaskQueueCore.CLOSED_MASK;
                                                                        }
                                                                        if ((j4 & 1099511889952L) != 0) {
                                                                            j4 |= z39 ? 1125899906842624L : 562949953421312L;
                                                                        }
                                                                        int i39 = z38 ? 0 : 4;
                                                                        i24 = z39 ? 0 : 4;
                                                                        i23 = i39;
                                                                        j5 = j4;
                                                                    } else {
                                                                        z27 = z25;
                                                                        z28 = z26;
                                                                        z29 = z21;
                                                                        i22 = i19;
                                                                        j5 = j4;
                                                                        i23 = 0;
                                                                        z30 = false;
                                                                        i24 = 0;
                                                                        z31 = false;
                                                                    }
                                                                    i25 = ((j5 & 1101659111456L) > 0L ? 1 : ((j5 & 1101659111456L) == 0L ? 0 : -1));
                                                                    if (i25 == 0) {
                                                                        int spi_data_polarity = decodeParam != null ? decodeParam.getSpi_data_polarity() : 0;
                                                                        if (spi_data_polarity == 0) {
                                                                            i26 = 1;
                                                                            z32 = true;
                                                                        } else {
                                                                            z32 = false;
                                                                            i26 = 1;
                                                                        }
                                                                        int i40 = spi_data_polarity == i26 ? i26 : 0;
                                                                        if (i25 != 0) {
                                                                            j5 |= z32 ? 72057594037927936L : 36028797018963968L;
                                                                        }
                                                                        if ((j5 & 1101659111456L) != 0) {
                                                                            j5 |= i40 != 0 ? 17592186044416L : 8796093022208L;
                                                                        }
                                                                        i3 = i23;
                                                                        z5 = z30;
                                                                        i5 = i16;
                                                                        i9 = i40;
                                                                        i2 = i24;
                                                                        str11 = str32;
                                                                        z11 = z13;
                                                                        z12 = z32;
                                                                    } else {
                                                                        i3 = i23;
                                                                        z5 = z30;
                                                                        i5 = i16;
                                                                        z12 = false;
                                                                        i9 = 0;
                                                                        i2 = i24;
                                                                        str11 = str32;
                                                                        z11 = z13;
                                                                    }
                                                                    f3 = f4;
                                                                    i8 = i11;
                                                                    i7 = i12;
                                                                    i4 = i14;
                                                                    str8 = str20;
                                                                    str9 = str21;
                                                                    f2 = f6;
                                                                    i6 = i17;
                                                                    str4 = str24;
                                                                    str6 = str26;
                                                                    z10 = z15;
                                                                    str7 = str27;
                                                                    z2 = z19;
                                                                    z9 = z22;
                                                                    str10 = str31;
                                                                    z3 = z24;
                                                                    z6 = z27;
                                                                    z7 = z28;
                                                                    z4 = z31;
                                                                    z8 = z29;
                                                                    i = i22;
                                                                    j2 = j5;
                                                                    str13 = str37;
                                                                    f = f7;
                                                                    str12 = str17;
                                                                    z = z18;
                                                                    str5 = str29;
                                                                }
                                                            } else {
                                                                str29 = str28;
                                                                z22 = z20;
                                                                str30 = null;
                                                            }
                                                            z23 = false;
                                                            i19 = 0;
                                                            i20 = ((j4 & 1103806595104L) > 0L ? 1 : ((j4 & 1103806595104L) == 0L ? 0 : -1));
                                                            if (i20 == 0) {
                                                            }
                                                            if ((j4 & 1099645845536L) == 0) {
                                                            }
                                                            i21 = ((j4 & 1099511889952L) > 0L ? 1 : ((j4 & 1099511889952L) == 0L ? 0 : -1));
                                                            if (i21 == 0) {
                                                            }
                                                            i25 = ((j5 & 1101659111456L) > 0L ? 1 : ((j5 & 1101659111456L) == 0L ? 0 : -1));
                                                            if (i25 == 0) {
                                                            }
                                                            f3 = f4;
                                                            i8 = i11;
                                                            i7 = i12;
                                                            i4 = i14;
                                                            str8 = str20;
                                                            str9 = str21;
                                                            f2 = f6;
                                                            i6 = i17;
                                                            str4 = str24;
                                                            str6 = str26;
                                                            z10 = z15;
                                                            str7 = str27;
                                                            z2 = z19;
                                                            z9 = z22;
                                                            str10 = str31;
                                                            z3 = z24;
                                                            z6 = z27;
                                                            z7 = z28;
                                                            z4 = z31;
                                                            z8 = z29;
                                                            i = i22;
                                                            j2 = j5;
                                                            str13 = str37;
                                                            f = f7;
                                                            str12 = str17;
                                                            z = z18;
                                                            str5 = str29;
                                                        }
                                                    } else {
                                                        str24 = str23;
                                                    }
                                                    str25 = null;
                                                    i18 = ((j4 & 1099578736672L) > 0L ? 1 : ((j4 & 1099578736672L) == 0L ? 0 : -1));
                                                    if (i18 != 0) {
                                                    }
                                                    if ((j4 & 1099520016416L) != 0) {
                                                    }
                                                    if ((1100585369632L & j4) != 0) {
                                                    }
                                                    if ((j4 & 1099512152104L) != 0) {
                                                    }
                                                    z23 = false;
                                                    i19 = 0;
                                                    i20 = ((j4 & 1103806595104L) > 0L ? 1 : ((j4 & 1103806595104L) == 0L ? 0 : -1));
                                                    if (i20 == 0) {
                                                    }
                                                    if ((j4 & 1099645845536L) == 0) {
                                                    }
                                                    i21 = ((j4 & 1099511889952L) > 0L ? 1 : ((j4 & 1099511889952L) == 0L ? 0 : -1));
                                                    if (i21 == 0) {
                                                    }
                                                    i25 = ((j5 & 1101659111456L) > 0L ? 1 : ((j5 & 1101659111456L) == 0L ? 0 : -1));
                                                    if (i25 == 0) {
                                                    }
                                                    f3 = f4;
                                                    i8 = i11;
                                                    i7 = i12;
                                                    i4 = i14;
                                                    str8 = str20;
                                                    str9 = str21;
                                                    f2 = f6;
                                                    i6 = i17;
                                                    str4 = str24;
                                                    str6 = str26;
                                                    z10 = z15;
                                                    str7 = str27;
                                                    z2 = z19;
                                                    z9 = z22;
                                                    str10 = str31;
                                                    z3 = z24;
                                                    z6 = z27;
                                                    z7 = z28;
                                                    z4 = z31;
                                                    z8 = z29;
                                                    i = i22;
                                                    j2 = j5;
                                                    str13 = str37;
                                                    f = f7;
                                                    str12 = str17;
                                                    z = z18;
                                                    str5 = str29;
                                                }
                                            } else {
                                                f6 = f5;
                                                i17 = i15;
                                            }
                                            str23 = null;
                                            if ((j4 & 1099545182240L) == 0) {
                                            }
                                            str25 = null;
                                            i18 = ((j4 & 1099578736672L) > 0L ? 1 : ((j4 & 1099578736672L) == 0L ? 0 : -1));
                                            if (i18 != 0) {
                                            }
                                            if ((j4 & 1099520016416L) != 0) {
                                            }
                                            if ((1100585369632L & j4) != 0) {
                                            }
                                            if ((j4 & 1099512152104L) != 0) {
                                            }
                                            z23 = false;
                                            i19 = 0;
                                            i20 = ((j4 & 1103806595104L) > 0L ? 1 : ((j4 & 1103806595104L) == 0L ? 0 : -1));
                                            if (i20 == 0) {
                                            }
                                            if ((j4 & 1099645845536L) == 0) {
                                            }
                                            i21 = ((j4 & 1099511889952L) > 0L ? 1 : ((j4 & 1099511889952L) == 0L ? 0 : -1));
                                            if (i21 == 0) {
                                            }
                                            i25 = ((j5 & 1101659111456L) > 0L ? 1 : ((j5 & 1101659111456L) == 0L ? 0 : -1));
                                            if (i25 == 0) {
                                            }
                                            f3 = f4;
                                            i8 = i11;
                                            i7 = i12;
                                            i4 = i14;
                                            str8 = str20;
                                            str9 = str21;
                                            f2 = f6;
                                            i6 = i17;
                                            str4 = str24;
                                            str6 = str26;
                                            z10 = z15;
                                            str7 = str27;
                                            z2 = z19;
                                            z9 = z22;
                                            str10 = str31;
                                            z3 = z24;
                                            z6 = z27;
                                            z7 = z28;
                                            z4 = z31;
                                            z8 = z29;
                                            i = i22;
                                            j2 = j5;
                                            str13 = str37;
                                            f = f7;
                                            str12 = str17;
                                            z = z18;
                                            str5 = str29;
                                        } else {
                                            str2 = str35;
                                            str3 = str36;
                                            j4 = j;
                                        }
                                    } else {
                                        str20 = str18;
                                        str21 = str19;
                                        str2 = str35;
                                        str3 = str36;
                                        j4 = j;
                                        str22 = null;
                                    }
                                    f5 = 0.0f;
                                    z14 = false;
                                    i15 = 0;
                                    i16 = 0;
                                    if ((j4 & 1099512676384L) != 0) {
                                    }
                                    str23 = null;
                                    if ((j4 & 1099545182240L) == 0) {
                                    }
                                    str25 = null;
                                    i18 = ((j4 & 1099578736672L) > 0L ? 1 : ((j4 & 1099578736672L) == 0L ? 0 : -1));
                                    if (i18 != 0) {
                                    }
                                    if ((j4 & 1099520016416L) != 0) {
                                    }
                                    if ((1100585369632L & j4) != 0) {
                                    }
                                    if ((j4 & 1099512152104L) != 0) {
                                    }
                                    z23 = false;
                                    i19 = 0;
                                    i20 = ((j4 & 1103806595104L) > 0L ? 1 : ((j4 & 1103806595104L) == 0L ? 0 : -1));
                                    if (i20 == 0) {
                                    }
                                    if ((j4 & 1099645845536L) == 0) {
                                    }
                                    i21 = ((j4 & 1099511889952L) > 0L ? 1 : ((j4 & 1099511889952L) == 0L ? 0 : -1));
                                    if (i21 == 0) {
                                    }
                                    i25 = ((j5 & 1101659111456L) > 0L ? 1 : ((j5 & 1101659111456L) == 0L ? 0 : -1));
                                    if (i25 == 0) {
                                    }
                                    f3 = f4;
                                    i8 = i11;
                                    i7 = i12;
                                    i4 = i14;
                                    str8 = str20;
                                    str9 = str21;
                                    f2 = f6;
                                    i6 = i17;
                                    str4 = str24;
                                    str6 = str26;
                                    z10 = z15;
                                    str7 = str27;
                                    z2 = z19;
                                    z9 = z22;
                                    str10 = str31;
                                    z3 = z24;
                                    z6 = z27;
                                    z7 = z28;
                                    z4 = z31;
                                    z8 = z29;
                                    i = i22;
                                    j2 = j5;
                                    str13 = str37;
                                    f = f7;
                                    str12 = str17;
                                    z = z18;
                                    str5 = str29;
                                }
                            } else {
                                i14 = i13;
                            }
                            str19 = null;
                            if ((j & 1099515822116L) == 0) {
                            }
                            f5 = 0.0f;
                            z14 = false;
                            i15 = 0;
                            i16 = 0;
                            if ((j4 & 1099512676384L) != 0) {
                            }
                            str23 = null;
                            if ((j4 & 1099545182240L) == 0) {
                            }
                            str25 = null;
                            i18 = ((j4 & 1099578736672L) > 0L ? 1 : ((j4 & 1099578736672L) == 0L ? 0 : -1));
                            if (i18 != 0) {
                            }
                            if ((j4 & 1099520016416L) != 0) {
                            }
                            if ((1100585369632L & j4) != 0) {
                            }
                            if ((j4 & 1099512152104L) != 0) {
                            }
                            z23 = false;
                            i19 = 0;
                            i20 = ((j4 & 1103806595104L) > 0L ? 1 : ((j4 & 1103806595104L) == 0L ? 0 : -1));
                            if (i20 == 0) {
                            }
                            if ((j4 & 1099645845536L) == 0) {
                            }
                            i21 = ((j4 & 1099511889952L) > 0L ? 1 : ((j4 & 1099511889952L) == 0L ? 0 : -1));
                            if (i21 == 0) {
                            }
                            i25 = ((j5 & 1101659111456L) > 0L ? 1 : ((j5 & 1101659111456L) == 0L ? 0 : -1));
                            if (i25 == 0) {
                            }
                            f3 = f4;
                            i8 = i11;
                            i7 = i12;
                            i4 = i14;
                            str8 = str20;
                            str9 = str21;
                            f2 = f6;
                            i6 = i17;
                            str4 = str24;
                            str6 = str26;
                            z10 = z15;
                            str7 = str27;
                            z2 = z19;
                            z9 = z22;
                            str10 = str31;
                            z3 = z24;
                            z6 = z27;
                            z7 = z28;
                            z4 = z31;
                            z8 = z29;
                            i = i22;
                            j2 = j5;
                            str13 = str37;
                            f = f7;
                            str12 = str17;
                            z = z18;
                            str5 = str29;
                        }
                    } else {
                        str17 = str16;
                        i12 = i10;
                        j3 = 0;
                        str18 = null;
                    }
                    i13 = 0;
                    if ((j & 1100048498720L) != j3) {
                    }
                    str19 = null;
                    if ((j & 1099515822116L) == 0) {
                    }
                    f5 = 0.0f;
                    z14 = false;
                    i15 = 0;
                    i16 = 0;
                    if ((j4 & 1099512676384L) != 0) {
                    }
                    str23 = null;
                    if ((j4 & 1099545182240L) == 0) {
                    }
                    str25 = null;
                    i18 = ((j4 & 1099578736672L) > 0L ? 1 : ((j4 & 1099578736672L) == 0L ? 0 : -1));
                    if (i18 != 0) {
                    }
                    if ((j4 & 1099520016416L) != 0) {
                    }
                    if ((1100585369632L & j4) != 0) {
                    }
                    if ((j4 & 1099512152104L) != 0) {
                    }
                    z23 = false;
                    i19 = 0;
                    i20 = ((j4 & 1103806595104L) > 0L ? 1 : ((j4 & 1103806595104L) == 0L ? 0 : -1));
                    if (i20 == 0) {
                    }
                    if ((j4 & 1099645845536L) == 0) {
                    }
                    i21 = ((j4 & 1099511889952L) > 0L ? 1 : ((j4 & 1099511889952L) == 0L ? 0 : -1));
                    if (i21 == 0) {
                    }
                    i25 = ((j5 & 1101659111456L) > 0L ? 1 : ((j5 & 1101659111456L) == 0L ? 0 : -1));
                    if (i25 == 0) {
                    }
                    f3 = f4;
                    i8 = i11;
                    i7 = i12;
                    i4 = i14;
                    str8 = str20;
                    str9 = str21;
                    f2 = f6;
                    i6 = i17;
                    str4 = str24;
                    str6 = str26;
                    z10 = z15;
                    str7 = str27;
                    z2 = z19;
                    z9 = z22;
                    str10 = str31;
                    z3 = z24;
                    z6 = z27;
                    z7 = z28;
                    z4 = z31;
                    z8 = z29;
                    i = i22;
                    j2 = j5;
                    str13 = str37;
                    f = f7;
                    str12 = str17;
                    z = z18;
                    str5 = str29;
                }
            }
            str15 = null;
            String str372 = str15;
            if ((j & 1099513725088L) == 0) {
            }
            if ((j & 1099780064288L) == 0) {
            }
            i13 = 0;
            if ((j & 1100048498720L) != j3) {
            }
            str19 = null;
            if ((j & 1099515822116L) == 0) {
            }
            f5 = 0.0f;
            z14 = false;
            i15 = 0;
            i16 = 0;
            if ((j4 & 1099512676384L) != 0) {
            }
            str23 = null;
            if ((j4 & 1099545182240L) == 0) {
            }
            str25 = null;
            i18 = ((j4 & 1099578736672L) > 0L ? 1 : ((j4 & 1099578736672L) == 0L ? 0 : -1));
            if (i18 != 0) {
            }
            if ((j4 & 1099520016416L) != 0) {
            }
            if ((1100585369632L & j4) != 0) {
            }
            if ((j4 & 1099512152104L) != 0) {
            }
            z23 = false;
            i19 = 0;
            i20 = ((j4 & 1103806595104L) > 0L ? 1 : ((j4 & 1103806595104L) == 0L ? 0 : -1));
            if (i20 == 0) {
            }
            if ((j4 & 1099645845536L) == 0) {
            }
            i21 = ((j4 & 1099511889952L) > 0L ? 1 : ((j4 & 1099511889952L) == 0L ? 0 : -1));
            if (i21 == 0) {
            }
            i25 = ((j5 & 1101659111456L) > 0L ? 1 : ((j5 & 1101659111456L) == 0L ? 0 : -1));
            if (i25 == 0) {
            }
            f3 = f4;
            i8 = i11;
            i7 = i12;
            i4 = i14;
            str8 = str20;
            str9 = str21;
            f2 = f6;
            i6 = i17;
            str4 = str24;
            str6 = str26;
            z10 = z15;
            str7 = str27;
            z2 = z19;
            z9 = z22;
            str10 = str31;
            z3 = z24;
            z6 = z27;
            z7 = z28;
            z4 = z31;
            z8 = z29;
            i = i22;
            j2 = j5;
            str13 = str372;
            f = f7;
            str12 = str17;
            z = z18;
            str5 = str29;
        } else {
            str = str34;
            str2 = str35;
            str3 = str36;
            j2 = j;
            str4 = null;
            str5 = null;
            str6 = null;
            str7 = null;
            str8 = null;
            str9 = null;
            str10 = null;
            str11 = null;
            f = 0.0f;
            f2 = 0.0f;
            f3 = 0.0f;
            i = 0;
            z = false;
            z2 = false;
            z3 = false;
            i2 = 0;
            z4 = false;
            z5 = false;
            i3 = 0;
            z6 = false;
            z7 = false;
            i4 = 0;
            z8 = false;
            z9 = false;
            i5 = 0;
            z10 = false;
            i6 = 0;
            i7 = 0;
            z11 = false;
            i8 = 0;
            z12 = false;
            i9 = 0;
            str12 = null;
            str13 = null;
        }
        int i41 = ((j2 & 1108101562432L) > 0L ? 1 : ((j2 & 1108101562432L) == 0L ? 0 : -1));
        String str40 = (i41 == 0 || mappingObject4 == null) ? null : mappingObject4.getStr();
        int i42 = ((j2 & 1116691497216L) > 0L ? 1 : ((j2 & 1116691497216L) == 0L ? 0 : -1));
        String str41 = (i42 == 0 || mappingObject5 == null) ? null : mappingObject5.getStr();
        int i43 = ((j2 & 1133871366656L) > 0L ? 1 : ((j2 & 1133871366656L) == 0L ? 0 : -1));
        String str42 = (i43 == 0 || mappingObject6 == null) ? null : mappingObject6.getStr();
        int i44 = ((j2 & 1168231106560L) > 0L ? 1 : ((j2 & 1168231106560L) == 0L ? 0 : -1));
        String str43 = (i44 == 0 || mappingObject7 == null) ? null : mappingObject7.getStr();
        int i45 = ((j2 & 1236950585344L) > 0L ? 1 : ((j2 & 1236950585344L) == 0L ? 0 : -1));
        String str44 = (i45 == 0 || mappingObject8 == null) ? null : mappingObject8.getStr();
        int i46 = ((j2 & 1374389542912L) > 0L ? 1 : ((j2 & 1374389542912L) == 0L ? 0 : -1));
        String str45 = (i46 == 0 || mappingObject9 == null) ? null : mappingObject9.getStr();
        int i47 = ((j2 & 1649267458048L) > 0L ? 1 : ((j2 & 1649267458048L) == 0L ? 0 : -1));
        if (i47 != 0 && mappingObject10 != null) {
            str33 = mappingObject10.getStr();
        }
        String str46 = str33;
        if ((j2 & 1099578736672L) != 0) {
            str14 = str41;
            CompoundButtonBindingAdapter.setChecked(this.decodeSpiClkEdgeDownRadioButton, z2);
            CompoundButtonBindingAdapter.setChecked(this.decodeSpiClkEdgeUpRadioButton, z);
        } else {
            str14 = str41;
        }
        if (i41 != 0) {
            TextViewBindingAdapter.setText(this.decodeSpiClkEdgeDownRadioButton, str40);
        }
        if (i43 != 0) {
            TextViewBindingAdapter.setText(this.decodeSpiClkEdgeUpRadioButton, str42);
        }
        if ((1099512152096L & j2) != 0) {
            if (getBuildSdkInt() >= 11) {
                this.decodeSpiClkThresValue.setAlpha(f);
            }
            this.decodeSpiClkThresValue.setEnabled(z3);
            this.decodeSpiClkValue.setTextColor(i);
        }
        if ((j2 & 1099512676384L) != 0) {
            TextViewBindingAdapter.setText(this.decodeSpiClkThresValue, str4);
        }
        if ((1099512152104L & j2) != 0) {
            TextViewBindingAdapter.setText(this.decodeSpiClkValue, str10);
        }
        if ((j2 & 1099511889952L) != 0) {
            int i48 = i2;
            this.decodeSpiCsLabel.setVisibility(i48);
            this.decodeSpiCsPolLabel.setVisibility(i48);
            this.decodeSpiCsPolRadioGroup.setVisibility(i48);
            this.decodeSpiCsThresLabel.setVisibility(i48);
            this.decodeSpiCsThresValue.setVisibility(i48);
            this.decodeSpiCsValue.setVisibility(i48);
            CompoundButtonBindingAdapter.setChecked(this.decodeSpiModeCsRadioButton, z4);
            CompoundButtonBindingAdapter.setChecked(this.decodeSpiModeTimeoutRadioButton, z5);
            int i49 = i3;
            this.decodeSpiTmoLabel.setVisibility(i49);
            this.decodeSpiTmoValue.setVisibility(i49);
        }
        if ((j2 & 1103806595104L) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.decodeSpiCsPolNegativeRadioButton, z6);
            CompoundButtonBindingAdapter.setChecked(this.decodeSpiCsPolPositiveRadioButton, z7);
        }
        if (i46 != 0) {
            TextViewBindingAdapter.setText(this.decodeSpiCsPolNegativeRadioButton, str45);
        }
        if (i47 != 0) {
            TextViewBindingAdapter.setText(this.decodeSpiCsPolPositiveRadioButton, str46);
        }
        if ((j2 & 1100048498720L) != 0) {
            TextViewBindingAdapter.setText(this.decodeSpiCsThresValue, str9);
        }
        if ((j2 & 1099780064288L) != 0) {
            TextViewBindingAdapter.setText(this.decodeSpiCsValue, str8);
        }
        if ((1099780063264L & j2) != 0) {
            this.decodeSpiCsValue.setTextColor(i4);
        }
        if ((1100585369632L & j2) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.decodeSpiEndianLSBRadioButton, z8);
            CompoundButtonBindingAdapter.setChecked(this.decodeSpiEndianMSBRadioButton, z9);
        }
        if ((j2 & 1099511758864L) != 0) {
            TextViewBindingAdapter.setText(this.decodeSpiEndianLSBRadioButton, str3);
        }
        if (i45 != 0) {
            TextViewBindingAdapter.setText(this.decodeSpiEndianMSBRadioButton, str44);
        }
        if ((1099515822112L & j2) != 0) {
            int i50 = i5;
            this.decodeSpiMisoThresLabel.setVisibility(i50);
            this.decodeSpiMisoThresValue.setEnabled(z10);
            this.decodeSpiMisoThresValue.setVisibility(i50);
            this.decodeSpiMisoValue.setTextColor(i6);
            if (getBuildSdkInt() >= 11) {
                this.decodeSpiMisoThresValue.setAlpha(f2);
            }
        }
        if ((1099545182240L & j2) != 0) {
            TextViewBindingAdapter.setText(this.decodeSpiMisoThresValue, str7);
        }
        if ((j2 & 1099515822116L) != 0) {
            TextViewBindingAdapter.setText(this.decodeSpiMisoValue, str6);
        }
        if (i44 != 0) {
            TextViewBindingAdapter.setText(this.decodeSpiModeCsRadioButton, str43);
        }
        if ((j2 & 1099511693314L) != 0) {
            TextViewBindingAdapter.setText(this.decodeSpiModeTimeoutRadioButton, str2);
        }
        if ((j2 & 1099513724960L) != 0) {
            int i51 = i7;
            this.decodeSpiMosiThresLabel.setVisibility(i51);
            this.decodeSpiMosiThresValue.setEnabled(z11);
            this.decodeSpiMosiThresValue.setVisibility(i51);
            this.decodeSpiMosiValue.setTextColor(i8);
            if (getBuildSdkInt() >= 11) {
                this.decodeSpiMosiThresValue.setAlpha(f3);
            }
        }
        if ((j2 & 1099528405024L) != 0) {
            TextViewBindingAdapter.setText(this.decodeSpiMosiThresValue, str13);
        }
        if ((j2 & 1099513725088L) != 0) {
            TextViewBindingAdapter.setText(this.decodeSpiMosiValue, str12);
        }
        if ((j2 & 1101659111456L) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.decodeSpiPolarityNegativeRadioButton, z12);
            CompoundButtonBindingAdapter.setChecked(this.decodeSpiPolarityPositiveRadioButton, i9);
        }
        if ((j2 & 1099511660545L) != 0) {
            TextViewBindingAdapter.setText(this.decodeSpiPolarityNegativeRadioButton, str);
        }
        if (i42 != 0) {
            TextViewBindingAdapter.setText(this.decodeSpiPolarityPositiveRadioButton, str14);
        }
        if ((1099520016416L & j2) != 0) {
            TextViewBindingAdapter.setText(this.decodeSpiTmoValue, str5);
        }
        if ((1099645845536L & j2) != 0) {
            TextViewBindingAdapter.setText(this.decodeSpiWidthValue, str11);
        }
    }
}
