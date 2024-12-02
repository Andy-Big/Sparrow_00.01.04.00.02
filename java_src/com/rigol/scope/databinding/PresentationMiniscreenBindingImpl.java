package com.rigol.scope.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.rigol.scope.R;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.MiniScreenParam;
import me.relex.circleindicator.CircleIndicator3;

/* loaded from: classes2.dex */
public class PresentationMiniscreenBindingImpl extends PresentationMiniscreenBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.top_guideline, 6);
        sViewsWithIds.put(R.id.bottom_guideline, 7);
        sViewsWithIds.put(R.id.left_guideline, 8);
        sViewsWithIds.put(R.id.right_guideline, 9);
        sViewsWithIds.put(R.id.top_left_corner_layout, 10);
        sViewsWithIds.put(R.id.top_left_corner_press, 11);
        sViewsWithIds.put(R.id.top_left_corner_slash, 12);
        sViewsWithIds.put(R.id.top_right_corner_layout, 13);
        sViewsWithIds.put(R.id.top_right_corner_press, 14);
        sViewsWithIds.put(R.id.top_right_corner_slash, 15);
        sViewsWithIds.put(R.id.content, 16);
        sViewsWithIds.put(R.id.indicator, 17);
        sViewsWithIds.put(R.id.bottom_left_corner_layout, 18);
        sViewsWithIds.put(R.id.bottom_left_corner_tv, 19);
        sViewsWithIds.put(R.id.bottom_left_corner_press_tv, 20);
        sViewsWithIds.put(R.id.bottom_left_corner_press, 21);
        sViewsWithIds.put(R.id.bottom_left_corner_slash, 22);
        sViewsWithIds.put(R.id.panel_switch, 23);
        sViewsWithIds.put(R.id.bottom_right_corner_layout, 24);
        sViewsWithIds.put(R.id.bottom_right_corner_tv, 25);
        sViewsWithIds.put(R.id.bottom_right_corner_press_tv, 26);
        sViewsWithIds.put(R.id.bottom_right_corner_press, 27);
        sViewsWithIds.put(R.id.bottom_right_corner_slash, 28);
    }

    public PresentationMiniscreenBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 29, sIncludes, sViewsWithIds));
    }

    private PresentationMiniscreenBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (Guideline) objArr[7], (ConstraintLayout) objArr[18], (ImageView) objArr[21], (TextView) objArr[20], (ImageView) objArr[22], (TextView) objArr[19], (ConstraintLayout) objArr[24], (ImageView) objArr[27], (TextView) objArr[26], (ImageView) objArr[28], (TextView) objArr[25], (ViewPager2) objArr[16], (CircleIndicator3) objArr[17], (Guideline) objArr[8], (Button) objArr[23], (Guideline) objArr[9], (TextView) objArr[3], (Guideline) objArr[6], (ConstraintLayout) objArr[10], (ImageView) objArr[11], (TextView) objArr[2], (ImageView) objArr[12], (TextView) objArr[1], (ConstraintLayout) objArr[13], (ImageView) objArr[14], (TextView) objArr[5], (ImageView) objArr[15], (TextView) objArr[4]);
        this.mDirtyFlags = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.topCenterPosition.setTag(null);
        this.topLeftCornerPressTv.setTag(null);
        this.topLeftCornerTv.setTag(null);
        this.topRightCornerPressTv.setTag(null);
        this.topRightCornerTv.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 4L;
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
            setParam((MiniScreenParam) obj);
            return true;
        }
        return false;
    }

    @Override // com.rigol.scope.databinding.PresentationMiniscreenBinding
    public void setParam(MiniScreenParam miniScreenParam) {
        updateRegistration(0, miniScreenParam);
        this.mParam = miniScreenParam;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(594);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return onChangeParam((MiniScreenParam) obj, i2);
    }

    private boolean onChangeParam(MiniScreenParam miniScreenParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i == 352) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        } else {
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003a  */
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
        MiniScreenParam miniScreenParam = this.mParam;
        int i = ((j & 7) > 0L ? 1 : ((j & 7) == 0L ? 0 : -1));
        String str5 = null;
        if (i != 0) {
            ServiceEnum.Function function = miniScreenParam != null ? miniScreenParam.getFunction() : null;
            if (miniScreenParam != null) {
                String topRightCornerTips = miniScreenParam.getTopRightCornerTips(function);
                String topCenterString = miniScreenParam.getTopCenterString(function);
                str3 = miniScreenParam.getTopLeftCornerString(function);
                str4 = miniScreenParam.getTopRightCornerString(function);
                str = miniScreenParam.getTopLeftCornerTips(function);
                str2 = topRightCornerTips;
                str5 = topCenterString;
                if (i == 0) {
                    TextViewBindingAdapter.setText(this.topCenterPosition, str5);
                    TextViewBindingAdapter.setText(this.topLeftCornerPressTv, str);
                    TextViewBindingAdapter.setText(this.topLeftCornerTv, str3);
                    TextViewBindingAdapter.setText(this.topRightCornerPressTv, str2);
                    TextViewBindingAdapter.setText(this.topRightCornerTv, str4);
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
