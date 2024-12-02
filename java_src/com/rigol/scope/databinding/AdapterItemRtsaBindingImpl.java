package com.rigol.scope.databinding;

import android.graphics.drawable.Drawable;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.databinding.adapters.ViewBindingAdapter;
import com.rigol.scope.R;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.FftParam;
import com.rigol.scope.utilities.ColorUtil;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.UnitFormat;
import com.rigol.scope.utilities.ViewUtil;

/* loaded from: classes2.dex */
public class AdapterItemRtsaBindingImpl extends AdapterItemRtsaBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    public AdapterItemRtsaBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 4, sIncludes, sViewsWithIds));
    }

    private AdapterItemRtsaBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (TextView) objArr[2], (TextView) objArr[3], (TextView) objArr[1]);
        this.mDirtyFlags = -1L;
        this.center.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.span.setTag(null);
        this.title.setTag(null);
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
            setParam((FftParam) obj);
            return true;
        }
        return false;
    }

    @Override // com.rigol.scope.databinding.AdapterItemRtsaBinding
    public void setParam(FftParam fftParam) {
        updateRegistration(0, fftParam);
        this.mParam = fftParam;
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
        return onChangeParam((FftParam) obj, i2);
    }

    private boolean onChangeParam(FftParam fftParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i == 271) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        } else if (i == 150) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else if (i == 870) {
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
        String str;
        String str2;
        int i;
        boolean z;
        int i2;
        Drawable drawable;
        int i3;
        long j2;
        long j3;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        FftParam fftParam = this.mParam;
        Drawable drawable2 = null;
        int i4 = 0;
        if ((31 & j) != 0) {
            if ((j & 25) != 0) {
                str = "S: " + ViewUtil.subNumber(UnitFormat.newBuilder("0.##########", UnitFormat.SI.MICRO).convert(fftParam != null ? fftParam.getSpan() : 0L) + ServiceEnum.Unit.Unit_hz.value2, 4);
            } else {
                str = null;
            }
            int i5 = ((j & 19) > 0L ? 1 : ((j & 19) == 0L ? 0 : -1));
            if (i5 != 0) {
                z = fftParam != null ? fftParam.isEnable() : false;
                if (i5 != 0) {
                    if (z) {
                        j2 = j | 64 | 256 | PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
                        j3 = PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
                    } else {
                        j2 = j | 32 | 128 | 512;
                        j3 = PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
                    }
                    j = j2 | j3;
                }
                i = -1;
                i2 = z ? -1 : getColorFromResource(this.span, R.color.gray_regent);
                if (!z) {
                    i = getColorFromResource(this.center, R.color.gray_regent);
                }
            } else {
                i = 0;
                z = false;
                i2 = 0;
            }
            if ((j & 21) != 0) {
                str2 = "C: " + ViewUtil.subNumber(UnitFormat.newBuilder("0.##########", UnitFormat.SI.MICRO).convert(fftParam != null ? fftParam.getCenter() : 0L) + ServiceEnum.Unit.Unit_hz.value2, 4);
            } else {
                str2 = null;
            }
        } else {
            str = null;
            str2 = null;
            i = 0;
            z = false;
            i2 = 0;
        }
        if ((4160 & j) != 0) {
            i3 = ColorUtil.getColor(getRoot().getContext(), fftParam != null ? fftParam.getServiceId() : 0);
            drawable = (64 & j) != 0 ? ContextUtil.getSelectedBackground(R.drawable.bg_item_math, i3) : null;
        } else {
            drawable = null;
            i3 = 0;
        }
        int i6 = ((19 & j) > 0L ? 1 : ((19 & j) == 0L ? 0 : -1));
        if (i6 != 0) {
            if (!z) {
                drawable = ContextUtil.getDrawable(R.drawable.bg_item_math);
            }
            drawable2 = drawable;
            if (!z) {
                i3 = ContextCompat.getColor(getRoot().getContext(), R.color.gray_regent);
            }
            i4 = i3;
        }
        Drawable drawable3 = drawable2;
        int i7 = i4;
        if ((21 & j) != 0) {
            TextViewBindingAdapter.setText(this.center, str2);
        }
        if (i6 != 0) {
            this.center.setTextColor(i);
            ViewBindingAdapter.setBackground(this.mboundView0, drawable3);
            this.span.setTextColor(i2);
            this.title.setTextColor(i7);
        }
        if ((j & 25) != 0) {
            TextViewBindingAdapter.setText(this.span, str);
        }
    }
}
