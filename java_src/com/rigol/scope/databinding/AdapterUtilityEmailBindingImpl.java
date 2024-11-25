package com.rigol.scope.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
import com.rigol.scope.views.SwitchButton;
/* loaded from: classes2.dex */
public class AdapterUtilityEmailBindingImpl extends AdapterUtilityEmailBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.constraintLayout3, 1);
        sViewsWithIds.put(R.id.tv_userName, 2);
        sViewsWithIds.put(R.id.edt_userName, 3);
        sViewsWithIds.put(R.id.tv_password, 4);
        sViewsWithIds.put(R.id.constraintLayout30, 5);
        sViewsWithIds.put(R.id.edt_password, 6);
        sViewsWithIds.put(R.id.img_passwodEye, 7);
        sViewsWithIds.put(R.id.tv_email_receiver, 8);
        sViewsWithIds.put(R.id.edt_email_receiver, 9);
        sViewsWithIds.put(R.id.tv_email_subject, 10);
        sViewsWithIds.put(R.id.edt_email_subject, 11);
        sViewsWithIds.put(R.id.constraintLayout29, 12);
        sViewsWithIds.put(R.id.tv_smtp, 13);
        sViewsWithIds.put(R.id.edt_smtp, 14);
        sViewsWithIds.put(R.id.tv_security_protocol, 15);
        sViewsWithIds.put(R.id.switchButton_security_protocol, 16);
        sViewsWithIds.put(R.id.tv_email_content, 17);
        sViewsWithIds.put(R.id.edt_email_content, 18);
        sViewsWithIds.put(R.id.tv_attachment, 19);
        sViewsWithIds.put(R.id.button_send, 20);
        sViewsWithIds.put(R.id.button_default, 21);
        sViewsWithIds.put(R.id.tv_attachment_value, 22);
        sViewsWithIds.put(R.id.view12, 23);
        sViewsWithIds.put(R.id.view13, 24);
    }

    public AdapterUtilityEmailBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 25, sIncludes, sViewsWithIds));
    }

    private AdapterUtilityEmailBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (Button) objArr[21], (Button) objArr[20], (ConstraintLayout) objArr[12], (ConstraintLayout) objArr[1], (ConstraintLayout) objArr[5], (EditText) objArr[18], (EditText) objArr[9], (EditText) objArr[11], (EditText) objArr[6], (EditText) objArr[14], (EditText) objArr[3], (ImageView) objArr[7], (SwitchButton) objArr[16], (TextView) objArr[19], (TextView) objArr[22], (TextView) objArr[17], (TextView) objArr[8], (TextView) objArr[10], (TextView) objArr[4], (TextView) objArr[15], (TextView) objArr[13], (TextView) objArr[2], (View) objArr[23], (View) objArr[24]);
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
            this.mDirtyFlags = 1L;
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
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}
