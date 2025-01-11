package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

/* compiled from: Count.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a!\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u0004\u001aE\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\"\u0010\u0005\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0006H\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"count", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/Flow;", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "predicate", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 5, mv = {1, 1, 15}, xs = "kotlinx/coroutines/flow/FlowKt")
/* loaded from: classes2.dex */
final /* synthetic */ class FlowKt__CountKt {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object count(Flow<? extends T> flow, Continuation<? super Integer> continuation) {
        FlowKt__CountKt$count$1 flowKt__CountKt$count$1;
        int i;
        Ref.IntRef intRef;
        if (continuation instanceof FlowKt__CountKt$count$1) {
            flowKt__CountKt$count$1 = (FlowKt__CountKt$count$1) continuation;
            if ((flowKt__CountKt$count$1.label & Integer.MIN_VALUE) != 0) {
                flowKt__CountKt$count$1.label -= Integer.MIN_VALUE;
                Object obj = flowKt__CountKt$count$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = flowKt__CountKt$count$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    final Ref.IntRef intRef2 = new Ref.IntRef();
                    intRef2.element = 0;
                    flowKt__CountKt$count$1.L$0 = flow;
                    flowKt__CountKt$count$1.L$1 = intRef2;
                    flowKt__CountKt$count$1.L$2 = flow;
                    flowKt__CountKt$count$1.label = 1;
                    if (flow.collect(new FlowCollector<T>() { // from class: kotlinx.coroutines.flow.FlowKt__CountKt$count$$inlined$collect$1
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        public Object emit(Object obj2, Continuation continuation2) {
                            Ref.IntRef intRef3 = Ref.IntRef.this;
                            intRef3.element++;
                            int i2 = intRef3.element;
                            return Unit.INSTANCE;
                        }
                    }, flowKt__CountKt$count$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    intRef = intRef2;
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    Flow flow2 = (Flow) flowKt__CountKt$count$1.L$2;
                    intRef = (Ref.IntRef) flowKt__CountKt$count$1.L$1;
                    Flow flow3 = (Flow) flowKt__CountKt$count$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                return Boxing.boxInt(intRef.element);
            }
        }
        flowKt__CountKt$count$1 = new FlowKt__CountKt$count$1(continuation);
        Object obj2 = flowKt__CountKt$count$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = flowKt__CountKt$count$1.label;
        if (i != 0) {
        }
        return Boxing.boxInt(intRef.element);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object count(Flow<? extends T> flow, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2, Continuation<? super Integer> continuation) {
        FlowKt__CountKt$count$3 flowKt__CountKt$count$3;
        int i;
        Ref.IntRef intRef;
        if (continuation instanceof FlowKt__CountKt$count$3) {
            flowKt__CountKt$count$3 = (FlowKt__CountKt$count$3) continuation;
            if ((flowKt__CountKt$count$3.label & Integer.MIN_VALUE) != 0) {
                flowKt__CountKt$count$3.label -= Integer.MIN_VALUE;
                Object obj = flowKt__CountKt$count$3.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = flowKt__CountKt$count$3.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    Ref.IntRef intRef2 = new Ref.IntRef();
                    intRef2.element = 0;
                    flowKt__CountKt$count$3.L$0 = flow;
                    flowKt__CountKt$count$3.L$1 = function2;
                    flowKt__CountKt$count$3.L$2 = intRef2;
                    flowKt__CountKt$count$3.L$3 = flow;
                    flowKt__CountKt$count$3.label = 1;
                    if (flow.collect(new FlowKt__CountKt$count$$inlined$collect$2<>(function2, intRef2), flowKt__CountKt$count$3) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    intRef = intRef2;
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    Flow flow2 = (Flow) flowKt__CountKt$count$3.L$3;
                    intRef = (Ref.IntRef) flowKt__CountKt$count$3.L$2;
                    Function2 function22 = (Function2) flowKt__CountKt$count$3.L$1;
                    Flow flow3 = (Flow) flowKt__CountKt$count$3.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                return Boxing.boxInt(intRef.element);
            }
        }
        flowKt__CountKt$count$3 = new FlowKt__CountKt$count$3(continuation);
        Object obj2 = flowKt__CountKt$count$3.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = flowKt__CountKt$count$3.label;
        if (i != 0) {
        }
        return Boxing.boxInt(intRef.element);
    }
}
