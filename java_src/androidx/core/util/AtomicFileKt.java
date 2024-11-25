package androidx.core.util;

import com.sun.mail.imap.IMAPStore;
import java.io.FileOutputStream;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
/* compiled from: AtomicFile.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\b\u001a\u0016\u0010\u0003\u001a\u00020\u0004*\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0007\u001a0\u0010\u0007\u001a\u00020\b*\u00020\u00022!\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\b0\nH\u0087\b\u001a\u0014\u0010\u000f\u001a\u00020\b*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0001H\u0007\u001a\u001e\u0010\u0011\u001a\u00020\b*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0013"}, d2 = {"readBytes", "", "Landroid/util/AtomicFile;", "readText", "", "charset", "Ljava/nio/charset/Charset;", "tryWrite", "", "block", "Lkotlin/Function1;", "Ljava/io/FileOutputStream;", "Lkotlin/ParameterName;", IMAPStore.ID_NAME, "out", "writeBytes", "array", "writeText", "text", "core-ktx_release"}, k = 2, mv = {1, 1, 16})
/* loaded from: classes.dex */
public final class AtomicFileKt {
    public static final void tryWrite(android.util.AtomicFile tryWrite, Function1<? super FileOutputStream, Unit> block) {
        Intrinsics.checkParameterIsNotNull(tryWrite, "$this$tryWrite");
        Intrinsics.checkParameterIsNotNull(block, "block");
        FileOutputStream stream = tryWrite.startWrite();
        try {
            Intrinsics.checkExpressionValueIsNotNull(stream, "stream");
            block.invoke(stream);
            InlineMarker.finallyStart(1);
            tryWrite.finishWrite(stream);
            InlineMarker.finallyEnd(1);
        } catch (Throwable th) {
            InlineMarker.finallyStart(1);
            tryWrite.failWrite(stream);
            InlineMarker.finallyEnd(1);
            throw th;
        }
    }

    public static /* synthetic */ void writeText$default(android.util.AtomicFile atomicFile, String str, Charset charset, int i, Object obj) {
        if ((i & 2) != 0) {
            charset = Charsets.UTF_8;
        }
        writeText(atomicFile, str, charset);
    }

    public static final void writeText(android.util.AtomicFile writeText, String text, Charset charset) {
        Intrinsics.checkParameterIsNotNull(writeText, "$this$writeText");
        Intrinsics.checkParameterIsNotNull(text, "text");
        Intrinsics.checkParameterIsNotNull(charset, "charset");
        byte[] bytes = text.getBytes(charset);
        Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
        writeBytes(writeText, bytes);
    }

    public static final byte[] readBytes(android.util.AtomicFile readBytes) {
        Intrinsics.checkParameterIsNotNull(readBytes, "$this$readBytes");
        byte[] readFully = readBytes.readFully();
        Intrinsics.checkExpressionValueIsNotNull(readFully, "readFully()");
        return readFully;
    }

    public static /* synthetic */ String readText$default(android.util.AtomicFile atomicFile, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        return readText(atomicFile, charset);
    }

    public static final String readText(android.util.AtomicFile readText, Charset charset) {
        Intrinsics.checkParameterIsNotNull(readText, "$this$readText");
        Intrinsics.checkParameterIsNotNull(charset, "charset");
        byte[] readFully = readText.readFully();
        Intrinsics.checkExpressionValueIsNotNull(readFully, "readFully()");
        return new String(readFully, charset);
    }

    public static final void writeBytes(android.util.AtomicFile writeBytes, byte[] array) {
        Intrinsics.checkParameterIsNotNull(writeBytes, "$this$writeBytes");
        Intrinsics.checkParameterIsNotNull(array, "array");
        FileOutputStream stream = writeBytes.startWrite();
        try {
            Intrinsics.checkExpressionValueIsNotNull(stream, "stream");
            stream.write(array);
            writeBytes.finishWrite(stream);
        } catch (Throwable th) {
            writeBytes.failWrite(stream);
            throw th;
        }
    }
}
