package com.rigol.scope.databinding;

import android.graphics.drawable.Drawable;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.SpannableString;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.ImageViewBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.rigol.scope.R;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.CursorResultParam;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.views.DisableTouchEventRecyclerView;
import com.rigol.scope.views.resultItem.ResultItemConstraintLayout;
/* loaded from: classes2.dex */
public class AdapterItemResultCursorBindingImpl extends AdapterItemResultCursorBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ResultItemConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.title_layout, 3);
        sViewsWithIds.put(R.id.result_list, 4);
    }

    public AdapterItemResultCursorBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 5, sIncludes, sViewsWithIds));
    }

    private AdapterItemResultCursorBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (ImageView) objArr[1], (DisableTouchEventRecyclerView) objArr[4], (TextView) objArr[2], (ConstraintLayout) objArr[3]);
        this.mDirtyFlags = -1L;
        this.icon.setTag(null);
        ResultItemConstraintLayout resultItemConstraintLayout = (ResultItemConstraintLayout) objArr[0];
        this.mboundView0 = resultItemConstraintLayout;
        resultItemConstraintLayout.setTag(null);
        this.title.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 64L;
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
            setParam((CursorResultParam) obj);
            return true;
        }
        return false;
    }

    @Override // com.rigol.scope.databinding.AdapterItemResultCursorBinding
    public void setParam(CursorResultParam cursorResultParam) {
        updateRegistration(0, cursorResultParam);
        this.mParam = cursorResultParam;
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
        return onChangeParam((CursorResultParam) obj, i2);
    }

    private boolean onChangeParam(CursorResultParam cursorResultParam, int i) {
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
        } else if (i == 205) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else if (i == 939) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        } else if (i == 862) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        } else if (i == 866) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
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
        Drawable drawable;
        String str;
        ServiceEnum.Chan chan;
        SpannableString spannableString;
        SpannableString spannableString2;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        CursorResultParam cursorResultParam = this.mParam;
        int i = 0;
        if ((127 & j) != 0) {
            int i2 = ((j & 67) > 0L ? 1 : ((j & 67) == 0L ? 0 : -1));
            if (i2 != 0) {
                ServiceEnum.MeasType measType = cursorResultParam != null ? cursorResultParam.getMeasType() : null;
                String str2 = measType != null ? measType.pic1 : null;
                z = measType != null;
                if (i2 != 0) {
                    j = z ? j | 256 : j | 128;
                }
                drawable = ContextUtil.getDrawable(getRoot().getContext(), str2);
            } else {
                z = false;
                drawable = null;
            }
            int i3 = ((j & 125) > 0L ? 1 : ((j & 125) == 0L ? 0 : -1));
            if (i3 != 0) {
                z2 = (cursorResultParam != null ? cursorResultParam.getCursorMode() : null) != ServiceEnum.CursorMode.cursor_mode_manual;
                if (i3 != 0) {
                    j = z2 ? j | PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM : j | PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
                }
            } else {
                z2 = false;
            }
        } else {
            z = false;
            z2 = false;
            drawable = null;
        }
        if ((j & 6144) != 0) {
            if (cursorResultParam != null) {
                str = cursorResultParam.getTitle();
                chan = cursorResultParam.getSourceA();
            } else {
                str = null;
                chan = null;
            }
            spannableString = (j & PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH) != 0 ? ViewUtil.getTitleWithSrc(getRoot().getContext(), str, chan) : null;
        } else {
            str = null;
            chan = null;
            spannableString = null;
        }
        if ((PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM & j) != 0) {
            spannableString2 = ViewUtil.getTitleWithSrc(getRoot().getContext(), str, chan, cursorResultParam != null ? cursorResultParam.getSourceB() : null);
        } else {
            spannableString2 = null;
        }
        boolean z3 = ((256 & j) == 0 || drawable == null) ? false : true;
        int i4 = ((j & 67) > 0L ? 1 : ((j & 67) == 0L ? 0 : -1));
        if (i4 != 0) {
            if (!z) {
                z3 = false;
            }
            if (i4 != 0) {
                j |= z3 ? PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID : 512L;
            }
            if (!z3) {
                i = 8;
            }
        }
        int i5 = i;
        int i6 = ((125 & j) > 0L ? 1 : ((125 & j) == 0L ? 0 : -1));
        SpannableString spannableString3 = i6 != 0 ? z2 ? spannableString2 : spannableString : null;
        if ((j & 67) != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.icon, drawable);
            this.icon.setVisibility(i5);
        }
        if (i6 != 0) {
            TextViewBindingAdapter.setText(this.title, spannableString3);
        }
    }
}
