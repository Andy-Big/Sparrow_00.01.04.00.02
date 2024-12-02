package com.rigol.scope.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.CompoundButtonBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.rigol.scope.R;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.HorizontalParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.NavigateParam;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.ViewUtil;

/* loaded from: classes2.dex */
public class PopupviewNavigateBindingImpl extends PopupviewNavigateBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.modeRadio, 23);
        sViewsWithIds.put(R.id.speedLinear, 24);
        sViewsWithIds.put(R.id.typeLinear, 25);
        sViewsWithIds.put(R.id.serchButton, 26);
        sViewsWithIds.put(R.id.frameLinear, 27);
        sViewsWithIds.put(R.id.currentFrameText, 28);
        sViewsWithIds.put(R.id.lineView, 29);
    }

    public PopupviewNavigateBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 30, sIncludes, sViewsWithIds));
    }

    private PopupviewNavigateBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 6, (TextView) objArr[28], (TextView) objArr[17], (RadioButton) objArr[3], (RelativeLayout) objArr[27], (RadioButton) objArr[4], (TextView) objArr[14], (TextView) objArr[13], (TextView) objArr[16], (View) objArr[29], (RadioGroup) objArr[23], (TextView) objArr[1], (ConstraintLayout) objArr[0], (ImageView) objArr[20], (ImageView) objArr[19], (ImageView) objArr[21], (ImageView) objArr[22], (ImageView) objArr[18], (Button) objArr[26], (LinearLayout) objArr[24], (TextView) objArr[6], (TextView) objArr[5], (TextView) objArr[12], (TextView) objArr[11], (RadioButton) objArr[2], (LinearLayout) objArr[25], (TextView) objArr[8], (TextView) objArr[7], (TextView) objArr[15], (TextView) objArr[10], (TextView) objArr[9]);
        this.mDirtyFlags = -1L;
        this.currentText.setTag(null);
        this.eventRadio.setTag(null);
        this.frameRadio.setTag(null);
        this.frameSpeedSpinner.setTag(null);
        this.frameSpeedText.setTag(null);
        this.frameText.setTag(null);
        this.modeText.setTag(null);
        this.navigateLayout.setTag(null);
        this.playImage.setTag(null);
        this.playLastImage.setTag(null);
        this.playNextImage.setTag(null);
        this.recordToEndImage.setTag(null);
        this.recordToStartImage.setTag(null);
        this.speedSpinner.setTag(null);
        this.speedText.setTag(null);
        this.startFrameEdit.setTag(null);
        this.startFrameText.setTag(null);
        this.timeRadio.setTag(null);
        this.typeSpinner.setTag(null);
        this.typeText.setTag(null);
        this.visibleFrameText.setTag(null);
        this.visibleSpinner.setTag(null);
        this.visibleText.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
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
            setParam((NavigateParam) obj);
        } else if (380 != i) {
            return false;
        } else {
            setHorizontal((HorizontalParam) obj);
        }
        return true;
    }

    @Override // com.rigol.scope.databinding.PopupviewNavigateBinding
    public void setParam(NavigateParam navigateParam) {
        updateRegistration(3, navigateParam);
        this.mParam = navigateParam;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(594);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewNavigateBinding
    public void setHorizontal(HorizontalParam horizontalParam) {
        updateRegistration(4, horizontalParam);
        this.mHorizontal = horizontalParam;
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        notifyPropertyChanged(380);
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
                            return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgNavigateTimeoffsetSpeedParamTimeSpeed((MappingObject) obj, i2);
                        }
                        return onChangeHorizontal((HorizontalParam) obj, i2);
                    }
                    return onChangeParam((NavigateParam) obj, i2);
                }
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgSearchTypeParamSerchType((MappingObject) obj, i2);
            }
            return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgNavigateFramedrawDisplaymodeParamFrameMode((MappingObject) obj, i2);
        }
        return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgNavigateTimeoffsetSpeedParamFrameSpeed((MappingObject) obj, i2);
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgNavigateTimeoffsetSpeedParamFrameSpeed(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgNavigateFramedrawDisplaymodeParamFrameMode(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgSearchTypeParamSerchType(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeParam(NavigateParam navigateParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        } else if (i == 556) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        } else if (i == 791) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
            }
            return true;
        } else if (i == 412) {
            synchronized (this) {
                this.mDirtyFlags |= 256;
            }
            return true;
        } else if (i == 937) {
            synchronized (this) {
                this.mDirtyFlags |= 512;
            }
            return true;
        } else if (i == 807) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 348) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
            }
            return true;
        } else if (i == 350) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
            }
            return true;
        } else if (i == 349) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            }
            return true;
        } else if (i == 347) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE;
            }
            return true;
        } else if (i == 197) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 524) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeHorizontal(HorizontalParam horizontalParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        } else if (i == 28) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgNavigateTimeoffsetSpeedParamTimeSpeed(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:122:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x028c  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x02b2  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x02c3  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x02f2  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0394  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x03bc  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x03c4  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x03c8  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x03d3  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x03f2  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0402  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x048d  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x049f  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x04a8  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x04b1  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x04ee  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x0517  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x052e  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x0537  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x053c  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x0545  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x054e  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x0556  */
    /* JADX WARN: Removed duplicated region for block: B:275:0x0564  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x0576  */
    /* JADX WARN: Removed duplicated region for block: B:283:0x05a2  */
    /* JADX WARN: Removed duplicated region for block: B:286:0x05ad  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x0614  */
    /* JADX WARN: Removed duplicated region for block: B:294:0x0621  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x0677  */
    /* JADX WARN: Removed duplicated region for block: B:301:0x0680  */
    /* JADX WARN: Removed duplicated region for block: B:307:0x06b8  */
    /* JADX WARN: Removed duplicated region for block: B:310:0x06c7  */
    /* JADX WARN: Removed duplicated region for block: B:313:0x06d4  */
    /* JADX WARN: Removed duplicated region for block: B:316:0x06e3  */
    /* JADX WARN: Removed duplicated region for block: B:323:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x014b  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void executeBindings() {
        long j;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        boolean z;
        boolean z2;
        int i;
        float f;
        int i2;
        int i3;
        boolean z3;
        int i4;
        int i5;
        int i6;
        int i7;
        boolean z4;
        float f2;
        String str8;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        int i8;
        int i9;
        float f3;
        float f4;
        boolean z10;
        int i10;
        boolean z11;
        int i11;
        int i12;
        int i13;
        float f5;
        int i14;
        boolean z12;
        int i15;
        int i16;
        int i17;
        boolean z13;
        String str9;
        boolean z14;
        boolean z15;
        int i18;
        boolean z16;
        int i19;
        float f6;
        int i20;
        int i21;
        int i22;
        int colorFromResource;
        int i23;
        int colorFromResource2;
        long j2;
        long j3;
        boolean z17;
        String str10;
        int i24;
        int i25;
        boolean z18;
        long j4;
        boolean z19;
        boolean z20;
        String str11;
        int i26;
        String str12;
        int i27;
        int i28;
        int i29;
        float f7;
        int i30;
        int i31;
        int i32;
        int i33;
        String str13;
        int i34;
        long j5;
        int i35;
        int colorFromResource3;
        int colorFromResource4;
        int colorFromResource5;
        long j6;
        long j7;
        long j8;
        long j9;
        int i36;
        int i37;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        NavigateParam navigateParam = this.mParam;
        HorizontalParam horizontalParam = this.mHorizontal;
        if ((524287 & j) != 0) {
            if ((j & 360456) != 0) {
                if (navigateParam != null) {
                    i36 = navigateParam.getCurrentPage();
                    i37 = navigateParam.getMaxPage();
                } else {
                    i36 = 0;
                    i37 = 0;
                }
                String valueOf = String.valueOf(i36);
                String str14 = valueOf + '/';
                str = str14 + String.valueOf(i37);
            } else {
                str = null;
            }
            if ((j & 263180) != 0) {
                MappingObject mappingObject = ViewUtil.getMappingObject(R.array.msg_search_type, navigateParam != null ? navigateParam.getSerchType() : 0);
                updateRegistration(2, mappingObject);
                if (mappingObject != null) {
                    str10 = mappingObject.getStr();
                    i24 = ((j & 393368) > 0L ? 1 : ((j & 393368) == 0L ? 0 : -1));
                    if (i24 == 0) {
                        i25 = navigateParam != null ? navigateParam.getSelectMode() : 0;
                        if ((j & 262280) != 0) {
                            z18 = 1 == i25;
                            if (i25 == 0) {
                                z19 = true;
                                z20 = 2 != i25;
                                if (i24 != 0) {
                                    j |= z20 ? 281474976710656L : 140737488355328L;
                                }
                                j4 = 264202;
                            }
                        } else {
                            z18 = false;
                        }
                        z19 = false;
                        if (2 != i25) {
                        }
                        if (i24 != 0) {
                        }
                        j4 = 264202;
                    } else {
                        i25 = 0;
                        z18 = false;
                        j4 = 264202;
                        z19 = false;
                        z20 = false;
                    }
                    if ((j & j4) == 0) {
                        i26 = navigateParam != null ? navigateParam.getFrameMode() : 0;
                        MappingObject mappingObject2 = ViewUtil.getMappingObject(R.array.msg_navigate_framedraw_displaymode, i26);
                        updateRegistration(1, mappingObject2);
                        str11 = mappingObject2 != null ? mappingObject2.getStr() : null;
                    } else {
                        str11 = null;
                        i26 = 0;
                    }
                    if ((j & 278536) == 0) {
                        str12 = String.valueOf(navigateParam != null ? navigateParam.getFrameDisplayFrame() : 0L);
                    } else {
                        str12 = null;
                    }
                    if ((j & 270345) != 0) {
                        MappingObject mappingObject3 = ViewUtil.getMappingObject(R.array.msg_navigate_timeoffset_speed, navigateParam != null ? navigateParam.getFrameSpeed() : 0);
                        updateRegistration(0, mappingObject3);
                        if (mappingObject3 != null) {
                            str2 = mappingObject3.getStr();
                            if ((j & 395738) != 0) {
                                z3 = navigateParam != null ? navigateParam.getNavEnable() : false;
                                if ((j & 262216) != 0) {
                                    if (z3) {
                                        j8 = j | PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED | 4194304 | 268435456 | 1099511627776L;
                                        j9 = 4398046511104L;
                                    } else {
                                        j8 = j | PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED | PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE | 134217728 | 549755813888L;
                                        j9 = 2199023255552L;
                                    }
                                    j = j8 | j9;
                                }
                                if ((j & 393304) != 0) {
                                    if (z3) {
                                        j6 = j | 67108864;
                                        j7 = 17179869184L;
                                    } else {
                                        j6 = j | 33554432;
                                        j7 = 8589934592L;
                                    }
                                    j = j6 | j7;
                                }
                                if ((j & 264394) != 0) {
                                    j = z3 ? j | 4294967296L : j | 2147483648L;
                                }
                                if ((j & 262472) != 0) {
                                    j = z3 ? j | 274877906944L : j | 137438953472L;
                                }
                                if ((j & 262216) != 0) {
                                    i27 = z3 ? getColorFromResource(this.frameSpeedText, R.color.white) : getColorFromResource(this.frameSpeedText, R.color.gray_regent);
                                    if (z3) {
                                        TextView textView = this.visibleText;
                                        j5 = j;
                                        i35 = R.color.white;
                                        colorFromResource3 = getColorFromResource(textView, R.color.white);
                                    } else {
                                        j5 = j;
                                        i35 = R.color.white;
                                        colorFromResource3 = getColorFromResource(this.visibleText, R.color.gray_regent);
                                    }
                                    TextView textView2 = this.modeText;
                                    i28 = z3 ? getColorFromResource(textView2, i35) : getColorFromResource(textView2, R.color.gray_regent);
                                    f7 = ContextUtil.getAlpha(z3);
                                    if (z3) {
                                        i30 = colorFromResource3;
                                        colorFromResource4 = getColorFromResource(this.frameSpeedSpinner, R.color.white);
                                    } else {
                                        i30 = colorFromResource3;
                                        colorFromResource4 = getColorFromResource(this.frameSpeedSpinner, R.color.gray_regent);
                                    }
                                    if (z3) {
                                        i31 = colorFromResource4;
                                        colorFromResource5 = getColorFromResource(this.typeText, R.color.white);
                                    } else {
                                        i31 = colorFromResource4;
                                        colorFromResource5 = getColorFromResource(this.typeText, R.color.gray_regent);
                                    }
                                    long j10 = j5;
                                    i29 = colorFromResource5;
                                    j = j10;
                                    if ((j & 262696) == 0) {
                                        if (navigateParam != null) {
                                            i33 = i28;
                                            i32 = i27;
                                            i34 = navigateParam.getTimeSpeed();
                                        } else {
                                            i32 = i27;
                                            i33 = i28;
                                            i34 = 0;
                                        }
                                        MappingObject mappingObject4 = ViewUtil.getMappingObject(R.array.msg_navigate_timeoffset_speed, i34);
                                        updateRegistration(5, mappingObject4);
                                        if (mappingObject4 != null) {
                                            str13 = mappingObject4.getStr();
                                            if ((j & 266248) != 0) {
                                                int i38 = i30;
                                                str6 = str13;
                                                z = z19;
                                                i6 = i26;
                                                i3 = i33;
                                                str7 = str12;
                                                f = f7;
                                                str5 = String.valueOf(navigateParam != null ? navigateParam.getFrameStartFrame() : 0L);
                                                z2 = z18;
                                                i5 = i32;
                                                i7 = i25;
                                                i4 = i31;
                                                z4 = z20;
                                                str3 = str11;
                                                i = i29;
                                                str4 = str10;
                                                i2 = i38;
                                            } else {
                                                z2 = z18;
                                                i5 = i32;
                                                i7 = i25;
                                                i4 = i31;
                                                z4 = z20;
                                                str3 = str11;
                                                i = i29;
                                                str4 = str10;
                                                i2 = i30;
                                                str6 = str13;
                                                z = z19;
                                                i6 = i26;
                                                i3 = i33;
                                                str7 = str12;
                                                f = f7;
                                                str5 = null;
                                            }
                                        }
                                    } else {
                                        i32 = i27;
                                        i33 = i28;
                                    }
                                    str13 = null;
                                    if ((j & 266248) != 0) {
                                    }
                                } else {
                                    i27 = 0;
                                    i28 = 0;
                                }
                            } else {
                                i27 = 0;
                                i28 = 0;
                                z3 = false;
                            }
                            i29 = 0;
                            f7 = 0.0f;
                            i30 = 0;
                            i31 = 0;
                            if ((j & 262696) == 0) {
                            }
                            str13 = null;
                            if ((j & 266248) != 0) {
                            }
                        }
                    }
                    str2 = null;
                    if ((j & 395738) != 0) {
                    }
                    i29 = 0;
                    f7 = 0.0f;
                    i30 = 0;
                    i31 = 0;
                    if ((j & 262696) == 0) {
                    }
                    str13 = null;
                    if ((j & 266248) != 0) {
                    }
                }
            }
            str10 = null;
            i24 = ((j & 393368) > 0L ? 1 : ((j & 393368) == 0L ? 0 : -1));
            if (i24 == 0) {
            }
            if ((j & j4) == 0) {
            }
            if ((j & 278536) == 0) {
            }
            if ((j & 270345) != 0) {
            }
            str2 = null;
            if ((j & 395738) != 0) {
            }
            i29 = 0;
            f7 = 0.0f;
            i30 = 0;
            i31 = 0;
            if ((j & 262696) == 0) {
            }
            str13 = null;
            if ((j & 266248) != 0) {
            }
        } else {
            str = null;
            str2 = null;
            str3 = null;
            str4 = null;
            str5 = null;
            str6 = null;
            str7 = null;
            z = false;
            z2 = false;
            i = 0;
            f = 0.0f;
            i2 = 0;
            i3 = 0;
            z3 = false;
            i4 = 0;
            i5 = 0;
            i6 = 0;
            i7 = 0;
            z4 = false;
        }
        if ((j & 279172874240L) != 0) {
            int i39 = ((j & 4294967296L) > 0L ? 1 : ((j & 4294967296L) == 0L ? 0 : -1));
            if (i39 != 0) {
                if (navigateParam != null) {
                    i7 = navigateParam.getSelectMode();
                }
                f2 = f;
                str8 = str2;
                z5 = i7 != 2;
                if (i39 != 0) {
                    j = z5 ? j | 68719476736L : j | 34359738368L;
                }
            } else {
                f2 = f;
                str8 = str2;
                z5 = false;
            }
            if ((j & 274877906944L) != 0) {
                z6 = !(navigateParam != null ? navigateParam.getIfPlaying() : false);
                if ((j & 140754735333376L) == 0) {
                    ServiceEnum.AcquireMode acquireMode = horizontalParam != null ? horizontalParam.getAcquireMode() : null;
                    if ((j & 140754668224512L) != 0) {
                        z7 = z6;
                        if (acquireMode == ServiceEnum.AcquireMode.Acquire_Ultra) {
                            z17 = true;
                            if ((j & 67108864) == 0) {
                                z9 = z17;
                                if (acquireMode != ServiceEnum.AcquireMode.Acquire_Ultra) {
                                    z8 = true;
                                }
                            } else {
                                z9 = z17;
                            }
                            z8 = false;
                        }
                    } else {
                        z7 = z6;
                    }
                    z17 = false;
                    if ((j & 67108864) == 0) {
                    }
                    z8 = false;
                } else {
                    z7 = z6;
                    z8 = false;
                    z9 = false;
                }
                if ((j & 393304) == 0) {
                    if (!z3) {
                        z8 = false;
                    }
                    z10 = z3 ? z9 : false;
                    float alpha = ContextUtil.getAlpha(z8);
                    i8 = i;
                    f3 = ContextUtil.getAlpha(z10);
                    i9 = i2;
                    f4 = alpha;
                } else {
                    i8 = i;
                    i9 = i2;
                    z8 = false;
                    f3 = 0.0f;
                    f4 = 0.0f;
                    z10 = false;
                }
                i10 = ((j & 262472) > 0L ? 1 : ((j & 262472) == 0L ? 0 : -1));
                if (i10 == 0) {
                    if (!z3) {
                        z7 = false;
                    }
                    if (i10 != 0) {
                        if (z7) {
                            j2 = j | 16777216 | 17592186044416L;
                            j3 = 1125899906842624L;
                        } else {
                            j2 = j | 8388608 | 8796093022208L;
                            j3 = 562949953421312L;
                        }
                        j = j2 | j3;
                    }
                    long j11 = j;
                    int colorFromResource6 = z7 ? getColorFromResource(this.startFrameText, R.color.white) : getColorFromResource(this.startFrameText, R.color.gray_regent);
                    if (z7) {
                        i21 = colorFromResource6;
                        colorFromResource = getColorFromResource(this.speedText, R.color.white);
                        i22 = R.color.gray_regent;
                    } else {
                        i21 = colorFromResource6;
                        TextView textView3 = this.speedText;
                        i22 = R.color.gray_regent;
                        colorFromResource = getColorFromResource(textView3, R.color.gray_regent);
                    }
                    float alpha2 = ContextUtil.getAlpha(z7);
                    if (z7) {
                        i23 = colorFromResource;
                        colorFromResource2 = getColorFromResource(this.visibleFrameText, R.color.white);
                    } else {
                        i23 = colorFromResource;
                        colorFromResource2 = getColorFromResource(this.visibleFrameText, i22);
                    }
                    i13 = colorFromResource2;
                    z11 = z7;
                    f5 = alpha2;
                    i12 = i21;
                    i11 = i23;
                    j = j11;
                } else {
                    z11 = false;
                    i11 = 0;
                    i12 = 0;
                    i13 = 0;
                    f5 = 0.0f;
                }
                if ((j & 393368) == 0) {
                    if (z4) {
                        z9 = true;
                    }
                    i14 = i3;
                    z12 = z9;
                } else {
                    i14 = i3;
                    z12 = false;
                }
                i15 = ((j & 34359738368L) > 0L ? 1 : ((j & 34359738368L) == 0L ? 0 : -1));
                if (i15 == 0) {
                    if (navigateParam != null) {
                        i20 = navigateParam.getFrameMode();
                        i17 = i5;
                    } else {
                        i17 = i5;
                        i20 = i6;
                    }
                    MappingObject mappingObject5 = ViewUtil.getMappingObject(R.array.msg_navigate_framedraw_displaymode, i20);
                    updateRegistration(1, mappingObject5);
                    str9 = mappingObject5 != null ? mappingObject5.getV() : null;
                    i16 = i4;
                    z13 = str9 != null ? str9.equals(String.valueOf(0)) : false;
                    if (i15 != 0) {
                        j |= z13 ? 1073741824L : 536870912L;
                    }
                } else {
                    i16 = i4;
                    i17 = i5;
                    z13 = false;
                    str9 = null;
                }
                if ((j & 536870912) != 0 || str9 == null) {
                    z14 = true;
                    z15 = false;
                } else {
                    z14 = true;
                    z15 = str9.equals(String.valueOf(1));
                }
                i18 = ((j & 34359738368L) > 0L ? 1 : ((j & 34359738368L) == 0L ? 0 : -1));
                if (i18 == 0) {
                    if (z13) {
                        z15 = z14;
                    }
                    if (i18 != 0) {
                        j |= z15 ? 70368744177664L : 35184372088832L;
                    }
                    z16 = z14;
                } else {
                    z16 = false;
                }
                if ((j & 4294967296L) != 0) {
                    z16 = false;
                } else if (z5) {
                    z16 = z14;
                }
                i19 = ((264394 & j) > 0L ? 1 : ((264394 & j) == 0L ? 0 : -1));
                if (i19 == 0) {
                    if (!z3) {
                        z16 = false;
                    }
                    f6 = ContextUtil.getAlpha(z16);
                } else {
                    z16 = false;
                    f6 = 0.0f;
                }
                if ((j & 360456) != 0) {
                    TextViewBindingAdapter.setText(this.currentText, str);
                }
                if ((j & 262280) != 0) {
                    CompoundButtonBindingAdapter.setChecked(this.eventRadio, z2);
                    CompoundButtonBindingAdapter.setChecked(this.timeRadio, z);
                }
                if ((j & 393304) != 0) {
                    this.eventRadio.setEnabled(z8);
                    this.frameRadio.setEnabled(z10);
                    this.timeRadio.setEnabled(z8);
                    if (getBuildSdkInt() >= 11) {
                        this.eventRadio.setAlpha(f4);
                        this.frameRadio.setAlpha(f3);
                        this.timeRadio.setAlpha(f4);
                    }
                }
                if ((j & 393368) != 0) {
                    CompoundButtonBindingAdapter.setChecked(this.frameRadio, z12);
                }
                if ((j & 262216) != 0) {
                    this.frameSpeedSpinner.setClickable(z3);
                    this.frameSpeedSpinner.setEnabled(z3);
                    this.frameSpeedSpinner.setTextColor(i16);
                    this.frameSpeedText.setTextColor(i17);
                    this.modeText.setTextColor(i14);
                    this.playImage.setEnabled(z3);
                    this.typeSpinner.setClickable(z3);
                    this.typeSpinner.setEnabled(z3);
                    this.typeText.setTextColor(i8);
                    this.visibleSpinner.setClickable(z3);
                    this.visibleSpinner.setEnabled(z3);
                    this.visibleText.setTextColor(i9);
                    if (getBuildSdkInt() >= 11) {
                        float f8 = f2;
                        this.playImage.setAlpha(f8);
                        this.typeSpinner.setAlpha(f8);
                        this.visibleSpinner.setAlpha(f8);
                    }
                }
                if ((270345 & j) != 0) {
                    TextViewBindingAdapter.setText(this.frameSpeedSpinner, str8);
                }
                if ((j & 262472) != 0) {
                    boolean z21 = z11;
                    this.frameText.setClickable(z21);
                    this.frameText.setEnabled(z21);
                    this.speedSpinner.setClickable(z21);
                    this.speedSpinner.setEnabled(z21);
                    this.speedText.setTextColor(i11);
                    this.startFrameEdit.setClickable(z21);
                    this.startFrameEdit.setEnabled(z21);
                    this.startFrameText.setTextColor(i12);
                    this.visibleFrameText.setTextColor(i13);
                    if (getBuildSdkInt() >= 11) {
                        float f9 = f5;
                        this.frameText.setAlpha(f9);
                        this.speedSpinner.setAlpha(f9);
                        this.startFrameEdit.setAlpha(f9);
                    }
                }
                if ((278536 & j) != 0) {
                    TextViewBindingAdapter.setText(this.frameText, str7);
                }
                if (i19 != 0) {
                    if (getBuildSdkInt() >= 11) {
                        this.playLastImage.setAlpha(f6);
                        this.playNextImage.setAlpha(f6);
                        this.recordToEndImage.setAlpha(f6);
                        this.recordToStartImage.setAlpha(f6);
                    }
                    this.playLastImage.setEnabled(z16);
                    this.playNextImage.setEnabled(z16);
                    this.recordToEndImage.setEnabled(z16);
                    this.recordToStartImage.setEnabled(z16);
                }
                if ((262696 & j) != 0) {
                    TextViewBindingAdapter.setText(this.speedSpinner, str6);
                }
                if ((266248 & j) != 0) {
                    TextViewBindingAdapter.setText(this.startFrameEdit, str5);
                }
                if ((j & 263180) != 0) {
                    TextViewBindingAdapter.setText(this.typeSpinner, str4);
                }
                if ((j & 264202) == 0) {
                    TextViewBindingAdapter.setText(this.visibleSpinner, str3);
                    return;
                }
                return;
            }
        } else {
            f2 = f;
            str8 = str2;
            z5 = false;
        }
        z6 = false;
        if ((j & 140754735333376L) == 0) {
        }
        if ((j & 393304) == 0) {
        }
        i10 = ((j & 262472) > 0L ? 1 : ((j & 262472) == 0L ? 0 : -1));
        if (i10 == 0) {
        }
        if ((j & 393368) == 0) {
        }
        i15 = ((j & 34359738368L) > 0L ? 1 : ((j & 34359738368L) == 0L ? 0 : -1));
        if (i15 == 0) {
        }
        if ((j & 536870912) != 0) {
        }
        z14 = true;
        z15 = false;
        i18 = ((j & 34359738368L) > 0L ? 1 : ((j & 34359738368L) == 0L ? 0 : -1));
        if (i18 == 0) {
        }
        if ((j & 4294967296L) != 0) {
        }
        i19 = ((264394 & j) > 0L ? 1 : ((264394 & j) == 0L ? 0 : -1));
        if (i19 == 0) {
        }
        if ((j & 360456) != 0) {
        }
        if ((j & 262280) != 0) {
        }
        if ((j & 393304) != 0) {
        }
        if ((j & 393368) != 0) {
        }
        if ((j & 262216) != 0) {
        }
        if ((270345 & j) != 0) {
        }
        if ((j & 262472) != 0) {
        }
        if ((278536 & j) != 0) {
        }
        if (i19 != 0) {
        }
        if ((262696 & j) != 0) {
        }
        if ((266248 & j) != 0) {
        }
        if ((j & 263180) != 0) {
        }
        if ((j & 264202) == 0) {
        }
    }
}
