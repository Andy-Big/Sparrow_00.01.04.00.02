package com.rigol.scope.data;

import android.text.TextUtils;
import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.NetworkUtils;
import com.blankj.utilcode.util.ThreadUtils;
import com.blankj.utilcode.util.Utils;
import com.rigol.util.EthernetUtil;
import java.net.InetAddress;
import javax.jmdns.impl.JmDNSImpl;
import kotlin.Metadata;
/* compiled from: IOParam.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\r\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0002\u0010\u0004J\u0017\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"com/rigol/scope/data/IOParam$apply$3", "Lcom/blankj/utilcode/util/ThreadUtils$SimpleTask;", "", "doInBackground", "()Ljava/lang/Boolean;", "onSuccess", "", "result", "(Ljava/lang/Boolean;)V", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class IOParam$apply$3 extends ThreadUtils.SimpleTask<Boolean> {
    final /* synthetic */ IOParam this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public IOParam$apply$3(IOParam iOParam) {
        this.this$0 = iOParam;
    }

    @Override // com.blankj.utilcode.util.ThreadUtils.Task
    public Boolean doInBackground() {
        for (int i = 112; i <= 254; i++) {
            for (int i2 = 67; i2 <= 255; i2++) {
                String str = "169.254." + i + '.' + i2;
                if (!EthernetUtil.checkConflict(str)) {
                    this.this$0.saveIPAddress(str);
                    this.this$0.saveMask("255.255.0.0");
                    this.this$0.saveGateWay("169.254.1.1");
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.blankj.utilcode.util.ThreadUtils.Task
    public void onSuccess(Boolean bool) {
        if (bool != null && bool.booleanValue()) {
            EthernetUtil.setStaticIp(ActivityUtils.getTopActivity(), this.this$0.getIpAddress(), this.this$0.getMask(), this.this$0.getGateway(), this.this$0.getDns());
        }
        if (this.this$0.getMdns()) {
            ThreadUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.rigol.scope.data.IOParam$apply$3$onSuccess$2
                @Override // java.lang.Runnable
                public final void run() {
                    NetworkUtils.isAvailableAsync(new Utils.Consumer<Boolean>() { // from class: com.rigol.scope.data.IOParam$apply$3$onSuccess$2.1
                        @Override // com.blankj.utilcode.util.Utils.Consumer
                        public final void accept(Boolean bool2) {
                            if (TextUtils.isEmpty(IOParam$apply$3.this.this$0.getIpAddress()) || TextUtils.isEmpty(IOParam$apply$3.this.this$0.getHostName())) {
                                return;
                            }
                            try {
                                IOParam$apply$3.this.this$0.setJmDNS(new JmDNSImpl(InetAddress.getByName(IOParam$apply$3.this.this$0.getIpAddress()), IOParam$apply$3.this.this$0.getHostName()));
                                IOParam$apply$3.this.this$0.applyMdns(true);
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
