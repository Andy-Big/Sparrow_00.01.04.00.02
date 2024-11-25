package kotlin.io;

import java.nio.charset.CharsetDecoder;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
/* compiled from: Console.kt */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
/* loaded from: classes2.dex */
final /* synthetic */ class LineReader$readLine$1 extends MutablePropertyReference0Impl {
    LineReader$readLine$1(LineReader lineReader) {
        super(lineReader, LineReader.class, "decoder", "getDecoder()Ljava/nio/charset/CharsetDecoder;", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        return LineReader.access$getDecoder$p((LineReader) this.receiver);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(Object obj) {
        LineReader lineReader = (LineReader) this.receiver;
        LineReader.decoder = (CharsetDecoder) obj;
    }
}
