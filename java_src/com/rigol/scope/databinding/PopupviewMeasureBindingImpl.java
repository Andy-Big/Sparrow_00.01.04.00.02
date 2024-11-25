package com.rigol.scope.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableInt;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.rigol.scope.R;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.MeasureSettingParam;
import com.rigol.scope.generated.callback.OnClickListener;
/* loaded from: classes2.dex */
public class PopupviewMeasureBindingImpl extends PopupviewMeasureBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback56;
    private final View.OnClickListener mCallback57;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.tabs, 7);
        sViewsWithIds.put(R.id.header, 8);
        sViewsWithIds.put(R.id.holder1_title, 9);
        sViewsWithIds.put(R.id.view_pager, 10);
    }

    public PopupviewMeasureBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 11, sIncludes, sViewsWithIds));
    }

    private PopupviewMeasureBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 4, (ConstraintLayout) objArr[8], (TextView) objArr[2], (TextView) objArr[9], (TextView) objArr[4], (TextView) objArr[3], (ImageView) objArr[1], (Button) objArr[6], (TabLayout) objArr[7], (Button) objArr[5], (ViewPager2) objArr[10]);
        this.mDirtyFlags = -1L;
        this.holder1Spinner.setTag(null);
        this.holder2Spinner.setTag(null);
        this.holder2Title.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.pic.setTag(null);
        this.settingBtn.setTag(null);
        this.verticalSetting.setTag(null);
        setRootTag(view);
        this.mCallback57 = new OnClickListener(this, 2);
        this.mCallback56 = new OnClickListener(this, 1);
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
            setParam((MeasureSettingParam) obj);
        } else if (569 == i) {
            setOnClickListener((View.OnClickListener) obj);
        } else if (639 != i) {
            return false;
        } else {
            setPicObservable((ObservableInt) obj);
        }
        return true;
    }

    @Override // com.rigol.scope.databinding.PopupviewMeasureBinding
    public void setParam(MeasureSettingParam measureSettingParam) {
        updateRegistration(0, measureSettingParam);
        this.mParam = measureSettingParam;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(594);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewMeasureBinding
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        notifyPropertyChanged(569);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewMeasureBinding
    public void setPicObservable(ObservableInt observableInt) {
        updateRegistration(2, observableInt);
        this.mPicObservable = observableInt;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(639);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return false;
                    }
                    return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgAppMeasSrcaParamSelectSourceAValue1((MappingObject) obj, i2);
                }
                return onChangePicObservable((ObservableInt) obj, i2);
            }
            return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgAppMeasSrcbParamSelectSourceBValue1((MappingObject) obj, i2);
        }
        return onChangeParam((MeasureSettingParam) obj, i2);
    }

    private boolean onChangeParam(MeasureSettingParam measureSettingParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i == 792) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        } else if (i == 834) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        } else if (i == 793) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgAppMeasSrcbParamSelectSourceBValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
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

    private boolean onChangePicObservable(ObservableInt observableInt, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgAppMeasSrcaParamSelectSourceAValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 512;
            }
            return true;
        } else {
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00b5  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 367
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rigol.scope.databinding.PopupviewMeasureBindingImpl.executeBindings():void");
    }

    @Override // com.rigol.scope.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int i, View view) {
        if (i == 1) {
            View.OnClickListener onClickListener = this.mOnClickListener;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        } else if (i != 2) {
        } else {
            View.OnClickListener onClickListener2 = this.mOnClickListener;
            if (onClickListener2 != null) {
                onClickListener2.onClick(view);
            }
        }
    }
}
