package com.rigol.scope.databinding;

import android.graphics.drawable.Drawable;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.CompoundButtonBindingAdapter;
import androidx.databinding.adapters.ImageViewBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.rigol.scope.R;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.AfgParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.UnitFormat;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.views.SwitchButton;
import com.rigol.scope.views.baseview.BaseEditText;

/* loaded from: classes2.dex */
public class AdapterAwgBindingImpl extends AdapterAwgBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;
    private final ImageView mboundView21;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.left_guideline, 22);
        sViewsWithIds.put(R.id.left_guideline2, 23);
        sViewsWithIds.put(R.id.sweep_out_text, 24);
        sViewsWithIds.put(R.id.source_type_text, 25);
    }

    public AdapterAwgBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 26, sIncludes, sViewsWithIds));
    }

    private AdapterAwgBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 6, (BaseEditText) objArr[12], (TextView) objArr[11], (TextView) objArr[9], (BaseEditText) objArr[10], (SwitchButton) objArr[1], (Guideline) objArr[22], (Guideline) objArr[23], (BaseEditText) objArr[20], (TextView) objArr[19], (BaseEditText) objArr[18], (TextView) objArr[17], (BaseEditText) objArr[16], (TextView) objArr[15], (BaseEditText) objArr[14], (TextView) objArr[13], (TextView) objArr[2], (TextView) objArr[25], (TextView) objArr[24], (TextView) objArr[4], (TextView) objArr[3], (TextView) objArr[6], (TextView) objArr[5], (TextView) objArr[8], (TextView) objArr[7]);
        this.mDirtyFlags = -1L;
        this.basicAmpEdit.setTag(null);
        this.basicAmpText.setTag(null);
        this.fraguencyText.setTag(null);
        this.labelEditText.setTag(null);
        this.labelSwitch.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[21];
        this.mboundView21 = imageView;
        imageView.setTag(null);
        this.phaseDepthEdit.setTag(null);
        this.phaseDepthText.setTag(null);
        this.phaseEditText.setTag(null);
        this.phaseText.setTag(null);
        this.rangeDepthEdit.setTag(null);
        this.rangeDepthText.setTag(null);
        this.rangeEditText.setTag(null);
        this.rangeText.setTag(null);
        this.sourceTypeSpinner.setTag(null);
        this.waveTypeSpinner.setTag(null);
        this.waveTypeText.setTag(null);
        this.waveTypefmSpinner.setTag(null);
        this.waveTypefmText.setTag(null);
        this.waveTypepmSpinner.setTag(null);
        this.waveTypepmText.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 16777216L;
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
            setParam((AfgParam) obj);
            return true;
        }
        return false;
    }

    @Override // com.rigol.scope.databinding.AdapterAwgBinding
    public void setParam(AfgParam afgParam) {
        updateRegistration(0, afgParam);
        this.mParam = afgParam;
        synchronized (this) {
            this.mDirtyFlags |= 1;
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
                            return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgAfgWaveModTypeParamAfgWaveModType((MappingObject) obj, i2);
                        }
                        return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgAfgWaveModAmShapeParamAfgWavePmShape((MappingObject) obj, i2);
                    }
                    return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgAfgWaveModAmShapeParamAfgWaveFmShape((MappingObject) obj, i2);
                }
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgAfgWaveModAmShapeParamAfgWaveAmShape((MappingObject) obj, i2);
            }
            return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgAfgModPicParamWaveModPic((MappingObject) obj, i2);
        }
        return onChangeParam((AfgParam) obj, i2);
    }

    private boolean onChangeParam(AfgParam afgParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i == 812) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        } else if (i == 1040) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
            }
            return true;
        } else if (i == 41) {
            synchronized (this) {
                this.mDirtyFlags |= 256;
            }
            return true;
        } else if (i == 39) {
            synchronized (this) {
                this.mDirtyFlags |= 512;
            }
            return true;
        } else if (i == 40) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 42) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
            }
            return true;
        } else if (i == 1042) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
            }
            return true;
        } else if (i == 1043) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            }
            return true;
        } else if (i == 1044) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE;
            }
            return true;
        } else if (i == 1041) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 1047) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
            }
            return true;
        } else if (i == 1046) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
            }
            return true;
        } else if (i == 1045) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgAfgModPicParamWaveModPic(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        } else if (i == 638) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgAfgWaveModAmShapeParamAfgWaveAmShape(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgAfgWaveModAmShapeParamAfgWaveFmShape(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgAfgWaveModAmShapeParamAfgWavePmShape(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 4194304;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgAfgWaveModTypeParamAfgWaveModType(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 8388608;
            }
            return true;
        } else {
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:151:0x02a5  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x02e8  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x02ed  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0305  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0341  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0353  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x036b  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0379  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x03ab  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x046c  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x0487  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x0499  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x04a5  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x04cb  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x04e0  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x04ea  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x050f  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x052f  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x053e A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:296:0x054d  */
    /* JADX WARN: Removed duplicated region for block: B:309:0x057e  */
    /* JADX WARN: Removed duplicated region for block: B:312:0x0591 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:317:0x05a0  */
    /* JADX WARN: Removed duplicated region for block: B:322:0x05b2  */
    /* JADX WARN: Removed duplicated region for block: B:325:0x062b  */
    /* JADX WARN: Removed duplicated region for block: B:328:0x0637  */
    /* JADX WARN: Removed duplicated region for block: B:331:0x0642  */
    /* JADX WARN: Removed duplicated region for block: B:334:0x0686  */
    /* JADX WARN: Removed duplicated region for block: B:337:0x0698  */
    /* JADX WARN: Removed duplicated region for block: B:340:0x06a5  */
    /* JADX WARN: Removed duplicated region for block: B:343:0x06b2  */
    /* JADX WARN: Removed duplicated region for block: B:348:0x06ce  */
    /* JADX WARN: Removed duplicated region for block: B:351:0x06db  */
    /* JADX WARN: Removed duplicated region for block: B:354:0x06ea  */
    /* JADX WARN: Removed duplicated region for block: B:357:0x06f7  */
    /* JADX WARN: Removed duplicated region for block: B:360:0x070b  */
    /* JADX WARN: Removed duplicated region for block: B:363:0x071a  */
    /* JADX WARN: Removed duplicated region for block: B:366:0x0727  */
    /* JADX WARN: Removed duplicated region for block: B:369:0x073b  */
    /* JADX WARN: Removed duplicated region for block: B:372:0x074a  */
    /* JADX WARN: Removed duplicated region for block: B:375:0x0759  */
    /* JADX WARN: Removed duplicated region for block: B:378:0x0768  */
    /* JADX WARN: Removed duplicated region for block: B:385:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01de  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void executeBindings() {
        long j;
        long j2;
        Drawable drawable;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        int i;
        int i2;
        int i3;
        boolean z;
        int i4;
        boolean z2;
        int i5;
        int i6;
        int i7;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        long j3;
        int i16;
        float f;
        boolean z11;
        int i17;
        String str11;
        int i18;
        int i19;
        int i20;
        Drawable drawable2;
        String str12;
        int i21;
        String str13;
        String str14;
        String str15;
        int i22;
        int i23;
        String str16;
        String str17;
        int i24;
        Drawable drawable3;
        String str18;
        long j4;
        String str19;
        String str20;
        int i25;
        boolean z12;
        boolean z13;
        int i26;
        String str21;
        int i27;
        int i28;
        String str22;
        String str23;
        String str24;
        String str25;
        long j5;
        long j6;
        long j7;
        long j8;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        AfgParam afgParam = this.mParam;
        String str26 = null;
        if ((33554431 & j) != 0) {
            int i29 = ((j & 16777409) > 0L ? 1 : ((j & 16777409) == 0L ? 0 : -1));
            if (i29 != 0) {
                i20 = afgParam != null ? afgParam.getWave_function() : 0;
                z = i20 == 2;
                if (i29 != 0) {
                    j = z ? j | 1073741824 : j | 536870912;
                }
            } else {
                i20 = 0;
                z = false;
            }
            if ((j & 17563651) != 0) {
                MappingObject mappingObject = ViewUtil.getMappingObject(R.array.msg_afg_mod_pic, afgParam != null ? afgParam.getWave_mod_pic() : 0);
                updateRegistration(1, mappingObject);
                Drawable pic = mappingObject != null ? mappingObject.getPic() : null;
                Drawable.ConstantState constantState = pic != null ? pic.getConstantState() : null;
                Drawable newDrawable = constantState != null ? constantState.newDrawable() : null;
                if (newDrawable != null) {
                    drawable2 = newDrawable.mutate();
                    if ((j & 17826309) == 0) {
                        i21 = afgParam != null ? afgParam.getAfg_wave_am_shape() : 0;
                        MappingObject mappingObject2 = ViewUtil.getMappingObject(R.array.msg_afg_wave_mod_am_shape, i21);
                        updateRegistration(2, mappingObject2);
                        str12 = mappingObject2 != null ? mappingObject2.getStr() : null;
                    } else {
                        str12 = null;
                        i21 = 0;
                    }
                    if ((j & 16793601) == 0) {
                        if (afgParam != null) {
                            str13 = str12;
                            j8 = afgParam.getWave_mod_fm_freq();
                        } else {
                            str13 = str12;
                            j8 = 0;
                        }
                        str14 = ViewUtil.subNumber(UnitFormat.newBuilder("0.##########", UnitFormat.SI.MICRO).convert(j8) + ServiceEnum.Unit.Unit_hz.value2, 6);
                    } else {
                        str13 = str12;
                        str14 = null;
                    }
                    if ((18875401 & j) == 0) {
                        int afg_wave_fm_shape = afgParam != null ? afgParam.getAfg_wave_fm_shape() : 0;
                        MappingObject mappingObject3 = ViewUtil.getMappingObject(R.array.msg_afg_wave_mod_am_shape, afg_wave_fm_shape);
                        updateRegistration(3, mappingObject3);
                        if (mappingObject3 != null) {
                            str15 = mappingObject3.getStr();
                            i22 = afg_wave_fm_shape;
                        } else {
                            i22 = afg_wave_fm_shape;
                            str15 = null;
                        }
                    } else {
                        str15 = null;
                        i22 = 0;
                    }
                    if ((j & 16809985) == 0) {
                        if (afgParam != null) {
                            i23 = i21;
                            j7 = afgParam.getWave_mod_am_depth();
                        } else {
                            i23 = i21;
                            j7 = 0;
                        }
                        str16 = ViewUtil.subNumber(UnitFormat.newBuilder().convert(j7) + ServiceEnum.Unit.Unit_percent.value2, 6);
                    } else {
                        i23 = i21;
                        str16 = null;
                    }
                    if ((j & 20973585) == 0) {
                        int afg_wave_pm_shape = afgParam != null ? afgParam.getAfg_wave_pm_shape() : 0;
                        MappingObject mappingObject4 = ViewUtil.getMappingObject(R.array.msg_afg_wave_mod_am_shape, afg_wave_pm_shape);
                        updateRegistration(4, mappingObject4);
                        if (mappingObject4 != null) {
                            str17 = mappingObject4.getStr();
                            i24 = afg_wave_pm_shape;
                        } else {
                            i24 = afg_wave_pm_shape;
                            str17 = null;
                        }
                    } else {
                        str17 = null;
                        i24 = 0;
                    }
                    if ((j & 16781313) == 0) {
                        drawable3 = drawable2;
                        str18 = ViewUtil.subNumber(UnitFormat.newBuilder("0.##########", UnitFormat.SI.MICRO).convert(afgParam != null ? afgParam.getWave_mod_am_freq() : 0L) + ServiceEnum.Unit.Unit_hz.value2, 6);
                    } else {
                        drawable3 = drawable2;
                        str18 = null;
                    }
                    j4 = 0;
                    if ((25169697 & j) == 0) {
                        int afg_wave_mod_type = afgParam != null ? afgParam.getAfg_wave_mod_type() : 0;
                        int i30 = ((j & 16779521) > 0L ? 1 : ((j & 16779521) == 0L ? 0 : -1));
                        if (i30 != 0) {
                            boolean z14 = afg_wave_mod_type == 2;
                            if (i30 != 0) {
                                j = z14 ? j | 268435456 : j | 134217728;
                            }
                            j6 = 0;
                            if ((j & 16777473) != 0) {
                                j |= z14 ? 281474976710656L : 140737488355328L;
                            }
                            if ((j & 16777473) != 0) {
                                i2 = z14 ? 0 : 8;
                                z13 = z14;
                            } else {
                                z13 = z14;
                                i2 = 0;
                            }
                        } else {
                            j6 = 0;
                            i2 = 0;
                            z13 = false;
                        }
                        if ((j & 16777985) != j6) {
                            boolean z15 = afg_wave_mod_type == 0;
                            if ((j & 16777473) != j6) {
                                j |= z15 ? 67108864L : 33554432L;
                            }
                            if ((j & 16777985) != j6) {
                                j = z15 ? j | 68719476736L : j | 34359738368L;
                            }
                            if ((j & 16777473) != j6) {
                                i26 = z15 ? 0 : 8;
                                z5 = z15;
                            } else {
                                z5 = z15;
                                i26 = 0;
                            }
                        } else {
                            z5 = false;
                            i26 = 0;
                        }
                        if ((j & 25166113) != j6) {
                            MappingObject mappingObject5 = ViewUtil.getMappingObject(R.array.msg_afg_wave_mod_type, afg_wave_mod_type);
                            str19 = str18;
                            updateRegistration(5, mappingObject5);
                            if (mappingObject5 != null) {
                                str20 = mappingObject5.getStr();
                                j4 = 0;
                                if ((j & 16778497) == 0) {
                                    z12 = afg_wave_mod_type == 1;
                                    if ((j & 16777473) != 0) {
                                        j |= z12 ? 17179869184L : 8589934592L;
                                    }
                                    if ((j & 16778497) != 0) {
                                        j = z12 ? j | 70368744177664L : j | 35184372088832L;
                                    }
                                    i25 = ((j & 16777473) == 0 || z12) ? 0 : 8;
                                } else {
                                    i25 = 0;
                                    z12 = false;
                                }
                            }
                        } else {
                            str19 = str18;
                        }
                        str20 = null;
                        j4 = 0;
                        if ((j & 16778497) == 0) {
                        }
                    } else {
                        str19 = str18;
                        str20 = null;
                        i25 = 0;
                        i2 = 0;
                        z12 = false;
                        z13 = false;
                        z5 = false;
                        i26 = 0;
                    }
                    if ((j & 16842753) == j4) {
                        if (afgParam != null) {
                            str21 = str20;
                            i28 = i20;
                            j5 = afgParam.getWave_mod_pm_freq();
                        } else {
                            str21 = str20;
                            i28 = i20;
                            j5 = 0;
                        }
                        i27 = i25;
                        str22 = ViewUtil.subNumber(UnitFormat.newBuilder("0.##########", UnitFormat.SI.MICRO).convert(j5) + ServiceEnum.Unit.Unit_hz.value2, 6);
                    } else {
                        str21 = str20;
                        i27 = i25;
                        i28 = i20;
                        str22 = null;
                    }
                    if ((16908289 & j) == 0) {
                        str23 = str22;
                        str24 = UnitFormat.newBuilder(UnitFormat.SI.MILLI).convert(afgParam != null ? afgParam.getWave_mod_pm_dev() : 0L, ServiceEnum.Unit.Unit_degree);
                    } else {
                        str23 = str22;
                        str24 = null;
                    }
                    if ((16785409 & j) == 0) {
                        str25 = str24;
                        str26 = ViewUtil.subNumber(UnitFormat.newBuilder("0.##########", UnitFormat.SI.MICRO).convert(afgParam != null ? afgParam.getWave_mod_fm_deviation() : 0L) + ServiceEnum.Unit.Unit_hz.value2, 6);
                    } else {
                        str25 = str24;
                    }
                    j2 = 0;
                    if ((16777281 & j) != 0 || afgParam == null) {
                        str10 = str17;
                        str6 = str14;
                        str9 = str15;
                        str8 = str13;
                        str3 = str26;
                        z2 = false;
                        z4 = z13;
                        drawable = drawable3;
                        str4 = str19;
                        i3 = i28;
                        str7 = str21;
                        i = i27;
                        str5 = str16;
                        i5 = i24;
                        i7 = i22;
                        i4 = i26;
                        str2 = str23;
                    } else {
                        str10 = str17;
                        str6 = str14;
                        str9 = str15;
                        str8 = str13;
                        str3 = str26;
                        z4 = z13;
                        str4 = str19;
                        i3 = i28;
                        str7 = str21;
                        i = i27;
                        z2 = afgParam.getService_output_enable();
                        i5 = i24;
                        i7 = i22;
                        drawable = drawable3;
                        i4 = i26;
                        str2 = str23;
                        str5 = str16;
                    }
                    str = str25;
                    int i31 = i23;
                    z3 = z12;
                    i6 = i31;
                }
            }
            drawable2 = null;
            if ((j & 17826309) == 0) {
            }
            if ((j & 16793601) == 0) {
            }
            if ((18875401 & j) == 0) {
            }
            if ((j & 16809985) == 0) {
            }
            if ((j & 20973585) == 0) {
            }
            if ((j & 16781313) == 0) {
            }
            j4 = 0;
            if ((25169697 & j) == 0) {
            }
            if ((j & 16842753) == j4) {
            }
            if ((16908289 & j) == 0) {
            }
            if ((16785409 & j) == 0) {
            }
            j2 = 0;
            if ((16777281 & j) != 0) {
            }
            str10 = str17;
            str6 = str14;
            str9 = str15;
            str8 = str13;
            str3 = str26;
            z2 = false;
            z4 = z13;
            drawable = drawable3;
            str4 = str19;
            i3 = i28;
            str7 = str21;
            i = i27;
            str5 = str16;
            i5 = i24;
            i7 = i22;
            i4 = i26;
            str2 = str23;
            str = str25;
            int i312 = i23;
            z3 = z12;
            i6 = i312;
        } else {
            j2 = 0;
            drawable = null;
            str = null;
            str2 = null;
            str3 = null;
            str4 = null;
            str5 = null;
            str6 = null;
            str7 = null;
            str8 = null;
            str9 = null;
            str10 = null;
            i = 0;
            i2 = 0;
            i3 = 0;
            z = false;
            i4 = 0;
            z2 = false;
            i5 = 0;
            i6 = 0;
            i7 = 0;
            z3 = false;
            z4 = false;
            z5 = false;
        }
        boolean z16 = (j & 536870912) != j2 && i3 == 1;
        if ((j & 68719476736L) != 0) {
            if (afgParam != null) {
                i19 = afgParam.getAfg_wave_am_shape();
                z6 = z16;
            } else {
                z6 = z16;
                i19 = i6;
            }
            if (i19 != 5) {
                z7 = true;
                if ((70368744177664L & j) != 0) {
                    if ((afgParam != null ? afgParam.getAfg_wave_fm_shape() : i7) != 5) {
                        z8 = true;
                        if ((j & 268435456) != 0) {
                            if (afgParam != null) {
                                i18 = afgParam.getAfg_wave_pm_shape();
                                z9 = z8;
                            } else {
                                z9 = z8;
                                i18 = i5;
                            }
                            if (i18 != 5) {
                                z10 = true;
                                i8 = ((j & 16779521) > 0L ? 1 : ((j & 16779521) == 0L ? 0 : -1));
                                if (i8 != 0) {
                                    if (!z4) {
                                        z10 = false;
                                    }
                                    if (i8 != 0) {
                                        j |= z10 ? 4398046511104L : 2199023255552L;
                                    }
                                    if (!z10) {
                                        i9 = 8;
                                        i10 = ((j & 16777409) > 0L ? 1 : ((j & 16777409) == 0L ? 0 : -1));
                                        if (i10 != 0) {
                                            if (z) {
                                                z6 = true;
                                            }
                                            if (i10 != 0) {
                                                j |= z6 ? 1099511627776L : 549755813888L;
                                            }
                                        } else {
                                            z6 = false;
                                        }
                                        i11 = ((j & 16777985) > 0L ? 1 : ((j & 16777985) == 0L ? 0 : -1));
                                        if (i11 != 0) {
                                            if (!z5) {
                                                z7 = false;
                                            }
                                            if (i11 != 0) {
                                                j |= z7 ? 274877906944L : 137438953472L;
                                            }
                                            if (!z7) {
                                                i12 = 8;
                                                i13 = ((j & 16778497) > 0L ? 1 : ((j & 16778497) == 0L ? 0 : -1));
                                                if (i13 == 0) {
                                                    if (!z3) {
                                                        z9 = false;
                                                    }
                                                    if (i13 != 0) {
                                                        j |= z9 ? 17592186044416L : 8796093022208L;
                                                    }
                                                    i14 = z9 ? 0 : 8;
                                                } else {
                                                    i14 = 0;
                                                }
                                                boolean z17 = (j & 549755813888L) == 0 && i3 == 0;
                                                i15 = ((j & 16777409) > 0L ? 1 : ((j & 16777409) == 0L ? 0 : -1));
                                                float f2 = 0.0f;
                                                if (i15 == 0) {
                                                    boolean z18 = z6 ? true : z17;
                                                    if (i15 != 0) {
                                                        j |= z18 ? 4294967296L : 2147483648L;
                                                    }
                                                    j3 = 0;
                                                    if ((j & 16777345) != 0) {
                                                        f = ContextUtil.getAlpha(z18);
                                                        i16 = i14;
                                                    } else {
                                                        i16 = i14;
                                                        f = 0.0f;
                                                    }
                                                    z11 = z18;
                                                } else {
                                                    j3 = 0;
                                                    i16 = i14;
                                                    f = 0.0f;
                                                    z11 = false;
                                                }
                                                boolean service_output_enable = ((j & 4294967296L) != j3 || afgParam == null) ? z2 : afgParam.getService_output_enable();
                                                i17 = ((j & 16777409) > j3 ? 1 : ((j & 16777409) == j3 ? 0 : -1));
                                                if (i17 != 0) {
                                                    r35 = z11 ? service_output_enable : false;
                                                    f2 = ContextUtil.getAlpha(r35);
                                                }
                                                int i32 = i9;
                                                float f3 = f2;
                                                String str27 = str2;
                                                boolean z19 = r35;
                                                if (i17 == 0) {
                                                    str11 = str;
                                                    this.basicAmpEdit.setEnabled(z19);
                                                    this.labelEditText.setEnabled(z19);
                                                    this.mboundView21.setEnabled(z19);
                                                    this.phaseDepthEdit.setEnabled(z19);
                                                    this.phaseEditText.setEnabled(z19);
                                                    this.rangeDepthEdit.setEnabled(z19);
                                                    this.rangeEditText.setEnabled(z19);
                                                    this.sourceTypeSpinner.setEnabled(z19);
                                                    this.waveTypeSpinner.setEnabled(z19);
                                                    this.waveTypefmSpinner.setEnabled(z19);
                                                    this.waveTypepmSpinner.setEnabled(z19);
                                                    if (getBuildSdkInt() >= 11) {
                                                        this.basicAmpEdit.setAlpha(f3);
                                                        this.labelEditText.setAlpha(f3);
                                                        this.mboundView21.setAlpha(f3);
                                                        this.phaseDepthEdit.setAlpha(f3);
                                                        this.phaseEditText.setAlpha(f3);
                                                        this.rangeDepthEdit.setAlpha(f3);
                                                        this.rangeEditText.setAlpha(f3);
                                                        this.sourceTypeSpinner.setAlpha(f3);
                                                        this.waveTypeSpinner.setAlpha(f3);
                                                        this.waveTypefmSpinner.setAlpha(f3);
                                                        this.waveTypepmSpinner.setAlpha(f3);
                                                    }
                                                } else {
                                                    str11 = str;
                                                }
                                                if ((16785409 & j) != 0) {
                                                    TextViewBindingAdapter.setText(this.basicAmpEdit, str3);
                                                }
                                                if ((j & 16777473) != 0) {
                                                    this.basicAmpEdit.setVisibility(i);
                                                    this.basicAmpText.setVisibility(i);
                                                    this.phaseDepthEdit.setVisibility(i2);
                                                    this.phaseDepthText.setVisibility(i2);
                                                    this.rangeDepthEdit.setVisibility(i4);
                                                    this.rangeDepthText.setVisibility(i4);
                                                    this.waveTypeSpinner.setVisibility(i4);
                                                    this.waveTypeText.setVisibility(i4);
                                                    this.waveTypefmSpinner.setVisibility(i);
                                                    this.waveTypefmText.setVisibility(i);
                                                    this.waveTypepmSpinner.setVisibility(i2);
                                                    this.waveTypepmText.setVisibility(i2);
                                                }
                                                if ((j & 16777985) != 0) {
                                                    this.fraguencyText.setVisibility(i12);
                                                    this.labelEditText.setVisibility(i12);
                                                }
                                                if ((16781313 & j) != 0) {
                                                    TextViewBindingAdapter.setText(this.labelEditText, str4);
                                                }
                                                if ((16777281 & j) != 0) {
                                                    CompoundButtonBindingAdapter.setChecked(this.labelSwitch, service_output_enable);
                                                }
                                                if ((16777345 & j) != 0) {
                                                    this.labelSwitch.setEnabled(z11);
                                                    if (getBuildSdkInt() >= 11) {
                                                        this.labelSwitch.setAlpha(f);
                                                    }
                                                }
                                                if ((17563651 & j) != 0) {
                                                    ImageViewBindingAdapter.setImageDrawable(this.mboundView21, drawable);
                                                }
                                                if ((16908289 & j) != 0) {
                                                    TextViewBindingAdapter.setText(this.phaseDepthEdit, str11);
                                                }
                                                if ((16842753 & j) != 0) {
                                                    TextViewBindingAdapter.setText(this.phaseEditText, str27);
                                                }
                                                if ((j & 16779521) != 0) {
                                                    this.phaseEditText.setVisibility(i32);
                                                    this.phaseText.setVisibility(i32);
                                                }
                                                if ((16809985 & j) != 0) {
                                                    TextViewBindingAdapter.setText(this.rangeDepthEdit, str5);
                                                }
                                                if ((16793601 & j) != 0) {
                                                    TextViewBindingAdapter.setText(this.rangeEditText, str6);
                                                }
                                                if ((j & 16778497) != 0) {
                                                    int i33 = i16;
                                                    this.rangeEditText.setVisibility(i33);
                                                    this.rangeText.setVisibility(i33);
                                                }
                                                if ((25166113 & j) != 0) {
                                                    TextViewBindingAdapter.setText(this.sourceTypeSpinner, str7);
                                                }
                                                if ((17826309 & j) != 0) {
                                                    TextViewBindingAdapter.setText(this.waveTypeSpinner, str8);
                                                }
                                                if ((18875401 & j) != 0) {
                                                    TextViewBindingAdapter.setText(this.waveTypefmSpinner, str9);
                                                }
                                                if ((j & 20973585) == 0) {
                                                    TextViewBindingAdapter.setText(this.waveTypepmSpinner, str10);
                                                    return;
                                                }
                                                return;
                                            }
                                        }
                                        i12 = 0;
                                        i13 = ((j & 16778497) > 0L ? 1 : ((j & 16778497) == 0L ? 0 : -1));
                                        if (i13 == 0) {
                                        }
                                        if ((j & 549755813888L) == 0) {
                                        }
                                        i15 = ((j & 16777409) > 0L ? 1 : ((j & 16777409) == 0L ? 0 : -1));
                                        float f22 = 0.0f;
                                        if (i15 == 0) {
                                        }
                                        if ((j & 4294967296L) != j3) {
                                        }
                                        i17 = ((j & 16777409) > j3 ? 1 : ((j & 16777409) == j3 ? 0 : -1));
                                        if (i17 != 0) {
                                        }
                                        int i322 = i9;
                                        float f32 = f22;
                                        String str272 = str2;
                                        boolean z192 = r35;
                                        if (i17 == 0) {
                                        }
                                        if ((16785409 & j) != 0) {
                                        }
                                        if ((j & 16777473) != 0) {
                                        }
                                        if ((j & 16777985) != 0) {
                                        }
                                        if ((16781313 & j) != 0) {
                                        }
                                        if ((16777281 & j) != 0) {
                                        }
                                        if ((16777345 & j) != 0) {
                                        }
                                        if ((17563651 & j) != 0) {
                                        }
                                        if ((16908289 & j) != 0) {
                                        }
                                        if ((16842753 & j) != 0) {
                                        }
                                        if ((j & 16779521) != 0) {
                                        }
                                        if ((16809985 & j) != 0) {
                                        }
                                        if ((16793601 & j) != 0) {
                                        }
                                        if ((j & 16778497) != 0) {
                                        }
                                        if ((25166113 & j) != 0) {
                                        }
                                        if ((17826309 & j) != 0) {
                                        }
                                        if ((18875401 & j) != 0) {
                                        }
                                        if ((j & 20973585) == 0) {
                                        }
                                    }
                                }
                                i9 = 0;
                                i10 = ((j & 16777409) > 0L ? 1 : ((j & 16777409) == 0L ? 0 : -1));
                                if (i10 != 0) {
                                }
                                i11 = ((j & 16777985) > 0L ? 1 : ((j & 16777985) == 0L ? 0 : -1));
                                if (i11 != 0) {
                                }
                                i12 = 0;
                                i13 = ((j & 16778497) > 0L ? 1 : ((j & 16778497) == 0L ? 0 : -1));
                                if (i13 == 0) {
                                }
                                if ((j & 549755813888L) == 0) {
                                }
                                i15 = ((j & 16777409) > 0L ? 1 : ((j & 16777409) == 0L ? 0 : -1));
                                float f222 = 0.0f;
                                if (i15 == 0) {
                                }
                                if ((j & 4294967296L) != j3) {
                                }
                                i17 = ((j & 16777409) > j3 ? 1 : ((j & 16777409) == j3 ? 0 : -1));
                                if (i17 != 0) {
                                }
                                int i3222 = i9;
                                float f322 = f222;
                                String str2722 = str2;
                                boolean z1922 = r35;
                                if (i17 == 0) {
                                }
                                if ((16785409 & j) != 0) {
                                }
                                if ((j & 16777473) != 0) {
                                }
                                if ((j & 16777985) != 0) {
                                }
                                if ((16781313 & j) != 0) {
                                }
                                if ((16777281 & j) != 0) {
                                }
                                if ((16777345 & j) != 0) {
                                }
                                if ((17563651 & j) != 0) {
                                }
                                if ((16908289 & j) != 0) {
                                }
                                if ((16842753 & j) != 0) {
                                }
                                if ((j & 16779521) != 0) {
                                }
                                if ((16809985 & j) != 0) {
                                }
                                if ((16793601 & j) != 0) {
                                }
                                if ((j & 16778497) != 0) {
                                }
                                if ((25166113 & j) != 0) {
                                }
                                if ((17826309 & j) != 0) {
                                }
                                if ((18875401 & j) != 0) {
                                }
                                if ((j & 20973585) == 0) {
                                }
                            }
                        } else {
                            z9 = z8;
                        }
                        z10 = false;
                        i8 = ((j & 16779521) > 0L ? 1 : ((j & 16779521) == 0L ? 0 : -1));
                        if (i8 != 0) {
                        }
                        i9 = 0;
                        i10 = ((j & 16777409) > 0L ? 1 : ((j & 16777409) == 0L ? 0 : -1));
                        if (i10 != 0) {
                        }
                        i11 = ((j & 16777985) > 0L ? 1 : ((j & 16777985) == 0L ? 0 : -1));
                        if (i11 != 0) {
                        }
                        i12 = 0;
                        i13 = ((j & 16778497) > 0L ? 1 : ((j & 16778497) == 0L ? 0 : -1));
                        if (i13 == 0) {
                        }
                        if ((j & 549755813888L) == 0) {
                        }
                        i15 = ((j & 16777409) > 0L ? 1 : ((j & 16777409) == 0L ? 0 : -1));
                        float f2222 = 0.0f;
                        if (i15 == 0) {
                        }
                        if ((j & 4294967296L) != j3) {
                        }
                        i17 = ((j & 16777409) > j3 ? 1 : ((j & 16777409) == j3 ? 0 : -1));
                        if (i17 != 0) {
                        }
                        int i32222 = i9;
                        float f3222 = f2222;
                        String str27222 = str2;
                        boolean z19222 = r35;
                        if (i17 == 0) {
                        }
                        if ((16785409 & j) != 0) {
                        }
                        if ((j & 16777473) != 0) {
                        }
                        if ((j & 16777985) != 0) {
                        }
                        if ((16781313 & j) != 0) {
                        }
                        if ((16777281 & j) != 0) {
                        }
                        if ((16777345 & j) != 0) {
                        }
                        if ((17563651 & j) != 0) {
                        }
                        if ((16908289 & j) != 0) {
                        }
                        if ((16842753 & j) != 0) {
                        }
                        if ((j & 16779521) != 0) {
                        }
                        if ((16809985 & j) != 0) {
                        }
                        if ((16793601 & j) != 0) {
                        }
                        if ((j & 16778497) != 0) {
                        }
                        if ((25166113 & j) != 0) {
                        }
                        if ((17826309 & j) != 0) {
                        }
                        if ((18875401 & j) != 0) {
                        }
                        if ((j & 20973585) == 0) {
                        }
                    }
                }
                z8 = false;
                if ((j & 268435456) != 0) {
                }
                z10 = false;
                i8 = ((j & 16779521) > 0L ? 1 : ((j & 16779521) == 0L ? 0 : -1));
                if (i8 != 0) {
                }
                i9 = 0;
                i10 = ((j & 16777409) > 0L ? 1 : ((j & 16777409) == 0L ? 0 : -1));
                if (i10 != 0) {
                }
                i11 = ((j & 16777985) > 0L ? 1 : ((j & 16777985) == 0L ? 0 : -1));
                if (i11 != 0) {
                }
                i12 = 0;
                i13 = ((j & 16778497) > 0L ? 1 : ((j & 16778497) == 0L ? 0 : -1));
                if (i13 == 0) {
                }
                if ((j & 549755813888L) == 0) {
                }
                i15 = ((j & 16777409) > 0L ? 1 : ((j & 16777409) == 0L ? 0 : -1));
                float f22222 = 0.0f;
                if (i15 == 0) {
                }
                if ((j & 4294967296L) != j3) {
                }
                i17 = ((j & 16777409) > j3 ? 1 : ((j & 16777409) == j3 ? 0 : -1));
                if (i17 != 0) {
                }
                int i322222 = i9;
                float f32222 = f22222;
                String str272222 = str2;
                boolean z192222 = r35;
                if (i17 == 0) {
                }
                if ((16785409 & j) != 0) {
                }
                if ((j & 16777473) != 0) {
                }
                if ((j & 16777985) != 0) {
                }
                if ((16781313 & j) != 0) {
                }
                if ((16777281 & j) != 0) {
                }
                if ((16777345 & j) != 0) {
                }
                if ((17563651 & j) != 0) {
                }
                if ((16908289 & j) != 0) {
                }
                if ((16842753 & j) != 0) {
                }
                if ((j & 16779521) != 0) {
                }
                if ((16809985 & j) != 0) {
                }
                if ((16793601 & j) != 0) {
                }
                if ((j & 16778497) != 0) {
                }
                if ((25166113 & j) != 0) {
                }
                if ((17826309 & j) != 0) {
                }
                if ((18875401 & j) != 0) {
                }
                if ((j & 20973585) == 0) {
                }
            }
        } else {
            z6 = z16;
        }
        z7 = false;
        if ((70368744177664L & j) != 0) {
        }
        z8 = false;
        if ((j & 268435456) != 0) {
        }
        z10 = false;
        i8 = ((j & 16779521) > 0L ? 1 : ((j & 16779521) == 0L ? 0 : -1));
        if (i8 != 0) {
        }
        i9 = 0;
        i10 = ((j & 16777409) > 0L ? 1 : ((j & 16777409) == 0L ? 0 : -1));
        if (i10 != 0) {
        }
        i11 = ((j & 16777985) > 0L ? 1 : ((j & 16777985) == 0L ? 0 : -1));
        if (i11 != 0) {
        }
        i12 = 0;
        i13 = ((j & 16778497) > 0L ? 1 : ((j & 16778497) == 0L ? 0 : -1));
        if (i13 == 0) {
        }
        if ((j & 549755813888L) == 0) {
        }
        i15 = ((j & 16777409) > 0L ? 1 : ((j & 16777409) == 0L ? 0 : -1));
        float f222222 = 0.0f;
        if (i15 == 0) {
        }
        if ((j & 4294967296L) != j3) {
        }
        i17 = ((j & 16777409) > j3 ? 1 : ((j & 16777409) == j3 ? 0 : -1));
        if (i17 != 0) {
        }
        int i3222222 = i9;
        float f322222 = f222222;
        String str2722222 = str2;
        boolean z1922222 = r35;
        if (i17 == 0) {
        }
        if ((16785409 & j) != 0) {
        }
        if ((j & 16777473) != 0) {
        }
        if ((j & 16777985) != 0) {
        }
        if ((16781313 & j) != 0) {
        }
        if ((16777281 & j) != 0) {
        }
        if ((16777345 & j) != 0) {
        }
        if ((17563651 & j) != 0) {
        }
        if ((16908289 & j) != 0) {
        }
        if ((16842753 & j) != 0) {
        }
        if ((j & 16779521) != 0) {
        }
        if ((16809985 & j) != 0) {
        }
        if ((16793601 & j) != 0) {
        }
        if ((j & 16778497) != 0) {
        }
        if ((25166113 & j) != 0) {
        }
        if ((17826309 & j) != 0) {
        }
        if ((18875401 & j) != 0) {
        }
        if ((j & 20973585) == 0) {
        }
    }
}
