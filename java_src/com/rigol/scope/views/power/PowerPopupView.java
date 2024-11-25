package com.rigol.scope.views.power;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import com.blankj.utilcode.util.ShellUtils;
import com.blankj.utilcode.util.Utils;
import com.rigol.scope.BaseApplicationContext;
import com.rigol.scope.R;
import com.rigol.scope.cil.API;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.databinding.PopupviewPowerBinding;
import com.rigol.scope.viewmodels.PanelKeyViewModel;
import com.rigol.scope.views.baseview.BasePopupView;
import java.io.PrintStream;
import java.util.Objects;
import timber.log.Timber;
/* loaded from: classes2.dex */
public class PowerPopupView extends BasePopupView implements View.OnClickListener, PopupWindow.OnDismissListener {
    private PopupviewPowerBinding binding;

    public PowerPopupView() {
        super((int) R.style.App_PopupWindow_Common_Alert);
        PopupviewPowerBinding inflate = PopupviewPowerBinding.inflate(LayoutInflater.from(this.context));
        this.binding = inflate;
        setContentView(inflate.getRoot());
        this.binding.buttonSleep.setOnClickListener(this);
        this.binding.buttonRestart.setOnClickListener(this);
        this.binding.buttonShutdowm.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id != R.id.button_sleep) {
            if (id == R.id.button_shutdowm) {
                API.getInstance().UI_PostInt32(11, MessageID.MSG_HARDWARE_POWERDOWN, 1);
                return;
            } else if (id == R.id.button_restart) {
                API.getInstance().UI_PostInt32(11, MessageID.MSG_HARDWARE_RESTART, 0);
                return;
            } else {
                return;
            }
        }
        ShellUtils.execCmdAsync("rmmod /rigol/driver/focaltech_ts.ko", true, (Utils.Consumer<ShellUtils.CommandResult>) new Utils.Consumer() { // from class: com.rigol.scope.views.power.-$$Lambda$PowerPopupView$GkrNGLGx6TOvATp1e2GRBKdMzX8
            @Override // com.blankj.utilcode.util.Utils.Consumer
            public final void accept(Object obj) {
                Timber.d(((ShellUtils.CommandResult) obj).toString(), new Object[0]);
            }
        });
        for (int i = 0; i < ServiceEnum.PanelLed.ALL_LEDS.value1; i++) {
            API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, i, 0);
        }
        Intent intent = new Intent();
        intent.setAction("com.rigol.watchdog.QuickOpenStatus");
        intent.putExtra("quickOpenStatus", "0");
        Context context = BaseApplicationContext.getContext();
        if (context != null) {
            context.sendBroadcast(intent);
        }
        final PrintStream printStream = System.out;
        Objects.requireNonNull(printStream);
        ShellUtils.execCmdAsync("su -c \"/rigol/shell/quick_boot_test.sh off\"", true, (Utils.Consumer<ShellUtils.CommandResult>) new Utils.Consumer() { // from class: com.rigol.scope.views.power.-$$Lambda$PowerPopupView$f0rZkPNCQYOQPYmV9rAXrEPzgsc
            @Override // com.blankj.utilcode.util.Utils.Consumer
            public final void accept(Object obj) {
                printStream.println((ShellUtils.CommandResult) obj);
            }
        });
    }

    @Override // com.rigol.scope.views.baseview.BasePopupView, android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        super.onDismiss();
        PanelKeyViewModel.isPowerDown = false;
        API.getInstance().UI_PostInt32(11, MessageID.MSG_HARDWARE_POWERDOWN, 0);
    }
}
