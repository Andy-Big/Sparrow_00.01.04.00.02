package com.rigol.scope.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.rigol.scope.R;
import com.rigol.scope.data.BodeParam;
import com.rigol.scope.data.FftParam;
import com.rigol.scope.data.MappingObject;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class BodeResultPopuwinBindingImpl extends BodeResultPopuwinBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;
    private final TextView mboundView2;
    private final TextView mboundView3;
    private final TextView mboundView4;
    private final TextView mboundView5;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.guideline_center, 6);
        sViewsWithIds.put(R.id.guideline_center2, 7);
        sViewsWithIds.put(R.id.guideline_center12, 8);
        sViewsWithIds.put(R.id.nothing_text1, 9);
        sViewsWithIds.put(R.id.nothing_text2, 10);
        sViewsWithIds.put(R.id.nothing_text6, 11);
        sViewsWithIds.put(R.id.nothing_text12, 12);
        sViewsWithIds.put(R.id.nothing_text21, 13);
    }

    public BodeResultPopuwinBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 14, sIncludes, sViewsWithIds));
    }

    private BodeResultPopuwinBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 4, (Guideline) objArr[6], (Guideline) objArr[8], (Guideline) objArr[7], (TextView) objArr[1], (TextView) objArr[9], (TextView) objArr[12], (TextView) objArr[10], (TextView) objArr[13], (TextView) objArr[11]);
        this.mDirtyFlags = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView = (TextView) objArr[2];
        this.mboundView2 = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[3];
        this.mboundView3 = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) objArr[4];
        this.mboundView4 = textView3;
        textView3.setTag(null);
        TextView textView4 = (TextView) objArr[5];
        this.mboundView5 = textView4;
        textView4.setTag(null);
        this.nothingText.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 16L;
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
        if (1 == i) {
            setAmpOrderMapping((MappingObject) obj);
            return true;
        } else if (594 == i) {
            setParam((FftParam) obj);
            return true;
        } else if (6 == i) {
            setFreqOrderMapping((MappingObject) obj);
            return true;
        } else if (100 == i) {
            setBodeParam((BodeParam) obj);
            return true;
        } else {
            return false;
        }
    }

    @Override // com.rigol.scope.databinding.BodeResultPopuwinBinding
    public void setAmpOrderMapping(MappingObject mappingObject) {
        this.mAmpOrderMapping = mappingObject;
    }

    @Override // com.rigol.scope.databinding.BodeResultPopuwinBinding
    public void setParam(FftParam fftParam) {
        this.mParam = fftParam;
    }

    @Override // com.rigol.scope.databinding.BodeResultPopuwinBinding
    public void setFreqOrderMapping(MappingObject mappingObject) {
        this.mFreqOrderMapping = mappingObject;
    }

    @Override // com.rigol.scope.databinding.BodeResultPopuwinBinding
    public void setBodeParam(BodeParam bodeParam) {
        updateRegistration(3, bodeParam);
        this.mBodeParam = bodeParam;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(100);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return false;
                    }
                    return onChangeBodeParam((BodeParam) obj, i2);
                }
                return onChangeFreqOrderMapping((MappingObject) obj, i2);
            }
            return onChangeParam((FftParam) obj, i2);
        }
        return onChangeAmpOrderMapping((MappingObject) obj, i2);
    }

    private boolean onChangeAmpOrderMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeParam(FftParam fftParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeFreqOrderMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeBodeParam(BodeParam bodeParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
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
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        BodeParam bodeParam = this.mBodeParam;
        int i = ((j & 24) > 0L ? 1 : ((j & 24) == 0L ? 0 : -1));
        String str5 = null;
        if (i != 0) {
            ArrayList<String> bode_resultlist = bodeParam != null ? bodeParam.getBode_resultlist() : null;
            if (bode_resultlist != null) {
                str5 = bode_resultlist.get(4);
                str2 = bode_resultlist.get(8);
                str3 = bode_resultlist.get(7);
                str4 = bode_resultlist.get(3);
                str = bode_resultlist.get(5);
                if (i == 0) {
                    TextViewBindingAdapter.setText(this.mboundView2, str5);
                    TextViewBindingAdapter.setText(this.mboundView3, str);
                    TextViewBindingAdapter.setText(this.mboundView4, str3);
                    TextViewBindingAdapter.setText(this.mboundView5, str2);
                    TextViewBindingAdapter.setText(this.nothingText, str4);
                    return;
                }
                return;
            }
        }
        str = null;
        str2 = null;
        str3 = null;
        str4 = null;
        if (i == 0) {
        }
    }
}
