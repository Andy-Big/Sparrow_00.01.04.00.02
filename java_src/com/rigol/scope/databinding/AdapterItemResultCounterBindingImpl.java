package com.rigol.scope.databinding;

import android.graphics.drawable.Drawable;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.ImageViewBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.rigol.scope.R;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.CounterResultParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.utilities.ColorUtil;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.views.resultItem.ResultItemConstraintLayout;

/* loaded from: classes2.dex */
public class AdapterItemResultCounterBindingImpl extends AdapterItemResultCounterBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ResultItemConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.title_layout, 11);
        sViewsWithIds.put(R.id.result_layout, 12);
        sViewsWithIds.put(R.id.type_title, 13);
    }

    public AdapterItemResultCounterBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 14, sIncludes, sViewsWithIds));
    }

    private AdapterItemResultCounterBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (TextView) objArr[10], (TextView) objArr[9], (TextView) objArr[3], (ImageView) objArr[1], (TextView) objArr[6], (TextView) objArr[5], (TextView) objArr[8], (TextView) objArr[7], (ConstraintLayout) objArr[12], (TextView) objArr[2], (ConstraintLayout) objArr[11], (TextView) objArr[4], (TextView) objArr[13]);
        this.mDirtyFlags = -1L;
        this.avg.setTag(null);
        this.avgTitle.setTag(null);
        this.currentResult.setTag(null);
        this.icon.setTag(null);
        this.max.setTag(null);
        this.maxTitle.setTag(null);
        ResultItemConstraintLayout resultItemConstraintLayout = (ResultItemConstraintLayout) objArr[0];
        this.mboundView0 = resultItemConstraintLayout;
        resultItemConstraintLayout.setTag(null);
        this.min.setTag(null);
        this.minTitle.setTag(null);
        this.title.setTag(null);
        this.type.setTag(null);
        setRootTag(view);
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
        if (594 == i) {
            setParam((CounterResultParam) obj);
            return true;
        }
        return false;
    }

    @Override // com.rigol.scope.databinding.AdapterItemResultCounterBinding
    public void setParam(CounterResultParam counterResultParam) {
        updateRegistration(0, counterResultParam);
        this.mParam = counterResultParam;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(594);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            if (i != 1) {
                return false;
            }
            return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgCounter1MeasTypeParamCounterTypeValue1((MappingObject) obj, i2);
        }
        return onChangeParam((CounterResultParam) obj, i2);
    }

    private boolean onChangeParam(CounterResultParam counterResultParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i == 528) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else if (i == 939) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        } else if (i == 862) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        } else if (i == 1015) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        } else if (i == 192) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        } else if (i == 191) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
            }
            return true;
        } else if (i == 525) {
            synchronized (this) {
                this.mDirtyFlags |= 256;
            }
            return true;
        } else if (i == 542) {
            synchronized (this) {
                this.mDirtyFlags |= 512;
            }
            return true;
        } else if (i == 66) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgCounter1MeasTypeParamCounterTypeValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
            }
            return true;
        } else {
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:123:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0235  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0250  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x025e  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:173:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0126  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void executeBindings() {
        long j;
        boolean z;
        boolean z2;
        boolean z3;
        int i;
        String str;
        Drawable drawable;
        SpannableString spannableString;
        String str2;
        String str3;
        String str4;
        CharSequence charSequence;
        int i2;
        CharSequence charSequence2;
        int i3;
        int i4;
        String str5;
        ServiceEnum.Chan chan;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        CounterResultParam counterResultParam = this.mParam;
        int i5 = 0;
        if ((8191 & j) != 0) {
            str = ((j & 4353) == 0 || counterResultParam == null) ? null : counterResultParam.getMaxValue();
            String minValue = ((j & 4609) == 0 || counterResultParam == null) ? null : counterResultParam.getMinValue();
            int i6 = ((j & 4101) > 0L ? 1 : ((j & 4101) == 0L ? 0 : -1));
            if (i6 != 0) {
                ServiceEnum.MeasType measType = counterResultParam != null ? counterResultParam.getMeasType() : null;
                String str6 = measType != null ? measType.pic1 : null;
                z3 = measType != null;
                if (i6 != 0) {
                    j = z3 ? j | PlaybackStateCompat.ACTION_PREPARE : j | PlaybackStateCompat.ACTION_PLAY_FROM_URI;
                }
                drawable = ContextUtil.getDrawable(getRoot().getContext(), str6);
            } else {
                z3 = false;
                drawable = null;
            }
            int i7 = ((j & 4129) > 0L ? 1 : ((j & 4129) == 0L ? 0 : -1));
            if (i7 != 0) {
                z2 = TextUtils.isEmpty(counterResultParam != null ? counterResultParam.getValue() : null);
                if (i7 != 0) {
                    j = z2 ? j | PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH : j | PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
                }
            } else {
                z2 = false;
            }
            if ((j & 4121) != 0) {
                if (counterResultParam != null) {
                    str5 = counterResultParam.getTitle();
                    chan = counterResultParam.getSourceA();
                } else {
                    str5 = null;
                    chan = null;
                }
                i = (j & 4113) != 0 ? ColorUtil.getColor(getRoot().getContext(), chan) : 0;
                spannableString = ViewUtil.getTitleWithSrc(getRoot().getContext(), str5, chan);
            } else {
                i = 0;
                spannableString = null;
            }
            if ((6339 & j) != 0) {
                ServiceEnum.CounterType counterType = counterResultParam != null ? counterResultParam.getCounterType() : null;
                if ((j & 6211) != 0) {
                    MappingObject mappingObject = ViewUtil.getMappingObject(R.array.msg_counter_1_meas_type, counterType != null ? counterType.value1 : 0);
                    updateRegistration(1, mappingObject);
                    if (mappingObject != null) {
                        str2 = mappingObject.getStr();
                        i4 = ((j & 4289) > 0L ? 1 : ((j & 4289) == 0L ? 0 : -1));
                        if (i4 == 0) {
                            z = counterType != ServiceEnum.CounterType.TOTALIZE;
                            if (i4 != 0) {
                                j = z ? j | PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED : j | PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
                            }
                        } else {
                            z = false;
                        }
                    }
                }
                str2 = null;
                i4 = ((j & 4289) > 0L ? 1 : ((j & 4289) == 0L ? 0 : -1));
                if (i4 == 0) {
                }
            } else {
                z = false;
                str2 = null;
            }
            if ((j & 5121) == 0 || counterResultParam == null) {
                str4 = minValue;
                str3 = null;
            } else {
                str3 = counterResultParam.getAvgValue();
                str4 = minValue;
            }
        } else {
            z = false;
            z2 = false;
            z3 = false;
            i = 0;
            str = null;
            drawable = null;
            spannableString = null;
            str2 = null;
            str3 = null;
            str4 = null;
        }
        boolean isCounterSwitch = ((j & PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) == 0 || counterResultParam == null) ? false : counterResultParam.isCounterSwitch();
        boolean z4 = ((j & PlaybackStateCompat.ACTION_PREPARE) == 0 || drawable == null) ? false : true;
        if ((PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID & j) != 0) {
            charSequence = ContextUtil.getValueWithFont(getRoot().getContext(), R.font.digital_numbers, counterResultParam != null ? counterResultParam.getValue() : null);
        } else {
            charSequence = null;
        }
        int i8 = ((j & 4101) > 0L ? 1 : ((j & 4101) == 0L ? 0 : -1));
        if (i8 != 0) {
            if (!z3) {
                z4 = false;
            }
            if (i8 != 0) {
                j |= z4 ? 4194304L : PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
            }
            if (!z4) {
                i2 = 8;
                String str7 = charSequence;
                if ((j & 4129) == 0) {
                    if (z2) {
                        str7 = this.currentResult.getResources().getString(R.string.result_item_none_value);
                    }
                    charSequence2 = str7;
                } else {
                    charSequence2 = null;
                }
                i3 = ((j & 4289) > 0L ? 1 : ((j & 4289) == 0L ? 0 : -1));
                if (i3 != 0) {
                    if (!z) {
                        isCounterSwitch = false;
                    }
                    if (i3 != 0) {
                        j |= isCounterSwitch ? PlaybackStateCompat.ACTION_SET_REPEAT_MODE : PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
                    }
                    if (!isCounterSwitch) {
                        i5 = 8;
                    }
                }
                int i9 = i5;
                if ((5121 & j) != 0) {
                    TextViewBindingAdapter.setText(this.avg, str3);
                }
                if ((j & 4289) != 0) {
                    this.avg.setVisibility(i9);
                    this.avgTitle.setVisibility(i9);
                    this.max.setVisibility(i9);
                    this.maxTitle.setVisibility(i9);
                    this.min.setVisibility(i9);
                    this.minTitle.setVisibility(i9);
                }
                if ((j & 4129) != 0) {
                    TextViewBindingAdapter.setText(this.currentResult, charSequence2);
                }
                if ((4113 & j) != 0) {
                    this.currentResult.setTextColor(i);
                }
                if ((j & 4101) != 0) {
                    ImageViewBindingAdapter.setImageDrawable(this.icon, drawable);
                    this.icon.setVisibility(i2);
                }
                if ((j & 4353) != 0) {
                    TextViewBindingAdapter.setText(this.max, str);
                }
                if ((j & 4609) != 0) {
                    TextViewBindingAdapter.setText(this.min, str4);
                }
                if ((4121 & j) != 0) {
                    TextViewBindingAdapter.setText(this.title, spannableString);
                }
                if ((j & 6211) == 0) {
                    TextViewBindingAdapter.setText(this.type, str2);
                    return;
                }
                return;
            }
        }
        i2 = 0;
        String str72 = charSequence;
        if ((j & 4129) == 0) {
        }
        i3 = ((j & 4289) > 0L ? 1 : ((j & 4289) == 0L ? 0 : -1));
        if (i3 != 0) {
        }
        int i92 = i5;
        if ((5121 & j) != 0) {
        }
        if ((j & 4289) != 0) {
        }
        if ((j & 4129) != 0) {
        }
        if ((4113 & j) != 0) {
        }
        if ((j & 4101) != 0) {
        }
        if ((j & 4353) != 0) {
        }
        if ((j & 4609) != 0) {
        }
        if ((4121 & j) != 0) {
        }
        if ((j & 6211) == 0) {
        }
    }
}
