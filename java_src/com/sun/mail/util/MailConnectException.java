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
    */
    public MailConnectException(SocketConnectException socketConnectException) {
        super(r0.toString());
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("Couldn't connect to host, port: ");
        sb.append(socketConnectException.getHost());
        sb.append(", ");
        sb.append(socketConnectException.getPort());
        sb.append("; timeout ");
        sb.append(socketConnectException.getConnectionTimeout());
        if (socketConnectException.getMessage() != null) {
            str = "; " + socketConnectException.getMessage();
        } else {
            str = "";
        }
        sb.append(str);
        this.host = socketConnectException.getHost();
        this.port = socketConnectException.getPort();
        this.cto = socketConnectException.getConnectionTimeout();
        setNextException(socketConnectException.getException());
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
