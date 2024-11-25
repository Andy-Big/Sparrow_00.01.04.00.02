package com.rigol.scope.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.RefParam;
import com.rigol.scope.views.SwitchButton;
import com.rigol.scope.views.baseview.BaseEditText;
/* loaded from: classes2.dex */
public class PopupviewRefBindingImpl extends PopupviewRefBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.math_guideline_center, 17);
        sViewsWithIds.put(R.id.ref_channel, 18);
        sViewsWithIds.put(R.id.source, 19);
        sViewsWithIds.put(R.id.save, 20);
        sViewsWithIds.put(R.id.save_btn, 21);
        sViewsWithIds.put(R.id.clean, 22);
        sViewsWithIds.put(R.id.math_dividing_line, 23);
        sViewsWithIds.put(R.id.ref_import, 24);
        sViewsWithIds.put(R.id.import_btn, 25);
        sViewsWithIds.put(R.id.ref_export, 26);
        sViewsWithIds.put(R.id.label, 27);
        sViewsWithIds.put(R.id.ref_color, 28);
        sViewsWithIds.put(R.id.ref_reset, 29);
    }

    public PopupviewRefBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 30, sIncludes, sViewsWithIds));
    }

    private PopupviewRefBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 6, (TextView) objArr[22], (Button) objArr[3], (Button) objArr[25], (TextView) objArr[27], (BaseEditText) objArr[13], (SwitchButton) objArr[14], (ImageButton) objArr[7], (ImageButton) objArr[6], (View) objArr[23], (Guideline) objArr[17], (ImageButton) objArr[11], (ImageButton) objArr[10], (TextView) objArr[8], (EditText) objArr[9], (TextView) objArr[18], (TextView) objArr[1], (TextView) objArr[28], (TextView) objArr[15], (TextView) objArr[26], (Button) objArr[12], (TextView) objArr[24], (TextView) objArr[29], (Button) objArr[16], (TextView) objArr[20], (Button) objArr[21], (TextView) objArr[4], (EditText) objArr[5], (TextView) objArr[19], (TextView) objArr[2]);
        this.mDirtyFlags = -1L;
        this.cleanBtn.setTag(null);
        this.labelEditText.setTag(null);
        this.labelSwitch.setTag(null);
        this.mainScaleNomal.setTag(null);
        this.mainScaleVertical.setTag(null);
        this.mathOffsetDown.setTag(null);
        this.mathOffsetUp.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.offset.setTag(null);
        this.offsetEditText.setTag(null);
        this.refChannelSpinner.setTag(null);
        this.refColorSpinner.setTag(null);
        this.refExportBtn.setTag(null);
        this.refResetBtn.setTag(null);
        this.scale.setTag(null);
        this.scaleEditText.setTag(null);
        this.sourceSpinner.setTag(null);
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
        if (594 == i) {
            setParam((RefParam) obj);
            return true;
        }
        return false;
    }

    @Override // com.rigol.scope.databinding.PopupviewRefBinding
    public void setParam(RefParam refParam) {
        updateRegistration(4, refParam);
        this.mParam = refParam;
        synchronized (this) {
            this.mDirtyFlags |= 16;
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
                            return onChangeParamParam1((RefParam.Param) obj, i2);
                        }
                        return onChangeParam((RefParam) obj, i2);
                    }
                    return onChangeParamParam((RefParam.Param) obj, i2);
                }
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgRefSourceParamParamSrcChanValue1((MappingObject) obj, i2);
            }
            return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgRefColorParamParamRefColorValue1((MappingObject) obj, i2);
        }
        return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgRefChannelParamRefChan((MappingObject) obj, i2);
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgRefChannelParamRefChan(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgRefColorParamParamRefColorValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgRefSourceParamParamSrcChanValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeParamParam(RefParam.Param param, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        } else if (i == 897) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        } else if (i == 1020) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
            }
            return true;
        } else if (i == 987) {
            synchronized (this) {
                this.mDirtyFlags |= 256;
            }
            return true;
        } else if (i == 1019) {
            synchronized (this) {
                this.mDirtyFlags |= 512;
            }
            return true;
        } else if (i == 475) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 716) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeParam(RefParam refParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        } else if (i == 714) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
            }
            return true;
        } else if (i == 594) {
            synchronized (this) {
                this.mDirtyFlags |= 40;
            }
            return true;
        } else if (i == 828) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeParamParam1(RefParam.Param param, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        } else if (i == 570) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE;
            }
            return true;
        } else if (i == 897) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
            }
            return true;
        } else {
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x025c  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0266  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0271  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0278  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x02a6  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x02b1  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x02be  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x02cb  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x02d8  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x02e7  */
    /* JADX WARN: Removed duplicated region for block: B:169:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0183 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0191  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 754
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rigol.scope.databinding.PopupviewRefBindingImpl.executeBindings():void");
    }
}
