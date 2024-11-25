package com.rigol.scope.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
import com.rigol.scope.data.LaParam;
import com.rigol.scope.data.MappingObject;
/* loaded from: classes2.dex */
public class AdapterLaBasicBindingImpl extends AdapterLaBasicBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.la_wave_size, 24);
        sViewsWithIds.put(R.id.la_peak, 25);
    }

    public AdapterLaBasicBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 26, sIncludes, sViewsWithIds));
    }

    private AdapterLaBasicBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3, (AppCompatCheckBox) objArr[3], (AppCompatCheckBox) objArr[1], (AppCompatCheckBox) objArr[4], (AppCompatCheckBox) objArr[15], (AppCompatCheckBox) objArr[16], (AppCompatCheckBox) objArr[17], (AppCompatCheckBox) objArr[18], (AppCompatCheckBox) objArr[19], (AppCompatCheckBox) objArr[20], (AppCompatCheckBox) objArr[5], (AppCompatCheckBox) objArr[6], (AppCompatCheckBox) objArr[7], (AppCompatCheckBox) objArr[8], (AppCompatCheckBox) objArr[9], (AppCompatCheckBox) objArr[10], (AppCompatCheckBox) objArr[13], (AppCompatCheckBox) objArr[11], (AppCompatCheckBox) objArr[14], (EditText) objArr[2], (EditText) objArr[12], (TextView) objArr[23], (TextView) objArr[25], (TextView) objArr[22], (TextView) objArr[24], (TextView) objArr[21]);
        this.mDirtyFlags = -1L;
        this.d0.setTag(null);
        this.d0tod7.setTag(null);
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
        this.d8tod15.setTag(null);
        this.d9.setTag(null);
        this.laBasic.setTag(null);
        this.laBasicTwo.setTag(null);
        this.laOrder.setTag(null);
        this.laPeakSpinner.setTag(null);
        this.laWaveSpinner.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = PlaybackStateCompat.ACTION_PLAY_FROM_URI;
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
        } else if (177 != i) {
            return false;
        } else {
            setCheckedChangeListener((CompoundButton.OnCheckedChangeListener) obj);
        }
        return true;
    }

    @Override // com.rigol.scope.databinding.AdapterLaBasicBinding
    public void setParma(LaParam laParam) {
        updateRegistration(1, laParam);
        this.mParma = laParam;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(600);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterLaBasicBinding
    public void setCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.mCheckedChangeListener = onCheckedChangeListener;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(177);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    return false;
                }
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgLaWaveSizeParmaLaSize((MappingObject) obj, i2);
            }
            return onChangeParma((LaParam) obj, i2);
        }
        return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgLaAutoSetParmaLaOrder((MappingObject) obj, i2);
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgLaAutoSetParmaLaOrder(MappingObject mappingObject, int i) {
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
        } else if (i == 209) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        } else if (i == 210) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        } else if (i == 168) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        } else if (i == 211) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
            }
            return true;
        } else if (i == 212) {
            synchronized (this) {
                this.mDirtyFlags |= 256;
            }
            return true;
        } else if (i == 472) {
            synchronized (this) {
                this.mDirtyFlags |= 512;
            }
            return true;
        } else if (i == 466) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 455) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgLaWaveSizeParmaLaSize(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
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

    /* JADX WARN: Removed duplicated region for block: B:100:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0241  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x024c  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0264  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0286  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0296  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x02ad  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x02bb  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x02d2  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x02e0  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x02f8  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0308  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0320  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0330  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0347  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0355  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x036d  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0378  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0390  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x039e  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x03b5  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x03c5  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x03dd  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x03eb  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x0403  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x0411  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x042a  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x020c  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 1604
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rigol.scope.databinding.AdapterLaBasicBindingImpl.executeBindings():void");
    }
}
