package javax.mail.event;

import java.util.EventListener;
/* loaded from: classes2.dex */
public interface TransportListener extends EventListener {
    void messageDelivered(TransportEvent transportEvent);

    void messageNotDelivered(TransportEvent transportEvent);

    void messagePartiallyDelivered(TransportEvent transportEvent);
}
