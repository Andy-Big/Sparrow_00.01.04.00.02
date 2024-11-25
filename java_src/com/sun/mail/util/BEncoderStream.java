package com.sun.mail.util;

import java.io.OutputStream;
/* loaded from: classes2.dex */
public class BEncoderStream extends BASE64EncoderStream {
    public BEncoderStream(OutputStream outputStream) {
        super(outputStream, Integer.MAX_VALUE);
    }

    public static int encodedLength(byte[] bArr) {
        return ((bArr.length + 2) / 3) * 4;
    }
}
