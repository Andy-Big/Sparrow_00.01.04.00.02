package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
import com.rigol.scope.views.SwitchButton;
/* loaded from: classes2.dex */
public abstract class AdapterUtilityEmailBinding extends ViewDataBinding {
    public final Button buttonDefault;
    public final Button buttonSend;
    public final ConstraintLayout constraintLayout29;
    public final ConstraintLayout constraintLayout3;
    public final ConstraintLayout constraintLayout30;
    public final EditText edtEmailContent;
    public final EditText edtEmailReceiver;
    public final EditText edtEmailSubject;
    public final EditText edtPassword;
    public final EditText edtSmtp;
    public final EditText edtUserName;
    public final ImageView imgPasswodEye;
    public final SwitchButton switchButtonSecurityProtocol;
    public final TextView tvAttachment;
    public final TextView tvAttachmentValue;
    public final TextView tvEmailContent;
    public final TextView tvEmailReceiver;
    public final TextView tvEmailSubject;
    public final TextView tvPassword;
    public final TextView tvSecurityProtocol;
    public final TextView tvSmtp;
    public final TextView tvUserName;
    public final View view12;
    public final View view13;

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterUtilityEmailBinding(Object obj, View view, int i, Button button, Button button2, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, EditText editText, EditText editText2, EditText editText3, EditText editText4, EditText editText5, EditText editText6, ImageView imageView, SwitchButton switchButton, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, View view2, View view3) {
        super(obj, view, i);
        this.buttonDefault = button;
        this.buttonSend = button2;
        this.constraintLayout29 = constraintLayout;
        this.constraintLayout3 = constraintLayout2;
        this.constraintLayout30 = constraintLayout3;
        this.edtEmailContent = editText;
        this.edtEmailReceiver = editText2;
        this.edtEmailSubject = editText3;
        this.edtPassword = editText4;
        this.edtSmtp = editText5;
        this.edtUserName = editText6;
        this.imgPasswodEye = imageView;
        this.switchButtonSecurityProtocol = switchButton;
        this.tvAttachment = textView;
        this.tvAttachmentValue = textView2;
        this.tvEmailContent = textView3;
        this.tvEmailReceiver = textView4;
        this.tvEmailSubject = textView5;
        this.tvPassword = textView6;
        this.tvSecurityProtocol = textView7;
        this.tvSmtp = textView8;
        this.tvUserName = textView9;
        this.view12 = view2;
        this.view13 = view3;
    }

    public static AdapterUtilityEmailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterUtilityEmailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterUtilityEmailBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_utility_email, viewGroup, z, obj);
    }

    public static AdapterUtilityEmailBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterUtilityEmailBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterUtilityEmailBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_utility_email, null, false, obj);
    }

    public static AdapterUtilityEmailBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterUtilityEmailBinding bind(View view, Object obj) {
        return (AdapterUtilityEmailBinding) bind(obj, view, R.layout.adapter_utility_email);
    }
}
