package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.ranges.IntRange;

/* compiled from: SafeCollector.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollectorKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$9 implements Flow<Integer> {
    final /* synthetic */ IntRange $this_asFlow$inlined;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0096@¨\u0006\b"}, d2 = {"collect", "", ExifInterface.GPS_DIRECTION_TRUE, "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "continuation", "Lkotlin/coroutines/Continuation;", "", "kotlinx/coroutines/flow/internal/SafeCollectorKt$unsafeFlow$1$collect$1"}, k = 3, mv = {1, 1, 15})
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$9", f = "Builders.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {128}, m = "collect", n = {"this", "collector", "continuation", "$receiver", "$this$forEach$iv", "element$iv", "value"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$6", "I$0"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$9$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$9.this.collect(null, this);
        }
    }

    public FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$9(IntRange intRange) {
        this.$this_asFlow$inlined = intRange;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [kotlinx.coroutines.flow.FlowCollector, kotlin.coroutines.Continuation] */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x006f  */
    @Override // kotlinx.coroutines.flow.Flow
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object collect(FlowCollector<? super Integer> flowCollector, Continuation continuation) {
        AnonymousClass1 anonymousClass1;
        int i;
        FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$9 flowKt__BuildersKt$asFlow$$inlined$unsafeFlow$9;
        Continuation continuation2;
        FlowCollector<? super Integer> flowCollector2;
        Iterator<Integer> it;
        Object obj;
        Object obj2;
        AnonymousClass1 anonymousClass12;
        FlowCollector<? super Integer> flowCollector3;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
                Object obj3 = anonymousClass1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = anonymousClass1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj3);
                    IntRange intRange = this.$this_asFlow$inlined;
                    flowKt__BuildersKt$asFlow$$inlined$unsafeFlow$9 = this;
                    continuation2 = anonymousClass1;
                    flowCollector2 = flowCollector;
                    it = intRange.iterator();
                    obj = intRange;
                    obj2 = coroutine_suspended;
                    anonymousClass12 = anonymousClass1;
                    flowCollector3 = flowCollector2;
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    int i2 = anonymousClass1.I$0;
                    Object obj4 = anonymousClass1.L$6;
                    it = (Iterator) anonymousClass1.L$5;
                    continuation2 = (Continuation) anonymousClass1.L$2;
                    flowKt__BuildersKt$asFlow$$inlined$unsafeFlow$9 = (FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$9) anonymousClass1.L$0;
                    ResultKt.throwOnFailure(obj3);
                    flowCollector2 = (FlowCollector) anonymousClass1.L$3;
                    obj = (Iterable) anonymousClass1.L$4;
                    obj2 = coroutine_suspended;
                    anonymousClass12 = anonymousClass1;
                    flowCollector3 = (FlowCollector) anonymousClass1.L$1;
                }
                while (it.hasNext()) {
                    Integer next = it.next();
                    int intValue = next.intValue();
                    Integer boxInt = Boxing.boxInt(intValue);
                    anonymousClass12.L$0 = flowKt__BuildersKt$asFlow$$inlined$unsafeFlow$9;
                    anonymousClass12.L$1 = flowCollector3;
                    anonymousClass12.L$2 = continuation2;
                    anonymousClass12.L$3 = flowCollector2;
                    anonymousClass12.L$4 = obj;
                    anonymousClass12.L$5 = it;
                    anonymousClass12.L$6 = next;
                    anonymousClass12.I$0 = intValue;
                    anonymousClass12.label = 1;
                    if (flowCollector2.emit(boxInt, anonymousClass12) == obj2) {
                        return obj2;
                    }
                }
                return Unit.INSTANCE;
            }
        }
        anonymousClass1 = new AnonymousClass1(continuation);
        Object obj32 = anonymousClass1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = anonymousClass1.label;
        if (i != 0) {
        }
        while (it.hasNext()) {
        }
        return Unit.INSTANCE;
    }
}
