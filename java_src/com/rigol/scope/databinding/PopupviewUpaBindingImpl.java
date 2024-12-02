package com.rigol.scope.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.CompoundButtonBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.rigol.scope.R;
import com.rigol.scope.data.HorizontalParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.UpaParam;
import com.rigol.scope.data.UpaRippleParam;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.views.SwitchButton;

/* loaded from: classes2.dex */
public class PopupviewUpaBindingImpl extends PopupviewUpaBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.right_guideline, 3);
        sViewsWithIds.put(R.id.left_guideline, 4);
        sViewsWithIds.put(R.id.left_guideline2, 5);
        sViewsWithIds.put(R.id.upa_spring, 6);
        sViewsWithIds.put(R.id.no_text, 7);
        sViewsWithIds.put(R.id.adaper_upa_view, 8);
    }

    public PopupviewUpaBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 9, sIncludes, sViewsWithIds));
    }

    private PopupviewUpaBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 5, (RecyclerView) objArr[8], (SwitchButton) objArr[2], (Guideline) objArr[4], (Guideline) objArr[5], (TextView) objArr[7], (Guideline) objArr[3], (TextView) objArr[1], (TextView) objArr[6]);
        this.mDirtyFlags = -1L;
        this.displayOnoffSwitchButton.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.upaAnalysisSpinner.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 512L;
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
            setParam((UpaParam) obj);
        } else if (992 == i) {
            setUpaMappingObj((MappingObject) obj);
        } else if (993 == i) {
            setUpaRippleParam((UpaRippleParam) obj);
        } else if (382 != i) {
            return false;
        } else {
            setHorizontalParam((HorizontalParam) obj);
        }
        return true;
    }

    @Override // com.rigol.scope.databinding.PopupviewUpaBinding
    public void setParam(UpaParam upaParam) {
        updateRegistration(0, upaParam);
        this.mParam = upaParam;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(594);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewUpaBinding
    public void setUpaMappingObj(MappingObject mappingObject) {
        this.mUpaMappingObj = mappingObject;
    }

    @Override // com.rigol.scope.databinding.PopupviewUpaBinding
    public void setUpaRippleParam(UpaRippleParam upaRippleParam) {
        updateRegistration(2, upaRippleParam);
        this.mUpaRippleParam = upaRippleParam;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(993);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewUpaBinding
    public void setHorizontalParam(HorizontalParam horizontalParam) {
        this.mHorizontalParam = horizontalParam;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            return false;
                        }
                        return onChangeHorizontalParam((HorizontalParam) obj, i2);
                    }
                    return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgUpaTypeParamType((MappingObject) obj, i2);
                }
                return onChangeUpaRippleParam((UpaRippleParam) obj, i2);
            }
            return onChangeUpaMappingObj((MappingObject) obj, i2);
        }
        return onChangeParam((UpaParam) obj, i2);
    }

    private boolean onChangeParam(UpaParam upaParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i == 978) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        } else if (i == 726) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeUpaMappingObj(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeUpaRippleParam(UpaRippleParam upaRippleParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else if (i == 726) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgUpaTypeParamType(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 256;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeHorizontalParam(HorizontalParam horizontalParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void executeBindings() {
        long j;
        boolean z;
        String str;
        int i;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        UpaParam upaParam = this.mParam;
        UpaRippleParam upaRippleParam = this.mUpaRippleParam;
        if ((1005 & j) != 0) {
            int type = upaParam != null ? upaParam.getType() : 0;
            int i2 = ((j & 741) > 0L ? 1 : ((j & 741) == 0L ? 0 : -1));
            if (i2 != 0) {
                z = type == 0;
                if (i2 != 0) {
                    j = z ? j | PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH : j | PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
                }
            } else {
                z = false;
            }
            if ((j & 809) != 0) {
                MappingObject mappingObject = ViewUtil.getMappingObject(R.array.msg_upa_type, type);
                updateRegistration(3, mappingObject);
                if (mappingObject != null) {
                    str = mappingObject.getStr();
                    i = ((741 & j) > 0L ? 1 : ((741 & j) == 0L ? 0 : -1));
                    boolean refPowerDisp = i != 0 ? z ? ((PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH & j) != 0 || upaParam == null) ? false : upaParam.getRefPowerDisp() : ((PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID & j) != 0 || upaRippleParam == null) ? false : upaRippleParam.getRefPowerDisp() : false;
                    if (i != 0) {
                        CompoundButtonBindingAdapter.setChecked(this.displayOnoffSwitchButton, refPowerDisp);
                    }
                    if ((j & 809) == 0) {
                        TextViewBindingAdapter.setText(this.upaAnalysisSpinner, str);
                        return;
                    }
                    return;
                }
            }
        } else {
            z = false;
        }
        str = null;
        if ((PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID & j) != 0) {
        }
        i = ((741 & j) > 0L ? 1 : ((741 & j) == 0L ? 0 : -1));
        boolean refPowerDisp2 = i != 0 ? z ? ((PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH & j) != 0 || upaParam == null) ? false : upaParam.getRefPowerDisp() : ((PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID & j) != 0 || upaRippleParam == null) ? false : upaRippleParam.getRefPowerDisp() : false;
        if (i != 0) {
        }
        if ((j & 809) == 0) {
        }
    }
}
