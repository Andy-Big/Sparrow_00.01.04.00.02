package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: SafeCollector.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollectorKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$8 implements Flow<Long> {
    final /* synthetic */ long[] $this_asFlow$inlined;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0096@¨\u0006\b"}, d2 = {"collect", "", ExifInterface.GPS_DIRECTION_TRUE, "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "continuation", "Lkotlin/coroutines/Continuation;", "", "kotlinx/coroutines/flow/internal/SafeCollectorKt$unsafeFlow$1$collect$1"}, k = 3, mv = {1, 1, 15})
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$8", f = "Builders.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {128}, m = "collect", n = {"this", "collector", "continuation", "$receiver", "$this$forEach$iv", "element$iv", "value"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "J$0", "J$1"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$8$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        long J$0;
        long J$1;
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
            return FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$8.this.collect(null, this);
        }
    }

    public FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$8(long[] jArr) {
        this.$this_asFlow$inlined = jArr;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [kotlinx.coroutines.flow.FlowCollector, kotlin.coroutines.Continuation] */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00ab  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x00a4 -> B:20:0x00a6). Please submit an issue!!! */
    @Override // kotlinx.coroutines.flow.Flow
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object collect(FlowCollector<? super Long> flowCollector, Continuation continuation) {
        AnonymousClass1 anonymousClass1;
        int i;
        int length;
        int i2;
        FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$8 flowKt__BuildersKt$asFlow$$inlined$unsafeFlow$8;
        Object obj;
        long[] jArr;
        long[] jArr2;
        Object obj2;
        AnonymousClass1 anonymousClass12;
        FlowCollector<? super Long> flowCollector2;
        FlowCollector<? super Long> flowCollector3;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
                Object obj3 = anonymousClass1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = anonymousClass1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj3);
                    long[] jArr3 = this.$this_asFlow$inlined;
                    length = jArr3.length;
                    i2 = 0;
                    flowKt__BuildersKt$asFlow$$inlined$unsafeFlow$8 = this;
                    obj = anonymousClass1;
                    jArr = jArr3;
                    jArr2 = jArr;
                    FlowCollector<? super Long> flowCollector4 = flowCollector;
                    obj2 = coroutine_suspended;
                    anonymousClass12 = anonymousClass1;
                    flowCollector2 = flowCollector4;
                    flowCollector3 = flowCollector4;
                    if (i2 < length) {
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    long j = anonymousClass1.J$1;
                    long j2 = anonymousClass1.J$0;
                    int i3 = anonymousClass1.I$1;
                    int i4 = anonymousClass1.I$0;
                    obj = (Continuation) anonymousClass1.L$2;
                    flowKt__BuildersKt$asFlow$$inlined$unsafeFlow$8 = (FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$8) anonymousClass1.L$0;
                    ResultKt.throwOnFailure(obj3);
                    int i5 = i4;
                    FlowCollector<? super Long> flowCollector5 = (FlowCollector) anonymousClass1.L$3;
                    Object obj4 = coroutine_suspended;
                    jArr2 = (long[]) anonymousClass1.L$4;
                    anonymousClass12 = anonymousClass1;
                    jArr = (long[]) anonymousClass1.L$5;
                    flowCollector2 = (FlowCollector) anonymousClass1.L$1;
                    i2 = i3 + 1;
                    obj2 = obj4;
                    length = i5;
                    flowCollector3 = flowCollector5;
                    if (i2 < length) {
                        long j3 = jArr[i2];
                        long longValue = Boxing.boxLong(j3).longValue();
                        Long boxLong = Boxing.boxLong(longValue);
                        anonymousClass12.L$0 = flowKt__BuildersKt$asFlow$$inlined$unsafeFlow$8;
                        anonymousClass12.L$1 = flowCollector2;
                        anonymousClass12.L$2 = obj;
                        anonymousClass12.L$3 = flowCollector3;
                        anonymousClass12.L$4 = jArr2;
                        anonymousClass12.L$5 = jArr;
                        i5 = length;
                        anonymousClass12.I$0 = i5;
                        anonymousClass12.I$1 = i2;
                        anonymousClass12.J$0 = j3;
                        anonymousClass12.J$1 = longValue;
                        anonymousClass12.label = 1;
                        if (flowCollector3.emit(boxLong, anonymousClass12) == obj2) {
                            return obj2;
                        }
                        obj4 = obj2;
                        i3 = i2;
                        flowCollector5 = flowCollector3;
                        i2 = i3 + 1;
                        obj2 = obj4;
                        length = i5;
                        flowCollector3 = flowCollector5;
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
}
