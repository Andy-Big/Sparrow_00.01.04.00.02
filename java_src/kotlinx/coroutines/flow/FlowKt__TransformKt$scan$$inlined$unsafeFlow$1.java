package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;

/* JADX INFO: Add missing generic type declarations: [R] */
/* compiled from: SafeCollector.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollectorKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class FlowKt__TransformKt$scan$$inlined$unsafeFlow$1<R> implements Flow<R> {
    final /* synthetic */ Object $initial$inlined;
    final /* synthetic */ Function3 $operation$inlined;
    final /* synthetic */ Flow $this_scan$inlined;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0096@¨\u0006\b"}, d2 = {"collect", "", ExifInterface.GPS_DIRECTION_TRUE, "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "continuation", "Lkotlin/coroutines/Continuation;", "", "kotlinx/coroutines/flow/internal/SafeCollectorKt$unsafeFlow$1$collect$1"}, k = 3, mv = {1, 1, 15})
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__TransformKt$scan$$inlined$unsafeFlow$1", f = "Transform.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1}, l = {127, 129}, m = "collect", n = {"this", "collector", "continuation", "$receiver", "accumulator", "this", "collector", "continuation", "$receiver", "accumulator", "$this$collect$iv"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$scan$$inlined$unsafeFlow$1$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends ContinuationImpl {
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
            return FlowKt__TransformKt$scan$$inlined$unsafeFlow$1.this.collect(null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00ac A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00ad A[PHI: r11 
      PHI: (r11v6 java.lang.Object) = (r11v5 java.lang.Object), (r11v1 java.lang.Object) binds: [B:21:0x00aa, B:12:0x0029] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Type inference failed for: r5v0, types: [T, java.lang.Object] */
    @Override // kotlinx.coroutines.flow.Flow
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object collect(FlowCollector flowCollector, Continuation continuation) {
        AnonymousClass1 anonymousClass1;
        int i;
        Ref.ObjectRef objectRef;
        FlowKt__TransformKt$scan$$inlined$unsafeFlow$1<R> flowKt__TransformKt$scan$$inlined$unsafeFlow$1;
        FlowCollector flowCollector2;
        Continuation continuation2;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
                Object obj = anonymousClass1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = anonymousClass1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    AnonymousClass1 anonymousClass12 = anonymousClass1;
                    objectRef = new Ref.ObjectRef();
                    objectRef.element = this.$initial$inlined;
                    T t = objectRef.element;
                    anonymousClass1.L$0 = this;
                    anonymousClass1.L$1 = flowCollector;
                    anonymousClass1.L$2 = anonymousClass12;
                    anonymousClass1.L$3 = flowCollector;
                    anonymousClass1.L$4 = objectRef;
                    anonymousClass1.label = 1;
                    if (flowCollector.emit(t, anonymousClass1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    flowKt__TransformKt$scan$$inlined$unsafeFlow$1 = this;
                    flowCollector2 = flowCollector;
                    continuation2 = anonymousClass12;
                } else if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    Flow flow = (Flow) anonymousClass1.L$5;
                    Ref.ObjectRef objectRef2 = (Ref.ObjectRef) anonymousClass1.L$4;
                    FlowCollector flowCollector3 = (FlowCollector) anonymousClass1.L$3;
                    Continuation continuation3 = (Continuation) anonymousClass1.L$2;
                    FlowCollector flowCollector4 = (FlowCollector) anonymousClass1.L$1;
                    FlowKt__TransformKt$scan$$inlined$unsafeFlow$1 flowKt__TransformKt$scan$$inlined$unsafeFlow$12 = (FlowKt__TransformKt$scan$$inlined$unsafeFlow$1) anonymousClass1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    FlowCollector flowCollector5 = (FlowCollector) anonymousClass1.L$3;
                    continuation2 = (Continuation) anonymousClass1.L$2;
                    flowCollector2 = (FlowCollector) anonymousClass1.L$1;
                    flowKt__TransformKt$scan$$inlined$unsafeFlow$1 = (FlowKt__TransformKt$scan$$inlined$unsafeFlow$1) anonymousClass1.L$0;
                    ResultKt.throwOnFailure(obj);
                    objectRef = (Ref.ObjectRef) anonymousClass1.L$4;
                    flowCollector = flowCollector5;
                }
                Flow flow2 = flowKt__TransformKt$scan$$inlined$unsafeFlow$1.$this_scan$inlined;
                anonymousClass1.L$0 = flowKt__TransformKt$scan$$inlined$unsafeFlow$1;
                anonymousClass1.L$1 = flowCollector2;
                anonymousClass1.L$2 = continuation2;
                anonymousClass1.L$3 = flowCollector;
                anonymousClass1.L$4 = objectRef;
                anonymousClass1.L$5 = flow2;
                anonymousClass1.label = 2;
                obj = flow2.collect(new FlowKt__TransformKt$scan$$inlined$unsafeFlow$1$lambda$1(flowCollector, objectRef, flowKt__TransformKt$scan$$inlined$unsafeFlow$1), anonymousClass1);
                return obj != coroutine_suspended ? coroutine_suspended : obj;
            }
        }
        anonymousClass1 = new AnonymousClass1(continuation);
        Object obj2 = anonymousClass1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = anonymousClass1.label;
        if (i != 0) {
        }
        Flow flow22 = flowKt__TransformKt$scan$$inlined$unsafeFlow$1.$this_scan$inlined;
        anonymousClass1.L$0 = flowKt__TransformKt$scan$$inlined$unsafeFlow$1;
        anonymousClass1.L$1 = flowCollector2;
        anonymousClass1.L$2 = continuation2;
        anonymousClass1.L$3 = flowCollector;
        anonymousClass1.L$4 = objectRef;
        anonymousClass1.L$5 = flow22;
        anonymousClass1.label = 2;
        obj2 = flow22.collect(new FlowKt__TransformKt$scan$$inlined$unsafeFlow$1$lambda$1(flowCollector, objectRef, flowKt__TransformKt$scan$$inlined$unsafeFlow$1), anonymousClass1);
        if (obj2 != coroutine_suspended2) {
        }
    }

    public FlowKt__TransformKt$scan$$inlined$unsafeFlow$1(Flow flow, Object obj, Function3 function3) {
        this.$this_scan$inlined = flow;
        this.$initial$inlined = obj;
        this.$operation$inlined = function3;
    }
}
