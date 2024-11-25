package com.rigol.scope.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
import com.rigol.scope.data.LaParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.views.SwitchButton;
/* loaded from: classes2.dex */
public class AbapterLaSeniorBindingImpl extends AbapterLaSeniorBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.la_source, 25);
        sViewsWithIds.put(R.id.la_source_on_off, 26);
        sViewsWithIds.put(R.id.trigger_noise_switch, 27);
        sViewsWithIds.put(R.id.la_source_group_text, 28);
        sViewsWithIds.put(R.id.la_wave_color, 29);
        sViewsWithIds.put(R.id.la_group_cancel, 30);
        sViewsWithIds.put(R.id.la_label_show, 31);
        sViewsWithIds.put(R.id.la_source_group_text1, 32);
        sViewsWithIds.put(R.id.la_source_group_text2, 33);
        sViewsWithIds.put(R.id.la_source_group_text3, 34);
    }

    public AbapterLaSeniorBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 35, sIncludes, sViewsWithIds));
    }

    private AbapterLaSeniorBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 6, (AppCompatCheckBox) objArr[3], (AppCompatCheckBox) objArr[4], (AppCompatCheckBox) objArr[13], (AppCompatCheckBox) objArr[14], (AppCompatCheckBox) objArr[15], (AppCompatCheckBox) objArr[16], (AppCompatCheckBox) objArr[17], (AppCompatCheckBox) objArr[18], (AppCompatCheckBox) objArr[5], (AppCompatCheckBox) objArr[6], (AppCompatCheckBox) objArr[7], (AppCompatCheckBox) objArr[8], (AppCompatCheckBox) objArr[9], (AppCompatCheckBox) objArr[10], (AppCompatCheckBox) objArr[11], (AppCompatCheckBox) objArr[12], (Button) objArr[30], (TextView) objArr[20], (TextView) objArr[31], (TextView) objArr[19], (TextView) objArr[25], (TextView) objArr[22], (TextView) objArr[2], (TextView) objArr[28], (TextView) objArr[32], (TextView) objArr[33], (TextView) objArr[34], (TextView) objArr[21], (TextView) objArr[23], (TextView) objArr[26], (TextView) objArr[1], (TextView) objArr[29], (SwitchButton) objArr[24], (SwitchButton) objArr[27]);
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
        this.laLabelEdit.setTag(null);
        this.laLabelText.setTag(null);
        this.laSourceCentre.setTag(null);
        this.laSourceGroup.setTag(null);
        this.laSourceHigh.setTag(null);
        this.laSourceLow.setTag(null);
        this.laSourceSpinner.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.showLabelSwitch.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
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
        if (600 == i) {
            setParma((LaParam) obj);
            return true;
        }
        return false;
    }

    @Override // com.rigol.scope.databinding.AbapterLaSeniorBinding
    public void setParma(LaParam laParam) {
        updateRegistration(1, laParam);
        this.mParma = laParam;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(600);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
                                return false;
                            }
                            return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgLaHighColorParmaLaHighColor((MappingObject) obj, i2);
                        }
                        return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgLaHighColorParmaLaEdgeColor((MappingObject) obj, i2);
                    }
                    return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgLaGroupSetParmaLaGroup1((MappingObject) obj, i2);
                }
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgLaHighColorParmaLaLowColor((MappingObject) obj, i2);
            }
            return onChangeParma((LaParam) obj, i2);
        }
        return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgLaCurrentChanParmaLaSource((MappingObject) obj, i2);
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgLaCurrentChanParmaLaSource(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeParma(LaParam laParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        } else if (i == 473) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        } else if (i == 457) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
            }
            return true;
        } else if (i == 355) {
            synchronized (this) {
                this.mDirtyFlags |= 256;
            }
            return true;
        } else if (i == 475) {
            synchronized (this) {
                this.mDirtyFlags |= 512;
            }
            return true;
        } else if (i == 434) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 461) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
            }
            return true;
        } else if (i == 456) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
            }
            return true;
        } else if (i == 465) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            }
            return true;
        } else if (i == 476) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgLaHighColorParmaLaLowColor(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgLaGroupSetParmaLaGroup1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
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

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgLaHighColorParmaLaEdgeColor(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
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

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgLaHighColorParmaLaHighColor(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
            }
            return true;
        } else {
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:141:0x0257  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x029b A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:149:0x02aa  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x02bb  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x02c8 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:161:0x02dd  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0303  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0315  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x032f  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0094  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 1307
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rigol.scope.databinding.AbapterLaSeniorBindingImpl.executeBindings():void");
    }
}
