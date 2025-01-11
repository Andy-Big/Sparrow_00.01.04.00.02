package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: SafeCollector.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollectorKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$2<T> implements Flow<T> {
    final /* synthetic */ Function1 $this_asFlow$inlined;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0096@¨\u0006\b"}, d2 = {"collect", "", ExifInterface.GPS_DIRECTION_TRUE, "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "continuation", "Lkotlin/coroutines/Continuation;", "", "kotlinx/coroutines/flow/internal/SafeCollectorKt$unsafeFlow$1$collect$1"}, k = 3, mv = {1, 1, 15})
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$2", f = "Builders.kt", i = {0, 0, 0, 0, 1, 1, 1, 1}, l = {126, 126}, m = "collect", n = {"this", "collector", "continuation", "$receiver", "this", "collector", "continuation", "$receiver"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$2$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$2.this.collect(null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x008d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x008e A[PHI: r9 
      PHI: (r9v7 java.lang.Object) = (r9v6 java.lang.Object), (r9v1 java.lang.Object) binds: [B:21:0x008b, B:12:0x0029] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    @Override // kotlinx.coroutines.flow.Flow
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object collect(FlowCollector flowCollector, Continuation continuation) {
        AnonymousClass1 anonymousClass1;
        int i;
        FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$2<T> flowKt__BuildersKt$asFlow$$inlined$unsafeFlow$2;
        FlowCollector flowCollector2;
        Continuation continuation2;
        FlowCollector flowCollector3;
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
                    Function1 function1 = this.$this_asFlow$inlined;
                    anonymousClass1.L$0 = this;
                    anonymousClass1.L$1 = flowCollector;
                    anonymousClass1.L$2 = anonymousClass12;
                    anonymousClass1.L$3 = flowCollector;
                    anonymousClass1.L$4 = flowCollector;
                    anonymousClass1.label = 1;
                    Object invoke = function1.invoke(anonymousClass1);
                    if (invoke == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    flowKt__BuildersKt$asFlow$$inlined$unsafeFlow$2 = this;
                    flowCollector2 = flowCollector;
                    continuation2 = anonymousClass12;
                    obj = invoke;
                    flowCollector3 = flowCollector2;
                } else if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    FlowCollector flowCollector4 = (FlowCollector) anonymousClass1.L$3;
                    Continuation continuation3 = (Continuation) anonymousClass1.L$2;
                    FlowCollector flowCollector5 = (FlowCollector) anonymousClass1.L$1;
                    FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$2 flowKt__BuildersKt$asFlow$$inlined$unsafeFlow$22 = (FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$2) anonymousClass1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    flowCollector = (FlowCollector) anonymousClass1.L$4;
                    flowCollector3 = (FlowCollector) anonymousClass1.L$3;
                    continuation2 = (Continuation) anonymousClass1.L$2;
                    flowCollector2 = (FlowCollector) anonymousClass1.L$1;
                    flowKt__BuildersKt$asFlow$$inlined$unsafeFlow$2 = (FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$2) anonymousClass1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                anonymousClass1.L$0 = flowKt__BuildersKt$asFlow$$inlined$unsafeFlow$2;
                anonymousClass1.L$1 = flowCollector2;
                anonymousClass1.L$2 = continuation2;
                anonymousClass1.L$3 = flowCollector3;
                anonymousClass1.label = 2;
                obj = flowCollector.emit(obj, anonymousClass1);
                return obj != coroutine_suspended ? coroutine_suspended : obj;
            }
        }
        anonymousClass1 = new AnonymousClass1(continuation);
        Object obj2 = anonymousClass1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = anonymousClass1.label;
        if (i != 0) {
        }
        anonymousClass1.L$0 = flowKt__BuildersKt$asFlow$$inlined$unsafeFlow$2;
        anonymousClass1.L$1 = flowCollector2;
        anonymousClass1.L$2 = continuation2;
        anonymousClass1.L$3 = flowCollector3;
        anonymousClass1.label = 2;
        obj2 = flowCollector.emit(obj2, anonymousClass1);
        if (obj2 != coroutine_suspended2) {
        }
    }

    public FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$2(Function1 function1) {
        this.$this_asFlow$inlined = function1;
    }
}
