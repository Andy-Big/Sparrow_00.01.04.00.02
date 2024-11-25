package com.rigol.scope.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
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
public class AdapterTriggerRuntBindingImpl extends AdapterTriggerRuntBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.guideline_left, 22);
        sViewsWithIds.put(R.id.guideline_center, 23);
        sViewsWithIds.put(R.id.guideline_right, 24);
        sViewsWithIds.put(R.id.guideline_forth, 25);
        sViewsWithIds.put(R.id.guideline_fifth, 26);
        sViewsWithIds.put(R.id.view_top, 27);
        sViewsWithIds.put(R.id.trigger_source_label, 28);
        sViewsWithIds.put(R.id.trigger_runt_polarity_label, 29);
        sViewsWithIds.put(R.id.trigger_levelB, 30);
        sViewsWithIds.put(R.id.runt_trigger_label, 31);
        sViewsWithIds.put(R.id.trigger_level, 32);
        sViewsWithIds.put(R.id.verticalSeekBarWrapper2, 33);
        sViewsWithIds.put(R.id.verticalSeekBarWrapper3, 34);
        sViewsWithIds.put(R.id.trigger_holdoff_label, 35);
        sViewsWithIds.put(R.id.trigger_noise_label, 36);
        sViewsWithIds.put(R.id.view2, 37);
        sViewsWithIds.put(R.id.view16, 38);
    }

    public AdapterTriggerRuntBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 39, sIncludes, sViewsWithIds));
    }

    private AdapterTriggerRuntBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 11, (Button) objArr[9], (Button) objArr[10], (Guideline) objArr[23], (Guideline) objArr[26], (Guideline) objArr[25], (Guideline) objArr[22], (Guideline) objArr[24], (ImageView) objArr[14], (RadioButton) objArr[19], (RadioButton) objArr[18], (TextView) objArr[4], (EditText) objArr[5], (RadioButton) objArr[17], (RadioButton) objArr[1], (RadioButton) objArr[8], (RadioButton) objArr[7], (TextView) objArr[31], (EditText) objArr[20], (TextView) objArr[35], (TextView) objArr[32], (EditText) objArr[12], (VerticalSeekBar) objArr[15], (TextView) objArr[30], (EditText) objArr[13], (VerticalSeekBar) objArr[16], (CheckBox) objArr[11], (TextView) objArr[36], (SwitchButton) objArr[21], (TextView) objArr[29], (TextView) objArr[6], (TextView) objArr[28], (TextView) objArr[2], (EditText) objArr[3], (VerticalSeekBarWrapper) objArr[33], (VerticalSeekBarWrapper) objArr[34], (View) objArr[38], (View) objArr[37], (View) objArr[27]);
        this.mDirtyFlags = -1L;
        this.buttonLevel.setTag(null);
        this.buttonLevelB.setTag(null);
        this.imageView2.setTag(null);
        this.lessMore.setTag(null);
        this.lessThan.setTag(null);
        this.lowerLimit.setTag(null);
        this.lowerLimitValue.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.moreThan.setTag(null);
        this.none.setTag(null);
        this.runtNegative.setTag(null);
        this.runtPositive.setTag(null);
        this.triggerHoldoff.setTag(null);
        this.triggerLevelAValue.setTag(null);
        this.triggerLevelAView.setTag(null);
        this.triggerLevelBValue.setTag(null);
        this.triggerLevelBView.setTag(null);
        this.triggerLevelSelectAb.setTag(null);
        this.triggerNoiseSwitch.setTag(null);
        this.triggerSource.setTag(null);
        this.upperLimit.setTag(null);
        this.upperLimitValue.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 268435456L;
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
        if (643 == i) {
            setPolarityNegativeMapping((MappingObject) obj);
        } else if (594 == i) {
            setParam((TriggerParam) obj);
        } else if (916 == i) {
            setSweepAutoMapping((MappingObject) obj);
        } else if (788 == i) {
            setSelectLevelABMapping((MappingObject) obj);
        } else if (1060 == i) {
            setWhenNoneMapping((MappingObject) obj);
        } else if (918 == i) {
            setSweepSingleMapping((MappingObject) obj);
        } else if (790 == i) {
            setSelectLevelBMapping((MappingObject) obj);
        } else if (917 == i) {
            setSweepNormalMapping((MappingObject) obj);
        } else if (644 == i) {
            setPolarityPositiveMapping((MappingObject) obj);
        } else if (789 != i) {
            return false;
        } else {
            setSelectLevelAMapping((MappingObject) obj);
        }
        return true;
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerRuntBinding
    public void setPolarityNegativeMapping(MappingObject mappingObject) {
        updateRegistration(0, mappingObject);
        this.mPolarityNegativeMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(643);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerRuntBinding
    public void setParam(TriggerParam triggerParam) {
        updateRegistration(1, triggerParam);
        this.mParam = triggerParam;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(594);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerRuntBinding
    public void setSweepAutoMapping(MappingObject mappingObject) {
        this.mSweepAutoMapping = mappingObject;
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerRuntBinding
    public void setSelectLevelABMapping(MappingObject mappingObject) {
        this.mSelectLevelABMapping = mappingObject;
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerRuntBinding
    public void setWhenNoneMapping(MappingObject mappingObject) {
        updateRegistration(4, mappingObject);
        this.mWhenNoneMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        notifyPropertyChanged(1060);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerRuntBinding
    public void setSweepSingleMapping(MappingObject mappingObject) {
        this.mSweepSingleMapping = mappingObject;
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerRuntBinding
    public void setSelectLevelBMapping(MappingObject mappingObject) {
        this.mSelectLevelBMapping = mappingObject;
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerRuntBinding
    public void setSweepNormalMapping(MappingObject mappingObject) {
        this.mSweepNormalMapping = mappingObject;
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerRuntBinding
    public void setPolarityPositiveMapping(MappingObject mappingObject) {
        updateRegistration(9, mappingObject);
        this.mPolarityPositiveMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 512;
        }
        notifyPropertyChanged(644);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerRuntBinding
    public void setSelectLevelAMapping(MappingObject mappingObject) {
        this.mSelectLevelAMapping = mappingObject;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return onChangePolarityNegativeMapping((MappingObject) obj, i2);
            case 1:
                return onChangeParam((TriggerParam) obj, i2);
            case 2:
                return onChangeSweepAutoMapping((MappingObject) obj, i2);
            case 3:
                return onChangeSelectLevelABMapping((MappingObject) obj, i2);
            case 4:
                return onChangeWhenNoneMapping((MappingObject) obj, i2);
            case 5:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerSourceParamChanValue1((MappingObject) obj, i2);
            case 6:
                return onChangeSweepSingleMapping((MappingObject) obj, i2);
            case 7:
                return onChangeSelectLevelBMapping((MappingObject) obj, i2);
            case 8:
                return onChangeSweepNormalMapping((MappingObject) obj, i2);
            case 9:
                return onChangePolarityPositiveMapping((MappingObject) obj, i2);
            case 10:
                return onChangeSelectLevelAMapping((MappingObject) obj, i2);
            default:
                return false;
        }
    }

    private boolean onChangePolarityNegativeMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
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

    private boolean onChangeParam(TriggerParam triggerParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        } else if (i == 256) {
            synchronized (this) {
                this.mDirtyFlags |= 12288;
            }
            return true;
        } else if (i == 764) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE;
            }
            return true;
        } else if (i == 761) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 152) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
            }
            return true;
        } else if (i == 762) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
            }
            return true;
        } else if (i == 763) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
            }
            return true;
        } else if (i == 765) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
            }
            return true;
        } else if (i == 766) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
            }
            return true;
        } else if (i == 672) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
            }
            return true;
        } else if (i == 673) {
            synchronized (this) {
                this.mDirtyFlags |= 4194304;
            }
            return true;
        } else if (i == 377) {
            synchronized (this) {
                this.mDirtyFlags |= 8388608;
            }
            return true;
        } else if (i == 448) {
            synchronized (this) {
                this.mDirtyFlags |= 16777216;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeSweepAutoMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeSelectLevelABMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeWhenNoneMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 33554432;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerSourceParamChanValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 67108864;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeSweepSingleMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeSelectLevelBMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeSweepNormalMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 256;
            }
            return true;
        }
        return false;
    }

    private boolean onChangePolarityPositiveMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 512;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 134217728;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeSelectLevelAMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:180:0x0307, code lost:
        if (r39 != false) goto L140;
     */
    /* JADX WARN: Removed duplicated region for block: B:116:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0211 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:131:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x025c  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x02ef  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0314  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0325  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0334  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0358  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0364  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0379  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x038f  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x03ad  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x03b8  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x03c7  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x03d4  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x03e3  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x03f2  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x0401  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x040e  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x041b  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x0428  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x0435  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x0442  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x0451  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x045e  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:252:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00f5 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0198  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 1129
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rigol.scope.databinding.AdapterTriggerRuntBindingImpl.executeBindings():void");
    }
}
