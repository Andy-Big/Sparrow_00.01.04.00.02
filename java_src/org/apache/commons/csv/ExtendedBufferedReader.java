package org.apache.commons.csv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
/* loaded from: classes2.dex */
final class ExtendedBufferedReader extends BufferedReader {
    private boolean closed;
    private long eolCounter;
    private int lastChar;
    private long position;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ExtendedBufferedReader(Reader reader) {
        super(reader);
        this.lastChar = -2;
    }

    @Override // java.io.BufferedReader, java.io.Reader
    public int read() throws IOException {
        int read = super.read();
        if (read == 13 || (read == 10 && this.lastChar != 13)) {
            this.eolCounter++;
        }
        this.lastChar = read;
        this.position++;
        return read;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getLastChar() {
        return this.lastChar;
    }

    @Override // java.io.BufferedReader, java.io.Reader
    public int read(char[] cArr, int i, int i2) throws IOException {
        int i3;
        if (i2 == 0) {
            return 0;
        }
        int read = super.read(cArr, i, i2);
        if (read > 0) {
            int i4 = i;
            while (true) {
                i3 = i + read;
                if (i4 >= i3) {
                    break;
                }
                char c = cArr[i4];
                if (c == '\n') {
                    if (13 != (i4 > 0 ? cArr[i4 - 1] : this.lastChar)) {
                        this.eolCounter++;
                    }
                } else if (c == '\r') {
                    this.eolCounter++;
                }
                i4++;
            }
            this.lastChar = cArr[i3 - 1];
        } else if (read == -1) {
            this.lastChar = -1;
        }
        this.position += read;
        return read;
    }

    @Override // java.io.BufferedReader
    public String readLine() throws IOException {
        String readLine = super.readLine();
        if (readLine != null) {
            this.lastChar = 10;
            this.eolCounter++;
        } else {
            this.lastChar = -1;
        }
        return readLine;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int lookAhead() throws IOException {
        super.mark(1);
        int read = super.read();
        super.reset();
        return read;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long getCurrentLineNumber() {
        int i = this.lastChar;
        if (i == 13 || i == 10 || i == -2 || i == -1) {
            return this.eolCounter;
        }
        return this.eolCounter + 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long getPosition() {
        return this.position;
    }

    public boolean isClosed() {
        return this.closed;
    }

    @Override // java.io.BufferedReader, java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.closed = true;
        this.lastChar = -1;
        super.close();
    }
}
