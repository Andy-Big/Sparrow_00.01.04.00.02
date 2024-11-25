package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.selects.SelectBuilder;
/* compiled from: Delay.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "invoke", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__DelayKt$debounce$2$1$2$1", "kotlinx/coroutines/flow/FlowKt__DelayKt$debounce$2$$special$$inlined$let$lambda$1"}, k = 3, mv = {1, 1, 15})
/* loaded from: classes2.dex */
final class FlowKt__DelayKt$debounce$2$invokeSuspend$$inlined$select$lambda$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ FlowCollector $downstream$inlined;
    final /* synthetic */ Ref.ObjectRef $lastValue$inlined;
    final /* synthetic */ SelectBuilder $this_select$inlined;
    final /* synthetic */ Object $value;
    final /* synthetic */ ReceiveChannel $values$inlined;
    int label;
    final /* synthetic */ FlowKt__DelayKt$debounce$2 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__DelayKt$debounce$2$invokeSuspend$$inlined$select$lambda$2(Object obj, Continuation continuation, SelectBuilder selectBuilder, FlowKt__DelayKt$debounce$2 flowKt__DelayKt$debounce$2, ReceiveChannel receiveChannel, Ref.ObjectRef objectRef, FlowCollector flowCollector) {
        super(1, continuation);
        this.$value = obj;
        this.$this_select$inlined = selectBuilder;
        this.this$0 = flowKt__DelayKt$debounce$2;
        this.$values$inlined = receiveChannel;
        this.$lastValue$inlined = objectRef;
        this.$downstream$inlined = flowCollector;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> completion) {
        Intrinsics.checkParameterIsNotNull(completion, "completion");
        return new FlowKt__DelayKt$debounce$2$invokeSuspend$$inlined$select$lambda$2(this.$value, completion, this.$this_select$inlined, this.this$0, this.$values$inlined, this.$lastValue$inlined, this.$downstream$inlined);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((FlowKt__DelayKt$debounce$2$invokeSuspend$$inlined$select$lambda$2) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.$lastValue$inlined.element = null;
            FlowCollector flowCollector = this.$downstream$inlined;
            Symbol symbol = NullSurrogateKt.NULL;
            Object obj2 = this.$value;
            Object obj3 = obj2 != symbol ? obj2 : null;
            this.label = 1;
            if (flowCollector.emit(obj3, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
