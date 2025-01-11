package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: Collect.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class FlowKt__ReduceKt$reduce$$inlined$collect$1<T> implements FlowCollector<T> {
    final /* synthetic */ Ref.ObjectRef $accumulator$inlined;
    final /* synthetic */ Function3 $operation$inlined;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0096@¨\u0006\u0007"}, d2 = {"emit", "", ExifInterface.GPS_DIRECTION_TRUE, "value", "continuation", "Lkotlin/coroutines/Continuation;", "", "kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3$emit$1"}, k = 3, mv = {1, 1, 15})
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt$reduce$$inlined$collect$1", f = "Reduce.kt", i = {0, 0, 0, 0, 1, 1, 1, 1}, l = {138, 138}, m = "emit", n = {"this", "value", "continuation", "value", "this", "value", "continuation", "value"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt$reduce$$inlined$collect$1$1  reason: invalid class name */
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
            return FlowKt__ReduceKt$reduce$$inlined$collect$1.this.emit(null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0092 A[RETURN] */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object emit(Object obj, Continuation continuation) {
        AnonymousClass1 anonymousClass1;
        Object obj2;
        Object coroutine_suspended;
        int i;
        Ref.ObjectRef objectRef;
        Ref.ObjectRef objectRef2;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
                obj2 = anonymousClass1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = anonymousClass1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj2);
                    AnonymousClass1 anonymousClass12 = anonymousClass1;
                    objectRef = this.$accumulator$inlined;
                    if (objectRef.element != NullSurrogateKt.NULL) {
                        Function3 function3 = this.$operation$inlined;
                        T t = this.$accumulator$inlined.element;
                        anonymousClass1.L$0 = this;
                        anonymousClass1.L$1 = obj;
                        anonymousClass1.L$2 = anonymousClass12;
                        anonymousClass1.L$3 = obj;
                        anonymousClass1.L$4 = objectRef;
                        anonymousClass1.label = 2;
                        anonymousClass1.L$0 = this;
                        anonymousClass1.L$1 = obj;
                        anonymousClass1.L$2 = anonymousClass12;
                        anonymousClass1.L$3 = obj;
                        anonymousClass1.L$4 = objectRef;
                        anonymousClass1.label = 1;
                        obj2 = function3.invoke(t, obj, anonymousClass1);
                        if (obj2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        objectRef2 = objectRef;
                    }
                    objectRef.element = (T) obj;
                    return Unit.INSTANCE;
                } else if (i != 1) {
                    if (i == 2) {
                        objectRef2 = (Ref.ObjectRef) anonymousClass1.L$4;
                        Object obj3 = anonymousClass1.L$3;
                        Continuation continuation2 = (Continuation) anonymousClass1.L$2;
                        Object obj4 = anonymousClass1.L$1;
                        FlowKt__ReduceKt$reduce$$inlined$collect$1 flowKt__ReduceKt$reduce$$inlined$collect$1 = (FlowKt__ReduceKt$reduce$$inlined$collect$1) anonymousClass1.L$0;
                        ResultKt.throwOnFailure(obj2);
                        Object obj5 = obj2;
                        Ref.ObjectRef objectRef3 = objectRef2;
                        obj = (T) obj5;
                        objectRef = objectRef3;
                        objectRef.element = (T) obj;
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    objectRef2 = (Ref.ObjectRef) anonymousClass1.L$4;
                    Object obj6 = anonymousClass1.L$3;
                    Continuation continuation3 = (Continuation) anonymousClass1.L$2;
                    Object obj7 = anonymousClass1.L$1;
                    FlowKt__ReduceKt$reduce$$inlined$collect$1 flowKt__ReduceKt$reduce$$inlined$collect$12 = (FlowKt__ReduceKt$reduce$$inlined$collect$1) anonymousClass1.L$0;
                    ResultKt.throwOnFailure(obj2);
                }
                if (obj2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                Object obj52 = obj2;
                Ref.ObjectRef objectRef32 = objectRef2;
                obj = (T) obj52;
                objectRef = objectRef32;
                objectRef.element = (T) obj;
                return Unit.INSTANCE;
            }
        }
        anonymousClass1 = new AnonymousClass1(continuation);
        obj2 = anonymousClass1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = anonymousClass1.label;
        if (i != 0) {
        }
        if (obj2 == coroutine_suspended) {
        }
        Object obj522 = obj2;
        Ref.ObjectRef objectRef322 = objectRef2;
        obj = (T) obj522;
        objectRef = objectRef322;
        objectRef.element = (T) obj;
        return Unit.INSTANCE;
    }

    public FlowKt__ReduceKt$reduce$$inlined$collect$1(Ref.ObjectRef objectRef, Function3 function3) {
        this.$accumulator$inlined = objectRef;
        this.$operation$inlined = function3;
    }
}
