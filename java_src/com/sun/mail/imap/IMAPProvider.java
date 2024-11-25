package com.sun.mail.imap;

import com.sun.mail.util.DefaultProvider;
import javax.mail.Provider;
@DefaultProvider
/* loaded from: classes2.dex */
public class IMAPProvider extends Provider {
    public IMAPProvider() {
        super(Provider.Type.STORE, "imap", IMAPStore.class.getName(), "Oracle", null);
    }
}
