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
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.rigol.scope.R;
import com.rigol.scope.data.DiskManageParam;
import com.rigol.scope.data.DiskParam;
import com.rigol.scope.data.SharedParam;
import com.rigol.scope.generated.callback.OnClickListener;
import com.rigol.scope.utilities.ContextUtil;

/* loaded from: classes2.dex */
public class PopupviewDiskManageBindingImpl extends PopupviewDiskManageBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback72;
    private final View.OnClickListener mCallback73;
    private final View.OnClickListener mCallback74;
    private final View.OnClickListener mCallback75;
    private final View.OnClickListener mCallback76;
    private final View.OnClickListener mCallback77;
    private final View.OnClickListener mCallback78;
    private final View.OnClickListener mCallback79;
    private final View.OnClickListener mCallback80;
    private final View.OnClickListener mCallback81;
    private final View.OnClickListener mCallback82;
    private final View.OnClickListener mCallback83;
    private final View.OnClickListener mCallback84;
    private final View.OnClickListener mCallback85;
    private final View.OnClickListener mCallback86;
    private final View.OnClickListener mCallback87;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.dividing_line, 20);
        sViewsWithIds.put(R.id.bottom_layout, 21);
        sViewsWithIds.put(R.id.bottom_dividing_line, 22);
    }

    public PopupviewDiskManageBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 23, sIncludes, sViewsWithIds));
    }

    private PopupviewDiskManageBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 4, (ImageView) objArr[1], (View) objArr[22], (ConstraintLayout) objArr[21], (Button) objArr[15], (Button) objArr[19], (Button) objArr[10], (Button) objArr[13], (Button) objArr[14], (TextView) objArr[3], (Button) objArr[11], (Button) objArr[16], (ImageView) objArr[4], (View) objArr[20], (TextView) objArr[8], (RecyclerView) objArr[7], (ImageView) objArr[2], (TextView) objArr[9], (Button) objArr[18], (Button) objArr[12], (Button) objArr[17], (ImageButton) objArr[5], (ImageButton) objArr[6]);
        this.mDirtyFlags = -1L;
        this.backward.setTag(null);
        this.cancel.setTag(null);
        this.cleanAll.setTag(null);
        this.copy.setTag(null);
        this.createFile.setTag(null);
        this.createFolder.setTag(null);
        this.currentPath.setTag(null);
        this.cut.setTag(null);
        this.delete.setTag(null);
        this.diskListArrow.setTag(null);
        this.empty.setTag(null);
        this.fileList.setTag(null);
        this.forward.setTag(null);
        this.loading.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.ok.setTag(null);
        this.paste.setTag(null);
        this.rename.setTag(null);
        this.selectAll.setTag(null);
        this.selectCancel.setTag(null);
        setRootTag(view);
        this.mCallback79 = new OnClickListener(this, 8);
        this.mCallback82 = new OnClickListener(this, 11);
        this.mCallback83 = new OnClickListener(this, 12);
        this.mCallback77 = new OnClickListener(this, 6);
        this.mCallback80 = new OnClickListener(this, 9);
        this.mCallback78 = new OnClickListener(this, 7);
        this.mCallback81 = new OnClickListener(this, 10);
        this.mCallback87 = new OnClickListener(this, 16);
        this.mCallback74 = new OnClickListener(this, 3);
        this.mCallback86 = new OnClickListener(this, 15);
        this.mCallback76 = new OnClickListener(this, 5);
        this.mCallback75 = new OnClickListener(this, 4);
        this.mCallback72 = new OnClickListener(this, 1);
        this.mCallback84 = new OnClickListener(this, 13);
        this.mCallback85 = new OnClickListener(this, 14);
        this.mCallback73 = new OnClickListener(this, 2);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
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
        if (242 == i) {
            setDiskParam((DiskManageParam) obj);
        } else if (179 == i) {
            setClickListener((View.OnClickListener) obj);
        } else if (505 == i) {
            setLoadingFiles((ObservableBoolean) obj);
        } else if (822 != i) {
            return false;
        } else {
            setShareParam((SharedParam) obj);
        }
        return true;
    }

    @Override // com.rigol.scope.databinding.PopupviewDiskManageBinding
    public void setDiskParam(DiskManageParam diskManageParam) {
        updateRegistration(0, diskManageParam);
        this.mDiskParam = diskManageParam;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(242);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewDiskManageBinding
    public void setClickListener(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        notifyPropertyChanged(179);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewDiskManageBinding
    public void setLoadingFiles(ObservableBoolean observableBoolean) {
        updateRegistration(1, observableBoolean);
        this.mLoadingFiles = observableBoolean;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(505);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewDiskManageBinding
    public void setShareParam(SharedParam sharedParam) {
        updateRegistration(2, sharedParam);
        this.mShareParam = sharedParam;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(822);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return false;
                    }
                    return onChangeDiskParamDiskParam((DiskParam) obj, i2);
                }
                return onChangeShareParam((SharedParam) obj, i2);
            }
            return onChangeLoadingFiles((ObservableBoolean) obj, i2);
        }
        return onChangeDiskParam((DiskManageParam) obj, i2);
    }

    private boolean onChangeDiskParam(DiskManageParam diskManageParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i == 242) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        } else if (i == 190) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        } else if (i == 906) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        } else if (i == 794) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
            }
            return true;
        } else if (i == 795) {
            synchronized (this) {
                this.mDirtyFlags |= 256;
            }
            return true;
        } else if (i == 602) {
            synchronized (this) {
                this.mDirtyFlags |= 512;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeLoadingFiles(ObservableBoolean observableBoolean, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeShareParam(SharedParam sharedParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else if (i == 843) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 835) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeDiskParamDiskParam(DiskParam diskParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0252  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0271  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x028a  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x02a0  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x02a9  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x02de  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x02e8  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x0308  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x031f  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x032d  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x034a  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x0356  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x035f  */
    /* JADX WARN: Removed duplicated region for block: B:286:0x0384  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x0393  */
    /* JADX WARN: Removed duplicated region for block: B:295:0x039f  */
    /* JADX WARN: Removed duplicated region for block: B:303:0x03b1  */
    /* JADX WARN: Removed duplicated region for block: B:306:0x03bd  */
    /* JADX WARN: Removed duplicated region for block: B:314:0x03d7  */
    /* JADX WARN: Removed duplicated region for block: B:325:0x03f2  */
    /* JADX WARN: Removed duplicated region for block: B:328:0x03fc  */
    /* JADX WARN: Removed duplicated region for block: B:331:0x0474  */
    /* JADX WARN: Removed duplicated region for block: B:334:0x04a3  */
    /* JADX WARN: Removed duplicated region for block: B:337:0x04ae  */
    /* JADX WARN: Removed duplicated region for block: B:340:0x04b9  */
    /* JADX WARN: Removed duplicated region for block: B:343:0x04c4  */
    /* JADX WARN: Removed duplicated region for block: B:346:0x04d4  */
    /* JADX WARN: Removed duplicated region for block: B:349:0x04e1  */
    /* JADX WARN: Removed duplicated region for block: B:355:0x04fb  */
    /* JADX WARN: Removed duplicated region for block: B:358:0x0506  */
    /* JADX WARN: Removed duplicated region for block: B:364:0x0522  */
    /* JADX WARN: Removed duplicated region for block: B:371:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0132  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void executeBindings() {
        long j;
        float f;
        DiskManageParam.State state;
        String str;
        boolean z;
        int i;
        int i2;
        boolean z2;
        boolean z3;
        int i3;
        int i4;
        boolean z4;
        int i5;
        int i6;
        boolean z5;
        boolean z6;
        int i7;
        int i8;
        boolean z7;
        DiskManageParam.SelectionMode selectionMode;
        boolean z8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        boolean z9;
        float f2;
        boolean z10;
        int i16;
        int i17;
        int i18;
        boolean z11;
        int i19;
        boolean z12;
        int i20;
        int i21;
        long j2;
        int i22;
        int i23;
        float f3;
        int i24;
        int i25;
        int i26;
        long j3;
        long j4;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        DiskManageParam diskManageParam = this.mDiskParam;
        View.OnClickListener onClickListener = this.mClickListener;
        ObservableBoolean observableBoolean = this.mLoadingFiles;
        SharedParam sharedParam = this.mShareParam;
        if ((5097 & j) != 0) {
            if ((j & 5057) != 0) {
                state = diskManageParam != null ? diskManageParam.getState() : null;
                if ((j & 4545) != 0) {
                    z = state == DiskManageParam.State.SELECTING;
                    if ((j & 4417) != 0) {
                        j = z ? j | PlaybackStateCompat.ACTION_PREPARE : j | PlaybackStateCompat.ACTION_PLAY_FROM_URI;
                    }
                    if ((j & 4161) != 0) {
                        if (z) {
                            j3 = j | PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
                            j4 = 1073741824;
                        } else {
                            j3 = j | PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
                            j4 = 536870912;
                        }
                        j = j3 | j4;
                    }
                    if ((j & 4289) != 0) {
                        j = z ? j | 70368744177664L : j | 35184372088832L;
                    }
                    if ((j & 4161) != 0) {
                        i22 = z ? 0 : 8;
                        if (z) {
                            i23 = 8;
                            i25 = ((j & 4929) > 0L ? 1 : ((j & 4929) == 0L ? 0 : -1));
                            if (i25 != 0) {
                                z2 = state == DiskManageParam.State.DEFAULT;
                                if (i25 != 0) {
                                    j = z2 ? j | 4194304 : j | PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
                                }
                            } else {
                                z2 = false;
                            }
                            i26 = ((j & 4161) > 0L ? 1 : ((j & 4161) == 0L ? 0 : -1));
                            if (i26 != 0) {
                                boolean z13 = state == DiskManageParam.State.PASTING;
                                if (i26 != 0) {
                                    j |= z13 ? 17179869184L : 8589934592L;
                                }
                                if (!z13) {
                                    i = 8;
                                }
                            }
                            i = 0;
                        }
                        i23 = 0;
                        i25 = ((j & 4929) > 0L ? 1 : ((j & 4929) == 0L ? 0 : -1));
                        if (i25 != 0) {
                        }
                        i26 = ((j & 4161) > 0L ? 1 : ((j & 4161) == 0L ? 0 : -1));
                        if (i26 != 0) {
                        }
                        i = 0;
                    }
                } else {
                    z = false;
                }
                i22 = 0;
                i23 = 0;
                i25 = ((j & 4929) > 0L ? 1 : ((j & 4929) == 0L ? 0 : -1));
                if (i25 != 0) {
                }
                i26 = ((j & 4161) > 0L ? 1 : ((j & 4161) == 0L ? 0 : -1));
                if (i26 != 0) {
                }
                i = 0;
            } else {
                state = null;
                z = false;
                i = 0;
                z2 = false;
                i22 = 0;
                i23 = 0;
            }
            if ((j & 4225) != 0) {
                i2 = diskManageParam != null ? diskManageParam.getSelectedCount() : 0;
                z3 = i2 == 1;
                f3 = ContextUtil.getAlpha(z3);
            } else {
                f3 = 0.0f;
                i2 = 0;
                z3 = false;
            }
            if ((j & 4105) != 0) {
                DiskParam diskParam = diskManageParam != null ? diskManageParam.getDiskParam() : null;
                updateRegistration(3, diskParam);
                if (diskParam != null) {
                    str = diskParam.getFormattedPath();
                    i24 = ((j & 4129) > 0L ? 1 : ((j & 4129) == 0L ? 0 : -1));
                    if (i24 == 0) {
                        i4 = diskManageParam != null ? diskManageParam.getCount() : 0;
                        z4 = i4 == 0;
                        if (i24 != 0) {
                            j = z4 ? j | 67108864 : j | 33554432;
                        }
                        i3 = z4 ? 8 : 0;
                        i5 = i22;
                        i6 = i23;
                        f = f3;
                    } else {
                        i5 = i22;
                        i6 = i23;
                        f = f3;
                        i3 = 0;
                        i4 = 0;
                        z4 = false;
                    }
                }
            }
            str = null;
            i24 = ((j & 4129) > 0L ? 1 : ((j & 4129) == 0L ? 0 : -1));
            if (i24 == 0) {
            }
        } else {
            f = 0.0f;
            state = null;
            str = null;
            z = false;
            i = 0;
            i2 = 0;
            z2 = false;
            z3 = false;
            i3 = 0;
            i4 = 0;
            z4 = false;
            i5 = 0;
            i6 = 0;
        }
        int i27 = ((j & 4131) > 0L ? 1 : ((j & 4131) == 0L ? 0 : -1));
        if (i27 != 0) {
            z5 = observableBoolean != null ? observableBoolean.get() : false;
            if (i27 != 0) {
                j |= z5 ? PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH : PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
            }
            if ((j & 4098) != 0) {
                j |= z5 ? 17592186044416L : 8796093022208L;
            }
            z6 = !z5;
            if ((j & 4131) != 0) {
                j |= z6 ? 16777216L : 8388608L;
            }
            if ((j & 4098) != 0) {
                i7 = z5 ? 0 : 8;
                i8 = ((j & 7172) > 0L ? 1 : ((j & 7172) == 0L ? 0 : -1));
                if (i8 == 0) {
                    z7 = sharedParam != null ? sharedParam.getShowUsb() : false;
                    if (i8 != 0) {
                        j = z7 ? j | 1099511627776L : j | 549755813888L;
                    }
                } else {
                    z7 = false;
                }
                if ((j & 70368761004032L) == 0) {
                    if ((j & 70368744177664L) != 0) {
                        if (diskManageParam != null) {
                            i2 = diskManageParam.getSelectedCount();
                        }
                        boolean z14 = i2 == 1;
                        j2 = PlaybackStateCompat.ACTION_PREPARE;
                        z3 = z14;
                    } else {
                        j2 = PlaybackStateCompat.ACTION_PREPARE;
                    }
                    if ((j & j2) != 0) {
                        selectionMode = diskManageParam != null ? diskManageParam.getSelectionMode() : null;
                        if (selectionMode != DiskManageParam.SelectionMode.NONE) {
                            z8 = true;
                            if ((j & 16809984) != 0) {
                                if (diskManageParam != null) {
                                    i4 = diskManageParam.getCount();
                                }
                                z4 = i4 == 0;
                                if ((j & 4129) != 0) {
                                    j |= z4 ? 67108864L : 33554432L;
                                }
                            }
                        }
                    } else {
                        selectionMode = null;
                    }
                    z8 = false;
                    if ((j & 16809984) != 0) {
                    }
                } else {
                    selectionMode = null;
                    z8 = false;
                }
                boolean showSmb = ((j & 549755813888L) != 0 || sharedParam == null) ? false : sharedParam.getShowSmb();
                i9 = ((j & 4417) > 0L ? 1 : ((j & 4417) == 0L ? 0 : -1));
                if (i9 == 0) {
                    if (!z) {
                        z8 = false;
                    }
                    if (i9 != 0) {
                        j |= z8 ? 4398046511104L : 2199023255552L;
                    }
                } else {
                    z8 = false;
                }
                i10 = ((j & 4131) > 0L ? 1 : ((j & 4131) == 0L ? 0 : -1));
                if (i10 == 0) {
                    boolean z15 = z5 ? true : z4;
                    if (!z6) {
                        z4 = false;
                    }
                    if (i10 != 0) {
                        j |= z15 ? PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED : PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
                    }
                    if ((j & 4131) != 0) {
                        j |= z4 ? 1125899906842624L : 562949953421312L;
                    }
                    i11 = z15 ? 8 : 0;
                    if (!z4) {
                        i12 = 8;
                        i13 = ((j & 7172) > 0L ? 1 : ((j & 7172) == 0L ? 0 : -1));
                        if (i13 != 0) {
                            if (z7) {
                                showSmb = true;
                            }
                            if (i13 != 0) {
                                j |= showSmb ? 281474976710656L : 140737488355328L;
                            }
                            if (!showSmb) {
                                i14 = 8;
                                i15 = ((j & 4289) > 0L ? 1 : ((j & 4289) == 0L ? 0 : -1));
                                if (i15 == 0) {
                                    z9 = z ? z3 : false;
                                    if (i15 != 0) {
                                        j |= z9 ? 4294967296L : 2147483648L;
                                    }
                                } else {
                                    z9 = false;
                                }
                                if ((j & 2201170739200L) != 0) {
                                    z2 = state == DiskManageParam.State.DEFAULT;
                                    if ((j & 4929) != 0) {
                                        j = z2 ? j | 4194304 : j | PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
                                    }
                                }
                                if ((j & 4289) == 0) {
                                    z10 = z9 ? true : z2;
                                    f2 = ContextUtil.getAlpha(z10);
                                } else {
                                    f2 = 0.0f;
                                    z10 = false;
                                }
                                i16 = ((j & 4417) > 0L ? 1 : ((j & 4417) == 0L ? 0 : -1));
                                if (i16 != 0) {
                                    boolean z16 = z8 ? true : z2;
                                    if (i16 != 0) {
                                        j |= z16 ? 68719476736L : 34359738368L;
                                    }
                                    if (!z16) {
                                        i17 = 8;
                                        if ((j & 4194304) != 0) {
                                            if (diskManageParam != null) {
                                                selectionMode = diskManageParam.getSelectionMode();
                                            }
                                            i18 = i3;
                                            if (selectionMode == DiskManageParam.SelectionMode.ALL) {
                                                z11 = true;
                                                i19 = ((j & 4929) > 0L ? 1 : ((j & 4929) == 0L ? 0 : -1));
                                                if (i19 == 0) {
                                                    if (!z2) {
                                                        z11 = false;
                                                    }
                                                    if (i19 != 0) {
                                                        j |= z11 ? 268435456L : 134217728L;
                                                    }
                                                } else {
                                                    z11 = false;
                                                }
                                                if ((268435456 & j) != 0) {
                                                    String path = diskManageParam != null ? diskManageParam.getPath() : null;
                                                    if (path != null) {
                                                        z12 = path.startsWith(DiskManageParam.DEFAULT_PATH);
                                                        i20 = ((j & 4929) > 0L ? 1 : ((j & 4929) == 0L ? 0 : -1));
                                                        if (i20 != 0) {
                                                            if (!z11) {
                                                                z12 = false;
                                                            }
                                                            if (i20 != 0) {
                                                                j |= z12 ? 274877906944L : 137438953472L;
                                                            }
                                                            i21 = z12 ? 0 : 8;
                                                        } else {
                                                            i21 = 0;
                                                        }
                                                        if ((PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM & j) != 0) {
                                                            this.backward.setOnClickListener(this.mCallback72);
                                                            this.cancel.setOnClickListener(this.mCallback83);
                                                            this.cleanAll.setOnClickListener(this.mCallback87);
                                                            this.copy.setOnClickListener(this.mCallback78);
                                                            this.createFile.setOnClickListener(this.mCallback81);
                                                            this.createFolder.setOnClickListener(this.mCallback82);
                                                            this.currentPath.setOnClickListener(this.mCallback74);
                                                            this.cut.setOnClickListener(this.mCallback79);
                                                            this.delete.setOnClickListener(this.mCallback84);
                                                            this.diskListArrow.setOnClickListener(this.mCallback75);
                                                            this.forward.setOnClickListener(this.mCallback73);
                                                            this.ok.setOnClickListener(this.mCallback86);
                                                            this.paste.setOnClickListener(this.mCallback80);
                                                            this.rename.setOnClickListener(this.mCallback85);
                                                            this.selectAll.setOnClickListener(this.mCallback76);
                                                            this.selectCancel.setOnClickListener(this.mCallback77);
                                                        }
                                                        if ((j & 4161) != 0) {
                                                            this.cancel.setVisibility(i);
                                                            int i28 = i5;
                                                            this.copy.setVisibility(i28);
                                                            this.createFolder.setVisibility(i6);
                                                            this.cut.setVisibility(i28);
                                                            this.delete.setVisibility(i28);
                                                            this.paste.setVisibility(i);
                                                            this.rename.setVisibility(i28);
                                                        }
                                                        if ((j & 4929) != 0) {
                                                            this.cleanAll.setVisibility(i21);
                                                        }
                                                        if ((j & 4105) != 0) {
                                                            TextViewBindingAdapter.setText(this.currentPath, str);
                                                        }
                                                        if ((j & 7172) != 0) {
                                                            this.diskListArrow.setVisibility(i14);
                                                        }
                                                        if ((j & 4131) != 0) {
                                                            this.empty.setVisibility(i12);
                                                            this.fileList.setVisibility(i11);
                                                        }
                                                        if ((j & 4098) != 0) {
                                                            this.loading.setVisibility(i7);
                                                        }
                                                        if ((j & 4289) != 0) {
                                                            if (getBuildSdkInt() >= 11) {
                                                                this.ok.setAlpha(f2);
                                                            }
                                                            this.ok.setEnabled(z10);
                                                        }
                                                        if ((j & 4417) != 0) {
                                                            this.ok.setVisibility(i17);
                                                        }
                                                        if ((j & 4225) != 0) {
                                                            if (getBuildSdkInt() >= 11) {
                                                                this.rename.setAlpha(f);
                                                            }
                                                            this.rename.setEnabled(z3);
                                                        }
                                                        if ((j & 4129) != 0) {
                                                            int i29 = i18;
                                                            this.selectAll.setVisibility(i29);
                                                            this.selectCancel.setVisibility(i29);
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                }
                                                z12 = false;
                                                i20 = ((j & 4929) > 0L ? 1 : ((j & 4929) == 0L ? 0 : -1));
                                                if (i20 != 0) {
                                                }
                                                if ((PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM & j) != 0) {
                                                }
                                                if ((j & 4161) != 0) {
                                                }
                                                if ((j & 4929) != 0) {
                                                }
                                                if ((j & 4105) != 0) {
                                                }
                                                if ((j & 7172) != 0) {
                                                }
                                                if ((j & 4131) != 0) {
                                                }
                                                if ((j & 4098) != 0) {
                                                }
                                                if ((j & 4289) != 0) {
                                                }
                                                if ((j & 4417) != 0) {
                                                }
                                                if ((j & 4225) != 0) {
                                                }
                                                if ((j & 4129) != 0) {
                                                }
                                            }
                                        } else {
                                            i18 = i3;
                                        }
                                        z11 = false;
                                        i19 = ((j & 4929) > 0L ? 1 : ((j & 4929) == 0L ? 0 : -1));
                                        if (i19 == 0) {
                                        }
                                        if ((268435456 & j) != 0) {
                                        }
                                        z12 = false;
                                        i20 = ((j & 4929) > 0L ? 1 : ((j & 4929) == 0L ? 0 : -1));
                                        if (i20 != 0) {
                                        }
                                        if ((PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM & j) != 0) {
                                        }
                                        if ((j & 4161) != 0) {
                                        }
                                        if ((j & 4929) != 0) {
                                        }
                                        if ((j & 4105) != 0) {
                                        }
                                        if ((j & 7172) != 0) {
                                        }
                                        if ((j & 4131) != 0) {
                                        }
                                        if ((j & 4098) != 0) {
                                        }
                                        if ((j & 4289) != 0) {
                                        }
                                        if ((j & 4417) != 0) {
                                        }
                                        if ((j & 4225) != 0) {
                                        }
                                        if ((j & 4129) != 0) {
                                        }
                                    }
                                }
                                i17 = 0;
                                if ((j & 4194304) != 0) {
                                }
                                z11 = false;
                                i19 = ((j & 4929) > 0L ? 1 : ((j & 4929) == 0L ? 0 : -1));
                                if (i19 == 0) {
                                }
                                if ((268435456 & j) != 0) {
                                }
                                z12 = false;
                                i20 = ((j & 4929) > 0L ? 1 : ((j & 4929) == 0L ? 0 : -1));
                                if (i20 != 0) {
                                }
                                if ((PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM & j) != 0) {
                                }
                                if ((j & 4161) != 0) {
                                }
                                if ((j & 4929) != 0) {
                                }
                                if ((j & 4105) != 0) {
                                }
                                if ((j & 7172) != 0) {
                                }
                                if ((j & 4131) != 0) {
                                }
                                if ((j & 4098) != 0) {
                                }
                                if ((j & 4289) != 0) {
                                }
                                if ((j & 4417) != 0) {
                                }
                                if ((j & 4225) != 0) {
                                }
                                if ((j & 4129) != 0) {
                                }
                            }
                        }
                        i14 = 0;
                        i15 = ((j & 4289) > 0L ? 1 : ((j & 4289) == 0L ? 0 : -1));
                        if (i15 == 0) {
                        }
                        if ((j & 2201170739200L) != 0) {
                        }
                        if ((j & 4289) == 0) {
                        }
                        i16 = ((j & 4417) > 0L ? 1 : ((j & 4417) == 0L ? 0 : -1));
                        if (i16 != 0) {
                        }
                        i17 = 0;
                        if ((j & 4194304) != 0) {
                        }
                        z11 = false;
                        i19 = ((j & 4929) > 0L ? 1 : ((j & 4929) == 0L ? 0 : -1));
                        if (i19 == 0) {
                        }
                        if ((268435456 & j) != 0) {
                        }
                        z12 = false;
                        i20 = ((j & 4929) > 0L ? 1 : ((j & 4929) == 0L ? 0 : -1));
                        if (i20 != 0) {
                        }
                        if ((PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM & j) != 0) {
                        }
                        if ((j & 4161) != 0) {
                        }
                        if ((j & 4929) != 0) {
                        }
                        if ((j & 4105) != 0) {
                        }
                        if ((j & 7172) != 0) {
                        }
                        if ((j & 4131) != 0) {
                        }
                        if ((j & 4098) != 0) {
                        }
                        if ((j & 4289) != 0) {
                        }
                        if ((j & 4417) != 0) {
                        }
                        if ((j & 4225) != 0) {
                        }
                        if ((j & 4129) != 0) {
                        }
                    }
                } else {
                    i11 = 0;
                }
                i12 = 0;
                i13 = ((j & 7172) > 0L ? 1 : ((j & 7172) == 0L ? 0 : -1));
                if (i13 != 0) {
                }
                i14 = 0;
                i15 = ((j & 4289) > 0L ? 1 : ((j & 4289) == 0L ? 0 : -1));
                if (i15 == 0) {
                }
                if ((j & 2201170739200L) != 0) {
                }
                if ((j & 4289) == 0) {
                }
                i16 = ((j & 4417) > 0L ? 1 : ((j & 4417) == 0L ? 0 : -1));
                if (i16 != 0) {
                }
                i17 = 0;
                if ((j & 4194304) != 0) {
                }
                z11 = false;
                i19 = ((j & 4929) > 0L ? 1 : ((j & 4929) == 0L ? 0 : -1));
                if (i19 == 0) {
                }
                if ((268435456 & j) != 0) {
                }
                z12 = false;
                i20 = ((j & 4929) > 0L ? 1 : ((j & 4929) == 0L ? 0 : -1));
                if (i20 != 0) {
                }
                if ((PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM & j) != 0) {
                }
                if ((j & 4161) != 0) {
                }
                if ((j & 4929) != 0) {
                }
                if ((j & 4105) != 0) {
                }
                if ((j & 7172) != 0) {
                }
                if ((j & 4131) != 0) {
                }
                if ((j & 4098) != 0) {
                }
                if ((j & 4289) != 0) {
                }
                if ((j & 4417) != 0) {
                }
                if ((j & 4225) != 0) {
                }
                if ((j & 4129) != 0) {
                }
            }
        } else {
            z5 = false;
            z6 = false;
        }
        i7 = 0;
        i8 = ((j & 7172) > 0L ? 1 : ((j & 7172) == 0L ? 0 : -1));
        if (i8 == 0) {
        }
        if ((j & 70368761004032L) == 0) {
        }
        if ((j & 549755813888L) != 0) {
        }
        i9 = ((j & 4417) > 0L ? 1 : ((j & 4417) == 0L ? 0 : -1));
        if (i9 == 0) {
        }
        i10 = ((j & 4131) > 0L ? 1 : ((j & 4131) == 0L ? 0 : -1));
        if (i10 == 0) {
        }
        i12 = 0;
        i13 = ((j & 7172) > 0L ? 1 : ((j & 7172) == 0L ? 0 : -1));
        if (i13 != 0) {
        }
        i14 = 0;
        i15 = ((j & 4289) > 0L ? 1 : ((j & 4289) == 0L ? 0 : -1));
        if (i15 == 0) {
        }
        if ((j & 2201170739200L) != 0) {
        }
        if ((j & 4289) == 0) {
        }
        i16 = ((j & 4417) > 0L ? 1 : ((j & 4417) == 0L ? 0 : -1));
        if (i16 != 0) {
        }
        i17 = 0;
        if ((j & 4194304) != 0) {
        }
        z11 = false;
        i19 = ((j & 4929) > 0L ? 1 : ((j & 4929) == 0L ? 0 : -1));
        if (i19 == 0) {
        }
        if ((268435456 & j) != 0) {
        }
        z12 = false;
        i20 = ((j & 4929) > 0L ? 1 : ((j & 4929) == 0L ? 0 : -1));
        if (i20 != 0) {
        }
        if ((PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM & j) != 0) {
        }
        if ((j & 4161) != 0) {
        }
        if ((j & 4929) != 0) {
        }
        if ((j & 4105) != 0) {
        }
        if ((j & 7172) != 0) {
        }
        if ((j & 4131) != 0) {
        }
        if ((j & 4098) != 0) {
        }
        if ((j & 4289) != 0) {
        }
        if ((j & 4417) != 0) {
        }
        if ((j & 4225) != 0) {
        }
        if ((j & 4129) != 0) {
        }
    }

    @Override // com.rigol.scope.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int i, View view) {
        switch (i) {
            case 1:
                View.OnClickListener onClickListener = this.mClickListener;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                    return;
                }
                return;
            case 2:
                View.OnClickListener onClickListener2 = this.mClickListener;
                if (onClickListener2 != null) {
                    onClickListener2.onClick(view);
                    return;
                }
                return;
            case 3:
                View.OnClickListener onClickListener3 = this.mClickListener;
                if (onClickListener3 != null) {
                    onClickListener3.onClick(view);
                    return;
                }
                return;
            case 4:
                View.OnClickListener onClickListener4 = this.mClickListener;
                if (onClickListener4 != null) {
                    onClickListener4.onClick(view);
                    return;
                }
                return;
            case 5:
                View.OnClickListener onClickListener5 = this.mClickListener;
                if (onClickListener5 != null) {
                    onClickListener5.onClick(view);
                    return;
                }
                return;
            case 6:
                View.OnClickListener onClickListener6 = this.mClickListener;
                if (onClickListener6 != null) {
                    onClickListener6.onClick(view);
                    return;
                }
                return;
            case 7:
                View.OnClickListener onClickListener7 = this.mClickListener;
                if (onClickListener7 != null) {
                    onClickListener7.onClick(view);
                    return;
                }
                return;
            case 8:
                View.OnClickListener onClickListener8 = this.mClickListener;
                if (onClickListener8 != null) {
                    onClickListener8.onClick(view);
                    return;
                }
                return;
            case 9:
                View.OnClickListener onClickListener9 = this.mClickListener;
                if (onClickListener9 != null) {
                    onClickListener9.onClick(view);
                    return;
                }
                return;
            case 10:
                View.OnClickListener onClickListener10 = this.mClickListener;
                if (onClickListener10 != null) {
                    onClickListener10.onClick(view);
                    return;
                }
                return;
            case 11:
                View.OnClickListener onClickListener11 = this.mClickListener;
                if (onClickListener11 != null) {
                    onClickListener11.onClick(view);
                    return;
                }
                return;
            case 12:
                View.OnClickListener onClickListener12 = this.mClickListener;
                if (onClickListener12 != null) {
                    onClickListener12.onClick(view);
                    return;
                }
                return;
            case 13:
                View.OnClickListener onClickListener13 = this.mClickListener;
                if (onClickListener13 != null) {
                    onClickListener13.onClick(view);
                    return;
                }
                return;
            case 14:
                View.OnClickListener onClickListener14 = this.mClickListener;
                if (onClickListener14 != null) {
                    onClickListener14.onClick(view);
                    return;
                }
                return;
            case 15:
                View.OnClickListener onClickListener15 = this.mClickListener;
                if (onClickListener15 != null) {
                    onClickListener15.onClick(view);
                    return;
                }
                return;
            case 16:
                View.OnClickListener onClickListener16 = this.mClickListener;
                if (onClickListener16 != null) {
                    onClickListener16.onClick(view);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
