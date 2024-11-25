package javax.mail.internet;

import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MimeUtility.java */
/* loaded from: classes2.dex */
public class AsciiOutputStream extends OutputStream {
    private boolean breakOnNonAscii;
    private boolean checkEOL;
    private int ascii = 0;
    private int non_ascii = 0;
    private int linelen = 0;
    private boolean longLine = false;
    private boolean badEOL = false;
    private int lastb = 0;
    private int ret = 0;

    public AsciiOutputStream(boolean z, boolean z2) {
        boolean z3 = false;
        this.checkEOL = false;
        this.breakOnNonAscii = z;
        if (z2 && z) {
            z3 = true;
        }
        this.checkEOL = z3;
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        check(i);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        int i3 = i2 + i;
        while (i < i3) {
            check(bArr[i]);
            i++;
        }
    }

    private final void check(int i) throws IOException {
        int i2 = i & 255;
        if (this.checkEOL && ((this.lastb == 13 && i2 != 10) || (this.lastb != 13 && i2 == 10))) {
            this.badEOL = true;
        }
        if (i2 == 13 || i2 == 10) {
            this.linelen = 0;
        } else {
            int i3 = this.linelen + 1;
            this.linelen = i3;
            if (i3 > 998) {
                this.longLine = true;
            }
        }
        if (MimeUtility.nonascii(i2)) {
            this.non_ascii++;
            if (this.breakOnNonAscii) {
                this.ret = 3;
                throw new EOFException();
            }
        } else {
            this.ascii++;
        }
        this.lastb = i2;
    }

    public int getAscii() {
        int i = this.ret;
        if (i != 0) {
            return i;
        }
        if (this.badEOL) {
            return 3;
        }
        int i2 = this.non_ascii;
        return i2 == 0 ? this.longLine ? 2 : 1 : this.ascii > i2 ? 2 : 3;
    }
}
