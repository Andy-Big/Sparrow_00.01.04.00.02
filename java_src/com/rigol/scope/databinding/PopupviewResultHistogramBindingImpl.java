package com.rigol.scope.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.generated.callback.OnClickListener;
import com.rigol.scope.views.SwitchButton;
import com.rigol.scope.views.histogram.HistogramResultParam;
/* loaded from: classes2.dex */
public class PopupviewResultHistogramBindingImpl extends PopupviewResultHistogramBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback67;
    private final View.OnClickListener mCallback68;
    private final View.OnClickListener mCallback69;
    private final View.OnClickListener mCallback70;
    private final View.OnClickListener mCallback71;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.guideline_center, 10);
        sViewsWithIds.put(R.id.guideline_left, 11);
        sViewsWithIds.put(R.id.guideline_right, 12);
        sViewsWithIds.put(R.id.enable, 13);
        sViewsWithIds.put(R.id.histogram_type, 14);
        sViewsWithIds.put(R.id.source, 15);
        sViewsWithIds.put(R.id.dispgrid, 16);
        sViewsWithIds.put(R.id.statisen, 17);
        sViewsWithIds.put(R.id.reset_button, 18);
        sViewsWithIds.put(R.id.dividing_line, 19);
        sViewsWithIds.put(R.id.rang_setup, 20);
        sViewsWithIds.put(R.id.leftpos, 21);
        sViewsWithIds.put(R.id.rightpos, 22);
        sViewsWithIds.put(R.id.highpos, 23);
        sViewsWithIds.put(R.id.lowpos, 24);
        sViewsWithIds.put(R.id.histo_reset, 25);
    }

    public PopupviewResultHistogramBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 26, sIncludes, sViewsWithIds));
    }

    private PopupviewResultHistogramBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 11, (TextView) objArr[16], (EditText) objArr[4], (View) objArr[19], (TextView) objArr[13], (Guideline) objArr[10], (Guideline) objArr[11], (Guideline) objArr[12], (TextView) objArr[23], (EditText) objArr[8], (TextView) objArr[25], (SwitchButton) objArr[1], (TextView) objArr[14], (TextView) objArr[2], (TextView) objArr[21], (EditText) objArr[6], (TextView) objArr[24], (EditText) objArr[9], (TextView) objArr[20], (Button) objArr[18], (TextView) objArr[22], (EditText) objArr[7], (TextView) objArr[15], (TextView) objArr[3], (TextView) objArr[17], (SwitchButton) objArr[5]);
        this.mDirtyFlags = -1L;
        this.dispgridEditText.setTag(null);
        this.highposEditText.setTag(null);
        this.histogramEn.setTag(null);
        this.histogramTypeSpinner.setTag(null);
        this.leftposEditText.setTag(null);
        this.lowposEditText.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.rightposEditText.setTag(null);
        this.sourceSpinner.setTag(null);
        this.statisenSwitch.setTag(null);
        setRootTag(view);
        this.mCallback67 = new OnClickListener(this, 1);
        this.mCallback70 = new OnClickListener(this, 4);
        this.mCallback68 = new OnClickListener(this, 2);
        this.mCallback71 = new OnClickListener(this, 5);
        this.mCallback69 = new OnClickListener(this, 3);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 8388608L;
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
        if (156 == i) {
            setChan2MappingObject((MappingObject) obj);
        } else if (165 == i) {
            setChanNoneMappingObject((MappingObject) obj);
        } else if (381 == i) {
            setHorizontalMappingObject((MappingObject) obj);
        } else if (158 == i) {
            setChan3MappingObject((MappingObject) obj);
        } else if (594 == i) {
            setParam((HistogramResultParam) obj);
        } else if (569 == i) {
            setOnClickListener((View.OnClickListener) obj);
        } else if (160 == i) {
            setChan4MappingObject((MappingObject) obj);
        } else if (154 == i) {
            setChan1MappingObject((MappingObject) obj);
        } else if (530 == i) {
            setMeasureMappingObject((MappingObject) obj);
        } else if (1026 != i) {
            return false;
        } else {
            setVerticalMappingObject((MappingObject) obj);
        }
        return true;
    }

    @Override // com.rigol.scope.databinding.PopupviewResultHistogramBinding
    public void setChan2MappingObject(MappingObject mappingObject) {
        this.mChan2MappingObject = mappingObject;
    }

    @Override // com.rigol.scope.databinding.PopupviewResultHistogramBinding
    public void setChanNoneMappingObject(MappingObject mappingObject) {
        this.mChanNoneMappingObject = mappingObject;
    }

    @Override // com.rigol.scope.databinding.PopupviewResultHistogramBinding
    public void setHorizontalMappingObject(MappingObject mappingObject) {
        this.mHorizontalMappingObject = mappingObject;
    }

    @Override // com.rigol.scope.databinding.PopupviewResultHistogramBinding
    public void setChan3MappingObject(MappingObject mappingObject) {
        this.mChan3MappingObject = mappingObject;
    }

    @Override // com.rigol.scope.databinding.PopupviewResultHistogramBinding
    public void setParam(HistogramResultParam histogramResultParam) {
        updateRegistration(5, histogramResultParam);
        this.mParam = histogramResultParam;
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        notifyPropertyChanged(594);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewResultHistogramBinding
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
        }
        notifyPropertyChanged(569);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewResultHistogramBinding
    public void setChan4MappingObject(MappingObject mappingObject) {
        this.mChan4MappingObject = mappingObject;
    }

    @Override // com.rigol.scope.databinding.PopupviewResultHistogramBinding
    public void setChan1MappingObject(MappingObject mappingObject) {
        this.mChan1MappingObject = mappingObject;
    }

    @Override // com.rigol.scope.databinding.PopupviewResultHistogramBinding
    public void setMeasureMappingObject(MappingObject mappingObject) {
        this.mMeasureMappingObject = mappingObject;
    }

    @Override // com.rigol.scope.databinding.PopupviewResultHistogramBinding
    public void setVerticalMappingObject(MappingObject mappingObject) {
        this.mVerticalMappingObject = mappingObject;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return onChangeChan2MappingObject((MappingObject) obj, i2);
            case 1:
                return onChangeChanNoneMappingObject((MappingObject) obj, i2);
            case 2:
                return onChangeHorizontalMappingObject((MappingObject) obj, i2);
            case 3:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgHistoTypeParamTypeValue1((MappingObject) obj, i2);
            case 4:
                return onChangeChan3MappingObject((MappingObject) obj, i2);
            case 5:
                return onChangeParam((HistogramResultParam) obj, i2);
            case 6:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgHistoSourceParamChanValue1((MappingObject) obj, i2);
            case 7:
                return onChangeChan4MappingObject((MappingObject) obj, i2);
            case 8:
                return onChangeChan1MappingObject((MappingObject) obj, i2);
            case 9:
                return onChangeMeasureMappingObject((MappingObject) obj, i2);
            case 10:
                return onChangeVerticalMappingObject((MappingObject) obj, i2);
            default:
                return false;
        }
    }

    private boolean onChangeChan2MappingObject(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeChanNoneMappingObject(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeHorizontalMappingObject(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgHistoTypeParamTypeValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeChan3MappingObject(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeParam(HistogramResultParam histogramResultParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        } else if (i == 271) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            }
            return true;
        } else if (i == 978) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE;
            }
            return true;
        } else if (i == 152) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 369) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
            }
            return true;
        } else if (i == 690) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
            }
            return true;
        } else if (i == 691) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
            }
            return true;
        } else if (i == 693) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
            }
            return true;
        } else if (i == 1021) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
            }
            return true;
        } else if (i == 689) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgHistoSourceParamChanValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 4194304;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeChan4MappingObject(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeChan1MappingObject(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 256;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeMeasureMappingObject(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 512;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeVerticalMappingObject(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x014f A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x018c  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 615
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rigol.scope.databinding.PopupviewResultHistogramBindingImpl.executeBindings():void");
    }

    @Override // com.rigol.scope.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int i, View view) {
        if (i == 1) {
            View.OnClickListener onClickListener = this.mOnClickListener;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        } else if (i == 2) {
            View.OnClickListener onClickListener2 = this.mOnClickListener;
            if (onClickListener2 != null) {
                onClickListener2.onClick(view);
            }
        } else if (i == 3) {
            View.OnClickListener onClickListener3 = this.mOnClickListener;
            if (onClickListener3 != null) {
                onClickListener3.onClick(view);
            }
        } else if (i == 4) {
            View.OnClickListener onClickListener4 = this.mOnClickListener;
            if (onClickListener4 != null) {
                onClickListener4.onClick(view);
            }
        } else if (i != 5) {
        } else {
            View.OnClickListener onClickListener5 = this.mOnClickListener;
            if (onClickListener5 != null) {
                onClickListener5.onClick(view);
            }
        }
    }
}
