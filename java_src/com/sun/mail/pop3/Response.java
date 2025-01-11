package com.sun.mail.pop3;

import java.io.InputStream;

/* compiled from: Protocol.java */
/* loaded from: classes2.dex */
class Response {
    boolean ok = false;
    boolean cont = false;
    String data = null;
    InputStream bytes = null;

    Response() {
    }
}
