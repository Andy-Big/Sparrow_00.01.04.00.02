package com.rigol.scope.adapters;

import android.content.Context;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.SPUtils;
import com.rigol.pinyinkeyboard.ExternalInterface;
import com.rigol.scope.R;
import com.rigol.scope.adapters.UtilityEmailAdapter;
import com.rigol.scope.data.MailContext;
import com.rigol.scope.databinding.AdapterUtilityEmailBinding;
import com.rigol.scope.utilities.MailUtil;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.util.ToastUtils;
import java.util.Objects;

/* loaded from: classes.dex */
public class UtilityEmailAdapter extends RecyclerView.Adapter<EmailViewHolder> implements View.OnClickListener {
    private View baseView;
    private AdapterUtilityEmailBinding binding;
    private Context context;
    private boolean hidePassword;
    private MailContext mailContext;

    /* JADX DEBUG: Method not inlined, still used in: [com.rigol.scope.adapters.-$$Lambda$UtilityEmailAdapter$W_1QDHFwQXt56TB-2R3opg3crPw.resultShow(java.lang.String):void] */
    /* renamed from: lambda$W_1QDHFwQXt56TB-2R3opg3crPw */
    public static /* synthetic */ void m11lambda$W_1QDHFwQXt56TB2R3opg3crPw(EditText editText, CharSequence charSequence) {
        editText.setText(charSequence);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return 1;
    }

