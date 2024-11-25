package com.rigol.scope.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
import com.rigol.scope.data.HorizontalParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.NavigateParam;
/* loaded from: classes2.dex */
public class PopupviewNavigateBindingImpl extends PopupviewNavigateBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.modeRadio, 23);
        sViewsWithIds.put(R.id.speedLinear, 24);
        sViewsWithIds.put(R.id.typeLinear, 25);
        sViewsWithIds.put(R.id.serchButton, 26);
        sViewsWithIds.put(R.id.frameLinear, 27);
        sViewsWithIds.put(R.id.currentFrameText, 28);
        sViewsWithIds.put(R.id.lineView, 29);
    }

    public PopupviewNavigateBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 30, sIncludes, sViewsWithIds));
    }

    private PopupviewNavigateBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 6, (TextView) objArr[28], (TextView) objArr[17], (RadioButton) objArr[3], (RelativeLayout) objArr[27], (RadioButton) objArr[4], (TextView) objArr[14], (TextView) objArr[13], (TextView) objArr[16], (View) objArr[29], (RadioGroup) objArr[23], (TextView) objArr[1], (ConstraintLayout) objArr[0], (ImageView) objArr[20], (ImageView) objArr[19], (ImageView) objArr[21], (ImageView) objArr[22], (ImageView) objArr[18], (Button) objArr[26], (LinearLayout) objArr[24], (TextView) objArr[6], (TextView) objArr[5], (TextView) objArr[12], (TextView) objArr[11], (RadioButton) objArr[2], (LinearLayout) objArr[25], (TextView) objArr[8], (TextView) objArr[7], (TextView) objArr[15], (TextView) objArr[10], (TextView) objArr[9]);
        this.mDirtyFlags = -1L;
        this.currentText.setTag(null);
        this.eventRadio.setTag(null);
        this.frameRadio.setTag(null);
        this.frameSpeedSpinner.setTag(null);
        this.frameSpeedText.setTag(null);
        this.frameText.setTag(null);
        this.modeText.setTag(null);
        this.navigateLayout.setTag(null);
        this.playImage.setTag(null);
        this.playLastImage.setTag(null);
        this.playNextImage.setTag(null);
        this.recordToEndImage.setTag(null);
        this.recordToStartImage.setTag(null);
        this.speedSpinner.setTag(null);
        this.speedText.setTag(null);
        this.startFrameEdit.setTag(null);
        this.startFrameText.setTag(null);
        this.timeRadio.setTag(null);
        this.typeSpinner.setTag(null);
        this.typeText.setTag(null);
        this.visibleFrameText.setTag(null);
        this.visibleSpinner.setTag(null);
        this.visibleText.setTag(null);
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
        if (594 == i) {
            setParam((NavigateParam) obj);
        } else if (380 != i) {
            return false;
        } else {
            setHorizontal((HorizontalParam) obj);
        }
        return true;
    }

    @Override // com.rigol.scope.databinding.PopupviewNavigateBinding
    public void setParam(NavigateParam navigateParam) {
        updateRegistration(3, navigateParam);
        this.mParam = navigateParam;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(594);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewNavigateBinding
    public void setHorizontal(HorizontalParam horizontalParam) {
        updateRegistration(4, horizontalParam);
        this.mHorizontal = horizontalParam;
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        notifyPropertyChanged(380);
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
                            return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgNavigateTimeoffsetSpeedParamTimeSpeed((MappingObject) obj, i2);
                        }
                        return onChangeHorizontal((HorizontalParam) obj, i2);
                    }
                    return onChangeParam((NavigateParam) obj, i2);
                }
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgSearchTypeParamSerchType((MappingObject) obj, i2);
            }
            return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgNavigateFramedrawDisplaymodeParamFrameMode((MappingObject) obj, i2);
        }
        return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgNavigateTimeoffsetSpeedParamFrameSpeed((MappingObject) obj, i2);
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgNavigateTimeoffsetSpeedParamFrameSpeed(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgNavigateFramedrawDisplaymodeParamFrameMode(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgSearchTypeParamSerchType(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeParam(NavigateParam navigateParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        } else if (i == 556) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        } else if (i == 791) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
            }
            return true;
        } else if (i == 412) {
            synchronized (this) {
                this.mDirtyFlags |= 256;
            }
            return true;
        } else if (i == 937) {
            synchronized (this) {
                this.mDirtyFlags |= 512;
            }
            return true;
        } else if (i == 807) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 348) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
            }
            return true;
        } else if (i == 350) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
            }
            return true;
        } else if (i == 349) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            }
            return true;
        } else if (i == 347) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE;
            }
            return true;
        } else if (i == 197) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 524) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeHorizontal(HorizontalParam horizontalParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        } else if (i == 28) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgNavigateTimeoffsetSpeedParamTimeSpeed(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:122:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x028c  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x02b2  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x02c3  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x02f2  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0394  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x03bc  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x03c4  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x03c8  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x03d3  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x03f2  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0402  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x048d  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x049f  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x04a8  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x04b1  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x04ee  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x0517  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x052e  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x0537  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x053c  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x0545  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x054e  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x0556  */
    /* JADX WARN: Removed duplicated region for block: B:275:0x0564  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x0576  */
    /* JADX WARN: Removed duplicated region for block: B:283:0x05a2  */
    /* JADX WARN: Removed duplicated region for block: B:286:0x05ad  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x0614  */
    /* JADX WARN: Removed duplicated region for block: B:294:0x0621  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x0677  */
    /* JADX WARN: Removed duplicated region for block: B:301:0x0680  */
    /* JADX WARN: Removed duplicated region for block: B:307:0x06b8  */
    /* JADX WARN: Removed duplicated region for block: B:310:0x06c7  */
    /* JADX WARN: Removed duplicated region for block: B:313:0x06d4  */
    /* JADX WARN: Removed duplicated region for block: B:316:0x06e3  */
    /* JADX WARN: Removed duplicated region for block: B:323:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x014b  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 1774
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rigol.scope.databinding.PopupviewNavigateBindingImpl.executeBindings():void");
    }
}
