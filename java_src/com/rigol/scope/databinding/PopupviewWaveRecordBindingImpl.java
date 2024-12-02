package com.rigol.scope.databinding;

import android.graphics.drawable.Drawable;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
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
import com.rigol.scope.R;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.HorizontalParam;
import com.rigol.scope.data.WaveRecordParam;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.UnitFormat;
import com.rigol.scope.views.SwitchButton;
import com.rigol.scope.views.TouchableSeekBar;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

/* loaded from: classes2.dex */
public class PopupviewWaveRecordBindingImpl extends PopupviewWaveRecordBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private long mDirtyFlags_1;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.center_guideline, 35);
        sViewsWithIds.put(R.id.left_guideline, 36);
        sViewsWithIds.put(R.id.right_guideline, 37);
        sViewsWithIds.put(R.id.record_min, 38);
        sViewsWithIds.put(R.id.record_min_switchButton, 39);
        sViewsWithIds.put(R.id.record_time, 40);
    }

    public PopupviewWaveRecordBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 41, sIncludes, sViewsWithIds));
    }

    private PopupviewWaveRecordBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (Guideline) objArr[35], (View) objArr[3], (View) objArr[18], (Guideline) objArr[36], (ImageView) objArr[31], (ImageView) objArr[30], (ImageView) objArr[28], (ImageView) objArr[32], (TextView) objArr[19], (ImageView) objArr[34], (TouchableSeekBar) objArr[26], (TextView) objArr[16], (ImageView) objArr[17], (TextView) objArr[21], (TextView) objArr[22], (TextView) objArr[27], (TextView) objArr[9], (TextView) objArr[10], (TextView) objArr[14], (TextView) objArr[15], (TextView) objArr[12], (Button) objArr[11], (TextView) objArr[13], (TextView) objArr[38], (SwitchButton) objArr[39], (TextView) objArr[1], (SwitchButton) objArr[2], (TextView) objArr[4], (TextView) objArr[23], (TextView) objArr[24], (TextView) objArr[8], (TouchableSeekBar) objArr[7], (TextView) objArr[5], (ImageView) objArr[6], (TextView) objArr[25], (TextView) objArr[40], (TextView) objArr[20], (ImageView) objArr[33], (ImageView) objArr[29], (Guideline) objArr[37]);
        this.mDirtyFlags = -1L;
        this.mDirtyFlags_1 = -1L;
        this.dividingLine1.setTag(null);
        this.dividingLine2.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.play.setTag(null);
        this.playLast.setTag(null);
        this.playMode.setTag(null);
        this.playNext.setTag(null);
        this.playOption.setTag(null);
        this.playOrder.setTag(null);
        this.playSeekBar.setTag(null);
        this.recordBeeper.setTag(null);
        this.recordBeeperImageView.setTag(null);
        this.recordCurrent.setTag(null);
        this.recordCurrentValue.setTag(null);
        this.recordEndframeValue.setTag(null);
        this.recordFrames.setTag(null);
        this.recordFramesValue.setTag(null);
        this.recordInterval.setTag(null);
        this.recordIntervalValue.setTag(null);
        this.recordMaxframes.setTag(null);
        this.recordMaxframesButton.setTag(null);
        this.recordMaxframesValue.setTag(null);
        this.recordOnoff.setTag(null);
        this.recordOnoffSwitchButton.setTag(null);
        this.recordOption.setTag(null);
        this.recordPlayinterval.setTag(null);
        this.recordPlayintervalValue.setTag(null);
        this.recordProgress.setTag(null);
        this.recordSeekBar.setTag(null);
        this.recordStart.setTag(null);
        this.recordStartImageView.setTag(null);
        this.recordStartframeValue.setTag(null);
        this.recordTimeValue.setTag(null);
        this.recordToend.setTag(null);
        this.recordTostart.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
            this.mDirtyFlags_1 = 0L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.mDirtyFlags == 0 && this.mDirtyFlags_1 == 0) {
                return false;
            }
            return true;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (594 == i) {
            setParam((WaveRecordParam) obj);
        } else if (382 != i) {
            return false;
        } else {
            setHorizontalParam((HorizontalParam) obj);
        }
        return true;
    }

    @Override // com.rigol.scope.databinding.PopupviewWaveRecordBinding
    public void setParam(WaveRecordParam waveRecordParam) {
        updateRegistration(0, waveRecordParam);
        this.mParam = waveRecordParam;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(594);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewWaveRecordBinding
    public void setHorizontalParam(HorizontalParam horizontalParam) {
        updateRegistration(1, horizontalParam);
        this.mHorizontalParam = horizontalParam;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(382);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            if (i != 1) {
                return false;
            }
            return onChangeHorizontalParam((HorizontalParam) obj, i2);
        }
        return onChangeParam((WaveRecordParam) obj, i2);
    }

    private boolean onChangeParam(WaveRecordParam waveRecordParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i == 702) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else if (i == 703) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        } else if (i == 708) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        } else if (i == 704) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        } else if (i == 699) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        } else if (i == 696) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
            }
            return true;
        } else if (i == 701) {
            synchronized (this) {
                this.mDirtyFlags |= 256;
            }
            return true;
        } else if (i == 700) {
            synchronized (this) {
                this.mDirtyFlags |= 512;
            }
            return true;
        } else if (i == 694) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 934) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
            }
            return true;
        } else if (i == 906) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
            }
            return true;
        } else if (i == 695) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            }
            return true;
        } else if (i == 706) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE;
            }
            return true;
        } else if (i == 709) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 697) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
            }
            return true;
        } else if (i == 707) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
            }
            return true;
        } else if (i == 705) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeHorizontalParam(HorizontalParam horizontalParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
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

    /* JADX WARN: Removed duplicated region for block: B:138:0x029b  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x02b5  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x02c2  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x02de  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x02eb  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x02f9  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0304  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0347  */
    /* JADX WARN: Removed duplicated region for block: B:329:0x05b5  */
    /* JADX WARN: Removed duplicated region for block: B:333:0x05c7  */
    /* JADX WARN: Removed duplicated region for block: B:336:0x05d6  */
    /* JADX WARN: Removed duplicated region for block: B:374:0x070e  */
    /* JADX WARN: Removed duplicated region for block: B:377:0x072c  */
    /* JADX WARN: Removed duplicated region for block: B:386:0x0745  */
    /* JADX WARN: Removed duplicated region for block: B:389:0x0754  */
    /* JADX WARN: Removed duplicated region for block: B:396:0x0768  */
    /* JADX WARN: Removed duplicated region for block: B:399:0x0772  */
    /* JADX WARN: Removed duplicated region for block: B:427:0x085e  */
    /* JADX WARN: Removed duplicated region for block: B:430:0x0880  */
    /* JADX WARN: Removed duplicated region for block: B:431:0x08e2  */
    /* JADX WARN: Removed duplicated region for block: B:439:0x08ff  */
    /* JADX WARN: Removed duplicated region for block: B:442:0x090a  */
    /* JADX WARN: Removed duplicated region for block: B:445:0x0915  */
    /* JADX WARN: Removed duplicated region for block: B:451:0x099e  */
    /* JADX WARN: Removed duplicated region for block: B:454:0x09ac  */
    /* JADX WARN: Removed duplicated region for block: B:457:0x09bc  */
    /* JADX WARN: Removed duplicated region for block: B:460:0x09cc  */
    /* JADX WARN: Removed duplicated region for block: B:463:0x09d9  */
    /* JADX WARN: Removed duplicated region for block: B:468:0x0a31  */
    /* JADX WARN: Removed duplicated region for block: B:471:0x0a41  */
    /* JADX WARN: Removed duplicated region for block: B:474:0x0a51  */
    /* JADX WARN: Removed duplicated region for block: B:477:0x0a61  */
    /* JADX WARN: Removed duplicated region for block: B:480:0x0a78  */
    /* JADX WARN: Removed duplicated region for block: B:483:0x0a88  */
    /* JADX WARN: Removed duplicated region for block: B:486:0x0a98  */
    /* JADX WARN: Removed duplicated region for block: B:489:0x0aa8  */
    /* JADX WARN: Removed duplicated region for block: B:492:0x0ab8  */
    /* JADX WARN: Removed duplicated region for block: B:500:0x0ae2  */
    /* JADX WARN: Removed duplicated region for block: B:503:0x0aef  */
    /* JADX WARN: Removed duplicated region for block: B:509:0x0b0b  */
    /* JADX WARN: Removed duplicated region for block: B:512:0x0b1b  */
    /* JADX WARN: Removed duplicated region for block: B:515:0x0b2b  */
    /* JADX WARN: Removed duplicated region for block: B:522:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void executeBindings() {
        long j;
        long j2;
        long j3;
        long j4;
        String str;
        String str2;
        Drawable drawable;
        Drawable drawable2;
        String str3;
        Drawable drawable3;
        Drawable drawable4;
        String str4;
        Drawable drawable5;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        int i;
        int i2;
        int i3;
        int i4;
        boolean z;
        boolean z2;
        boolean z3;
        int i5;
        int i6;
        boolean z4;
        int i7;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        float f;
        boolean z11;
        int i8;
        float f2;
        int i9;
        String str10;
        String str11;
        String str12;
        Drawable drawable6;
        int i10;
        boolean z12;
        int i11;
        int i12;
        int i13;
        int i14;
        boolean z13;
        int i15;
        float f3;
        int i16;
        int i17;
        boolean z14;
        int i18;
        int i19;
        long j5;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        boolean z15;
        int i27;
        boolean z16;
        int i28;
        float f4;
        boolean z17;
        int i29;
        Drawable drawable7;
        int i30;
        int colorFromResource;
        int i31;
        int colorFromResource2;
        int i32;
        int i33;
        int colorFromResource3;
        int i34;
        int colorFromResource4;
        long j6;
        long j7;
        long j8;
        int i35;
        int colorFromResource5;
        int i36;
        int colorFromResource6;
        int i37;
        int colorFromResource7;
        int i38;
        int colorFromResource8;
        int i39;
        int colorFromResource9;
        long j9;
        long j10;
        ServiceEnum.ControlAction controlAction;
        boolean z18;
        String str13;
        String str14;
        Drawable drawable8;
        Drawable drawable9;
        boolean z19;
        Drawable drawable10;
        boolean z20;
        Drawable drawable11;
        Drawable drawable12;
        Drawable drawable13;
        String str15;
        int i40;
        int i41;
        Drawable drawable14;
        int i42;
        String str16;
        int i43;
        String str17;
        int i44;
        String str18;
        long j11;
        Drawable drawable15;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
            j2 = this.mDirtyFlags_1;
            this.mDirtyFlags_1 = 0L;
        }
        WaveRecordParam waveRecordParam = this.mParam;
        HorizontalParam horizontalParam = this.mHorizontalParam;
        if ((1572861 & j) != 0) {
            int i45 = ((j & 1052729) > 0L ? 1 : ((j & 1052729) == 0L ? 0 : -1));
            if (i45 != 0) {
                z18 = waveRecordParam != null ? waveRecordParam.isRecordOnOff() : false;
                if (i45 != 0) {
                    j = z18 ? j | 4294967296L : j | 2147483648L;
                }
                if ((j & 1048617) != 0) {
                    j = z18 ? j | 70368744177664L : j | 35184372088832L;
                }
            } else {
                z18 = false;
            }
            if ((j & 1049089) != 0) {
                str13 = UnitFormat.newBuilder(UnitFormat.SI.FEMTO).convert(waveRecordParam != null ? waveRecordParam.getRecordInterval() : 0L) + ServiceEnum.Unit.Unit_s.value2;
            } else {
                str13 = null;
            }
            if ((1064961 & j) != 0) {
                str14 = UnitFormat.newBuilder(UnitFormat.SI.FEMTO).convert(waveRecordParam != null ? waveRecordParam.getRecordPlayInterval() : 0L) + ServiceEnum.Unit.Unit_s.value2;
            } else {
                str14 = null;
            }
            int i46 = ((1049601 & j) > 0L ? 1 : ((1049601 & j) == 0L ? 0 : -1));
            if (i46 != 0) {
                boolean isRecordBeeper = waveRecordParam != null ? waveRecordParam.isRecordBeeper() : false;
                if (i46 != 0) {
                    j |= isRecordBeeper ? 67108864L : 33554432L;
                }
                drawable8 = AppCompatResources.getDrawable(this.recordBeeperImageView.getContext(), isRecordBeeper ? R.drawable.record_beeper_on : R.drawable.record_beeper_off);
            } else {
                drawable8 = null;
            }
            int i47 = ((j & 1048609) > 0L ? 1 : ((j & 1048609) == 0L ? 0 : -1));
            if (i47 != 0) {
                z19 = waveRecordParam != null ? waveRecordParam.isRecordPlay() : false;
                if (i47 != 0) {
                    j = z19 ? j | 4398046511104L : j | 2199023255552L;
                }
                drawable9 = z19 ? AppCompatResources.getDrawable(this.play.getContext(), R.drawable.record_play1) : AppCompatResources.getDrawable(this.play.getContext(), R.drawable.record_pause1);
            } else {
                drawable9 = null;
                z19 = false;
            }
            int i48 = ((j & 1048593) > 0L ? 1 : ((j & 1048593) == 0L ? 0 : -1));
            if (i48 != 0) {
                z20 = waveRecordParam != null ? waveRecordParam.isRecordStart() : false;
                if (i48 != 0) {
                    j2 |= z20 ? PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM : PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
                }
                drawable10 = z20 ? AppCompatResources.getDrawable(this.recordStartImageView.getContext(), R.drawable.record_start) : AppCompatResources.getDrawable(this.recordStartImageView.getContext(), R.drawable.record_no_start);
            } else {
                drawable10 = null;
                z20 = false;
            }
            int i49 = ((j & 1310721) > 0L ? 1 : ((j & 1310721) == 0L ? 0 : -1));
            if (i49 != 0) {
                boolean isRecordPlayDir = waveRecordParam != null ? waveRecordParam.isRecordPlayDir() : false;
                if (i49 != 0) {
                    j |= isRecordPlayDir ? 281474976710656L : 140737488355328L;
                }
                drawable11 = AppCompatResources.getDrawable(this.playOrder.getContext(), isRecordPlayDir ? R.drawable.record_play_reverse : R.drawable.record_play_order);
            } else {
                drawable11 = null;
            }
            if ((j & 1048769) != 0) {
                if (waveRecordParam != null) {
                    i40 = waveRecordParam.getRecordFrames();
                    i41 = waveRecordParam.getRecordCurrentFrames();
                    drawable12 = drawable10;
                } else {
                    drawable12 = drawable10;
                    i40 = 0;
                    i41 = 0;
                }
                str = String.valueOf(i40);
                drawable13 = drawable11;
                j4 = j2;
                str15 = (String.valueOf(i41) + '/') + str;
            } else {
                drawable12 = drawable10;
                drawable13 = drawable11;
                j4 = j2;
                str = null;
                str15 = null;
                i40 = 0;
                i41 = 0;
            }
            String time = ((1050625 & j) == 0 || waveRecordParam == null) ? null : waveRecordParam.getTime();
            int i50 = ((j & 1179649) > 0L ? 1 : ((j & 1179649) == 0L ? 0 : -1));
            if (i50 != 0) {
                boolean isRecordPlayMode = waveRecordParam != null ? waveRecordParam.isRecordPlayMode() : false;
                if (i50 != 0) {
                    j |= isRecordPlayMode ? 268435456L : 134217728L;
                }
                if (isRecordPlayMode) {
                    j11 = j;
                    drawable15 = AppCompatResources.getDrawable(this.playMode.getContext(), R.drawable.record_play_loop);
                } else {
                    j11 = j;
                    drawable15 = AppCompatResources.getDrawable(this.playMode.getContext(), R.drawable.record_play_single);
                }
                drawable14 = drawable15;
                j = j11;
            } else {
                drawable14 = null;
            }
            int i51 = ((j & 1048581) > 0L ? 1 : ((j & 1048581) == 0L ? 0 : -1));
            if (i51 != 0) {
                boolean isRecordMin = waveRecordParam != null ? waveRecordParam.isRecordMin() : false;
                if (i51 != 0) {
                    j |= isRecordMin ? 274877906944L : 137438953472L;
                }
                if (isRecordMin) {
                    i42 = 8;
                    j3 = 0;
                    if ((j & 1155073) == 0) {
                        i43 = waveRecordParam != null ? waveRecordParam.getRecordStartFrame() : 0;
                        str16 = (j & 1081345) != 0 ? String.valueOf(i43) : null;
                    } else {
                        str16 = null;
                        i43 = 0;
                    }
                    if ((j & 1146881) == 0) {
                        int recordEndFrame = waveRecordParam != null ? waveRecordParam.getRecordEndFrame() : 0;
                        i44 = recordEndFrame - i43;
                        str17 = (j & 1114113) != 0 ? String.valueOf(recordEndFrame) : null;
                    } else {
                        str17 = null;
                        i44 = 0;
                    }
                    if ((j & 1048833) == 0) {
                        str18 = String.valueOf(waveRecordParam != null ? waveRecordParam.getRecordMaxFrames() : 0);
                    } else {
                        str18 = null;
                    }
                    if ((j & 1089537) == 0) {
                        int recordCurrent = waveRecordParam != null ? waveRecordParam.getRecordCurrent() : 0;
                        String valueOf = (j & 1056769) != 0 ? String.valueOf(recordCurrent) : null;
                        int i52 = recordCurrent - i43;
                        drawable5 = drawable12;
                        str9 = str16;
                        str5 = str15;
                        z3 = z18;
                        str2 = str17;
                        str6 = str14;
                        z = z20;
                        i4 = i52;
                        drawable3 = drawable9;
                        drawable2 = drawable14;
                        i = i44;
                        str7 = str18;
                        str8 = str13;
                        i2 = i42;
                        str4 = time;
                        drawable = drawable13;
                        i5 = i41;
                        z2 = z19;
                        drawable4 = drawable8;
                        i3 = i40;
                        str3 = valueOf;
                    } else {
                        drawable5 = drawable12;
                        str9 = str16;
                        str5 = str15;
                        z3 = z18;
                        str2 = str17;
                        str6 = str14;
                        z = z20;
                        i4 = 0;
                        drawable3 = drawable9;
                        drawable2 = drawable14;
                        i = i44;
                        str7 = str18;
                        str8 = str13;
                        i2 = i42;
                        str4 = time;
                        drawable = drawable13;
                        i5 = i41;
                        z2 = z19;
                        drawable4 = drawable8;
                        i3 = i40;
                        str3 = null;
                    }
                }
            }
            i42 = 0;
            j3 = 0;
            if ((j & 1155073) == 0) {
            }
            if ((j & 1146881) == 0) {
            }
            if ((j & 1048833) == 0) {
            }
            if ((j & 1089537) == 0) {
            }
        } else {
            j3 = 0;
            j4 = j2;
            str = null;
            str2 = null;
            drawable = null;
            drawable2 = null;
            str3 = null;
            drawable3 = null;
            drawable4 = null;
            str4 = null;
            drawable5 = null;
            str5 = null;
            str6 = null;
            str7 = null;
            str8 = null;
            str9 = null;
            i = 0;
            i2 = 0;
            i3 = 0;
            i4 = 0;
            z = false;
            z2 = false;
            z3 = false;
            i5 = 0;
        }
        int i53 = ((j & 1577115) > j3 ? 1 : ((j & 1577115) == j3 ? 0 : -1));
        if (i53 != 0) {
            if (horizontalParam != null) {
                controlAction = horizontalParam.getRunStop();
                i6 = i3;
            } else {
                i6 = i3;
                controlAction = null;
            }
            z4 = controlAction == ServiceEnum.ControlAction.Control_Stop;
            if (i53 != 0) {
                j = z4 ? j | 17592186044416L : j | 8796093022208L;
            }
        } else {
            i6 = i3;
            z4 = false;
        }
        if ((j & 17592186044416L) != 0) {
            if (waveRecordParam != null) {
                i5 = waveRecordParam.getRecordCurrentFrames();
            }
            int i54 = i5;
            z5 = i5 != 0;
            i7 = i54;
        } else {
            i7 = i5;
            z5 = false;
        }
        int i55 = ((j & 1577115) > 0L ? 1 : ((j & 1577115) == 0L ? 0 : -1));
        if (i55 != 0) {
            if (!z4) {
                z5 = false;
            }
            if (i55 != 0) {
                j |= z5 ? 1099511627776L : 549755813888L;
            }
        } else {
            z5 = false;
        }
        if ((j & 1099511627776L) != 0) {
            if (waveRecordParam != null) {
                z3 = waveRecordParam.isRecordOnOff();
            }
            if ((j & 1052729) != 0) {
                j = z3 ? j | 4294967296L : j | 2147483648L;
            }
            if ((j & 1048617) != 0) {
                j = z3 ? j | 70368744177664L : j | 35184372088832L;
            }
        }
        boolean z21 = z3;
        int i56 = ((j & 1577115) > 0L ? 1 : ((j & 1577115) == 0L ? 0 : -1));
        if (i56 != 0) {
            z6 = z5 ? z21 : false;
            if (i56 != 0) {
                j4 = z6 ? j4 | PlaybackStateCompat.ACTION_PREPARE : j4 | PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            }
        } else {
            z6 = false;
        }
        if ((j & 70373039144960L) == 0 && (j4 & PlaybackStateCompat.ACTION_PREPARE) == 0) {
            z8 = false;
            z7 = false;
        } else {
            if ((j & 70368744177664L) != 0) {
                if (waveRecordParam != null) {
                    z2 = waveRecordParam.isRecordPlay();
                }
                if ((j & 1048609) != 0) {
                    j |= z2 ? 4398046511104L : 2199023255552L;
                }
                z7 = !z2;
            } else {
                z7 = false;
            }
            if ((j & 4294967296L) == 0 && (j4 & PlaybackStateCompat.ACTION_PREPARE) == 0) {
                z8 = false;
            } else {
                if (waveRecordParam != null) {
                    z = waveRecordParam.isRecordStart();
                }
                if ((j & 1048593) != 0) {
                    j4 |= z ? PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM : PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
                }
                z8 = !z;
            }
        }
        int i57 = ((j & 1052729) > 0L ? 1 : ((j & 1052729) == 0L ? 0 : -1));
        if (i57 != 0) {
            z9 = z21 ? z8 : false;
            if (i57 != 0) {
                j4 |= z9 ? 256L : 128L;
            }
            if ((j & 1052697) != 0) {
                j4 |= z9 ? PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH : PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
            }
        } else {
            z9 = false;
        }
        if ((j & 1048617) != 0) {
            boolean z22 = z21 ? z7 : false;
            z10 = z22;
            f = ContextUtil.getAlpha(z22);
        } else {
            z10 = false;
            f = 0.0f;
        }
        int i58 = ((j & 1577115) > 0L ? 1 : ((j & 1577115) == 0L ? 0 : -1));
        if (i58 != 0) {
            if (!z6) {
                z8 = false;
            }
            if (i58 != 0) {
                j = z8 ? j | 4194304 : j | PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
            }
        } else {
            z8 = false;
        }
        if ((j & 4194304) != 0 || (j4 & 65792) != 0) {
            if ((j4 & 256) != 0) {
                if (waveRecordParam != null) {
                    z2 = waveRecordParam.isRecordPlay();
                }
                if ((j & 1048609) != 0) {
                    j = z2 ? j | 4398046511104L : j | 2199023255552L;
                }
                z7 = !z2;
            }
            if ((j & 4194304) != 0 || (j4 & PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) != 0) {
                long j12 = j;
                ServiceEnum.RecordState state = waveRecordParam != null ? waveRecordParam.getState() : null;
                r26 = state;
                z11 = state != ServiceEnum.RecordState.Record_empty;
                j = j12;
                if ((j & 1577115) == 0) {
                    float alpha = ContextUtil.getAlpha(z8 ? z11 : false);
                    i8 = i7;
                    f2 = alpha;
                } else {
                    i8 = i7;
                    f2 = 0.0f;
                }
                i9 = ((j & 1052729) > 0L ? 1 : ((j & 1052729) == 0L ? 0 : -1));
                if (i9 == 0) {
                    if (!z9) {
                        z7 = false;
                    }
                    if (i9 != 0) {
                        j |= z7 ? 16777216L : 8388608L;
                    }
                    if ((j & 1048633) != 0) {
                        if (z7) {
                            j9 = j | 1073741824 | 68719476736L | 4503599627370496L | 72057594037927936L;
                            j10 = 4611686018427387904L;
                        } else {
                            j9 = j | 536870912 | 34359738368L | 2251799813685248L | 36028797018963968L | LockFreeTaskQueueCore.CLOSED_MASK;
                            j10 = Long.MIN_VALUE;
                        }
                        j = j9 | j10;
                    }
                    if ((j & 1048633) != 0) {
                        if (z7) {
                            TextView textView = this.recordIntervalValue;
                            j8 = j;
                            i35 = R.color.white;
                            colorFromResource5 = getColorFromResource(textView, R.color.white);
                        } else {
                            j8 = j;
                            i35 = R.color.white;
                            colorFromResource5 = getColorFromResource(this.recordIntervalValue, R.color.gray_regent);
                        }
                        TextView textView2 = this.recordBeeper;
                        i11 = z7 ? getColorFromResource(textView2, i35) : getColorFromResource(textView2, R.color.gray_regent);
                        float alpha2 = ContextUtil.getAlpha(z7);
                        if (z7) {
                            i36 = colorFromResource5;
                            colorFromResource6 = getColorFromResource(this.recordStart, R.color.white);
                        } else {
                            i36 = colorFromResource5;
                            colorFromResource6 = getColorFromResource(this.recordStart, R.color.gray_regent);
                        }
                        if (z7) {
                            i37 = colorFromResource6;
                            colorFromResource7 = getColorFromResource(this.recordFramesValue, R.color.white);
                        } else {
                            i37 = colorFromResource6;
                            colorFromResource7 = getColorFromResource(this.recordFramesValue, R.color.gray_regent);
                        }
                        if (z7) {
                            i38 = colorFromResource7;
                            colorFromResource8 = getColorFromResource(this.recordInterval, R.color.white);
                        } else {
                            i38 = colorFromResource7;
                            colorFromResource8 = getColorFromResource(this.recordInterval, R.color.gray_regent);
                        }
                        if (z7) {
                            i39 = colorFromResource8;
                            colorFromResource9 = getColorFromResource(this.recordFrames, R.color.white);
                        } else {
                            i39 = colorFromResource8;
                            colorFromResource9 = getColorFromResource(this.recordFrames, R.color.gray_regent);
                        }
                        f3 = alpha2;
                        drawable6 = drawable4;
                        i13 = colorFromResource9;
                        j = j8;
                        str11 = str2;
                        str12 = str3;
                        z12 = z7;
                        i12 = i38;
                        i15 = i36;
                        i14 = i37;
                        z13 = z12;
                        str10 = str;
                        i10 = i39;
                    } else {
                        drawable6 = drawable4;
                        i11 = 0;
                        i13 = 0;
                        i14 = 0;
                        i15 = 0;
                        z13 = z7;
                        f3 = 0.0f;
                        str10 = str;
                        str11 = str2;
                        str12 = str3;
                        i10 = 0;
                        z12 = false;
                        i12 = 0;
                    }
                } else {
                    str10 = str;
                    str11 = str2;
                    str12 = str3;
                    drawable6 = drawable4;
                    i10 = 0;
                    z12 = false;
                    i11 = 0;
                    i12 = 0;
                    i13 = 0;
                    i14 = 0;
                    z13 = false;
                    i15 = 0;
                    f3 = 0.0f;
                }
                i16 = ((j & 1052697) > 0L ? 1 : ((j & 1052697) == 0L ? 0 : -1));
                if (i16 == 0) {
                    boolean z23 = z9 ? z11 : false;
                    if (i16 != 0) {
                        j |= z23 ? LockFreeTaskQueueCore.FROZEN_MASK : 576460752303423488L;
                    }
                    boolean z24 = z23;
                    i17 = i10;
                    z14 = z24;
                } else {
                    i17 = i10;
                    z14 = false;
                }
                if ((j & 16777216) == 0) {
                    if (waveRecordParam != null) {
                        r26 = waveRecordParam.getState();
                    }
                    ServiceEnum.RecordState recordState = r26;
                    i18 = i12;
                    z11 = recordState != ServiceEnum.RecordState.Record_empty;
                } else {
                    i18 = i12;
                }
                i19 = ((j & 1052729) > 0L ? 1 : ((j & 1052729) == 0L ? 0 : -1));
                if (i19 == 0) {
                    if (!z13) {
                        z11 = false;
                    }
                    if (i19 != 0) {
                        if (z11) {
                            j6 = j | 17179869184L | 1125899906842624L | 18014398509481984L;
                            j7 = 288230376151711744L;
                        } else {
                            j6 = j | 8589934592L | 562949953421312L | 9007199254740992L;
                            j7 = 144115188075855872L;
                        }
                        j = j6 | j7;
                    }
                    int colorFromResource10 = z11 ? getColorFromResource(this.recordPlayintervalValue, R.color.white) : getColorFromResource(this.recordPlayintervalValue, R.color.gray_regent);
                    if (z11) {
                        i30 = colorFromResource10;
                        colorFromResource = getColorFromResource(this.recordEndframeValue, R.color.white);
                    } else {
                        i30 = colorFromResource10;
                        colorFromResource = getColorFromResource(this.recordEndframeValue, R.color.gray_regent);
                    }
                    if (z11) {
                        TextView textView3 = this.recordPlayinterval;
                        j5 = j;
                        i31 = R.color.white;
                        colorFromResource2 = getColorFromResource(textView3, R.color.white);
                    } else {
                        j5 = j;
                        i31 = R.color.white;
                        colorFromResource2 = getColorFromResource(this.recordPlayinterval, R.color.gray_regent);
                    }
                    float alpha3 = ContextUtil.getAlpha(z11);
                    TextView textView4 = this.recordCurrent;
                    int colorFromResource11 = z11 ? getColorFromResource(textView4, i31) : getColorFromResource(textView4, R.color.gray_regent);
                    if (z11) {
                        i32 = colorFromResource2;
                        colorFromResource3 = getColorFromResource(this.recordCurrentValue, R.color.white);
                        i33 = R.color.gray_regent;
                    } else {
                        i32 = colorFromResource2;
                        TextView textView5 = this.recordCurrentValue;
                        i33 = R.color.gray_regent;
                        colorFromResource3 = getColorFromResource(textView5, R.color.gray_regent);
                    }
                    if (z11) {
                        i34 = colorFromResource3;
                        colorFromResource4 = getColorFromResource(this.recordStartframeValue, R.color.white);
                    } else {
                        i34 = colorFromResource3;
                        colorFromResource4 = getColorFromResource(this.recordStartframeValue, i33);
                    }
                    i20 = i;
                    i25 = i30;
                    f4 = alpha3;
                    z17 = z12;
                    i21 = i11;
                    i29 = colorFromResource;
                    z15 = z11;
                    i27 = i34;
                    i22 = i4;
                    z16 = z15;
                    i23 = i13;
                    i28 = colorFromResource11;
                    i26 = colorFromResource4;
                    i24 = i32;
                } else {
                    j5 = j;
                    i20 = i;
                    i21 = i11;
                    i22 = i4;
                    i23 = i13;
                    i24 = 0;
                    i25 = 0;
                    i26 = 0;
                    z15 = false;
                    i27 = 0;
                    z16 = false;
                    i28 = 0;
                    f4 = 0.0f;
                    z17 = z12;
                    i29 = 0;
                }
                if ((j5 & 1048581) == 0) {
                    drawable7 = drawable;
                    this.dividingLine1.setVisibility(i2);
                    this.dividingLine2.setVisibility(i2);
                    this.playOption.setVisibility(i2);
                    this.recordBeeper.setVisibility(i2);
                    this.recordBeeperImageView.setVisibility(i2);
                    this.recordFrames.setVisibility(i2);
                    this.recordFramesValue.setVisibility(i2);
                    this.recordInterval.setVisibility(i2);
                    this.recordIntervalValue.setVisibility(i2);
                    this.recordMaxframes.setVisibility(i2);
                    this.recordMaxframesButton.setVisibility(i2);
                    this.recordMaxframesValue.setVisibility(i2);
                    this.recordOnoff.setVisibility(i2);
                    this.recordOnoffSwitchButton.setVisibility(i2);
                    this.recordOption.setVisibility(i2);
                    this.recordProgress.setVisibility(i2);
                    this.recordSeekBar.setVisibility(i2);
                    this.recordStart.setVisibility(i2);
                    this.recordStartImageView.setVisibility(i2);
                } else {
                    drawable7 = drawable;
                }
                if ((j5 & 1577115) != 0 && getBuildSdkInt() >= 11) {
                    this.play.setAlpha(f2);
                }
                if ((j5 & 1052697) != 0) {
                    this.play.setEnabled(z14);
                }
                if ((j5 & 1048609) != 0) {
                    ImageViewBindingAdapter.setImageDrawable(this.play, drawable3);
                }
                if ((j5 & 1052729) != 0) {
                    if (getBuildSdkInt() >= 11) {
                        this.playLast.setAlpha(f4);
                        this.playMode.setAlpha(f4);
                        this.playNext.setAlpha(f4);
                        this.playOrder.setAlpha(f4);
                        this.playSeekBar.setAlpha(f4);
                        this.recordToend.setAlpha(f4);
                        this.recordTostart.setAlpha(f4);
                    }
                    this.playLast.setEnabled(z16);
                    this.playMode.setEnabled(z16);
                    this.playNext.setEnabled(z16);
                    this.playOrder.setEnabled(z16);
                    this.playSeekBar.setTouchable(z15);
                    this.recordCurrent.setTextColor(i28);
                    this.recordCurrentValue.setEnabled(z16);
                    this.recordCurrentValue.setTextColor(i27);
                    this.recordEndframeValue.setEnabled(z16);
                    this.recordEndframeValue.setTextColor(i29);
                    this.recordPlayinterval.setTextColor(i24);
                    this.recordPlayintervalValue.setEnabled(z16);
                    this.recordPlayintervalValue.setTextColor(i25);
                    this.recordStartframeValue.setEnabled(z16);
                    this.recordStartframeValue.setTextColor(i26);
                    this.recordToend.setEnabled(z16);
                    this.recordTostart.setEnabled(z16);
                }
                if ((j5 & 1179649) != 0) {
                    ImageViewBindingAdapter.setImageDrawable(this.playMode, drawable2);
                }
                if ((j5 & 1310721) != 0) {
                    ImageViewBindingAdapter.setImageDrawable(this.playOrder, drawable7);
                }
                if ((j5 & 1146881) != 0) {
                    this.playSeekBar.setMax(i20);
                }
                if ((j5 & 1089537) != 0) {
                    SeekBarBindingAdapter.setProgress(this.playSeekBar, i22);
                }
                if ((j5 & 1048633) != 0) {
                    this.recordBeeper.setTextColor(i21);
                    boolean z25 = z17;
                    this.recordBeeperImageView.setEnabled(z25);
                    this.recordFrames.setTextColor(i23);
                    this.recordFramesValue.setEnabled(z25);
                    this.recordFramesValue.setTextColor(i18);
                    this.recordInterval.setTextColor(i17);
                    this.recordIntervalValue.setEnabled(z25);
                    this.recordIntervalValue.setTextColor(i15);
                    this.recordMaxframesButton.setEnabled(z25);
                    this.recordStart.setTextColor(i14);
                    if (getBuildSdkInt() >= 11) {
                        this.recordBeeperImageView.setAlpha(f3);
                    }
                }
                if ((j5 & 1049601) != 0) {
                    ImageViewBindingAdapter.setImageDrawable(this.recordBeeperImageView, drawable6);
                }
                if ((j5 & 1056769) != 0) {
                    TextViewBindingAdapter.setText(this.recordCurrentValue, str12);
                }
                if ((j5 & 1114113) != 0) {
                    TextViewBindingAdapter.setText(this.recordEndframeValue, str11);
                }
                if ((j5 & 1048641) != 0) {
                    TextViewBindingAdapter.setText(this.recordFramesValue, str10);
                    this.recordSeekBar.setMax(i6);
                }
                if ((j5 & 1049089) != 0) {
                    TextViewBindingAdapter.setText(this.recordIntervalValue, str8);
                }
                if ((j5 & 1048833) != 0) {
                    TextViewBindingAdapter.setText(this.recordMaxframesValue, str7);
                }
                if ((j5 & 1048585) != 0) {
                    CompoundButtonBindingAdapter.setChecked(this.recordOnoffSwitchButton, z21);
                }
                if ((j5 & 1064961) != 0) {
                    TextViewBindingAdapter.setText(this.recordPlayintervalValue, str6);
                }
                if ((j5 & 1048769) != 0) {
                    TextViewBindingAdapter.setText(this.recordProgress, str5);
                }
                if ((j5 & PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) != 0 && getBuildSdkInt() >= 11) {
                    this.recordSeekBar.setAlpha(ContextUtil.getAlpha(false));
                }
                if ((j5 & 1048705) != 0) {
                    SeekBarBindingAdapter.setProgress(this.recordSeekBar, i8);
                }
                if ((j5 & 1048617) != 0) {
                    if (getBuildSdkInt() >= 11) {
                        this.recordStartImageView.setAlpha(f);
                    }
                    this.recordStartImageView.setEnabled(z10);
                }
                if ((j5 & 1048593) != 0) {
                    ImageViewBindingAdapter.setImageDrawable(this.recordStartImageView, drawable5);
                }
                if ((j5 & 1081345) != 0) {
                    TextViewBindingAdapter.setText(this.recordStartframeValue, str9);
                }
                if ((j5 & 1050625) == 0) {
                    TextViewBindingAdapter.setText(this.recordTimeValue, str4);
                    return;
                }
                return;
            }
        }
        z11 = false;
        if ((j & 1577115) == 0) {
        }
        i9 = ((j & 1052729) > 0L ? 1 : ((j & 1052729) == 0L ? 0 : -1));
        if (i9 == 0) {
        }
        i16 = ((j & 1052697) > 0L ? 1 : ((j & 1052697) == 0L ? 0 : -1));
        if (i16 == 0) {
        }
        if ((j & 16777216) == 0) {
        }
        i19 = ((j & 1052729) > 0L ? 1 : ((j & 1052729) == 0L ? 0 : -1));
        if (i19 == 0) {
        }
        if ((j5 & 1048581) == 0) {
        }
        if ((j5 & 1577115) != 0) {
            this.play.setAlpha(f2);
        }
        if ((j5 & 1052697) != 0) {
        }
        if ((j5 & 1048609) != 0) {
        }
        if ((j5 & 1052729) != 0) {
        }
        if ((j5 & 1179649) != 0) {
        }
        if ((j5 & 1310721) != 0) {
        }
        if ((j5 & 1146881) != 0) {
        }
        if ((j5 & 1089537) != 0) {
        }
        if ((j5 & 1048633) != 0) {
        }
        if ((j5 & 1049601) != 0) {
        }
        if ((j5 & 1056769) != 0) {
        }
        if ((j5 & 1114113) != 0) {
        }
        if ((j5 & 1048641) != 0) {
        }
        if ((j5 & 1049089) != 0) {
        }
        if ((j5 & 1048833) != 0) {
        }
        if ((j5 & 1048585) != 0) {
        }
        if ((j5 & 1064961) != 0) {
        }
        if ((j5 & 1048769) != 0) {
        }
        if ((j5 & PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) != 0) {
            this.recordSeekBar.setAlpha(ContextUtil.getAlpha(false));
        }
        if ((j5 & 1048705) != 0) {
        }
        if ((j5 & 1048617) != 0) {
        }
        if ((j5 & 1048593) != 0) {
        }
        if ((j5 & 1081345) != 0) {
        }
        if ((j5 & 1050625) == 0) {
        }
    }
}
