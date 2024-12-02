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
import androidx.databinding.adapters.CompoundButtonBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.rigol.scope.R;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.generated.callback.OnClickListener;
import com.rigol.scope.utilities.ColorUtil;
import com.rigol.scope.utilities.UnitFormat;
import com.rigol.scope.utilities.ViewUtil;
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
    */
    protected void executeBindings() {
        long j;
        boolean z;
        int i;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        HistogramResultParam histogramResultParam = this.mParam;
        View.OnClickListener onClickListener = this.mOnClickListener;
        String str10 = null;
        if ((16773224 & j) != 0) {
            int i2 = ((j & 11534368) > 0L ? 1 : ((j & 11534368) == 0L ? 0 : -1));
            if (i2 != 0) {
                str8 = UnitFormat.newBuilder(UnitFormat.SI.NANO).convert(histogramResultParam != null ? histogramResultParam.getRealBottom() : 0L);
            } else {
                str8 = null;
            }
            if ((j & 8650784) != 0) {
                str6 = UnitFormat.newBuilder(UnitFormat.SI.FEMTO).convert(histogramResultParam != null ? histogramResultParam.getRealRight() : 0L) + ServiceEnum.Unit.Unit_s.value2;
            } else {
                str6 = null;
            }
            if ((j & 8519712) != 0) {
                str7 = UnitFormat.newBuilder(UnitFormat.SI.FEMTO).convert(histogramResultParam != null ? histogramResultParam.getRealLeft() : 0L) + ServiceEnum.Unit.Unit_s.value2;
            } else {
                str7 = null;
            }
            if ((12058656 & j) != 0) {
                ServiceEnum.Unit verUnit = histogramResultParam != null ? histogramResultParam.getVerUnit() : null;
                str9 = verUnit != null ? verUnit.value2 : null;
                if (i2 != 0) {
                    str3 = str8 + str9;
                } else {
                    str3 = null;
                }
            } else {
                str3 = null;
                str9 = null;
            }
            if ((j & 12615776) != 0) {
                ServiceEnum.Chan chan = histogramResultParam != null ? histogramResultParam.getChan() : null;
                int i3 = chan != null ? chan.value1 : 0;
                i = (j & 8421408) != 0 ? ColorUtil.getColor(getRoot().getContext(), i3) : 0;
                MappingObject mappingObject = ViewUtil.getMappingObject(R.array.msg_histo_source, i3);
                updateRegistration(6, mappingObject);
                if (mappingObject != null) {
                    str4 = mappingObject.getStr();
                    if ((j & 8409128) != 0) {
                        ServiceEnum.HistoType type = histogramResultParam != null ? histogramResultParam.getType() : null;
                        MappingObject mappingObject2 = ViewUtil.getMappingObject(R.array.msg_histo_type, type != null ? type.value1 : 0);
                        updateRegistration(3, mappingObject2);
                        if (mappingObject2 != null) {
                            str5 = mappingObject2.getStr();
                            z = ((j & 8396832) != 0 || histogramResultParam == null) ? false : histogramResultParam.getEnable();
                            if ((j & 9961504) != 0) {
                                str2 = UnitFormat.newBuilder(UnitFormat.SI.NANO).convert(histogramResultParam != null ? histogramResultParam.getRealTop() : 0L) + str9;
                            } else {
                                str2 = null;
                            }
                            if ((j & 8454176) != 0) {
                                str10 = UnitFormat.newBuilder(UnitFormat.PATTERN_SIGN, UnitFormat.SI.MILLI).convert(histogramResultParam != null ? histogramResultParam.getHeight() : 0) + ServiceEnum.Unit.Unit_Div.value2;
                            }
                            str = str10;
                        }
                    }
                    str5 = null;
                    if ((j & 8396832) != 0) {
                    }
                    if ((j & 9961504) != 0) {
                    }
                    if ((j & 8454176) != 0) {
                    }
                    str = str10;
                }
            } else {
                i = 0;
            }
            str4 = null;
            if ((j & 8409128) != 0) {
            }
            str5 = null;
            if ((j & 8396832) != 0) {
            }
            if ((j & 9961504) != 0) {
            }
            if ((j & 8454176) != 0) {
            }
            str = str10;
        } else {
            z = false;
            i = 0;
            str = null;
            str2 = null;
            str3 = null;
            str4 = null;
            str5 = null;
            str6 = null;
            str7 = null;
        }
        if ((8388608 & j) != 0) {
            this.dispgridEditText.setOnClickListener(this.mCallback67);
            this.highposEditText.setOnClickListener(this.mCallback70);
            this.leftposEditText.setOnClickListener(this.mCallback68);
            this.lowposEditText.setOnClickListener(this.mCallback71);
            this.rightposEditText.setOnClickListener(this.mCallback69);
        }
        if ((j & 8454176) != 0) {
            TextViewBindingAdapter.setText(this.dispgridEditText, str);
        }
        if ((j & 9961504) != 0) {
            TextViewBindingAdapter.setText(this.highposEditText, str2);
        }
        if ((8396832 & j) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.histogramEn, z);
            CompoundButtonBindingAdapter.setChecked(this.statisenSwitch, z);
        }
        if ((8409128 & j) != 0) {
            TextViewBindingAdapter.setText(this.histogramTypeSpinner, str5);
        }
        if ((8519712 & j) != 0) {
            TextViewBindingAdapter.setText(this.leftposEditText, str7);
        }
        if ((j & 11534368) != 0) {
            TextViewBindingAdapter.setText(this.lowposEditText, str3);
        }
        if ((j & 8650784) != 0) {
            TextViewBindingAdapter.setText(this.rightposEditText, str6);
        }
        if ((12615776 & j) != 0) {
            TextViewBindingAdapter.setText(this.sourceSpinner, str4);
        }
        if ((j & 8421408) != 0) {
            this.sourceSpinner.setTextColor(i);
        }
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
