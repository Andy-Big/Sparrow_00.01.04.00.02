package com.rigol.scope.databinding;

import android.graphics.drawable.Drawable;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.CompoundButtonBindingAdapter;
import androidx.databinding.adapters.ImageViewBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.rigol.scope.R;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.HorizontalParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.MaskParam;
import com.rigol.scope.utilities.ColorUtil;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.UnitFormat;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.views.SwitchButton;
import java.util.List;

/* loaded from: classes2.dex */
public class PopupviewMaskBindingImpl extends PopupviewMaskBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.guideline_center, 41);
        sViewsWithIds.put(R.id.enable, 42);
        sViewsWithIds.put(R.id.radioGroup_maskRange, 43);
    }

    public PopupviewMaskBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 44, sIncludes, sViewsWithIds));
    }

    private PopupviewMaskBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 9, (Button) objArr[20], (Button) objArr[21], (Button) objArr[22], (CheckBox) objArr[39], (CheckBox) objArr[40], (CheckBox) objArr[38], (View) objArr[7], (View) objArr[23], (TextView) objArr[42], (SwitchButton) objArr[1], (Guideline) objArr[41], (ImageButton) objArr[18], (ImageButton) objArr[19], (ImageButton) objArr[15], (ImageButton) objArr[14], (TextView) objArr[8], (TextView) objArr[2], (ImageView) objArr[3], (RadioButton) objArr[11], (RadioButton) objArr[31], (RadioButton) objArr[36], (RadioButton) objArr[32], (RadioButton) objArr[35], (RadioButton) objArr[10], (RadioGroup) objArr[30], (RadioGroup) objArr[34], (RadioGroup) objArr[43], (Button) objArr[6], (TextView) objArr[4], (TextView) objArr[5], (SwitchButton) objArr[26], (TextView) objArr[37], (TextView) objArr[25], (TextView) objArr[24], (TextView) objArr[29], (TextView) objArr[33], (TextView) objArr[27], (TextView) objArr[9], (TextView) objArr[16], (TextView) objArr[12], (TextView) objArr[28], (TextView) objArr[17], (TextView) objArr[13]);
        this.mDirtyFlags = -1L;
        this.buttonMaskCreateMenu.setTag(null);
        this.buttonMaskLoad.setTag(null);
        this.buttonMaskSave.setTag(null);
        this.checkBoxMaskBeeper.setTag(null);
        this.checkBoxMaskScreen.setTag(null);
        this.checkBoxMaskStop.setTag(null);
        this.dividingLine1.setTag(null);
        this.dividingLine2.setTag(null);
        this.enableSwitch.setTag(null);
        this.imageButtonMaskXmaskLeft.setTag(null);
        this.imageButtonMaskXmaskRight.setTag(null);
        this.imageButtonMaskYmaskDown.setTag(null);
        this.imageButtonMaskYmaskUP.setTag(null);
        this.mask.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.operate.setTag(null);
        this.operateButton.setTag(null);
        this.radioButtonMaskCursor.setTag(null);
        this.radioButtonMaskFaile.setTag(null);
        this.radioButtonMaskNegativePulse.setTag(null);
        this.radioButtonMaskPass.setTag(null);
        this.radioButtonMaskPositionPulse.setTag(null);
        this.radioButtonMaskScreen.setTag(null);
        this.radioGroupMaskOutEvent.setTag(null);
        this.radioGroupMaskOutHl.setTag(null);
        this.resetButton.setTag(null);
        this.source.setTag(null);
        this.sourceSpinner.setTag(null);
        this.switchButtonMaskOut.setTag(null);
        this.textViewMaskErrAction.setTag(null);
        this.textViewMaskOUt.setTag(null);
        this.textViewMaskOption.setTag(null);
        this.textViewMaskOutEvent.setTag(null);
        this.textViewMaskOutHl.setTag(null);
        this.textViewMaskOutPulse.setTag(null);
        this.textViewMaskRange.setTag(null);
        this.textViewMaskXmask.setTag(null);
        this.textViewMaskYmask.setTag(null);
        this.valueMaskOUtPulse.setTag(null);
        this.valueMaskXmask.setTag(null);
        this.valueMaskYmask.setTag(null);
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
        if (13 == i) {
            setNegativeMapping((MappingObject) obj);
        } else if (594 == i) {
            setParam((MaskParam) obj);
        } else if (3 == i) {
            setCursorMapping((MappingObject) obj);
        } else if (18 == i) {
            setScreenMapping((MappingObject) obj);
        } else if (16 == i) {
            setPositiveMapping((MappingObject) obj);
        } else if (14 == i) {
            setPassMapping((MappingObject) obj);
        } else if (5 == i) {
            setFailMapping((MappingObject) obj);
        } else if (382 != i) {
            return false;
        } else {
            setHorizontalParam((HorizontalParam) obj);
        }
        return true;
    }

    @Override // com.rigol.scope.databinding.PopupviewMaskBinding
    public void setNegativeMapping(MappingObject mappingObject) {
        updateRegistration(0, mappingObject);
        this.mNegativeMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(13);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewMaskBinding
    public void setParam(MaskParam maskParam) {
        updateRegistration(1, maskParam);
        this.mParam = maskParam;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(594);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewMaskBinding
    public void setCursorMapping(MappingObject mappingObject) {
        updateRegistration(2, mappingObject);
        this.mCursorMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(3);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewMaskBinding
    public void setScreenMapping(MappingObject mappingObject) {
        updateRegistration(3, mappingObject);
        this.mScreenMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(18);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewMaskBinding
    public void setPositiveMapping(MappingObject mappingObject) {
        updateRegistration(5, mappingObject);
        this.mPositiveMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        notifyPropertyChanged(16);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewMaskBinding
    public void setPassMapping(MappingObject mappingObject) {
        updateRegistration(6, mappingObject);
        this.mPassMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        notifyPropertyChanged(14);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewMaskBinding
    public void setFailMapping(MappingObject mappingObject) {
        updateRegistration(7, mappingObject);
        this.mFailMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 128;
        }
        notifyPropertyChanged(5);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewMaskBinding
    public void setHorizontalParam(HorizontalParam horizontalParam) {
        this.mHorizontalParam = horizontalParam;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return onChangeNegativeMapping((MappingObject) obj, i2);
            case 1:
                return onChangeParam((MaskParam) obj, i2);
            case 2:
                return onChangeCursorMapping((MappingObject) obj, i2);
            case 3:
                return onChangeScreenMapping((MappingObject) obj, i2);
            case 4:
                return onChangeViewUtilGetArrayComRigolScopeRArrayMsgMaskSourceGetParamSource((MappingObject) obj, i2);
            case 5:
                return onChangePositiveMapping((MappingObject) obj, i2);
            case 6:
                return onChangePassMapping((MappingObject) obj, i2);
            case 7:
                return onChangeFailMapping((MappingObject) obj, i2);
            case 8:
                return onChangeHorizontalParam((HorizontalParam) obj, i2);
            default:
                return false;
        }
    }

    private boolean onChangeNegativeMapping(MappingObject mappingObject, int i) {
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

    private boolean onChangeParam(MaskParam maskParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        } else if (i == 271) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 572) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
            }
            return true;
        } else if (i == 858) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
            }
            return true;
        } else if (i == 541) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            }
            return true;
        } else if (i == 685) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE;
            }
            return true;
        } else if (i == 1086) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 1080) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
            }
            return true;
        } else if (i == 63) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
            }
            return true;
        } else if (i == 577) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
            }
            return true;
        } else if (i == 575) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
            }
            return true;
        } else if (i == 576) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
            }
            return true;
        } else if (i == 277) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeCursorMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
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

    private boolean onChangeScreenMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
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

    private boolean onChangeViewUtilGetArrayComRigolScopeRArrayMsgMaskSourceGetParamSource(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
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

    private boolean onChangePositiveMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
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

    private boolean onChangePassMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
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

    private boolean onChangeFailMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
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

    private boolean onChangeHorizontalParam(HorizontalParam horizontalParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 256;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:134:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0296  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x02a9  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x02d9  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void executeBindings() {
        long j;
        String str;
        float f;
        boolean z;
        boolean z2;
        int i;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        String str2;
        boolean z7;
        String str3;
        String str4;
        boolean z8;
        String str5;
        boolean z9;
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        int i2;
        Drawable drawable;
        String str6;
        boolean z14;
        String str7;
        String str8;
        long j2;
        Drawable drawable2;
        boolean z15;
        String str9;
        String str10;
        String str11;
        int i3;
        long j3;
        float f2;
        boolean z16;
        boolean z17;
        boolean z18;
        String str12;
        boolean z19;
        boolean z20;
        boolean z21;
        boolean z22;
        String str13;
        int i4;
        boolean z23;
        boolean z24;
        boolean z25;
        boolean z26;
        boolean z27;
        boolean z28;
        int i5;
        boolean z29;
        boolean z30;
        boolean z31;
        int i6;
        String str14;
        int i7;
        ServiceEnum.MaskPolarity maskPolarity;
        int i8;
        Integer num;
        Integer num2;
        Integer num3;
        ServiceEnum.MaskActionEvent maskActionEvent;
        long j4;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        MappingObject mappingObject = this.mNegativeMapping;
        MaskParam maskParam = this.mParam;
        MappingObject mappingObject2 = this.mCursorMapping;
        MappingObject mappingObject3 = this.mScreenMapping;
        MappingObject mappingObject4 = this.mPositiveMapping;
        MappingObject mappingObject5 = this.mPassMapping;
        MappingObject mappingObject6 = this.mFailMapping;
        String str15 = ((j & 268435969) == 0 || mappingObject == null) ? null : mappingObject.getStr();
        float f3 = 0.0f;
        if ((j & 289405970) != 0) {
            boolean isAuxOut = ((j & 268566530) == 0 || maskParam == null) ? false : maskParam.isAuxOut();
            if ((j & 268697602) != 0) {
                if (maskParam != null) {
                    z15 = isAuxOut;
                    j4 = maskParam.getOutPulse();
                } else {
                    z15 = isAuxOut;
                    j4 = 0;
                }
                str9 = UnitFormat.newBuilder(UnitFormat.SI.FEMTO).convert(j4) + ServiceEnum.Unit.Unit_s.value2;
            } else {
                z15 = isAuxOut;
                str9 = null;
            }
            if ((j & 268500994) != 0) {
                str10 = UnitFormat.newBuilder(UnitFormat.SI.MILLI).convert(maskParam != null ? maskParam.getXValue() : 0) + ServiceEnum.Unit.Unit_Div.value2;
            } else {
                str10 = null;
            }
            if ((j & 285216786) != 0) {
                int source = maskParam != null ? maskParam.getSource() : 0;
                i3 = (j & 268439554) != 0 ? ColorUtil.getColor(getRoot().getContext(), source) : 0;
                MappingObject mappingObject7 = ViewUtil.getArray(R.array.msg_mask_source).get(source);
                updateRegistration(4, mappingObject7);
                str11 = mappingObject7 != null ? mappingObject7.getStr() : null;
            } else {
                str11 = null;
                i3 = 0;
            }
            int i9 = ((j & 268438530) > 0L ? 1 : ((j & 268438530) == 0L ? 0 : -1));
            if (i9 != 0) {
                if (maskParam != null) {
                    boolean isOperate = maskParam.isOperate();
                    z18 = maskParam.isEnable();
                    z17 = isOperate;
                } else {
                    z17 = false;
                    z18 = false;
                }
                if (i9 != 0) {
                    j = z18 ? j | 4294967296L : j | 2147483648L;
                }
                z16 = z17;
                if ((j & 268438530) != 0) {
                    j |= z16 ? 17179869184L : 8589934592L;
                }
                j3 = 0;
                f2 = (j & 268436482) != 0 ? ContextUtil.getAlpha(z18) : 0.0f;
            } else {
                j3 = 0;
                f2 = 0.0f;
                z16 = false;
                z17 = false;
                z18 = false;
            }
            if ((j & 268959746) != j3) {
                if (maskParam != null) {
                    str5 = str11;
                    str12 = str10;
                    maskActionEvent = maskParam.getOutEvent();
                } else {
                    str12 = str10;
                    str5 = str11;
                    maskActionEvent = null;
                }
                boolean z32 = maskActionEvent == ServiceEnum.MaskActionEvent.mask_action_on_fail;
                z19 = maskActionEvent == ServiceEnum.MaskActionEvent.mask_action_on_pass;
                z20 = z32;
            } else {
                str12 = str10;
                str5 = str11;
                z19 = false;
                z20 = false;
            }
            if ((j & 270532610) != 0) {
                if (maskParam != null) {
                    i8 = maskParam.getErrAction();
                    z21 = z19;
                } else {
                    z21 = z19;
                    i8 = 0;
                }
                List<Integer> bitsFromValue = ViewUtil.getBitsFromValue(i8);
                z22 = z20;
                List<Integer> checkLengthIfNotEnoughThenAdd = ViewUtil.checkLengthIfNotEnoughThenAdd(bitsFromValue, 3);
                if (checkLengthIfNotEnoughThenAdd != null) {
                    num3 = checkLengthIfNotEnoughThenAdd.get(0);
                    num2 = checkLengthIfNotEnoughThenAdd.get(1);
                    num = checkLengthIfNotEnoughThenAdd.get(2);
                } else {
                    num = null;
                    num2 = null;
                    num3 = null;
                }
                int safeUnbox = ViewDataBinding.safeUnbox(num3);
                str13 = str9;
                int safeUnbox2 = ViewDataBinding.safeUnbox(num2);
                int safeUnbox3 = ViewDataBinding.safeUnbox(num);
                i4 = i3;
                z24 = safeUnbox == 1;
                z25 = safeUnbox2 == 1;
                z23 = safeUnbox3 == 1;
            } else {
                z21 = z19;
                z22 = z20;
                str13 = str9;
                i4 = i3;
                z23 = false;
                z24 = false;
                z25 = false;
            }
            if ((j & 269484034) != 0) {
                if (maskParam != null) {
                    maskPolarity = maskParam.getOutHl();
                    z26 = z23;
                } else {
                    z26 = z23;
                    maskPolarity = null;
                }
                z28 = maskPolarity == ServiceEnum.MaskPolarity.mask_polarity_positive;
                z27 = maskPolarity == ServiceEnum.MaskPolarity.mask_polarity_negative;
            } else {
                z26 = z23;
                z27 = false;
                z28 = false;
            }
            int i10 = ((j & 268443650) > 0L ? 1 : ((j & 268443650) == 0L ? 0 : -1));
            if (i10 != 0) {
                boolean minPop = maskParam != null ? maskParam.getMinPop() : false;
                if (i10 != 0) {
                    j |= minPop ? 68719476736L : 34359738368L;
                }
                if (minPop) {
                    i5 = 8;
                    if ((j & 268468226) == 0) {
                        if (maskParam != null) {
                            z29 = z27;
                            i7 = maskParam.getYValue();
                        } else {
                            z29 = z27;
                            i7 = 0;
                        }
                        z30 = z24;
                        z31 = z25;
                        i6 = i5;
                        str14 = UnitFormat.newBuilder(UnitFormat.SI.MILLI).convert(i7) + ServiceEnum.Unit.Unit_Div.value2;
                    } else {
                        z29 = z27;
                        z30 = z24;
                        z31 = z25;
                        i6 = i5;
                        str14 = null;
                    }
                    if ((268451842 & j) == 0) {
                        ServiceEnum.MaskRange range = maskParam != null ? maskParam.getRange() : null;
                        boolean z33 = range == ServiceEnum.MaskRange.mask_range_screen;
                        z10 = z22;
                        z11 = z21;
                        z4 = z26;
                        i2 = i4;
                        z13 = z28;
                        z12 = z29;
                        z3 = z30;
                        str = str15;
                        z = range == ServiceEnum.MaskRange.mask_range_user;
                        z9 = z33;
                        f = f2;
                        i = i6;
                        str4 = str13;
                    } else {
                        f = f2;
                        z10 = z22;
                        z11 = z21;
                        z4 = z26;
                        i2 = i4;
                        z13 = z28;
                        z12 = z29;
                        z3 = z30;
                        i = i6;
                        z9 = false;
                        str = str15;
                        str4 = str13;
                        z = false;
                    }
                    z7 = z17;
                    z6 = z16;
                    z5 = z18;
                    str3 = str12;
                    z8 = z15;
                    str2 = str14;
                    z2 = z31;
                }
            }
            i5 = 0;
            if ((j & 268468226) == 0) {
            }
            if ((268451842 & j) == 0) {
            }
            z7 = z17;
            z6 = z16;
            z5 = z18;
            str3 = str12;
            z8 = z15;
            str2 = str14;
            z2 = z31;
        } else {
            str = str15;
            f = 0.0f;
            z = false;
            z2 = false;
            i = 0;
            z3 = false;
            z4 = false;
            z5 = false;
            z6 = false;
            str2 = null;
            z7 = false;
            str3 = null;
            str4 = null;
            z8 = false;
            str5 = null;
            z9 = false;
            z10 = false;
            z11 = false;
            z12 = false;
            z13 = false;
            i2 = 0;
        }
        String str16 = ((j & 272629764) == 0 || mappingObject2 == null) ? null : mappingObject2.getStr();
        String str17 = ((j & 276824072) == 0 || mappingObject3 == null) ? null : mappingObject3.getStr();
        String str18 = ((j & 301989920) == 0 || mappingObject4 == null) ? null : mappingObject4.getStr();
        String str19 = ((j & 335544384) == 0 || mappingObject5 == null) ? null : mappingObject5.getStr();
        String str20 = ((j & 402653312) == 0 || mappingObject6 == null) ? null : mappingObject6.getStr();
        boolean z34 = (j & 4294967296L) != 0 ? !z7 : false;
        int i11 = ((j & 268438530) > 0L ? 1 : ((j & 268438530) == 0L ? 0 : -1));
        if (i11 != 0) {
            boolean z35 = z6 ? z5 : false;
            if (i11 != 0) {
                j |= z35 ? 1073741824L : 536870912L;
            }
            if (z35) {
                j2 = j;
                drawable2 = AppCompatResources.getDrawable(this.operateButton.getContext(), 17301539);
            } else {
                j2 = j;
                drawable2 = AppCompatResources.getDrawable(this.operateButton.getContext(), 17301540);
            }
            drawable = drawable2;
            j = j2;
        } else {
            drawable = null;
        }
        int i12 = ((j & 268438530) > 0L ? 1 : ((j & 268438530) == 0L ? 0 : -1));
        if (i12 != 0) {
            boolean z36 = z5 ? z34 : false;
            f3 = ContextUtil.getAlpha(z36);
            str6 = str17;
            z14 = z36;
        } else {
            str6 = str17;
            z14 = false;
        }
        float f4 = f3;
        String str21 = str18;
        if (i12 != 0) {
            str7 = str19;
            str8 = str20;
            if (getBuildSdkInt() >= 11) {
                this.buttonMaskCreateMenu.setAlpha(f4);
                this.buttonMaskLoad.setAlpha(f4);
                this.buttonMaskSave.setAlpha(f4);
                this.checkBoxMaskBeeper.setAlpha(f4);
                this.checkBoxMaskScreen.setAlpha(f4);
                this.checkBoxMaskStop.setAlpha(f4);
                this.imageButtonMaskXmaskLeft.setAlpha(f4);
                this.imageButtonMaskXmaskRight.setAlpha(f4);
                this.imageButtonMaskYmaskDown.setAlpha(f4);
                this.imageButtonMaskYmaskUP.setAlpha(f4);
                this.radioButtonMaskCursor.setAlpha(f4);
                this.radioButtonMaskFaile.setAlpha(f4);
                this.radioButtonMaskNegativePulse.setAlpha(f4);
                this.radioButtonMaskPass.setAlpha(f4);
                this.radioButtonMaskPositionPulse.setAlpha(f4);
                this.radioButtonMaskScreen.setAlpha(f4);
                this.source.setAlpha(f4);
                this.sourceSpinner.setAlpha(f4);
                this.switchButtonMaskOut.setAlpha(f4);
                this.textViewMaskErrAction.setAlpha(f4);
                this.textViewMaskOUt.setAlpha(f4);
                this.textViewMaskOutEvent.setAlpha(f4);
                this.textViewMaskOutHl.setAlpha(f4);
                this.textViewMaskOutPulse.setAlpha(f4);
                this.textViewMaskRange.setAlpha(f4);
                this.textViewMaskXmask.setAlpha(f4);
                this.textViewMaskYmask.setAlpha(f4);
                this.valueMaskOUtPulse.setAlpha(f4);
                this.valueMaskXmask.setAlpha(f4);
                this.valueMaskYmask.setAlpha(f4);
            }
            this.buttonMaskCreateMenu.setEnabled(z14);
            this.buttonMaskLoad.setEnabled(z14);
            this.buttonMaskSave.setEnabled(z14);
            this.checkBoxMaskBeeper.setEnabled(z14);
            this.checkBoxMaskScreen.setEnabled(z14);
            this.checkBoxMaskStop.setEnabled(z14);
            this.imageButtonMaskXmaskLeft.setEnabled(z14);
            this.imageButtonMaskXmaskRight.setEnabled(z14);
            this.imageButtonMaskYmaskDown.setEnabled(z14);
            this.imageButtonMaskYmaskUP.setEnabled(z14);
            ImageViewBindingAdapter.setImageDrawable(this.operateButton, drawable);
            this.radioButtonMaskCursor.setEnabled(z14);
            this.radioButtonMaskFaile.setEnabled(z14);
            this.radioButtonMaskNegativePulse.setEnabled(z14);
            this.radioButtonMaskPass.setEnabled(z14);
            this.radioButtonMaskPositionPulse.setEnabled(z14);
            this.radioButtonMaskScreen.setEnabled(z14);
            this.sourceSpinner.setEnabled(z14);
            this.switchButtonMaskOut.setEnabled(z14);
            this.valueMaskOUtPulse.setEnabled(z14);
            this.valueMaskXmask.setEnabled(z14);
            this.valueMaskYmask.setEnabled(z14);
        } else {
            str7 = str19;
            str8 = str20;
        }
        if ((j & 268443650) != 0) {
            this.buttonMaskCreateMenu.setVisibility(i);
            this.buttonMaskLoad.setVisibility(i);
            this.buttonMaskSave.setVisibility(i);
            this.checkBoxMaskBeeper.setVisibility(i);
            this.checkBoxMaskScreen.setVisibility(i);
            this.checkBoxMaskStop.setVisibility(i);
            this.dividingLine1.setVisibility(i);
            this.dividingLine2.setVisibility(i);
            this.imageButtonMaskXmaskLeft.setVisibility(i);
            this.imageButtonMaskXmaskRight.setVisibility(i);
            this.imageButtonMaskYmaskDown.setVisibility(i);
            this.imageButtonMaskYmaskUP.setVisibility(i);
            this.mask.setVisibility(i);
            this.radioButtonMaskCursor.setVisibility(i);
            this.radioButtonMaskFaile.setVisibility(i);
            this.radioButtonMaskNegativePulse.setVisibility(i);
            this.radioButtonMaskPass.setVisibility(i);
            this.radioButtonMaskPositionPulse.setVisibility(i);
            this.radioButtonMaskScreen.setVisibility(i);
            this.radioGroupMaskOutEvent.setVisibility(i);
            this.radioGroupMaskOutHl.setVisibility(i);
            this.switchButtonMaskOut.setVisibility(i);
            this.textViewMaskErrAction.setVisibility(i);
            this.textViewMaskOUt.setVisibility(i);
            this.textViewMaskOption.setVisibility(i);
            this.textViewMaskOutEvent.setVisibility(i);
            this.textViewMaskOutHl.setVisibility(i);
            this.textViewMaskOutPulse.setVisibility(i);
            this.textViewMaskXmask.setVisibility(i);
            this.textViewMaskYmask.setVisibility(i);
            this.valueMaskOUtPulse.setVisibility(i);
            this.valueMaskXmask.setVisibility(i);
            this.valueMaskYmask.setVisibility(i);
        }
        if ((j & 270532610) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.checkBoxMaskBeeper, z2);
            CompoundButtonBindingAdapter.setChecked(this.checkBoxMaskScreen, z4);
            CompoundButtonBindingAdapter.setChecked(this.checkBoxMaskStop, z3);
        }
        if ((268436482 & j) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.enableSwitch, z5);
            this.operateButton.setEnabled(z5);
            this.resetButton.setEnabled(z5);
            if (getBuildSdkInt() >= 11) {
                this.operate.setAlpha(f);
                this.operateButton.setAlpha(f);
                this.resetButton.setAlpha(f);
            }
        }
        if ((268451842 & j) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.radioButtonMaskCursor, z);
            CompoundButtonBindingAdapter.setChecked(this.radioButtonMaskScreen, z9);
        }
        if ((j & 272629764) != 0) {
            TextViewBindingAdapter.setText(this.radioButtonMaskCursor, str16);
        }
        if ((j & 268959746) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.radioButtonMaskFaile, z10);
            CompoundButtonBindingAdapter.setChecked(this.radioButtonMaskPass, z11);
        }
        if ((j & 402653312) != 0) {
            TextViewBindingAdapter.setText(this.radioButtonMaskFaile, str8);
        }
        if ((j & 269484034) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.radioButtonMaskNegativePulse, z12);
            CompoundButtonBindingAdapter.setChecked(this.radioButtonMaskPositionPulse, z13);
        }
        if ((268435969 & j) != 0) {
            TextViewBindingAdapter.setText(this.radioButtonMaskNegativePulse, str);
        }
        if ((j & 335544384) != 0) {
            TextViewBindingAdapter.setText(this.radioButtonMaskPass, str7);
        }
        if ((j & 301989920) != 0) {
            TextViewBindingAdapter.setText(this.radioButtonMaskPositionPulse, str21);
        }
        if ((j & 276824072) != 0) {
            TextViewBindingAdapter.setText(this.radioButtonMaskScreen, str6);
        }
        if ((j & 285216786) != 0) {
            TextViewBindingAdapter.setText(this.sourceSpinner, str5);
        }
        if ((j & 268439554) != 0) {
            this.sourceSpinner.setTextColor(i2);
        }
        if ((j & 268566530) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.switchButtonMaskOut, z8);
        }
        if ((j & 268697602) != 0) {
            TextViewBindingAdapter.setText(this.valueMaskOUtPulse, str4);
        }
        if ((j & 268500994) != 0) {
            TextViewBindingAdapter.setText(this.valueMaskXmask, str3);
        }
        if ((j & 268468226) != 0) {
            TextViewBindingAdapter.setText(this.valueMaskYmask, str2);
        }
    }
}
