package com.rigol.scope.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.rigol.scope.R;
import com.rigol.scope.data.SelfTestParam;

/* loaded from: classes2.dex */
public class AdapterItemSelfTestBindingImpl extends AdapterItemSelfTestBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public AdapterItemSelfTestBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 5, sIncludes, sViewsWithIds));
    }

    private AdapterItemSelfTestBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[4], (TextView) objArr[2], (TextView) objArr[3], (TextView) objArr[1]);
        this.mDirtyFlags = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.tvId.setTag(null);
        this.tvItemValue.setTag(null);
        this.tvSelfRange.setTag(null);
        this.tvSelfTestItem.setTag(null);
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
            setParam((SelfTestParam) obj);
        } else if (433 != i) {
            return false;
        } else {
            setIndex((Integer) obj);
        }
        return true;
    }

    @Override // com.rigol.scope.databinding.AdapterItemSelfTestBinding
    public void setParam(SelfTestParam selfTestParam) {
        this.mParam = selfTestParam;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(594);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterItemSelfTestBinding
    public void setIndex(Integer num) {
        this.mIndex = num;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(433);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        int i;
        int i2;
        int i3;
        String str;
        String str2;
        String str3;
        int i4;
        long j2;
        long j3;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        SelfTestParam selfTestParam = this.mParam;
        Integer num = this.mIndex;
        int i5 = ((j & 5) > 0L ? 1 : ((j & 5) == 0L ? 0 : -1));
        if (i5 != 0) {
            if (selfTestParam != null) {
                i4 = selfTestParam.getResult();
                str2 = selfTestParam.getRange();
                str3 = selfTestParam.getItem();
                str = selfTestParam.getValue();
            } else {
                i4 = 0;
                str = null;
                str2 = null;
                str3 = null;
            }
            r11 = i4 == 1 ? 1 : 0;
            if (i5 != 0) {
                if (r11 != 0) {
                    j2 = j | 16 | 64 | 256;
                    j3 = PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
                } else {
                    j2 = j | 8 | 32 | 128;
                    j3 = 512;
                }
                j = j2 | j3;
            }
            TextView textView = this.tvSelfTestItem;
            i3 = r11 != 0 ? getColorFromResource(textView, R.color.white) : getColorFromResource(textView, R.color.red);
            TextView textView2 = this.tvId;
            int colorFromResource = r11 != 0 ? getColorFromResource(textView2, R.color.white) : getColorFromResource(textView2, R.color.red);
            TextView textView3 = this.tvItemValue;
            i = r11 != 0 ? getColorFromResource(textView3, R.color.white) : getColorFromResource(textView3, R.color.red);
            TextView textView4 = this.tvSelfRange;
            i2 = r11 != 0 ? getColorFromResource(textView4, R.color.white) : getColorFromResource(textView4, R.color.red);
            r11 = colorFromResource;
        } else {
            i = 0;
            i2 = 0;
            i3 = 0;
            str = null;
            str2 = null;
            str3 = null;
        }
        int i6 = ((6 & j) > 0L ? 1 : ((6 & j) == 0L ? 0 : -1));
        String valueOf = i6 != 0 ? String.valueOf(ViewDataBinding.safeUnbox(num)) : null;
        if (i6 != 0) {
            TextViewBindingAdapter.setText(this.tvId, valueOf);
        }
        if ((j & 5) != 0) {
            this.tvId.setTextColor(r11);
            TextViewBindingAdapter.setText(this.tvItemValue, str);
            this.tvItemValue.setTextColor(i);
            TextViewBindingAdapter.setText(this.tvSelfRange, str2);
            this.tvSelfRange.setTextColor(i2);
            TextViewBindingAdapter.setText(this.tvSelfTestItem, str3);
            this.tvSelfTestItem.setTextColor(i3);
        }
    }
}
