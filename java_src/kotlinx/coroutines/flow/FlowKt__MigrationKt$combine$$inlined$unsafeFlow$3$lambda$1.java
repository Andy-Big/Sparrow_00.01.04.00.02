package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: Zip.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0005\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0004\b\u0001\u0010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "invoke", "()[Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__ZipKt$combine$5$1"}, k = 3, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class FlowKt__MigrationKt$combine$$inlined$unsafeFlow$3$lambda$1<T> extends Lambda implements Function0<T[]> {
    final /* synthetic */ FlowKt__MigrationKt$combine$$inlined$unsafeFlow$3 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__MigrationKt$combine$$inlined$unsafeFlow$3$lambda$1(FlowKt__MigrationKt$combine$$inlined$unsafeFlow$3 flowKt__MigrationKt$combine$$inlined$unsafeFlow$3) {
        super(0);
        this.this$0 = flowKt__MigrationKt$combine$$inlined$unsafeFlow$3;
    }

    @Override // kotlin.jvm.functions.Function0
    public final T[] invoke() {
        int length = this.this$0.$flows$inlined.length;
        Intrinsics.reifiedOperationMarker(0, "T?");
        return (T[]) new Object[length];
    }
}
