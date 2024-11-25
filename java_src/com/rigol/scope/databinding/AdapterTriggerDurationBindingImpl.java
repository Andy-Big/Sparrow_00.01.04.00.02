package com.rigol.scope.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
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
public class AdapterTriggerDurationBindingImpl extends AdapterTriggerDurationBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;
    private final TextView mboundView17;
    private final TextView mboundView19;
    private final TextView mboundView21;
    private final TextView mboundView23;
    private final TextView mboundView25;
    private final TextView mboundView27;
    private final TextView mboundView29;
    private final TextView mboundView31;
    private final TextView mboundView33;
    private final TextView mboundView35;
    private final TextView mboundView37;
    private final TextView mboundView39;
    private final TextView mboundView41;
    private final TextView mboundView43;
    private final TextView mboundView45;
    private final TextView mboundView47;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.guideline_left, 50);
        sViewsWithIds.put(R.id.guideline_center, 51);
        sViewsWithIds.put(R.id.guideline_right, 52);
        sViewsWithIds.put(R.id.guideline_forth, 53);
        sViewsWithIds.put(R.id.view_top, 54);
        sViewsWithIds.put(R.id.view_1, 55);
        sViewsWithIds.put(R.id.ch2, 56);
        sViewsWithIds.put(R.id.trigger_factor_label, 57);
        sViewsWithIds.put(R.id.trigger_source_label, 58);
        sViewsWithIds.put(R.id.ch4, 59);
        sViewsWithIds.put(R.id.ch3, 60);
        sViewsWithIds.put(R.id.key_all, 61);
        sViewsWithIds.put(R.id.key_next, 62);
        sViewsWithIds.put(R.id.key_return, 63);
        sViewsWithIds.put(R.id.key_x, 64);
        sViewsWithIds.put(R.id.key_one, 65);
        sViewsWithIds.put(R.id.button_level, 66);
        sViewsWithIds.put(R.id.trigger_level, 67);
        sViewsWithIds.put(R.id.imageView2, 68);
        sViewsWithIds.put(R.id.verticalSeekBarWrapper2, 69);
        sViewsWithIds.put(R.id.ch1, 70);
        sViewsWithIds.put(R.id.key_zero, 71);
        sViewsWithIds.put(R.id.trigger_holdoff_label, 72);
        sViewsWithIds.put(R.id.trigger_noise_label, 73);
        sViewsWithIds.put(R.id.view, 74);
        sViewsWithIds.put(R.id.view21, 75);
    }

    public AdapterTriggerDurationBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 76, sIncludes, sViewsWithIds));
    }

    private AdapterTriggerDurationBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 5, (Button) objArr[66], (TextView) objArr[70], (TextView) objArr[56], (TextView) objArr[60], (TextView) objArr[59], (RadioButton) objArr[3], (RadioButton) objArr[1], (RadioButton) objArr[4], (RadioButton) objArr[2], (Guideline) objArr[51], (Guideline) objArr[53], (Guideline) objArr[50], (Guideline) objArr[52], (ImageView) objArr[68], (ImageButton) objArr[61], (ImageButton) objArr[62], (ImageButton) objArr[65], (ImageButton) objArr[63], (ImageButton) objArr[64], (ImageButton) objArr[71], (TextView) objArr[6], (EditText) objArr[5], (TextView) objArr[8], (EditText) objArr[7], (TextView) objArr[57], (EditText) objArr[48], (TextView) objArr[72], (TextView) objArr[67], (EditText) objArr[10], (VerticalSeekBar) objArr[11], (TextView) objArr[73], (SwitchButton) objArr[49], (TextView) objArr[9], (TextView) objArr[58], (ImageButton) objArr[12], (ImageButton) objArr[13], (ImageButton) objArr[14], (ImageButton) objArr[15], (ImageButton) objArr[16], (ImageButton) objArr[18], (ImageButton) objArr[36], (ImageButton) objArr[38], (ImageButton) objArr[40], (ImageButton) objArr[42], (ImageButton) objArr[44], (ImageButton) objArr[46], (ImageButton) objArr[20], (ImageButton) objArr[22], (ImageButton) objArr[24], (ImageButton) objArr[26], (ImageButton) objArr[28], (ImageButton) objArr[30], (ImageButton) objArr[32], (ImageButton) objArr[34], (VerticalSeekBarWrapper) objArr[69], (View) objArr[74], (View) objArr[55], (View) objArr[75], (View) objArr[54]);
        this.mDirtyFlags = -1L;
        this.durationLessthan.setTag(null);
        this.durationMoreless.setTag(null);
        this.durationMorethan.setTag(null);
        this.durationUnmoreless.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView = (TextView) objArr[17];
        this.mboundView17 = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[19];
        this.mboundView19 = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) objArr[21];
        this.mboundView21 = textView3;
        textView3.setTag(null);
        TextView textView4 = (TextView) objArr[23];
        this.mboundView23 = textView4;
        textView4.setTag(null);
        TextView textView5 = (TextView) objArr[25];
        this.mboundView25 = textView5;
        textView5.setTag(null);
        TextView textView6 = (TextView) objArr[27];
        this.mboundView27 = textView6;
        textView6.setTag(null);
        TextView textView7 = (TextView) objArr[29];
        this.mboundView29 = textView7;
        textView7.setTag(null);
        TextView textView8 = (TextView) objArr[31];
        this.mboundView31 = textView8;
        textView8.setTag(null);
        TextView textView9 = (TextView) objArr[33];
        this.mboundView33 = textView9;
        textView9.setTag(null);
        TextView textView10 = (TextView) objArr[35];
        this.mboundView35 = textView10;
        textView10.setTag(null);
        TextView textView11 = (TextView) objArr[37];
        this.mboundView37 = textView11;
        textView11.setTag(null);
        TextView textView12 = (TextView) objArr[39];
        this.mboundView39 = textView12;
        textView12.setTag(null);
        TextView textView13 = (TextView) objArr[41];
        this.mboundView41 = textView13;
        textView13.setTag(null);
        TextView textView14 = (TextView) objArr[43];
        this.mboundView43 = textView14;
        textView14.setTag(null);
        TextView textView15 = (TextView) objArr[45];
        this.mboundView45 = textView15;
        textView15.setTag(null);
        TextView textView16 = (TextView) objArr[47];
        this.mboundView47 = textView16;
        textView16.setTag(null);
        this.triggerDurationLimitLow.setTag(null);
        this.triggerDurationLimitLowValues.setTag(null);
        this.triggerDurationLimitUp.setTag(null);
        this.triggerDurationLimitUpValues.setTag(null);
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
            this.mDirtyFlags = PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
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

    @Override // com.rigol.scope.databinding.AdapterTriggerDurationBinding
    public void setSweepSingleMapping(MappingObject mappingObject) {
        this.mSweepSingleMapping = mappingObject;
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerDurationBinding
    public void setSweepNormalMapping(MappingObject mappingObject) {
        this.mSweepNormalMapping = mappingObject;
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerDurationBinding
    public void setParam(TriggerParam triggerParam) {
        updateRegistration(3, triggerParam);
        this.mParam = triggerParam;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(594);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerDurationBinding
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
                        return onChangeSweepAutoMapping((MappingObject) obj, i2);
                    }
                    return onChangeParam((TriggerParam) obj, i2);
                }
                return onChangeSweepNormalMapping((MappingObject) obj, i2);
            }
            return onChangeSweepSingleMapping((MappingObject) obj, i2);
        }
        return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerSourceLaExtAcParamChanValue1((MappingObject) obj, i2);
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerSourceLaExtAcParamChanValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeSweepSingleMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeSweepNormalMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeParam(TriggerParam triggerParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        } else if (i == 256) {
            synchronized (this) {
                this.mDirtyFlags |= 192;
            }
            return true;
        } else if (i == 249) {
            synchronized (this) {
                this.mDirtyFlags |= 256;
            }
            return true;
        } else if (i == 251) {
            synchronized (this) {
                this.mDirtyFlags |= 512;
            }
            return true;
        } else if (i == 152) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 484) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
            }
            return true;
        } else if (i == 671) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
            }
            return true;
        } else if (i == 164) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            }
            return true;
        } else if (i == 377) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE;
            }
            return true;
        } else if (i == 448) {
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
                this.mDirtyFlags |= 16;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:304:0x05be  */
    /* JADX WARN: Removed duplicated region for block: B:307:0x05ee  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:337:0x0643  */
    /* JADX WARN: Removed duplicated region for block: B:340:0x0657  */
    /* JADX WARN: Removed duplicated region for block: B:344:0x0677  */
    /* JADX WARN: Removed duplicated region for block: B:347:0x0686  */
    /* JADX WARN: Removed duplicated region for block: B:367:0x06b2  */
    /* JADX WARN: Removed duplicated region for block: B:375:0x06d5  */
    /* JADX WARN: Removed duplicated region for block: B:383:0x0824  */
    /* JADX WARN: Removed duplicated region for block: B:386:0x0859  */
    /* JADX WARN: Removed duplicated region for block: B:390:0x08e4  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 3455
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rigol.scope.databinding.AdapterTriggerDurationBindingImpl.executeBindings():void");
    }
}
