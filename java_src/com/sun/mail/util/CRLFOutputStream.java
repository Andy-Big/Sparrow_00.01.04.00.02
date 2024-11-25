package com.sun.mail.util;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes2.dex */
public class CRLFOutputStream extends FilterOutputStream {
    private static final byte[] newline = {13, 10};
    protected boolean atBOL;
    protected int lastb;

    public CRLFOutputStream(OutputStream outputStream) {
        super(outputStream);
        this.lastb = -1;
        this.atBOL = true;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i) throws IOException {
        if (i == 13) {
            writeln();
        } else if (i == 10) {
            if (this.lastb != 13) {
                writeln();
            }
        } else {
            this.out.write(i);
            this.atBOL = false;
        }
        this.lastb = i;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        int i3 = i2 + i;
        int i4 = i;
        while (i < i3) {
            if (bArr[i] == 13) {
                this.out.write(bArr, i4, i - i4);
                writeln();
            } else if (bArr[i] == 10) {
                if (this.lastb != 13) {
                    this.out.write(bArr, i4, i - i4);
                    writeln();
                }
            } else {
                this.lastb = bArr[i];
                i++;
            }
            i4 = i + 1;
            this.lastb = bArr[i];
            i++;
        }
        int i5 = i3 - i4;
        if (i5 > 0) {
            this.out.write(bArr, i4, i5);
            this.atBOL = false;
        }
    }

    public void writeln() throws IOException {
        this.out.write(newline);
        this.atBOL = true;
    }
}
