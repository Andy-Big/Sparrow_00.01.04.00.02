package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import kotlinx.coroutines.internal.Symbol;
/* compiled from: Delay.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "it", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__DelayKt$debounce$2$1$1"}, k = 3, mv = {1, 1, 15})
/* loaded from: classes2.dex */
final class FlowKt__DelayKt$debounce$2$invokeSuspend$$inlined$select$lambda$1 extends SuspendLambda implements Function2<Object, Continuation<? super Unit>, Object> {
    final /* synthetic */ FlowCollector $downstream$inlined;
    final /* synthetic */ Ref.ObjectRef $lastValue$inlined;
    final /* synthetic */ ReceiveChannel $values$inlined;
    Object L$0;
    int label;
    private Object p$0;
    final /* synthetic */ FlowKt__DelayKt$debounce$2 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__DelayKt$debounce$2$invokeSuspend$$inlined$select$lambda$1(Continuation continuation, FlowKt__DelayKt$debounce$2 flowKt__DelayKt$debounce$2, ReceiveChannel receiveChannel, Ref.ObjectRef objectRef, FlowCollector flowCollector) {
        super(2, continuation);
        this.this$0 = flowKt__DelayKt$debounce$2;
        this.$values$inlined = receiveChannel;
        this.$lastValue$inlined = objectRef;
        this.$downstream$inlined = flowCollector;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> completion) {
        Intrinsics.checkParameterIsNotNull(completion, "completion");
        FlowKt__DelayKt$debounce$2$invokeSuspend$$inlined$select$lambda$1 flowKt__DelayKt$debounce$2$invokeSuspend$$inlined$select$lambda$1 = new FlowKt__DelayKt$debounce$2$invokeSuspend$$inlined$select$lambda$1(completion, this.this$0, this.$values$inlined, this.$lastValue$inlined, this.$downstream$inlined);
        flowKt__DelayKt$debounce$2$invokeSuspend$$inlined$select$lambda$1.p$0 = obj;
        return flowKt__DelayKt$debounce$2$invokeSuspend$$inlined$select$lambda$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Continuation<? super Unit> continuation) {
        return ((FlowKt__DelayKt$debounce$2$invokeSuspend$$inlined$select$lambda$1) create(obj, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [kotlinx.coroutines.internal.Symbol, T] */
    /* JADX WARN: Type inference failed for: r6v1, types: [T, java.lang.Object] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ?? r6 = this.p$0;
            if (r6 == 0) {
                if (this.$lastValue$inlined.element != 0) {
                    FlowCollector flowCollector = this.$downstream$inlined;
                    Symbol symbol = NullSurrogateKt.NULL;
                    Object obj2 = this.$lastValue$inlined.element;
                    if (obj2 == symbol) {
                        obj2 = null;
                    }
                    this.L$0 = r6;
                    this.label = 1;
                    if (flowCollector.emit(obj2, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } else {
                this.$lastValue$inlined.element = r6;
                return Unit.INSTANCE;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        this.$lastValue$inlined.element = NullSurrogateKt.DONE;
        return Unit.INSTANCE;
    }
}
