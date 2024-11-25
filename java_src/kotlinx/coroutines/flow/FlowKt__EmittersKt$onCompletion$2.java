package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: Emitters.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u008a@¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/FlowCollector;", "it", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 15})
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$2", f = "Emitters.kt", i = {0, 0}, l = {145}, m = "invokeSuspend", n = {"$this$onCompletion", "it"}, s = {"L$0", "L$1"})
/* loaded from: classes2.dex */
public final class FlowKt__EmittersKt$onCompletion$2<T> extends SuspendLambda implements Function3<FlowCollector<? super T>, Throwable, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2 $action;
    Object L$0;
    Object L$1;
    int label;
    private FlowCollector p$;
    private Throwable p$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__EmittersKt$onCompletion$2(Function2 function2, Continuation continuation) {
        super(3, continuation);
        this.$action = function2;
    }

    public final Continuation<Unit> create(FlowCollector<? super T> create, Throwable th, Continuation<? super Unit> continuation) {
        Intrinsics.checkParameterIsNotNull(create, "$this$create");
        Intrinsics.checkParameterIsNotNull(continuation, "continuation");
        FlowKt__EmittersKt$onCompletion$2 flowKt__EmittersKt$onCompletion$2 = new FlowKt__EmittersKt$onCompletion$2(this.$action, continuation);
        flowKt__EmittersKt$onCompletion$2.p$ = create;
        flowKt__EmittersKt$onCompletion$2.p$0 = th;
        return flowKt__EmittersKt$onCompletion$2;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Throwable th, Continuation<? super Unit> continuation) {
        return ((FlowKt__EmittersKt$onCompletion$2) create((FlowCollector) obj, th, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector = this.p$;
            Throwable th = this.p$0;
            Function2 function2 = this.$action;
            this.L$0 = flowCollector;
            this.L$1 = th;
            this.label = 1;
            if (function2.invoke(th, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            Throwable th2 = (Throwable) this.L$1;
            FlowCollector flowCollector2 = (FlowCollector) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
