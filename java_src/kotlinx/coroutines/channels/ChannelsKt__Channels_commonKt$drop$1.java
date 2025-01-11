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
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$drop$1", f = "Channels.common.kt", i = {0, 0, 1, 1, 2, 2, 2}, l = {700, 705, 706}, m = "invokeSuspend", n = {"$this$produce", "remaining", "$this$produce", "remaining", "$this$produce", "remaining", "e"}, s = {"L$0", "I$0", "L$0", "I$0", "L$0", "I$0", "L$1"})
/* loaded from: classes2.dex */
final class ChannelsKt__Channels_commonKt$drop$1<E> extends SuspendLambda implements Function2<ProducerScope<? super E>, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $n;
    final /* synthetic */ ReceiveChannel $this_drop;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    private ProducerScope p$;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ChannelsKt__Channels_commonKt$drop$1(ReceiveChannel receiveChannel, int i, Continuation continuation) {
        super(2, continuation);
        this.$this_drop = receiveChannel;
        this.$n = i;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> completion) {
        Intrinsics.checkParameterIsNotNull(completion, "completion");
        ChannelsKt__Channels_commonKt$drop$1 channelsKt__Channels_commonKt$drop$1 = new ChannelsKt__Channels_commonKt$drop$1(this.$this_drop, this.$n, completion);
        channelsKt__Channels_commonKt$drop$1.p$ = (ProducerScope) obj;
        return channelsKt__Channels_commonKt$drop$1;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Continuation<? super Unit> continuation) {
        return ((ChannelsKt__Channels_commonKt$drop$1) create(obj, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [696=4] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x007e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00da  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x007f -> B:24:0x0086). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x00d8 -> B:34:0x00a9). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        ProducerScope producerScope;
        int i;
        Object obj2;
        ChannelsKt__Channels_commonKt$drop$1<E> channelsKt__Channels_commonKt$drop$1;
        ProducerScope producerScope2;
        ChannelsKt__Channels_commonKt$drop$1<E> channelsKt__Channels_commonKt$drop$12;
        ChannelIterator<E> it;
        int i2;
        ChannelIterator<E> it2;
        Object hasNext;
        ProducerScope producerScope3;
        Object hasNext2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            producerScope = this.p$;
            if (!(this.$n >= 0)) {
                throw new IllegalArgumentException(("Requested element count " + this.$n + " is less than zero.").toString());
            }
            int i4 = this.$n;
            if (i4 > 0) {
                producerScope2 = producerScope;
                channelsKt__Channels_commonKt$drop$12 = this;
                it = this.$this_drop.iterator();
                i2 = i4;
                ChannelIterator<E> channelIterator = it;
                channelsKt__Channels_commonKt$drop$12.L$0 = producerScope2;
                channelsKt__Channels_commonKt$drop$12.I$0 = i2;
                channelsKt__Channels_commonKt$drop$12.L$1 = channelIterator;
                channelsKt__Channels_commonKt$drop$12.label = 1;
                hasNext = channelIterator.hasNext(channelsKt__Channels_commonKt$drop$12);
                if (hasNext != coroutine_suspended) {
                }
            } else {
                i = i4;
                obj2 = coroutine_suspended;
                channelsKt__Channels_commonKt$drop$1 = this;
                it2 = channelsKt__Channels_commonKt$drop$1.$this_drop.iterator();
                channelsKt__Channels_commonKt$drop$1.L$0 = producerScope;
                channelsKt__Channels_commonKt$drop$1.I$0 = i;
                channelsKt__Channels_commonKt$drop$1.L$1 = it2;
                channelsKt__Channels_commonKt$drop$1.label = 2;
                hasNext2 = it2.hasNext(channelsKt__Channels_commonKt$drop$1);
                if (hasNext2 != obj2) {
                }
            }
        } else if (i3 == 1) {
            int i5 = this.I$0;
            ResultKt.throwOnFailure(obj);
            ProducerScope producerScope4 = (ProducerScope) this.L$0;
            i = i5;
            ChannelIterator<E> channelIterator2 = (ChannelIterator) this.L$1;
            obj2 = coroutine_suspended;
            channelsKt__Channels_commonKt$drop$1 = this;
            if (((Boolean) obj).booleanValue()) {
                channelIterator2.next();
                int i6 = i - 1;
                if (i6 == 0) {
                    i = i6;
                } else {
                    producerScope2 = producerScope4;
                    it = channelIterator2;
                    i2 = i6;
                    channelsKt__Channels_commonKt$drop$12 = channelsKt__Channels_commonKt$drop$1;
                    coroutine_suspended = obj2;
                    ChannelIterator<E> channelIterator3 = it;
                    channelsKt__Channels_commonKt$drop$12.L$0 = producerScope2;
                    channelsKt__Channels_commonKt$drop$12.I$0 = i2;
                    channelsKt__Channels_commonKt$drop$12.L$1 = channelIterator3;
                    channelsKt__Channels_commonKt$drop$12.label = 1;
                    hasNext = channelIterator3.hasNext(channelsKt__Channels_commonKt$drop$12);
                    if (hasNext != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    Object obj3 = coroutine_suspended;
                    channelsKt__Channels_commonKt$drop$1 = channelsKt__Channels_commonKt$drop$12;
                    obj = hasNext;
                    producerScope4 = producerScope2;
                    i = i2;
                    channelIterator2 = channelIterator3;
                    obj2 = obj3;
                    if (((Boolean) obj).booleanValue()) {
                    }
                }
            }
            producerScope = producerScope4;
            it2 = channelsKt__Channels_commonKt$drop$1.$this_drop.iterator();
            channelsKt__Channels_commonKt$drop$1.L$0 = producerScope;
            channelsKt__Channels_commonKt$drop$1.I$0 = i;
            channelsKt__Channels_commonKt$drop$1.L$1 = it2;
            channelsKt__Channels_commonKt$drop$1.label = 2;
            hasNext2 = it2.hasNext(channelsKt__Channels_commonKt$drop$1);
            if (hasNext2 != obj2) {
            }
        } else if (i3 == 2) {
            int i7 = this.I$0;
            producerScope3 = (ProducerScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            i = i7;
            it2 = (ChannelIterator) this.L$1;
            obj2 = coroutine_suspended;
            channelsKt__Channels_commonKt$drop$1 = this;
            if (((Boolean) obj).booleanValue()) {
            }
        } else if (i3 != 3) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            int i8 = this.I$0;
            ResultKt.throwOnFailure(obj);
            i = i8;
            producerScope = (ProducerScope) this.L$0;
            it2 = (ChannelIterator) this.L$2;
            obj2 = coroutine_suspended;
            channelsKt__Channels_commonKt$drop$1 = this;
            channelsKt__Channels_commonKt$drop$1.L$0 = producerScope;
            channelsKt__Channels_commonKt$drop$1.I$0 = i;
            channelsKt__Channels_commonKt$drop$1.L$1 = it2;
            channelsKt__Channels_commonKt$drop$1.label = 2;
            hasNext2 = it2.hasNext(channelsKt__Channels_commonKt$drop$1);
            if (hasNext2 != obj2) {
                return obj2;
            }
            producerScope3 = producerScope;
            obj = hasNext2;
            if (((Boolean) obj).booleanValue()) {
                return Unit.INSTANCE;
            }
            E next = it2.next();
            channelsKt__Channels_commonKt$drop$1.L$0 = producerScope3;
            channelsKt__Channels_commonKt$drop$1.I$0 = i;
            channelsKt__Channels_commonKt$drop$1.L$1 = next;
            channelsKt__Channels_commonKt$drop$1.L$2 = it2;
            channelsKt__Channels_commonKt$drop$1.label = 3;
            if (producerScope3.send(next, channelsKt__Channels_commonKt$drop$1) == obj2) {
                return obj2;
            }
            producerScope = producerScope3;
            channelsKt__Channels_commonKt$drop$1.L$0 = producerScope;
            channelsKt__Channels_commonKt$drop$1.I$0 = i;
            channelsKt__Channels_commonKt$drop$1.L$1 = it2;
            channelsKt__Channels_commonKt$drop$1.label = 2;
            hasNext2 = it2.hasNext(channelsKt__Channels_commonKt$drop$1);
            if (hasNext2 != obj2) {
            }
        }
    }
}
