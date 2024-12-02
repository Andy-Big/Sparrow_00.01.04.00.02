package com.rigol.scope.databinding;

import android.graphics.drawable.Drawable;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.CompoundButtonBindingAdapter;
import androidx.databinding.adapters.ImageViewBindingAdapter;
import androidx.databinding.adapters.SeekBarBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.rigol.scope.R;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.TriggerParam;
import com.rigol.scope.utilities.ColorUtil;
import com.rigol.scope.utilities.UnitFormat;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.views.SwitchButton;
import com.rigol.scope.views.vertical.VerticalSeekBar;
import com.rigol.scope.views.vertical.VerticalSeekBarWrapper;

/* loaded from: classes2.dex */
public class AdapterTriggerVideoBindingImpl extends AdapterTriggerVideoBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.guideline_left, 15);
        sViewsWithIds.put(R.id.guideline_center, 16);
        sViewsWithIds.put(R.id.guideline_right, 17);
        sViewsWithIds.put(R.id.guideline_forth, 18);
        sViewsWithIds.put(R.id.view_top, 19);
        sViewsWithIds.put(R.id.view_1, 20);
        sViewsWithIds.put(R.id.view_2, 21);
        sViewsWithIds.put(R.id.view15, 22);
        sViewsWithIds.put(R.id.trigger_source_label, 23);
        sViewsWithIds.put(R.id.trigger_polarity_label, 24);
        sViewsWithIds.put(R.id.button_level, 25);
        sViewsWithIds.put(R.id.video_standard, 26);
        sViewsWithIds.put(R.id.trigger_video_sync, 27);
        sViewsWithIds.put(R.id.trigger_level, 28);
        sViewsWithIds.put(R.id.verticalSeekBarWrapper2, 29);
        sViewsWithIds.put(R.id.trigger_noise_label, 30);
    }

    public AdapterTriggerVideoBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 31, sIncludes, sViewsWithIds));
    }

    private AdapterTriggerVideoBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 12, (RadioButton) objArr[8], (Button) objArr[25], (RadioButton) objArr[11], (Guideline) objArr[16], (Guideline) objArr[18], (Guideline) objArr[15], (Guideline) objArr[17], (ImageView) objArr[6], (RadioButton) objArr[9], (TextView) objArr[13], (EditText) objArr[14], (RadioButton) objArr[10], (RadioButton) objArr[3], (RadioButton) objArr[2], (TextView) objArr[28], (EditText) objArr[5], (VerticalSeekBar) objArr[7], (TextView) objArr[30], (SwitchButton) objArr[12], (TextView) objArr[24], (TextView) objArr[1], (TextView) objArr[23], (TextView) objArr[27], (VerticalSeekBarWrapper) objArr[29], (TextView) objArr[26], (TextView) objArr[4], (View) objArr[20], (View) objArr[22], (View) objArr[21], (View) objArr[19]);
        this.mDirtyFlags = -1L;
        this.allLines.setTag(null);
        this.even.setTag(null);
        this.imageView2.setTag(null);
        this.lines.setTag(null);
        this.linesNumber.setTag(null);
        this.linesNumberValue.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.odd.setTag(null);
        this.polarityN.setTag(null);
        this.polarityP.setTag(null);
        this.triggerLevelValue.setTag(null);
        this.triggerLevelView.setTag(null);
        this.triggerNoiseSwitch.setTag(null);
        this.triggerSource.setTag(null);
        this.videoStandardValue.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 268435456L;
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
        if (643 == i) {
            setPolarityNegativeMapping((MappingObject) obj);
        } else if (594 == i) {
            setParam((TriggerParam) obj);
        } else if (916 == i) {
            setSweepAutoMapping((MappingObject) obj);
        } else if (918 == i) {
            setSweepSingleMapping((MappingObject) obj);
        } else if (917 == i) {
            setSweepNormalMapping((MappingObject) obj);
        } else if (644 != i) {
            return false;
        } else {
            setPolarityPositiveMapping((MappingObject) obj);
        }
        return true;
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerVideoBinding
    public void setPolarityNegativeMapping(MappingObject mappingObject) {
        updateRegistration(0, mappingObject);
        this.mPolarityNegativeMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(643);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerVideoBinding
    public void setParam(TriggerParam triggerParam) {
        updateRegistration(3, triggerParam);
        this.mParam = triggerParam;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(594);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerVideoBinding
    public void setSweepAutoMapping(MappingObject mappingObject) {
        this.mSweepAutoMapping = mappingObject;
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerVideoBinding
    public void setSweepSingleMapping(MappingObject mappingObject) {
        this.mSweepSingleMapping = mappingObject;
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerVideoBinding
    public void setSweepNormalMapping(MappingObject mappingObject) {
        this.mSweepNormalMapping = mappingObject;
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerVideoBinding
    public void setPolarityPositiveMapping(MappingObject mappingObject) {
        updateRegistration(9, mappingObject);
        this.mPolarityPositiveMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 512;
        }
        notifyPropertyChanged(644);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return onChangePolarityNegativeMapping((MappingObject) obj, i2);
            case 1:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerVideoStandardParamVideoFormatValue1((MappingObject) obj, i2);
            case 2:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerVideoSyncInt0((MappingObject) obj, i2);
            case 3:
                return onChangeParam((TriggerParam) obj, i2);
            case 4:
                return onChangeSweepAutoMapping((MappingObject) obj, i2);
            case 5:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerVideoSyncInt2((MappingObject) obj, i2);
            case 6:
                return onChangeSweepSingleMapping((MappingObject) obj, i2);
            case 7:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerVideoSyncInt3((MappingObject) obj, i2);
            case 8:
                return onChangeSweepNormalMapping((MappingObject) obj, i2);
            case 9:
                return onChangePolarityPositiveMapping((MappingObject) obj, i2);
            case 10:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerSourceLaParamChanValue1((MappingObject) obj, i2);
            case 11:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerVideoSyncInt1((MappingObject) obj, i2);
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
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerVideoStandardParamVideoFormatValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
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

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerVideoSyncInt0(MappingObject mappingObject, int i) {
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

    private boolean onChangeParam(TriggerParam triggerParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        } else if (i == 152) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 1030) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
            }
            return true;
        } else if (i == 1029) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
            }
            return true;
        } else if (i == 484) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
            }
            return true;
        } else if (i == 671) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
            }
            return true;
        } else if (i == 1031) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
            }
            return true;
        } else if (i == 448) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
            }
            return true;
        } else if (i == 503) {
            synchronized (this) {
                this.mDirtyFlags |= 4194304;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeSweepAutoMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerVideoSyncInt2(MappingObject mappingObject, int i) {
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

    private boolean onChangeSweepSingleMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerVideoSyncInt3(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 16777216;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeSweepNormalMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 256;
            }
            return true;
        }
        return false;
    }

    private boolean onChangePolarityPositiveMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 512;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 33554432;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerSourceLaParamChanValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 67108864;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerVideoSyncInt1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 134217728;
            }
            return true;
        } else {
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x02c0  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x02e6  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x02f1  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x02fc  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x030c  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0325  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0332  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x033f  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x034c  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0359  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0364  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0373  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0380  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x038d  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x039a  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x03a9  */
    /* JADX WARN: Removed duplicated region for block: B:222:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00a1 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x015a A[ADDED_TO_REGION] */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void executeBindings() {
        long j;
        boolean z;
        String str;
        boolean z2;
        ServiceEnum.Trigger_Video_Format trigger_Video_Format;
        Drawable drawable;
        boolean z3;
        boolean z4;
        boolean z5;
        int i;
        boolean z6;
        boolean z7;
        String str2;
        int i2;
        String str3;
        boolean z8;
        String str4;
        int i3;
        String str5;
        String str6;
        String str7;
        String str8;
        boolean z9;
        String str9;
        boolean z10;
        String str10;
        int i4;
        String str11;
        int i5;
        String str12;
        boolean z11;
        boolean z12;
        Drawable drawable2;
        int i6;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        int i7;
        boolean z17;
        boolean z18;
        String str13;
        int i8;
        String str14;
        long j2;
        int i9;
        int i10;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        MappingObject mappingObject = this.mPolarityNegativeMapping;
        TriggerParam triggerParam = this.mParam;
        MappingObject mappingObject2 = this.mPolarityPositiveMapping;
        String str15 = ((j & 268439553) == 0 || mappingObject == null) ? null : mappingObject.getStr();
        if ((343909386 & j) != 0) {
            if ((j & 335578120) != 0) {
                ServiceEnum.Chan chan = triggerParam != null ? triggerParam.getChan() : null;
                MappingObject mappingObject3 = ViewUtil.getMappingObject(R.array.msg_trigger_source_la, chan != null ? chan.value1 : 0);
                updateRegistration(10, mappingObject3);
                str11 = mappingObject3 != null ? mappingObject3.getStr() : null;
                if ((j & 268468232) != 0) {
                    i5 = ColorUtil.getColor(getRoot().getContext(), chan);
                    if ((j & 268697608) != 0) {
                        long level = triggerParam != null ? triggerParam.getLevel() : 0L;
                        if (triggerParam != null) {
                            str12 = triggerParam.getTriggerLevelStr(level);
                            boolean isNoise = ((j & 270532616) != 0 || triggerParam == null) ? false : triggerParam.getIsNoise();
                            if ((j & 268501000) != 0) {
                                ServiceEnum.TriggerPulsePolarity videoPolarity = triggerParam != null ? triggerParam.getVideoPolarity() : null;
                                boolean z19 = videoPolarity == ServiceEnum.TriggerPulsePolarity.Trigger_pulse_positive;
                                drawable2 = ViewUtil.getTriggerVideoPolarityPic(videoPolarity);
                                z12 = videoPolarity == ServiceEnum.TriggerPulsePolarity.Trigger_pulse_negative;
                                z11 = z19;
                            } else {
                                z11 = false;
                                z12 = false;
                                drawable2 = null;
                            }
                            i6 = ((j & 269484040) > 0L ? 1 : ((j & 269484040) == 0L ? 0 : -1));
                            if (i6 != 0) {
                                ServiceEnum.Trigger_Video_Sync videoSync = triggerParam != null ? triggerParam.getVideoSync() : null;
                                z16 = videoSync == ServiceEnum.Trigger_Video_Sync.trig_video_even;
                                boolean z20 = videoSync == ServiceEnum.Trigger_Video_Sync.trig_video_odd;
                                z13 = videoSync == ServiceEnum.Trigger_Video_Sync.trig_video_x_line;
                                boolean z21 = videoSync == ServiceEnum.Trigger_Video_Sync.trig_video_any_line;
                                if (i6 != 0) {
                                    j |= z13 ? 1073741824L : 536870912L;
                                }
                                z15 = z21;
                                z14 = z20;
                                i7 = z13 ? 0 : 8;
                            } else {
                                z13 = false;
                                z14 = false;
                                z15 = false;
                                z16 = false;
                                i7 = 0;
                            }
                            if ((j & 272629768) != 0) {
                                if (triggerParam != null) {
                                    i10 = triggerParam.getLinesNumber();
                                    z17 = z13;
                                } else {
                                    z17 = z13;
                                    i10 = 0;
                                }
                                z18 = z14;
                                str13 = str11;
                                i8 = i5;
                                str14 = UnitFormat.newBuilder(" 0.###  ", UnitFormat.SI.NONE).convert(i10, ServiceEnum.Unit.Unit_none);
                            } else {
                                z17 = z13;
                                z18 = z14;
                                str13 = str11;
                                i8 = i5;
                                str14 = null;
                            }
                            if ((j & 268959752) != 0 || triggerParam == null) {
                                j2 = 268574730;
                                i9 = 0;
                            } else {
                                i9 = triggerParam.getProgress();
                                j2 = 268574730;
                            }
                            if ((j & j2) != 0) {
                                ServiceEnum.Trigger_Video_Format videoFormat = triggerParam != null ? triggerParam.getVideoFormat() : null;
                                MappingObject mappingObject4 = ViewUtil.getMappingObject(R.array.msg_trigger_video_standard, videoFormat != null ? videoFormat.value1 : 0);
                                updateRegistration(1, mappingObject4);
                                String str16 = mappingObject4 != null ? mappingObject4.getStr() : null;
                                int i11 = ((j & 268566536) > 0L ? 1 : ((j & 268566536) == 0L ? 0 : -1));
                                if (i11 != 0) {
                                    boolean z22 = videoFormat == ServiceEnum.Trigger_Video_Format.Video_Stardard_NTSC;
                                    if (i11 != 0) {
                                        j = z22 ? j | 4294967296L : j | 2147483648L;
                                    }
                                    drawable = drawable2;
                                    i3 = i9;
                                    str2 = str16;
                                    trigger_Video_Format = videoFormat;
                                    z2 = z18;
                                    str4 = str12;
                                    z4 = z15;
                                    z7 = z11;
                                    i = i7;
                                    str3 = str13;
                                    str = str14;
                                    z = z17;
                                    z8 = isNoise;
                                    z5 = z22;
                                    z3 = z12;
                                    z6 = z16;
                                    i2 = i8;
                                } else {
                                    z3 = z12;
                                    drawable = drawable2;
                                    z6 = z16;
                                    i2 = i8;
                                    i3 = i9;
                                    str2 = str16;
                                    trigger_Video_Format = videoFormat;
                                    z2 = z18;
                                }
                            } else {
                                z3 = z12;
                                drawable = drawable2;
                                z6 = z16;
                                z2 = z18;
                                i2 = i8;
                                i3 = i9;
                                trigger_Video_Format = null;
                                str2 = null;
                            }
                            str4 = str12;
                            z4 = z15;
                            z7 = z11;
                            i = i7;
                            str3 = str13;
                            str = str14;
                            z = z17;
                            z8 = isNoise;
                            z5 = false;
                        }
                    }
                    str12 = null;
                    if ((j & 270532616) != 0) {
                    }
                    if ((j & 268501000) != 0) {
                    }
                    i6 = ((j & 269484040) > 0L ? 1 : ((j & 269484040) == 0L ? 0 : -1));
                    if (i6 != 0) {
                    }
                    if ((j & 272629768) != 0) {
                    }
                    if ((j & 268959752) != 0) {
                    }
                    j2 = 268574730;
                    i9 = 0;
                    if ((j & j2) != 0) {
                    }
                    str4 = str12;
                    z4 = z15;
                    z7 = z11;
                    i = i7;
                    str3 = str13;
                    str = str14;
                    z = z17;
                    z8 = isNoise;
                    z5 = false;
                }
            } else {
                str11 = null;
            }
            i5 = 0;
            if ((j & 268697608) != 0) {
            }
            str12 = null;
            if ((j & 270532616) != 0) {
            }
            if ((j & 268501000) != 0) {
            }
            i6 = ((j & 269484040) > 0L ? 1 : ((j & 269484040) == 0L ? 0 : -1));
            if (i6 != 0) {
            }
            if ((j & 272629768) != 0) {
            }
            if ((j & 268959752) != 0) {
            }
            j2 = 268574730;
            i9 = 0;
            if ((j & j2) != 0) {
            }
            str4 = str12;
            z4 = z15;
            z7 = z11;
            i = i7;
            str3 = str13;
            str = str14;
            z = z17;
            z8 = isNoise;
            z5 = false;
        } else {
            z = false;
            str = null;
            z2 = false;
            trigger_Video_Format = null;
            drawable = null;
            z3 = false;
            z4 = false;
            z5 = false;
            i = 0;
            z6 = false;
            z7 = false;
            str2 = null;
            i2 = 0;
            str3 = null;
            z8 = false;
            str4 = null;
            i3 = 0;
        }
        String str17 = str15;
        if ((j & 402653184) != 0) {
            str5 = str;
            str6 = ViewUtil.getMappingObject(R.array.msg_trigger_video_sync, 1).getStr();
        } else {
            str5 = str;
            str6 = null;
        }
        if ((j & 268451840) != 0) {
            str7 = str6;
            str8 = ViewUtil.getMappingObject(R.array.msg_trigger_video_sync, 0).getStr();
        } else {
            str7 = str6;
            str8 = null;
        }
        if ((j & 285212672) != 0) {
            z9 = z7;
            str9 = ViewUtil.getMappingObject(R.array.msg_trigger_video_sync, 3).getStr();
        } else {
            z9 = z7;
            str9 = null;
        }
        if ((j & 276824064) != 0) {
            z10 = z3;
            str10 = ViewUtil.getMappingObject(R.array.msg_trigger_video_sync, 2).getStr();
        } else {
            z10 = z3;
            str10 = null;
        }
        String str18 = ((j & 301990400) == 0 || mappingObject2 == null) ? null : mappingObject2.getStr();
        boolean z23 = (j & 2147483648L) != 0 && trigger_Video_Format == ServiceEnum.Trigger_Video_Format.Video_Stardard_PAL;
        int i12 = ((j & 268566536) > 0L ? 1 : ((j & 268566536) == 0L ? 0 : -1));
        if (i12 != 0) {
            if (z5) {
                z23 = true;
            }
            if (i12 != 0) {
                j |= z23 ? 17179869184L : 8589934592L;
            }
            if (!z23) {
                i4 = 4;
                if ((j & 269484040) != 0) {
                    CompoundButtonBindingAdapter.setChecked(this.allLines, z4);
                    CompoundButtonBindingAdapter.setChecked(this.even, z6);
                    CompoundButtonBindingAdapter.setChecked(this.lines, z);
                    this.linesNumber.setVisibility(i);
                    this.linesNumberValue.setVisibility(i);
                    CompoundButtonBindingAdapter.setChecked(this.odd, z2);
                }
                if ((j & 268451840) != 0) {
                    TextViewBindingAdapter.setText(this.allLines, str8);
                }
                if ((j & 285212672) != 0) {
                    TextViewBindingAdapter.setText(this.even, str9);
                }
                if ((j & 268566536) != 0) {
                    this.even.setVisibility(i4);
                    this.odd.setVisibility(i4);
                }
                if ((j & 268501000) != 0) {
                    ImageViewBindingAdapter.setImageDrawable(this.imageView2, drawable);
                    CompoundButtonBindingAdapter.setChecked(this.polarityN, z10);
                    CompoundButtonBindingAdapter.setChecked(this.polarityP, z9);
                }
                if ((j & 402653184) != 0) {
                    TextViewBindingAdapter.setText(this.lines, str7);
                }
                if ((j & 272629768) != 0) {
                    TextViewBindingAdapter.setText(this.linesNumberValue, str5);
                }
                if ((j & 276824064) != 0) {
                    TextViewBindingAdapter.setText(this.odd, str10);
                }
                if ((268439553 & j) != 0) {
                    TextViewBindingAdapter.setText(this.polarityN, str17);
                }
                if ((j & 301990400) != 0) {
                    TextViewBindingAdapter.setText(this.polarityP, str18);
                }
                if ((j & 268697608) != 0) {
                    TextViewBindingAdapter.setText(this.triggerLevelValue, str4);
                }
                if ((268959752 & j) != 0) {
                    SeekBarBindingAdapter.setProgress(this.triggerLevelView, i3);
                }
                if ((j & 270532616) != 0) {
                    CompoundButtonBindingAdapter.setChecked(this.triggerNoiseSwitch, z8);
                }
                if ((j & 335578120) != 0) {
                    TextViewBindingAdapter.setText(this.triggerSource, str3);
                }
                if ((j & 268468232) != 0) {
                    this.triggerSource.setTextColor(i2);
                }
                if ((j & 268574730) == 0) {
                    TextViewBindingAdapter.setText(this.videoStandardValue, str2);
                    return;
                }
                return;
            }
        }
        i4 = 0;
        if ((j & 269484040) != 0) {
        }
        if ((j & 268451840) != 0) {
        }
        if ((j & 285212672) != 0) {
        }
        if ((j & 268566536) != 0) {
        }
        if ((j & 268501000) != 0) {
        }
        if ((j & 402653184) != 0) {
        }
        if ((j & 272629768) != 0) {
        }
        if ((j & 276824064) != 0) {
        }
        if ((268439553 & j) != 0) {
        }
        if ((j & 301990400) != 0) {
        }
        if ((j & 268697608) != 0) {
        }
        if ((268959752 & j) != 0) {
        }
        if ((j & 270532616) != 0) {
        }
        if ((j & 335578120) != 0) {
        }
        if ((j & 268468232) != 0) {
        }
        if ((j & 268574730) == 0) {
        }
    }
}
