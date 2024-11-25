package com.sun.mail.imap.protocol;

import com.sun.mail.iap.ProtocolException;
/* loaded from: classes2.dex */
public interface SaslAuthenticator {
    boolean authenticate(String[] strArr, String str, String str2, String str3, String str4) throws ProtocolException;
}
