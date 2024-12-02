package com.rigol.scope.databinding;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.CompoundButtonBindingAdapter;
import androidx.databinding.adapters.ImageViewBindingAdapter;
import androidx.databinding.adapters.SeekBarBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.databinding.adapters.ViewBindingAdapter;
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
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

/* loaded from: classes2.dex */
public class AdapterTriggerDurationBindingImpl extends AdapterTriggerDurationBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;
    private final TextView mboundView17;
    private final TextView mboundView19;
    private final TextView mboundView21;
    private final TextView mboundView23;
    private final TextView mboundView25;
    private final TextView mboundView27;
    private final TextView mboundView29;
    private final TextView mboundView31;
    private final TextView mboundView33;
    private final TextView mboundView35;
    private final TextView mboundView37;
    private final TextView mboundView39;
    private final TextView mboundView41;
    private final TextView mboundView43;
    private final TextView mboundView45;
    private final TextView mboundView47;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.guideline_left, 50);
        sViewsWithIds.put(R.id.guideline_center, 51);
        sViewsWithIds.put(R.id.guideline_right, 52);
        sViewsWithIds.put(R.id.guideline_forth, 53);
        sViewsWithIds.put(R.id.view_top, 54);
        sViewsWithIds.put(R.id.view_1, 55);
        sViewsWithIds.put(R.id.ch2, 56);
        sViewsWithIds.put(R.id.trigger_factor_label, 57);
        sViewsWithIds.put(R.id.trigger_source_label, 58);
        sViewsWithIds.put(R.id.ch4, 59);
        sViewsWithIds.put(R.id.ch3, 60);
        sViewsWithIds.put(R.id.key_all, 61);
        sViewsWithIds.put(R.id.key_next, 62);
        sViewsWithIds.put(R.id.key_return, 63);
        sViewsWithIds.put(R.id.key_x, 64);
        sViewsWithIds.put(R.id.key_one, 65);
        sViewsWithIds.put(R.id.button_level, 66);
        sViewsWithIds.put(R.id.trigger_level, 67);
        sViewsWithIds.put(R.id.imageView2, 68);
        sViewsWithIds.put(R.id.verticalSeekBarWrapper2, 69);
        sViewsWithIds.put(R.id.ch1, 70);
        sViewsWithIds.put(R.id.key_zero, 71);
        sViewsWithIds.put(R.id.trigger_holdoff_label, 72);
        sViewsWithIds.put(R.id.trigger_noise_label, 73);
        sViewsWithIds.put(R.id.view, 74);
        sViewsWithIds.put(R.id.view21, 75);
    }

    public AdapterTriggerDurationBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 76, sIncludes, sViewsWithIds));
    }

    private AdapterTriggerDurationBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 5, (Button) objArr[66], (TextView) objArr[70], (TextView) objArr[56], (TextView) objArr[60], (TextView) objArr[59], (RadioButton) objArr[3], (RadioButton) objArr[1], (RadioButton) objArr[4], (RadioButton) objArr[2], (Guideline) objArr[51], (Guideline) objArr[53], (Guideline) objArr[50], (Guideline) objArr[52], (ImageView) objArr[68], (ImageButton) objArr[61], (ImageButton) objArr[62], (ImageButton) objArr[65], (ImageButton) objArr[63], (ImageButton) objArr[64], (ImageButton) objArr[71], (TextView) objArr[6], (EditText) objArr[5], (TextView) objArr[8], (EditText) objArr[7], (TextView) objArr[57], (EditText) objArr[48], (TextView) objArr[72], (TextView) objArr[67], (EditText) objArr[10], (VerticalSeekBar) objArr[11], (TextView) objArr[73], (SwitchButton) objArr[49], (TextView) objArr[9], (TextView) objArr[58], (ImageButton) objArr[12], (ImageButton) objArr[13], (ImageButton) objArr[14], (ImageButton) objArr[15], (ImageButton) objArr[16], (ImageButton) objArr[18], (ImageButton) objArr[36], (ImageButton) objArr[38], (ImageButton) objArr[40], (ImageButton) objArr[42], (ImageButton) objArr[44], (ImageButton) objArr[46], (ImageButton) objArr[20], (ImageButton) objArr[22], (ImageButton) objArr[24], (ImageButton) objArr[26], (ImageButton) objArr[28], (ImageButton) objArr[30], (ImageButton) objArr[32], (ImageButton) objArr[34], (VerticalSeekBarWrapper) objArr[69], (View) objArr[74], (View) objArr[55], (View) objArr[75], (View) objArr[54]);
        this.mDirtyFlags = -1L;
        this.durationLessthan.setTag(null);
        this.durationMoreless.setTag(null);
        this.durationMorethan.setTag(null);
        this.durationUnmoreless.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView = (TextView) objArr[17];
        this.mboundView17 = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[19];
        this.mboundView19 = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) objArr[21];
        this.mboundView21 = textView3;
        textView3.setTag(null);
        TextView textView4 = (TextView) objArr[23];
        this.mboundView23 = textView4;
        textView4.setTag(null);
        TextView textView5 = (TextView) objArr[25];
        this.mboundView25 = textView5;
        textView5.setTag(null);
        TextView textView6 = (TextView) objArr[27];
        this.mboundView27 = textView6;
        textView6.setTag(null);
        TextView textView7 = (TextView) objArr[29];
        this.mboundView29 = textView7;
        textView7.setTag(null);
        TextView textView8 = (TextView) objArr[31];
        this.mboundView31 = textView8;
        textView8.setTag(null);
        TextView textView9 = (TextView) objArr[33];
        this.mboundView33 = textView9;
        textView9.setTag(null);
        TextView textView10 = (TextView) objArr[35];
        this.mboundView35 = textView10;
        textView10.setTag(null);
        TextView textView11 = (TextView) objArr[37];
        this.mboundView37 = textView11;
        textView11.setTag(null);
        TextView textView12 = (TextView) objArr[39];
        this.mboundView39 = textView12;
        textView12.setTag(null);
        TextView textView13 = (TextView) objArr[41];
        this.mboundView41 = textView13;
        textView13.setTag(null);
        TextView textView14 = (TextView) objArr[43];
        this.mboundView43 = textView14;
        textView14.setTag(null);
        TextView textView15 = (TextView) objArr[45];
        this.mboundView45 = textView15;
        textView15.setTag(null);
        TextView textView16 = (TextView) objArr[47];
        this.mboundView47 = textView16;
        textView16.setTag(null);
        this.triggerDurationLimitLow.setTag(null);
        this.triggerDurationLimitLowValues.setTag(null);
        this.triggerDurationLimitUp.setTag(null);
        this.triggerDurationLimitUpValues.setTag(null);
        this.triggerHoldoff.setTag(null);
        this.triggerLevelValue.setTag(null);
        this.triggerLevelView.setTag(null);
        this.triggerNoiseSwitch.setTag(null);
        this.triggerSource.setTag(null);
        this.valueCh1.setTag(null);
        this.valueCh2.setTag(null);
        this.valueCh3.setTag(null);
        this.valueCh4.setTag(null);
        this.valueD0.setTag(null);
        this.valueD1.setTag(null);
        this.valueD10.setTag(null);
        this.valueD11.setTag(null);
        this.valueD12.setTag(null);
        this.valueD13.setTag(null);
        this.valueD14.setTag(null);
        this.valueD15.setTag(null);
        this.valueD2.setTag(null);
        this.valueD3.setTag(null);
        this.valueD4.setTag(null);
        this.valueD5.setTag(null);
        this.valueD6.setTag(null);
        this.valueD7.setTag(null);
        this.valueD8.setTag(null);
        this.valueD9.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
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
        if (918 == i) {
            setSweepSingleMapping((MappingObject) obj);
        } else if (917 == i) {
            setSweepNormalMapping((MappingObject) obj);
        } else if (594 == i) {
            setParam((TriggerParam) obj);
        } else if (916 != i) {
            return false;
        } else {
            setSweepAutoMapping((MappingObject) obj);
        }
        return true;
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerDurationBinding
    public void setSweepSingleMapping(MappingObject mappingObject) {
        this.mSweepSingleMapping = mappingObject;
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerDurationBinding
    public void setSweepNormalMapping(MappingObject mappingObject) {
        this.mSweepNormalMapping = mappingObject;
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerDurationBinding
    public void setParam(TriggerParam triggerParam) {
        updateRegistration(3, triggerParam);
        this.mParam = triggerParam;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(594);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerDurationBinding
    public void setSweepAutoMapping(MappingObject mappingObject) {
        this.mSweepAutoMapping = mappingObject;
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
                        return onChangeSweepAutoMapping((MappingObject) obj, i2);
                    }
                    return onChangeParam((TriggerParam) obj, i2);
                }
                return onChangeSweepNormalMapping((MappingObject) obj, i2);
            }
            return onChangeSweepSingleMapping((MappingObject) obj, i2);
        }
        return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerSourceLaExtAcParamChanValue1((MappingObject) obj, i2);
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerSourceLaExtAcParamChanValue1(MappingObject mappingObject, int i) {
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

    private boolean onChangeSweepSingleMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeSweepNormalMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeParam(TriggerParam triggerParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        } else if (i == 256) {
            synchronized (this) {
                this.mDirtyFlags |= 192;
            }
            return true;
        } else if (i == 249) {
            synchronized (this) {
                this.mDirtyFlags |= 256;
            }
            return true;
        } else if (i == 251) {
            synchronized (this) {
                this.mDirtyFlags |= 512;
            }
            return true;
        } else if (i == 152) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 484) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
            }
            return true;
        } else if (i == 671) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
            }
            return true;
        } else if (i == 164) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            }
            return true;
        } else if (i == 377) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE;
            }
            return true;
        } else if (i == 448) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
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

    /* JADX WARN: Removed duplicated region for block: B:23:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:304:0x05be  */
    /* JADX WARN: Removed duplicated region for block: B:307:0x05ee  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:337:0x0643  */
    /* JADX WARN: Removed duplicated region for block: B:340:0x0657  */
    /* JADX WARN: Removed duplicated region for block: B:344:0x0677  */
    /* JADX WARN: Removed duplicated region for block: B:347:0x0686  */
    /* JADX WARN: Removed duplicated region for block: B:367:0x06b2  */
    /* JADX WARN: Removed duplicated region for block: B:375:0x06d5  */
    /* JADX WARN: Removed duplicated region for block: B:383:0x0824  */
    /* JADX WARN: Removed duplicated region for block: B:386:0x0859  */
    /* JADX WARN: Removed duplicated region for block: B:390:0x08e4  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void executeBindings() {
        long j;
        boolean z;
        boolean z2;
        boolean z3;
        int i;
        boolean z4;
        int i2;
        boolean z5;
        int i3;
        int i4;
        String str;
        String str2;
        String str3;
        String str4;
        Drawable drawable;
        Drawable drawable2;
        Drawable drawable3;
        Drawable drawable4;
        Drawable drawable5;
        Drawable drawable6;
        Drawable drawable7;
        Drawable drawable8;
        Drawable drawable9;
        Drawable drawable10;
        Drawable drawable11;
        Drawable drawable12;
        Drawable drawable13;
        Drawable drawable14;
        Drawable drawable15;
        Drawable drawable16;
        Drawable drawable17;
        Drawable drawable18;
        Drawable drawable19;
        String str5;
        Drawable drawable20;
        Drawable drawable21;
        Drawable drawable22;
        Drawable drawable23;
        Drawable drawable24;
        Drawable drawable25;
        Drawable drawable26;
        Drawable drawable27;
        Drawable drawable28;
        Drawable drawable29;
        Drawable drawable30;
        Drawable drawable31;
        Drawable drawable32;
        Drawable drawable33;
        Drawable drawable34;
        Drawable drawable35;
        Drawable drawable36;
        Drawable drawable37;
        Drawable drawable38;
        Drawable drawable39;
        Drawable drawable40;
        int i5;
        String str6;
        String str7;
        TriggerParam triggerParam;
        String str8;
        boolean z6;
        String str9;
        long j2;
        Drawable drawable41;
        String str10;
        Drawable drawable42;
        Drawable drawable43;
        Drawable drawable44;
        Drawable drawable45;
        Drawable drawable46;
        Drawable drawable47;
        Drawable drawable48;
        Drawable drawable49;
        Drawable drawable50;
        Drawable drawable51;
        Drawable drawable52;
        Drawable drawable53;
        Drawable drawable54;
        int i6;
        Drawable drawable55;
        Drawable drawable56;
        Drawable drawable57;
        Drawable drawable58;
        Drawable drawable59;
        Drawable drawable60;
        int i7;
        Drawable drawable61;
        String str11;
        Drawable drawable62;
        int i8;
        int i9;
        int i10;
        int i11;
        Drawable drawable63;
        String str12;
        String str13;
        boolean z7;
        boolean z8;
        long j3;
        boolean z9;
        boolean z10;
        int i12;
        Drawable drawable64;
        Drawable drawable65;
        Drawable drawable66;
        long j4;
        Drawable drawable67;
        Drawable drawable68;
        Drawable drawable69;
        Drawable drawable70;
        Drawable drawable71;
        Drawable drawable72;
        Drawable drawable73;
        Drawable drawable74;
        Drawable drawable75;
        Drawable drawable76;
        Drawable drawable77;
        Drawable drawable78;
        Drawable drawable79;
        Drawable drawable80;
        Drawable drawable81;
        Drawable drawable82;
        Drawable drawable83;
        long j5;
        long j6;
        ServiceEnum.TriggerPattern[] triggerPatternArr;
        ServiceEnum.TriggerPattern triggerPattern;
        ServiceEnum.TriggerPattern triggerPattern2;
        ServiceEnum.TriggerPattern triggerPattern3;
        ServiceEnum.TriggerPattern triggerPattern4;
        ServiceEnum.TriggerPattern triggerPattern5;
        ServiceEnum.TriggerPattern triggerPattern6;
        ServiceEnum.TriggerPattern triggerPattern7;
        ServiceEnum.TriggerPattern triggerPattern8;
        ServiceEnum.TriggerPattern triggerPattern9;
        ServiceEnum.TriggerPattern triggerPattern10;
        ServiceEnum.TriggerPattern triggerPattern11;
        ServiceEnum.TriggerPattern triggerPattern12;
        ServiceEnum.TriggerPattern triggerPattern13;
        ServiceEnum.TriggerPattern triggerPattern14;
        ServiceEnum.TriggerPattern triggerPattern15;
        ServiceEnum.TriggerPattern triggerPattern16;
        ServiceEnum.TriggerPattern triggerPattern17;
        ServiceEnum.TriggerPattern triggerPattern18;
        ServiceEnum.TriggerPattern triggerPattern19;
        ServiceEnum.TriggerPattern triggerPattern20;
        long j7;
        ServiceEnum.EMoreThan eMoreThan;
        Drawable drawable84;
        Drawable drawable85;
        Drawable drawable86;
        Drawable drawable87;
        Drawable drawable88;
        Drawable drawable89;
        Drawable drawable90;
        int i13;
        long j8;
        int i14;
        Drawable drawable91;
        Drawable drawable92;
        Drawable drawable93;
        Drawable drawable94;
        Drawable drawable95;
        Drawable drawable96;
        Drawable drawable97;
        int i15;
        Drawable drawable98;
        Context context;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        TriggerParam triggerParam2 = this.mParam;
        if ((131049 & j) != 0) {
            if ((j & 67592) != 0) {
                long level = triggerParam2 != null ? triggerParam2.getLevel() : 0L;
                if (triggerParam2 != null) {
                    str6 = triggerParam2.getTriggerLevelStr(level);
                    boolean isNoise = ((j & 98312) != 0 || triggerParam2 == null) ? false : triggerParam2.getIsNoise();
                    if ((j & 66056) == 0) {
                        str7 = UnitFormat.newBuilder(UnitFormat.SI.FEMTO).convert(triggerParam2 != null ? triggerParam2.getDurationUperLimit() : 0L, ServiceEnum.Unit.Unit_s);
                    } else {
                        str7 = null;
                    }
                    if ((j & 66601) == 0) {
                        ServiceEnum.Chan chan = triggerParam2 != null ? triggerParam2.getChan() : null;
                        int i16 = ((j & 66568) > 0L ? 1 : ((j & 66568) == 0L ? 0 : -1));
                        if (i16 != 0) {
                            boolean z11 = chan == ServiceEnum.Chan.chan1;
                            boolean z12 = chan == ServiceEnum.Chan.d10;
                            boolean z13 = chan == ServiceEnum.Chan.d5;
                            boolean z14 = chan == ServiceEnum.Chan.d13;
                            boolean z15 = chan == ServiceEnum.Chan.d9;
                            boolean z16 = chan == ServiceEnum.Chan.d2;
                            str8 = str6;
                            boolean z17 = chan == ServiceEnum.Chan.chan2;
                            z6 = isNoise;
                            boolean z18 = chan == ServiceEnum.Chan.d11;
                            str9 = str7;
                            boolean z19 = chan == ServiceEnum.Chan.d6;
                            triggerParam = triggerParam2;
                            boolean z20 = chan == ServiceEnum.Chan.d1;
                            boolean z21 = chan == ServiceEnum.Chan.d3;
                            boolean z22 = chan == ServiceEnum.Chan.d12;
                            boolean z23 = chan == ServiceEnum.Chan.d7;
                            i6 = ColorUtil.getColor(getRoot().getContext(), chan);
                            boolean z24 = chan == ServiceEnum.Chan.chan3;
                            boolean z25 = chan == ServiceEnum.Chan.d0;
                            boolean z26 = chan == ServiceEnum.Chan.d15;
                            boolean z27 = chan == ServiceEnum.Chan.d4;
                            boolean z28 = chan == ServiceEnum.Chan.d14;
                            boolean z29 = chan == ServiceEnum.Chan.d8;
                            boolean z30 = chan == ServiceEnum.Chan.chan4;
                            if (i16 != 0) {
                                j |= z11 ? 67108864L : 33554432L;
                            }
                            if ((j & 66568) != 0) {
                                j |= z12 ? PlaybackStateCompat.ACTION_SET_REPEAT_MODE : PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
                            }
                            if ((j & 66568) != 0) {
                                j |= z13 ? 72057594037927936L : 36028797018963968L;
                            }
                            if ((j & 66568) != 0) {
                                j |= z14 ? 274877906944L : 137438953472L;
                            }
                            if ((j & 66568) != 0) {
                                j |= z15 ? 4503599627370496L : 2251799813685248L;
                            }
                            if ((j & 66568) != 0) {
                                j |= z16 ? 1099511627776L : 549755813888L;
                            }
                            if ((j & 66568) != 0) {
                                j |= z17 ? 68719476736L : 34359738368L;
                            }
                            if ((j & 66568) != 0) {
                                j |= z18 ? 17179869184L : 8589934592L;
                            }
                            if ((j & 66568) != 0) {
                                j |= z19 ? LockFreeTaskQueueCore.FROZEN_MASK : 576460752303423488L;
                            }
                            if ((j & 66568) != 0) {
                                j |= z20 ? 70368744177664L : 35184372088832L;
                            }
                            if ((j & 66568) != 0) {
                                j |= z21 ? 288230376151711744L : 144115188075855872L;
                            }
                            if ((j & 66568) != 0) {
                                j |= z22 ? 281474976710656L : 140737488355328L;
                            }
                            if ((j & 66568) != 0) {
                                j |= z23 ? 1125899906842624L : 562949953421312L;
                            }
                            if ((j & 66568) != 0) {
                                j |= z24 ? 17592186044416L : 8796093022208L;
                            }
                            if ((j & 66568) != 0) {
                                j |= z25 ? 268435456L : 134217728L;
                            }
                            if ((j & 66568) != 0) {
                                j |= z26 ? 4398046511104L : 2199023255552L;
                            }
                            if ((j & 66568) != 0) {
                                j |= z27 ? 4611686018427387904L : LockFreeTaskQueueCore.CLOSED_MASK;
                            }
                            if ((j & 66568) != 0) {
                                j |= z28 ? PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED : PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
                            }
                            if ((j & 66568) != 0) {
                                j |= z29 ? 18014398509481984L : 9007199254740992L;
                            }
                            if ((j & 66568) != 0) {
                                j |= z30 ? 4194304L : PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
                            }
                            Drawable drawable99 = z11 ? AppCompatResources.getDrawable(this.valueCh1.getContext(), R.drawable.bg_rectangle_selected) : AppCompatResources.getDrawable(this.valueCh1.getContext(), R.drawable.bg_rectangle_normal);
                            Drawable drawable100 = z12 ? AppCompatResources.getDrawable(this.valueD10.getContext(), R.drawable.bg_rectangle_selected) : AppCompatResources.getDrawable(this.valueD10.getContext(), R.drawable.bg_rectangle_normal);
                            Drawable drawable101 = z13 ? AppCompatResources.getDrawable(this.valueD5.getContext(), R.drawable.bg_rectangle_selected) : AppCompatResources.getDrawable(this.valueD5.getContext(), R.drawable.bg_rectangle_normal);
                            Drawable drawable102 = z14 ? AppCompatResources.getDrawable(this.valueD13.getContext(), R.drawable.bg_rectangle_selected) : AppCompatResources.getDrawable(this.valueD13.getContext(), R.drawable.bg_rectangle_normal);
                            Drawable drawable103 = z15 ? AppCompatResources.getDrawable(this.valueD9.getContext(), R.drawable.bg_rectangle_selected) : AppCompatResources.getDrawable(this.valueD9.getContext(), R.drawable.bg_rectangle_normal);
                            Drawable drawable104 = z16 ? AppCompatResources.getDrawable(this.valueD2.getContext(), R.drawable.bg_rectangle_selected) : AppCompatResources.getDrawable(this.valueD2.getContext(), R.drawable.bg_rectangle_normal);
                            Drawable drawable105 = z17 ? AppCompatResources.getDrawable(this.valueCh2.getContext(), R.drawable.bg_rectangle_selected) : AppCompatResources.getDrawable(this.valueCh2.getContext(), R.drawable.bg_rectangle_normal);
                            Drawable drawable106 = z18 ? AppCompatResources.getDrawable(this.valueD11.getContext(), R.drawable.bg_rectangle_selected) : AppCompatResources.getDrawable(this.valueD11.getContext(), R.drawable.bg_rectangle_normal);
                            Drawable drawable107 = z19 ? AppCompatResources.getDrawable(this.valueD6.getContext(), R.drawable.bg_rectangle_selected) : AppCompatResources.getDrawable(this.valueD6.getContext(), R.drawable.bg_rectangle_normal);
                            Drawable drawable108 = z20 ? AppCompatResources.getDrawable(this.valueD1.getContext(), R.drawable.bg_rectangle_selected) : AppCompatResources.getDrawable(this.valueD1.getContext(), R.drawable.bg_rectangle_normal);
                            if (z21) {
                                Context context2 = this.valueD3.getContext();
                                j8 = j;
                                i14 = R.drawable.bg_rectangle_selected;
                                drawable91 = AppCompatResources.getDrawable(context2, R.drawable.bg_rectangle_selected);
                            } else {
                                j8 = j;
                                i14 = R.drawable.bg_rectangle_selected;
                                drawable91 = AppCompatResources.getDrawable(this.valueD3.getContext(), R.drawable.bg_rectangle_normal);
                            }
                            Context context3 = this.valueD12.getContext();
                            Drawable drawable109 = z22 ? AppCompatResources.getDrawable(context3, i14) : AppCompatResources.getDrawable(context3, R.drawable.bg_rectangle_normal);
                            if (z23) {
                                drawable53 = drawable91;
                                drawable92 = AppCompatResources.getDrawable(this.valueD7.getContext(), R.drawable.bg_rectangle_selected);
                            } else {
                                drawable53 = drawable91;
                                drawable92 = AppCompatResources.getDrawable(this.valueD7.getContext(), R.drawable.bg_rectangle_normal);
                            }
                            if (z24) {
                                drawable54 = drawable92;
                                drawable93 = AppCompatResources.getDrawable(this.valueCh3.getContext(), R.drawable.bg_rectangle_selected);
                            } else {
                                drawable54 = drawable92;
                                drawable93 = AppCompatResources.getDrawable(this.valueCh3.getContext(), R.drawable.bg_rectangle_normal);
                            }
                            if (z25) {
                                drawable55 = drawable93;
                                drawable94 = AppCompatResources.getDrawable(this.valueD0.getContext(), R.drawable.bg_rectangle_selected);
                            } else {
                                drawable55 = drawable93;
                                drawable94 = AppCompatResources.getDrawable(this.valueD0.getContext(), R.drawable.bg_rectangle_normal);
                            }
                            if (z26) {
                                drawable56 = drawable94;
                                drawable95 = AppCompatResources.getDrawable(this.valueD15.getContext(), R.drawable.bg_rectangle_selected);
                            } else {
                                drawable56 = drawable94;
                                drawable95 = AppCompatResources.getDrawable(this.valueD15.getContext(), R.drawable.bg_rectangle_normal);
                            }
                            if (z27) {
                                drawable57 = drawable95;
                                drawable96 = AppCompatResources.getDrawable(this.valueD4.getContext(), R.drawable.bg_rectangle_selected);
                            } else {
                                drawable57 = drawable95;
                                drawable96 = AppCompatResources.getDrawable(this.valueD4.getContext(), R.drawable.bg_rectangle_normal);
                            }
                            if (z28) {
                                drawable58 = drawable96;
                                drawable97 = AppCompatResources.getDrawable(this.valueD14.getContext(), R.drawable.bg_rectangle_selected);
                            } else {
                                drawable58 = drawable96;
                                drawable97 = AppCompatResources.getDrawable(this.valueD14.getContext(), R.drawable.bg_rectangle_normal);
                            }
                            if (z29) {
                                drawable59 = drawable97;
                                drawable98 = AppCompatResources.getDrawable(this.valueD8.getContext(), R.drawable.bg_rectangle_selected);
                                i15 = R.drawable.bg_rectangle_normal;
                            } else {
                                drawable59 = drawable97;
                                Context context4 = this.valueD8.getContext();
                                i15 = R.drawable.bg_rectangle_normal;
                                drawable98 = AppCompatResources.getDrawable(context4, R.drawable.bg_rectangle_normal);
                            }
                            if (z30) {
                                context = this.valueCh4.getContext();
                                i15 = R.drawable.bg_rectangle_selected;
                            } else {
                                context = this.valueCh4.getContext();
                            }
                            drawable84 = AppCompatResources.getDrawable(context, i15);
                            drawable60 = drawable99;
                            drawable52 = drawable103;
                            drawable51 = drawable109;
                            drawable50 = drawable102;
                            drawable49 = drawable101;
                            drawable48 = drawable100;
                            drawable47 = drawable108;
                            drawable89 = drawable107;
                            drawable88 = drawable106;
                            drawable87 = drawable105;
                            drawable86 = drawable104;
                            drawable85 = drawable98;
                            j = j8;
                        } else {
                            triggerParam = triggerParam2;
                            str8 = str6;
                            z6 = isNoise;
                            str9 = str7;
                            drawable84 = null;
                            drawable85 = null;
                            drawable86 = null;
                            drawable87 = null;
                            drawable88 = null;
                            drawable89 = null;
                            drawable47 = null;
                            drawable48 = null;
                            drawable49 = null;
                            drawable50 = null;
                            drawable51 = null;
                            drawable52 = null;
                            drawable53 = null;
                            drawable54 = null;
                            i6 = 0;
                            drawable55 = null;
                            drawable56 = null;
                            drawable57 = null;
                            drawable58 = null;
                            drawable59 = null;
                            drawable60 = null;
                        }
                        if (chan != null) {
                            i13 = chan.value1;
                            drawable90 = drawable84;
                        } else {
                            drawable90 = drawable84;
                            i13 = 0;
                        }
                        MappingObject mappingObject = ViewUtil.getMappingObject(R.array.msg_trigger_source_la_ext_ac, i13);
                        updateRegistration(0, mappingObject);
                        if (mappingObject != null) {
                            drawable46 = drawable89;
                            drawable45 = drawable88;
                            drawable44 = drawable87;
                            drawable43 = drawable86;
                            drawable42 = drawable85;
                            j2 = j;
                            str10 = mappingObject.getStr();
                            drawable41 = drawable90;
                        } else {
                            drawable46 = drawable89;
                            drawable41 = drawable90;
                            drawable45 = drawable88;
                            drawable44 = drawable87;
                            drawable43 = drawable86;
                            drawable42 = drawable85;
                            j2 = j;
                            str10 = null;
                        }
                    } else {
                        triggerParam = triggerParam2;
                        str8 = str6;
                        z6 = isNoise;
                        str9 = str7;
                        j2 = j;
                        drawable41 = null;
                        str10 = null;
                        drawable42 = null;
                        drawable43 = null;
                        drawable44 = null;
                        drawable45 = null;
                        drawable46 = null;
                        drawable47 = null;
                        drawable48 = null;
                        drawable49 = null;
                        drawable50 = null;
                        drawable51 = null;
                        drawable52 = null;
                        drawable53 = null;
                        drawable54 = null;
                        i6 = 0;
                        drawable55 = null;
                        drawable56 = null;
                        drawable57 = null;
                        drawable58 = null;
                        drawable59 = null;
                        drawable60 = null;
                    }
                    i7 = ((j2 & 65672) > 0L ? 1 : ((j2 & 65672) == 0L ? 0 : -1));
                    if (i7 == 0) {
                        if (triggerParam != null) {
                            str11 = str10;
                            drawable61 = drawable41;
                            eMoreThan = triggerParam.getEMoreThan();
                        } else {
                            drawable61 = drawable41;
                            str11 = str10;
                            eMoreThan = null;
                        }
                        drawable62 = drawable42;
                        boolean z31 = eMoreThan == ServiceEnum.EMoreThan.Trigger_When_Lessthan;
                        boolean z32 = eMoreThan == ServiceEnum.EMoreThan.Trigger_When_Morethan;
                        if (i7 != 0) {
                            j2 |= z31 ? 1073741824L : 536870912L;
                        }
                        if ((j2 & 65672) != 0) {
                            j2 |= z32 ? 4294967296L : 2147483648L;
                        }
                        int i17 = z31 ? 4 : 0;
                        i9 = z32 ? 4 : 0;
                        i8 = i17;
                        j = j2;
                    } else {
                        drawable61 = drawable41;
                        str11 = str10;
                        drawable62 = drawable42;
                        j = j2;
                        i8 = 0;
                        i9 = 0;
                    }
                    if ((j & 81928) == 0) {
                        if (triggerParam != null) {
                            i11 = i9;
                            j7 = triggerParam.getHoldOff();
                        } else {
                            i11 = i9;
                            j7 = 0;
                        }
                        i10 = i8;
                        drawable63 = drawable43;
                        str12 = UnitFormat.newBuilder(UnitFormat.SI.FEMTO).convert(j7, ServiceEnum.Unit.Unit_s);
                    } else {
                        i10 = i8;
                        i11 = i9;
                        drawable63 = drawable43;
                        str12 = null;
                    }
                    if ((j & 65608) == 0) {
                        ServiceEnum.EMoreThan eMoreThan2 = triggerParam != null ? triggerParam.getEMoreThan() : null;
                        z3 = eMoreThan2 == ServiceEnum.EMoreThan.Trigger_When_UnMoreLess;
                        str13 = str12;
                        z8 = eMoreThan2 == ServiceEnum.EMoreThan.Trigger_When_Morethan;
                        z9 = eMoreThan2 == ServiceEnum.EMoreThan.Trigger_When_Lessthan;
                        z7 = eMoreThan2 == ServiceEnum.EMoreThan.Trigger_When_MoreLess;
                        j3 = 69640;
                    } else {
                        str13 = str12;
                        z7 = false;
                        z3 = false;
                        z8 = false;
                        j3 = 69640;
                        z9 = false;
                    }
                    int progress = ((j & j3) != 0 || triggerParam == null) ? 0 : triggerParam.getProgress();
                    if ((j & 73736) == 0) {
                        if (triggerParam != null) {
                            z10 = z7;
                            triggerPatternArr = triggerParam.getChanDurationPattern();
                        } else {
                            z10 = z7;
                            triggerPatternArr = null;
                        }
                        i12 = progress;
                        if (triggerPatternArr != null) {
                            ServiceEnum.TriggerPattern triggerPattern21 = (ServiceEnum.TriggerPattern) getFromArray(triggerPatternArr, 12);
                            triggerPattern6 = (ServiceEnum.TriggerPattern) getFromArray(triggerPatternArr, 9);
                            triggerPattern7 = (ServiceEnum.TriggerPattern) getFromArray(triggerPatternArr, 18);
                            triggerPattern4 = (ServiceEnum.TriggerPattern) getFromArray(triggerPatternArr, 8);
                            triggerPattern8 = (ServiceEnum.TriggerPattern) getFromArray(triggerPatternArr, 13);
                            triggerPattern9 = (ServiceEnum.TriggerPattern) getFromArray(triggerPatternArr, 3);
                            triggerPattern10 = (ServiceEnum.TriggerPattern) getFromArray(triggerPatternArr, 2);
                            triggerPattern11 = (ServiceEnum.TriggerPattern) getFromArray(triggerPatternArr, 19);
                            triggerPattern12 = (ServiceEnum.TriggerPattern) getFromArray(triggerPatternArr, 20);
                            triggerPattern3 = (ServiceEnum.TriggerPattern) getFromArray(triggerPatternArr, 1);
                            triggerPattern13 = (ServiceEnum.TriggerPattern) getFromArray(triggerPatternArr, 14);
                            triggerPattern14 = (ServiceEnum.TriggerPattern) getFromArray(triggerPatternArr, 21);
                            triggerPattern15 = (ServiceEnum.TriggerPattern) getFromArray(triggerPatternArr, 15);
                            triggerPattern16 = (ServiceEnum.TriggerPattern) getFromArray(triggerPatternArr, 10);
                            triggerPattern5 = (ServiceEnum.TriggerPattern) getFromArray(triggerPatternArr, 0);
                            triggerPattern17 = (ServiceEnum.TriggerPattern) getFromArray(triggerPatternArr, 16);
                            triggerPattern18 = (ServiceEnum.TriggerPattern) getFromArray(triggerPatternArr, 11);
                            triggerPattern19 = (ServiceEnum.TriggerPattern) getFromArray(triggerPatternArr, 22);
                            triggerPattern20 = (ServiceEnum.TriggerPattern) getFromArray(triggerPatternArr, 23);
                            triggerPattern = (ServiceEnum.TriggerPattern) getFromArray(triggerPatternArr, 17);
                            triggerPattern2 = triggerPattern21;
                        } else {
                            triggerPattern = null;
                            triggerPattern2 = null;
                            triggerPattern3 = null;
                            triggerPattern4 = null;
                            triggerPattern5 = null;
                            triggerPattern6 = null;
                            triggerPattern7 = null;
                            triggerPattern8 = null;
                            triggerPattern9 = null;
                            triggerPattern10 = null;
                            triggerPattern11 = null;
                            triggerPattern12 = null;
                            triggerPattern13 = null;
                            triggerPattern14 = null;
                            triggerPattern15 = null;
                            triggerPattern16 = null;
                            triggerPattern17 = null;
                            triggerPattern18 = null;
                            triggerPattern19 = null;
                            triggerPattern20 = null;
                        }
                        drawable65 = ViewUtil.getTriggerDurationPatternPic(triggerPattern2);
                        drawable69 = ViewUtil.getTriggerDurationPatternPic(triggerPattern6);
                        drawable70 = ViewUtil.getTriggerDurationPatternPic(triggerPattern7);
                        drawable67 = ViewUtil.getTriggerDurationPatternPic(triggerPattern4);
                        drawable71 = ViewUtil.getTriggerDurationPatternPic(triggerPattern8);
                        drawable72 = ViewUtil.getTriggerDurationPatternPic(triggerPattern9);
                        drawable73 = ViewUtil.getTriggerDurationPatternPic(triggerPattern10);
                        drawable74 = ViewUtil.getTriggerDurationPatternPic(triggerPattern11);
                        drawable75 = ViewUtil.getTriggerDurationPatternPic(triggerPattern12);
                        drawable66 = ViewUtil.getTriggerDurationPatternPic(triggerPattern3);
                        drawable76 = ViewUtil.getTriggerDurationPatternPic(triggerPattern13);
                        drawable77 = ViewUtil.getTriggerDurationPatternPic(triggerPattern14);
                        drawable78 = ViewUtil.getTriggerDurationPatternPic(triggerPattern15);
                        drawable79 = ViewUtil.getTriggerDurationPatternPic(triggerPattern16);
                        drawable68 = ViewUtil.getTriggerDurationPatternPic(triggerPattern5);
                        drawable80 = ViewUtil.getTriggerDurationPatternPic(triggerPattern17);
                        drawable81 = ViewUtil.getTriggerDurationPatternPic(triggerPattern18);
                        drawable82 = ViewUtil.getTriggerDurationPatternPic(triggerPattern19);
                        drawable83 = ViewUtil.getTriggerDurationPatternPic(triggerPattern20);
                        drawable64 = ViewUtil.getTriggerDurationPatternPic(triggerPattern);
                        j4 = 65800;
                    } else {
                        z10 = z7;
                        i12 = progress;
                        drawable64 = null;
                        drawable65 = null;
                        drawable66 = null;
                        j4 = 65800;
                        drawable67 = null;
                        drawable68 = null;
                        drawable69 = null;
                        drawable70 = null;
                        drawable71 = null;
                        drawable72 = null;
                        drawable73 = null;
                        drawable74 = null;
                        drawable75 = null;
                        drawable76 = null;
                        drawable77 = null;
                        drawable78 = null;
                        drawable79 = null;
                        drawable80 = null;
                        drawable81 = null;
                        drawable82 = null;
                        drawable83 = null;
                    }
                    if ((j & j4) == 0) {
                        if (triggerParam != null) {
                            long j9 = j;
                            j6 = triggerParam.getDurationLowerLimit();
                            j5 = j9;
                        } else {
                            j5 = j;
                            j6 = 0;
                        }
                        Drawable drawable110 = drawable64;
                        Drawable drawable111 = drawable65;
                        String convert = UnitFormat.newBuilder(UnitFormat.SI.FEMTO).convert(j6, ServiceEnum.Unit.Unit_s);
                        drawable22 = drawable44;
                        drawable21 = drawable45;
                        drawable38 = drawable46;
                        drawable31 = drawable47;
                        drawable36 = drawable49;
                        drawable24 = drawable50;
                        drawable32 = drawable51;
                        drawable34 = drawable52;
                        drawable39 = drawable66;
                        drawable14 = drawable67;
                        drawable20 = drawable68;
                        str3 = str8;
                        z4 = z6;
                        str2 = str9;
                        drawable8 = drawable110;
                        drawable37 = drawable53;
                        drawable33 = drawable54;
                        i3 = i6;
                        drawable28 = drawable55;
                        drawable18 = drawable56;
                        drawable27 = drawable57;
                        drawable40 = drawable58;
                        drawable4 = drawable59;
                        drawable7 = drawable60;
                        i2 = i11;
                        drawable6 = drawable61;
                        str5 = str11;
                        drawable35 = drawable62;
                        drawable25 = drawable63;
                        str = str13;
                        z2 = z10;
                        drawable2 = drawable69;
                        drawable10 = drawable70;
                        drawable12 = drawable71;
                        drawable3 = drawable72;
                        drawable29 = drawable73;
                        drawable26 = drawable74;
                        drawable17 = drawable75;
                        drawable13 = drawable76;
                        drawable15 = drawable77;
                        drawable16 = drawable78;
                        drawable30 = drawable79;
                        drawable11 = drawable80;
                        drawable9 = drawable81;
                        drawable19 = drawable82;
                        drawable23 = drawable83;
                        j = j5;
                        drawable = drawable111;
                        str4 = convert;
                        z5 = z8;
                        drawable5 = drawable48;
                        i = i10;
                        z = z9;
                    } else {
                        Drawable drawable112 = drawable65;
                        drawable22 = drawable44;
                        drawable21 = drawable45;
                        drawable38 = drawable46;
                        drawable31 = drawable47;
                        drawable36 = drawable49;
                        drawable24 = drawable50;
                        drawable32 = drawable51;
                        drawable34 = drawable52;
                        drawable39 = drawable66;
                        drawable14 = drawable67;
                        drawable20 = drawable68;
                        str3 = str8;
                        z4 = z6;
                        str2 = str9;
                        drawable8 = drawable64;
                        drawable37 = drawable53;
                        drawable33 = drawable54;
                        i3 = i6;
                        drawable28 = drawable55;
                        drawable18 = drawable56;
                        drawable27 = drawable57;
                        drawable40 = drawable58;
                        drawable4 = drawable59;
                        drawable7 = drawable60;
                        i2 = i11;
                        drawable6 = drawable61;
                        str5 = str11;
                        drawable35 = drawable62;
                        drawable25 = drawable63;
                        str = str13;
                        z = z9;
                        z2 = z10;
                        drawable2 = drawable69;
                        drawable10 = drawable70;
                        drawable12 = drawable71;
                        drawable3 = drawable72;
                        drawable29 = drawable73;
                        drawable26 = drawable74;
                        drawable17 = drawable75;
                        drawable13 = drawable76;
                        drawable15 = drawable77;
                        drawable16 = drawable78;
                        drawable30 = drawable79;
                        drawable11 = drawable80;
                        drawable9 = drawable81;
                        drawable19 = drawable82;
                        drawable23 = drawable83;
                        drawable = drawable112;
                        str4 = null;
                        z5 = z8;
                        drawable5 = drawable48;
                        i = i10;
                    }
                    i4 = i12;
                }
            }
            str6 = null;
            if ((j & 98312) != 0) {
            }
            if ((j & 66056) == 0) {
            }
            if ((j & 66601) == 0) {
            }
            i7 = ((j2 & 65672) > 0L ? 1 : ((j2 & 65672) == 0L ? 0 : -1));
            if (i7 == 0) {
            }
            if ((j & 81928) == 0) {
            }
            if ((j & 65608) == 0) {
            }
            if ((j & j3) != 0) {
            }
            if ((j & 73736) == 0) {
            }
            if ((j & j4) == 0) {
            }
            i4 = i12;
        } else {
            z = false;
            z2 = false;
            z3 = false;
            i = 0;
            z4 = false;
            i2 = 0;
            z5 = false;
            i3 = 0;
            i4 = 0;
            str = null;
            str2 = null;
            str3 = null;
            str4 = null;
            drawable = null;
            drawable2 = null;
            drawable3 = null;
            drawable4 = null;
            drawable5 = null;
            drawable6 = null;
            drawable7 = null;
            drawable8 = null;
            drawable9 = null;
            drawable10 = null;
            drawable11 = null;
            drawable12 = null;
            drawable13 = null;
            drawable14 = null;
            drawable15 = null;
            drawable16 = null;
            drawable17 = null;
            drawable18 = null;
            drawable19 = null;
            str5 = null;
            drawable20 = null;
            drawable21 = null;
            drawable22 = null;
            drawable23 = null;
            drawable24 = null;
            drawable25 = null;
            drawable26 = null;
            drawable27 = null;
            drawable28 = null;
            drawable29 = null;
            drawable30 = null;
            drawable31 = null;
            drawable32 = null;
            drawable33 = null;
            drawable34 = null;
            drawable35 = null;
            drawable36 = null;
            drawable37 = null;
            drawable38 = null;
            drawable39 = null;
            drawable40 = null;
        }
        int i18 = ((j & PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) > 0L ? 1 : ((j & PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) == 0L ? 0 : -1));
        if (i18 != 0 && i18 != 0) {
            j |= ViewUtil.isDoubleChan() ? 16777216L : 8388608L;
        }
        if ((j & 65608) != 0) {
            i5 = i3;
            CompoundButtonBindingAdapter.setChecked(this.durationLessthan, z);
            CompoundButtonBindingAdapter.setChecked(this.durationMoreless, z2);
            CompoundButtonBindingAdapter.setChecked(this.durationMorethan, z5);
            CompoundButtonBindingAdapter.setChecked(this.durationUnmoreless, z3);
        } else {
            i5 = i3;
        }
        if ((j & PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) != 0) {
            this.mboundView17.setVisibility(ViewUtil.isDoubleChan() ? 8 : 0);
            this.mboundView19.setVisibility(ViewUtil.isDoubleChan() ? 8 : 0);
            this.mboundView21.setVisibility(ViewUtil.isDoubleChan() ? 8 : 0);
            this.mboundView23.setVisibility(ViewUtil.isDoubleChan() ? 8 : 0);
            this.mboundView25.setVisibility(ViewUtil.isDoubleChan() ? 8 : 0);
            this.mboundView27.setVisibility(ViewUtil.isDoubleChan() ? 8 : 0);
            this.mboundView29.setVisibility(ViewUtil.isDoubleChan() ? 8 : 0);
            this.mboundView31.setVisibility(ViewUtil.isDoubleChan() ? 8 : 0);
            this.mboundView33.setVisibility(ViewUtil.isDoubleChan() ? 8 : 0);
            this.mboundView35.setVisibility(ViewUtil.isDoubleChan() ? 8 : 0);
            this.mboundView37.setVisibility(ViewUtil.isDoubleChan() ? 8 : 0);
            this.mboundView39.setVisibility(ViewUtil.isDoubleChan() ? 8 : 0);
            this.mboundView41.setVisibility(ViewUtil.isDoubleChan() ? 8 : 0);
            this.mboundView43.setVisibility(ViewUtil.isDoubleChan() ? 8 : 0);
            this.mboundView45.setVisibility(ViewUtil.isDoubleChan() ? 8 : 0);
            this.mboundView47.setVisibility(ViewUtil.isDoubleChan() ? 8 : 0);
            this.valueD0.setVisibility(ViewUtil.isDoubleChan() ? 8 : 0);
            this.valueD1.setVisibility(ViewUtil.isDoubleChan() ? 8 : 0);
            this.valueD10.setVisibility(ViewUtil.isDoubleChan() ? 8 : 0);
            this.valueD11.setVisibility(ViewUtil.isDoubleChan() ? 8 : 0);
            this.valueD12.setVisibility(ViewUtil.isDoubleChan() ? 8 : 0);
            this.valueD13.setVisibility(ViewUtil.isDoubleChan() ? 8 : 0);
            this.valueD14.setVisibility(ViewUtil.isDoubleChan() ? 8 : 0);
            this.valueD15.setVisibility(ViewUtil.isDoubleChan() ? 8 : 0);
            this.valueD2.setVisibility(ViewUtil.isDoubleChan() ? 8 : 0);
            this.valueD3.setVisibility(ViewUtil.isDoubleChan() ? 8 : 0);
            this.valueD4.setVisibility(ViewUtil.isDoubleChan() ? 8 : 0);
            this.valueD5.setVisibility(ViewUtil.isDoubleChan() ? 8 : 0);
            this.valueD6.setVisibility(ViewUtil.isDoubleChan() ? 8 : 0);
            this.valueD7.setVisibility(ViewUtil.isDoubleChan() ? 8 : 0);
            this.valueD8.setVisibility(ViewUtil.isDoubleChan() ? 8 : 0);
            this.valueD9.setVisibility(ViewUtil.isDoubleChan() ? 8 : 0);
        }
        if ((j & 65672) != 0) {
            this.triggerDurationLimitLow.setVisibility(i);
            this.triggerDurationLimitLowValues.setVisibility(i);
            this.triggerDurationLimitUp.setVisibility(i2);
            this.triggerDurationLimitUpValues.setVisibility(i2);
        }
        if ((65800 & j) != 0) {
            TextViewBindingAdapter.setText(this.triggerDurationLimitLowValues, str4);
        }
        if ((j & 66056) != 0) {
            TextViewBindingAdapter.setText(this.triggerDurationLimitUpValues, str2);
        }
        if ((81928 & j) != 0) {
            TextViewBindingAdapter.setText(this.triggerHoldoff, str);
        }
        if ((j & 67592) != 0) {
            TextViewBindingAdapter.setText(this.triggerLevelValue, str3);
        }
        if ((69640 & j) != 0) {
            SeekBarBindingAdapter.setProgress(this.triggerLevelView, i4);
        }
        if ((j & 98312) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.triggerNoiseSwitch, z4);
        }
        if ((j & 66568) != 0) {
            this.triggerSource.setTextColor(i5);
            ViewBindingAdapter.setBackground(this.valueCh1, drawable7);
            ViewBindingAdapter.setBackground(this.valueCh2, drawable22);
            ViewBindingAdapter.setBackground(this.valueCh3, drawable28);
            ViewBindingAdapter.setBackground(this.valueCh4, drawable6);
            ViewBindingAdapter.setBackground(this.valueD0, drawable18);
            ViewBindingAdapter.setBackground(this.valueD1, drawable31);
            ViewBindingAdapter.setBackground(this.valueD10, drawable5);
            ViewBindingAdapter.setBackground(this.valueD11, drawable21);
            ViewBindingAdapter.setBackground(this.valueD12, drawable32);
            ViewBindingAdapter.setBackground(this.valueD13, drawable24);
            ViewBindingAdapter.setBackground(this.valueD14, drawable4);
            ViewBindingAdapter.setBackground(this.valueD15, drawable27);
            ViewBindingAdapter.setBackground(this.valueD2, drawable25);
            ViewBindingAdapter.setBackground(this.valueD3, drawable37);
            ViewBindingAdapter.setBackground(this.valueD4, drawable40);
            ViewBindingAdapter.setBackground(this.valueD5, drawable36);
            ViewBindingAdapter.setBackground(this.valueD6, drawable38);
            ViewBindingAdapter.setBackground(this.valueD7, drawable33);
            ViewBindingAdapter.setBackground(this.valueD8, drawable35);
            ViewBindingAdapter.setBackground(this.valueD9, drawable34);
        }
        if ((66601 & j) != 0) {
            TextViewBindingAdapter.setText(this.triggerSource, str5);
        }
        if ((j & 73736) != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.valueCh1, drawable20);
            ImageViewBindingAdapter.setImageDrawable(this.valueCh2, drawable39);
            ImageViewBindingAdapter.setImageDrawable(this.valueCh3, drawable29);
            ImageViewBindingAdapter.setImageDrawable(this.valueCh4, drawable3);
            ImageViewBindingAdapter.setImageDrawable(this.valueD0, drawable14);
            ImageViewBindingAdapter.setImageDrawable(this.valueD1, drawable2);
            ImageViewBindingAdapter.setImageDrawable(this.valueD10, drawable10);
            ImageViewBindingAdapter.setImageDrawable(this.valueD11, drawable26);
            ImageViewBindingAdapter.setImageDrawable(this.valueD12, drawable17);
            ImageViewBindingAdapter.setImageDrawable(this.valueD13, drawable15);
            ImageViewBindingAdapter.setImageDrawable(this.valueD14, drawable19);
            ImageViewBindingAdapter.setImageDrawable(this.valueD15, drawable23);
            ImageViewBindingAdapter.setImageDrawable(this.valueD2, drawable30);
            ImageViewBindingAdapter.setImageDrawable(this.valueD3, drawable9);
            ImageViewBindingAdapter.setImageDrawable(this.valueD4, drawable);
            ImageViewBindingAdapter.setImageDrawable(this.valueD5, drawable12);
            ImageViewBindingAdapter.setImageDrawable(this.valueD6, drawable13);
            ImageViewBindingAdapter.setImageDrawable(this.valueD7, drawable16);
            ImageViewBindingAdapter.setImageDrawable(this.valueD8, drawable11);
            ImageViewBindingAdapter.setImageDrawable(this.valueD9, drawable8);
        }
    }
}
