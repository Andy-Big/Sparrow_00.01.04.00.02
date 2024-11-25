package com.rigol.scope.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
import com.rigol.scope.data.FftParam;
import com.rigol.scope.data.HorizontalParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.views.SwitchButton;
/* loaded from: classes2.dex */
public class AdapterRtsaBasesettingBindingImpl extends AdapterRtsaBasesettingBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.freq, 19);
        sViewsWithIds.put(R.id.freq_rectangle, 20);
        sViewsWithIds.put(R.id.fftCenter, 21);
        sViewsWithIds.put(R.id.fftStart, 22);
        sViewsWithIds.put(R.id.fftEnd, 23);
        sViewsWithIds.put(R.id.span, 24);
        sViewsWithIds.put(R.id.span_rectangle, 25);
        sViewsWithIds.put(R.id.fftSpan, 26);
        sViewsWithIds.put(R.id.bw, 27);
        sViewsWithIds.put(R.id.bw_rectangle, 28);
        sViewsWithIds.put(R.id.rbw, 29);
        sViewsWithIds.put(R.id.rbw_auto, 30);
        sViewsWithIds.put(R.id.window, 31);
        sViewsWithIds.put(R.id.ampt, 32);
        sViewsWithIds.put(R.id.ampt_rectangle, 33);
        sViewsWithIds.put(R.id.unit, 34);
        sViewsWithIds.put(R.id.source, 35);
        sViewsWithIds.put(R.id.persistTime, 36);
    }

    public AdapterRtsaBasesettingBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 37, sIncludes, sViewsWithIds));
    }

    private AdapterRtsaBasesettingBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 7, (TextView) objArr[32], (ImageView) objArr[33], (Button) objArr[16], (TextView) objArr[27], (ImageView) objArr[28], (TextView) objArr[21], (EditText) objArr[1], (TextView) objArr[23], (EditText) objArr[3], (TextView) objArr[26], (EditText) objArr[4], (TextView) objArr[22], (EditText) objArr[2], (TextView) objArr[19], (ImageView) objArr[20], (Button) objArr[6], (Button) objArr[5], (TextView) objArr[36], (TextView) objArr[18], (Button) objArr[17], (TextView) objArr[29], (TextView) objArr[30], (SwitchButton) objArr[8], (TextView) objArr[7], (TextView) objArr[10], (EditText) objArr[11], (TextView) objArr[13], (EditText) objArr[14], (TextView) objArr[35], (TextView) objArr[15], (TextView) objArr[24], (ImageView) objArr[25], (TextView) objArr[34], (TextView) objArr[12], (TextView) objArr[31], (TextView) objArr[9]);
        this.mDirtyFlags = -1L;
        this.autoTuneBtn.setTag(null);
        this.fftCenterEditText.setTag(null);
        this.fftEndEditText.setTag(null);
        this.fftSpanEditText.setTag(null);
        this.fftStartEditText.setTag(null);
        this.fullSpanBtn.setTag(null);
        this.lastSpanBtn.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.persistTimeSpinner.setTag(null);
        this.presetBtn.setTag(null);
        this.rbwAutoSwitch.setTag(null);
        this.rbwSpinner.setTag(null);
        this.refLevel.setTag(null);
        this.refLevelEditText.setTag(null);
        this.scale.setTag(null);
        this.scaleEditText.setTag(null);
        this.sourceSpinner.setTag(null);
        this.unitSpinner.setTag(null);
        this.windowSpinner.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
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
            setParam((FftParam) obj);
        } else if (379 != i) {
            return false;
        } else {
            setHoriParam((HorizontalParam) obj);
        }
        return true;
    }

    @Override // com.rigol.scope.databinding.AdapterRtsaBasesettingBinding
    public void setParam(FftParam fftParam) {
        updateRegistration(2, fftParam);
        this.mParam = fftParam;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(594);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterRtsaBasesettingBinding
    public void setHoriParam(HorizontalParam horizontalParam) {
        updateRegistration(6, horizontalParam);
        this.mHoriParam = horizontalParam;
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        notifyPropertyChanged(379);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgFftWindowParamWindowValue1((MappingObject) obj, i2);
            case 1:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgFftUnitParamUnitValue1((MappingObject) obj, i2);
            case 2:
                return onChangeParam((FftParam) obj, i2);
            case 3:
                return onChangeParamGetRBWListGetParamRbwValue1((MappingObject) obj, i2);
            case 4:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgFftSrcParamSrcValue1((MappingObject) obj, i2);
            case 5:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDisplayPersistimeParamPersistTimeValue1((MappingObject) obj, i2);
            case 6:
                return onChangeHoriParam((HorizontalParam) obj, i2);
            default:
                return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgFftWindowParamWindowValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgFftUnitParamUnitValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeParam(FftParam fftParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else if (i == 150) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
            }
            return true;
        } else if (i == 900) {
            synchronized (this) {
                this.mDirtyFlags |= 256;
            }
            return true;
        } else if (i == 273) {
            synchronized (this) {
                this.mDirtyFlags |= 512;
            }
            return true;
        } else if (i == 870) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 686) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
            }
            return true;
        } else if (i == 61) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
            }
            return true;
        } else if (i == 1075) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            }
            return true;
        } else if (i == 987) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE;
            }
            return true;
        } else if (i == 719) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 776) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
            }
            return true;
        } else if (i == 896) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
            }
            return true;
        } else if (i == 620) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeParamGetRBWListGetParamRbwValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgFftSrcParamSrcValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDisplayPersistimeParamPersistTimeValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeHoriParam(HorizontalParam horizontalParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        } else if (i == 760) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
            }
            return true;
        } else {
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0242 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0301  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0313  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x031d  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0334  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0344  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x034f  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x03aa  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x03b5  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x03c0  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x03cb  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x03d6  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x03e3  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x03ee  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x03f5  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0425  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0434  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x0443  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x0452  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x0461  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x046e  */
    /* JADX WARN: Removed duplicated region for block: B:228:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0193 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01d8 A[ADDED_TO_REGION] */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 1145
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rigol.scope.databinding.AdapterRtsaBasesettingBindingImpl.executeBindings():void");
    }
}
