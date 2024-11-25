package com.rigol.scope.adapters;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.SnackbarUtils;
import com.rigol.scope.R;
import com.rigol.scope.cil.API;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.databinding.AdapterUtilityAutosettingBinding;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.PopupViewManager;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.viewmodels.AutosetViewModel;
import com.rigol.scope.views.alert.AutoLockPopupView;
import com.rigol.scope.views.auto.AutosetParam;
import com.rigol.scope.views.keyboard.KeyboardListener;
import com.rigol.scope.views.keyboard.KeyboardPopupView;
import com.rigol.util.ToastUtils;
import java.util.Objects;
/* loaded from: classes.dex */
public class UtilityAutoConfigAdapter extends RecyclerView.Adapter<AutoSettingHolder> implements CompoundButton.OnCheckedChangeListener, View.OnClickListener {
    private AutosetParam autosetParam;
    private View baseView;
    private AdapterUtilityAutosettingBinding binding;
    private Context context;
    private KeyboardPopupView keyboardPopupView;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return 1;
    }

    public UtilityAutoConfigAdapter(Context context, View view) {
        this.context = context;
        this.baseView = view;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public AutoSettingHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        this.binding = AdapterUtilityAutosettingBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        return new AutoSettingHolder(this.binding);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(AutoSettingHolder autoSettingHolder, int i) {
        initViewStyle();
        initViewState();
    }

    private void initViewState() {
        AutosetViewModel autosetViewModel = (AutosetViewModel) ContextUtil.getAppViewModel(AutosetViewModel.class);
        if (autosetViewModel != null) {
            AutosetParam value = autosetViewModel.getLiveData().getValue();
            this.autosetParam = value;
            this.binding.setParam(value);
        }
    }

    private void initViewStyle() {
        this.binding.lockLayout.setOnClickListener(this);
        ViewUtil.setSwitchButton(this.binding.switchAutorange);
        this.binding.autoRangeLayout.setOnClickListener(this);
        this.binding.switchAutorange.setOnCheckedChangeListener(this);
        ViewUtil.setSwitchButton(this.binding.switchChannel);
        this.binding.channelLayout.setOnClickListener(this);
        this.binding.switchChannel.setOnCheckedChangeListener(this);
        ViewUtil.setSwitchButton(this.binding.switchOverlay);
        this.binding.overlayLayout.setOnClickListener(this);
        this.binding.switchOverlay.setOnCheckedChangeListener(this);
        ViewUtil.setSwitchButton(this.binding.switchKeepcoup);
        this.binding.switchKeepcoup.setOnCheckedChangeListener(this);
        this.binding.keepcoupLayout.setOnClickListener(this);
        this.binding.edtOldPassword.setOnClickListener(this);
        this.binding.edtNewPassword.setOnClickListener(this);
        this.binding.edtConfirmPassword.setOnClickListener(this);
        this.binding.configuration.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.auto_range_layout /* 2131361988 */:
                this.binding.switchAutorange.setPressed(true);
                this.binding.switchAutorange.toggle();
                return;
            case R.id.channel_layout /* 2131362251 */:
                this.binding.switchChannel.setPressed(true);
                this.binding.switchChannel.toggle();
                return;
            case R.id.configuration /* 2131362303 */:
                try {
                    if (!Objects.equals(this.binding.edtOldPassword.getText().toString(), this.autosetParam.getPassword().getValue())) {
                        ToastUtils.showShort(this.context.getResources().getString(R.string.err_invalid_old));
                        return;
                    }
                    String obj = this.binding.edtNewPassword.getText().toString();
                    if (!obj.equals(this.binding.edtConfirmPassword.getText().toString())) {
                        ToastUtils.showShort(this.context.getResources().getString(R.string.err_two_different));
                        return;
                    } else {
                        this.autosetParam.getPassword().save(obj);
                        return;
                    }
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    return;
                }
            case R.id.edt_confirmPassword /* 2131362749 */:
                if (this.autosetParam != null) {
                    ViewUtil.showKeyboard(this.baseView, view, ServiceEnum.Unit.Unit_number, this.autosetParam.getPasswordAttr().getMaxIntValue(), this.autosetParam.getPasswordAttr().getMinIntValue(), this.autosetParam.getPasswordAttr().getDefIntValue(), 0L, new KeyboardListener() { // from class: com.rigol.scope.adapters.UtilityAutoConfigAdapter.3
                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public <T> void resultMinUnitValueListener(T t) {
                            UtilityAutoConfigAdapter.this.binding.edtConfirmPassword.setText(t.toString());
                        }

                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public void onCall(KeyboardPopupView keyboardPopupView) {
                            UtilityAutoConfigAdapter.this.keyboardPopupView = keyboardPopupView;
                        }
                    });
                    return;
                }
                return;
            case R.id.edt_newPassword /* 2131362754 */:
                if (this.autosetParam != null) {
                    ViewUtil.showKeyboard(this.baseView, view, ServiceEnum.Unit.Unit_number, this.autosetParam.getPasswordAttr().getMaxIntValue(), this.autosetParam.getPasswordAttr().getMinIntValue(), this.autosetParam.getPasswordAttr().getDefIntValue(), 0L, new KeyboardListener() { // from class: com.rigol.scope.adapters.UtilityAutoConfigAdapter.2
                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public <T> void resultMinUnitValueListener(T t) {
                            UtilityAutoConfigAdapter.this.binding.edtNewPassword.setText(t.toString());
                        }

                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public void onCall(KeyboardPopupView keyboardPopupView) {
                            UtilityAutoConfigAdapter.this.keyboardPopupView = keyboardPopupView;
                        }
                    });
                    return;
                }
                return;
            case R.id.edt_oldPassword /* 2131362755 */:
                if (this.autosetParam != null) {
                    ViewUtil.showKeyboard(this.baseView, view, ServiceEnum.Unit.Unit_number, this.autosetParam.getPasswordAttr().getMaxIntValue(), this.autosetParam.getPasswordAttr().getMinIntValue(), this.autosetParam.getPasswordAttr().getDefIntValue(), 0L, new KeyboardListener() { // from class: com.rigol.scope.adapters.UtilityAutoConfigAdapter.1
                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public <T> void resultMinUnitValueListener(T t) {
                            UtilityAutoConfigAdapter.this.binding.edtOldPassword.setText(t.toString());
                        }

                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public void onCall(KeyboardPopupView keyboardPopupView) {
                            UtilityAutoConfigAdapter.this.keyboardPopupView = keyboardPopupView;
                        }
                    });
                    return;
                }
                return;
            case R.id.keepcoup_layout /* 2131363211 */:
                this.binding.switchKeepcoup.setPressed(true);
                this.binding.switchKeepcoup.toggle();
                return;
            case R.id.lock_layout /* 2131363333 */:
                clickLock();
                return;
            case R.id.overlay_layout /* 2131363528 */:
                this.binding.switchOverlay.setPressed(true);
                this.binding.switchOverlay.toggle();
                return;
            default:
                return;
        }
    }

    private void clickLock() {
        if (API.getInstance().UI_QueryBool(35, 776)) {
            EditText editText = new EditText(this.context);
            editText.setInputType(129);
            AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
            builder.setIcon(R.drawable.ic_back);
            builder.setTitle("输入解锁密码");
            builder.setView(editText);
            builder.setPositiveButton(this.context.getString(R.string.msg_gui_menu_ask), new DialogInterface.OnClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$UtilityAutoConfigAdapter$Pr2_2TLlbt3KNRNJ5RDXe1rswso
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    UtilityAutoConfigAdapter.this.lambda$clickLock$0$UtilityAutoConfigAdapter(dialogInterface, i);
                }
            });
            builder.setNegativeButton(this.context.getString(R.string.autoset_20), new DialogInterface.OnClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$UtilityAutoConfigAdapter$rPRtsMap6sePf8doxU2KlA51kiE
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    SnackbarUtils.dismiss();
                }
            });
            builder.show();
            return;
        }
        PopupViewManager.getInstance().show(AutoLockPopupView.class);
    }

    public /* synthetic */ void lambda$clickLock$0$UtilityAutoConfigAdapter(DialogInterface dialogInterface, int i) {
        this.binding.imageViewLock.setImageResource(R.drawable.unlock);
        API.getInstance().UI_PostBool(35, 776, false);
        ToastUtils.showShort(this.context.getResources().getString(R.string.err_auto_unlocked));
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (compoundButton.isPressed() && this.autosetParam != null) {
            int id = compoundButton.getId();
            if (id == R.id.switch_autorange) {
                this.autosetParam.getRange().save(Boolean.valueOf(z));
            } else if (id == R.id.switch_channel) {
                this.autosetParam.getChannel().save(Boolean.valueOf(z));
            } else if (id == R.id.switch_overlay) {
                this.autosetParam.getOverlay().save(Boolean.valueOf(z));
            } else if (id == R.id.switch_keepcoup) {
                this.autosetParam.getKeepcoup().save(Boolean.valueOf(z));
            }
        }
    }

    /* loaded from: classes.dex */
    public static class AutoSettingHolder extends RecyclerView.ViewHolder {
        private AdapterUtilityAutosettingBinding binding;

        public AutoSettingHolder(AdapterUtilityAutosettingBinding adapterUtilityAutosettingBinding) {
            super(adapterUtilityAutosettingBinding.getRoot());
            this.binding = adapterUtilityAutosettingBinding;
        }
    }
}
