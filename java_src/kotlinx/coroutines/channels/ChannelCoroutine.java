package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import com.sun.mail.imap.IMAPStore;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.JobCancellationException;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.selects.SelectClause1;
import kotlinx.coroutines.selects.SelectClause2;
/* compiled from: ChannelCoroutine.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0004B#\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\"\u001a\u00020\u0003H\u0016J\u0012\u0010\"\u001a\u00020\t2\b\u0010#\u001a\u0004\u0018\u00010$H\u0007J\u0016\u0010\"\u001a\u00020\u00032\u000e\u0010#\u001a\n\u0018\u00010%j\u0004\u0018\u0001`&J\u0012\u0010'\u001a\u00020\t2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u0013\u0010(\u001a\u00020\t2\b\u0010#\u001a\u0004\u0018\u00010$H\u0096\u0001J.\u0010)\u001a\u00020\u00032#\u0010*\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010$¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020\u00030+H\u0097\u0001J\u000f\u0010.\u001a\b\u0012\u0004\u0012\u00028\u00000/H\u0096\u0003J\u0016\u00100\u001a\u00020\t2\u0006\u00101\u001a\u00028\u0000H\u0096\u0001¢\u0006\u0002\u00102J\u0010\u00103\u001a\u0004\u0018\u00018\u0000H\u0096\u0001¢\u0006\u0002\u00104J\u0011\u00105\u001a\u00028\u0000H\u0096Aø\u0001\u0000¢\u0006\u0002\u00106J\u001a\u00107\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019H\u0097Aø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u00106J\u0013\u00108\u001a\u0004\u0018\u00018\u0000H\u0097Aø\u0001\u0000¢\u0006\u0002\u00106J\u0019\u00109\u001a\u00020\u00032\u0006\u00101\u001a\u00028\u0000H\u0096Aø\u0001\u0000¢\u0006\u0002\u0010:J\u0019\u0010;\u001a\u00020\u00032\u0006\u00101\u001a\u00028\u0000H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010:R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\fR\u0014\u0010\u000f\u001a\u00020\t8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\t8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\t8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\t8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0010R\u0018\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R#\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00190\u00158\u0016X\u0097\u0005ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0017R\u001c\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u00158\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0017R$\u0010\u001d\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001f0\u001eX\u0096\u0005¢\u0006\u0006\u001a\u0004\b \u0010!\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006<"}, d2 = {"Lkotlinx/coroutines/channels/ChannelCoroutine;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/AbstractCoroutine;", "", "Lkotlinx/coroutines/channels/Channel;", "parentContext", "Lkotlin/coroutines/CoroutineContext;", "_channel", "active", "", "(Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/channels/Channel;Z)V", "get_channel", "()Lkotlinx/coroutines/channels/Channel;", "channel", "getChannel", "isClosedForReceive", "()Z", "isClosedForSend", "isEmpty", "isFull", "onReceive", "Lkotlinx/coroutines/selects/SelectClause1;", "getOnReceive", "()Lkotlinx/coroutines/selects/SelectClause1;", "onReceiveOrClosed", "Lkotlinx/coroutines/channels/ValueOrClosed;", "getOnReceiveOrClosed", "onReceiveOrNull", "getOnReceiveOrNull", "onSend", "Lkotlinx/coroutines/selects/SelectClause2;", "Lkotlinx/coroutines/channels/SendChannel;", "getOnSend", "()Lkotlinx/coroutines/selects/SelectClause2;", "cancel", "cause", "", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "cancelInternal", "close", "invokeOnClose", "handler", "Lkotlin/Function1;", "Lkotlin/ParameterName;", IMAPStore.ID_NAME, "iterator", "Lkotlinx/coroutines/channels/ChannelIterator;", "offer", "element", "(Ljava/lang/Object;)Z", "poll", "()Ljava/lang/Object;", "receive", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "receiveOrClosed", "receiveOrNull", "send", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendFair", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public class ChannelCoroutine<E> extends AbstractCoroutine<Unit> implements Channel<E> {
    private final Channel<E> _channel;

    static /* synthetic */ Object receive$suspendImpl(ChannelCoroutine channelCoroutine, Continuation continuation) {
        return channelCoroutine._channel.receive(continuation);
    }

    static /* synthetic */ Object receiveOrClosed$suspendImpl(ChannelCoroutine channelCoroutine, Continuation continuation) {
        return channelCoroutine._channel.receiveOrClosed(continuation);
    }

    static /* synthetic */ Object receiveOrNull$suspendImpl(ChannelCoroutine channelCoroutine, Continuation continuation) {
        return channelCoroutine._channel.receiveOrNull(continuation);
    }

    static /* synthetic */ Object send$suspendImpl(ChannelCoroutine channelCoroutine, Object obj, Continuation continuation) {
        return channelCoroutine._channel.send(obj, continuation);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean close(Throwable th) {
        return this._channel.close(th);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public SelectClause1<E> getOnReceive() {
        return this._channel.getOnReceive();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public SelectClause1<ValueOrClosed<E>> getOnReceiveOrClosed() {
        return this._channel.getOnReceiveOrClosed();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public SelectClause1<E> getOnReceiveOrNull() {
        return this._channel.getOnReceiveOrNull();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public SelectClause2<E, SendChannel<E>> getOnSend() {
        return this._channel.getOnSend();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public void invokeOnClose(Function1<? super Throwable, Unit> handler) {
        Intrinsics.checkParameterIsNotNull(handler, "handler");
        this._channel.invokeOnClose(handler);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public boolean isClosedForReceive() {
        return this._channel.isClosedForReceive();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean isClosedForSend() {
        return this._channel.isClosedForSend();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public boolean isEmpty() {
        return this._channel.isEmpty();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean isFull() {
        return this._channel.isFull();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public ChannelIterator<E> iterator() {
        return this._channel.iterator();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean offer(E e) {
        return this._channel.offer(e);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public E poll() {
        return this._channel.poll();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public Object receive(Continuation<? super E> continuation) {
        return receive$suspendImpl(this, continuation);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public Object receiveOrClosed(Continuation<? super ValueOrClosed<? extends E>> continuation) {
        return receiveOrClosed$suspendImpl(this, continuation);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @Deprecated(level = DeprecationLevel.WARNING, message = "Deprecated in favor of receiveOrClosed and receiveOrNull extension", replaceWith = @ReplaceWith(expression = "receiveOrNull", imports = {"kotlinx.coroutines.channels.receiveOrNull"}))
    public Object receiveOrNull(Continuation<? super E> continuation) {
        return receiveOrNull$suspendImpl(this, continuation);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public Object send(E e, Continuation<? super Unit> continuation) {
        return send$suspendImpl(this, e, continuation);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Channel<E> get_channel() {
        return this._channel;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelCoroutine(CoroutineContext parentContext, Channel<E> _channel, boolean z) {
        super(parentContext, z);
        Intrinsics.checkParameterIsNotNull(parentContext, "parentContext");
        Intrinsics.checkParameterIsNotNull(_channel, "_channel");
        this._channel = _channel;
    }

    public final Channel<E> getChannel() {
        return this;
    }

    @Override // kotlinx.coroutines.JobSupport, kotlinx.coroutines.Job
    public /* synthetic */ void cancel() {
        cancel(null);
    }

    @Override // kotlinx.coroutines.JobSupport, kotlinx.coroutines.Job
    public final void cancel(CancellationException cancellationException) {
        cancel(cancellationException);
    }

    @Override // kotlinx.coroutines.JobSupport, kotlinx.coroutines.Job
    /* renamed from: cancelInternal */
    public boolean cancel(Throwable th) {
        JobCancellationException jobCancellationException;
        if (th == null || (jobCancellationException = JobSupport.toCancellationException$default(this, th, null, 1, null)) == null) {
            jobCancellationException = new JobCancellationException(DebugStringsKt.getClassSimpleName(this) + " was cancelled", null, this);
        }
        this._channel.cancel(jobCancellationException);
        cancelCoroutine(jobCancellationException);
        return true;
    }

    public final Object sendFair(E e, Continuation<? super Unit> continuation) {
        Channel<E> channel = this._channel;
        if (channel != null) {
            return ((AbstractSendChannel) channel).sendFair$kotlinx_coroutines_core(e, continuation);
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.channels.AbstractSendChannel<E>");
    }
}
