package com.sun.mail.util;

import javax.mail.MessagingException;
/* loaded from: classes2.dex */
public class MailConnectException extends MessagingException {
    private static final long serialVersionUID = -3818807731125317729L;
    private int cto;
    private String host;
    private int port;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public MailConnectException(com.sun.mail.util.SocketConnectException r4) {
        /*
            r3 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Couldn't connect to host, port: "
            r0.append(r1)
            java.lang.String r1 = r4.getHost()
            r0.append(r1)
            java.lang.String r1 = ", "
            r0.append(r1)
            int r1 = r4.getPort()
            r0.append(r1)
            java.lang.String r1 = "; timeout "
            r0.append(r1)
            int r1 = r4.getConnectionTimeout()
            r0.append(r1)
            java.lang.String r1 = r4.getMessage()
            if (r1 == 0) goto L45
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "; "
            r1.append(r2)
            java.lang.String r2 = r4.getMessage()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            goto L47
        L45:
            java.lang.String r1 = ""
        L47:
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r3.<init>(r0)
            java.lang.String r0 = r4.getHost()
            r3.host = r0
            int r0 = r4.getPort()
            r3.port = r0
            int r0 = r4.getConnectionTimeout()
            r3.cto = r0
            java.lang.Exception r4 = r4.getException()
            r3.setNextException(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.util.MailConnectException.<init>(com.sun.mail.util.SocketConnectException):void");
    }

    public String getHost() {
        return this.host;
    }

    public int getPort() {
        return this.port;
    }

    public int getConnectionTimeout() {
        return this.cto;
    }
}
