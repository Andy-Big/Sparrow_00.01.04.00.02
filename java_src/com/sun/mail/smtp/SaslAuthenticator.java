package com.sun.mail.smtp;

import javax.mail.MessagingException;
/* loaded from: classes2.dex */
public interface SaslAuthenticator {
    boolean authenticate(String[] strArr, String str, String str2, String str3, String str4) throws MessagingException;
}
