package com.rigol.scope.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.rigol.scope.R;
import com.rigol.scope.data.AfgParam;
import com.rigol.scope.data.LaParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.SharedParam;
import com.rigol.scope.data.UtilityParam;
import com.rigol.scope.utilities.DrawView1;
import com.rigol.scope.utilities.MRefreshHeader;
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
        To view partially-correct add '--show-bad-code' argument
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 1425
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rigol.scope.databinding.FragmentSettingsBarBindingImpl.executeBindings():void");
    }
}
