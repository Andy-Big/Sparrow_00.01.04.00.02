package com.rigol.scope.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableInt;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.rigol.scope.R;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.WindowParam;
import com.rigol.scope.generated.callback.OnClickListener;
/* loaded from: classes2.dex */
public class PopupviewMultiWindowBindingImpl extends PopupviewMultiWindowBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback51;
    private final View.OnClickListener mCallback52;
    private final View.OnClickListener mCallback53;
    private final View.OnClickListener mCallback54;
    private final View.OnClickListener mCallback55;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.type_diagram, 12);
        sViewsWithIds.put(R.id.type_diagram_list, 13);
        sViewsWithIds.put(R.id.type_result_table, 14);
        sViewsWithIds.put(R.id.type_result_table_list, 15);
        sViewsWithIds.put(R.id.dividing_line, 16);
    }

    public PopupviewMultiWindowBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 17, sIncludes, sViewsWithIds));
    }

    private PopupviewMultiWindowBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 13, (View) objArr[16], (TextView) objArr[4], (TextView) objArr[3], (TextView) objArr[6], (TextView) objArr[5], (TextView) objArr[8], (TextView) objArr[7], (TextView) objArr[10], (TextView) objArr[9], (Button) objArr[11], (ImageView) objArr[1], (ConstraintLayout) objArr[2], (TextView) objArr[12], (RecyclerView) objArr[13], (TextView) objArr[14], (RecyclerView) objArr[15]);
        this.mDirtyFlags = -1L;
        this.holder1Spinner.setTag(null);
        this.holder1Title.setTag(null);
        this.holder2Spinner.setTag(null);
        this.holder2Title.setTag(null);
        this.holder3Spinner.setTag(null);
        this.holder3Title.setTag(null);
        this.holder4Spinner.setTag(null);
        this.holder4Title.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.okButton.setTag(null);
        this.pic.setTag(null);
        this.sourceLayout.setTag(null);
        setRootTag(view);
        this.mCallback55 = new OnClickListener(this, 5);
        this.mCallback52 = new OnClickListener(this, 2);
        this.mCallback54 = new OnClickListener(this, 4);
        this.mCallback53 = new OnClickListener(this, 3);
        this.mCallback51 = new OnClickListener(this, 1);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 8388608L;
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
        if (838 == i) {
            setShowSource3((ObservableBoolean) obj);
        } else if (865 == i) {
            setSourceArrayId((ObservableInt) obj);
        } else if (567 == i) {
            setOkButtonEnable((ObservableBoolean) obj);
        } else if (569 == i) {
            setOnClickListener((View.OnClickListener) obj);
        } else if (1077 == i) {
            setWindowParam((WindowParam) obj);
        } else if (979 == i) {
            setTypeArrayId((ObservableInt) obj);
        } else if (842 == i) {
            setShowType((ObservableBoolean) obj);
        } else if (984 == i) {
            setUiEnable((ObservableBoolean) obj);
        } else if (836 == i) {
            setShowSource1((ObservableBoolean) obj);
        } else if (837 != i) {
            return false;
        } else {
            setShowSource2((ObservableBoolean) obj);
        }
        return true;
    }

    @Override // com.rigol.scope.databinding.PopupviewMultiWindowBinding
    public void setShowSource3(ObservableBoolean observableBoolean) {
        updateRegistration(1, observableBoolean);
        this.mShowSource3 = observableBoolean;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(838);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewMultiWindowBinding
    public void setSourceArrayId(ObservableInt observableInt) {
        updateRegistration(2, observableInt);
        this.mSourceArrayId = observableInt;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(865);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewMultiWindowBinding
    public void setOkButtonEnable(ObservableBoolean observableBoolean) {
        updateRegistration(3, observableBoolean);
        this.mOkButtonEnable = observableBoolean;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(567);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewMultiWindowBinding
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
        }
        notifyPropertyChanged(569);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewMultiWindowBinding
    public void setWindowParam(WindowParam windowParam) {
        updateRegistration(6, windowParam);
        this.mWindowParam = windowParam;
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        notifyPropertyChanged(1077);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewMultiWindowBinding
    public void setTypeArrayId(ObservableInt observableInt) {
        updateRegistration(7, observableInt);
        this.mTypeArrayId = observableInt;
        synchronized (this) {
            this.mDirtyFlags |= 128;
        }
        notifyPropertyChanged(979);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewMultiWindowBinding
    public void setShowType(ObservableBoolean observableBoolean) {
        updateRegistration(8, observableBoolean);
        this.mShowType = observableBoolean;
        synchronized (this) {
            this.mDirtyFlags |= 256;
        }
        notifyPropertyChanged(842);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewMultiWindowBinding
    public void setUiEnable(ObservableBoolean observableBoolean) {
        updateRegistration(9, observableBoolean);
        this.mUiEnable = observableBoolean;
        synchronized (this) {
            this.mDirtyFlags |= 512;
        }
        notifyPropertyChanged(984);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewMultiWindowBinding
    public void setShowSource1(ObservableBoolean observableBoolean) {
        updateRegistration(10, observableBoolean);
        this.mShowSource1 = observableBoolean;
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
        }
        notifyPropertyChanged(836);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewMultiWindowBinding
    public void setShowSource2(ObservableBoolean observableBoolean) {
        updateRegistration(12, observableBoolean);
        this.mShowSource2 = observableBoolean;
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
        }
        notifyPropertyChanged(837);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return onChangeViewUtilGetMappingObjectSourceArrayIdWindowParamSource1Value1((MappingObject) obj, i2);
            case 1:
                return onChangeShowSource3((ObservableBoolean) obj, i2);
            case 2:
                return onChangeSourceArrayId((ObservableInt) obj, i2);
            case 3:
                return onChangeOkButtonEnable((ObservableBoolean) obj, i2);
            case 4:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgChanList2WindowParamSource3Value1((MappingObject) obj, i2);
            case 5:
                return onChangeViewUtilGetMappingObjectTypeArrayIdWindowParamServiceID((MappingObject) obj, i2);
            case 6:
                return onChangeWindowParam((WindowParam) obj, i2);
            case 7:
                return onChangeTypeArrayId((ObservableInt) obj, i2);
            case 8:
                return onChangeShowType((ObservableBoolean) obj, i2);
            case 9:
                return onChangeUiEnable((ObservableBoolean) obj, i2);
            case 10:
                return onChangeShowSource1((ObservableBoolean) obj, i2);
            case 11:
                return onChangeViewUtilGetMappingObjectSourceArrayIdWindowParamSource2Value1((MappingObject) obj, i2);
            case 12:
                return onChangeShowSource2((ObservableBoolean) obj, i2);
            default:
                return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectSourceArrayIdWindowParamSource1Value1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeShowSource3(ObservableBoolean observableBoolean, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeSourceArrayId(ObservableInt observableInt, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeOkButtonEnable(ObservableBoolean observableBoolean, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgChanList2WindowParamSource3Value1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
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

    private boolean onChangeViewUtilGetMappingObjectTypeArrayIdWindowParamServiceID(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
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

    private boolean onChangeWindowParam(WindowParam windowParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        } else if (i == 978) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
            }
            return true;
        } else if (i == 810) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
            }
            return true;
        } else if (i == 859) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
            }
            return true;
        } else if (i == 860) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
            }
            return true;
        } else if (i == 861) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeTypeArrayId(ObservableInt observableInt, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeShowType(ObservableBoolean observableBoolean, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 256;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeUiEnable(ObservableBoolean observableBoolean, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 512;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeShowSource1(ObservableBoolean observableBoolean, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewUtilGetMappingObjectSourceArrayIdWindowParamSource2Value1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
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

    private boolean onChangeShowSource2(ObservableBoolean observableBoolean, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x029e  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x02c2  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x02e3  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x02f1  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0326  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0354  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0364  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x038b  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x03b3  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x03bc  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x03c5 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:211:0x03d8  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x03f9  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x0417  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x0420  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x0430  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x0439  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x044b  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x0473  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x0479  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x0486  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x04a2  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x04b2  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x04fe  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x050d  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x051a  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x052a  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x0539  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x0546  */
    /* JADX WARN: Removed duplicated region for block: B:283:0x0558  */
    /* JADX WARN: Removed duplicated region for block: B:286:0x0565  */
    /* JADX WARN: Removed duplicated region for block: B:289:0x0574  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x0582  */
    /* JADX WARN: Removed duplicated region for block: B:297:0x059e  */
    /* JADX WARN: Removed duplicated region for block: B:304:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01c7  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 1456
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rigol.scope.databinding.PopupviewMultiWindowBindingImpl.executeBindings():void");
    }

    @Override // com.rigol.scope.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int i, View view) {
        if (i == 1) {
            View.OnClickListener onClickListener = this.mOnClickListener;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        } else if (i == 2) {
            View.OnClickListener onClickListener2 = this.mOnClickListener;
            if (onClickListener2 != null) {
                onClickListener2.onClick(view);
            }
        } else if (i == 3) {
            View.OnClickListener onClickListener3 = this.mOnClickListener;
            if (onClickListener3 != null) {
                onClickListener3.onClick(view);
            }
        } else if (i == 4) {
            View.OnClickListener onClickListener4 = this.mOnClickListener;
            if (onClickListener4 != null) {
                onClickListener4.onClick(view);
            }
        } else if (i != 5) {
        } else {
            View.OnClickListener onClickListener5 = this.mOnClickListener;
            if (onClickListener5 != null) {
                onClickListener5.onClick(view);
            }
        }
    }
}
