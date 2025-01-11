package com.sun.mail.util;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import kotlin.UByte;

/* loaded from: classes2.dex */
public class UUDecoderStream extends FilterInputStream {
    private byte[] buffer;
    private int bufsize;
    private boolean gotEnd;
    private boolean gotPrefix;
    private boolean ignoreErrors;
    private boolean ignoreMissingBeginEnd;
    private int index;
    private LineInputStream lin;
    private int mode;
    private String name;
    private String readAhead;

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    public UUDecoderStream(InputStream inputStream) {
        super(inputStream);
        this.buffer = new byte[45];
        this.bufsize = 0;
        this.index = 0;
        this.gotPrefix = false;
        this.gotEnd = false;
        this.lin = new LineInputStream(inputStream);
        this.ignoreErrors = PropUtil.getBooleanSystemProperty("mail.mime.uudecode.ignoreerrors", false);
        this.ignoreMissingBeginEnd = PropUtil.getBooleanSystemProperty("mail.mime.uudecode.ignoremissingbeginend", false);
    }

    public UUDecoderStream(InputStream inputStream, boolean z, boolean z2) {
        super(inputStream);
        this.buffer = new byte[45];
        this.bufsize = 0;
        this.index = 0;
        this.gotPrefix = false;
        this.gotEnd = false;
        this.lin = new LineInputStream(inputStream);
        this.ignoreErrors = z;
        this.ignoreMissingBeginEnd = z2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        if (this.index >= this.bufsize) {
            readPrefix();
            if (!decode()) {
                return -1;
            }
            this.index = 0;
        }
        byte[] bArr = this.buffer;
        int i = this.index;
        this.index = i + 1;
        return bArr[i] & UByte.MAX_VALUE;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        while (i3 < i2) {
            int read = read();
            if (read == -1) {
                if (i3 == 0) {
                    return -1;
                }
                return i3;
            }
            bArr[i + i3] = (byte) read;
            i3++;
        }
        return i3;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        return ((this.in.available() * 3) / 4) + (this.bufsize - this.index);
    }

    public String getName() throws IOException {
        readPrefix();
        return this.name;
    }

    public int getMode() throws IOException {
        readPrefix();
        return this.mode;
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x00b2, code lost:
        r8.readAhead = r0;
        r8.gotPrefix = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00b6, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void readPrefix() throws IOException {
        int charAt;
        if (this.gotPrefix) {
            return;
        }
        this.mode = 438;
        this.name = "encoder.buf";
        while (true) {
            String readLine = this.lin.readLine();
            if (readLine == null) {
                if (!this.ignoreMissingBeginEnd) {
                    throw new DecodingException("UUDecoder: Missing begin");
                }
                this.gotPrefix = true;
                this.gotEnd = true;
                return;
            } else if (readLine.regionMatches(false, 0, "begin", 0, 5)) {
                try {
                    this.mode = Integer.parseInt(readLine.substring(6, 9));
                } catch (NumberFormatException e) {
                    if (!this.ignoreErrors) {
                        throw new DecodingException("UUDecoder: Error in mode: " + e.toString());
                    }
                }
                if (readLine.length() > 10) {
                    this.name = readLine.substring(10);
                } else if (!this.ignoreErrors) {
                    throw new DecodingException("UUDecoder: Missing name: " + readLine);
                }
                this.gotPrefix = true;
                return;
            } else if (!this.ignoreMissingBeginEnd || readLine.length() == 0 || ((charAt = ((((readLine.charAt(0) - ' ') & 63) * 8) + 5) / 6) != 0 && readLine.length() < charAt + 1)) {
            }
        }
    }

    private boolean decode() throws IOException {
        if (this.gotEnd) {
            return false;
        }
        this.bufsize = 0;
        while (true) {
            String str = this.readAhead;
            if (str != null) {
                this.readAhead = null;
            } else {
                str = this.lin.readLine();
            }
            if (str == null) {
                if (!this.ignoreMissingBeginEnd) {
                    throw new DecodingException("UUDecoder: Missing end at EOF");
                }
                this.gotEnd = true;
                return false;
            } else if (str.equals("end")) {
                this.gotEnd = true;
                return false;
            } else if (str.length() != 0) {
                char charAt = str.charAt(0);
                if (charAt >= ' ') {
                    int i = (charAt - ' ') & 63;
                    if (i == 0) {
                        String readLine = this.lin.readLine();
                        if ((readLine == null || !readLine.equals("end")) && !this.ignoreMissingBeginEnd) {
                            throw new DecodingException("UUDecoder: Missing End after count 0 line");
                        }
                        this.gotEnd = true;
                        return false;
                    } else if (str.length() < (((i * 8) + 5) / 6) + 1) {
                        if (!this.ignoreErrors) {
                            throw new DecodingException("UUDecoder: Short buffer error");
                        }
                    } else {
                        int i2 = 1;
                        while (this.bufsize < i) {
                            int i3 = i2 + 1;
                            int i4 = i3 + 1;
                            byte charAt2 = (byte) ((str.charAt(i3) - ' ') & 63);
                            byte[] bArr = this.buffer;
                            int i5 = this.bufsize;
                            int i6 = i5 + 1;
                            this.bufsize = i6;
                            bArr[i5] = (byte) (((((byte) ((str.charAt(i2) - ' ') & 63)) << 2) & 252) | ((charAt2 >>> 4) & 3));
                            if (i6 < i) {
                                i2 = i4 + 1;
                                byte charAt3 = (byte) ((str.charAt(i4) - ' ') & 63);
                                byte[] bArr2 = this.buffer;
                                int i7 = this.bufsize;
                                this.bufsize = i7 + 1;
                                bArr2[i7] = (byte) (((charAt2 << 4) & 240) | ((charAt3 >>> 2) & 15));
                                charAt2 = charAt3;
                            } else {
                                i2 = i4;
                            }
                            if (this.bufsize < i) {
                                byte[] bArr3 = this.buffer;
                                int i8 = this.bufsize;
                                this.bufsize = i8 + 1;
                                bArr3[i8] = (byte) ((((byte) ((str.charAt(i2) - ' ') & 63)) & 63) | ((charAt2 << 6) & 192));
                                i2++;
                            }
                        }
                        return true;
                    }
                } else if (!this.ignoreErrors) {
                    throw new DecodingException("UUDecoder: Buffer format error");
                }
            }
        }
    }
}
