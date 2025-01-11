package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: Collect.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__TransformKt$$special$$inlined$collect$10"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class FlowKt__TransformKt$scanReduce$$inlined$unsafeFlow$1$lambda$1<T> implements FlowCollector<T> {
    final /* synthetic */ Ref.ObjectRef $accumulator$inlined;
    final /* synthetic */ FlowCollector $this_unsafeFlow$inlined;
    final /* synthetic */ FlowKt__TransformKt$scanReduce$$inlined$unsafeFlow$1 this$0;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0096@¨\u0006\b"}, d2 = {"emit", "", ExifInterface.GPS_DIRECTION_TRUE, "value", "continuation", "Lkotlin/coroutines/Continuation;", "", "kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3$emit$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$$special$$inlined$collect$10$1"}, k = 3, mv = {1, 1, 15})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$scanReduce$$inlined$unsafeFlow$1$lambda$1$1  reason: invalid class name */
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
            return FlowKt__TransformKt$scanReduce$$inlined$unsafeFlow$1$lambda$1.this.emit(null, this);
        }
    }

    public FlowKt__TransformKt$scanReduce$$inlined$unsafeFlow$1$lambda$1(FlowCollector flowCollector, Ref.ObjectRef objectRef, FlowKt__TransformKt$scanReduce$$inlined$unsafeFlow$1 flowKt__TransformKt$scanReduce$$inlined$unsafeFlow$1) {
        this.$this_unsafeFlow$inlined = flowCollector;
        this.$accumulator$inlined = objectRef;
        this.this$0 = flowKt__TransformKt$scanReduce$$inlined$unsafeFlow$1;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a4 A[RETURN] */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object emit(Object obj, Continuation continuation) {
        AnonymousClass1 anonymousClass1;
        Object coroutine_suspended;
        int i;
        Ref.ObjectRef objectRef;
        FlowKt__TransformKt$scanReduce$$inlined$unsafeFlow$1$lambda$1<T> flowKt__TransformKt$scanReduce$$inlined$unsafeFlow$1$lambda$1;
        Object obj2;
        Continuation continuation2;
        Object obj3;
        FlowCollector flowCollector;
        T t;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
                Object obj4 = anonymousClass1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = anonymousClass1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj4);
                    AnonymousClass1 anonymousClass12 = anonymousClass1;
                    objectRef = this.$accumulator$inlined;
                    if (objectRef.element == NullSurrogateKt.NULL) {
                        flowKt__TransformKt$scanReduce$$inlined$unsafeFlow$1$lambda$1 = this;
                        obj2 = obj;
                    } else {
                        Function3 function3 = this.this$0.$operation$inlined;
                        T t2 = this.$accumulator$inlined.element;
                        anonymousClass1.L$0 = this;
                        anonymousClass1.L$1 = obj;
                        anonymousClass1.L$2 = anonymousClass12;
                        anonymousClass1.L$3 = obj;
                        anonymousClass1.L$4 = objectRef;
                        anonymousClass1.label = 1;
                        Object invoke = function3.invoke(t2, obj, anonymousClass1);
                        if (invoke == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        flowKt__TransformKt$scanReduce$$inlined$unsafeFlow$1$lambda$1 = this;
                        obj2 = obj;
                        obj = invoke;
                    }
                    continuation2 = anonymousClass12;
                    obj3 = obj2;
                } else if (i != 1) {
                    if (i == 2) {
                        Object obj5 = anonymousClass1.L$3;
                        Continuation continuation3 = (Continuation) anonymousClass1.L$2;
                        Object obj6 = anonymousClass1.L$1;
                        FlowKt__TransformKt$scanReduce$$inlined$unsafeFlow$1$lambda$1 flowKt__TransformKt$scanReduce$$inlined$unsafeFlow$1$lambda$12 = (FlowKt__TransformKt$scanReduce$$inlined$unsafeFlow$1$lambda$1) anonymousClass1.L$0;
                        ResultKt.throwOnFailure(obj4);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    Object obj7 = anonymousClass1.L$3;
                    continuation2 = (Continuation) anonymousClass1.L$2;
                    obj2 = anonymousClass1.L$1;
                    flowKt__TransformKt$scanReduce$$inlined$unsafeFlow$1$lambda$1 = (FlowKt__TransformKt$scanReduce$$inlined$unsafeFlow$1$lambda$1) anonymousClass1.L$0;
                    ResultKt.throwOnFailure(obj4);
                    objectRef = (Ref.ObjectRef) anonymousClass1.L$4;
                    obj = (T) obj4;
                    obj3 = obj7;
                }
                objectRef.element = (T) obj;
                flowCollector = flowKt__TransformKt$scanReduce$$inlined$unsafeFlow$1$lambda$1.$this_unsafeFlow$inlined;
                t = flowKt__TransformKt$scanReduce$$inlined$unsafeFlow$1$lambda$1.$accumulator$inlined.element;
                anonymousClass1.L$0 = flowKt__TransformKt$scanReduce$$inlined$unsafeFlow$1$lambda$1;
                anonymousClass1.L$1 = obj2;
                anonymousClass1.L$2 = continuation2;
                anonymousClass1.L$3 = obj3;
                anonymousClass1.label = 2;
                if (flowCollector.emit(t, anonymousClass1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
        }
        anonymousClass1 = new AnonymousClass1(continuation);
        Object obj42 = anonymousClass1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = anonymousClass1.label;
        if (i != 0) {
        }
        objectRef.element = (T) obj;
        flowCollector = flowKt__TransformKt$scanReduce$$inlined$unsafeFlow$1$lambda$1.$this_unsafeFlow$inlined;
        t = flowKt__TransformKt$scanReduce$$inlined$unsafeFlow$1$lambda$1.$accumulator$inlined.element;
        anonymousClass1.L$0 = flowKt__TransformKt$scanReduce$$inlined$unsafeFlow$1$lambda$1;
        anonymousClass1.L$1 = obj2;
        anonymousClass1.L$2 = continuation2;
        anonymousClass1.L$3 = obj3;
        anonymousClass1.label = 2;
        if (flowCollector.emit(t, anonymousClass1) == coroutine_suspended) {
        }
        return Unit.INSTANCE;
    }
}
