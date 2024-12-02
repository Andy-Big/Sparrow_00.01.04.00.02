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

/* loaded from: classes2.dex */
public class AdapterTriggerPatternBindingImpl extends AdapterTriggerPatternBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.guideline_left, 42);
        sViewsWithIds.put(R.id.guideline_center, 43);
        sViewsWithIds.put(R.id.guideline_right, 44);
        sViewsWithIds.put(R.id.guideline_forth, 45);
        sViewsWithIds.put(R.id.view_top, 46);
        sViewsWithIds.put(R.id.trigger_source_label, 47);
        sViewsWithIds.put(R.id.ch4, 48);
        sViewsWithIds.put(R.id.key_all, 49);
        sViewsWithIds.put(R.id.key_next, 50);
        sViewsWithIds.put(R.id.key_return, 51);
        sViewsWithIds.put(R.id.key_falling, 52);
        sViewsWithIds.put(R.id.key_rising, 53);
        sViewsWithIds.put(R.id.key_x, 54);
        sViewsWithIds.put(R.id.key_one, 55);
        sViewsWithIds.put(R.id.button_level, 56);
        sViewsWithIds.put(R.id.trigger_level, 57);
        sViewsWithIds.put(R.id.imageView2, 58);
        sViewsWithIds.put(R.id.verticalSeekBarWrapper2, 59);
        sViewsWithIds.put(R.id.ch1, 60);
        sViewsWithIds.put(R.id.ch2, 61);
        sViewsWithIds.put(R.id.ch3, 62);
        sViewsWithIds.put(R.id.key_zero, 63);
        sViewsWithIds.put(R.id.trigger_holdoff_label, 64);
        sViewsWithIds.put(R.id.trigger_noise_label, 65);
        sViewsWithIds.put(R.id.view, 66);
        sViewsWithIds.put(R.id.view21, 67);
    }

    public AdapterTriggerPatternBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 68, sIncludes, sViewsWithIds));
    }

    private AdapterTriggerPatternBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 5, (Button) objArr[56], (TextView) objArr[60], (TextView) objArr[61], (TextView) objArr[62], (TextView) objArr[48], (TextView) objArr[20], (TextView) objArr[21], (TextView) objArr[30], (TextView) objArr[31], (TextView) objArr[32], (TextView) objArr[33], (TextView) objArr[34], (TextView) objArr[35], (TextView) objArr[22], (TextView) objArr[23], (TextView) objArr[24], (TextView) objArr[25], (TextView) objArr[26], (TextView) objArr[27], (TextView) objArr[28], (TextView) objArr[29], (Guideline) objArr[43], (Guideline) objArr[45], (Guideline) objArr[42], (Guideline) objArr[44], (ImageView) objArr[58], (ImageButton) objArr[49], (ImageButton) objArr[52], (ImageButton) objArr[50], (ImageButton) objArr[55], (ImageButton) objArr[51], (ImageButton) objArr[53], (ImageButton) objArr[54], (ImageButton) objArr[63], (EditText) objArr[40], (TextView) objArr[64], (TextView) objArr[57], (EditText) objArr[36], (VerticalSeekBar) objArr[37], (TextView) objArr[65], (SwitchButton) objArr[41], (TextView) objArr[19], (TextView) objArr[47], (ImageButton) objArr[38], (ImageButton) objArr[39], (ImageButton) objArr[2], (ImageButton) objArr[1], (ImageButton) objArr[3], (ImageButton) objArr[4], (ImageButton) objArr[13], (ImageButton) objArr[14], (ImageButton) objArr[15], (ImageButton) objArr[16], (ImageButton) objArr[17], (ImageButton) objArr[18], (ImageButton) objArr[5], (ImageButton) objArr[6], (ImageButton) objArr[7], (ImageButton) objArr[8], (ImageButton) objArr[9], (ImageButton) objArr[10], (ImageButton) objArr[11], (ImageButton) objArr[12], (VerticalSeekBarWrapper) objArr[59], (View) objArr[66], (View) objArr[67], (View) objArr[46]);
        this.mDirtyFlags = -1L;
        this.d0.setTag(null);
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
        this.d9.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
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
            this.mDirtyFlags = PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
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

    @Override // com.rigol.scope.databinding.AdapterTriggerPatternBinding
    public void setSweepSingleMapping(MappingObject mappingObject) {
        this.mSweepSingleMapping = mappingObject;
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerPatternBinding
    public void setSweepNormalMapping(MappingObject mappingObject) {
        this.mSweepNormalMapping = mappingObject;
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerPatternBinding
    public void setParam(TriggerParam triggerParam) {
        updateRegistration(2, triggerParam);
        this.mParam = triggerParam;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(594);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerPatternBinding
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
                        return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerSourceLaParamChanValue1((MappingObject) obj, i2);
                    }
                    return onChangeSweepAutoMapping((MappingObject) obj, i2);
                }
                return onChangeParam((TriggerParam) obj, i2);
            }
            return onChangeSweepNormalMapping((MappingObject) obj, i2);
        }
        return onChangeSweepSingleMapping((MappingObject) obj, i2);
    }

    private boolean onChangeSweepSingleMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeSweepNormalMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeParam(TriggerParam triggerParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else if (i == 152) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        } else if (i == 166) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        } else if (i == 484) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
            }
            return true;
        } else if (i == 671) {
            synchronized (this) {
                this.mDirtyFlags |= 256;
            }
            return true;
        } else if (i == 377) {
            synchronized (this) {
                this.mDirtyFlags |= 512;
            }
            return true;
        } else if (i == 448) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
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
        }
        return false;
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerSourceLaParamChanValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
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

    /* JADX WARN: Removed duplicated region for block: B:23:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x0720  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:311:0x0764  */
    /* JADX WARN: Removed duplicated region for block: B:315:0x078c  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x01a4  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void executeBindings() {
        long j;
        long j2;
        String str;
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
        String str2;
        Drawable drawable14;
        Drawable drawable15;
        Drawable drawable16;
        Drawable drawable17;
        Drawable drawable18;
        Drawable drawable19;
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
        String str3;
        Drawable drawable33;
        Drawable drawable34;
        Drawable drawable35;
        Drawable drawable36;
        Drawable drawable37;
        Drawable drawable38;
        Drawable drawable39;
        Drawable drawable40;
        int i;
        boolean z;
        int i2;
        String str4;
        Drawable drawable41;
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
        Drawable drawable55;
        Drawable drawable56;
        Drawable drawable57;
        Drawable drawable58;
        Drawable drawable59;
        Drawable drawable60;
        TriggerParam triggerParam;
        Drawable drawable61;
        Drawable drawable62;
        String str5;
        Drawable drawable63;
        Drawable drawable64;
        Drawable drawable65;
        Drawable drawable66;
        Drawable drawable67;
        Drawable drawable68;
        boolean z2;
        Drawable drawable69;
        Drawable drawable70;
        String str6;
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
        Drawable drawable84;
        Drawable drawable85;
        Drawable drawable86;
        Drawable drawable87;
        Drawable drawable88;
        Drawable drawable89;
        long j3;
        int i3;
        String str7;
        Drawable drawable90;
        Drawable drawable91;
        Drawable drawable92;
        long j4;
        ServiceEnum.Chan chan;
        long j5;
        Drawable drawable93;
        Drawable drawable94;
        Drawable drawable95;
        Drawable drawable96;
        Drawable drawable97;
        Drawable drawable98;
        Drawable drawable99;
        Drawable drawable100;
        Drawable drawable101;
        Drawable drawable102;
        Drawable drawable103;
        Drawable drawable104;
        Drawable drawable105;
        Drawable drawable106;
        Drawable drawable107;
        int i4;
        int i5;
        Drawable drawable108;
        Drawable drawable109;
        Drawable drawable110;
        Drawable drawable111;
        Drawable drawable112;
        Drawable drawable113;
        Drawable drawable114;
        int i6;
        Drawable drawable115;
        Drawable drawable116;
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
        synchronized (this) {
            j = this.mDirtyFlags;
            j2 = 0;
            this.mDirtyFlags = 0L;
        }
        TriggerParam triggerParam2 = this.mParam;
        String str8 = null;
        if ((8180 & j) != 0) {
            if ((j & 4228) != 0) {
                long level = triggerParam2 != null ? triggerParam2.getLevel() : 0L;
                if (triggerParam2 != null) {
                    str4 = triggerParam2.getTriggerLevelStr(level);
                    boolean isNoise = ((j & 5124) != 0 || triggerParam2 == null) ? false : triggerParam2.getIsNoise();
                    if ((j & 4164) == 0) {
                        ServiceEnum.TriggerPattern[] chanPattern = triggerParam2 != null ? triggerParam2.getChanPattern() : null;
                        if (chanPattern != null) {
                            triggerPattern9 = (ServiceEnum.TriggerPattern) getFromArray(chanPattern, 22);
                            triggerPattern10 = (ServiceEnum.TriggerPattern) getFromArray(chanPattern, 9);
                            ServiceEnum.TriggerPattern triggerPattern21 = (ServiceEnum.TriggerPattern) getFromArray(chanPattern, 10);
                            triggerPattern11 = (ServiceEnum.TriggerPattern) getFromArray(chanPattern, 0);
                            triggerPattern14 = (ServiceEnum.TriggerPattern) getFromArray(chanPattern, 15);
                            triggerPattern15 = (ServiceEnum.TriggerPattern) getFromArray(chanPattern, 13);
                            triggerPattern13 = (ServiceEnum.TriggerPattern) getFromArray(chanPattern, 1);
                            triggerPattern16 = (ServiceEnum.TriggerPattern) getFromArray(chanPattern, 18);
                            triggerPattern17 = (ServiceEnum.TriggerPattern) getFromArray(chanPattern, 19);
                            triggerPattern12 = (ServiceEnum.TriggerPattern) getFromArray(chanPattern, 8);
                            triggerPattern18 = (ServiceEnum.TriggerPattern) getFromArray(chanPattern, 17);
                            triggerPattern19 = (ServiceEnum.TriggerPattern) getFromArray(chanPattern, 2);
                            triggerPattern20 = (ServiceEnum.TriggerPattern) getFromArray(chanPattern, 12);
                            triggerPattern8 = (ServiceEnum.TriggerPattern) getFromArray(chanPattern, 20);
                            triggerPattern7 = (ServiceEnum.TriggerPattern) getFromArray(chanPattern, 16);
                            triggerPattern6 = (ServiceEnum.TriggerPattern) getFromArray(chanPattern, 3);
                            triggerPattern5 = (ServiceEnum.TriggerPattern) getFromArray(chanPattern, 21);
                            triggerPattern4 = (ServiceEnum.TriggerPattern) getFromArray(chanPattern, 14);
                            triggerPattern3 = (ServiceEnum.TriggerPattern) getFromArray(chanPattern, 11);
                            triggerPattern2 = (ServiceEnum.TriggerPattern) getFromArray(chanPattern, 23);
                            triggerPattern = triggerPattern21;
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
                        drawable49 = ViewUtil.getTriggerPatternPic(triggerPattern9);
                        drawable50 = ViewUtil.getTriggerPatternPic(triggerPattern10);
                        drawable41 = ViewUtil.getTriggerPatternPic(triggerPattern);
                        drawable43 = ViewUtil.getTriggerPatternPic(triggerPattern3);
                        drawable46 = ViewUtil.getTriggerPatternPic(triggerPattern6);
                        drawable47 = ViewUtil.getTriggerPatternPic(triggerPattern7);
                        drawable51 = ViewUtil.getTriggerPatternPic(triggerPattern11);
                        drawable45 = ViewUtil.getTriggerPatternPic(triggerPattern5);
                        drawable44 = ViewUtil.getTriggerPatternPic(triggerPattern4);
                        drawable48 = ViewUtil.getTriggerPatternPic(triggerPattern8);
                        drawable54 = ViewUtil.getTriggerPatternPic(triggerPattern14);
                        drawable55 = ViewUtil.getTriggerPatternPic(triggerPattern15);
                        drawable53 = ViewUtil.getTriggerPatternPic(triggerPattern13);
                        drawable56 = ViewUtil.getTriggerPatternPic(triggerPattern16);
                        drawable57 = ViewUtil.getTriggerPatternPic(triggerPattern17);
                        drawable52 = ViewUtil.getTriggerPatternPic(triggerPattern12);
                        drawable58 = ViewUtil.getTriggerPatternPic(triggerPattern18);
                        drawable59 = ViewUtil.getTriggerPatternPic(triggerPattern19);
                        drawable60 = ViewUtil.getTriggerPatternPic(triggerPattern20);
                        drawable42 = ViewUtil.getTriggerPatternPic(triggerPattern2);
                    } else {
                        drawable41 = null;
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
                        drawable55 = null;
                        drawable56 = null;
                        drawable57 = null;
                        drawable58 = null;
                        drawable59 = null;
                        drawable60 = null;
                    }
                    if ((j & 6196) == 0) {
                        if (triggerParam2 != null) {
                            drawable61 = drawable41;
                            chan = triggerParam2.getChan();
                        } else {
                            drawable61 = drawable41;
                            chan = null;
                        }
                        int i7 = ((j & 4132) > 0L ? 1 : ((j & 4132) == 0L ? 0 : -1));
                        if (i7 != 0) {
                            drawable62 = drawable42;
                            str5 = str4;
                            boolean z3 = chan == ServiceEnum.Chan.chan1;
                            drawable63 = drawable43;
                            boolean z4 = chan == ServiceEnum.Chan.d10;
                            drawable64 = drawable44;
                            boolean z5 = chan == ServiceEnum.Chan.d5;
                            drawable65 = drawable45;
                            boolean z6 = chan == ServiceEnum.Chan.d13;
                            drawable66 = drawable46;
                            boolean z7 = chan == ServiceEnum.Chan.d9;
                            drawable67 = drawable47;
                            boolean z8 = chan == ServiceEnum.Chan.d2;
                            drawable68 = drawable48;
                            boolean z9 = chan == ServiceEnum.Chan.chan2;
                            z2 = isNoise;
                            boolean z10 = chan == ServiceEnum.Chan.d11;
                            drawable69 = drawable49;
                            boolean z11 = chan == ServiceEnum.Chan.d6;
                            drawable70 = drawable50;
                            boolean z12 = chan == ServiceEnum.Chan.d1;
                            triggerParam = triggerParam2;
                            boolean z13 = chan == ServiceEnum.Chan.d3;
                            boolean z14 = chan == ServiceEnum.Chan.d12;
                            boolean z15 = chan == ServiceEnum.Chan.d7;
                            i3 = ColorUtil.getColor(getRoot().getContext(), chan);
                            boolean z16 = chan == ServiceEnum.Chan.chan3;
                            boolean z17 = chan == ServiceEnum.Chan.d0;
                            boolean z18 = chan == ServiceEnum.Chan.d15;
                            boolean z19 = chan == ServiceEnum.Chan.d4;
                            boolean z20 = chan == ServiceEnum.Chan.d14;
                            boolean z21 = chan == ServiceEnum.Chan.d8;
                            boolean z22 = chan == ServiceEnum.Chan.chan4;
                            if (i7 != 0) {
                                j |= z3 ? 4194304L : PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
                            }
                            if ((j & 4132) != 0) {
                                j |= z4 ? PlaybackStateCompat.ACTION_PREPARE : PlaybackStateCompat.ACTION_PLAY_FROM_URI;
                            }
                            if ((j & 4132) != 0) {
                                j |= z5 ? 281474976710656L : 140737488355328L;
                            }
                            if ((j & 4132) != 0) {
                                j |= z6 ? 1073741824L : 536870912L;
                            }
                            if ((j & 4132) != 0) {
                                j |= z7 ? 17592186044416L : 8796093022208L;
                            }
                            if ((j & 4132) != 0) {
                                j |= z8 ? 4294967296L : 2147483648L;
                            }
                            if ((j & 4132) != 0) {
                                j |= z9 ? 268435456L : 134217728L;
                            }
                            if ((j & 4132) != 0) {
                                j |= z10 ? 67108864L : 33554432L;
                            }
                            if ((j & 4132) != 0) {
                                j |= z11 ? 4503599627370496L : 2251799813685248L;
                            }
                            if ((j & 4132) != 0) {
                                j |= z12 ? 274877906944L : 137438953472L;
                            }
                            if ((j & 4132) != 0) {
                                j |= z13 ? 1125899906842624L : 562949953421312L;
                            }
                            if ((j & 4132) != 0) {
                                j |= z14 ? 1099511627776L : 549755813888L;
                            }
                            if ((j & 4132) != 0) {
                                j |= z15 ? 4398046511104L : 2199023255552L;
                            }
                            if ((j & 4132) != 0) {
                                j |= z16 ? 68719476736L : 34359738368L;
                            }
                            if ((j & 4132) != 0) {
                                j |= z17 ? 16777216L : 8388608L;
                            }
                            if ((j & 4132) != 0) {
                                j |= z18 ? 17179869184L : 8589934592L;
                            }
                            if ((j & 4132) != 0) {
                                j |= z19 ? 18014398509481984L : 9007199254740992L;
                            }
                            if ((j & 4132) != 0) {
                                j |= z20 ? PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH : PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
                            }
                            if ((j & 4132) != 0) {
                                j |= z21 ? 70368744177664L : 35184372088832L;
                            }
                            if ((j & 4132) != 0) {
                                j |= z22 ? PlaybackStateCompat.ACTION_SET_REPEAT_MODE : PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
                            }
                            drawable96 = z3 ? AppCompatResources.getDrawable(this.valueCh1.getContext(), R.drawable.bg_rectangle_selected) : AppCompatResources.getDrawable(this.valueCh1.getContext(), R.drawable.bg_rectangle_normal);
                            drawable97 = z4 ? AppCompatResources.getDrawable(this.valueD10.getContext(), R.drawable.bg_rectangle_selected) : AppCompatResources.getDrawable(this.valueD10.getContext(), R.drawable.bg_rectangle_normal);
                            drawable98 = z5 ? AppCompatResources.getDrawable(this.valueD5.getContext(), R.drawable.bg_rectangle_selected) : AppCompatResources.getDrawable(this.valueD5.getContext(), R.drawable.bg_rectangle_normal);
                            drawable99 = z6 ? AppCompatResources.getDrawable(this.valueD13.getContext(), R.drawable.bg_rectangle_selected) : AppCompatResources.getDrawable(this.valueD13.getContext(), R.drawable.bg_rectangle_normal);
                            drawable100 = z7 ? AppCompatResources.getDrawable(this.valueD9.getContext(), R.drawable.bg_rectangle_selected) : AppCompatResources.getDrawable(this.valueD9.getContext(), R.drawable.bg_rectangle_normal);
                            drawable101 = z8 ? AppCompatResources.getDrawable(this.valueD2.getContext(), R.drawable.bg_rectangle_selected) : AppCompatResources.getDrawable(this.valueD2.getContext(), R.drawable.bg_rectangle_normal);
                            drawable102 = z9 ? AppCompatResources.getDrawable(this.valueCh2.getContext(), R.drawable.bg_rectangle_selected) : AppCompatResources.getDrawable(this.valueCh2.getContext(), R.drawable.bg_rectangle_normal);
                            drawable103 = z10 ? AppCompatResources.getDrawable(this.valueD11.getContext(), R.drawable.bg_rectangle_selected) : AppCompatResources.getDrawable(this.valueD11.getContext(), R.drawable.bg_rectangle_normal);
                            drawable104 = z11 ? AppCompatResources.getDrawable(this.valueD6.getContext(), R.drawable.bg_rectangle_selected) : AppCompatResources.getDrawable(this.valueD6.getContext(), R.drawable.bg_rectangle_normal);
                            drawable105 = z12 ? AppCompatResources.getDrawable(this.valueD1.getContext(), R.drawable.bg_rectangle_selected) : AppCompatResources.getDrawable(this.valueD1.getContext(), R.drawable.bg_rectangle_normal);
                            drawable106 = z13 ? AppCompatResources.getDrawable(this.valueD3.getContext(), R.drawable.bg_rectangle_selected) : AppCompatResources.getDrawable(this.valueD3.getContext(), R.drawable.bg_rectangle_normal);
                            if (z14) {
                                Context context = this.valueD12.getContext();
                                j5 = j;
                                i5 = R.drawable.bg_rectangle_selected;
                                drawable108 = AppCompatResources.getDrawable(context, R.drawable.bg_rectangle_selected);
                            } else {
                                j5 = j;
                                i5 = R.drawable.bg_rectangle_selected;
                                drawable108 = AppCompatResources.getDrawable(this.valueD12.getContext(), R.drawable.bg_rectangle_normal);
                            }
                            Context context2 = this.valueD7.getContext();
                            drawable95 = z15 ? AppCompatResources.getDrawable(context2, i5) : AppCompatResources.getDrawable(context2, R.drawable.bg_rectangle_normal);
                            if (z16) {
                                drawable109 = drawable108;
                                drawable110 = AppCompatResources.getDrawable(this.valueCh3.getContext(), R.drawable.bg_rectangle_selected);
                            } else {
                                drawable109 = drawable108;
                                drawable110 = AppCompatResources.getDrawable(this.valueCh3.getContext(), R.drawable.bg_rectangle_normal);
                            }
                            if (z17) {
                                drawable85 = drawable110;
                                drawable111 = AppCompatResources.getDrawable(this.valueD0.getContext(), R.drawable.bg_rectangle_selected);
                            } else {
                                drawable85 = drawable110;
                                drawable111 = AppCompatResources.getDrawable(this.valueD0.getContext(), R.drawable.bg_rectangle_normal);
                            }
                            if (z18) {
                                drawable86 = drawable111;
                                drawable112 = AppCompatResources.getDrawable(this.valueD15.getContext(), R.drawable.bg_rectangle_selected);
                            } else {
                                drawable86 = drawable111;
                                drawable112 = AppCompatResources.getDrawable(this.valueD15.getContext(), R.drawable.bg_rectangle_normal);
                            }
                            if (z19) {
                                drawable87 = drawable112;
                                drawable113 = AppCompatResources.getDrawable(this.valueD4.getContext(), R.drawable.bg_rectangle_selected);
                            } else {
                                drawable87 = drawable112;
                                drawable113 = AppCompatResources.getDrawable(this.valueD4.getContext(), R.drawable.bg_rectangle_normal);
                            }
                            if (z20) {
                                drawable88 = drawable113;
                                drawable114 = AppCompatResources.getDrawable(this.valueD14.getContext(), R.drawable.bg_rectangle_selected);
                            } else {
                                drawable88 = drawable113;
                                drawable114 = AppCompatResources.getDrawable(this.valueD14.getContext(), R.drawable.bg_rectangle_normal);
                            }
                            if (z21) {
                                drawable89 = drawable114;
                                drawable115 = AppCompatResources.getDrawable(this.valueD8.getContext(), R.drawable.bg_rectangle_selected);
                                i6 = R.drawable.bg_rectangle_normal;
                            } else {
                                drawable89 = drawable114;
                                Context context3 = this.valueD8.getContext();
                                i6 = R.drawable.bg_rectangle_normal;
                                drawable115 = AppCompatResources.getDrawable(context3, R.drawable.bg_rectangle_normal);
                            }
                            if (z22) {
                                drawable107 = drawable115;
                                drawable116 = AppCompatResources.getDrawable(this.valueCh4.getContext(), R.drawable.bg_rectangle_selected);
                            } else {
                                drawable107 = drawable115;
                                drawable116 = AppCompatResources.getDrawable(this.valueCh4.getContext(), i6);
                            }
                            drawable94 = drawable116;
                            drawable93 = drawable109;
                        } else {
                            triggerParam = triggerParam2;
                            drawable62 = drawable42;
                            str5 = str4;
                            drawable63 = drawable43;
                            drawable64 = drawable44;
                            drawable65 = drawable45;
                            drawable66 = drawable46;
                            drawable67 = drawable47;
                            drawable68 = drawable48;
                            z2 = isNoise;
                            drawable69 = drawable49;
                            drawable70 = drawable50;
                            j5 = j;
                            drawable93 = null;
                            drawable94 = null;
                            drawable95 = null;
                            drawable96 = null;
                            drawable97 = null;
                            drawable98 = null;
                            drawable99 = null;
                            drawable100 = null;
                            drawable101 = null;
                            drawable102 = null;
                            drawable103 = null;
                            drawable104 = null;
                            drawable105 = null;
                            drawable106 = null;
                            drawable107 = null;
                            drawable85 = null;
                            drawable86 = null;
                            drawable87 = null;
                            drawable88 = null;
                            drawable89 = null;
                            i3 = 0;
                        }
                        if (chan != null) {
                            i4 = chan.value1;
                            drawable83 = drawable93;
                        } else {
                            drawable83 = drawable93;
                            i4 = 0;
                        }
                        MappingObject mappingObject = ViewUtil.getMappingObject(R.array.msg_trigger_source_la, i4);
                        updateRegistration(4, mappingObject);
                        if (mappingObject != null) {
                            str6 = mappingObject.getStr();
                            drawable71 = drawable94;
                        } else {
                            drawable71 = drawable94;
                            str6 = null;
                        }
                        drawable84 = drawable107;
                        j3 = 4612;
                        drawable82 = drawable106;
                        drawable81 = drawable105;
                        drawable80 = drawable104;
                        drawable79 = drawable103;
                        drawable78 = drawable102;
                        drawable5 = drawable101;
                        drawable77 = drawable100;
                        drawable76 = drawable99;
                        drawable75 = drawable98;
                        drawable74 = drawable97;
                        drawable73 = drawable96;
                        drawable72 = drawable95;
                        j = j5;
                    } else {
                        triggerParam = triggerParam2;
                        drawable61 = drawable41;
                        drawable62 = drawable42;
                        str5 = str4;
                        drawable63 = drawable43;
                        drawable64 = drawable44;
                        drawable65 = drawable45;
                        drawable66 = drawable46;
                        drawable67 = drawable47;
                        drawable68 = drawable48;
                        z2 = isNoise;
                        drawable69 = drawable49;
                        drawable70 = drawable50;
                        str6 = null;
                        drawable71 = null;
                        drawable72 = null;
                        drawable73 = null;
                        drawable74 = null;
                        drawable75 = null;
                        drawable76 = null;
                        drawable77 = null;
                        drawable5 = null;
                        drawable78 = null;
                        drawable79 = null;
                        drawable80 = null;
                        drawable81 = null;
                        drawable82 = null;
                        drawable83 = null;
                        drawable84 = null;
                        drawable85 = null;
                        drawable86 = null;
                        drawable87 = null;
                        drawable88 = null;
                        drawable89 = null;
                        j3 = 4612;
                        i3 = 0;
                    }
                    if ((j & j3) == 0) {
                        if (triggerParam != null) {
                            drawable90 = drawable71;
                            drawable91 = drawable72;
                            j4 = triggerParam.getHoldOff();
                        } else {
                            drawable90 = drawable71;
                            drawable91 = drawable72;
                            j4 = 0;
                        }
                        str7 = str6;
                        drawable92 = drawable73;
                        str8 = UnitFormat.newBuilder(UnitFormat.SI.FEMTO).convert(j4, ServiceEnum.Unit.Unit_s);
                    } else {
                        str7 = str6;
                        drawable90 = drawable71;
                        drawable91 = drawable72;
                        drawable92 = drawable73;
                    }
                    j2 = 0;
                    if ((j & 4356) != 0 || triggerParam == null) {
                        drawable20 = drawable75;
                        drawable40 = drawable76;
                        drawable18 = drawable77;
                        drawable36 = drawable78;
                        drawable35 = drawable79;
                        drawable26 = drawable80;
                        drawable12 = drawable81;
                        drawable38 = drawable51;
                        str3 = str8;
                        drawable21 = drawable52;
                        drawable16 = drawable53;
                        drawable32 = drawable54;
                        drawable23 = drawable55;
                        drawable9 = drawable56;
                        drawable24 = drawable82;
                        drawable27 = drawable57;
                        drawable13 = drawable58;
                        drawable2 = drawable59;
                        drawable3 = drawable60;
                        drawable37 = drawable61;
                        drawable14 = drawable83;
                        drawable29 = drawable62;
                        str2 = str5;
                        drawable11 = drawable63;
                        drawable15 = drawable64;
                        drawable30 = drawable66;
                        drawable39 = drawable67;
                        drawable10 = drawable68;
                        z = z2;
                        drawable34 = drawable69;
                        drawable6 = drawable70;
                        drawable19 = drawable84;
                        i2 = i3;
                        drawable8 = drawable85;
                        drawable33 = drawable86;
                        drawable7 = drawable87;
                        drawable28 = drawable88;
                        drawable22 = drawable89;
                        drawable25 = drawable90;
                        drawable17 = drawable91;
                        str = str7;
                        drawable31 = drawable92;
                        i = 0;
                    } else {
                        i = triggerParam.getProgress();
                        drawable20 = drawable75;
                        drawable40 = drawable76;
                        drawable18 = drawable77;
                        drawable36 = drawable78;
                        drawable35 = drawable79;
                        drawable26 = drawable80;
                        drawable12 = drawable81;
                        drawable38 = drawable51;
                        str3 = str8;
                        drawable21 = drawable52;
                        drawable16 = drawable53;
                        drawable32 = drawable54;
                        drawable23 = drawable55;
                        drawable9 = drawable56;
                        drawable24 = drawable82;
                        drawable27 = drawable57;
                        drawable13 = drawable58;
                        drawable2 = drawable59;
                        drawable3 = drawable60;
                        drawable37 = drawable61;
                        drawable14 = drawable83;
                        drawable29 = drawable62;
                        str2 = str5;
                        drawable11 = drawable63;
                        drawable15 = drawable64;
                        drawable30 = drawable66;
                        drawable39 = drawable67;
                        drawable10 = drawable68;
                        z = z2;
                        drawable34 = drawable69;
                        drawable6 = drawable70;
                        drawable19 = drawable84;
                        i2 = i3;
                        drawable8 = drawable85;
                        drawable33 = drawable86;
                        drawable7 = drawable87;
                        drawable28 = drawable88;
                        drawable22 = drawable89;
                        drawable25 = drawable90;
                        drawable17 = drawable91;
                        str = str7;
                        drawable31 = drawable92;
                    }
                    drawable4 = drawable74;
                    drawable = drawable65;
                }
            }
            str4 = null;
            if ((j & 5124) != 0) {
            }
            if ((j & 4164) == 0) {
            }
            if ((j & 6196) == 0) {
            }
            if ((j & j3) == 0) {
            }
            j2 = 0;
            if ((j & 4356) != 0) {
            }
            drawable20 = drawable75;
            drawable40 = drawable76;
            drawable18 = drawable77;
            drawable36 = drawable78;
            drawable35 = drawable79;
            drawable26 = drawable80;
            drawable12 = drawable81;
            drawable38 = drawable51;
            str3 = str8;
            drawable21 = drawable52;
            drawable16 = drawable53;
            drawable32 = drawable54;
            drawable23 = drawable55;
            drawable9 = drawable56;
            drawable24 = drawable82;
            drawable27 = drawable57;
            drawable13 = drawable58;
            drawable2 = drawable59;
            drawable3 = drawable60;
            drawable37 = drawable61;
            drawable14 = drawable83;
            drawable29 = drawable62;
            str2 = str5;
            drawable11 = drawable63;
            drawable15 = drawable64;
            drawable30 = drawable66;
            drawable39 = drawable67;
            drawable10 = drawable68;
            z = z2;
            drawable34 = drawable69;
            drawable6 = drawable70;
            drawable19 = drawable84;
            i2 = i3;
            drawable8 = drawable85;
            drawable33 = drawable86;
            drawable7 = drawable87;
            drawable28 = drawable88;
            drawable22 = drawable89;
            drawable25 = drawable90;
            drawable17 = drawable91;
            str = str7;
            drawable31 = drawable92;
            i = 0;
            drawable4 = drawable74;
            drawable = drawable65;
        } else {
            str = null;
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
            str2 = null;
            drawable14 = null;
            drawable15 = null;
            drawable16 = null;
            drawable17 = null;
            drawable18 = null;
            drawable19 = null;
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
            str3 = null;
            drawable33 = null;
            drawable34 = null;
            drawable35 = null;
            drawable36 = null;
            drawable37 = null;
            drawable38 = null;
            drawable39 = null;
            drawable40 = null;
            i = 0;
            z = false;
            i2 = 0;
        }
        int i8 = ((j & PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM) > j2 ? 1 : ((j & PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM) == j2 ? 0 : -1));
        if (i8 != 0 && i8 != 0) {
            j |= ViewUtil.isDoubleChan() ? PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED : PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
        }
        if ((j & PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM) != 0) {
            this.d0.setVisibility(ViewUtil.isDoubleChan() ? 8 : 0);
            this.d1.setVisibility(ViewUtil.isDoubleChan() ? 8 : 0);
            this.d10.setVisibility(ViewUtil.isDoubleChan() ? 8 : 0);
            this.d11.setVisibility(ViewUtil.isDoubleChan() ? 8 : 0);
            this.d12.setVisibility(ViewUtil.isDoubleChan() ? 8 : 0);
            this.d13.setVisibility(ViewUtil.isDoubleChan() ? 8 : 0);
            this.d14.setVisibility(ViewUtil.isDoubleChan() ? 8 : 0);
            this.d15.setVisibility(ViewUtil.isDoubleChan() ? 8 : 0);
            this.d2.setVisibility(ViewUtil.isDoubleChan() ? 8 : 0);
            this.d3.setVisibility(ViewUtil.isDoubleChan() ? 8 : 0);
            this.d4.setVisibility(ViewUtil.isDoubleChan() ? 8 : 0);
            this.d5.setVisibility(ViewUtil.isDoubleChan() ? 8 : 0);
            this.d6.setVisibility(ViewUtil.isDoubleChan() ? 8 : 0);
            this.d7.setVisibility(ViewUtil.isDoubleChan() ? 8 : 0);
            this.d8.setVisibility(ViewUtil.isDoubleChan() ? 8 : 0);
            this.d9.setVisibility(ViewUtil.isDoubleChan() ? 8 : 0);
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
        if ((4612 & j) != 0) {
            TextViewBindingAdapter.setText(this.triggerHoldoff, str3);
        }
        if ((j & 4228) != 0) {
            TextViewBindingAdapter.setText(this.triggerLevelValue, str2);
        }
        if ((4356 & j) != 0) {
            SeekBarBindingAdapter.setProgress(this.triggerLevelView, i);
        }
        if ((5124 & j) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.triggerNoiseSwitch, z);
        }
        if ((6196 & j) != 0) {
            TextViewBindingAdapter.setText(this.triggerSource, str);
        }
        if ((j & 4132) != 0) {
            this.triggerSource.setTextColor(i2);
            ViewBindingAdapter.setBackground(this.valueCh1, drawable31);
            ViewBindingAdapter.setBackground(this.valueCh2, drawable36);
            ViewBindingAdapter.setBackground(this.valueCh3, drawable8);
            ViewBindingAdapter.setBackground(this.valueCh4, drawable25);
            ViewBindingAdapter.setBackground(this.valueD0, drawable33);
            ViewBindingAdapter.setBackground(this.valueD1, drawable12);
            ViewBindingAdapter.setBackground(this.valueD10, drawable4);
            ViewBindingAdapter.setBackground(this.valueD11, drawable35);
            ViewBindingAdapter.setBackground(this.valueD12, drawable14);
            ViewBindingAdapter.setBackground(this.valueD13, drawable40);
            ViewBindingAdapter.setBackground(this.valueD14, drawable22);
            ViewBindingAdapter.setBackground(this.valueD15, drawable7);
            ViewBindingAdapter.setBackground(this.valueD2, drawable5);
            ViewBindingAdapter.setBackground(this.valueD3, drawable24);
            ViewBindingAdapter.setBackground(this.valueD4, drawable28);
            ViewBindingAdapter.setBackground(this.valueD5, drawable20);
            ViewBindingAdapter.setBackground(this.valueD6, drawable26);
            ViewBindingAdapter.setBackground(this.valueD7, drawable17);
            ViewBindingAdapter.setBackground(this.valueD8, drawable19);
            ViewBindingAdapter.setBackground(this.valueD9, drawable18);
        }
        if ((j & 4164) != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.valueCh1, drawable38);
            ImageViewBindingAdapter.setImageDrawable(this.valueCh2, drawable16);
            ImageViewBindingAdapter.setImageDrawable(this.valueCh3, drawable2);
            ImageViewBindingAdapter.setImageDrawable(this.valueCh4, drawable30);
            ImageViewBindingAdapter.setImageDrawable(this.valueD0, drawable21);
            ImageViewBindingAdapter.setImageDrawable(this.valueD1, drawable6);
            ImageViewBindingAdapter.setImageDrawable(this.valueD10, drawable9);
            ImageViewBindingAdapter.setImageDrawable(this.valueD11, drawable27);
            ImageViewBindingAdapter.setImageDrawable(this.valueD12, drawable10);
            ImageViewBindingAdapter.setImageDrawable(this.valueD13, drawable);
            ImageViewBindingAdapter.setImageDrawable(this.valueD14, drawable34);
            ImageViewBindingAdapter.setImageDrawable(this.valueD15, drawable29);
            ImageViewBindingAdapter.setImageDrawable(this.valueD2, drawable37);
            ImageViewBindingAdapter.setImageDrawable(this.valueD3, drawable11);
            ImageViewBindingAdapter.setImageDrawable(this.valueD4, drawable3);
            ImageViewBindingAdapter.setImageDrawable(this.valueD5, drawable23);
            ImageViewBindingAdapter.setImageDrawable(this.valueD6, drawable15);
            ImageViewBindingAdapter.setImageDrawable(this.valueD7, drawable32);
            ImageViewBindingAdapter.setImageDrawable(this.valueD8, drawable39);
            ImageViewBindingAdapter.setImageDrawable(this.valueD9, drawable13);
        }
    }
}
