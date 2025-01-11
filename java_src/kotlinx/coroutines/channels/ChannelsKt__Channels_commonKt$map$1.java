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

/* JADX INFO: Add missing generic type declarations: [R] */
/* compiled from: Channels.common.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u0004H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", ExifInterface.LONGITUDE_EAST, "R", "Lkotlinx/coroutines/channels/ProducerScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 15})
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$map$1", f = "Channels.common.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2}, l = {2201, 1400, 1400}, m = "invokeSuspend", n = {"$this$produce", "$this$consumeEach$iv", "$this$consume$iv$iv", "cause$iv$iv", "$this$consume$iv", "$this$produce", "$this$consumeEach$iv", "$this$consume$iv$iv", "cause$iv$iv", "$this$consume$iv", "e$iv", "it", "$this$produce", "$this$consumeEach$iv", "$this$consume$iv$iv", "cause$iv$iv", "$this$consume$iv", "e$iv", "it"}, s = {"L$0", "L$1", "L$3", "L$4", "L$5", "L$0", "L$1", "L$3", "L$4", "L$5", "L$7", "L$8", "L$0", "L$1", "L$3", "L$4", "L$5", "L$7", "L$8"})
/* loaded from: classes2.dex */
final class ChannelsKt__Channels_commonKt$map$1<R> extends SuspendLambda implements Function2<ProducerScope<? super R>, Continuation<? super Unit>, Object> {
    final /* synthetic */ ReceiveChannel $this_map;
    final /* synthetic */ Function2 $transform;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    Object L$9;
    int label;
    private ProducerScope p$;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ChannelsKt__Channels_commonKt$map$1(ReceiveChannel receiveChannel, Function2 function2, Continuation continuation) {
        super(2, continuation);
        this.$this_map = receiveChannel;
        this.$transform = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> completion) {
        Intrinsics.checkParameterIsNotNull(completion, "completion");
        ChannelsKt__Channels_commonKt$map$1 channelsKt__Channels_commonKt$map$1 = new ChannelsKt__Channels_commonKt$map$1(this.$this_map, this.$transform, completion);
        channelsKt__Channels_commonKt$map$1.p$ = (ProducerScope) obj;
        return channelsKt__Channels_commonKt$map$1;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Continuation<? super Unit> continuation) {
        return ((ChannelsKt__Channels_commonKt$map$1) create(obj, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1398=4] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00d9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00e2 A[Catch: all -> 0x0138, TRY_LEAVE, TryCatch #0 {all -> 0x0138, blocks: (B:23:0x00c3, B:26:0x00da, B:28:0x00e2, B:37:0x0130), top: B:48:0x00c3 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0127 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0130 A[Catch: all -> 0x0138, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0138, blocks: (B:23:0x00c3, B:26:0x00da, B:28:0x00e2, B:37:0x0130), top: B:48:0x00c3 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x0128 -> B:36:0x012e). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Throwable th;
        ReceiveChannel receiveChannel;
        ReceiveChannel receiveChannel2;
        ChannelsKt__Channels_commonKt$map$1<R> channelsKt__Channels_commonKt$map$1;
        ChannelsKt__Channels_commonKt$map$1<R> channelsKt__Channels_commonKt$map$12;
        ReceiveChannel receiveChannel3;
        ReceiveChannel receiveChannel4;
        ProducerScope producerScope;
        ChannelIterator it;
        Throwable th2;
        ReceiveChannel receiveChannel5;
        ProducerScope producerScope2;
        Object obj2;
        Object obj3;
        ReceiveChannel receiveChannel6;
        Object obj4;
        ChannelIterator channelIterator;
        ReceiveChannel receiveChannel7;
        ChannelsKt__Channels_commonKt$map$1<R> channelsKt__Channels_commonKt$map$13;
        ProducerScope producerScope3;
        Object obj5;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        int i2 = 2;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ProducerScope producerScope4 = this.p$;
                receiveChannel2 = this.$this_map;
                Throwable th3 = null;
                channelsKt__Channels_commonKt$map$1 = this;
                channelsKt__Channels_commonKt$map$12 = channelsKt__Channels_commonKt$map$1;
                receiveChannel3 = receiveChannel2;
                receiveChannel4 = receiveChannel3;
                producerScope = producerScope4;
                it = receiveChannel2.iterator();
                th2 = th3;
                channelsKt__Channels_commonKt$map$12.L$0 = producerScope;
                channelsKt__Channels_commonKt$map$12.L$1 = receiveChannel4;
                channelsKt__Channels_commonKt$map$12.L$2 = channelsKt__Channels_commonKt$map$1;
                channelsKt__Channels_commonKt$map$12.L$3 = receiveChannel3;
                channelsKt__Channels_commonKt$map$12.L$4 = th2;
                channelsKt__Channels_commonKt$map$12.L$5 = receiveChannel2;
                channelsKt__Channels_commonKt$map$12.L$6 = it;
                channelsKt__Channels_commonKt$map$12.label = 1;
                obj5 = it.hasNext(channelsKt__Channels_commonKt$map$1);
                if (obj5 == coroutine_suspended) {
                }
                if (!((Boolean) obj5).booleanValue()) {
                }
            } else if (i == 1) {
                it = (ChannelIterator) this.L$6;
                ReceiveChannel receiveChannel8 = (ReceiveChannel) this.L$5;
                th2 = (Throwable) this.L$4;
                ReceiveChannel receiveChannel9 = (ReceiveChannel) this.L$3;
                ChannelsKt__Channels_commonKt$map$1<R> channelsKt__Channels_commonKt$map$14 = (ChannelsKt__Channels_commonKt$map$1) this.L$2;
                ReceiveChannel receiveChannel10 = (ReceiveChannel) this.L$1;
                ProducerScope producerScope5 = (ProducerScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                obj5 = obj;
                channelsKt__Channels_commonKt$map$12 = this;
                receiveChannel2 = receiveChannel8;
                producerScope = producerScope5;
                receiveChannel4 = receiveChannel10;
                channelsKt__Channels_commonKt$map$1 = channelsKt__Channels_commonKt$map$14;
                receiveChannel3 = receiveChannel9;
                if (!((Boolean) obj5).booleanValue()) {
                }
            } else if (i == 2) {
                producerScope3 = (ProducerScope) this.L$9;
                Object obj6 = this.L$8;
                Object obj7 = this.L$7;
                channelIterator = (ChannelIterator) this.L$6;
                ReceiveChannel receiveChannel11 = (ReceiveChannel) this.L$5;
                Throwable th4 = (Throwable) this.L$4;
                receiveChannel5 = (ReceiveChannel) this.L$3;
                ChannelsKt__Channels_commonKt$map$1<R> channelsKt__Channels_commonKt$map$15 = (ChannelsKt__Channels_commonKt$map$1) this.L$2;
                ReceiveChannel receiveChannel12 = (ReceiveChannel) this.L$1;
                ProducerScope producerScope6 = (ProducerScope) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    channelsKt__Channels_commonKt$map$13 = this;
                    producerScope2 = producerScope6;
                    obj2 = obj;
                    obj3 = obj6;
                    receiveChannel7 = receiveChannel11;
                    obj4 = obj7;
                    th2 = th4;
                    channelsKt__Channels_commonKt$map$1 = channelsKt__Channels_commonKt$map$15;
                    receiveChannel6 = receiveChannel12;
                    channelsKt__Channels_commonKt$map$13.L$0 = producerScope2;
                    channelsKt__Channels_commonKt$map$13.L$1 = receiveChannel6;
                    channelsKt__Channels_commonKt$map$13.L$2 = channelsKt__Channels_commonKt$map$1;
                    channelsKt__Channels_commonKt$map$13.L$3 = receiveChannel5;
                    channelsKt__Channels_commonKt$map$13.L$4 = th2;
                    channelsKt__Channels_commonKt$map$13.L$5 = receiveChannel7;
                    channelsKt__Channels_commonKt$map$13.L$6 = channelIterator;
                    channelsKt__Channels_commonKt$map$13.L$7 = obj4;
                    channelsKt__Channels_commonKt$map$13.L$8 = obj3;
                    channelsKt__Channels_commonKt$map$13.label = 3;
                    if (producerScope3.send(obj2, channelsKt__Channels_commonKt$map$13) != coroutine_suspended) {
                    }
                } catch (Throwable th5) {
                    th = th5;
                    receiveChannel = receiveChannel5;
                    throw th;
                }
            } else if (i != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                it = (ChannelIterator) this.L$6;
                ReceiveChannel receiveChannel13 = (ReceiveChannel) this.L$5;
                th2 = (Throwable) this.L$4;
                ReceiveChannel receiveChannel14 = (ReceiveChannel) this.L$3;
                ChannelsKt__Channels_commonKt$map$1<R> channelsKt__Channels_commonKt$map$16 = (ChannelsKt__Channels_commonKt$map$1) this.L$2;
                ReceiveChannel receiveChannel15 = (ReceiveChannel) this.L$1;
                ProducerScope producerScope7 = (ProducerScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                channelsKt__Channels_commonKt$map$12 = this;
                receiveChannel2 = receiveChannel13;
                producerScope = producerScope7;
                receiveChannel4 = receiveChannel15;
                channelsKt__Channels_commonKt$map$1 = channelsKt__Channels_commonKt$map$16;
                receiveChannel3 = receiveChannel14;
                i2 = 2;
                try {
                    channelsKt__Channels_commonKt$map$12.L$0 = producerScope;
                    channelsKt__Channels_commonKt$map$12.L$1 = receiveChannel4;
                    channelsKt__Channels_commonKt$map$12.L$2 = channelsKt__Channels_commonKt$map$1;
                    channelsKt__Channels_commonKt$map$12.L$3 = receiveChannel3;
                    channelsKt__Channels_commonKt$map$12.L$4 = th2;
                    channelsKt__Channels_commonKt$map$12.L$5 = receiveChannel2;
                    channelsKt__Channels_commonKt$map$12.L$6 = it;
                    channelsKt__Channels_commonKt$map$12.label = 1;
                    obj5 = it.hasNext(channelsKt__Channels_commonKt$map$1);
                    if (obj5 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    if (!((Boolean) obj5).booleanValue()) {
                        obj3 = it.next();
                        Function2 function2 = channelsKt__Channels_commonKt$map$12.$transform;
                        channelsKt__Channels_commonKt$map$12.L$0 = producerScope;
                        channelsKt__Channels_commonKt$map$12.L$1 = receiveChannel4;
                        channelsKt__Channels_commonKt$map$12.L$2 = channelsKt__Channels_commonKt$map$1;
                        channelsKt__Channels_commonKt$map$12.L$3 = receiveChannel3;
                        channelsKt__Channels_commonKt$map$12.L$4 = th2;
                        channelsKt__Channels_commonKt$map$12.L$5 = receiveChannel2;
                        channelsKt__Channels_commonKt$map$12.L$6 = it;
                        channelsKt__Channels_commonKt$map$12.L$7 = obj3;
                        channelsKt__Channels_commonKt$map$12.L$8 = obj3;
                        channelsKt__Channels_commonKt$map$12.L$9 = producerScope;
                        channelsKt__Channels_commonKt$map$12.label = i2;
                        obj2 = function2.invoke(obj3, channelsKt__Channels_commonKt$map$12);
                        if (obj2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        producerScope2 = producerScope;
                        channelsKt__Channels_commonKt$map$13 = channelsKt__Channels_commonKt$map$12;
                        receiveChannel7 = receiveChannel2;
                        receiveChannel6 = receiveChannel4;
                        channelIterator = it;
                        producerScope3 = producerScope2;
                        receiveChannel5 = receiveChannel3;
                        obj4 = obj3;
                        channelsKt__Channels_commonKt$map$13.L$0 = producerScope2;
                        channelsKt__Channels_commonKt$map$13.L$1 = receiveChannel6;
                        channelsKt__Channels_commonKt$map$13.L$2 = channelsKt__Channels_commonKt$map$1;
                        channelsKt__Channels_commonKt$map$13.L$3 = receiveChannel5;
                        channelsKt__Channels_commonKt$map$13.L$4 = th2;
                        channelsKt__Channels_commonKt$map$13.L$5 = receiveChannel7;
                        channelsKt__Channels_commonKt$map$13.L$6 = channelIterator;
                        channelsKt__Channels_commonKt$map$13.L$7 = obj4;
                        channelsKt__Channels_commonKt$map$13.L$8 = obj3;
                        channelsKt__Channels_commonKt$map$13.label = 3;
                        if (producerScope3.send(obj2, channelsKt__Channels_commonKt$map$13) != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        it = channelIterator;
                        receiveChannel3 = receiveChannel5;
                        receiveChannel4 = receiveChannel6;
                        channelsKt__Channels_commonKt$map$12 = channelsKt__Channels_commonKt$map$13;
                        receiveChannel2 = receiveChannel7;
                        producerScope = producerScope2;
                        i2 = 2;
                        channelsKt__Channels_commonKt$map$12.L$0 = producerScope;
                        channelsKt__Channels_commonKt$map$12.L$1 = receiveChannel4;
                        channelsKt__Channels_commonKt$map$12.L$2 = channelsKt__Channels_commonKt$map$1;
                        channelsKt__Channels_commonKt$map$12.L$3 = receiveChannel3;
                        channelsKt__Channels_commonKt$map$12.L$4 = th2;
                        channelsKt__Channels_commonKt$map$12.L$5 = receiveChannel2;
                        channelsKt__Channels_commonKt$map$12.L$6 = it;
                        channelsKt__Channels_commonKt$map$12.label = 1;
                        obj5 = it.hasNext(channelsKt__Channels_commonKt$map$1);
                        if (obj5 == coroutine_suspended) {
                        }
                        if (!((Boolean) obj5).booleanValue()) {
                            Unit unit = Unit.INSTANCE;
                            ChannelsKt.cancelConsumed(receiveChannel3, th2);
                            return Unit.INSTANCE;
                        }
                    }
                } catch (Throwable th6) {
                    th = th6;
                    receiveChannel = receiveChannel3;
                    try {
                        throw th;
                    } catch (Throwable th7) {
                        ChannelsKt.cancelConsumed(receiveChannel, th);
                        throw th7;
                    }
                }
            }
        } catch (Throwable th8) {
            th = th8;
        }
    }
}
