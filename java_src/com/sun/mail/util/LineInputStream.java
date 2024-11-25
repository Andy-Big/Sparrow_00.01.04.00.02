package com.sun.mail.util;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;
import java.nio.charset.StandardCharsets;
/* loaded from: classes2.dex */
public class LineInputStream extends FilterInputStream {
    private boolean allowutf8;
    private CharsetDecoder decoder;
    private byte[] lineBuffer;
    private static boolean defaultutf8 = PropUtil.getBooleanSystemProperty("mail.mime.allowutf8", false);
    private static int MAX_INCR = 1048576;

    public LineInputStream(InputStream inputStream) {
        this(inputStream, false);
    }

    public LineInputStream(InputStream inputStream, boolean z) {
        super(inputStream);
        this.lineBuffer = null;
        this.allowutf8 = z;
        if (z || !defaultutf8) {
            return;
        }
        CharsetDecoder newDecoder = StandardCharsets.UTF_8.newDecoder();
        this.decoder = newDecoder;
        newDecoder.onMalformedInput(CodingErrorAction.REPORT);
        this.decoder.onUnmappableCharacter(CodingErrorAction.REPORT);
    }

    public String readLine() throws IOException {
        int read;
        byte[] bArr = this.lineBuffer;
        if (bArr == null) {
            bArr = new byte[128];
            this.lineBuffer = bArr;
        }
        int length = bArr.length;
        int i = 0;
        while (true) {
            read = this.in.read();
            if (read == -1 || read == 10) {
                break;
            }
            boolean z = true;
            if (read == 13) {
                if (this.in.markSupported()) {
                    this.in.mark(2);
                }
                int read2 = this.in.read();
                if (read2 == 13) {
                    read2 = this.in.read();
                } else {
                    z = false;
                }
                if (read2 != 10) {
                    if (this.in.markSupported()) {
                        this.in.reset();
                    } else {
                        if (!(this.in instanceof PushbackInputStream)) {
                            this.in = new PushbackInputStream(this.in, 2);
                        }
                        if (read2 != -1) {
                            ((PushbackInputStream) this.in).unread(read2);
                        }
                        if (z) {
                            ((PushbackInputStream) this.in).unread(13);
                        }
                    }
                }
            } else {
                length--;
                if (length < 0) {
                    int length2 = bArr.length;
                    int i2 = MAX_INCR;
                    if (length2 < i2) {
                        bArr = new byte[bArr.length * 2];
                    } else {
                        bArr = new byte[bArr.length + i2];
                    }
                    length = (bArr.length - i) - 1;
                    System.arraycopy(this.lineBuffer, 0, bArr, 0, i);
                    this.lineBuffer = bArr;
                }
                bArr[i] = (byte) read;
                i++;
            }
        }
        if (read == -1 && i == 0) {
            return null;
        }
        if (this.allowutf8) {
            return new String(bArr, 0, i, StandardCharsets.UTF_8);
        }
        if (defaultutf8) {
            try {
                return this.decoder.decode(ByteBuffer.wrap(bArr, 0, i)).toString();
            } catch (CharacterCodingException unused) {
            }
        }
        return new String(bArr, 0, 0, i);
    }
}
