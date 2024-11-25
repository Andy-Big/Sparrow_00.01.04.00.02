package com.rigol.scope.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.rigol.scope.R;
import com.rigol.scope.data.HorizontalParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.SearchParam;
import com.rigol.scope.views.SwitchButton;
/* loaded from: classes2.dex */
public class PopupviewSearchBindingImpl extends PopupviewSearchBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.guideline_center, 13);
        sViewsWithIds.put(R.id.dividing_line1, 14);
        sViewsWithIds.put(R.id.search_view, 15);
        sViewsWithIds.put(R.id.dividing_line2, 16);
        sViewsWithIds.put(R.id.navigateBut, 17);
    }

    public PopupviewSearchBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 18, sIncludes, sViewsWithIds));
    }

    private PopupviewSearchBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3, (Button) objArr[12], (Button) objArr[10], (View) objArr[14], (View) objArr[16], (TextView) objArr[1], (SwitchButton) objArr[2], (Guideline) objArr[13], (TextView) objArr[5], (SwitchButton) objArr[6], (Button) objArr[17], (EditText) objArr[8], (ImageView) objArr[7], (ImageView) objArr[9], (Button) objArr[11], (RecyclerView) objArr[15], (TextView) objArr[3], (TextView) objArr[4]);
        this.mDirtyFlags = -1L;
        this.copyFromTriggerBtn.setTag(null);
        this.copyToTriggerBtn.setTag(null);
        this.enable.setTag(null);
        this.enableSwitchButton.setTag(null);
        this.markTable.setTag(null);
        this.markTableSwitchButton.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.navigation.setTag(null);
        this.playLastImage.setTag(null);
        this.playnextImage.setTag(null);
        this.saveBtn.setTag(null);
        this.type.setTag(null);
        this.typeSpinner.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
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
            setParam((SearchParam) obj);
        } else if (380 != i) {
            return false;
        } else {
            setHorizontal((HorizontalParam) obj);
        }
        return true;
    }

    @Override // com.rigol.scope.databinding.PopupviewSearchBinding
    public void setParam(SearchParam searchParam) {
        updateRegistration(0, searchParam);
        this.mParam = searchParam;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(594);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewSearchBinding
    public void setHorizontal(HorizontalParam horizontalParam) {
        updateRegistration(2, horizontalParam);
        this.mHorizontal = horizontalParam;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(380);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    return false;
                }
                return onChangeHorizontal((HorizontalParam) obj, i2);
            }
            return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgSearchTypeParamTypeValue1((MappingObject) obj, i2);
        }
        return onChangeParam((SearchParam) obj, i2);
    }

    private boolean onChangeParam(SearchParam searchParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i == 271) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        } else if (i == 978) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        } else if (i == 519) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        } else if (i == 557) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgSearchTypeParamTypeValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeHorizontal(HorizontalParam horizontalParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else if (i == 28) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
            }
            return true;
        } else if (i == 935) {
            synchronized (this) {
                this.mDirtyFlags |= 256;
            }
            return true;
        } else if (i == 760) {
            synchronized (this) {
                this.mDirtyFlags |= 512;
            }
            return true;
        } else {
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:152:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0070  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 564
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rigol.scope.databinding.PopupviewSearchBindingImpl.executeBindings():void");
    }
}
