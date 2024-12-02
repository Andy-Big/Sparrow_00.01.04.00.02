package com.rigol.scope.databinding;

import android.graphics.drawable.Drawable;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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
public class AdapterTriggerEdgeBindingImpl extends AdapterTriggerEdgeBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.guideline_left, 18);
        sViewsWithIds.put(R.id.guideline_center, 19);
        sViewsWithIds.put(R.id.guideline_right, 20);
        sViewsWithIds.put(R.id.view_top, 21);
        sViewsWithIds.put(R.id.view_line_1, 22);
        sViewsWithIds.put(R.id.view_line_2, 23);
        sViewsWithIds.put(R.id.trigger_source_label, 24);
        sViewsWithIds.put(R.id.trigger_holdoff_label, 25);
        sViewsWithIds.put(R.id.trigger_mode_label, 26);
        sViewsWithIds.put(R.id.mode_radio_group, 27);
        sViewsWithIds.put(R.id.edge_type_label, 28);
        sViewsWithIds.put(R.id.verticalSeekBarWrapper2, 29);
    }

    public AdapterTriggerEdgeBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 30, sIncludes, sViewsWithIds));
    }

    private AdapterTriggerEdgeBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 9, (RadioButton) objArr[7], (Button) objArr[16], (RadioButton) objArr[12], (RadioButton) objArr[11], (RadioButton) objArr[10], (ImageView) objArr[13], (TextView) objArr[28], (Guideline) objArr[19], (Guideline) objArr[18], (Guideline) objArr[20], (RadioGroup) objArr[27], (RadioButton) objArr[8], (RadioButton) objArr[9], (TextView) objArr[3], (TextView) objArr[1], (EditText) objArr[4], (TextView) objArr[25], (TextView) objArr[14], (EditText) objArr[17], (VerticalSeekBar) objArr[15], (TextView) objArr[26], (TextView) objArr[6], (SwitchButton) objArr[5], (TextView) objArr[2], (TextView) objArr[24], (VerticalSeekBarWrapper) objArr[29], (View) objArr[22], (View) objArr[23], (View) objArr[21]);
        this.mDirtyFlags = -1L;
        this.autoRadioButton.setTag(null);
        this.buttonLevel.setTag(null);
        this.edgeEither.setTag(null);
        this.edgeFalling.setTag(null);
        this.edgeRising.setTag(null);
        this.edgeSlopeImageButton.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.normalRadioButton.setTag(null);
        this.singleRadioButton.setTag(null);
        this.triggerCoupling.setTag(null);
        this.triggerCouplingLabel.setTag(null);
        this.triggerHoldoff.setTag(null);
        this.triggerLevel.setTag(null);
        this.triggerLevelValue.setTag(null);
        this.triggerLevelView.setTag(null);
        this.triggerNoiseLabel.setTag(null);
        this.triggerNoiseSwitch.setTag(null);
        this.triggerSource.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 33554432L;
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
            setParam((TriggerParam) obj);
        } else if (916 == i) {
            setSweepAutoMapping((MappingObject) obj);
        } else if (265 == i) {
            setEdgeRisingMapping((MappingObject) obj);
        } else if (918 == i) {
            setSweepSingleMapping((MappingObject) obj);
        } else if (917 == i) {
            setSweepNormalMapping((MappingObject) obj);
        } else if (258 == i) {
            setEdgeEitherMapping((MappingObject) obj);
        } else if (261 != i) {
            return false;
        } else {
            setEdgeFallingMapping((MappingObject) obj);
        }
        return true;
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerEdgeBinding
    public void setParam(TriggerParam triggerParam) {
        updateRegistration(2, triggerParam);
        this.mParam = triggerParam;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(594);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerEdgeBinding
    public void setSweepAutoMapping(MappingObject mappingObject) {
        updateRegistration(3, mappingObject);
        this.mSweepAutoMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(916);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerEdgeBinding
    public void setEdgeRisingMapping(MappingObject mappingObject) {
        updateRegistration(4, mappingObject);
        this.mEdgeRisingMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        notifyPropertyChanged(265);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerEdgeBinding
    public void setSweepSingleMapping(MappingObject mappingObject) {
        updateRegistration(5, mappingObject);
        this.mSweepSingleMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        notifyPropertyChanged(918);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerEdgeBinding
    public void setSweepNormalMapping(MappingObject mappingObject) {
        updateRegistration(6, mappingObject);
        this.mSweepNormalMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        notifyPropertyChanged(917);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerEdgeBinding
    public void setEdgeEitherMapping(MappingObject mappingObject) {
        updateRegistration(7, mappingObject);
        this.mEdgeEitherMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 128;
        }
        notifyPropertyChanged(258);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerEdgeBinding
    public void setEdgeFallingMapping(MappingObject mappingObject) {
        updateRegistration(8, mappingObject);
        this.mEdgeFallingMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 256;
        }
        notifyPropertyChanged(261);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerCouplingParamCouplingValue1((MappingObject) obj, i2);
            case 1:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerSourceLaExtAcParamChanValue1((MappingObject) obj, i2);
            case 2:
                return onChangeParam((TriggerParam) obj, i2);
            case 3:
                return onChangeSweepAutoMapping((MappingObject) obj, i2);
            case 4:
                return onChangeEdgeRisingMapping((MappingObject) obj, i2);
            case 5:
                return onChangeSweepSingleMapping((MappingObject) obj, i2);
            case 6:
                return onChangeSweepNormalMapping((MappingObject) obj, i2);
            case 7:
                return onChangeEdgeEitherMapping((MappingObject) obj, i2);
            case 8:
                return onChangeEdgeFallingMapping((MappingObject) obj, i2);
            default:
                return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerCouplingParamCouplingValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
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

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerSourceLaExtAcParamChanValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeParam(TriggerParam triggerParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else if (i == 152) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
            }
            return true;
        } else if (i == 193) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
            }
            return true;
        } else if (i == 377) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            }
            return true;
        } else if (i == 448) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE;
            }
            return true;
        } else if (i == 554) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 266) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
            }
            return true;
        } else if (i == 671) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
            }
            return true;
        } else if (i == 484) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeSweepAutoMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeEdgeRisingMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
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

    private boolean onChangeSweepSingleMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
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

    private boolean onChangeSweepNormalMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
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

    private boolean onChangeEdgeEitherMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
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

    private boolean onChangeEdgeFallingMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 256;
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

    /* JADX WARN: Removed duplicated region for block: B:100:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x02d7  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0303  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x030e  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0320  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0328  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0333  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x037e  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x03a2  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x03ad  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x03b8  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x03c3  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x03d0  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x03dd  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x03ea  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x03f7  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x0404  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x0411  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x041e  */
    /* JADX WARN: Removed duplicated region for block: B:224:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0172 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01b8 A[ADDED_TO_REGION] */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void executeBindings() {
        long j;
        float f;
        ServiceEnum.Chan chan;
        String str;
        String str2;
        String str3;
        String str4;
        Drawable drawable;
        int i;
        boolean z;
        boolean z2;
        int i2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        int i3;
        boolean z9;
        String str5;
        boolean z10;
        int i4;
        float f2;
        boolean z11;
        String str6;
        long j2;
        long j3;
        String str7;
        float f3;
        String str8;
        ServiceEnum.Chan chan2;
        boolean z12;
        int i5;
        boolean z13;
        int i6;
        String str9;
        float f4;
        boolean z14;
        boolean z15;
        boolean z16;
        boolean z17;
        boolean z18;
        String str10;
        String str11;
        boolean z19;
        String str12;
        String str13;
        long j4;
        long j5;
        int i7;
        long j6;
        long j7;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        TriggerParam triggerParam = this.mParam;
        MappingObject mappingObject = this.mSweepAutoMapping;
        MappingObject mappingObject2 = this.mEdgeRisingMapping;
        MappingObject mappingObject3 = this.mSweepSingleMapping;
        MappingObject mappingObject4 = this.mSweepNormalMapping;
        MappingObject mappingObject5 = this.mEdgeEitherMapping;
        MappingObject mappingObject6 = this.mEdgeFallingMapping;
        String str14 = null;
        if ((34078215 & j) != 0) {
            if ((j & 33559045) != 0) {
                ServiceEnum.Coupling coupling = triggerParam != null ? triggerParam.getCoupling() : null;
                MappingObject mappingObject7 = ViewUtil.getMappingObject(R.array.msg_trigger_coupling, coupling != null ? coupling.value1 : 0);
                updateRegistration(0, mappingObject7);
                if (mappingObject7 != null) {
                    str7 = mappingObject7.getStr();
                    if ((j & 33557510) == 0) {
                        chan2 = triggerParam != null ? triggerParam.getChan() : null;
                        MappingObject mappingObject8 = ViewUtil.getMappingObject(R.array.msg_trigger_source_la_ext_ac, chan2 != null ? chan2.value1 : 0);
                        updateRegistration(1, mappingObject8);
                        str8 = mappingObject8 != null ? mappingObject8.getStr() : null;
                        int i8 = ((j & 33556484) > 0L ? 1 : ((j & 33556484) == 0L ? 0 : -1));
                        if (i8 != 0) {
                            i5 = ColorUtil.getColor(getRoot().getContext(), chan2);
                            z12 = chan2 == ServiceEnum.Chan.acline;
                            if (i8 != 0) {
                                if (z12) {
                                    j6 = j | 536870912 | 2147483648L | 8589934592L;
                                    j7 = 34359738368L;
                                } else {
                                    j6 = j | 268435456 | 1073741824 | 4294967296L;
                                    j7 = 17179869184L;
                                }
                                j = j6 | j7;
                            }
                            f3 = z12 ? 0.5f : 1.0f;
                            z13 = !z12;
                            if (z12) {
                                i6 = 4;
                                if ((j & 33587204) == 0) {
                                    if (triggerParam != null) {
                                        f4 = f3;
                                        str9 = str8;
                                        i7 = triggerParam.getNMode();
                                    } else {
                                        str9 = str8;
                                        f4 = f3;
                                        i7 = 0;
                                    }
                                    boolean z20 = i7 == ServiceEnum.TriggerSweep.Trigger_Sweep_Normal.value1;
                                    z16 = i7 == ServiceEnum.TriggerSweep.Trigger_Sweep_Single.value1;
                                    z14 = i7 == ServiceEnum.TriggerSweep.Trigger_Sweep_Auto.value1;
                                    z15 = z20;
                                } else {
                                    str9 = str8;
                                    f4 = f3;
                                    z14 = false;
                                    z15 = false;
                                    z16 = false;
                                }
                                if ((j & 33816580) == 0) {
                                    if (triggerParam != null) {
                                        z17 = z14;
                                        z18 = z15;
                                        j5 = triggerParam.getLevel();
                                    } else {
                                        z17 = z14;
                                        z18 = z15;
                                        j5 = 0;
                                    }
                                    if (triggerParam != null) {
                                        str10 = triggerParam.getTriggerLevelStr(j5);
                                        boolean isNoise = ((j & 33570820) != 0 || triggerParam == null) ? false : triggerParam.getIsNoise();
                                        if ((j & 33562628) != 0) {
                                            if (triggerParam != null) {
                                                str11 = str10;
                                                z19 = isNoise;
                                                j4 = triggerParam.getHoldOff();
                                            } else {
                                                str11 = str10;
                                                z19 = isNoise;
                                                j4 = 0;
                                            }
                                            str12 = str7;
                                            z8 = z12;
                                            str13 = UnitFormat.newBuilder(UnitFormat.SI.FEMTO).convert(j4, ServiceEnum.Unit.Unit_s);
                                        } else {
                                            str11 = str10;
                                            z19 = isNoise;
                                            str12 = str7;
                                            z8 = z12;
                                            str13 = null;
                                        }
                                        int progress = ((j & 33685508) != 0 || triggerParam == null) ? 0 : triggerParam.getProgress();
                                        if ((j & 33619972) != 0) {
                                            ServiceEnum.EdgeSlope edgeSlope = triggerParam != null ? triggerParam.getEdgeSlope() : null;
                                            boolean z21 = edgeSlope == ServiceEnum.EdgeSlope.Trigger_Edge_Any;
                                            long j8 = j;
                                            boolean z22 = edgeSlope == ServiceEnum.EdgeSlope.Trigger_Edge_Rising;
                                            boolean z23 = edgeSlope == ServiceEnum.EdgeSlope.Trigger_Edge_Falling;
                                            i3 = progress;
                                            z2 = z17;
                                            z9 = z19;
                                            drawable = ViewUtil.getTriggerEdgePic(edgeSlope);
                                            i = i5;
                                            f = f4;
                                            z3 = z16;
                                            str4 = str12;
                                            z5 = z22;
                                            i2 = i6;
                                            str2 = str11;
                                            z7 = z21;
                                            chan = chan2;
                                            z4 = z18;
                                            z6 = z23;
                                            j = j8;
                                        } else {
                                            i3 = progress;
                                            i = i5;
                                            chan = chan2;
                                            i2 = i6;
                                            z2 = z17;
                                            z3 = z16;
                                            z4 = z18;
                                            str2 = str11;
                                            z9 = z19;
                                            z5 = false;
                                            z6 = false;
                                            z7 = false;
                                            drawable = null;
                                            f = f4;
                                            str4 = str12;
                                        }
                                        String str15 = str9;
                                        str3 = str13;
                                        z = z13;
                                        str = str15;
                                    }
                                } else {
                                    z17 = z14;
                                    z18 = z15;
                                }
                                str10 = null;
                                if ((j & 33570820) != 0) {
                                }
                                if ((j & 33562628) != 0) {
                                }
                                if ((j & 33685508) != 0) {
                                }
                                if ((j & 33619972) != 0) {
                                }
                                String str152 = str9;
                                str3 = str13;
                                z = z13;
                                str = str152;
                            }
                            i6 = 0;
                            if ((j & 33587204) == 0) {
                            }
                            if ((j & 33816580) == 0) {
                            }
                            str10 = null;
                            if ((j & 33570820) != 0) {
                            }
                            if ((j & 33562628) != 0) {
                            }
                            if ((j & 33685508) != 0) {
                            }
                            if ((j & 33619972) != 0) {
                            }
                            String str1522 = str9;
                            str3 = str13;
                            z = z13;
                            str = str1522;
                        } else {
                            f3 = 0.0f;
                        }
                    } else {
                        f3 = 0.0f;
                        str8 = null;
                        chan2 = null;
                    }
                    z12 = false;
                    i5 = 0;
                    z13 = false;
                    i6 = 0;
                    if ((j & 33587204) == 0) {
                    }
                    if ((j & 33816580) == 0) {
                    }
                    str10 = null;
                    if ((j & 33570820) != 0) {
                    }
                    if ((j & 33562628) != 0) {
                    }
                    if ((j & 33685508) != 0) {
                    }
                    if ((j & 33619972) != 0) {
                    }
                    String str15222 = str9;
                    str3 = str13;
                    z = z13;
                    str = str15222;
                }
            }
            str7 = null;
            if ((j & 33557510) == 0) {
            }
            z12 = false;
            i5 = 0;
            z13 = false;
            i6 = 0;
            if ((j & 33587204) == 0) {
            }
            if ((j & 33816580) == 0) {
            }
            str10 = null;
            if ((j & 33570820) != 0) {
            }
            if ((j & 33562628) != 0) {
            }
            if ((j & 33685508) != 0) {
            }
            if ((j & 33619972) != 0) {
            }
            String str152222 = str9;
            str3 = str13;
            z = z13;
            str = str152222;
        } else {
            f = 0.0f;
            chan = null;
            str = null;
            str2 = null;
            str3 = null;
            str4 = null;
            drawable = null;
            i = 0;
            z = false;
            z2 = false;
            i2 = 0;
            z3 = false;
            z4 = false;
            z5 = false;
            z6 = false;
            z7 = false;
            z8 = false;
            i3 = 0;
            z9 = false;
        }
        String str16 = ((j & 34078728) == 0 || mappingObject == null) ? null : mappingObject.getStr();
        String str17 = ((j & 34603024) == 0 || mappingObject2 == null) ? null : mappingObject2.getStr();
        String str18 = ((j & 35651616) == 0 || mappingObject3 == null) ? null : mappingObject3.getStr();
        String str19 = ((j & 37748800) == 0 || mappingObject4 == null) ? null : mappingObject4.getStr();
        String str20 = ((j & 41943168) == 0 || mappingObject5 == null) ? null : mappingObject5.getStr();
        if ((j & 50331904) != 0 && mappingObject6 != null) {
            str14 = mappingObject6.getStr();
        }
        String str21 = str14;
        if ((j & 4294967296L) != 0) {
            str5 = str18;
            if (chan == ServiceEnum.Chan.ext) {
                z10 = true;
                i4 = ((j & 33556484) > 0L ? 1 : ((j & 33556484) == 0L ? 0 : -1));
                if (i4 == 0) {
                    if (z8) {
                        z10 = true;
                    }
                    if (i4 != 0) {
                        if (z10) {
                            j2 = j | 134217728;
                            j3 = 137438953472L;
                        } else {
                            j2 = j | 67108864;
                            j3 = 68719476736L;
                        }
                        j = j2 | j3;
                    }
                    z11 = !z10;
                    f2 = z10 ? 0.5f : 1.0f;
                } else {
                    f2 = 0.0f;
                    z11 = false;
                }
                if ((j & 33587204) == 0) {
                    str6 = str19;
                    CompoundButtonBindingAdapter.setChecked(this.autoRadioButton, z2);
                    CompoundButtonBindingAdapter.setChecked(this.normalRadioButton, z4);
                    CompoundButtonBindingAdapter.setChecked(this.singleRadioButton, z3);
                } else {
                    str6 = str19;
                }
                if ((j & 34078728) != 0) {
                    TextViewBindingAdapter.setText(this.autoRadioButton, str16);
                }
                if ((j & 33556484) != 0) {
                    this.buttonLevel.setVisibility(i2);
                    this.triggerCoupling.setEnabled(z11);
                    this.triggerLevel.setVisibility(i2);
                    this.triggerLevelValue.setVisibility(i2);
                    this.triggerLevelView.setVisibility(i2);
                    this.triggerNoiseSwitch.setEnabled(z);
                    this.triggerSource.setTextColor(i);
                    if (getBuildSdkInt() >= 11) {
                        this.triggerCoupling.setAlpha(f2);
                        this.triggerCouplingLabel.setAlpha(f2);
                        float f5 = f;
                        this.triggerNoiseLabel.setAlpha(f5);
                        this.triggerNoiseSwitch.setAlpha(f5);
                    }
                }
                if ((33619972 & j) != 0) {
                    CompoundButtonBindingAdapter.setChecked(this.edgeEither, z7);
                    CompoundButtonBindingAdapter.setChecked(this.edgeFalling, z6);
                    CompoundButtonBindingAdapter.setChecked(this.edgeRising, z5);
                    ImageViewBindingAdapter.setImageDrawable(this.edgeSlopeImageButton, drawable);
                }
                if ((j & 41943168) != 0) {
                    TextViewBindingAdapter.setText(this.edgeEither, str20);
                }
                if ((j & 50331904) != 0) {
                    TextViewBindingAdapter.setText(this.edgeFalling, str21);
                }
                if ((j & 34603024) != 0) {
                    TextViewBindingAdapter.setText(this.edgeRising, str17);
                }
                if ((j & 37748800) != 0) {
                    TextViewBindingAdapter.setText(this.normalRadioButton, str6);
                }
                if ((j & 35651616) != 0) {
                    TextViewBindingAdapter.setText(this.singleRadioButton, str5);
                }
                if ((j & 33559045) != 0) {
                    TextViewBindingAdapter.setText(this.triggerCoupling, str4);
                }
                if ((j & 33562628) != 0) {
                    TextViewBindingAdapter.setText(this.triggerHoldoff, str3);
                }
                if ((j & 33816580) != 0) {
                    TextViewBindingAdapter.setText(this.triggerLevelValue, str2);
                }
                if ((j & 33685508) != 0) {
                    SeekBarBindingAdapter.setProgress(this.triggerLevelView, i3);
                }
                if ((j & 33570820) != 0) {
                    CompoundButtonBindingAdapter.setChecked(this.triggerNoiseSwitch, z9);
                }
                if ((j & 33557510) == 0) {
                    TextViewBindingAdapter.setText(this.triggerSource, str);
                    return;
                }
                return;
            }
        } else {
            str5 = str18;
        }
        z10 = false;
        i4 = ((j & 33556484) > 0L ? 1 : ((j & 33556484) == 0L ? 0 : -1));
        if (i4 == 0) {
        }
        if ((j & 33587204) == 0) {
        }
        if ((j & 34078728) != 0) {
        }
        if ((j & 33556484) != 0) {
        }
        if ((33619972 & j) != 0) {
        }
        if ((j & 41943168) != 0) {
        }
        if ((j & 50331904) != 0) {
        }
        if ((j & 34603024) != 0) {
        }
        if ((j & 37748800) != 0) {
        }
        if ((j & 35651616) != 0) {
        }
        if ((j & 33559045) != 0) {
        }
        if ((j & 33562628) != 0) {
        }
        if ((j & 33816580) != 0) {
        }
        if ((j & 33685508) != 0) {
        }
        if ((j & 33570820) != 0) {
        }
        if ((j & 33557510) == 0) {
        }
    }
}
