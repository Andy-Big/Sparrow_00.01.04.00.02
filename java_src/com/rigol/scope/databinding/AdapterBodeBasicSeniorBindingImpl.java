package com.rigol.scope.databinding;

import android.graphics.drawable.Drawable;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.CompoundButtonBindingAdapter;
import androidx.databinding.adapters.ImageViewBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.rigol.scope.R;
import com.rigol.scope.data.BodeParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.utilities.ColorUtil;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.views.SwitchButton;

/* loaded from: classes2.dex */
public class AdapterBodeBasicSeniorBindingImpl extends AdapterBodeBasicSeniorBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.left_guideline, 9);
        sViewsWithIds.put(R.id.left_guideline1, 10);
        sViewsWithIds.put(R.id.left_guideline2, 11);
        sViewsWithIds.put(R.id.left_guideline3, 12);
        sViewsWithIds.put(R.id.tips_button, 13);
    }

    public AdapterBodeBasicSeniorBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 14, sIncludes, sViewsWithIds));
    }

    private AdapterBodeBasicSeniorBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 5, (TextView) objArr[4], (SwitchButton) objArr[8], (SwitchButton) objArr[7], (TextView) objArr[6], (TextView) objArr[3], (Guideline) objArr[9], (Guideline) objArr[10], (Guideline) objArr[11], (Guideline) objArr[12], (TextView) objArr[2], (ImageView) objArr[5], (SwitchButton) objArr[1], (TextView) objArr[13]);
        this.mDirtyFlags = -1L;
        this.bodeDisp.setTag(null);
        this.bodeFirEnable.setTag(null);
        this.bodeImpedance.setTag(null);
        this.bodeSourceOut.setTag(null);
        this.bodeSweepType.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.msgBodeSourceIn.setTag(null);
        this.operateButton.setTag(null);
        this.showBodeSwitch.setTag(null);
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
        if (600 == i) {
            setParma((BodeParam) obj);
            return true;
        }
        return false;
    }

    @Override // com.rigol.scope.databinding.AdapterBodeBasicSeniorBinding
    public void setParma(BodeParam bodeParam) {
        updateRegistration(4, bodeParam);
        this.mParma = bodeParam;
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        notifyPropertyChanged(600);
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
                        return onChangeParma((BodeParam) obj, i2);
                    }
                    return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgBodeSweepTypeParmaBodeSweepType((MappingObject) obj, i2);
                }
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgBodeSourceOutParmaBodeSourceOut((MappingObject) obj, i2);
            }
            return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgBodeDispTypeParmaBodedispType((MappingObject) obj, i2);
        }
        return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgBodeSourceInParmaBodeSourceIn((MappingObject) obj, i2);
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgBodeSourceInParmaBodeSourceIn(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgBodeDispTypeParmaBodedispType(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgBodeSourceOutParmaBodeSourceOut(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgBodeSweepTypeParmaBodeSweepType(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeParma(BodeParam bodeParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        } else if (i == 96) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        } else if (i == 104) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        } else if (i == 105) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
            }
            return true;
        } else if (i == 109) {
            synchronized (this) {
                this.mDirtyFlags |= 256;
            }
            return true;
        } else if (i == 111) {
            synchronized (this) {
                this.mDirtyFlags |= 512;
            }
            return true;
        } else if (i == 106) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 319) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
            }
            return true;
        } else {
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00e8 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x015f  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void executeBindings() {
        long j;
        long j2;
        float f;
        String str;
        boolean z;
        int i;
        String str2;
        String str3;
        String str4;
        Drawable drawable;
        boolean z2;
        int i2;
        boolean z3;
        boolean z4;
        Drawable drawable2;
        float f2;
        boolean z5;
        Drawable drawable3;
        boolean z6;
        String str5;
        int i3;
        String str6;
        long j3;
        String str7;
        synchronized (this) {
            j = this.mDirtyFlags;
            j2 = 0;
            this.mDirtyFlags = 0L;
        }
        BodeParam bodeParam = this.mParma;
        if ((8191 & j) != 0) {
            int i4 = ((j & 4176) > 0L ? 1 : ((j & 4176) == 0L ? 0 : -1));
            if (i4 != 0) {
                z5 = bodeParam != null ? bodeParam.getBodeRunStopEnable() : false;
                boolean z7 = z5;
                if (i4 != 0) {
                    j |= z7 ? PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH : PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
                }
                drawable3 = AppCompatResources.getDrawable(this.operateButton.getContext(), z7 ? 17301539 : 17301540);
            } else {
                z5 = false;
                drawable3 = null;
            }
            int i5 = ((j & 4208) > 0L ? 1 : ((j & 4208) == 0L ? 0 : -1));
            if (i5 != 0) {
                z6 = bodeParam != null ? bodeParam.getBodeEnable() : false;
                if (i5 != 0) {
                    j = z6 ? j | PlaybackStateCompat.ACTION_PREPARE : j | PlaybackStateCompat.ACTION_PLAY_FROM_URI;
                }
                if ((j & 4144) != 0) {
                    f = ContextUtil.getAlpha(z6);
                    if ((j & 4241) == 0) {
                        int bodeSourceIn = bodeParam != null ? bodeParam.getBodeSourceIn() : 0;
                        MappingObject mappingObject = ViewUtil.getMappingObject(R.array.msg_bode_source_in, bodeSourceIn);
                        updateRegistration(0, mappingObject);
                        str5 = mappingObject != null ? mappingObject.getStr() : null;
                        if ((j & 4240) != 0) {
                            i3 = ColorUtil.getColor(getRoot().getContext(), bodeSourceIn);
                            if ((j & 4376) != 0) {
                                MappingObject mappingObject2 = ViewUtil.getMappingObject(R.array.msg_bode_sweep_type, bodeParam != null ? bodeParam.getBodeSweepType() : 0);
                                updateRegistration(3, mappingObject2);
                                if (mappingObject2 != null) {
                                    str3 = mappingObject2.getStr();
                                    boolean firEnable = ((j & 6160) != 0 || bodeParam == null) ? false : bodeParam.getFirEnable();
                                    if ((j & 4626) != 0) {
                                        MappingObject mappingObject3 = ViewUtil.getMappingObject(R.array.msg_bode_disp_type, bodeParam != null ? bodeParam.getBodedispType() : 0);
                                        updateRegistration(1, mappingObject3);
                                        if (mappingObject3 != null) {
                                            str6 = mappingObject3.getStr();
                                            if ((j & 5140) != 0) {
                                                int bodeSourceOut = bodeParam != null ? bodeParam.getBodeSourceOut() : 0;
                                                MappingObject mappingObject4 = ViewUtil.getMappingObject(R.array.msg_bode_source_out, bodeSourceOut);
                                                updateRegistration(2, mappingObject4);
                                                if (mappingObject4 != null) {
                                                    str7 = mappingObject4.getStr();
                                                    j3 = 5136;
                                                } else {
                                                    j3 = 5136;
                                                    str7 = null;
                                                }
                                                long j4 = j & j3;
                                                j2 = 0;
                                                if (j4 != 0) {
                                                    i2 = ColorUtil.getColor(getRoot().getContext(), bodeSourceOut);
                                                    z2 = firEnable;
                                                } else {
                                                    z2 = firEnable;
                                                    i2 = 0;
                                                }
                                                str4 = str5;
                                                i = i3;
                                                str2 = str6;
                                                drawable = drawable3;
                                                str = str7;
                                                z3 = z5;
                                                z = z6;
                                            } else {
                                                z3 = z5;
                                                z2 = firEnable;
                                                z = z6;
                                                i2 = 0;
                                                str4 = str5;
                                                i = i3;
                                                str2 = str6;
                                                drawable = drawable3;
                                                str = null;
                                            }
                                        }
                                    }
                                    str6 = null;
                                    if ((j & 5140) != 0) {
                                    }
                                }
                            }
                            str3 = null;
                            if ((j & 6160) != 0) {
                            }
                            if ((j & 4626) != 0) {
                            }
                            str6 = null;
                            if ((j & 5140) != 0) {
                            }
                        }
                    } else {
                        str5 = null;
                    }
                    i3 = 0;
                    if ((j & 4376) != 0) {
                    }
                    str3 = null;
                    if ((j & 6160) != 0) {
                    }
                    if ((j & 4626) != 0) {
                    }
                    str6 = null;
                    if ((j & 5140) != 0) {
                    }
                }
            } else {
                z6 = false;
            }
            f = 0.0f;
            if ((j & 4241) == 0) {
            }
            i3 = 0;
            if ((j & 4376) != 0) {
            }
            str3 = null;
            if ((j & 6160) != 0) {
            }
            if ((j & 4626) != 0) {
            }
            str6 = null;
            if ((j & 5140) != 0) {
            }
        } else {
            f = 0.0f;
            str = null;
            z = false;
            i = 0;
            str2 = null;
            str3 = null;
            str4 = null;
            drawable = null;
            z2 = false;
            i2 = 0;
            z3 = false;
        }
        if ((j & PlaybackStateCompat.ACTION_PREPARE) != j2) {
            if (bodeParam != null) {
                z3 = bodeParam.getBodeRunStopEnable();
            }
            z4 = !z3;
        } else {
            z4 = false;
        }
        int i6 = ((j & 4208) > 0L ? 1 : ((j & 4208) == 0L ? 0 : -1));
        if (i6 != 0) {
            if (!z) {
                z4 = false;
            }
            drawable2 = drawable;
            f2 = ContextUtil.getAlpha(z4);
        } else {
            drawable2 = drawable;
            f2 = 0.0f;
            z4 = false;
        }
        if (i6 != 0) {
            if (getBuildSdkInt() >= 11) {
                this.bodeDisp.setAlpha(f2);
                this.bodeSourceOut.setAlpha(f2);
                this.bodeSweepType.setAlpha(f2);
                this.msgBodeSourceIn.setAlpha(f2);
            }
            this.bodeDisp.setEnabled(z4);
            this.bodeSourceOut.setEnabled(z4);
            this.bodeSweepType.setEnabled(z4);
            this.msgBodeSourceIn.setEnabled(z4);
        }
        if ((j & 4626) != 0) {
            TextViewBindingAdapter.setText(this.bodeDisp, str2);
        }
        if ((4144 & j) != 0) {
            if (getBuildSdkInt() >= 11) {
                this.bodeFirEnable.setAlpha(f);
                this.bodeImpedance.setAlpha(f);
                this.operateButton.setAlpha(f);
            }
            this.bodeFirEnable.setEnabled(z);
            this.bodeImpedance.setEnabled(z);
            this.operateButton.setEnabled(z);
            CompoundButtonBindingAdapter.setChecked(this.showBodeSwitch, z);
        }
        if ((6160 & j) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.bodeFirEnable, z2);
        }
        if ((5136 & j) != 0) {
            this.bodeSourceOut.setTextColor(i2);
        }
        if ((5140 & j) != 0) {
            TextViewBindingAdapter.setText(this.bodeSourceOut, str);
        }
        if ((j & 4376) != 0) {
            TextViewBindingAdapter.setText(this.bodeSweepType, str3);
        }
        if ((4240 & j) != 0) {
            this.msgBodeSourceIn.setTextColor(i);
        }
        if ((j & 4241) != 0) {
            TextViewBindingAdapter.setText(this.msgBodeSourceIn, str4);
        }
        if ((j & 4176) != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.operateButton, drawable2);
        }
    }
}
