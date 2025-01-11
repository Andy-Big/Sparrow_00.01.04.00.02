package com.sun.mail.smtp;

import javax.mail.SendFailedException;
import javax.mail.internet.InternetAddress;

/* loaded from: classes2.dex */
public class SMTPAddressFailedException extends SendFailedException {
    private static final long serialVersionUID = 804831199768630097L;
    protected InternetAddress addr;
    protected String cmd;
    protected int rc;

    public SMTPAddressFailedException(InternetAddress internetAddress, String str, int i, String str2) {
        super(str2);
        this.addr = internetAddress;
        this.cmd = str;
        this.rc = i;
    }

    public InternetAddress getAddress() {
        return this.addr;
    }

    public String getCommand() {
        return this.cmd;
    }

    public int getReturnCode() {
        return this.rc;
    }
}
