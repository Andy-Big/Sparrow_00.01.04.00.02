package javax.mail.event;

import java.util.EventListener;
/* loaded from: classes2.dex */
public interface ConnectionListener extends EventListener {
    void closed(ConnectionEvent connectionEvent);

    void disconnected(ConnectionEvent connectionEvent);

    void opened(ConnectionEvent connectionEvent);
}
