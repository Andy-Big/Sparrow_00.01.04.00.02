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
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
import com.rigol.scope.data.HorizontalParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.VerticalParam;
import com.rigol.scope.generated.callback.OnClickListener;
import com.rigol.scope.views.SwitchButton;
import com.rigol.scope.views.baseview.BaseEditText;
/* loaded from: classes2.dex */
public class AdapterItemPopupviewVerticalBindingImpl extends AdapterItemPopupviewVerticalBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback10;
    private final View.OnClickListener mCallback11;
    private final View.OnClickListener mCallback12;
    private final View.OnClickListener mCallback13;
    private final View.OnClickListener mCallback14;
    private final View.OnClickListener mCallback15;
    private final View.OnClickListener mCallback16;
    private final View.OnClickListener mCallback17;
    private final View.OnClickListener mCallback18;
    private final View.OnClickListener mCallback19;
    private final View.OnClickListener mCallback20;
    private final View.OnClickListener mCallback21;
    private final View.OnClickListener mCallback22;
    private final View.OnClickListener mCallback23;
    private final View.OnClickListener mCallback24;
    private final View.OnClickListener mCallback25;
    private final View.OnClickListener mCallback26;
    private final View.OnClickListener mCallback27;
    private final View.OnClickListener mCallback28;
    private final View.OnClickListener mCallback29;
    private final View.OnClickListener mCallback4;
    private final View.OnClickListener mCallback5;
    private final View.OnClickListener mCallback6;
    private final View.OnClickListener mCallback7;
    private final View.OnClickListener mCallback8;
    private final View.OnClickListener mCallback9;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;
    private final TextView mboundView10;
    private final TextView mboundView13;
    private final TextView mboundView19;
    private final TextView mboundView23;
    private final TextView mboundView25;
    private final TextView mboundView27;
    private final ImageView mboundView3;
    private final TextView mboundView31;
    private final TextView mboundView33;
    private final TextView mboundView35;
    private final TextView mboundView39;
    private final ImageView mboundView4;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.diagram, 43);
        sViewsWithIds.put(R.id.display, 44);
    }

    public AdapterItemPopupviewVerticalBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 45, sIncludes, sViewsWithIds));
    }

    private AdapterItemPopupviewVerticalBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 6, (Button) objArr[6], (Button) objArr[17], (TextView) objArr[32], (TextView) objArr[20], (EditText) objArr[34], (ImageView) objArr[43], (TextView) objArr[44], (SwitchButton) objArr[9], (SwitchButton) objArr[26], (Button) objArr[5], (TextView) objArr[21], (SwitchButton) objArr[22], (SwitchButton) objArr[24], (ImageView) objArr[2], (ImageView) objArr[1], (ImageView) objArr[8], (ImageView) objArr[7], (BaseEditText) objArr[12], (SwitchButton) objArr[14], (Button) objArr[18], (EditText) objArr[40], (ImageButton) objArr[41], (ImageButton) objArr[42], (EditText) objArr[36], (ImageButton) objArr[37], (ImageButton) objArr[38], (Button) objArr[15], (EditText) objArr[28], (ImageButton) objArr[29], (ImageButton) objArr[30], (Button) objArr[16], (TextView) objArr[11]);
        this.mDirtyFlags = -1L;
        this.acButton.setTag(null);
        this.acquireBtn.setTag(null);
        this.bandwidthLimitSpinner.setTag(null);
        this.couplingSpinner.setTag(null);
        this.delayEditText.setTag(null);
        this.displaySwitch.setTag(null);
        this.fineSwitch.setTag(null);
        this.gudButton.setTag(null);
        this.impedance.setTag(null);
        this.impedanceSwitch.setTag(null);
        this.invertSwitch.setTag(null);
        this.ivImpedance1.setTag(null);
        this.ivImpedance50.setTag(null);
        this.ivLineImpedance1.setTag(null);
        this.ivLineImpedance50.setTag(null);
        this.labelEditText.setTag(null);
        this.labelSwitch.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView = (TextView) objArr[10];
        this.mboundView10 = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[13];
        this.mboundView13 = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) objArr[19];
        this.mboundView19 = textView3;
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
        ImageView imageView = (ImageView) objArr[3];
        this.mboundView3 = imageView;
        imageView.setTag(null);
        TextView textView7 = (TextView) objArr[31];
        this.mboundView31 = textView7;
        textView7.setTag(null);
        TextView textView8 = (TextView) objArr[33];
        this.mboundView33 = textView8;
        textView8.setTag(null);
        TextView textView9 = (TextView) objArr[35];
        this.mboundView35 = textView9;
        textView9.setTag(null);
        TextView textView10 = (TextView) objArr[39];
        this.mboundView39 = textView10;
        textView10.setTag(null);
        ImageView imageView2 = (ImageView) objArr[4];
        this.mboundView4 = imageView2;
        imageView2.setTag(null);
        this.measureBtn.setTag(null);
        this.offsetEditText.setTag(null);
        this.offsetLeft.setTag(null);
        this.offsetRight.setTag(null);
        this.positionEditText.setTag(null);
        this.positionLeft.setTag(null);
        this.positionRight.setTag(null);
        this.probeSettingBtn.setTag(null);
        this.scaleEditText.setTag(null);
        this.scaleLeft.setTag(null);
        this.scaleRight.setTag(null);
        this.triggerBtn.setTag(null);
        this.unitSpinner.setTag(null);
        setRootTag(view);
        this.mCallback27 = new OnClickListener(this, 24);
        this.mCallback15 = new OnClickListener(this, 12);
        this.mCallback16 = new OnClickListener(this, 13);
        this.mCallback28 = new OnClickListener(this, 25);
        this.mCallback9 = new OnClickListener(this, 6);
        this.mCallback25 = new OnClickListener(this, 22);
        this.mCallback13 = new OnClickListener(this, 10);
        this.mCallback8 = new OnClickListener(this, 5);
        this.mCallback14 = new OnClickListener(this, 11);
        this.mCallback26 = new OnClickListener(this, 23);
        this.mCallback7 = new OnClickListener(this, 4);
        this.mCallback23 = new OnClickListener(this, 20);
        this.mCallback11 = new OnClickListener(this, 8);
        this.mCallback19 = new OnClickListener(this, 16);
        this.mCallback6 = new OnClickListener(this, 3);
        this.mCallback12 = new OnClickListener(this, 9);
        this.mCallback24 = new OnClickListener(this, 21);
        this.mCallback5 = new OnClickListener(this, 2);
        this.mCallback17 = new OnClickListener(this, 14);
        this.mCallback21 = new OnClickListener(this, 18);
        this.mCallback29 = new OnClickListener(this, 26);
        this.mCallback4 = new OnClickListener(this, 1);
        this.mCallback20 = new OnClickListener(this, 17);
        this.mCallback10 = new OnClickListener(this, 7);
        this.mCallback22 = new OnClickListener(this, 19);
        this.mCallback18 = new OnClickListener(this, 15);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 2147483648L;
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
            setParam((VerticalParam) obj);
        } else if (569 == i) {
            setOnClickListener((View.OnClickListener) obj);
        } else if (382 != i) {
            return false;
        } else {
            setHorizontalParam((HorizontalParam) obj);
        }
        return true;
    }

    @Override // com.rigol.scope.databinding.AdapterItemPopupviewVerticalBinding
    public void setParam(VerticalParam verticalParam) {
        updateRegistration(3, verticalParam);
        this.mParam = verticalParam;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(594);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterItemPopupviewVerticalBinding
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        notifyPropertyChanged(569);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterItemPopupviewVerticalBinding
    public void setHorizontalParam(HorizontalParam horizontalParam) {
        updateRegistration(5, horizontalParam);
        this.mHorizontalParam = horizontalParam;
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        notifyPropertyChanged(382);
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
                            return onChangeHorizontalParam((HorizontalParam) obj, i2);
                        }
                        return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgChanBwlimitParamBandLimitValue1((MappingObject) obj, i2);
                    }
                    return onChangeParam((VerticalParam) obj, i2);
                }
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgChanCoupParamCouplingValue1((MappingObject) obj, i2);
            }
            return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgChanUnitParamUnitValue1((MappingObject) obj, i2);
        }
        return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgChanProbeParamProbeRatioValue1((MappingObject) obj, i2);
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgChanProbeParamProbeRatioValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
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

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgChanUnitParamUnitValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
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

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgChanCoupParamCouplingValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 512;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeParam(VerticalParam verticalParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        } else if (i == 431) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 193) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
            }
            return true;
        } else if (i == 909) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
            }
            return true;
        } else if (i == 987) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            }
            return true;
        } else if (i == 475) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE;
            }
            return true;
        } else if (i == 828) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 666) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
            }
            return true;
        } else if (i == 662) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
            }
            return true;
        } else if (i == 670) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
            }
            return true;
        } else if (i == 665) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
            }
            return true;
        } else if (i == 667) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
            }
            return true;
        } else if (i == 432) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
            }
            return true;
        } else if (i == 444) {
            synchronized (this) {
                this.mDirtyFlags |= 4194304;
            }
            return true;
        } else if (i == 314) {
            synchronized (this) {
                this.mDirtyFlags |= 8388608;
            }
            return true;
        } else if (i == 774) {
            synchronized (this) {
                this.mDirtyFlags |= 16777216;
            }
            return true;
        } else if (i == 71) {
            synchronized (this) {
                this.mDirtyFlags |= 33554432;
            }
            return true;
        } else if (i == 163) {
            synchronized (this) {
                this.mDirtyFlags |= 67108864;
            }
            return true;
        } else if (i == 646) {
            synchronized (this) {
                this.mDirtyFlags |= 134217728;
            }
            return true;
        } else if (i == 565) {
            synchronized (this) {
                this.mDirtyFlags |= 268435456;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgChanBwlimitParamBandLimitValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 536870912;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeHorizontalParam(HorizontalParam horizontalParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        } else if (i == 935) {
            synchronized (this) {
                this.mDirtyFlags |= 1073741824;
            }
            return true;
        } else {
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:131:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x01d4 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x028d A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:182:0x02ad  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0300  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0315  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0333  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0345 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:211:0x0359  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x0386  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x0399  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x03d4  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x03df  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x03e3  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x03ee  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x03f1  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x0406  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x041a  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x0428 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:262:0x043b A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:267:0x044f  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x0499  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x04d0  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x050d  */
    /* JADX WARN: Removed duplicated region for block: B:284:0x0526  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x053d  */
    /* JADX WARN: Removed duplicated region for block: B:344:0x0608  */
    /* JADX WARN: Removed duplicated region for block: B:348:0x061d  */
    /* JADX WARN: Removed duplicated region for block: B:352:0x0636  */
    /* JADX WARN: Removed duplicated region for block: B:355:0x0642  */
    /* JADX WARN: Removed duplicated region for block: B:359:0x065a  */
    /* JADX WARN: Removed duplicated region for block: B:362:0x066c  */
    /* JADX WARN: Removed duplicated region for block: B:376:0x069a  */
    /* JADX WARN: Removed duplicated region for block: B:379:0x06a7  */
    /* JADX WARN: Removed duplicated region for block: B:383:0x06b3  */
    /* JADX WARN: Removed duplicated region for block: B:386:0x06bc A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:391:0x06c7  */
    /* JADX WARN: Removed duplicated region for block: B:394:0x06ce  */
    /* JADX WARN: Removed duplicated region for block: B:397:0x06da  */
    /* JADX WARN: Removed duplicated region for block: B:401:0x06ea  */
    /* JADX WARN: Removed duplicated region for block: B:404:0x06f9  */
    /* JADX WARN: Removed duplicated region for block: B:405:0x07be  */
    /* JADX WARN: Removed duplicated region for block: B:408:0x07cc  */
    /* JADX WARN: Removed duplicated region for block: B:414:0x08e7  */
    /* JADX WARN: Removed duplicated region for block: B:416:0x08ee  */
    /* JADX WARN: Removed duplicated region for block: B:422:0x0912  */
    /* JADX WARN: Removed duplicated region for block: B:425:0x0923  */
    /* JADX WARN: Removed duplicated region for block: B:428:0x0930  */
    /* JADX WARN: Removed duplicated region for block: B:430:0x0939  */
    /* JADX WARN: Removed duplicated region for block: B:433:0x0948  */
    /* JADX WARN: Removed duplicated region for block: B:436:0x0970  */
    /* JADX WARN: Removed duplicated region for block: B:438:0x0979  */
    /* JADX WARN: Removed duplicated region for block: B:441:0x098c  */
    /* JADX WARN: Removed duplicated region for block: B:444:0x099d  */
    /* JADX WARN: Removed duplicated region for block: B:447:0x09aa  */
    /* JADX WARN: Removed duplicated region for block: B:450:0x09c2  */
    /* JADX WARN: Removed duplicated region for block: B:453:0x09d3  */
    /* JADX WARN: Removed duplicated region for block: B:455:0x09dc  */
    /* JADX WARN: Removed duplicated region for block: B:461:0x09fc  */
    /* JADX WARN: Removed duplicated region for block: B:464:0x0a0d  */
    /* JADX WARN: Removed duplicated region for block: B:467:0x0a1a  */
    /* JADX WARN: Removed duplicated region for block: B:473:0x0a3a  */
    /* JADX WARN: Removed duplicated region for block: B:480:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x014b  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 2629
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rigol.scope.databinding.AdapterItemPopupviewVerticalBindingImpl.executeBindings():void");
    }

    @Override // com.rigol.scope.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int i, View view) {
        switch (i) {
            case 1:
                View.OnClickListener onClickListener = this.mOnClickListener;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                    return;
                }
                return;
            case 2:
                View.OnClickListener onClickListener2 = this.mOnClickListener;
                if (onClickListener2 != null) {
                    onClickListener2.onClick(view);
                    return;
                }
                return;
            case 3:
                View.OnClickListener onClickListener3 = this.mOnClickListener;
                if (onClickListener3 != null) {
                    onClickListener3.onClick(view);
                    return;
                }
                return;
            case 4:
                View.OnClickListener onClickListener4 = this.mOnClickListener;
                if (onClickListener4 != null) {
                    onClickListener4.onClick(view);
                    return;
                }
                return;
            case 5:
                View.OnClickListener onClickListener5 = this.mOnClickListener;
                if (onClickListener5 != null) {
                    onClickListener5.onClick(view);
                    return;
                }
                return;
            case 6:
                View.OnClickListener onClickListener6 = this.mOnClickListener;
                if (onClickListener6 != null) {
                    onClickListener6.onClick(view);
                    return;
                }
                return;
            case 7:
                View.OnClickListener onClickListener7 = this.mOnClickListener;
                if (onClickListener7 != null) {
                    onClickListener7.onClick(view);
                    return;
                }
                return;
            case 8:
                View.OnClickListener onClickListener8 = this.mOnClickListener;
                if (onClickListener8 != null) {
                    onClickListener8.onClick(view);
                    return;
                }
                return;
            case 9:
                View.OnClickListener onClickListener9 = this.mOnClickListener;
                if (onClickListener9 != null) {
                    onClickListener9.onClick(view);
                    return;
                }
                return;
            case 10:
                View.OnClickListener onClickListener10 = this.mOnClickListener;
                if (onClickListener10 != null) {
                    onClickListener10.onClick(view);
                    return;
                }
                return;
            case 11:
                View.OnClickListener onClickListener11 = this.mOnClickListener;
                if (onClickListener11 != null) {
                    onClickListener11.onClick(view);
                    return;
                }
                return;
            case 12:
                View.OnClickListener onClickListener12 = this.mOnClickListener;
                if (onClickListener12 != null) {
                    onClickListener12.onClick(view);
                    return;
                }
                return;
            case 13:
                View.OnClickListener onClickListener13 = this.mOnClickListener;
                if (onClickListener13 != null) {
                    onClickListener13.onClick(view);
                    return;
                }
                return;
            case 14:
                View.OnClickListener onClickListener14 = this.mOnClickListener;
                if (onClickListener14 != null) {
                    onClickListener14.onClick(view);
                    return;
                }
                return;
            case 15:
                View.OnClickListener onClickListener15 = this.mOnClickListener;
                if (onClickListener15 != null) {
                    onClickListener15.onClick(view);
                    return;
                }
                return;
            case 16:
                View.OnClickListener onClickListener16 = this.mOnClickListener;
                if (onClickListener16 != null) {
                    onClickListener16.onClick(view);
                    return;
                }
                return;
            case 17:
                View.OnClickListener onClickListener17 = this.mOnClickListener;
                if (onClickListener17 != null) {
                    onClickListener17.onClick(view);
                    return;
                }
                return;
            case 18:
                View.OnClickListener onClickListener18 = this.mOnClickListener;
                if (onClickListener18 != null) {
                    onClickListener18.onClick(view);
                    return;
                }
                return;
            case 19:
                View.OnClickListener onClickListener19 = this.mOnClickListener;
                if (onClickListener19 != null) {
                    onClickListener19.onClick(view);
                    return;
                }
                return;
            case 20:
                View.OnClickListener onClickListener20 = this.mOnClickListener;
                if (onClickListener20 != null) {
                    onClickListener20.onClick(view);
                    return;
                }
                return;
            case 21:
                View.OnClickListener onClickListener21 = this.mOnClickListener;
                if (onClickListener21 != null) {
                    onClickListener21.onClick(view);
                    return;
                }
                return;
            case 22:
                View.OnClickListener onClickListener22 = this.mOnClickListener;
                if (onClickListener22 != null) {
                    onClickListener22.onClick(view);
                    return;
                }
                return;
            case 23:
                View.OnClickListener onClickListener23 = this.mOnClickListener;
                if (onClickListener23 != null) {
                    onClickListener23.onClick(view);
                    return;
                }
                return;
            case 24:
                View.OnClickListener onClickListener24 = this.mOnClickListener;
                if (onClickListener24 != null) {
                    onClickListener24.onClick(view);
                    return;
                }
                return;
            case 25:
                View.OnClickListener onClickListener25 = this.mOnClickListener;
                if (onClickListener25 != null) {
                    onClickListener25.onClick(view);
                    return;
                }
                return;
            case 26:
                View.OnClickListener onClickListener26 = this.mOnClickListener;
                if (onClickListener26 != null) {
                    onClickListener26.onClick(view);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
