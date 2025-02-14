package com.rigol.scope.databinding;

import android.graphics.drawable.Drawable;
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
import androidx.databinding.adapters.ImageViewBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.databinding.adapters.ViewBindingAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.rigol.scope.R;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.HorizontalParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.TriggerParam;
import com.rigol.scope.generated.callback.OnClickListener;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.PopupViewManager;
import com.rigol.scope.utilities.UnitFormat;
import com.rigol.scope.utilities.ViewUtil;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

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
    */
    protected void executeBindings() {
        long j;
        HorizontalParam horizontalParam;
        String str;
        String str2;
        String str3;
        Drawable drawable;
        Drawable drawable2;
        String str4;
        String str5;
        Drawable drawable3;
        String str6;
        String str7;
        String str8;
        int i;
        boolean z;
        int i2;
        boolean z2;
        int i3;
        int i4;
        Drawable drawable4;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        int i5;
        String str9;
        ServiceEnum.ControlAction controlAction;
        boolean z7;
        String str10;
        String str11;
        String str12;
        String str13;
        long j2;
        boolean z8;
        boolean z9;
        boolean z10;
        boolean z11;
        String str14;
        String str15;
        String str16;
        int i6;
        long j3;
        long j4;
        long j5;
        ServiceEnum.TriggerPulsePolarity triggerPulsePolarity;
        ServiceEnum.TriggerPulsePolarity triggerPulsePolarity2;
        ServiceEnum.SHEvent sHEvent;
        ServiceEnum.EdgeSlope edgeSlope;
        ServiceEnum.EdgeSlope edgeSlope2;
        ServiceEnum.EdgeSlope edgeSlope3;
        ServiceEnum.EdgeSlope edgeSlope4;
        ServiceEnum.EdgeSlope edgeSlope5;
        ServiceEnum.TriggerPulsePolarity triggerPulsePolarity3;
        ServiceEnum.EdgeSlope edgeSlope6;
        ServiceEnum.OverEvent overEvent;
        ServiceEnum.EdgeSlope edgeSlope7;
        ServiceEnum.EdgeSlope edgeSlope8;
        ServiceEnum.TriggerMode triggerMode;
        Drawable drawable5;
        long j6;
        long j7;
        long j8;
        long j9;
        long j10;
        long j11;
        long j12;
        long j13;
        long j14;
        long j15;
        long j16;
        long j17;
        long j18;
        long j19;
        long j20;
        long j21;
        long j22;
        long j23;
        long j24;
        long j25;
        long j26;
        ServiceEnum.Unit unit;
        int i7;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
            this.mDirtyFlags_1 = 0L;
        }
        TriggerParam triggerParam = this.mTriggerParam;
        HorizontalParam horizontalParam2 = this.mHorizontalParam;
        if ((2256197860196338L & j) != 0) {
            int i8 = ((j & 2251799814209506L) > 0L ? 1 : ((j & 2251799814209506L) == 0L ? 0 : -1));
            if (i8 == 0 || triggerParam == null) {
                triggerPulsePolarity = null;
                triggerPulsePolarity2 = null;
                sHEvent = null;
                edgeSlope = null;
                edgeSlope2 = null;
                edgeSlope3 = null;
                edgeSlope4 = null;
                edgeSlope5 = null;
                triggerPulsePolarity3 = null;
                edgeSlope6 = null;
                overEvent = null;
                edgeSlope7 = null;
                edgeSlope8 = null;
            } else {
                ServiceEnum.EdgeSlope edgeSlopeA = triggerParam.getEdgeSlopeA();
                ServiceEnum.TriggerPulsePolarity polarity = triggerParam.getPolarity();
                ServiceEnum.EdgeSlope overSlope = triggerParam.getOverSlope();
                ServiceEnum.EdgeSlope edgeSlope9 = triggerParam.getEdgeSlope();
                ServiceEnum.SHEvent sHEvent2 = triggerParam.getSHEvent();
                edgeSlope2 = triggerParam.getSlope();
                ServiceEnum.EdgeSlope setupHoldSlope = triggerParam.getSetupHoldSlope();
                ServiceEnum.TriggerPulsePolarity runtPolarity = triggerParam.getRuntPolarity();
                ServiceEnum.EdgeSlope timeoutSlope = triggerParam.getTimeoutSlope();
                ServiceEnum.EdgeSlope edgeSlopeB = triggerParam.getEdgeSlopeB();
                ServiceEnum.TriggerPulsePolarity videoPolarity = triggerParam.getVideoPolarity();
                overEvent = triggerParam.getOverEvent();
                edgeSlope7 = triggerParam.getNthSlope();
                edgeSlope8 = edgeSlopeB;
                triggerPulsePolarity3 = polarity;
                triggerPulsePolarity = videoPolarity;
                edgeSlope6 = edgeSlopeA;
                edgeSlope4 = overSlope;
                triggerPulsePolarity2 = runtPolarity;
                edgeSlope = edgeSlope9;
                sHEvent = sHEvent2;
                edgeSlope5 = setupHoldSlope;
                edgeSlope3 = timeoutSlope;
            }
            if ((j & 2253998836940770L) != 0) {
                ServiceEnum.TriggerMode triggerMode2 = triggerParam != null ? triggerParam.getTriggerMode() : null;
                if (i8 != 0) {
                    if (triggerParam != null) {
                        horizontalParam = horizontalParam2;
// Inform: пример получения иконки триггера (?)
                        i7 = triggerParam.getTriggerViewDisplay(triggerMode2, triggerPulsePolarity, triggerPulsePolarity2, sHEvent, edgeSlope, edgeSlope2, edgeSlope3, edgeSlope4, overEvent, edgeSlope5, edgeSlope7, triggerPulsePolarity3, edgeSlope6, edgeSlope8);
                    } else {
                        horizontalParam = horizontalParam2;
                        i7 = 0;
                    }
                    drawable5 = ContextUtil.getDrawable(getRoot().getContext(), i7);
                    triggerMode = triggerMode2;
                } else {
                    horizontalParam = horizontalParam2;
                    triggerMode = triggerMode2;
                    drawable5 = null;
                }
            } else {
                horizontalParam = horizontalParam2;
                triggerMode = null;
                drawable5 = null;
            }
            if ((j & 2253998836416546L) != 0) {
                if (triggerParam != null) {
                    ServiceEnum.Unit unit2 = triggerParam.getUnit();
                    long iiclevelB = triggerParam.getIiclevelB();
                    long slopelevelB = triggerParam.getSlopelevelB();
                    long milstdlevelA = triggerParam.getMilstdlevelA();
                    long iislevelC = triggerParam.getIislevelC();
                    long level = triggerParam.getLevel();
                    long delaylevelB = triggerParam.getDelaylevelB();
                    long spilevelA = triggerParam.getSpilevelA();
                    long iiclevelA = triggerParam.getIiclevelA();
                    long overlevelA = triggerParam.getOverlevelA();
                    long iislevelB = triggerParam.getIislevelB();
                    long delaylevelA = triggerParam.getDelaylevelA();
                    long spilevelB = triggerParam.getSpilevelB();
                    long runtlevelA = triggerParam.getRuntlevelA();
                    long overlevelB = triggerParam.getOverlevelB();
                    long setupHoldlevelA = triggerParam.getSetupHoldlevelA();
                    long iislevelA = triggerParam.getIislevelA();
                    long spilevelC = triggerParam.getSpilevelC();
                    long runtlevelB = triggerParam.getRuntlevelB();
                    long setupHoldlevelB = triggerParam.getSetupHoldlevelB();
                    long slopelevelA = triggerParam.getSlopelevelA();
                    unit = unit2;
                    j14 = triggerParam.getMilstdlevelB();
                    j26 = iislevelC;
                    j9 = runtlevelA;
                    j18 = setupHoldlevelB;
                    j24 = iislevelA;
                    j21 = spilevelA;
                    j12 = overlevelB;
                    j19 = iiclevelA;
                    j13 = milstdlevelA;
                    j8 = slopelevelB;
                    j7 = slopelevelA;
                    j25 = iislevelB;
                    j15 = delaylevelA;
                    j16 = delaylevelB;
                    j11 = overlevelA;
                    j10 = runtlevelB;
                    j23 = spilevelC;
                    j22 = spilevelB;
                    j17 = setupHoldlevelA;
                    j20 = iiclevelB;
                    j6 = level;
                } else {
                    j6 = 0;
                    j7 = 0;
                    j8 = 0;
                    j9 = 0;
                    j10 = 0;
                    j11 = 0;
                    j12 = 0;
                    j13 = 0;
                    j14 = 0;
                    j15 = 0;
                    j16 = 0;
                    j17 = 0;
                    j18 = 0;
                    j19 = 0;
                    j20 = 0;
                    j21 = 0;
                    j22 = 0;
                    j23 = 0;
                    j24 = 0;
                    j25 = 0;
                    j26 = 0;
                    unit = null;
                }
                if (triggerParam != null) {
                    str2 = triggerParam.getTriggerLevelShowStr(unit, triggerMode, j6, j7, j8, j9, j10, j11, j12, j13, j14, j15, j16, j17, j18, j19, j20, j21, j22, j23, j24, j25, j26);
                    if ((j & 2251799813685266L) != 0) {
                        ServiceEnum.Chan chan = triggerParam != null ? triggerParam.getChan() : null;
                        if (triggerParam != null) {
                            drawable = triggerParam.getChanColor(getRoot().getContext(), chan);
                            str3 = triggerParam.getChanValuesDisplay(chan);
                            if ((j & 2253998836940802L) != 0) {
                                int nMode = triggerParam != null ? triggerParam.getNMode() : 0;
                                if (triggerParam != null) {
                                    str = triggerParam.getTriggerModeDisplay(nMode);
                                    drawable2 = drawable5;
                                }
                            }
                            str = null;
                            drawable2 = drawable5;
                        }
                    }
                    str3 = null;
                    drawable = null;
                    if ((j & 2253998836940802L) != 0) {
                    }
                    str = null;
                    drawable2 = drawable5;
                }
            }
            str2 = null;
            if ((j & 2251799813685266L) != 0) {
            }
            str3 = null;
            drawable = null;
            if ((j & 2253998836940802L) != 0) {
            }
            str = null;
            drawable2 = drawable5;
        } else {
            horizontalParam = horizontalParam2;
            str = null;
            str2 = null;
            str3 = null;
            drawable = null;
            drawable2 = null;
        }
        if ((4499201580859405L & j) != 0) {
            if ((j & 2256197860196356L) != 0) {
                str10 = UnitFormat.newBuilder(UnitFormat.SI.FEMTO).convert(horizontalParam != null ? horizontalParam.getMainScale() : 0L, ServiceEnum.Unit.Unit_s) + '/';
            } else {
                str10 = null;
            }
            if ((j & 2260595906707460L) != 0) {
                str11 = UnitFormat.newBuilder("0.00").convert(horizontalParam != null ? horizontalParam.getSample() : 0L, ServiceEnum.Unit.Unit_SaS);
            } else {
                str11 = null;
            }
            if ((j & 2322168557862916L) != 0) {
                str12 = UnitFormat.newBuilder("0.00").convert(horizontalParam != null ? horizontalParam.getDepthValue() : 0L, ServiceEnum.Unit.Unit_Pts);
            } else {
                str12 = null;
            }
            if ((j & 2286984185774093L) != 0) {
                ServiceEnum.AcquireMode acquireMode = horizontalParam != null ? horizontalParam.getAcquireMode() : null;
                str13 = ((j & 2286984185774084L) == 0 || acquireMode == null) ? null : acquireMode.value2;
                MappingObject mappingObject = ViewUtil.getMappingObject(R.array.msg_acq_mode, acquireMode != null ? acquireMode.value1 : 0);
                updateRegistration(0, mappingObject);
                drawable3 = mappingObject != null ? mappingObject.getPic() : null;
            } else {
                drawable3 = null;
                str13 = null;
            }
            if ((j & 4222124650659844L) != 0) {
                ServiceEnum.HoriTimeMode timeMode = horizontalParam != null ? horizontalParam.getTimeMode() : null;
                int i9 = ((j & 3096224743817220L) > 0L ? 1 : ((j & 3096224743817220L) == 0L ? 0 : -1));
                if (i9 != 0) {
                    z8 = timeMode != ServiceEnum.HoriTimeMode.Horizontal_ROLL;
                    if (i9 != 0) {
                        j = z8 ? j | Long.MIN_VALUE : j | 4611686018427387904L;
                    }
                } else {
                    z8 = false;
                }
                z9 = timeMode == ServiceEnum.HoriTimeMode.Horizontal_ROLL;
                j2 = 0;
                if ((j & 2533274790395908L) != 0) {
                    j |= z9 ? 9007199254740992L : 4503599627370496L;
                }
                if ((j & 4222124650659844L) != 0) {
                    j = z9 ? j | LockFreeTaskQueueCore.CLOSED_MASK : j | LockFreeTaskQueueCore.FROZEN_MASK;
                }
                if ((j & 2533274790395908L) != 0 && z9) {
                    i3 = 4;
                    if ((j & 2392537302040580L) == j2) {
                        if (horizontalParam != null) {
                            z11 = z9;
                            z10 = z8;
                            str14 = str10;
                            j5 = horizontalParam.getDotTime();
                        } else {
                            z10 = z8;
                            z11 = z9;
                            str14 = str10;
                            j5 = 0;
                        }
                        str15 = str11;
                        str16 = UnitFormat.newBuilder(UnitFormat.PATTERN_SIGN, UnitFormat.SI.FEMTO).convert(j5, ServiceEnum.Unit.S_PT);
                    } else {
                        z10 = z8;
                        z11 = z9;
                        str14 = str10;
                        str15 = str11;
                        str16 = null;
                    }
                    i6 = ((j & 2269391999729668L) > 0L ? 1 : ((j & 2269391999729668L) == 0L ? 0 : -1));
                    if (i6 == 0) {
                        boolean sapmassa = horizontalParam != null ? horizontalParam.getSapmassa() : false;
                        if (i6 != 0) {
                            if (sapmassa) {
                                j3 = j | 144115188075855872L;
                                j4 = 576460752303423488L;
                            } else {
                                j3 = j | 72057594037927936L;
                                j4 = 288230376151711744L;
                            }
                            j = j3 | j4;
                        }
                        int i10 = sapmassa ? 4 : 0;
                        int i11 = sapmassa ? 0 : 4;
                        str8 = str13;
                        z2 = z11;
                        str4 = str14;
                        str5 = str15;
                        str6 = str16;
                        i = i10;
                        z = z10;
                        int i12 = i11;
                        str7 = str12;
                        i2 = i12;
                    } else {
                        str7 = str12;
                        str8 = str13;
                        z2 = z11;
                        z = z10;
                        str4 = str14;
                        str5 = str15;
                        i2 = 0;
                        str6 = str16;
                        i = 0;
                    }
                }
            } else {
                j2 = 0;
                z8 = false;
                z9 = false;
            }
            i3 = 0;
            if ((j & 2392537302040580L) == j2) {
            }
            i6 = ((j & 2269391999729668L) > 0L ? 1 : ((j & 2269391999729668L) == 0L ? 0 : -1));
            if (i6 == 0) {
            }
        } else {
            str4 = null;
            str5 = null;
            drawable3 = null;
            str6 = null;
            str7 = null;
            str8 = null;
            i = 0;
            z = false;
            i2 = 0;
            z2 = false;
            i3 = 0;
        }
        if ((j & 6917529027641081856L) != 0) {
            if (horizontalParam != null) {
                drawable4 = drawable3;
                controlAction = horizontalParam.getRunStop();
            } else {
                drawable4 = drawable3;
                controlAction = null;
            }
            if ((j & LockFreeTaskQueueCore.CLOSED_MASK) != 0) {
                i4 = i2;
                if (controlAction != ServiceEnum.ControlAction.Control_Stop) {
                    z7 = true;
                    if ((j & 4611686018427387904L) == 0) {
                        z4 = z7;
                        if (controlAction == ServiceEnum.ControlAction.Control_Stop) {
                            z3 = true;
                        }
                    } else {
                        z4 = z7;
                    }
                    z3 = false;
                }
            } else {
                i4 = i2;
            }
            z7 = false;
            if ((j & 4611686018427387904L) == 0) {
            }
            z3 = false;
        } else {
            i4 = i2;
            drawable4 = drawable3;
            z3 = false;
            z4 = false;
        }
        int i13 = ((j & 4222124650659844L) > 0L ? 1 : ((j & 4222124650659844L) == 0L ? 0 : -1));
        if (i13 != 0) {
            z5 = z2 ? z4 : false;
            if (i13 != 0) {
                j = z5 ? j | 36028797018963968L : j | 18014398509481984L;
            }
        } else {
            z5 = false;
        }
        int i14 = ((j & 3096224743817220L) > 0L ? 1 : ((j & 3096224743817220L) == 0L ? 0 : -1));
        if (i14 != 0) {
            z6 = z ? true : z3;
        } else {
            z6 = false;
        }
        int i15 = ((j & 4222124650659844L) > 0L ? 1 : ((j & 4222124650659844L) == 0L ? 0 : -1));
        String mainOffsetStr = i15 != 0 ? z5 ? " " : ((j & 18014398509481984L) == 0 || horizontalParam == null) ? null : horizontalParam.getMainOffsetStr() : null;
        if ((j & 2251799813685248L) != 0) {
            i5 = i;
            str9 = str5;
            this.acquireBtn.setOnClickListener(this.mCallback35);
            this.acquireInfo.setOnClickListener(this.mCallback36);
            this.horizontalOffsetBtn.setOnClickListener(this.mCallback37);
            this.horizontalOffsetInfo.setOnClickListener(this.mCallback38);
            this.horizontalScaleBtn.setOnClickListener(this.mCallback33);
            this.horizontalScaleInfo.setOnClickListener(this.mCallback34);
            this.triggerBtn.setOnClickListener(this.mCallback39);
            this.triggerInfo.setOnClickListener(this.mCallback40);
        } else {
            i5 = i;
            str9 = str5;
        }
        if ((j & 2251799813685266L) != 0) {
            ViewBindingAdapter.setBackground(this.appCompatTextView2, drawable);
            TextViewBindingAdapter.setText(this.appCompatTextView2, str3);
        }
        if ((j & 2533274790395908L) != 0) {
            this.appCompatTextView2.setVisibility(i3);
            this.appCompatTextView3.setVisibility(i3);
            this.appCompatTextView4.setVisibility(i3);
            this.imageView2.setVisibility(i3);
            this.triggerBtn.setEnabled(z);
            this.triggerInfo.setEnabled(z);
        }
        if ((j & 2253998836416546L) != 0) {
            TextViewBindingAdapter.setText(this.appCompatTextView3, str2);
        }
        if ((j & 2253998836940802L) != 0) {
            TextViewBindingAdapter.setText(this.appCompatTextView4, str);
        }
        if (i14 != 0) {
            this.horizontalOffsetBtn.setEnabled(z6);
            this.horizontalOffsetInfo.setEnabled(z6);
        }
        if (i15 != 0) {
            TextViewBindingAdapter.setText(this.horizontalOffsetInfo, mainOffsetStr);
        }
        if ((j & 2256197860196356L) != 0) {
            TextViewBindingAdapter.setText(this.horizontalScaleInfo, str4);
        }
        if ((j & 2251799814209506L) != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.imageView2, drawable2);
        }
        if ((j & 2260595906707460L) != 0) {
            TextViewBindingAdapter.setText(this.mboundView5, str9);
        }
        if ((2269391999729668L & j) != 0) {
            this.mboundView5.setVisibility(i5);
            this.mboundView6.setVisibility(i4);
        }
        if ((j & 2286984185774093L) != 0) {
            TextViewBindingAdapter.setDrawableStart(this.mboundView7, drawable4);
        }
        if ((2286984185774084L & j) != 0) {
            TextViewBindingAdapter.setText(this.mboundView7, str8);
        }
        if ((j & 2322168557862916L) != 0) {
            TextViewBindingAdapter.setText(this.mboundView8, str7);
        }
        if ((j & 2392537302040580L) != 0) {
            TextViewBindingAdapter.setText(this.mboundView9, str6);
        }
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
