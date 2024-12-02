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
import com.rigol.scope.data.DvmResultParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.utilities.ColorUtil;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.views.resultItem.ResultItemConstraintLayout;

/* loaded from: classes2.dex */
public class AdapterItemResultDvmBindingImpl extends AdapterItemResultDvmBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ResultItemConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.title_layout, 6);
        sViewsWithIds.put(R.id.result_layout, 7);
        sViewsWithIds.put(R.id.mode_title, 8);
        sViewsWithIds.put(R.id.mode_title_bw, 9);
    }

    public AdapterItemResultDvmBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 10, sIncludes, sViewsWithIds));
    }

    private AdapterItemResultDvmBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (TextView) objArr[3], (ImageView) objArr[1], (TextView) objArr[4], (TextView) objArr[8], (TextView) objArr[9], (TextView) objArr[5], (ConstraintLayout) objArr[7], (TextView) objArr[2], (ConstraintLayout) objArr[6]);
        this.mDirtyFlags = -1L;
        this.currentResult.setTag(null);
        this.icon.setTag(null);
        ResultItemConstraintLayout resultItemConstraintLayout = (ResultItemConstraintLayout) objArr[0];
        this.mboundView0 = resultItemConstraintLayout;
        resultItemConstraintLayout.setTag(null);
        this.mode.setTag(null);
        this.modeWb.setTag(null);
        this.title.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 128L;
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
            setParam((DvmResultParam) obj);
            return true;
        }
        return false;
    }

    @Override // com.rigol.scope.databinding.AdapterItemResultDvmBinding
    public void setParam(DvmResultParam dvmResultParam) {
        updateRegistration(0, dvmResultParam);
        this.mParam = dvmResultParam;
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
            return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDvmModeParamDvmModeValue1((MappingObject) obj, i2);
        }
        return onChangeParam((DvmResultParam) obj, i2);
    }

    private boolean onChangeParam(DvmResultParam dvmResultParam, int i) {
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
        } else if (i == 252) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDvmModeParamDvmModeValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
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

    /* JADX WARN: Removed duplicated region for block: B:102:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:112:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x016e  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void executeBindings() {
        long j;
        SpannableString spannableString;
        Drawable drawable;
        String str;
        String str2;
        boolean z;
        int i;
        boolean z2;
        SpannableString spannableString2;
        int i2;
        int i3;
        int i4;
        int i5;
        String str3;
        String str4;
        ServiceEnum.Chan chan;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        DvmResultParam dvmResultParam = this.mParam;
        boolean z3 = true;
        CharSequence charSequence = null;
        if ((255 & j) != 0) {
            if ((j & 153) != 0) {
                if (dvmResultParam != null) {
                    str4 = dvmResultParam.getTitle();
                    chan = dvmResultParam.getSourceA();
                } else {
                    str4 = null;
                    chan = null;
                }
                i = (j & 145) != 0 ? ColorUtil.getColor(getRoot().getContext(), chan) : 0;
                spannableString = ViewUtil.getTitleWithSrc(getRoot().getContext(), str4, chan);
            } else {
                spannableString = null;
                i = 0;
            }
            int i6 = ((j & 133) > 0L ? 1 : ((j & 133) == 0L ? 0 : -1));
            if (i6 != 0) {
                ServiceEnum.MeasType measType = dvmResultParam != null ? dvmResultParam.getMeasType() : null;
                String str5 = measType != null ? measType.pic1 : null;
                z = measType != null;
                if (i6 != 0) {
                    j = z ? j | 512 : j | 256;
                }
                drawable = ContextUtil.getDrawable(getRoot().getContext(), str5);
            } else {
                drawable = null;
                z = false;
            }
            if ((j & 227) != 0) {
                ServiceEnum.DvmMode dvmMode = dvmResultParam != null ? dvmResultParam.getDvmMode() : null;
                MappingObject mappingObject = ViewUtil.getMappingObject(R.array.msg_dvm_mode, dvmMode != null ? dvmMode.value1 : 0);
                updateRegistration(1, mappingObject);
                if (mappingObject != null) {
                    str = mappingObject.getStr();
                    i5 = ((j & 129) > 0L ? 1 : ((j & 129) == 0L ? 0 : -1));
                    if (i5 == 0) {
                        if (dvmResultParam != null) {
                            str2 = dvmResultParam.getBwv();
                            str3 = dvmResultParam.getValue();
                        } else {
                            str2 = null;
                            str3 = null;
                        }
                        z2 = TextUtils.isEmpty(str3);
                        if (i5 != 0) {
                            j = z2 ? j | PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH : j | PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
                        }
                        z3 = ((j & 512) != 0 || drawable == null) ? false : false;
                        if ((j & PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID) == 0) {
                            spannableString2 = ContextUtil.getValueWithFont(getRoot().getContext(), R.font.digital_numbers, dvmResultParam != null ? dvmResultParam.getValue() : null);
                        } else {
                            spannableString2 = null;
                        }
                        i2 = ((j & 133) > 0L ? 1 : ((j & 133) == 0L ? 0 : -1));
                        if (i2 != 0) {
                            if (!z) {
                                z3 = false;
                            }
                            if (i2 != 0) {
                                j |= z3 ? PlaybackStateCompat.ACTION_PLAY_FROM_URI : PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
                            }
                            if (!z3) {
                                i3 = 8;
                                i4 = ((129 & j) > 0L ? 1 : ((129 & j) == 0L ? 0 : -1));
                                String str6 = spannableString2;
                                if (i4 != 0) {
                                    if (z2) {
                                        str6 = this.currentResult.getResources().getString(R.string.result_item_none_value);
                                    }
                                    charSequence = str6;
                                }
                                if (i4 != 0) {
                                    TextViewBindingAdapter.setText(this.currentResult, charSequence);
                                    TextViewBindingAdapter.setText(this.modeWb, str2);
                                }
                                if ((145 & j) != 0) {
                                    this.currentResult.setTextColor(i);
                                }
                                if ((j & 133) != 0) {
                                    ImageViewBindingAdapter.setImageDrawable(this.icon, drawable);
                                    this.icon.setVisibility(i3);
                                }
                                if ((227 & j) != 0) {
                                    TextViewBindingAdapter.setText(this.mode, str);
                                }
                                if ((j & 153) != 0) {
                                    TextViewBindingAdapter.setText(this.title, spannableString);
                                    return;
                                }
                                return;
                            }
                        }
                        i3 = 0;
                        i4 = ((129 & j) > 0L ? 1 : ((129 & j) == 0L ? 0 : -1));
                        String str62 = spannableString2;
                        if (i4 != 0) {
                        }
                        if (i4 != 0) {
                        }
                        if ((145 & j) != 0) {
                        }
                        if ((j & 133) != 0) {
                        }
                        if ((227 & j) != 0) {
                        }
                        if ((j & 153) != 0) {
                        }
                    } else {
                        str2 = null;
                    }
                }
            }
            str = null;
            i5 = ((j & 129) > 0L ? 1 : ((j & 129) == 0L ? 0 : -1));
            if (i5 == 0) {
            }
        } else {
            spannableString = null;
            drawable = null;
            str = null;
            str2 = null;
            z = false;
            i = 0;
        }
        z2 = false;
        if ((j & 512) != 0) {
        }
        if ((j & PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID) == 0) {
        }
        i2 = ((j & 133) > 0L ? 1 : ((j & 133) == 0L ? 0 : -1));
        if (i2 != 0) {
        }
        i3 = 0;
        i4 = ((129 & j) > 0L ? 1 : ((129 & j) == 0L ? 0 : -1));
        String str622 = spannableString2;
        if (i4 != 0) {
        }
        if (i4 != 0) {
        }
        if ((145 & j) != 0) {
        }
        if ((j & 133) != 0) {
        }
        if ((227 & j) != 0) {
        }
        if ((j & 153) != 0) {
        }
    }
}
