package com.rigol.scope.data;

import android.text.TextUtils;
import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.NetworkUtils;
import com.blankj.utilcode.util.ThreadUtils;
import com.blankj.utilcode.util.Utils;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.util.EthernetUtil;
import java.net.InetAddress;
import javax.jmdns.impl.JmDNSImpl;
import kotlin.Metadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IOParam.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class IOParam$apply$4 implements Runnable {
    final /* synthetic */ IOParam this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public IOParam$apply$4(IOParam iOParam) {
        this.this$0 = iOParam;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (EthernetUtil.checkConflict(this.this$0.getIpAddress())) {
            ThreadUtils.runOnUiThread(new Runnable() { // from class: com.rigol.scope.data.IOParam$apply$4.1
                @Override // java.lang.Runnable
                public final void run() {
                    IOParam$apply$4.this.this$0.setStatus(ServiceEnum.tagNET_STATUS_EN.NET_STATUS_IPCONFLICT);
                }
            });
        } else if (EthernetUtil.checkInvalid(this.this$0.getIpAddress())) {
            ThreadUtils.runOnUiThread(new Runnable() { // from class: com.rigol.scope.data.IOParam$apply$4.2
                @Override // java.lang.Runnable
                public final void run() {
                    IOParam$apply$4.this.this$0.setStatus(ServiceEnum.tagNET_STATUS_EN.NET_STATUS_INVALID_IP);
                }
            });
        } else {
            ThreadUtils.runOnUiThread(new Runnable() { // from class: com.rigol.scope.data.IOParam$apply$4.3
                @Override // java.lang.Runnable
                public final void run() {
                    EthernetUtil.setStaticIp(ActivityUtils.getTopActivity(), IOParam$apply$4.this.this$0.getIpAddress(), IOParam$apply$4.this.this$0.getMask(), IOParam$apply$4.this.this$0.getGateway(), IOParam$apply$4.this.this$0.getDns());
                }
            });
            if (this.this$0.getMdns()) {
                ThreadUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.rigol.scope.data.IOParam$apply$4.4
                    @Override // java.lang.Runnable
                    public final void run() {
                        NetworkUtils.isAvailableAsync(new Utils.Consumer<Boolean>() { // from class: com.rigol.scope.data.IOParam.apply.4.4.1
                            @Override // com.blankj.utilcode.util.Utils.Consumer
                            public final void accept(Boolean bool) {
                                if (TextUtils.isEmpty(IOParam$apply$4.this.this$0.getIpAddress()) || TextUtils.isEmpty(IOParam$apply$4.this.this$0.getHostName())) {
                                    return;
                                }
                                try {
                                    IOParam$apply$4.this.this$0.setJmDNS(new JmDNSImpl(InetAddress.getByName(IOParam$apply$4.this.this$0.getIpAddress()), IOParam$apply$4.this.this$0.getHostName()));
                                    IOParam$apply$4.this.this$0.applyMdns(true);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                    }
                }, 3000L);
            } else {
                this.this$0.applyMdns(false);
            }
        }
    }
}
