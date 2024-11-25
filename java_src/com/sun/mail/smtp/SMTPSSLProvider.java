package com.sun.mail.smtp;

import com.sun.mail.util.DefaultProvider;
import javax.mail.Provider;
@DefaultProvider
/* loaded from: classes2.dex */
public class SMTPSSLProvider extends Provider {
    public SMTPSSLProvider() {
        super(Provider.Type.TRANSPORT, "smtps", SMTPSSLTransport.class.getName(), "Oracle", null);
    }
}
