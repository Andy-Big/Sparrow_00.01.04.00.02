package com.sun.mail.smtp;

import com.sun.mail.util.DefaultProvider;
import javax.mail.Provider;
@DefaultProvider
/* loaded from: classes2.dex */
public class SMTPProvider extends Provider {
    public SMTPProvider() {
        super(Provider.Type.TRANSPORT, "smtp", SMTPTransport.class.getName(), "Oracle", null);
    }
}
