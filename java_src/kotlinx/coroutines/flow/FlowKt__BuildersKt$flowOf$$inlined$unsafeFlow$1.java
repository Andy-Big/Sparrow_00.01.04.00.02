package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: SafeCollector.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollectorKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1<T> implements Flow<T> {
    final /* synthetic */ Object[] $elements$inlined;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0096@¨\u0006\b"}, d2 = {"collect", "", ExifInterface.GPS_DIRECTION_TRUE, "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "continuation", "Lkotlin/coroutines/Continuation;", "", "kotlinx/coroutines/flow/internal/SafeCollectorKt$unsafeFlow$1$collect$1"}, k = 3, mv = {1, 1, 15})
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1", f = "Builders.kt", i = {0, 0, 0, 0, 0}, l = {127}, m = "collect", n = {"this", "collector", "continuation", "$receiver", "element"}, s = {"L$0", "L$1", "L$2", "L$3", "L$5"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1.this.collect(null, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0083  */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.lang.Object[]] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x007e -> B:19:0x0081). Please submit an issue!!! */
    @Override // kotlinx.coroutines.flow.Flow
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object collect(FlowCollector flowCollector, Continuation continuation) {
        AnonymousClass1 anonymousClass1;
        int i;
        int length;
        FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1<T> flowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1;
        Object obj;
        FlowCollector flowCollector2;
        int i2;
        T[] tArr;
        Object obj2;
        AnonymousClass1 anonymousClass12;
        FlowCollector flowCollector3;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
                Object obj3 = anonymousClass1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = anonymousClass1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj3);
                    ?? r2 = this.$elements$inlined;
                    length = r2.length;
                    flowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1 = this;
                    obj = anonymousClass1;
                    flowCollector2 = flowCollector;
                    i2 = 0;
                    tArr = r2;
                    obj2 = coroutine_suspended;
                    anonymousClass12 = anonymousClass1;
                    flowCollector3 = flowCollector2;
                    if (i2 < length) {
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    Object obj4 = anonymousClass1.L$5;
                    i2 = anonymousClass1.I$1;
                    int i3 = anonymousClass1.I$0;
                    obj = (Continuation) anonymousClass1.L$2;
                    flowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1 = (FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1) anonymousClass1.L$0;
                    ResultKt.throwOnFailure(obj3);
                    flowCollector2 = (FlowCollector) anonymousClass1.L$3;
                    tArr = (Object[]) anonymousClass1.L$4;
                    length = i3;
                    obj2 = coroutine_suspended;
                    anonymousClass12 = anonymousClass1;
                    flowCollector3 = (FlowCollector) anonymousClass1.L$1;
                    i2++;
                    if (i2 < length) {
                        T t = tArr[i2];
                        anonymousClass12.L$0 = flowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1;
                        anonymousClass12.L$1 = flowCollector3;
                        anonymousClass12.L$2 = obj;
                        anonymousClass12.L$3 = flowCollector2;
                        anonymousClass12.L$4 = tArr;
                        anonymousClass12.I$0 = length;
                        anonymousClass12.I$1 = i2;
                        anonymousClass12.L$5 = t;
                        anonymousClass12.label = 1;
                        if (flowCollector2.emit(t, anonymousClass12) == obj2) {
                            return obj2;
                        }
                        i2++;
                        if (i2 < length) {
                            return Unit.INSTANCE;
                        }
                    }
                }
            }
        }
        anonymousClass1 = new AnonymousClass1(continuation);
        Object obj32 = anonymousClass1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = anonymousClass1.label;
        if (i != 0) {
        }
    }

    public FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1(Object[] objArr) {
        this.$elements$inlined = objArr;
    }
}
