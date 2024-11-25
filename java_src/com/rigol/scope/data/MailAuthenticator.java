package com.rigol.scope.data;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
/* loaded from: classes2.dex */
public class MailAuthenticator extends Authenticator {
    String password;
    String userName;

    public MailAuthenticator(String str, String str2) {
        this.userName = str;
        this.password = str2;
    }

    @Override // javax.mail.Authenticator
    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(this.userName, this.password);
    }
}
