package com.rigol.scope.databinding;

import android.graphics.drawable.Drawable;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.ImageViewBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.rigol.scope.R;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.MeasureResultParam;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.views.DisableTouchEventRecyclerView;
import com.rigol.scope.views.resultItem.ResultItemConstraintLayout;

/* loaded from: classes2.dex */
public class AdapterItemResultMeasureBindingImpl extends AdapterItemResultMeasureBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ResultItemConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.title_layout, 5);
        sViewsWithIds.put(R.id.title, 6);
    }

    public AdapterItemResultMeasureBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 7, sIncludes, sViewsWithIds));
    }

    private AdapterItemResultMeasureBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (ImageView) objArr[4], (TextView) objArr[3], (ImageView) objArr[1], (DisableTouchEventRecyclerView) objArr[2], (TextView) objArr[6], (LinearLayout) objArr[5]);
        this.mDirtyFlags = -1L;
        this.arrow.setTag(null);
        this.currentResult.setTag(null);
        this.icon.setTag(null);
        ResultItemConstraintLayout resultItemConstraintLayout = (ResultItemConstraintLayout) objArr[0];
        this.mboundView0 = resultItemConstraintLayout;
        resultItemConstraintLayout.setTag(null);
        this.resultList.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 4L;
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
            setParam((MeasureResultParam) obj);
            return true;
        }
        return false;
    }

    @Override // com.rigol.scope.databinding.AdapterItemResultMeasureBinding
    public void setParam(MeasureResultParam measureResultParam) {
        updateRegistration(0, measureResultParam);
        this.mParam = measureResultParam;
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
        return onChangeParam((MeasureResultParam) obj, i2);
    }

    private boolean onChangeParam(MeasureResultParam measureResultParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i == 528) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        } else {
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:79:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void executeBindings() {
        long j;
        int i;
        boolean z;
        int i2;
        Drawable drawable;
        Drawable drawable2;
        String str;
        int i3;
        int i4;
        int i5;
        String str2;
        long j2;
        long j3;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        MeasureResultParam measureResultParam = this.mParam;
        int i6 = ((j & 7) > 0L ? 1 : ((j & 7) == 0L ? 0 : -1));
        if (i6 != 0) {
            ServiceEnum.MeasType measType = measureResultParam != null ? measureResultParam.getMeasType() : null;
            String str3 = measType != null ? measType.pic1 : null;
            z = measType != null;
            if (i6 != 0) {
                j = z ? j | 16 : j | 8;
            }
            Drawable drawable3 = ContextUtil.getDrawable(getRoot().getContext(), str3);
            int i7 = ((j & 5) > 0L ? 1 : ((j & 5) == 0L ? 0 : -1));
            if (i7 != 0) {
                if (measureResultParam != null) {
                    str2 = measureResultParam.getCur();
                    i5 = measureResultParam.getStat();
                } else {
                    i5 = 0;
                    str2 = null;
                }
                boolean z2 = i5 == 1;
                if (i7 != 0) {
                    if (z2) {
                        j2 = j | 64 | 256;
                        j3 = PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
                    } else {
                        j2 = j | 32 | 128;
                        j3 = 512;
                    }
                    j = j2 | j3;
                }
                Drawable drawable4 = z2 ? AppCompatResources.getDrawable(this.arrow.getContext(), R.drawable.ic_arrow_up3) : AppCompatResources.getDrawable(this.arrow.getContext(), R.drawable.ic_arrow_down3);
                i2 = z2 ? 0 : 8;
                i = z2 ? 8 : 0;
                str = str2;
                drawable2 = drawable3;
                drawable = drawable4;
                boolean z3 = (16 & j) == 0 && drawable2 != null;
                i3 = ((j & 7) > 0L ? 1 : ((j & 7) == 0L ? 0 : -1));
                if (i3 != 0) {
                    if (!z) {
                        z3 = false;
                    }
                    if (i3 != 0) {
                        j |= z3 ? PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM : PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
                    }
                    if (!z3) {
                        i4 = 8;
                        if ((5 & j) != 0) {
                            ImageViewBindingAdapter.setImageDrawable(this.arrow, drawable);
                            TextViewBindingAdapter.setText(this.currentResult, str);
                            this.currentResult.setVisibility(i);
                            this.resultList.setVisibility(i2);
                        }
                        if ((j & 7) != 0) {
                            ImageViewBindingAdapter.setImageDrawable(this.icon, drawable2);
                            this.icon.setVisibility(i4);
                            return;
                        }
                        return;
                    }
                }
                i4 = 0;
                if ((5 & j) != 0) {
                }
                if ((j & 7) != 0) {
                }
            } else {
                drawable2 = drawable3;
                i = 0;
                i2 = 0;
                drawable = null;
            }
        } else {
            i = 0;
            z = false;
            i2 = 0;
            drawable = null;
            drawable2 = null;
        }
        str = null;
        if ((16 & j) == 0) {
        }
        i3 = ((j & 7) > 0L ? 1 : ((j & 7) == 0L ? 0 : -1));
        if (i3 != 0) {
        }
        i4 = 0;
        if ((5 & j) != 0) {
        }
        if ((j & 7) != 0) {
        }
    }
}
