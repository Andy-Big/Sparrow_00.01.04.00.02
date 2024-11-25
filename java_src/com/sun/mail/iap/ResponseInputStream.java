package com.sun.mail.iap;

import com.sun.mail.util.ASCIIUtility;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes2.dex */
public class ResponseInputStream {
    private static final int incrementSlop = 16;
    private static final int maxIncrement = 262144;
    private static final int minIncrement = 256;
    private BufferedInputStream bin;

    public ResponseInputStream(InputStream inputStream) {
        this.bin = new BufferedInputStream(inputStream, 2048);
    }

    public ByteArray readResponse() throws IOException {
        return readResponse(null);
    }

    public ByteArray readResponse(ByteArray byteArray) throws IOException {
        if (byteArray == null) {
            byteArray = new ByteArray(new byte[128], 0, 128);
        }
        byte[] bytes = byteArray.getBytes();
        int i = 0;
        while (true) {
            boolean z = false;
            int i2 = 0;
            while (!z && (i2 = this.bin.read()) != -1) {
                if (i2 == 10 && i > 0 && bytes[i - 1] == 13) {
                    z = true;
                }
                if (i >= bytes.length) {
                    int length = bytes.length;
                    if (length > 262144) {
                        length = 262144;
                    }
                    byteArray.grow(length);
                    bytes = byteArray.getBytes();
                }
                bytes[i] = (byte) i2;
                i++;
            }
            if (i2 == -1) {
                throw new IOException("Connection dropped by server?");
            }
            if (i < 5) {
                break;
            }
            int i3 = i - 3;
            if (bytes[i3] != 125) {
                break;
            }
            int i4 = i - 4;
            while (i4 >= 0 && bytes[i4] != 123) {
                i4--;
            }
            if (i4 < 0) {
                break;
            }
            try {
                int parseInt = ASCIIUtility.parseInt(bytes, i4 + 1, i3);
                if (parseInt > 0) {
                    int length2 = bytes.length - i;
                    int i5 = parseInt + 16;
                    if (i5 > length2) {
                        int i6 = i5 - length2;
                        if (256 > i6) {
                            i6 = 256;
                        }
                        byteArray.grow(i6);
                        bytes = byteArray.getBytes();
                    }
                    while (parseInt > 0) {
                        int read = this.bin.read(bytes, i, parseInt);
                        if (read == -1) {
                            throw new IOException("Connection dropped by server?");
                        }
                        parseInt -= read;
                        i += read;
                    }
                    continue;
                }
            } catch (NumberFormatException unused) {
            }
        }
        byteArray.setCount(i);
        return byteArray;
    }

    public int available() throws IOException {
        return this.bin.available();
    }
}
