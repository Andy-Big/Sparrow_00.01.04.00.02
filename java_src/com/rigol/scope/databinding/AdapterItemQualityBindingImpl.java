package com.rigol.scope.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.rigol.scope.R;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.UpaParam;
import com.rigol.scope.utilities.ColorUtil;
import com.rigol.scope.utilities.UnitFormat;
import com.rigol.scope.utilities.ViewUtil;

/* loaded from: classes2.dex */
public class AdapterItemQualityBindingImpl extends AdapterItemQualityBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.right_guideline, 9);
        sViewsWithIds.put(R.id.left_guideline, 10);
        sViewsWithIds.put(R.id.left_guideline2, 11);
        sViewsWithIds.put(R.id.left_guideline3, 12);
        sViewsWithIds.put(R.id.left_guideline4, 13);
        sViewsWithIds.put(R.id.dividing_line1, 14);
        sViewsWithIds.put(R.id.upa_option, 15);
        sViewsWithIds.put(R.id.upa_, 16);
        sViewsWithIds.put(R.id.dividing_line2, 17);
        sViewsWithIds.put(R.id.upa_consult, 18);
        sViewsWithIds.put(R.id.upa_settype, 19);
        sViewsWithIds.put(R.id.upa_max_mun, 20);
        sViewsWithIds.put(R.id.dividing_line3, 21);
        sViewsWithIds.put(R.id.upa_record_mun, 22);
        sViewsWithIds.put(R.id.upa_current, 23);
        sViewsWithIds.put(R.id.upa_current_text, 24);
        sViewsWithIds.put(R.id.upa_middle_mun, 25);
        sViewsWithIds.put(R.id.upa_found_default, 26);
        sViewsWithIds.put(R.id.low_edit_text, 27);
        sViewsWithIds.put(R.id.upa_reccovery, 28);
        sViewsWithIds.put(R.id.upa_link_drawing, 29);
    }

    public AdapterItemQualityBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 30, sIncludes, sViewsWithIds));
    }

    private AdapterItemQualityBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 6, (View) objArr[14], (View) objArr[17], (View) objArr[21], (Guideline) objArr[10], (Guideline) objArr[11], (Guideline) objArr[12], (Guideline) objArr[13], (TextView) objArr[27], (Guideline) objArr[9], (TextView) objArr[16], (TextView) objArr[18], (TextView) objArr[23], (TextView) objArr[6], (TextView) objArr[5], (TextView) objArr[24], (EditText) objArr[8], (EditText) objArr[3], (Button) objArr[26], (Button) objArr[29], (TextView) objArr[20], (TextView) objArr[25], (EditText) objArr[7], (TextView) objArr[15], (TextView) objArr[1], (Button) objArr[28], (TextView) objArr[22], (EditText) objArr[4], (TextView) objArr[2], (TextView) objArr[19]);
        this.mDirtyFlags = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.upaCurrentSpinner.setTag(null);
        this.upaCurrentSpinner2.setTag(null);
        this.upaDownEdit.setTag(null);
        this.upaEditText.setTag(null);
        this.upaMiddleText.setTag(null);
        this.upaPassageway.setTag(null);
        this.upaRecordText.setTag(null);
        this.upaSetTypeSpinner.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
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
            setParam((UpaParam) obj);
        } else if (992 != i) {
            return false;
        } else {
            setUpaMappingObj((MappingObject) obj);
        }
        return true;
    }

    @Override // com.rigol.scope.databinding.AdapterItemQualityBinding
    public void setParam(UpaParam upaParam) {
        updateRegistration(3, upaParam);
        this.mParam = upaParam;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(594);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterItemQualityBinding
    public void setUpaMappingObj(MappingObject mappingObject) {
        this.mUpaMappingObj = mappingObject;
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
                            return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgUpaReflTypeParamRefPowerFref((MappingObject) obj, i2);
                        }
                        return onChangeUpaMappingObj((MappingObject) obj, i2);
                    }
                    return onChangeParam((UpaParam) obj, i2);
                }
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgUpaPowerFrefParamReflevel((MappingObject) obj, i2);
            }
            return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgUpaPowerVoltParamRefPowerVolt((MappingObject) obj, i2);
        }
        return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgUpaPowerCurrParamRefPowerCurr((MappingObject) obj, i2);
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgUpaPowerCurrParamRefPowerCurr(MappingObject mappingObject, int i) {
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

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgUpaPowerVoltParamRefPowerVolt(MappingObject mappingObject, int i) {
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

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgUpaPowerFrefParamReflevel(MappingObject mappingObject, int i) {
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

    private boolean onChangeParam(UpaParam upaParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        } else if (i == 729) {
            synchronized (this) {
                this.mDirtyFlags |= 512;
            }
            return true;
        } else if (i == 727) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 722) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
            }
            return true;
        } else if (i == 711) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
            }
            return true;
        } else if (i == 903) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            }
            return true;
        } else if (i == 733) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE;
            }
            return true;
        } else if (i == 724) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 721) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
            }
            return true;
        } else if (i == 713) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
            }
            return true;
        } else if (i == 720) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
            }
            return true;
        } else if (i == 712) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeUpaMappingObj(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgUpaReflTypeParamRefPowerFref(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
            }
            return true;
        } else {
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0156  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void executeBindings() {
        long j;
        String str;
        int i;
        String str2;
        int i2;
        String str3;
        String str4;
        String str5;
        boolean z;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        UpaParam upaParam = this.mParam;
        if ((4194287 & j) != 0) {
            if ((j & 2113804) != 0) {
                MappingObject mappingObject = ViewUtil.getMappingObject(R.array.msg_upa_power_fref, upaParam != null ? upaParam.getReflevel() : 0);
                updateRegistration(2, mappingObject);
                if (mappingObject != null) {
                    str = mappingObject.getStr();
                    if ((j & 2097802) == 0) {
                        int refPowerVolt = upaParam != null ? upaParam.getRefPowerVolt() : 0;
                        i2 = (j & 2097672) != 0 ? ColorUtil.getColor(getRoot().getContext(), ServiceEnum.getChanFromValue1(refPowerVolt)) : 0;
                        MappingObject mappingObject2 = ViewUtil.getMappingObject(R.array.msg_upa_power_volt, refPowerVolt);
                        updateRegistration(1, mappingObject2);
                        if (mappingObject2 != null) {
                            str2 = mappingObject2.getStr();
                            if ((j & 2129993) != 0) {
                                int refPowerCurr = upaParam != null ? upaParam.getRefPowerCurr() : 0;
                                MappingObject mappingObject3 = ViewUtil.getMappingObject(R.array.msg_upa_power_curr, refPowerCurr);
                                updateRegistration(0, mappingObject3);
                                str5 = mappingObject3 != null ? mappingObject3.getStr() : null;
                                i = (j & 2129928) != 0 ? ColorUtil.getColor(getRoot().getContext(), ServiceEnum.getChanFromValue1(refPowerCurr)) : 0;
                            } else {
                                i = 0;
                                str5 = null;
                            }
                            if ((j & 4135976) != 0) {
                                int refPowerFref = upaParam != null ? upaParam.getRefPowerFref() : 0;
                                if ((j & 3087368) != 0) {
                                    z = refPowerFref == 0;
                                    if ((j & 2294792) != 0) {
                                        j = z ? j | 8388608 : j | 4194304;
                                    }
                                    if ((j & 2104328) != 0) {
                                        j = z ? j | 33554432 : j | 16777216;
                                    }
                                    if ((j & 2884616) != 0) {
                                        j = z ? j | 134217728 : j | 67108864;
                                    }
                                } else {
                                    z = false;
                                }
                                if ((j & 3146792) != 0) {
                                    MappingObject mappingObject4 = ViewUtil.getMappingObject(R.array.msg_upa_refl_type, refPowerFref);
                                    updateRegistration(5, mappingObject4);
                                    if (mappingObject4 != null) {
                                        str3 = mappingObject4.getStr();
                                    }
                                }
                                str3 = null;
                            } else {
                                str3 = null;
                                z = false;
                            }
                            if ((j & 2105352) != 0) {
                                str4 = String.valueOf(upaParam != null ? upaParam.getStatCount() : 0);
                            } else {
                                str4 = null;
                            }
                        }
                    } else {
                        i2 = 0;
                    }
                    str2 = null;
                    if ((j & 2129993) != 0) {
                    }
                    if ((j & 4135976) != 0) {
                    }
                    if ((j & 2105352) != 0) {
                    }
                }
            }
            str = null;
            if ((j & 2097802) == 0) {
            }
            str2 = null;
            if ((j & 2129993) != 0) {
            }
            if ((j & 4135976) != 0) {
            }
            if ((j & 2105352) != 0) {
            }
        } else {
            str = null;
            i = 0;
            str2 = null;
            i2 = 0;
            str3 = null;
            str4 = null;
            str5 = null;
            z = false;
        }
        if ((j & 33554432) != 0) {
            str6 = String.valueOf(upaParam != null ? upaParam.getRefPctlHigh() : 0) + '%';
        } else {
            str6 = null;
        }
        if ((j & 4194304) != 0) {
            str7 = UnitFormat.newBuilder(UnitFormat.SI.NANO).convert(upaParam != null ? upaParam.getRefAbsMid() : 0L, ServiceEnum.Unit.Unit_V);
        } else {
            str7 = null;
        }
        if ((j & 8388608) != 0) {
            str8 = String.valueOf(upaParam != null ? upaParam.getRefPctMid() : 0) + '%';
        } else {
            str8 = null;
        }
        if ((j & 16777216) != 0) {
            str9 = str7;
            str10 = str8;
            str11 = UnitFormat.newBuilder(UnitFormat.SI.NANO).convert(upaParam != null ? upaParam.getRefAbsHigh() : 0L, ServiceEnum.Unit.Unit_V);
        } else {
            str9 = str7;
            str10 = str8;
            str11 = null;
        }
        if ((j & 134217728) != 0) {
            str12 = String.valueOf(upaParam != null ? upaParam.getRefPctLow() : 0) + '%';
        } else {
            str12 = null;
        }
        if ((j & 67108864) != 0) {
            str13 = str11;
            str14 = UnitFormat.newBuilder(UnitFormat.SI.NANO).convert(upaParam != null ? upaParam.getRefAbsLow() : 0L, ServiceEnum.Unit.Unit_V);
        } else {
            str13 = str11;
            str14 = null;
        }
        int i3 = ((2294792 & j) > 0L ? 1 : ((2294792 & j) == 0L ? 0 : -1));
        if (i3 != 0) {
            if (!z) {
                str10 = str9;
            }
            str15 = str10;
        } else {
            str15 = null;
        }
        int i4 = ((j & 2104328) > 0L ? 1 : ((j & 2104328) == 0L ? 0 : -1));
        if (i4 == 0) {
            str6 = null;
        } else if (!z) {
            str6 = str13;
        }
        int i5 = ((j & 2884616) > 0L ? 1 : ((j & 2884616) == 0L ? 0 : -1));
        if (i5 == 0) {
            str14 = null;
        } else if (z) {
            str14 = str12;
        }
        if ((j & 2129993) != 0) {
            TextViewBindingAdapter.setText(this.upaCurrentSpinner, str5);
        }
        if ((j & 2129928) != 0) {
            this.upaCurrentSpinner.setTextColor(i);
        }
        if ((j & 2113804) != 0) {
            TextViewBindingAdapter.setText(this.upaCurrentSpinner2, str);
        }
        if (i5 != 0) {
            TextViewBindingAdapter.setText(this.upaDownEdit, str14);
        }
        if (i4 != 0) {
            TextViewBindingAdapter.setText(this.upaEditText, str6);
        }
        if (i3 != 0) {
            TextViewBindingAdapter.setText(this.upaMiddleText, str15);
        }
        if ((j & 2097802) != 0) {
            TextViewBindingAdapter.setText(this.upaPassageway, str2);
        }
        if ((j & 2097672) != 0) {
            this.upaPassageway.setTextColor(i2);
        }
        if ((j & 2105352) != 0) {
            TextViewBindingAdapter.setText(this.upaRecordText, str4);
        }
        if ((j & 3146792) != 0) {
            TextViewBindingAdapter.setText(this.upaSetTypeSpinner, str3);
        }
    }
}
