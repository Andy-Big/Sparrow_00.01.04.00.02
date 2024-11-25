package com.sun.mail.imap.protocol;

import com.sun.mail.iap.ProtocolException;
/* loaded from: classes2.dex */
public class IMAPReferralException extends ProtocolException {
    private static final long serialVersionUID = 2578770669364251968L;
    private String url;

    public IMAPReferralException(String str, String str2) {
        super(str);
        this.url = str2;
    }

    public String getUrl() {
        return this.url;
    }
}
