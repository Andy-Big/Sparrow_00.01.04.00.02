package com.rigol.scope.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
import com.rigol.scope.data.HorizontalParam;
import com.rigol.scope.data.WaveRecordParam;
import com.rigol.scope.views.SwitchButton;
import com.rigol.scope.views.TouchableSeekBar;
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
        To view partially-correct add '--show-bad-code' argument
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 2870
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rigol.scope.databinding.PopupviewWaveRecordBindingImpl.executeBindings():void");
    }
}
