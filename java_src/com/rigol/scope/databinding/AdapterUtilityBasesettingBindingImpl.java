package com.rigol.scope.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.SeekBar;
import android.widget.Space;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.CompoundButtonBindingAdapter;
import androidx.databinding.adapters.SeekBarBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.rigol.scope.R;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.MaskParam;
import com.rigol.scope.data.UtilityParam;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.views.SwitchButton;

/* loaded from: classes2.dex */
public class AdapterUtilityBasesettingBindingImpl extends AdapterUtilityBasesettingBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;
    private final TextView mboundView3;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.content_layout, 17);
        sViewsWithIds.put(R.id.language_layout, 18);
        sViewsWithIds.put(R.id.tv_language, 19);
        sViewsWithIds.put(R.id.view3, 20);
        sViewsWithIds.put(R.id.scree_intensit_layout, 21);
        sViewsWithIds.put(R.id.scree_intensity, 22);
        sViewsWithIds.put(R.id.load_last_layout, 23);
        sViewsWithIds.put(R.id.tv_load_last, 24);
        sViewsWithIds.put(R.id.power_layout, 25);
        sViewsWithIds.put(R.id.tv_powerstate, 26);
        sViewsWithIds.put(R.id.beeper_layout, 27);
        sViewsWithIds.put(R.id.tv_beeper, 28);
        sViewsWithIds.put(R.id.vibration_layout, 29);
        sViewsWithIds.put(R.id.tv_vibration, 30);
        sViewsWithIds.put(R.id.screen_lock_layout, 31);
        sViewsWithIds.put(R.id.tv_screen_lock, 32);
        sViewsWithIds.put(R.id.vertical_expand_layout, 33);
        sViewsWithIds.put(R.id.vertical_expand, 34);
        sViewsWithIds.put(R.id.view4, 35);
        sViewsWithIds.put(R.id.showtime_layout, 36);
        sViewsWithIds.put(R.id.tv_showtime, 37);
        sViewsWithIds.put(R.id.openzoom_layout, 38);
        sViewsWithIds.put(R.id.tv_sopenzoom, 39);
        sViewsWithIds.put(R.id.space, 40);
        sViewsWithIds.put(R.id.settime_layout, 41);
        sViewsWithIds.put(R.id.year_layout, 42);
        sViewsWithIds.put(R.id.tv_year, 43);
        sViewsWithIds.put(R.id.time_layout, 44);
        sViewsWithIds.put(R.id.tv_time, 45);
    }

    public AdapterUtilityBasesettingBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 46, sIncludes, sViewsWithIds));
    }

    private AdapterUtilityBasesettingBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3, (ConstraintLayout) objArr[7], (ConstraintLayout) objArr[27], (ConstraintLayout) objArr[17], (ConstraintLayout) objArr[18], (ConstraintLayout) objArr[23], (ConstraintLayout) objArr[38], (ConstraintLayout) objArr[25], (ConstraintLayout) objArr[21], (TextView) objArr[22], (SeekBar) objArr[2], (ConstraintLayout) objArr[31], (ConstraintLayout) objArr[41], (ConstraintLayout) objArr[36], (TextView) objArr[1], (Space) objArr[40], (SwitchButton) objArr[9], (SwitchButton) objArr[6], (SwitchButton) objArr[4], (SwitchButton) objArr[14], (SwitchButton) objArr[5], (SwitchButton) objArr[11], (SwitchButton) objArr[13], (SwitchButton) objArr[12], (SwitchButton) objArr[10], (ConstraintLayout) objArr[44], (TextView) objArr[8], (TextView) objArr[28], (TextView) objArr[19], (TextView) objArr[24], (TextView) objArr[26], (TextView) objArr[32], (TextView) objArr[37], (TextView) objArr[39], (TextView) objArr[45], (TextView) objArr[16], (TextView) objArr[30], (TextView) objArr[43], (TextView) objArr[15], (TextView) objArr[34], (ConstraintLayout) objArr[33], (ConstraintLayout) objArr[29], (View) objArr[20], (View) objArr[35], (ConstraintLayout) objArr[42]);
        this.mDirtyFlags = -1L;
        this.auxoutLayout.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView = (TextView) objArr[3];
        this.mboundView3 = textView;
        textView.setTag(null);
        this.screeIntensitySeekbar.setTag(null);
        this.spLanguage.setTag(null);
        this.switchButtonAuxout.setTag(null);
        this.switchButtonBeeper.setTag(null);
        this.switchButtonLoadLast.setTag(null);
        this.switchButtonOpenzoom.setTag(null);
        this.switchButtonPower.setTag(null);
        this.switchButtonScreenLock.setTag(null);
        this.switchButtonShowtime.setTag(null);
        this.switchButtonVerticalExpand.setTag(null);
        this.switchButtonVibration.setTag(null);
        this.tvAuxout.setTag(null);
        this.tvTimevalue.setTag(null);
        this.tvYearvalue.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
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
            setParam((UtilityParam) obj);
        } else if (522 != i) {
            return false;
        } else {
            setMaskParam((MaskParam) obj);
        }
        return true;
    }

    @Override // com.rigol.scope.databinding.AdapterUtilityBasesettingBinding
    public void setParam(UtilityParam utilityParam) {
        updateRegistration(1, utilityParam);
        this.mParam = utilityParam;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(594);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterUtilityBasesettingBinding
    public void setMaskParam(MaskParam maskParam) {
        updateRegistration(2, maskParam);
        this.mMaskParam = maskParam;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(522);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    return false;
                }
                return onChangeMaskParam((MaskParam) obj, i2);
            }
            return onChangeParam((UtilityParam) obj, i2);
        }
        return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgAppUtilityLanguageParamLanguage((MappingObject) obj, i2);
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgAppUtilityLanguageParamLanguage(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeParam(UtilityParam utilityParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        } else if (i == 478) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        } else if (i == 243) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        } else if (i == 651) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        } else if (i == 652) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
            }
            return true;
        } else if (i == 88) {
            synchronized (this) {
                this.mDirtyFlags |= 256;
            }
            return true;
        } else if (i == 63) {
            synchronized (this) {
                this.mDirtyFlags |= 512;
            }
            return true;
        } else if (i == 1028) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 506) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
            }
            return true;
        } else if (i == 1025) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
            }
            return true;
        } else if (i == 841) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            }
            return true;
        } else if (i == 845) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE;
            }
            return true;
        } else if (i == 222) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 934) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeMaskParam(MaskParam maskParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else if (i == 572) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
            }
            return true;
        } else {
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00cb  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void executeBindings() {
        long j;
        String str;
        String str2;
        String str3;
        String str4;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        int i;
        boolean z8;
        boolean z9;
        float f;
        boolean z10;
        boolean showzoom;
        String time;
        String str5;
        int i2;
        boolean vibration;
        long j2;
        boolean z11;
        long j3;
        boolean z12;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        UtilityParam utilityParam = this.mParam;
        MaskParam maskParam = this.mMaskParam;
        String str6 = null;
        if ((393211 & j) != 0) {
            z3 = ((j & 262658) == 0 || utilityParam == null) ? false : utilityParam.getAuxOut();
            boolean powerOnSet = ((j & 262210) == 0 || utilityParam == null) ? false : utilityParam.getPowerOnSet();
            if ((j & 262171) != 0) {
                MappingObject mappingObject = ViewUtil.getMappingObject(R.array.msg_app_utility_language, utilityParam != null ? utilityParam.getLanguage() : 0);
                updateRegistration(0, mappingObject);
                if (mappingObject != null) {
                    str = mappingObject.getStr();
                    z4 = ((j & 264194) != 0 || utilityParam == null) ? false : utilityParam.getLockKeyboard();
                    showzoom = ((j & 278530) != 0 || utilityParam == null) ? false : utilityParam.getShowzoom();
                    time = ((j & 327682) != 0 || utilityParam == null) ? null : utilityParam.getTime();
                    if ((j & 262178) == 0) {
                        i2 = utilityParam != null ? utilityParam.getDisplayBrightness() : 0;
                        str5 = String.valueOf(i2) + '%';
                    } else {
                        str5 = null;
                        i2 = 0;
                    }
                    if ((j & 294914) != 0 && utilityParam != null) {
                        str6 = utilityParam.getDate();
                    }
                    z7 = ((j & 270338) != 0 || utilityParam == null) ? false : utilityParam.getShowTime();
                    vibration = ((j & 263170) != 0 || utilityParam == null) ? false : utilityParam.getVibration();
                    if ((j & 262402) != 0 || utilityParam == null) {
                        j2 = 262274;
                        z11 = false;
                    } else {
                        z11 = utilityParam.getBeeper();
                        j2 = 262274;
                    }
                    if ((j & j2) != 0 || utilityParam == null) {
                        j3 = 266242;
                        z12 = false;
                    } else {
                        z12 = utilityParam.getPowerStatus();
                        j3 = 266242;
                    }
                    if ((j & j3) != 0 || utilityParam == null) {
                        str2 = str5;
                        z2 = vibration;
                        str4 = str6;
                        z5 = powerOnSet;
                        z6 = showzoom;
                        str3 = time;
                        i = i2;
                        z8 = z11;
                        z9 = z12;
                        z = false;
                    } else {
                        z = utilityParam.getVerticalExpand();
                        str2 = str5;
                        z2 = vibration;
                        str4 = str6;
                        z5 = powerOnSet;
                        z6 = showzoom;
                        str3 = time;
                        i = i2;
                        z8 = z11;
                        z9 = z12;
                    }
                }
            }
            str = null;
            if ((j & 264194) != 0) {
            }
            if ((j & 278530) != 0) {
            }
            if ((j & 327682) != 0) {
            }
            if ((j & 262178) == 0) {
            }
            if ((j & 294914) != 0) {
                str6 = utilityParam.getDate();
            }
            if ((j & 270338) != 0) {
            }
            if ((j & 263170) != 0) {
            }
            if ((j & 262402) != 0) {
            }
            j2 = 262274;
            z11 = false;
            if ((j & j2) != 0) {
            }
            j3 = 266242;
            z12 = false;
            if ((j & j3) != 0) {
            }
            str2 = str5;
            z2 = vibration;
            str4 = str6;
            z5 = powerOnSet;
            z6 = showzoom;
            str3 = time;
            i = i2;
            z8 = z11;
            z9 = z12;
            z = false;
        } else {
            str = null;
            str2 = null;
            str3 = null;
            str4 = null;
            z = false;
            z2 = false;
            z3 = false;
            z4 = false;
            z5 = false;
            z6 = false;
            z7 = false;
            i = 0;
            z8 = false;
            z9 = false;
        }
        int i3 = ((j & 393220) > 0L ? 1 : ((j & 393220) == 0L ? 0 : -1));
        if (i3 != 0) {
            z10 = !(maskParam != null ? maskParam.isOperate() : false);
            f = ContextUtil.getAlpha(z10);
        } else {
            f = 0.0f;
            z10 = false;
        }
        if (i3 != 0) {
            this.auxoutLayout.setEnabled(z10);
            this.switchButtonAuxout.setEnabled(z10);
            if (getBuildSdkInt() >= 11) {
                this.switchButtonAuxout.setAlpha(f);
                this.tvAuxout.setAlpha(f);
            }
        }
        if ((j & 262178) != 0) {
            TextViewBindingAdapter.setText(this.mboundView3, str2);
            SeekBarBindingAdapter.setProgress(this.screeIntensitySeekbar, i);
        }
        if ((j & 262171) != 0) {
            TextViewBindingAdapter.setText(this.spLanguage, str);
        }
        if ((j & 262658) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.switchButtonAuxout, z3);
        }
        if ((j & 262402) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.switchButtonBeeper, z8);
        }
        if ((j & 262210) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.switchButtonLoadLast, z5);
        }
        if ((j & 278530) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.switchButtonOpenzoom, z6);
        }
        if ((262274 & j) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.switchButtonPower, z9);
        }
        if ((j & 264194) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.switchButtonScreenLock, z4);
        }
        if ((270338 & j) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.switchButtonShowtime, z7);
        }
        if ((266242 & j) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.switchButtonVerticalExpand, z);
        }
        if ((263170 & j) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.switchButtonVibration, z2);
        }
        if ((j & 327682) != 0) {
            TextViewBindingAdapter.setText(this.tvTimevalue, str3);
        }
        if ((j & 294914) != 0) {
            TextViewBindingAdapter.setText(this.tvYearvalue, str4);
        }
    }
}
