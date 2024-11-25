package com.sun.mail.imap;

import javax.mail.AuthenticationFailedException;
/* loaded from: classes2.dex */
public class ReferralException extends AuthenticationFailedException {
    private static final long serialVersionUID = -3414063558596287683L;
    private String text;
    private String url;

    public ReferralException(String str, String str2) {
        super("[REFERRAL " + str + "] " + str2);
        this.url = str;
        this.text = str2;
    }

    public String getUrl() {
        return this.url;
    }

    public String getText() {
        return this.text;
    }
}
