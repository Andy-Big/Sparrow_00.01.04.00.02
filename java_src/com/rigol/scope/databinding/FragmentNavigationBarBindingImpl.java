package com.rigol.scope.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.rigol.scope.R;
import com.rigol.scope.data.HorizontalParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.TriggerParam;
import com.rigol.scope.generated.callback.OnClickListener;
import com.rigol.scope.utilities.PopupViewManager;
/* loaded from: classes2.dex */
public class FragmentNavigationBarBindingImpl extends FragmentNavigationBarBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback33;
    private final View.OnClickListener mCallback34;
    private final View.OnClickListener mCallback35;
    private final View.OnClickListener mCallback36;
    private final View.OnClickListener mCallback37;
    private final View.OnClickListener mCallback38;
    private final View.OnClickListener mCallback39;
    private final View.OnClickListener mCallback40;
    private long mDirtyFlags;
    private long mDirtyFlags_1;
    private final ConstraintLayout mboundView0;
    private final TextView mboundView5;
    private final TextView mboundView6;
    private final TextView mboundView7;
    private final TextView mboundView8;
    private final TextView mboundView9;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.navigation_bar_layout, 18);
        sViewsWithIds.put(R.id.logo, 19);
        sViewsWithIds.put(R.id.status, 20);
        sViewsWithIds.put(R.id.function_list, 21);
        sViewsWithIds.put(R.id.function_list_left_arrow, 22);
        sViewsWithIds.put(R.id.function_list_right_arrow, 23);
        sViewsWithIds.put(R.id.app_switch_layout, 24);
        sViewsWithIds.put(R.id.app_switch, 25);
    }

    public FragmentNavigationBarBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 26, sIncludes, sViewsWithIds));
    }

    private FragmentNavigationBarBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3, (Button) objArr[3], (ConstraintLayout) objArr[4], (TextView) objArr[14], (TextView) objArr[16], (TextView) objArr[17], (ImageButton) objArr[25], (ConstraintLayout) objArr[24], (RecyclerView) objArr[21], (ImageView) objArr[22], (ImageView) objArr[23], (Button) objArr[10], (TextView) objArr[11], (Button) objArr[1], (TextView) objArr[2], (ImageView) objArr[15], (ImageView) objArr[19], (ConstraintLayout) objArr[18], (TextView) objArr[20], (Button) objArr[12], (ConstraintLayout) objArr[13]);
        this.mDirtyFlags = -1L;
        this.mDirtyFlags_1 = -1L;
        this.acquireBtn.setTag(null);
        this.acquireInfo.setTag(null);
        this.appCompatTextView2.setTag(null);
        this.appCompatTextView3.setTag(null);
        this.appCompatTextView4.setTag(null);
        this.horizontalOffsetBtn.setTag(null);
        this.horizontalOffsetInfo.setTag(null);
        this.horizontalScaleBtn.setTag(null);
        this.horizontalScaleInfo.setTag(null);
        this.imageView2.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView = (TextView) objArr[5];
        this.mboundView5 = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[6];
        this.mboundView6 = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) objArr[7];
        this.mboundView7 = textView3;
        textView3.setTag(null);
        TextView textView4 = (TextView) objArr[8];
        this.mboundView8 = textView4;
        textView4.setTag(null);
        TextView textView5 = (TextView) objArr[9];
        this.mboundView9 = textView5;
        textView5.setTag(null);
        this.triggerBtn.setTag(null);
        this.triggerInfo.setTag(null);
        setRootTag(view);
        this.mCallback39 = new OnClickListener(this, 7);
        this.mCallback37 = new OnClickListener(this, 5);
        this.mCallback40 = new OnClickListener(this, 8);
        this.mCallback38 = new OnClickListener(this, 6);
        this.mCallback35 = new OnClickListener(this, 3);
        this.mCallback36 = new OnClickListener(this, 4);
        this.mCallback33 = new OnClickListener(this, 1);
        this.mCallback34 = new OnClickListener(this, 2);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 2251799813685248L;
            this.mDirtyFlags_1 = 0L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.mDirtyFlags == 0 && this.mDirtyFlags_1 == 0) {
                return false;
            }
            return true;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (946 == i) {
            setTriggerParam((TriggerParam) obj);
        } else if (382 != i) {
            return false;
        } else {
            setHorizontalParam((HorizontalParam) obj);
        }
        return true;
    }

    @Override // com.rigol.scope.databinding.FragmentNavigationBarBinding
    public void setTriggerParam(TriggerParam triggerParam) {
        updateRegistration(1, triggerParam);
        this.mTriggerParam = triggerParam;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(946);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.FragmentNavigationBarBinding
    public void setHorizontalParam(HorizontalParam horizontalParam) {
        updateRegistration(2, horizontalParam);
        this.mHorizontalParam = horizontalParam;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(382);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    return false;
                }
                return onChangeHorizontalParam((HorizontalParam) obj, i2);
            }
            return onChangeTriggerParam((TriggerParam) obj, i2);
        }
        return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgAcqModeHorizontalParamAcquireModeValue1((MappingObject) obj, i2);
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgAcqModeHorizontalParamAcquireModeValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i == 638) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeTriggerParam(TriggerParam triggerParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        } else if (i == 152) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        } else if (i == 945) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        } else if (i == 1030) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        } else if (i == 762) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
            }
            return true;
        } else if (i == 769) {
            synchronized (this) {
                this.mDirtyFlags |= 256;
            }
            return true;
        } else if (i == 266) {
            synchronized (this) {
                this.mDirtyFlags |= 512;
            }
            return true;
        } else if (i == 846) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 938) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
            }
            return true;
        } else if (i == 579) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
            }
            return true;
        } else if (i == 578) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            }
            return true;
        } else if (i == 819) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE;
            }
            return true;
        } else if (i == 562) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 642) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
            }
            return true;
        } else if (i == 267) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
            }
            return true;
        } else if (i == 268) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
            }
            return true;
        } else if (i == 987) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
            }
            return true;
        } else if (i == 484) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
            }
            return true;
        } else if (i == 853) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
            }
            return true;
        } else if (i == 854) {
            synchronized (this) {
                this.mDirtyFlags |= 4194304;
            }
            return true;
        } else if (i == 765) {
            synchronized (this) {
                this.mDirtyFlags |= 8388608;
            }
            return true;
        } else if (i == 766) {
            synchronized (this) {
                this.mDirtyFlags |= 16777216;
            }
            return true;
        } else if (i == 582) {
            synchronized (this) {
                this.mDirtyFlags |= 33554432;
            }
            return true;
        } else if (i == 583) {
            synchronized (this) {
                this.mDirtyFlags |= 67108864;
            }
            return true;
        } else if (i == 539) {
            synchronized (this) {
                this.mDirtyFlags |= 134217728;
            }
            return true;
        } else if (i == 540) {
            synchronized (this) {
                this.mDirtyFlags |= 268435456;
            }
            return true;
        } else if (i == 233) {
            synchronized (this) {
                this.mDirtyFlags |= 536870912;
            }
            return true;
        } else if (i == 234) {
            synchronized (this) {
                this.mDirtyFlags |= 1073741824;
            }
            return true;
        } else if (i == 820) {
            synchronized (this) {
                this.mDirtyFlags |= 2147483648L;
            }
            return true;
        } else if (i == 821) {
            synchronized (this) {
                this.mDirtyFlags |= 4294967296L;
            }
            return true;
        } else if (i == 415) {
            synchronized (this) {
                this.mDirtyFlags |= 8589934592L;
            }
            return true;
        } else if (i == 416) {
            synchronized (this) {
                this.mDirtyFlags |= 17179869184L;
            }
            return true;
        } else if (i == 893) {
            synchronized (this) {
                this.mDirtyFlags |= 34359738368L;
            }
            return true;
        } else if (i == 894) {
            synchronized (this) {
                this.mDirtyFlags |= 68719476736L;
            }
            return true;
        } else if (i == 895) {
            synchronized (this) {
                this.mDirtyFlags |= 137438953472L;
            }
            return true;
        } else if (i == 424) {
            synchronized (this) {
                this.mDirtyFlags |= 274877906944L;
            }
            return true;
        } else if (i == 425) {
            synchronized (this) {
                this.mDirtyFlags |= 549755813888L;
            }
            return true;
        } else if (i == 426) {
            synchronized (this) {
                this.mDirtyFlags |= 1099511627776L;
            }
            return true;
        } else if (i == 554) {
            synchronized (this) {
                this.mDirtyFlags |= 2199023255552L;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeHorizontalParam(HorizontalParam horizontalParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else if (i == 516) {
            synchronized (this) {
                this.mDirtyFlags |= 4398046511104L;
            }
            return true;
        } else if (i == 770) {
            synchronized (this) {
                this.mDirtyFlags |= 8796093022208L;
            }
            return true;
        } else if (i == 772) {
            synchronized (this) {
                this.mDirtyFlags |= 17592186044416L;
            }
            return true;
        } else if (i == 28) {
            synchronized (this) {
                this.mDirtyFlags |= 35184372088832L;
            }
            return true;
        } else if (i == 239) {
            synchronized (this) {
                this.mDirtyFlags |= 70368744177664L;
            }
            return true;
        } else if (i == 246) {
            synchronized (this) {
                this.mDirtyFlags |= 140737488355328L;
            }
            return true;
        } else if (i == 935) {
            synchronized (this) {
                this.mDirtyFlags |= 281474976710656L;
            }
            return true;
        } else if (i == 760) {
            synchronized (this) {
                this.mDirtyFlags |= 562949953421312L;
            }
            return true;
        } else if (i == 515) {
            synchronized (this) {
                this.mDirtyFlags |= 1125899906842624L;
            }
            return true;
        } else {
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:131:0x033f  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0369  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0380  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x03b9  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x040c  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0415  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01d7  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 1427
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rigol.scope.databinding.FragmentNavigationBarBindingImpl.executeBindings():void");
    }

    @Override // com.rigol.scope.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int i, View view) {
        switch (i) {
            case 1:
                PopupViewManager.getInstance();
                if (PopupViewManager.getInstance() != null) {
                    PopupViewManager.getInstance().toggle(PopupViewManager.HORIZONTAL_CLASS, view);
                    return;
                }
                return;
            case 2:
                PopupViewManager.getInstance();
                if (PopupViewManager.getInstance() != null) {
                    PopupViewManager.getInstance().toggle(PopupViewManager.HORIZONTAL_CLASS, view);
                    return;
                }
                return;
            case 3:
                PopupViewManager.getInstance();
                if (PopupViewManager.getInstance() != null) {
                    PopupViewManager.getInstance().toggle(PopupViewManager.HORIZONTAL_CLASS, view);
                    return;
                }
                return;
            case 4:
                PopupViewManager.getInstance();
                if (PopupViewManager.getInstance() != null) {
                    PopupViewManager.getInstance().toggle(PopupViewManager.HORIZONTAL_CLASS, view);
                    return;
                }
                return;
            case 5:
                PopupViewManager.getInstance();
                if (PopupViewManager.getInstance() != null) {
                    PopupViewManager.getInstance().toggle(PopupViewManager.HORIZONTAL_CLASS, view);
                    return;
                }
                return;
            case 6:
                PopupViewManager.getInstance();
                if (PopupViewManager.getInstance() != null) {
                    PopupViewManager.getInstance().toggle(PopupViewManager.HORIZONTAL_CLASS, view);
                    return;
                }
                return;
            case 7:
                PopupViewManager.getInstance();
                if (PopupViewManager.getInstance() != null) {
                    PopupViewManager.getInstance().toggle(PopupViewManager.TRIGGER_CLASS, view);
                    return;
                }
                return;
            case 8:
                PopupViewManager.getInstance();
                if (PopupViewManager.getInstance() != null) {
                    PopupViewManager.getInstance().toggle(PopupViewManager.TRIGGER_CLASS, view);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
