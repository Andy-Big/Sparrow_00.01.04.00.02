package com.rigol.scope.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
import com.rigol.scope.data.AfgParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.views.SwitchButton;
import com.rigol.scope.views.baseview.BaseEditText;
/* loaded from: classes2.dex */
public class AdapterAwgBindingImpl extends AdapterAwgBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;
    private final ImageView mboundView21;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.left_guideline, 22);
        sViewsWithIds.put(R.id.left_guideline2, 23);
        sViewsWithIds.put(R.id.sweep_out_text, 24);
        sViewsWithIds.put(R.id.source_type_text, 25);
    }

    public AdapterAwgBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 26, sIncludes, sViewsWithIds));
    }

    private AdapterAwgBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 6, (BaseEditText) objArr[12], (TextView) objArr[11], (TextView) objArr[9], (BaseEditText) objArr[10], (SwitchButton) objArr[1], (Guideline) objArr[22], (Guideline) objArr[23], (BaseEditText) objArr[20], (TextView) objArr[19], (BaseEditText) objArr[18], (TextView) objArr[17], (BaseEditText) objArr[16], (TextView) objArr[15], (BaseEditText) objArr[14], (TextView) objArr[13], (TextView) objArr[2], (TextView) objArr[25], (TextView) objArr[24], (TextView) objArr[4], (TextView) objArr[3], (TextView) objArr[6], (TextView) objArr[5], (TextView) objArr[8], (TextView) objArr[7]);
        this.mDirtyFlags = -1L;
        this.basicAmpEdit.setTag(null);
        this.basicAmpText.setTag(null);
        this.fraguencyText.setTag(null);
        this.labelEditText.setTag(null);
        this.labelSwitch.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[21];
        this.mboundView21 = imageView;
        imageView.setTag(null);
        this.phaseDepthEdit.setTag(null);
        this.phaseDepthText.setTag(null);
        this.phaseEditText.setTag(null);
        this.phaseText.setTag(null);
        this.rangeDepthEdit.setTag(null);
        this.rangeDepthText.setTag(null);
        this.rangeEditText.setTag(null);
        this.rangeText.setTag(null);
        this.sourceTypeSpinner.setTag(null);
        this.waveTypeSpinner.setTag(null);
        this.waveTypeText.setTag(null);
        this.waveTypefmSpinner.setTag(null);
        this.waveTypefmText.setTag(null);
        this.waveTypepmSpinner.setTag(null);
        this.waveTypepmText.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 16777216L;
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
            setParam((AfgParam) obj);
            return true;
        }
        return false;
    }

    @Override // com.rigol.scope.databinding.AdapterAwgBinding
    public void setParam(AfgParam afgParam) {
        updateRegistration(0, afgParam);
        this.mParam = afgParam;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(594);
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
                            return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgAfgWaveModTypeParamAfgWaveModType((MappingObject) obj, i2);
                        }
                        return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgAfgWaveModAmShapeParamAfgWavePmShape((MappingObject) obj, i2);
                    }
                    return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgAfgWaveModAmShapeParamAfgWaveFmShape((MappingObject) obj, i2);
                }
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgAfgWaveModAmShapeParamAfgWaveAmShape((MappingObject) obj, i2);
            }
            return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgAfgModPicParamWaveModPic((MappingObject) obj, i2);
        }
        return onChangeParam((AfgParam) obj, i2);
    }

    private boolean onChangeParam(AfgParam afgParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i == 812) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        } else if (i == 1040) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
            }
            return true;
        } else if (i == 41) {
            synchronized (this) {
                this.mDirtyFlags |= 256;
            }
            return true;
        } else if (i == 39) {
            synchronized (this) {
                this.mDirtyFlags |= 512;
            }
            return true;
        } else if (i == 40) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 42) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
            }
            return true;
        } else if (i == 1042) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
            }
            return true;
        } else if (i == 1043) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            }
            return true;
        } else if (i == 1044) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE;
            }
            return true;
        } else if (i == 1041) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 1047) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
            }
            return true;
        } else if (i == 1046) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
            }
            return true;
        } else if (i == 1045) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgAfgModPicParamWaveModPic(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        } else if (i == 638) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgAfgWaveModAmShapeParamAfgWaveAmShape(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgAfgWaveModAmShapeParamAfgWaveFmShape(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgAfgWaveModAmShapeParamAfgWavePmShape(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
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

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgAfgWaveModTypeParamAfgWaveModType(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 8388608;
            }
            return true;
        } else {
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:151:0x02a5  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x02e8  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x02ed  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0305  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0341  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0353  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x036b  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0379  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x03ab  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x046c  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x0487  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x0499  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x04a5  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x04cb  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x04e0  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x04ea  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x050f  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x052f  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x053e A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:296:0x054d  */
    /* JADX WARN: Removed duplicated region for block: B:309:0x057e  */
    /* JADX WARN: Removed duplicated region for block: B:312:0x0591 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:317:0x05a0  */
    /* JADX WARN: Removed duplicated region for block: B:322:0x05b2  */
    /* JADX WARN: Removed duplicated region for block: B:325:0x062b  */
    /* JADX WARN: Removed duplicated region for block: B:328:0x0637  */
    /* JADX WARN: Removed duplicated region for block: B:331:0x0642  */
    /* JADX WARN: Removed duplicated region for block: B:334:0x0686  */
    /* JADX WARN: Removed duplicated region for block: B:337:0x0698  */
    /* JADX WARN: Removed duplicated region for block: B:340:0x06a5  */
    /* JADX WARN: Removed duplicated region for block: B:343:0x06b2  */
    /* JADX WARN: Removed duplicated region for block: B:348:0x06ce  */
    /* JADX WARN: Removed duplicated region for block: B:351:0x06db  */
    /* JADX WARN: Removed duplicated region for block: B:354:0x06ea  */
    /* JADX WARN: Removed duplicated region for block: B:357:0x06f7  */
    /* JADX WARN: Removed duplicated region for block: B:360:0x070b  */
    /* JADX WARN: Removed duplicated region for block: B:363:0x071a  */
    /* JADX WARN: Removed duplicated region for block: B:366:0x0727  */
    /* JADX WARN: Removed duplicated region for block: B:369:0x073b  */
    /* JADX WARN: Removed duplicated region for block: B:372:0x074a  */
    /* JADX WARN: Removed duplicated region for block: B:375:0x0759  */
    /* JADX WARN: Removed duplicated region for block: B:378:0x0768  */
    /* JADX WARN: Removed duplicated region for block: B:385:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01de  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 1907
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rigol.scope.databinding.AdapterAwgBindingImpl.executeBindings():void");
    }
}
