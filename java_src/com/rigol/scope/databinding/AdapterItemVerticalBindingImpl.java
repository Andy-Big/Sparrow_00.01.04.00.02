package com.rigol.scope.databinding;

import android.graphics.drawable.Drawable;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.Converters;
import androidx.databinding.adapters.ImageViewBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.databinding.adapters.ViewBindingAdapter;
import com.rigol.scope.R;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.VerticalParam;
import com.rigol.scope.utilities.ColorUtil;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.UnitFormat;
import com.rigol.scope.utilities.ViewUtil;

/* loaded from: classes2.dex */
public class AdapterItemVerticalBindingImpl extends AdapterItemVerticalBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    public AdapterItemVerticalBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 9, sIncludes, sViewsWithIds));
    }

    private AdapterItemVerticalBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3, (ImageView) objArr[6], (TextView) objArr[7], (ImageView) objArr[4], (ImageView) objArr[5], (ImageView) objArr[8], (TextView) objArr[3], (TextView) objArr[2], (TextView) objArr[1]);
        this.mDirtyFlags = -1L;
        this.bandLimit.setTag(null);
        this.bandLimitText.setTag(null);
        this.coupling1.setTag(null);
        this.impedance.setTag(null);
        this.invert.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.position.setTag(null);
        this.scale.setTag(null);
        this.title.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = PlaybackStateCompat.ACTION_PLAY_FROM_URI;
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
            setParam((VerticalParam) obj);
            return true;
        }
        return false;
    }

    @Override // com.rigol.scope.databinding.AdapterItemVerticalBinding
    public void setParam(VerticalParam verticalParam) {
        updateRegistration(1, verticalParam);
        this.mParam = verticalParam;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(594);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    return false;
                }
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgChanBwlimitParamBandLimitValue1((MappingObject) obj, i2);
            }
            return onChangeParam((VerticalParam) obj, i2);
        }
        return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgChanCoupParamCouplingValue1((MappingObject) obj, i2);
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgChanCoupParamCouplingValue1(MappingObject mappingObject, int i) {
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

    private boolean onChangeParam(VerticalParam verticalParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        } else if (i == 909) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        } else if (i == 774) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        } else if (i == 987) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        } else if (i == 565) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
            }
            return true;
        } else if (i == 193) {
            synchronized (this) {
                this.mDirtyFlags |= 256;
            }
            return true;
        } else if (i == 431) {
            synchronized (this) {
                this.mDirtyFlags |= 512;
            }
            return true;
        } else if (i == 71) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 444) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgChanBwlimitParamBandLimitValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
            }
            return true;
        } else {
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:150:0x0236, code lost:
        if (r40 != false) goto L194;
     */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0288  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x02a6  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0309  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x033f  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0346  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0393  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x039d  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x03ad  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x03b9  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x03c4  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x03d0  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x03de  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x03ec  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x03fa  */
    /* JADX WARN: Removed duplicated region for block: B:227:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0103 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0111  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void executeBindings() {
        long j;
        String str;
        int i;
        String str2;
        String str3;
        int i2;
        int i3;
        int i4;
        int i5;
        Drawable drawable;
        int i6;
        boolean z;
        int i7;
        boolean z2;
        String str4;
        int i8;
        int i9;
        int i10;
        int i11;
        Drawable drawable2;
        int i12;
        String str5;
        Drawable drawable3;
        int i13;
        int i14;
        int i15;
        int i16;
        String str6;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        long j2;
        int i23;
        int i24;
        String str7;
        String str8;
        long j3;
        int i25;
        int i26;
        long j4;
        long j5;
        ServiceEnum.Bandwidth bandwidth;
        String str9;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        VerticalParam verticalParam = this.mParam;
        if ((16383 & j) != 0) {
            int i27 = 4;
            if ((j & 13318) != 0) {
                if (verticalParam != null) {
                    bandwidth = verticalParam.getBandLimit();
                    str9 = verticalParam.getUnitHz();
                } else {
                    bandwidth = null;
                    str9 = null;
                }
                int i28 = ((j & 9218) > 0L ? 1 : ((j & 9218) == 0L ? 0 : -1));
                if (i28 != 0) {
                    boolean z3 = bandwidth == ServiceEnum.Bandwidth.BW_OFF;
                    if (i28 != 0) {
                        j |= z3 ? PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED : PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
                    }
                    if (z3) {
                        i16 = 4;
                        MappingObject mappingObject = ViewUtil.getMappingObject(R.array.msg_chan_bwlimit, bandwidth == null ? bandwidth.value1 : 0);
                        updateRegistration(2, mappingObject);
                        str6 = (mappingObject == null ? mappingObject.getStr() : null) + str9;
                    }
                }
                i16 = 0;
                MappingObject mappingObject2 = ViewUtil.getMappingObject(R.array.msg_chan_bwlimit, bandwidth == null ? bandwidth.value1 : 0);
                updateRegistration(2, mappingObject2);
                if (mappingObject2 == null) {
                }
                str6 = (mappingObject2 == null ? mappingObject2.getStr() : null) + str9;
            } else {
                i16 = 0;
                str6 = null;
            }
            int i29 = ((j & 8706) > 0L ? 1 : ((j & 8706) == 0L ? 0 : -1));
            if (i29 != 0) {
                boolean z4 = (verticalParam != null ? verticalParam.getImpedance() : null) == ServiceEnum.Impedance.IMP_1M;
                if (i29 != 0) {
                    j |= z4 ? PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID : PlaybackStateCompat.ACTION_PREPARE;
                }
                if (z4) {
                    i17 = 4;
                    ServiceEnum.Unit unit = ((8418 & j) != 0 || verticalParam == null) ? null : verticalParam.getUnit();
                    if ((j & 8459) != 0) {
                        ServiceEnum.Coupling coupling = verticalParam != null ? verticalParam.getCoupling() : null;
                        MappingObject mappingObject3 = ViewUtil.getMappingObject(R.array.msg_chan_coup, coupling != null ? coupling.value1 : 0);
                        updateRegistration(0, mappingObject3);
                        Drawable pic = mappingObject3 != null ? mappingObject3.getPic() : null;
                        Drawable.ConstantState constantState = pic != null ? pic.getConstantState() : null;
                        Drawable newDrawable = constantState != null ? constantState.newDrawable() : null;
                        if (newDrawable != null) {
                            drawable = newDrawable.mutate();
                            String title = ((j & 8194) != 0 || verticalParam == null) ? null : verticalParam.getTitle();
                            i18 = ((j & 8210) > 0L ? 1 : ((j & 8210) == 0L ? 0 : -1));
                            if (i18 != 0) {
                                ServiceEnum.enChanStatus status = verticalParam != null ? verticalParam.getStatus() : null;
                                boolean z5 = status == ServiceEnum.enChanStatus.CHAN_OFF;
                                boolean z6 = status == ServiceEnum.enChanStatus.CHAN_ACTIVE;
                                boolean z7 = status == ServiceEnum.enChanStatus.CHAN_HIDE;
                                int color = ColorUtil.getColor(getRoot().getContext(), status);
                                if (i18 != 0) {
                                    if (z5) {
                                        j4 = j | PlaybackStateCompat.ACTION_PREPARE_FROM_URI | PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE | 134217728 | 536870912 | 2147483648L | 8589934592L;
                                        j5 = 137438953472L;
                                    } else {
                                        j4 = j | PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH | PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED | 67108864 | 268435456 | 1073741824 | 4294967296L;
                                        j5 = 68719476736L;
                                    }
                                    j = j4 | j5;
                                }
                                if ((j & 8210) != 0) {
                                    j = z6 ? j | 8388608 : j | 4194304;
                                }
                                if ((j & 8210) != 0) {
                                    j |= z7 ? 33554432L : 16777216L;
                                }
                                if (z5) {
                                    TextView textView = this.bandLimitText;
                                    i25 = R.color.gray_regent;
                                    i26 = getColorFromResource(textView, R.color.gray_regent);
                                } else {
                                    i25 = R.color.gray_regent;
                                    i26 = -1;
                                }
                                int colorFromResource = z5 ? getColorFromResource(this.position, i25) : -1;
                                long j6 = j;
                                int colorFromResource2 = z5 ? getColorFromResource(this.impedance, i25) : -1;
                                int colorFromResource3 = z5 ? getColorFromResource(this.bandLimit, i25) : -1;
                                i10 = colorFromResource2;
                                int colorFromResource4 = z5 ? getColorFromResource(this.invert, i25) : -1;
                                i19 = z7 ? 4 : 0;
                                i8 = colorFromResource4;
                                j2 = 10242;
                                z2 = z6;
                                z = z5;
                                i6 = colorFromResource;
                                i22 = color;
                                i21 = i26;
                                i20 = colorFromResource3;
                                j = j6;
                            } else {
                                i19 = 0;
                                i20 = 0;
                                i21 = 0;
                                i22 = 0;
                                i6 = 0;
                                z = false;
                                z2 = false;
                                i8 = 0;
                                j2 = 10242;
                                i10 = 0;
                            }
                            i23 = ((j & j2) > 0L ? 1 : ((j & j2) == 0L ? 0 : -1));
                            if (i23 != 0) {
                                boolean invert = verticalParam != null ? verticalParam.getInvert() : false;
                                if (i23 != 0) {
                                    j |= invert ? 34359738368L : 17179869184L;
                                }
                            }
                            i27 = 0;
                            if ((j & 8290) != 0) {
                                if (verticalParam != null) {
                                    i24 = i19;
                                    i9 = i20;
                                    j3 = verticalParam.getScale();
                                } else {
                                    i24 = i19;
                                    i9 = i20;
                                    j3 = 0;
                                }
                                str7 = str6;
                                str8 = UnitFormat.newBuilder(UnitFormat.SI.NANO).convert(j3, unit) + '/';
                            } else {
                                i24 = i19;
                                i9 = i20;
                                str7 = str6;
                                str8 = null;
                            }
                            if ((j & 8386) != 0) {
                                long j7 = j;
                                String convert = UnitFormat.newBuilder(UnitFormat.SI.NANO).convert(verticalParam != null ? verticalParam.getOffset() : 0L, unit);
                                str2 = str8;
                                i5 = i16;
                                i = i24;
                                str = convert;
                                i4 = i17;
                                j = j7;
                            } else {
                                str2 = str8;
                                i5 = i16;
                                i = i24;
                                str = null;
                                i4 = i17;
                            }
                            i3 = i22;
                            i2 = i21;
                            str3 = str7;
                            int i30 = i27;
                            str4 = title;
                            i7 = i30;
                        }
                    }
                    drawable = null;
                    if ((j & 8194) != 0) {
                    }
                    i18 = ((j & 8210) > 0L ? 1 : ((j & 8210) == 0L ? 0 : -1));
                    if (i18 != 0) {
                    }
                    i23 = ((j & j2) > 0L ? 1 : ((j & j2) == 0L ? 0 : -1));
                    if (i23 != 0) {
                    }
                    i27 = 0;
                    if ((j & 8290) != 0) {
                    }
                    if ((j & 8386) != 0) {
                    }
                    i3 = i22;
                    i2 = i21;
                    str3 = str7;
                    int i302 = i27;
                    str4 = title;
                    i7 = i302;
                }
            }
            i17 = 0;
            if ((8418 & j) != 0) {
            }
            if ((j & 8459) != 0) {
            }
            drawable = null;
            if ((j & 8194) != 0) {
            }
            i18 = ((j & 8210) > 0L ? 1 : ((j & 8210) == 0L ? 0 : -1));
            if (i18 != 0) {
            }
            i23 = ((j & j2) > 0L ? 1 : ((j & j2) == 0L ? 0 : -1));
            if (i23 != 0) {
            }
            i27 = 0;
            if ((j & 8290) != 0) {
            }
            if ((j & 8386) != 0) {
            }
            i3 = i22;
            i2 = i21;
            str3 = str7;
            int i3022 = i27;
            str4 = title;
            i7 = i3022;
        } else {
            str = null;
            i = 0;
            str2 = null;
            str3 = null;
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            drawable = null;
            i6 = 0;
            z = false;
            i7 = 0;
            z2 = false;
            str4 = null;
            i8 = 0;
            i9 = 0;
            i10 = 0;
        }
        String str10 = str2;
        if ((j & 68728913920L) != 0) {
            i11 = ColorUtil.getColor(getRoot().getContext(), verticalParam != null ? verticalParam.getServiceId() : 0);
            if ((j & 8388608) != 0) {
                drawable2 = ContextUtil.getSelectedBackground(R.drawable.bg_item_vertical, i11);
                i12 = ((j & 8210) > 0L ? 1 : ((j & 8210) == 0L ? 0 : -1));
                if (i12 == 0) {
                    int i31 = i11;
                    if (z) {
                        TextView textView2 = this.scale;
                        str5 = str;
                        i15 = R.color.gray_regent;
                        i11 = getColorFromResource(textView2, R.color.gray_regent);
                    } else {
                        str5 = str;
                        i15 = R.color.gray_regent;
                    }
                    Drawable drawable4 = z2 ? drawable2 : ContextUtil.getDrawable(R.drawable.bg_item_vertical);
                    if (z) {
                        i31 = ContextCompat.getColor(getRoot().getContext(), i15);
                    }
                    drawable3 = drawable4;
                    i13 = i31;
                } else {
                    str5 = str;
                    i11 = 0;
                    drawable3 = null;
                    i13 = 0;
                }
                if (i12 == 0) {
                    i14 = i7;
                    if (getBuildSdkInt() >= 21) {
                        this.bandLimit.setImageTintList(Converters.convertColorToColorStateList(i9));
                        this.coupling1.setImageTintList(Converters.convertColorToColorStateList(i3));
                        this.impedance.setImageTintList(Converters.convertColorToColorStateList(i10));
                        this.invert.setImageTintList(Converters.convertColorToColorStateList(i8));
                    }
                    this.bandLimitText.setTextColor(i2);
                    ViewBindingAdapter.setBackground(this.mboundView0, drawable3);
                    this.mboundView0.setVisibility(i);
                    this.position.setTextColor(i6);
                    this.scale.setTextColor(i11);
                    this.title.setTextColor(i13);
                } else {
                    i14 = i7;
                }
                if ((j & 9218) != 0) {
                    this.bandLimit.setVisibility(i5);
                    this.bandLimitText.setVisibility(i5);
                }
                if ((j & 13318) != 0) {
                    TextViewBindingAdapter.setText(this.bandLimitText, str3);
                }
                if ((8459 & j) != 0) {
                    ImageViewBindingAdapter.setImageDrawable(this.coupling1, drawable);
                }
                if ((j & 8706) != 0) {
                    this.impedance.setVisibility(i4);
                }
                if ((10242 & j) != 0) {
                    this.invert.setVisibility(i14);
                }
                if ((8386 & j) != 0) {
                    TextViewBindingAdapter.setText(this.position, str5);
                }
                if ((8290 & j) != 0) {
                    TextViewBindingAdapter.setText(this.scale, str10);
                }
                if ((j & 8194) == 0) {
                    TextViewBindingAdapter.setText(this.title, str4);
                    return;
                }
                return;
            }
        } else {
            i11 = 0;
        }
        drawable2 = null;
        i12 = ((j & 8210) > 0L ? 1 : ((j & 8210) == 0L ? 0 : -1));
        if (i12 == 0) {
        }
        if (i12 == 0) {
        }
        if ((j & 9218) != 0) {
        }
        if ((j & 13318) != 0) {
        }
        if ((8459 & j) != 0) {
        }
        if ((j & 8706) != 0) {
        }
        if ((10242 & j) != 0) {
        }
        if ((8386 & j) != 0) {
        }
        if ((8290 & j) != 0) {
        }
        if ((j & 8194) == 0) {
        }
    }
}
