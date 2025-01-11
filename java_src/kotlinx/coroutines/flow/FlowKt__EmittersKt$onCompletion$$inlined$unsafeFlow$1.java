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
import kotlinx.coroutines.flow.internal.SafeCollector;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: SafeCollector.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollectorKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1<T> implements Flow<T> {
    final /* synthetic */ Function3 $action$inlined;
    final /* synthetic */ Flow $this_onCompletion$inlined;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0096@¨\u0006\b"}, d2 = {"collect", "", ExifInterface.GPS_DIRECTION_TRUE, "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "continuation", "Lkotlin/coroutines/Continuation;", "", "kotlinx/coroutines/flow/internal/SafeCollectorKt$unsafeFlow$1$collect$1"}, k = 3, mv = {1, 1, 15})
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1", f = "Emitters.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2}, l = {128, 131, 131}, m = "collect", n = {"this", "collector", "continuation", "$receiver", "exception", "this", "collector", "continuation", "$receiver", "exception", "this", "collector", "continuation", "$receiver", "exception"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1  reason: invalid class name */
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
            return FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1.this.collect(null, this);
        }
    }

    public FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1(Flow flow, Function3 function3) {
        this.$this_onCompletion$inlined = flow;
        this.$action$inlined = function3;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:1|(2:3|(7:5|6|(1:(1:(1:(2:11|(1:13)(1:15))(2:16|17))(2:18|(2:20|21)(1:22)))(4:23|24|25|26))(4:43|44|45|(1:47)(1:48))|27|28|29|(1:31)(2:32|(0)(0))))|52|6|(0)(0)|27|28|29|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00d7, code lost:
        r12 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00d8, code lost:
        r9 = r2;
        r2 = r11;
        r11 = r12;
        r12 = r9;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00cf A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0105 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x010a  */
    @Override // kotlinx.coroutines.flow.Flow
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object collect(FlowCollector flowCollector, Continuation continuation) {
        AnonymousClass1 anonymousClass1;
        Object coroutine_suspended;
        int i;
        Throwable th;
        FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1<T> flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1;
        FlowCollector flowCollector2;
        Continuation continuation2;
        Throwable th2;
        FlowCollector flowCollector3;
        Throwable th3;
        Function3 function3;
        Throwable th4;
        Throwable th5;
        Function3 function32;
        Throwable th6;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
                Object obj = anonymousClass1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = anonymousClass1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    AnonymousClass1 anonymousClass12 = anonymousClass1;
                    th = null;
                    try {
                        Flow flow = this.$this_onCompletion$inlined;
                        anonymousClass1.L$0 = this;
                        anonymousClass1.L$1 = flowCollector;
                        anonymousClass1.L$2 = anonymousClass12;
                        anonymousClass1.L$3 = flowCollector;
                        anonymousClass1.L$4 = th;
                        anonymousClass1.label = 1;
                        Object catchImpl = FlowKt.catchImpl(flow, flowCollector, anonymousClass1);
                        if (catchImpl == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1 = this;
                        flowCollector2 = flowCollector;
                        continuation2 = anonymousClass12;
                        obj = catchImpl;
                    } catch (Throwable th7) {
                        flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1 = this;
                        flowCollector2 = flowCollector;
                        continuation2 = anonymousClass12;
                        th2 = th;
                        flowCollector3 = flowCollector2;
                        th3 = th7;
                        function3 = flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1.$action$inlined;
                        anonymousClass1.L$0 = flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1;
                        anonymousClass1.L$1 = flowCollector2;
                        anonymousClass1.L$2 = continuation2;
                        anonymousClass1.L$3 = flowCollector3;
                        anonymousClass1.L$4 = th2;
                        anonymousClass1.L$5 = th3;
                        anonymousClass1.label = 3;
                        if (FlowKt__EmittersKt.invokeSafely$FlowKt__EmittersKt(new SafeCollector(flowCollector3, anonymousClass1.getContext()), function3, th2, anonymousClass1) == coroutine_suspended) {
                        }
                    }
                } else if (i != 1) {
                    if (i == 2) {
                        th6 = (Throwable) anonymousClass1.L$4;
                        FlowCollector flowCollector4 = (FlowCollector) anonymousClass1.L$3;
                        Continuation continuation3 = (Continuation) anonymousClass1.L$2;
                        FlowCollector flowCollector5 = (FlowCollector) anonymousClass1.L$1;
                        FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1 flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$12 = (FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1) anonymousClass1.L$0;
                        ResultKt.throwOnFailure(obj);
                        if (th6 != null) {
                            return Unit.INSTANCE;
                        }
                        throw th6;
                    } else if (i == 3) {
                        th3 = (Throwable) anonymousClass1.L$5;
                        th4 = (Throwable) anonymousClass1.L$4;
                        FlowCollector flowCollector6 = (FlowCollector) anonymousClass1.L$3;
                        Continuation continuation4 = (Continuation) anonymousClass1.L$2;
                        FlowCollector flowCollector7 = (FlowCollector) anonymousClass1.L$1;
                        FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1 flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$13 = (FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1) anonymousClass1.L$0;
                        ResultKt.throwOnFailure(obj);
                        if (th4 == null) {
                            throw th4;
                        }
                        throw th3;
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    Throwable th8 = (Throwable) anonymousClass1.L$4;
                    flowCollector3 = (FlowCollector) anonymousClass1.L$3;
                    continuation2 = (Continuation) anonymousClass1.L$2;
                    flowCollector2 = (FlowCollector) anonymousClass1.L$1;
                    flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1 = (FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1) anonymousClass1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        th = th8;
                        flowCollector = flowCollector3;
                    } catch (Throwable th9) {
                        th2 = th8;
                        th3 = th9;
                        function3 = flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1.$action$inlined;
                        anonymousClass1.L$0 = flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1;
                        anonymousClass1.L$1 = flowCollector2;
                        anonymousClass1.L$2 = continuation2;
                        anonymousClass1.L$3 = flowCollector3;
                        anonymousClass1.L$4 = th2;
                        anonymousClass1.L$5 = th3;
                        anonymousClass1.label = 3;
                        if (FlowKt__EmittersKt.invokeSafely$FlowKt__EmittersKt(new SafeCollector(flowCollector3, anonymousClass1.getContext()), function3, th2, anonymousClass1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        th4 = th2;
                        if (th4 == null) {
                        }
                    }
                }
                th5 = (Throwable) obj;
                function32 = flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1.$action$inlined;
                anonymousClass1.L$0 = flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1;
                anonymousClass1.L$1 = flowCollector2;
                anonymousClass1.L$2 = continuation2;
                anonymousClass1.L$3 = flowCollector;
                anonymousClass1.L$4 = th5;
                anonymousClass1.label = 2;
                if (FlowKt__EmittersKt.invokeSafely$FlowKt__EmittersKt(new SafeCollector(flowCollector, anonymousClass1.getContext()), function32, th5, anonymousClass1) != coroutine_suspended) {
                    return coroutine_suspended;
                }
                th6 = th5;
                if (th6 != null) {
                }
            }
        }
        anonymousClass1 = new AnonymousClass1(continuation);
        Object obj2 = anonymousClass1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = anonymousClass1.label;
        if (i != 0) {
        }
        th5 = (Throwable) obj2;
        function32 = flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1.$action$inlined;
        anonymousClass1.L$0 = flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1;
        anonymousClass1.L$1 = flowCollector2;
        anonymousClass1.L$2 = continuation2;
        anonymousClass1.L$3 = flowCollector;
        anonymousClass1.L$4 = th5;
        anonymousClass1.label = 2;
        if (FlowKt__EmittersKt.invokeSafely$FlowKt__EmittersKt(new SafeCollector(flowCollector, anonymousClass1.getContext()), function32, th5, anonymousClass1) != coroutine_suspended) {
        }
    }
}
