package com.rigol.scope.databinding;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.databinding.adapters.ViewBindingAdapter;
import com.rigol.scope.R;
import com.rigol.scope.data.MotorParam;
import com.rigol.scope.views.baseview.FanScaleView;

/* loaded from: classes2.dex */
public class PresentationMotorBindingImpl extends PresentationMotorBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.top_tip, 4);
        sViewsWithIds.put(R.id.txt_fan_tip, 5);
        sViewsWithIds.put(R.id.btn_default_setting, 6);
        sViewsWithIds.put(R.id.txt_detalut_tip, 7);
        sViewsWithIds.put(R.id.btn_fan_group, 8);
        sViewsWithIds.put(R.id.fan_scale_view, 9);
        sViewsWithIds.put(R.id.btn_angle_group, 10);
        sViewsWithIds.put(R.id.txt_description_group, 11);
        sViewsWithIds.put(R.id.txt_description_tip, 12);
        sViewsWithIds.put(R.id.txt_description2_tip, 13);
        sViewsWithIds.put(R.id.btn_hide, 14);
    }

    public PresentationMotorBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 15, sIncludes, sViewsWithIds));
    }

    private PresentationMotorBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (Button) objArr[1], (LinearLayout) objArr[10], (Button) objArr[2], (Button) objArr[3], (ImageView) objArr[6], (LinearLayout) objArr[8], (Button) objArr[14], (FanScaleView) objArr[9], (ConstraintLayout) objArr[4], (TextView) objArr[13], (ConstraintLayout) objArr[11], (TextView) objArr[12], (TextView) objArr[7], (TextView) objArr[5]);
        this.mDirtyFlags = -1L;
        this.btnAngleFirst.setTag(null);
        this.btnAngleSecond.setTag(null);
        this.btnAngleThird.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 16L;
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
            setParam((MotorParam) obj);
            return true;
        }
        return false;
    }

    @Override // com.rigol.scope.databinding.PresentationMotorBinding
    public void setParam(MotorParam motorParam) {
        updateRegistration(0, motorParam);
        this.mParam = motorParam;
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
        return onChangeParam((MotorParam) obj, i2);
    }

    private boolean onChangeParam(MotorParam motorParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i == 46) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        } else if (i == 47) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else if (i == 48) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        } else {
            return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        Drawable drawable;
        Drawable drawable2;
        Drawable drawable3;
        int i;
        int i2;
        int i3;
        boolean z;
        boolean z2;
        String str;
        String str2;
        String str3;
        int i4;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        MotorParam motorParam = this.mParam;
        int i5 = ((31 & j) > 0L ? 1 : ((31 & j) == 0L ? 0 : -1));
        long j2 = PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
        String str4 = null;
        if (i5 != 0) {
            int i6 = ((j & 19) > 0L ? 1 : ((j & 19) == 0L ? 0 : -1));
            if (i6 != 0) {
                i4 = motorParam != null ? motorParam.getAngle1() : 0;
                z = i4 == -1;
                boolean z3 = ((float) i4) == -1.0f;
                if (i6 != 0) {
                    j = z ? j | PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH : j | PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
                }
                if ((j & 19) != 0) {
                    j |= z3 ? 256L : 128L;
                }
                Context context = this.btnAngleFirst.getContext();
                drawable = z3 ? AppCompatResources.getDrawable(context, R.drawable.screen_btn_defaultbg_setting_trig) : AppCompatResources.getDrawable(context, R.drawable.screen_btn_bg_setting_trig);
            } else {
                drawable = null;
                i4 = 0;
                z = false;
            }
            int i7 = ((j & 25) > 0L ? 1 : ((j & 25) == 0L ? 0 : -1));
            if (i7 != 0) {
                i2 = motorParam != null ? motorParam.getAngle3() : 0;
                z2 = i2 == -1;
                boolean z4 = ((float) i2) == -1.0f;
                if (i7 != 0) {
                    j = z2 ? j | PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID : j | 512;
                }
                if ((j & 25) != 0) {
                    j |= z4 ? 64L : 32L;
                }
                Context context2 = this.btnAngleThird.getContext();
                drawable2 = z4 ? AppCompatResources.getDrawable(context2, R.drawable.screen_btn_defaultbg_setting_trig) : AppCompatResources.getDrawable(context2, R.drawable.screen_btn_bg_setting_trig);
            } else {
                drawable2 = null;
                i2 = 0;
                z2 = false;
            }
            int i8 = ((j & 21) > 0L ? 1 : ((j & 21) == 0L ? 0 : -1));
            if (i8 != 0) {
                i = motorParam != null ? motorParam.getAngle2() : 0;
                boolean z5 = ((float) i) == -1.0f;
                r20 = i == -1 ? 1 : 0;
                if (i8 != 0) {
                    j |= z5 ? PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM : PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
                }
                if ((j & 21) != 0) {
                    j = r20 != 0 ? j | PlaybackStateCompat.ACTION_PREPARE : j | PlaybackStateCompat.ACTION_PLAY_FROM_URI;
                }
                drawable3 = z5 ? AppCompatResources.getDrawable(this.btnAngleSecond.getContext(), R.drawable.screen_btn_defaultbg_setting_trig) : AppCompatResources.getDrawable(this.btnAngleSecond.getContext(), R.drawable.screen_btn_bg_setting_trig);
                i3 = r20;
            } else {
                drawable3 = null;
                i = 0;
                i3 = 0;
            }
            j2 = PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
            r20 = i4;
        } else {
            drawable = null;
            drawable2 = null;
            drawable3 = null;
            i = 0;
            i2 = 0;
            i3 = 0;
            z = false;
            z2 = false;
        }
        if ((j2 & j) != 0) {
            str = String.valueOf(r20) + '%';
        } else {
            str = null;
        }
        if ((PlaybackStateCompat.ACTION_PLAY_FROM_URI & j) != 0) {
            str2 = String.valueOf(i) + '%';
        } else {
            str2 = null;
        }
        if ((512 & j) != 0) {
            str3 = String.valueOf(i2) + '%';
        } else {
            str3 = null;
        }
        int i9 = ((j & 25) > 0L ? 1 : ((j & 25) == 0L ? 0 : -1));
        if (i9 == 0 || z2) {
            str3 = null;
        }
        int i10 = ((21 & j) > 0L ? 1 : ((21 & j) == 0L ? 0 : -1));
        if (i10 == 0 || i3 != 0) {
            str2 = null;
        }
        int i11 = ((j & 19) > 0L ? 1 : ((j & 19) == 0L ? 0 : -1));
        if (i11 != 0 && !z) {
            str4 = str;
        }
        String str5 = str4;
        if (i11 != 0) {
            ViewBindingAdapter.setBackground(this.btnAngleFirst, drawable);
            TextViewBindingAdapter.setText(this.btnAngleFirst, str5);
        }
        if (i10 != 0) {
            ViewBindingAdapter.setBackground(this.btnAngleSecond, drawable3);
            TextViewBindingAdapter.setText(this.btnAngleSecond, str2);
        }
        if (i9 != 0) {
            ViewBindingAdapter.setBackground(this.btnAngleThird, drawable2);
            TextViewBindingAdapter.setText(this.btnAngleThird, str3);
        }
    }
}
