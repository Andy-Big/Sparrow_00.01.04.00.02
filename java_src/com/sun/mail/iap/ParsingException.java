package com.sun.mail.iap;
/* loaded from: classes2.dex */
public class ParsingException extends ProtocolException {
    private static final long serialVersionUID = 7756119840142724839L;

    public ParsingException() {
    }

    public ParsingException(String str) {
        super(str);
    }

    public ParsingException(Response response) {
        super(response);
    }
}
