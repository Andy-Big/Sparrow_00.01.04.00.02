package com.sun.mail.iap;
/* loaded from: classes2.dex */
public class CommandFailedException extends ProtocolException {
    private static final long serialVersionUID = 793932807880443631L;

    public CommandFailedException() {
    }

    public CommandFailedException(String str) {
        super(str);
    }

    public CommandFailedException(Response response) {
        super(response);
    }
}
