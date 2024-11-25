package kotlin.io.path;

import androidx.exifinterface.media.ExifInterface;
import com.sun.mail.imap.IMAPStore;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.Charsets;
/* compiled from: PathReadWrite.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0084\u0001\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a%\u0010\u0005\u001a\u00020\u0002*\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\nH\u0087\b\u001a%\u0010\u0005\u001a\u00020\u0002*\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u000b2\b\b\u0002\u0010\t\u001a\u00020\nH\u0087\b\u001a\u001e\u0010\f\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\t\u001a\u00020\nH\u0007\u001a:\u0010\u000f\u001a\u00020\u0010*\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u0012\u0010\u0013\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00150\u0014\"\u00020\u0015H\u0087\b¢\u0006\u0002\u0010\u0016\u001a:\u0010\u0017\u001a\u00020\u0018*\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u0012\u0010\u0013\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00150\u0014\"\u00020\u0015H\u0087\b¢\u0006\u0002\u0010\u0019\u001a=\u0010\u001a\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\n2!\u0010\u001b\u001a\u001d\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u00010\u001cH\u0087\bø\u0001\u0000\u001a&\u0010 \u001a\u00020!*\u00020\u00022\u0012\u0010\u0013\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00150\u0014\"\u00020\u0015H\u0087\b¢\u0006\u0002\u0010\"\u001a&\u0010#\u001a\u00020$*\u00020\u00022\u0012\u0010\u0013\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00150\u0014\"\u00020\u0015H\u0087\b¢\u0006\u0002\u0010%\u001a\r\u0010&\u001a\u00020\u0004*\u00020\u0002H\u0087\b\u001a\u001d\u0010'\u001a\b\u0012\u0004\u0012\u00020\u000e0(*\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\nH\u0087\b\u001a\u0016\u0010)\u001a\u00020\u000e*\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\nH\u0007\u001a0\u0010*\u001a\u00020+*\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\n2\u0012\u0010\u0013\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00150\u0014\"\u00020\u0015H\u0087\b¢\u0006\u0002\u0010,\u001a?\u0010-\u001a\u0002H.\"\u0004\b\u0000\u0010.*\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\n2\u0018\u0010/\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u000b\u0012\u0004\u0012\u0002H.0\u001cH\u0087\bø\u0001\u0000¢\u0006\u0002\u00100\u001a.\u00101\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0013\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00150\u0014\"\u00020\u0015H\u0087\b¢\u0006\u0002\u00102\u001a>\u00103\u001a\u00020\u0002*\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\u0012\u0010\u0013\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00150\u0014\"\u00020\u0015H\u0087\b¢\u0006\u0002\u00104\u001a>\u00103\u001a\u00020\u0002*\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u000b2\b\b\u0002\u0010\t\u001a\u00020\n2\u0012\u0010\u0013\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00150\u0014\"\u00020\u0015H\u0087\b¢\u0006\u0002\u00105\u001a7\u00106\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\t\u001a\u00020\n2\u0012\u0010\u0013\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00150\u0014\"\u00020\u0015H\u0007¢\u0006\u0002\u00107\u001a0\u00108\u001a\u000209*\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\n2\u0012\u0010\u0013\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00150\u0014\"\u00020\u0015H\u0087\b¢\u0006\u0002\u0010:\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006;"}, d2 = {"appendBytes", "", "Ljava/nio/file/Path;", "array", "", "appendLines", "lines", "", "", "charset", "Ljava/nio/charset/Charset;", "Lkotlin/sequences/Sequence;", "appendText", "text", "", "bufferedReader", "Ljava/io/BufferedReader;", "bufferSize", "", "options", "", "Ljava/nio/file/OpenOption;", "(Ljava/nio/file/Path;Ljava/nio/charset/Charset;I[Ljava/nio/file/OpenOption;)Ljava/io/BufferedReader;", "bufferedWriter", "Ljava/io/BufferedWriter;", "(Ljava/nio/file/Path;Ljava/nio/charset/Charset;I[Ljava/nio/file/OpenOption;)Ljava/io/BufferedWriter;", "forEachLine", "action", "Lkotlin/Function1;", "Lkotlin/ParameterName;", IMAPStore.ID_NAME, "line", "inputStream", "Ljava/io/InputStream;", "(Ljava/nio/file/Path;[Ljava/nio/file/OpenOption;)Ljava/io/InputStream;", "outputStream", "Ljava/io/OutputStream;", "(Ljava/nio/file/Path;[Ljava/nio/file/OpenOption;)Ljava/io/OutputStream;", "readBytes", "readLines", "", "readText", "reader", "Ljava/io/InputStreamReader;", "(Ljava/nio/file/Path;Ljava/nio/charset/Charset;[Ljava/nio/file/OpenOption;)Ljava/io/InputStreamReader;", "useLines", ExifInterface.GPS_DIRECTION_TRUE, "block", "(Ljava/nio/file/Path;Ljava/nio/charset/Charset;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "writeBytes", "(Ljava/nio/file/Path;[B[Ljava/nio/file/OpenOption;)V", "writeLines", "(Ljava/nio/file/Path;Ljava/lang/Iterable;Ljava/nio/charset/Charset;[Ljava/nio/file/OpenOption;)Ljava/nio/file/Path;", "(Ljava/nio/file/Path;Lkotlin/sequences/Sequence;Ljava/nio/charset/Charset;[Ljava/nio/file/OpenOption;)Ljava/nio/file/Path;", "writeText", "(Ljava/nio/file/Path;Ljava/lang/String;Ljava/nio/charset/Charset;[Ljava/nio/file/OpenOption;)V", "writer", "Ljava/io/OutputStreamWriter;", "(Ljava/nio/file/Path;Ljava/nio/charset/Charset;[Ljava/nio/file/OpenOption;)Ljava/io/OutputStreamWriter;", "kotlin-stdlib-jdk7"}, k = 5, mv = {1, 4, 0}, xi = 1, xs = "kotlin/io/path/PathsKt")
/* loaded from: classes2.dex */
class PathsKt__PathReadWriteKt {
    static /* synthetic */ InputStreamReader reader$default(Path path, Charset charset, OpenOption[] openOptionArr, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        return new InputStreamReader(Files.newInputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length)), charset);
    }

    private static final InputStreamReader reader(Path path, Charset charset, OpenOption... openOptionArr) {
        return new InputStreamReader(Files.newInputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length)), charset);
    }

    static /* synthetic */ BufferedReader bufferedReader$default(Path path, Charset charset, int i, OpenOption[] openOptionArr, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        if ((i2 & 2) != 0) {
            i = 8192;
        }
        return new BufferedReader(new InputStreamReader(Files.newInputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length)), charset), i);
    }

    private static final BufferedReader bufferedReader(Path path, Charset charset, int i, OpenOption... openOptionArr) {
        return new BufferedReader(new InputStreamReader(Files.newInputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length)), charset), i);
    }

    static /* synthetic */ OutputStreamWriter writer$default(Path path, Charset charset, OpenOption[] openOptionArr, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        return new OutputStreamWriter(Files.newOutputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length)), charset);
    }

    private static final OutputStreamWriter writer(Path path, Charset charset, OpenOption... openOptionArr) {
        return new OutputStreamWriter(Files.newOutputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length)), charset);
    }

    static /* synthetic */ BufferedWriter bufferedWriter$default(Path path, Charset charset, int i, OpenOption[] openOptionArr, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        if ((i2 & 2) != 0) {
            i = 8192;
        }
        return new BufferedWriter(new OutputStreamWriter(Files.newOutputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length)), charset), i);
    }

    private static final BufferedWriter bufferedWriter(Path path, Charset charset, int i, OpenOption... openOptionArr) {
        return new BufferedWriter(new OutputStreamWriter(Files.newOutputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length)), charset), i);
    }

    private static final byte[] readBytes(Path path) {
        byte[] readAllBytes = Files.readAllBytes(path);
        Intrinsics.checkNotNullExpressionValue(readAllBytes, "Files.readAllBytes(this)");
        return readAllBytes;
    }

    private static final void writeBytes(Path path, byte[] bArr, OpenOption... openOptionArr) {
        Files.write(path, bArr, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
    }

    private static final void appendBytes(Path path, byte[] bArr) {
        Files.write(path, bArr, StandardOpenOption.APPEND);
    }

    public static /* synthetic */ String readText$default(Path path, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        return PathsKt.readText(path, charset);
    }

    public static final String readText(Path readText, Charset charset) {
        Intrinsics.checkNotNullParameter(readText, "$this$readText");
        Intrinsics.checkNotNullParameter(charset, "charset");
        InputStreamReader inputStreamReader = new InputStreamReader(Files.newInputStream(readText, (OpenOption[]) Arrays.copyOf(new OpenOption[0], 0)), charset);
        Throwable th = null;
        try {
            String readText2 = TextStreamsKt.readText(inputStreamReader);
            CloseableKt.closeFinally(inputStreamReader, th);
            return readText2;
        } finally {
        }
    }

    public static /* synthetic */ void writeText$default(Path path, String str, Charset charset, OpenOption[] openOptionArr, int i, Object obj) {
        if ((i & 2) != 0) {
            charset = Charsets.UTF_8;
        }
        PathsKt.writeText(path, str, charset, openOptionArr);
    }

    public static final void writeText(Path writeText, String text, Charset charset, OpenOption... options) {
        Intrinsics.checkNotNullParameter(writeText, "$this$writeText");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(charset, "charset");
        Intrinsics.checkNotNullParameter(options, "options");
        OutputStream newOutputStream = Files.newOutputStream(writeText, (OpenOption[]) Arrays.copyOf(options, options.length));
        Intrinsics.checkNotNullExpressionValue(newOutputStream, "Files.newOutputStream(this, *options)");
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(newOutputStream, charset);
        Throwable th = null;
        try {
            outputStreamWriter.write(text);
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(outputStreamWriter, th);
        } finally {
        }
    }

    public static /* synthetic */ void appendText$default(Path path, String str, Charset charset, int i, Object obj) {
        if ((i & 2) != 0) {
            charset = Charsets.UTF_8;
        }
        PathsKt.appendText(path, str, charset);
    }

    public static final void appendText(Path appendText, String text, Charset charset) {
        Intrinsics.checkNotNullParameter(appendText, "$this$appendText");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(charset, "charset");
        OutputStream newOutputStream = Files.newOutputStream(appendText, StandardOpenOption.APPEND);
        Intrinsics.checkNotNullExpressionValue(newOutputStream, "Files.newOutputStream(th…tandardOpenOption.APPEND)");
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(newOutputStream, charset);
        Throwable th = null;
        try {
            outputStreamWriter.write(text);
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(outputStreamWriter, th);
        } finally {
        }
    }

    static /* synthetic */ void forEachLine$default(Path path, Charset charset, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        BufferedReader newBufferedReader = Files.newBufferedReader(path, charset);
        Intrinsics.checkNotNullExpressionValue(newBufferedReader, "Files.newBufferedReader(this, charset)");
        BufferedReader bufferedReader = newBufferedReader;
        BufferedReader bufferedReader2 = bufferedReader instanceof BufferedReader ? bufferedReader : new BufferedReader(bufferedReader, 8192);
        Throwable th = null;
        try {
            for (String str : TextStreamsKt.lineSequence(bufferedReader2)) {
                function1.invoke(str);
            }
            Unit unit = Unit.INSTANCE;
            InlineMarker.finallyStart(1);
            if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0)) {
                CloseableKt.closeFinally(bufferedReader2, th);
            } else {
                bufferedReader2.close();
            }
            InlineMarker.finallyEnd(1);
        } finally {
        }
    }

    private static final void forEachLine(Path path, Charset charset, Function1<? super String, Unit> function1) {
        BufferedReader newBufferedReader = Files.newBufferedReader(path, charset);
        Intrinsics.checkNotNullExpressionValue(newBufferedReader, "Files.newBufferedReader(this, charset)");
        BufferedReader bufferedReader = newBufferedReader;
        BufferedReader bufferedReader2 = bufferedReader instanceof BufferedReader ? bufferedReader : new BufferedReader(bufferedReader, 8192);
        Throwable th = null;
        try {
            for (String str : TextStreamsKt.lineSequence(bufferedReader2)) {
                function1.invoke(str);
            }
            Unit unit = Unit.INSTANCE;
            InlineMarker.finallyStart(1);
            if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0)) {
                CloseableKt.closeFinally(bufferedReader2, th);
            } else {
                bufferedReader2.close();
            }
            InlineMarker.finallyEnd(1);
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                InlineMarker.finallyStart(1);
                if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0)) {
                    CloseableKt.closeFinally(bufferedReader2, th2);
                } else {
                    try {
                        bufferedReader2.close();
                    } catch (Throwable unused) {
                    }
                }
                InlineMarker.finallyEnd(1);
                throw th3;
            }
        }
    }

    private static final InputStream inputStream(Path path, OpenOption... openOptionArr) {
        InputStream newInputStream = Files.newInputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
        Intrinsics.checkNotNullExpressionValue(newInputStream, "Files.newInputStream(this, *options)");
        return newInputStream;
    }

    private static final OutputStream outputStream(Path path, OpenOption... openOptionArr) {
        OutputStream newOutputStream = Files.newOutputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
        Intrinsics.checkNotNullExpressionValue(newOutputStream, "Files.newOutputStream(this, *options)");
        return newOutputStream;
    }

    static /* synthetic */ List readLines$default(Path path, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        List<String> readAllLines = Files.readAllLines(path, charset);
        Intrinsics.checkNotNullExpressionValue(readAllLines, "Files.readAllLines(this, charset)");
        return readAllLines;
    }

    private static final List<String> readLines(Path path, Charset charset) {
        List<String> readAllLines = Files.readAllLines(path, charset);
        Intrinsics.checkNotNullExpressionValue(readAllLines, "Files.readAllLines(this, charset)");
        return readAllLines;
    }

    static /* synthetic */ Object useLines$default(Path path, Charset charset, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        BufferedReader newBufferedReader = Files.newBufferedReader(path, charset);
        Throwable th = null;
        try {
            BufferedReader it = newBufferedReader;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            Object invoke = function1.invoke(TextStreamsKt.lineSequence(it));
            InlineMarker.finallyStart(1);
            if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0)) {
                CloseableKt.closeFinally(newBufferedReader, th);
            } else if (newBufferedReader != null) {
                newBufferedReader.close();
            }
            InlineMarker.finallyEnd(1);
            return invoke;
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                InlineMarker.finallyStart(1);
                if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0)) {
                    CloseableKt.closeFinally(newBufferedReader, th2);
                } else if (newBufferedReader != null) {
                    try {
                        newBufferedReader.close();
                    } catch (Throwable unused) {
                    }
                }
                InlineMarker.finallyEnd(1);
                throw th3;
            }
        }
    }

    private static final <T> T useLines(Path path, Charset charset, Function1<? super Sequence<String>, ? extends T> function1) {
        BufferedReader newBufferedReader = Files.newBufferedReader(path, charset);
        Throwable th = null;
        try {
            BufferedReader it = newBufferedReader;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            T invoke = function1.invoke(TextStreamsKt.lineSequence(it));
            InlineMarker.finallyStart(1);
            if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0)) {
                CloseableKt.closeFinally(newBufferedReader, th);
            } else if (newBufferedReader != null) {
                newBufferedReader.close();
            }
            InlineMarker.finallyEnd(1);
            return invoke;
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                InlineMarker.finallyStart(1);
                if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0)) {
                    CloseableKt.closeFinally(newBufferedReader, th2);
                } else if (newBufferedReader != null) {
                    try {
                        newBufferedReader.close();
                    } catch (Throwable unused) {
                    }
                }
                InlineMarker.finallyEnd(1);
                throw th3;
            }
        }
    }

    static /* synthetic */ Path writeLines$default(Path path, Iterable iterable, Charset charset, OpenOption[] openOptionArr, int i, Object obj) {
        if ((i & 2) != 0) {
            charset = Charsets.UTF_8;
        }
        Path write = Files.write(path, iterable, charset, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
        Intrinsics.checkNotNullExpressionValue(write, "Files.write(this, lines, charset, *options)");
        return write;
    }

    private static final Path writeLines(Path path, Iterable<? extends CharSequence> iterable, Charset charset, OpenOption... openOptionArr) {
        Path write = Files.write(path, iterable, charset, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
        Intrinsics.checkNotNullExpressionValue(write, "Files.write(this, lines, charset, *options)");
        return write;
    }

    static /* synthetic */ Path writeLines$default(Path path, Sequence sequence, Charset charset, OpenOption[] openOptionArr, int i, Object obj) {
        if ((i & 2) != 0) {
            charset = Charsets.UTF_8;
        }
        Path write = Files.write(path, SequencesKt.asIterable(sequence), charset, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
        Intrinsics.checkNotNullExpressionValue(write, "Files.write(this, lines.…ble(), charset, *options)");
        return write;
    }

    private static final Path writeLines(Path path, Sequence<? extends CharSequence> sequence, Charset charset, OpenOption... openOptionArr) {
        Path write = Files.write(path, SequencesKt.asIterable(sequence), charset, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
        Intrinsics.checkNotNullExpressionValue(write, "Files.write(this, lines.…ble(), charset, *options)");
        return write;
    }

    static /* synthetic */ Path appendLines$default(Path path, Iterable iterable, Charset charset, int i, Object obj) {
        if ((i & 2) != 0) {
            charset = Charsets.UTF_8;
        }
        Path write = Files.write(path, iterable, charset, StandardOpenOption.APPEND);
        Intrinsics.checkNotNullExpressionValue(write, "Files.write(this, lines,…tandardOpenOption.APPEND)");
        return write;
    }

    private static final Path appendLines(Path path, Iterable<? extends CharSequence> iterable, Charset charset) {
        Path write = Files.write(path, iterable, charset, StandardOpenOption.APPEND);
        Intrinsics.checkNotNullExpressionValue(write, "Files.write(this, lines,…tandardOpenOption.APPEND)");
        return write;
    }

    static /* synthetic */ Path appendLines$default(Path path, Sequence sequence, Charset charset, int i, Object obj) {
        if ((i & 2) != 0) {
            charset = Charsets.UTF_8;
        }
        Path write = Files.write(path, SequencesKt.asIterable(sequence), charset, StandardOpenOption.APPEND);
        Intrinsics.checkNotNullExpressionValue(write, "Files.write(this, lines.…tandardOpenOption.APPEND)");
        return write;
    }

    private static final Path appendLines(Path path, Sequence<? extends CharSequence> sequence, Charset charset) {
        Path write = Files.write(path, SequencesKt.asIterable(sequence), charset, StandardOpenOption.APPEND);
        Intrinsics.checkNotNullExpressionValue(write, "Files.write(this, lines.…tandardOpenOption.APPEND)");
        return write;
    }
}
