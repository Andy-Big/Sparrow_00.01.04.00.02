package com.rigol.scope.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.rigol.scope.R;
import com.rigol.scope.views.busAnalyse.BusAnalyseParam;

/* loaded from: classes2.dex */
public class PopupviewAnalyseEthResultBindingImpl extends PopupviewAnalyseEthResultBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.title_layout, 1);
        sViewsWithIds.put(R.id.scrollView, 2);
        sViewsWithIds.put(R.id.resultText, 3);
        sViewsWithIds.put(R.id.bus_analyse_eth_result_save, 4);
        sViewsWithIds.put(R.id.header, 5);
        sViewsWithIds.put(R.id.result, 6);
        sViewsWithIds.put(R.id.eyeText, 7);
        sViewsWithIds.put(R.id.eth_eye_layout, 8);
        sViewsWithIds.put(R.id.eye, 9);
        sViewsWithIds.put(R.id.eth_eye_y_layout, 10);
        sViewsWithIds.put(R.id.eth_eye_yruler1, 11);
        sViewsWithIds.put(R.id.eth_eye_yruler2, 12);
        sViewsWithIds.put(R.id.eth_eye_yruler3, 13);
        sViewsWithIds.put(R.id.eth_eye_yruler4, 14);
        sViewsWithIds.put(R.id.eth_eye_yruler5, 15);
        sViewsWithIds.put(R.id.eth_eye_yruler6, 16);
        sViewsWithIds.put(R.id.eth_eye_yruler7, 17);
        sViewsWithIds.put(R.id.eth_eye_yruler8, 18);
        sViewsWithIds.put(R.id.eth_eye_yruler9, 19);
        sViewsWithIds.put(R.id.eth_eye_yruler10, 20);
        sViewsWithIds.put(R.id.eth_eye_yruler11, 21);
        sViewsWithIds.put(R.id.eth_eye_x_layout, 22);
        sViewsWithIds.put(R.id.eth_eye_xruler1, 23);
        sViewsWithIds.put(R.id.eth_eye_xruler2, 24);
        sViewsWithIds.put(R.id.eth_eye_xruler3, 25);
        sViewsWithIds.put(R.id.eth_eye_xruler4, 26);
        sViewsWithIds.put(R.id.eth_eye_xruler5, 27);
        sViewsWithIds.put(R.id.eth_eye_xruler6, 28);
        sViewsWithIds.put(R.id.eth_eye_xruler7, 29);
        sViewsWithIds.put(R.id.eth_eye_xruler8, 30);
        sViewsWithIds.put(R.id.eth_eye_xruler9, 31);
        sViewsWithIds.put(R.id.eth_eye_xruler10, 32);
        sViewsWithIds.put(R.id.eth_eye_xruler11, 33);
        sViewsWithIds.put(R.id.eth_eye_xruler12, 34);
        sViewsWithIds.put(R.id.eth_eye_xruler13, 35);
        sViewsWithIds.put(R.id.eth_eye_xruler14, 36);
        sViewsWithIds.put(R.id.eth_eye_xruler15, 37);
        sViewsWithIds.put(R.id.eth_eye_xruler16, 38);
        sViewsWithIds.put(R.id.eth_eye_xruler17, 39);
        sViewsWithIds.put(R.id.jitterText, 40);
        sViewsWithIds.put(R.id.eth_jitter_layout, 41);
        sViewsWithIds.put(R.id.jitter, 42);
        sViewsWithIds.put(R.id.eth_jitter_y_layout, 43);
        sViewsWithIds.put(R.id.eth_jitter_yruler1, 44);
        sViewsWithIds.put(R.id.eth_jitter_yruler2, 45);
        sViewsWithIds.put(R.id.eth_jitter_yruler3, 46);
        sViewsWithIds.put(R.id.eth_jitter_yruler4, 47);
        sViewsWithIds.put(R.id.eth_jitter_yruler5, 48);
        sViewsWithIds.put(R.id.eth_jitter_yruler6, 49);
        sViewsWithIds.put(R.id.eth_jitter_yruler7, 50);
        sViewsWithIds.put(R.id.eth_jitter_yruler8, 51);
        sViewsWithIds.put(R.id.eth_jitter_yruler9, 52);
        sViewsWithIds.put(R.id.eth_jitter_yruler10, 53);
        sViewsWithIds.put(R.id.eth_jitter_yruler11, 54);
        sViewsWithIds.put(R.id.eth_jitter_x_layout, 55);
        sViewsWithIds.put(R.id.eth_jitter_xruler1, 56);
        sViewsWithIds.put(R.id.eth_jitter_xruler2, 57);
        sViewsWithIds.put(R.id.eth_jitter_xruler3, 58);
        sViewsWithIds.put(R.id.eth_jitter_xruler4, 59);
        sViewsWithIds.put(R.id.eth_jitter_xruler5, 60);
        sViewsWithIds.put(R.id.eth_jitter_xruler6, 61);
        sViewsWithIds.put(R.id.eth_jitter_xruler7, 62);
        sViewsWithIds.put(R.id.eth_jitter_xruler8, 63);
        sViewsWithIds.put(R.id.eth_jitter_xruler9, 64);
        sViewsWithIds.put(R.id.eth_jitter_xruler10, 65);
        sViewsWithIds.put(R.id.eth_jitter_xruler11, 66);
        sViewsWithIds.put(R.id.eth_jitter_xruler12, 67);
        sViewsWithIds.put(R.id.eth_jitter_xruler13, 68);
        sViewsWithIds.put(R.id.eth_jitter_xruler14, 69);
        sViewsWithIds.put(R.id.eth_jitter_xruler15, 70);
        sViewsWithIds.put(R.id.eth_jitter_xruler16, 71);
        sViewsWithIds.put(R.id.eth_jitter_xruler17, 72);
    }

    public PopupviewAnalyseEthResultBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 73, sIncludes, sViewsWithIds));
    }

    private PopupviewAnalyseEthResultBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (Button) objArr[4], (ConstraintLayout) objArr[8], (ConstraintLayout) objArr[22], (TextView) objArr[23], (TextView) objArr[32], (TextView) objArr[33], (TextView) objArr[34], (TextView) objArr[35], (TextView) objArr[36], (TextView) objArr[37], (TextView) objArr[38], (TextView) objArr[39], (TextView) objArr[24], (TextView) objArr[25], (TextView) objArr[26], (TextView) objArr[27], (TextView) objArr[28], (TextView) objArr[29], (TextView) objArr[30], (TextView) objArr[31], (ConstraintLayout) objArr[10], (TextView) objArr[11], (TextView) objArr[20], (TextView) objArr[21], (TextView) objArr[12], (TextView) objArr[13], (TextView) objArr[14], (TextView) objArr[15], (TextView) objArr[16], (TextView) objArr[17], (TextView) objArr[18], (TextView) objArr[19], (ConstraintLayout) objArr[41], (ConstraintLayout) objArr[55], (TextView) objArr[56], (TextView) objArr[65], (TextView) objArr[66], (TextView) objArr[67], (TextView) objArr[68], (TextView) objArr[69], (TextView) objArr[70], (TextView) objArr[71], (TextView) objArr[72], (TextView) objArr[57], (TextView) objArr[58], (TextView) objArr[59], (TextView) objArr[60], (TextView) objArr[61], (TextView) objArr[62], (TextView) objArr[63], (TextView) objArr[64], (ConstraintLayout) objArr[43], (TextView) objArr[44], (TextView) objArr[53], (TextView) objArr[54], (TextView) objArr[45], (TextView) objArr[46], (TextView) objArr[47], (TextView) objArr[48], (TextView) objArr[49], (TextView) objArr[50], (TextView) objArr[51], (TextView) objArr[52], (ImageView) objArr[9], (TextView) objArr[7], (RecyclerView) objArr[5], (ImageView) objArr[42], (TextView) objArr[40], (RecyclerView) objArr[6], (TextView) objArr[3], (ScrollView) objArr[2], (View) objArr[1]);
        this.mDirtyFlags = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 2L;
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
            setParam((BusAnalyseParam) obj);
            return true;
        }
        return false;
    }

    @Override // com.rigol.scope.databinding.PopupviewAnalyseEthResultBinding
    public void setParam(BusAnalyseParam busAnalyseParam) {
        this.mParam = busAnalyseParam;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return onChangeParam((BusAnalyseParam) obj, i2);
    }

    private boolean onChangeParam(BusAnalyseParam busAnalyseParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        }
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}
