package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Add missing generic type declarations: [E] */
/* compiled from: Channels.common.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/ProducerScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 15})
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$filterIndexed$1", f = "Channels.common.kt", i = {0, 0, 1, 1, 1, 2, 2, 2}, l = {774, 775, 775}, m = "invokeSuspend", n = {"$this$produce", "index", "$this$produce", "index", "e", "$this$produce", "index", "e"}, s = {"L$0", "I$0", "L$0", "I$0", "L$1", "L$0", "I$0", "L$1"})
/* loaded from: classes2.dex */
final class ChannelsKt__Channels_commonKt$filterIndexed$1<E> extends SuspendLambda implements Function2<ProducerScope<? super E>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function3 $predicate;
    final /* synthetic */ ReceiveChannel $this_filterIndexed;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    private ProducerScope p$;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ChannelsKt__Channels_commonKt$filterIndexed$1(ReceiveChannel receiveChannel, Function3 function3, Continuation continuation) {
        super(2, continuation);
        this.$this_filterIndexed = receiveChannel;
        this.$predicate = function3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> completion) {
        Intrinsics.checkParameterIsNotNull(completion, "completion");
        ChannelsKt__Channels_commonKt$filterIndexed$1 channelsKt__Channels_commonKt$filterIndexed$1 = new ChannelsKt__Channels_commonKt$filterIndexed$1(this.$this_filterIndexed, this.$predicate, completion);
        channelsKt__Channels_commonKt$filterIndexed$1.p$ = (ProducerScope) obj;
        return channelsKt__Channels_commonKt$filterIndexed$1;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Continuation<? super Unit> continuation) {
        return ((ChannelsKt__Channels_commonKt$filterIndexed$1) create(obj, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [772=4] */
    /* JADX DEBUG: Multi-variable search result rejected for r5v10, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00bf  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x00b9 -> B:13:0x0062). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        ProducerScope producerScope;
        ChannelsKt__Channels_commonKt$filterIndexed$1<E> channelsKt__Channels_commonKt$filterIndexed$1;
        int i;
        ChannelIterator<E> it;
        ProducerScope producerScope2;
        E e;
        int i2;
        ChannelIterator<E> channelIterator;
        Object obj2;
        ChannelsKt__Channels_commonKt$filterIndexed$1<E> channelsKt__Channels_commonKt$filterIndexed$12;
        ProducerScope producerScope3;
        int i3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = this.label;
        if (i4 == 0) {
            ResultKt.throwOnFailure(obj);
            producerScope = this.p$;
            channelsKt__Channels_commonKt$filterIndexed$1 = this;
            i = 0;
            it = this.$this_filterIndexed.iterator();
        } else if (i4 == 1) {
            int i5 = this.I$0;
            ResultKt.throwOnFailure(obj);
            producerScope3 = (ProducerScope) this.L$0;
            i3 = i5;
            channelIterator = (ChannelIterator) this.L$1;
            obj2 = coroutine_suspended;
            channelsKt__Channels_commonKt$filterIndexed$12 = this;
            if (((Boolean) obj).booleanValue()) {
                return Unit.INSTANCE;
            }
            E next = channelIterator.next();
            Function3 function3 = channelsKt__Channels_commonKt$filterIndexed$12.$predicate;
            Integer boxInt = Boxing.boxInt(i3);
            i2 = i3 + 1;
            channelsKt__Channels_commonKt$filterIndexed$12.L$0 = producerScope3;
            channelsKt__Channels_commonKt$filterIndexed$12.I$0 = i2;
            channelsKt__Channels_commonKt$filterIndexed$12.L$1 = next;
            channelsKt__Channels_commonKt$filterIndexed$12.L$2 = channelIterator;
            channelsKt__Channels_commonKt$filterIndexed$12.label = 2;
            Object invoke = function3.invoke(boxInt, next, channelsKt__Channels_commonKt$filterIndexed$12);
            if (invoke == obj2) {
                return obj2;
            }
            ProducerScope producerScope4 = producerScope3;
            e = next;
            obj = invoke;
            producerScope2 = producerScope4;
            if (((Boolean) obj).booleanValue()) {
            }
            channelsKt__Channels_commonKt$filterIndexed$1 = channelsKt__Channels_commonKt$filterIndexed$12;
            coroutine_suspended = obj2;
            it = channelIterator;
            i = i2;
            producerScope = producerScope2;
        } else if (i4 == 2) {
            Object obj3 = this.L$1;
            i2 = this.I$0;
            ResultKt.throwOnFailure(obj);
            producerScope2 = (ProducerScope) this.L$0;
            e = obj3;
            channelIterator = (ChannelIterator) this.L$2;
            obj2 = coroutine_suspended;
            channelsKt__Channels_commonKt$filterIndexed$12 = this;
            if (((Boolean) obj).booleanValue()) {
                channelsKt__Channels_commonKt$filterIndexed$12.L$0 = producerScope2;
                channelsKt__Channels_commonKt$filterIndexed$12.I$0 = i2;
                channelsKt__Channels_commonKt$filterIndexed$12.L$1 = e;
                channelsKt__Channels_commonKt$filterIndexed$12.L$2 = channelIterator;
                channelsKt__Channels_commonKt$filterIndexed$12.label = 3;
                if (producerScope2.send(e, channelsKt__Channels_commonKt$filterIndexed$12) == obj2) {
                    return obj2;
                }
            }
            channelsKt__Channels_commonKt$filterIndexed$1 = channelsKt__Channels_commonKt$filterIndexed$12;
            coroutine_suspended = obj2;
            it = channelIterator;
            i = i2;
            producerScope = producerScope2;
        } else if (i4 != 3) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            it = (ChannelIterator) this.L$2;
            i = this.I$0;
            producerScope = (ProducerScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            channelsKt__Channels_commonKt$filterIndexed$1 = this;
        }
        channelsKt__Channels_commonKt$filterIndexed$1.L$0 = producerScope;
        channelsKt__Channels_commonKt$filterIndexed$1.I$0 = i;
        channelsKt__Channels_commonKt$filterIndexed$1.L$1 = it;
        channelsKt__Channels_commonKt$filterIndexed$1.label = 1;
        Object hasNext = it.hasNext(channelsKt__Channels_commonKt$filterIndexed$1);
        if (hasNext == coroutine_suspended) {
            return coroutine_suspended;
        }
        Object obj4 = coroutine_suspended;
        channelsKt__Channels_commonKt$filterIndexed$12 = channelsKt__Channels_commonKt$filterIndexed$1;
        obj = hasNext;
        producerScope3 = producerScope;
        i3 = i;
        channelIterator = it;
        obj2 = obj4;
        if (((Boolean) obj).booleanValue()) {
        }
    }
}
