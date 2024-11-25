package org.apache.commons.csv;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.CharBuffer;
/* loaded from: classes2.dex */
class IOUtils {
    static final int DEFAULT_BUFFER_SIZE = 4096;
    private static final int EOF = -1;

    IOUtils() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long copy(Reader reader, Appendable appendable) throws IOException {
        return copy(reader, appendable, CharBuffer.allocate(4096));
    }

    static long copy(Reader reader, Appendable appendable, CharBuffer charBuffer) throws IOException {
        long j = 0;
        while (true) {
            int read = reader.read(charBuffer);
            if (-1 == read) {
                return j;
            }
            charBuffer.flip();
            appendable.append(charBuffer, 0, read);
            j += read;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long copyLarge(Reader reader, Writer writer) throws IOException {
        return copyLarge(reader, writer, new char[4096]);
    }

    static long copyLarge(Reader reader, Writer writer, char[] cArr) throws IOException {
        long j = 0;
        while (true) {
            int read = reader.read(cArr);
            if (-1 == read) {
                return j;
            }
            writer.write(cArr, 0, read);
            j += read;
        }
    }
}
