package com.rigol.scope.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.CompoundButtonBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.rigol.scope.R;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.CursorResultParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.SharedParam;
import com.rigol.scope.generated.callback.OnClickListener;
import com.rigol.scope.utilities.ColorUtil;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.views.SwitchButton;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

/* loaded from: classes2.dex */
public class PopupviewResultCursorBindingImpl extends PopupviewResultCursorBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback58;
    private final View.OnClickListener mCallback59;
    private final View.OnClickListener mCallback60;
    private final View.OnClickListener mCallback61;
    private final View.OnClickListener mCallback62;
    private final View.OnClickListener mCallback63;
    private final View.OnClickListener mCallback64;
    private final View.OnClickListener mCallback65;
    private final View.OnClickListener mCallback66;
    private long mDirtyFlags;
    private long mDirtyFlags_1;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.guideline_center, 23);
        sViewsWithIds.put(R.id.guideline_left, 24);
        sViewsWithIds.put(R.id.guideline_right, 25);
        sViewsWithIds.put(R.id.mode, 26);
        sViewsWithIds.put(R.id.mode_radio_group, 27);
        sViewsWithIds.put(R.id.delete, 28);
        sViewsWithIds.put(R.id.delete_button, 29);
    }

    public PopupviewResultCursorBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 30, sIncludes, sViewsWithIds));
    }

    private PopupviewResultCursorBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 12, (TextView) objArr[16], (EditText) objArr[17], (TextView) objArr[4], (TextView) objArr[5], (TextView) objArr[8], (TextView) objArr[9], (TextView) objArr[18], (EditText) objArr[19], (TextView) objArr[10], (TextView) objArr[11], (TextView) objArr[14], (SwitchButton) objArr[15], (Button) objArr[22], (TextView) objArr[28], (Button) objArr[29], (Guideline) objArr[23], (Guideline) objArr[24], (Guideline) objArr[25], (RadioButton) objArr[1], (TextView) objArr[26], (RadioGroup) objArr[27], (TextView) objArr[6], (TextView) objArr[7], (RadioButton) objArr[2], (TextView) objArr[20], (TextView) objArr[21], (TextView) objArr[12], (SwitchButton) objArr[13], (RadioButton) objArr[3]);
        this.mDirtyFlags = -1L;
        this.mDirtyFlags_1 = -1L;
        this.aLocation.setTag(null);
        this.aLocationEditText.setTag(null);
        this.aSrc.setTag(null);
        this.aSrcSpinnermanual.setTag(null);
        this.aSrcSpinnertrack.setTag(null);
        this.aSrcSpinnerxy.setTag(null);
        this.bLocation.setTag(null);
        this.bLocationEditText.setTag(null);
        this.bSrc.setTag(null);
        this.bSrcSpinner.setTag(null);
        this.bothAb.setTag(null);
        this.bothAbSwitch.setTag(null);
        this.byLocationEditText.setTag(null);
        this.manualRadioButton.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.syncArea.setTag(null);
        this.syncAreaSpinner.setTag(null);
        this.trackRadioButton.setTag(null);
        this.unit.setTag(null);
        this.unitSpinner.setTag(null);
        this.xOrY.setTag(null);
        this.xOrYSwitch.setTag(null);
        this.xyRadioButton.setTag(null);
        setRootTag(view);
        this.mCallback65 = new OnClickListener(this, 8);
        this.mCallback64 = new OnClickListener(this, 7);
        this.mCallback66 = new OnClickListener(this, 9);
        this.mCallback59 = new OnClickListener(this, 2);
        this.mCallback62 = new OnClickListener(this, 5);
        this.mCallback63 = new OnClickListener(this, 6);
        this.mCallback60 = new OnClickListener(this, 3);
        this.mCallback58 = new OnClickListener(this, 1);
        this.mCallback61 = new OnClickListener(this, 4);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 34359738368L;
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
        if (1083 == i) {
            setXyMapping((MappingObject) obj);
        } else if (944 == i) {
            setTrackMapping((MappingObject) obj);
        } else if (569 == i) {
            setOnClickListener((View.OnClickListener) obj);
        } else if (823 == i) {
            setSharedParam((SharedParam) obj);
        } else if (206 == i) {
            setCursorParam((CursorResultParam) obj);
        } else if (517 != i) {
            return false;
        } else {
            setManualMapping((MappingObject) obj);
        }
        return true;
    }

    @Override // com.rigol.scope.databinding.PopupviewResultCursorBinding
    public void setXyMapping(MappingObject mappingObject) {
        updateRegistration(0, mappingObject);
        this.mXyMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(1083);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewResultCursorBinding
    public void setTrackMapping(MappingObject mappingObject) {
        updateRegistration(4, mappingObject);
        this.mTrackMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        notifyPropertyChanged(944);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewResultCursorBinding
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
        }
        notifyPropertyChanged(569);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewResultCursorBinding
    public void setSharedParam(SharedParam sharedParam) {
        updateRegistration(7, sharedParam);
        this.mSharedParam = sharedParam;
        synchronized (this) {
            this.mDirtyFlags |= 128;
        }
        notifyPropertyChanged(823);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewResultCursorBinding
    public void setCursorParam(CursorResultParam cursorResultParam) {
        updateRegistration(10, cursorResultParam);
        this.mCursorParam = cursorResultParam;
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
        }
        notifyPropertyChanged(206);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewResultCursorBinding
    public void setManualMapping(MappingObject mappingObject) {
        updateRegistration(11, mappingObject);
        this.mManualMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
        }
        notifyPropertyChanged(517);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return onChangeXyMapping((MappingObject) obj, i2);
            case 1:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgCursorTasrcCursorParamSourceAValue1((MappingObject) obj, i2);
            case 2:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgCursorXysrcViewUtilGetWindowXyIndexCursorParamSourceACursorParamSourceB((MappingObject) obj, i2);
            case 3:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgCursorTbsrcCursorParamSourceBValue1((MappingObject) obj, i2);
            case 4:
                return onChangeTrackMapping((MappingObject) obj, i2);
            case 5:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgCursorSyncAreaCursorParamSyncAreaValue1((MappingObject) obj, i2);
            case 6:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgCursorTimeunitCursorParamUnitValue1((MappingObject) obj, i2);
            case 7:
                return onChangeSharedParam((SharedParam) obj, i2);
            case 8:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgCursorManualsrcCursorParamSourceAValue1((MappingObject) obj, i2);
            case 9:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgCursorVunitCursorParamUnitValue1((MappingObject) obj, i2);
            case 10:
                return onChangeCursorParam((CursorResultParam) obj, i2);
            case 11:
                return onChangeManualMapping((MappingObject) obj, i2);
            default:
                return false;
        }
    }

    private boolean onChangeXyMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgCursorTasrcCursorParamSourceAValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
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

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgCursorXysrcViewUtilGetWindowXyIndexCursorParamSourceACursorParamSourceB(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
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

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgCursorTbsrcCursorParamSourceBValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
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

    private boolean onChangeTrackMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgCursorSyncAreaCursorParamSyncAreaValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgCursorTimeunitCursorParamUnitValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeSharedParam(SharedParam sharedParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
            }
            return true;
        } else if (i == 1085) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgCursorManualsrcCursorParamSourceAValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 256;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgCursorVunitCursorParamUnitValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 512;
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

    private boolean onChangeCursorParam(CursorResultParam cursorResultParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 205) {
            synchronized (this) {
                this.mDirtyFlags |= 8388608;
            }
            return true;
        } else if (i == 862) {
            synchronized (this) {
                this.mDirtyFlags |= 16777216;
            }
            return true;
        } else if (i == 919) {
            synchronized (this) {
                this.mDirtyFlags |= 33554432;
            }
            return true;
        } else if (i == 866) {
            synchronized (this) {
                this.mDirtyFlags |= 67108864;
            }
            return true;
        } else if (i == 1032) {
            synchronized (this) {
                this.mDirtyFlags |= 134217728;
            }
            return true;
        } else if (i == 120) {
            synchronized (this) {
                this.mDirtyFlags |= 268435456;
            }
            return true;
        } else if (i == 68) {
            synchronized (this) {
                this.mDirtyFlags |= 536870912;
            }
            return true;
        } else if (i == 70) {
            synchronized (this) {
                this.mDirtyFlags |= 1073741824;
            }
            return true;
        } else if (i == 130) {
            synchronized (this) {
                this.mDirtyFlags |= 2147483648L;
            }
            return true;
        } else if (i == 132) {
            synchronized (this) {
                this.mDirtyFlags |= 4294967296L;
            }
            return true;
        } else if (i == 987) {
            synchronized (this) {
                this.mDirtyFlags |= 8589934592L;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeManualMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 17179869184L;
            }
            return true;
        } else {
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:206:0x03cf  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x03dc  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x03e9  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x0425  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x049f  */
    /* JADX WARN: Removed duplicated region for block: B:289:0x062e  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void executeBindings() {
        long j;
        long j2;
        boolean z;
        float f;
        String str;
        long j3;
        String str2;
        boolean z2;
        float f2;
        String str3;
        ServiceEnum.CursorMode cursorMode;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        int i;
        int i2;
        boolean z3;
        boolean z4;
        int i3;
        boolean z5;
        boolean z6;
        int i4;
        boolean z7;
        boolean z8;
        int i5;
        boolean z9;
        int i6;
        boolean z10;
        String str12;
        String str13;
        boolean z11;
        String str14;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        String str15;
        String str16;
        String str17;
        String str18;
        String str19;
        int i7;
        String str20;
        String str21;
        String str22;
        String str23;
        String str24;
        long j4;
        long j5;
        ServiceEnum.Unit unit;
        long j6;
        String string;
        long j7;
        String str25;
        String str26;
        String str27;
        String str28;
        boolean z16;
        boolean z17;
        String str29;
        String str30;
        ServiceEnum.Chan chan;
        String str31;
        int i8;
        String str32;
        String str33;
        String str34;
        int i9;
        String str35;
        int i10;
        String str36;
        ServiceEnum.CursorMode cursorMode2;
        boolean z18;
        boolean z19;
        int i11;
        boolean z20;
        int i12;
        boolean z21;
        boolean z22;
        ServiceEnum.CursorMode cursorMode3;
        ServiceEnum.Chan chan2;
        String str37;
        String str38;
        int i13;
        String str39;
        long j8;
        long j9;
        ServiceEnum.Chan chan3;
        int i14;
        int i15;
        int i16;
        ServiceEnum.Chan chan4;
        int i17;
        ServiceEnum.Chan chan5;
        int i18;
        long j10;
        String string2;
        long j11;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
            j2 = this.mDirtyFlags_1;
            this.mDirtyFlags_1 = 0L;
        }
        MappingObject mappingObject = this.mXyMapping;
        MappingObject mappingObject2 = this.mTrackMapping;
        View.OnClickListener onClickListener = this.mOnClickListener;
        SharedParam sharedParam = this.mSharedParam;
        CursorResultParam cursorResultParam = this.mCursorParam;
        MappingObject mappingObject3 = this.mManualMapping;
        String str40 = ((j & 34359746561L) == 0 || mappingObject == null) ? null : mappingObject.getStr();
        String str41 = ((j & 34359869456L) == 0 || mappingObject2 == null) ? null : mappingObject2.getStr();
        if ((j & 34360787072L) != 0) {
            z = (sharedParam != null ? sharedParam.getXyWindowCount() : 0) > 0;
            f = ContextUtil.getAlpha(z);
        } else {
            z = false;
            f = 0.0f;
        }
        if ((j & 51538413422L) != 0) {
            if ((j & 51141674560L) != 0) {
                ServiceEnum.CursorView view = cursorResultParam != null ? cursorResultParam.getView() : null;
                boolean z23 = (j & 34493957120L) != 0 && view == ServiceEnum.CursorView.cursor_view_vert;
                z16 = view == ServiceEnum.CursorView.cursor_view_hori;
                if ((j & 40936408064L) != 0) {
                    j = z16 ? j | 8796093022208L : j | 4398046511104L;
                }
                if ((j & 34493957120L) != 0) {
                    if (z16) {
                        j = j | 140737488355328L | 2251799813685248L | 144115188075855872L;
                        j11 = 2;
                    } else {
                        j = j | 70368744177664L | 1125899906842624L | 72057594037927936L;
                        j11 = 1;
                    }
                    j2 |= j11;
                }
                if ((j & 36104569856L) != 0) {
                    j = z16 ? j | 36028797018963968L : j | 18014398509481984L;
                }
                if ((j & 43088610880L) != 0) {
                    j2 |= z16 ? 8L : 4L;
                }
                if ((j & 34493957120L) != 0) {
                    String string3 = z16 ? this.aLocation.getResources().getString(R.string.msg_cursor_tapos) : this.aLocation.getResources().getString(R.string.msg_cursor_vapos);
                    String string4 = this.bLocation.getResources().getString(z16 ? R.string.msg_cursor_tbpos : R.string.msg_cursor_vbpos);
                    if (z16) {
                        j10 = j;
                        string2 = this.unit.getResources().getString(R.string.msg_cursor_timeunit);
                    } else {
                        j10 = j;
                        string2 = this.unit.getResources().getString(R.string.msg_cursor_vunit);
                    }
                    String str42 = string3;
                    str25 = string2;
                    str26 = this.bothAb.getResources().getString(z16 ? R.string.msg_cursor_habpos : R.string.msg_cursor_vabpos);
                    j = j10;
                    z17 = z23;
                    j7 = j2;
                    str27 = str42;
                    str28 = string4;
                } else {
                    str25 = null;
                    str26 = null;
                    z17 = z23;
                    j7 = j2;
                    str27 = null;
                    str28 = null;
                }
            } else {
                j7 = j2;
                str25 = null;
                str26 = null;
                str27 = null;
                str28 = null;
                z16 = false;
                z17 = false;
            }
            if ((j & 34443723788L) != 0) {
                if (cursorResultParam != null) {
                    str29 = str25;
                    chan4 = cursorResultParam.getSourceB();
                } else {
                    str29 = str25;
                    chan4 = null;
                }
                if ((j & 34426848256L) != 0) {
                    str30 = str26;
                    i17 = ColorUtil.getColor(getRoot().getContext(), chan4);
                } else {
                    str30 = str26;
                    i17 = 0;
                }
                if ((j & 34426913800L) != 0) {
                    i8 = i17;
                    if (chan4 != null) {
                        i18 = chan4.value1;
                        chan5 = chan4;
                    } else {
                        chan5 = chan4;
                        i18 = 0;
                    }
                    MappingObject mappingObject4 = ViewUtil.getMappingObject(R.array.msg_cursor_tbsrc, i18);
                    updateRegistration(3, mappingObject4);
                    if (mappingObject4 != null) {
                        str31 = mappingObject4.getStr();
                        chan = chan5;
                    }
                } else {
                    chan5 = chan4;
                    i8 = i17;
                }
                str31 = null;
                chan = chan5;
            } else {
                str29 = str25;
                str30 = str26;
                chan = null;
                str31 = null;
                i8 = 0;
            }
            boolean isBothAB = ((j & 34628174848L) == 0 || cursorResultParam == null) ? false : cursorResultParam.isBothAB();
            if ((j & 34393556000L) != 0) {
                if (cursorResultParam != null) {
                    str32 = str31;
                    chan3 = cursorResultParam.getSyncArea();
                } else {
                    str32 = str31;
                    chan3 = null;
                }
                if ((j & 34393293824L) != 0) {
                    str33 = str27;
                    i14 = ColorUtil.getColor(getRoot().getContext(), chan3);
                } else {
                    str33 = str27;
                    i14 = 0;
                }
                if (chan3 != null) {
                    i16 = chan3.value1;
                    i15 = i14;
                } else {
                    i15 = i14;
                    i16 = 0;
                }
                MappingObject mappingObject5 = ViewUtil.getMappingObject(R.array.msg_cursor_sync_area, i16);
                updateRegistration(5, mappingObject5);
                str34 = mappingObject5 != null ? mappingObject5.getStr() : null;
                i9 = i15;
            } else {
                str32 = str31;
                str33 = str27;
                str34 = null;
                i9 = 0;
            }
            int i19 = ((j & 34368128000L) > 0L ? 1 : ((j & 34368128000L) == 0L ? 0 : -1));
            if (i19 != 0) {
                if (cursorResultParam != null) {
                    i10 = i9;
                    str35 = str34;
                    cursorMode2 = cursorResultParam.getCursorMode();
                } else {
                    str35 = str34;
                    i10 = i9;
                    cursorMode2 = null;
                }
                str36 = str28;
                z18 = cursorMode2 != ServiceEnum.CursorMode.cursor_mode_track;
                z8 = z16;
                z19 = cursorMode2 == ServiceEnum.CursorMode.cursor_mode_manual;
                z21 = cursorMode2 == ServiceEnum.CursorMode.cursor_mode_xy;
                z22 = cursorMode2 == ServiceEnum.CursorMode.cursor_mode_track;
                j3 = j7;
                boolean z24 = cursorMode2 == ServiceEnum.CursorMode.cursor_mode_track;
                z20 = cursorMode2 != ServiceEnum.CursorMode.cursor_mode_xy;
                if (i19 != 0) {
                    j |= z18 ? 562949953421312L : 281474976710656L;
                }
                if ((j & 34368128000L) != 0) {
                    if (z19) {
                        j8 = j | 137438953472L | 9007199254740992L;
                        j9 = 576460752303423488L;
                    } else {
                        j8 = j | 68719476736L | 4503599627370496L;
                        j9 = 288230376151711744L;
                    }
                    j = j8 | j9;
                }
                if ((j & 34368128000L) != 0) {
                    j |= z24 ? 2199023255552L : 1099511627776L;
                }
                if ((j & 34368128000L) != 0) {
                    j |= z20 ? 549755813888L : 274877906944L;
                }
                i3 = z19 ? 0 : 8;
                i11 = z24 ? 0 : 8;
                i12 = z20 ? 0 : 8;
            } else {
                str35 = str34;
                i10 = i9;
                str36 = str28;
                z8 = z16;
                j3 = j7;
                cursorMode2 = null;
                z18 = false;
                z19 = false;
                i11 = 0;
                z20 = false;
                i3 = 0;
                i12 = 0;
                z21 = false;
                z22 = false;
            }
            if ((j & 34445772038L) != 0) {
                if (cursorResultParam != null) {
                    cursorMode3 = cursorMode2;
                    chan2 = cursorResultParam.getSourceA();
                } else {
                    cursorMode3 = cursorMode2;
                    chan2 = null;
                }
                if ((j & 34443658244L) != 0) {
                    z9 = z18;
                    MappingObject mappingObject6 = ViewUtil.getMappingObject(R.array.msg_cursor_xysrc, ViewUtil.getWindowXyIndex(chan2, chan));
                    updateRegistration(2, mappingObject6);
                    if (mappingObject6 != null) {
                        str37 = mappingObject6.getStr();
                        int color = (j & 34376516608L) == 0 ? ColorUtil.getColor(getRoot().getContext(), chan2) : 0;
                        if ((j & 34378630402L) == 0) {
                            int i20 = chan2 != null ? chan2.value1 : 0;
                            if ((j & 34376532994L) != 0) {
                                str38 = str37;
                                MappingObject mappingObject7 = ViewUtil.getMappingObject(R.array.msg_cursor_tasrc, i20);
                                i13 = color;
                                updateRegistration(1, mappingObject7);
                                if (mappingObject7 != null) {
                                    str39 = mappingObject7.getStr();
                                    if ((j & 34378614016L) != 0) {
                                        MappingObject mappingObject8 = ViewUtil.getMappingObject(R.array.msg_cursor_manualsrc, i20);
                                        updateRegistration(8, mappingObject8);
                                        if (mappingObject8 != null) {
                                            z3 = z17;
                                            i6 = i8;
                                            z10 = isBothAB;
                                            str = str40;
                                            z6 = z19;
                                            i = i11;
                                            f2 = f;
                                            str4 = str30;
                                            z5 = z21;
                                            cursorMode = cursorMode3;
                                            i5 = i13;
                                            str2 = str41;
                                            str5 = str36;
                                            str10 = str39;
                                            i2 = i12;
                                            str7 = str35;
                                            str8 = str32;
                                            i4 = i10;
                                            str9 = str38;
                                            boolean z25 = z22;
                                            str11 = mappingObject8.getStr();
                                            str3 = str29;
                                            z2 = z;
                                            str6 = str33;
                                            z7 = z20;
                                            z4 = z25;
                                        }
                                    }
                                    z3 = z17;
                                    str3 = str29;
                                    i6 = i8;
                                    z10 = isBothAB;
                                    str = str40;
                                    z6 = z19;
                                    i = i11;
                                    z2 = z;
                                    f2 = f;
                                    str4 = str30;
                                    str6 = str33;
                                    z5 = z21;
                                    cursorMode = cursorMode3;
                                    i5 = i13;
                                    str2 = str41;
                                    z7 = z20;
                                    str5 = str36;
                                    z4 = z22;
                                    str10 = str39;
                                    str11 = null;
                                    i2 = i12;
                                    str7 = str35;
                                    str8 = str32;
                                    i4 = i10;
                                    str9 = str38;
                                }
                            } else {
                                str38 = str37;
                                i13 = color;
                            }
                            str39 = null;
                            if ((j & 34378614016L) != 0) {
                            }
                            z3 = z17;
                            str3 = str29;
                            i6 = i8;
                            z10 = isBothAB;
                            str = str40;
                            z6 = z19;
                            i = i11;
                            z2 = z;
                            f2 = f;
                            str4 = str30;
                            str6 = str33;
                            z5 = z21;
                            cursorMode = cursorMode3;
                            i5 = i13;
                            str2 = str41;
                            z7 = z20;
                            str5 = str36;
                            z4 = z22;
                            str10 = str39;
                            str11 = null;
                            i2 = i12;
                            str7 = str35;
                            str8 = str32;
                            i4 = i10;
                            str9 = str38;
                        } else {
                            String str43 = str37;
                            int i21 = color;
                            z3 = z17;
                            str3 = str29;
                            i6 = i8;
                            z10 = isBothAB;
                            i2 = i12;
                            str7 = str35;
                            str = str40;
                            z6 = z19;
                            i = i11;
                            z2 = z;
                            f2 = f;
                            str4 = str30;
                            str8 = str32;
                            str6 = str33;
                            i4 = i10;
                            z5 = z21;
                            cursorMode = cursorMode3;
                            str9 = str43;
                            i5 = i21;
                            str2 = str41;
                            z7 = z20;
                            str5 = str36;
                            z4 = z22;
                            str10 = null;
                        }
                    }
                } else {
                    z9 = z18;
                }
                str37 = null;
                if ((j & 34376516608L) == 0) {
                }
                if ((j & 34378630402L) == 0) {
                }
            } else {
                ServiceEnum.CursorMode cursorMode4 = cursorMode2;
                z9 = z18;
                z3 = z17;
                str3 = str29;
                i6 = i8;
                z10 = isBothAB;
                i2 = i12;
                str7 = str35;
                str = str40;
                z6 = z19;
                i = i11;
                z2 = z;
                f2 = f;
                str4 = str30;
                str8 = str32;
                str6 = str33;
                i4 = i10;
                z5 = z21;
                cursorMode = cursorMode4;
                str2 = str41;
                z7 = z20;
                str9 = null;
                i5 = 0;
                str5 = str36;
                z4 = z22;
                str10 = null;
            }
            str11 = str10;
        } else {
            str = str40;
            j3 = j2;
            str2 = str41;
            z2 = z;
            f2 = f;
            str3 = null;
            cursorMode = null;
            str4 = null;
            str5 = null;
            str6 = null;
            str7 = null;
            str8 = null;
            str9 = null;
            str10 = null;
            str11 = null;
            i = 0;
            i2 = 0;
            z3 = false;
            z4 = false;
            i3 = 0;
            z5 = false;
            z6 = false;
            i4 = 0;
            z7 = false;
            z8 = false;
            i5 = 0;
            z9 = false;
            i6 = 0;
            z10 = false;
        }
        String str44 = ((j & 51539609600L) == 0 || mappingObject3 == null) ? null : mappingObject3.getStr();
        String byStr = ((j & 4398046511104L) == 0 || cursorResultParam == null) ? null : cursorResultParam.getByStr();
        String axStr = ((j & 36028797018963968L) == 0 || cursorResultParam == null) ? null : cursorResultParam.getAxStr();
        if ((j & 292733975779082240L) != 0) {
            str12 = str44;
            boolean z26 = cursorMode == ServiceEnum.CursorMode.cursor_mode_xy;
            if ((j & 4503599627370496L) != 0) {
                j |= z26 ? LockFreeTaskQueueCore.CLOSED_MASK : LockFreeTaskQueueCore.FROZEN_MASK;
            }
            if ((j & 4503599627370496L) != 0) {
                if (z26) {
                    j6 = j;
                    string = this.aSrc.getResources().getString(R.string.msg_cursor_xysrc);
                } else {
                    j6 = j;
                    string = this.aSrc.getResources().getString(R.string.msg_cursor_tasrc);
                }
                z11 = z26;
                str13 = string;
                j = j6;
            } else {
                z11 = z26;
                str13 = null;
            }
        } else {
            str12 = str44;
            str13 = null;
            z11 = false;
        }
        int i22 = ((j & 34368128000L) > 0L ? 1 : ((j & 34368128000L) == 0L ? 0 : -1));
        if (i22 != 0) {
            if (!z9) {
                z7 = false;
            }
            str14 = str13;
            z12 = z7;
        } else {
            str14 = str13;
            z12 = false;
        }
        if ((j3 & 12) != 0) {
            if (cursorResultParam != null) {
                z13 = z11;
                unit = cursorResultParam.getUnit();
            } else {
                z13 = z11;
                unit = null;
            }
            int i23 = unit != null ? unit.value1 : 0;
            if ((j3 & 8) != 0) {
                z15 = z5;
                MappingObject mappingObject9 = ViewUtil.getMappingObject(R.array.msg_cursor_timeunit, i23);
                z14 = z4;
                updateRegistration(6, mappingObject9);
                if (mappingObject9 != null) {
                    str16 = mappingObject9.getStr();
                    if ((j3 & 4) != 0) {
                        MappingObject mappingObject10 = ViewUtil.getMappingObject(R.array.msg_cursor_vunit, i23);
                        updateRegistration(9, mappingObject10);
                        if (mappingObject10 != null) {
                            str15 = mappingObject10.getStr();
                        }
                    }
                    str15 = null;
                }
            } else {
                z14 = z4;
                z15 = z5;
            }
            str16 = null;
            if ((j3 & 4) != 0) {
            }
            str15 = null;
        } else {
            z13 = z11;
            z14 = z4;
            z15 = z5;
            str15 = null;
            str16 = null;
        }
        String ayStr = ((j & 18014398509481984L) == 0 || cursorResultParam == null) ? null : cursorResultParam.getAyStr();
        String bxStr = ((j & 8796093022208L) == 0 || cursorResultParam == null) ? null : cursorResultParam.getBxStr();
        if ((j & 40936408064L) != 0) {
            if (z8) {
                byStr = bxStr;
            }
            str17 = byStr;
        } else {
            str17 = null;
        }
        String str45 = str15;
        if (i22 != 0) {
            if (z6) {
                str18 = str16;
                str14 = this.aSrc.getResources().getString(R.string.msg_cursor_manualsrc);
            } else {
                str18 = str16;
            }
            boolean z27 = z6 ? true : z13;
            if (i22 != 0) {
                if (z27) {
                    j4 = j | 35184372088832L;
                    j5 = Long.MIN_VALUE;
                } else {
                    j4 = j | 17592186044416L;
                    j5 = 4611686018427387904L;
                }
                j = j4 | j5;
            }
            int i24 = z27 ? 8 : 0;
            str19 = this.xOrY.getResources().getString(z27 ? R.string.msg_cursor_type : R.string.msg_cursor_track_mode);
            i7 = i24;
            str20 = ayStr;
            str21 = str14;
        } else {
            str18 = str16;
            str19 = null;
            i7 = 0;
            str20 = ayStr;
            str21 = null;
        }
        int i25 = ((j & 36104569856L) > 0L ? 1 : ((j & 36104569856L) == 0L ? 0 : -1));
        if (i25 != 0) {
            if (!z8) {
                axStr = str20;
            }
            str22 = str17;
            str23 = axStr;
        } else {
            str22 = str17;
            str23 = null;
        }
        int i26 = ((j & 43088610880L) > 0L ? 1 : ((j & 43088610880L) == 0L ? 0 : -1));
        String str46 = i26 != 0 ? z8 ? str18 : str45 : null;
        if ((j & 34493957120L) != 0) {
            str24 = str19;
            TextViewBindingAdapter.setText(this.aLocation, str6);
            TextViewBindingAdapter.setText(this.bLocation, str5);
            TextViewBindingAdapter.setText(this.bothAb, str4);
            TextViewBindingAdapter.setText(this.unit, str3);
            CompoundButtonBindingAdapter.setChecked(this.xOrYSwitch, z3);
        } else {
            str24 = str19;
        }
        if ((34359738368L & j) != 0) {
            this.aLocationEditText.setOnClickListener(this.mCallback63);
            this.aSrcSpinnermanual.setOnClickListener(this.mCallback58);
            this.aSrcSpinnertrack.setOnClickListener(this.mCallback60);
            this.aSrcSpinnerxy.setOnClickListener(this.mCallback61);
            this.bLocationEditText.setOnClickListener(this.mCallback64);
            this.bSrcSpinner.setOnClickListener(this.mCallback62);
            this.byLocationEditText.setOnClickListener(this.mCallback66);
            this.syncArea.setVisibility(8);
            this.syncAreaSpinner.setOnClickListener(this.mCallback59);
            this.syncAreaSpinner.setVisibility(8);
            this.unitSpinner.setOnClickListener(this.mCallback65);
        }
        if (i25 != 0) {
            TextViewBindingAdapter.setText(this.aLocationEditText, str23);
        }
        if ((j & 34368128000L) != 0) {
            TextViewBindingAdapter.setText(this.aSrc, str21);
            this.aSrc.setVisibility(i2);
            this.aSrcSpinnermanual.setVisibility(i3);
            this.aSrcSpinnertrack.setVisibility(i);
            this.bSrc.setVisibility(i7);
            this.bSrcSpinner.setVisibility(i7);
            CompoundButtonBindingAdapter.setChecked(this.manualRadioButton, z12);
            CompoundButtonBindingAdapter.setChecked(this.trackRadioButton, z14);
            TextViewBindingAdapter.setText(this.xOrY, str24);
            CompoundButtonBindingAdapter.setChecked(this.xyRadioButton, z15);
        }
        if ((34378614016L & j) != 0) {
            TextViewBindingAdapter.setText(this.aSrcSpinnermanual, str11);
        }
        if ((34376516608L & j) != 0) {
            int i27 = i5;
            this.aSrcSpinnermanual.setTextColor(i27);
            this.aSrcSpinnertrack.setTextColor(i27);
        }
        if ((34376532994L & j) != 0) {
            TextViewBindingAdapter.setText(this.aSrcSpinnertrack, str10);
        }
        if ((34443658244L & j) != 0) {
            TextViewBindingAdapter.setText(this.aSrcSpinnerxy, str9);
        }
        if ((j & 40936408064L) != 0) {
            TextViewBindingAdapter.setText(this.bLocationEditText, str22);
        }
        if ((j & 34426913800L) != 0) {
            TextViewBindingAdapter.setText(this.bSrcSpinner, str8);
        }
        if ((j & 34426848256L) != 0) {
            this.bSrcSpinner.setTextColor(i6);
        }
        if ((j & 34628174848L) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.bothAbSwitch, z10);
        }
        if ((j & 51539609600L) != 0) {
            TextViewBindingAdapter.setText(this.manualRadioButton, str12);
        }
        if ((j & 34393556000L) != 0) {
            TextViewBindingAdapter.setText(this.syncAreaSpinner, str7);
        }
        if ((j & 34393293824L) != 0) {
            this.syncAreaSpinner.setTextColor(i4);
        }
        if ((j & 34359869456L) != 0) {
            TextViewBindingAdapter.setText(this.trackRadioButton, str2);
        }
        if (i26 != 0) {
            TextViewBindingAdapter.setText(this.unitSpinner, str46);
        }
        if ((j & 34360787072L) != 0) {
            if (getBuildSdkInt() >= 11) {
                this.xyRadioButton.setAlpha(f2);
            }
            this.xyRadioButton.setEnabled(z2);
        }
        if ((j & 34359746561L) != 0) {
            TextViewBindingAdapter.setText(this.xyRadioButton, str);
        }
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
            default:
                return;
        }
    }
}
