package com.sun.mail.iap;
/* loaded from: classes2.dex */
public class ConnectionException extends ProtocolException {
    private static final long serialVersionUID = 5749739604257464727L;
    private transient Protocol p;

    public ConnectionException() {
    }

    public ConnectionException(String str) {
        super(str);
    }

    public ConnectionException(Protocol protocol, Response response) {
        super(response);
        this.p = protocol;
    }

    public Protocol getProtocol() {
        return this.p;
    }
}
