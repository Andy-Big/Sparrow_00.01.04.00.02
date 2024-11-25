package com.sun.mail.imap;

import com.sun.mail.util.DefaultProvider;
import javax.mail.Provider;
@DefaultProvider
/* loaded from: classes2.dex */
public class IMAPSSLProvider extends Provider {
    public IMAPSSLProvider() {
        super(Provider.Type.STORE, "imaps", IMAPSSLStore.class.getName(), "Oracle", null);
    }
}
