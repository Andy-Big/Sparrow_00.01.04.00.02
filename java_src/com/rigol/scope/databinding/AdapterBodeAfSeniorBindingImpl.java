package com.rigol.scope.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.CompoundButtonBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.rigol.scope.R;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.BodeParam;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.UnitFormat;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.views.SwitchButton;
/* loaded from: classes2.dex */
public class AdapterBodeAfSeniorBindingImpl extends AdapterBodeAfSeniorBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;
    private final TextView mboundView12;
    private final TextView mboundView14;
    private final TextView mboundView2;
    private final TextView mboundView4;
    private final TextView mboundView6;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.left_guideline, 19);
        sViewsWithIds.put(R.id.left_guideline1, 20);
        sViewsWithIds.put(R.id.left_guideline2, 21);
        sViewsWithIds.put(R.id.left_guideline3, 22);
    }

    public AdapterBodeAfSeniorBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 23, sIncludes, sViewsWithIds));
    }

    private AdapterBodeAfSeniorBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (TextView) objArr[13], (TextView) objArr[7], (TextView) objArr[15], (TextView) objArr[8], (TextView) objArr[16], (TextView) objArr[9], (TextView) objArr[17], (TextView) objArr[10], (TextView) objArr[18], (TextView) objArr[3], (TextView) objArr[1], (TextView) objArr[11], (SwitchButton) objArr[5], (Guideline) objArr[19], (Guideline) objArr[20], (Guideline) objArr[21], (Guideline) objArr[22]);
        this.mDirtyFlags = -1L;
        this.bodeAmpout.setTag(null);
        this.bodeBodevaramp1.setTag(null);
        this.bodeBodevaramp2.setTag(null);
        this.bodeBodevaramp3.setTag(null);
        this.bodeBodevaramp4.setTag(null);
        this.bodeBodevaramp5.setTag(null);
        this.bodeBodevaramp6.setTag(null);
        this.bodeBodevaramp7.setTag(null);
        this.bodeBodevaramp8.setTag(null);
        this.bodePointNum.setTag(null);
        this.bodeStartFreq.setTag(null);
        this.bodeStopFreq.setTag(null);
        this.bodeVaramp.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView = (TextView) objArr[12];
        this.mboundView12 = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[14];
        this.mboundView14 = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) objArr[2];
        this.mboundView2 = textView3;
        textView3.setTag(null);
        TextView textView4 = (TextView) objArr[4];
        this.mboundView4 = textView4;
        textView4.setTag(null);
        TextView textView5 = (TextView) objArr[6];
        this.mboundView6 = textView5;
        textView5.setTag(null);
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
        if (594 == i) {
            setParam((BodeParam) obj);
            return true;
        }
        return false;
    }

    @Override // com.rigol.scope.databinding.AdapterBodeAfSeniorBinding
    public void setParam(BodeParam bodeParam) {
        updateRegistration(0, bodeParam);
        this.mParam = bodeParam;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(594);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return onChangeParam((BodeParam) obj, i2);
    }

    private boolean onChangeParam(BodeParam bodeParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i == 96) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        } else if (i == 104) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else if (i == 107) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        } else if (i == 102) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        } else if (i == 110) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        } else if (i == 112) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        } else if (i == 114) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
            }
            return true;
        } else if (i == 116) {
            synchronized (this) {
                this.mDirtyFlags |= 256;
            }
            return true;
        } else if (i == 118) {
            synchronized (this) {
                this.mDirtyFlags |= 512;
            }
            return true;
        } else if (i == 108) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 91) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
            }
            return true;
        } else if (i == 113) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
            }
            return true;
        } else if (i == 115) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            }
            return true;
        } else if (i == 117) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE;
            }
            return true;
        } else if (i == 119) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
            }
            return true;
        } else {
            return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        float f;
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
        String str11;
        String str12;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        long j2;
        float f2;
        boolean z5;
        float f3;
        boolean z6;
        boolean z7;
        float f4;
        boolean z8;
        float f5;
        boolean z9;
        String str13;
        String str14;
        String str15;
        String str16;
        String str17;
        String str18;
        String str19;
        String str20;
        String str21;
        String str22;
        String str23;
        String str24;
        boolean z10;
        long j3;
        long j4;
        long j5;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        BodeParam bodeParam = this.mParam;
        float f6 = 0.0f;
        if ((131071 & j) != 0) {
            if ((j & 65601) != 0) {
                str13 = ViewUtil.subNumber(UnitFormat.newBuilder("0.##########", UnitFormat.SI.NANO).convert(bodeParam != null ? bodeParam.getBodevaramp1() : 0L) + ServiceEnum.Unit.Unit_V.value2, 6);
            } else {
                str13 = null;
            }
            if ((j & 67585) != 0) {
                str4 = ViewUtil.subNumber(UnitFormat.newBuilder("0.##########", UnitFormat.SI.NANO).convert(bodeParam != null ? bodeParam.getBodeAmpout() : 0L) + ServiceEnum.Unit.Unit_V.value2, 6);
            } else {
                str4 = null;
            }
            if ((j & 65793) != 0) {
                str5 = ViewUtil.subNumber(UnitFormat.newBuilder("0.##########", UnitFormat.SI.NANO).convert(bodeParam != null ? bodeParam.getBodevaramp5() : 0L) + ServiceEnum.Unit.Unit_V.value2, 6);
            } else {
                str5 = null;
            }
            if ((j & 73729) != 0) {
                str6 = ViewUtil.subNumber(UnitFormat.newBuilder("0.##########", UnitFormat.SI.NANO).convert(bodeParam != null ? bodeParam.getBodevaramp4() : 0L) + ServiceEnum.Unit.Unit_V.value2, 6);
            } else {
                str6 = null;
            }
            if ((j & 98305) != 0) {
                str14 = ViewUtil.subNumber(UnitFormat.newBuilder("0.##########", UnitFormat.SI.NANO).convert(bodeParam != null ? bodeParam.getBodevaramp8() : 0L) + ServiceEnum.Unit.Unit_V.value2, 6);
            } else {
                str14 = null;
            }
            if ((j & 65553) != 0) {
                str15 = String.valueOf(bodeParam != null ? bodeParam.getBodePointNum() : 0);
            } else {
                str15 = null;
            }
            int i = ((j & 65575) > 0L ? 1 : ((j & 65575) == 0L ? 0 : -1));
            if (i != 0) {
                z = bodeParam != null ? bodeParam.getBodeEnable() : false;
                if (i != 0) {
                    j = z ? j | PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED : j | PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
                }
                f = (j & 65539) != 0 ? ContextUtil.getAlpha(z) : 0.0f;
            } else {
                f = 0.0f;
                z = false;
            }
            if ((j & 65665) != 0) {
                str16 = ViewUtil.subNumber(UnitFormat.newBuilder("0.##########", UnitFormat.SI.NANO).convert(bodeParam != null ? bodeParam.getBodevaramp3() : 0L) + ServiceEnum.Unit.Unit_V.value2, 6);
            } else {
                str16 = null;
            }
            if ((j & 65545) != 0) {
                if (bodeParam != null) {
                    str8 = str16;
                    j5 = bodeParam.getBodeStartFreq();
                } else {
                    str8 = str16;
                    j5 = 0;
                }
                str17 = str13;
                str18 = ViewUtil.subNumber(UnitFormat.newBuilder("0.##########", UnitFormat.SI.MICRO).convert(j5) + ServiceEnum.Unit.Unit_hz.value2, 6);
            } else {
                str8 = str16;
                str17 = str13;
                str18 = null;
            }
            if ((66049 & j) != 0) {
                str19 = str18;
                str20 = ViewUtil.subNumber(UnitFormat.newBuilder("0.##########", UnitFormat.SI.NANO).convert(bodeParam != null ? bodeParam.getBodevaramp7() : 0L) + ServiceEnum.Unit.Unit_V.value2, 6);
            } else {
                str19 = str18;
                str20 = null;
            }
            if ((69633 & j) != 0) {
                str21 = str20;
                str22 = ViewUtil.subNumber(UnitFormat.newBuilder("0.##########", UnitFormat.SI.NANO).convert(bodeParam != null ? bodeParam.getBodevaramp2() : 0L) + ServiceEnum.Unit.Unit_V.value2, 6);
            } else {
                str21 = str20;
                str22 = null;
            }
            if ((81921 & j) != 0) {
                str23 = str22;
                str24 = ViewUtil.subNumber(UnitFormat.newBuilder("0.##########", UnitFormat.SI.NANO).convert(bodeParam != null ? bodeParam.getBodevaramp6() : 0L) + ServiceEnum.Unit.Unit_V.value2, 6);
            } else {
                str23 = str22;
                str24 = null;
            }
            int i2 = ((j & 65573) > 0L ? 1 : ((j & 65573) == 0L ? 0 : -1));
            if (i2 != 0) {
                z10 = bodeParam != null ? bodeParam.getBodeVaramp() : false;
                if (i2 != 0) {
                    j = z10 ? j | PlaybackStateCompat.ACTION_SET_REPEAT_MODE : j | PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
                }
            } else {
                z10 = false;
            }
            if ((j & 66561) != 0) {
                if (bodeParam != null) {
                    long j6 = j;
                    j4 = bodeParam.getBodeStopFreq();
                    j3 = j6;
                } else {
                    j3 = j;
                    j4 = 0;
                }
                z2 = z10;
                str10 = str14;
                str3 = str15;
                str12 = ViewUtil.subNumber(UnitFormat.newBuilder("0.##########", UnitFormat.SI.MICRO).convert(j4) + ServiceEnum.Unit.Unit_hz.value2, 6);
                str11 = str19;
                str9 = str21;
                str2 = str23;
                j = j3;
            } else {
                z2 = z10;
                str10 = str14;
                str3 = str15;
                str12 = null;
                str11 = str19;
                str9 = str21;
                str2 = str23;
            }
            str7 = str24;
            str = str17;
        } else {
            f = 0.0f;
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
            str11 = null;
            str12 = null;
            z = false;
            z2 = false;
        }
        if ((j & PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) != 0) {
            z3 = bodeParam != null ? bodeParam.getBodeRunStopEnable() : false;
            z4 = !z3;
        } else {
            z3 = false;
            z4 = false;
        }
        int i3 = ((j & 65575) > 0L ? 1 : ((j & 65575) == 0L ? 0 : -1));
        if (i3 != 0) {
            boolean z11 = z ? z4 : false;
            if (i3 != 0) {
                j = z11 ? j | 4194304 : j | PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
            }
            j2 = 0;
            if ((j & 65543) != 0) {
                f2 = f;
                f3 = ContextUtil.getAlpha(z11);
                boolean z12 = z11;
                z5 = z;
                z6 = z12;
            } else {
                f2 = f;
                f3 = 0.0f;
                boolean z13 = z11;
                z5 = z;
                z6 = z13;
            }
        } else {
            j2 = 0;
            f2 = f;
            z5 = z;
            f3 = 0.0f;
            z6 = false;
        }
        if ((j & 4194304) != j2) {
            if (bodeParam != null) {
                z2 = bodeParam.getBodeVaramp();
            }
            if ((j & 65573) != j2) {
                j = z2 ? j | PlaybackStateCompat.ACTION_SET_REPEAT_MODE : j | PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
            }
            z7 = !z2;
        } else {
            z7 = false;
        }
        boolean z14 = z2;
        String str25 = str3;
        int i4 = ((j & 65575) > 0L ? 1 : ((j & 65575) == 0L ? 0 : -1));
        if (i4 != 0) {
            if (!z6) {
                z7 = false;
            }
            float alpha = ContextUtil.getAlpha(z7);
            boolean z15 = z7;
            f4 = f3;
            z9 = z15;
            z8 = z6;
            f5 = alpha;
        } else {
            f4 = f3;
            z8 = z6;
            f5 = 0.0f;
            z9 = false;
        }
        if ((j & PlaybackStateCompat.ACTION_SET_REPEAT_MODE) != 0) {
            if (bodeParam != null) {
                z3 = bodeParam.getBodeRunStopEnable();
            }
            z4 = !z3;
        }
        int i5 = ((j & 65573) > 0L ? 1 : ((j & 65573) == 0L ? 0 : -1));
        if (i5 != 0) {
            r35 = z14 ? z4 : false;
            f6 = ContextUtil.getAlpha(r35);
        }
        String str26 = str9;
        String str27 = str10;
        float f7 = f6;
        boolean z16 = r35;
        String str28 = str7;
        if (i4 != 0) {
            if (getBuildSdkInt() >= 11) {
                this.bodeAmpout.setAlpha(f5);
            }
            this.bodeAmpout.setEnabled(z9);
        }
        if ((j & 67585) != 0) {
            TextViewBindingAdapter.setText(this.bodeAmpout, str4);
        }
        if (i5 != 0) {
            if (getBuildSdkInt() >= 11) {
                this.bodeBodevaramp1.setAlpha(f7);
                this.bodeBodevaramp2.setAlpha(f7);
                this.bodeBodevaramp3.setAlpha(f7);
                this.bodeBodevaramp4.setAlpha(f7);
                this.bodeBodevaramp5.setAlpha(f7);
                this.bodeBodevaramp6.setAlpha(f7);
                this.bodeBodevaramp7.setAlpha(f7);
                this.bodeBodevaramp8.setAlpha(f7);
            }
            this.bodeBodevaramp1.setEnabled(z16);
            this.bodeBodevaramp2.setEnabled(z16);
            this.bodeBodevaramp3.setEnabled(z16);
            this.bodeBodevaramp4.setEnabled(z16);
            this.bodeBodevaramp5.setEnabled(z16);
            this.bodeBodevaramp6.setEnabled(z16);
            this.bodeBodevaramp7.setEnabled(z16);
            this.bodeBodevaramp8.setEnabled(z16);
        }
        if ((j & 65601) != 0) {
            TextViewBindingAdapter.setText(this.bodeBodevaramp1, str);
        }
        if ((69633 & j) != 0) {
            TextViewBindingAdapter.setText(this.bodeBodevaramp2, str2);
        }
        if ((65665 & j) != 0) {
            TextViewBindingAdapter.setText(this.bodeBodevaramp3, str8);
        }
        if ((j & 73729) != 0) {
            TextViewBindingAdapter.setText(this.bodeBodevaramp4, str6);
        }
        if ((j & 65793) != 0) {
            TextViewBindingAdapter.setText(this.bodeBodevaramp5, str5);
        }
        if ((81921 & j) != 0) {
            TextViewBindingAdapter.setText(this.bodeBodevaramp6, str28);
        }
        if ((66049 & j) != 0) {
            TextViewBindingAdapter.setText(this.bodeBodevaramp7, str26);
        }
        if ((98305 & j) != 0) {
            TextViewBindingAdapter.setText(this.bodeBodevaramp8, str27);
        }
        if ((j & 65543) != 0) {
            if (getBuildSdkInt() >= 11) {
                float f8 = f4;
                this.bodePointNum.setAlpha(f8);
                this.bodeStartFreq.setAlpha(f8);
                this.bodeStopFreq.setAlpha(f8);
                this.bodeVaramp.setAlpha(f8);
            }
            boolean z17 = z8;
            this.bodePointNum.setEnabled(z17);
            this.bodeStopFreq.setEnabled(z17);
            this.bodeVaramp.setEnabled(z17);
        }
        if ((65553 & j) != 0) {
            TextViewBindingAdapter.setText(this.bodePointNum, str25);
        }
        if ((65539 & j) != 0) {
            boolean z18 = z5;
            this.bodeStartFreq.setEnabled(z18);
            this.mboundView12.setEnabled(z18);
            this.mboundView14.setEnabled(z18);
            this.mboundView2.setEnabled(z18);
            this.mboundView4.setEnabled(z18);
            this.mboundView6.setEnabled(z18);
            if (getBuildSdkInt() >= 11) {
                float f9 = f2;
                this.mboundView12.setAlpha(f9);
                this.mboundView14.setAlpha(f9);
                this.mboundView2.setAlpha(f9);
                this.mboundView4.setAlpha(f9);
                this.mboundView6.setAlpha(f9);
            }
        }
        if ((65545 & j) != 0) {
            TextViewBindingAdapter.setText(this.bodeStartFreq, str11);
        }
        if ((66561 & j) != 0) {
            TextViewBindingAdapter.setText(this.bodeStopFreq, str12);
        }
        if ((j & 65569) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.bodeVaramp, z14);
        }
    }
}
