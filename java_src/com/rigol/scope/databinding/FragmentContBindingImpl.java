package com.rigol.scope.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.MutableLiveData;
import com.rigol.scope.R;
import com.rigol.scope.data.LeftStatusBarParam;
import com.rigol.scope.data.MenuParam;
import com.rigol.scope.views.waveview.AwgPlotView;
/* loaded from: classes2.dex */
public class FragmentContBindingImpl extends FragmentContBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.modeSpinner, 5);
        sViewsWithIds.put(R.id.trigButton, 6);
        sViewsWithIds.put(R.id.middleView, 7);
        sViewsWithIds.put(R.id.bottomView, 8);
        sViewsWithIds.put(R.id.switch1View, 9);
        sViewsWithIds.put(R.id.rigol1View, 10);
        sViewsWithIds.put(R.id.switch2View, 11);
        sViewsWithIds.put(R.id.rigol2View, 12);
        sViewsWithIds.put(R.id.switch3View, 13);
        sViewsWithIds.put(R.id.rigol3View, 14);
        sViewsWithIds.put(R.id.startPhaseText, 15);
        sViewsWithIds.put(R.id.startPhaseEdit, 16);
        sViewsWithIds.put(R.id.dutyCycleText, 17);
        sViewsWithIds.put(R.id.dutyCycleEdit, 18);
        sViewsWithIds.put(R.id.afgView, 19);
        sViewsWithIds.put(R.id.rowListView, 20);
    }

    public FragmentContBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 21, sIncludes, sViewsWithIds));
    }

    private FragmentContBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 4, (AwgPlotView) objArr[19], (View) objArr[1], (View) objArr[8], (TextView) objArr[2], (TextView) objArr[18], (TextView) objArr[17], (View) objArr[7], (TextView) objArr[5], (TextView) objArr[3], (AppCompatTextView) objArr[10], (AppCompatTextView) objArr[12], (AppCompatTextView) objArr[14], (AppCompatTextView) objArr[20], (TextView) objArr[16], (TextView) objArr[15], (AppCompatTextView) objArr[9], (AppCompatTextView) objArr[11], (AppCompatTextView) objArr[13], (TextView) objArr[6], (TextView) objArr[4]);
        this.mDirtyFlags = -1L;
        this.bgView.setTag(null);
        this.channelText.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.onText.setTag(null);
        this.waveformSpinner.setTag(null);
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
        if (483 == i) {
            setLeftStatusBarParam((LeftStatusBarParam) obj);
        } else if (533 != i) {
            return false;
        } else {
            setMenuParam((MenuParam) obj);
        }
        return true;
    }

    @Override // com.rigol.scope.databinding.FragmentContBinding
    public void setLeftStatusBarParam(LeftStatusBarParam leftStatusBarParam) {
        this.mLeftStatusBarParam = leftStatusBarParam;
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        notifyPropertyChanged(483);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.FragmentContBinding
    public void setMenuParam(MenuParam menuParam) {
        this.mMenuParam = menuParam;
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        notifyPropertyChanged(533);
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
                    return onChangeMenuParamWaveform((MutableLiveData) obj, i2);
                }
                return onChangeLeftStatusBarParamColor((MutableLiveData) obj, i2);
            }
            return onChangeLeftStatusBarParamChannelEnable((MutableLiveData) obj, i2);
        }
        return onChangeLeftStatusBarParamSelectChanEnable((MutableLiveData) obj, i2);
    }

    private boolean onChangeLeftStatusBarParamSelectChanEnable(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeLeftStatusBarParamChannelEnable(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeLeftStatusBarParamColor(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeMenuParamWaveform(MutableLiveData<String> mutableLiveData, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:131:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0150  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 433
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rigol.scope.databinding.FragmentContBindingImpl.executeBindings():void");
    }
}
