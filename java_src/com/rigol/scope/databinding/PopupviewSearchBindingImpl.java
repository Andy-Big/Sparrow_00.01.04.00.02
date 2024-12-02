package com.rigol.scope.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.CompoundButtonBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.rigol.scope.R;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.HorizontalParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.SearchParam;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.views.SwitchButton;

/* loaded from: classes2.dex */
public class PopupviewSearchBindingImpl extends PopupviewSearchBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.guideline_center, 13);
        sViewsWithIds.put(R.id.dividing_line1, 14);
        sViewsWithIds.put(R.id.search_view, 15);
        sViewsWithIds.put(R.id.dividing_line2, 16);
        sViewsWithIds.put(R.id.navigateBut, 17);
    }

    public PopupviewSearchBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 18, sIncludes, sViewsWithIds));
    }

    private PopupviewSearchBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3, (Button) objArr[12], (Button) objArr[10], (View) objArr[14], (View) objArr[16], (TextView) objArr[1], (SwitchButton) objArr[2], (Guideline) objArr[13], (TextView) objArr[5], (SwitchButton) objArr[6], (Button) objArr[17], (EditText) objArr[8], (ImageView) objArr[7], (ImageView) objArr[9], (Button) objArr[11], (RecyclerView) objArr[15], (TextView) objArr[3], (TextView) objArr[4]);
        this.mDirtyFlags = -1L;
        this.copyFromTriggerBtn.setTag(null);
        this.copyToTriggerBtn.setTag(null);
        this.enable.setTag(null);
        this.enableSwitchButton.setTag(null);
        this.markTable.setTag(null);
        this.markTableSwitchButton.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.navigation.setTag(null);
        this.playLastImage.setTag(null);
        this.playnextImage.setTag(null);
        this.saveBtn.setTag(null);
        this.type.setTag(null);
        this.typeSpinner.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
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
            setParam((SearchParam) obj);
        } else if (380 != i) {
            return false;
        } else {
            setHorizontal((HorizontalParam) obj);
        }
        return true;
    }

    @Override // com.rigol.scope.databinding.PopupviewSearchBinding
    public void setParam(SearchParam searchParam) {
        updateRegistration(0, searchParam);
        this.mParam = searchParam;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(594);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewSearchBinding
    public void setHorizontal(HorizontalParam horizontalParam) {
        updateRegistration(2, horizontalParam);
        this.mHorizontal = horizontalParam;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(380);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    return false;
                }
                return onChangeHorizontal((HorizontalParam) obj, i2);
            }
            return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgSearchTypeParamTypeValue1((MappingObject) obj, i2);
        }
        return onChangeParam((SearchParam) obj, i2);
    }

    private boolean onChangeParam(SearchParam searchParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i == 271) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        } else if (i == 978) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        } else if (i == 519) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        } else if (i == 557) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgSearchTypeParamTypeValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeHorizontal(HorizontalParam horizontalParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else if (i == 28) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
            }
            return true;
        } else if (i == 935) {
            synchronized (this) {
                this.mDirtyFlags |= 256;
            }
            return true;
        } else if (i == 760) {
            synchronized (this) {
                this.mDirtyFlags |= 512;
            }
            return true;
        } else {
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:152:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0070  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void executeBindings() {
        long j;
        float f;
        boolean z;
        boolean z2;
        String str;
        String str2;
        boolean z3;
        boolean z4;
        float f2;
        boolean z5;
        int i;
        float f3;
        boolean z6;
        long j2;
        long j3;
        float f4;
        boolean z7;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        SearchParam searchParam = this.mParam;
        HorizontalParam horizontalParam = this.mHorizontal;
        if ((1147 & j) != 0) {
            if ((j & 1043) != 0) {
                ServiceEnum.enumSearchType type = searchParam != null ? searchParam.getType() : null;
                MappingObject mappingObject = ViewUtil.getMappingObject(R.array.msg_search_type, type != null ? type.value1 : 0);
                updateRegistration(1, mappingObject);
                if (mappingObject != null) {
                    str = mappingObject.getStr();
                    if ((j & 1089) == 0) {
                        str2 = String.valueOf(searchParam != null ? searchParam.getNavigation() : 0);
                    } else {
                        str2 = null;
                    }
                    if ((j & 1033) == 0) {
                        z7 = searchParam != null ? searchParam.isEnable() : false;
                        f4 = ContextUtil.getAlpha(z7);
                    } else {
                        f4 = 0.0f;
                        z7 = false;
                    }
                    z = ((j & 1057) != 0 || searchParam == null) ? false : searchParam.isMarkTableEn();
                    z2 = z7;
                    f = f4;
                }
            }
            str = null;
            if ((j & 1089) == 0) {
            }
            if ((j & 1033) == 0) {
            }
            if ((j & 1057) != 0) {
            }
            z2 = z7;
            f = f4;
        } else {
            f = 0.0f;
            z = false;
            z2 = false;
            str = null;
            str2 = null;
        }
        if ((j & 1924) != 0) {
            z3 = (horizontalParam != null ? horizontalParam.getAcquireMode() : null) != ServiceEnum.AcquireMode.Acquire_Ultra;
            if ((j & 1412) != 0) {
                j |= z3 ? PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM : PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
            }
            if ((j & 1924) != 0) {
                j = z3 ? j | PlaybackStateCompat.ACTION_SET_REPEAT_MODE : j | PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
            }
        } else {
            z3 = false;
        }
        if ((j & 135168) != 0) {
            z4 = (horizontalParam != null ? horizontalParam.getTimeMode() : null) != ServiceEnum.HoriTimeMode.Horizontal_ROLL;
            if ((j & PlaybackStateCompat.ACTION_PREPARE_FROM_URI) != 0) {
                j = z4 ? j | PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED : j | PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
            }
        } else {
            z4 = false;
        }
        int i2 = ((j & 1412) > 0L ? 1 : ((j & 1412) == 0L ? 0 : -1));
        if (i2 != 0) {
            boolean z8 = z3 ? z4 : false;
            if (i2 != 0) {
                j |= z8 ? PlaybackStateCompat.ACTION_PREPARE : PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            }
            f2 = z8 ? 1.0f : 0.5f;
        } else {
            f2 = 0.0f;
        }
        if ((j & PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) != 0) {
            if ((horizontalParam != null ? horizontalParam.getRunStop() : null) != ServiceEnum.ControlAction.Control_Run) {
                z5 = true;
                if ((j & PlaybackStateCompat.ACTION_PREPARE_FROM_URI) != 0 || !z4) {
                    z5 = false;
                }
                i = ((j & 1924) > 0L ? 1 : ((j & 1924) == 0L ? 0 : -1));
                if (i == 0) {
                    boolean z9 = z3 ? true : z5;
                    if (i != 0) {
                        if (z9) {
                            j2 = j | PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
                            j3 = 4194304;
                        } else {
                            j2 = j | PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
                            j3 = PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
                        }
                        j = j2 | j3;
                    }
                    f3 = z9 ? 1.0f : 0.5f;
                    z6 = z9;
                } else {
                    f3 = 0.0f;
                    z6 = false;
                }
                if ((1033 & j) != 0) {
                    if (getBuildSdkInt() >= 11) {
                        this.copyFromTriggerBtn.setAlpha(f);
                        this.copyToTriggerBtn.setAlpha(f);
                        this.markTable.setAlpha(f);
                        this.markTableSwitchButton.setAlpha(f);
                        this.navigation.setAlpha(f);
                        this.playLastImage.setAlpha(f);
                        this.playnextImage.setAlpha(f);
                        this.saveBtn.setAlpha(f);
                        this.type.setAlpha(f);
                        this.typeSpinner.setAlpha(f);
                    }
                    this.copyFromTriggerBtn.setEnabled(z2);
                    this.copyToTriggerBtn.setEnabled(z2);
                    CompoundButtonBindingAdapter.setChecked(this.enableSwitchButton, z2);
                    this.markTableSwitchButton.setEnabled(z2);
                    this.navigation.setEnabled(z2);
                    this.playLastImage.setEnabled(z2);
                    this.playnextImage.setEnabled(z2);
                    this.saveBtn.setEnabled(z2);
                    this.typeSpinner.setEnabled(z2);
                }
                if ((j & 1412) != 0 && getBuildSdkInt() >= 11) {
                    this.enable.setAlpha(f2);
                }
                if ((j & 1924) != 0) {
                    if (getBuildSdkInt() >= 11) {
                        this.enableSwitchButton.setAlpha(f3);
                    }
                    this.enableSwitchButton.setEnabled(z6);
                }
                if ((1057 & j) != 0) {
                    CompoundButtonBindingAdapter.setChecked(this.markTableSwitchButton, z);
                }
                if ((1089 & j) != 0) {
                    TextViewBindingAdapter.setText(this.navigation, str2);
                }
                if ((j & 1043) == 0) {
                    TextViewBindingAdapter.setText(this.typeSpinner, str);
                    return;
                }
                return;
            }
        }
        z5 = false;
        if ((j & PlaybackStateCompat.ACTION_PREPARE_FROM_URI) != 0) {
        }
        z5 = false;
        i = ((j & 1924) > 0L ? 1 : ((j & 1924) == 0L ? 0 : -1));
        if (i == 0) {
        }
        if ((1033 & j) != 0) {
        }
        if ((j & 1412) != 0) {
            this.enable.setAlpha(f2);
        }
        if ((j & 1924) != 0) {
        }
        if ((1057 & j) != 0) {
        }
        if ((1089 & j) != 0) {
        }
        if ((j & 1043) == 0) {
        }
    }
}
