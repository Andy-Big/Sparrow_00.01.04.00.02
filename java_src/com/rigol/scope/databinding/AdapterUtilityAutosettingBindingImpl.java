package com.rigol.scope.databinding;

import android.graphics.drawable.Drawable;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.CompoundButtonBindingAdapter;
import androidx.databinding.adapters.ImageViewBindingAdapter;
import com.rigol.scope.R;
import com.rigol.scope.data.BaseProperty;
import com.rigol.scope.views.SwitchButton;
import com.rigol.scope.views.auto.AutosetParam;
/* loaded from: classes2.dex */
public class AdapterUtilityAutosettingBindingImpl extends AdapterUtilityAutosettingBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.lock_layout, 6);
        sViewsWithIds.put(R.id.textView55, 7);
        sViewsWithIds.put(R.id.view7, 8);
        sViewsWithIds.put(R.id.auto_range_layout, 9);
        sViewsWithIds.put(R.id.textView60, 10);
        sViewsWithIds.put(R.id.channel_layout, 11);
        sViewsWithIds.put(R.id.textView61, 12);
        sViewsWithIds.put(R.id.overlay_layout, 13);
        sViewsWithIds.put(R.id.textView63, 14);
        sViewsWithIds.put(R.id.keepcoup_layout, 15);
        sViewsWithIds.put(R.id.textView64, 16);
        sViewsWithIds.put(R.id.view8, 17);
        sViewsWithIds.put(R.id.textView68, 18);
        sViewsWithIds.put(R.id.textView69, 19);
        sViewsWithIds.put(R.id.edt_oldPassword, 20);
        sViewsWithIds.put(R.id.textView70, 21);
        sViewsWithIds.put(R.id.edt_newPassword, 22);
        sViewsWithIds.put(R.id.textView71, 23);
        sViewsWithIds.put(R.id.edt_confirmPassword, 24);
        sViewsWithIds.put(R.id.configuration, 25);
    }

    public AdapterUtilityAutosettingBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 26, sIncludes, sViewsWithIds));
    }

    private AdapterUtilityAutosettingBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 6, (ConstraintLayout) objArr[9], (ConstraintLayout) objArr[11], (Button) objArr[25], (EditText) objArr[24], (EditText) objArr[22], (EditText) objArr[20], (ImageView) objArr[1], (ConstraintLayout) objArr[15], (ConstraintLayout) objArr[6], (ConstraintLayout) objArr[13], (SwitchButton) objArr[2], (SwitchButton) objArr[3], (SwitchButton) objArr[5], (SwitchButton) objArr[4], (TextView) objArr[7], (TextView) objArr[10], (TextView) objArr[12], (TextView) objArr[14], (TextView) objArr[16], (TextView) objArr[18], (TextView) objArr[19], (TextView) objArr[21], (TextView) objArr[23], (View) objArr[8], (View) objArr[17]);
        this.mDirtyFlags = -1L;
        this.imageViewLock.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.switchAutorange.setTag(null);
        this.switchChannel.setTag(null);
        this.switchKeepcoup.setTag(null);
        this.switchOverlay.setTag(null);
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
        if (594 == i) {
            setParam((AutosetParam) obj);
            return true;
        }
        return false;
    }

    @Override // com.rigol.scope.databinding.AdapterUtilityAutosettingBinding
    public void setParam(AutosetParam autosetParam) {
        updateRegistration(1, autosetParam);
        this.mParam = autosetParam;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(594);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
                                return false;
                            }
                            return onChangeParamRange((BaseProperty) obj, i2);
                        }
                        return onChangeParamKeepcoup((BaseProperty) obj, i2);
                    }
                    return onChangeParamLock((BaseProperty) obj, i2);
                }
                return onChangeParamChannel((BaseProperty) obj, i2);
            }
            return onChangeParam((AutosetParam) obj, i2);
        }
        return onChangeParamOverlay((BaseProperty) obj, i2);
    }

    private boolean onChangeParamOverlay(BaseProperty<Boolean> baseProperty, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i == 1015) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeParam(AutosetParam autosetParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeParamChannel(BaseProperty<Boolean> baseProperty, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else if (i == 1015) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeParamLock(BaseProperty<Boolean> baseProperty, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        } else if (i == 1015) {
            synchronized (this) {
                this.mDirtyFlags |= 256;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeParamKeepcoup(BaseProperty<Boolean> baseProperty, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        } else if (i == 1015) {
            synchronized (this) {
                this.mDirtyFlags |= 512;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeParamRange(BaseProperty<Boolean> baseProperty, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        } else if (i == 1015) {
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
        boolean z2;
        boolean z3;
        Drawable drawable;
        boolean z4;
        boolean z5;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        AutosetParam autosetParam = this.mParam;
        if ((4095 & j) != 0) {
            if ((j & 2115) != 0) {
                BaseProperty<Boolean> overlay = autosetParam != null ? autosetParam.getOverlay() : null;
                updateRegistration(0, overlay);
                z2 = ViewDataBinding.safeUnbox(overlay != null ? overlay.getValue() : null);
            } else {
                z2 = false;
            }
            if ((j & 2182) != 0) {
                BaseProperty<Boolean> channel = autosetParam != null ? autosetParam.getChannel() : null;
                updateRegistration(2, channel);
                z5 = ViewDataBinding.safeUnbox(channel != null ? channel.getValue() : null);
            } else {
                z5 = false;
            }
            int i = ((j & 2314) > 0L ? 1 : ((j & 2314) == 0L ? 0 : -1));
            if (i != 0) {
                BaseProperty<Boolean> lock = autosetParam != null ? autosetParam.getLock() : null;
                updateRegistration(3, lock);
                boolean safeUnbox = ViewDataBinding.safeUnbox(lock != null ? lock.getValue() : null);
                if (i != 0) {
                    j |= safeUnbox ? PlaybackStateCompat.ACTION_PLAY_FROM_URI : PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
                }
                drawable = AppCompatResources.getDrawable(this.imageViewLock.getContext(), safeUnbox ? R.drawable.lock : R.drawable.unlock);
            } else {
                drawable = null;
            }
            if ((j & 2578) != 0) {
                BaseProperty<Boolean> keepcoup = autosetParam != null ? autosetParam.getKeepcoup() : null;
                updateRegistration(4, keepcoup);
                z4 = ViewDataBinding.safeUnbox(keepcoup != null ? keepcoup.getValue() : null);
            } else {
                z4 = false;
            }
            if ((j & 3106) != 0) {
                BaseProperty<Boolean> range = autosetParam != null ? autosetParam.getRange() : null;
                updateRegistration(5, range);
                boolean z6 = z5;
                z3 = ViewDataBinding.safeUnbox(range != null ? range.getValue() : null);
                z = z6;
            } else {
                z = z5;
                z3 = false;
            }
        } else {
            z = false;
            z2 = false;
            z3 = false;
            drawable = null;
            z4 = false;
        }
        if ((j & 2314) != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.imageViewLock, drawable);
        }
        if ((3106 & j) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.switchAutorange, z3);
        }
        if ((2182 & j) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.switchChannel, z);
        }
        if ((2578 & j) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.switchKeepcoup, z4);
        }
        if ((j & 2115) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.switchOverlay, z2);
        }
    }
}
