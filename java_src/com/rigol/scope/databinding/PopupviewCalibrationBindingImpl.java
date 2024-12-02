package com.rigol.scope.databinding;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.ImageViewBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.rigol.scope.R;
import com.rigol.scope.data.CalibrationParam;
import com.rigol.scope.data.UtilityParam;
import com.rigol.scope.views.NumberProgressBar;

/* loaded from: classes2.dex */
public class PopupviewCalibrationBindingImpl extends PopupviewCalibrationBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.title, 11);
        sViewsWithIds.put(R.id.guideline_left, 12);
        sViewsWithIds.put(R.id.guideline_center, 13);
        sViewsWithIds.put(R.id.notice, 14);
        sViewsWithIds.put(R.id.last_time, 15);
        sViewsWithIds.put(R.id.result, 16);
        sViewsWithIds.put(R.id.dividing_line, 17);
    }

    public PopupviewCalibrationBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 18, sIncludes, sViewsWithIds));
    }

    private PopupviewCalibrationBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3, (Button) objArr[10], (TextView) objArr[5], (ImageView) objArr[6], (TextView) objArr[8], (ScrollView) objArr[7], (View) objArr[17], (Guideline) objArr[13], (Guideline) objArr[12], (TextView) objArr[15], (TextView) objArr[2], (TextView) objArr[14], (TextView) objArr[1], (ConstraintLayout) objArr[0], (NumberProgressBar) objArr[4], (TextView) objArr[16], (TextView) objArr[3], (Button) objArr[9], (TextView) objArr[11]);
        this.mDirtyFlags = -1L;
        this.close.setTag(null);
        this.detail.setTag(null);
        this.detailArrow.setTag(null);
        this.detailContent.setTag(null);
        this.detailScroll.setTag(null);
        this.lastTimeContent.setTag(null);
        this.noticeContent.setTag(null);
        this.popup.setTag(null);
        this.progress.setTag(null);
        this.resultContent.setTag(null);
        this.startOrStop.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
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
        if (1013 == i) {
            setUtilityParam((UtilityParam) obj);
        } else if (449 == i) {
            setIsProbe((ObservableBoolean) obj);
        } else if (569 == i) {
            setOnClickListener((View.OnClickListener) obj);
        } else if (134 != i) {
            return false;
        } else {
            setCalibrationParam((CalibrationParam) obj);
        }
        return true;
    }

    @Override // com.rigol.scope.databinding.PopupviewCalibrationBinding
    public void setUtilityParam(UtilityParam utilityParam) {
        updateRegistration(0, utilityParam);
        this.mUtilityParam = utilityParam;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(1013);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewCalibrationBinding
    public void setIsProbe(ObservableBoolean observableBoolean) {
        updateRegistration(1, observableBoolean);
        this.mIsProbe = observableBoolean;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(449);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewCalibrationBinding
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(569);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewCalibrationBinding
    public void setCalibrationParam(CalibrationParam calibrationParam) {
        updateRegistration(2, calibrationParam);
        this.mCalibrationParam = calibrationParam;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(134);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    return false;
                }
                return onChangeCalibrationParam((CalibrationParam) obj, i2);
            }
            return onChangeIsProbe((ObservableBoolean) obj, i2);
        }
        return onChangeUtilityParam((UtilityParam) obj, i2);
    }

    private boolean onChangeUtilityParam(UtilityParam utilityParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i == 677) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeIsProbe(ObservableBoolean observableBoolean, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeCalibrationParam(CalibrationParam calibrationParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else if (i == 479) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        } else if (i == 739) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        } else if (i == 675) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
            }
            return true;
        } else if (i == 827) {
            synchronized (this) {
                this.mDirtyFlags |= 256;
            }
            return true;
        } else if (i == 240) {
            synchronized (this) {
                this.mDirtyFlags |= 512;
            }
            return true;
        } else if (i == 901) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
            }
            return true;
        } else {
            return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        boolean z;
        int i;
        String str;
        int i2;
        boolean z2;
        String str2;
        String str3;
        Drawable drawable;
        String str4;
        String str5;
        String str6;
        Resources resources;
        int i3;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        UtilityParam utilityParam = this.mUtilityParam;
        ObservableBoolean observableBoolean = this.mIsProbe;
        View.OnClickListener onClickListener = this.mOnClickListener;
        CalibrationParam calibrationParam = this.mCalibrationParam;
        int i4 = 0;
        if ((j & 2325) != 0) {
            z = utilityParam != null ? utilityParam.getProjectMode() : false;
            if ((j & 2065) != 0) {
                j |= z ? PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID : PlaybackStateCompat.ACTION_PREPARE;
            }
            if ((j & 2325) != 0) {
                j = z ? j | PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE : j | PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
            }
            i = ((j & 2065) == 0 || z) ? 0 : 8;
        } else {
            z = false;
            i = 0;
        }
        int i5 = ((j & 2050) > 0L ? 1 : ((j & 2050) == 0L ? 0 : -1));
        String str7 = null;
        if (i5 != 0) {
            boolean z3 = observableBoolean != null ? observableBoolean.get() : false;
            if (i5 != 0) {
                j |= z3 ? 8388608L : 4194304L;
            }
            if (z3) {
                resources = this.noticeContent.getResources();
                i3 = R.string.inf_cal_probe;
            } else {
                resources = this.noticeContent.getResources();
                i3 = R.string.inf_cal_info;
            }
            str = resources.getString(i3);
        } else {
            str = null;
        }
        if ((j & 4068) != 0) {
            int i6 = ((j & 2308) > 0L ? 1 : ((j & 2308) == 0L ? 0 : -1));
            if (i6 != 0) {
                z2 = calibrationParam != null ? calibrationParam.isShowDetail() : false;
                if (i6 != 0) {
                    j = z2 ? j | PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED : j | PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
                }
                drawable = AppCompatResources.getDrawable(this.detailArrow.getContext(), z2 ? R.drawable.ic_arrow_up3 : R.drawable.ic_arrow_down3);
            } else {
                z2 = false;
                drawable = null;
            }
            int i7 = ((j & 3076) > 0L ? 1 : ((j & 3076) == 0L ? 0 : -1));
            if (i7 != 0) {
                boolean isStarted = calibrationParam != null ? calibrationParam.isStarted() : false;
                if (i7 != 0) {
                    j |= isStarted ? PlaybackStateCompat.ACTION_PLAY_FROM_URI : PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
                }
                str6 = isStarted ? this.startOrStop.getResources().getString(R.string.msg_self_cal_quit) : this.startOrStop.getResources().getString(R.string.msg_self_cal_start);
            } else {
                str6 = null;
            }
            str3 = ((j & 2084) == 0 || calibrationParam == null) ? null : calibrationParam.getLastDate();
            i2 = ((j & 2180) == 0 || calibrationParam == null) ? 0 : calibrationParam.getProgressNow();
            String result = ((j & 2116) == 0 || calibrationParam == null) ? null : calibrationParam.getResult();
            if ((j & 2564) != 0 && calibrationParam != null) {
                str7 = calibrationParam.getDetail();
            }
            str5 = str6;
            str4 = result;
            str2 = str7;
        } else {
            i2 = 0;
            z2 = false;
            str2 = null;
            str3 = null;
            drawable = null;
            str4 = null;
            str5 = null;
        }
        if ((PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE & j) != 0) {
            if (calibrationParam != null) {
                z2 = calibrationParam.isShowDetail();
            }
            if ((j & 2308) != 0) {
                j = z2 ? j | PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED : j | PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
            }
        }
        int i8 = ((j & 2325) > 0L ? 1 : ((j & 2325) == 0L ? 0 : -1));
        if (i8 != 0) {
            if (!z) {
                z2 = false;
            }
            if (i8 != 0) {
                j |= z2 ? PlaybackStateCompat.ACTION_PREPARE_FROM_URI : PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
            }
            if (!z2) {
                i4 = 8;
            }
        }
        int i9 = i4;
        if ((2056 & j) != 0) {
            this.close.setOnClickListener(onClickListener);
            this.detailArrow.setOnClickListener(onClickListener);
            this.startOrStop.setOnClickListener(onClickListener);
        }
        if ((2065 & j) != 0) {
            this.detail.setVisibility(i);
            this.detailArrow.setVisibility(i);
        }
        if ((j & 2308) != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.detailArrow, drawable);
        }
        if ((j & 2564) != 0) {
            TextViewBindingAdapter.setText(this.detailContent, str2);
        }
        if ((2325 & j) != 0) {
            this.detailScroll.setVisibility(i9);
        }
        if ((j & 2084) != 0) {
            TextViewBindingAdapter.setText(this.lastTimeContent, str3);
        }
        if ((j & 2050) != 0) {
            TextViewBindingAdapter.setText(this.noticeContent, str);
        }
        if ((j & 2180) != 0) {
            this.progress.setProgress(i2);
        }
        if ((j & 2116) != 0) {
            TextViewBindingAdapter.setText(this.resultContent, str4);
        }
        if ((j & 3076) != 0) {
            TextViewBindingAdapter.setText(this.startOrStop, str5);
        }
    }
}
