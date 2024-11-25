package kotlinx.coroutines.flow;

import com.rigol.scope.utilities.ViewUtil;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Add missing generic type declarations: [R, T1, T2] */
/* compiled from: Zip.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00052\u0006\u0010\u0006\u001a\u0002H\u00022\u0006\u0010\u0007\u001a\u0002H\u0003H\u008a@¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"<anonymous>", "", "T1", "T2", "R", "Lkotlinx/coroutines/flow/FlowCollector;", ViewUtil.KEY_A, ViewUtil.KEY_B, "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__ZipKt$combine$1$1"}, k = 3, mv = {1, 1, 15})
/* loaded from: classes2.dex */
final class FlowKt__ZipKt$combine$$inlined$unsafeFlow$1$lambda$1<R, T1, T2> extends SuspendLambda implements Function4<FlowCollector<? super R>, T1, T2, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    private FlowCollector p$;
    private Object p$0;
    private Object p$1;
    final /* synthetic */ FlowKt__ZipKt$combine$$inlined$unsafeFlow$1 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__ZipKt$combine$$inlined$unsafeFlow$1$lambda$1(Continuation continuation, FlowKt__ZipKt$combine$$inlined$unsafeFlow$1 flowKt__ZipKt$combine$$inlined$unsafeFlow$1) {
        super(4, continuation);
        this.this$0 = flowKt__ZipKt$combine$$inlined$unsafeFlow$1;
    }

    public final Continuation<Unit> create(FlowCollector<? super R> create, T1 t1, T2 t2, Continuation<? super Unit> continuation) {
        Intrinsics.checkParameterIsNotNull(create, "$this$create");
        Intrinsics.checkParameterIsNotNull(continuation, "continuation");
        FlowKt__ZipKt$combine$$inlined$unsafeFlow$1$lambda$1 flowKt__ZipKt$combine$$inlined$unsafeFlow$1$lambda$1 = new FlowKt__ZipKt$combine$$inlined$unsafeFlow$1$lambda$1(continuation, this.this$0);
        flowKt__ZipKt$combine$$inlined$unsafeFlow$1$lambda$1.p$ = create;
        flowKt__ZipKt$combine$$inlined$unsafeFlow$1$lambda$1.p$0 = t1;
        flowKt__ZipKt$combine$$inlined$unsafeFlow$1$lambda$1.p$1 = t2;
        return flowKt__ZipKt$combine$$inlined$unsafeFlow$1$lambda$1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function4
    public final Object invoke(Object obj, Object obj2, Object obj3, Continuation<? super Unit> continuation) {
        return ((FlowKt__ZipKt$combine$$inlined$unsafeFlow$1$lambda$1) create((FlowCollector) obj, obj2, obj3, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        FlowCollector flowCollector;
        Object obj2;
        FlowCollector flowCollector2;
        Object obj3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            flowCollector = this.p$;
            obj2 = this.p$0;
            Object obj4 = this.p$1;
            Function3 function3 = this.this$0.$transform$inlined;
            this.L$0 = flowCollector;
            this.L$1 = obj2;
            this.L$2 = obj4;
            this.L$3 = flowCollector;
            this.label = 1;
            Object invoke = function3.invoke(obj2, obj4, this);
            if (invoke == coroutine_suspended) {
                return coroutine_suspended;
            }
            flowCollector2 = flowCollector;
            obj3 = obj4;
            obj = invoke;
        } else if (i != 1) {
            if (i == 2) {
                FlowCollector flowCollector3 = (FlowCollector) this.L$0;
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            flowCollector = (FlowCollector) this.L$3;
            obj3 = this.L$2;
            obj2 = this.L$1;
            flowCollector2 = (FlowCollector) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        this.L$0 = flowCollector2;
        this.L$1 = obj2;
        this.L$2 = obj3;
        this.label = 2;
        if (flowCollector.emit(obj, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }
}