    public UtilityEmailAdapter(Context context, View view) {
        this.context = context;
        this.baseView = view;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public EmailViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        this.binding = AdapterUtilityEmailBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        this.mailContext = new MailContext();
        return new EmailViewHolder(this.binding);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final EmailViewHolder emailViewHolder, int i) {
        ViewUtil.setSwitchButton(this.binding.switchButtonSecurityProtocol);
        initMail();
        initClick();
        emailViewHolder.binding.buttonSend.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$UtilityEmailAdapter$NFjcFKZgF5Dbg4pk3BXI81Xjd44
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UtilityEmailAdapter.this.lambda$onBindViewHolder$2$UtilityEmailAdapter(emailViewHolder, view);
            }
        });
        emailViewHolder.binding.imgPasswodEye.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$UtilityEmailAdapter$3m-RKGwNu5-4xCmAc29j6JAJJw4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UtilityEmailAdapter.lambda$onBindViewHolder$3(UtilityEmailAdapter.EmailViewHolder.this, view);
            }
        });
        emailViewHolder.binding.switchButtonSecurityProtocol.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$UtilityEmailAdapter$u2Xw9cBDX6lbkSeqVtSR7A_fhVo
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                UtilityEmailAdapter.this.lambda$onBindViewHolder$4$UtilityEmailAdapter(emailViewHolder, compoundButton, z);
            }
        });
        emailViewHolder.binding.imgPasswodEye.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$UtilityEmailAdapter$CTgeye4HI2kLuAMeAryYsxFVVEM
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UtilityEmailAdapter.this.lambda$onBindViewHolder$5$UtilityEmailAdapter(emailViewHolder, view);
            }
        });
    }

    public /* synthetic */ void lambda$onBindViewHolder$2$UtilityEmailAdapter(EmailViewHolder emailViewHolder, View view) {
        if ("".equals(emailViewHolder.binding.edtSmtp.getText().toString())) {
            this.mailContext.setMailServerHost("smtp.163.com");
        } else {
            this.mailContext.setMailServerHost(emailViewHolder.binding.edtSmtp.getText().toString());
        }
        this.mailContext.setMailServerPort("25");
        emailViewHolder.binding.edtUserName.requestFocus();
        this.mailContext.setValidate(true);
        this.mailContext.setUserName(emailViewHolder.binding.edtUserName.getText().toString().split("@")[0]);
        this.mailContext.setPassword(emailViewHolder.binding.edtPassword.getText().toString());
        this.mailContext.setFromAddress(emailViewHolder.binding.edtUserName.getText().toString());
        this.mailContext.setToAddress(emailViewHolder.binding.edtEmailReceiver.getText().toString());
        this.mailContext.setSubject(emailViewHolder.binding.edtEmailSubject.getText().toString());
        this.mailContext.setBody(emailViewHolder.binding.edtEmailContent.getText().toString());
        new Thread(new Runnable() { // from class: com.rigol.scope.adapters.-$$Lambda$UtilityEmailAdapter$p3s5VGiBLS1MaYkXnDjz4HUTn_A
            @Override // java.lang.Runnable
            public final void run() {
                UtilityEmailAdapter.this.lambda$onBindViewHolder$1$UtilityEmailAdapter();
            }
        }, "send-email").start();
    }

    public /* synthetic */ void lambda$onBindViewHolder$1$UtilityEmailAdapter() {
        SPUtils.getInstance().put("email_smtp", this.binding.edtSmtp.getText().toString());
        SPUtils.getInstance().put("email_user", this.binding.edtUserName.getText().toString());
        SPUtils.getInstance().put("email_password", this.binding.edtPassword.getText().toString());
        final boolean sendMail = MailUtil.sendMail(this.mailContext, null);
        ActivityUtils.getTopActivity().runOnUiThread(new Runnable() { // from class: com.rigol.scope.adapters.-$$Lambda$UtilityEmailAdapter$9T4r55SVRLgsW4HcqK7kkP12RIo
            @Override // java.lang.Runnable
            public final void run() {
                UtilityEmailAdapter.lambda$onBindViewHolder$0(sendMail);
            }
        });
    }

    static /* synthetic */ void lambda$onBindViewHolder$0(boolean z) {
        if (z) {
            ToastUtils.showShort("邮件发送成功");
        } else {
            ToastUtils.showShort("邮件发送失败");
        }
    }

    /* JADX DEBUG: Method not inlined, still used in: [com.rigol.scope.adapters.-$$Lambda$UtilityEmailAdapter$3m-RKGwNu5-4xCmAc29j6JAJJw4.onClick(android.view.View):void] */
    static /* synthetic */ void lambda$onBindViewHolder$3(EmailViewHolder emailViewHolder, View view) {
        emailViewHolder.binding.switchButtonSecurityProtocol.toggle();
    }

    public /* synthetic */ void lambda$onBindViewHolder$4$UtilityEmailAdapter(EmailViewHolder emailViewHolder, CompoundButton compoundButton, boolean z) {
        this.mailContext.setProtocol(emailViewHolder.binding.switchButtonSecurityProtocol.isChecked());
    }

    public /* synthetic */ void lambda$onBindViewHolder$5$UtilityEmailAdapter(EmailViewHolder emailViewHolder, View view) {
        if (this.hidePassword) {
            emailViewHolder.binding.edtPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            emailViewHolder.binding.edtPassword.setSelection(emailViewHolder.binding.edtPassword.getText().length());
            this.hidePassword = true;
            return;
        }
        emailViewHolder.binding.edtPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
        emailViewHolder.binding.edtPassword.setSelection(emailViewHolder.binding.edtPassword.getText().length());
        this.hidePassword = false;
    }

    private void initClick() {
        this.binding.edtUserName.setOnClickListener(this);
        this.binding.edtPassword.setOnClickListener(this);
        this.binding.edtEmailReceiver.setOnClickListener(this);
        this.binding.edtEmailSubject.setOnClickListener(this);
        this.binding.edtSmtp.setOnClickListener(this);
        this.binding.edtEmailContent.setOnClickListener(this);
    }

    private void initMail() {
        String string = SPUtils.getInstance().getString("email_smtp", "smtp.163.com");
        String string2 = SPUtils.getInstance().getString("email_user");
        String string3 = SPUtils.getInstance().getString("email_password");
        this.binding.edtSmtp.setText(string);
        this.binding.edtUserName.setText(string2);
        this.binding.edtPassword.setText(string3);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.edt_email_content /* 2131362750 */:
                showTypeWritingPop(this.binding.edtEmailContent);
                return;
            case R.id.edt_email_receiver /* 2131362751 */:
                showTypeWritingPop(this.binding.edtEmailReceiver);
                return;
            case R.id.edt_email_subject /* 2131362752 */:
                showTypeWritingPop(this.binding.edtEmailSubject);
                return;
            case R.id.edt_hostName_value /* 2131362753 */:
            case R.id.edt_newPassword /* 2131362754 */:
            case R.id.edt_oldPassword /* 2131362755 */:
            default:
                return;
            case R.id.edt_password /* 2131362756 */:
                showTypeWritingPop(this.binding.edtPassword);
                return;
            case R.id.edt_smtp /* 2131362757 */:
                showTypeWritingPop(this.binding.edtSmtp);
                return;
            case R.id.edt_userName /* 2131362758 */:
                showTypeWritingPop(this.binding.edtUserName);
                return;
        }
    }

    private void showTypeWritingPop(final EditText editText) {
        Context context = this.context;
        View view = this.baseView;
        Objects.requireNonNull(editText);
        ViewUtil.showPinyinKeyboard(context, view, editText, new ExternalInterface() { // from class: com.rigol.scope.adapters.-$$Lambda$UtilityEmailAdapter$W_1QDHFwQXt56TB-2R3opg3crPw
            @Override // com.rigol.pinyinkeyboard.ExternalInterface
            public final void resultShow(String str) {
                UtilityEmailAdapter.m11lambda$W_1QDHFwQXt56TB2R3opg3crPw(editText, str);
            }
        });
    }

    /* loaded from: classes.dex */
    public class EmailViewHolder extends RecyclerView.ViewHolder {
        private AdapterUtilityEmailBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public EmailViewHolder(AdapterUtilityEmailBinding adapterUtilityEmailBinding) {
            super(adapterUtilityEmailBinding.getRoot());
            UtilityEmailAdapter.this = r1;
            this.binding = adapterUtilityEmailBinding;
        }
    }
}
