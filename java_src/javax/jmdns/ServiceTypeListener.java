package javax.jmdns;

import java.util.EventListener;
/* loaded from: classes2.dex */
public interface ServiceTypeListener extends EventListener {
    void serviceTypeAdded(ServiceEvent serviceEvent);

    void subTypeForServiceTypeAdded(ServiceEvent serviceEvent);
}
