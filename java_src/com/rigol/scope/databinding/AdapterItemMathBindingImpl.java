package com.rigol.scope.databinding;

import android.graphics.drawable.Drawable;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.databinding.adapters.ViewBindingAdapter;
import com.rigol.scope.R;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.MathParam;
import com.rigol.scope.utilities.ViewUtil;
/* loaded from: classes2.dex */
public class AdapterItemMathBindingImpl extends AdapterItemMathBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    public AdapterItemMathBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 5, sIncludes, sViewsWithIds));
    }

    private AdapterItemMathBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (TextView) objArr[4], (TextView) objArr[3], (TextView) objArr[2], (TextView) objArr[1]);
        this.mDirtyFlags = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.operator.setTag(null);
        this.position.setTag(null);
        this.scale.setTag(null);
        this.title.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 256L;
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
            setParam((MathParam) obj);
        } else if (451 != i) {
            return false;
        } else {
            setItemPosition((Integer) obj);
        }
        return true;
    }

    @Override // com.rigol.scope.databinding.AdapterItemMathBinding
    public void setParam(MathParam mathParam) {
        updateRegistration(0, mathParam);
        this.mParam = mathParam;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(594);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterItemMathBinding
    public void setItemPosition(Integer num) {
        this.mItemPosition = num;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            if (i != 1) {
                return false;
            }
            return onChangeViewUtilGetListComRigolScopeRArrayMsgMathList2GetParamGetServiceIdInt17((MappingObject) obj, i2);
        }
        return onChangeParam((MathParam) obj, i2);
    }

    private boolean onChangeParam(MathParam mathParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i == 909) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        } else if (i == 777) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        } else if (i == 566) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        } else if (i == 574) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetListComRigolScopeRArrayMsgMathList2GetParamGetServiceIdInt17(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
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
        String str3;
        String str4;
        int i;
        int i2;
        int i3;
        boolean z;
        int i4;
        long j2;
        long j3;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        MathParam mathParam = this.mParam;
        Drawable drawable = null;
        int i5 = 0;
        if ((507 & j) != 0) {
            str = ((j & 273) == 0 || mathParam == null) ? null : mathParam.getScaleString();
            String offsetString = ((j & 289) == 0 || mathParam == null) ? null : mathParam.getOffsetString();
            int i6 = ((j & 265) > 0L ? 1 : ((j & 265) == 0L ? 0 : -1));
            if (i6 != 0) {
                z = mathParam != null ? mathParam.getStatus() : false;
                if (i6 != 0) {
                    if (z) {
                        j2 = j | PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID | PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM | PlaybackStateCompat.ACTION_PREPARE | PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
                        j3 = PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
                    } else {
                        j2 = j | 512 | PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH | PlaybackStateCompat.ACTION_PLAY_FROM_URI | PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
                        j3 = PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
                    }
                    j = j2 | j3;
                }
                i4 = -1;
                i3 = z ? -1 : getColorFromResource(this.scale, R.color.gray_regent);
                i2 = z ? -1 : getColorFromResource(this.position, R.color.gray_regent);
                if (!z) {
                    i4 = getColorFromResource(this.operator, R.color.gray_regent);
                }
            } else {
                i2 = 0;
                i3 = 0;
                i4 = 0;
                z = false;
            }
            if ((j & 387) != 0) {
                MappingObject mappingObject = ViewUtil.getList((int) R.array.msg_math_list2).get((mathParam != null ? mathParam.getServiceId() : 0) - 17);
                updateRegistration(1, mappingObject);
                if (mappingObject != null) {
                    str3 = mappingObject.getStr();
                    str4 = ((j & 321) != 0 || mathParam == null) ? null : mathParam.getOperatorString();
                    str2 = offsetString;
                    i = i4;
                }
            }
            str3 = null;
            if ((j & 321) != 0) {
            }
            str2 = offsetString;
            i = i4;
        } else {
            str = null;
            str2 = null;
            str3 = null;
            str4 = null;
            i = 0;
            i2 = 0;
            i3 = 0;
            z = false;
        }
        int defaultColor = ((j & PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM) == 0 || mathParam == null) ? 0 : mathParam.getDefaultColor();
        Drawable selectedBackground = ((j & PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID) == 0 || mathParam == null) ? null : mathParam.getSelectedBackground();
        Drawable defaultBackground = ((512 & j) == 0 || mathParam == null) ? null : mathParam.getDefaultBackground();
        int closedColor = ((j & PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH) == 0 || mathParam == null) ? 0 : mathParam.getClosedColor();
        int i7 = ((j & 265) > 0L ? 1 : ((j & 265) == 0L ? 0 : -1));
        if (i7 != 0) {
            drawable = z ? selectedBackground : defaultBackground;
            i5 = z ? defaultColor : closedColor;
        }
        Drawable drawable2 = drawable;
        int i8 = i5;
        if (i7 != 0) {
            ViewBindingAdapter.setBackground(this.mboundView0, drawable2);
            this.operator.setTextColor(i);
            this.position.setTextColor(i2);
            this.scale.setTextColor(i3);
            this.title.setTextColor(i8);
        }
        if ((j & 321) != 0) {
            TextViewBindingAdapter.setText(this.operator, str4);
        }
        if ((j & 289) != 0) {
            TextViewBindingAdapter.setText(this.position, str2);
        }
        if ((j & 273) != 0) {
            TextViewBindingAdapter.setText(this.scale, str);
        }
        if ((j & 387) != 0) {
            TextViewBindingAdapter.setText(this.title, str3);
        }
    }
}
