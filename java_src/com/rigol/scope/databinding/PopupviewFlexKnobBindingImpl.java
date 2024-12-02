package com.rigol.scope.databinding;

import android.graphics.drawable.Drawable;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.InverseBindingListener;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.CompoundButtonBindingAdapter;
import androidx.databinding.adapters.ImageViewBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.rigol.scope.R;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.FlexKnobParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.utilities.ContextUtil;

/* loaded from: classes2.dex */
public class PopupviewFlexKnobBindingImpl extends PopupviewFlexKnobBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.title_layout, 12);
        sViewsWithIds.put(R.id.guideline_left, 13);
        sViewsWithIds.put(R.id.guideline_right, 14);
        sViewsWithIds.put(R.id.guideline_center, 15);
        sViewsWithIds.put(R.id.direction_type, 16);
        sViewsWithIds.put(R.id.direction_radio_group, 17);
    }

    public PopupviewFlexKnobBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 18, sIncludes, sViewsWithIds));
    }

    private PopupviewFlexKnobBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3, (RadioButton) objArr[1], (RadioGroup) objArr[17], (TextView) objArr[16], (Guideline) objArr[15], (Guideline) objArr[13], (Guideline) objArr[14], (RadioButton) objArr[2], (ImageView) objArr[6], (RecyclerView) objArr[11], (View) objArr[12], (TextView) objArr[7], (TextView) objArr[9], (TextView) objArr[8], (TextView) objArr[10], (TextView) objArr[3], (TextView) objArr[4], (View) objArr[5]);
        this.mDirtyFlags = -1L;
        this.autoRadioButton.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.offRadioButton.setTag(null);
        this.pic.setTag(null);
        this.recyclerView.setTag(null);
        this.tvAHint.setTag(null);
        this.tvAHintContent.setTag(null);
        this.tvBHint.setTag(null);
        this.tvBHintContent.setTag(null);
        this.tvHint.setTag(null);
        this.tvHintContent.setTag(null);
        this.viewTop.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 128L;
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
        if (15 == i) {
            setPopupviewFlexKnobBinding((FlexKnobParam) obj);
        } else if (594 == i) {
            setParam((FlexKnobParam) obj);
        } else if (177 != i) {
            return false;
        } else {
            setCheckedChangeListener((CompoundButton.OnCheckedChangeListener) obj);
        }
        return true;
    }

    @Override // com.rigol.scope.databinding.PopupviewFlexKnobBinding
    public void setPopupviewFlexKnobBinding(FlexKnobParam flexKnobParam) {
        this.mPopupviewFlexKnobBinding = flexKnobParam;
    }

    @Override // com.rigol.scope.databinding.PopupviewFlexKnobBinding
    public void setParam(FlexKnobParam flexKnobParam) {
        updateRegistration(1, flexKnobParam);
        this.mParam = flexKnobParam;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(594);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewFlexKnobBinding
    public void setCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.mCheckedChangeListener = onCheckedChangeListener;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(177);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    return false;
                }
                return onChangeParamCurrentMappingObject((MappingObject) obj, i2);
            }
            return onChangeParam((FlexKnobParam) obj, i2);
        }
        return onChangePopupviewFlexKnobBinding((FlexKnobParam) obj, i2);
    }

    private boolean onChangePopupviewFlexKnobBinding(FlexKnobParam flexKnobParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeParam(FlexKnobParam flexKnobParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        } else if (i == 176) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        } else if (i == 196) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeParamCurrentMappingObject(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else if (i == 638) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
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

    /* JADX WARN: Removed duplicated region for block: B:43:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00be  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void executeBindings() {
        long j;
        float f;
        float f2;
        Drawable drawable;
        String str;
        String str2;
        boolean z;
        boolean z2;
        int i;
        int i2;
        String str3;
        int i3;
        int i4;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        FlexKnobParam flexKnobParam = this.mParam;
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener = this.mCheckedChangeListener;
        if ((246 & j) != 0) {
            if ((j & 230) != 0) {
                MappingObject currentMappingObject = flexKnobParam != null ? flexKnobParam.getCurrentMappingObject() : null;
                updateRegistration(2, currentMappingObject);
                drawable = ((j & 166) == 0 || currentMappingObject == null) ? null : currentMappingObject.getPic();
                if ((j & 134) == 0 || currentMappingObject == null) {
                    str = null;
                    str3 = null;
                } else {
                    str = currentMappingObject.getKeyBStr();
                    str3 = currentMappingObject.getKeyAStr();
                }
                int i5 = ((j & 198) > 0L ? 1 : ((j & 198) == 0L ? 0 : -1));
                if (i5 != 0) {
                    boolean z3 = (currentMappingObject != null ? currentMappingObject.getValue() : 0) == ServiceEnum.FlexKnobEnum.Intensity.value1;
                    if (i5 != 0) {
                        j |= z3 ? PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH : PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
                    }
                    if (z3) {
                        i3 = 4;
                        i4 = ((j & 146) > 0L ? 1 : ((j & 146) == 0L ? 0 : -1));
                        if (i4 == 0) {
                            boolean isCheckDirection = flexKnobParam != null ? flexKnobParam.isCheckDirection() : false;
                            if (i4 != 0) {
                                j |= isCheckDirection ? 512L : 256L;
                            }
                            int i6 = isCheckDirection ? 0 : 4;
                            float alpha = ContextUtil.getAlpha(isCheckDirection);
                            z2 = !isCheckDirection;
                            f2 = ContextUtil.getAlpha(z2);
                            i2 = i3;
                            i = i6;
                            str2 = str3;
                            z = isCheckDirection;
                            f = alpha;
                        } else {
                            i2 = i3;
                            f = 0.0f;
                            f2 = 0.0f;
                            z = false;
                            z2 = false;
                            i = 0;
                            str2 = str3;
                        }
                    }
                }
            } else {
                drawable = null;
                str = null;
                str3 = null;
            }
            i3 = 0;
            i4 = ((j & 146) > 0L ? 1 : ((j & 146) == 0L ? 0 : -1));
            if (i4 == 0) {
            }
        } else {
            f = 0.0f;
            f2 = 0.0f;
            drawable = null;
            str = null;
            str2 = null;
            z = false;
            z2 = false;
            i = 0;
            i2 = 0;
        }
        int i7 = ((j & 136) > 0L ? 1 : ((j & 136) == 0L ? 0 : -1));
        if ((j & 146) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.autoRadioButton, z);
            CompoundButtonBindingAdapter.setChecked(this.offRadioButton, z2);
            this.pic.setEnabled(z2);
            this.recyclerView.setEnabled(z2);
            this.tvAHint.setEnabled(z2);
            this.tvAHintContent.setEnabled(z2);
            this.tvBHint.setEnabled(z2);
            this.tvBHintContent.setEnabled(z2);
            this.tvHint.setEnabled(z);
            this.tvHintContent.setEnabled(z);
            this.tvHintContent.setVisibility(i);
            this.viewTop.setEnabled(z2);
            if (getBuildSdkInt() >= 11) {
                this.pic.setAlpha(f2);
                this.recyclerView.setAlpha(f2);
                this.tvAHint.setAlpha(f2);
                this.tvAHintContent.setAlpha(f2);
                this.tvBHint.setAlpha(f2);
                this.tvBHintContent.setAlpha(f2);
                this.tvHint.setAlpha(f);
                this.tvHintContent.setAlpha(f);
                this.viewTop.setAlpha(f2);
            }
        }
        if (i7 != 0) {
            InverseBindingListener inverseBindingListener = null;
            CompoundButtonBindingAdapter.setListeners(this.autoRadioButton, onCheckedChangeListener, inverseBindingListener);
            CompoundButtonBindingAdapter.setListeners(this.offRadioButton, onCheckedChangeListener, inverseBindingListener);
        }
        if ((j & 166) != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.pic, drawable);
        }
        if ((134 & j) != 0) {
            TextViewBindingAdapter.setText(this.tvAHintContent, str2);
            TextViewBindingAdapter.setText(this.tvBHintContent, str);
        }
        if ((j & 198) != 0) {
            this.tvBHint.setVisibility(i2);
            this.tvBHintContent.setVisibility(i2);
        }
    }
}
