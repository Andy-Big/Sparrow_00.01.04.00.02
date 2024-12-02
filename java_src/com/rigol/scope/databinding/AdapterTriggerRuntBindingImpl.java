package com.rigol.scope.databinding;

import android.graphics.drawable.Drawable;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
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
public class AdapterTriggerRuntBindingImpl extends AdapterTriggerRuntBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.guideline_left, 22);
        sViewsWithIds.put(R.id.guideline_center, 23);
        sViewsWithIds.put(R.id.guideline_right, 24);
        sViewsWithIds.put(R.id.guideline_forth, 25);
        sViewsWithIds.put(R.id.guideline_fifth, 26);
        sViewsWithIds.put(R.id.view_top, 27);
        sViewsWithIds.put(R.id.trigger_source_label, 28);
        sViewsWithIds.put(R.id.trigger_runt_polarity_label, 29);
        sViewsWithIds.put(R.id.trigger_levelB, 30);
        sViewsWithIds.put(R.id.runt_trigger_label, 31);
        sViewsWithIds.put(R.id.trigger_level, 32);
        sViewsWithIds.put(R.id.verticalSeekBarWrapper2, 33);
        sViewsWithIds.put(R.id.verticalSeekBarWrapper3, 34);
        sViewsWithIds.put(R.id.trigger_holdoff_label, 35);
        sViewsWithIds.put(R.id.trigger_noise_label, 36);
        sViewsWithIds.put(R.id.view2, 37);
        sViewsWithIds.put(R.id.view16, 38);
    }

    public AdapterTriggerRuntBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 39, sIncludes, sViewsWithIds));
    }

    private AdapterTriggerRuntBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 11, (Button) objArr[9], (Button) objArr[10], (Guideline) objArr[23], (Guideline) objArr[26], (Guideline) objArr[25], (Guideline) objArr[22], (Guideline) objArr[24], (ImageView) objArr[14], (RadioButton) objArr[19], (RadioButton) objArr[18], (TextView) objArr[4], (EditText) objArr[5], (RadioButton) objArr[17], (RadioButton) objArr[1], (RadioButton) objArr[8], (RadioButton) objArr[7], (TextView) objArr[31], (EditText) objArr[20], (TextView) objArr[35], (TextView) objArr[32], (EditText) objArr[12], (VerticalSeekBar) objArr[15], (TextView) objArr[30], (EditText) objArr[13], (VerticalSeekBar) objArr[16], (CheckBox) objArr[11], (TextView) objArr[36], (SwitchButton) objArr[21], (TextView) objArr[29], (TextView) objArr[6], (TextView) objArr[28], (TextView) objArr[2], (EditText) objArr[3], (VerticalSeekBarWrapper) objArr[33], (VerticalSeekBarWrapper) objArr[34], (View) objArr[38], (View) objArr[37], (View) objArr[27]);
        this.mDirtyFlags = -1L;
        this.buttonLevel.setTag(null);
        this.buttonLevelB.setTag(null);
        this.imageView2.setTag(null);
        this.lessMore.setTag(null);
        this.lessThan.setTag(null);
        this.lowerLimit.setTag(null);
        this.lowerLimitValue.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.moreThan.setTag(null);
        this.none.setTag(null);
        this.runtNegative.setTag(null);
        this.runtPositive.setTag(null);
        this.triggerHoldoff.setTag(null);
        this.triggerLevelAValue.setTag(null);
        this.triggerLevelAView.setTag(null);
        this.triggerLevelBValue.setTag(null);
        this.triggerLevelBView.setTag(null);
        this.triggerLevelSelectAb.setTag(null);
        this.triggerNoiseSwitch.setTag(null);
        this.triggerSource.setTag(null);
        this.upperLimit.setTag(null);
        this.upperLimitValue.setTag(null);
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
        } else if (788 == i) {
            setSelectLevelABMapping((MappingObject) obj);
        } else if (1060 == i) {
            setWhenNoneMapping((MappingObject) obj);
        } else if (918 == i) {
            setSweepSingleMapping((MappingObject) obj);
        } else if (790 == i) {
            setSelectLevelBMapping((MappingObject) obj);
        } else if (917 == i) {
            setSweepNormalMapping((MappingObject) obj);
        } else if (644 == i) {
            setPolarityPositiveMapping((MappingObject) obj);
        } else if (789 != i) {
            return false;
        } else {
            setSelectLevelAMapping((MappingObject) obj);
        }
        return true;
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerRuntBinding
    public void setPolarityNegativeMapping(MappingObject mappingObject) {
        updateRegistration(0, mappingObject);
        this.mPolarityNegativeMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(643);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerRuntBinding
    public void setParam(TriggerParam triggerParam) {
        updateRegistration(1, triggerParam);
        this.mParam = triggerParam;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(594);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerRuntBinding
    public void setSweepAutoMapping(MappingObject mappingObject) {
        this.mSweepAutoMapping = mappingObject;
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerRuntBinding
    public void setSelectLevelABMapping(MappingObject mappingObject) {
        this.mSelectLevelABMapping = mappingObject;
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerRuntBinding
    public void setWhenNoneMapping(MappingObject mappingObject) {
        updateRegistration(4, mappingObject);
        this.mWhenNoneMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        notifyPropertyChanged(1060);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerRuntBinding
    public void setSweepSingleMapping(MappingObject mappingObject) {
        this.mSweepSingleMapping = mappingObject;
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerRuntBinding
    public void setSelectLevelBMapping(MappingObject mappingObject) {
        this.mSelectLevelBMapping = mappingObject;
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerRuntBinding
    public void setSweepNormalMapping(MappingObject mappingObject) {
        this.mSweepNormalMapping = mappingObject;
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerRuntBinding
    public void setPolarityPositiveMapping(MappingObject mappingObject) {
        updateRegistration(9, mappingObject);
        this.mPolarityPositiveMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 512;
        }
        notifyPropertyChanged(644);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerRuntBinding
    public void setSelectLevelAMapping(MappingObject mappingObject) {
        this.mSelectLevelAMapping = mappingObject;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return onChangePolarityNegativeMapping((MappingObject) obj, i2);
            case 1:
                return onChangeParam((TriggerParam) obj, i2);
            case 2:
                return onChangeSweepAutoMapping((MappingObject) obj, i2);
            case 3:
                return onChangeSelectLevelABMapping((MappingObject) obj, i2);
            case 4:
                return onChangeWhenNoneMapping((MappingObject) obj, i2);
            case 5:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerSourceParamChanValue1((MappingObject) obj, i2);
            case 6:
                return onChangeSweepSingleMapping((MappingObject) obj, i2);
            case 7:
                return onChangeSelectLevelBMapping((MappingObject) obj, i2);
            case 8:
                return onChangeSweepNormalMapping((MappingObject) obj, i2);
            case 9:
                return onChangePolarityPositiveMapping((MappingObject) obj, i2);
            case 10:
                return onChangeSelectLevelAMapping((MappingObject) obj, i2);
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
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeParam(TriggerParam triggerParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        } else if (i == 256) {
            synchronized (this) {
                this.mDirtyFlags |= 12288;
            }
            return true;
        } else if (i == 764) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE;
            }
            return true;
        } else if (i == 761) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 152) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
            }
            return true;
        } else if (i == 762) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
            }
            return true;
        } else if (i == 763) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
            }
            return true;
        } else if (i == 765) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
            }
            return true;
        } else if (i == 766) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
            }
            return true;
        } else if (i == 672) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
            }
            return true;
        } else if (i == 673) {
            synchronized (this) {
                this.mDirtyFlags |= 4194304;
            }
            return true;
        } else if (i == 377) {
            synchronized (this) {
                this.mDirtyFlags |= 8388608;
            }
            return true;
        } else if (i == 448) {
            synchronized (this) {
                this.mDirtyFlags |= 16777216;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeSweepAutoMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeSelectLevelABMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeWhenNoneMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
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

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerSourceParamChanValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
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

    private boolean onChangeSweepSingleMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeSelectLevelBMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
            }
            return true;
        }
        return false;
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
                this.mDirtyFlags |= 134217728;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeSelectLevelAMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:180:0x0307, code lost:
        if (r39 != false) goto L140;
     */
    /* JADX WARN: Removed duplicated region for block: B:116:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0211 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:131:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x025c  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x02ef  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0314  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0325  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0334  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0358  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0364  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0379  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x038f  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x03ad  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x03b8  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x03c7  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x03d4  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x03e3  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x03f2  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x0401  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x040e  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x041b  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x0428  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x0435  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x0442  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x0451  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x045e  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:252:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00f5 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0198  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void executeBindings() {
        long j;
        boolean z;
        String str;
        String str2;
        ServiceEnum.EMoreThan eMoreThan;
        boolean z2;
        boolean z3;
        boolean z4;
        Drawable drawable;
        boolean z5;
        boolean z6;
        int i;
        boolean z7;
        String str3;
        boolean z8;
        int i2;
        String str4;
        String str5;
        int i3;
        String str6;
        boolean z9;
        int i4;
        int i5;
        int i6;
        String str7;
        int i7;
        int i8;
        String str8;
        String str9;
        boolean z10;
        String str10;
        long j2;
        String str11;
        int i9;
        String str12;
        int i10;
        String str13;
        boolean z11;
        ServiceEnum.EMoreThan eMoreThan2;
        int i11;
        String str14;
        String str15;
        boolean z12;
        String str16;
        String str17;
        String str18;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z20;
        String str19;
        long j3;
        long j4;
        long j5;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        MappingObject mappingObject = this.mPolarityNegativeMapping;
        TriggerParam triggerParam = this.mParam;
        MappingObject mappingObject2 = this.mWhenNoneMapping;
        MappingObject mappingObject3 = this.mPolarityPositiveMapping;
        String str20 = ((j & 268437505) == 0 || mappingObject == null) ? null : mappingObject.getStr();
        if ((369094690 & j) != 0) {
            if ((j & 268697602) != 0) {
                if ((triggerParam != null ? triggerParam.getRuntTrigger_Level_ID() : null) == ServiceEnum.Trigger_Level_ID.Trigger_Level_Double) {
                    z10 = true;
                    if ((j & 268451842) == 0) {
                        str10 = UnitFormat.newBuilder(UnitFormat.SI.FEMTO).convert(triggerParam != null ? triggerParam.getRuntUperLimit() : 0L, ServiceEnum.Unit.Unit_s);
                    } else {
                        str10 = null;
                    }
                    int progressB = ((j & 272629762) != 0 || triggerParam == null) ? 0 : triggerParam.getProgressB();
                    if ((j & 335609890) == 0) {
                        ServiceEnum.Chan chan = triggerParam != null ? triggerParam.getChan() : null;
                        MappingObject mappingObject4 = ViewUtil.getMappingObject(R.array.msg_trigger_source, chan != null ? chan.value1 : 0);
                        updateRegistration(5, mappingObject4);
                        str11 = mappingObject4 != null ? mappingObject4.getStr() : null;
                        j2 = 0;
                        if ((j & 268500994) != 0) {
                            i9 = ColorUtil.getColor(getRoot().getContext(), chan);
                            if ((j & 269484034) != j2) {
                                long runtlevelB = triggerParam != null ? triggerParam.getRuntlevelB() : 0L;
                                if (triggerParam != null) {
                                    str12 = triggerParam.getTriggerLevelStr(runtlevelB);
                                    boolean isNoise = ((j & 285212674) != 0 || triggerParam == null) ? false : triggerParam.getIsNoise();
                                    i10 = ((j & 268443650) > 0L ? 1 : ((j & 268443650) == 0L ? 0 : -1));
                                    if (i10 == 0) {
                                        if (triggerParam != null) {
                                            str13 = str11;
                                            eMoreThan2 = triggerParam.getEMoreThan();
                                        } else {
                                            str13 = str11;
                                            eMoreThan2 = null;
                                        }
                                        z11 = eMoreThan2 == ServiceEnum.EMoreThan.Trigger_When_None;
                                        if (i10 != 0) {
                                            j = z11 ? j | 17179869184L | 68719476736L : j | 8589934592L | 34359738368L;
                                        }
                                    } else {
                                        str13 = str11;
                                        z11 = false;
                                        eMoreThan2 = null;
                                    }
                                    if ((j & 268959746) == 0) {
                                        if (triggerParam != null) {
                                            z7 = z11;
                                            i11 = i9;
                                            j5 = triggerParam.getRuntlevelA();
                                        } else {
                                            z7 = z11;
                                            i11 = i9;
                                            j5 = 0;
                                        }
                                        if (triggerParam != null) {
                                            str14 = triggerParam.getTriggerLevelStr(j5);
                                            if ((j & 276824066) != 0) {
                                                if (triggerParam != null) {
                                                    str15 = str14;
                                                    j4 = triggerParam.getHoldOff();
                                                } else {
                                                    str15 = str14;
                                                    j4 = 0;
                                                }
                                                z12 = z10;
                                                str16 = str10;
                                                str17 = UnitFormat.newBuilder(UnitFormat.SI.FEMTO).convert(j4, ServiceEnum.Unit.Unit_s);
                                            } else {
                                                str15 = str14;
                                                z12 = z10;
                                                str16 = str10;
                                                str17 = null;
                                            }
                                            if ((j & 268439554) != 0) {
                                                ServiceEnum.EMoreThan eMoreThan3 = triggerParam != null ? triggerParam.getEMoreThan() : null;
                                                z15 = eMoreThan3 == ServiceEnum.EMoreThan.Trigger_When_None;
                                                str18 = str17;
                                                z16 = eMoreThan3 == ServiceEnum.EMoreThan.Trigger_When_Morethan;
                                                boolean z21 = eMoreThan3 == ServiceEnum.EMoreThan.Trigger_When_Lessthan;
                                                z14 = eMoreThan3 == ServiceEnum.EMoreThan.Trigger_When_MoreLess;
                                                z13 = z21;
                                            } else {
                                                str18 = str17;
                                                z13 = false;
                                                z14 = false;
                                                z15 = false;
                                                z16 = false;
                                            }
                                            if ((j & 268468226) != 0) {
                                                if (triggerParam != null) {
                                                    z17 = z13;
                                                    z18 = z14;
                                                    j3 = triggerParam.getRuntLowerLimit();
                                                } else {
                                                    z17 = z13;
                                                    z18 = z14;
                                                    j3 = 0;
                                                }
                                                z19 = z15;
                                                z20 = z16;
                                                str19 = UnitFormat.newBuilder(UnitFormat.SI.FEMTO).convert(j3, ServiceEnum.Unit.Unit_s);
                                            } else {
                                                z17 = z13;
                                                z18 = z14;
                                                z19 = z15;
                                                z20 = z16;
                                                str19 = null;
                                            }
                                            int progressA = ((270532610 & j) != 0 || triggerParam == null) ? 0 : triggerParam.getProgressA();
                                            if ((j & 268566530) != 0) {
                                                ServiceEnum.TriggerPulsePolarity runtPolarity = triggerParam != null ? triggerParam.getRuntPolarity() : null;
                                                boolean z22 = runtPolarity == ServiceEnum.TriggerPulsePolarity.Trigger_pulse_negative;
                                                z2 = runtPolarity == ServiceEnum.TriggerPulsePolarity.Trigger_pulse_positive;
                                                i3 = progressB;
                                                str6 = str12;
                                                z9 = isNoise;
                                                str5 = str16;
                                                z8 = z12;
                                                z3 = z18;
                                                z4 = z20;
                                                i2 = progressA;
                                                drawable = ViewUtil.getTriggerRuntPolarityPic(runtPolarity);
                                                str2 = str18;
                                                str = str19;
                                                str4 = str15;
                                                z = z17;
                                                str3 = str13;
                                                i = i11;
                                                z5 = z22;
                                                eMoreThan = eMoreThan2;
                                                z6 = z19;
                                            } else {
                                                i3 = progressB;
                                                str6 = str12;
                                                z9 = isNoise;
                                                eMoreThan = eMoreThan2;
                                                str5 = str16;
                                                z8 = z12;
                                                str2 = str18;
                                                z3 = z18;
                                                z4 = z20;
                                                z6 = z19;
                                                z2 = false;
                                                drawable = null;
                                                i2 = progressA;
                                                str4 = str15;
                                                str = str19;
                                                str3 = str13;
                                                z = z17;
                                                i = i11;
                                                z5 = false;
                                            }
                                        }
                                    } else {
                                        z7 = z11;
                                        i11 = i9;
                                    }
                                    str14 = null;
                                    if ((j & 276824066) != 0) {
                                    }
                                    if ((j & 268439554) != 0) {
                                    }
                                    if ((j & 268468226) != 0) {
                                    }
                                    if ((270532610 & j) != 0) {
                                    }
                                    if ((j & 268566530) != 0) {
                                    }
                                }
                            }
                            str12 = null;
                            if ((j & 285212674) != 0) {
                            }
                            i10 = ((j & 268443650) > 0L ? 1 : ((j & 268443650) == 0L ? 0 : -1));
                            if (i10 == 0) {
                            }
                            if ((j & 268959746) == 0) {
                            }
                            str14 = null;
                            if ((j & 276824066) != 0) {
                            }
                            if ((j & 268439554) != 0) {
                            }
                            if ((j & 268468226) != 0) {
                            }
                            if ((270532610 & j) != 0) {
                            }
                            if ((j & 268566530) != 0) {
                            }
                        }
                    } else {
                        j2 = 0;
                        str11 = null;
                    }
                    i9 = 0;
                    if ((j & 269484034) != j2) {
                    }
                    str12 = null;
                    if ((j & 285212674) != 0) {
                    }
                    i10 = ((j & 268443650) > 0L ? 1 : ((j & 268443650) == 0L ? 0 : -1));
                    if (i10 == 0) {
                    }
                    if ((j & 268959746) == 0) {
                    }
                    str14 = null;
                    if ((j & 276824066) != 0) {
                    }
                    if ((j & 268439554) != 0) {
                    }
                    if ((j & 268468226) != 0) {
                    }
                    if ((270532610 & j) != 0) {
                    }
                    if ((j & 268566530) != 0) {
                    }
                }
            }
            z10 = false;
            if ((j & 268451842) == 0) {
            }
            if ((j & 272629762) != 0) {
            }
            if ((j & 335609890) == 0) {
            }
            i9 = 0;
            if ((j & 269484034) != j2) {
            }
            str12 = null;
            if ((j & 285212674) != 0) {
            }
            i10 = ((j & 268443650) > 0L ? 1 : ((j & 268443650) == 0L ? 0 : -1));
            if (i10 == 0) {
            }
            if ((j & 268959746) == 0) {
            }
            str14 = null;
            if ((j & 276824066) != 0) {
            }
            if ((j & 268439554) != 0) {
            }
            if ((j & 268468226) != 0) {
            }
            if ((270532610 & j) != 0) {
            }
            if ((j & 268566530) != 0) {
            }
        } else {
            z = false;
            str = null;
            str2 = null;
            eMoreThan = null;
            z2 = false;
            z3 = false;
            z4 = false;
            drawable = null;
            z5 = false;
            z6 = false;
            i = 0;
            z7 = false;
            str3 = null;
            z8 = false;
            i2 = 0;
            str4 = null;
            str5 = null;
            i3 = 0;
            str6 = null;
            z9 = false;
        }
        String str21 = ((j & 301989904) == 0 || mappingObject2 == null) ? null : mappingObject2.getStr();
        String str22 = ((j & 402653696) == 0 || mappingObject3 == null) ? null : mappingObject3.getStr();
        int i12 = ((j & 8589934592L) > 0L ? 1 : ((j & 8589934592L) == 0L ? 0 : -1));
        int i13 = 4;
        String str23 = str2;
        if (i12 != 0) {
            boolean z23 = eMoreThan == ServiceEnum.EMoreThan.Trigger_When_Lessthan;
            if (i12 != 0) {
                j |= z23 ? 1073741824L : 536870912L;
            }
            if (z23) {
                i4 = 4;
                i5 = ((j & 34359738368L) > 0L ? 1 : ((j & 34359738368L) == 0L ? 0 : -1));
                int i14 = i4;
                if (i5 != 0) {
                    boolean z24 = eMoreThan == ServiceEnum.EMoreThan.Trigger_When_Morethan;
                    if (i5 != 0) {
                        j |= z24 ? 4294967296L : 2147483648L;
                    }
                }
                i13 = 0;
                i6 = ((j & 268443650) > 0L ? 1 : ((j & 268443650) == 0L ? 0 : -1));
                if (i6 == 0) {
                    if (z7) {
                        i14 = 8;
                    }
                    if (z7) {
                        i13 = 8;
                    }
                    str7 = str22;
                    i8 = i14;
                    i7 = i13;
                } else {
                    str7 = str22;
                    i7 = 0;
                    i8 = 0;
                }
                if ((j & 268435456) == 0) {
                    str8 = str20;
                    str9 = str21;
                    this.buttonLevel.setVisibility(0);
                    this.buttonLevelB.setVisibility(0);
                    this.triggerLevelAValue.setVisibility(0);
                    this.triggerLevelAView.setVisibility(0);
                    this.triggerLevelBValue.setVisibility(0);
                    this.triggerLevelBView.setVisibility(0);
                } else {
                    str8 = str20;
                    str9 = str21;
                }
                if ((j & 268566530) != 0) {
                    ImageViewBindingAdapter.setImageDrawable(this.imageView2, drawable);
                    CompoundButtonBindingAdapter.setChecked(this.runtNegative, z5);
                    CompoundButtonBindingAdapter.setChecked(this.runtPositive, z2);
                }
                if ((j & 268439554) != 0) {
                    CompoundButtonBindingAdapter.setChecked(this.lessMore, z3);
                    CompoundButtonBindingAdapter.setChecked(this.lessThan, z);
                    CompoundButtonBindingAdapter.setChecked(this.moreThan, z4);
                    CompoundButtonBindingAdapter.setChecked(this.none, z6);
                }
                if (i6 != 0) {
                    this.lowerLimit.setVisibility(i8);
                    this.lowerLimitValue.setVisibility(i8);
                    this.upperLimit.setVisibility(i7);
                    this.upperLimitValue.setVisibility(i7);
                }
                if ((268468226 & j) != 0) {
                    TextViewBindingAdapter.setText(this.lowerLimitValue, str);
                }
                if ((j & 301989904) != 0) {
                    TextViewBindingAdapter.setText(this.none, str9);
                }
                if ((268437505 & j) != 0) {
                    TextViewBindingAdapter.setText(this.runtNegative, str8);
                }
                if ((j & 402653696) != 0) {
                    TextViewBindingAdapter.setText(this.runtPositive, str7);
                }
                if ((276824066 & j) != 0) {
                    TextViewBindingAdapter.setText(this.triggerHoldoff, str23);
                }
                if ((268959746 & j) != 0) {
                    TextViewBindingAdapter.setText(this.triggerLevelAValue, str4);
                }
                if ((270532610 & j) != 0) {
                    SeekBarBindingAdapter.setProgress(this.triggerLevelAView, i2);
                }
                if ((j & 269484034) != 0) {
                    TextViewBindingAdapter.setText(this.triggerLevelBValue, str6);
                }
                if ((j & 272629762) != 0) {
                    SeekBarBindingAdapter.setProgress(this.triggerLevelBView, i3);
                }
                if ((j & 268697602) != 0) {
                    CompoundButtonBindingAdapter.setChecked(this.triggerLevelSelectAb, z8);
                }
                if ((j & 285212674) != 0) {
                    CompoundButtonBindingAdapter.setChecked(this.triggerNoiseSwitch, z9);
                }
                if ((j & 335609890) != 0) {
                    TextViewBindingAdapter.setText(this.triggerSource, str3);
                }
                if ((268500994 & j) != 0) {
                    this.triggerSource.setTextColor(i);
                }
                if ((j & 268451842) == 0) {
                    TextViewBindingAdapter.setText(this.upperLimitValue, str5);
                    return;
                }
                return;
            }
        }
        i4 = 0;
        i5 = ((j & 34359738368L) > 0L ? 1 : ((j & 34359738368L) == 0L ? 0 : -1));
        int i142 = i4;
        if (i5 != 0) {
        }
        i13 = 0;
        i6 = ((j & 268443650) > 0L ? 1 : ((j & 268443650) == 0L ? 0 : -1));
        if (i6 == 0) {
        }
        if ((j & 268435456) == 0) {
        }
        if ((j & 268566530) != 0) {
        }
        if ((j & 268439554) != 0) {
        }
        if (i6 != 0) {
        }
        if ((268468226 & j) != 0) {
        }
        if ((j & 301989904) != 0) {
        }
        if ((268437505 & j) != 0) {
        }
        if ((j & 402653696) != 0) {
        }
        if ((276824066 & j) != 0) {
        }
        if ((268959746 & j) != 0) {
        }
        if ((270532610 & j) != 0) {
        }
        if ((j & 269484034) != 0) {
        }
        if ((j & 272629762) != 0) {
        }
        if ((j & 268697602) != 0) {
        }
        if ((j & 285212674) != 0) {
        }
        if ((j & 335609890) != 0) {
        }
        if ((268500994 & j) != 0) {
        }
        if ((j & 268451842) == 0) {
        }
    }
}
