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
/* compiled from: Channels.common.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/ProducerScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 15})
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$filter$1", f = "Channels.common.kt", i = {0, 1, 1, 2, 2}, l = {751, 752, 752}, m = "invokeSuspend", n = {"$this$produce", "$this$produce", "e", "$this$produce", "e"}, s = {"L$0", "L$0", "L$1", "L$0", "L$1"})
/* loaded from: classes2.dex */
final class ChannelsKt__Channels_commonKt$filter$1<E> extends SuspendLambda implements Function2<ProducerScope<? super E>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2 $predicate;
    final /* synthetic */ ReceiveChannel $this_filter;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    private ProducerScope p$;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ChannelsKt__Channels_commonKt$filter$1(ReceiveChannel receiveChannel, Function2 function2, Continuation continuation) {
        super(2, continuation);
        this.$this_filter = receiveChannel;
        this.$predicate = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> completion) {
        Intrinsics.checkParameterIsNotNull(completion, "completion");
        ChannelsKt__Channels_commonKt$filter$1 channelsKt__Channels_commonKt$filter$1 = new ChannelsKt__Channels_commonKt$filter$1(this.$this_filter, this.$predicate, completion);
        channelsKt__Channels_commonKt$filter$1.p$ = (ProducerScope) obj;
        return channelsKt__Channels_commonKt$filter$1;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Continuation<? super Unit> continuation) {
        return ((ChannelsKt__Channels_commonKt$filter$1) create(obj, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [750=4] */
    /* JADX DEBUG: Multi-variable search result rejected for r5v10, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0060 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a3  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x009e -> B:14:0x0054). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        ChannelIterator<E> it;
        ProducerScope producerScope;
        ProducerScope producerScope2;
        ChannelIterator<E> channelIterator;
        Object obj2;
        ChannelsKt__Channels_commonKt$filter$1<E> channelsKt__Channels_commonKt$filter$1;
        ChannelsKt__Channels_commonKt$filter$1<E> channelsKt__Channels_commonKt$filter$12;
        Object hasNext;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ProducerScope producerScope3 = this.p$;
            it = this.$this_filter.iterator();
            producerScope = producerScope3;
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
            producerScope2 = (ProducerScope) this.L$0;
            channelIterator = (ChannelIterator) this.L$1;
            obj2 = coroutine_suspended;
            channelsKt__Channels_commonKt$filter$1 = this;
            if (((Boolean) obj).booleanValue()) {
            }
        } else if (i == 2) {
            Object obj3 = this.L$1;
            producerScope2 = (ProducerScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            E e = obj3;
            channelIterator = (ChannelIterator) this.L$2;
            obj2 = coroutine_suspended;
            channelsKt__Channels_commonKt$filter$1 = this;
            if (((Boolean) obj).booleanValue()) {
                channelsKt__Channels_commonKt$filter$1.L$0 = producerScope2;
                channelsKt__Channels_commonKt$filter$1.L$1 = e;
                channelsKt__Channels_commonKt$filter$1.L$2 = channelIterator;
                channelsKt__Channels_commonKt$filter$1.label = 3;
                if (producerScope2.send(e, channelsKt__Channels_commonKt$filter$1) == obj2) {
                    return obj2;
                }
            }
            channelsKt__Channels_commonKt$filter$12 = channelsKt__Channels_commonKt$filter$1;
            coroutine_suspended = obj2;
            it = channelIterator;
            producerScope = producerScope2;
            channelsKt__Channels_commonKt$filter$12.L$0 = producerScope;
            channelsKt__Channels_commonKt$filter$12.L$1 = it;
            channelsKt__Channels_commonKt$filter$12.label = 1;
            hasNext = it.hasNext(channelsKt__Channels_commonKt$filter$12);
            if (hasNext == coroutine_suspended) {
                return coroutine_suspended;
            }
            Object obj4 = coroutine_suspended;
            channelsKt__Channels_commonKt$filter$1 = channelsKt__Channels_commonKt$filter$12;
            obj = hasNext;
            producerScope2 = producerScope;
            channelIterator = it;
            obj2 = obj4;
            if (((Boolean) obj).booleanValue()) {
                return Unit.INSTANCE;
            }
            E next = channelIterator.next();
            Function2 function2 = channelsKt__Channels_commonKt$filter$1.$predicate;
            channelsKt__Channels_commonKt$filter$1.L$0 = producerScope2;
            channelsKt__Channels_commonKt$filter$1.L$1 = next;
            channelsKt__Channels_commonKt$filter$1.L$2 = channelIterator;
            channelsKt__Channels_commonKt$filter$1.label = 2;
            Object invoke = function2.invoke(next, channelsKt__Channels_commonKt$filter$1);
            if (invoke == obj2) {
                return obj2;
            }
            e = next;
            obj = invoke;
            if (((Boolean) obj).booleanValue()) {
            }
            channelsKt__Channels_commonKt$filter$12 = channelsKt__Channels_commonKt$filter$1;
            coroutine_suspended = obj2;
            it = channelIterator;
            producerScope = producerScope2;
            channelsKt__Channels_commonKt$filter$12.L$0 = producerScope;
            channelsKt__Channels_commonKt$filter$12.L$1 = it;
            channelsKt__Channels_commonKt$filter$12.label = 1;
            hasNext = it.hasNext(channelsKt__Channels_commonKt$filter$12);
            if (hasNext == coroutine_suspended) {
            }
        } else if (i != 3) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            it = (ChannelIterator) this.L$2;
            producerScope = (ProducerScope) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        channelsKt__Channels_commonKt$filter$12 = this;
        channelsKt__Channels_commonKt$filter$12.L$0 = producerScope;
        channelsKt__Channels_commonKt$filter$12.L$1 = it;
        channelsKt__Channels_commonKt$filter$12.label = 1;
        hasNext = it.hasNext(channelsKt__Channels_commonKt$filter$12);
        if (hasNext == coroutine_suspended) {
        }
    }
}
