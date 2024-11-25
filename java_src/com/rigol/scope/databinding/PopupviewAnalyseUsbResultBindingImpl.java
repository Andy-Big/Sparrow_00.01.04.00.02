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
import com.rigol.scope.views.busAnalyse.BusAnalyseUsbParam;
/* loaded from: classes2.dex */
public class PopupviewAnalyseUsbResultBindingImpl extends PopupviewAnalyseUsbResultBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.title_layout, 25);
        sViewsWithIds.put(R.id.scrollView, 26);
        sViewsWithIds.put(R.id.resultText, 27);
        sViewsWithIds.put(R.id.bus_analyse_usb_result_save, 28);
        sViewsWithIds.put(R.id.header, 29);
        sViewsWithIds.put(R.id.result, 30);
        sViewsWithIds.put(R.id.poltText, 31);
        sViewsWithIds.put(R.id.plot_layout, 32);
        sViewsWithIds.put(R.id.polt, 33);
        sViewsWithIds.put(R.id.plot_y_layout, 34);
        sViewsWithIds.put(R.id.yruler9, 35);
        sViewsWithIds.put(R.id.plot_x_layout, 36);
        sViewsWithIds.put(R.id.xruler1, 37);
        sViewsWithIds.put(R.id.eyeText, 38);
        sViewsWithIds.put(R.id.eye_layout, 39);
        sViewsWithIds.put(R.id.eye, 40);
        sViewsWithIds.put(R.id.yruler1_1, 41);
        sViewsWithIds.put(R.id.yruler2_1, 42);
        sViewsWithIds.put(R.id.yruler3_1, 43);
        sViewsWithIds.put(R.id.yruler4_1, 44);
        sViewsWithIds.put(R.id.yruler5_1, 45);
        sViewsWithIds.put(R.id.yruler6_1, 46);
        sViewsWithIds.put(R.id.yruler7_1, 47);
        sViewsWithIds.put(R.id.yruler8_1, 48);
        sViewsWithIds.put(R.id.yruler9_1, 49);
        sViewsWithIds.put(R.id.eyexruler1_1, 50);
        sViewsWithIds.put(R.id.xruler2_1, 51);
        sViewsWithIds.put(R.id.xruler3_1, 52);
        sViewsWithIds.put(R.id.xruler4_1, 53);
        sViewsWithIds.put(R.id.xruler5_1, 54);
        sViewsWithIds.put(R.id.xruler6_1, 55);
        sViewsWithIds.put(R.id.xruler7_1, 56);
        sViewsWithIds.put(R.id.yruler1_11, 57);
        sViewsWithIds.put(R.id.yruler2_11, 58);
        sViewsWithIds.put(R.id.yruler3_11, 59);
        sViewsWithIds.put(R.id.yruler4_11, 60);
        sViewsWithIds.put(R.id.yruler5_11, 61);
        sViewsWithIds.put(R.id.yruler6_11, 62);
        sViewsWithIds.put(R.id.xruler1_11, 63);
        sViewsWithIds.put(R.id.xruler2_11, 64);
        sViewsWithIds.put(R.id.xruler3_11, 65);
        sViewsWithIds.put(R.id.xruler4_11, 66);
        sViewsWithIds.put(R.id.xruler5_11, 67);
        sViewsWithIds.put(R.id.xruler6_11, 68);
        sViewsWithIds.put(R.id.xruler7_11, 69);
        sViewsWithIds.put(R.id.xruler8_11, 70);
        sViewsWithIds.put(R.id.xruler9_11, 71);
        sViewsWithIds.put(R.id.yruler1_2, 72);
        sViewsWithIds.put(R.id.yruler2_2, 73);
        sViewsWithIds.put(R.id.yruler3_2, 74);
        sViewsWithIds.put(R.id.yruler4_2, 75);
        sViewsWithIds.put(R.id.yruler5_2, 76);
        sViewsWithIds.put(R.id.yruler6_2, 77);
        sViewsWithIds.put(R.id.yruler7_2, 78);
        sViewsWithIds.put(R.id.yruler8_2, 79);
        sViewsWithIds.put(R.id.yruler9_2, 80);
        sViewsWithIds.put(R.id.yruler10_2, 81);
        sViewsWithIds.put(R.id.yruler11_2, 82);
        sViewsWithIds.put(R.id.xruler1_2, 83);
        sViewsWithIds.put(R.id.xruler2_2, 84);
        sViewsWithIds.put(R.id.xruler3_2, 85);
        sViewsWithIds.put(R.id.xruler4_2, 86);
        sViewsWithIds.put(R.id.xruler5_2, 87);
    }

    public PopupviewAnalyseUsbResultBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 88, sIncludes, sViewsWithIds));
    }

    private PopupviewAnalyseUsbResultBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (Button) objArr[28], (ImageView) objArr[40], (ConstraintLayout) objArr[22], (ConstraintLayout) objArr[21], (ConstraintLayout) objArr[20], (ConstraintLayout) objArr[19], (ConstraintLayout) objArr[24], (ConstraintLayout) objArr[23], (ConstraintLayout) objArr[39], (TextView) objArr[38], (TextView) objArr[50], (RecyclerView) objArr[29], (ConstraintLayout) objArr[32], (ConstraintLayout) objArr[36], (ConstraintLayout) objArr[34], (ImageView) objArr[33], (TextView) objArr[31], (RecyclerView) objArr[30], (TextView) objArr[27], (ScrollView) objArr[26], (View) objArr[25], (TextView) objArr[37], (TextView) objArr[17], (TextView) objArr[18], (TextView) objArr[63], (TextView) objArr[83], (TextView) objArr[9], (TextView) objArr[51], (TextView) objArr[64], (TextView) objArr[84], (TextView) objArr[10], (TextView) objArr[52], (TextView) objArr[65], (TextView) objArr[85], (TextView) objArr[11], (TextView) objArr[53], (TextView) objArr[66], (TextView) objArr[86], (TextView) objArr[12], (TextView) objArr[54], (TextView) objArr[67], (TextView) objArr[87], (TextView) objArr[13], (TextView) objArr[55], (TextView) objArr[68], (TextView) objArr[14], (TextView) objArr[56], (TextView) objArr[69], (TextView) objArr[15], (TextView) objArr[70], (TextView) objArr[16], (TextView) objArr[71], (TextView) objArr[1], (TextView) objArr[81], (TextView) objArr[41], (TextView) objArr[57], (TextView) objArr[82], (TextView) objArr[72], (TextView) objArr[2], (TextView) objArr[42], (TextView) objArr[58], (TextView) objArr[73], (TextView) objArr[3], (TextView) objArr[43], (TextView) objArr[59], (TextView) objArr[74], (TextView) objArr[4], (TextView) objArr[44], (TextView) objArr[60], (TextView) objArr[75], (TextView) objArr[5], (TextView) objArr[45], (TextView) objArr[61], (TextView) objArr[76], (TextView) objArr[6], (TextView) objArr[46], (TextView) objArr[62], (TextView) objArr[77], (TextView) objArr[7], (TextView) objArr[47], (TextView) objArr[78], (TextView) objArr[8], (TextView) objArr[48], (TextView) objArr[79], (TextView) objArr[35], (TextView) objArr[49], (TextView) objArr[80]);
        this.mDirtyFlags = -1L;
        this.eye11Xlayout.setTag(null);
        this.eye11Ylayout.setTag(null);
        this.eye1Xlayout.setTag(null);
        this.eye1Ylayout.setTag(null);
        this.eye2Xlayout.setTag(null);
        this.eye2Ylayout.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.xruler10.setTag(null);
        this.xruler11.setTag(null);
        this.xruler2.setTag(null);
        this.xruler3.setTag(null);
        this.xruler4.setTag(null);
        this.xruler5.setTag(null);
        this.xruler6.setTag(null);
        this.xruler7.setTag(null);
        this.xruler8.setTag(null);
        this.xruler9.setTag(null);
        this.yruler1.setTag(null);
        this.yruler2.setTag(null);
        this.yruler3.setTag(null);
        this.yruler4.setTag(null);
        this.yruler5.setTag(null);
        this.yruler6.setTag(null);
        this.yruler7.setTag(null);
        this.yruler8.setTag(null);
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
        if (594 == i) {
            setParam((BusAnalyseUsbParam) obj);
            return true;
        }
        return false;
    }

    @Override // com.rigol.scope.databinding.PopupviewAnalyseUsbResultBinding
    public void setParam(BusAnalyseUsbParam busAnalyseUsbParam) {
        updateRegistration(0, busAnalyseUsbParam);
        this.mParam = busAnalyseUsbParam;
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
        return onChangeParam((BusAnalyseUsbParam) obj, i2);
    }

    private boolean onChangeParam(BusAnalyseUsbParam busAnalyseUsbParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i == 899) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        } else if (i == 898) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else if (i == 1011) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        } else {
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:113:0x032b  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x033b  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x035e  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x036c  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x03a9  */
    /* JADX WARN: Removed duplicated region for block: B:136:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x02c7  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x02ce  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x02d8  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 1000
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rigol.scope.databinding.PopupviewAnalyseUsbResultBindingImpl.executeBindings():void");
    }
}
