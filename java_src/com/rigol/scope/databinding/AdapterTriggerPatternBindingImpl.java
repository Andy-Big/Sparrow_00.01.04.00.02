package com.rigol.scope.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.TriggerParam;
import com.rigol.scope.views.SwitchButton;
import com.rigol.scope.views.vertical.VerticalSeekBar;
import com.rigol.scope.views.vertical.VerticalSeekBarWrapper;
/* loaded from: classes2.dex */
public class AdapterTriggerPatternBindingImpl extends AdapterTriggerPatternBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.guideline_left, 42);
        sViewsWithIds.put(R.id.guideline_center, 43);
        sViewsWithIds.put(R.id.guideline_right, 44);
        sViewsWithIds.put(R.id.guideline_forth, 45);
        sViewsWithIds.put(R.id.view_top, 46);
        sViewsWithIds.put(R.id.trigger_source_label, 47);
        sViewsWithIds.put(R.id.ch4, 48);
        sViewsWithIds.put(R.id.key_all, 49);
        sViewsWithIds.put(R.id.key_next, 50);
        sViewsWithIds.put(R.id.key_return, 51);
        sViewsWithIds.put(R.id.key_falling, 52);
        sViewsWithIds.put(R.id.key_rising, 53);
        sViewsWithIds.put(R.id.key_x, 54);
        sViewsWithIds.put(R.id.key_one, 55);
        sViewsWithIds.put(R.id.button_level, 56);
        sViewsWithIds.put(R.id.trigger_level, 57);
        sViewsWithIds.put(R.id.imageView2, 58);
        sViewsWithIds.put(R.id.verticalSeekBarWrapper2, 59);
        sViewsWithIds.put(R.id.ch1, 60);
        sViewsWithIds.put(R.id.ch2, 61);
        sViewsWithIds.put(R.id.ch3, 62);
        sViewsWithIds.put(R.id.key_zero, 63);
        sViewsWithIds.put(R.id.trigger_holdoff_label, 64);
        sViewsWithIds.put(R.id.trigger_noise_label, 65);
        sViewsWithIds.put(R.id.view, 66);
        sViewsWithIds.put(R.id.view21, 67);
    }

    public AdapterTriggerPatternBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 68, sIncludes, sViewsWithIds));
    }

    private AdapterTriggerPatternBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 5, (Button) objArr[56], (TextView) objArr[60], (TextView) objArr[61], (TextView) objArr[62], (TextView) objArr[48], (TextView) objArr[20], (TextView) objArr[21], (TextView) objArr[30], (TextView) objArr[31], (TextView) objArr[32], (TextView) objArr[33], (TextView) objArr[34], (TextView) objArr[35], (TextView) objArr[22], (TextView) objArr[23], (TextView) objArr[24], (TextView) objArr[25], (TextView) objArr[26], (TextView) objArr[27], (TextView) objArr[28], (TextView) objArr[29], (Guideline) objArr[43], (Guideline) objArr[45], (Guideline) objArr[42], (Guideline) objArr[44], (ImageView) objArr[58], (ImageButton) objArr[49], (ImageButton) objArr[52], (ImageButton) objArr[50], (ImageButton) objArr[55], (ImageButton) objArr[51], (ImageButton) objArr[53], (ImageButton) objArr[54], (ImageButton) objArr[63], (EditText) objArr[40], (TextView) objArr[64], (TextView) objArr[57], (EditText) objArr[36], (VerticalSeekBar) objArr[37], (TextView) objArr[65], (SwitchButton) objArr[41], (TextView) objArr[19], (TextView) objArr[47], (ImageButton) objArr[38], (ImageButton) objArr[39], (ImageButton) objArr[2], (ImageButton) objArr[1], (ImageButton) objArr[3], (ImageButton) objArr[4], (ImageButton) objArr[13], (ImageButton) objArr[14], (ImageButton) objArr[15], (ImageButton) objArr[16], (ImageButton) objArr[17], (ImageButton) objArr[18], (ImageButton) objArr[5], (ImageButton) objArr[6], (ImageButton) objArr[7], (ImageButton) objArr[8], (ImageButton) objArr[9], (ImageButton) objArr[10], (ImageButton) objArr[11], (ImageButton) objArr[12], (VerticalSeekBarWrapper) objArr[59], (View) objArr[66], (View) objArr[67], (View) objArr[46]);
        this.mDirtyFlags = -1L;
        this.d0.setTag(null);
        this.d1.setTag(null);
        this.d10.setTag(null);
        this.d11.setTag(null);
        this.d12.setTag(null);
        this.d13.setTag(null);
        this.d14.setTag(null);
        this.d15.setTag(null);
        this.d2.setTag(null);
        this.d3.setTag(null);
        this.d4.setTag(null);
        this.d5.setTag(null);
        this.d6.setTag(null);
        this.d7.setTag(null);
        this.d8.setTag(null);
        this.d9.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.triggerHoldoff.setTag(null);
        this.triggerLevelValue.setTag(null);
        this.triggerLevelView.setTag(null);
        this.triggerNoiseSwitch.setTag(null);
        this.triggerSource.setTag(null);
        this.valueCh1.setTag(null);
        this.valueCh2.setTag(null);
        this.valueCh3.setTag(null);
        this.valueCh4.setTag(null);
        this.valueD0.setTag(null);
        this.valueD1.setTag(null);
        this.valueD10.setTag(null);
        this.valueD11.setTag(null);
        this.valueD12.setTag(null);
        this.valueD13.setTag(null);
        this.valueD14.setTag(null);
        this.valueD15.setTag(null);
        this.valueD2.setTag(null);
        this.valueD3.setTag(null);
        this.valueD4.setTag(null);
        this.valueD5.setTag(null);
        this.valueD6.setTag(null);
        this.valueD7.setTag(null);
        this.valueD8.setTag(null);
        this.valueD9.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
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
        } else if (594 == i) {
            setParam((TriggerParam) obj);
        } else if (916 != i) {
            return false;
        } else {
            setSweepAutoMapping((MappingObject) obj);
        }
        return true;
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerPatternBinding
    public void setSweepSingleMapping(MappingObject mappingObject) {
        this.mSweepSingleMapping = mappingObject;
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerPatternBinding
    public void setSweepNormalMapping(MappingObject mappingObject) {
        this.mSweepNormalMapping = mappingObject;
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerPatternBinding
    public void setParam(TriggerParam triggerParam) {
        updateRegistration(2, triggerParam);
        this.mParam = triggerParam;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(594);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerPatternBinding
    public void setSweepAutoMapping(MappingObject mappingObject) {
        this.mSweepAutoMapping = mappingObject;
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
                        return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerSourceLaParamChanValue1((MappingObject) obj, i2);
                    }
                    return onChangeSweepAutoMapping((MappingObject) obj, i2);
                }
                return onChangeParam((TriggerParam) obj, i2);
            }
            return onChangeSweepNormalMapping((MappingObject) obj, i2);
        }
        return onChangeSweepSingleMapping((MappingObject) obj, i2);
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

    private boolean onChangeParam(TriggerParam triggerParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else if (i == 152) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        } else if (i == 166) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        } else if (i == 484) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
            }
            return true;
        } else if (i == 671) {
            synchronized (this) {
                this.mDirtyFlags |= 256;
            }
            return true;
        } else if (i == 377) {
            synchronized (this) {
                this.mDirtyFlags |= 512;
            }
            return true;
        } else if (i == 448) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeSweepAutoMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerSourceLaParamChanValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
            }
            return true;
        } else {
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x0720  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:311:0x0764  */
    /* JADX WARN: Removed duplicated region for block: B:315:0x078c  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x01a4  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 3081
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rigol.scope.databinding.AdapterTriggerPatternBindingImpl.executeBindings():void");
    }
}
