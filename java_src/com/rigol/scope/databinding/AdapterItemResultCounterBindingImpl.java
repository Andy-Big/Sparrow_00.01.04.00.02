package com.rigol.scope.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
import com.rigol.scope.data.CounterResultParam;
import com.rigol.scope.data.MappingObject;
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
        To view partially-correct add '--show-bad-code' argument
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 627
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rigol.scope.databinding.AdapterItemResultCounterBindingImpl.executeBindings():void");
    }
}
