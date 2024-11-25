package com.sun.mail.smtp;

import javax.mail.Session;
import javax.mail.URLName;
/* loaded from: classes2.dex */
public class SMTPSSLTransport extends SMTPTransport {
    public SMTPSSLTransport(Session session, URLName uRLName) {
        super(session, uRLName, "smtps", true);
    }
}
