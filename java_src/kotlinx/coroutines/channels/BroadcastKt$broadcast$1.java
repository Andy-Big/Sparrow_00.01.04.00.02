package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Add missing generic type declarations: [E] */
/* compiled from: Broadcast.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/ProducerScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 15})
@DebugMetadata(c = "kotlinx.coroutines.channels.BroadcastKt$broadcast$1", f = "Broadcast.kt", i = {0, 1, 1}, l = {29, 30}, m = "invokeSuspend", n = {"$this$broadcast", "$this$broadcast", "e"}, s = {"L$0", "L$0", "L$1"})
/* loaded from: classes2.dex */
final class BroadcastKt$broadcast$1<E> extends SuspendLambda implements Function2<ProducerScope<? super E>, Continuation<? super Unit>, Object> {
    final /* synthetic */ ReceiveChannel $this_broadcast;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    private ProducerScope p$;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BroadcastKt$broadcast$1(ReceiveChannel receiveChannel, Continuation continuation) {
        super(2, continuation);
        this.$this_broadcast = receiveChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> completion) {
        Intrinsics.checkParameterIsNotNull(completion, "completion");
        BroadcastKt$broadcast$1 broadcastKt$broadcast$1 = new BroadcastKt$broadcast$1(this.$this_broadcast, completion);
        broadcastKt$broadcast$1.p$ = (ProducerScope) obj;
        return broadcastKt$broadcast$1;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Continuation<? super Unit> continuation) {
        return ((BroadcastKt$broadcast$1) create(obj, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0048 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0068 -> B:12:0x003c). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        ProducerScope producerScope;
        ChannelIterator<E> it;
        BroadcastKt$broadcast$1<E> broadcastKt$broadcast$1;
        Object hasNext;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            producerScope = this.p$;
            it = this.$this_broadcast.iterator();
        } else if (i == 1) {
            it = (ChannelIterator) this.L$1;
            ProducerScope producerScope2 = (ProducerScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            BroadcastKt$broadcast$1<E> broadcastKt$broadcast$12 = this;
            if (!((Boolean) obj).booleanValue()) {
                E next = it.next();
                broadcastKt$broadcast$12.L$0 = producerScope2;
                broadcastKt$broadcast$12.L$1 = next;
                broadcastKt$broadcast$12.L$2 = it;
                broadcastKt$broadcast$12.label = 2;
                if (producerScope2.send(next, broadcastKt$broadcast$12) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                producerScope = producerScope2;
                broadcastKt$broadcast$1 = broadcastKt$broadcast$12;
                broadcastKt$broadcast$1.L$0 = producerScope;
                broadcastKt$broadcast$1.L$1 = it;
                broadcastKt$broadcast$1.label = 1;
                hasNext = it.hasNext(broadcastKt$broadcast$1);
                if (hasNext != coroutine_suspended) {
                    return coroutine_suspended;
                }
                BroadcastKt$broadcast$1<E> broadcastKt$broadcast$13 = broadcastKt$broadcast$1;
                producerScope2 = producerScope;
                obj = hasNext;
                broadcastKt$broadcast$12 = broadcastKt$broadcast$13;
                if (!((Boolean) obj).booleanValue()) {
                    return Unit.INSTANCE;
                }
            }
        } else if (i != 2) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            it = (ChannelIterator) this.L$2;
            ResultKt.throwOnFailure(obj);
            producerScope = (ProducerScope) this.L$0;
        }
        broadcastKt$broadcast$1 = this;
        broadcastKt$broadcast$1.L$0 = producerScope;
        broadcastKt$broadcast$1.L$1 = it;
        broadcastKt$broadcast$1.label = 1;
        hasNext = it.hasNext(broadcastKt$broadcast$1);
        if (hasNext != coroutine_suspended) {
        }
    }
}
