package com.sun.mail.util;

import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes2.dex */
public class QDecoderStream extends QPDecoderStream {
    public QDecoderStream(InputStream inputStream) {
        super(inputStream);
    }

    @Override // com.sun.mail.util.QPDecoderStream, java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int read = this.in.read();
        if (read == 95) {
            return 32;
        }
        if (read == 61) {
            this.ba[0] = (byte) this.in.read();
            this.ba[1] = (byte) this.in.read();
            try {
                return ASCIIUtility.parseInt(this.ba, 0, 2, 16);
            } catch (NumberFormatException e) {
                throw new DecodingException("QDecoder: Error in QP stream " + e.getMessage());
            }
        }
        return read;
    }
}
