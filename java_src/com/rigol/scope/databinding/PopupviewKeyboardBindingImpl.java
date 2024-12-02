package com.rigol.scope.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.rigol.scope.R;
import com.rigol.scope.data.KeyboardParam;

/* loaded from: classes2.dex */
public class PopupviewKeyboardBindingImpl extends PopupviewKeyboardBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.edt_value, 6);
        sViewsWithIds.put(R.id.iv_key_1, 7);
        sViewsWithIds.put(R.id.iv_key_2, 8);
        sViewsWithIds.put(R.id.btn_one, 9);
        sViewsWithIds.put(R.id.btn_two, 10);
        sViewsWithIds.put(R.id.btn_three, 11);
        sViewsWithIds.put(R.id.btn_delete, 12);
        sViewsWithIds.put(R.id.btn_four, 13);
        sViewsWithIds.put(R.id.btn_five, 14);
        sViewsWithIds.put(R.id.btn_six, 15);
        sViewsWithIds.put(R.id.btn_max, 16);
        sViewsWithIds.put(R.id.btn_seven, 17);
        sViewsWithIds.put(R.id.btn_eight, 18);
        sViewsWithIds.put(R.id.btn_nine, 19);
        sViewsWithIds.put(R.id.btn_min, 20);
        sViewsWithIds.put(R.id.btn_decimalPoint, 21);
        sViewsWithIds.put(R.id.btn_zero, 22);
        sViewsWithIds.put(R.id.btn_PositiveOrNegative, 23);
        sViewsWithIds.put(R.id.btn_def, 24);
        sViewsWithIds.put(R.id.btn_exp, 25);
        sViewsWithIds.put(R.id.btn_ok, 26);
        sViewsWithIds.put(R.id.btn_cls, 27);
    }

    public PopupviewKeyboardBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 28, sIncludes, sViewsWithIds));
    }

    private PopupviewKeyboardBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (Button) objArr[27], (Button) objArr[21], (Button) objArr[24], (ImageButton) objArr[12], (Button) objArr[18], (Button) objArr[25], (Button) objArr[14], (Button) objArr[13], (Button) objArr[16], (Button) objArr[20], (Button) objArr[19], (Button) objArr[26], (Button) objArr[9], (Button) objArr[23], (Button) objArr[17], (Button) objArr[15], (Button) objArr[11], (Button) objArr[10], (Button) objArr[1], (Button) objArr[2], (Button) objArr[3], (Button) objArr[4], (Button) objArr[5], (Button) objArr[22], (EditText) objArr[6], (ImageView) objArr[7], (ImageView) objArr[8]);
        this.mDirtyFlags = -1L;
        this.btnUnit1.setTag(null);
        this.btnUnit2.setTag(null);
        this.btnUnit3.setTag(null);
        this.btnUnit4.setTag(null);
        this.btnUnit5.setTag(null);
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
            setParam((KeyboardParam) obj);
            return true;
        }
        return false;
    }

    @Override // com.rigol.scope.databinding.PopupviewKeyboardBinding
    public void setParam(KeyboardParam keyboardParam) {
        updateRegistration(0, keyboardParam);
        this.mParam = keyboardParam;
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
        return onChangeParam((KeyboardParam) obj, i2);
    }

    private boolean onChangeParam(KeyboardParam keyboardParam, int i) {
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
        long j;
        String str;
        String str2;
        String str3;
        String str4;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        KeyboardParam keyboardParam = this.mParam;
        int i = ((j & 3) > 0L ? 1 : ((j & 3) == 0L ? 0 : -1));
        String str5 = null;
        if (i == 0 || keyboardParam == null) {
            str = null;
            str2 = null;
            str3 = null;
            str4 = null;
        } else {
            String unitStr = keyboardParam.getUnitStr(4);
            String unitStr2 = keyboardParam.getUnitStr(0);
            str2 = keyboardParam.getUnitStr(3);
            str4 = keyboardParam.getUnitStr(2);
            str3 = keyboardParam.getUnitStr(1);
            str = unitStr;
            str5 = unitStr2;
        }
        if (i != 0) {
            TextViewBindingAdapter.setText(this.btnUnit1, str5);
            TextViewBindingAdapter.setText(this.btnUnit2, str3);
            TextViewBindingAdapter.setText(this.btnUnit3, str4);
            TextViewBindingAdapter.setText(this.btnUnit4, str2);
            TextViewBindingAdapter.setText(this.btnUnit5, str);
        }
    }
}
