package com.rigol.scope.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.CompoundButtonBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.rigol.scope.R;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.FftParam;
import com.rigol.scope.data.HorizontalParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.utilities.ColorUtil;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.UnitFormat;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.views.SwitchButton;
import java.util.List;

/* loaded from: classes2.dex */
public class AdapterRtsaBasesettingBindingImpl extends AdapterRtsaBasesettingBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.freq, 19);
        sViewsWithIds.put(R.id.freq_rectangle, 20);
        sViewsWithIds.put(R.id.fftCenter, 21);
        sViewsWithIds.put(R.id.fftStart, 22);
        sViewsWithIds.put(R.id.fftEnd, 23);
        sViewsWithIds.put(R.id.span, 24);
        sViewsWithIds.put(R.id.span_rectangle, 25);
        sViewsWithIds.put(R.id.fftSpan, 26);
        sViewsWithIds.put(R.id.bw, 27);
        sViewsWithIds.put(R.id.bw_rectangle, 28);
        sViewsWithIds.put(R.id.rbw, 29);
        sViewsWithIds.put(R.id.rbw_auto, 30);
        sViewsWithIds.put(R.id.window, 31);
        sViewsWithIds.put(R.id.ampt, 32);
        sViewsWithIds.put(R.id.ampt_rectangle, 33);
        sViewsWithIds.put(R.id.unit, 34);
        sViewsWithIds.put(R.id.source, 35);
        sViewsWithIds.put(R.id.persistTime, 36);
    }

    public AdapterRtsaBasesettingBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 37, sIncludes, sViewsWithIds));
    }

    private AdapterRtsaBasesettingBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 7, (TextView) objArr[32], (ImageView) objArr[33], (Button) objArr[16], (TextView) objArr[27], (ImageView) objArr[28], (TextView) objArr[21], (EditText) objArr[1], (TextView) objArr[23], (EditText) objArr[3], (TextView) objArr[26], (EditText) objArr[4], (TextView) objArr[22], (EditText) objArr[2], (TextView) objArr[19], (ImageView) objArr[20], (Button) objArr[6], (Button) objArr[5], (TextView) objArr[36], (TextView) objArr[18], (Button) objArr[17], (TextView) objArr[29], (TextView) objArr[30], (SwitchButton) objArr[8], (TextView) objArr[7], (TextView) objArr[10], (EditText) objArr[11], (TextView) objArr[13], (EditText) objArr[14], (TextView) objArr[35], (TextView) objArr[15], (TextView) objArr[24], (ImageView) objArr[25], (TextView) objArr[34], (TextView) objArr[12], (TextView) objArr[31], (TextView) objArr[9]);
        this.mDirtyFlags = -1L;
        this.autoTuneBtn.setTag(null);
        this.fftCenterEditText.setTag(null);
        this.fftEndEditText.setTag(null);
        this.fftSpanEditText.setTag(null);
        this.fftStartEditText.setTag(null);
        this.fullSpanBtn.setTag(null);
        this.lastSpanBtn.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.persistTimeSpinner.setTag(null);
        this.presetBtn.setTag(null);
        this.rbwAutoSwitch.setTag(null);
        this.rbwSpinner.setTag(null);
        this.refLevel.setTag(null);
        this.refLevelEditText.setTag(null);
        this.scale.setTag(null);
        this.scaleEditText.setTag(null);
        this.sourceSpinner.setTag(null);
        this.unitSpinner.setTag(null);
        this.windowSpinner.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
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
            setParam((FftParam) obj);
        } else if (379 != i) {
            return false;
        } else {
            setHoriParam((HorizontalParam) obj);
        }
        return true;
    }

    @Override // com.rigol.scope.databinding.AdapterRtsaBasesettingBinding
    public void setParam(FftParam fftParam) {
        updateRegistration(2, fftParam);
        this.mParam = fftParam;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(594);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterRtsaBasesettingBinding
    public void setHoriParam(HorizontalParam horizontalParam) {
        updateRegistration(6, horizontalParam);
        this.mHoriParam = horizontalParam;
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        notifyPropertyChanged(379);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgFftWindowParamWindowValue1((MappingObject) obj, i2);
            case 1:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgFftUnitParamUnitValue1((MappingObject) obj, i2);
            case 2:
                return onChangeParam((FftParam) obj, i2);
            case 3:
                return onChangeParamGetRBWListGetParamRbwValue1((MappingObject) obj, i2);
            case 4:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgFftSrcParamSrcValue1((MappingObject) obj, i2);
            case 5:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDisplayPersistimeParamPersistTimeValue1((MappingObject) obj, i2);
            case 6:
                return onChangeHoriParam((HorizontalParam) obj, i2);
            default:
                return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgFftWindowParamWindowValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgFftUnitParamUnitValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeParam(FftParam fftParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else if (i == 150) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
            }
            return true;
        } else if (i == 900) {
            synchronized (this) {
                this.mDirtyFlags |= 256;
            }
            return true;
        } else if (i == 273) {
            synchronized (this) {
                this.mDirtyFlags |= 512;
            }
            return true;
        } else if (i == 870) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 686) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
            }
            return true;
        } else if (i == 61) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
            }
            return true;
        } else if (i == 1075) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            }
            return true;
        } else if (i == 987) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE;
            }
            return true;
        } else if (i == 719) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 776) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
            }
            return true;
        } else if (i == 896) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
            }
            return true;
        } else if (i == 620) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeParamGetRBWListGetParamRbwValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgFftSrcParamSrcValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDisplayPersistimeParamPersistTimeValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeHoriParam(HorizontalParam horizontalParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        } else if (i == 760) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
            }
            return true;
        } else {
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0242 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0301  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0313  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x031d  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0334  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0344  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x034f  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x03aa  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x03b5  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x03c0  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x03cb  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x03d6  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x03e3  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x03ee  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x03f5  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0425  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0434  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x0443  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x0452  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x0461  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x046e  */
    /* JADX WARN: Removed duplicated region for block: B:228:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0193 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01d8 A[ADDED_TO_REGION] */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void executeBindings() {
        long j;
        long j2;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        ServiceEnum.Unit unit;
        String str10;
        String str11;
        int i;
        boolean z;
        int i2;
        long j3;
        float f;
        boolean z2;
        String str12;
        String str13;
        ServiceEnum.Unit unit2;
        boolean z3;
        int i3;
        boolean z4;
        int i4;
        float f2;
        boolean z5;
        String str14;
        String str15;
        String str16;
        String str17;
        String str18;
        String str19;
        String str20;
        ServiceEnum.Unit unit3;
        String str21;
        long j4;
        boolean z6;
        String str22;
        String str23;
        String str24;
        int i5;
        int i6;
        List<MappingObject> list;
        ServiceEnum.RtsaRBW rtsaRBW;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        FftParam fftParam = this.mParam;
        HorizontalParam horizontalParam = this.mHoriParam;
        if ((1572799 & j) != 0) {
            if ((j & 1049604) != 0) {
                str14 = ViewUtil.subNumber(UnitFormat.newBuilder("0.##########", UnitFormat.SI.MICRO).convert(fftParam != null ? fftParam.getSpan() : 0L) + ServiceEnum.Unit.Unit_hz.value2, 6);
            } else {
                str14 = null;
            }
            if ((j & 1050636) != 0) {
                if (fftParam != null) {
                    list = fftParam.getRBWList();
                    rtsaRBW = fftParam.getRbw();
                } else {
                    list = null;
                    rtsaRBW = null;
                }
                MappingObject mappingObject = list != null ? list.get(rtsaRBW != null ? rtsaRBW.value1 : 0) : null;
                updateRegistration(3, mappingObject);
                if (mappingObject != null) {
                    str15 = mappingObject.getStr();
                    if ((j & 1056773) != 0) {
                        ServiceEnum.fftWindow window = fftParam != null ? fftParam.getWindow() : null;
                        MappingObject mappingObject2 = ViewUtil.getMappingObject(R.array.msg_fft_window, window != null ? window.value1 : 0);
                        updateRegistration(0, mappingObject2);
                        if (mappingObject2 != null) {
                            str16 = mappingObject2.getStr();
                            if ((j & 1049092) != 0) {
                                str17 = ViewUtil.subNumber(UnitFormat.newBuilder("0.##########", UnitFormat.SI.MICRO).convert(fftParam != null ? fftParam.getEnd() : 0L) + ServiceEnum.Unit.Unit_hz.value2, 6);
                            } else {
                                str17 = null;
                            }
                            if ((j & 1048836) != 0) {
                                str18 = ViewUtil.subNumber(UnitFormat.newBuilder("0.##########", UnitFormat.SI.MICRO).convert(fftParam != null ? fftParam.getStart() : 0L) + ServiceEnum.Unit.Unit_hz.value2, 6);
                            } else {
                                str18 = null;
                            }
                            if ((j & 1048708) != 0) {
                                str19 = ViewUtil.subNumber(UnitFormat.newBuilder("0.##########", UnitFormat.SI.MICRO).convert(fftParam != null ? fftParam.getCenter() : 0L) + ServiceEnum.Unit.Unit_hz.value2, 6);
                            } else {
                                str19 = null;
                            }
                            if ((j & 1310756) != 0) {
                                ServiceEnum.EWavePersis persistTime = fftParam != null ? fftParam.getPersistTime() : null;
                                MappingObject mappingObject3 = ViewUtil.getMappingObject(R.array.msg_display_persistime, persistTime != null ? persistTime.value1 : 0);
                                updateRegistration(5, mappingObject3);
                                if (mappingObject3 != null) {
                                    str20 = mappingObject3.getStr();
                                    String refLevelStr = ((j & 1081348) != 0 || fftParam == null) ? null : fftParam.getRefLevelStr();
                                    if ((j & 1064966) == 0) {
                                        unit3 = fftParam != null ? fftParam.getUnit() : null;
                                        MappingObject mappingObject4 = ViewUtil.getMappingObject(R.array.msg_fft_unit, unit3 != null ? unit3.value1 : 0);
                                        updateRegistration(1, mappingObject4);
                                        str21 = mappingObject4 != null ? mappingObject4.getStr() : null;
                                    } else {
                                        unit3 = null;
                                        str21 = null;
                                    }
                                    if ((j & 1052676) != 0 || fftParam == null) {
                                        j4 = 1179668;
                                        z6 = false;
                                    } else {
                                        z6 = fftParam.isAutoRbw();
                                        j4 = 1179668;
                                    }
                                    if ((j & j4) == 0) {
                                        ServiceEnum.Chan src = fftParam != null ? fftParam.getSrc() : null;
                                        str22 = str19;
                                        if (src != null) {
                                            i6 = src.value1;
                                            str23 = str20;
                                        } else {
                                            str23 = str20;
                                            i6 = 0;
                                        }
                                        MappingObject mappingObject5 = ViewUtil.getMappingObject(R.array.msg_fft_src, i6);
                                        updateRegistration(4, mappingObject5);
                                        str24 = mappingObject5 != null ? mappingObject5.getStr() : null;
                                        j2 = 0;
                                        if ((j & 1179652) != 0) {
                                            i5 = ColorUtil.getColor(getRoot().getContext(), src);
                                            if ((j & 1114116) != j2 || fftParam == null) {
                                                z = z6;
                                                unit = unit3;
                                                str8 = str15;
                                                str6 = str18;
                                                str4 = str14;
                                                str3 = str23;
                                                str11 = str21;
                                                str9 = null;
                                                int i7 = i5;
                                                str2 = str24;
                                                str = str22;
                                                str10 = str16;
                                                str7 = refLevelStr;
                                                str5 = str17;
                                                i = i7;
                                            } else {
                                                int i8 = i5;
                                                str2 = str24;
                                                str = str22;
                                                str10 = str16;
                                                str7 = refLevelStr;
                                                str5 = str17;
                                                i = i8;
                                                String str25 = str18;
                                                str4 = str14;
                                                str3 = str23;
                                                str11 = str21;
                                                str9 = fftParam.getScaleStr();
                                                z = z6;
                                                unit = unit3;
                                                str8 = str15;
                                                str6 = str25;
                                            }
                                        }
                                    } else {
                                        str22 = str19;
                                        str23 = str20;
                                        j2 = 0;
                                        str24 = null;
                                    }
                                    i5 = 0;
                                    if ((j & 1114116) != j2) {
                                    }
                                    z = z6;
                                    unit = unit3;
                                    str8 = str15;
                                    str6 = str18;
                                    str4 = str14;
                                    str3 = str23;
                                    str11 = str21;
                                    str9 = null;
                                    int i72 = i5;
                                    str2 = str24;
                                    str = str22;
                                    str10 = str16;
                                    str7 = refLevelStr;
                                    str5 = str17;
                                    i = i72;
                                }
                            }
                            str20 = null;
                            if ((j & 1081348) != 0) {
                            }
                            if ((j & 1064966) == 0) {
                            }
                            if ((j & 1052676) != 0) {
                            }
                            j4 = 1179668;
                            z6 = false;
                            if ((j & j4) == 0) {
                            }
                            i5 = 0;
                            if ((j & 1114116) != j2) {
                            }
                            z = z6;
                            unit = unit3;
                            str8 = str15;
                            str6 = str18;
                            str4 = str14;
                            str3 = str23;
                            str11 = str21;
                            str9 = null;
                            int i722 = i5;
                            str2 = str24;
                            str = str22;
                            str10 = str16;
                            str7 = refLevelStr;
                            str5 = str17;
                            i = i722;
                        }
                    }
                    str16 = null;
                    if ((j & 1049092) != 0) {
                    }
                    if ((j & 1048836) != 0) {
                    }
                    if ((j & 1048708) != 0) {
                    }
                    if ((j & 1310756) != 0) {
                    }
                    str20 = null;
                    if ((j & 1081348) != 0) {
                    }
                    if ((j & 1064966) == 0) {
                    }
                    if ((j & 1052676) != 0) {
                    }
                    j4 = 1179668;
                    z6 = false;
                    if ((j & j4) == 0) {
                    }
                    i5 = 0;
                    if ((j & 1114116) != j2) {
                    }
                    z = z6;
                    unit = unit3;
                    str8 = str15;
                    str6 = str18;
                    str4 = str14;
                    str3 = str23;
                    str11 = str21;
                    str9 = null;
                    int i7222 = i5;
                    str2 = str24;
                    str = str22;
                    str10 = str16;
                    str7 = refLevelStr;
                    str5 = str17;
                    i = i7222;
                }
            }
            str15 = null;
            if ((j & 1056773) != 0) {
            }
            str16 = null;
            if ((j & 1049092) != 0) {
            }
            if ((j & 1048836) != 0) {
            }
            if ((j & 1048708) != 0) {
            }
            if ((j & 1310756) != 0) {
            }
            str20 = null;
            if ((j & 1081348) != 0) {
            }
            if ((j & 1064966) == 0) {
            }
            if ((j & 1052676) != 0) {
            }
            j4 = 1179668;
            z6 = false;
            if ((j & j4) == 0) {
            }
            i5 = 0;
            if ((j & 1114116) != j2) {
            }
            z = z6;
            unit = unit3;
            str8 = str15;
            str6 = str18;
            str4 = str14;
            str3 = str23;
            str11 = str21;
            str9 = null;
            int i72222 = i5;
            str2 = str24;
            str = str22;
            str10 = str16;
            str7 = refLevelStr;
            str5 = str17;
            i = i72222;
        } else {
            j2 = 0;
            str = null;
            str2 = null;
            str3 = null;
            str4 = null;
            str5 = null;
            str6 = null;
            str7 = null;
            str8 = null;
            str9 = null;
            unit = null;
            str10 = null;
            str11 = null;
            i = 0;
            z = false;
        }
        int i9 = ((j & 1589316) > j2 ? 1 : ((j & 1589316) == j2 ? 0 : -1));
        if (i9 != 0) {
            i2 = i;
            z2 = (horizontalParam != null ? horizontalParam.getRunStop() : null) != ServiceEnum.ControlAction.Control_Stop;
            if (i9 != 0) {
                j = z2 ? j | 16777216 : j | 8388608;
            }
            j3 = 0;
            f = (j & 1572928) != 0 ? ContextUtil.getAlpha(z2) : 0.0f;
        } else {
            i2 = i;
            j3 = 0;
            f = 0.0f;
            z2 = false;
        }
        if ((j & 16777216) != j3) {
            if (fftParam != null) {
                unit = fftParam.getUnit();
            }
            str12 = str2;
            str13 = str9;
            unit2 = unit;
            if (unit2 != ServiceEnum.Unit.Unit_V) {
                z3 = true;
                i3 = ((j & 1589316) > 0L ? 1 : ((j & 1589316) == 0L ? 0 : -1));
                if (i3 == 0) {
                    if (!z2) {
                        z3 = false;
                    }
                    if (i3 != 0) {
                        j = z3 ? j | 4194304 : j | PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
                    }
                } else {
                    z3 = false;
                }
                if ((j & 4194304) != 0) {
                    if (fftParam != null) {
                        unit2 = fftParam.getUnit();
                    }
                    if (unit2 != ServiceEnum.Unit.Unit_W) {
                        z4 = true;
                        i4 = ((j & 1589316) > 0L ? 1 : ((j & 1589316) == 0L ? 0 : -1));
                        if (i4 != 0) {
                            boolean z7 = z3 ? z4 : false;
                            z5 = z7;
                            f2 = ContextUtil.getAlpha(z7);
                        } else {
                            f2 = 0.0f;
                            z5 = false;
                        }
                        String str26 = str7;
                        if ((j & 1572928) != 0) {
                            this.autoTuneBtn.setEnabled(z2);
                            this.fftCenterEditText.setEnabled(z2);
                            this.fftEndEditText.setEnabled(z2);
                            this.fftSpanEditText.setEnabled(z2);
                            this.fftStartEditText.setEnabled(z2);
                            this.fullSpanBtn.setEnabled(z2);
                            this.lastSpanBtn.setEnabled(z2);
                            this.persistTimeSpinner.setEnabled(z2);
                            this.presetBtn.setEnabled(z2);
                            this.rbwAutoSwitch.setEnabled(z2);
                            this.rbwSpinner.setEnabled(z2);
                            this.sourceSpinner.setEnabled(z2);
                            this.unitSpinner.setEnabled(z2);
                            this.windowSpinner.setEnabled(z2);
                            if (getBuildSdkInt() >= 11) {
                                this.mboundView0.setAlpha(f);
                            }
                        }
                        if ((j & 1048708) != 0) {
                            TextViewBindingAdapter.setText(this.fftCenterEditText, str);
                        }
                        if ((j & 1049092) != 0) {
                            TextViewBindingAdapter.setText(this.fftEndEditText, str5);
                        }
                        if ((j & 1049604) != 0) {
                            TextViewBindingAdapter.setText(this.fftSpanEditText, str4);
                        }
                        if ((j & 1048836) != 0) {
                            TextViewBindingAdapter.setText(this.fftStartEditText, str6);
                        }
                        if ((j & 1310756) != 0) {
                            TextViewBindingAdapter.setText(this.persistTimeSpinner, str3);
                        }
                        if ((1052676 & j) != 0) {
                            CompoundButtonBindingAdapter.setChecked(this.rbwAutoSwitch, z);
                        }
                        if ((j & 1050636) != 0) {
                            TextViewBindingAdapter.setText(this.rbwSpinner, str8);
                        }
                        if (i4 != 0) {
                            if (getBuildSdkInt() >= 11) {
                                this.refLevel.setAlpha(f2);
                                this.refLevelEditText.setAlpha(f2);
                                this.scale.setAlpha(f2);
                                this.scaleEditText.setAlpha(f2);
                            }
                            this.refLevelEditText.setEnabled(z5);
                            this.scaleEditText.setEnabled(z5);
                        }
                        if ((1081348 & j) != 0) {
                            TextViewBindingAdapter.setText(this.refLevelEditText, str26);
                        }
                        if ((1114116 & j) != 0) {
                            TextViewBindingAdapter.setText(this.scaleEditText, str13);
                        }
                        if ((1179668 & j) != 0) {
                            TextViewBindingAdapter.setText(this.sourceSpinner, str12);
                        }
                        if ((1179652 & j) != 0) {
                            this.sourceSpinner.setTextColor(i2);
                        }
                        if ((1064966 & j) != 0) {
                            TextViewBindingAdapter.setText(this.unitSpinner, str11);
                        }
                        if ((j & 1056773) != 0) {
                            TextViewBindingAdapter.setText(this.windowSpinner, str10);
                            return;
                        }
                        return;
                    }
                }
                z4 = false;
                i4 = ((j & 1589316) > 0L ? 1 : ((j & 1589316) == 0L ? 0 : -1));
                if (i4 != 0) {
                }
                String str262 = str7;
                if ((j & 1572928) != 0) {
                }
                if ((j & 1048708) != 0) {
                }
                if ((j & 1049092) != 0) {
                }
                if ((j & 1049604) != 0) {
                }
                if ((j & 1048836) != 0) {
                }
                if ((j & 1310756) != 0) {
                }
                if ((1052676 & j) != 0) {
                }
                if ((j & 1050636) != 0) {
                }
                if (i4 != 0) {
                }
                if ((1081348 & j) != 0) {
                }
                if ((1114116 & j) != 0) {
                }
                if ((1179668 & j) != 0) {
                }
                if ((1179652 & j) != 0) {
                }
                if ((1064966 & j) != 0) {
                }
                if ((j & 1056773) != 0) {
                }
            }
        } else {
            str12 = str2;
            str13 = str9;
            unit2 = unit;
        }
        z3 = false;
        i3 = ((j & 1589316) > 0L ? 1 : ((j & 1589316) == 0L ? 0 : -1));
        if (i3 == 0) {
        }
        if ((j & 4194304) != 0) {
        }
        z4 = false;
        i4 = ((j & 1589316) > 0L ? 1 : ((j & 1589316) == 0L ? 0 : -1));
        if (i4 != 0) {
        }
        String str2622 = str7;
        if ((j & 1572928) != 0) {
        }
        if ((j & 1048708) != 0) {
        }
        if ((j & 1049092) != 0) {
        }
        if ((j & 1049604) != 0) {
        }
        if ((j & 1048836) != 0) {
        }
        if ((j & 1310756) != 0) {
        }
        if ((1052676 & j) != 0) {
        }
        if ((j & 1050636) != 0) {
        }
        if (i4 != 0) {
        }
        if ((1081348 & j) != 0) {
        }
        if ((1114116 & j) != 0) {
        }
        if ((1179668 & j) != 0) {
        }
        if ((1179652 & j) != 0) {
        }
        if ((1064966 & j) != 0) {
        }
        if ((j & 1056773) != 0) {
        }
    }
}
