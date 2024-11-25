package com.sun.mail.util;

import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
/* compiled from: WriteTimeoutSocket.java */
/* loaded from: classes2.dex */
class TimeoutOutputStream extends OutputStream {
    private byte[] b1;
    private final OutputStream os;
    private final ScheduledExecutorService ses;
    private final int timeout;
    private final Callable<Object> timeoutTask = new Callable<Object>() { // from class: com.sun.mail.util.TimeoutOutputStream.1
        @Override // java.util.concurrent.Callable
        public Object call() throws Exception {
            TimeoutOutputStream.this.os.close();
            return null;
        }
    };

    public TimeoutOutputStream(OutputStream outputStream, ScheduledExecutorService scheduledExecutorService, int i) throws IOException {
        this.os = outputStream;
        this.ses = scheduledExecutorService;
        this.timeout = i;
    }

    @Override // java.io.OutputStream
    public synchronized void write(int i) throws IOException {
        if (this.b1 == null) {
            this.b1 = new byte[1];
        }
        this.b1[0] = (byte) i;
        write(this.b1);
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        if (i >= 0) {
            if (i <= bArr.length && i2 >= 0 && (i3 = i + i2) <= bArr.length && i3 >= 0) {
                if (i2 == 0) {
                    return;
                }
                ScheduledFuture scheduledFuture = null;
                try {
                    if (this.timeout > 0) {
                        scheduledFuture = this.ses.schedule(this.timeoutTask, this.timeout, TimeUnit.MILLISECONDS);
                    }
                } catch (RejectedExecutionException unused) {
                }
                this.os.write(bArr, i, i2);
                if (scheduledFuture != null) {
                    scheduledFuture.cancel(true);
                }
                return;
            }
        }
        throw new IndexOutOfBoundsException();
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.os.close();
    }
}
