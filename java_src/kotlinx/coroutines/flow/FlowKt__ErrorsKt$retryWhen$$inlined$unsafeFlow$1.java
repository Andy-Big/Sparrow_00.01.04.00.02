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
import kotlin.jvm.functions.Function4;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: SafeCollector.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollectorKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1<T> implements Flow<T> {
    final /* synthetic */ Function4 $predicate$inlined;
    final /* synthetic */ Flow $this_retryWhen$inlined;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0096@¨\u0006\b"}, d2 = {"collect", "", ExifInterface.GPS_DIRECTION_TRUE, "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "continuation", "Lkotlin/coroutines/Continuation;", "", "kotlinx/coroutines/flow/internal/SafeCollectorKt$unsafeFlow$1$collect$1"}, k = 3, mv = {1, 1, 15})
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1", f = "Errors.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2}, l = {130, 132, 132}, m = "collect", n = {"this", "collector", "continuation", "$receiver", "attempt", "shallRetry", "this", "collector", "continuation", "$receiver", "attempt", "cause", "this", "collector", "continuation", "$receiver", "attempt", "cause"}, s = {"L$0", "L$1", "L$2", "L$3", "J$0", "I$0", "L$0", "L$1", "L$2", "L$3", "J$0", "L$4", "L$0", "L$1", "L$2", "L$3", "J$0", "L$4"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        long J$0;
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
            return FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1.this.collect(null, this);
        }
    }

    public FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1(Flow flow, Function4 function4) {
        this.$this_retryWhen$inlined = flow;
        this.$predicate$inlined = function4;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [174=4] */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00ae A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00ec A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0105  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x00ba -> B:35:0x00fb). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x00ea -> B:31:0x00ed). Please submit an issue!!! */
    @Override // kotlinx.coroutines.flow.Flow
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object collect(FlowCollector flowCollector, Continuation continuation) {
        AnonymousClass1 anonymousClass1;
        FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1<T> flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1;
        int i;
        long j;
        Object obj;
        FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1<T> flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$12;
        Object obj2;
        FlowCollector flowCollector2;
        AnonymousClass1 anonymousClass12;
        FlowCollector flowCollector3;
        FlowCollector flowCollector4;
        FlowCollector flowCollector5;
        Throwable th;
        int i2;
        Throwable th2;
        Object catchImpl;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
                flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1 = this;
                Object obj3 = anonymousClass1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = anonymousClass1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj3);
                    j = 0;
                    obj = anonymousClass1;
                    flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$12 = flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1;
                    obj2 = coroutine_suspended;
                    flowCollector2 = flowCollector;
                    anonymousClass12 = anonymousClass1;
                    flowCollector3 = flowCollector2;
                    Flow flow = flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$12.$this_retryWhen$inlined;
                    anonymousClass12.L$0 = flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$12;
                    anonymousClass12.L$1 = flowCollector3;
                    anonymousClass12.L$2 = obj;
                    anonymousClass12.L$3 = flowCollector2;
                    anonymousClass12.J$0 = j;
                    anonymousClass12.I$0 = 0;
                    anonymousClass12.label = 1;
                    catchImpl = FlowKt.catchImpl(flow, flowCollector2, anonymousClass12);
                    if (catchImpl != obj2) {
                    }
                } else if (i == 1) {
                    i2 = anonymousClass1.I$0;
                    j = anonymousClass1.J$0;
                    flowCollector5 = (FlowCollector) anonymousClass1.L$3;
                    obj = (Continuation) anonymousClass1.L$2;
                    flowCollector4 = (FlowCollector) anonymousClass1.L$1;
                    flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$12 = (FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1) anonymousClass1.L$0;
                    ResultKt.throwOnFailure(obj3);
                    th2 = (Throwable) obj3;
                    if (th2 != null) {
                    }
                    flowCollector2 = flowCollector5;
                    long j2 = j;
                    Object obj4 = coroutine_suspended;
                    anonymousClass12 = anonymousClass1;
                    flowCollector3 = flowCollector4;
                    if (i2 == 0) {
                    }
                } else if (i == 2) {
                    th = (Throwable) anonymousClass1.L$4;
                    j = anonymousClass1.J$0;
                    flowCollector5 = (FlowCollector) anonymousClass1.L$3;
                    obj = (Continuation) anonymousClass1.L$2;
                    flowCollector4 = (FlowCollector) anonymousClass1.L$1;
                    flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$12 = (FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1) anonymousClass1.L$0;
                    ResultKt.throwOnFailure(obj3);
                    if (obj3 == coroutine_suspended) {
                    }
                    if (((Boolean) obj3).booleanValue()) {
                    }
                } else if (i != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    th = (Throwable) anonymousClass1.L$4;
                    j = anonymousClass1.J$0;
                    flowCollector5 = (FlowCollector) anonymousClass1.L$3;
                    obj = (Continuation) anonymousClass1.L$2;
                    flowCollector4 = (FlowCollector) anonymousClass1.L$1;
                    flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$12 = (FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1) anonymousClass1.L$0;
                    ResultKt.throwOnFailure(obj3);
                    if (((Boolean) obj3).booleanValue()) {
                        j++;
                        i2 = 1;
                        flowCollector2 = flowCollector5;
                        long j22 = j;
                        Object obj42 = coroutine_suspended;
                        anonymousClass12 = anonymousClass1;
                        flowCollector3 = flowCollector4;
                        if (i2 == 0) {
                            return Unit.INSTANCE;
                        }
                        obj2 = obj42;
                        j = j22;
                        Flow flow2 = flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$12.$this_retryWhen$inlined;
                        anonymousClass12.L$0 = flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$12;
                        anonymousClass12.L$1 = flowCollector3;
                        anonymousClass12.L$2 = obj;
                        anonymousClass12.L$3 = flowCollector2;
                        anonymousClass12.J$0 = j;
                        anonymousClass12.I$0 = 0;
                        anonymousClass12.label = 1;
                        catchImpl = FlowKt.catchImpl(flow2, flowCollector2, anonymousClass12);
                        if (catchImpl != obj2) {
                            return obj2;
                        }
                        flowCollector5 = flowCollector2;
                        obj3 = catchImpl;
                        flowCollector4 = flowCollector3;
                        anonymousClass1 = anonymousClass12;
                        coroutine_suspended = obj2;
                        i2 = 0;
                        th2 = (Throwable) obj3;
                        if (th2 != null) {
                            Function4 function4 = flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$12.$predicate$inlined;
                            Long boxLong = Boxing.boxLong(j);
                            anonymousClass1.L$0 = flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$12;
                            anonymousClass1.L$1 = flowCollector4;
                            anonymousClass1.L$2 = obj;
                            anonymousClass1.L$3 = flowCollector5;
                            anonymousClass1.J$0 = j;
                            anonymousClass1.L$4 = th2;
                            anonymousClass1.label = 3;
                            anonymousClass1.L$0 = flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$12;
                            anonymousClass1.L$1 = flowCollector4;
                            anonymousClass1.L$2 = obj;
                            anonymousClass1.L$3 = flowCollector5;
                            anonymousClass1.J$0 = j;
                            anonymousClass1.L$4 = th2;
                            anonymousClass1.label = 2;
                            Object invoke = function4.invoke(flowCollector5, th2, boxLong, anonymousClass1);
                            if (invoke == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            th = th2;
                            obj3 = invoke;
                            if (obj3 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            if (((Boolean) obj3).booleanValue()) {
                                throw th;
                            }
                        }
                        flowCollector2 = flowCollector5;
                        long j222 = j;
                        Object obj422 = coroutine_suspended;
                        anonymousClass12 = anonymousClass1;
                        flowCollector3 = flowCollector4;
                        if (i2 == 0) {
                        }
                    }
                }
            }
        }
        flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1 = this;
        anonymousClass1 = new AnonymousClass1(continuation);
        Object obj32 = anonymousClass1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = anonymousClass1.label;
        if (i != 0) {
        }
    }
}
