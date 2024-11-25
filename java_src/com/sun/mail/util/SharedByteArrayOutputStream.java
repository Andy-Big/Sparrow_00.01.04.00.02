package com.sun.mail.util;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import javax.mail.util.SharedByteArrayInputStream;
/* loaded from: classes2.dex */
public class SharedByteArrayOutputStream extends ByteArrayOutputStream {
    public SharedByteArrayOutputStream(int i) {
        super(i);
    }

    public InputStream toStream() {
        return new SharedByteArrayInputStream(this.buf, 0, this.count);
    }
}
