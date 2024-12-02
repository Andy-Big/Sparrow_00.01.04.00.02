package com.rigol.scope.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.InverseBindingListener;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.CompoundButtonBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.rigol.scope.R;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.LaParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.UnitFormat;
import com.rigol.scope.utilities.ViewUtil;
import java.util.List;

/* loaded from: classes2.dex */
public class AdapterLaBasicBindingImpl extends AdapterLaBasicBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.la_wave_size, 24);
        sViewsWithIds.put(R.id.la_peak, 25);
    }

    public AdapterLaBasicBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 26, sIncludes, sViewsWithIds));
    }

    private AdapterLaBasicBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3, (AppCompatCheckBox) objArr[3], (AppCompatCheckBox) objArr[1], (AppCompatCheckBox) objArr[4], (AppCompatCheckBox) objArr[15], (AppCompatCheckBox) objArr[16], (AppCompatCheckBox) objArr[17], (AppCompatCheckBox) objArr[18], (AppCompatCheckBox) objArr[19], (AppCompatCheckBox) objArr[20], (AppCompatCheckBox) objArr[5], (AppCompatCheckBox) objArr[6], (AppCompatCheckBox) objArr[7], (AppCompatCheckBox) objArr[8], (AppCompatCheckBox) objArr[9], (AppCompatCheckBox) objArr[10], (AppCompatCheckBox) objArr[13], (AppCompatCheckBox) objArr[11], (AppCompatCheckBox) objArr[14], (EditText) objArr[2], (EditText) objArr[12], (TextView) objArr[23], (TextView) objArr[25], (TextView) objArr[22], (TextView) objArr[24], (TextView) objArr[21]);
        this.mDirtyFlags = -1L;
        this.d0.setTag(null);
        this.d0tod7.setTag(null);
        this.d1.setTag(null);
        this.d10.setTag(null);
        this.d11.setTag(null);
        this.d12.setTag(null);
        this.d13.setTag(null);
        this.d14.setTag(null);
        this.d15.setTag(null);
        this.d2.setTag(null);
        this.d3.setTag(null);
        this.d4.setTag(null);
        this.d5.setTag(null);
        this.d6.setTag(null);
        this.d7.setTag(null);
        this.d8.setTag(null);
        this.d8tod15.setTag(null);
        this.d9.setTag(null);
        this.laBasic.setTag(null);
        this.laBasicTwo.setTag(null);
        this.laOrder.setTag(null);
        this.laPeakSpinner.setTag(null);
        this.laWaveSpinner.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
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
        if (600 == i) {
            setParma((LaParam) obj);
        } else if (177 != i) {
            return false;
        } else {
            setCheckedChangeListener((CompoundButton.OnCheckedChangeListener) obj);
        }
        return true;
    }

    @Override // com.rigol.scope.databinding.AdapterLaBasicBinding
    public void setParma(LaParam laParam) {
        updateRegistration(1, laParam);
        this.mParma = laParam;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(600);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterLaBasicBinding
    public void setCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.mCheckedChangeListener = onCheckedChangeListener;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(177);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    return false;
                }
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgLaWaveSizeParmaLaSize((MappingObject) obj, i2);
            }
            return onChangeParma((LaParam) obj, i2);
        }
        return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgLaAutoSetParmaLaOrder((MappingObject) obj, i2);
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgLaAutoSetParmaLaOrder(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeParma(LaParam laParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        } else if (i == 209) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        } else if (i == 210) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        } else if (i == 168) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        } else if (i == 211) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
            }
            return true;
        } else if (i == 212) {
            synchronized (this) {
                this.mDirtyFlags |= 256;
            }
            return true;
        } else if (i == 472) {
            synchronized (this) {
                this.mDirtyFlags |= 512;
            }
            return true;
        } else if (i == 466) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 455) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgLaWaveSizeParmaLaSize(MappingObject mappingObject, int i) {
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

    /* JADX WARN: Removed duplicated region for block: B:100:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0241  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x024c  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0264  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0286  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0296  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x02ad  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x02bb  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x02d2  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x02e0  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x02f8  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0308  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0320  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0330  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0347  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0355  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x036d  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0378  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0390  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x039e  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x03b5  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x03c5  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x03dd  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x03eb  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x0403  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x0411  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x042a  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x020c  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void executeBindings() {
        long j;
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener;
        String str;
        String str2;
        String str3;
        String str4;
        float f;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z20;
        float f2;
        String str5;
        boolean z21;
        String str6;
        boolean z22;
        boolean z23;
        boolean z24;
        boolean z25;
        boolean z26;
        boolean z27;
        boolean z28;
        boolean z29;
        String str7;
        String str8;
        boolean z30;
        boolean z31;
        boolean z32;
        boolean z33;
        boolean z34;
        boolean z35;
        boolean z36;
        boolean z37;
        boolean z38;
        boolean z39;
        boolean z40;
        boolean z41;
        boolean z42;
        boolean z43;
        boolean z44;
        boolean z45;
        boolean z46;
        boolean z47;
        boolean z48;
        boolean z49;
        boolean z50;
        boolean z51;
        boolean z52;
        boolean z53;
        boolean z54;
        boolean z55;
        boolean z56;
        boolean z57;
        boolean z58;
        String str9;
        boolean z59;
        float f3;
        int i;
        boolean z60;
        int i2;
        boolean z61;
        long j2;
        long j3;
        long j4;
        long j5;
        long j6;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        LaParam laParam = this.mParma;
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener2 = this.mCheckedChangeListener;
        if ((16375 & j) != 0) {
            if ((j & 9219) != 0) {
                MappingObject mappingObject = ViewUtil.getMappingObject(R.array.msg_la_auto_set, laParam != null ? laParam.getLa_order() : 0);
                updateRegistration(0, mappingObject);
                if (mappingObject != null) {
                    str9 = mappingObject.getStr();
                    if ((j & 10242) == 0) {
                        z59 = laParam != null ? laParam.getLa_calibration_probe() : false;
                        f3 = ContextUtil.getAlpha(z59);
                    } else {
                        z59 = false;
                        f3 = 0.0f;
                    }
                    ServiceEnum.Unit unit = ((j & 8482) != 0 || laParam == null) ? null : laParam.getUnit();
                    i = ((j & 8386) > 0L ? 1 : ((j & 8386) == 0L ? 0 : -1));
                    if (i == 0) {
                        z60 = laParam != null ? laParam.getD8TOd15() : false;
                        if (i != 0) {
                            if (z60) {
                                j5 = j | PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID | PlaybackStateCompat.ACTION_PREPARE_FROM_URI | PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE | 536870912 | 2147483648L | 8589934592L | 549755813888L;
                                j6 = 2199023255552L;
                            } else {
                                j5 = j | PlaybackStateCompat.ACTION_PREPARE | PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH | PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED | 268435456 | 1073741824 | 4294967296L | 274877906944L;
                                j6 = 1099511627776L;
                            }
                            j = j5 | j6;
                        }
                    } else {
                        z60 = false;
                    }
                    if ((j & 12806) != 0) {
                        MappingObject mappingObject2 = ViewUtil.getMappingObject(R.array.msg_la_wave_size, laParam != null ? laParam.getLa_size_() : 0);
                        updateRegistration(2, mappingObject2);
                        if (mappingObject2 != null) {
                            str4 = mappingObject2.getStr();
                            i2 = ((j & 8274) > 0L ? 1 : ((j & 8274) == 0L ? 0 : -1));
                            if (i2 != 0) {
                                z61 = laParam != null ? laParam.getD0TOd7() : false;
                                if (i2 != 0) {
                                    if (z61) {
                                        j3 = j | PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED | 8388608 | 33554432 | 134217728 | 34359738368L | 137438953472L | 8796093022208L;
                                        j4 = 35184372088832L;
                                    } else {
                                        j3 = j | PlaybackStateCompat.ACTION_SET_REPEAT_MODE | 4194304 | 16777216 | 67108864 | 17179869184L | 68719476736L | 4398046511104L;
                                        j4 = 17592186044416L;
                                    }
                                    j = j3 | j4;
                                }
                            } else {
                                z61 = false;
                            }
                            if ((j & 8226) != 0) {
                                if (laParam != null) {
                                    onCheckedChangeListener = onCheckedChangeListener2;
                                    j2 = laParam.getD0TOd7_threshold_();
                                } else {
                                    onCheckedChangeListener = onCheckedChangeListener2;
                                    j2 = 0;
                                }
                                str = UnitFormat.newBuilder(UnitFormat.SI.NANO).convert(j2, unit);
                            } else {
                                onCheckedChangeListener = onCheckedChangeListener2;
                                str = null;
                            }
                            if ((j & 8450) != 0) {
                                String convert = UnitFormat.newBuilder(UnitFormat.SI.NANO).convert(laParam != null ? laParam.getD8TOd15_threshold_() : 0L, unit);
                                z = z59;
                                z2 = z61;
                                z3 = z60;
                                str3 = str9;
                                str2 = convert;
                                f = f3;
                            } else {
                                z = z59;
                                f = f3;
                                z2 = z61;
                                z3 = z60;
                                str3 = str9;
                                str2 = null;
                            }
                        }
                    }
                    str4 = null;
                    i2 = ((j & 8274) > 0L ? 1 : ((j & 8274) == 0L ? 0 : -1));
                    if (i2 != 0) {
                    }
                    if ((j & 8226) != 0) {
                    }
                    if ((j & 8450) != 0) {
                    }
                }
            }
            str9 = null;
            if ((j & 10242) == 0) {
            }
            if ((j & 8482) != 0) {
            }
            i = ((j & 8386) > 0L ? 1 : ((j & 8386) == 0L ? 0 : -1));
            if (i == 0) {
            }
            if ((j & 12806) != 0) {
            }
            str4 = null;
            i2 = ((j & 8274) > 0L ? 1 : ((j & 8274) == 0L ? 0 : -1));
            if (i2 != 0) {
            }
            if ((j & 8226) != 0) {
            }
            if ((j & 8450) != 0) {
            }
        } else {
            onCheckedChangeListener = onCheckedChangeListener2;
            str = null;
            str2 = null;
            str3 = null;
            str4 = null;
            f = 0.0f;
            z = false;
            z2 = false;
            z3 = false;
        }
        int i3 = ((j & 8200) > 0L ? 1 : ((j & 8200) == 0L ? 0 : -1));
        boolean z62 = true;
        if ((j & 23456248053760L) != 0) {
            List<Integer> chanStateList = laParam != null ? laParam.getChanStateList() : null;
            if ((j & 4398046511104L) != 0) {
                if (ViewDataBinding.safeUnbox(chanStateList != null ? (Integer) getFromList(chanStateList, 1) : null) == 1) {
                    z43 = true;
                    if ((j & 4294967296L) != 0) {
                        if (ViewDataBinding.safeUnbox(chanStateList != null ? (Integer) getFromList(chanStateList, 10) : null) == 1) {
                            z44 = true;
                            if ((j & 17179869184L) != 0) {
                                z13 = z43;
                                if (ViewDataBinding.safeUnbox(chanStateList != null ? (Integer) getFromList(chanStateList, 4) : null) == 1) {
                                    z45 = true;
                                    if ((j & 1073741824) == 0) {
                                        z11 = z45;
                                        if (ViewDataBinding.safeUnbox(chanStateList != null ? (Integer) getFromList(chanStateList, 15) : null) == 1) {
                                            z46 = true;
                                            if ((j & PlaybackStateCompat.ACTION_SET_REPEAT_MODE) != 0) {
                                                z9 = z46;
                                                if (ViewDataBinding.safeUnbox(chanStateList != null ? (Integer) getFromList(chanStateList, 7) : null) == 1) {
                                                    z47 = true;
                                                    if ((j & 68719476736L) == 0) {
                                                        z10 = z47;
                                                        if (ViewDataBinding.safeUnbox(chanStateList != null ? (Integer) getFromList(chanStateList, 3) : null) == 1) {
                                                            z48 = true;
                                                            if ((j & 16777216) != 0) {
                                                                z12 = z48;
                                                                if (ViewDataBinding.safeUnbox(chanStateList != null ? (Integer) getFromList(chanStateList, 6) : null) == 1) {
                                                                    z49 = true;
                                                                    if ((j & PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) == 0) {
                                                                        z14 = z49;
                                                                        if (ViewDataBinding.safeUnbox(chanStateList != null ? (Integer) getFromList(chanStateList, 13) : null) == 1) {
                                                                            z50 = true;
                                                                            if ((j & 1099511627776L) != 0) {
                                                                                z15 = z50;
                                                                                if (ViewDataBinding.safeUnbox(chanStateList != null ? (Integer) getFromList(chanStateList, 9) : null) == 1) {
                                                                                    z51 = true;
                                                                                    if ((j & 17592186044416L) == 0) {
                                                                                        z16 = z51;
                                                                                        if (ViewDataBinding.safeUnbox(chanStateList != null ? (Integer) getFromList(chanStateList, 5) : null) == 1) {
                                                                                            z52 = true;
                                                                                            if ((j & 268435456) != 0) {
                                                                                                z19 = z52;
                                                                                                if (ViewDataBinding.safeUnbox(chanStateList != null ? (Integer) getFromList(chanStateList, 8) : null) == 1) {
                                                                                                    z53 = true;
                                                                                                    if ((j & PlaybackStateCompat.ACTION_PREPARE) == 0) {
                                                                                                        z8 = z53;
                                                                                                        if (ViewDataBinding.safeUnbox(chanStateList != null ? (Integer) getFromList(chanStateList, 14) : null) == 1) {
                                                                                                            z54 = true;
                                                                                                            if ((j & 4194304) != 0) {
                                                                                                                z55 = z54;
                                                                                                                if (ViewDataBinding.safeUnbox(chanStateList != null ? (Integer) getFromList(chanStateList, 0) : null) == 1) {
                                                                                                                    z56 = true;
                                                                                                                    if ((j & 274877906944L) == 0) {
                                                                                                                        z17 = z56;
                                                                                                                        if (ViewDataBinding.safeUnbox(chanStateList != null ? (Integer) getFromList(chanStateList, 11) : null) == 1) {
                                                                                                                            z57 = true;
                                                                                                                            if ((j & PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) != 0) {
                                                                                                                                z18 = z57;
                                                                                                                                if (ViewDataBinding.safeUnbox(chanStateList != null ? (Integer) getFromList(chanStateList, 12) : null) == 1) {
                                                                                                                                    z58 = true;
                                                                                                                                    if ((j & 67108864) == 0) {
                                                                                                                                        z62 = true;
                                                                                                                                        z4 = ViewDataBinding.safeUnbox(chanStateList != null ? (Integer) getFromList(chanStateList, 2) : null) == 1;
                                                                                                                                        z7 = z44;
                                                                                                                                    } else {
                                                                                                                                        z62 = true;
                                                                                                                                        z7 = z44;
                                                                                                                                        z4 = false;
                                                                                                                                    }
                                                                                                                                    z6 = z58;
                                                                                                                                    z5 = z55;
                                                                                                                                }
                                                                                                                            } else {
                                                                                                                                z18 = z57;
                                                                                                                            }
                                                                                                                            z58 = false;
                                                                                                                            if ((j & 67108864) == 0) {
                                                                                                                            }
                                                                                                                            z6 = z58;
                                                                                                                            z5 = z55;
                                                                                                                        }
                                                                                                                    } else {
                                                                                                                        z17 = z56;
                                                                                                                    }
                                                                                                                    z57 = false;
                                                                                                                    if ((j & PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) != 0) {
                                                                                                                    }
                                                                                                                    z58 = false;
                                                                                                                    if ((j & 67108864) == 0) {
                                                                                                                    }
                                                                                                                    z6 = z58;
                                                                                                                    z5 = z55;
                                                                                                                }
                                                                                                            } else {
                                                                                                                z55 = z54;
                                                                                                            }
                                                                                                            z56 = false;
                                                                                                            if ((j & 274877906944L) == 0) {
                                                                                                            }
                                                                                                            z57 = false;
                                                                                                            if ((j & PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) != 0) {
                                                                                                            }
                                                                                                            z58 = false;
                                                                                                            if ((j & 67108864) == 0) {
                                                                                                            }
                                                                                                            z6 = z58;
                                                                                                            z5 = z55;
                                                                                                        }
                                                                                                    } else {
                                                                                                        z8 = z53;
                                                                                                    }
                                                                                                    z54 = false;
                                                                                                    if ((j & 4194304) != 0) {
                                                                                                    }
                                                                                                    z56 = false;
                                                                                                    if ((j & 274877906944L) == 0) {
                                                                                                    }
                                                                                                    z57 = false;
                                                                                                    if ((j & PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) != 0) {
                                                                                                    }
                                                                                                    z58 = false;
                                                                                                    if ((j & 67108864) == 0) {
                                                                                                    }
                                                                                                    z6 = z58;
                                                                                                    z5 = z55;
                                                                                                }
                                                                                            } else {
                                                                                                z19 = z52;
                                                                                            }
                                                                                            z53 = false;
                                                                                            if ((j & PlaybackStateCompat.ACTION_PREPARE) == 0) {
                                                                                            }
                                                                                            z54 = false;
                                                                                            if ((j & 4194304) != 0) {
                                                                                            }
                                                                                            z56 = false;
                                                                                            if ((j & 274877906944L) == 0) {
                                                                                            }
                                                                                            z57 = false;
                                                                                            if ((j & PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) != 0) {
                                                                                            }
                                                                                            z58 = false;
                                                                                            if ((j & 67108864) == 0) {
                                                                                            }
                                                                                            z6 = z58;
                                                                                            z5 = z55;
                                                                                        }
                                                                                    } else {
                                                                                        z16 = z51;
                                                                                    }
                                                                                    z52 = false;
                                                                                    if ((j & 268435456) != 0) {
                                                                                    }
                                                                                    z53 = false;
                                                                                    if ((j & PlaybackStateCompat.ACTION_PREPARE) == 0) {
                                                                                    }
                                                                                    z54 = false;
                                                                                    if ((j & 4194304) != 0) {
                                                                                    }
                                                                                    z56 = false;
                                                                                    if ((j & 274877906944L) == 0) {
                                                                                    }
                                                                                    z57 = false;
                                                                                    if ((j & PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) != 0) {
                                                                                    }
                                                                                    z58 = false;
                                                                                    if ((j & 67108864) == 0) {
                                                                                    }
                                                                                    z6 = z58;
                                                                                    z5 = z55;
                                                                                }
                                                                            } else {
                                                                                z15 = z50;
                                                                            }
                                                                            z51 = false;
                                                                            if ((j & 17592186044416L) == 0) {
                                                                            }
                                                                            z52 = false;
                                                                            if ((j & 268435456) != 0) {
                                                                            }
                                                                            z53 = false;
                                                                            if ((j & PlaybackStateCompat.ACTION_PREPARE) == 0) {
                                                                            }
                                                                            z54 = false;
                                                                            if ((j & 4194304) != 0) {
                                                                            }
                                                                            z56 = false;
                                                                            if ((j & 274877906944L) == 0) {
                                                                            }
                                                                            z57 = false;
                                                                            if ((j & PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) != 0) {
                                                                            }
                                                                            z58 = false;
                                                                            if ((j & 67108864) == 0) {
                                                                            }
                                                                            z6 = z58;
                                                                            z5 = z55;
                                                                        }
                                                                    } else {
                                                                        z14 = z49;
                                                                    }
                                                                    z50 = false;
                                                                    if ((j & 1099511627776L) != 0) {
                                                                    }
                                                                    z51 = false;
                                                                    if ((j & 17592186044416L) == 0) {
                                                                    }
                                                                    z52 = false;
                                                                    if ((j & 268435456) != 0) {
                                                                    }
                                                                    z53 = false;
                                                                    if ((j & PlaybackStateCompat.ACTION_PREPARE) == 0) {
                                                                    }
                                                                    z54 = false;
                                                                    if ((j & 4194304) != 0) {
                                                                    }
                                                                    z56 = false;
                                                                    if ((j & 274877906944L) == 0) {
                                                                    }
                                                                    z57 = false;
                                                                    if ((j & PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) != 0) {
                                                                    }
                                                                    z58 = false;
                                                                    if ((j & 67108864) == 0) {
                                                                    }
                                                                    z6 = z58;
                                                                    z5 = z55;
                                                                }
                                                            } else {
                                                                z12 = z48;
                                                            }
                                                            z49 = false;
                                                            if ((j & PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) == 0) {
                                                            }
                                                            z50 = false;
                                                            if ((j & 1099511627776L) != 0) {
                                                            }
                                                            z51 = false;
                                                            if ((j & 17592186044416L) == 0) {
                                                            }
                                                            z52 = false;
                                                            if ((j & 268435456) != 0) {
                                                            }
                                                            z53 = false;
                                                            if ((j & PlaybackStateCompat.ACTION_PREPARE) == 0) {
                                                            }
                                                            z54 = false;
                                                            if ((j & 4194304) != 0) {
                                                            }
                                                            z56 = false;
                                                            if ((j & 274877906944L) == 0) {
                                                            }
                                                            z57 = false;
                                                            if ((j & PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) != 0) {
                                                            }
                                                            z58 = false;
                                                            if ((j & 67108864) == 0) {
                                                            }
                                                            z6 = z58;
                                                            z5 = z55;
                                                        }
                                                    } else {
                                                        z10 = z47;
                                                    }
                                                    z48 = false;
                                                    if ((j & 16777216) != 0) {
                                                    }
                                                    z49 = false;
                                                    if ((j & PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) == 0) {
                                                    }
                                                    z50 = false;
                                                    if ((j & 1099511627776L) != 0) {
                                                    }
                                                    z51 = false;
                                                    if ((j & 17592186044416L) == 0) {
                                                    }
                                                    z52 = false;
                                                    if ((j & 268435456) != 0) {
                                                    }
                                                    z53 = false;
                                                    if ((j & PlaybackStateCompat.ACTION_PREPARE) == 0) {
                                                    }
                                                    z54 = false;
                                                    if ((j & 4194304) != 0) {
                                                    }
                                                    z56 = false;
                                                    if ((j & 274877906944L) == 0) {
                                                    }
                                                    z57 = false;
                                                    if ((j & PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) != 0) {
                                                    }
                                                    z58 = false;
                                                    if ((j & 67108864) == 0) {
                                                    }
                                                    z6 = z58;
                                                    z5 = z55;
                                                }
                                            } else {
                                                z9 = z46;
                                            }
                                            z47 = false;
                                            if ((j & 68719476736L) == 0) {
                                            }
                                            z48 = false;
                                            if ((j & 16777216) != 0) {
                                            }
                                            z49 = false;
                                            if ((j & PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) == 0) {
                                            }
                                            z50 = false;
                                            if ((j & 1099511627776L) != 0) {
                                            }
                                            z51 = false;
                                            if ((j & 17592186044416L) == 0) {
                                            }
                                            z52 = false;
                                            if ((j & 268435456) != 0) {
                                            }
                                            z53 = false;
                                            if ((j & PlaybackStateCompat.ACTION_PREPARE) == 0) {
                                            }
                                            z54 = false;
                                            if ((j & 4194304) != 0) {
                                            }
                                            z56 = false;
                                            if ((j & 274877906944L) == 0) {
                                            }
                                            z57 = false;
                                            if ((j & PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) != 0) {
                                            }
                                            z58 = false;
                                            if ((j & 67108864) == 0) {
                                            }
                                            z6 = z58;
                                            z5 = z55;
                                        }
                                    } else {
                                        z11 = z45;
                                    }
                                    z46 = false;
                                    if ((j & PlaybackStateCompat.ACTION_SET_REPEAT_MODE) != 0) {
                                    }
                                    z47 = false;
                                    if ((j & 68719476736L) == 0) {
                                    }
                                    z48 = false;
                                    if ((j & 16777216) != 0) {
                                    }
                                    z49 = false;
                                    if ((j & PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) == 0) {
                                    }
                                    z50 = false;
                                    if ((j & 1099511627776L) != 0) {
                                    }
                                    z51 = false;
                                    if ((j & 17592186044416L) == 0) {
                                    }
                                    z52 = false;
                                    if ((j & 268435456) != 0) {
                                    }
                                    z53 = false;
                                    if ((j & PlaybackStateCompat.ACTION_PREPARE) == 0) {
                                    }
                                    z54 = false;
                                    if ((j & 4194304) != 0) {
                                    }
                                    z56 = false;
                                    if ((j & 274877906944L) == 0) {
                                    }
                                    z57 = false;
                                    if ((j & PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) != 0) {
                                    }
                                    z58 = false;
                                    if ((j & 67108864) == 0) {
                                    }
                                    z6 = z58;
                                    z5 = z55;
                                }
                            } else {
                                z13 = z43;
                            }
                            z45 = false;
                            if ((j & 1073741824) == 0) {
                            }
                            z46 = false;
                            if ((j & PlaybackStateCompat.ACTION_SET_REPEAT_MODE) != 0) {
                            }
                            z47 = false;
                            if ((j & 68719476736L) == 0) {
                            }
                            z48 = false;
                            if ((j & 16777216) != 0) {
                            }
                            z49 = false;
                            if ((j & PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) == 0) {
                            }
                            z50 = false;
                            if ((j & 1099511627776L) != 0) {
                            }
                            z51 = false;
                            if ((j & 17592186044416L) == 0) {
                            }
                            z52 = false;
                            if ((j & 268435456) != 0) {
                            }
                            z53 = false;
                            if ((j & PlaybackStateCompat.ACTION_PREPARE) == 0) {
                            }
                            z54 = false;
                            if ((j & 4194304) != 0) {
                            }
                            z56 = false;
                            if ((j & 274877906944L) == 0) {
                            }
                            z57 = false;
                            if ((j & PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) != 0) {
                            }
                            z58 = false;
                            if ((j & 67108864) == 0) {
                            }
                            z6 = z58;
                            z5 = z55;
                        }
                    }
                    z44 = false;
                    if ((j & 17179869184L) != 0) {
                    }
                    z45 = false;
                    if ((j & 1073741824) == 0) {
                    }
                    z46 = false;
                    if ((j & PlaybackStateCompat.ACTION_SET_REPEAT_MODE) != 0) {
                    }
                    z47 = false;
                    if ((j & 68719476736L) == 0) {
                    }
                    z48 = false;
                    if ((j & 16777216) != 0) {
                    }
                    z49 = false;
                    if ((j & PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) == 0) {
                    }
                    z50 = false;
                    if ((j & 1099511627776L) != 0) {
                    }
                    z51 = false;
                    if ((j & 17592186044416L) == 0) {
                    }
                    z52 = false;
                    if ((j & 268435456) != 0) {
                    }
                    z53 = false;
                    if ((j & PlaybackStateCompat.ACTION_PREPARE) == 0) {
                    }
                    z54 = false;
                    if ((j & 4194304) != 0) {
                    }
                    z56 = false;
                    if ((j & 274877906944L) == 0) {
                    }
                    z57 = false;
                    if ((j & PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) != 0) {
                    }
                    z58 = false;
                    if ((j & 67108864) == 0) {
                    }
                    z6 = z58;
                    z5 = z55;
                }
            }
            z43 = false;
            if ((j & 4294967296L) != 0) {
            }
            z44 = false;
            if ((j & 17179869184L) != 0) {
            }
            z45 = false;
            if ((j & 1073741824) == 0) {
            }
            z46 = false;
            if ((j & PlaybackStateCompat.ACTION_SET_REPEAT_MODE) != 0) {
            }
            z47 = false;
            if ((j & 68719476736L) == 0) {
            }
            z48 = false;
            if ((j & 16777216) != 0) {
            }
            z49 = false;
            if ((j & PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) == 0) {
            }
            z50 = false;
            if ((j & 1099511627776L) != 0) {
            }
            z51 = false;
            if ((j & 17592186044416L) == 0) {
            }
            z52 = false;
            if ((j & 268435456) != 0) {
            }
            z53 = false;
            if ((j & PlaybackStateCompat.ACTION_PREPARE) == 0) {
            }
            z54 = false;
            if ((j & 4194304) != 0) {
            }
            z56 = false;
            if ((j & 274877906944L) == 0) {
            }
            z57 = false;
            if ((j & PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) != 0) {
            }
            z58 = false;
            if ((j & 67108864) == 0) {
            }
            z6 = z58;
            z5 = z55;
        } else {
            z4 = false;
            z5 = false;
            z6 = false;
            z7 = false;
            z8 = false;
            z9 = false;
            z10 = false;
            z11 = false;
            z12 = false;
            z13 = false;
            z14 = false;
            z15 = false;
            z16 = false;
            z17 = false;
            z18 = false;
            z19 = false;
        }
        int i4 = ((j & 8386) > 0L ? 1 : ((j & 8386) == 0L ? 0 : -1));
        if (i4 != 0) {
            if (z3) {
                z5 = z62;
            }
            if (z3) {
                z15 = z62;
            }
            if (z3) {
                z6 = z62;
            }
            if (z3) {
                z8 = z62;
            }
            if (z3) {
                z9 = z62;
            }
            if (z3) {
                z7 = z62;
            }
            if (z3) {
                z18 = z62;
            }
            if (z3) {
                z16 = z62;
            }
            f2 = f;
            z27 = z7;
            z23 = z18;
            boolean z63 = z8;
            z20 = z4;
            z22 = z63;
            boolean z64 = z15;
            str5 = str3;
            z24 = z64;
            boolean z65 = z16;
            z21 = z;
            z25 = z65;
            boolean z66 = z9;
            str6 = str4;
            z26 = z66;
        } else {
            z20 = z4;
            f2 = f;
            str5 = str3;
            z21 = z;
            str6 = str4;
            z22 = false;
            z5 = false;
            z6 = false;
            z23 = false;
            z24 = false;
            z25 = false;
            z26 = false;
            z27 = false;
        }
        int i5 = ((j & 8274) > 0L ? 1 : ((j & 8274) == 0L ? 0 : -1));
        if (i5 != 0) {
            if (z2) {
                z10 = true;
            }
            if (z2) {
                z17 = true;
            }
            if (z2) {
                z14 = true;
            }
            if (z2) {
                z20 = true;
            }
            if (z2) {
                z11 = true;
            }
            if (z2) {
                z12 = true;
            }
            if (z2) {
                z13 = true;
            }
            if (z2) {
                z19 = true;
            }
            str8 = str2;
            z30 = z24;
            z38 = z10;
            z37 = z17;
            z32 = z3;
            z40 = z20;
            str7 = str;
            z36 = z13;
            z33 = z26;
            z41 = z19;
            boolean z67 = z12;
            z28 = z22;
            z34 = z11;
            z31 = z25;
            z39 = z67;
            boolean z68 = z14;
            z29 = z5;
            z35 = z68;
        } else {
            z28 = z22;
            z29 = z5;
            str7 = str;
            str8 = str2;
            z30 = z24;
            z31 = z25;
            z32 = z3;
            z33 = z26;
            z34 = false;
            z35 = false;
            z36 = false;
            z37 = false;
            z38 = false;
            z39 = false;
            z40 = false;
            z41 = false;
        }
        if (i5 != 0) {
            z42 = z6;
            CompoundButtonBindingAdapter.setChecked(this.d0, z37);
            CompoundButtonBindingAdapter.setChecked(this.d1, z36);
            CompoundButtonBindingAdapter.setChecked(this.d2, z40);
            CompoundButtonBindingAdapter.setChecked(this.d3, z39);
            CompoundButtonBindingAdapter.setChecked(this.d4, z34);
            CompoundButtonBindingAdapter.setChecked(this.d5, z41);
            CompoundButtonBindingAdapter.setChecked(this.d6, z35);
            CompoundButtonBindingAdapter.setChecked(this.d7, z38);
        } else {
            z42 = z6;
        }
        if (i3 != 0) {
            InverseBindingListener inverseBindingListener = null;
            CompoundButtonBindingAdapter.setListeners(this.d0, onCheckedChangeListener, inverseBindingListener);
            CompoundButtonBindingAdapter.setListeners(this.d0tod7, onCheckedChangeListener, inverseBindingListener);
            CompoundButtonBindingAdapter.setListeners(this.d1, onCheckedChangeListener, inverseBindingListener);
            CompoundButtonBindingAdapter.setListeners(this.d10, onCheckedChangeListener, inverseBindingListener);
            CompoundButtonBindingAdapter.setListeners(this.d11, onCheckedChangeListener, inverseBindingListener);
            CompoundButtonBindingAdapter.setListeners(this.d12, onCheckedChangeListener, inverseBindingListener);
            CompoundButtonBindingAdapter.setListeners(this.d13, onCheckedChangeListener, inverseBindingListener);
            CompoundButtonBindingAdapter.setListeners(this.d14, onCheckedChangeListener, inverseBindingListener);
            CompoundButtonBindingAdapter.setListeners(this.d15, onCheckedChangeListener, inverseBindingListener);
            CompoundButtonBindingAdapter.setListeners(this.d2, onCheckedChangeListener, inverseBindingListener);
            CompoundButtonBindingAdapter.setListeners(this.d3, onCheckedChangeListener, inverseBindingListener);
            CompoundButtonBindingAdapter.setListeners(this.d4, onCheckedChangeListener, inverseBindingListener);
            CompoundButtonBindingAdapter.setListeners(this.d5, onCheckedChangeListener, inverseBindingListener);
            CompoundButtonBindingAdapter.setListeners(this.d6, onCheckedChangeListener, inverseBindingListener);
            CompoundButtonBindingAdapter.setListeners(this.d7, onCheckedChangeListener, inverseBindingListener);
            CompoundButtonBindingAdapter.setListeners(this.d8, onCheckedChangeListener, inverseBindingListener);
            CompoundButtonBindingAdapter.setListeners(this.d8tod15, onCheckedChangeListener, inverseBindingListener);
            CompoundButtonBindingAdapter.setListeners(this.d9, onCheckedChangeListener, inverseBindingListener);
        }
        if ((8210 & j) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.d0tod7, z2);
        }
        if (i4 != 0) {
            CompoundButtonBindingAdapter.setChecked(this.d10, z27);
            CompoundButtonBindingAdapter.setChecked(this.d11, z23);
            CompoundButtonBindingAdapter.setChecked(this.d12, z42);
            CompoundButtonBindingAdapter.setChecked(this.d13, z30);
            CompoundButtonBindingAdapter.setChecked(this.d14, z29);
            CompoundButtonBindingAdapter.setChecked(this.d15, z33);
            CompoundButtonBindingAdapter.setChecked(this.d8, z28);
            CompoundButtonBindingAdapter.setChecked(this.d9, z31);
        }
        if ((8322 & j) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.d8tod15, z32);
        }
        if ((j & 8226) != 0) {
            TextViewBindingAdapter.setText(this.laBasic, str7);
        }
        if ((j & 8450) != 0) {
            TextViewBindingAdapter.setText(this.laBasicTwo, str8);
        }
        if ((j & 10242) != 0) {
            if (getBuildSdkInt() >= 11) {
                this.laOrder.setAlpha(f2);
            }
            this.laOrder.setEnabled(z21);
        }
        if ((j & 9219) != 0) {
            TextViewBindingAdapter.setText(this.laPeakSpinner, str5);
        }
        if ((j & 12806) != 0) {
            TextViewBindingAdapter.setText(this.laWaveSpinner, str6);
        }
    }
}
