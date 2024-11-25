package kotlinx.coroutines.flow.internal;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
/* compiled from: Merge.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx/coroutines/flow/internal/ChannelFlowMerge$collectTo$2$1"}, k = 3, mv = {1, 1, 15})
/* loaded from: classes2.dex */
final class ChannelFlowMerge$collectTo$$inlined$collect$1$lambda$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Flow $inner;
    Object L$0;
    int label;
    private CoroutineScope p$;
    final /* synthetic */ ChannelFlowMerge$collectTo$$inlined$collect$1 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelFlowMerge$collectTo$$inlined$collect$1$lambda$1(Flow flow, Continuation continuation, ChannelFlowMerge$collectTo$$inlined$collect$1 channelFlowMerge$collectTo$$inlined$collect$1) {
        super(2, continuation);
        this.$inner = flow;
        this.this$0 = channelFlowMerge$collectTo$$inlined$collect$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> completion) {
        Intrinsics.checkParameterIsNotNull(completion, "completion");
        ChannelFlowMerge$collectTo$$inlined$collect$1$lambda$1 channelFlowMerge$collectTo$$inlined$collect$1$lambda$1 = new ChannelFlowMerge$collectTo$$inlined$collect$1$lambda$1(this.$inner, completion, this.this$0);
        channelFlowMerge$collectTo$$inlined$collect$1$lambda$1.p$ = (CoroutineScope) obj;
        return channelFlowMerge$collectTo$$inlined$collect$1$lambda$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ChannelFlowMerge$collectTo$$inlined$collect$1$lambda$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.L$0 = this.p$;
                this.label = 1;
                if (this.$inner.collect(this.this$0.$collector$inlined, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            this.this$0.$semaphore$inlined.release();
            return Unit.INSTANCE;
        } catch (Throwable th) {
            this.this$0.$semaphore$inlined.release();
            throw th;
        }
    }
}
