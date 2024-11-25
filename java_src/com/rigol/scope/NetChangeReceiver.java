package com.rigol.scope;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.lifecycle.LiveData;
import com.rigol.scope.cil.API;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.IOParam;
import com.rigol.scope.data.SharedParam;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.viewmodels.IOViewModel;
import com.rigol.scope.viewmodels.SharedViewModel;
import com.rigol.util.EthernetUtil;
import com.rigol.util.ToastUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: NetChangeReceiver.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/rigol/scope/NetChangeReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes.dex */
public class NetChangeReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        LiveData<SharedParam> liveData;
        SharedParam value;
        LiveData<SharedParam> liveData2;
        SharedParam value2;
        LiveData<IOParam> liveData3;
        IOParam value3;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        ToastUtils.INSTANCE.show("LENGTH_LONG", 1);
        ServiceEnum.tagNET_STATUS_EN networkStatus = ViewUtil.getNetworkStatus(EthernetUtil.getEthernetConnectState(context));
        IOViewModel iOViewModel = (IOViewModel) ContextUtil.getAppViewModel(IOViewModel.class);
        if (iOViewModel != null && (liveData3 = iOViewModel.getLiveData()) != null && (value3 = liveData3.getValue()) != null) {
            ViewUtil.getNetworkInfo(context, value3);
        }
        if (networkStatus == ServiceEnum.tagNET_STATUS_EN.NET_STATUS_CONNECTED) {
            if (context.getApplicationContext() instanceof App) {
                Context applicationContext = context.getApplicationContext();
                if (applicationContext == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.rigol.scope.App");
                }
                if (((App) applicationContext).isAppForeground()) {
                    ToastUtils.showShort((int) R.string.inf_lan_connected);
                }
            }
            SharedViewModel sharedViewModel = (SharedViewModel) ContextUtil.getAppViewModel(SharedViewModel.class);
            if (sharedViewModel == null || (liveData2 = sharedViewModel.getLiveData()) == null || (value2 = liveData2.getValue()) == null) {
                return;
            }
            value2.setShowNetwork(true);
        } else if (networkStatus == ServiceEnum.tagNET_STATUS_EN.NET_STATUS_UNLINK) {
            if (context.getApplicationContext() instanceof App) {
                Context applicationContext2 = context.getApplicationContext();
                if (applicationContext2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.rigol.scope.App");
                }
                if (((App) applicationContext2).isAppForeground()) {
                    ToastUtils.showShort((int) R.string.inf_lan_disconnected);
                }
            }
            SharedViewModel sharedViewModel2 = (SharedViewModel) ContextUtil.getAppViewModel(SharedViewModel.class);
            if (sharedViewModel2 != null && (liveData = sharedViewModel2.getLiveData()) != null && (value = liveData.getValue()) != null) {
                value.setShowNetwork(false);
            }
            API.getInstance().UI_PostInt32(15, MessageID.MSG_SCPI_SOCKET_DISCONNECT, 0);
        }
    }
}
