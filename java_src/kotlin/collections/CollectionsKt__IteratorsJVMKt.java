package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import java.util.Enumeration;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IteratorsJVM.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001f\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0086\u0002¨\u0006\u0004"}, d2 = {"iterator", "", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/util/Enumeration;", "kotlin-stdlib"}, k = 5, mv = {1, 4, 0}, xi = 1, xs = "kotlin/collections/CollectionsKt")
/* loaded from: classes2.dex */
public class CollectionsKt__IteratorsJVMKt extends CollectionsKt__IterablesKt {
    public static final <T> Iterator<T> iterator(Enumeration<T> iterator) {
        Intrinsics.checkNotNullParameter(iterator, "$this$iterator");
        return new CollectionsKt__IteratorsJVMKt$iterator$1(iterator);
    }
}
