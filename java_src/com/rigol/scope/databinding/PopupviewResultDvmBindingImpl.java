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
import com.rigol.scope.data.DvmResultParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.generated.callback.OnClickListener;
import com.rigol.scope.utilities.ColorUtil;
import com.rigol.scope.utilities.UnitFormat;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.views.SwitchButton;

/* loaded from: classes2.dex */
public class PopupviewResultDvmBindingImpl extends PopupviewResultDvmBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback1;
    private final View.OnClickListener mCallback2;
    private final View.OnClickListener mCallback3;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.guideline_center, 9);
        sViewsWithIds.put(R.id.guideline_left, 10);
        sViewsWithIds.put(R.id.guideline_right, 11);
        sViewsWithIds.put(R.id.source, 12);
        sViewsWithIds.put(R.id.mode, 13);
        sViewsWithIds.put(R.id.mode_radio_group, 14);
        sViewsWithIds.put(R.id.beeper, 15);
        sViewsWithIds.put(R.id.limit_type, 16);
        sViewsWithIds.put(R.id.upper, 17);
        sViewsWithIds.put(R.id.lower, 18);
        sViewsWithIds.put(R.id.delete, 19);
        sViewsWithIds.put(R.id.delete_button, 20);
    }

    public PopupviewResultDvmBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 21, sIncludes, sViewsWithIds));
    }

    private PopupviewResultDvmBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 5, (TextView) objArr[15], (SwitchButton) objArr[5], (TextView) objArr[19], (Button) objArr[20], (Guideline) objArr[9], (Guideline) objArr[10], (Guideline) objArr[11], (TextView) objArr[16], (SwitchButton) objArr[6], (TextView) objArr[18], (EditText) objArr[8], (TextView) objArr[13], (RadioButton) objArr[4], (RadioButton) objArr[2], (RadioButton) objArr[3], (RadioGroup) objArr[14], (TextView) objArr[12], (TextView) objArr[1], (TextView) objArr[17], (EditText) objArr[7]);
        this.mDirtyFlags = -1L;
        this.beeperSwitch.setTag(null);
        this.limitTypeSwitch.setTag(null);
        this.lowerEditText.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.modeAcDcRadioButton.setTag(null);
        this.modeAcRadioButton.setTag(null);
        this.modeDcRadioButton.setTag(null);
        this.sourceSpinner.setTag(null);
        this.upperEditText.setTag(null);
        setRootTag(view);
        this.mCallback2 = new OnClickListener(this, 2);
        this.mCallback1 = new OnClickListener(this, 1);
        this.mCallback3 = new OnClickListener(this, 3);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
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
        if (27 == i) {
            setAcdcMappingObject((MappingObject) obj);
        } else if (26 == i) {
            setAcMappingObject((MappingObject) obj);
        } else if (594 == i) {
            setParam((DvmResultParam) obj);
        } else if (569 == i) {
            setOnClickListener((View.OnClickListener) obj);
        } else if (223 != i) {
            return false;
        } else {
            setDcMappingObject((MappingObject) obj);
        }
        return true;
    }

    @Override // com.rigol.scope.databinding.PopupviewResultDvmBinding
    public void setAcdcMappingObject(MappingObject mappingObject) {
        updateRegistration(1, mappingObject);
        this.mAcdcMappingObject = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(27);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewResultDvmBinding
    public void setAcMappingObject(MappingObject mappingObject) {
        updateRegistration(2, mappingObject);
        this.mAcMappingObject = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(26);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewResultDvmBinding
    public void setParam(DvmResultParam dvmResultParam) {
        updateRegistration(3, dvmResultParam);
        this.mParam = dvmResultParam;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(594);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewResultDvmBinding
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        notifyPropertyChanged(569);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewResultDvmBinding
    public void setDcMappingObject(MappingObject mappingObject) {
        updateRegistration(4, mappingObject);
        this.mDcMappingObject = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        notifyPropertyChanged(223);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            return false;
                        }
                        return onChangeDcMappingObject((MappingObject) obj, i2);
                    }
                    return onChangeParam((DvmResultParam) obj, i2);
                }
                return onChangeAcMappingObject((MappingObject) obj, i2);
            }
            return onChangeAcdcMappingObject((MappingObject) obj, i2);
        }
        return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDvmSrcParamSourceAValue1((MappingObject) obj, i2);
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDvmSrcParamSourceAValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeAcdcMappingObject(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
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

    private boolean onChangeAcMappingObject(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
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

    private boolean onChangeParam(DvmResultParam dvmResultParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        } else if (i == 862) {
            synchronized (this) {
                this.mDirtyFlags |= 512;
            }
            return true;
        } else if (i == 252) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 88) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
            }
            return true;
        } else if (i == 488) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
            }
            return true;
        } else if (i == 489) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            }
            return true;
        } else if (i == 487) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeDcMappingObject(MappingObject mappingObject, int i) {
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

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0081, code lost:
        if ((r7 != null ? r7.getLimitType() : 0) == 1) goto L34;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:122:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0197  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void executeBindings() {
        long j;
        boolean z;
        int i;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        String str;
        String str2;
        String str3;
        int i2;
        int i3;
        boolean z6;
        boolean z7;
        boolean z8;
        int i4;
        String str4;
        String str5;
        String str6;
        long j2;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        MappingObject mappingObject = this.mAcdcMappingObject;
        MappingObject mappingObject2 = this.mAcMappingObject;
        DvmResultParam dvmResultParam = this.mParam;
        View.OnClickListener onClickListener = this.mOnClickListener;
        MappingObject mappingObject3 = this.mDcMappingObject;
        int i5 = ((65666 & j) > 0L ? 1 : ((65666 & j) == 0L ? 0 : -1));
        String str7 = (i5 == 0 || mappingObject == null) ? null : mappingObject.getStr();
        int i6 = ((65796 & j) > 0L ? 1 : ((65796 & j) == 0L ? 0 : -1));
        String str8 = (i6 == 0 || mappingObject2 == null) ? null : mappingObject2.getStr();
        if ((97865 & j) != 0) {
            z5 = true;
            if ((j & 66568) != 0) {
                ServiceEnum.DvmMode dvmMode = dvmResultParam != null ? dvmResultParam.getDvmMode() : null;
                z6 = dvmMode == ServiceEnum.DvmMode.DVM_AC_RMS;
                z4 = dvmMode == ServiceEnum.DvmMode.DVM_DC_RMS;
                z3 = dvmMode == ServiceEnum.DvmMode.DVM_DC;
            } else {
                z6 = false;
                z3 = false;
                z4 = false;
            }
            if ((j & 69640) != 0) {
            }
            z5 = false;
            if ((j & 81928) != 0) {
                z7 = z6;
                str = UnitFormat.newBuilder(UnitFormat.SI.NANO).convert(dvmResultParam != null ? dvmResultParam.getLimitLower() : 0L, ServiceEnum.Unit.Unit_V);
            } else {
                z7 = z6;
                str = null;
            }
            if ((j & 66121) != 0) {
                ServiceEnum.Chan sourceA = dvmResultParam != null ? dvmResultParam.getSourceA() : null;
                i4 = (j & 66056) != 0 ? ColorUtil.getColor(getRoot().getContext(), sourceA) : 0;
                MappingObject mappingObject4 = ViewUtil.getMappingObject(R.array.msg_dvm_src, sourceA != null ? sourceA.value1 : 0);
                z8 = false;
                updateRegistration(0, mappingObject4);
                if (mappingObject4 != null) {
                    str4 = mappingObject4.getStr();
                    if ((j & 67592) != 0 && dvmResultParam != null) {
                        z8 = dvmResultParam.isBeeper();
                    }
                    if ((j & 73736) == 0) {
                        if (dvmResultParam != null) {
                            long limitUpper = dvmResultParam.getLimitUpper();
                            str5 = str;
                            str6 = str4;
                            j2 = limitUpper;
                        } else {
                            str5 = str;
                            str6 = str4;
                            j2 = 0;
                        }
                        String str9 = str5;
                        int i7 = i4;
                        z2 = z8;
                        str2 = str6;
                        z = z7;
                        i = i7;
                        str3 = UnitFormat.newBuilder(UnitFormat.SI.NANO).convert(j2, ServiceEnum.Unit.Unit_V);
                        str = str9;
                        i2 = ((j & 98320) > 0L ? 1 : ((j & 98320) == 0L ? 0 : -1));
                        String str10 = (i2 != 0 || mappingObject3 == null) ? null : mappingObject3.getStr();
                        if ((j & 67592) == 0) {
                            i3 = i;
                            CompoundButtonBindingAdapter.setChecked(this.beeperSwitch, z2);
                        } else {
                            i3 = i;
                        }
                        if ((j & 69640) != 0) {
                            CompoundButtonBindingAdapter.setChecked(this.limitTypeSwitch, z5);
                        }
                        if ((j & PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) != 0) {
                            this.lowerEditText.setOnClickListener(this.mCallback3);
                            this.sourceSpinner.setOnClickListener(this.mCallback1);
                            this.upperEditText.setOnClickListener(this.mCallback2);
                        }
                        if ((j & 81928) != 0) {
                            TextViewBindingAdapter.setText(this.lowerEditText, str);
                        }
                        if ((j & 66568) != 0) {
                            CompoundButtonBindingAdapter.setChecked(this.modeAcDcRadioButton, z4);
                            CompoundButtonBindingAdapter.setChecked(this.modeAcRadioButton, z);
                            CompoundButtonBindingAdapter.setChecked(this.modeDcRadioButton, z3);
                        }
                        if (i5 != 0) {
                            TextViewBindingAdapter.setText(this.modeAcDcRadioButton, str7);
                        }
                        if (i6 != 0) {
                            TextViewBindingAdapter.setText(this.modeAcRadioButton, str8);
                        }
                        if (i2 != 0) {
                            TextViewBindingAdapter.setText(this.modeDcRadioButton, str10);
                        }
                        if ((j & 66121) != 0) {
                            TextViewBindingAdapter.setText(this.sourceSpinner, str2);
                        }
                        if ((66056 & j) != 0) {
                            this.sourceSpinner.setTextColor(i3);
                        }
                        if ((j & 73736) == 0) {
                            TextViewBindingAdapter.setText(this.upperEditText, str3);
                            return;
                        }
                        return;
                    }
                    int i8 = i4;
                    z2 = z8;
                    str2 = str4;
                    z = z7;
                    i = i8;
                }
            } else {
                z8 = false;
                i4 = 0;
            }
            str4 = null;
            if ((j & 67592) != 0) {
                z8 = dvmResultParam.isBeeper();
            }
            if ((j & 73736) == 0) {
            }
        } else {
            z = false;
            i = 0;
            z2 = false;
            z3 = false;
            z4 = false;
            z5 = false;
            str = null;
            str2 = null;
        }
        str3 = null;
        i2 = ((j & 98320) > 0L ? 1 : ((j & 98320) == 0L ? 0 : -1));
        if (i2 != 0) {
        }
        if ((j & 67592) == 0) {
        }
        if ((j & 69640) != 0) {
        }
        if ((j & PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) != 0) {
        }
        if ((j & 81928) != 0) {
        }
        if ((j & 66568) != 0) {
        }
        if (i5 != 0) {
        }
        if (i6 != 0) {
        }
        if (i2 != 0) {
        }
        if ((j & 66121) != 0) {
        }
        if ((66056 & j) != 0) {
        }
        if ((j & 73736) == 0) {
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
        } else if (i != 3) {
        } else {
            View.OnClickListener onClickListener3 = this.mOnClickListener;
            if (onClickListener3 != null) {
                onClickListener3.onClick(view);
            }
        }
    }
}
