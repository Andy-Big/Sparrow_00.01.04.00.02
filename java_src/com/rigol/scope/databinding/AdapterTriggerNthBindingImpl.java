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
public class AdapterTriggerNthBindingImpl extends AdapterTriggerNthBinding {
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
        sViewsWithIds.put(R.id.guideline_fifth, 14);
        sViewsWithIds.put(R.id.view_top, 15);
        sViewsWithIds.put(R.id.trigger_source_label, 16);
        sViewsWithIds.put(R.id.trigger_noise, 17);
        sViewsWithIds.put(R.id.trigger_noise_label, 18);
        sViewsWithIds.put(R.id.view, 19);
        sViewsWithIds.put(R.id.trigger_nth_idle_time_label, 20);
        sViewsWithIds.put(R.id.trigger_nth_edge_number_label, 21);
        sViewsWithIds.put(R.id.view2, 22);
        sViewsWithIds.put(R.id.trigger_level, 23);
        sViewsWithIds.put(R.id.verticalSeekBarWrapper2, 24);
        sViewsWithIds.put(R.id.button_level, 25);
        sViewsWithIds.put(R.id.trigger_nth_edge_label, 26);
    }

    public AdapterTriggerNthBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 27, sIncludes, sViewsWithIds));
    }

    private AdapterTriggerNthBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 7, (Button) objArr[25], (Guideline) objArr[11], (Guideline) objArr[14], (Guideline) objArr[13], (Guideline) objArr[10], (Guideline) objArr[12], (ImageView) objArr[5], (TextView) objArr[23], (EditText) objArr[7], (VerticalSeekBar) objArr[6], (View) objArr[17], (TextView) objArr[18], (SwitchButton) objArr[2], (RadioButton) objArr[8], (TextView) objArr[26], (TextView) objArr[21], (EditText) objArr[4], (RadioButton) objArr[9], (TextView) objArr[20], (EditText) objArr[3], (TextView) objArr[1], (TextView) objArr[16], (VerticalSeekBarWrapper) objArr[24], (View) objArr[19], (View) objArr[22], (View) objArr[15]);
        this.mDirtyFlags = -1L;
        this.imageView2.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.triggerLevelValue.setTag(null);
        this.triggerLevelView.setTag(null);
        this.triggerNoiseSwitch.setTag(null);
        this.triggerNthEdgeFalling.setTag(null);
        this.triggerNthEdgeNumberValue.setTag(null);
        this.triggerNthEdgeRising.setTag(null);
        this.triggerNthIdleTimeValue.setTag(null);
        this.triggerSource.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
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

    @Override // com.rigol.scope.databinding.AdapterTriggerNthBinding
    public void setSweepSingleMapping(MappingObject mappingObject) {
        this.mSweepSingleMapping = mappingObject;
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerNthBinding
    public void setSweepNormalMapping(MappingObject mappingObject) {
        this.mSweepNormalMapping = mappingObject;
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerNthBinding
    public void setSlopeRisingMapping(MappingObject mappingObject) {
        updateRegistration(2, mappingObject);
        this.mSlopeRisingMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(850);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerNthBinding
    public void setParam(TriggerParam triggerParam) {
        updateRegistration(4, triggerParam);
        this.mParam = triggerParam;
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        notifyPropertyChanged(594);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerNthBinding
    public void setSweepAutoMapping(MappingObject mappingObject) {
        this.mSweepAutoMapping = mappingObject;
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerNthBinding
    public void setSlopeFallingMapping(MappingObject mappingObject) {
        updateRegistration(6, mappingObject);
        this.mSlopeFallingMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 64;
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
                return onChangeSlopeRisingMapping((MappingObject) obj, i2);
            case 3:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerSourceLaParamChanValue1((MappingObject) obj, i2);
            case 4:
                return onChangeParam((TriggerParam) obj, i2);
            case 5:
                return onChangeSweepAutoMapping((MappingObject) obj, i2);
            case 6:
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

    private boolean onChangeSlopeRisingMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
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

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerSourceLaParamChanValue1(MappingObject mappingObject, int i) {
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

    private boolean onChangeParam(TriggerParam triggerParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        } else if (i == 152) {
            synchronized (this) {
                this.mDirtyFlags |= 512;
            }
            return true;
        } else if (i == 448) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 411) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
            }
            return true;
        } else if (i == 262) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
            }
            return true;
        } else if (i == 562) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            }
            return true;
        } else if (i == 671) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE;
            }
            return true;
        } else if (i == 484) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeSweepAutoMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeSlopeFallingMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
            }
            return true;
        } else {
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:69:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0126  */
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
        int i2;
        String str;
        String str2;
        String str3;
        String str4;
        Drawable drawable;
        String str5;
        boolean z4;
        Drawable drawable2;
        int i3;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        MappingObject mappingObject = this.mSlopeRisingMapping;
        TriggerParam triggerParam = this.mParam;
        MappingObject mappingObject2 = this.mSlopeFallingMapping;
        int i4 = ((131204 & j) > 0L ? 1 : ((131204 & j) == 0L ? 0 : -1));
        String str6 = (i4 == 0 || mappingObject == null) ? null : mappingObject.getStr();
        boolean z5 = false;
        if ((196376 & j) != 0) {
            if ((j & 139280) != 0) {
                ServiceEnum.EdgeSlope nthSlope = triggerParam != null ? triggerParam.getNthSlope() : null;
                z4 = true;
                z2 = nthSlope == ServiceEnum.EdgeSlope.Trigger_Edge_Falling;
                drawable2 = ViewUtil.getTriggerNthPic(nthSlope);
                if (nthSlope != ServiceEnum.EdgeSlope.Trigger_Edge_Rising) {
                    z4 = false;
                }
            } else {
                z2 = false;
                z4 = false;
                drawable2 = null;
            }
            i = ((j & 147472) == 0 || triggerParam == null) ? 0 : triggerParam.getProgress();
            if ((j & 135184) != 0) {
                str3 = UnitFormat.newBuilder(" 0.###  ", UnitFormat.SI.NONE).convert(triggerParam != null ? triggerParam.getEdgeNumber() : 0, ServiceEnum.Unit.Unit_none);
            } else {
                str3 = null;
            }
            if ((j & 131864) != 0) {
                ServiceEnum.Chan chan = triggerParam != null ? triggerParam.getChan() : null;
                MappingObject mappingObject3 = ViewUtil.getMappingObject(R.array.msg_trigger_source_la, chan != null ? chan.value1 : 0);
                updateRegistration(3, mappingObject3);
                str4 = mappingObject3 != null ? mappingObject3.getStr() : null;
                i3 = (j & 131600) != 0 ? ColorUtil.getColor(getRoot().getContext(), chan) : 0;
            } else {
                i3 = 0;
                str4 = null;
            }
            if ((j & 163856) != 0) {
                long level = triggerParam != null ? triggerParam.getLevel() : 0L;
                if (triggerParam != null) {
                    str = triggerParam.getTriggerLevelStr(level);
                    if ((j & 132112) != 0 && triggerParam != null) {
                        z5 = triggerParam.getIsNoise();
                    }
                    if ((j & 133136) == 0) {
                        str2 = UnitFormat.newBuilder(UnitFormat.SI.FEMTO).convert(triggerParam != null ? triggerParam.getIdelTime() : 0L, ServiceEnum.Unit.Unit_s);
                        i2 = i3;
                        z3 = z5;
                        z = z4;
                        drawable = drawable2;
                    } else {
                        i2 = i3;
                        z3 = z5;
                        z = z4;
                        drawable = drawable2;
                        str2 = null;
                    }
                }
            }
            str = null;
            if ((j & 132112) != 0) {
                z5 = triggerParam.getIsNoise();
            }
            if ((j & 133136) == 0) {
            }
        } else {
            z = false;
            z2 = false;
            i = 0;
            z3 = false;
            i2 = 0;
            str = null;
            str2 = null;
            str3 = null;
            str4 = null;
            drawable = null;
        }
        int i5 = ((j & 196672) > 0L ? 1 : ((j & 196672) == 0L ? 0 : -1));
        String str7 = (i5 == 0 || mappingObject2 == null) ? null : mappingObject2.getStr();
        if ((j & 139280) != 0) {
            str5 = str4;
            ImageViewBindingAdapter.setImageDrawable(this.imageView2, drawable);
            CompoundButtonBindingAdapter.setChecked(this.triggerNthEdgeFalling, z2);
            CompoundButtonBindingAdapter.setChecked(this.triggerNthEdgeRising, z);
        } else {
            str5 = str4;
        }
        if ((j & 163856) != 0) {
            TextViewBindingAdapter.setText(this.triggerLevelValue, str);
        }
        if ((j & 147472) != 0) {
            SeekBarBindingAdapter.setProgress(this.triggerLevelView, i);
        }
        if ((132112 & j) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.triggerNoiseSwitch, z3);
        }
        if (i5 != 0) {
            TextViewBindingAdapter.setText(this.triggerNthEdgeFalling, str7);
        }
        if ((j & 135184) != 0) {
            TextViewBindingAdapter.setText(this.triggerNthEdgeNumberValue, str3);
        }
        if (i4 != 0) {
            TextViewBindingAdapter.setText(this.triggerNthEdgeRising, str6);
        }
        if ((133136 & j) != 0) {
            TextViewBindingAdapter.setText(this.triggerNthIdleTimeValue, str2);
        }
        if ((131600 & j) != 0) {
            this.triggerSource.setTextColor(i2);
        }
        if ((j & 131864) != 0) {
            TextViewBindingAdapter.setText(this.triggerSource, str5);
        }
    }
}
