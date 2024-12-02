package com.rigol.scope.databinding;

import android.graphics.drawable.Drawable;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.CompoundButtonBindingAdapter;
import androidx.databinding.adapters.ImageViewBindingAdapter;
import androidx.databinding.adapters.SeekBarBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.rigol.scope.R;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.TriggerParam;
import com.rigol.scope.utilities.ColorUtil;
import com.rigol.scope.utilities.UnitFormat;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.views.SwitchButton;
import com.rigol.scope.views.vertical.VerticalSeekBar;
import com.rigol.scope.views.vertical.VerticalSeekBarWrapper;

/* loaded from: classes2.dex */
public class AdapterTriggerTimeoutBindingImpl extends AdapterTriggerTimeoutBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.guideline_left, 10);
        sViewsWithIds.put(R.id.guideline_center, 11);
        sViewsWithIds.put(R.id.guideline_right, 12);
        sViewsWithIds.put(R.id.guideline_forth, 13);
        sViewsWithIds.put(R.id.view_top, 14);
        sViewsWithIds.put(R.id.trigger_source_label, 15);
        sViewsWithIds.put(R.id.trigger_noise_label, 16);
        sViewsWithIds.put(R.id.trigger_timeout_time_label, 17);
        sViewsWithIds.put(R.id.trigger_level, 18);
        sViewsWithIds.put(R.id.verticalSeekBarWrapper2, 19);
        sViewsWithIds.put(R.id.button_level, 20);
        sViewsWithIds.put(R.id.trigger_timeout_edge_label, 21);
        sViewsWithIds.put(R.id.view_line_1, 22);
        sViewsWithIds.put(R.id.view_line_2, 23);
    }

    public AdapterTriggerTimeoutBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 24, sIncludes, sViewsWithIds));
    }

    private AdapterTriggerTimeoutBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 8, (Button) objArr[20], (Guideline) objArr[11], (Guideline) objArr[13], (Guideline) objArr[10], (Guideline) objArr[12], (ImageView) objArr[4], (TextView) objArr[18], (EditText) objArr[6], (VerticalSeekBar) objArr[5], (TextView) objArr[16], (SwitchButton) objArr[2], (TextView) objArr[1], (TextView) objArr[15], (RadioButton) objArr[9], (RadioButton) objArr[8], (TextView) objArr[21], (RadioButton) objArr[7], (TextView) objArr[17], (EditText) objArr[3], (VerticalSeekBarWrapper) objArr[19], (View) objArr[22], (View) objArr[23], (View) objArr[14]);
        this.mDirtyFlags = -1L;
        this.imageView2.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.triggerLevelValue.setTag(null);
        this.triggerLevelView.setTag(null);
        this.triggerNoiseSwitch.setTag(null);
        this.triggerSource.setTag(null);
        this.triggerTimeoutEdgeEither.setTag(null);
        this.triggerTimeoutEdgeFalling.setTag(null);
        this.triggerTimeoutEdgeRising.setTag(null);
        this.triggerTimeoutTimeValue.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
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
        if (918 == i) {
            setSweepSingleMapping((MappingObject) obj);
        } else if (917 == i) {
            setSweepNormalMapping((MappingObject) obj);
        } else if (847 == i) {
            setSlopeEitherMapping((MappingObject) obj);
        } else if (850 == i) {
            setSlopeRisingMapping((MappingObject) obj);
        } else if (594 == i) {
            setParam((TriggerParam) obj);
        } else if (916 == i) {
            setSweepAutoMapping((MappingObject) obj);
        } else if (848 != i) {
            return false;
        } else {
            setSlopeFallingMapping((MappingObject) obj);
        }
        return true;
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerTimeoutBinding
    public void setSweepSingleMapping(MappingObject mappingObject) {
        this.mSweepSingleMapping = mappingObject;
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerTimeoutBinding
    public void setSweepNormalMapping(MappingObject mappingObject) {
        this.mSweepNormalMapping = mappingObject;
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerTimeoutBinding
    public void setSlopeEitherMapping(MappingObject mappingObject) {
        updateRegistration(2, mappingObject);
        this.mSlopeEitherMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(847);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerTimeoutBinding
    public void setSlopeRisingMapping(MappingObject mappingObject) {
        updateRegistration(3, mappingObject);
        this.mSlopeRisingMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(850);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerTimeoutBinding
    public void setParam(TriggerParam triggerParam) {
        updateRegistration(5, triggerParam);
        this.mParam = triggerParam;
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        notifyPropertyChanged(594);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerTimeoutBinding
    public void setSweepAutoMapping(MappingObject mappingObject) {
        this.mSweepAutoMapping = mappingObject;
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerTimeoutBinding
    public void setSlopeFallingMapping(MappingObject mappingObject) {
        updateRegistration(7, mappingObject);
        this.mSlopeFallingMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 128;
        }
        notifyPropertyChanged(848);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return onChangeSweepSingleMapping((MappingObject) obj, i2);
            case 1:
                return onChangeSweepNormalMapping((MappingObject) obj, i2);
            case 2:
                return onChangeSlopeEitherMapping((MappingObject) obj, i2);
            case 3:
                return onChangeSlopeRisingMapping((MappingObject) obj, i2);
            case 4:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerSourceLaParamChanValue1((MappingObject) obj, i2);
            case 5:
                return onChangeParam((TriggerParam) obj, i2);
            case 6:
                return onChangeSweepAutoMapping((MappingObject) obj, i2);
            case 7:
                return onChangeSlopeFallingMapping((MappingObject) obj, i2);
            default:
                return false;
        }
    }

    private boolean onChangeSweepSingleMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeSweepNormalMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeSlopeEitherMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
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

    private boolean onChangeSlopeRisingMapping(MappingObject mappingObject, int i) {
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

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerSourceLaParamChanValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeParam(TriggerParam triggerParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        } else if (i == 152) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
            }
            return true;
        } else if (i == 448) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
            }
            return true;
        } else if (i == 936) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            }
            return true;
        } else if (i == 938) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE;
            }
            return true;
        } else if (i == 671) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 484) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeSweepAutoMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeSlopeFallingMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
            }
            return true;
        } else {
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:74:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0141  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void executeBindings() {
        long j;
        boolean z;
        boolean z2;
        int i;
        boolean z3;
        boolean z4;
        String str;
        Drawable drawable;
        String str2;
        String str3;
        String str4;
        int i2;
        int i3;
        boolean z5;
        long j2;
        int i4;
        String str5;
        int i5;
        String str6;
        long j3;
        long j4;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        MappingObject mappingObject = this.mSlopeEitherMapping;
        MappingObject mappingObject2 = this.mSlopeRisingMapping;
        TriggerParam triggerParam = this.mParam;
        MappingObject mappingObject3 = this.mSlopeFallingMapping;
        int i6 = ((262404 & j) > 0L ? 1 : ((262404 & j) == 0L ? 0 : -1));
        String str7 = (i6 == 0 || mappingObject == null) ? null : mappingObject.getStr();
        int i7 = ((262664 & j) > 0L ? 1 : ((262664 & j) == 0L ? 0 : -1));
        String str8 = (i7 == 0 || mappingObject2 == null) ? null : mappingObject2.getStr();
        boolean z6 = false;
        if ((392240 & j) != 0) {
            i = ((j & 294944) == 0 || triggerParam == null) ? 0 : triggerParam.getProgress();
            if ((j & 278560) != 0) {
                ServiceEnum.EdgeSlope timeoutSlope = triggerParam != null ? triggerParam.getTimeoutSlope() : null;
                z4 = timeoutSlope == ServiceEnum.EdgeSlope.Trigger_Edge_Rising;
                z3 = timeoutSlope == ServiceEnum.EdgeSlope.Trigger_Edge_Any;
                z5 = timeoutSlope == ServiceEnum.EdgeSlope.Trigger_Edge_Falling;
                drawable = ViewUtil.getTriggerTimeoutPic(timeoutSlope);
            } else {
                z3 = false;
                z4 = false;
                z5 = false;
                drawable = null;
            }
            if ((j & 265264) != 0) {
                ServiceEnum.Chan chan = triggerParam != null ? triggerParam.getChan() : null;
                MappingObject mappingObject4 = ViewUtil.getMappingObject(R.array.msg_trigger_source_la, chan != null ? chan.value1 : 0);
                updateRegistration(4, mappingObject4);
                str5 = mappingObject4 != null ? mappingObject4.getStr() : null;
                j2 = 0;
                i4 = (j & 264224) != 0 ? ColorUtil.getColor(getRoot().getContext(), chan) : 0;
            } else {
                j2 = 0;
                i4 = 0;
                str5 = null;
            }
            if ((j & 327712) != j2) {
                if (triggerParam != null) {
                    str2 = str5;
                    i5 = i4;
                    j4 = triggerParam.getLevel();
                } else {
                    str2 = str5;
                    i5 = i4;
                    j4 = 0;
                }
                if (triggerParam != null) {
                    str = triggerParam.getTriggerLevelStr(j4);
                    if ((j & 266272) != 0 && triggerParam != null) {
                        z6 = triggerParam.getIsNoise();
                    }
                    if ((j & 270368) == 0) {
                        if (triggerParam != null) {
                            long timeOut = triggerParam.getTimeOut();
                            str6 = str;
                            j3 = timeOut;
                        } else {
                            str6 = str;
                            j3 = 0;
                        }
                        String str9 = str6;
                        z2 = z5;
                        z = z6;
                        drawable = drawable;
                        str3 = UnitFormat.newBuilder(UnitFormat.SI.FEMTO).convert(j3, ServiceEnum.Unit.Unit_s);
                        str4 = str8;
                        i2 = i5;
                        str = str9;
                    } else {
                        z2 = z5;
                        z = z6;
                        str3 = null;
                        str4 = str8;
                        i2 = i5;
                    }
                }
            } else {
                str2 = str5;
                i5 = i4;
            }
            str = null;
            if ((j & 266272) != 0) {
                z6 = triggerParam.getIsNoise();
            }
            if ((j & 270368) == 0) {
            }
        } else {
            z = false;
            z2 = false;
            i = 0;
            z3 = false;
            z4 = false;
            str = null;
            drawable = null;
            str2 = null;
            str3 = null;
            str4 = str8;
            i2 = 0;
        }
        int i8 = ((j & 393344) > 0L ? 1 : ((j & 393344) == 0L ? 0 : -1));
        String str10 = (i8 == 0 || mappingObject3 == null) ? null : mappingObject3.getStr();
        if ((j & 278560) != 0) {
            i3 = i7;
            ImageViewBindingAdapter.setImageDrawable(this.imageView2, drawable);
            CompoundButtonBindingAdapter.setChecked(this.triggerTimeoutEdgeEither, z3);
            CompoundButtonBindingAdapter.setChecked(this.triggerTimeoutEdgeFalling, z2);
            CompoundButtonBindingAdapter.setChecked(this.triggerTimeoutEdgeRising, z4);
        } else {
            i3 = i7;
        }
        if ((j & 327712) != 0) {
            TextViewBindingAdapter.setText(this.triggerLevelValue, str);
        }
        if ((j & 294944) != 0) {
            SeekBarBindingAdapter.setProgress(this.triggerLevelView, i);
        }
        if ((j & 266272) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.triggerNoiseSwitch, z);
        }
        if ((j & 265264) != 0) {
            TextViewBindingAdapter.setText(this.triggerSource, str2);
        }
        if ((264224 & j) != 0) {
            this.triggerSource.setTextColor(i2);
        }
        if (i6 != 0) {
            TextViewBindingAdapter.setText(this.triggerTimeoutEdgeEither, str7);
        }
        if (i8 != 0) {
            TextViewBindingAdapter.setText(this.triggerTimeoutEdgeFalling, str10);
        }
        if (i3 != 0) {
            TextViewBindingAdapter.setText(this.triggerTimeoutEdgeRising, str4);
        }
        if ((j & 270368) != 0) {
            TextViewBindingAdapter.setText(this.triggerTimeoutTimeValue, str3);
        }
    }
}
