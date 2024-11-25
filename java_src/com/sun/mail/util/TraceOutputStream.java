package com.sun.mail.util;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
/* loaded from: classes2.dex */
public class TraceOutputStream extends FilterOutputStream {
    private boolean quote;
    private boolean trace;
    private OutputStream traceOut;

    public TraceOutputStream(OutputStream outputStream, MailLogger mailLogger) {
        super(outputStream);
        this.trace = false;
        this.quote = false;
        this.trace = mailLogger.isLoggable(Level.FINEST);
        this.traceOut = new LogOutputStream(mailLogger);
    }

    public TraceOutputStream(OutputStream outputStream, OutputStream outputStream2) {
        super(outputStream);
        this.trace = false;
        this.quote = false;
        this.traceOut = outputStream2;
    }

    public void setTrace(boolean z) {
        this.trace = z;
    }

    public void setQuote(boolean z) {
        this.quote = z;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i) throws IOException {
        if (this.trace) {
            if (this.quote) {
                writeByte(i);
            } else {
                this.traceOut.write(i);
            }
        }
        this.out.write(i);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        if (this.trace) {
            if (this.quote) {
                for (int i3 = 0; i3 < i2; i3++) {
                    writeByte(bArr[i + i3]);
                }
            } else {
                this.traceOut.write(bArr, i, i2);
            }
        }
        this.out.write(bArr, i, i2);
    }

    private final void writeByte(int i) throws IOException {
        int i2 = i & 255;
        if (i2 > 127) {
            this.traceOut.write(77);
            this.traceOut.write(45);
            i2 &= 127;
        }
        if (i2 == 13) {
            this.traceOut.write(92);
            this.traceOut.write(114);
        } else if (i2 == 10) {
            this.traceOut.write(92);
            this.traceOut.write(110);
            this.traceOut.write(10);
        } else if (i2 == 9) {
            this.traceOut.write(92);
            this.traceOut.write(116);
        } else if (i2 < 32) {
            this.traceOut.write(94);
            this.traceOut.write(i2 + 64);
        } else {
            this.traceOut.write(i2);
        }
    }
}
