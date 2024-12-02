package com.rigol.scope.databinding;

import android.graphics.drawable.Drawable;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.ImageViewBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.databinding.adapters.ViewBindingAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.rigol.scope.R;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.AfgParam;
import com.rigol.scope.data.LaParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.SharedParam;
import com.rigol.scope.data.UtilityParam;
import com.rigol.scope.utilities.ColorUtil;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.DrawView1;
import com.rigol.scope.utilities.MRefreshHeader;
import com.rigol.scope.utilities.UnitFormat;
import com.rigol.scope.utilities.ViewUtil;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

/* loaded from: classes2.dex */
public class FragmentSettingsBarBindingImpl extends FragmentSettingsBarBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;
    private final ConstraintLayout mboundView2;
    private final TextView mboundView3;
    private final ImageView mboundView5;
    private final TextView mboundView7;
    private final TextView mboundView8;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.starter_layout, 15);
        sViewsWithIds.put(R.id.starter_button, 16);
        sViewsWithIds.put(R.id.vertical_list_system_time_layout, 17);
        sViewsWithIds.put(R.id.vertical_list, 18);
        sViewsWithIds.put(R.id.vertical_d, 19);
        sViewsWithIds.put(R.id.d_item_list, 20);
        sViewsWithIds.put(R.id.nothing_view, 21);
        sViewsWithIds.put(R.id.vertical_d_two, 22);
        sViewsWithIds.put(R.id.vertical_g, 23);
        sViewsWithIds.put(R.id.msRefreshHeader, 24);
        sViewsWithIds.put(R.id.vertical_m, 25);
        sViewsWithIds.put(R.id.math_item_list, 26);
        sViewsWithIds.put(R.id.math_list, 27);
        sViewsWithIds.put(R.id.other_layout, 28);
        sViewsWithIds.put(R.id.system_time_layout, 29);
        sViewsWithIds.put(R.id.power_icon_view, 30);
    }

    public FragmentSettingsBarBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 31, sIncludes, sViewsWithIds));
    }

    private FragmentSettingsBarBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 6, (ImageView) objArr[11], (RecyclerView) objArr[20], (TextView) objArr[14], (ImageView) objArr[10], (RecyclerView) objArr[26], (RecyclerView) objArr[27], (MRefreshHeader) objArr[24], (View) objArr[21], (RecyclerView) objArr[28], (DrawView1) objArr[30], (ImageView) objArr[12], (ImageButton) objArr[16], (LinearLayoutCompat) objArr[15], (TextView) objArr[1], (ConstraintLayout) objArr[29], (TextView) objArr[13], (ImageView) objArr[9], (SmartRefreshLayout) objArr[19], (ConstraintLayout) objArr[22], (SmartRefreshLayout) objArr[23], (TextView) objArr[6], (ConstraintLayout) objArr[4], (RecyclerView) objArr[18], (ConstraintLayout) objArr[17], (ConstraintLayout) objArr[25]);
        this.mDirtyFlags = -1L;
        this.beeper.setTag(null);
        this.date.setTag(null);
        this.lxi.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        ConstraintLayout constraintLayout2 = (ConstraintLayout) objArr[2];
        this.mboundView2 = constraintLayout2;
        constraintLayout2.setTag(null);
        TextView textView = (TextView) objArr[3];
        this.mboundView3 = textView;
        textView.setTag(null);
        ImageView imageView = (ImageView) objArr[5];
        this.mboundView5 = imageView;
        imageView.setTag(null);
        TextView textView2 = (TextView) objArr[7];
        this.mboundView7 = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) objArr[8];
        this.mboundView8 = textView3;
        textView3.setTag(null);
        this.rmt.setTag(null);
        this.starterMessage.setTag(null);
        this.time.setTag(null);
        this.usb.setTag(null);
        this.verticalGText.setTag(null);
        this.verticalGView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
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
        if (1013 == i) {
            setUtilityParam((UtilityParam) obj);
        } else if (454 == i) {
            setLaParam((LaParam) obj);
        } else if (367 == i) {
            setHasUpdate((ObservableBoolean) obj);
        } else if (823 == i) {
            setSharedParam((SharedParam) obj);
        } else if (38 != i) {
            return false;
        } else {
            setAfgParam((AfgParam) obj);
        }
        return true;
    }

    @Override // com.rigol.scope.databinding.FragmentSettingsBarBinding
    public void setUtilityParam(UtilityParam utilityParam) {
        updateRegistration(1, utilityParam);
        this.mUtilityParam = utilityParam;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(1013);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.FragmentSettingsBarBinding
    public void setLaParam(LaParam laParam) {
        updateRegistration(2, laParam);
        this.mLaParam = laParam;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(454);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.FragmentSettingsBarBinding
    public void setHasUpdate(ObservableBoolean observableBoolean) {
        updateRegistration(3, observableBoolean);
        this.mHasUpdate = observableBoolean;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(367);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.FragmentSettingsBarBinding
    public void setSharedParam(SharedParam sharedParam) {
        updateRegistration(4, sharedParam);
        this.mSharedParam = sharedParam;
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        notifyPropertyChanged(823);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.FragmentSettingsBarBinding
    public void setAfgParam(AfgParam afgParam) {
        updateRegistration(5, afgParam);
        this.mAfgParam = afgParam;
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        notifyPropertyChanged(38);
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
                            return onChangeAfgParam((AfgParam) obj, i2);
                        }
                        return onChangeSharedParam((SharedParam) obj, i2);
                    }
                    return onChangeHasUpdate((ObservableBoolean) obj, i2);
                }
                return onChangeLaParam((LaParam) obj, i2);
            }
            return onChangeUtilityParam((UtilityParam) obj, i2);
        }
        return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgAfgWaveFunctionAfgParamWaveFunction((MappingObject) obj, i2);
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgAfgWaveFunctionAfgParamWaveFunction(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i == 638) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeUtilityParam(UtilityParam utilityParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        } else if (i == 88) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
            }
            return true;
        } else if (i == 934) {
            synchronized (this) {
                this.mDirtyFlags |= 256;
            }
            return true;
        } else if (i == 841) {
            synchronized (this) {
                this.mDirtyFlags |= 512;
            }
            return true;
        } else if (i == 222) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeLaParam(LaParam laParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else if (i == 453) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeHasUpdate(ObservableBoolean observableBoolean, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeSharedParam(SharedParam sharedParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        } else if (i == 843) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
            }
            return true;
        } else if (i == 830) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            }
            return true;
        } else if (i == 832) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeAfgParam(AfgParam afgParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        } else if (i == 81) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 1040) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
            }
            return true;
        } else if (i == 75) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
            }
            return true;
        } else if (i == 77) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
            }
            return true;
        } else {
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:113:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x038f  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x03ab  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x03d4  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x03e7  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x040c  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x0418  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x043a  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x044a  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x0450  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x0458  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x045d  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x0465  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x0482  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x04a8  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x04b6  */
    /* JADX WARN: Removed duplicated region for block: B:294:0x04c4  */
    /* JADX WARN: Removed duplicated region for block: B:297:0x04d2  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:300:0x04e2  */
    /* JADX WARN: Removed duplicated region for block: B:302:0x04e9  */
    /* JADX WARN: Removed duplicated region for block: B:305:0x04fb  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x0514  */
    /* JADX WARN: Removed duplicated region for block: B:311:0x0521  */
    /* JADX WARN: Removed duplicated region for block: B:314:0x0535  */
    /* JADX WARN: Removed duplicated region for block: B:317:0x0540  */
    /* JADX WARN: Removed duplicated region for block: B:320:0x0552  */
    /* JADX WARN: Removed duplicated region for block: B:323:0x055f  */
    /* JADX WARN: Removed duplicated region for block: B:326:0x056c  */
    /* JADX WARN: Removed duplicated region for block: B:329:0x0579  */
    /* JADX WARN: Removed duplicated region for block: B:332:0x0586  */
    /* JADX WARN: Removed duplicated region for block: B:339:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0112  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void executeBindings() {
        long j;
        String str;
        String str2;
        Drawable drawable;
        int i;
        int i2;
        int i3;
        boolean z;
        int i4;
        int i5;
        int i6;
        int i7;
        String str3;
        int i8;
        Drawable drawable2;
        String str4;
        Drawable drawable3;
        long j2;
        int i9;
        int i10;
        int i11;
        boolean z2;
        boolean z3;
        int i12;
        int i13;
        String str5;
        Drawable drawable4;
        int i14;
        int i15;
        String str6;
        int i16;
        boolean z4;
        int i17;
        int i18;
        int i19;
        Drawable drawable5;
        int i20;
        long j3;
        String str7;
        boolean z5;
        int i21;
        long j4;
        int color;
        long j5;
        long j6;
        long j7;
        int i22;
        boolean z6;
        long j8;
        long j9;
        int i23;
        int i24;
        int i25;
        long j10;
        long j11;
        int i26;
        int i27;
        long j12;
        long j13;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        UtilityParam utilityParam = this.mUtilityParam;
        LaParam laParam = this.mLaParam;
        ObservableBoolean observableBoolean = this.mHasUpdate;
        SharedParam sharedParam = this.mSharedParam;
        AfgParam afgParam = this.mAfgParam;
        if ((526210 & j) != 0) {
            str2 = ((j & 524546) == 0 || utilityParam == null) ? null : utilityParam.getTime();
            int i28 = ((j & 524802) > 0L ? 1 : ((j & 524802) == 0L ? 0 : -1));
            if (i28 != 0) {
                boolean showTime = utilityParam != null ? utilityParam.getShowTime() : false;
                if (i28 != 0) {
                    j |= showTime ? 8589934592L : 4294967296L;
                }
                if (!showTime) {
                    i2 = 8;
                    i26 = ((j & 524418) > 0L ? 1 : ((j & 524418) == 0L ? 0 : -1));
                    if (i26 == 0) {
                        boolean beeper = utilityParam != null ? utilityParam.getBeeper() : false;
                        if (i26 != 0) {
                            j |= beeper ? 33554432L : 16777216L;
                        }
                        drawable = beeper ? AppCompatResources.getDrawable(this.beeper.getContext(), R.drawable.beeper_on) : AppCompatResources.getDrawable(this.beeper.getContext(), R.drawable.beeper_off);
                    } else {
                        drawable = null;
                    }
                    i27 = ((j & 524290) > 0L ? 1 : ((j & 524290) == 0L ? 0 : -1));
                    if (i27 == 0) {
                        boolean z7 = (utilityParam != null ? utilityParam.getSeries() : 0) == 800;
                        if (i27 != 0) {
                            if (z7) {
                                j12 = j | 536870912;
                                j13 = 137438953472L;
                            } else {
                                j12 = j | 268435456;
                                j13 = 68719476736L;
                            }
                            j = j12 | j13;
                        }
                        boolean checkModelEDU = z7 ? ViewUtil.checkModelEDU() : false;
                        boolean checkModel = z7 ? true : ViewUtil.checkModel();
                        if ((j & 524290) != 0) {
                            j |= checkModelEDU ? 134217728L : 67108864L;
                        }
                        if ((j & 524290) != 0) {
                            j |= checkModel ? 549755813888L : 274877906944L;
                        }
                        i3 = checkModelEDU ? 8 : 0;
                        i = checkModel ? 8 : 0;
                    } else {
                        i = 0;
                        i3 = 0;
                    }
                    str = ((j & 525314) != 0 || utilityParam == null) ? null : utilityParam.getDate();
                }
            }
            i2 = 0;
            i26 = ((j & 524418) > 0L ? 1 : ((j & 524418) == 0L ? 0 : -1));
            if (i26 == 0) {
            }
            i27 = ((j & 524290) > 0L ? 1 : ((j & 524290) == 0L ? 0 : -1));
            if (i27 == 0) {
            }
            if ((j & 525314) != 0) {
            }
        } else {
            str = null;
            str2 = null;
            drawable = null;
            i = 0;
            i2 = 0;
            i3 = 0;
        }
        int i29 = ((j & 526340) > 0L ? 1 : ((j & 526340) == 0L ? 0 : -1));
        if (i29 != 0) {
            z = laParam != null ? laParam.getLaEnable() : false;
            if (i29 != 0) {
                if (z) {
                    j10 = j | 35184372088832L;
                    j11 = 2251799813685248L;
                } else {
                    j10 = j | 17592186044416L;
                    j11 = 1125899906842624L;
                }
                j = j10 | j11;
            }
        } else {
            z = false;
        }
        int i30 = ((j & 524296) > 0L ? 1 : ((j & 524296) == 0L ? 0 : -1));
        if (i30 != 0) {
            boolean z8 = observableBoolean != null ? observableBoolean.get() : false;
            if (i30 != 0) {
                j |= z8 ? 8796093022208L : 4398046511104L;
            }
            if (!z8) {
                i4 = 8;
                if ((j & 552976) == 0) {
                    int i31 = ((j & 528400) > 0L ? 1 : ((j & 528400) == 0L ? 0 : -1));
                    if (i31 != 0) {
                        boolean showUsb = sharedParam != null ? sharedParam.getShowUsb() : false;
                        if (i31 != 0) {
                            j |= showUsb ? 36028797018963968L : 18014398509481984L;
                        }
                        if (!showUsb) {
                            i6 = 8;
                            i23 = ((j & 540688) > 0L ? 1 : ((j & 540688) == 0L ? 0 : -1));
                            if (i23 != 0) {
                                boolean showRMT = sharedParam != null ? sharedParam.getShowRMT() : false;
                                if (i23 != 0) {
                                    j |= showRMT ? 562949953421312L : 281474976710656L;
                                }
                                if (!showRMT) {
                                    i24 = 8;
                                    i25 = ((j & 532496) > 0L ? 1 : ((j & 532496) == 0L ? 0 : -1));
                                    if (i25 != 0) {
                                        boolean showNetwork = sharedParam != null ? sharedParam.getShowNetwork() : false;
                                        if (i25 != 0) {
                                            j |= showNetwork ? PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE : PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
                                        }
                                        i5 = showNetwork ? 0 : 8;
                                        i7 = i24;
                                    } else {
                                        i7 = i24;
                                        i5 = 0;
                                    }
                                }
                            }
                            i24 = 0;
                            i25 = ((j & 532496) > 0L ? 1 : ((j & 532496) == 0L ? 0 : -1));
                            if (i25 != 0) {
                            }
                        }
                    }
                    i6 = 0;
                    i23 = ((j & 540688) > 0L ? 1 : ((j & 540688) == 0L ? 0 : -1));
                    if (i23 != 0) {
                    }
                    i24 = 0;
                    i25 = ((j & 532496) > 0L ? 1 : ((j & 532496) == 0L ? 0 : -1));
                    if (i25 != 0) {
                    }
                } else {
                    i5 = 0;
                    i6 = 0;
                    i7 = 0;
                }
                if ((j & 1015905) == 0) {
                    int i32 = ((j & 786464) > 0L ? 1 : ((j & 786464) == 0L ? 0 : -1));
                    if (i32 != 0) {
                        j3 = afgParam != null ? afgParam.getBasic_freq() : 0L;
                        z2 = j3 >= 1000000;
                        if (i32 != 0) {
                            j = z2 ? j | 8388608 : j | 4194304;
                        }
                    } else {
                        j3 = 0;
                        z2 = false;
                    }
                    if ((j & 655392) != 0) {
                        i8 = i6;
                        str3 = str2;
                        str7 = UnitFormat.newBuilder(UnitFormat.SI.NANO).convert(afgParam != null ? afgParam.getBasic_amp() : 0L, ServiceEnum.Unit.Unit_V);
                    } else {
                        str3 = str2;
                        i8 = i6;
                        str7 = null;
                    }
                    if ((j & 589921) != 0) {
                        int wave_function = afgParam != null ? afgParam.getWave_function() : 0;
                        int i33 = ((j & 589856) > 0L ? 1 : ((j & 589856) == 0L ? 0 : -1));
                        if (i33 != 0) {
                            z6 = wave_function == 5;
                            if (i33 != 0) {
                                if (z6) {
                                    j8 = j | 2147483648L;
                                    j9 = 34359738368L;
                                } else {
                                    j8 = j | 1073741824;
                                    j9 = 17179869184L;
                                }
                                j = j8 | j9;
                            }
                            i22 = z6 ? 4 : 0;
                            j7 = j;
                        } else {
                            j7 = j;
                            i22 = 0;
                            z6 = false;
                        }
                        MappingObject mappingObject = ViewUtil.getMappingObject(R.array.msg_afg_wave_function, wave_function);
                        updateRegistration(0, mappingObject);
                        Drawable pic = mappingObject != null ? mappingObject.getPic() : null;
                        Drawable.ConstantState constantState = pic != null ? pic.getConstantState() : null;
                        Drawable newDrawable = constantState != null ? constantState.newDrawable() : null;
                        if (newDrawable != null) {
                            i21 = i22;
                            drawable2 = newDrawable.mutate();
                        } else {
                            i21 = i22;
                            drawable2 = null;
                        }
                        int i34 = wave_function;
                        z5 = false;
                        j = j7;
                        z3 = z6;
                        i10 = i34;
                    } else {
                        z5 = false;
                        i10 = 0;
                        i21 = 0;
                        z3 = false;
                        drawable2 = null;
                    }
                    int i35 = ((j & 557088) > 0L ? 1 : ((j & 557088) == 0L ? 0 : -1));
                    if (i35 != 0) {
                        boolean basic_output_enable = afgParam != null ? afgParam.getBasic_output_enable() : z5;
                        if (i35 != 0) {
                            if (basic_output_enable) {
                                j5 = j | 2199023255552L;
                                j6 = 140737488355328L;
                            } else {
                                j5 = j | 1099511627776L;
                                j6 = 70368744177664L;
                            }
                            j = j5 | j6;
                        }
                        if (basic_output_enable) {
                            j4 = j;
                            color = ColorUtil.getColor(getRoot().getContext(), 63);
                        } else {
                            j4 = j;
                            color = ColorUtil.getColor(getRoot().getContext(), 71);
                        }
                        int i36 = color;
                        Drawable selectedBackground = basic_output_enable ? ContextUtil.getSelectedBackground(R.drawable.bg_item_vertical, ColorUtil.getColor(getRoot().getContext(), 63)) : ContextUtil.getDrawable(R.drawable.bg_item_vertical);
                        i9 = i21;
                        str4 = str7;
                        j2 = j3;
                        drawable3 = selectedBackground;
                        i11 = i36;
                        j = j4;
                    } else {
                        i9 = i21;
                        str4 = str7;
                        j2 = j3;
                        i11 = 0;
                        drawable3 = null;
                    }
                } else {
                    str3 = str2;
                    i8 = i6;
                    drawable2 = null;
                    str4 = null;
                    drawable3 = null;
                    j2 = 0;
                    i9 = 0;
                    i10 = 0;
                    i11 = 0;
                    z2 = false;
                    z3 = false;
                }
                if ((j & 8388608) == 0) {
                    i12 = i4;
                    i13 = i9;
                    str5 = ViewUtil.subNumber(UnitFormat.newBuilder("0.000", UnitFormat.SI.MICRO).convert(j2) + ServiceEnum.Unit.Unit_hz.value2, 7);
                } else {
                    i12 = i4;
                    i13 = i9;
                    str5 = null;
                }
                if ((j & 2286984185774080L) == 0) {
                    i14 = ColorUtil.getColor(getRoot().getContext(), laParam != null ? laParam.getServiceId() : 0);
                    drawable4 = (j & 35184372088832L) != 0 ? ContextUtil.getSelectedBackground(R.drawable.bg_item_vertical, i14) : null;
                } else {
                    drawable4 = null;
                    i14 = 0;
                }
                if ((j & 4194304) == 0) {
                    i15 = i14;
                    str6 = UnitFormat.newBuilder("0", UnitFormat.SI.MICRO).convert(j2) + ServiceEnum.Unit.Unit_hz.value2;
                } else {
                    i15 = i14;
                    str6 = null;
                }
                if ((17179869184L & j) == 0) {
                    i16 = 4;
                    if (i10 == 4) {
                        z4 = true;
                        if ((j & 786464) == 0) {
                            str5 = null;
                        } else if (!z2) {
                            str5 = str6;
                        }
                        i17 = ((j & 589856) > 0L ? 1 : ((j & 589856) == 0L ? 0 : -1));
                        if (i17 != 0) {
                            boolean z9 = z3 ? true : z4;
                            if (i17 != 0) {
                                j |= z9 ? 9007199254740992L : 4503599627370496L;
                            }
                            if (z9) {
                                i18 = i16;
                                i19 = ((j & 526340) > 0L ? 1 : ((j & 526340) == 0L ? 0 : -1));
                                if (i19 == 0) {
                                    Drawable drawable6 = z ? drawable4 : ContextUtil.getDrawable(R.drawable.bg_item_vertical);
                                    if (!z) {
                                        i15 = ColorUtil.getColor(getRoot().getContext(), 71);
                                    }
                                    drawable5 = drawable6;
                                    i20 = i15;
                                } else {
                                    drawable5 = null;
                                    i20 = 0;
                                }
                                if ((j & 524418) != 0) {
                                    ImageViewBindingAdapter.setImageDrawable(this.beeper, drawable);
                                }
                                if ((j & 525314) != 0) {
                                    TextViewBindingAdapter.setText(this.date, str);
                                }
                                if ((j & 524802) != 0) {
                                    this.date.setVisibility(i2);
                                    this.time.setVisibility(i2);
                                }
                                if ((j & 532496) != 0) {
                                    this.lxi.setVisibility(i5);
                                }
                                if (i19 != 0) {
                                    ViewBindingAdapter.setBackground(this.mboundView2, drawable5);
                                    this.mboundView3.setTextColor(i20);
                                }
                                if ((j & 524290) != 0) {
                                    this.mboundView2.setVisibility(i3);
                                    this.mboundView3.setVisibility(i3);
                                    this.verticalGView.setVisibility(i);
                                }
                                if ((589921 & j) != 0) {
                                    ViewBindingAdapter.setBackground(this.mboundView5, drawable2);
                                }
                                if ((557088 & j) != 0) {
                                    this.mboundView7.setTextColor(i11);
                                    ViewBindingAdapter.setBackground(this.verticalGView, drawable3);
                                }
                                if ((j & 786464) != 0) {
                                    TextViewBindingAdapter.setText(this.mboundView8, str5);
                                }
                                if ((j & 589856) != 0) {
                                    this.mboundView8.setVisibility(i18);
                                    this.verticalGText.setVisibility(i13);
                                }
                                if ((j & 540688) != 0) {
                                    this.rmt.setVisibility(i7);
                                }
                                if ((j & 524296) != 0) {
                                    this.starterMessage.setVisibility(i12);
                                }
                                if ((j & 524546) != 0) {
                                    TextViewBindingAdapter.setText(this.time, str3);
                                }
                                if ((j & 528400) != 0) {
                                    this.usb.setVisibility(i8);
                                }
                                if ((j & 655392) == 0) {
                                    TextViewBindingAdapter.setText(this.verticalGText, str4);
                                    return;
                                }
                                return;
                            }
                        }
                        i18 = 0;
                        i19 = ((j & 526340) > 0L ? 1 : ((j & 526340) == 0L ? 0 : -1));
                        if (i19 == 0) {
                        }
                        if ((j & 524418) != 0) {
                        }
                        if ((j & 525314) != 0) {
                        }
                        if ((j & 524802) != 0) {
                        }
                        if ((j & 532496) != 0) {
                        }
                        if (i19 != 0) {
                        }
                        if ((j & 524290) != 0) {
                        }
                        if ((589921 & j) != 0) {
                        }
                        if ((557088 & j) != 0) {
                        }
                        if ((j & 786464) != 0) {
                        }
                        if ((j & 589856) != 0) {
                        }
                        if ((j & 540688) != 0) {
                        }
                        if ((j & 524296) != 0) {
                        }
                        if ((j & 524546) != 0) {
                        }
                        if ((j & 528400) != 0) {
                        }
                        if ((j & 655392) == 0) {
                        }
                    }
                } else {
                    i16 = 4;
                }
                z4 = false;
                if ((j & 786464) == 0) {
                }
                i17 = ((j & 589856) > 0L ? 1 : ((j & 589856) == 0L ? 0 : -1));
                if (i17 != 0) {
                }
                i18 = 0;
                i19 = ((j & 526340) > 0L ? 1 : ((j & 526340) == 0L ? 0 : -1));
                if (i19 == 0) {
                }
                if ((j & 524418) != 0) {
                }
                if ((j & 525314) != 0) {
                }
                if ((j & 524802) != 0) {
                }
                if ((j & 532496) != 0) {
                }
                if (i19 != 0) {
                }
                if ((j & 524290) != 0) {
                }
                if ((589921 & j) != 0) {
                }
                if ((557088 & j) != 0) {
                }
                if ((j & 786464) != 0) {
                }
                if ((j & 589856) != 0) {
                }
                if ((j & 540688) != 0) {
                }
                if ((j & 524296) != 0) {
                }
                if ((j & 524546) != 0) {
                }
                if ((j & 528400) != 0) {
                }
                if ((j & 655392) == 0) {
                }
            }
        }
        i4 = 0;
        if ((j & 552976) == 0) {
        }
        if ((j & 1015905) == 0) {
        }
        if ((j & 8388608) == 0) {
        }
        if ((j & 2286984185774080L) == 0) {
        }
        if ((j & 4194304) == 0) {
        }
        if ((17179869184L & j) == 0) {
        }
        z4 = false;
        if ((j & 786464) == 0) {
        }
        i17 = ((j & 589856) > 0L ? 1 : ((j & 589856) == 0L ? 0 : -1));
        if (i17 != 0) {
        }
        i18 = 0;
        i19 = ((j & 526340) > 0L ? 1 : ((j & 526340) == 0L ? 0 : -1));
        if (i19 == 0) {
        }
        if ((j & 524418) != 0) {
        }
        if ((j & 525314) != 0) {
        }
        if ((j & 524802) != 0) {
        }
        if ((j & 532496) != 0) {
        }
        if (i19 != 0) {
        }
        if ((j & 524290) != 0) {
        }
        if ((589921 & j) != 0) {
        }
        if ((557088 & j) != 0) {
        }
        if ((j & 786464) != 0) {
        }
        if ((j & 589856) != 0) {
        }
        if ((j & 540688) != 0) {
        }
        if ((j & 524296) != 0) {
        }
        if ((j & 524546) != 0) {
        }
        if ((j & 528400) != 0) {
        }
        if ((j & 655392) == 0) {
        }
    }
}
