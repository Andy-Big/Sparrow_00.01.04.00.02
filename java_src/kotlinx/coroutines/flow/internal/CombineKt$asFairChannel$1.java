package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.ChannelCoroutine;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Combine.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 15})
@DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$asFairChannel$1", f = "Combine.kt", i = {0, 0, 0}, l = {144}, m = "invokeSuspend", n = {"$this$produce", "channel", "$this$collect$iv"}, s = {"L$0", "L$1", "L$2"})
/* loaded from: classes2.dex */
public final class CombineKt$asFairChannel$1 extends SuspendLambda implements Function2<ProducerScope<? super Object>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Flow $flow;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    private ProducerScope p$;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CombineKt$asFairChannel$1(Flow flow, Continuation continuation) {
        super(2, continuation);
        this.$flow = flow;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> completion) {
        Intrinsics.checkParameterIsNotNull(completion, "completion");
        CombineKt$asFairChannel$1 combineKt$asFairChannel$1 = new CombineKt$asFairChannel$1(this.$flow, completion);
        combineKt$asFairChannel$1.p$ = (ProducerScope) obj;
        return combineKt$asFairChannel$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(ProducerScope<? super Object> producerScope, Continuation<? super Unit> continuation) {
        return ((CombineKt$asFairChannel$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ProducerScope producerScope = this.p$;
            SendChannel channel = producerScope.getChannel();
            if (channel == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.channels.ChannelCoroutine<kotlin.Any>");
            }
            final ChannelCoroutine channelCoroutine = (ChannelCoroutine) channel;
            Flow flow = this.$flow;
            this.L$0 = producerScope;
            this.L$1 = channelCoroutine;
            this.L$2 = flow;
            this.label = 1;
            if (flow.collect(new FlowCollector<Object>() { // from class: kotlinx.coroutines.flow.internal.CombineKt$asFairChannel$1$invokeSuspend$$inlined$collect$1
                @Override // kotlinx.coroutines.flow.FlowCollector
                public Object emit(Object obj2, Continuation continuation) {
                    ChannelCoroutine channelCoroutine2 = ChannelCoroutine.this;
                    if (obj2 == null) {
                        obj2 = NullSurrogateKt.NULL;
                    }
                    return channelCoroutine2.sendFair(obj2, continuation);
                }
            }, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            Flow flow2 = (Flow) this.L$2;
            ChannelCoroutine channelCoroutine2 = (ChannelCoroutine) this.L$1;
            ProducerScope producerScope2 = (ProducerScope) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
