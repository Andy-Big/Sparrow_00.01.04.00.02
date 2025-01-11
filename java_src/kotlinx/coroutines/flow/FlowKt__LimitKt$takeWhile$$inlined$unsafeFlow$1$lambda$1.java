package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.internal.AbortFlowException;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: Collect.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__LimitKt$$special$$inlined$collect$4"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class FlowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1$lambda$1<T> implements FlowCollector<T> {
    final /* synthetic */ FlowCollector $this_unsafeFlow$inlined;
    final /* synthetic */ FlowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1 this$0;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0096@¨\u0006\b"}, d2 = {"emit", "", ExifInterface.GPS_DIRECTION_TRUE, "value", "continuation", "Lkotlin/coroutines/Continuation;", "", "kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3$emit$1", "kotlinx/coroutines/flow/FlowKt__LimitKt$$special$$inlined$collect$4$1"}, k = 3, mv = {1, 1, 15})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1$lambda$1$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1$lambda$1.this.emit(null, this);
        }
    }

    public FlowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1$lambda$1(FlowCollector flowCollector, FlowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1 flowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1) {
        this.$this_unsafeFlow$inlined = flowCollector;
        this.this$0 = flowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v8, resolved type: kotlinx.coroutines.flow.FlowCollector */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x008c  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object emit(Object obj, Continuation continuation) {
        AnonymousClass1 anonymousClass1;
        Object obj2;
        int i;
        AnonymousClass1 anonymousClass12;
        FlowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1$lambda$1<T> flowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1$lambda$1;
        Object obj3;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
                obj2 = anonymousClass1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = anonymousClass1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj2);
                    anonymousClass12 = anonymousClass1;
                    Function2 function2 = this.this$0.$predicate$inlined;
                    anonymousClass1.L$0 = this;
                    anonymousClass1.L$1 = obj;
                    anonymousClass1.L$2 = anonymousClass12;
                    anonymousClass1.L$3 = obj;
                    anonymousClass1.label = 1;
                    obj2 = function2.invoke(obj, anonymousClass1);
                    if (obj2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    flowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1$lambda$1 = this;
                    obj3 = obj;
                } else if (i != 1) {
                    if (i == 2) {
                        Object obj4 = anonymousClass1.L$3;
                        Continuation continuation2 = (Continuation) anonymousClass1.L$2;
                        Object obj5 = anonymousClass1.L$1;
                        FlowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1$lambda$1 flowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1$lambda$12 = (FlowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1$lambda$1) anonymousClass1.L$0;
                        ResultKt.throwOnFailure(obj2);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    obj = anonymousClass1.L$3;
                    anonymousClass12 = (Continuation) anonymousClass1.L$2;
                    obj3 = anonymousClass1.L$1;
                    flowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1$lambda$1 = (FlowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1$lambda$1) anonymousClass1.L$0;
                    ResultKt.throwOnFailure(obj2);
                }
                if (((Boolean) obj2).booleanValue()) {
                    throw new AbortFlowException();
                }
                FlowCollector flowCollector = flowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1$lambda$1.$this_unsafeFlow$inlined;
                anonymousClass1.L$0 = flowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1$lambda$1;
                anonymousClass1.L$1 = obj3;
                anonymousClass1.L$2 = anonymousClass12;
                anonymousClass1.L$3 = obj;
                anonymousClass1.label = 2;
                if (flowCollector.emit(obj, anonymousClass1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
        }
        anonymousClass1 = new AnonymousClass1(continuation);
        obj2 = anonymousClass1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = anonymousClass1.label;
        if (i != 0) {
        }
        if (((Boolean) obj2).booleanValue()) {
        }
    }
}
