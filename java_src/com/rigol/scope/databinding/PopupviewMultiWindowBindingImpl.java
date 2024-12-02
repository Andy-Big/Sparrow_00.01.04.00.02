package com.rigol.scope.databinding;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
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
import androidx.databinding.adapters.ImageViewBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.rigol.scope.R;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.WindowParam;
import com.rigol.scope.generated.callback.OnClickListener;
import com.rigol.scope.utilities.ColorUtil;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.ViewUtil;

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
    */
    protected void executeBindings() {
        long j;
        int i;
        int i2;
        String str;
        ServiceEnum.WindowType windowType;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        Drawable drawable;
        int i3;
        int i4;
        int i5;
        boolean z;
        int i6;
        int i7;
        int i8;
        int i9;
        boolean z2;
        int i10;
        int i11;
        int i12;
        long j2;
        String str7;
        float f;
        boolean z3;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        boolean z4;
        String str8;
        int i18;
        int i19;
        int i20;
        float f2;
        boolean z5;
        int i21;
        int i22;
        boolean z6;
        long j3;
        String str9;
        int i23;
        int i24;
        int i25;
        Drawable drawable2;
        ServiceEnum.WindowType windowType2;
        boolean z7;
        int i26;
        Drawable drawable3;
        String str10;
        String str11;
        String str12;
        int i27;
        int i28;
        String str13;
        String str14;
        long j4;
        String str15;
        int i29;
        ServiceEnum.Chan chan;
        int i30;
        int i31;
        long j5;
        String string;
        Resources resources;
        int i32;
        long j6;
        long j7;
        String str16;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        ObservableBoolean observableBoolean = this.mShowSource3;
        ObservableInt observableInt = this.mSourceArrayId;
        ObservableBoolean observableBoolean2 = this.mOkButtonEnable;
        View.OnClickListener onClickListener = this.mOnClickListener;
        WindowParam windowParam = this.mWindowParam;
        ObservableInt observableInt2 = this.mTypeArrayId;
        ObservableBoolean observableBoolean3 = this.mShowType;
        ObservableBoolean observableBoolean4 = this.mUiEnable;
        ObservableBoolean observableBoolean5 = this.mShowSource1;
        ObservableBoolean observableBoolean6 = this.mShowSource2;
        int i33 = ((j & 8388610) > 0L ? 1 : ((j & 8388610) == 0L ? 0 : -1));
        if (i33 != 0) {
            boolean z8 = observableBoolean != null ? observableBoolean.get() : false;
            if (i33 != 0) {
                j |= z8 ? 8796093022208L : 4398046511104L;
            }
            if (!z8) {
                i = 8;
                int i34 = ((14174277 & j) != 0 || observableInt == null) ? 0 : observableInt.get();
                String str17 = null;
                if ((16697429 & j) == 0) {
                    if ((j & 10518608) != 0) {
                        ServiceEnum.Chan source3 = windowParam != null ? windowParam.getSource3() : null;
                        int i35 = source3 != null ? source3.value1 : 0;
                        MappingObject mappingObject = ViewUtil.getMappingObject(R.array.msg_chan_list2, i35);
                        updateRegistration(4, mappingObject);
                        str9 = mappingObject != null ? mappingObject.getStr() : null;
                        j3 = 0;
                        if ((j & 10485824) != 0) {
                            i23 = ColorUtil.getColor(getRoot().getContext(), ServiceEnum.getChanFromValue1(i35));
                            i24 = ((j & 8519744) > j3 ? 1 : ((j & 8519744) == j3 ? 0 : -1));
                            if (i24 == 0) {
                                windowType2 = windowParam != null ? windowParam.getType() : null;
                                str5 = str9;
                                if (windowType2 != null) {
                                    str16 = windowType2.pic2;
                                    i25 = i23;
                                } else {
                                    i25 = i23;
                                    str16 = null;
                                }
                                z7 = windowType2 == ServiceEnum.WindowType.WIN_MEASURE;
                                if (i24 != 0) {
                                    j = z7 ? j | 134217728 : j | 67108864;
                                }
                                drawable2 = ContextUtil.getDrawable(getRoot().getContext(), str16);
                            } else {
                                str5 = str9;
                                i25 = i23;
                                drawable2 = null;
                                windowType2 = null;
                                z7 = false;
                            }
                            i26 = ((j & 8650816) > 0L ? 1 : ((j & 8650816) == 0L ? 0 : -1));
                            if (i26 == 0) {
                                if (windowParam != null) {
                                    drawable3 = drawable2;
                                    i31 = windowParam.getServiceID();
                                } else {
                                    drawable3 = drawable2;
                                    i31 = 0;
                                }
                                z = z7;
                                i28 = ColorUtil.getColor(getRoot().getContext(), i31);
                                boolean z9 = i31 == 56;
                                if (i26 != 0) {
                                    if (z9) {
                                        j6 = j | 536870912 | 2147483648L;
                                        j7 = 8589934592L;
                                    } else {
                                        j6 = j | 268435456 | 1073741824;
                                        j7 = 4294967296L;
                                    }
                                    j = j6 | j7;
                                }
                                if (z9) {
                                    j5 = j;
                                    string = this.holder3Title.getResources().getString(R.string.msg_xy_srcy);
                                } else {
                                    j5 = j;
                                    string = this.holder3Title.getResources().getString(R.string.msg_app_meas_srcb);
                                }
                                String string2 = this.holder4Title.getResources().getString(z9 ? R.string.msg_xy_srcz : R.string.msg_app_meas_srcc);
                                if (z9) {
                                    resources = this.holder2Title.getResources();
                                    i32 = R.string.msg_xy_srcx;
                                } else {
                                    resources = this.holder2Title.getResources();
                                    i32 = R.string.msg_app_meas_srca;
                                }
                                String string3 = resources.getString(i32);
                                i27 = i31;
                                str10 = string;
                                str11 = string2;
                                j = j5;
                                str12 = string3;
                            } else {
                                drawable3 = drawable2;
                                z = z7;
                                str10 = null;
                                str11 = null;
                                str12 = null;
                                i27 = 0;
                                i28 = 0;
                            }
                            if ((j & 8929349) == 0) {
                                if (windowParam != null) {
                                    str13 = str10;
                                    chan = windowParam.getSource1();
                                } else {
                                    str13 = str10;
                                    chan = null;
                                }
                                if (chan != null) {
                                    i30 = chan.value1;
                                    str14 = str11;
                                } else {
                                    str14 = str11;
                                    i30 = 0;
                                }
                                MappingObject mappingObject2 = ViewUtil.getMappingObject(i34, i30);
                                i6 = i27;
                                updateRegistration(0, mappingObject2);
                                str15 = mappingObject2 != null ? mappingObject2.getStr() : null;
                                j4 = 0;
                                if ((j & 8912960) != 0) {
                                    i29 = ColorUtil.getColor(getRoot().getContext(), ServiceEnum.getChanFromValue1(i30));
                                    if ((j & 13633604) != j4) {
                                        ServiceEnum.Chan source2 = windowParam != null ? windowParam.getSource2() : null;
                                        int i36 = source2 != null ? source2.value1 : 0;
                                        long j8 = j;
                                        int color = (j & 9437248) != 0 ? ColorUtil.getColor(getRoot().getContext(), ServiceEnum.getChanFromValue1(i36)) : 0;
                                        MappingObject mappingObject3 = ViewUtil.getMappingObject(i34, i36);
                                        updateRegistration(11, mappingObject3);
                                        if (mappingObject3 != null) {
                                            i2 = i;
                                            i7 = i25;
                                            drawable = drawable3;
                                            str3 = str12;
                                            str2 = str13;
                                            str = str14;
                                            i4 = color;
                                            str6 = mappingObject3.getStr();
                                        } else {
                                            i2 = i;
                                            i7 = i25;
                                            drawable = drawable3;
                                            str3 = str12;
                                            str2 = str13;
                                            str = str14;
                                            i4 = color;
                                            str6 = null;
                                        }
                                        j = j8;
                                    } else {
                                        i2 = i;
                                        i7 = i25;
                                        drawable = drawable3;
                                        str3 = str12;
                                        str2 = str13;
                                        str = str14;
                                        i4 = 0;
                                        str6 = null;
                                    }
                                    int i37 = i28;
                                    i5 = i29;
                                    windowType = windowType2;
                                    str4 = str15;
                                    i3 = i37;
                                }
                            } else {
                                str13 = str10;
                                str14 = str11;
                                i6 = i27;
                                j4 = 0;
                                str15 = null;
                            }
                            i29 = 0;
                            if ((j & 13633604) != j4) {
                            }
                            int i372 = i28;
                            i5 = i29;
                            windowType = windowType2;
                            str4 = str15;
                            i3 = i372;
                        }
                    } else {
                        j3 = 0;
                        str9 = null;
                    }
                    i23 = 0;
                    i24 = ((j & 8519744) > j3 ? 1 : ((j & 8519744) == j3 ? 0 : -1));
                    if (i24 == 0) {
                    }
                    i26 = ((j & 8650816) > 0L ? 1 : ((j & 8650816) == 0L ? 0 : -1));
                    if (i26 == 0) {
                    }
                    if ((j & 8929349) == 0) {
                    }
                    i29 = 0;
                    if ((j & 13633604) != j4) {
                    }
                    int i3722 = i28;
                    i5 = i29;
                    windowType = windowType2;
                    str4 = str15;
                    i3 = i3722;
                } else {
                    i2 = i;
                    str = null;
                    windowType = null;
                    str2 = null;
                    str3 = null;
                    str4 = null;
                    str5 = null;
                    str6 = null;
                    drawable = null;
                    i3 = 0;
                    i4 = 0;
                    i5 = 0;
                    z = false;
                    i6 = 0;
                    i7 = 0;
                }
                i8 = ((j & 8716512) > 0L ? 1 : ((j & 8716512) == 0L ? 0 : -1));
                if (i8 == 0) {
                    i9 = observableInt2 != null ? observableInt2.get() : 0;
                    z2 = i9 != 0;
                    if (i8 != 0) {
                        j |= z2 ? 35184372088832L : 17592186044416L;
                    }
                } else {
                    i9 = 0;
                    z2 = false;
                }
                i10 = ((j & 8388864) > 0L ? 1 : ((j & 8388864) == 0L ? 0 : -1));
                if (i10 != 0) {
                    boolean z10 = observableBoolean3 != null ? observableBoolean3.get() : false;
                    if (i10 != 0) {
                        j |= z10 ? 137438953472L : 68719476736L;
                    }
                    if (!z10) {
                        i11 = 8;
                        i12 = ((j & 8389128) > 0L ? 1 : ((j & 8389128) == 0L ? 0 : -1));
                        if (i12 != 0) {
                            z3 = observableBoolean4 != null ? observableBoolean4.get() : false;
                            if (i12 != 0) {
                                j = z3 ? j | 549755813888L : j | 274877906944L;
                            }
                            j2 = 0;
                            if ((j & 8389120) != 0) {
                                str7 = str4;
                                f = ContextUtil.getAlpha(z3);
                            } else {
                                str7 = str4;
                                f = 0.0f;
                            }
                        } else {
                            j2 = 0;
                            str7 = str4;
                            f = 0.0f;
                            z3 = false;
                        }
                        i13 = ((j & 8389632) > j2 ? 1 : ((j & 8389632) == j2 ? 0 : -1));
                        if (i13 != 0) {
                            boolean z11 = observableBoolean5 != null ? observableBoolean5.get() : false;
                            if (i13 != 0) {
                                j |= z11 ? 33554432L : 16777216L;
                            }
                            if (!z11) {
                                i14 = 8;
                                i15 = ((j & 8392704) > 0L ? 1 : ((j & 8392704) == 0L ? 0 : -1));
                                if (i15 != 0) {
                                    boolean z12 = observableBoolean6 != null ? observableBoolean6.get() : false;
                                    if (i15 != 0) {
                                        j |= z12 ? 34359738368L : 17179869184L;
                                    }
                                    if (!z12) {
                                        i16 = 8;
                                        if ((j & 67108864) != 0) {
                                            i17 = i16;
                                            if (windowType == ServiceEnum.WindowType.WIN_MAIN_WAVEFORM) {
                                                z4 = true;
                                                boolean z13 = ((j & 549755813888L) != 0 || observableBoolean2 == null) ? false : observableBoolean2.get();
                                                if ((j & 35184372088832L) != 0) {
                                                    if (windowParam != null) {
                                                        i6 = windowParam.getServiceID();
                                                    }
                                                    MappingObject mappingObject4 = ViewUtil.getMappingObject(i9, i6);
                                                    updateRegistration(5, mappingObject4);
                                                    if (mappingObject4 != null) {
                                                        str8 = mappingObject4.getStr();
                                                        i18 = ((j & 8519744) > 0L ? 1 : ((j & 8519744) == 0L ? 0 : -1));
                                                        if (i18 != 0) {
                                                            boolean z14 = z ? true : z4;
                                                            if (i18 != 0) {
                                                                j |= z14 ? 2199023255552L : 1099511627776L;
                                                            }
                                                            i19 = z14 ? 8 : 0;
                                                        } else {
                                                            i19 = 0;
                                                        }
                                                        i20 = ((j & 8389128) > 0L ? 1 : ((j & 8389128) == 0L ? 0 : -1));
                                                        if (i20 != 0) {
                                                            boolean z15 = z3 ? z13 : false;
                                                            z5 = z15;
                                                            f2 = ContextUtil.getAlpha(z15);
                                                        } else {
                                                            f2 = 0.0f;
                                                            z5 = false;
                                                        }
                                                        i21 = ((j & 8716512) > 0L ? 1 : ((j & 8716512) == 0L ? 0 : -1));
                                                        if (i21 != 0) {
                                                            if (!z2) {
                                                                str8 = "";
                                                            }
                                                            str17 = str8;
                                                        }
                                                        String str18 = str17;
                                                        if ((j & 8388608) != 0) {
                                                            i22 = i19;
                                                            z6 = z5;
                                                            this.holder1Spinner.setOnClickListener(this.mCallback51);
                                                            this.holder2Spinner.setOnClickListener(this.mCallback52);
                                                            this.holder3Spinner.setOnClickListener(this.mCallback53);
                                                            this.holder4Spinner.setOnClickListener(this.mCallback54);
                                                            this.okButton.setOnClickListener(this.mCallback55);
                                                        } else {
                                                            i22 = i19;
                                                            z6 = z5;
                                                        }
                                                        if (i21 != 0) {
                                                            TextViewBindingAdapter.setText(this.holder1Spinner, str18);
                                                        }
                                                        if ((j & 8650816) != 0) {
                                                            this.holder1Spinner.setTextColor(i3);
                                                            TextViewBindingAdapter.setText(this.holder2Title, str3);
                                                            TextViewBindingAdapter.setText(this.holder3Title, str2);
                                                            TextViewBindingAdapter.setText(this.holder4Title, str);
                                                        }
                                                        if ((j & 8388864) != 0) {
                                                            this.holder1Spinner.setVisibility(i11);
                                                            this.holder1Title.setVisibility(i11);
                                                        }
                                                        if ((j & 8389120) != 0) {
                                                            if (getBuildSdkInt() >= 11) {
                                                                this.holder2Spinner.setAlpha(f);
                                                                this.holder2Title.setAlpha(f);
                                                                this.holder3Spinner.setAlpha(f);
                                                                this.holder3Title.setAlpha(f);
                                                                this.holder4Spinner.setAlpha(f);
                                                                this.holder4Title.setAlpha(f);
                                                            }
                                                            this.holder2Spinner.setEnabled(z3);
                                                            this.holder2Title.setEnabled(z3);
                                                            this.holder3Spinner.setEnabled(z3);
                                                            this.holder3Title.setEnabled(z3);
                                                            this.holder4Spinner.setEnabled(z3);
                                                            this.holder4Title.setEnabled(z3);
                                                        }
                                                        if ((j & 8929349) != 0) {
                                                            TextViewBindingAdapter.setText(this.holder2Spinner, str7);
                                                        }
                                                        if ((8912960 & j) != 0) {
                                                            this.holder2Spinner.setTextColor(i5);
                                                        }
                                                        if ((j & 8389632) != 0) {
                                                            this.holder2Spinner.setVisibility(i14);
                                                            this.holder2Title.setVisibility(i14);
                                                        }
                                                        if ((j & 13633604) != 0) {
                                                            TextViewBindingAdapter.setText(this.holder3Spinner, str6);
                                                        }
                                                        if ((9437248 & j) != 0) {
                                                            this.holder3Spinner.setTextColor(i4);
                                                        }
                                                        if ((j & 8392704) != 0) {
                                                            int i38 = i17;
                                                            this.holder3Spinner.setVisibility(i38);
                                                            this.holder3Title.setVisibility(i38);
                                                        }
                                                        if ((j & 10518608) != 0) {
                                                            TextViewBindingAdapter.setText(this.holder4Spinner, str5);
                                                        }
                                                        if ((j & 10485824) != 0) {
                                                            this.holder4Spinner.setTextColor(i7);
                                                        }
                                                        if ((8388610 & j) != 0) {
                                                            int i39 = i2;
                                                            this.holder4Spinner.setVisibility(i39);
                                                            this.holder4Title.setVisibility(i39);
                                                        }
                                                        if (i20 != 0) {
                                                            if (getBuildSdkInt() >= 11) {
                                                                this.okButton.setAlpha(f2);
                                                            }
                                                            this.okButton.setEnabled(z6);
                                                        }
                                                        if ((j & 8519744) != 0) {
                                                            ImageViewBindingAdapter.setImageDrawable(this.pic, drawable);
                                                            this.sourceLayout.setVisibility(i22);
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                }
                                                str8 = null;
                                                i18 = ((j & 8519744) > 0L ? 1 : ((j & 8519744) == 0L ? 0 : -1));
                                                if (i18 != 0) {
                                                }
                                                i20 = ((j & 8389128) > 0L ? 1 : ((j & 8389128) == 0L ? 0 : -1));
                                                if (i20 != 0) {
                                                }
                                                i21 = ((j & 8716512) > 0L ? 1 : ((j & 8716512) == 0L ? 0 : -1));
                                                if (i21 != 0) {
                                                }
                                                String str182 = str17;
                                                if ((j & 8388608) != 0) {
                                                }
                                                if (i21 != 0) {
                                                }
                                                if ((j & 8650816) != 0) {
                                                }
                                                if ((j & 8388864) != 0) {
                                                }
                                                if ((j & 8389120) != 0) {
                                                }
                                                if ((j & 8929349) != 0) {
                                                }
                                                if ((8912960 & j) != 0) {
                                                }
                                                if ((j & 8389632) != 0) {
                                                }
                                                if ((j & 13633604) != 0) {
                                                }
                                                if ((9437248 & j) != 0) {
                                                }
                                                if ((j & 8392704) != 0) {
                                                }
                                                if ((j & 10518608) != 0) {
                                                }
                                                if ((j & 10485824) != 0) {
                                                }
                                                if ((8388610 & j) != 0) {
                                                }
                                                if (i20 != 0) {
                                                }
                                                if ((j & 8519744) != 0) {
                                                }
                                            }
                                        } else {
                                            i17 = i16;
                                        }
                                        z4 = false;
                                        if ((j & 549755813888L) != 0) {
                                        }
                                        if ((j & 35184372088832L) != 0) {
                                        }
                                        str8 = null;
                                        i18 = ((j & 8519744) > 0L ? 1 : ((j & 8519744) == 0L ? 0 : -1));
                                        if (i18 != 0) {
                                        }
                                        i20 = ((j & 8389128) > 0L ? 1 : ((j & 8389128) == 0L ? 0 : -1));
                                        if (i20 != 0) {
                                        }
                                        i21 = ((j & 8716512) > 0L ? 1 : ((j & 8716512) == 0L ? 0 : -1));
                                        if (i21 != 0) {
                                        }
                                        String str1822 = str17;
                                        if ((j & 8388608) != 0) {
                                        }
                                        if (i21 != 0) {
                                        }
                                        if ((j & 8650816) != 0) {
                                        }
                                        if ((j & 8388864) != 0) {
                                        }
                                        if ((j & 8389120) != 0) {
                                        }
                                        if ((j & 8929349) != 0) {
                                        }
                                        if ((8912960 & j) != 0) {
                                        }
                                        if ((j & 8389632) != 0) {
                                        }
                                        if ((j & 13633604) != 0) {
                                        }
                                        if ((9437248 & j) != 0) {
                                        }
                                        if ((j & 8392704) != 0) {
                                        }
                                        if ((j & 10518608) != 0) {
                                        }
                                        if ((j & 10485824) != 0) {
                                        }
                                        if ((8388610 & j) != 0) {
                                        }
                                        if (i20 != 0) {
                                        }
                                        if ((j & 8519744) != 0) {
                                        }
                                    }
                                }
                                i16 = 0;
                                if ((j & 67108864) != 0) {
                                }
                                z4 = false;
                                if ((j & 549755813888L) != 0) {
                                }
                                if ((j & 35184372088832L) != 0) {
                                }
                                str8 = null;
                                i18 = ((j & 8519744) > 0L ? 1 : ((j & 8519744) == 0L ? 0 : -1));
                                if (i18 != 0) {
                                }
                                i20 = ((j & 8389128) > 0L ? 1 : ((j & 8389128) == 0L ? 0 : -1));
                                if (i20 != 0) {
                                }
                                i21 = ((j & 8716512) > 0L ? 1 : ((j & 8716512) == 0L ? 0 : -1));
                                if (i21 != 0) {
                                }
                                String str18222 = str17;
                                if ((j & 8388608) != 0) {
                                }
                                if (i21 != 0) {
                                }
                                if ((j & 8650816) != 0) {
                                }
                                if ((j & 8388864) != 0) {
                                }
                                if ((j & 8389120) != 0) {
                                }
                                if ((j & 8929349) != 0) {
                                }
                                if ((8912960 & j) != 0) {
                                }
                                if ((j & 8389632) != 0) {
                                }
                                if ((j & 13633604) != 0) {
                                }
                                if ((9437248 & j) != 0) {
                                }
                                if ((j & 8392704) != 0) {
                                }
                                if ((j & 10518608) != 0) {
                                }
                                if ((j & 10485824) != 0) {
                                }
                                if ((8388610 & j) != 0) {
                                }
                                if (i20 != 0) {
                                }
                                if ((j & 8519744) != 0) {
                                }
                            }
                        }
                        i14 = 0;
                        i15 = ((j & 8392704) > 0L ? 1 : ((j & 8392704) == 0L ? 0 : -1));
                        if (i15 != 0) {
                        }
                        i16 = 0;
                        if ((j & 67108864) != 0) {
                        }
                        z4 = false;
                        if ((j & 549755813888L) != 0) {
                        }
                        if ((j & 35184372088832L) != 0) {
                        }
                        str8 = null;
                        i18 = ((j & 8519744) > 0L ? 1 : ((j & 8519744) == 0L ? 0 : -1));
                        if (i18 != 0) {
                        }
                        i20 = ((j & 8389128) > 0L ? 1 : ((j & 8389128) == 0L ? 0 : -1));
                        if (i20 != 0) {
                        }
                        i21 = ((j & 8716512) > 0L ? 1 : ((j & 8716512) == 0L ? 0 : -1));
                        if (i21 != 0) {
                        }
                        String str182222 = str17;
                        if ((j & 8388608) != 0) {
                        }
                        if (i21 != 0) {
                        }
                        if ((j & 8650816) != 0) {
                        }
                        if ((j & 8388864) != 0) {
                        }
                        if ((j & 8389120) != 0) {
                        }
                        if ((j & 8929349) != 0) {
                        }
                        if ((8912960 & j) != 0) {
                        }
                        if ((j & 8389632) != 0) {
                        }
                        if ((j & 13633604) != 0) {
                        }
                        if ((9437248 & j) != 0) {
                        }
                        if ((j & 8392704) != 0) {
                        }
                        if ((j & 10518608) != 0) {
                        }
                        if ((j & 10485824) != 0) {
                        }
                        if ((8388610 & j) != 0) {
                        }
                        if (i20 != 0) {
                        }
                        if ((j & 8519744) != 0) {
                        }
                    }
                }
                i11 = 0;
                i12 = ((j & 8389128) > 0L ? 1 : ((j & 8389128) == 0L ? 0 : -1));
                if (i12 != 0) {
                }
                i13 = ((j & 8389632) > j2 ? 1 : ((j & 8389632) == j2 ? 0 : -1));
                if (i13 != 0) {
                }
                i14 = 0;
                i15 = ((j & 8392704) > 0L ? 1 : ((j & 8392704) == 0L ? 0 : -1));
                if (i15 != 0) {
                }
                i16 = 0;
                if ((j & 67108864) != 0) {
                }
                z4 = false;
                if ((j & 549755813888L) != 0) {
                }
                if ((j & 35184372088832L) != 0) {
                }
                str8 = null;
                i18 = ((j & 8519744) > 0L ? 1 : ((j & 8519744) == 0L ? 0 : -1));
                if (i18 != 0) {
                }
                i20 = ((j & 8389128) > 0L ? 1 : ((j & 8389128) == 0L ? 0 : -1));
                if (i20 != 0) {
                }
                i21 = ((j & 8716512) > 0L ? 1 : ((j & 8716512) == 0L ? 0 : -1));
                if (i21 != 0) {
                }
                String str1822222 = str17;
                if ((j & 8388608) != 0) {
                }
                if (i21 != 0) {
                }
                if ((j & 8650816) != 0) {
                }
                if ((j & 8388864) != 0) {
                }
                if ((j & 8389120) != 0) {
                }
                if ((j & 8929349) != 0) {
                }
                if ((8912960 & j) != 0) {
                }
                if ((j & 8389632) != 0) {
                }
                if ((j & 13633604) != 0) {
                }
                if ((9437248 & j) != 0) {
                }
                if ((j & 8392704) != 0) {
                }
                if ((j & 10518608) != 0) {
                }
                if ((j & 10485824) != 0) {
                }
                if ((8388610 & j) != 0) {
                }
                if (i20 != 0) {
                }
                if ((j & 8519744) != 0) {
                }
            }
        }
        i = 0;
        if ((14174277 & j) != 0) {
        }
        String str172 = null;
        if ((16697429 & j) == 0) {
        }
        i8 = ((j & 8716512) > 0L ? 1 : ((j & 8716512) == 0L ? 0 : -1));
        if (i8 == 0) {
        }
        i10 = ((j & 8388864) > 0L ? 1 : ((j & 8388864) == 0L ? 0 : -1));
        if (i10 != 0) {
        }
        i11 = 0;
        i12 = ((j & 8389128) > 0L ? 1 : ((j & 8389128) == 0L ? 0 : -1));
        if (i12 != 0) {
        }
        i13 = ((j & 8389632) > j2 ? 1 : ((j & 8389632) == j2 ? 0 : -1));
        if (i13 != 0) {
        }
        i14 = 0;
        i15 = ((j & 8392704) > 0L ? 1 : ((j & 8392704) == 0L ? 0 : -1));
        if (i15 != 0) {
        }
        i16 = 0;
        if ((j & 67108864) != 0) {
        }
        z4 = false;
        if ((j & 549755813888L) != 0) {
        }
        if ((j & 35184372088832L) != 0) {
        }
        str8 = null;
        i18 = ((j & 8519744) > 0L ? 1 : ((j & 8519744) == 0L ? 0 : -1));
        if (i18 != 0) {
        }
        i20 = ((j & 8389128) > 0L ? 1 : ((j & 8389128) == 0L ? 0 : -1));
        if (i20 != 0) {
        }
        i21 = ((j & 8716512) > 0L ? 1 : ((j & 8716512) == 0L ? 0 : -1));
        if (i21 != 0) {
        }
        String str18222222 = str172;
        if ((j & 8388608) != 0) {
        }
        if (i21 != 0) {
        }
        if ((j & 8650816) != 0) {
        }
        if ((j & 8388864) != 0) {
        }
        if ((j & 8389120) != 0) {
        }
        if ((j & 8929349) != 0) {
        }
        if ((8912960 & j) != 0) {
        }
        if ((j & 8389632) != 0) {
        }
        if ((j & 13633604) != 0) {
        }
        if ((9437248 & j) != 0) {
        }
        if ((j & 8392704) != 0) {
        }
        if ((j & 10518608) != 0) {
        }
        if ((j & 10485824) != 0) {
        }
        if ((8388610 & j) != 0) {
        }
        if (i20 != 0) {
        }
        if ((j & 8519744) != 0) {
        }
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
