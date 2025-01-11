package kotlin.io;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Console.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0014\u001a\u00020\u0004H\u0002J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0010H\u0002J\u0018\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0004H\u0002J\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fJ\b\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020!H\u0002J\u0010\u0010#\u001a\u00020!2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00060\u0012j\u0002`\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lkotlin/io/LineReader;", "", "()V", "BUFFER_SIZE", "", "byteBuf", "Ljava/nio/ByteBuffer;", "bytes", "", "charBuf", "Ljava/nio/CharBuffer;", "chars", "", "decoder", "Ljava/nio/charset/CharsetDecoder;", "directEOL", "", "sb", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "compactBytes", "decode", "endOfInput", "decodeEndOfInput", "nBytes", "nChars", "readLine", "", "inputStream", "Ljava/io/InputStream;", "charset", "Ljava/nio/charset/Charset;", "resetAll", "", "trimStringBuilder", "updateCharset", "kotlin-stdlib"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes2.dex */
public final class LineReader {
    private static final int BUFFER_SIZE = 32;
    private static final ByteBuffer byteBuf;
    private static final byte[] bytes;
    private static final CharBuffer charBuf;
    private static CharsetDecoder decoder;
    private static boolean directEOL;
    private static final StringBuilder sb;
    public static final LineReader INSTANCE = new LineReader();
    private static final char[] chars = new char[32];

    static {
        byte[] bArr = new byte[32];
        bytes = bArr;
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        Intrinsics.checkNotNullExpressionValue(wrap, "ByteBuffer.wrap(bytes)");
        byteBuf = wrap;
        CharBuffer wrap2 = CharBuffer.wrap(chars);
        Intrinsics.checkNotNullExpressionValue(wrap2, "CharBuffer.wrap(chars)");
        charBuf = wrap2;
        sb = new StringBuilder();
    }

    private LineReader() {
    }

    public static final /* synthetic */ CharsetDecoder access$getDecoder$p(LineReader lineReader) {
        CharsetDecoder charsetDecoder = decoder;
        if (charsetDecoder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("decoder");
        }
        return charsetDecoder;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0022, code lost:
        if ((!kotlin.jvm.internal.Intrinsics.areEqual(r0.charset(), r11)) != false) goto L69;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized String readLine(InputStream inputStream, Charset charset) {
        int decodeEndOfInput;
        Intrinsics.checkNotNullParameter(inputStream, "inputStream");
        Intrinsics.checkNotNullParameter(charset, "charset");
        boolean z = true;
        if (decoder != null) {
            if (decoder == null) {
                Intrinsics.throwUninitializedPropertyAccessException("decoder");
            }
        }
        updateCharset(charset);
        int i = 0;
        int i2 = 0;
        while (true) {
            int read = inputStream.read();
            if (read == -1) {
                if ((sb.length() == 0) && i == 0 && i2 == 0) {
                    return null;
                }
                decodeEndOfInput = decodeEndOfInput(i, i2);
            } else {
                int i3 = i + 1;
                bytes[i] = (byte) read;
                if (read != 10 && i3 != 32 && directEOL) {
                    i = i3;
                }
                byteBuf.limit(i3);
                charBuf.position(i2);
                i2 = decode(false);
                if (i2 > 0 && chars[i2 - 1] == '\n') {
                    byteBuf.position(0);
                    decodeEndOfInput = i2;
                    break;
                }
                i = compactBytes();
            }
        }
        if (decodeEndOfInput > 0 && chars[decodeEndOfInput - 1] == '\n' && decodeEndOfInput - 1 > 0 && chars[decodeEndOfInput - 1] == '\r') {
            decodeEndOfInput--;
        }
        if (sb.length() != 0) {
            z = false;
        }
        if (z) {
            return new String(chars, 0, decodeEndOfInput);
        }
        sb.append(chars, 0, decodeEndOfInput);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "sb.toString()");
        if (sb.length() > 32) {
            trimStringBuilder();
        }
        sb.setLength(0);
        return sb2;
    }

    private final int decode(boolean z) {
        while (true) {
            CharsetDecoder charsetDecoder = decoder;
            if (charsetDecoder == null) {
                Intrinsics.throwUninitializedPropertyAccessException("decoder");
            }
            CoderResult decode = charsetDecoder.decode(byteBuf, charBuf, z);
            Intrinsics.checkNotNullExpressionValue(decode, "decoder.decode(byteBuf, charBuf, endOfInput)");
            if (decode.isError()) {
                resetAll();
                decode.throwException();
            }
            int position = charBuf.position();
            if (!decode.isOverflow()) {
                return position;
            }
            int i = position - 1;
            sb.append(chars, 0, i);
            charBuf.position(0);
            charBuf.limit(32);
            charBuf.put(chars[i]);
        }
    }

    private final int compactBytes() {
        ByteBuffer byteBuffer = byteBuf;
        byteBuffer.compact();
        int position = byteBuffer.position();
        byteBuffer.position(0);
        return position;
    }

    private final int decodeEndOfInput(int i, int i2) {
        byteBuf.limit(i);
        charBuf.position(i2);
        int decode = decode(true);
        CharsetDecoder charsetDecoder = decoder;
        if (charsetDecoder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("decoder");
        }
        charsetDecoder.reset();
        byteBuf.position(0);
        return decode;
    }

    private final void updateCharset(Charset charset) {
        CharsetDecoder newDecoder = charset.newDecoder();
        Intrinsics.checkNotNullExpressionValue(newDecoder, "charset.newDecoder()");
        decoder = newDecoder;
        byteBuf.clear();
        charBuf.clear();
        byteBuf.put((byte) 10);
        byteBuf.flip();
        CharsetDecoder charsetDecoder = decoder;
        if (charsetDecoder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("decoder");
        }
        boolean z = false;
        charsetDecoder.decode(byteBuf, charBuf, false);
        if (charBuf.position() == 1 && charBuf.get(0) == '\n') {
            z = true;
        }
        directEOL = z;
        resetAll();
    }

    private final void resetAll() {
        CharsetDecoder charsetDecoder = decoder;
        if (charsetDecoder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("decoder");
        }
        charsetDecoder.reset();
        byteBuf.position(0);
        sb.setLength(0);
    }

    private final void trimStringBuilder() {
        sb.setLength(32);
        sb.trimToSize();
    }
}
