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
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$take$1", f = "Channels.common.kt", i = {0, 0, 1, 1, 1}, l = {994, 995}, m = "invokeSuspend", n = {"$this$produce", "remaining", "$this$produce", "remaining", "e"}, s = {"L$0", "I$0", "L$0", "I$0", "L$1"})
/* loaded from: classes2.dex */
final class ChannelsKt__Channels_commonKt$take$1<E> extends SuspendLambda implements Function2<ProducerScope<? super E>, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $n;
    final /* synthetic */ ReceiveChannel $this_take;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    private ProducerScope p$;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ChannelsKt__Channels_commonKt$take$1(ReceiveChannel receiveChannel, int i, Continuation continuation) {
        super(2, continuation);
        this.$this_take = receiveChannel;
        this.$n = i;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> completion) {
        Intrinsics.checkParameterIsNotNull(completion, "completion");
        ChannelsKt__Channels_commonKt$take$1 channelsKt__Channels_commonKt$take$1 = new ChannelsKt__Channels_commonKt$take$1(this.$this_take, this.$n, completion);
        channelsKt__Channels_commonKt$take$1.p$ = (ProducerScope) obj;
        return channelsKt__Channels_commonKt$take$1;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Continuation<? super Unit> continuation) {
        return ((ChannelsKt__Channels_commonKt$take$1) create(obj, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0060 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0092  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x0085 -> B:29:0x0087). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        ProducerScope producerScope;
        int i;
        ChannelIterator<E> it;
        ChannelsKt__Channels_commonKt$take$1<E> channelsKt__Channels_commonKt$take$1;
        ChannelsKt__Channels_commonKt$take$1<E> channelsKt__Channels_commonKt$take$12;
        ProducerScope producerScope2;
        int i2;
        ChannelIterator<E> channelIterator;
        Object hasNext;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            producerScope = this.p$;
            int i4 = this.$n;
            if (i4 == 0) {
                return Unit.INSTANCE;
            }
            if (!(i4 >= 0)) {
                throw new IllegalArgumentException(("Requested element count " + this.$n + " is less than zero.").toString());
            }
            i = this.$n;
            it = this.$this_take.iterator();
            channelsKt__Channels_commonKt$take$1 = this;
            channelsKt__Channels_commonKt$take$1.L$0 = producerScope;
            channelsKt__Channels_commonKt$take$1.I$0 = i;
            channelsKt__Channels_commonKt$take$1.L$1 = it;
            channelsKt__Channels_commonKt$take$1.label = 1;
            hasNext = it.hasNext(channelsKt__Channels_commonKt$take$1);
            if (hasNext != coroutine_suspended) {
            }
        } else if (i3 == 1) {
            channelIterator = (ChannelIterator) this.L$1;
            i2 = this.I$0;
            producerScope2 = (ProducerScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            channelsKt__Channels_commonKt$take$12 = this;
            if (!((Boolean) obj).booleanValue()) {
            }
        } else if (i3 != 2) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            channelIterator = (ChannelIterator) this.L$2;
            i2 = this.I$0;
            ResultKt.throwOnFailure(obj);
            producerScope = (ProducerScope) this.L$0;
            channelsKt__Channels_commonKt$take$1 = this;
            int i5 = i2 - 1;
            if (i5 != 0) {
                return Unit.INSTANCE;
            }
            it = channelIterator;
            i = i5;
            channelsKt__Channels_commonKt$take$1.L$0 = producerScope;
            channelsKt__Channels_commonKt$take$1.I$0 = i;
            channelsKt__Channels_commonKt$take$1.L$1 = it;
            channelsKt__Channels_commonKt$take$1.label = 1;
            hasNext = it.hasNext(channelsKt__Channels_commonKt$take$1);
            if (hasNext != coroutine_suspended) {
                return coroutine_suspended;
            }
            ChannelsKt__Channels_commonKt$take$1<E> channelsKt__Channels_commonKt$take$13 = channelsKt__Channels_commonKt$take$1;
            producerScope2 = producerScope;
            obj = hasNext;
            channelsKt__Channels_commonKt$take$12 = channelsKt__Channels_commonKt$take$13;
            ChannelIterator<E> channelIterator2 = it;
            i2 = i;
            channelIterator = channelIterator2;
            if (!((Boolean) obj).booleanValue()) {
                E next = channelIterator.next();
                channelsKt__Channels_commonKt$take$12.L$0 = producerScope2;
                channelsKt__Channels_commonKt$take$12.I$0 = i2;
                channelsKt__Channels_commonKt$take$12.L$1 = next;
                channelsKt__Channels_commonKt$take$12.L$2 = channelIterator;
                channelsKt__Channels_commonKt$take$12.label = 2;
                if (producerScope2.send(next, channelsKt__Channels_commonKt$take$12) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                producerScope = producerScope2;
                channelsKt__Channels_commonKt$take$1 = channelsKt__Channels_commonKt$take$12;
                int i52 = i2 - 1;
                if (i52 != 0) {
                }
            } else {
                return Unit.INSTANCE;
            }
        }
    }
}
